package br.com.gplab.model;

import java.util.ArrayList;

import br.com.gplab.analysis.DataHolder;
import br.com.gplab.analysis.UnimodData;
import br.com.gplab.analysis.mappings.PepAnalysisConsts;
import br.com.gplab.model.subItens.DPProbability;

// 2188A	MULTI	4	377.94113	1507.7354	377.94374	99344.95	159	79	4		0.735405	0.00184671742886167	1.432737	377.941062887638	4.033	42.354	0	596	905		-1	 	0	 	 	 	NaN	1411100	0;31352.08;57898.99;250592.1;325104.7;299228.3;368181.5;407575.3;448897.1;405763;514879.3;959543.1;922970.2;1071183;1218494;1130436;1118336;1269141;1255101;1233697;1239393;1374097;1156046;1279212;1023995;1261701;1463794;1141294;1208226;867101.6;1304632;797539.4;831084;709012.3;420802.8;434783.6;190160;487065.5;417839;405774.7;196816.9;303758.7;363763.6;548122.1;260128.6;391629.1;260744.6;180246;314581.6;312207.8;187578.2;127858.2;206914.1;223906.2;208429.8;332199.3;216880.3;229731.3;318897.4;199178.5;283778.1;52530.16;228728;72970.17;265869.3;150331.6;286924.7;147843.1;151296.2;105994.2;168950.3;193940.3;188631.6;162887.7;130723.6;144640.9;179807.9;118035.4;261217;105196.9;0	1	623	1
public class Peptide implements Runnable {
    
    private PepAnalysisConsts refConsts;
    private UnimodData uData;

    
    /* Peptide's full data, before breaking it down into variables
     */
    private String fullData;
    public String getFullData() { return fullData; }
    
    /* Peptide's "link" to the Unimod
     */
    private int accession;
    public int getAccession() { return accession; }
    public void setAccession(int accession) { this.accession = accession; }

    /* Original file from the reading
     */
    private String rawFile;
    public String getRawFile() { return rawFile; }
    public void setRawFile(String rawFile) { this.rawFile = rawFile; }
    
    /*
     */
    private String type;
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    /*
     */
    private int charge;
    public int getCharge() { return charge; }
    public void setCharge(int charge) { this.charge = charge; }

    /*
     */
    private double massCharge;
    public double getMassCharge() { return massCharge; }
    public void setMassCharge(double massCharge) { this.massCharge = massCharge; }

    /*
     */
    private double mass;
    public double getMass() { return mass; }
    public void setMass(double mass) { this.mass = mass; }

    /*
     */
    private double uncalibratedMZ;
    public double getUncalibratedMZ() { return uncalibratedMZ; }
    public void setUncalibratedMZ(double uncalibratedMZ) { this.uncalibratedMZ = uncalibratedMZ; }

    /*
     */
    private double resolution;
    public double getResolution() { return resolution; }
    public void setResolution(double resolution) { this.resolution = resolution; }

    /*
     */
    private int nDataPoints;
    public int getNDataPoints() { return nDataPoints; }
    public void setNDataPoints(int nDataPoints) { this.nDataPoints = nDataPoints; }

    /*
     */
    private int nScans;
    public int getNScans() { return nScans; }
    public void setNScans(int nScans) { this.nScans = nScans; }

    /*
     */
    private double massFractional;
    public double getMassFractional() { return massFractional; }
    public void setMassFractional(double massFractional) { this.massFractional = massFractional; }

    /*
     */
    private double massDeficit;
    public double getMassDeficit() { return massDeficit; }
    public void setMassDeficit(double massDeficit) { this.massDeficit = massDeficit; }

    /*
     */
    private double massPrecision;
    public double getMassPrecision() { return massPrecision; }
    public void setMassPrecision(double massPrecision) { this.massPrecision = massPrecision; }

    /*
     */
    private double retentionTime;
    public double getRetentionTime() { return retentionTime; }
    public void setRetentionTime(double retentionTime) { this.retentionTime = retentionTime; }

