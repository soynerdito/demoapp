package com.soynerdito.app;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<Item> {


	public ItemAdapter(Context context, List<Item> objects) {
		super(context, R.layout.list_item, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		if (convertView == null) {
		    LayoutInflater inflater = (LayoutInflater) parent.getContext()
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    v = inflater.inflate(R.layout.list_item, null);
		} else {
		    v = convertView;
		}
		ViewHolder holder = (ViewHolder)v.getTag();
		if( holder== null ){
			holder = new ViewHolder(); 
			holder.tx1 = (TextView)v.findViewById(R.id.textView1);
			holder.tx2 = (TextView)v.findViewById(R.id.textView2);
			holder.tx3 = (TextView)v.findViewById(R.id.textView3);
			holder.ivLogo = (ImageView)v.findViewById(R.id.ivLogo);
			
			v.setTag(holder);
		}		
		Item item = this.getItem(position);
		//Load View with data
		holder.tx1.setText(item.title); 
		holder.tx3.setText(item.link); 
		holder.tx2.setText(item.pubDate);
		holder.ivLogo.setImageBitmap( item.image );
		
		return v;
	}

	class ViewHolder {
		TextView tx1;
		TextView tx2;
		TextView tx3;
		ImageView ivLogo;
	}
	
}
