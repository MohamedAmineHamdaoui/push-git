package com.elhaouari.bank.metier;

import org.springframework.stereotype.Service;

@Service
public interface OperationMetier {
	
	public boolean verser(String code, double montant, Long codeEmp);
	public boolean retirer(String code, double montant, Long codeEmp);
	public boolean virement(String code1, String code2, double montant, Long codeEmp);
	public PageOperation operations(String compte, int page, int size);
	
}
