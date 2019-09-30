package br.com.gplab.analysis.mappings;

import org.json.JSONObject;

public class GPAnalysisConsts {
    
    private String splitChar = ",";
    public String getSplitChar() { return splitChar; }
    public void setSplitChar(String splitChar) { this.splitChar = splitChar; }
    
    
    private int pID_ndx = -1;
    public int getPID_ndx() { return pID_ndx; }
    public void setPID_ndx(int pID_ndx) { this.pID_ndx = pID_ndx; }
    
    private int proteinRank_ndx = -1;
    public int getProteinRank_ndx() { return proteinRank_ndx; }
    public void setProteinRank_ndx(int proteinRank_ndx) { this.proteinRank_ndx = proteinRank_ndx; }
    
    private int pos_ndx = -1;
    public int getPos_ndx() { return pos_ndx; }
    public void setPos_ndx(int pos_ndx) { this.pos_ndx = pos_ndx; }
    
    private int sequence_ndx = -1;
    public int getSequence_ndx() { return sequence_ndx; }
    public void setSequence_ndx(int sequence_ndx) { this.sequence_ndx = sequence_ndx; }
    
    private int modifications_ndx = -1;
    public int getModifications_ndx() { return modifications_ndx; }
    public void setModifications_ndx(int modifications_ndx) { this.modifications_ndx = modifications_ndx; }
    
    private int glycans_ndx = -1;
    public int getGlycans_ndx() { return glycans_ndx; }
    public void setGlycans_ndx(int glycans_ndx) { this.glycans_ndx = glycans_ndx; }
    
    private int pep2D_ndx = -1;
    public int getPep2D_ndx() { return pep2D_ndx; }
    public void setPep2D_ndx(int pep2d_ndx) { pep2D_ndx = pep2d_ndx; }
    
    private int pep1D_ndx = -1;
    public int getPep1D_ndx() { return pep1D_ndx; }
    public void setPep1D_ndx(int pep1d_ndx) { pep1D_ndx = pep1d_ndx; }
    
    private int fdr2D_ndx = -1;
    public int getFdr2D_ndx() { return fdr2D_ndx; }
    public void setFdr2D_ndx(int fdr2d_ndx) { fdr2D_ndx = fdr2d_ndx; }
    
    private int fdr1D_ndx = -1;
    public int getFdr1D_ndx() { return fdr1D_ndx; }
    public void setFdr1D_ndx(int fdr1d_ndx) { fdr1D_ndx = fdr1d_ndx; }
    
    private int fdrUnique2D_ndx = -1;
    public int getFdrUnique2D_ndx() { return fdrUnique2D_ndx; }
    public void setFdrUnique2D_ndx(int fdrUnique2D_ndx) { this.fdrUnique2D_ndx = fdrUnique2D_ndx; }
    
    private int fdrUnique1D_ndx = -1;
    public int getFdrUnique1D_ndx() { return fdrUnique1D_ndx; }
    public void setFdrUnique1D_ndx(int fdrUnique1D_ndx) { this.fdrUnique1D_ndx = fdrUnique1D_ndx; }

    private int qValue2D_ndx = -1;
    public int getqValue2D_ndx() { return qValue2D_ndx; }
    public void setqValue2D_ndx(int qValue2D_ndx) { this.qValue2D_ndx = qValue2D_ndx; }

    private int qValue1D_ndx = -1;
    public int getqValue1D_ndx() { return qValue1D_ndx; }
    public void setqValue1D_ndx(int qValue1D_ndx) { this.qValue1D_ndx = qValue1D_ndx; }

    private int logProb_ndx = -1;
    public int getLogProb_ndx() { return logProb_ndx; }
    public void setLogProb_ndx(int logProb_ndx) { this.logProb_ndx = logProb_ndx; }

    private int score_ndx = -1;
    public int getScore_ndx() { return score_ndx; }
    public void setScore_ndx(int score_ndx) { this.score_ndx = score_ndx; }

    private int deltaScore_ndx = -1;
    public int getDeltaScore_ndx() { return deltaScore_ndx; }
    public void setDeltaScore_ndx(int deltaScore_ndx) { this.deltaScore_ndx = deltaScore_ndx; }

