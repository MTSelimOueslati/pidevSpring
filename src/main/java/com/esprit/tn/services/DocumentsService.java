package com.esprit.tn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Documents;
import com.esprit.tn.entities.User;
import com.esprit.tn.repositories.DocumentsRepository;
import com.esprit.tn.repositories.UserRepository;

@Service
public class DocumentsService implements IDocumentsService {
	
	@Autowired
	DocumentsRepository docrepo;

	@Autowired
	UserRepository userrepo;


	
	@Override
	public Documents addDocuments(Documents d, int userid) {
		// TODO Auto-generated method stub
		d.setUser(userrepo.findById(userid).get());
		docrepo.save(d);
		return d;
	}
	
	

	@Override
	public void deleteDocuments(int id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Documents updateDocuments(Documents d, int id) {
		// TODO Auto-generated method stub
		Documents doc = docrepo.findById(id).get();
		doc.setCautionnement(d.getCautionnement());
		doc.setFichedepaie(d.getFichedepaie());
		doc.setLettredengagement(d.getLettredengagement());
		doc.setPiecedidentite(d.getPiecedidentite());
		return docrepo.save(doc);
	}



	@Override
	public Documents getDocumentById(int id) {
		// TODO Auto-generated method stub
		return docrepo.findById(id).get();
	}



	@Override
	public List<Documents> getAllDocuments() {
		// TODO Auto-generated method stub
		List<Documents>documents = new ArrayList<Documents>();
		docrepo.findAll().forEach(d ->documents.add(d));
		return documents;
	}







	@Override
	public Documents getByUser(User user) {
		// TODO Auto-generated method stub

		return user.getDocuments();
	}



	@Override
	public int delete(Documents documents) {
		// TODO Auto-generated method stub
		docrepo.delete(documents);
		return 1;
	}
	
	/*
	@Override
	public Documents getDocumentsByUser(User user) {
		return appUser.getProfile().getDocuments();
	}*/

}
