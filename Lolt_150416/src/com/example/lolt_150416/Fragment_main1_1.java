package com.example.lolt_150416;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment_main1_1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_main1_1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_main1_1 newInstance(String param1, String param2) {
        Fragment_main1_1 fragment = new Fragment_main1_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_main1_1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ViewGroup group = null;
    ViewPager pager = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        group = container;
        pager = (ViewPager)group.findViewById(R.id.viewpager);

        View v = null;
        v = inflater.inflate(R.layout.main1_1, container, false);
        Button bt = (Button)v.findViewById(R.id.button_facebook);
        bt.setOnClickListener(startListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_google);
        bt.setOnClickListener(startListener);
        bt.setTag(v);
        bt = (Button)v.findViewById(R.id.button_kakao);
        bt.setOnClickListener(startListener);
        bt.setTag(v);

        return v;
    }

    View.OnClickListener startListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_start: {
                    //시작 버튼
                    pager.setCurrentItem(2);
                }
                break;

                case R.id.button_facebook: {
                    //페이스북
                    pager.setCurrentItem(2);
                }
                break;

                case R.id.button_google: {
                    //구글
                    pager.setCurrentItem(2);
                }
                break;
            }
        }
    };
}
