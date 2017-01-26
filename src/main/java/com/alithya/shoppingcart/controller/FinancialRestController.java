package com.alithya.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alithya.shoppingcart.service.ClientBalanceService;


@RestController
@RequestMapping("/rest/api/v1")
public class FinancialRestController {

	@Autowired
	private ClientBalanceService clientBalanceService;

	@RequestMapping(value = "/checkBalance/{clientId}/{cost}", method = RequestMethod.GET)
	public ResponseEntity<String> checkBalance(@PathVariable int clientId, @PathVariable double cost) throws Exception {
		String message = "";
		try {
			if(clientBalanceService.isBalanceEnough(clientId, cost))
				message = "isdone";
			else
				message = "balance is not enough";

		} catch (Exception e) {
			message = e.getMessage();
		}

		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateBalance/{clientId}/{account}", method = RequestMethod.GET)
	public ResponseEntity<String> updateBalance(@PathVariable int clientId, @PathVariable double account)
			throws Exception {

		String message = "";

		try {
			clientBalanceService.updateClietnBalance(clientId, account);
			message = "isdone";
			return new ResponseEntity<String>(message, HttpStatus.OK);

		} catch (Exception e) {
			message = e.getMessage();
			System.out.println(message);
			return new ResponseEntity<String>(message,HttpStatus.NOT_MODIFIED);
		}
		

	}

	@RequestMapping(value = "/rechargeBalance/{clientId}/{account}", method = RequestMethod.GET)
	public ResponseEntity<String> rechargeBalance(@PathVariable int clientId, @PathVariable double account)throws Exception {

		String message = "";
		try {
			clientBalanceService.rechargeClientBalance(clientId, account);
			message = "isdone";
			return new ResponseEntity<String>(message, HttpStatus.OK);

		} catch (Exception e) {
			message = e.getMessage();
			System.out.println(message);
			return new ResponseEntity<String>(message,HttpStatus.NOT_MODIFIED);
		}
		

	}

}
