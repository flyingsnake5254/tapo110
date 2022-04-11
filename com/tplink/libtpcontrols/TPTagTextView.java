package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.text.TextUtilsCompat;

public class TPTagTextView
  extends AppCompatTextView
{
  private Paint c;
  private int d;
  private int f;
  private int q;
  private int x;
  private int y;
  private int z;
  
  public TPTagTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TPTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramContext, paramAttributeSet);
  }
  
  private int b(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.c.setStyle(Paint.Style.STROKE);
    Path localPath = new Path();
    int i = this.d;
    localPath.moveTo(i, i);
    localPath.lineTo(this.d, getHeight() - this.d);
    localPath.lineTo(getWidth() - this.d, getHeight() - this.d);
    int j = getWidth();
    i = this.d;
    localPath.lineTo(j - i, i);
    localPath.close();
    paramCanvas.drawPath(localPath, this.c);
  }
  
  private void d(Canvas paramCanvas)
  {
    this.c.setStyle(Paint.Style.STROKE);
    Path localPath = new Path();
    float f1;
    int i;
    if (f())
    {
      localPath.moveTo(this.d, getHeight() / 2.0F);
      f1 = getHeight() / 2.0F;
      i = this.d;
      localPath.lineTo(f1 + i, i);
      localPath.lineTo(getWidth(), this.d);
      localPath.lineTo(getWidth(), getHeight() - this.d);
      localPath.lineTo(getHeight() / 2.0F + this.d, getHeight() - this.d);
      localPath.close();
    }
    else
    {
      i = this.d;
      localPath.moveTo(i, i);
      localPath.lineTo(this.d, getHeight() - this.d);
      localPath.lineTo(getWidth() - getHeight() / 2.0F - this.d, getHeight() - this.d);
      localPath.lineTo(getWidth() - this.d, getHeight() / 2.0F);
      float f2 = getWidth();
      f1 = getHeight() / 2.0F;
      i = this.d;
      localPath.lineTo(f2 - f1 - i, i);
      localPath.close();
    }
    paramCanvas.drawPath(localPath, this.c);
    this.c.setStyle(Paint.Style.FILL);
    if (f()) {
      paramCanvas.drawCircle(getHeight() * 0.4F, getHeight() / 2.0F, b(1.0F), this.c);
    } else {
      paramCanvas.drawCircle(getWidth() - getHeight() * 0.4F, getHeight() / 2.0F, b(1.0F), this.c);
    }
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPTagTextView);
    int i = localTypedArray.getColor(x0.TPTagTextView_tt_border_color, ContextCompat.getColor(paramContext, p0.common_tplink_light_gray));
    this.f = localTypedArray.getInt(x0.TPTagTextView_tt_tag_style, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842965, 16843699, 16842967, 16843700, 16842969 });
    int j = paramContext.getDimensionPixelSize(0, 0);
    this.q = paramContext.getDimensionPixelSize(1, j);
    this.y = paramContext.getDimensionPixelSize(2, j);
    this.x = paramContext.getDimensionPixelSize(3, j);
    this.z = paramContext.getDimensionPixelSize(4, j);
    this.d = b(1.0F);
    paramAttributeSet = new Paint();
    this.c = paramAttributeSet;
    paramAttributeSet.setFlags(1);
    this.c.setColor(i);
    this.c.setStrokeWidth(i);
    paramContext.recycle();
    localTypedArray.recycle();
  }
  
  protected boolean f()
  {
    int i = TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public int getTextPaddingBottom()
  {
    return this.z;
  }
  
  public int getTextPaddingEnd()
  {
    return this.x;
  }
  
  public int getTextPaddingStart()
  {
    return this.q;
  }
  
  public int getTextPaddingTop()
  {
    return this.y;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.f;
    if (i == 0) {
      d(paramCanvas);
    } else if (1 == i) {
      c(paramCanvas);
    }
  }
  
  public void setTagStyle(int paramInt)
  {
    int i;
    if (paramInt <= 1)
    {
      i = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      i = 0;
    }
    this.f = i;
    postInvalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPTagTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */