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
import android.widget.EditText;

public class BaseFragment extends Fragment {
	private String Tag = BaseFragment.this.getClass().getSimpleName();
	private ArrayList<TestBean> mInputData = new ArrayList<TestBean>();
	public EditText mEditText;
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mEditText = (EditText) getView().findViewById(R.id.title);
		if (null!=getArguments()) {
			mInputData  = (ArrayList<TestBean>) getArguments().get("data");
		} else {
			
		}
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < mInputData.size(); i++) {
			bf.append(mInputData.get(i).getTitle());
		}
		Log.e(Tag, "onActivityCreated"+"mInputData--"+bf.toString());
		bf.setLength(0);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.e(Tag, "onCreate");
		super.onCreate(savedInstanceState);
	}


	@Override
	public void onDestroy() {
		Log.e(Tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.e(Tag, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onAttach(Activity activity) {
		Log.e(Tag, "onAttach");
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e(Tag, "onCreateView");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onDetach() {
		Log.e(Tag, "onDetach");
		super.onDetach();
	}

	@Override
	public void onPause() {
		Log.e(Tag, "onPause");
		super.onPause();
	}

	@Override
	public void onResume() {
		Log.e(Tag, "onResume");
		super.onResume();
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		Log.e(Tag, "isVisibleToUser=---"+ isVisibleToUser);
		// onResume
		if (isVisibleToUser) {
			loadFirstData();
		}
		super.setUserVisibleHint(isVisibleToUser);
	}

	protected void loadFirstData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		
//		Bundle data = getArguments();
//		if (null!=data) {
//			String text = data.getString("context");
//			mEditText.setText(text);
//			Log.e(Tag, "getArguments===="+text);
//		} else {
//			Log.e(Tag, "no Arguments");
//		}
	}
	
	

}
