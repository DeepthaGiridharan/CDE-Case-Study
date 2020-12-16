package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao
{

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		try {
			Connection con=ConnectionHandler.getConnection();
			List<MenuItem> mlist=new ArrayList<MenuItem>();
			PreparedStatement stmt=con.prepareStatement("select * from menu_item");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				MenuItem m=new MenuItem(rs.getLong("me_id"),rs.getString("me_name"),rs.getFloat("me_price"),rs.getBoolean("me_active"),rs.getDate("me_date_of_launch "),rs.getString("me_category"),rs.getBoolean("me_free_delivery"));
				mlist.add(m);
			}
			return mlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		try {
			Connection con=ConnectionHandler.getConnection();
			List<MenuItem> mlist=new ArrayList<MenuItem>();
			PreparedStatement stmt=con.prepareStatement("select * from menu_item where"+ "me_active=true && me_date_of_launch<=curdate( )");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				MenuItem m=new MenuItem(rs.getLong("me_id"),rs.getString("me_name"),rs.getFloat("me_price"),rs.getBoolean("me_active"),rs.getDate("me_date_of_launch "),rs.getString("me_category"),rs.getBoolean("me_free_delivery"));
				mlist.add(m);
			}
			return mlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		try {
			Connection con=ConnectionHandler.getConnection();
			long menuItemId=menuItem.getId();
			PreparedStatement stmt=con.prepareStatement("update menu_item set me_name=?,me_price=?,me-active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? where me_id=?");
			stmt.setString(1,menuItem.getName());
			stmt.setFloat(2, menuItem.getPrice());
			stmt.setBoolean(3,menuItem.isActive());
			stmt.setDate(4,(Date) menuItem.getDateOfLaunch());
			stmt.setString(5,menuItem.getCategory());
			stmt.setBoolean(6,menuItem.isFreeDelivery());
			stmt.setLong(7,menuItemId);
			
			int rowsaff=stmt.executeUpdate();
			
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		try {
			Connection con=ConnectionHandler.getConnection();
			
			PreparedStatement stmt=con.prepareStatement("select * from menu_item where me_id=?");
			stmt.setLong(1,menuItemId);
			ResultSet rs=stmt.executeQuery();
			MenuItem m=new MenuItem(rs.getLong("me_id"),rs.getString("me_name"),rs.getFloat("me_price"),rs.getBoolean("me_active"),rs.getDate("me_date_of_launch "),rs.getString("me_category"),rs.getBoolean("me_free_delivery"));
			return m;
			
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
