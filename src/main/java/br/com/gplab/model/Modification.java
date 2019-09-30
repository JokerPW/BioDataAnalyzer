package br.com.gplab.model;

import java.util.ArrayList;

import br.com.gplab.model.subItens.Mod;

//M23(Oxidation / 15.9949); N46(NGlycan / 2336.8511)
public class Modification {

    private ArrayList<Mod> mods;
    
    public Modification(String data) {
	mods = new ArrayList<Mod> ();
	
	if (data.indexOf(';') < 0) {
	    mods.add(new Mod(data));
	    return;
	}
	
	String[] cut1 = data.split(";");
	for (int i = 0; i < cut1.length; i++) {
	    Mod md = new Mod(cut1[i]);
	    if (md.getModType() != Mod.modTypes.Oxidation)
		mods.add(md);
	    
	}
	
    }//--- End: Constructor
    
    
    public int getMods() {
	return mods.size();
    }

    @Override
    public String toString() {
	
	StringBuilder ret = new StringBuilder();
	
	for (Mod mod : mods)
	    ret.append(mod.toString());
	
	return ret.toString();
    }


    public void dispose() {
	for (Mod mod : mods) {
	    mod.dispose();
	    mod = null;
	}
	
	mods = null;
    }
    
}