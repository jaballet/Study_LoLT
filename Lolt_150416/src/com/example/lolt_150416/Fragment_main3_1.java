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
public class Fragment_main3_1 extends Fragment {


    public Fragment_main3_1() {
        // Required empty public constructor
    }
    public static Fragment_main3_1 newInstance(String param1, String param2) {
        Fragment_main3_1 fragment = new Fragment_main3_1();
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
        v = inflater.inflate(R.layout.main3_1, null);
        Button bt;
        bt = (Button)v.findViewById(R.id.button_back);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_flight_yes);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_flight_no);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_flight_confirm);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        return v;
    }

    View.OnClickListener viewListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_flight_yes:{
//                    pager.setCurrentItem(12);
                }break;
                case R.id.button_flight_no:{
//                    pager.setCurrentItem(12);
                }break;
                case R.id.button_back:{
                    pager.setCurrentItem(15);
                }break;
                case R.id.button_flight_confirm:{
                    pager.setCurrentItem(17);
    				((SurveyActivity)(Fragment_main3_1.this.getActivity())).appendPreferences(1);	//1점 추가
                }break;
            }
        }
    };
}
