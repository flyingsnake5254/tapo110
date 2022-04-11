package com.tplink.iot.widget.camerasetting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import b.d.q.b.j;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;

public class SimpleProcessBarNewIpc
  extends View
{
  int c = getResources().getColor(2131100108);
  int d = getResources().getColor(2131099752);
  int f = getResources().getColor(2131100196);
  private int p0;
  private int p1 = 0;
  private SdCardStatus q;
  private float x = a(getContext(), 5.0F);
  private Paint y = new Paint(1);
  private int z;
  
  public SimpleProcessBarNewIpc(Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleProcessBarNewIpc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    float f3;
    if (j.a())
    {
      float f1 = paramInt;
      float f2 = this.p0;
      f3 = this.x;
      paramCanvas.drawRoundRect(0.0F, 0.0F, f1, f2, f3, f3, this.y);
    }
    else
    {
      RectF localRectF = new RectF(0.0F, 0.0F, paramInt, this.p0);
      f3 = this.x;
      paramCanvas.drawRoundRect(localRectF, f3, f3, this.y);
    }
  }
  
  public int getProcess()
  {
    return this.p1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.z = getWidth();
    this.p0 = getHeight();
    if (!SdCardStatus.ABNORMAL.equals(this.q))
    {
      SdCardStatus localSdCardStatus = SdCardStatus.FULL;
      if (!localSdCardStatus.equals(this.q))
      {
        if (SdCardStatus.UNFORMATTED.equals(this.q))
        {
          this.y.setColor(this.d);
          b(paramCanvas, this.z);
          return;
        }
        if (localSdCardStatus.equals(this.q))
        {
          this.y.setColor(this.f);
          b(paramCanvas, this.z);
        }
        else
        {
          this.y.setColor(this.d);
          this.y.setStyle(Paint.Style.FILL);
          b(paramCanvas, this.z);
          float f1 = (float)(this.p1 / 100.0D);
          this.y.setColor(this.c);
          b(paramCanvas, (int)(this.z * f1));
        }
        return;
      }
    }
    this.y.setColor(this.f);
    b(paramCanvas, this.z);
  }
  
  public void setProcess(int paramInt)
  {
    this.p1 = paramInt;
    invalidate();
  }
  
  public void setStatus(SdCardStatus paramSdCardStatus)
  {
    this.q = paramSdCardStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerasetting\SimpleProcessBarNewIpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */