package br.com.gplab.analysis.mappings;

import org.json.JSONObject;

public class PepAnalysisConsts {

    private String splitChar = "\\t";
    public String getSplitChar() { return splitChar; }
    public void setSplitChar(String splitChar) { this.splitChar = splitChar; }
    

    private int rawFile_ndx = -1;			//0
    public int getRawFile_ndx() { return rawFile_ndx; }
    public void setRawFile_ndx(int rawFile_ndx) { this.rawFile_ndx = rawFile_ndx; }

    private int type_ndx = -1;				//1
    public int getType_ndx() { return type_ndx; }
    public void setType_ndx(int type_ndx) { this.type_ndx = type_ndx; }

    private int charge_ndx = -1;			//2
    public int getCharge_ndx() { return charge_ndx; }
    public void setCharge_ndx(int charge_ndx) { this.charge_ndx = charge_ndx; }

    private int massCharge_ndx = -1;			//3
    public int getMassCharge_ndx() { return massCharge_ndx; }
    public void setMassCharge_ndx(int massCharge_ndx) { this.massCharge_ndx = massCharge_ndx; }

    private int mass_ndx = -1;				//4
    public int getMass_ndx() { return mass_ndx; }
    public void setMass_ndx(int mass_ndx) { this.mass_ndx = mass_ndx; }

    private int uncalibratedMZ_ndx = -1;		//5
    public int getUncalibratedMZ_ndx() { return uncalibratedMZ_ndx; }
    public void setUncalibratedMZ_ndx(int uncalibratedMZ_ndx) { this.uncalibratedMZ_ndx = uncalibratedMZ_ndx; }

    private int resolution_ndx = -1;			//6
    public int getResolution_ndx() { return resolution_ndx; }
    public void setResolution_ndx(int resolution_ndx) { this.resolution_ndx = resolution_ndx; }

    private int nDataPoints_ndx = -1;			//7
    public int getNDataPoints_ndx() { return nDataPoints_ndx; }
    public void setNDataPoints_ndx(int nDataPoints_ndx) { this.nDataPoints_ndx = nDataPoints_ndx; }

    private int nScans_ndx = -1;			//8
    public int getNScans_ndx() { return nScans_ndx; }
    public void setNScans_ndx(int nDataPoints_ndx) { this.nDataPoints_ndx = nScans_ndx; }

    private int nIsotopicPeaks_ndx = -1;		//9
    public int getNIsotopicPeaks_ndx() { return nIsotopicPeaks_ndx; }
    public void setNIsotopicPeaks_ndx(int nIsotopicPeaks_ndx) { this.nIsotopicPeaks_ndx = nIsotopicPeaks_ndx; }

    private int massFractional_ndx = -1;		//11
    public int getMassFractional_ndx() { return massFractional_ndx; }
    public void setMassFractional_ndx(int massFractional_ndx) { this.massFractional_ndx = massFractional_ndx; }

    private int massDeficit_ndx = -1;			//12
    public int getMassDeficit_ndx() { return massDeficit_ndx; }
    public void setMassDeficit_ndx(int massDeficit_ndx) { this.massDeficit_ndx = massDeficit_ndx; }

    private int massPrecision_ndx = -1;			//13
    public int getMassPrecision_ndx() { return massPrecision_ndx; }
    public void setMassPrecision_ndx(int massPrecision_ndx) { this.massPrecision_ndx = massPrecision_ndx; }

    private int maxPrecision_ndx = -1;			//14
    public int getMaxPrecision_ndx() { return maxPrecision_ndx; }
    public void setMaxPrecision_ndx(int maxPrecision_ndx) { this.maxPrecision_ndx = maxPrecision_ndx; }

    private int retentionTime_ndx = -1;			//15
    public int getRetentionTime_ndx() { return retentionTime_ndx; }
    public void setRetentionTime_ndx(int retentionTime_ndx) { this.retentionTime_ndx = retentionTime_ndx; }

    private int retentionLength_ndx = -1;		//16
    public int getRetentionLength_ndx() { return retentionLength_ndx; }
    public void setRetentionLength_ndx(int retentionLength_ndx) { this.retentionLength_ndx = retentionLength_ndx; }

