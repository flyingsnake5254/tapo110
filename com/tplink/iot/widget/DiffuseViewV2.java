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

public class DiffuseViewV2
  extends View
{
  private boolean H3 = false;
  private List<Integer> I3 = new ArrayList();
  private List<Integer> J3 = new ArrayList();
  private Paint K3;
  private int c = getResources().getColor(2131099808);
  private int d = getResources().getColor(2131099808);
  private Bitmap f;
  private boolean p0 = false;
  private boolean p1 = false;
  private int p2 = 3;
  private int p3 = 2;
  private float q = 100.0F;
  private int x = 3;
  private Integer y = Integer.valueOf(255);
  private int z = 7;
  
  public DiffuseViewV2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DiffuseViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public DiffuseViewV2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.DiffuseViewV2, paramInt, 0);
    this.c = paramContext.getColor(1, this.c);
    this.d = paramContext.getColor(2, this.d);
    this.q = paramContext.getFloat(4, this.q);
    this.x = paramContext.getInt(8, this.x);
    this.y = Integer.valueOf(paramContext.getInt(6, this.y.intValue()));
    this.z = paramContext.getInt(7, this.z);
    this.p3 = paramContext.getInt(0, this.p3);
    this.H3 = paramContext.getBoolean(5, this.H3);
    paramInt = paramContext.getResourceId(3, -1);
    if (paramInt != -1) {
      this.f = BitmapFactory.decodeResource(getResources(), paramInt);
    }
    paramContext.recycle();
  }
  
  private void a()
  {
    Paint localPaint = new Paint();
    this.K3 = localPaint;
    localPaint.setAntiAlias(true);
  }
  
  public void b()
  {
    if (this.p0) {
      c();
    }
    this.p0 = true;
    this.I3.add(Integer.valueOf(255));
    this.J3.add(Integer.valueOf(0));
    invalidate();
  }
  
  public void c()
  {
    this.p0 = false;
    this.J3.clear();
    this.I3.clear();
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
    this.K3.setColor(this.c);
    this.K3.setStyle(Paint.Style.STROKE);
    this.K3.setStrokeWidth(this.p3);
    for (int i = 0;; i++)
    {
      int j = this.I3.size();
      int k = 1;
      if (i >= j) {
        break;
      }
      Integer localInteger = (Integer)this.I3.get(i);
      this.K3.setAlpha(localInteger.intValue());
      localObject = (Integer)this.J3.get(i);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.q + ((Integer)localObject).intValue(), this.K3);
      if ((localInteger.intValue() > 0) && (((Integer)localObject).intValue() < this.y.intValue()))
      {
        List localList = this.I3;
        if (localInteger.intValue() - this.z > 0) {
          k = localInteger.intValue() - this.z;
        }
        localList.set(i, Integer.valueOf(k));
        this.J3.set(i, Integer.valueOf(((Integer)localObject).intValue() + this.z));
      }
    }
    if (!this.J3.isEmpty())
    {
      localObject = this.J3;
      if (((Integer)((List)localObject).get(((List)localObject).size() - 1)).intValue() >= this.y.intValue() / this.x)
      {
        this.I3.add(Integer.valueOf(255));
        this.J3.add(Integer.valueOf(0));
      }
    }
    if (this.J3.size() >= 10)
    {
      this.J3.remove(0);
      this.I3.remove(0);
    }
    this.K3.setAlpha(255);
    this.K3.setColor(this.d);
    if (this.H3) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.q, this.K3);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCanvas.drawBitmap((Bitmap)localObject, getWidth() / 2 - this.f.getWidth() / 2, getHeight() / 2 - this.f.getHeight() / 2, this.K3);
    }
    if (this.p0) {
      if (!this.p1) {
        invalidate();
      } else if (this.J3.size() <= this.p2) {
        invalidate();
      } else {
        c();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\DiffuseViewV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */