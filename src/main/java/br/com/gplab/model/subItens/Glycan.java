package br.com.gplab.model.subItens;

//HexNAc(2
public class Glycan {

    public static enum glycanType{
	Hex, HexNAc, Fuc, NeuAc, NeuGc;
    }

    
    private glycanType type;
    public glycanType getType() { return type; }
    public void setType(glycanType type) { this.type = type; }

    private int quantity;
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    
    public Glycan(String data) {
	//System.out.println("- glycan: " + data);
	String[] cut1 = data.replace("(", "@").split("@");
	
	switch(cut1[0]) {
	case "Hex": type = glycanType.Hex; 
//		System.out.println("Hex - " + cut1[1]);
		break;
	case "HexNAc": type = glycanType.HexNAc; 
//		System.out.println("HexNAc - " + cut1[1]);
		break;
	case "Fuc": type = glycanType.Fuc; 
//		System.out.println("Fuc - " + cut1[1]);
		break;
	case "NeuAc": type = glycanType.NeuAc; 
//		System.out.println("NeuAc - " + cut1[1]);
		break;
	case "NeuGc": type = glycanType.NeuGc; 
//		System.out.println("NeuGc - " + cut1[1]);
		break;
	 
	default: type = glycanType.Hex;
	}
	
	quantity = Integer.parseInt(cut1[1]);
	
    }//---End: Contructor
    
    
    @Override
    public String toString() {
	return type.toString() + "(" + quantity + ")";
    }
    
    public void dispose() {
	type = null;
    }
    
}