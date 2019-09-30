package br.com.gplab.analysis;

import java.util.ArrayList;

import br.com.gplab.model.GlycoPeptide;

public class ModificationsCounter {
    
    public int countMultiMods(ArrayList<GlycoPeptide> allData) {
	
	int count = 0;
	
	for (GlycoPeptide gp : allData) {
	    if (gp.getMods().getMods() > 1) {
		//System.out.println("GP: "+ gp.getpID());
		count++;
	    }
	}
	
	return count;
    }
    
}