    /*
     */
    private double retentionLength;
    public double getRetentionLength() { return retentionLength; }
    public void setRetentionLength(double retentionLength) { this.retentionLength = retentionLength; }

    /*
     */
    private int minScanNumber;
    public int getMinScanNumber() { return minScanNumber; }
    public void setMinScanNumber(int minScanNumber) { this.minScanNumber = minScanNumber; }

    /*
     */
    private int maxScanNumber;
    public int getMaxScanNumber() { return maxScanNumber; }
    public void setMaxScanNumber(int maxScanNumber) { this.maxScanNumber = maxScanNumber; }

    /*
     */
    private int msmsIDs;
    public int getMsmsIDs() { return msmsIDs; }
    public void setMsmsIDs(int msmsIDs) { this.msmsIDs = msmsIDs; }

    /*
     */
    private String sequence;
    public String getSequence() { return sequence; }
    public void setSequence(String sequence) { this.sequence = sequence; }

    /* Length of the Sequence
     */
    public int getLength() { return sequence.length(); }

    /*
     */
    private String modifications;
    public String getModifications() { return modifications; }
    public void setModifications(String modifications) { this.modifications = modifications; }

    /*
     */
    private String modifiedSequence;
    public String getModifiedSequence() { return modifiedSequence; }
    public void setModifiedSequence(String modifiedSequence) { this.modifiedSequence = modifiedSequence; }

    /*
     */
    private ArrayList<Protein> proteins;
    public ArrayList<Protein> getProteins() { return proteins; }
    public void setProteins(ArrayList<Protein> proteins) { this.proteins = proteins; }

    /*
     */
    private double score;
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    /*
     */
    private double intensity;
    public double getTntensity() { return intensity; }
    public void setIntensity(double intensity) { this.intensity = intensity; }

    /*
     */
    private ArrayList<Double> intensities;
    public ArrayList<Double> getTntensities() { return intensities; }
    public void setIntensities(ArrayList<Double> intensities) { this.intensities = intensities; }

    /*
     */
    private int msmsCount;
    public int getMsmsCount() { return msmsCount; }
    public void setMsmsCount(int msmsCount) { this.msmsCount = msmsCount; }

    /*
     */
    private ArrayList<Integer> msmsScanNs;
    public ArrayList<Integer> getMsmsScanNs() { return msmsScanNs; }
    public void setMsmsScanNs(ArrayList<Integer> msmsScanNs) { this.msmsScanNs = msmsScanNs; }

    /*
     */
    private ArrayList<Integer> msmsIsotopesNdxs;
    public ArrayList<Integer> getMsmsIsotopesNdxs() { return msmsIsotopesNdxs; }
    public void setMsmsIsotopesNdxs(ArrayList<Integer> msmsIsotopesNdxs) { this.msmsIsotopesNdxs = msmsIsotopesNdxs; }

    /*
     */
    private double dpMassDifference;
    public double getDpMassDifference() { return dpMassDifference; }
    public void setDpMassDifference(double dpMassDifference) { this.dpMassDifference = dpMassDifference; }

    /*
     */
    private double dpTimeDifference;
    public double getDpTimeDifference() { return dpTimeDifference; }
    public void setDpTimeDifference(double dpTimeDifference) { this.dpTimeDifference = dpTimeDifference; }

    /*
     */
    private double dpScore;
    public double getDpScore() { return dpScore; }
    public void setDpScore(double dpScore) { this.dpScore = dpScore; }

    /*
     */
    private double dpPep;
    public double getDpPep() { return dpPep; }
    public void setDpPep(double dpPep) { this.dpPep = dpPep; }
    
    /* Significance index (if >= .9)
     */
    private double dp_Positional_Probability = -1;
    public double getDP_Positional_Probability() { return dp_Positional_Probability; }
    public void setDP_Positional_Probability(double dp_Positional_Probability) { this.dp_Positional_Probability = dp_Positional_Probability; }

