package br.com.gplab.model;

import java.util.ArrayList;

import br.com.gplab.analysis.DataHolder;
import br.com.gplab.analysis.mappings.GPAnalysisConsts;
import br.com.gplab.utils.FailSafe;

// 1 | 585367,2,193,K.DTVQHWN[+1378.47569]WTSDLPLQC[+57.02146]ATHSVSIR.W,N7(NGlycan / 1378.4757),HexNAc(2)Hex(6),8.1e-24,1.7e-21,0,0,0,0,8.1e-24,1.7e-21,23.09,1207.8,1058.8,1058.8,4,1058.2157,1058.2139,1.76,,4229.8411,4229.8337,Specific,7,>sp|P42703|LIFR_MOUSE Leukemia inhibitory factor receptor OS=Mus musculus OX=10090 GN=Lifr PE=1 SV=1,2215,51.4111,controllerType=0 controllerNumber=1 scan=12907,C16(Carbamidomethyl / 57.0215),QEHF1_09556_LR_Glyco_P1-1.12907.12907.4,high-energy collision-induced dissociation
public class GlycoPeptide implements Runnable {
    
    private GPAnalysisConsts refConsts;
    
    /* GP's full data, before breaking it down into variables
     */
    private String fullData;
    public String getFullData() { return fullData + ",Full Sequence=" + sequence.getFullSequence() + ",Total Ion Current=" + getTotalIonCurrent() + ",Base Peak Intensity=" + getIntensity() + ",Isolation Interference(%)=" + getIsolationInterference(); }
    
    /* GP's unique identifier (concatenation of fields Sequence + Glycans)
     */
    private String glycoPeptide;
    public String getGP() { return glycoPeptide; }
    
    /* Identification
     */
    private String pID;
    public String getpID() { return pID; }
    public void setpID(String pID) { this.pID = pID; }

    /* ordination
     */
    private int proteinRank;
    public int getProteinRank() { return proteinRank; }
    public void setProteinRank(int proteinRank) { this.proteinRank = proteinRank; }

    
    /* unknow data
     */
    private int pos;
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
    
    
    /* Squence
     */
    private Sequence sequence;
    public Sequence getSequence() { return sequence; }
    public void setSequence(Sequence sequence) { this.sequence = sequence; }
    
    
    /* Modifications
     */
    private Modification modifications;
    public Modification getMods() { return modifications; }
    public void setMods(Modification modifications) { this.modifications = modifications; }
    
    
    /* Modifications
     */
    private ArrayList<Glycans> glycans;
    public ArrayList<Glycans> getGlycans() { return glycans; }
    public void setGlycans(ArrayList<Glycans> glycans) { this.glycans = glycans; }
    
    
    /* Significance Markers
     */
    private double pep2D;
    public double getPep2D() { return pep2D; }
    public void setPep2D(double pep2d) { pep2D = pep2d; }
    
    private double pep1D;
    public double getPep1D() { return pep1D; }
    public void setPep1D(double pep1d) { pep1D = pep1d; }
    
    private double fdr2D;
    public double getFdr2D() { return fdr2D; }
    public void setFdr2D(double fdr2d) { fdr2D = fdr2d; }
    
    private double fdr1D;
    public double getFdr1D() { return fdr1D; }
    public void setFdr1D(double fdr1d) { fdr1D = fdr1d; }
    
    private double fdrUnique2D;
    public double getFdrUnique2D() { return fdrUnique2D; }
    public void setFdrUnique2D(double fdrUnique2D) { this.fdrUnique2D = fdrUnique2D; }
    
    private double fdrUnique1D;
    public double getFdrUnique1D() { return fdrUnique1D; }
    public void setFdrUnique1D(double fdrUnique1D) { this.fdrUnique1D = fdrUnique1D; }
    
    private double qValue2D;
    public double getqValue2D() { return qValue2D; }
    public void setqValue2D(double qValue2D) { this.qValue2D = qValue2D; }
    
    private double qValue1D;
    public double getqValue1D() { return qValue1D; }
    public void setqValue1D(double qValue1D) { this.qValue1D = qValue1D; }
    
    private double logProb;
    public double getLogProb() { return logProb; }
    public void setLogProb(double logProb) { this.logProb = logProb; }
    
    private double score;
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
    
    private double deltaScore;
    public double getDeltaScore() { return deltaScore; }
    public void setDeltaScore(double deltaScore) { this.deltaScore = deltaScore; }
    
