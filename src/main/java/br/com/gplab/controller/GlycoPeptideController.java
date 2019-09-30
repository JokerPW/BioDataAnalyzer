package br.com.gplab.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gplab.analysis.DataHolder;
import br.com.gplab.analysis.GlycanCounter;
import br.com.gplab.analysis.ModificationsCounter;
import br.com.gplab.analysis.SubListing;
import br.com.gplab.analysis.UniqueData;
import br.com.gplab.analysis.mappings.GPAnalysisConsts;
import br.com.gplab.model.GlycoPeptide;
import br.com.gplab.model.MaxQuantResult;
import br.com.gplab.model.subItens.Glycan;
import br.com.gplab.utils.FailSafe;


@RestController
@RequestMapping("/glycopeptide")
public class GlycoPeptideController {
    
    @Autowired
    private DataHolder dataHolder;
    
    
    private UniqueData dataVerifier;
    private GlycanCounter glycanCounter;
    private ModificationsCounter modificationsCounter;
    private SubListing subListing;


    @PostMapping(value="/significances", consumes = "multipart/form-data")
    public ResponseEntity<?> ReceiveSignificances(@RequestParam("pep2D") String pep2D, @RequestParam("logProb") String logProb,
	    @RequestParam("score") String score) {
	
	System.out.println("===== ReceiveScores =====");
	System.out.println("Pep2D: " + pep2D + " - LogProbability: " + logProb + " - Score: " + score);
	double dPep2D = (pep2D.length() > 0) ? FailSafe.forceDouble(pep2D) : 0.0; 
	double dLogProb = (logProb.length() > 0) ? FailSafe.forceDouble(logProb) : 0.0; 
	double dScore = (score.length() > 0) ? FailSafe.forceDouble(score) : 0.0; 
	
	dataHolder.getGPAnalysisConsts().ConfigureScoring(dPep2D, dLogProb, dScore);
	return new ResponseEntity ("Data Acquired", HttpStatus.OK);
	
    }//--- End: ReceiveIndexes
    

