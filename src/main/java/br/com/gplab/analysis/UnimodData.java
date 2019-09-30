package br.com.gplab.analysis;

import java.util.ArrayList;
import java.util.Hashtable;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.gplab.model.UnimodItem;
import br.com.gplab.model.unimod.AltName;
import br.com.gplab.model.unimod.AminoAcid;
import br.com.gplab.model.unimod.Brick;
import br.com.gplab.model.unimod.Brick2Element;
import br.com.gplab.model.unimod.Classification;
import br.com.gplab.model.unimod.Fragment;
import br.com.gplab.model.unimod.FragmentComp;
import br.com.gplab.model.unimod.Mod2Brick;
import br.com.gplab.model.unimod.Modification;
import br.com.gplab.model.unimod.NeutralLoss;
import br.com.gplab.model.unimod.Position;
import br.com.gplab.model.unimod.Spec2NL;
import br.com.gplab.model.unimod.Specificity;
import br.com.gplab.model.unimod.Xref;
import br.com.gplab.model.unimod.XrefSource;
import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.XMLReader;

public class UnimodData {

    private double UNIMOD_OFFSET = 0.05;
    
    //private static final String URL = "F:/Trampos/ParasitologyLab/Database/unimod_tables.xml";
    private static final String URL = "C:/tomcat/unimod_tables.xml";
    private static boolean canInstantiate = false;
    private static UnimodData instance;
    
    
    private ArrayList<IUnimod> altNames;
    public ArrayList<IUnimod> getAltNames() { return altNames; }
    
    private Hashtable <Integer, IUnimod> dictAltNames;
    public Hashtable <Integer, IUnimod> getDictAltNames() { return dictAltNames; }

    
    private ArrayList<IUnimod> aminoAcids;
    public ArrayList<IUnimod> getAminoAcids() { return aminoAcids; }
    
    private Hashtable <Integer, IUnimod> dictAminoAcids;
    public Hashtable <Integer, IUnimod> getDictAminoAcids() { return dictAminoAcids; }
    

    private ArrayList<IUnimod> bricks;
    public ArrayList<IUnimod> getBricks() { return bricks; }
    
    private Hashtable <Integer, IUnimod> dictBricks;
    public Hashtable <Integer, IUnimod> getDictBricks() { return dictBricks; }
    

    private ArrayList<IUnimod> brick2Elements;
    public ArrayList<IUnimod> getBrick2Elements() { return brick2Elements; }
    
    private Hashtable <Integer, IUnimod> dictBrick2Elements;
    public Hashtable <Integer, IUnimod> getDictBrick2Elements() { return dictBrick2Elements; }
    
    
    private ArrayList<IUnimod> classifications;
    public ArrayList<IUnimod> getClassifications() { return classifications; }
    
    private Hashtable <Integer, IUnimod> dictClassifications;
    public Hashtable <Integer, IUnimod> getDictClassifications() { return dictClassifications; }
    
    
    private ArrayList<IUnimod> elements;
    public ArrayList<IUnimod> getElements() { return elements; }
    
    private Hashtable <Integer, IUnimod> dictElements;
    public Hashtable <Integer, IUnimod> getDictElements() { return dictElements; }
    
    
    private ArrayList<IUnimod> fragments;
    public ArrayList<IUnimod> getFragments() { return fragments; }
    
    private Hashtable <Integer, IUnimod> dictFragments;
    public Hashtable <Integer, IUnimod> getDictFragments() { return dictFragments; }
    
    
    private ArrayList<IUnimod> fragmentComps;
    public ArrayList<IUnimod> getFragmentComps() { return fragmentComps; }
    
    private Hashtable <Integer, IUnimod> dictFragmentComps;
    public Hashtable <Integer, IUnimod> getDictFragmentComps() { return dictFragmentComps; }
    
    
    private ArrayList<IUnimod> mod2Bricks;
    public ArrayList<IUnimod> getMod2Bricks() { return mod2Bricks; }
    
    private Hashtable <Integer, IUnimod> dictMod2Bricks;
    public Hashtable <Integer, IUnimod> getDictMod2Bricks() { return dictMod2Bricks; }
    
    
    private ArrayList<IUnimod> modifications;
    public ArrayList<IUnimod> getModifications() { return modifications; }
    
    private Hashtable <Integer, IUnimod> dictModifications;
    public Hashtable <Integer, IUnimod> getDictModifications() { return dictModifications; }
    

    private ArrayList<IUnimod> neutralLosses;
    public ArrayList<IUnimod> getNeutralLosses() { return neutralLosses; }
    
    private Hashtable <Integer, IUnimod> dictNeutralLosses;
    public Hashtable <Integer, IUnimod> getDictNeutralLosses() { return dictNeutralLosses; }
    

