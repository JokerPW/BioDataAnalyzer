package br.com.gplab.model;

//C9(Carbamidomethyl / 57.0215); C11(Carbamidomethyl / 57.0215)
public class ModsFixed {
    
    private int[] positions;
    public int[] getPositions() { return positions; }
    public void setPositions(int[] positions) { this.positions = positions; }

    
    private String rawData;
    public String getRawData() { return rawData; }
    public void setRawData(String rawData) { this.rawData = rawData; }
    
    
    public ModsFixed(String data) {
	rawData = data;
	
	String[] cut1 = data.split(";");
	positions = new int[(cut1.length)];
	
	for(int i = 0; i < cut1.length; i++)
	    positions[i] = cutPosition(cut1[i]);
	
    }


    private int cutPosition(String data) {
	String[] cut1 = data.replaceAll("\\s+","").replace("(", "@").split("@");
	return Integer.parseInt(cut1[0].substring(1));
    }
    
    public void dispose() {
	positions = null;
	rawData = null;
    }

}