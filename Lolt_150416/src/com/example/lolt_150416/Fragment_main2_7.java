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
public class Fragment_main2_7 extends Fragment {
    public Fragment_main2_7() {
        // Required empty public constructor
    }
    public static Fragment_main2_7 newInstance(String param1, String param2) {
        Fragment_main2_7 fragment = new Fragment_main2_7();
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
        v = inflater.inflate(R.layout.main2_7, null);
        Button bt;
        bt = (Button)v.findViewById(R.id.button_back);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_floor_rate1);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_floor_rate2);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_floor_rate3);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_floor_rate4);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_floor_rate5);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_floor_rate6);
        bt.setOnClickListener(viewListener);
        bt.setTag(v);
//        bt = (Button)v.findViewById(R.id.button_floor_confirm);
//        bt.setOnClickListener(viewListener);
//        bt.setTag(v);
        return v;
    }

    View.OnClickListener viewListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_floor_rate1:{
                    pager.setCurrentItem(16);
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).appendPreferences(1);	//1점 추가
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).surveyComplete();
                }break;
                case R.id.button_floor_rate2:{
                    pager.setCurrentItem(16);
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).appendPreferences(1);	//1점 추가
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).surveyComplete();
                }break;
                case R.id.button_floor_rate3:{
                    pager.setCurrentItem(16);
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).appendPreferences(1);	//1점 추가
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).surveyComplete();
                }break;
                case R.id.button_floor_rate4:{
                    pager.setCurrentItem(16);
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).appendPreferences(1);	//1점 추가
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).surveyComplete();
                }break;
                case R.id.button_floor_rate5:{
                    pager.setCurrentItem(16);
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).appendPreferences(1);	//1점 추가
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).surveyComplete();
                }break;
                case R.id.button_floor_rate6:{
                    pager.setCurrentItem(16);
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).appendPreferences(1);	//1점 추가
    				((SurveyActivity)(Fragment_main2_7.this.getActivity())).surveyComplete();
                }break;
//                case R.id.button_floor_confirm:{
//                    pager.setCurrentItem(16);
//                }break;
                case R.id.button_back:{
                    pager.setCurrentItem(14);
                }break;
            }
        }
    };
}
