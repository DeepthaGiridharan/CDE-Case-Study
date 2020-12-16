package com.cognizant.truyum.dao;
import java.util.*;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;


public class MenuItemDaoCollectionImplTest {
public static void testGetMenuItemListAdmin() throws Exception {
	MenuItemDaoCollectionImpl m=new MenuItemDaoCollectionImpl();
	 MenuItemDao menuItemDao=m;
	 List<MenuItem> mlist=menuItemDao.getMenuItemListAdmin();
	 for(MenuItem menu:mlist) {
		
		 System.out.println(menu.toString());
		 
	 }
}
public static void testGetMenuItemListCustomer() throws Exception {
	MenuItemDaoCollectionImpl m=new MenuItemDaoCollectionImpl();
	 MenuItemDao menuItemDao=m;
	 List<MenuItem> mlist=menuItemDao.getMenuItemListCustomer();
	 for(MenuItem menu:mlist) {
			
		 System.out.println(menu.toString());
		 
	 }
	
	
}
public static void  testModifyMenuItem() throws Exception {
	
	MenuItem menuItem=new MenuItem(4,"Black Forest Cake",(float)45.00,true,DateUtil.convertToDate("02/07/2017"),"Dessert",true);
	MenuItemDaoCollectionImpl m=new MenuItemDaoCollectionImpl();
	 MenuItemDao menuItemDao=m;
	
	 menuItemDao.modifyMenuItem(menuItem);
	
	
	 System.out.println(menuItemDao.getMenuItem(4).toString());
	
}
public static void main(String [] args) throws Exception {
	testGetMenuItemListAdmin();
	testGetMenuItemListCustomer();
	 testModifyMenuItem();
}
}
