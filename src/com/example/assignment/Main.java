
package com.example.assignment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Grace XU
 *
 * Oct 12, 2014
 */
public class Main extends Activity{
	
	private Button addButton ;
	private MyApp myApp;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addbill);
		addButton = (Button)this.findViewById(R.id.addButton);
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myApp = (MyApp)getApplication();		
				myApp.setName("Anh");
				//SWITCH INTERFACE
				Intent intent = new Intent(Main.this,Calculator.class);
				startActivity(intent);
				
			}
		});
		
		
		
	}

}
