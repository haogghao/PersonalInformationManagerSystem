package com.dw.model;
/**
 *  ����Ա��
 * @author DY1101shaoyuxian
 *
 */
public class User {
	private String userid;//����Աid
	private String username;//�û���
	private String password;//����
    private String status;
	public User() {

	}

	public User(String id,String username, String password,String status) {
		this.userid=id;
		this.username = username;
		this.password = password;
		this.status=status;
	}

	public String getUserid() {
		return userid;
	}

	public void setId(String id) {
		this.userid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
