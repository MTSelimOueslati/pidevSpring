package com.esprit.tn.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;


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
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping(value="/add", consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE
	})  
	private Documents adddocument(@RequestPart("evJson")String docsJson,
			@RequestPart("fichedepaie") MultipartFile filefiche,
			@RequestPart("piecedidentite") MultipartFile fileidentite,
			@RequestPart("lettredengagement") MultipartFile filelettre,
			@RequestPart("cautionnement") MultipartFile filecaut,
			@RequestParam("userId") int userId)   
	{  	
		
		Documents docs= new Documents();
		String fileName1 = StringUtils.cleanPath(filefiche.getOriginalFilename());
		String fileName2 = StringUtils.cleanPath(fileidentite.getOriginalFilename());
		String fileName3 = StringUtils.cleanPath(filelettre.getOriginalFilename());
		String fileName4 = StringUtils.cleanPath(filecaut.getOriginalFilename());
		System.out.println("pay slip ="+fileName1);
		System.out.println("identity ="+fileName2);
		System.out.println("engagement lettre ="+fileName3);
		System.out.println("bond ="+fileName4);
		/*try {
			docs= objectMapper.readValue(docsJson, Documents.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		String fileDownloadUri1 = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/")
				.path(fileName1).toUriString();
		System.out.println("file url =====>"+fileDownloadUri1);
		docs.setFichedepaie(fileDownloadUri1.getBytes());
		
		String fileDownloadUri2 = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/")
				.path(fileName2).toUriString();
		System.out.println("file url =====>"+fileDownloadUri2);
		docs.setPiecedidentite(fileDownloadUri2.getBytes());
		
		String fileDownloadUri3 = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/")
				.path(fileName1).toUriString();
		System.out.println("file url =====>"+fileDownloadUri3);
		docs.setLettredengagement(fileDownloadUri3.getBytes());

		String fileDownloadUri4 = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/")
				.path(fileName1).toUriString();
		System.out.println("file url =====>"+fileDownloadUri4);
		docs.setCautionnement(fileDownloadUri4.getBytes());
		
		docserv.addDocuments(docs, userId);
		return docs;  
	}
	
	
	
/*	
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
		
		
	}  */
	
	
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
