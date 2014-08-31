package com.reyesmagos.bancoldex.bancoldexapp.activities.register;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.NeedMock;

public class NeedSelectorActivity extends Activity {

	private ListView needListView;
	public static String needSelected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neccesity_activity);
		createComponents();
	}

	public void createComponents() {
		NeedMock needMock = new NeedMock();
		needListView = (ListView) super.findViewById(R.id.listView_needs);

		ArrayAdapter<String> needsArray = new ArrayAdapter<String>(
				this.getApplicationContext(), R.layout.need_text_view,
				needMock.getNeedList());
		this.needListView.setAdapter(needsArray);

		this.needListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				needSelected = parent.getItemAtPosition(pos).toString();
				changeText();
				finish();
				
			}
		});

	}
	
	public void onAccept(View view){

		this.finish();
	}
	
	public void changeText(){
		RegisterActivity.selectedNeed.setVisibility(TextView.VISIBLE);
		RegisterActivity.selectedNeed.setText(needSelected);
		RegisterActivity.imageViewNecessity.setVisibility(ImageView.GONE);
		
	}

	public String getNeedSelected() {
		return needSelected;
	}
	


}
