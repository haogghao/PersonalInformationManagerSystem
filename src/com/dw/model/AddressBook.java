package com.dw.model;

public class AddressBook {
	private String id;
	private String userid;
	private String name;
	private String contact_way;
	private String work_addr;
	private String city;
	private String beizhu;
    public AddressBook(){};
	public AddressBook(String name, String contact_way, String work_addr, String city,String beizhu){
		this.name=name;
		this.contact_way=contact_way;
		this.work_addr=work_addr;
		this.city=city;
		this.beizhu=beizhu;	
	};
	public AddressBook(String id,String name, String contact_way, String work_addr, String city,String beizhu){
		this.id=id;
		this.name=name;
		this.contact_way=contact_way;
		this.work_addr=work_addr;
		this.city=city;
		this.beizhu=beizhu;
	};
	public AddressBook(String id,String userid,String name, String contact_way, String work_addr, String city,String beizhu){
		this.id=id;
		this.userid=userid;
		this.name=name;
		this.contact_way=contact_way;
		this.work_addr=work_addr;
		this.city=city;
		this.beizhu=beizhu;
	};
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the contact_way
	 */
	public String getContact_way() {
		return contact_way;
	}

	/**
	 * @param contact_way
	 *            the contact_way to set
	 */
	public void setContact_way(String contact_way) {
		this.contact_way = contact_way;
	}

	/**
	 * @return the work_addr
	 */
	public String getWork_addr() {
		return work_addr;
	}

	/**
	 * @param work_addr
	 *            the work_addr to set
	 */
	public void setWork_addr(String work_addr) {
		this.work_addr = work_addr;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the beizhu
	 */
	public String getBeizhu() {
		return beizhu;
	}

	/**
	 * @param beizhu
	 *            the beizhu to set
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}
