package Dao;

import java.util.List;

import Model.Student;



public interface StuDao {

	public Student findStudent(String stuNo,String psw) throws Exception;
	public int addStudent(Student stu);
	public List<Student> findAll() throws Exception;
	public int deleteById(String stuno) throws Exception;
	//public Score findscoreById(String stuno) throws Exception;
	public List<Student> findByMajor(String major) throws Exception;
	public Student findById(String stuNo) throws Exception;
	public int updateById(Student s);
	public int selectCom(String stuno,String comno);
	public Student PswCheck(String stuno);
	public int changePsw(Student a);
	public List<Student> findByComId(String comno) throws Exception;
}
