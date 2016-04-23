package com.example.point04;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RabbitView extends View
{
     public float bitmapX;
     public float bitmapY;
	
	public RabbitView(Context context)
	{
		super(context);
		bitmapX=290;
		bitmapY=130;
	}

	@Override
	public void draw(Canvas canvas)
	{
		// TODO Auto-generated method stub
		super.draw(canvas);
		Paint paint=new Paint();
		
		Bitmap bitmap =BitmapFactory.decodeResource(getResources(),R.drawable.rabbit);
		canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
		
		if(!bitmap.isRecycled())
		{
			bitmap.recycle();
		}
		
	}

	
}