    private int minScanNumber_ndx = -1;			//18
    public int getMinScanNumber_ndx() { return minScanNumber_ndx; }
    public void setMinScanNumber_ndx(int minScanNumber_ndx) { this.minScanNumber_ndx = minScanNumber_ndx; }

    private int maxScanNumber_ndx = -1;			//19
    public int getMaxScanNumber_ndx() { return maxScanNumber_ndx; }
    public void setMaxScanNumber_ndx(int maxScanNumber_ndx) { this.maxScanNumber_ndx = maxScanNumber_ndx; }

    private int msmsIds_ndx= -1;			//21
    public int getMsmsIds_ndx() { return msmsIds_ndx; }
    public void setMsmsIds_ndx(int msmsIds_ndx) { this.msmsIds_ndx = msmsIds_ndx; }

    private int sequence_ndx= -1;			//22
    public int getSequence_ndx() { return sequence_ndx; }
    public void setSequence_ndx(int sequence_ndx) { this.sequence_ndx = sequence_ndx; }

    private int modifications_ndx= -1;			//24
    public int getModifications_ndx() { return modifications_ndx; }
    public void setModifications_ndx(int modifications_ndx) { this.modifications_ndx = modifications_ndx; }

    private int modifiedSequence_ndx = -1;		//25
    public int getModifiedSequence_ndx() { return modifiedSequence_ndx; }
    public void setModifiedSequence_ndx(int modifiedSequence_ndx) { this.modifiedSequence_ndx = modifiedSequence_ndx; }

    private int proteins_ndx = -1;			//26
    public int getProteins_ndx() { return proteins_ndx; }
    public void setProteins_ndx(int proteins_ndx) { this.proteins_ndx = proteins_ndx; }

    private int score_ndx = -1;				//27
    public int getScore_ndx() { return score_ndx; }
    public void setScore_ndx(int score_ndx) { this.score_ndx = score_ndx; }

    private int intensity_ndx = -1;			//28
    public int getIntensity_ndx() { return intensity_ndx; }
    public void setIntensity_ndx(int intensity_ndx) { this.intensity_ndx = intensity_ndx; }

    private int intensities_ndx = -1;			//29
    public int getIntensities_ndx() { return intensities_ndx; }
    public void setIntensities_ndx(int intensities_ndx) { this.intensities_ndx = intensities_ndx; }

    private int msmsCount_ndx = -1;			//30
    public int getMsmsCount_ndx() { return msmsCount_ndx; }
    public void setMsmsCount_ndx(int msmsCount_ndx) { this.msmsCount_ndx = msmsCount_ndx; }

    private int msmsScanNs_ndx = -1;			//31
    public int getMsmsScanNs_ndx() { return msmsScanNs_ndx; }
    public void setMsmsScanNs_ndx(int msmsScanNs_ndx) { this.msmsScanNs_ndx = msmsScanNs_ndx; }

    private int msmsIsotopeNdxs_ndx = -1;		//32
    public int getMsmsIsotopeNdxs_ndx() { return msmsIsotopeNdxs_ndx; }
    public void setMsmsIsotopeNdxs_ndx(int msmsIsotopeNdxs_ndx) { this.msmsIsotopeNdxs_ndx = msmsIsotopeNdxs_ndx; }

    private int dpMassDifference_ndx = -1;		//33
    public int getDpMassDifference_ndx() { return dpMassDifference_ndx; }
    public void setDpMassDifference_ndx(int dpMassDifference_ndx) { this.dpMassDifference_ndx = dpMassDifference_ndx; }

    private int dpTimeDifference_ndx = -1;		//34
    public int getDpTimeDifference_ndx() { return dpTimeDifference_ndx; }
    public void setDpTimeDifference_ndx(int dpTimeDifference_ndx) { this.dpTimeDifference_ndx = dpTimeDifference_ndx; }

    private int dpScore_ndx = -1;			//35
    public int getDpScore_ndx() { return dpScore_ndx; }
    public void setDpScore_ndx(int dpScore_ndx) { this.dpScore_ndx = dpScore_ndx; }

    private int dpPep_ndx = -1;				//36
    public int getDpPep_ndx() { return dpPep_ndx; }
    public void setDpPep_ndx(int dpPep_ndx) { this.dpPep_ndx = dpPep_ndx; }

