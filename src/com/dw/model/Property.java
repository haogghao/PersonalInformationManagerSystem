package com.dw.model;

public class Property {
	private String id;
	private String userid;
	private String income;
	private String project;
	private String money;
	private String time;
	private String left_money;

	public Property(String id2, String income2, String project2, String money2,
			String time2,String left_money2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		
		this.income=income2;
		this.project=project2;
		this.money=money2;
		this.time=time2;
		this.left_money=left_money2;
	}
	
	public Property(String id2,String userid2, String income2, String project2, String money2,
			String time2,String left_money2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.userid=userid2;
		this.income=income2;
		this.project=project2;
		this.money=money2;
		this.time=time2;
		this.left_money=left_money2;
	}

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
	 * @return the income
	 */
	public String getIncome() {
		return income;
	}

	/**
	 * @param income
	 *            the income to set
	 */
	public void setIncome(String income) {
		this.income = income;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the left_money
	 */
	public String getLeft_money() {
		return left_money;
	}

	/**
	 * @param left_money
	 *            the left_money to set
	 */
	public void setLeft_money(String left_money) {
		this.left_money = left_money;
	}

}