    private int deltaModScore_ndx = -1;
    public int getDeltaModScore_ndx() { return deltaModScore_ndx; }
    public void setDeltaModScore_ndx(int deltaModScore_ndx) { this.deltaModScore_ndx = deltaModScore_ndx; }

    private int zCharge_ndx = -1;
    public int getzCharge_ndx() { return zCharge_ndx; }
    public void setzCharge_ndx(int zCharge_ndx) { this.zCharge_ndx = zCharge_ndx; }

    private int obsMz_ndx = -1;
    public int getObsMz_ndx() { return obsMz_ndx; }
    public void setObsMz_ndx(int obsMz_ndx) { this.obsMz_ndx = obsMz_ndx; }

    private int calcMz_ndx = -1;
    public int getCalcMz_ndx() { return calcMz_ndx; }
    public void setCalcMz_ndx(int calcMz_ndx) { this.calcMz_ndx = calcMz_ndx; }

    private int ppmErr_ndx = -1;
    public int getPpmErr_ndx() { return ppmErr_ndx; }
    public void setPpmErr_ndx(int ppmErr_ndx) { this.ppmErr_ndx = ppmErr_ndx; }

    private int proteinName_ndx = -1;
    public int getProteinName_ndx() { return proteinName_ndx; }
    public void setProteinName_ndx(int proteinName_ndx) { this.proteinName_ndx = proteinName_ndx; }

    private int proteinID_ndx = -1;
    public int getProteinID_ndx() { return proteinID_ndx; }
    public void setProteinID_ndx(int proteinID_ndx) { this.proteinID_ndx = proteinID_ndx; }

    private int scanTime_ndx = -1;
    public int getScanTime_ndx() { return scanTime_ndx; }
    public void setScanTime_ndx(int scanTime_ndx) { this.scanTime_ndx = scanTime_ndx; }

    private int scanNumber_ndx = -1;
    public int getScanNumber_ndx() { return scanNumber_ndx; }
    public void setScanNumber_ndx(int scanNumber_ndx) { this.scanNumber_ndx = scanNumber_ndx; }
    
    private int modsFixed_ndx = -1;
    public int getModsFixed_ndx() { return modsFixed_ndx; }
    public void setModsFixed_ndx(int modsFixed_ndx) { this.modsFixed_ndx = modsFixed_ndx; }

    

    private double pep2D_sig = 0;
    public double getPep2D_sig() { return pep2D_sig; }
    public void setPep2D_sig(double pep2D_sig) { this.pep2D_sig = pep2D_sig; }

    private double logProb_sig = 0;
    public double getLogProb_sig() { return logProb_sig; }
    public void setLogProb_sig(double logProb_sig) { this.logProb_sig = logProb_sig; }

    private double score_sig = 0;
    public double getScore_sig() { return score_sig; }
    public void setScore_sig(double score_sig) { this.score_sig = score_sig; }