    private int dpPositionalProbability_ndx = -1;	//37
    public int getDpPositionalProbability_ndx() { return dpPositionalProbability_ndx; }
    public void setDpPositionalProbability_ndx(int dpPositionalProbability_ndx) { this.dpPositionalProbability_ndx = dpPositionalProbability_ndx; }

    private int dpBaseSequence_ndx = -1;		//38
    public int getDpBaseSequence_ndx() { return dpBaseSequence_ndx; }
    public void setDpBaseSequence_ndx(int dpBaseSequence_ndx) { this.dpBaseSequence_ndx = dpBaseSequence_ndx; }

    private int dpProbabilities_ndx = -1;		//39
    public int getDpProbabilities_ndx() { return dpProbabilities_ndx; }
    public void setDpProbabilities_ndx(int dpProbabilities_ndx) { this.dpProbabilities_ndx = dpProbabilities_ndx; }

    private int dpAA_ndx = -1;				//40
    public int getDpAA_ndx() { return dpAA_ndx; }
    public void setDpAA_ndx(int dpAA_ndx) { this.dpAA_ndx = dpAA_ndx; }

    private int dpBaseScanNum_ndx = -1;			//41
    public int getDpBaseScanNum_ndx() { return dpBaseScanNum_ndx; }
    public void setDpBaseScanNum_ndx(int dpBaseScanNum_ndx) { this.dpBaseScanNum_ndx = dpBaseScanNum_ndx; }

    private int dpModScanNum_ndx = -1;			//42
    public int getDpModScanNum_ndx() { return dpModScanNum_ndx; }
    public void setDpModScanNum_ndx(int dpModScanNum_ndx) { this.dpModScanNum_ndx = dpModScanNum_ndx; }

    private int dpDecoy_ndx = -1;			//43
    public int getDpDecoy_ndx() { return dpDecoy_ndx; }
    public void setDpDecoy_ndx(int dpDecoy_ndx) { this.dpDecoy_ndx = dpDecoy_ndx; }

    private int dpProteins_ndx = -1;			//44
    public int getDpProteins_ndx() { return dpProteins_ndx; }
    public void setDpProteins_ndx(int dpProteins_ndx) { this.dpProteins_ndx = dpProteins_ndx; }

    private int dpClusterIndex_ndx = -1;		//45
    public int getDpClusterIndex_ndx() { return dpClusterIndex_ndx; }
    public void setDpClusterIndex_ndx(int dpClusterIndex_ndx) { this.dpClusterIndex_ndx = dpClusterIndex_ndx; }

    private int dpClusterMass_ndx = -1;			//46
    public int getDpClusterMass_ndx() { return dpClusterMass_ndx; }
    public void setDpClusterMass_ndx(int dpClusterMass_ndx) { this.dpClusterMass_ndx = dpClusterMass_ndx; }

    private int dpClusterMassSD_ndx = -1;		//47
    public int getDpClusterMassSD_ndx() { return dpClusterMassSD_ndx; }
    public void setDpClusterMassSD_ndx(int dpClusterMassSD_ndx) { this.dpClusterMassSD_ndx = dpClusterMassSD_ndx; }

    private int dpClusterSizeTotal_ndx = -1;		//48
    public int getDpClusterSizeTotal_ndx() { return dpClusterSizeTotal_ndx; }
    public void setDpClusterSizeTotal_ndx(int dpClusterSizeTotal_ndx) { this.dpClusterSizeTotal_ndx = dpClusterSizeTotal_ndx; }

    private int dpClusterSizeForward_ndx = -1;		//49
    public int getDpClusterSizeForward_ndx() { return dpClusterSizeForward_ndx; }
    public void setDpClusterSizeForward_ndx(int dpClusterSizeForward_ndx) { this.dpClusterSizeForward_ndx = dpClusterSizeForward_ndx; }

    private int dpClusterSizeReverse_ndx = -1;		//50
    public int getDpClusterSizeReverse_ndx() { return dpClusterSizeReverse_ndx; }
    public void setDpClusterSizeReverse_ndx(int dpClusterSizeReverse_ndx) { this.dpClusterSizeReverse_ndx = dpClusterSizeReverse_ndx; }

    private int dpModification_ndx = -1;		//51
    public int getDpModification_ndx() { return dpModification_ndx; }
    public void setDpModification_ndx(int dpModification_ndx) { this.dpModification_ndx = dpModification_ndx; }

