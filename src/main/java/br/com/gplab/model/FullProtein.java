package br.com.gplab.model;

import java.util.ArrayList;
import java.util.Hashtable;

import br.com.gplab.model.Glycans.glycanNames;
import br.com.gplab.model.subItens.AminoAcid;

/*
sp|Q91X72|HEMO_MOUSE Hemopexin OS=Mus musculus OX=10090 GN=Hpx PE=1 SV=2
MARTAVALNILVLLGLCWSLAVASPLPTANGRVAEVENGTKPDSDVPEHCLDTWSFDAAT
MDHNGTMLFFKGEFVWRGHSGTRELISARWKNPITSVDAAFRGPDSVFLIKEDKVWVYPP
EKKENGYPKLFQEEFPGIPYPPDAAVECHRGECQSEGVLFFQGNRKWFWDFATRTQKERS
WSTVGNCTAALRWLERYYCFQGNKFLRFNPVTGEVPPRYPLDARDYFVSCPGRGHGRPRN
GTAHGNSTHPMHSRCSPDPGLTALLSDHRGATYAFTGSHYWRLDSSRDGWHSWPIAHHWP
QGPSTVDAAFSWDDKVYLIQGTQVYVFLTKGGNNLVSGYPKRLEKELGSPPGISLETIDA
AFSCPGSSRLYVSSGRRLWWLDLKSGAQATWTEVSWPHEKVDGALCLDKSLGPNTCSSNG
SSLYFIHGPNLYCYSSIDKLNAAKSLPQPQKVNSILGCSQ
*/
public class FullProtein implements Runnable {
    
    private ArrayList<String> rawData;
    public ArrayList<String> getRawData() { return rawData; }

    private Protein protein;
    public Protein getProtein() { return protein; }
    
    private String sequence;
    public String getSequence() { return sequence; }
    public void setSequence(String sequence) { this.sequence = sequence; }

    private ArrayList<String> subcellularLocation;
    public ArrayList<String> getSubcellularLocation() { return subcellularLocation; }

    private ArrayList<String> molecularFunctions;
    public ArrayList<String> getMolecularFunctions() { return molecularFunctions; }

    private ArrayList<String> biologicalProcess;
    public ArrayList<String> getBiologicalProcess() { return biologicalProcess; }

    private Hashtable <glycanNames, Integer> dictGlycansCount;
    public Hashtable <glycanNames, Integer> getDictFPs() { return dictGlycansCount; }

    private Hashtable <String, Integer> dictAminoAsCount;
    public Hashtable <String, Integer> getDictAAs() { return dictAminoAsCount; }
    
    
    public void fillData(ArrayList<String> data) {
	rawData = data;
	subcellularLocation = new ArrayList<String>();
	molecularFunctions = new ArrayList<String>();
	biologicalProcess = new ArrayList<String>();
	dictGlycansCount = new Hashtable <glycanNames, Integer> ();
	dictAminoAsCount = new Hashtable <String, Integer> ();
    }
    

    @Override
    public void run() {
	
	protein = new Protein(rawData.get(0));
	
	StringBuilder sb = new StringBuilder();
	for (int i = 1; i < rawData.size(); i++)
	    sb.append(rawData.get(i));
	
	sequence = sb.toString();
    }
    
    public int findPeptide(String peptide) {
	return sequence.indexOf(peptide) + 1;
    }
    
    public void countGlycans (ArrayList<GlycoPeptide> allGPs) {
	
	for (GlycoPeptide gp : allGPs) {
	    if (gp.getProteinName().getProteinID().equals(this.protein.getProteinID())) {
		for (Glycans gs : gp.getGlycans()) {
		    if (dictGlycansCount.containsKey(gs.getGlycanName()))
			dictGlycansCount.put(gs.getGlycanName(), dictGlycansCount.get(gs.getGlycanName()) + 1);
		    else
			dictGlycansCount.put(gs.getGlycanName(), 1);
		    
		}
	    }
	    
	}
	
    }//--- End: countGlycans
    

    public void countAminoAs (ArrayList<GlycoPeptide> allGPs) {
	
	ArrayList<AminoAcid> aas = new ArrayList<AminoAcid>(); 
	
	for (GlycoPeptide gp : allGPs) {
	    if (gp.getProteinName().getProteinID().equals(this.protein.getProteinID())) {
		for (AminoAcid aa : gp.getSequence().getAminoAcids()) 
		    aas.add(aa);
		
	    }
	}
	
	if (aas == null || aas.size() <= 0)
	    return;
	
	while (aas.size() > 0) {
	    AminoAcid amino = aas.get(0);
	    //System.out.println("Pointer: " + amino.getSequence() + " - " + amino.getMass());
	    dictAminoAsCount.put (amino.getSequence(), 1);
	    
	    for (int i = 0; i < aas.size(); i++) {
		AminoAcid refAA = aas.get(i);
		//System.out.println("Ref: " + refAA.getSequence() + " - " + refAA.getMass());
		
		if (amino.getSequence().equals(refAA.getSequence())) {
		    
		    if(amino.getMass() != refAA.getMass())
			dictAminoAsCount.put (amino.getSequence(), dictAminoAsCount.get(amino.getSequence()) + 1);
		    
		    aas.remove(refAA);
		}
	    }
	    aas.remove(amino);
	}
	
    }//--- End: countAminoAs
    
}