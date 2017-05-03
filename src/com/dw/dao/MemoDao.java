package com.dw.dao;

import java.util.List;

import com.dw.model.Memo;

public interface MemoDao {
	 public Memo findMemoById(String id); 
	public boolean addMemo(Memo stu);
	public boolean delMemo(String id);
	public boolean updateMemo(Memo stu);
	@SuppressWarnings("unchecked")
	public List StSelect(String userId);
	

}
