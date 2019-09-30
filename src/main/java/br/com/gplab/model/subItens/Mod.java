package br.com.gplab.model.subItens;

//M23(Oxidation / 15.9949)
public class Mod {
    
    private static enum modifications{
	N, M;
    }

    public static enum modTypes{
	Oxidation, NGlycan;
    }
    

    private modifications modification;
    public modifications getModification() { return modification; }
    public void setModification(modifications modification) { this.modification = modification; }
    
    private int position;
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }

    private modTypes modType;
    public modTypes getModType() { return modType; }
    public void setModType(modTypes modType) { this.modType = modType; }
    
    private double mass;
    public double getMass() { return mass; }
    public void setMass(double mass) { this.mass = mass; }
    
    
    public Mod(String data) {
	
	data = data.replaceAll("\\s+","");
	
	char mod = data.charAt(0);
	switch(mod) {
	case 'N':
	    modification = modifications.N;
	    modType = modTypes.NGlycan;
	    break;
	case 'M':
	    modification = modifications.M;
	    modType = modTypes.Oxidation;
	    break;
	default:
	    modification = modifications.N;
	    modType = modTypes.NGlycan;
	    
	}
	
	data = data.substring(1);
	String[] cut1 = data.replace("(", "@").split("@");
	
	position = Integer.parseInt(cut1[0]);
	
	String smass = cut1[1].split("/")[1];
	mass = Double.parseDouble(smass.substring(0, smass.length() -1));
	
    }//--- End: Constructor

    
    @Override
    public String toString() {
	return modification.toString() + position + "(" + modType.toString() + " / " + mass + ")";
    }
    
    public void dispose() {
	modification = null;
	modType = null;
    }
    
}