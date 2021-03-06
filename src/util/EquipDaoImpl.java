package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.EquipDao;
import Model.Admin;
import Model.Equip;
import Model.Notice;
import Model.Repair;
import conn.ConnectionFactory;

public class EquipDaoImpl implements EquipDao {

	public int addEquip(Equip nt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
	
			conn = ConnectionFactory.getConn();
			String sql = "insert into equip_tb(EquipID,Name,Manufacturer,Specification,Type,Status) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nt.getEquipID());
			pstmt.setString(2,nt.getName());
			pstmt.setString(3, nt.getManufacturer());
			pstmt.setString(4, nt.getSpecification());
			pstmt.setString(5, nt.getType());
			pstmt.setString(6, nt.getStatus());
			
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	
	public List<Equip> findAll() throws Exception {
		List<Equip> list = new ArrayList<Equip>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from Equip_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String equipID=rs.getString("EquipID");
				String name = rs.getString("Name");
				String manufacturer = rs.getString("Manufacturer");
				String specification = rs.getString("Specification");
				String  type= rs.getString("Type");
				String status = rs.getString("Status");
				Equip equip=new Equip(equipID, manufacturer, status, specification, name, type);
				
				list.add(equip);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<Repair> findRepairAll() throws Exception {
		List<Repair> list = new ArrayList<Repair>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from repair_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String equipID=rs.getString("EquipID");
				String userID = rs.getString("UserID");
				String described= rs.getString("Described");
				String  time= rs.getString("Time");
				String status = rs.getString("Status");
				if(status==null){
					status="未处理";
				}
				Repair repair=new Repair(userID, equipID, time, described, status);
				list.add(repair);				
				
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public Equip findById(String equipID) throws Exception {
		Equip equip = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		
			conn = ConnectionFactory.getConn();
			String sql = "select * from equip_tb where EquipID=?";
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,equipID);

			rs = pstmt.executeQuery();

			while(rs.next()){
				String equipid=rs.getString("EquipID");
				String name = rs.getString("Name");
				String manufacturer = rs.getString("Manufacturer");
				String specification = rs.getString("Specification");
				
				String  type= rs.getString("Type");
				String status = rs.getString("Status");
				equip=new Equip(equipid, manufacturer, status, specification, name, type);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return equip;
	}
	public int deleteById(String noticeno) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			System.out.println(noticeno);
			conn = ConnectionFactory.getConn();
			String sql = "delete from notice_tb where NoticeNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeno);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
	}
	public int changeStatus(Equip a) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
	
			conn = ConnectionFactory.getConn();
			String sql = "update equip_tb set Status= ? where EquipID= ?";
			pstmt=conn.prepareStatement(sql);
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getStatus());
			pstmt.setString(2, a.getEquipID());

			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public Equip findEquip(String seach) throws Exception {
		Equip equip = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		
			conn = ConnectionFactory.getConn();
			String sql = "select * from equip_tb where EquipID=?or Name=?";
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,seach);
			pstmt.setString(2,seach);

			rs = pstmt.executeQuery();

			while(rs.next()){
				String equipid=rs.getString("EquipID");
				String name = rs.getString("Name");
				String manufacturer = rs.getString("Manufacturer");
				String specification = rs.getString("Specification");
				
				String  type= rs.getString("Type");
				String status = rs.getString("Status");
				equip=new Equip(equipid, manufacturer, status, specification, name, type);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return equip;
		
		
	}
	public int addRepair(Repair nt) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
	
			conn = ConnectionFactory.getConn();
			String sql = "insert into Repair_tb(UserID,EquipID,Described,Time) values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nt.getUserID());
			pstmt.setString(2,nt.getEquipID());
			pstmt.setString(3,nt.getDescribe());
			pstmt.setString(4,nt.getTime());
			
			
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}


	public int updateById(Equip n) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = ConnectionFactory.getConn();
			String sql = "update equip_tb set Name= ?,Type= ?,Status= ?,Manufacturer= ? ,Specification=? where EquipID= ?";
			pstmt=conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,n.getName());
			pstmt.setString(2, n.getType());
			pstmt.setString(3, n.getStatus());
			pstmt.setString(4, n.getManufacturer());
			pstmt.setString(5, n.getSpecification());
			pstmt.setString(6,n.getEquipID());

			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	
	}


	public int deleteRepairById(String equipID) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			System.out.println(equipID);
			conn = ConnectionFactory.getConn();
			String sql = "delete from repair_tb where EquipID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,equipID);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
		
	}


	public int updateRepairById(Repair repair) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = ConnectionFactory.getConn();
			String sql = "update repair_tb set Status=? where EquipID= ?";
			pstmt=conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,repair.getStatus());
			pstmt.setString(2, repair.getEquipID());
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}


	public int deleteEqById(String equipID) throws Exception {
		
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			System.out.println(equipID);
			conn = ConnectionFactory.getConn();
			String sql = "delete from equip_tb where EquipID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,equipID);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
	
	}
	
}

