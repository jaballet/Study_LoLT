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
public class Fragment_main1_2 extends Fragment {


    public Fragment_main1_2() {
        // Required empty public constructor
    }
    public static Fragment_main1_2 newInstance(String param1, String param2) {
        Fragment_main1_2 fragment = new Fragment_main1_2();
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
        v = inflater.inflate(R.layout.main1_2, container, false);
                Button bt = (Button)v.findViewById(R.id.button_personal);
                bt.setOnClickListener(pagerBtListener);
                bt.setTag(v);
                bt = (Button)v.findViewById(R.id.button_setting);
                bt.setOnClickListener(pagerBtListener);
                bt.setTag(v);
                bt = (Button)v.findViewById(R.id.button_residential);
                bt.setOnClickListener(pagerBtListener);
                bt.setTag(v);
                bt = (Button)v.findViewById(R.id.button_leisure);
                bt.setOnClickListener(pagerBtListener);
                bt.setTag(v);
                bt = (Button)v.findViewById(R.id.button_back);
                bt.setOnClickListener(pagerBtListener);
                bt.setTag(v);
        return v;
    }

    View.OnClickListener pagerBtListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_personal:
                {
                    pager.setCurrentItem(3);
                }break;

                case R.id.button_setting:
                {
                    pager.setCurrentItem(3);
                }break;

                case R.id.button_residential:
                {
                    pager.setCurrentItem(3);
                }break;

                case R.id.button_leisure:
                {
                    pager.setCurrentItem(3);
                }break;

                case R.id.button_back:
                {
                    pager.setCurrentItem(1);
                }break;
            }
        }
    };
}
