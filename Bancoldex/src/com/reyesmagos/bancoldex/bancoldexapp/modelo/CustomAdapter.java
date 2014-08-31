package com.reyesmagos.bancoldex.bancoldexapp.modelo;

import java.util.List;

import com.reyesmagos.bancoldex.bancoldexapp.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	Context context;
	List<Notice> listaOpciones;

	public CustomAdapter(Context context, List<Notice> opciones) {
		this.context = context;
		this.listaOpciones = opciones;
	}

	private class viewHolder {
		ImageView imagenOpcioes;
		TextView textviewTitle;
		TextView textviewDate;
		TextView textviewRegion;
		TextView textviewSector;
		TextView textviewContent;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater
					.inflate(R.layout.notic_adapter_layout, null);

			holder = new viewHolder();
			holder.textviewTitle = (TextView) convertView
					.findViewById(R.id.textview_title);
			holder.textviewDate = (TextView) convertView
					.findViewById(R.id.textview_date);
			holder.textviewRegion = (TextView) convertView
					.findViewById(R.id.textview_region);
			holder.textviewSector = (TextView) convertView
					.findViewById(R.id.textview_sector);
			holder.textviewContent = (TextView) convertView
					.findViewById(R.id.textview_content);

			convertView.setTag(holder);
		} else {
			holder = (viewHolder) convertView.getTag();
		}

		// String s = (String) getItem(position);
		Notice notice = (Notice) getItem(position);
		holder.textviewTitle.setText(notice.getTitle());
		holder.textviewDate.setText(notice.getDate());
		if (notice.getDepartment() != null) {
			holder.textviewRegion.setText(notice.getDepartment());
		} else {
			holder.textviewRegion.setText(notice.getCountrie());
		}
		holder.textviewSector.setText(notice.getSector());
		holder.textviewContent.setText(notice.getContent());
		// holder.imagen.setText(s);

		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaOpciones.size();
	}

	@Override
	public Notice getItem(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.indexOf(getItem(arg0));
	}

}