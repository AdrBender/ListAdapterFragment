package com.adriano.listadapterfragment;

import android.support.v4.app.Fragment; 
import android.support.v4.app.FragmentManager; 
import android.support.v4.app.FragmentTransaction; 
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 


public class FragmentActivity extends AppCompatActivity { 

	Fragment fragment = null; 
	Button button1, button2; 

	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_fragment); 

		button1 = (Button) findViewById(R.id.button1); 
		button2 = (Button) findViewById(R.id.button2); 

	} 

	public void onClick(View view) { 
		switch (view.getId()){ 
			case R.id.button1: 
				fragment = new FragmentActivity1(); 
				loadFragment(fragment); 
				break; 
			case R.id.button2: 
				fragment = new FragmentActivity2(); 
				loadFragment(fragment); 
				break; 

		} 
    } 

	private void loadFragment(Fragment fragment) { 
		FragmentManager manager = getSupportFragmentManager(); 
		FragmentTransaction transaction = manager.beginTransaction(); 
		transaction.replace(R.id.fragment, fragment); 
		transaction.commit(); 
	} 

} 
