package com.dw.dao;

import java.util.List;

import com.dw.model.Diary;

public interface DiaryDao {
	public Diary findDiaryByid(String id);
	public boolean addDiary(Diary stu);
	public boolean delDiary(String id);
	public boolean updateDiary(Diary stu);
	@SuppressWarnings("unchecked")
	public List StSelect(String userId);

}
