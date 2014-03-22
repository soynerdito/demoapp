package com.soynerdito.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;

public class Item {
	public String title;
	public String description;
	public String pubDate;
	public String link;
	public Bitmap image;
		
	public Item(){
		this("","","","");	
	}
	
	public Item(String title,String description ,
			String pubDate,String link){
			
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.link= link; 
	}
	
	public void addData(EnumStat stat, String data){
		switch(stat){
		case DESC:
			description += data;
			break;
		case LINK:
			link += data;
			break;
		case TITLE:
			title += data;
			break;	
		case DATE:
			pubDate += data;
			break;
		}
	}

	public void loadExternalData(Context context) {
		// TODO Load data into a string
		try {
			int start = description.indexOf("src=") + "src=".length();
			String part  = description.substring(start) ;
			String parts[] = part.split(" ");
			File outputDir = context.getCacheDir(); // context being the Activity pointer
			File outputFile = File.createTempFile("prefix", "extension", outputDir);
			outputFile = getURLContents(parts[0], outputFile); 
			image = BitmapFactory.decodeStream(new FileInputStream(outputFile));	        
			this.pubDate = this.pubDate.replace("&nbsp;", "");
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private File getURLContents(String url, File outputFile) throws ClientProtocolException, IOException{
		HttpClient httpclient = new DefaultHttpClient(); // Create HTTP Client
		HttpGet httpget = new HttpGet(url); // Set the action you want to do
		HttpResponse response = httpclient.execute(httpget); // Executeit
		HttpEntity entity = response.getEntity(); 
		InputStream is = entity.getContent(); // Create an InputStream with the response
		//InputStreamReader input = new InputStreamReader(is, "iso-8859-1");
		byte data[] = new byte[1024];
		OutputStream output;
		output = new FileOutputStream(outputFile);
        int count;
        while ((count = is.read(data)) != -1) {
            output.write(data, 0, count);
        }
        output.flush();
        is.close();
        output.close();
		
		return outputFile; // Result is here
	}
}
