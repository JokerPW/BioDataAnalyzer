package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <xrefs_row xref_source_key="2" record_id="4843" mod_key="53" xref_url="">
//	<xref_text>11327326</xref_text>
// </xrefs_row>
public class Xref implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private String xrefUrl;
    public String getXrefUrl() { return xrefUrl; }
    public void setXrefUrl(String xrefUrl) { this.xrefUrl = xrefUrl; }
    
    private String text;
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    
    private int xrefSourceKey;	// recordID, from xref source
    public int getXrefSourceKey() { return xrefSourceKey; }
    public void setXrefSourceKey(int xrefSourceKey) { this.xrefSourceKey = xrefSourceKey; }
    
    private int modKey;		// recordID, from modification
    public int getModKey() { return modKey; }
    public void setModKey(int modKey) { this.modKey = modKey; }
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	xrefUrl = data.getAttribute("xref_url");
	text = data.getElementsByTagName("xref_text").item(0).getNodeValue();
	xrefSourceKey = FailSafe.forceInteger(data.getAttribute("xref_source_key"));
	modKey = FailSafe.forceInteger(data.getAttribute("mod_key"));
    }
    
}