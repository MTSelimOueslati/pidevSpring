package com.esprit.tn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Offer;
import com.esprit.tn.entities.Reclamation;
import com.esprit.tn.services.OfferServiceImpl;
import com.esprit.tn.services.ReclamationServiceImpl;

@RestController
public class ReclamationController {
	
	
	@Autowired
	ReclamationServiceImpl Reclamationservimpl;
	
	  //add recl
    @PostMapping("/rec/add-Rec")
    @ResponseBody
    private Reclamation addReclamation(@RequestBody Reclamation Reclamation)
    {
       Reclamationservimpl.AddRec(Reclamation); 
        return Reclamation;
    }
	//get rec
    @GetMapping("rec/getAll")
    public List<Reclamation> getAllRec() {
        return Reclamationservimpl.getAllRec();
    }
    //delete rec
    @DeleteMapping("rec/delete/{id}")
    public void deleteReclamationById(@PathVariable("id") int id) {
        Reclamationservimpl.deleteRec(id);
    }
    
    @PutMapping("/rec/update/{id}")      
    private Reclamation updateRec(@RequestBody Reclamation Reclamation, @PathVariable("id")int id )
    {        
    	Reclamationservimpl.UpdateRec(Reclamation, id); 
    return Reclamationservimpl.UpdateRec(Reclamation, id);    
    }
    
    @PutMapping("rec/updateS/{id}")
    public Reclamation  UpdateState(@PathVariable("id")int id) {
    	Reclamationservimpl.UpdateState(id);
    	return Reclamationservimpl.UpdateState(id);
    	
    }
    
}