    /*
     */
    private String dpBaseSequence;
    public String getDpBaseSequence() { return dpBaseSequence; }
    public void setDpBaseSequence(String dpBaseSequence) { this.dpBaseSequence = dpBaseSequence; }

    /*
     */
    private ArrayList<DPProbability> dpProbabilities;
    public ArrayList<DPProbability> getDpProbabilities() { return dpProbabilities; }
    public void setDpProbabilities(ArrayList<DPProbability> dpProbabilities) { this.dpProbabilities = dpProbabilities; }

    /*
     */
    private ArrayList<String> dpAA;
    public ArrayList<String> getDpAA() { return dpAA; }
    public void setDpAA(ArrayList<String> dpAA) { this.dpAA = dpAA; }

    /*
     */
    private int dpBaseScanNum;
    public int getDpBaseScanNum() { return dpBaseScanNum; }
    public void setDpBaseScanNum(int dpBaseScanNum) { this.dpBaseScanNum = dpBaseScanNum; }

    /*
     */
    private int dpModScanNum;
    public int getDpModScanNum() { return dpModScanNum; }
    public void setDpModScanNum(int dpModScanNum) { this.dpModScanNum = dpModScanNum; }

    /*
     */
    private int dpDecoy;
    public int getDpDecoy() { return dpDecoy; }
    public void setDpDecoy(int dpDecoy) { this.dpDecoy = dpDecoy; }

    /*
     */
    private ArrayList<Protein> dpProteins;
    public ArrayList<Protein> getDpProteins() { return dpProteins; }
    public void setDpProteins(ArrayList<Protein> dpProteins) { this.dpProteins = dpProteins; }

    /*
     */
    private int dpClusterIndex;
    public int getDpClusterIndex() { return dpClusterIndex; }
    public void setDpClusterIndex(int dpClusterIndex) { this.dpClusterIndex = dpClusterIndex; }

    /*
     */
    private double dpClusterMass;
    public double getDpClusterMass() { return dpClusterMass; }
    public void setDpClusterMass(double dpClusterMass) { this.dpClusterMass = dpClusterMass; }

    /*
     */
    private double dpClusterMassSD;
    public double getDpClusterMassSD() { return dpClusterMassSD; }
    public void setDpClusterMassSD(double dpClusterMassSD) { this.dpClusterMassSD = dpClusterMassSD; }

    /*
     */
    private int dpClusterSizeTotal;
    public int getDpClusterSizeTotal() { return dpClusterSizeTotal; }
    public void setDpClusterSizeTotal(int dpClusterSizeTotal) { this.dpClusterSizeTotal = dpClusterSizeTotal; }

    /*
     */
    private int dpClusterSizeForward;
    public int getDpClusterSizeForward() { return dpClusterSizeForward; }
    public void setDpClusterSizeForward(int dpClusterSizeForward) { this.dpClusterSizeForward = dpClusterSizeForward; }

    /*
     */
    private int dpClusterSizeReverse;
    public int getDpClusterSizeReverse() { return dpClusterSizeReverse; }
    public void setDpClusterSizeReverse(int dpClusterSizeReverse) { this.dpClusterSizeReverse = dpClusterSizeReverse; }

    /*
     */
    private String dpModification;
    public String getDpModification() { return dpModification; }
    public void setDpModification(String dpModification) { this.dpModification = dpModification; }

    /*
     */
    private int dpPepLengthDiff;
    public int getDpPepLengthDiff() { return dpPepLengthDiff; }
    public void setDpPepLengthDiff(int dpPepLengthDiff) { this.dpPepLengthDiff = dpPepLengthDiff; }

