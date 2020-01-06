package com.deloitte.ecommerce.dao;
import com.deloitte.ecommerce.entities.*;
import java.util.Set;

public interface CustomerWalletDao {
	
	    void addCustomer(CustomerWallet e);

	    CustomerWallet findByMobileNo(String mobileNo);
	    
	    CustomerWallet transferMoney(CustomerWallet sender,CustomerWallet receiver, double amt);

	    Set<CustomerWallet> allCustomer();
	    CustomerWallet getUserByUserMobile(String mobileNo);

	    boolean credentialsCorrect(String mobileNo, String password);

	}


