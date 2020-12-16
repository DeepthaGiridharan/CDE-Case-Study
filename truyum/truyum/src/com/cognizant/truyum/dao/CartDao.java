package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.*;


public interface CartDao {
	public void addCartItem(long userId ,long menuItemId) throws Exception;
	 public Cart getAllCartItems(long userId)throws CartEmptyException; 
	 public void removeCartItem(long userId,long menuItemId) throws CartEmptyException;

}
