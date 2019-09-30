package br.com.gplab.analysis;

import java.util.ArrayList;

import br.com.gplab.model.FullProtein;
import br.com.gplab.model.subItens.SequenceResponse;

public class ProteinFinder {
    
    public ArrayList<SequenceResponse> getSequencePosition (String fullSequence, ArrayList<FullProtein> allData) {
	
	ArrayList<SequenceResponse> resp = new ArrayList<SequenceResponse>();
	
	for(FullProtein fp : allData) {
	    int pos = fp.findPeptide(fullSequence);
	    if (pos >= 0) {
		resp.add (new SequenceResponse (pos, fp.getProtein().getProteinID()));
	    }
	}
	
	return resp;
    }
    
}