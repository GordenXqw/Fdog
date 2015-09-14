package com.sncd.fdog.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.sncd.fdog.manager.ActivityFdogManager;

/**
 * Created by Administrator on 2015/9/14.
 */
public abstract class FdogBaseActivity extends Activity {
    private final int TOAST_LENGTH= Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ActivityFdogManager.getInstance().addActivity(this);
        findViewById();
        initBar();
        bindData();
        bindListener();
    }
    /**
     * 绑定UI
    */
    protected abstract int getContentView();
    /**
     * 初始化控件
     */
    protected abstract void findViewById();
    protected abstract void initBar();
    /**
     * 初始化监听器
     */
    protected abstract void bindListener();

    /**
     * 绑定数据
     */
    protected abstract void bindData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityFdogManager.getInstance().removeActivity(this);
    }

    /**
     * 显示一个Toast信息
     *
     * @param msg
     *            要显示的信息
     */
    protected void showToastMsg(String msg) {
        Toast.makeText(this, msg, TOAST_LENGTH).show();
    }
    /**
     * 显示一个Toast信息
     *
     * @param resId
     *            要显示的信息ID
     */
    protected void showToastMsg(int resId) {
        Toast.makeText(this, resId, TOAST_LENGTH).show();
    }

    /**
     * 根据String资源ID格式化一个字符串
     *
     * @param resId
     *            要格式化的String资源ID
     * @return 返回格式化好的字符串
     */
    protected String getResString(int resId) {
        String _Message = getResources().getString(resId);
        _Message = String.format(_Message);
        return _Message;
    }
    protected void startActivityForName(Class<?> cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }
}
