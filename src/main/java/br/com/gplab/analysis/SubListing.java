package br.com.gplab.analysis;

import java.util.ArrayList;

import br.com.gplab.model.Glycans;
import br.com.gplab.model.GlycoPeptide;
import br.com.gplab.model.subItens.Glycan;
import br.com.gplab.model.subItens.Glycan.glycanType;

public class SubListing {
    
    public ArrayList<GlycoPeptide> createGlycanSubList (String type, ArrayList<GlycoPeptide> allData) {
	
	ArrayList<GlycoPeptide> subData = new ArrayList<GlycoPeptide>();
	Glycan.glycanType convertedType = convertType(type);
	
	boolean isFound = false;
	for (GlycoPeptide gp : allData) {
	    isFound = false;
	    ArrayList<Glycans> algs = gp.getGlycans();
	    
	    for (Glycans gs : algs) {
		for (Glycan gly : gs.getMolGlycans()) {
		    if (gly.getType() == convertedType && !isFound) {
			//System.out.println("GP: "+ gp.getpID());
			subData.add(gp);
			isFound = true;
		    }
		}
	    }
	}
	
	return subData;
	
    }//--- End: createGlycanSubList
    

    public ArrayList<GlycoPeptide> createMultiGlycoSubList (ArrayList<GlycoPeptide> allData) {
	
	ArrayList<GlycoPeptide> subData = new ArrayList<GlycoPeptide>();
	for (GlycoPeptide gp : allData) {
	    if (gp.getMods().getMods() > 1)
		subData.add(gp);
	    
	}
	
	return subData;
	
    }//--- End: createMultiGlycoSubList
    
    
    private Glycan.glycanType convertType (String type){
	
	switch(type) {
	case "Hex": return glycanType.Hex; 
	case "HexNAc": return glycanType.HexNAc; 
	case "Fuc": return glycanType.Fuc; 
	case "NeuAc": return glycanType.NeuAc; 
	case "NeuGc": return glycanType.NeuGc; 
	default: return glycanType.Hex;
	}
	
    }
    
}