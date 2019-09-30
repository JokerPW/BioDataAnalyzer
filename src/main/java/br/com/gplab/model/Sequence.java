package br.com.gplab.model;

import java.util.ArrayList;

import br.com.gplab.model.subItens.AminoAcid;

// K.DTVQHWN[+1378.47569]WTSDLPLQC[+57.02146]ATHSVSIR.W
public class Sequence {
    
    private static enum clivageSites{
	K, R;
    }

    
    private String rawText;
    public String getRawText() { return rawText; }
    public void setRawText(String rawText) { this.rawText = rawText; }

    private clivageSites clivageSite;
    public clivageSites getClivageSite() { return clivageSite; }
    public void setClivageSite(clivageSites clivageSite) { this.clivageSite = clivageSite; }

    private ArrayList<AminoAcid> aminoAcids;
    public ArrayList<AminoAcid> getAminoAcids() { return aminoAcids; }
    public void setAminoAcids(ArrayList<AminoAcid> aminoAcids) { this.aminoAcids = aminoAcids; }

    private StringBuilder fullSequence;
    public String getFullSequence() { return fullSequence.toString(); }
    public void setFullSequence(StringBuilder fullSequence) { this.fullSequence = fullSequence; }

    private String last;
    public String getLast() { return last; }
    public void setLast(String last) { this.last = last; }
    
    
    public Sequence(String raw) {
	rawText = raw;
	aminoAcids = new ArrayList<AminoAcid>();
	fullSequence = new StringBuilder();
	
	String[] cut1 = raw.replace("]", "@").split("@");
	for (int i = 0; i < cut1.length; i++) {
	    String[] cut2 = cut1[i].replace("[", "%").split("%");
	    if(i < cut1.length - 1) {
		
		if (i > 0) {	// Not the first amino acid sequence
		    aminoAcids.add(new AminoAcid(cut2[0], cut2[1]));
		    fullSequence.append(cut2[0]);
		    
		} else {
		    String[] finalCut = cut2[0].replace(".", ":").split(":");
		    
		    switch(finalCut[0]) {
		    case "K": clivageSite = clivageSites.K; break;
		    case "R": clivageSite = clivageSites.R; break;
		    default: clivageSite = clivageSites.K;
		    }
		    
		    fullSequence.append(finalCut[1]);
		    aminoAcids.add(new AminoAcid(finalCut[1], cut2[1]));
		}
		
	    } else {	// Last amino acid sequence
		String[] finalCut = cut2[0].replace(".", ":").split(":");
		aminoAcids.add(new AminoAcid(cut2[0], ""));
		fullSequence.append(finalCut[0]);
		
		last = finalCut[1];
		    
	    }//--- End: Last amino acid sequence
	    
	}//--- End: For (amino acids)
	
    }//--- End: Constructor
    
    
    public void dispose() {

	rawText = null;
	clivageSite = null;
	fullSequence = null;
	last = null;
	
	for (AminoAcid aa : aminoAcids)
	    aa.dispose();
	    
    }
}