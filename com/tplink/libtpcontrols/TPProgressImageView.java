package com.tplink.libtpcontrols;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class TPProgressImageView
  extends AppCompatImageView
{
  public TPProgressImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPProgressImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPProgressImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setBackgroundColor(-7829368);
  }
  
  private Bitmap a(int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-7829368);
    localCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight() * paramInt / 100, localPaint);
    localPaint.setColor(-16777216);
    localCanvas.drawRect(0.0F, getHeight() * paramInt / 100.0F, getWidth(), getHeight(), localPaint);
    return localBitmap;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setProgressBackGround(int paramInt)
  {
    int i;
    if (paramInt <= 100)
    {
      i = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      i = 0;
    }
    setBackground(new BitmapDrawable(a(100 - i)));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPProgressImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */