package com.alithya.shoppingcart.repository;

import com.alithya.shoppingcart.exception.FinancialServiceException;

public interface ClientBalanceRepository {

	public double getClientBalance(int clientId) throws FinancialServiceException;

	public int updateClientBalance(int clientId, double account) throws FinancialServiceException ;
	
	public int rechargeClientBalance(int clientId,double account) throws FinancialServiceException;
	
	public boolean isBalanceEnough(int clientId, double cost) throws FinancialServiceException;

}
