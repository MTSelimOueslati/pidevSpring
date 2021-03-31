package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Reclamation;

public interface IReclamationService {

	
		public void AddRec(Reclamation R);
		public List<Reclamation> getAllRec();
		public void deleteRec(int id);
		public Reclamation UpdateRec(Reclamation R,int a);
		public Reclamation UpdateState(int id); 
}	

