package zeromus.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private EditText subtotal_edit, tip_percent_edit, tip_amount_edit, total_edit = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		subtotal_edit = (EditText) findViewById(R.id.subtotal_edit);
		tip_percent_edit = (EditText) findViewById(R.id.tip_percent_edit);
		tip_amount_edit = (EditText) findViewById(R.id.tip_amount_edit);
		total_edit = (EditText) findViewById(R.id.total_edit);
	}

	public void calculate(View view)
	{
		Editable subtotal = subtotal_edit.getText();
		Editable tip_percent = tip_percent_edit.getText();
		Editable tip_amount = tip_amount_edit.getText();
		Editable total = total_edit.getText();

		if (subtotal.length() == 0 || tip_percent.length() == 0)
		{
			Toast.makeText(this, "Please fill in subtotal, tip percent, and tip amount", Toast.LENGTH_LONG).show();
			return;
		}
		else { calculateTotal(); }
	}

	public void calculateTotal()
	{
		float amount = Float.parseFloat(subtotal_edit.getText().toString());
		int tip_percent = Integer.parseInt(tip_percent_edit.getText().toString());
		System.out.println("3");
		
		float tip_amount = amount * tip_percent/100;
		float total = amount + tip_amount;
		//
		
		tip_amount_edit.setText(String.valueOf(tip_amount));
		total_edit.setText(String.valueOf(total));
	}
}