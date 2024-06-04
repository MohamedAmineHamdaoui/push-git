package com.elhaouari.bank.metier;

import java.util.List;

import com.elhaouari.bank.entity.Employe;

public interface EmployeMetier {

	public Employe save(Employe e);
	public List<Employe> list();
}
