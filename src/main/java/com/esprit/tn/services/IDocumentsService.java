package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Documents;
import com.esprit.tn.entities.User;

public interface IDocumentsService {
	
	Documents addDocuments(Documents d, long userid);
	
	Documents addDocuments1(Documents d);

	public Documents updateDocuments(Documents d, int id);
	
	public void deleteDocuments(int id);
	
	public Documents getDocumentById(int id);
	
	public List<Documents> getAllDocuments();
	
	public Documents getByUser(User user);

	public int delete(Documents documents);





}
