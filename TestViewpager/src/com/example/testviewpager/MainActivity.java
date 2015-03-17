package com.example.testviewpager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import android.R.integer;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	private ViewPager mViewPager;
	private MyAdapter mAdapter;
	private TextView mLeftView,mRightView,mMiddleView;
	private TextView mRefreshView,mContextView;
	
	private ArrayList<TestBean> mAdapterData;
	private int mPostion;
	private static final int[] mRList = new int[]{R.drawable.a,
		R.drawable.b,
		R.drawable.c,
		R.drawable.d,
		R.drawable.e,
		R.drawable.f};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	private void initViews() {
		mAdapterData = new ArrayList<TestBean>();
		addItems();
		
		
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mAdapter = new MyAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
		// 直接决定初始化实例的数量
		//  在此范围内的fragment正常情况下切换只执行 setUserVisalbe 仅在第一次创建时执行OnResume  仅在需要destroyView时 onPause ---
//		mViewPager.setOffscreenPageLimit(100);
		
		mLeftView = (TextView) findViewById(R.id.left);
		mRightView = (TextView) findViewById(R.id.right);
		mMiddleView = (TextView) findViewById(R.id.middle);
		mRefreshView = (TextView) findViewById(R.id.refresh);
		mContextView = (TextView) findViewById(R.id.allcontext);
		
		mLeftView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int last = mPostion -1;
				if (last >= 0) {
					if (Math.abs(mPostion - last)==1 )	{
						mViewPager.setCurrentItem(last,true);
					} else {
						mViewPager.setCurrentItem(last);
					}
				}
				
			}
		});
		mRightView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int last = mPostion +1;
				if (last < mAdapterData.size() -1) {
					if (Math.abs(mPostion - last)==1 )	{
						mViewPager.setCurrentItem(last,true);
					} else {
						mViewPager.setCurrentItem(last);
					}
				}
				
			}
		});
		
		mMiddleView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int temp = mPostion + 10;
				if (temp >= mAdapterData.size()-1) {
					temp = 0;
				}
				mViewPager.setCurrentItem(temp);
				
			}
		});
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				mPostion = arg0;
				mMiddleView.setText("第" + arg0 + "页") ;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mRefreshView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addItems();
				mAdapter.notifyDataSetChanged();
			}
		});
		mContextView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				StringBuffer sf = new StringBuffer();
				//all fragment 显示数据
				for (int i = 0; i < mAdapterData.size(); i++) {
					BaseFragment f = (BaseFragment) mAdapter.instantiateItem(mViewPager, i);
					// 由于fragment 未显示 s可能还未
					EditText s = f.mEditText;
					if (null!=s)
						sf.append(s.getText().toString());
				}
				Toast.makeText(MainActivity.this, sf.toString(), Toast.LENGTH_LONG).show();
			}
		});
	}

	private void addItems() {
		int size= mAdapterData.size();
		for (int i = size; i < 100 +size; i++) {
			TestBean object = new TestBean(i , mRList[i%6],"第" + i +"页");
			mAdapterData.add(object );;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class MyAdapter extends FragmentStatePagerAdapter{

		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
		// 数据更新最好写在instantiateItem
		// 做滑动采用缓存 右滑动新的
		@Override
		public Fragment getItem(int arg0) {
			Fragment f = null ;
			if (arg0%6==0) {
				f = new TestFragment1();  
			} else if (arg0%6==1) {
				f = new TestFragment2(); 
			} else if (arg0%6==2) {
				f = new TestFragment3(); 
			} else if (arg0%6==3) {
				f = new TestFragment4(); 
			} else if (arg0%6==4) {
				f = new TestFragment5(); 
			} else if (arg0%6==5) {
				f = new TestFragment6(); 
			} 
			Bundle args = new Bundle();
			args.putString("context", mAdapterData.get(arg0).getTitle());
			args.putSerializable("data", mAdapterData);
			f.setArguments(args );
			Log.e("getItme", "getItme!!!!!!!!");
			return f;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mAdapterData.size();
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			super.destroyItem(container, position, object);
		}

		@Override
		public void finishUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			super.finishUpdate(container);
		}

		@Override
		public Object instantiateItem(ViewGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			return super.instantiateItem(arg0, arg1);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return super.isViewFromObject(view, object);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub
			super.restoreState(arg0, arg1);
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return super.saveState();
		}

		@Override
		public void setPrimaryItem(ViewGroup container, int position,
				Object object) {
			// TODO Auto-generated method stub
			super.setPrimaryItem(container, position, object);
		}

		@Override
		public void startUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			super.startUpdate(container);
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
//			return super.getItemPosition(object);
			return PagerAdapter.POSITION_NONE;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return super.getPageTitle(position);
		}
		
		
		
	}

}
