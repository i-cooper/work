package com.example.point9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity
{
	private ListView lView=null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lView=(ListView) findViewById(R.id.listView1);
		int imageId[]={R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,
				R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08};
		String [] title=new String[]{"保密设置","安全","系统设置","上网","我的文档","GPS导航","我的音乐","E-mail"};
		
		List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
		for(int i=0;i<imageId.length;i++)
		{
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("image",imageId[i]);
			map.put("title",title[i]);
			listItems.add(map);
		}
		
		SimpleAdapter adapter=new SimpleAdapter(this,listItems,R.layout.items,new String[]{"image","title"}
		,new int []{R.id.image,R.id.title});
		lView.setAdapter(adapter);
	}
}
