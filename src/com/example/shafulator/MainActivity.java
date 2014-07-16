package com.example.shafulator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView Disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Disp =(TextView)findViewById(R.id.shaffles);
        Disp.setText("0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    static boolean isempty=true;
    public void num_Clicked(View sender)
    {
    	Button bt=(Button)sender;
    	if(Disp.getText().length()>10)return;
    	if(isempty)
	    	{
    		if(bt.getText().toString().equals("0"))return;
    		Disp.setText(bt.getText());	
    		isempty=false;
	    	}
    	else {
        	Disp.append(bt.getText());
    	}
    }
    static float accumulator=0;
    static short operationToDo=0;
    public void op_Clicked(View sender)
    {
    	Button bt=(Button)sender;
    	switch (operationToDo)
    	{
    	case 0:
    		accumulator+= Float.parseFloat(Disp.getText().toString());
        	Disp.setText(Float.toString(accumulator));
    	break;
    	case 1:
    		accumulator-= Float.parseFloat(Disp.getText().toString());
        	Disp.setText(Float.toString(accumulator));
    	break;
    	case 2:
    		accumulator*= Float.parseFloat(Disp.getText().toString());
        	Disp.setText(Float.toString(accumulator));
    	break;
    	case 3:
    		accumulator/= Float.parseFloat(Disp.getText().toString());
        	Disp.setText(Float.toString(accumulator));
    	break;
    	case 4:
    		accumulator= Float.parseFloat(Disp.getText().toString());
        	Disp.setText(Float.toString(accumulator));
    	break;
    	case 5:
    		accumulator= -Math.abs(Float.parseFloat(Disp.getText().toString()));
        	Disp.setText(Float.toString(accumulator));
    	break;
    	case 6:
    		Disp.setText("0");
    	break;
    	}
    	if(bt.getText().toString().equals("+")) operationToDo=0;
    	if(bt.getText().toString().equals("-")) operationToDo=1;
    	if(bt.getText().toString().equals("x")) operationToDo=2;
    	if(bt.getText().toString().equals("/")) operationToDo=3;
    	if(bt.getText().toString().equals("=")) operationToDo=4;
    	if(bt.getText().toString().equals("Neg")) operationToDo=5;
    	if(bt.getText().toString().equals("C")) operationToDo=6;
    	isempty=true;
    }
}
