package com.database.pgsql;

import java.util.Comparator;

public class AccountModelComparatorSortByEmail implements Comparator<AccountModel> {

	@Override
	public int compare(AccountModel acct1, AccountModel acct2) {
		// TODO Auto-generated method stub
		return acct1.getEmail().compareTo(acct2.getEmail());
	}

}
