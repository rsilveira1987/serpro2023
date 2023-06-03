package com.database.pgsql;

import java.util.Comparator;

public class AccountModelComparatorSortByName implements Comparator<AccountModel> {

	@Override
	public int compare(AccountModel acct1, AccountModel acct2) {
		// TODO Auto-generated method stub
		return acct1.getName().compareTo(acct2.getName());
	}

}
