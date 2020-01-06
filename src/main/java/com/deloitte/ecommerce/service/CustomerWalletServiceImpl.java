package com.deloitte.ecommerce.service;
import com.deloitte.ecommerce.dao.*;
import com.deloitte.ecommerce.entities.*;
import com.deloitte.ecommerce.exception.*;
import java.util.Set;



public class CustomerWalletServiceImpl implements CustomerWalletService {
	private CustomerWalletDao dao;

	public CustomerWalletServiceImpl(CustomerWalletDao dao) {
		this.dao = dao;
	}

	@Override
	public void addCustomer(CustomerWallet e) {
		dao.addCustomer(e);
	}

	@Override
	public CustomerWallet findByMobileNo(String mobileNo) {
		if (mobileNo == null) {
			throw new IncorrectMobileNoException("id is incorrect");
		}
		CustomerWallet e = dao.findByMobileNo(mobileNo);
		return e;
	}

	@Override
	public Set<CustomerWallet> allCustomer() {
		Set<CustomerWallet> cust = dao.allCustomer();
		return cust;

	}

	@Override
	public void transferMoney(CustomerWallet sender, CustomerWallet receiver, double amt) {
		dao.transferMoney(sender, receiver, amt);
	}

	@Override
	public CustomerWallet getUserByUserMobile(String mobileNo) {
		  CustomerWallet user = dao.getUserByUserMobile(mobileNo);
	        return user;
	}

	@Override
	public boolean credentialsCorrect(String mobileNo, String password) {
		  boolean correct = dao.credentialsCorrect(mobileNo, password);
	        return correct;
	}

}