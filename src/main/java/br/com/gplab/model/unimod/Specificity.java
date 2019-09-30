package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

//<specificity_row spec_group="2" record_id="6223" hidden="0" classifications_key="6" mod_key="2" position_key="4" one_letter="C-term">
//<misc_notes>MS/MS experiments of mass spectrometric c-ions (MS^3) can be used for protein identification by library searching. T3-sequencing is such a technique (see reference). Search engines must recognize this as a virtual modification.</misc_notes>
//</specificity_row>
public class Specificity implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private String oneLetter;	// oneLetter, from amino acid
    public String getOneLetter() { return oneLetter; }
    public void setOneLetter(String oneLetter) { this.oneLetter = oneLetter; }
    
    private String notes;
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    private boolean hidden;
    public boolean isHidden() { return hidden; }
    public void setHidden(boolean hidden) { this.hidden = hidden; }
    
    private int specGroup;
    public int getSpecGroup() { return specGroup; }
    public void setSpecGroup(int specGroup) { this.specGroup = specGroup; }
    
    private int classificationsKey;	// recordID, from classification
    public int getClassificationsKey() { return classificationsKey; }
    public void setClassificationsKey(int classificationsKey) { this.classificationsKey = classificationsKey; }
    
    private int modKey;		// recordID, from modification
    public int getModKey() { return modKey; }
    public void setModKey(int modKey) { this.modKey = modKey; }
    
    private int positionKey;	// recordID, from position
    public int getPositionKey() { return positionKey; }
    public void setPositionKey(int positionKey) { this.positionKey = positionKey; }
    
    
    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	oneLetter = data.getAttribute("one_letter");
	notes = data.getElementsByTagName("misc_notes").item(0).getNodeValue();
	hidden = data.getAttribute("hidden").equals("1");
	specGroup = FailSafe.forceInteger(data.getAttribute("spec_group"));
	classificationsKey = FailSafe.forceInteger(data.getAttribute("classifications_key"));
	modKey = FailSafe.forceInteger(data.getAttribute("mod_key"));
	positionKey = FailSafe.forceInteger(data.getAttribute("position_key"));
    }
    
}