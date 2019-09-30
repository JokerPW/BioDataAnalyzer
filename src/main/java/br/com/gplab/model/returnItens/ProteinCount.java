package br.com.gplab.model.returnItens;

public class ProteinCount {
    
    private String proteinID;
    public String getProteinID() { return proteinID; }
    
    private int instances;
    public int getInstances() { return instances; }

    private int glycosilationSites;
    public int getGlycosilationSites() { return glycosilationSites; }

    private int glycans;
    public int getGlycans() { return glycans; }
    
    
    public ProteinCount (String yourID, int yourGlycans) {
	proteinID = yourID;
	instances = 1;
	glycosilationSites = 0;
	glycans = yourGlycans;
    }
    
    public void addInstance() {
	this.instances++;
    }
    
    public void countGlycosilations (String fullSequence) {
	
	for (int i = 0; i < fullSequence.length(); i++) {
	    if (fullSequence.charAt(i) == 'N')
		glycosilationSites++;
	}
	
    }
    
    public void addGlycans (int newGlycans) {
	glycans += newGlycans;
    }
    
    
    @Override
    public String toString() {
	return proteinID + "," + instances + "," + glycosilationSites + "," + glycans;
    }


    public void dispose() {
	proteinID = null;
    }
}