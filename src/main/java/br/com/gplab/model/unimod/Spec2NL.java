package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <spec2nl_row is_pep_nl="0" record_id="3000" pairs_with="" spec_key="5745" code="" is_slave_nl="0" is_req_pep_nl="0" nl_composition="H(3) O(7) P(2)" description="" nl_mono_mass="176.935402" nl_avge_mass="176.9671"></spec2nl_row>
public class Spec2NL implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }
    
    private String pairsWith;
    public String getPairsWith() { return pairsWith; }
    public void setPairsWith(String pairsWith) { this.pairsWith = pairsWith; }
    
    private String code;
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    private String nlComposition;
    public String getNlComposition() { return nlComposition; }
    public void setNlComposition(String nlComposition) { this.nlComposition = nlComposition; }
    
    private String description;
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    private boolean isPepNL;
    public boolean isPepNL() { return isPepNL; }
    public void setPepNL(boolean isPepNL) { this.isPepNL = isPepNL; }
     
    private boolean isReqPepNL;
    public boolean isReqPepNL() { return isReqPepNL; }
    public void setReqPepNL(boolean isReqPepNL) { this.isReqPepNL = isReqPepNL; }
    
    private int specKey;	// recordID, from specificity
    public int getSpecKey() { return specKey; }
    public void setSpecKey(int specKey) { this.specKey = specKey; }

    private double nlAvgMass;
    public double getNlAvgMass() { return nlAvgMass; }
    public void setNlAvgMass(double nlAvgMass) { this.nlAvgMass = nlAvgMass; }
    
    private double nlMonoMass;
    public double getNlMonoMass() { return nlMonoMass; }
    public void setNlMonoMass(double nlMonoMass) { this.nlMonoMass = nlMonoMass; }
    
    
    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	pairsWith = data.getAttribute("pairs_with");
	code = data.getAttribute("code");
	nlComposition = data.getAttribute("nl_composition");
	pairsWith = data.getAttribute("pairs_with");
	isPepNL = data.getAttribute("pairs_with").equals("1");
	isReqPepNL = data.getAttribute("pairs_with").equals("1");
	specKey = FailSafe.forceInteger(data.getAttribute("spec_key"));
	nlAvgMass = FailSafe.forceDouble(data.getAttribute("nl_avge_mass"));
	nlMonoMass = FailSafe.forceDouble(data.getAttribute("nl_mono_mass"));
    }
   
}