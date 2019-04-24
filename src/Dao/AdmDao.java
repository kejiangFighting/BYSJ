package Dao;

import Model.Admin;

public interface AdmDao {

	public Admin findAdmin(String ano,String apsw) throws Exception;
	public Admin PswCheck(String adminno);
	public int changePsw(Admin a);
}