    private double deltaModScore;
    public double getDeltaModScore() { return deltaModScore; }
    public void setDeltaModScore(double deltaModScore) { this.deltaModScore = deltaModScore; }
    
    
    /* Charge
     */
    private int zCharge;
    public int getzCharge() { return zCharge; }
    public void setzCharge(int zCharge) { this.zCharge = zCharge; }
    
    /* Observed Mass/Charge
     */
    private double obsMz;
    public double getObsMz() { return obsMz; }
    public void setObsMz(double obsMz) { this.obsMz = obsMz; }
    
    /* Calculated Mass/Charge
     */
    private double calcMz;
    public double getCalcMz() { return calcMz; }
    public void setCalcMz(double calcMz) { this.calcMz = calcMz; }
    
    
    /* Particle Per Million Error
     */
    private double ppmErr;
    public double getPpmErr() { return ppmErr; }
    public void setPpmErr(double ppmErr) { this.ppmErr = ppmErr; }
    
    
    /* Protein data
     */
    private Protein proteinName;
    public Protein getProteinName() { return proteinName; }
    public void setProteinName(Protein proteinName) { this.proteinName = proteinName; }
    
    /* ProteinID
     */
    private int proteinID;
    public int getProteinID() { return proteinID; }
    public void setProteinID(int proteinID) { this.proteinID = proteinID; }


    /* Scan moment when this peptide was found 
     */
    private double scanTime;
    public double getScanTime() { return scanTime; }
    public void setScanTime(double scanTime) { this.scanTime = scanTime; }

    /* Scan data of this peptide 
     */
    private ScanNumber scanNumber;
    public ScanNumber getScanNumber() { return scanNumber; }
    public void setScanNumber(ScanNumber scanNumber) { this.scanNumber = scanNumber; }
    
    /* Where the fixed modification occurred. 
     */
    private ModsFixed modsFixed;
    public ModsFixed getModsFixed() { return modsFixed; }
    public void setModsFixed(ModsFixed modsFixed) { this.modsFixed = modsFixed; }
    
    /* Total Ion Current information, got from MaxQuant and merged through code.
     */
    private Double totalIonCurrent;	// Index 4
    public Double getTotalIonCurrent() { return totalIonCurrent; }
    public void setTotalIonCurrent(Double totalIonCurrent) { this.totalIonCurrent = totalIonCurrent; }

    /* Base Peak Intensity information, got from MaxQuant and merged through code.
     */
    private Double intensity;
    public Double getIntensity() { return intensity; }
    public void setIntensity(Double intensity) { this.intensity = intensity; }

    /* Isolation Interference(%) information, got from MaxQuant and merged through code.
     */
    private Double isolationInterference;	// Index _ (16)
    public Double getIsolationInterference() { return isolationInterference; }
    public void setIsolationInterference(Double isolationInterference) { this.isolationInterference = isolationInterference; }