    private int dpPepLengthDiff_ndx = -1;		//52
    public int getDpPepLengthDiff_ndx() { return dpPepLengthDiff_ndx; }
    public void setDpPepLengthDiff_ndx(int dpPepLengthDiff_ndx) { this.dpPepLengthDiff_ndx = dpPepLengthDiff_ndx; }

    private int dpRatioMB_ndx = -1;			//53
    public int getDpRatioMB_ndx() { return dpRatioMB_ndx; }
    public void setDpRatioMB_ndx(int dpRatioMB_ndx) { this.dpRatioMB_ndx = dpRatioMB_ndx; }
    
    

    public void ConfigureApplication(JSONObject payload) {
	if (payload.has("splitChar"))
	    setSplitChar(payload.getString("splitChar"));
	
	
	if (payload.has("rawFile_ndx"))
	    setRawFile_ndx(payload.getInt("rawFile_ndx"));
	
	if (payload.has("type_ndx"))
	    setType_ndx(payload.getInt("type_ndx"));

	if (payload.has("charge_ndx"))
	    setCharge_ndx(payload.getInt("charge_ndx"));

	if (payload.has("massCharge_ndx"))
	    setMassCharge_ndx(payload.getInt("massCharge_ndx"));

	if (payload.has("mass_ndx"))
	    setMass_ndx(payload.getInt("mass_ndx"));

	if (payload.has("uncalibratedMZ_ndx"))
	    setUncalibratedMZ_ndx(payload.getInt("uncalibratedMZ_ndx"));

	if (payload.has("resolution_ndx"))
	    setResolution_ndx(payload.getInt("resolution_ndx"));

	if (payload.has("nDataPoints_ndx"))
	    setNDataPoints_ndx(payload.getInt("nDataPoints_ndx"));

	if (payload.has("nScans_ndx"))
	    setNScans_ndx(payload.getInt("nScans_ndx"));

	if (payload.has("nIsotopicPeaks_ndx"))
	    setNIsotopicPeaks_ndx(payload.getInt("nIsotopicPeaks_ndx"));

	if (payload.has("massFractional_ndx"))
	    setMassFractional_ndx(payload.getInt("massFractional_ndx"));

	if (payload.has("massDeficit_ndx"))
	    setMassDeficit_ndx(payload.getInt("massDeficit_ndx"));

	if (payload.has("massPrecision_ndx"))
	    setMassPrecision_ndx(payload.getInt("massPrecision_ndx"));

	if (payload.has("maxPrecision_ndx"))
	    setMaxPrecision_ndx(payload.getInt("maxPrecision_ndx"));

	if (payload.has("retentionTime_ndx"))
	    setRetentionTime_ndx(payload.getInt("retentionTime_ndx"));

	if (payload.has("retentionLength_ndx"))
	    setRetentionLength_ndx(payload.getInt("retentionLength_ndx"));

	if (payload.has("minScanNumber_ndx"))
	    setMinScanNumber_ndx(payload.getInt("minScanNumber_ndx"));

	if (payload.has("maxScanNumber_ndx"))
	    setMaxScanNumber_ndx(payload.getInt("maxScanNumber_ndx"));

	if (payload.has("msmsIds_ndx"))
	    setMsmsIds_ndx(payload.getInt("msmsIds_ndx"));

	if (payload.has("sequence_ndx"))
	    setSequence_ndx(payload.getInt("sequence_ndx"));

	if (payload.has("modifications_ndx"))
	    setModifications_ndx(payload.getInt("modifications_ndx"));

	if (payload.has("modifiedSequence_ndx"))
	    setModifiedSequence_ndx(payload.getInt("modifiedSequence_ndx"));

	if (payload.has("proteins_ndx"))
	    setProteins_ndx(payload.getInt("proteins_ndx"));

	if (payload.has("score_ndx"))
	    setScore_ndx(payload.getInt("score_ndx"));

	if (payload.has("intensity_ndx"))
	    setIntensity_ndx(payload.getInt("intensity_ndx"));

	if (payload.has("intensities_ndx"))
	    setIntensities_ndx(payload.getInt("intensities_ndx"));

	if (payload.has("msmsCount_ndx"))
	    setMsmsCount_ndx(payload.getInt("msmsCount_ndx"));

	if (payload.has("msmsScanNs_ndx"))
	    setMsmsScanNs_ndx(payload.getInt("msmsScanNs_ndx"));

	if (payload.has("msmsIsotopeNdxs_ndx"))
	    setMsmsIsotopeNdxs_ndx(payload.getInt("msmsIsotopeNdxs_ndx"));

	if (payload.has("dpMassDifference_ndx"))
	    setDpMassDifference_ndx(payload.getInt("dpMassDifference_ndx"));

	if (payload.has("dpTimeDifference_ndx"))
	    setDpTimeDifference_ndx(payload.getInt("dpTimeDifference_ndx"));

	if (payload.has("dpScore_ndx"))
	    setDpScore_ndx(payload.getInt("dpScore_ndx"));

	if (payload.has("dpPep_ndx"))
	    setDpPep_ndx(payload.getInt("dpPep_ndx"));

	if (payload.has("dpPositionalProbability_ndx"))
	    setDpPositionalProbability_ndx(payload.getInt("dpPositionalProbability_ndx"));

	if (payload.has("dpBaseSequence_ndx"))
	    setDpBaseSequence_ndx(payload.getInt("dpBaseSequence_ndx"));

	if (payload.has("dpProbabilities_ndx"))
	    setDpProbabilities_ndx(payload.getInt("dpProbabilities_ndx"));

	if (payload.has("dpAA_ndx"))
	    setDpAA_ndx(payload.getInt("dpAA_ndx"));

	if (payload.has("dpBaseScanNum_ndx"))
	    setDpBaseScanNum_ndx(payload.getInt("dpBaseScanNum_ndx"));

	if (payload.has("dpModScanNum_ndx"))
	    setDpModScanNum_ndx(payload.getInt("dpModScanNum_ndx"));

	if (payload.has("dpDecoy_ndx"))
	    setDpDecoy_ndx(payload.getInt("dpDecoy_ndx"));

	if (payload.has("dpProteins_ndx"))
	    setDpProteins_ndx(payload.getInt("dpProteins_ndx"));

	if (payload.has("dpClusterIndex_ndx"))
	    setDpClusterIndex_ndx(payload.getInt("dpClusterIndex_ndx"));

	if (payload.has("dpClusterMass_ndx"))
	    setDpClusterMass_ndx(payload.getInt("dpClusterMass_ndx"));

	if (payload.has("dpClusterMassSD_ndx"))
	    setDpClusterMassSD_ndx(payload.getInt("dpClusterMassSD_ndx"));

	if (payload.has("dpClusterSizeTotal_ndx"))
	    setDpClusterSizeTotal_ndx(payload.getInt("dpClusterSizeTotal_ndx"));

	if (payload.has("dpClusterSizeForward_ndx"))
	    setDpClusterSizeForward_ndx(payload.getInt("dpClusterSizeForward_ndx"));

	if (payload.has("dpClusterSizeReverse_ndx"))
	    setDpClusterSizeReverse_ndx(payload.getInt("dpClusterSizeReverse_ndx"));

	if (payload.has("dpModification_ndx"))
	    setDpModification_ndx(payload.getInt("dpModification_ndx"));

	if (payload.has("dpPepLengthDiff_ndx"))
	    setDpPepLengthDiff_ndx(payload.getInt("dpPepLengthDiff_ndx"));

	if (payload.has("dpRatioMB_ndx"))
	    setDpRatioMB_ndx(payload.getInt("dpRatioMB_ndx"));
	
    }//--- End: ConfigureApplication (JSONObject)
    
    

