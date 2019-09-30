package br.com.gplab.analysis;

import java.util.ArrayList;
import java.util.Hashtable;

import br.com.gplab.analysis.mappings.GPAnalysisConsts;
import br.com.gplab.analysis.mappings.PepAnalysisConsts;
import br.com.gplab.model.FullProtein;
import br.com.gplab.model.GlycoPeptide;
import br.com.gplab.model.MaxQuantResult;
import br.com.gplab.model.Peptide;
import br.com.gplab.model.UnimodItem;
import br.com.gplab.model.returnItens.ProteinCount;


public class DataHolder {

    private GPAnalysisConsts gpAnalysisConsts;
    public GPAnalysisConsts getGPAnalysisConsts() { return gpAnalysisConsts; }

    private PepAnalysisConsts pepAnalysisConsts;
    public PepAnalysisConsts getPepAnalysisConsts() { return pepAnalysisConsts; }
    
    
    private ArrayList<String> rawData;
    public ArrayList<String> getRawData() { return rawData; }
    
    
    //==================== GP Controller
    private ArrayList<GlycoPeptide> allGPs;
    public ArrayList<GlycoPeptide> getGPs() { return allGPs; }
    
    private Hashtable <String, GlycoPeptide> dictGPs;
    public Hashtable <String, GlycoPeptide> getDictGPs() { return dictGPs; }
    

    private ArrayList<MaxQuantResult> allMQs;
    public ArrayList<MaxQuantResult> getMQs() { return allMQs; }
    
    private MaxQuantResult.software inUse;
    public MaxQuantResult.software getSoftware() { return inUse; }
    public void setSoftware (MaxQuantResult.software soft) { inUse = soft; }
    
    //==================== Organism (FASTA) Controller
    private ArrayList<FullProtein> allProts;
    public ArrayList<FullProtein> getProts() { return allProts; }

    private Hashtable <String, FullProtein> dictFPs;
    public Hashtable <String, FullProtein> getDictFPs() { return dictFPs; }
    
    
    //==================== Protein Controller
    private ArrayList<ProteinCount> uniqueProts;
    public ArrayList<ProteinCount> getUniqueProts() { return uniqueProts; }
    
    
    //==================== All Peptide Controller
    private ArrayList<Peptide> allPeps;
    public ArrayList<Peptide> getPeps() { return allPeps; }
    
    private Hashtable <String, Peptide> dictPeps;
    public Hashtable <String, Peptide> getDictPeps() { return dictPeps; }
    
    private ArrayList<UnimodItem> allUnimods;
    public ArrayList<UnimodItem> getUnimods() { return allUnimods; }
    
    private Hashtable <Double, UnimodItem> dictUnimods;
    public Hashtable <Double, UnimodItem> getDictUnimods() { return dictUnimods; }
    
    
    
    public DataHolder() {
	System.out.println("Initializing Data Holder");
	gpAnalysisConsts = new GPAnalysisConsts();
	pepAnalysisConsts = new PepAnalysisConsts();
	
	rawData = new ArrayList<String>();
	
	allGPs = new ArrayList<GlycoPeptide>();
	dictGPs = new Hashtable <String, GlycoPeptide>();
	allMQs = new ArrayList<MaxQuantResult>();
	
	allProts = new ArrayList<FullProtein>();
	dictFPs = new Hashtable <String, FullProtein>();
	
	uniqueProts = new ArrayList<ProteinCount>();

	allPeps = new ArrayList<Peptide>();
	dictPeps = new Hashtable <String, Peptide>();

	allUnimods = new ArrayList<UnimodItem>();
	dictUnimods = new Hashtable <Double, UnimodItem>();
	
    }//--- End: Constructor
    
    
    public void fillProteinGlycanInfo (ArrayList<FullProtein> prots, ArrayList<GlycoPeptide> gps) {
	if (!prots.get(0).getDictFPs().isEmpty())
	    return;
	
	for (FullProtein prot : prots) {
	    prot.countGlycans(gps);
	}
    }
    

    public void fillProteinAAsInfo (ArrayList<FullProtein> prots, ArrayList<GlycoPeptide> gps) {
	if (!prots.get(0).getDictAAs().isEmpty())
	    return;
	
	for (FullProtein prot : prots) {
	    prot.countAminoAs(gps);
	}
    }


    public void clearData() {
	gpAnalysisConsts = new GPAnalysisConsts();
	
	for (GlycoPeptide gp : allGPs) {
	    gp.dispose();
	    gp = null;
	}
	rawData = new ArrayList<String>();
	allGPs = new ArrayList<GlycoPeptide>();
	dictGPs = new Hashtable <String, GlycoPeptide>();
	
	for (MaxQuantResult mq : allMQs) {
	    mq.dispose();
	    mq = null;
	}
	allMQs = new ArrayList<MaxQuantResult>();
	
	for (ProteinCount pc : uniqueProts) {
	    pc.dispose();
	    pc = null;
	}
	uniqueProts = new ArrayList<ProteinCount>();
    }


}