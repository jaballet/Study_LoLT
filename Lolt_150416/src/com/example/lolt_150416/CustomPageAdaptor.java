package com.example.lolt_150416;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/*
레이아웃의 종류를 상수형인 enum으로 정의 해놓고 ViewPager의 Position과 매칭하 여사용함.
 */
enum ViewPosition{MAIN1_0,MAIN1_1,MAIN1_2,MAIN1_3,MAIN1_4,MAIN1_5,MAIN1_6,MAIN1_7,MAIN1_8
    ,MAIN2_1,MAIN2_2,MAIN2_3,MAIN2_4,MAIN2_5,MAIN2_6,MAIN2_7,MAIN3_1,MAIN3_2;
    public final int position;
    ViewPosition(){
        position = ordinal();
    }

}
/**
 * Created by cheochangwon on 2015. 1. 31..
 */
public class CustomPageAdaptor extends FragmentStatePagerAdapter {

    @Override
    public int getCount() {
        return ViewPosition.values().length;//ViewPosition.values().length;
    }

    public CustomPageAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        ViewPosition[] pos = ViewPosition.values();
        switch (pos[position]) {
            case MAIN1_0: {
                fragment = Fragment_main1_0.newInstance("argv1", "argv2");
            }
            break;
            case MAIN1_1: {
                fragment = Fragment_main1_1.newInstance("argv1", "argv2");
            }
            break;
            case MAIN1_2: {
                fragment = Fragment_main1_2.newInstance("argv1", "argv2");
            }
            break;
            case MAIN1_3: {
                fragment = Fragment_main1_3.newInstance("argv1", "argv2");
            }
            break;
            case MAIN1_4: {
                fragment = Fragment_main1_4.newInstance("argv1", "argv2");
            }
            break;
            case MAIN1_5: {
                fragment = Fragment_main1_5.newInstance("argv1", "argv2");
            }
            break;
            case MAIN1_6: {
                fragment = Fragment_main1_6.newInstance("argv1", "argv2");
            }
            break;
            case MAIN1_7: {
                fragment = Fragment_main1_7.newInstance("argv1", "argv2");
            }
            break;

            case MAIN1_8: {
                fragment = Fragment_main1_8.newInstance("argv1", "argv2");
            }
            break;

            case MAIN2_1: {
                fragment = Fragment_main2_1.newInstance("argv1", "argv2");
            }
            break;

            case MAIN2_2: {
                fragment = Fragment_main2_2.newInstance("argv1", "argv2");
            }
            break;
            case MAIN2_3: {
                fragment = Fragment_main2_3.newInstance("argv1", "argv2");
            }
            break;

            case MAIN2_4: {
                fragment = Fragment_main2_4.newInstance("argv1", "argv2");
            }
            break;

            case MAIN2_5: {
                fragment = Fragment_main2_5.newInstance("argv1", "argv2");
            }
            break;

            case MAIN2_6: {
                fragment = Fragment_main2_6.newInstance("argv1", "argv2");
            }
            break;

            case MAIN2_7: {
                fragment = Fragment_main2_7.newInstance("argv1", "argv2");
            }
            break;

            case MAIN3_1: {
                fragment = Fragment_main3_1.newInstance("argv1", "argv2");
            }
            break;

            case MAIN3_2: {
                fragment = Fragment_main3_2.newInstance("argv1", "argv2");
            }
            break;
            default: {

            }
        }
        return fragment;
    }
}