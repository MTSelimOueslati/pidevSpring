package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Documents;
import com.esprit.tn.entities.User;

public interface IDocumentsService {
	
	Documents addDocuments(Documents d, int userid);

	public Documents updateDocuments(Documents d, int id);
	
	public void deleteDocuments(int id);
	
	public Documents getDocumentById(int id);
	
	public List<Documents> getAllDocuments();
	
	public Documents getByUser(User user);

	public int delete(Documents documents);


/* 
 * public Documents add(Documents documents, int profileId);
	public Documents update(Documents documents, int id);
	public Documents fetchByUser(AppUser appUser);
	public Documents fetchByProfile(Profile profile);
	public int delete(Documents documents);
	public int deleteById(int id);
	public List<Documents> fetchAll();
 * 
 * 
 * */


}