    /*
     */
    private double dpRatioMB;
    public double getDpRatioMB() { return dpRatioMB; }
    public void setDpRatioMB(double dpRatioMB) { this.dpRatioMB = dpRatioMB; }

    
    /* If there was an error parsing this GP, the index of the column where the error occur will be shown here. It starts as -1, meaning "NO ERROR"
     */
    private int errorID;
    public int getErrorID() { return errorID; }
    public void setErrorID(int errorID) { this.errorID = errorID; }


    /*
     */
    private UnimodItem unimodItem;
    public UnimodItem getUnimodItem() { return unimodItem; }
    public void setUnimodItem(UnimodItem unimodItem) { this.unimodItem = unimodItem; }

    
    public Peptide() {
	proteins = new ArrayList<Protein>();
	intensities = new ArrayList<Double>();
	msmsScanNs = new ArrayList<Integer>();
	msmsIsotopesNdxs = new ArrayList<Integer>();
	dpProbabilities = new ArrayList<DPProbability>();
	dpAA = new ArrayList<String>();
	dpProteins = new ArrayList<Protein>();
	
	errorID = -1;
	
    }//--- End: Constructor
    
    
    public boolean fillData(String data, DataHolder yourRef) {
	uData = UnimodData.getInstance();
	fullData = data;
	//System.out.println("Full Data: " + fullData);
	refConsts = yourRef.getPepAnalysisConsts();
	String[] cut1 = fullData.split(refConsts.getSplitChar());
	
	if (!testIndex(refConsts.getProteins_ndx(), cut1) ||
		!testIndex(refConsts.getDpPositionalProbability_ndx(), cut1) ||
		!testIndex(refConsts.getSequence_ndx(), cut1) ||
		!testIndex(refConsts.getModifications_ndx(), cut1)) {
	    clear();
	    //System.out.println("Not enough Information - length: " + cut1.length);
	    return false;
	}
	
	String prots = cut1[refConsts.getProteins_ndx()];
	if (prots.length() > 0) {
	    String[] cut2 = prots.split(";");
	    for (int i = 0; i < cut2.length; i++) {
		try {
		    proteins.add(new Protein(cut2[i]));
		} catch (Exception e) {
		    errorID = refConsts.getProteins_ndx();
		}
	    }
	}
	

	// If this protein doesn't belong to the organism being studied, ignore it!
	/*for (Protein pt : proteins) {
	    if (pt.getProteinID() == null) {
		System.out.println("Protein not found");
	        clear();
	        return false;
	    } else if (!yourRef.getDictFPs().containsKey(pt.getProteinID())) {
		System.out.println("Protein does not belong to the Organism being studied: " + pt.getProteinID());
	        clear();
	        return false;
	    }
	}*/
	
        // If this peptide is not significant, ignore it!
        if (SignificanceRule(cut1)) {
            clear();
            System.out.println("Significance rule cut");
            return false;
        }
        
        if (testIndex(refConsts.getSequence_ndx(), cut1)) 
            setSequence(cut1[refConsts.getSequence_ndx()]);
        
	if (testIndex(refConsts.getModifications_ndx(), cut1))
	    setModifications(cut1[refConsts.getModifications_ndx()]);
	
	return true;
	
    }//--- End: fillData
    

