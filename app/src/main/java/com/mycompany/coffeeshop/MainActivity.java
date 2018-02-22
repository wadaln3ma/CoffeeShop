package com.mycompany.coffeeshop;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.mycompany.coffeeshop.*;


public class MainActivity extends Activity {

	int quantity = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		

	}


	public void Increment (View view){
		if (quantity >= 100){
			Toast.makeText(this, "You can't Order more than a hundred Cups", Toast.LENGTH_SHORT).show();
			return;
		}
		quantity ++;
		displayQuantity(quantity);
	}

	public void Decrement (View view){
		if (quantity == 1){
			Toast.makeText(this, "You can't order less than one coffee", Toast.LENGTH_SHORT).show();
			return;
		}
		quantity --;
		displayQuantity(quantity);
	}

	public void calculatePrice (View view){
		int price = 5;
		price *= quantity;
		EditText name = (EditText) findViewById(R.id.txt_name);
		String Name = name.getText().toString();
		String priceMessage = Name +"\n"
		+ "$" + price ;
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.setData(Uri.parse("mailto:"));
		intent.putExtra(Intent.EXTRA_SUBJECT
						, "Order For " + Name);
		intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		}
	
	}

	private void displayQuantity(int quanx){
		TextView quantit = (TextView) findViewById(R.id.quantity);
		quantit.setText(String.valueOf(quantity));
	}

	
}

