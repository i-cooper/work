package com.example.framgments;
import com.example.framgments.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment2 extends Fragment
{
	Button button=null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.framgment2,container,false);		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		button=(Button) getActivity().findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				TextView textView=(TextView) (getActivity().findViewById(R.id.text1));
				Toast.makeText(getActivity(),textView.getText().toString(),Toast.LENGTH_SHORT).show();
			}
		});
	}

}
