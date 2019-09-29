package com.ming.sjll.appication;


import com.ming.sjll.base.utils.AppUtils;


/**
 * @author luoming
 *created at 2019/8/6 10:57 AM
*/
public class SJLLApplication extends BaseApplication {
	private static SJLLApplication mInstance = null;
	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		//颜色
		AppUtils.init(this);

	}

	public static SJLLApplication getInstance() {
		return mInstance;
	}



}