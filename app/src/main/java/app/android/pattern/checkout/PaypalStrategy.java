package app.android.pattern.checkout;

import android.widget.Toast;

import app.android.pattern.ui.App;

/**
 * Created by Aleesha Kanwal on 13/05/2018.
 */

public class PaypalStrategy implements PaymentStrategy {

	private String emailId;
	private String password;
	
	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println("Amount= " +amount +"$ and paid using Paypal");
		Toast.makeText(App.getAppContext(), "Amount= " +amount +"$ and paid using Paypal",
				Toast.LENGTH_SHORT).show();
	}

}