    private ArrayList<IUnimod> positions;
    public ArrayList<IUnimod> getPositions() { return positions; }
    
    private Hashtable <Integer, IUnimod> dictPositions;
    public Hashtable <Integer, IUnimod> getDictPositions() { return dictPositions; }
    
    
    private ArrayList<IUnimod> spec2NLs;
    public ArrayList<IUnimod> getSpec2NLs() { return spec2NLs; }
    
    private Hashtable <Integer, IUnimod> dictSpec2NLs;
    public Hashtable <Integer, IUnimod> getDictSpec2NLs() { return dictSpec2NLs; }
    
    
    private ArrayList<IUnimod> specificities;
    public ArrayList<IUnimod> getSpecificities() { return specificities; }
    
    private Hashtable <Integer, IUnimod> dictSpecificities;
    public Hashtable <Integer, IUnimod> getDictSpecificities() { return dictSpecificities; }
    
    
    private ArrayList<IUnimod> xrefs;
    public ArrayList<IUnimod> getXrefs() { return xrefs; }
    
    private Hashtable <Integer, IUnimod> dictXrefs;
    public Hashtable <Integer, IUnimod> getDictXrefs() { return dictXrefs; }
    
    
    private ArrayList<IUnimod> xrefSources;
    public ArrayList<IUnimod> getXrefSources() { return xrefSources; }
    