    /* If there was an error parsing this GP, the index of the column where the error occur will be shown here. It starts as -1, meaning "NO ERROR"
     */
    private int errorID;
    public int getErrorID() { return errorID; }
    public void setErrorID(int errorID) { this.errorID = errorID; }

    
    public GlycoPeptide() {
	errorID = -1;
	
    }//--- End: Constructor
    
    
    public boolean fillData(String data, DataHolder yourRef) {
	fullData = data;
	refConsts = yourRef.getGPAnalysisConsts();
	String[] cut1 = fullData.split(refConsts.getSplitChar());

	try {
	    if (FailSafe.testIndex(refConsts.getProteinName_ndx(), cut1)) {
		// If this is a reverse analysis, ignore it!
	        if (cut1[refConsts.getProteinName_ndx()].indexOf("Reverse") >= 0) {
	            System.out.println("GP Fill Data Fail - protein REVERSE");
	            clear();
	            return false;
	        }
		proteinName = new Protein(cut1[refConsts.getProteinName_ndx()]);
	    }
	} catch (Error e) {
	    System.out.println("GP Fill Data Fail - proteinName creation");
	    errorID = refConsts.getProteinName_ndx();
	}
	
	// If this protein doesn't belong to the organism being studied, ignore it!
	if (proteinName == null || proteinName.getProteinID() == null ||
		!yourRef.getDictFPs().containsKey(proteinName.getProteinID())) {
	    System.out.println("Protein not found or does not belong to the Organism being studied");
            clear();
            return false;
	}
	
        // If this GP is not significant, ignore it!
        if (SignificanceRule(cut1)) {
            System.out.println("GP Fill Data Fail - Significance Rule: " + getPep2D());
            clear();
            return false;
        }

        // If it wasn't glycosilated, ignore it!
        if (!FailSafe.testIndex(refConsts.getGlycans_ndx(), cut1) || cut1[refConsts.getGlycans_ndx()].length() <= 0) {
            System.out.println("GP Fill Data Fail - no glycosilation");
            clear();
            return false;
        }
        
        if (FailSafe.testIndex(refConsts.getSequence_ndx(), cut1) && FailSafe.testIndex(refConsts.getGlycans_ndx(), cut1))
            glycoPeptide = cut1[refConsts.getSequence_ndx()] + cut1[refConsts.getGlycans_ndx()];

	try {
	    if (FailSafe.testIndex(refConsts.getScanNumber_ndx(), cut1))
		scanNumber = new ScanNumber(cut1[refConsts.getScanNumber_ndx()]);
	} catch (Error e) {
	    System.out.println("Fail at getting SCAN NUMBER");
	    errorID = refConsts.getScanNumber_ndx();
	}
	
        return true;
        
    }//--- End: fillData
    
	
    @Override
    public void run() {
	
	if (fullData.indexOf("\"") > 0) {
	    clearExtraComma();
	}
	
	String[] cut1 = fullData.split(refConsts.getSplitChar());
	
	if (FailSafe.testIndex(refConsts.getPID_ndx(), cut1))
	    setpID(cut1[refConsts.getPID_ndx()].split(" | ")[2]);
	
	if (FailSafe.testIndex(refConsts.getProteinRank_ndx(), cut1))
	    setProteinRank(forceInteger(cut1, refConsts.getProteinRank_ndx()));
	
	if (FailSafe.testIndex(refConsts.getPos_ndx(), cut1))
	    setPos(forceInteger(cut1, refConsts.getPos_ndx()));

	try {
	    if (FailSafe.testIndex(refConsts.getSequence_ndx(), cut1))
		sequence = new Sequence(cut1[refConsts.getSequence_ndx()]);
	} catch (Error e) {
	    System.out.println("Fail at getting SEQUENCE");
	    errorID = refConsts.getSequence_ndx();
	}

	try {
	    if (FailSafe.testIndex(refConsts.getModifications_ndx(), cut1))
		modifications = new Modification(cut1[refConsts.getModifications_ndx()]);
	} catch (Error e) {
	    System.out.println("Fail at getting MODIFICATION");
	    errorID = refConsts.getModifications_ndx();
	}
	
	//System.out.println("Glycans NDX: " + refConsts.getGlycans_ndx());
	//System.out.println("Data Length: " + cut1.length);
	try {
	    if (FailSafe.testIndex(refConsts.getGlycans_ndx(), cut1)) {
		glycans = new ArrayList<Glycans>();
		if (cut1[refConsts.getGlycans_ndx()].indexOf(";") > 0) {
		    System.out.println("Many Glycans found");
		    String[] allGlycans = cut1[refConsts.getGlycans_ndx()].split(";");
		    for (int i = 0; i < allGlycans.length; i++)
			glycans.add(new Glycans(allGlycans[i].replaceAll("\\s+","")));
		    
		} else {
		    System.out.println("Just one Glycan");
		    glycans.add(new Glycans(cut1[refConsts.getGlycans_ndx()]));
		}
	    }
	} catch (Error e) {
	    System.out.println("Fail at getting GLYCANS");
	    errorID = refConsts.getGlycans_ndx();
	}
	
	if (FailSafe.testIndex(refConsts.getzCharge_ndx(), cut1))
	    setzCharge(forceInteger(cut1, refConsts.getzCharge_ndx()));
	
	if (FailSafe.testIndex(refConsts.getObsMz_ndx(), cut1))
	    setObsMz(forceDouble(cut1, refConsts.getObsMz_ndx()));
	
	if (FailSafe.testIndex(refConsts.getCalcMz_ndx(), cut1))
	    setCalcMz(forceDouble(cut1, refConsts.getCalcMz_ndx()));
	
	if (FailSafe.testIndex(refConsts.getPpmErr_ndx(), cut1))
	    setPpmErr(forceDouble(cut1, refConsts.getPpmErr_ndx()));
	
	if (FailSafe.testIndex(refConsts.getProteinID_ndx(), cut1))
	    setProteinID(forceInteger(cut1, refConsts.getProteinID_ndx()));
	
	if (FailSafe.testIndex(refConsts.getScanTime_ndx(), cut1))
	    setScanTime(forceDouble(cut1, refConsts.getScanTime_ndx()));

	try {
	    if (FailSafe.testIndex(refConsts.getModsFixed_ndx(), cut1)) {
		if (cut1[refConsts.getModsFixed_ndx()].length() > 0)
		    modsFixed = new ModsFixed(cut1[refConsts.getModsFixed_ndx()]);
	    }
	} catch (Error e) {
	    System.out.println("Fail at getting MODS FIXED");
	    errorID = refConsts.getModsFixed_ndx();
	}
	
    }//--- End: run
    
    
    private boolean SignificanceRule(String[] data) {
	
	if (FailSafe.testIndex(refConsts.getPep2D_ndx(), data))
	    setPep2D(forceDouble(data, refConsts.getPep2D_ndx()));

	if (FailSafe.testIndex(refConsts.getLogProb_ndx(), data))
	    setLogProb(forceDouble(data, refConsts.getLogProb_ndx()));

	if (FailSafe.testIndex(refConsts.getScore_ndx(), data))
	    setScore(forceDouble(data, refConsts.getScore_ndx()));
	
	
	if ((refConsts.getPep2D_sig() != 0 && getPep2D() > refConsts.getPep2D_sig()) ||
	    (refConsts.getLogProb_sig() != 0 && getLogProb() < refConsts.getLogProb_sig()) ||
	    (refConsts.getScore_sig() != 0 && getScore() > refConsts.getScore_sig()))
	    return true;


	if (FailSafe.testIndex(refConsts.getPep1D_ndx(), data))
	    setPep1D(forceDouble(data, refConsts.getPep1D_ndx()));
	
	if (FailSafe.testIndex(refConsts.getFdr2D_ndx(), data))
	    setFdr2D(forceDouble(data, refConsts.getFdr2D_ndx()));
	
	if (FailSafe.testIndex(refConsts.getFdr1D_ndx(), data))
	    setFdr1D(forceDouble(data, refConsts.getFdr1D_ndx()));
	
	if (FailSafe.testIndex(refConsts.getFdrUnique2D_ndx(), data))
	    setFdrUnique2D(forceDouble(data, refConsts.getFdrUnique2D_ndx()));
	
	if (FailSafe.testIndex(refConsts.getFdrUnique1D_ndx(), data))
	    setFdrUnique1D(forceDouble(data, refConsts.getFdrUnique1D_ndx()));
	
	if (FailSafe.testIndex(refConsts.getqValue2D_ndx(), data))
	    setqValue2D(forceDouble(data, refConsts.getqValue2D_ndx()));
	
	if (FailSafe.testIndex(refConsts.getqValue1D_ndx(), data))
	    setqValue1D(forceDouble(data, refConsts.getqValue1D_ndx()));
	
	if (FailSafe.testIndex(refConsts.getDeltaScore_ndx(), data))
	    setDeltaScore(forceDouble(data, refConsts.getDeltaScore_ndx()));
	
	if (FailSafe.testIndex(refConsts.getDeltaModScore_ndx(), data))
	    setDeltaModScore(forceDouble(data, refConsts.getDeltaModScore_ndx()));
	
	return false;
    }
    
    private Double forceDouble(String[] data, int ndx) {
	try {
	    return Double.parseDouble(data[ndx]);
	} catch (Error e) {
	    errorID = ndx;
	    return 0.0;
	}
    }

    private int forceInteger(String[] data, int ndx) {
	try {
	    return Integer.parseInt(data[ndx]);
	} catch (Error e) {
	    errorID = ndx;
	    return 0;
	}
    }

    private void clearExtraComma() {
	String[] clean = fullData.split("\"");
	clean[1] = clean[1].replaceAll(",", ";");
	fullData = clean[0] + clean[1] + clean[2];
    }
    
    private void clear() {
	fullData = "";
	
	if (proteinName != null)
	    proteinName.clear();
	
    }
    
    
    public void dispose() {
	clear();
	
	glycoPeptide = null;
	pID = null;
	
	sequence.dispose();
	sequence = null;
	
	modifications.dispose();
	modifications = null;
	
	for (Glycans glc : glycans) {
	    glc.dispose();
	    glc = null;
	}
	
	proteinName.clear();
	proteinName = null;
	
	scanNumber = null;
	
	if (modsFixed != null)
	    modsFixed.dispose();
	
	modsFixed = null;
    }

}