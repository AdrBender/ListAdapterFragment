package com.adriano.listadapterfragment;

import android.support.v4.app.Fragment; 
import android.support.v4.app.FragmentManager; 
import android.support.v4.app.FragmentPagerAdapter; 
import android.support.v4.view.ViewPager; 
import android.support.v7.app.AppCompatActivity; 
import android.support.design.widget.TabLayout; 
import android.os.Bundle; 
import java.util.ArrayList; 
import java.util.List; 


public class AdapterViewActivity extends AppCompatActivity { 

	@Override 
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_adapterview); 

		setupViewPager(); 
	} 

	private void setupViewPager() {
		
		//adapter para o viewpager
		AbasPagerAdapter adapter = new AbasPagerAdapter(getSupportFragmentManager()); 
		
		//adicionando fragments para o adapter 
		adapter.addFragment(new FragmentActivity1()); 
		adapter.addFragment(new FragmentActivity2()); 
		
		//inicializando o viewpager 
		ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
		
		//setando o adapter 
		vp.setAdapter(adapter); 

		//inicializando o tablayout 
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
		
		//passando o viewpager ao tab layout
		tabLayout.setupWithViewPager(vp); 
		tabLayout.setBackgroundColor(getResources().getColor(R.color.white)); 
		tabLayout.setTabTextColors(getResources().getColor(R.color.blue), getResources().getColor(R.color.black)); 

		//estabeleca os indices dos tabs e texto, icones para seus tabs
		tabLayout.getTabAt(0).setText("PagerView 1"); 
		tabLayout.getTabAt(1).setText("PagerView 2"); 
	} 

	class AbasPagerAdapter extends FragmentPagerAdapter { 

		private final List<Fragment> mFragmentList = new ArrayList<>(); 

		public AbasPagerAdapter(FragmentManager fm) { 
			super(fm); 
		} 

		@Override 
		public Fragment getItem(int position) { 
			return mFragmentList.get(position); 
		} 

		@Override 
		public int getCount() { 
			return mFragmentList.size(); 
		} 

		public void addFragment(Fragment fragment) { 
			mFragmentList.add(fragment); 
		} 
	} 
} 

