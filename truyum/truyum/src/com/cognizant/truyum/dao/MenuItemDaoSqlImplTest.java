package com.cognizant.truyum.dao;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void main(String [] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		
	}
	public static void testGetMenuItemListAdmin() {
		 MenuItemDaoSqlImpl m=new  MenuItemDaoSqlImpl();
		 MenuItemDao menuItemDao=m;
		 List<MenuItem> mlist=menuItemDao.getMenuItemListAdmin();
		 for(int i=0;i<mlist.size();i++) {
			 MenuItem obj=mlist.get(i);
			 System.out.println(obj.getName()+" "+obj.getPrice()+" "+obj.isActive()+" "+obj.getDateOfLaunch()+" "+obj.getCategory()+" "+obj.isFreeDelivery());
			 
		 }
	}
	public static void testGetMenuItemListCustomer() {
		 MenuItemDaoSqlImpl m=new  MenuItemDaoSqlImpl();
		 MenuItemDao menuItemDao=m;
		 List<MenuItem> mlist=menuItemDao.getMenuItemListCustomer();
		 for(int i=0;i<mlist.size();i++) {
			 MenuItem obj=mlist.get(i);
			 System.out.println(obj.getName()+" "+obj.isFreeDelivery()+" "+obj.getPrice()+" "+obj.getCategory());
	}
		
	}
	public static void testModifyMenuItem() throws Exception {
		MenuItem menuItem=new MenuItem(4,"Black Forest Cake",(float)45.00,true,DateUtil.convertToDate("02/07/2017"),"Dessert",true);
		 MenuItemDaoSqlImpl m=new  MenuItemDaoSqlImpl();
		 MenuItemDao menuItemDao=m;
		 m.modifyMenuItem(menuItem);
		 MenuItem obj=menuItemDao.getMenuItem(menuItem.getId());
		 System.out.println(obj.getName()+" "+obj.isFreeDelivery()+" "+obj.getPrice()+" "+obj.getCategory());
		
	}
	
}
