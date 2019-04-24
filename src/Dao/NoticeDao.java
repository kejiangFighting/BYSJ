package Dao;

import java.sql.SQLException;
import java.util.List;

import Model.Notice;



public interface NoticeDao {

	public int addNotice(Notice nt);
	public List<Notice> findAll() throws Exception;
	public int deleteById(String noticeno) throws Exception;
	public Notice findById(String noticeno) throws Exception;
	public int updateById(Notice n);
	public List<Notice> findNotices(int page , int count) throws SQLException;
	 public int count() throws SQLException;
}
