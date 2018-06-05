package app.android.pattern.checkout;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.android.pattern.roomdatabase.database.AppDataBase;
import app.android.pattern.roomdatabase.entity.Cart;
import app.android.pattern.ui.App;

/**
 * Created by Aleesha Kanwal on 13/05/2018.
 */

public class ShoppingCart {

	List<Cart> items;
	
	public ShoppingCart(){
		initializeItems();
	}

	public void initializeItems(){
		this.items=new ArrayList<Cart>();
		AppDataBase database = AppDataBase.getAppDatabase(App.getAppContext());
		items = database.catDao().loadAllDataList();
	}

	public int calculateTotal(){
		int sum = 0;
		for(Cart bookEntity : items){
			sum += bookEntity.price;
		}
		Log.e("checkout", String.valueOf(sum));
		return sum;
	}

	public void pay(PaymentStrategy paymentMethod){
		initializeItems();
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}