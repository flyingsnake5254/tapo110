package com.tplink.iot.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class RoundImageView
  extends AppCompatImageView
{
  float c;
  float d;
  Path f = new Path();
  float q;
  
  public RoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.q = b.d.w.f.a.a(paramContext, 10.0F);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      float f1 = this.c;
      float f2 = this.q;
      if ((f1 > f2) && (this.d > f2))
      {
        this.f.moveTo(f2, 0.0F);
        this.f.lineTo(this.c - this.q, 0.0F);
        Path localPath = this.f;
        f1 = this.c;
        localPath.quadTo(f1, 0.0F, f1, this.q);
        this.f.lineTo(this.c, this.d - this.q);
        localPath = this.f;
        f1 = this.c;
        f2 = this.d;
        localPath.quadTo(f1, f2, f1 - this.q, f2);
        this.f.lineTo(this.q, this.d);
        localPath = this.f;
        f1 = this.d;
        localPath.quadTo(0.0F, f1, 0.0F, f1 - this.q);
        this.f.lineTo(0.0F, this.q);
        this.f.quadTo(0.0F, 0.0F, this.q, 0.0F);
        paramCanvas.clipPath(this.f);
      }
      super.onDraw(paramCanvas);
    }
    catch (Exception paramCanvas)
    {
      b.d.w.c.a.a("onDraw Exception");
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = getWidth();
    this.d = getHeight();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\RoundImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */