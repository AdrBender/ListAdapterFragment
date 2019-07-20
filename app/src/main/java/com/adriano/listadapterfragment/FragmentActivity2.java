package com.adriano.listadapterfragment;

import android.os.Bundle; 
import android.support.annotation.Nullable; 
import android.support.v4.app.Fragment; 
import android.view.LayoutInflater; 
import android.view.View; 
import android.view.ViewGroup; 
import android.widget.TextView; 
	 
	 
public class FragmentActivity2 extends Fragment { 
	 
    @Nullable 
    @Override 
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { 
        View view = inflater.inflate(R.layout.activity_fragment2 , container, false); 
 
        TextView text = (TextView) view.findViewById(R.id.textView); 
 
        text.setText("Fragment 2"); 
 
        return view; 
    } 
} 

