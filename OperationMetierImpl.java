package com.elhaouari.bank.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elhaouari.bank.dao.CompteRepository;
import com.elhaouari.bank.dao.EmployeRepository;
import com.elhaouari.bank.dao.OperationRepository;
import com.elhaouari.bank.entity.Compte;
import com.elhaouari.bank.entity.Employe;
import com.elhaouari.bank.entity.Operation;
import com.elhaouari.bank.entity.Retrait;
import com.elhaouari.bank.entity.Versement;

@Service
@Transactional
public class OperationMetierImpl implements OperationMetier{

	@Autowired
	private OperationRepository repository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@Override
	public boolean verser(String code, double montant, Long codeEmp) {
		
		Compte compte = compteRepository.findById(code).get();
		if (compte == null) {
			throw new RuntimeException("Compte not found");
		}
		Employe employe = employeRepository.findById(codeEmp).get();
		
		Versement v = new Versement(new Date(), montant, compte, employe);
		compte.setSolde(compte.getSolde() + montant);
		repository.save(v);
		
		return true;
	}

	@Override
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte compte = compteRepository.findById(code).get();
		if (compte == null) {
			throw new RuntimeException("Compte not found");
		}
		if (compte.getSolde() < montant) 
			throw new RuntimeException("Solde insuffisant");
		
		Employe employe = employeRepository.findById(codeEmp).get();
		
		Retrait v = new Retrait(new Date(), montant, compte, employe);
		compte.setSolde(compte.getSolde() - montant);
		repository.save(v);
		
		return true;
	}

	@Override
	public boolean virement(String code1, String code2, double montant, Long codeEmp) {
		
		this.retirer(code1, montant, codeEmp);
		this.verser(code2, montant, codeEmp);
		
		return true;
	}

	@Override
	public PageOperation operations(String compte, int page, int size) {

		Page<Operation> ops = repository.findByCompte(compte, PageRequest.of(page, size));
		
		PageOperation pOp = new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setPage(page);
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setTotalPage(ops.getTotalPages());
		pOp.setTotalOperation(ops.getTotalElements());
		
		return pOp;
	}

}
