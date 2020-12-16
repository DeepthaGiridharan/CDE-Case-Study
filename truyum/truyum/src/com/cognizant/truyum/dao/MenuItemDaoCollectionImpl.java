package com.cognizant.truyum.dao;

import com.cognizant.truyum.util.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import com.cognizant.truyum.model.MenuItem;
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static List<MenuItem >menuItemList=new ArrayList<MenuItem>();
	public MenuItemDaoCollectionImpl() throws Exception {
		if(menuItemList==null) {
			String d="15/03/2017";
			Date dol=DateUtil.convertToDate(d);
			MenuItem obj=new MenuItem(1,"Sandwich",(float) 99.00,true,dol,"Main Course",true);
			menuItemList.add(obj);
			d="23/12/2017";
			dol=DateUtil.convertToDate(d);
			obj=new MenuItem(2,"Burger",(float)129.00,true,dol,"Main Course",false);
			menuItemList.add(obj);
			d="21/08/2018";
			dol=DateUtil.convertToDate(d);
			obj=new MenuItem(3,"Pizza",(float)149.00,true,dol,"Main Course",false);
			menuItemList.add(obj);
			d="02/07/2017";
			dol=DateUtil.convertToDate(d);
			obj=new MenuItem(4,"French Fries",(float)57.00,false,dol,"Starters",true);
			menuItemList.add(obj);
			d="02/11/2022";
			dol=DateUtil.convertToDate(d);
			obj=new MenuItem(5,"Chocolate Brownie",(float)32.00,true,dol,"Dessert",true);
			menuItemList.add(obj);
		}
			
			
		}
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCustomer=new ArrayList<MenuItem>();
		LocalDate date=LocalDate.now();
		Date currdate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
		for(int i=0;i<menuItemList.size();i++) {
			MenuItem obj=menuItemList.get(i);
			if(obj.getDateOfLaunch().before(currdate)||obj.getDateOfLaunch().equals(currdate)) {
				menuItemListCustomer.add(obj);
			}
		}
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		
		for(MenuItem m:menuItemList) {
			if(menuItem.equals(m)) {
				menuItemList.remove(m);
				menuItemList.add(menuItem);
				break;
				}
			}
		
}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for(MenuItem m:menuItemList) {
			if(menuItemId==m.getId()) {
				return m;
			}
		}
		return null;
	}
	}
