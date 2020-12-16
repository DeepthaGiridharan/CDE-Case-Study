package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	public static void main(String[] args) throws Throwable{
		testAddCartItem();
		testGetAllCartItems();
		 testRemoveCartItem();
	}
	public static void testAddCartItem() throws Throwable{
		CartDaoSqlImpl  c=new CartDaoSqlImpl ();
		 CartDao cartDao=c;
		 cartDao.addCartItem(1,4);
		 Cart cart=cartDao.getAllCartItems(1);
		 List<MenuItem> mlist=cart.getMenuItemList();
		 for(int i=0;i<mlist.size();i++) {
			 MenuItem obj=mlist.get(i);
			 System.out.println(obj.getName()+" "+obj.isFreeDelivery()+" "+obj.getPrice()+" "+obj.getCategory());
		 }
		 
	}
	public static void testGetAllCartItems() throws CartEmptyException{
		CartDaoSqlImpl  c=new CartDaoSqlImpl ();
		 CartDao cartDao=c;
		 Cart cart=cartDao.getAllCartItems(1);
		 List<MenuItem> mlist=cart.getMenuItemList();
		 for(int i=0;i<mlist.size();i++) {
			 MenuItem obj=mlist.get(i);
			 System.out.println(obj.getName()+" "+obj.isFreeDelivery()+" "+obj.getPrice()+" "+obj.getCategory());
		 }
		
	}
	public static void testRemoveCartItem() throws CartEmptyException{
		CartDaoSqlImpl  c=new CartDaoSqlImpl ();
		 CartDao cartDao=c;
		 cartDao.removeCartItem(1,4);
		 Cart cart;
		 cart=cartDao.getAllCartItems(1);
		 
		
	}
}
