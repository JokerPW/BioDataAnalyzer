package br.com.gplab.analysis;

import java.util.ArrayList;

import br.com.gplab.model.Glycans;
import br.com.gplab.model.GlycoPeptide;
import br.com.gplab.model.subItens.Glycan;

public class GlycanCounter {
    
    public int countGlycan (Glycan.glycanType type, ArrayList<GlycoPeptide> allData) {
	
	int count = 0;
	boolean isFound = false;
	for (GlycoPeptide gp : allData) {
	    isFound = false;
	    ArrayList<Glycans> algs = gp.getGlycans();
	    
	    for (Glycans gs : algs) {
		for (Glycan gly : gs.getMolGlycans()) {
		    if (gly.getType() == type && !isFound) {
			//System.out.println("GP: "+ gp.getpID());
			count++;
			isFound = true;
		    }
		}
	    }
	    
	}
	
	return count;
    }
    
}