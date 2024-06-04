package com.elhaouari.bank.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhaouari.bank.dao.ClientRepository;
import com.elhaouari.bank.entity.Client;

@Service
public class ClientMetierImpl implements ClientMetier{

	@Autowired
	private ClientRepository repository;
	
	@Override
	public Client save(Client c) {
		return repository.save(c);
	}

	@Override
	public List<Client> list() {
		return repository.findAll();
	}

}
