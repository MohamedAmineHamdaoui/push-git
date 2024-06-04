package com.elhaouari.bank.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhaouari.bank.dao.CompteRepository;
import com.elhaouari.bank.entity.Compte;

@Service
public class CompteMetierImpl implements CompteMetier{

	@Autowired
	private CompteRepository repository;
	
	@Override
	public Compte save(Compte e) {
		return repository.save(e);
	}

	@Override
	public List<Compte> list() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Compte findOne(String code) {
		try {
			return repository.findById(code).get();
		}
		catch (Exception e){
			throw new RuntimeException("Compte not exists");
		}
	}

}
