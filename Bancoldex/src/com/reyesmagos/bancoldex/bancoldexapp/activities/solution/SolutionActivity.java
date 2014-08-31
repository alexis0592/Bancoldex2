package com.reyesmagos.bancoldex.bancoldexapp.activities.solution;

import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.activities.detail.DetailActivity;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.ProductMock;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.SolutionMock;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SolutionActivity extends Activity {

	private SolutionMock solutionMock;
	private ListView solutionListView;

	private String solutionSelected;
	private int option;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.solutions_activity);
		createComponents();
	}

	public void createComponents() {
		this.solutionListView = (ListView) super
				.findViewById(R.id.listView_solution);
		this.solutionMock = new SolutionMock();
		ArrayAdapter<String> arraySolution = new ArrayAdapter<String>(this,
				R.layout.solution_listview_personalized,
				solutionMock.getArraySolutions());
		solutionListView.setAdapter(arraySolution);

		solutionListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				solutionSelected = parent.getItemAtPosition(pos).toString();
				switch (pos) {
				case 0:
					option = 0;
					optionSelected(option, view);
					break;
				case 1:
					option = 1;
					optionSelected(option, view);
					break;
				default:
					break;
				}

			}
		});
	}

	public void optionSelected(int option, final View view) {
		ProductMock productMock = new ProductMock();
		AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
		builderSingle.setIcon(R.drawable.ic_launcher);
		builderSingle.setTitle("Seleccione Un Filtro");

		switch (option) {
		case 0:
			final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
					this, android.R.layout.select_dialog_singlechoice,
					productMock.convertProductToString(productMock
							.getArrayProduct()));
			builderSingle.setAdapter(arrayAdapter, new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int pos) {
					solutionSelected = arrayAdapter.getItem(pos);
					Log.i("Selected", solutionSelected);
					switch (pos) {
					case 0:
						Intent i = new Intent();
						i.setComponent(new ComponentName(
								"com.reyesmagos.bancoldex.bancoldexapp",
								"com.reyesmagos.bancoldex.bancoldexapp.activities.detail.DetailActivity"));
						i.setAction("android.intent.action.MAIN");
						i.addCategory("android.intent.category.LAUNCHER");
						i.addCategory("android.intent.category.DEFAULT");
						view.getContext().startActivity(i);
						break;
					case 1:
						Intent i2 = new Intent();
						i2.setComponent(new ComponentName(
								"com.reyesmagos.bancoldex.bancoldexapp",
								"com.reyesmagos.bancoldex.bancoldexapp.activities.detail.DetailActivity"));
						i2.setAction("android.intent.action.MAIN");
						i2.addCategory("android.intent.category.LAUNCHER");
						i2.addCategory("android.intent.category.DEFAULT");
						view.getContext().startActivity(i2);
						break;
					default:
						break;
					}
				}
			});
			builderSingle.show();
			break;
		case 1:
			final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(
					this, android.R.layout.select_dialog_singlechoice,
					productMock.convertProductToString(productMock
							.getArrayProduct2()));
			builderSingle.setAdapter(arrayAdapter1, new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int pos) {
					solutionSelected = arrayAdapter1.getItem(pos);
					Log.i("Selected", solutionSelected);
				}
			});
			builderSingle.show();
			break;

		default:
			break;
		}

	}

}
