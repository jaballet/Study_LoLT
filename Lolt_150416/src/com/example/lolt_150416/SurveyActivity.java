package com.example.lolt_150416;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SurveyActivity extends FragmentActivity {
	CustomViewPager pager;
	PagerAdapter adapter;
	Button next;
	Button next2;
	int index = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		pager = (CustomViewPager)findViewById(R.id.viewpager);
		adapter = new CustomPageAdaptor(getSupportFragmentManager());
		pager.setAdapter(adapter);

		next = (Button)findViewById(R.id.button);
		next2 = (Button)findViewById(R.id.button2);

		next.setOnClickListener(testlistener);
		next2.setOnClickListener(testlistener);

		index = pager.getCurrentItem();
		if(isSurveyComplete()){		
			pager.setCurrentItem(16);
		}
	}

	void showSelectView(ViewPosition position){
		index = position.ordinal();
		pager.setCurrentItem(position.ordinal());
	}

	void showPrevView(){
		if(index == 0)
			return;
		pager.setCurrentItem(--index);
	}

	void showNextView(){
		if(index == adapter.getCount() - 1)
			return;
		pager.setCurrentItem(++index);
	}

	View.OnClickListener testlistener = new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.button:{
				//                    if(index == 0)
				//                        break;
				Toast.makeText(SurveyActivity.this, "인덱스 : "+(index-1),Toast.LENGTH_SHORT).show();
				//                    pager.setCurrentItem(--index);
				showPrevView();
			}
			break;
			case R.id.button2:{
				//                    if(index == adapter.getCount() - 1)
				//                        break;
				Toast.makeText(SurveyActivity.this, "인덱스 : "+(index+1),Toast.LENGTH_SHORT).show();
				//                    pager.setCurrentItem(++index);
				showNextView();
			}
			break;

			}
		}
	};

	public void appendPreferences(int score){
		int totalScore = getPreferences();
		totalScore = totalScore + score;
		savePreferences(totalScore);
	}
	
	private int getPreferences(){
		SharedPreferences pref = getSharedPreferences("score", MODE_PRIVATE);
		int score = pref.getInt("totalscore", 0);
		return score;
	}

	private void savePreferences(int score){
		SharedPreferences pref = getSharedPreferences("score", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putInt("totalscore", score);
		editor.commit();
	}


	private void savePreferences(String key, Object value){
		SharedPreferences pref = getSharedPreferences("score", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString(key, value.toString());
		editor.commit();
	}

	private String getPreferences(String key){
		SharedPreferences pref = getSharedPreferences("score", MODE_PRIVATE);
		String result = pref.getString(key, null);
		return result;
	}
	
	private void removePreferences(){
		SharedPreferences pref = getSharedPreferences("score", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.remove("totalscore");
		editor.commit();
	}
	
	private void removeAllPreferences(){
        SharedPreferences pref = getSharedPreferences("score", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
	
	public void surveyComplete() {
		savePreferences("complete", true);
	}
	
	public boolean isSurveyComplete(){
		String result = getPreferences("complete");
		return Boolean.valueOf(result);
	}
}