    public void ConfigureApplication(PepAnalysisConsts payload) {
	if (payload.getSplitChar().length() > 0)
	    setSplitChar(payload.getSplitChar());
	
	
	if (payload.getRawFile_ndx() >= 0)
	    setRawFile_ndx(payload.getRawFile_ndx());
	
	if (payload.getType_ndx() >= 0)
	    setType_ndx(payload.getType_ndx());

	if (payload.getCharge_ndx() >= 0)
	    setCharge_ndx(payload.getCharge_ndx());

	if (payload.getMassCharge_ndx() >= 0)
	    setMassCharge_ndx(payload.getMassCharge_ndx());

	if (payload.getMass_ndx() >= 0)
	    setMass_ndx(payload.getMass_ndx());

	if (payload.getUncalibratedMZ_ndx() >= 0)
	    setUncalibratedMZ_ndx(payload.getUncalibratedMZ_ndx());

	if (payload.getResolution_ndx() >= 0)
	    setResolution_ndx(payload.getResolution_ndx());

	if (payload.getNDataPoints_ndx() >= 0)
	    setNDataPoints_ndx(payload.getNDataPoints_ndx());

	if (payload.getNScans_ndx() >= 0)
	    setNScans_ndx(payload.getNScans_ndx());

	if (payload.getNIsotopicPeaks_ndx() >= 0)
	    setNIsotopicPeaks_ndx(payload.getNIsotopicPeaks_ndx());

	if (payload.getMassFractional_ndx() >= 0)
	    setMassFractional_ndx(payload.getMassFractional_ndx());

	if (payload.getMassDeficit_ndx() >= 0)
	    setMassDeficit_ndx(payload.getMassDeficit_ndx());

	if (payload.getMassPrecision_ndx() >= 0)
	    setMassPrecision_ndx(payload.getMassPrecision_ndx());

	if (payload.getMaxPrecision_ndx() >= 0)
	    setMaxPrecision_ndx(payload.getMaxPrecision_ndx());

	if (payload.getRetentionTime_ndx() >= 0)
	    setRetentionTime_ndx(payload.getRetentionTime_ndx());

	if (payload.getRetentionLength_ndx() >= 0)
	    setRetentionLength_ndx(payload.getRetentionLength_ndx());

	if (payload.getMinScanNumber_ndx() >= 0)
	    setMinScanNumber_ndx(payload.getMinScanNumber_ndx());

	if (payload.getMaxScanNumber_ndx() >= 0)
	    setMaxScanNumber_ndx(payload.getMaxScanNumber_ndx());

	if (payload.getMsmsIds_ndx() >= 0)
	    setMsmsIds_ndx(payload.getMsmsIds_ndx());

	if (payload.getSequence_ndx() >= 0)
	    setSequence_ndx(payload.getSequence_ndx());

	if (payload.getModifications_ndx() >= 0)
	    setModifications_ndx(payload.getModifications_ndx());

	if (payload.getModifiedSequence_ndx() >= 0)
	    setModifiedSequence_ndx(payload.getModifiedSequence_ndx());

	if (payload.getProteins_ndx() >= 0)
	    setProteins_ndx(payload.getProteins_ndx());

	if (payload.getScore_ndx() >= 0)
	    setScore_ndx(payload.getScore_ndx());

	if (payload.getIntensity_ndx() >= 0)
	    setIntensity_ndx(payload.getIntensity_ndx());

	if (payload.getIntensities_ndx() >= 0)
	    setIntensities_ndx(payload.getIntensities_ndx());

	if (payload.getMsmsCount_ndx() >= 0)
	    setMsmsCount_ndx(payload.getMsmsCount_ndx());

	if (payload.getMsmsScanNs_ndx() >= 0)
	    setMsmsScanNs_ndx(payload.getMsmsScanNs_ndx());

	if (payload.getMsmsIsotopeNdxs_ndx() >= 0)
	    setMsmsIsotopeNdxs_ndx(payload.getMsmsIsotopeNdxs_ndx());

	if (payload.getDpMassDifference_ndx() >= 0)
	    setDpMassDifference_ndx(payload.getDpMassDifference_ndx());

	if (payload.getDpTimeDifference_ndx() >= 0)
	    setDpTimeDifference_ndx(payload.getDpTimeDifference_ndx());

	if (payload.getDpScore_ndx() >= 0)
	    setDpScore_ndx(payload.getDpScore_ndx());

	if (payload.getDpPep_ndx() >= 0)
	    setDpPep_ndx(payload.getDpPep_ndx());

	if (payload.getDpPositionalProbability_ndx() >= 0)
	    setDpPositionalProbability_ndx(payload.getDpPositionalProbability_ndx());

	if (payload.getDpBaseSequence_ndx() >= 0)
	    setDpBaseSequence_ndx(payload.getDpBaseSequence_ndx());

	if (payload.getDpProbabilities_ndx() >= 0)
	    setDpProbabilities_ndx(payload.getDpProbabilities_ndx());

	if (payload.getDpAA_ndx() >= 0)
	    setDpAA_ndx(payload.getDpAA_ndx());

	if (payload.getDpBaseScanNum_ndx() >= 0)
	    setDpBaseScanNum_ndx(payload.getDpBaseScanNum_ndx());

	if (payload.getDpModScanNum_ndx() >= 0)
	    setDpModScanNum_ndx(payload.getDpModScanNum_ndx());

	if (payload.getDpDecoy_ndx() >= 0)
	    setDpDecoy_ndx(payload.getDpDecoy_ndx());

	if (payload.getDpProteins_ndx() >= 0)
	    setDpProteins_ndx(payload.getDpProteins_ndx());

	if (payload.getDpClusterIndex_ndx() >= 0)
	    setDpClusterIndex_ndx(payload.getDpClusterIndex_ndx());

	if (payload.getDpClusterMass_ndx() >= 0)
	    setDpClusterMass_ndx(payload.getDpClusterMass_ndx());

	if (payload.getDpClusterMassSD_ndx() >= 0)
	    setDpClusterMassSD_ndx(payload.getDpClusterMassSD_ndx());

	if (payload.getDpClusterSizeTotal_ndx() >= 0)
	    setDpClusterSizeTotal_ndx(payload.getDpClusterSizeTotal_ndx());

	if (payload.getDpClusterSizeForward_ndx() >= 0)
	    setDpClusterSizeForward_ndx(payload.getDpClusterSizeForward_ndx());

	if (payload.getDpClusterSizeReverse_ndx() >= 0)
	    setDpClusterSizeReverse_ndx(payload.getDpClusterSizeReverse_ndx());

	if (payload.getDpModification_ndx() >= 0)
	    setDpModification_ndx(payload.getDpModification_ndx());

	if (payload.getDpPepLengthDiff_ndx() >= 0)
	    setDpPepLengthDiff_ndx(payload.getDpPepLengthDiff_ndx());

	if (payload.getDpRatioMB_ndx() >= 0)
	    setDpRatioMB_ndx(payload.getDpRatioMB_ndx());
	
    }//--- End: ConfigureApplication (AnalysisConsts)

    
    public void SetDefaults() {
	setSplitChar("\\t");
	setRawFile_ndx(0);
	setType_ndx(1);
	setCharge_ndx(2);
	setMassCharge_ndx(3);
	setMass_ndx(4);
	setUncalibratedMZ_ndx(5);
	setResolution_ndx(6);
	setNDataPoints_ndx(7);
	setNScans_ndx(8);
	setNIsotopicPeaks_ndx(9);
	setMassFractional_ndx(11);
	setMassDeficit_ndx(12);
	setMassPrecision_ndx(13);
	setMaxPrecision_ndx(14);
	setRetentionTime_ndx(15);
	setRetentionLength_ndx(16);
	setMinScanNumber_ndx(18);
	setMaxScanNumber_ndx(19);
	setMsmsIds_ndx(21);
	setSequence_ndx(22);
	setModifications_ndx(24);
	setModifiedSequence_ndx(25);
	setProteins_ndx(26);
	setScore_ndx(27);
	setIntensity_ndx(28);
	setIntensities_ndx(29);
	setMsmsCount_ndx(30);
	setMsmsScanNs_ndx(31);
	setMsmsIsotopeNdxs_ndx(32);
	setDpMassDifference_ndx(33);
	setDpTimeDifference_ndx(34);
	setDpScore_ndx(35);
	setDpPep_ndx(36);
	setDpPositionalProbability_ndx(37);
	setDpBaseSequence_ndx(38);
	setDpProbabilities_ndx(39);
	setDpAA_ndx(40);
	setDpBaseScanNum_ndx(41);
	setDpModScanNum_ndx(42);
	setDpDecoy_ndx(43);
	setDpProteins_ndx(44);
	setDpClusterIndex_ndx(45);
	setDpClusterMass_ndx(46);
	setDpClusterMassSD_ndx(47);
	setDpClusterSizeTotal_ndx(48);
	setDpClusterSizeForward_ndx(49);
	setDpClusterSizeReverse_ndx(50);
	setDpModification_ndx(51);
	setDpPepLengthDiff_ndx(52);
	setDpRatioMB_ndx(53);
	
    }//--- End: SetDefaults
    
}