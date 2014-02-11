package com.soynerdito.app;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
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
			holder.tx4 = (TextView)v.findViewById(R.id.textView4);
			holder.wv1 = (WebView)v.findViewById(R.id.webView1);
			
			v.setTag(holder);
		}		
		Item item = this.getItem(position);
		//Load View with data
		holder.tx1.setText(item.title); 
		//holder.tx2.setText(item.description); 
		holder.tx3.setText(item.link); 
		//holder.tx4.setText(item.pubDate);
		holder.tx2.setVisibility(View.GONE);
		holder.tx4.setVisibility(View.GONE);		

		holder.wv1.loadData(item.description + item.pubDate ,  "text/html", null);		
		
		return v;
	}

	class ViewHolder {
		TextView tx1;
		TextView tx2;
		TextView tx3;
		TextView tx4;
		WebView wv1;
	}
	
}
