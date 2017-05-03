package com.dw.dao;

import java.util.List;

import com.dw.model.Property;

public interface PropertyDao {
	public Property findPropertyByid(String id);
	public boolean addProperty(Property stu);
	public boolean delProperty(String id);
	public boolean updateProperty(Property stu);
	@SuppressWarnings("unchecked")
	public List StSelect(String userId);
}
