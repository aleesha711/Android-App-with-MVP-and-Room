package app.android.pattern.checkout;

import android.widget.Toast;

import app.android.pattern.ui.App;

/**
 * Created by Aleesha Kanwal on 13/05/2018.
 */

public class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	@Override
	public void pay(int amount) {
		System.out.println("Amount= " +amount +"$ and paid with credit/debit card");
		Toast.makeText(App.getAppContext(), "Amount= " +amount +"$ and paid with credit/debit card",
				Toast.LENGTH_SHORT).show();
}

}