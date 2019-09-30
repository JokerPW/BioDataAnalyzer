package br.com.gplab.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gplab.analysis.DataHolder;
import br.com.gplab.analysis.SubListing;
import br.com.gplab.analysis.UniqueData;
import br.com.gplab.analysis.mappings.PepAnalysisConsts;
import br.com.gplab.model.GlycoPeptide;
import br.com.gplab.model.Peptide;
import br.com.gplab.model.Protein;
import br.com.gplab.model.UnimodItem;
import br.com.gplab.model.returnItens.ProteinCount;


@RestController
@RequestMapping("/allpeptides")
public class AllPeptideController {

    @Autowired
    private DataHolder dataHolder;
    
    private UniqueData dataVerifier;
    
    

    @PostMapping(value="/peps", consumes = "multipart/form-data")
    //public ResponseEntity<?> ReceivePeps(@RequestParam("file") MultipartFile payload) {
    public ResponseEntity<?> ReceivePeps() {

	System.out.println("===== ReceivePost =====");
	
	if (dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No Organism Data", HttpStatus.OK);
	
	
	String content = "";
	
	try {
	    //byte[] bytes = payload.getBytes();
	    //BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
	    //BufferedReader br = new BufferedReader(new FileReader("F:/Trampos/ParasitologyLab/analysis/allPeptides.txt"));
	    BufferedReader br = new BufferedReader(new FileReader("C:/tomcat/allPeptides.txt"));
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
	
    }//--- End: ReceivePeps
    

    @PostMapping(value="/indexes", consumes = "multipart/form-data")
    public ResponseEntity<?> ReceiveIndexes(@ModelAttribute PepAnalysisConsts payload) {
	
	System.out.println("===== ReceiveIndexes =====");
	dataHolder.getPepAnalysisConsts().ConfigureApplication(payload);
	return ProcessData();
	
    }//--- End: ReceiveIndexes
    

    @PostMapping(value="/defaults")
    public ResponseEntity<?> UseDefaults() {
	
	System.out.println("===== UseDefaults =====");
	dataHolder.getPepAnalysisConsts().SetDefaults();
	return ProcessData();
	
    }//--- End: UseDefaults
    
    
    public ResponseEntity<?> ProcessData() {

	if (dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No Organism Data", HttpStatus.OK);

	if (dataVerifier == null)
	    dataVerifier = new UniqueData();
	
	for (String rawPep : dataHolder.getRawData()) {
	    Peptide pep = new Peptide();
	    if (pep.fillData(rawPep, dataHolder)) {
		if (dataVerifier.isUniquePeptide(pep, dataHolder.getPeps())) {
		    pep.run();
		    dataHolder.getPeps().add(pep);
		    dataHolder.getDictPeps().put(pep.getSequence(), pep);
		}
	    }
	}
	
	return new ResponseEntity ("Data Processed", HttpStatus.OK);
	
    }//--- End: ReceiveProcessData

    
    @PostMapping(value="/linkum")
    public ResponseEntity<?> LinkUniMod() {
	
	System.out.println("===== LinkUniMod =====");
	System.out.println("Trying to link " + dataHolder.getPeps().size() + " peptides.");
	for (Peptide pep : dataHolder.getPeps()) {
	    pep.unimodConnect();
	}
	
	return new ResponseEntity ("Data Linked", HttpStatus.OK);
	
    }//--- End: UseDefaults
    
    
    @GetMapping("/downloadpeps")
    public @ResponseBody ResponseEntity<?> getPeptidesCSV(HttpServletResponse response) {

	System.out.println("===== getPeptidesCSV =====");

	if (dataHolder.getPeps().size() <= 0)
	    return new ResponseEntity ("No Peptides Data", HttpStatus.OK);
	
        response.setHeader("content-disposition", "attachment;filename=allPeptides.csv");
        response.setContentType("application/csv");
        
        try {
	    ServletOutputStream writer = response.getOutputStream();
	    
	    for (Peptide pep : dataHolder.getPeps()) {
		 writer.print(pep.toString());
		 writer.println();
	    }
	    
	    writer.flush();
	    writer.close();
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
        
        return new ResponseEntity ("Data Sent", HttpStatus.OK);
        
    }//--- End: getGlycanCSV
    
    
    private void checkUniqueProts() {
	if (dataHolder.getUniqueProts().size() > 0)
	    return;
	
	for (int i = 0; i < dataHolder.getPeps().size(); i++) {
	    Peptide refPep = dataHolder.getPeps().get(i);
	    for (Protein pt : refPep.getProteins()) 
		addUniqueProt(pt);
	    
	    for (Protein pt : refPep.getDpProteins())
		addUniqueProt(pt);
	    
	}
	
    }//--- End: checkUniqueProts
    
    
    private void addUniqueProt (Protein pt) {
	boolean wasFound = false;
	
	for (int j = 0; j < dataHolder.getUniqueProts().size(); j++) {
	    if (pt.getProteinID().equals(dataHolder.getUniqueProts().get(j).getProteinID())) {
		wasFound = true;
		dataHolder.getUniqueProts().get(j).addInstance();
		break;
	    }
	}
	if (!wasFound) {
	    ProteinCount pc = new ProteinCount(pt.getProteinID(), 0);
	    dataHolder.getUniqueProts().add(pc);
	}
	
    }//--- End: addUniqueProt
    
}