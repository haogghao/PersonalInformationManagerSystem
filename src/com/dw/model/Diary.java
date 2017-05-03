package com.dw.model;

public class Diary {
	private String id;
	private String userid;
	private String time;
	private String addr;
	private String event;
	private String characters;

	public Diary(String id2, String time2, String addr2, String event2,
			String characters2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.time=time2;
		this.addr=addr2;
		this.event=event2;
		this.characters=characters2;
	}
	public Diary(String id2, String userId2,String time2, String addr2, String event2,
			String characters2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.userid=userId2;
		this.time=time2;
		this.addr=addr2;
		this.event=event2;
		this.characters=characters2;
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
	 * @return the characters
	 */
	public String getCharacters() {
		return characters;
	}

	/**
	 * @param characters
	 *            the characters to set
	 */
	public void setCharacters(String characters) {
		this.characters = characters;
	}

}
