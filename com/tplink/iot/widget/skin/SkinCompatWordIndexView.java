package com.tplink.iot.widget.skin;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tplink.iot.b;
import skin.support.widget.SkinCompatView;
import skin.support.widget.c;
import skin.support.widget.g;

public class SkinCompatWordIndexView
  extends SkinCompatView
  implements g
{
  private a d;
  String[] f = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  int q = -1;
  Paint x = new Paint();
  private int y;
  
  public SkinCompatWordIndexView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatWordIndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SkinCompatWordIndexView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.SkinCompatWordIndexView);
    this.y = paramContext.getResourceId(0, 2131100210);
    paramContext.recycle();
    a();
  }
  
  private int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public void a()
  {
    super.a();
    this.y = c.a(this.y);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int j = this.q;
    f1 /= getHeight();
    paramMotionEvent = this.f;
    int k = (int)(f1 * paramMotionEvent.length);
    a locala;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i == 2) && (j != k))
        {
          locala = this.d;
          if ((locala != null) && (k >= 0) && (k < paramMotionEvent.length))
          {
            locala.a(paramMotionEvent[k]);
            this.q = k;
          }
        }
      }
      else {
        this.q = -1;
      }
    }
    else if (j != k)
    {
      locala = this.d;
      if ((locala != null) && (k >= 0) && (k < paramMotionEvent.length))
      {
        locala.a(paramMotionEvent[k]);
        this.q = k;
      }
    }
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    int k = i / this.f.length;
    for (i = 0; i < this.f.length; i++)
    {
      this.x.setColor(this.y);
      this.x.setTextSize(b(getContext(), 12.0F));
      this.x.setTypeface(Typeface.DEFAULT);
      this.x.setAntiAlias(true);
      float f1 = j / 2;
      float f2 = this.x.measureText(this.f[i]) / 2.0F;
      float f3 = k * i + k;
      paramCanvas.drawText(this.f[i], f1 - f2, f3, this.x);
      this.x.reset();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnTouchingLetterChangedListener(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\skin\SkinCompatWordIndexView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */