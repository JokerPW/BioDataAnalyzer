package br.com.gplab.analysis.externalAPIs;

import java.util.ArrayList;
import java.util.Hashtable;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.gplab.model.FullProtein;
import br.com.gplab.model.returnItens.ProteinCount;
import br.com.gplab.utils.XMLReader;

public class Uniprot {

    private XMLReader xmlReader;
    
    private boolean hasRead;
    
    
    public Uniprot() {
	hasRead = false;
    }
    
    
    public void fillAllExtraInfo(ArrayList<ProteinCount> uniqueProts, Hashtable<String, FullProtein> dictFPs) {
	
	if (hasRead)
	    return;
	
	System.out.println("Accessing UNIPROT API");

	if (xmlReader == null)
	    xmlReader = new XMLReader();
	
	for (ProteinCount pc : uniqueProts) {

	    	// API Call
	    xmlReader.readGETXML("https://www.uniprot.org/uniprot/" + pc.getProteinID() + ".xml");
	    
	    	// First info: Subcellular Location
	    NodeList nl = xmlReader.getDoc().getElementsByTagName("comment");
	    for (int i = 0; i < nl.getLength(); i++) {
		Element elmt = (Element) nl.item(i);
		if ("subcellular location".equals(elmt.getAttribute("type"))) {
		    NodeList refNode = elmt.getElementsByTagName("subcellularLocation");
		    if (refNode.getLength() > 0) {
			for (int j = 0; j < refNode.getLength(); j++) {
			    Node nd = refNode.item(j);
			    String location = ((Element) nd).getElementsByTagName("location").item(0).getTextContent();
			    dictFPs.get(pc.getProteinID()).getSubcellularLocation().add(location);
			}
		    }
		}
	    }
	    
	    	// Second info: GO - Molecular function / GO - Biological process
	    nl = xmlReader.getDoc().getElementsByTagName("dbReference");
	    //System.out.println("Count dbReference: " + nl.getLength());
	    for (int i = 0; i < nl.getLength(); i++) {
		Element elmt = (Element) nl.item(i);
		if ("GO".equals(elmt.getAttribute("type"))) {
		    //System.out.println("Found GO");
		    NodeList refNode = elmt.getElementsByTagName("property");
		    if (refNode.getLength() > 0) {
			for (int j = 0; j < refNode.getLength(); j++) {
			    Node nd = refNode.item(j);
			    if ("term".equals(((Element) nd).getAttribute("type"))) {
				String go = ((Element) nd).getAttribute("value");
				//System.out.println("GO - " + go);
				if (go.split(":")[0].equals("P"))
				    dictFPs.get(pc.getProteinID()).getBiologicalProcess().add(go);
				else
				    dictFPs.get(pc.getProteinID()).getMolecularFunctions().add(go);
				
			    }
			}
		    }
		}
	    }
	    
	}//--- End: for (ProteinCount pc : uniqueProts)
	
	hasRead = true;
	
    }//--- End: fillExtraInfo

}