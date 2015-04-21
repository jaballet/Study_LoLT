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
public class Fragment_main1_6 extends Fragment {


    public Fragment_main1_6() {
        // Required empty public constructor
    }
    public static Fragment_main1_6 newInstance(String param1, String param2) {
        Fragment_main1_6 fragment = new Fragment_main1_6();
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
               v = inflater.inflate(R.layout.main1_6, null);
               Button bt = (Button)v.findViewById(R.id.button_confirm_age);
               bt.setOnClickListener(viewListener);
               bt.setTag(v);
               bt = (Button)v.findViewById(R.id.button_back);
               bt.setOnClickListener(viewListener);
               bt.setTag(v);
        return v;
    }

    View.OnClickListener viewListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_confirm_age:{
                    pager.setCurrentItem(7);
    				((SurveyActivity)(Fragment_main1_6.this.getActivity())).appendPreferences(1);	//1점 추가
                }break;
                case R.id.button_back:{
                    pager.setCurrentItem(5);
                }break;
            }
        }
    };
}