    private boolean SignificanceRule(String[] data) {
	//System.out.println("Index: " + refConsts.getDpPositionalProbability_ndx());
	if (testIndex(refConsts.getDpPositionalProbability_ndx(), data)) {
	    String temp = data[refConsts.getDpPositionalProbability_ndx()];
	    if (temp == null || "".equals(temp)) {
		//System.out.println("Blank or null: " + temp);
		return true;
	    }
	    setDP_Positional_Probability(forceDouble(data, refConsts.getDpPositionalProbability_ndx()));

	    if (getDP_Positional_Probability() < 0.75) {
		//System.out.println("Lower: " + getDP_Positional_Probability());
		return true;
	    }
	}
	
	//System.out.println("----------================ SIGNIFICANT!!!");
	return false;
    }
    
    
    @Override
    public void run() {
	//System.out.println("============== GOT ONE!!! ===============");
	String[] cut1 = fullData.split(refConsts.getSplitChar());

	if (testIndex(refConsts.getRawFile_ndx(), cut1))
	    setRawFile(cut1[refConsts.getRawFile_ndx()]);

	if (testIndex(refConsts.getType_ndx(), cut1))
	    setType(cut1[refConsts.getType_ndx()]);

	if (testIndex(refConsts.getCharge_ndx(), cut1))
	    setCharge(forceInteger(cut1, refConsts.getCharge_ndx()));

	if (testIndex(refConsts.getMassCharge_ndx(), cut1))
	    setMassCharge(forceDouble(cut1, refConsts.getMassCharge_ndx()));

	if (testIndex(refConsts.getMass_ndx(), cut1))
	    setMass(forceDouble(cut1, refConsts.getMass_ndx()));

	if (testIndex(refConsts.getUncalibratedMZ_ndx(), cut1))
	    setUncalibratedMZ(forceDouble(cut1, refConsts.getUncalibratedMZ_ndx()));

	if (testIndex(refConsts.getResolution_ndx(), cut1))
	    setResolution(forceDouble(cut1, refConsts.getResolution_ndx()));

	if (testIndex(refConsts.getNDataPoints_ndx(), cut1))
	    setNDataPoints(forceInteger(cut1, refConsts.getNDataPoints_ndx()));

	if (testIndex(refConsts.getNScans_ndx(), cut1))
	    setNScans(forceInteger(cut1, refConsts.getNScans_ndx()));

	if (testIndex(refConsts.getMassFractional_ndx(), cut1))
	    setMassFractional(forceDouble(cut1, refConsts.getMassFractional_ndx()));

	if (testIndex(refConsts.getMassDeficit_ndx(), cut1))
	    setMassDeficit(forceDouble(cut1, refConsts.getMassDeficit_ndx()));

	if (testIndex(refConsts.getMassPrecision_ndx(), cut1))
	    setMassPrecision(forceDouble(cut1, refConsts.getMassPrecision_ndx()));

	if (testIndex(refConsts.getRetentionTime_ndx(), cut1))
	    setRetentionTime(forceDouble(cut1, refConsts.getRetentionTime_ndx()));

	if (testIndex(refConsts.getRetentionLength_ndx(), cut1))
	    setRetentionLength(forceDouble(cut1, refConsts.getRetentionLength_ndx()));

	if (testIndex(refConsts.getMinScanNumber_ndx(), cut1))
	    setMinScanNumber(forceInteger(cut1, refConsts.getMinScanNumber_ndx()));

	if (testIndex(refConsts.getMaxScanNumber_ndx(), cut1))
	    setMaxScanNumber(forceInteger(cut1, refConsts.getMaxScanNumber_ndx()));

	if (testIndex(refConsts.getMsmsIds_ndx(), cut1))
	    setMsmsIDs(forceInteger(cut1, refConsts.getMsmsIds_ndx()));

	if (testIndex(refConsts.getModifiedSequence_ndx(), cut1))
	    setModifiedSequence(cut1[refConsts.getModifiedSequence_ndx()]);

	if (testIndex(refConsts.getScore_ndx(), cut1))
	    setScore(forceDouble(cut1, refConsts.getScore_ndx()));

	if (testIndex(refConsts.getIntensity_ndx(), cut1))
	    setIntensity(forceDouble(cut1, refConsts.getIntensity_ndx()));

	if (testIndex(refConsts.getIntensities_ndx(), cut1)) {
	     String intens = cut1[refConsts.getIntensities_ndx()];
	     if (intens.length() > 0) {
		 String[] cut2 = intens.split(";");
		 for (int i = 0; i < cut2.length; i++) {
		     try {
			 intensities.add(new Double(cut2[i].replaceAll("\\s", "")));
		     } catch (Exception e) {
			 errorID = refConsts.getIntensities_ndx();
		     }
		 }
	     }
	}

	if (testIndex(refConsts.getMsmsCount_ndx(), cut1))
	    setMsmsCount(forceInteger(cut1, refConsts.getMsmsCount_ndx()));

	if (testIndex(refConsts.getMsmsScanNs_ndx(), cut1)) {
	     String intens = cut1[refConsts.getMsmsScanNs_ndx()];
	     if (intens.length() > 0) {
		 String[] cut2 = intens.split(";");
		 for (int i = 0; i < cut2.length; i++) {
		     try {
			 msmsScanNs.add(new Integer(cut2[i].replaceAll("\\s", "")));
		     } catch (Exception e) {
			 errorID = refConsts.getMsmsScanNs_ndx();
		     }
		 }
	     }
	}

	if (testIndex(refConsts.getMsmsIsotopeNdxs_ndx(), cut1)) {
	     String intens = cut1[refConsts.getMsmsIsotopeNdxs_ndx()];
	     if (intens.length() > 0) {
		 String[] cut2 = intens.split(";");
		 for (int i = 0; i < cut2.length; i++) {
		     try {
			 msmsIsotopesNdxs.add(new Integer(cut2[i].replaceAll("\\s", "")));
		     } catch (Exception e) {
			 errorID = refConsts.getMsmsIsotopeNdxs_ndx();
		     }
		 }
	     }
	}

	if (testIndex(refConsts.getDpMassDifference_ndx(), cut1))
	    setDpMassDifference(forceDouble(cut1, refConsts.getDpMassDifference_ndx()));

	if (testIndex(refConsts.getDpTimeDifference_ndx(), cut1))
	    setDpTimeDifference(forceDouble(cut1, refConsts.getDpTimeDifference_ndx()));

	if (testIndex(refConsts.getDpScore_ndx(), cut1))
	    setDpScore(forceDouble(cut1, refConsts.getDpScore_ndx()));

	if (testIndex(refConsts.getDpPep_ndx(), cut1))
	    setDpPep(forceDouble(cut1, refConsts.getDpPep_ndx()));

	if (testIndex(refConsts.getDpBaseSequence_ndx(), cut1))
	    setDpBaseSequence(cut1[refConsts.getDpBaseSequence_ndx()]);


	if (testIndex(refConsts.getDpProbabilities_ndx(), cut1)) {
	     String intens = cut1[refConsts.getDpProbabilities_ndx()];
	     if (intens.length() > 0) {
		 String[] cut2 = intens.replace(")", "@").split("@");
		 for (int i = 0; i < cut2.length; i++) {
		     try {
			 dpProbabilities.add(new DPProbability(cut2[i]));
		     } catch (Exception e) {
			 errorID = refConsts.getDpProbabilities_ndx();
		     }
		 }
	     }
	}
	
	if (testIndex(refConsts.getDpAA_ndx(), cut1)) {
	     String intens = cut1[refConsts.getDpAA_ndx()];
	     if (intens.length() > 0) {
		 String[] cut2 = intens.split(";");
		 for (int i = 0; i < cut2.length; i++) {
		     try {
			 dpAA.add(cut2[i]);
		     } catch (Exception e) {
			 errorID = refConsts.getDpAA_ndx();
		     }
		 }
	     }
	}
	

	if (testIndex(refConsts.getDpBaseScanNum_ndx(), cut1))
	    setDpBaseScanNum(forceInteger(cut1, refConsts.getDpBaseScanNum_ndx()));

	if (testIndex(refConsts.getDpModScanNum_ndx(), cut1))
	    setDpModScanNum(forceInteger(cut1, refConsts.getDpModScanNum_ndx()));

	if (testIndex(refConsts.getDpDecoy_ndx(), cut1))
	    setDpDecoy(forceInteger(cut1, refConsts.getDpDecoy_ndx()));


	if (testIndex(refConsts.getDpProteins_ndx(), cut1)) {
	     String prots = cut1[refConsts.getDpProteins_ndx()];
	     if (prots.length() > 0) {
		 String[] cut2 = prots.split(";");
		 for (int i = 0; i < cut2.length; i++) {
		     try {
			 dpProteins.add(new Protein(cut2[i]));
		     } catch (Exception e) {
			 errorID = refConsts.getDpProteins_ndx();
		     }
		 }
	     }
	}


	if (testIndex(refConsts.getDpClusterIndex_ndx(), cut1))
	    setDpClusterIndex(forceInteger(cut1, refConsts.getDpClusterIndex_ndx()));

	if (testIndex(refConsts.getDpClusterMass_ndx(), cut1))
	    setDpClusterMass(forceDouble(cut1, refConsts.getDpClusterMass_ndx()));

	if (testIndex(refConsts.getDpClusterMassSD_ndx(), cut1))
	    setDpClusterMassSD(forceDouble(cut1, refConsts.getDpClusterMassSD_ndx()));

	if (testIndex(refConsts.getDpClusterSizeTotal_ndx(), cut1))
	    setDpClusterSizeTotal(forceInteger(cut1, refConsts.getDpClusterSizeTotal_ndx()));

	if (testIndex(refConsts.getDpClusterSizeForward_ndx(), cut1))
	    setDpClusterSizeForward(forceInteger(cut1, refConsts.getDpClusterSizeForward_ndx()));

	if (testIndex(refConsts.getDpClusterSizeReverse_ndx(), cut1))
	    setDpClusterSizeReverse(forceInteger(cut1, refConsts.getDpClusterSizeReverse_ndx()));

	if (testIndex(refConsts.getDpModification_ndx(), cut1))
	    setDpModification(cut1[refConsts.getDpModification_ndx()]);

	if (testIndex(refConsts.getDpPepLengthDiff_ndx(), cut1))
	    setDpPepLengthDiff(forceInteger(cut1, refConsts.getDpPepLengthDiff_ndx()));

	if (testIndex(refConsts.getDpRatioMB_ndx(), cut1))
	    setDpRatioMB(forceDouble(cut1, refConsts.getDpRatioMB_ndx()));

	
    }//--- End: run
    
    
    public void unimodConnect() {
	
	int accession = uData.findAccessionByMass(dpMassDifference);
	if (accession >= 0) {
	    //System.out.println("Found Accession: " + accession);
	    unimodItem = uData.findDataByAccession(accession);
	} else {
	    //System.out.println("Accession NOT Found: " + dpMassDifference);
	}
	
    }//--- End: unimodConnect
    

