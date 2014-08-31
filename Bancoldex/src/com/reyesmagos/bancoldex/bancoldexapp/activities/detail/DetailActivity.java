package com.reyesmagos.bancoldex.bancoldexapp.activities.detail;

import java.util.ArrayList;
import java.util.List;




import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.DetailMock;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends Activity {

	private TextView plazoMinimoTextView;
	private TextView plazoMaximoTextView;
	private TextView periodoGraciaTextView;
	private TextView valorMontoMaximoTextView;
	private TextView tasaMaximaClienteTextView;
	private ListView listView;

	private DetailMock detailMock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		createComponents();
	}

	public void createComponents() {
		this.plazoMaximoTextView = (TextView) super
				.findViewById(R.id.textView_plazo_maximo_result);
		this.plazoMinimoTextView = (TextView) super
				.findViewById(R.id.textView_plazo_min_result);
		this.periodoGraciaTextView = (TextView) super
				.findViewById(R.id.textView_periodo_gracia_result);
		this.valorMontoMaximoTextView = (TextView) super
				.findViewById(R.id.textView_val_monto_max_result);
		this.tasaMaximaClienteTextView = (TextView) super
				.findViewById(R.id.textView_tasa_max_cliente_result);
		this.listView = (ListView)super.findViewById(R.id.listView_tasas_y_plazos);

		this.detailMock = new DetailMock();
		this.plazoMaximoTextView.setText(detailMock.setDetails().get(0));
		this.plazoMinimoTextView.setText(detailMock.setDetails().get(1));
		this.periodoGraciaTextView.setText(detailMock.setDetails().get(2));
		this.valorMontoMaximoTextView.setText(detailMock.setDetails().get(3));
		this.tasaMaximaClienteTextView.setText(detailMock.setDetails().get(4));
		
		List<String>aux = new ArrayList<String>();
		aux.add("Tasas y Plazos: ");
		for(int i = detailMock.setDetails().size(); i >  5; i--){
			aux.add(detailMock.setDetails().get(i-1));
		}
		
		ArrayAdapter<String>adapterResult = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aux);
		this.listView.setAdapter(adapterResult);
		
	}
}
