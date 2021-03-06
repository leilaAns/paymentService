package com.alithya.shoppingcart.service;

import com.alithya.shoppingcart.exception.FinancialServiceException;

public interface ClientBalanceService {

	public double getClientBalance(int clientId) throws FinancialServiceException;

	public int updateClietnBalance(int clientId, double account) throws FinancialServiceException;

	public int rechargeClientBalance(int clientId, double account)throws FinancialServiceException;
	
	public boolean isBalanceEnough(int clientId, double cost) throws FinancialServiceException;

}
