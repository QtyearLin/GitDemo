package com.example.testviewpager;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class TestFragment1 extends BaseFragment {
	private ArrayList<TestBean> mTestData = new ArrayList<TestBean>();
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		if (null==savedInstanceState) {
			initData();
		} else {
			for (int i = 0; i < mTestData.size(); i++) {
				Log.e("test", mTestData.get(i).getTitle());
			}
		}
		super.onActivityCreated(savedInstanceState);
	}

	private void initData() {
		for (int i = 0; i < 100; i++) {
			TestBean t = new TestBean(i, i, "-----------"+i);
			mTestData.add(t);
		}
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("1", "onCreateView");
		return inflater.inflate(R.layout.fragment_a, null);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	

}
