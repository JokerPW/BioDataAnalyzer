package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <xref_sources_row xref_source="PubMed PMID" record_id="2"></xref_sources_row>
public class XrefSource implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private String xrefSource;
    public String getXrefSource() { return xrefSource; }
    public void setXrefSource(String xrefSource) { this.xrefSource = xrefSource; }
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	xrefSource = data.getAttribute("xref_source");
    }
    
}