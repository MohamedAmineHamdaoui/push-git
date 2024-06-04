package com.elhaouari.bank.metier;

import java.util.List;

import com.elhaouari.bank.entity.Compte;

public interface CompteMetier {

	public Compte save(Compte e);
	public List<Compte> list();
	public Compte findOne(String code);
}
