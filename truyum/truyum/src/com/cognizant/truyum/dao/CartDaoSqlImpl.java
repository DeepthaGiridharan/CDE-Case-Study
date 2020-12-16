package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) throws Exception, SQLException {
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into cart "+"(ct_us_id,ct_pr_id) "+"values"+"(?,?)");
		stmt.setLong(1,userId);
		stmt.setLong(2, menuItemId);
		int rowsaff=stmt.executeUpdate();
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		try {
			Connection con=ConnectionHandler.getConnection();
			List<MenuItem> menuItem=new ArrayList<MenuItem>();
			Cart c=new Cart(menuItem,0);
			PreparedStatement stmt=con.prepareStatement("select * from menu_item m join cart c on me_id=c.ct_pr_id where c.ct_us_id=? ");
			stmt.setLong(1,userId);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				MenuItem m=new MenuItem(rs.getLong("me_id"),rs.getString("me_name"),rs.getFloat("me_price"),rs.getBoolean("me_active"),rs.getDate("me_date_of_launch "),rs.getString("me_category"),rs.getBoolean("me_free_delivery"));
				menuItem.add(m);
			}
			PreparedStatement stmt1=con.prepareStatement("select sum(m.me_price) from menu_item m join cart c on me_id=c.ct_pr_id where c.ct_us_id=? ");
			stmt1.setLong(1,userId);
			ResultSet rs1=stmt1.executeQuery();
			double totalPrice=rs1.getDouble("sum(m.me_price)");
			c.setMenuItemList(menuItem);
			c.setTotal(totalPrice);
			return c;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException {
		try {
			Connection con=ConnectionHandler.getConnection();
			PreparedStatement stmt=con.prepareStatement("delete from cart where ct_us_id=? and ct_pr_id=?");
			stmt.setLong(1,userId);
			stmt.setLong(2, menuItemId);
			ResultSet rs=stmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
