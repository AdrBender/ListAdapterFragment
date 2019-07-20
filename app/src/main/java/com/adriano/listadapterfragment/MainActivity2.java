package com.adriano.listadapterfragment;

import android.content.Intent; 
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
	 
public class MainActivity2 extends AppCompatActivity { 
 
	  	Button button; 
	  	TextView textView; 
	 
	    @Override 
	    protected void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.activity_main2); 
	 
	        //button = (Button) findViewById(R.id.button); 
	        textView = (TextView) findViewById(R.id.textView); 
	 
	        String personagem = getIntent().getStringExtra("Personagem"); 
	        textView.setText(personagem); 
	    } 
	 
	    //public void onClick(View view) { 
	        //Intent intent = new Intent(MainActivity2.this, MainActivity.class); 
	        //startActivity(intent); 
	    //} 
} 
