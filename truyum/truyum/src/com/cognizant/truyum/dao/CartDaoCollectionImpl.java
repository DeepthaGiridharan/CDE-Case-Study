package com.cognizant.truyum.dao;
import java.util.*;
import com.cognizant.truyum.model.*;
import com.cognizant.truyum.util.DateUtil;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;
	
	public CartDaoCollectionImpl() throws Exception{
		if(userCarts==null) {
			 userCarts=new HashMap<Long,Cart>();
			
			
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws Exception{
		MenuItemDaoCollectionImpl m=new MenuItemDaoCollectionImpl();
		 MenuItemDao menuItemDao=m;
		 MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		 
		 
			 if(userCarts.containsKey(userId)) {
				 Cart obj=userCarts.get(userId);
				 List<MenuItem> mlist=obj.getMenuItemList();
				 mlist.add(menuItem);
				 obj.setMenuItemList(mlist);
				 userCarts.put(userId,obj);
				 }
			 else {
				 Cart obj=new Cart(new ArrayList<MenuItem>(),0);
				 List<MenuItem> mlist=obj.getMenuItemList();
				 mlist.add(menuItem);
				 
				 userCarts.put(userId,obj);
			 }
			 
		 
		 
		 
		
	}
	public Cart getAllCartItems(long userId) throws CartEmptyException{
		
	
		
			 
				 Cart c=userCarts.get(userId);
				 List<MenuItem> mlist=c.getMenuItemList();
				 if(mlist==null||mlist.size()<1) {
					 throw new CartEmptyException();
				 }
				 else {
					 List<MenuItem> list=c.getMenuItemList();
				     
					 double total=0;
					 for(MenuItem m:list) {
						 
						 total=total+m.getPrice();
					 }
					 c.setTotal(total);
					 
					 
				 }
			 
	
		return c;
		
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException {
		Cart c=getAllCartItems(userId);
		List<MenuItem> mlist=c.getMenuItemList();
		for(MenuItem m:mlist) {
			if(m.getId()==menuItemId) {
				mlist.remove(m);
				break;
				
			}
			c.setMenuItemList(mlist);
			userCarts.put(userId,c);
		}
		
	}
	
}
	


