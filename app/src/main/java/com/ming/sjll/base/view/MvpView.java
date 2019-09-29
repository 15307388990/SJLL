package com.ming.sjll.base.view;

/**
 * MVP模式View层接口
 *
 * @author linjie
 * @date 2017/10/15
 */
public interface MvpView {
    /**
     * 显示加载
     *
     * @param msg 提示语
     */
    void showLoading(String msg);

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示错误提示
     *
     * @param msg 错误提示
     */
    void showError(String msg);
}
