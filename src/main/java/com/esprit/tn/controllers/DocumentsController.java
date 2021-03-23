package com.esprit.tn.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.tn.entities.Documents;
import com.esprit.tn.entities.util.FileUploadUtil;
import com.esprit.tn.repositories.UserRepository;
import com.esprit.tn.services.DocumentsService;
import com.esprit.tn.services.UserService;

@RestController
@RequestMapping("/documents")
public class DocumentsController {
	
	@Autowired
	DocumentsService docserv ;
	
	@Autowired
	UserRepository userrepo;
	
	
	
	
	@PostMapping("/add")
	private Documents addDocuments(Documents docs,
			@RequestParam("fichedepaie") MultipartFile fichedpaie, 
			@RequestParam("piecedidentite") MultipartFile ident, 
			@RequestParam("lettredengagement") MultipartFile lettre, 
			@RequestParam("cautionnement") MultipartFile caut, 
			@RequestParam("userId") int userId)  throws IOException 
	{  
		
		String filefiche = StringUtils.cleanPath(fichedpaie.getOriginalFilename());
		docs.setFichedepaie(filefiche);
		
		String fileident = StringUtils.cleanPath(ident.getOriginalFilename());
		docs.setPiecedidentite(fileident);
		
		String filelettre = StringUtils.cleanPath(lettre.getOriginalFilename());
		docs.setLettredengagement(filelettre);
		
		String filecaut = StringUtils.cleanPath(caut.getOriginalFilename());
		docs.setCautionnement(filecaut);
		
		docserv.addDocuments(docs,userId);
		String uploadDir = "documents/" + docs.getId();
		 
        FileUploadUtil.saveFile(uploadDir, filefiche, fichedpaie);
        FileUploadUtil.saveFile(uploadDir, fileident, ident);
        FileUploadUtil.saveFile(uploadDir, filelettre, lettre);
        FileUploadUtil.saveFile(uploadDir, filecaut, caut);
		return docs;  
		
		
	}  
	
	
	@PutMapping("/update/{id}")
	private Documents updateDocuments(@RequestBody Documents docs, @PathVariable("id")int id)   
	{  
		docserv.updateDocuments(docs, id);
		return docs;  
	}
	
	@GetMapping("/show")  
	private List<Documents> getAllDocuments()   
	{  
		return docserv.getAllDocuments(); 
	}  
	
	@GetMapping("/getOne")
	public Documents getByUser(@RequestParam("userId") int userId){
		return docserv.getByUser(userrepo.findById(userId).get());
	}

}
