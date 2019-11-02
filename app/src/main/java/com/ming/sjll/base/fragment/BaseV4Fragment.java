package com.ming.sjll.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ming.sjll.base.cache.ACache;
import com.ming.sjll.base.manager.LoadManager;
import com.ming.sjll.base.utils.TextUtil;
import com.ming.sjll.base.widget.ToastShow;
import com.orhanobut.logger.Logger;

import java.lang.reflect.Field;


public class BaseV4Fragment extends Fragment {

	protected LayoutInflater inflater;
	private View contentView;
	protected Context mContext;
	protected ViewGroup container;
	protected String TAG = getClass().getName();

	private LoadManager mLoadManager;

	public static ACache mCache;

	//适配矢量图
	static {
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}


	protected void le(String msg) {
		Logger.t(TAG).e( msg);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
		mCache = ACache.get(mContext);
		initLoadManager();
	}

	public void showTips(String msg){
		if(!TextUtil.isEmpty(msg))
			ToastShow.s(msg);
	}

	public void showTips(@StringRes int msg){
			ToastShow.s(msg);
	}

	private void initLoadManager() {
		mLoadManager = new LoadManager(getActivity());
	}

	public void showLoadDialog() {
		if (mLoadManager != null)
			mLoadManager.showLoadDialog();
	}


	public void dismissDialog(){
		if (mLoadManager != null)
			mLoadManager.dismissDialog();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		this.container = container;
		onCreateView(savedInstanceState);
		if (contentView == null)
			return super.onCreateView(inflater, container, savedInstanceState);
		return contentView;
	}

	protected void onCreateView(Bundle savedInstanceState) {
		
	}

	/**
	 * 用于eventbus 回调
	 */
	public void onEventMainThread(){
	}

	@Override
	public void onDestroyView() {
//		NetRequest.getRequestQueue().cancelAll(this);//activity销毁时取消请求
		super.onDestroyView();
		contentView = null;
		container = null;
		inflater = null;
		if (mLoadManager != null){
			mLoadManager.onDestroy();
		}
	}

	public Context getApplicationContext() {
		return mContext.getApplicationContext();
	}

	public void setContentView(int layoutResID) {
		setContentView((ViewGroup) inflater.inflate(layoutResID, container, false));
	}

	public void setContentView(View view) {
		contentView = view;
	}

	public View getContentView() {
		return contentView;
	}

	public View findViewById(int id) {
		if (contentView != null)
			return contentView.findViewById(id);
		return null;
	}

	// http://stackoverflow.com/questions/15207305/getting-the-error-java-lang-illegalstateexception-activity-has-been-destroyed
	@Override
	public void onDetach() {
		super.onDetach();
		try {
			Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);

		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}





}
