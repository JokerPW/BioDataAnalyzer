package br.com.gplab.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.gplab.analysis.DataHolder;
import br.com.gplab.analysis.ProteinFinder;
import br.com.gplab.analysis.externalAPIs.Uniprot;
import br.com.gplab.model.FullProtein;
import br.com.gplab.model.Glycans;
import br.com.gplab.model.Glycans.glycanNames;
import br.com.gplab.model.GlycoPeptide;
import br.com.gplab.model.returnItens.ProteinCount;
import br.com.gplab.model.subItens.ProteinDomain;
import br.com.gplab.model.subItens.SequenceResponse;
import br.com.gplab.utils.XMLReader;

@RestController
@RequestMapping("/protein")
public class ProteinController {

    @Autowired
    private DataHolder dataHolder;
    
    
    private ProteinFinder proteinFinder;
    private XMLReader xmlReader;
    private Uniprot uniprot;
    

    @GetMapping("/sequence/{pid}")
    public @ResponseBody ResponseEntity<?> getSequenceExtraInfo(@PathVariable("pid") String pid) {

	System.out.println("===== SequenceExtraInfo =====");
	System.out.println("ProteinID: " + pid);

	if (dataHolder.getGPs().size() <= 0 || dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	if (proteinFinder == null) proteinFinder = new ProteinFinder();
	
	GlycoPeptide refGP = dataHolder.getDictGPs().get(pid);
	String fullSequence = refGP.getSequence().getFullSequence();
	System.out.println("fullSequence: " + fullSequence);
	ArrayList<SequenceResponse> resp = proteinFinder.getSequencePosition(fullSequence, dataHolder.getProts());
	JSONObject response = new JSONObject();
	JSONArray values = new JSONArray();
	
	ArrayList<Integer> sites = new ArrayList<Integer>();
	for (int i = 0; i < fullSequence.length(); i++) {
	    if (fullSequence.charAt(i) == 'N')
		sites.add(i + 1);
	}
	
	for (SequenceResponse sr : resp) {
	    JSONArray value = new JSONArray();
	    value.put(sr.getPosition());
	    value.put(sr.getpID());
	    
	    JSONArray sts = new JSONArray();
	    for (int s : sites)
		sts.put(sr.getPosition() + s);
	    value.put(sts);
		    
	    JSONArray gls = new JSONArray();
	    for (Glycans gl : refGP.getGlycans())
		gls.put(gl.toString());
	    value.put(gls);
		    
	    values.put(value);
	}
	
	response.put("positions", values);
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getSequenceExtraInfo
    

    @GetMapping("/list")
    public @ResponseBody ResponseEntity<?> getProteinList() {

	System.out.println("===== Protein List =====");

	if (dataHolder.getGPs().size() <= 0 || dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	if (proteinFinder == null) proteinFinder = new ProteinFinder();
	countUniqueProts();
	
	JSONObject response = new JSONObject();
	JSONArray values = new JSONArray();
	
	for (ProteinCount pc : dataHolder.getUniqueProts()) {
	    JSONArray value = new JSONArray();
	    value.put(pc.toString());
	    values.put(value);
	}
	
	response.put("proteins", values);
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getProteinList
    
    
    private void countUniqueProts() {
	if (dataHolder.getUniqueProts().size() > 0)
	    return;
	
	boolean wasFound = false;
	
	for (int i = 0; i < dataHolder.getGPs().size(); i++) {
	    wasFound = false;
	    GlycoPeptide refGP = dataHolder.getGPs().get(i);
	    
	    for (int j = 0; j < dataHolder.getUniqueProts().size(); j++) {
		if (refGP.getProteinName().getProteinID().equals(dataHolder.getUniqueProts().get(j).getProteinID())) {
		    wasFound = true;
		    dataHolder.getUniqueProts().get(j).addInstance();
		    dataHolder.getUniqueProts().get(j).addGlycans(refGP.getGlycans().size());
		    break;
		}
	    }
	    
	    if (!wasFound) {
		ProteinCount pc = new ProteinCount(refGP.getProteinName().getProteinID(), refGP.getGlycans().size());
		//System.out.println("Protein ID: " + dataHolder.getGPs().get(i).getProteinName().getProteinID());
		//System.out.println("Sequence: " + dataHolder.getDictFPs().get(dataHolder.getGPs().get(i).getProteinName().getProteinID()).getSequence());
		pc.countGlycosilations(dataHolder.getDictFPs().get(dataHolder.getGPs().get(i).getProteinName().getProteinID()).getSequence());
		dataHolder.getUniqueProts().add(pc);
	    }
	}
    }


    @GetMapping("/gpps")
    public @ResponseBody ResponseEntity<?> getGlycansPerProtein() {

	System.out.println("===== Glycans per Protein List =====");

	if (dataHolder.getGPs().size() <= 0 || dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	dataHolder.fillProteinGlycanInfo (dataHolder.getProts(), dataHolder.getGPs());
	
	JSONObject response = new JSONObject();
	JSONArray allProts = new JSONArray();
	
	for (FullProtein fp : dataHolder.getProts()) {
	    JSONArray values = new JSONArray();
	    Iterator<glycanNames> itr = fp.getDictFPs().keySet().iterator();
	    boolean hasItens = false;
	    
	    while(itr.hasNext()) {
		glycanNames key = itr.next();
		int mappedValue = fp.getDictFPs().get(key);
		JSONObject prot = new JSONObject();
	        prot.put (key.toString(), mappedValue);
	        hasItens = true;
	        values.put(prot);
	    }
	    
	    if (hasItens) {
		JSONObject prots = new JSONObject();
		prots.put(fp.getProtein().getProteinID(), values);
		allProts.put(prots);
	    }
	}
	
	response.put("proteins", allProts);
	System.out.println("Response: " + allProts.toString());
        return ResponseEntity.ok(response.toString());
        
    }//--- End: getGlycansPerProtein
    

    @GetMapping("/gpss")
    public @ResponseBody ResponseEntity<?> getProteinGlycansPerSite() {

	System.out.println("===== Glycans per Site List =====");

	if (dataHolder.getGPs().size() <= 0 || dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	dataHolder.fillProteinAAsInfo (dataHolder.getProts(), dataHolder.getGPs());
	
	JSONObject response = new JSONObject();
	JSONArray allProts = new JSONArray();
	
	for (FullProtein fp : dataHolder.getProts()) {
	    JSONArray values = new JSONArray();
	    Iterator<String> itr = fp.getDictAAs().keySet().iterator();
	    boolean hasItens = false;
	    
	    while(itr.hasNext()) {
		String key = itr.next();
		if (key.indexOf("N") < 0)
		    continue;
		
	        int mappedValue = fp.getDictAAs().get(key);
	        JSONObject prot = new JSONObject();
	        prot.put (key.toString(), mappedValue);
		hasItens = true;
	        values.put(prot);
	    }
	    
	    if (hasItens) {
		JSONObject prots = new JSONObject();
	    	prots.put(fp.getProtein().getProteinID(), values);
		allProts.put(prots);
	    }
	    
	}

	response.put("proteins", allProts);
	System.out.println("Response: " + response.toString());
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getProteinGlycansPerSite
    
    
    @GetMapping("/domain/{pid}")
    public @ResponseBody ResponseEntity<?> getProteinDomain(@PathVariable("pid") String pid) {

	System.out.println("===== Protein Domain =====");
	System.out.println("ProteinID: " + pid);

	if (dataHolder.getGPs().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	if (xmlReader == null) xmlReader = new XMLReader();
	
	GlycoPeptide refGP = dataHolder.getDictGPs().get(pid);
	JSONObject response = new JSONObject();
	
	xmlReader.readGETXML("https://www.uniprot.org/uniprot/" + refGP.getProteinName().getProteinID() + ".xml");
	NodeList nl = xmlReader.getDoc().getElementsByTagName("feature");
	ArrayList<ProteinDomain> elements = new ArrayList<ProteinDomain>();
	for (int i = 0; i < nl.getLength(); i++) {
	    Element elmt = (Element) nl.item(i); 
	    if ("domain".equals(elmt.getAttribute("type")))
		elements.add(new ProteinDomain(elmt));
		
	}
	
	for (ProteinDomain elmt : elements) {
	    String ret = elmt.getDescription(refGP.getPos());
	    if (ret.length() > 0)
		response.put("domain", ret);
	    
	}
	
	if (response.length() <= 0)
	    response.put("domain", "Not Found");
	
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getProteinDomain
    

    @GetMapping("/sublocations")
    public @ResponseBody ResponseEntity<?> getSubLocations() {

	System.out.println("===== Sub Locations =====");

	if (dataHolder.getGPs().size() <= 0 || dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	JSONObject response = new JSONObject();
	JSONArray allLocs = new JSONArray();
	//Hashtable<String, Integer> subLocs = new Hashtable<String, Integer>(); 

	countUniqueProts();
	
	if (uniprot == null) uniprot = new Uniprot();
	uniprot.fillAllExtraInfo(dataHolder.getUniqueProts(), dataHolder.getDictFPs());
	
	// Retrieve locations
	for (FullProtein fp : dataHolder.getProts()) {
	    for (String loc : fp.getSubcellularLocation()) {
		/*if (subLocs.containsKey(loc))
		    subLocs.put(loc, subLocs.get(loc) + 1);
		else
		    subLocs.put(loc, 1);*/
		
		JSONObject jobj = new JSONObject();
		jobj.put (fp.getProtein().getProteinID(), loc);
		allLocs.put(jobj);
	    }
	}
	
	// Fill response with locations found
	/*Iterator<String> itr = subLocs.keySet().iterator();
	while(itr.hasNext()) {
	    String key = itr.next();
	    int mappedValue = subLocs.get(key);
	    JSONObject loc = new JSONObject();
	    loc.put (key.toString(), mappedValue);
	    allLocs.put(loc);
	}*/

	response.put("locations", allLocs);
	System.out.println("Response: " + response.toString());
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getSubLocations
    

    @GetMapping("/molfunctions")
    public @ResponseBody ResponseEntity<?> getMolecularFunctions() {

	System.out.println("===== Sub Locations =====");

	if (dataHolder.getGPs().size() <= 0 || dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	JSONObject response = new JSONObject();
	countUniqueProts();
	
	if (uniprot == null) uniprot = new Uniprot();
	uniprot.fillAllExtraInfo(dataHolder.getUniqueProts(), dataHolder.getDictFPs());
	
	for (FullProtein fp : dataHolder.getProts()) {
	    JSONArray functions = new JSONArray();
	    boolean isFilled = false;
	    for (String fctn : fp.getMolecularFunctions()) {
		functions.put(fctn);
		isFilled = true;
	    }
	    
	    if (isFilled)
		response.put(fp.getProtein().getProteinID(), functions);
	    
	}
	
	System.out.println("Response: " + response.toString());
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getSubLocations
    

    @GetMapping("/bioprocess")
    public @ResponseBody ResponseEntity<?> getBiologicalProcess() {

	System.out.println("===== Sub Locations =====");

	if (dataHolder.getGPs().size() <= 0 || dataHolder.getProts().size() <= 0)
	    return new ResponseEntity ("No GP Data", HttpStatus.OK);
	
	JSONObject response = new JSONObject();
	countUniqueProts();
	
	if (uniprot == null) uniprot = new Uniprot();
	uniprot.fillAllExtraInfo(dataHolder.getUniqueProts(), dataHolder.getDictFPs());
	
	for (FullProtein fp : dataHolder.getProts()) {
	    JSONArray processes = new JSONArray();
	    boolean isFilled = false;
	    for (String biop : fp.getBiologicalProcess()) {
		processes.put(biop);
		isFilled = true;
	    }
	    
	    if (isFilled)
		response.put(fp.getProtein().getProteinID(), processes);
	    
	}
	
	System.out.println("Response: " + response.toString());
	return ResponseEntity.ok(response.toString());
        
    }//--- End: getSubLocations
    
    
}