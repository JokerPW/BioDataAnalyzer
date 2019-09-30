package br.com.gplab.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gplab.analysis.DataHolder;
import br.com.gplab.model.FullProtein;

@RestController
@RequestMapping("/organism")
public class OrganismController {

    @Autowired
    private DataHolder dataHolder;
    
    
    @PostMapping(value="/read", consumes = "multipart/form-data")
    //public ResponseEntity<?> ReceivePost(@RequestParam("prots") MultipartFile payload) {
	public ResponseEntity<?> ReceivePost() {

	System.out.println("===== Receive Organism Fasta =====");
	
	String content = "";
	try {
	    //byte[] bytes = payload.getBytes();
	    //BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
	    //BufferedReader br = new BufferedReader(new FileReader("F:/Trampos/ParasitologyLab/analysis/organism.fasta"));
	    BufferedReader br = new BufferedReader(new FileReader("C:/tomcat/organism.fasta"));
	    
	    ArrayList<String> info = new ArrayList<String>();
	    while((content = br.readLine())!=null) {
		
		if (content.charAt(0) == '>') {
		    if(info.size() > 0) {
			FullProtein fp = new FullProtein();
			fp.fillData(info);
			fp.run();
			dataHolder.getProts().add(fp);
			dataHolder.getDictFPs().put(fp.getProtein().getProteinID(), fp);
		    }
		    info = new ArrayList<String>();
		}
		
		info.add(content);
	    }
	    br.close();
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	return new ResponseEntity ("Data Acquired", HttpStatus.OK);
	
    }//--- End: ReceivePost
    
    

}