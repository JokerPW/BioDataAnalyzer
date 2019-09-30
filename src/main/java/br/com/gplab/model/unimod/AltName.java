package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <alt_names_row alt_name="Pierce EZ-Link PEO-Iodoacetyl Biotin" record_id="601" mod_key="20"></alt_names_row>
public class AltName implements IUnimod{

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }
    
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private int modKey;		// recordID from Modifications
    public int getModKey() { return modKey; }
    public void setModKey(int modKey) { this.modKey = modKey; }
    
    
    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	name = data.getAttribute("alt_name");
	modKey = FailSafe.forceInteger(data.getAttribute("mod_key"));
    }
    
}