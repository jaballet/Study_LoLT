package com.example.lolt_150416;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by cheochangwon on 2015. 1. 31..
 */
public class CustomViewPager extends ViewPager {

    boolean enabled = false;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            if (this.enabled) {
//				Log.i("INFO", "스크롤 중..");
                return super.onTouchEvent(ev);
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsStrting = sw.toString();
            Log.e("INFO", exceptionAsStrting);
        }
        return false;
    }

    public void setPagingEnabled() { //이 메소드를 이용해서 스크롤을 풀어주고
        this.enabled = true;
    }

    public void setPagingDisabled() { //이 메소드를 이용해서 스크롤을 막아줍니다.
        this.enabled = false;
    }
}
