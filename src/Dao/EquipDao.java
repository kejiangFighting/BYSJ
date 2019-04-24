package Dao;

import java.sql.SQLException;
import java.util.List;

import Model.Equip;

public interface EquipDao {
	
	public int addEquip(Equip equip);
	public List<Equip> findAll() throws Exception;
	public int deleteById(String equipID) throws Exception;
//	public Notice findById(String noticeno) throws Exception;
	//public int updateById(Notice n);
	//public List<Notice> findNotices(int page , int count) throws SQLException;
	// public int count() throws SQLException;

}
