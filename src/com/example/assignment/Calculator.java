package com.example.assignment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Calculator extends ActionBarActivity {
	public String str = "";
	Character op = 'q';
	//numtemp: store first number value in an expression
	//num: store second number
	float num = 0, numtemp = 0;
	boolean end = false;
	EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        
        result = (EditText) findViewById(R.id.editText1);
        result.setText("");
    }

    public void btn1Clicked(View v){
    	autoReset();
    	insert(1);
    }
    public void btn2Clicked(View v){
    	autoReset();
    	insert(2);
    }
    public void btn3Clicked(View v){
    	autoReset();
    	insert(3);
    }
    public void btn4Clicked(View v){
    	autoReset();
    	insert(4);
    }
    public void btn5Clicked(View v){
    	autoReset();
    	insert(5);
    }
    public void btn6Clicked(View v){
    	autoReset();
    	insert(6);
    }
    public void btn7Clicked(View v){
    	autoReset();
    	insert(7);
    }
    public void btn8Clicked(View v){
    	autoReset();
    	insert(8);
    }
    public void btn9Clicked(View v){
    	autoReset();
    	insert(9);
    }
    public void btn0Clicked(View v){
    	autoReset();
    	insert(0);
    }
    
    //form a number from input digits
    private void insert(int i){
    	str += Integer.toString(i);
    	num = Integer.valueOf(str);
    	result.setText(str);
    }
    
    public void btnPlusClicked(View v){
    	//prevent complex expression
    	if(op != 'q'){
    		calculate();
    	}
    	perform();
    	op = '+';
    }
    public void btnMinClicked(View v){//prevent complex expression
    	if(op != 'q'){
    		calculate();
    	}
    	perform();
    	op = '-';
    }
    public void btnMultiClicked(View v){//prevent complex expression
    	if(op != 'q'){
    		calculate();
    	}
    	perform();
    	op = '*';
    }
    public void btnDivClicked(View v){//prevent complex expression
    	if(op != 'q'){
    		calculate();
    	}
    	perform();
    	op = '/';
    }
    public void btnEqualClicked(View v){
    	end = true; //set expression ending flag
    	calculate();
    }
    
    private void autoReset(){
    	if(end)
    		btnClearClicked(getCurrentFocus());
    	end = false;
    }
    //do the calculation: plus, minus, multiplication, division
    private void calculate(){
    	if(op == '+')
    		num += numtemp;
    	else if(op == '-')
    		num = numtemp - num;
    	else if(op == '*')
    		num *= numtemp;
    	else{
    		if(num == 0){
    			result.setText("Not a Number");
    			return;
    		}	
    		else
    			num = numtemp/num;
    	}
    	
    	result.setText(Float.toString((float)num));
    		
    }
    
    public void btnClearClicked(View v){
    	end = false;
    	num = 0;
    	numtemp = 0;
    	str = "";
    	op = 'q';
    	result.setText("");
    }
    
    //handle the job right after user input calculation type
    private void perform(){
    	str = "";
    	//store first number value to numtemp, and use num to store the second value in an expression
    	numtemp = num;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
