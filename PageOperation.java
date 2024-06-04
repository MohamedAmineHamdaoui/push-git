package com.elhaouari.bank.metier;

import java.io.Serializable;
import java.util.List;

import com.elhaouari.bank.entity.Operation;

public class PageOperation implements Serializable{
	private static final long serialVersionUID = -5201131503244617917L;
	
	private List<Operation> operations;
	private int page;
	private int nombreOperations;
	private long totalOperation;
	private int totalPage;
	
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperations() {
		return nombreOperations;
	}
	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}
	public long getTotalOperation() {
		return totalOperation;
	}
	public void setTotalOperation(long l) {
		this.totalOperation = l;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
