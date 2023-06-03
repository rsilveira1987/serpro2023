package com.database.mysql;

public class AccountModel {
	
	private int _id;
	private String _firstName;
	private String _secondName;
	private String _email;
	
	public AccountModel(int id, String firstName, String secondName, String email) {
		_id = id;
		_firstName = firstName;
		_secondName = secondName;
		_email = email;
	}
	
	public AccountModel(String firstName, String secondName, String email) {
		_firstName = firstName;
		_secondName = secondName;
		_email = email;
	}
	
	public int getId() {
		return _id;
	}
	
	public String getFirstName() {
		return _firstName;
	}
	
	public String getSecondName() {
		return _secondName;
	}
	
	public String getEmail() {
		return _email;
	}
	
	@Override
	public String toString() {
		return "AccountModel("+_email+")";
	}
}

