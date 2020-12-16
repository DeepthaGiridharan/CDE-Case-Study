package com.cognizant.truyum.dao;



import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
public class CartDaoCollectionImplTest {
	public static void testAddCartItem() throws Exception {
		 CartDaoCollectionImpl c=new  CartDaoCollectionImpl();
		 CartDao cartDao=c;
		 cartDao.addCartItem(1,4);
		 Cart cart=cartDao.getAllCartItems(1);
		 for(MenuItem m:cart.getMenuItemList()) {
			 System.out.println(m.toString());
		 }
		
	}
	public static void testGetAllCartItems() throws Exception {
		CartDaoCollectionImpl c=new  CartDaoCollectionImpl();
		 CartDao cartDao=c;
		 Cart cart=cartDao.getAllCartItems(1);
		 for(MenuItem m:cart.getMenuItemList()) {
			 System.out.println(m.toString());
		 }
		 
	}
	public static void testRemoveCartItem() throws Exception {
		CartDaoCollectionImpl c=new  CartDaoCollectionImpl();
		 CartDao cartDao=c;
		 cartDao.removeCartItem(1,4);
		 try {
		 Cart cart=cartDao.getAllCartItems(1);
		 }
		 catch(CartEmptyException e) {
			 System.out.println("Item Removed Sucessfully");
		 }
		 
		 
		
	}
	public static void main(String [] args) throws Throwable {
		testAddCartItem();
		testGetAllCartItems();
		 testRemoveCartItem();
	}
	

}