    @PostMapping(value="/glycans", consumes = "multipart/form-data")
    //public ResponseEntity<?> ReceivePost(@RequestParam("file") MultipartFile payload) {
    public ResponseEntity<?> ReceivePost() {

	System.out.println("===== ReceivePost =====");
	
	if (dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No Organism Data", HttpStatus.OK);
	
	
	String content = "";
	
	try {
	    //byte[] bytes = payload.getBytes();
	    //BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
	    //BufferedReader br = new BufferedReader(new FileReader("F:/Trampos/ParasitologyLab/analysis/gps.csv"));
	    BufferedReader br = new BufferedReader(new FileReader("C:/tomcat/gps.csv"));
	    while((content = br.readLine()) != null) {
		dataHolder.getRawData().add(content);
	    }
	    
	    br.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	JSONObject response = new JSONObject();
	response.put("read", dataHolder.getRawData().get(0));
	
	System.out.println("Response: " + response);
	return ResponseEntity.ok(response.toString());
	
    }//--- End: ReceivePost
    

    @PostMapping(value="/glycans/indexes", consumes = "multipart/form-data")
    public ResponseEntity<?> ReceiveIndexes(@ModelAttribute GPAnalysisConsts payload) {
	
	System.out.println("===== ReceiveIndexes =====");
	dataHolder.getGPAnalysisConsts().ConfigureApplication(payload);
	return ProcessData();
	
    }//--- End: ReceiveIndexes
    

    @PostMapping(value="/glycans/defaults")
    public ResponseEntity<?> UseDefaults() {
	
	System.out.println("===== UseDefaults =====");
	dataHolder.getGPAnalysisConsts().SetDefaults();
	return ProcessData();
	
    }//--- End: UseDefaults
    

    @PostMapping(value="/glycans/liviadefaults")
    public ResponseEntity<?> UseLiviaDefaults() {
	
	System.out.println("===== liviadefaults =====");
	dataHolder.getGPAnalysisConsts().SetLiviaDefaults();
	return ProcessData();
	
    }//--- End: UseDefaults
    
    
    public ResponseEntity<?> ProcessData() {

	if (dataVerifier == null)
	    dataVerifier = new UniqueData();
	
	if (glycanCounter == null)
	    glycanCounter = new GlycanCounter();
	
	if (modificationsCounter == null)
	    modificationsCounter = new ModificationsCounter();
	
	for (String rawGP : dataHolder.getRawData()) {
	    //System.out.println("Cycle GPs");
	    GlycoPeptide gp = new GlycoPeptide();
	    if (gp.fillData(rawGP, dataHolder)) {
		if (dataVerifier.isUniqueGP(gp, dataHolder.getGPs())) {
		    //System.out.println("GP being added");
		    gp.run();
		    dataHolder.getGPs().add(gp);
		    dataHolder.getDictGPs().put(gp.getpID(), gp);
		}
	    }
	}
	
	JSONObject response = new JSONObject();
	
	System.out.println("========Glycans Count:===========");
	System.out.println("========Hex Count:===========");
	int Hex = glycanCounter.countGlycan(Glycan.glycanType.Hex, dataHolder.getGPs());
	System.out.println("Hex: " + Hex);
	response.put("Hex", Hex);
	System.out.println("========HexNAc Count:===========");
	int HexNAc = glycanCounter.countGlycan(Glycan.glycanType.HexNAc, dataHolder.getGPs());
	System.out.println("HexNAc: " + HexNAc);
	response.put("HexNAc", HexNAc);
	System.out.println("========Fuc Count:===========");
	int Fuc = glycanCounter.countGlycan(Glycan.glycanType.Fuc, dataHolder.getGPs());
	System.out.println("Fuc: " + Fuc);
	response.put("Fuc", Fuc);
	System.out.println("========NeuAc Count:===========");
	int NeuAc = glycanCounter.countGlycan(Glycan.glycanType.NeuAc, dataHolder.getGPs());
	System.out.println("NeuAc: " + NeuAc);
	response.put("NeuAc", NeuAc);
	System.out.println("========NeuGc Count:===========");
	int NeuGc = glycanCounter.countGlycan(Glycan.glycanType.NeuGc, dataHolder.getGPs());
	System.out.println("NeuGc: " + NeuGc);
	response.put("NeuGc", NeuGc);
	
	
	System.out.println("MultiMods Count:");
	int multiMods = modificationsCounter.countMultiMods(dataHolder.getGPs());
	System.out.println("multiMods:" + multiMods);
	response.put("multiMods", multiMods);
	response.put("processed", dataHolder.getGPs().size());
	
	System.out.println("Response: " + response);
	return ResponseEntity.ok(response.toString());
	
    }//--- End: ReceiveProcessData
    
    
    @GetMapping("/glycansjson/{glycan}")
    public @ResponseBody ResponseEntity<?> getGlycanJSON(@PathVariable("glycan") String glycan) {

	System.out.println("===== Request Glycan CSV =====");
	System.out.println("Glycan: " + glycan);

	if (dataHolder.getGPs().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	if (subListing == null)
	    subListing = new SubListing();
	
	ArrayList<GlycoPeptide> subData = subListing.createGlycanSubList(glycan, dataHolder.getGPs());
	JSONObject response = new JSONObject();
	JSONArray values = new JSONArray();
	
        for (GlycoPeptide gp : subData) {
            JSONArray value = new JSONArray();
            value.put(gp.getpID());
            value.put(gp.getFullData());
            values.put(value);
        }
	
        response.put("gps", values);
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getGlycanJSON
    

    @GetMapping("/glycansjson/multi")
    public @ResponseBody ResponseEntity<?> getMultiGlycanJSON() {

	System.out.println("===== Request Multi Glycan CSV =====");

	if (dataHolder.getGPs().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	if (subListing == null)
	    subListing = new SubListing();
	
	ArrayList<GlycoPeptide> subData = subListing.createMultiGlycoSubList(dataHolder.getGPs());
	JSONObject response = new JSONObject();
	JSONArray values = new JSONArray();
	
        for (GlycoPeptide gp : subData) {
            JSONArray value = new JSONArray();
            value.put(gp.getpID());
            value.put(gp.getFullData());
            values.put(value);
        }
	
        response.put("gps", values);
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getMultiGlycanJSON
    
    
    @GetMapping("/setSoft/{software}")
    public @ResponseBody ResponseEntity<?> getSoftware(@PathVariable("software") String software) {

	System.out.println("===== Request Software =====");
	System.out.println("Software: " + software);
	
	switch(software) {
	case "maxQuant":
	    dataHolder.setSoftware(MaxQuantResult.software.maxQuant);
	    break;
	case "proteomeDiscovery":
	    dataHolder.setSoftware(MaxQuantResult.software.proteomeDiscovery);
	    break;
	default:
	    dataHolder.setSoftware(MaxQuantResult.software.maxQuant);
	    
	}
	
	return ResponseEntity.ok("Software Aquired");
	
    }//--- End: getSoftware
    

    @PostMapping(value="/intensity", consumes = "multipart/form-data")
    //public ResponseEntity<?> ReceiveMaxQuantData(@RequestParam("maxquant") MultipartFile payload) {
    public ResponseEntity<?> ReceiveMaxQuantData() {

	System.out.println("===== ReceiveMaxQuantData =====");
	
	if (dataHolder.getGPs().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	String content = "";
	try {
	    //byte[] bytes = payload.getBytes();
	    //BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
	    //BufferedReader br = new BufferedReader(new FileReader("F:/Trampos/ParasitologyLab/analysis/msmsScans.txt"));
	    BufferedReader br = new BufferedReader(new FileReader("C:/tomcat/msmsScans.txt"));
	    while((content = br.readLine())!=null) {
		MaxQuantResult mqr = new MaxQuantResult();
		mqr.fillData(content, dataHolder);
		mqr.run();
		dataHolder.getMQs().add(mqr);
	    }
	    br.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	for (GlycoPeptide gp : dataHolder.getGPs()) {
	    for (MaxQuantResult mqr : dataHolder.getMQs()) {
		if (mqr.intensifyGP(gp))
		    break;
		
	    } 
	}
	
	return new ResponseEntity ("Data Acquired", HttpStatus.OK);
	
    }//--- End: ReceiveMaxQuantData
    
    
    
//==== Downloading CSV's
    @GetMapping("/glycans/{glycan}")
    public @ResponseBody ResponseEntity<?> getGlycanCSV(@PathVariable("glycan") String glycan, HttpServletResponse response) {

	System.out.println("===== Request Glycan CSV =====");
	System.out.println("Glycan: " + glycan);

	if (dataHolder.getGPs().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	if (subListing == null)
	    subListing = new SubListing();
	
	ArrayList<GlycoPeptide> subData = subListing.createGlycanSubList(glycan, dataHolder.getGPs());
	
        response.setHeader("content-disposition", "attachment;filename=glycopeptides_" + glycan + ".csv");
        response.setContentType("application/csv");
        
        try {
	    ServletOutputStream writer = response.getOutputStream();
	    
	    for (GlycoPeptide gp : subData) {
		 writer.print(gp.getFullData());
		 writer.println();
	    }
	    
	    writer.flush();
	    writer.close();
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
        
        return new ResponseEntity ("Data Sent", HttpStatus.OK);
        
    }//--- End: getGlycanCSV
    
    

    @GetMapping("/glycans/multi")
    public @ResponseBody ResponseEntity<?> getMultiGlycanCSV(HttpServletResponse response) {

	System.out.println("===== Request Multi Glycan CSV =====");

	if (dataHolder.getGPs().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	if (subListing == null)
	    subListing = new SubListing();
	
	ArrayList<GlycoPeptide> subData = subListing.createMultiGlycoSubList(dataHolder.getGPs());
	
        response.setHeader("content-disposition", "attachment;filename=glycopeptides_multisites.csv");
        response.setContentType("application/csv");
        
        try {
	    ServletOutputStream writer = response.getOutputStream();
	    
	    for (GlycoPeptide gp : subData) {
		 writer.print(gp.getFullData());
		 writer.println();
	    }
	    
	    writer.flush();
	    writer.close();
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
        
        return new ResponseEntity ("Data Sent", HttpStatus.OK);
        
    }//--- End: getMultiGlycanCSV
    

    @GetMapping("/clear")
    public @ResponseBody ResponseEntity<?> clearServer(HttpServletResponse response) {

	System.out.println("===== Clear server data =====");

	dataHolder.clearData();
        
        return new ResponseEntity ("Data Cleared", HttpStatus.OK);
        
    }//--- End: getMultiGlycanCSV
    
}