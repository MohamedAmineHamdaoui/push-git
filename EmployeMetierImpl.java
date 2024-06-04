package com.elhaouari.bank.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhaouari.bank.dao.EmployeRepository;
import com.elhaouari.bank.entity.Employe;

@Service
public class EmployeMetierImpl implements EmployeMetier{

	@Autowired
	private EmployeRepository repository;
	
	@Override
	public Employe save(Employe e) {
		return repository.save(e);
	}

	@Override
	public List<Employe> list() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
