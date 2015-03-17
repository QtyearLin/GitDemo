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
import android.widget.Toast;

public class TestFragment2 extends BaseFragment {

	private ArrayList<TestBean> mTestData = new ArrayList<TestBean>();

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
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
	public void onViewStateRestored(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewStateRestored(savedInstanceState);
		if (savedInstanceState!=null) {
			Toast.makeText(getActivity(), mEditText.getText().toString(), Toast.LENGTH_SHORT).show();
		}
		
		if (null==savedInstanceState) {
			initData();
		} else {
			mTestData = (ArrayList<TestBean>) savedInstanceState.get("data");
			for (int i = 0; i < mTestData.size(); i++) {
				Log.e("test", mTestData.get(i).getTitle());
			}
		}
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		if (isVisibleToUser) {
//			Toast.makeText(getActivity(), mEditText.getText().toString(), Toast.LENGTH_SHORT).show();
		}
		super.setUserVisibleHint(isVisibleToUser);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("2", "onCreateView");
		return inflater.inflate(R.layout.fragment_b, null);
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
		outState.putSerializable("data", mTestData);
		super.onSaveInstanceState(outState);
	}
	
	

}
