package com.example.lolt_150416;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_main3_2 extends Fragment {


    public Fragment_main3_2() {

        // Required empty public constructor
    }
    public static Fragment_main3_2 newInstance(String param1, String param2) {
        Fragment_main3_2 fragment = new Fragment_main3_2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    ViewGroup group = null;
    ViewPager pager = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        group = container;
        pager = (ViewPager)group.findViewById(R.id.viewpager);
        View v = null;
        v = inflater.inflate(R.layout.main3_2, null);
        Button bt;
        bt = (Button)v.findViewById(R.id.button_back);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_gps_no);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_gps_yes);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        return v;
    }

    View.OnClickListener viewListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_gps_yes:{
                    pager.setCurrentItem(18);
                }break;
                case R.id.button_gps_no:{
                    pager.setCurrentItem(18);
                }break;
                case R.id.button_back:{
                    pager.setCurrentItem(16);
                }break;
            }
        }
    };
}
