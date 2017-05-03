package com.dw.model;

public class Memo {
	private String id;
	private String userid;
	private String time;
	private String event;
	private String addr;

	public Memo(String id2, String time2, String event2, String addr2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.time=time2;
		this.event=event2;
		this.addr=addr2;
	}
	public Memo(String id2,String userId2, String time2, String event2, String addr2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.userid=userId2;
		this.time=time2;
		this.event=event2;
		this.addr=addr2;
	}
	public Memo() {
		// TODO Auto-generated constructor stub
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
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr
	 *            the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