    private Double forceDouble(String[] data, int ndx) {
	if (ndx >= data.length)
	    return 0.0;
	if ("NaN".equals(data[ndx]) || "".equals(data[ndx]))
	    return 0.0;
	
	try {
	    return Double.parseDouble(data[ndx]);
	} catch (Error e) {
	    errorID = ndx;
	    return 0.0;
	}
    }

    private int forceInteger(String[] data, int ndx) {
	if (ndx >= data.length)
	    return 0;
	if ("NaN".equals(data[ndx]) || "".equals(data[ndx]))
	    return 0;
	
	int ret = 0;
	try {
	    ret = Integer.parseInt(data[ndx]);
	} catch (Error e) {
	    errorID = ndx;
	    ret = 0;
	}
	return ret;
    }
    
    private boolean testIndex(int ndx, String[] data) {
	if (ndx < 0 || ndx >= data.length)
	    return false;
	
	return true;
    }

    private void clear() {
	fullData = "";
	
	for (Protein pt : proteins) {
	    pt.clear();
	    pt = null;
	    proteins.remove(pt);
	}
	
	proteins = null;
    }
    
    
    @Override
    public String toString() {
	if (fullData == null || fullData.length() <= 0)
	    return "";
	if (unimodItem == null || unimodItem.toString().length() <= 0)
	    return fullData + " - No UniMod data found";
	
	return fullData + " - " + unimodItem.toString();
    }
    
}