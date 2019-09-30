package br.com.gplab.model;

import java.util.ArrayList;

import br.com.gplab.model.subItens.Glycan;

//HexNAc(2)Hex(6)
public class Glycans {

    public static enum glycanNames{
	Paucimannose, Sialylated, Hybrid, Fucosylated, Oligomannose, HighMannose,
	Core1, Core2_F1Alpha, Core3_5_6_7, Core4, Core8, TnAntigen_O_linked_GlcNAc, Sialyl_T_Antigen, 
	Sialyl_Tn_Antigen, Disialyl_T_Antigen, O_Mannose_M1, O_Mannose_M2, O_Mannose_M3, 
	O_linked_Fuc, O_linked_Glc, O_linked_Gal, O_Mantype, notFound;
    }

    private ArrayList<Glycan> molGlycans;
    public ArrayList<Glycan> getMolGlycans() { return molGlycans; }
    
    private glycanNames glycanName;
    public glycanNames getGlycanName() { return glycanName; }
    
    
    public Glycans(String data) {
	//System.out.println("Glycans: " + data);
	molGlycans = new ArrayList<Glycan>();
	glycanName = getName(data.replace(" ", ""));
	//System.out.println("Glycan Name: " + glycanName);
	String[] cut1 = data.replace(")", "@").split("@");
	for(int i = 0; i < cut1.length; i++)
	    molGlycans.add(new Glycan(cut1[i]));
	
    }
    
    
    private glycanNames getName (String data) {
	//System.out.println("Glycan Type: " + data);
	switch (data) {
	case "HexNAc(1)": return glycanNames.TnAntigen_O_linked_GlcNAc;
	case "NeuAc(1)Hex(2)HexNAc(1)": return glycanNames.O_linked_Fuc;
	case "HexNAc(1)Hex(1)NeuAc(2)": return glycanNames.Disialyl_T_Antigen;
	
	case "HexNAc(1)NeuAc(1)": return glycanNames.Sialyl_Tn_Antigen;
	case "HexNAc(1)Hex(1)NeuAc(1)": return glycanNames.Sialyl_T_Antigen;
	
	case "Hex(2)HexNAc(1)": return glycanNames.O_Mannose_M1;
	case "Hex(3)HexNAc(2)": return glycanNames.O_Mannose_M2;
	case "HexNAc(2)Hex(1)": return glycanNames.O_Mannose_M3;
	
	case "Pen(2)Hex(1)": return glycanNames.O_linked_Glc;
	case "Hex(2)": return glycanNames.O_linked_Gal;
	case "Hex(5)": return glycanNames.O_Mantype;
		
	case "HexNAc(2)Fuc(1)":
	case "HexNAc(2)Hex(1)Fuc(1)":
	case "HexNAc(2)Hex(2)":
	case "HexNAc(2)Hex(2)Fuc(1)":
	case "HexNAc(2)Hex(3)":
	case "HexNAc(2)Hex(3)Fuc(1)": return glycanNames.Paucimannose;
	
	case "HexNAc(3)Hex(4)Fuc(1)NeuAc(1)":
	case "HexNAc(3)Hex(4)Fuc(2)NeuAc(1)":
	case "HexNAc(3)Hex(4)NeuAc(1)":
	case "HexNAc(3)Hex(5)Fuc(1)NeuAc(1)":
	case "HexNAc(3)Hex(5)NeuAc(1)":
	case "HexNAc(3)Hex(6)Fuc(1)NeuAc(1)":
	case "HexNAc(3)Hex(6)NeuAc(1)":
	case "HexNAc(4)Hex(3)NeuAc(1)":
	case "HexNAc(4)Hex(4)Fuc(1)NeuAc(1)":
	case "HexNAc(4)Hex(4)NeuAc(1)":
	case "HexNAc(4)Hex(5)Fuc(1)NeuAc(1)":
	case "HexNAc(4)Hex(5)Fuc(1)NeuAc(2)":
	case "HexNAc(4)Hex(5)Fuc(2)NeuAc(1)":
	case "HexNAc(4)Hex(5)Fuc(3)NeuAc(1)":
	case "HexNAc(4)Hex(5)NeuAc(1)":
	case "HexNAc(4)Hex(6)Fuc(1)NeuAc(1)":
	case "HexNAc(4)Hex(6)NeuAc(1)":
	case "HexNAc(4)Hex(7)NeuAc(1)":
	case "HexNAc(5)Hex(3)Fuc(1)NeuAc(1)":
	case "HexNAc(5)Hex(4)Fuc(1)NeuAc(1)":
	case "HexNAc(5)Hex(4)NeuAc(1)":
	case "HexNAc(5)Hex(4)NeuAc(2)":
	case "HexNAc(5)Hex(5)Fuc(1)NeuAc(2)":
	case "HexNAc(5)Hex(5)Fuc(2)NeuAc(1)":
	case "HexNAc(5)Hex(6)NeuAc(2)":
	case "HexNAc(6)Hex(3)Fuc(1)NeuAc(1)":
	case "HexNAc(6)Hex(3)Fuc(1)NeuAc(2)":
	case "HexNAc(6)Hex(5)Fuc(1)NeuAc(2)":
	case "HexNAc(6)Hex(5)Fuc(2)NeuAc(1)":
	case "HexNAc(6)Hex(6)Fuc(2)NeuAc(1)":
	case "HexNAc(6)Hex(6)NeuAc(1)":
	case "HexNAc(6)Hex(7)Fuc(3)NeuAc(1)":
	case "HexNAc(6)Hex(7)NeuAc(3)":
	case "HexNAc(6)Hex(7)NeuAc(4)":
	case "HexNAc(6)Hex(9)Fuc(1)NeuAc(2)":
	case "HexNAc(7)Hex(8)Fuc(1)NeuAc(1)": return glycanNames.Sialylated;
	
	case "HexNAc(3)Hex(3)":
	case "HexNAc(3)Hex(4)":
	case "HexNAc(3)Hex(5)":
	case "HexNAc(3)Hex(6)":
	case "HexNAc(4)Hex(3)":
	case "HexNAc(4)Hex(4)":
	case "HexNAc(4)Hex(5)":
	case "HexNAc(4)Hex(6)":
	case "HexNAc(4)Hex(7)":
	case "HexNAc(5)Hex(3)":
	case "HexNAc(5)Hex(4)":
	case "HexNAc(5)Hex(6)":
	case "HexNAc(5)Hex(8)":
	case "HexNAc(6)Hex(3)":
	case "HexNAc(6)Hex(4)":
	case "HexNAc(6)Hex(5)":
	case "HexNAc(6)Hex(7)":
	case "HexNAc(6)Hex(9)":
	case "HexNAc(7)Hex(3)":
	case "HexNAc(7)Hex(4)":
	case "HexNAc(7)Hex(6)":
	case "HexNAc(8)Hex(3)":
	case "HexNAc(8)Hex(4)":
	case "HexNAc(8)Hex(5)":
	case "HexNAc(8)Hex(8)":
	case "HexNAc(9)Hex(10)":
	case "HexNAc(9)Hex(3)":
	case "HexNAc(9)Hex(6)": return glycanNames.Hybrid;
	
	case "HexNAc(2)Hex(4)Fuc(1)":
	case "HexNAc(2)Hex(5)Fuc(1)":
	case "HexNAc(2)Hex(6)Fuc(1)":
	case "HexNAc(3)Hex(3)Fuc(1)":
	case "HexNAc(3)Hex(4)Fuc(1)":
	case "HexNAc(3)Hex(4)Fuc(2)":
	case "HexNAc(3)Hex(5)Fuc(1)":
	case "HexNAc(3)Hex(6)Fuc(1)":
	case "HexNAc(4)Hex(3)Fuc(1)":
	case "HexNAc(4)Hex(4)Fuc(1)":
	case "HexNAc(4)Hex(4)Fuc(2)":
	case "HexNAc(4)Hex(5)Fuc(1)":
	case "HexNAc(4)Hex(5)Fuc(2)":
	case "HexNAc(4)Hex(6)Fuc(1)":
	case "HexNAc(4)Hex(6)Fuc(2)":
	case "HexNAc(4)Hex(7)Fuc(1)":
	case "HexNAc(5)Hex(3)Fuc(1)":
	case "HexNAc(5)Hex(3)Fuc(2)":
	case "HexNAc(5)Hex(4)Fuc(1)":
	case "HexNAc(5)Hex(4)Fuc(2)":
	case "HexNAc(5)Hex(5)Fuc(1)":
	case "HexNAc(5)Hex(6)Fuc(4)":
	case "HexNAc(5)Hex(8)Fuc(1)":
	case "HexNAc(6)Hex(4)Fuc(1)":
	case "HexNAc(6)Hex(4)Fuc(2)":
	case "HexNAc(6)Hex(6)Fuc(2)":
	case "HexNAc(6)Hex(7)Fuc(3)":
	case "HexNAc(7)Hex(3)Fuc(1)":
	case "HexNAc(7)Hex(7)Fuc(1)":
	case "HexNAc(8)Hex(5)Fuc(1)":
	case "HexNAc(8)Hex(9)Fuc(1)":
	case "HexNAc(9)Hex(3)Fuc(1)":
	case "HexNAc(9)Hex(6)Fuc(1)":
	case "HexNAc(9)Hex(9)Fuc(1)": return glycanNames.Fucosylated;
	
	case "HexNAc(2)Hex(12)":
	case "HexNAc(2)Hex(11)":
	case "HexNAc(2)Hex(10)":
	case "HexNAc(2)Hex(9)":
	case "HexNAc(2)Hex(8)":
	case "HexNAc(2)Hex(7)":
	case "HexNAc(2)Hex(6)":
	case "HexNAc(2)Hex(5)":
	case "HexNAc(2)Hex(4)": return glycanNames.HighMannose;
	
	case "HexNAc(1)Hex(1)": return glycanNames.Core1;
	case "Hex(1)HexNAc(2)": return glycanNames.Core2_F1Alpha;
	case "HexNAc(2)": return glycanNames.Core3_5_6_7;
	case "HexNAc(3)": return glycanNames.Core4;
	case "Hex(1)HexNAc(1)": return glycanNames.Core8;
		
	case "HexNAc(2)Hex(6)Phospho(1)": return glycanNames.Oligomannose;
	
	default: return glycanNames.notFound;
	}
    }
    
    
    @Override
    public String toString() {
	
	StringBuilder ret = new StringBuilder();
	
	for (Glycan gl : molGlycans)
	    ret.append(gl.toString());
	
	return ret.toString();
    }


    public void dispose() {
	for (Glycan gl : molGlycans) {
	    gl.dispose();
	    gl = null;
	}
	
	glycanName = null;
	molGlycans = null;
    }
    
}