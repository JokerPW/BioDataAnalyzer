package br.com.gplab.analysis;

import java.util.ArrayList;

import br.com.gplab.model.GlycoPeptide;
import br.com.gplab.model.Peptide;

public class UniqueData {
    
    public boolean isUniqueGP (GlycoPeptide newGP, ArrayList<GlycoPeptide> allData) {
	for (GlycoPeptide gp : allData) {
	    if (newGP.getGP().equals(gp.getGP())) {
		if (newGP.getScanNumber().getScan() > gp.getScanNumber().getScan()) {
		    return false;
		} else {
		    allData.remove(gp);
		    return true;
		}
	    }
	}
	
	return true;
    }
    
    
    public boolean isUniquePeptide (Peptide pep, ArrayList<Peptide> allData) {
	
	for (Peptide pt : allData)
	    if (pt.getSequence().equals(pep.getSequence()) &&
		pt.getModifications().equals(pep.getModifications()) &&
		pt.getDP_Positional_Probability() == pep.getDP_Positional_Probability()) {
		System.out.println("---Peptide not unique!");
		return false;
	    }
	
	return true;
    }
    
}