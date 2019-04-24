package Dao;

import java.util.List;

import Model.Teacher;


public interface TeaDao {

	public Teacher findTeacher(String teaNo,String psw) throws Exception;
	public int addTeacher(Teacher tea);
	public List<Teacher> findAll() throws Exception;
	public int deleteById(String teano);
	public Teacher findById(String teaNo) throws Exception;
	public int updateById(Teacher t);
	public int changePsw(Teacher t);
	public Teacher PswCheck(String teano);
	public int selectComById(String comno, String teano);
	public String hasCom(String teano) throws Exception;
}
