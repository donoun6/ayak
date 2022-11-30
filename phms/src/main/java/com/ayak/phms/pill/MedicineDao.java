package com.ayak.phms.pill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineDao {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jvx330";
	private static final String JDBC_PASSWORD = "jvx330";
	
	public MedicineDao() {
		try {
			Class.forName(JDBC_DRIVER); //JDBC 드라이버 로딩
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void add_Pill(Medicine medi) {
		String sql = "INSERT INTO Medicine(M_Company, M_DrugName, M_DrugEffect, M_useDrug, M_BeforeWarn, M_AfterWarn, M_Interaction, M_SideEffect, M_StorageMethod, M_DrugImage)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, medi.getM_Company());
				pstmt.setString(2, medi.getM_DrugName());
				pstmt.setString(3, medi.getM_DrugEffect());
				pstmt.setString(4, medi.getM_UseDrug());
				pstmt.setString(5, medi.getM_BeforeWarn());
				pstmt.setString(6, medi.getM_AfterWarn());
				pstmt.setString(7, medi.getM_Interaction());
				pstmt.setString(8, medi.getM_SideEffect());
				pstmt.setString(9, medi.getM_StorageMethod());
				pstmt.setString(10, medi.getM_DrugImage());
				pstmt.executeUpdate();
				
				System.out.println("INSERTED.......");
			}finally {
				pstmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Medicine> All_list(){
		String sql = "SELECT * FROM Medicine";
		List<Medicine> medi_list = new ArrayList<Medicine>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con =  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Medicine medi = new Medicine();
					medi.setM_Company(rs.getString("M_Company"));
					medi.setM_DrugName(rs.getString("M_DrugName"));
					medi.setM_DrugEffect(rs.getString("M_DrugEffect"));
					medi.setM_UseDrug(rs.getString("M_UseDrug"));
					medi.setM_BeforeWarn(rs.getString("M_BeforeWarn"));
					medi.setM_AfterWarn(rs.getString("M_AfterWarn"));
					medi.setM_Interaction(rs.getString("M_Interaction"));
					medi.setM_SideEffect(rs.getString("M_SideEffect"));
					medi.setM_StorageMethod(rs.getString("M_StorageMethod"));
					medi.setM_DrugImage(rs.getString("M_DrugImage"));
					medi_list.add(medi);
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return medi_list;
	}
	
	public List<Medicine> All_listByDrugName(String DrugName){
		String sql = "SELECT * FROM Medicine WHERE M_DrugName LIKE ?";
		List<Medicine> medi_list = new ArrayList<Medicine>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con =  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + DrugName + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Medicine medi = new Medicine();
					medi.setM_Company(rs.getString("M_Company"));
					medi.setM_DrugName(rs.getString("M_DrugName"));
					medi.setM_DrugEffect(rs.getString("M_DrugEffect"));
					medi.setM_UseDrug(rs.getString("M_UseDrug"));
					medi.setM_BeforeWarn(rs.getString("M_BeforeWarn"));
					medi.setM_AfterWarn(rs.getString("M_AfterWarn"));
					medi.setM_Interaction(rs.getString("M_Interaction"));
					medi.setM_SideEffect(rs.getString("M_SideEffect"));
					medi.setM_StorageMethod(rs.getString("M_StorageMethod"));
					medi.setM_DrugImage(rs.getString("M_DrugImage"));
					medi_list.add(medi);
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return medi_list;
	}
	
	public List<Medicine> All_listByCompany(String Company){
		String sql = "SELECT * FROM Medicine WHERE M_Company LIKE ?";
		List<Medicine> medi_list = new ArrayList<Medicine>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con =  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + Company + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Medicine medi = new Medicine();
					medi.setM_Company(rs.getString("M_Company"));
					medi.setM_DrugName(rs.getString("M_DrugName"));
					medi.setM_DrugEffect(rs.getString("M_DrugEffect"));
					medi.setM_UseDrug(rs.getString("M_UseDrug"));
					medi.setM_BeforeWarn(rs.getString("M_BeforeWarn"));
					medi.setM_AfterWarn(rs.getString("M_AfterWarn"));
					medi.setM_Interaction(rs.getString("M_Interaction"));
					medi.setM_SideEffect(rs.getString("M_SideEffect"));
					medi.setM_StorageMethod(rs.getString("M_StorageMethod"));
					medi.setM_DrugImage(rs.getString("M_DrugImage"));
					medi_list.add(medi);
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return medi_list;
	}
	
	public List<Medicine> All_listByDrugEffect(String Effect){
		String sql = "SELECT * FROM Medicine WHERE M_DrugEffect LIKE ?";
		List<Medicine> medi_list = new ArrayList<Medicine>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con =  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + Effect + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Medicine medi = new Medicine();
					medi.setM_Company(rs.getString("M_Company"));
					medi.setM_DrugName(rs.getString("M_DrugName"));
					medi.setM_DrugEffect(rs.getString("M_DrugEffect"));
					medi.setM_UseDrug(rs.getString("M_UseDrug"));
					medi.setM_BeforeWarn(rs.getString("M_BeforeWarn"));
					medi.setM_AfterWarn(rs.getString("M_AfterWarn"));
					medi.setM_Interaction(rs.getString("M_Interaction"));
					medi.setM_SideEffect(rs.getString("M_SideEffect"));
					medi.setM_StorageMethod(rs.getString("M_StorageMethod"));
					medi.setM_DrugImage(rs.getString("M_DrugImage"));
					medi_list.add(medi);
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return medi_list;
	}
	
	
}
