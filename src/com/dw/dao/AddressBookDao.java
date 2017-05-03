package com.dw.dao;

import java.util.List;

import com.dw.model.AddressBook;

public interface AddressBookDao {
	public boolean addAddressBook(AddressBook stu);
	public boolean delAddressBook(String id);
	public boolean updateAddressBook(AddressBook stu);
	@SuppressWarnings("unchecked")
	public List StSelect(String userId);
	public AddressBook findAddressBookById(String Id);
	public List<AddressBook> findAddressBookByName(String userId,String name);

}