    private Hashtable <Integer, IUnimod> dictXrefSources;
    public Hashtable <Integer, IUnimod> getDictXrefSources() { return dictXrefSources; }
    
    
    public static UnimodData getInstance() {
    	if (instance == null) {
    	    canInstantiate = true;
    	    try {
		instance = new UnimodData();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
    	    canInstantiate = false;
    	}
    	
    	return instance;
    }
    
    public UnimodData() throws Exception {
	if (!canInstantiate) {
	    throw new Exception("This class is a Singleton. Use its getInstance method");
	}
	
	altNames = new ArrayList<IUnimod>();
	dictAltNames = new Hashtable <Integer, IUnimod>();
	
	aminoAcids = new ArrayList<IUnimod>();
	dictAminoAcids = new Hashtable <Integer, IUnimod>();

	bricks = new ArrayList<IUnimod>();
	dictBricks = new Hashtable <Integer, IUnimod>();

	brick2Elements = new ArrayList<IUnimod>();
	dictBrick2Elements = new Hashtable <Integer, IUnimod>();
	    
	classifications = new ArrayList<IUnimod>();
	dictClassifications = new Hashtable <Integer, IUnimod>();
	    
	elements = new ArrayList<IUnimod>();
	dictElements = new Hashtable <Integer, IUnimod>();
	    
	fragments = new ArrayList<IUnimod>();
	dictFragments = new Hashtable <Integer, IUnimod>();
	    
	fragmentComps = new ArrayList<IUnimod>();
	dictFragmentComps = new Hashtable <Integer, IUnimod>();
	    
	mod2Bricks = new ArrayList<IUnimod>();
	dictMod2Bricks = new Hashtable <Integer, IUnimod>();
	    
	modifications = new ArrayList<IUnimod>();
	dictModifications = new Hashtable <Integer, IUnimod>();

	neutralLosses = new ArrayList<IUnimod>();
	dictNeutralLosses = new Hashtable <Integer, IUnimod>();

	positions = new ArrayList<IUnimod>();
	dictPositions = new Hashtable <Integer, IUnimod>();
	    
	spec2NLs = new ArrayList<IUnimod>();
	dictSpec2NLs = new Hashtable <Integer, IUnimod>();
	    
	specificities = new ArrayList<IUnimod>();
	dictSpecificities = new Hashtable <Integer, IUnimod>();
	    
	xrefs = new ArrayList<IUnimod>();
	dictXrefs = new Hashtable <Integer, IUnimod>();
	    
	xrefSources = new ArrayList<IUnimod>();
	dictXrefSources = new Hashtable <Integer, IUnimod>();

	
	XMLReader xmlReader = new XMLReader();
	
	if (xmlReader.readFileXML(URL)) {
	    
	    addItems (xmlReader, "alt_names_row", AltName.class, altNames, dictAltNames);
	    addItems (xmlReader, "amino_acids_row", AminoAcid.class, aminoAcids, dictAminoAcids);
	    addItems (xmlReader, "brick2element_row", Brick2Element.class, brick2Elements, dictBrick2Elements);
	    addItems (xmlReader, "bricks_row", Brick.class, bricks, dictBricks);
	    addItems (xmlReader, "classifications_row", Classification.class, classifications, dictClassifications);
	    addItems (xmlReader, "elements_row", br.com.gplab.model.unimod.Element.class, elements, dictElements);
	    addItems (xmlReader, "fragment_comp_row", FragmentComp.class, fragmentComps, dictFragmentComps);
	    addItems (xmlReader, "fragments_row", Fragment.class, fragments, dictFragments);
	    addItems (xmlReader, "mod2brick_row", Mod2Brick.class, mod2Bricks, dictMod2Bricks);
	    addItems (xmlReader, "modifications_row", Modification.class, modifications, dictModifications);
	    addItems (xmlReader, "neutral_losses_row", NeutralLoss.class, neutralLosses, dictNeutralLosses);
	    addItems (xmlReader, "positions_row", Position.class, positions, dictPositions);
	    addItems (xmlReader, "spec2nl_row", Spec2NL.class, spec2NLs, dictSpec2NLs);
	    addItems (xmlReader, "specificity_row", Specificity.class, specificities, dictSpecificities);
	    addItems (xmlReader, "xref_sources_row", XrefSource.class, xrefSources, dictXrefSources);
	    addItems (xmlReader, "xrefs_row", Xref.class, xrefs, dictXrefs);
	}
	
	System.out.println("Unimod Mirror Ready!");
	
    }//--- End: Constructor
    
    
    private void addItems (XMLReader xmlReader, String tag, Class<? extends IUnimod> obj, ArrayList<IUnimod> list, Hashtable<Integer, IUnimod> dict) {
	NodeList nl = xmlReader.getDoc().getElementsByTagName(tag);
	for (int i = 0; i < nl.getLength(); i++) {
	    Element elmt = (Element) nl.item(i); 
	    try {
		IUnimod item = (IUnimod) obj.newInstance();
		item.populate(elmt);
		
		list.add(item);
		dict.put(item.getRecordID(), item);
		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	       
	}
	
    }//--- End: addItems
    
    
    public void updateOffset(double newOffset) {
	UNIMOD_OFFSET = newOffset;
    }
    
    
    public int findAccessionByMass(double dpMassDifference) {
	//System.out.println("Searching Accession: " + dpMassDifference);
	double smallest = 100.0;
	int ndx = -1;
	
        for (IUnimod mod : modifications) {
            
            if (Math.abs(Math.abs(dpMassDifference) - Math.abs(((Modification)mod).getMonoMass())) < UNIMOD_OFFSET &&
        	Math.abs(Math.abs(dpMassDifference) - Math.abs(((Modification)mod).getMonoMass())) < smallest &&
        	((dpMassDifference > 0 && ((Modification)mod).getMonoMass() > 0) || 
        	(dpMassDifference < 0 && ((Modification)mod).getMonoMass() < 0))) {
        	
        	ndx = mod.getRecordID();
        	smallest = Math.abs(Math.abs(dpMassDifference) - Math.abs(((Modification)mod).getAvgMass()));
            }
        }
        
        return ndx;
        
    }//--- End: findAccessionByMass
    
    
    public UnimodItem findDataByAccession(int accession) {
	
	if (accession < 0)
	    return null;
	
	UnimodItem ui = new UnimodItem();
	Modification mod = (Modification) getDictModifications().get(accession);
	
        if (mod != null) {
            ui.setAccession(mod.getRecordID());
            ui.setPsiMsName(mod.getExCodeName());
            ui.setDescription(mod.getFullName());
            ui.setInterimName(mod.getCodeName());
            ui.setComposition(mod.getComposition());
            ui.setMonoisotopicMass(mod.getMonoMass());
            ui.setAverageMass(mod.getAvgMass());
            
            ArrayList<Specificity> specs = findSpecificityFromModification(mod);
            for (Specificity spec : specs) {
        	String site = spec.getOneLetter();
        	String position = "";
        	String classification = "";
        	
        	Position pos = ((Position) getDictPositions().get(spec.getPositionKey()));
        	if (pos != null)
        	    position = pos.getPosition();
        	
        	Classification cls = ((Classification) getDictClassifications().get(spec.getClassificationsKey()));
        	if (cls != null)
        	    classification = cls.getClassification();
        	
        	ui.getSpecificities().add(new br.com.gplab.model.Specificity(site, position, classification));
            }
	
            return ui;
	}
        
        return null;
        
    }//--- End: findDataByAccession
    
    
    private ArrayList<Specificity> findSpecificityFromModification(Modification mod) {
    	
    	ArrayList<Specificity> al = new ArrayList<Specificity>();
    	for (IUnimod sp : getSpecificities()) {
    	    if (mod.getRecordID() == ((Specificity) sp).getModKey()) {
    		al.add((Specificity) sp);
    	    }
    	}
    	//System.out.println("Specificities found: " + al.size());
    	return al;
    }
}