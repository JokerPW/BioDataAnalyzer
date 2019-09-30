package br.com.gplab.model;

import br.com.gplab.analysis.DataHolder;

public class MaxQuantResult implements Runnable {
    
    public static enum software {maxQuant, proteomeDiscovery};
    
    private DataHolder refData;
    
    /* GP's full data, before breaking it down into variables
     */
    private String fullData;
    public String getFullData() { return fullData; }

    private int scanNumber;		// Index 1 (9)
    public int getScanNumber() { return scanNumber; }
    public void setScanNumber(int scanNumber) { this.scanNumber = scanNumber; }

    private Double isolationInterference;	// Index _ (16)
    public Double getIsolationInterference() { return isolationInterference; }
    public void setIsolationInterference(Double isolationInterference) { this.isolationInterference = isolationInterference; }

    private Double totalIonCurrent;	// Index 4 ()
    public Double getTotalIonCurrent() { return totalIonCurrent; }
    public void setTotalIonCurrent(Double totalIonCurrent) { this.totalIonCurrent = totalIonCurrent; }
    
    private Double intensity;		// Index 7 (Base Peak Intensity) (23)
    public Double getIntensity() { return intensity; }
    public void setIntensity(Double intensity) { this.intensity = intensity; }
    
    
    public void fillData(String data, DataHolder dataHolder) {
	refData = dataHolder;
	fullData = data.replace("\"", "");
    }
    

    @Override
    public void run() {
	//String[] cut1 = fullData.split((refData.getSoftware() == software.maxQuant) ? "\\t" : ",");
	String[] cut1 = fullData.split("\\t");
	
	setScanNumber(Integer.parseInt(cut1[(refData.getSoftware() == software.maxQuant) ? 1 : 9]));

	if (refData.getSoftware() == software.maxQuant) {
	    setTotalIonCurrent(Double.parseDouble(cut1[4]));
	    setIsolationInterference(0.0);
	} else {
	    setTotalIonCurrent(0.0);
	    setIsolationInterference(Double.parseDouble(cut1[16].replace("\"", "")));
	}
	setIntensity(Double.parseDouble(cut1[(refData.getSoftware() == software.maxQuant) ? 7 : 23]));
    }
    
    public boolean intensifyGP (GlycoPeptide gp) {
	if (getScanNumber() != gp.getScanNumber().getScan())
	    return false;
	
	gp.setIntensity (getIntensity());
	gp.setTotalIonCurrent (getTotalIonCurrent());
	gp.setIsolationInterference (getIsolationInterference());
	
	return true;
    }
    
    public void dispose() {
	fullData = null;
    }
    
}