package com.esprit.tn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Offer;
import com.esprit.tn.entities.Reclamation;
import com.esprit.tn.repositories.OfferRepository;
import com.esprit.tn.repositories.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService {

	
	
	
	@Autowired
	private ReclamationRepository iReclamationrep;
	
	@Override
	public void AddRec(Reclamation R) {
		// TODO Auto-generated method stub
	iReclamationrep.save(R);
	}
	
	@Override
	public List<Reclamation> getAllRec() {
		// TODO Auto-generated method stub
		return (List<Reclamation>) iReclamationrep.findAll();
	}
	@Override
	public void deleteRec(int id) {
		// TODO Auto-generated method stub
		iReclamationrep.deleteById(id);
	}
	@Override
	public Reclamation UpdateRec(Reclamation R,int id) {
		// TODO Auto-generated method stub
		Reclamation Reclamation= iReclamationrep.findById(id).get();
		Reclamation.setDescription(R.getDescription());
		Reclamation.setSubject(R.getSubject());
		//Reclamation.setState(R.getState());
		iReclamationrep.save(R);
		return R;
	}
	
	public Reclamation UpdateState(int id) {
		// TODO Auto-generated method stub
		Reclamation Reclamation= iReclamationrep.findById(id).get();
		String A=Reclamation.getState(); 
		if (A.equals("SOLVED"))
		{
			throw new RuntimeException("already SOLVED!!");
			
		}
		else  
		{	Reclamation.setState("SOLVED");
		iReclamationrep.save(Reclamation);
			return Reclamation;
		}
	}
}
