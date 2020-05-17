package com.mitocode;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mitocode.Account;
import com.mitocode.MessageException;

public class TransferBetweenAccountsTest {

	private final static Logger log = Logger.getLogger(TransferBetweenAccountsTest.class);

	@Test
	public void transferBetweenAccounts() throws MessageException {

		log.info("Test: Transfer between Accounts.");
		log.info("transferAmount: " + 2000.00);

		cuentaOrigen = new Account(5000.00);
		cuentaDestino = new Account(1000.00);
		printAccounts();

		assertTrue(cuentaOrigen.transfer(cuentaDestino, 2000.00));
		printAccounts();
	}
	
	@Test(expected = MessageException.class)
	public void transferBetweenAccountsInsufficientFunds() throws MessageException {

		log.info("Test: Transfer between Accounts Insufficient Funds ");
		log.info("transferAmount: " + 5001.00);

		cuentaOrigen = new Account(5000.00);
		cuentaDestino = new Account(1000.00);
		printAccounts();

		cuentaOrigen.transfer(cuentaDestino, 5001.00);
		printAccounts();
	}

	@Test(expected = MessageException.class)
	public void transferBetweenAccountsMinimumAmount() throws MessageException {

		log.info("Test: Transfer between Accounts Minimum Amount");
		log.info("transferAmount: " + 0.01);

		cuentaOrigen = new Account(5000.00);
		cuentaDestino = new Account(1000.00);
		printAccounts();

		cuentaOrigen.transfer(cuentaDestino, 0.01);
		printAccounts();
	}

	@Before
	public void before() {
		cuentaOrigen = null;
	}

	@After
	public void after() {
		cuentaOrigen = null;
		cuentaDestino = null;
		log.info("Ends\n");
	}

	public void printAccounts() {
		log.info(cuentaOrigen + " " + cuentaDestino);

	}

	private Account cuentaOrigen;
	private Account cuentaDestino;
}
