package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <amino_acids_row record_id="1" num_N="0" full_name="" num_C="0" num_O="0" num_S="0" num_Se="0" three_letter="" num_H="0" one_letter="-"></amino_acids_row>
public class AminoAcid implements IUnimod {
    
    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private String fullName;
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    private String threeLetter;
    public String getThreeLetter() { return threeLetter; }
    public void setThreeLetter(String threeLetter) { this.threeLetter = threeLetter; }

    private String oneLetter;
    public String getOneLetter() { return oneLetter; }
    public void setOneLetter(String oneLetter) { this.oneLetter = oneLetter; }
    
    private int numN;
    public int getNumN() { return numN; }
    public void setNumN(int numN) { this.numN = numN; }
    
    private int numC;
    public int getNumC() { return numC; }
    public void setNumC(int numC) { this.numC = numC; }
    
    private int numS;
    public int getNumS() { return numS; }
    public void setNumS(int numS) { this.numS = numS; }
    
    private int numSe;
    public int getNumSe() { return numSe; }
    public void setNumSe(int numSe) { this.numSe = numSe; }
    
    private int numH;
    public int getNumH() { return numH; }
    public void setNumH(int numH) { this.numH = numH; }
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	fullName = data.getAttribute("full_name");
	threeLetter = data.getAttribute("three_letter");
	oneLetter = data.getAttribute("one_letter");
	numN = FailSafe.forceInteger(data.getAttribute("num_N"));
	numC = FailSafe.forceInteger(data.getAttribute("num_C"));
	numS = FailSafe.forceInteger(data.getAttribute("num_S"));
	numSe = FailSafe.forceInteger(data.getAttribute("num_Se"));
	numH = FailSafe.forceInteger(data.getAttribute("num_H"));
    }
    
}