    public void ConfigureApplication(JSONObject payload) {
	if (payload.has("splitChar"))
	    setSplitChar(payload.getString("splitChar"));
	
	
	if (payload.has("pID_ndx"))
	    setPID_ndx(payload.getInt("pID_ndx"));

	if (payload.has("proteinRank_ndx"))
	    setProteinRank_ndx(payload.getInt("proteinRank_ndx"));

	if (payload.has("pos_ndx"))
	    setPos_ndx(payload.getInt("pos_ndx"));

	if (payload.has("sequence_ndx"))
	    setSequence_ndx(payload.getInt("sequence_ndx"));

	if (payload.has("modifications_ndx"))
	    setModifications_ndx(payload.getInt("modifications_ndx"));

	if (payload.has("glycans_ndx"))
	    setGlycans_ndx(payload.getInt("glycans_ndx"));

	if (payload.has("pep2D_ndx"))
	    setPep2D_ndx(payload.getInt("pep2D_ndx"));

	if (payload.has("pep1D_ndx"))
	    setPep1D_ndx(payload.getInt("pep1D_ndx"));

	if (payload.has("fdr2D_ndx"))
	    setFdr2D_ndx(payload.getInt("fdr2D_ndx"));

	if (payload.has("fdr1D_ndx"))
	    setFdr1D_ndx(payload.getInt("fdr1D_ndx"));

	if (payload.has("fdrUnique2D_ndx"))
	    setFdrUnique2D_ndx(payload.getInt("fdrUnique2D_ndx"));

	if (payload.has("fdrUnique1D_ndx"))
	    setFdrUnique1D_ndx(payload.getInt("fdrUnique1D_ndx"));

	if (payload.has("qValue2D_ndx"))
	    setqValue2D_ndx(payload.getInt("qValue2D_ndx"));

	if (payload.has("qValue1D_ndx"))
	    setqValue1D_ndx(payload.getInt("qValue1D_ndx"));

	if (payload.has("logProb_ndx"))
	    setLogProb_ndx(payload.getInt("logProb_ndx"));

	if (payload.has("score_ndx"))
	    setScore_ndx(payload.getInt("score_ndx"));

	if (payload.has("deltaScore_ndx"))
	    setDeltaScore_ndx(payload.getInt("deltaScore_ndx"));

	if (payload.has("deltaModScore_ndx"))
	    setDeltaModScore_ndx(payload.getInt("deltaModScore_ndx"));

	if (payload.has("zCharge_ndx"))
	    setzCharge_ndx(payload.getInt("zCharge_ndx"));

	if (payload.has("obsMz_ndx"))
	    setObsMz_ndx(payload.getInt("obsMz_ndx"));

	if (payload.has("calcMz_ndx"))
	    setCalcMz_ndx(payload.getInt("calcMz_ndx"));

	if (payload.has("ppmErr_ndx"))
	    setPpmErr_ndx(payload.getInt("ppmErr_ndx"));

	if (payload.has("proteinName_ndx"))
	    setProteinName_ndx(payload.getInt("proteinName_ndx"));

	if (payload.has("proteinID_ndx"))
	    setProteinID_ndx(payload.getInt("proteinID_ndx"));

	if (payload.has("scanTime_ndx"))
	    setScanTime_ndx(payload.getInt("scanTime_ndx"));

	if (payload.has("scanNumber_ndx"))
	    setScanNumber_ndx(payload.getInt("scanNumber_ndx"));

	if (payload.has("modsFixed_ndx"))
	    setModsFixed_ndx(payload.getInt("modsFixed_ndx"));
	
    }//--- End: ConfigureApplication (JSONObject)
    
    

    public void ConfigureApplication(GPAnalysisConsts payload) {
	if (payload.getSplitChar().length() > 0)
	    setSplitChar(payload.getSplitChar());
	
	
	if (payload.getPID_ndx() >= 0)
	    setPID_ndx(payload.getPID_ndx());

	if (payload.getProteinRank_ndx() >= 0)
	    setProteinRank_ndx(payload.getProteinRank_ndx());

	if (payload.getPos_ndx() >= 0)
	    setPos_ndx(payload.getPos_ndx());

	if (payload.getSequence_ndx() >= 0)
	    setSequence_ndx(payload.getSequence_ndx());

	if (payload.getModifications_ndx() >= 0)
	    setModifications_ndx(payload.getModifications_ndx());

	if (payload.getGlycans_ndx() >= 0)
	    setGlycans_ndx(payload.getGlycans_ndx());

	if (payload.getPep2D_ndx() >= 0)
	    setPep2D_ndx(payload.getPep2D_ndx());

	if (payload.getPep1D_ndx() >= 0)
	    setPep1D_ndx(payload.getPep1D_ndx());

	if (payload.getFdr2D_ndx() >= 0)
	    setFdr2D_ndx(payload.getFdr2D_ndx());

	if (payload.getFdr1D_ndx() >= 0)
	    setFdr1D_ndx(payload.getFdr1D_ndx());

	if (payload.getFdrUnique2D_ndx() >= 0)
	    setFdrUnique2D_ndx(payload.getFdrUnique2D_ndx());

	if (payload.getFdrUnique1D_ndx() >= 0)
	    setFdrUnique1D_ndx(payload.getFdrUnique1D_ndx());

	if (payload.getqValue2D_ndx() >= 0)
	    setqValue2D_ndx(payload.getqValue2D_ndx());

	if (payload.getqValue1D_ndx() >= 0)
	    setqValue1D_ndx(payload.getqValue1D_ndx());

	if (payload.getLogProb_ndx() >= 0)
	    setLogProb_ndx(payload.getLogProb_ndx());

	if (payload.getScore_ndx() >= 0)
	    setScore_ndx(payload.getScore_ndx());

	if (payload.getDeltaScore_ndx() >= 0)
	    setDeltaScore_ndx(payload.getDeltaScore_ndx());

	if (payload.getDeltaModScore_ndx() >= 0)
	    setDeltaModScore_ndx(payload.getDeltaModScore_ndx());

	if (payload.getzCharge_ndx() >= 0)
	    setzCharge_ndx(payload.getzCharge_ndx());

	if (payload.getObsMz_ndx() >= 0)
	    setObsMz_ndx(payload.getObsMz_ndx());

	if (payload.getCalcMz_ndx() >= 0)
	    setCalcMz_ndx(payload.getCalcMz_ndx());

	if (payload.getPpmErr_ndx() >= 0)
	    setPpmErr_ndx(payload.getPpmErr_ndx());

	if (payload.getProteinName_ndx() >= 0)
	    setProteinName_ndx(payload.getProteinName_ndx());

	if (payload.getProteinID_ndx() >= 0)
	    setProteinID_ndx(payload.getProteinID_ndx());

	if (payload.getScanTime_ndx() >= 0)
	    setScanTime_ndx(payload.getScanTime_ndx());

	if (payload.getScanNumber_ndx() >= 0)
	    setScanNumber_ndx(payload.getScanNumber_ndx());

	if (payload.getModsFixed_ndx() >= 0)
	    setModsFixed_ndx(payload.getModsFixed_ndx());
	
    }//--- End: ConfigureApplication (AnalysisConsts)

    
    public void SetDefaults() {
	setSplitChar(",");
	setPID_ndx(0);
	setProteinRank_ndx(1);
	setPos_ndx(2);
	setSequence_ndx(3);
	setModifications_ndx(4);
	setGlycans_ndx(5);
	setPep2D_ndx(6);
	setPep1D_ndx(7);
	setFdr2D_ndx(8);
	setFdr1D_ndx(9);
	setFdrUnique2D_ndx(10);
	setFdrUnique1D_ndx(11);
	setqValue2D_ndx(12);
	setqValue1D_ndx(13);
	setLogProb_ndx(14);
	setScore_ndx(15);
	setDeltaScore_ndx(16);
	setDeltaModScore_ndx(17);
	setzCharge_ndx(18);
	setObsMz_ndx(19);
	setCalcMz_ndx(20);
	setPpmErr_ndx(21);
	setProteinName_ndx(27);
	setProteinID_ndx(28);
	setScanTime_ndx(29);
	setScanNumber_ndx(30);
	setModsFixed_ndx(31);
	
    }//--- End: SetDefaults
    

    public void SetLiviaDefaults() {
	setSplitChar(";");
	setPID_ndx(0);
	setProteinRank_ndx(1);
	setPos_ndx(2);
	setSequence_ndx(3);
	setModifications_ndx(6);
	setGlycans_ndx(7);
	setPep2D_ndx(8);
	setPep1D_ndx(9);
	setFdr2D_ndx(10);
	setFdr1D_ndx(11);
	setFdrUnique2D_ndx(12);
	setFdrUnique1D_ndx(13);
	setqValue2D_ndx(14);
	setqValue1D_ndx(15);
	setLogProb_ndx(16);
	setScore_ndx(17);
	setDeltaScore_ndx(18);
	setDeltaModScore_ndx(19);
	setzCharge_ndx(20);
	setObsMz_ndx(21);
	setCalcMz_ndx(22);
	setPpmErr_ndx(23);
	setProteinName_ndx(30);
	setProteinID_ndx(31);
	setScanTime_ndx(32);
	setScanNumber_ndx(33);
	setModsFixed_ndx(35);
	
    }//--- End: SetLiviaDefaults
    
    
    public void ConfigureScoring(double pep2d, double logProb, double score) {
	pep2D_sig = pep2d;
	logProb_sig = logProb;
	score_sig = score;
	
    }//--- End: SetLiviaDefaults
    
}