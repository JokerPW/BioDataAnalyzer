package br.com.gplab.controller;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gplab.analysis.UnimodData;
import br.com.gplab.model.unimod.Classification;
import br.com.gplab.model.unimod.Modification;
import br.com.gplab.model.unimod.Position;
import br.com.gplab.model.unimod.Specificity;
import br.com.gplab.model.unimod.interfaces.IUnimod;

@RestController
@RequestMapping("/unimod")
public class UnimodController {
    
    
    @GetMapping("/setoffset/{offset}")
    public @ResponseBody ResponseEntity<?> setOffset(@PathVariable("offset") double offset) {

	System.out.println("===== Request setOffset =====");
	System.out.println("offset: " + offset);
	
	UnimodData uData = UnimodData.getInstance();
	uData.updateOffset(offset);
	
	return new ResponseEntity ("New Offset Recieved", HttpStatus.OK);
    }
    
    
    @GetMapping("/bymassdiff/{mass}")
    public @ResponseBody ResponseEntity<?> getUnimodAccession(@PathVariable("mass") double dpMassDifference) {

	System.out.println("===== Request getUnimodAccession =====");
	System.out.println("dpMassDifference: " + dpMassDifference);

	UnimodData uData = UnimodData.getInstance();
	JSONObject response = new JSONObject();
	
	int ndx = uData.findAccessionByMass(dpMassDifference);
	if (ndx > 0) {
            response.put("Accession", ndx);
            return ResponseEntity.ok(response.toString());
        } else {
            return new ResponseEntity ("Not found", HttpStatus.OK);
        }
	
    }//--- End: getUnimodAccession
    
    
    @GetMapping("/byaccession/{accession}")
    public @ResponseBody ResponseEntity<?> getUnimodData(@PathVariable("accession") int accession) {

	System.out.println("===== Request getUnimodData =====");
	System.out.println("Accession: " + accession);

	UnimodData uData = UnimodData.getInstance();
	JSONObject response = new JSONObject();
	
	Modification mod = (Modification) uData.getDictModifications().get(accession);
	
        if (mod != null) {
            response.put("Accession", mod.getRecordID());
            response.put("PSI_MS_Name", mod.getExCodeName());
            response.put("Description", mod.getFullName());
            response.put("Interim_Name", mod.getCodeName());
            response.put("Composition", mod.getComposition());
            response.put("Monoisotopic", mod.getMonoMass());
            response.put("Average", mod.getAvgMass());
            
            ArrayList<Specificity> specs = findSpecificityFromModification(mod, uData);
            JSONArray specificities = new JSONArray();
            int count = 0;
            for (Specificity spec : specs) {
        	JSONObject specificity = new JSONObject();
        	
        	specificity.put("Site", spec.getOneLetter());
        	
        	Position pos = ((Position) uData.getDictPositions().get(spec.getPositionKey()));
        	if (pos != null)
        	    specificity.put("Position", pos.getPosition());
        	
        	Classification cls = ((Classification) uData.getDictClassifications().get(spec.getClassificationsKey()));
        	if (cls != null)
        	    specificity.put("Classification", cls.getClassification());
        	
        	specificities.put(specificity);
            }
            
            response.put("Specificities", specificities);
            System.out.println("Response: " + response);
            return ResponseEntity.ok(response.toString());
        }
	
	return new ResponseEntity ("No match found", HttpStatus.OK);
        
    }//--- End: getUnimodData


    private ArrayList<Specificity> findSpecificityFromModification(Modification mod, UnimodData uData) {
	
	ArrayList<Specificity> al = new ArrayList<Specificity>();
	for (IUnimod sp : uData.getSpecificities()) {
	    if (mod.getRecordID() == ((Specificity) sp).getModKey()) {
		al.add((Specificity) sp);
	    }
	}
	System.out.println("Specificities found: " + al.size());
	return al;
    }
    
}