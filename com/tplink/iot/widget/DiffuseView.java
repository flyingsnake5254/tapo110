package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.List;

public class DiffuseView
  extends View
{
  private List<Integer> H3 = new ArrayList();
  private Paint I3;
  private int c = getResources().getColor(2131099808);
  private int d = getResources().getColor(2131099808);
  private Bitmap f;
  private boolean p0 = false;
  private boolean p1 = false;
  private int p2 = 3;
  private List<Integer> p3 = new ArrayList();
  private float q = 100.0F;
  private int x = 3;
  private Integer y = Integer.valueOf(255);
  private int z = 7;
  
  public DiffuseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DiffuseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public DiffuseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.DiffuseView, paramInt, 0);
    this.c = paramContext.getColor(0, this.c);
    this.d = paramContext.getColor(1, this.d);
    this.q = paramContext.getFloat(3, this.q);
    this.x = paramContext.getInt(6, this.x);
    this.y = Integer.valueOf(paramContext.getInt(4, this.y.intValue()));
    this.z = paramContext.getInt(5, this.z);
    paramInt = paramContext.getResourceId(2, -1);
    if (paramInt != -1) {
      this.f = BitmapFactory.decodeResource(getResources(), paramInt);
    }
    paramContext.recycle();
  }
  
  private void a()
  {
    Paint localPaint = new Paint();
    this.I3 = localPaint;
    localPaint.setAntiAlias(true);
    this.p3.add(Integer.valueOf(255));
    this.H3.add(Integer.valueOf(0));
  }
  
  public boolean b()
  {
    return this.p0;
  }
  
  public void c()
  {
    this.p0 = true;
    invalidate();
  }
  
  public void d()
  {
    this.p0 = false;
    this.H3.clear();
    this.p3.clear();
    this.p3.add(Integer.valueOf(255));
    this.H3.add(Integer.valueOf(0));
    invalidate();
  }
  
  public void invalidate()
  {
    if (hasWindowFocus()) {
      super.invalidate();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.I3.setColor(this.c);
    this.I3.setStyle(Paint.Style.STROKE);
    this.I3.setStrokeWidth(2.0F);
    for (int i = 0;; i++)
    {
      int j = this.p3.size();
      int k = 1;
      if (i >= j) {
        break;
      }
      Integer localInteger = (Integer)this.p3.get(i);
      this.I3.setAlpha(localInteger.intValue());
      localObject = (Integer)this.H3.get(i);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.q + ((Integer)localObject).intValue(), this.I3);
      if ((localInteger.intValue() > 0) && (((Integer)localObject).intValue() < this.y.intValue()))
      {
        List localList = this.p3;
        if (localInteger.intValue() - this.z > 0) {
          k = localInteger.intValue() - this.z;
        }
        localList.set(i, Integer.valueOf(k));
        this.H3.set(i, Integer.valueOf(((Integer)localObject).intValue() + this.z));
      }
    }
    Object localObject = this.H3;
    if (((Integer)((List)localObject).get(((List)localObject).size() - 1)).intValue() >= this.y.intValue() / this.x)
    {
      this.p3.add(Integer.valueOf(255));
      this.H3.add(Integer.valueOf(0));
    }
    if (this.H3.size() >= 10)
    {
      this.H3.remove(0);
      this.p3.remove(0);
    }
    this.I3.setAlpha(255);
    this.I3.setColor(this.d);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.q, this.I3);
    localObject = this.f;
    if (localObject != null) {
      paramCanvas.drawBitmap((Bitmap)localObject, getWidth() / 2 - this.f.getWidth() / 2, getHeight() / 2 - this.f.getHeight() / 2, this.I3);
    }
    if (this.p0) {
      if (!this.p1) {
        invalidate();
      } else if (this.H3.size() <= this.p2) {
        invalidate();
      } else {
        d();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      invalidate();
    }
  }
  
  public void setAutoStopSize(int paramInt)
  {
    this.p2 = paramInt;
  }
  
  public void setColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCoreColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setCoreImage(int paramInt)
  {
    this.f = BitmapFactory.decodeResource(getResources(), paramInt);
  }
  
  public void setCoreRadius(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setDiffuseSpeed(int paramInt)
  {
    this.z = paramInt;
  }
  
  public void setDiffuseWidth(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setIsAutoStop(boolean paramBoolean)
  {
    this.p1 = paramBoolean;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.y = Integer.valueOf(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\DiffuseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */