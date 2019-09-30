package br.com.gplab.model;

//>sp|P42703|LIFR_MOUSE Leukemia inhibitory factor receptor OS=Mus musculus OX=10090 GN=Lifr PE=1 SV=1
public class Protein {
    
    private String proteinID;
    public String getProteinID() { return proteinID; }
    public void setProteinID(String proteinID) { this.proteinID = proteinID; }

    private String description;
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    
    public Protein(String data) {
	//System.out.println("Protein info: " + data);
	String[] cut1 = data.replace("|", "@").split("@");
	
	if (cut1.length < 2) {
	    //System.out.println("Not enought protein info: " + cut1[0]);
	    proteinID = "";
	    description = "";
	    return;
	}
	
	proteinID = cut1[1];
	description = cut1[2];
	
    }//--- End: Constructor
    
    
    @Override
    public String toString() {
	return getProteinID() + "|" + getDescription();
    }
    
    public void clear() {
	proteinID = null;
	description = null;
    }
}