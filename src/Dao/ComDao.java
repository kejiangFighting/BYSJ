package Dao;

import java.util.List;

import Model.Company;



public interface ComDao {
	
	public int addCom(Company com);
	public List<Company> findAll() throws Exception;
	public int deleteById(String comno) throws Exception;
	public Company findById(String comno) throws Exception;
	public int updateById(Company c);
	public int Select(String Teano,String comno);
	public int cancelById(String comno);
	public String hasTea(String comno) throws Exception;
}
