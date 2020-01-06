package com.deloitte.ecommerce.dao;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.deloitte.ecommerce.entities.CustomerWallet;
import com.deloitte.ecommerce.exception.CustomerNotFoundException;




public class CustomerWalletDaoImpl implements CustomerWalletDao {
	  private Map<String, CustomerWallet> store = new HashMap<>();
	 

	    public CustomerWalletDaoImpl() {
	        CustomerWallet user1 = new CustomerWallet("9999999999", "Sujay",21,"1234");
	        store.put("9999999999", user1);
	        CustomerWallet user2 = new CustomerWallet("8888888888", "Sourav",30,"4321");
	        store.put("8888888888", user2);
	      
	    }
	@Override
	public void addCustomer(CustomerWallet e) {
		store.put(e.getMobileNo(), e);
		}
	@Override
	public CustomerWallet transferMoney(CustomerWallet sender,CustomerWallet receiver, double amt) {
		if (sender.getBalance() >= amt) {
			receiver.addBalance(amt);
			sender.addBalance(-amt);
		}
		return receiver;

	}

	@Override
	public CustomerWallet findByMobileNo(String mobileNo) {
		 CustomerWallet e = store.get(mobileNo);
	        if (e == null) {
	            throw new CustomerNotFoundException("customer not found for id=" + mobileNo);
	        }
	        return e;
	}

	@Override
	public Set<CustomerWallet> allCustomer() {
		Collection<CustomerWallet> cust = store.values();
		Set<CustomerWallet> custSet = new HashSet<>(cust);
		return custSet;
	}
	@Override
	public CustomerWallet getUserByUserMobile(String mobileNo) {
		  CustomerWallet user = store.get(mobileNo);
	        return user;
	}
	@Override
	public boolean credentialsCorrect(String mobileNo, String password) {
		  CustomerWallet user = store.get(mobileNo);
	        if (user == null) {
	            return false;
	        }
	        return user.getPassword().equals(password);
	}

}
