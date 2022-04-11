package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.text.TextUtilsCompat;

public class CustomSeekBar
  extends AppCompatSeekBar
  implements SeekBar.OnSeekBarChangeListener
{
  private float H3;
  private int I3 = 1;
  private float J3;
  private String K3;
  private a L3 = null;
  private int c;
  private float d;
  private String f;
  private float p0;
  private float p1;
  private float p2;
  Paint p3;
  private String q;
  private String x;
  private String y;
  private float z;
  
  public CustomSeekBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public CustomSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.CustomSeekBar);
    int i = paramContext.getIndexCount();
    for (int j = 0; j < i; j++)
    {
      int k = paramContext.getIndex(j);
      if (k == x0.CustomSeekBar_text_size) {
        this.d = paramContext.getDimension(k, 14.0F);
      } else if (k == x0.CustomSeekBar_text_color) {
        this.c = paramContext.getColor(k, getResources().getColor(p0.common_tplink_green));
      } else if (k == x0.CustomSeekBar_text_start) {
        this.q = paramContext.getString(k);
      } else if (k == x0.CustomSeekBar_text_mid) {
        this.x = paramContext.getString(k);
      } else if (k == x0.CustomSeekBar_text_end) {
        this.y = paramContext.getString(k);
      } else if (k == x0.CustomSeekBar_text_margin) {
        this.z = paramContext.getDimension(k, 10.0F);
      } else if (k == x0.CustomSeekBar_text_holder_width) {
        this.p0 = paramContext.getDimension(k, 30.0F);
      } else if (k == x0.CustomSeekBar_text_holder_height) {
        this.p1 = paramContext.getDimension(k, 20.0F);
      } else if (k == x0.CustomSeekBar_text_offset) {
        this.p2 = paramContext.getDimension(k, 0.0F);
      } else if (k == x0.CustomSeekBar_text_family) {
        this.K3 = paramContext.getString(k);
      }
    }
    paramContext.recycle();
    paramContext = new Paint();
    this.p3 = paramContext;
    paramContext.setAntiAlias(true);
    this.p3.setTextSize(this.d);
    this.p3.setColor(this.c);
    if (TextUtils.isEmpty(this.K3)) {
      this.K3 = "sans-serif";
    }
    paramContext = Typeface.create(this.K3, 0);
    if (paramContext != null) {
      this.p3.setTypeface(paramContext);
    }
    setPadding((int)Math.ceil(this.p0) / 2, (int)Math.ceil(this.p1) + 10, (int)Math.ceil(this.p0) / 2, (int)Math.ceil(this.p1) + 10);
    if (getProgress() < getMax() / 4)
    {
      this.f = this.q;
      setProgress(0);
    }
    else if (getProgress() > getMax() * 3 / 4)
    {
      this.f = this.y;
      setProgress(getMax());
    }
    else
    {
      this.f = this.x;
      setProgress(getMax() / 2);
    }
    setOnSeekBarChangeListener(this);
  }
  
  private void c()
  {
    Paint.FontMetrics localFontMetrics = this.p3.getFontMetrics();
    this.H3 = this.p3.measureText(this.f);
    float f1 = this.p1 / 2.0F;
    float f2 = localFontMetrics.descent;
    this.J3 = (f1 - f2 + (f2 - localFontMetrics.ascent) / 2.0F);
  }
  
  protected boolean b()
  {
    int i = TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public String getTitleText()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      c();
      Rect localRect = getProgressDrawable().getBounds();
      if (b())
      {
        f1 = localRect.width() * (getMax() - getProgress()) / getMax();
        f2 = this.p0;
      }
      for (float f3 = this.H3;; f3 = this.H3)
      {
        f2 = f1 + (f2 - f3) / 2.0F;
        break;
        f1 = localRect.width() * getProgress() / getMax();
        f2 = this.p0;
      }
      int i = this.I3;
      if (i == 1) {
        if (!b()) {}
      }
      for (float f1 = this.p2;; f1 = this.p2)
      {
        f1 = f2 - f1;
        break label193;
        for (f1 = this.p2;; f1 = this.p2)
        {
          f1 = f2 + f1;
          break label193;
          if (i != 3) {
            break label182;
          }
          if (!b()) {
            break;
          }
        }
      }
      label182:
      this.f = this.x;
      f1 = f2;
      label193:
      f3 = (float)(localRect.height() + this.J3 + this.p1 * 0.16D / 2.0D);
      float f2 = this.z;
      paramCanvas.drawText(this.f, f1, f3 - f2, this.p3);
      return;
    }
    finally {}
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    invalidate();
    a locala = this.L3;
    if (locala != null) {
      locala.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    a locala = this.L3;
    if (locala != null) {
      locala.onStartTrackingTouch(paramSeekBar);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (paramSeekBar.getProgress() < paramSeekBar.getMax() / 4)
    {
      paramSeekBar.setProgress(0);
      this.I3 = 1;
      setTitleText(this.q);
    }
    else if (paramSeekBar.getProgress() >= paramSeekBar.getMax() * 3 / 4)
    {
      paramSeekBar.setProgress(paramSeekBar.getMax());
      this.I3 = 3;
      setTitleText(this.y);
    }
    else
    {
      paramSeekBar.setProgress(paramSeekBar.getMax() / 2);
      this.I3 = 2;
      setTitleText(this.x);
    }
    invalidate();
    a locala = this.L3;
    if (locala != null) {
      locala.onStopTrackingTouch(paramSeekBar);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 2) {
      setTitleText("");
    } else if (paramMotionEvent.getAction() == 1) {
      if (getProgress() < getMax() / 4)
      {
        setTitleText(this.q);
        this.I3 = 1;
      }
      else if ((getProgress() >= getMax() / 4) && (getProgress() < getMax() * 3 / 4))
      {
        setTitleText(this.x);
        this.I3 = 2;
      }
      else
      {
        setTitleText(this.y);
        this.I3 = 3;
      }
    }
    invalidate();
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnCustomSeekBarChangeListener(a parama)
  {
    this.L3 = parama;
  }
  
  public void setSeekBarProgress(int paramInt)
  {
    setProgress(paramInt);
    if (paramInt < getMax() / 4)
    {
      setProgress(0);
      this.I3 = 1;
      setTitleText(this.q);
    }
    else if (paramInt >= getMax() * 3 / 4)
    {
      setProgress(getMax());
      this.I3 = 3;
      setTitleText(this.y);
    }
    else
    {
      setProgress(getMax() / 2);
      this.I3 = 2;
      setTitleText(this.x);
    }
    invalidate();
  }
  
  public void setTitleText(String paramString)
  {
    this.f = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean);
    
    public abstract void onStartTrackingTouch(SeekBar paramSeekBar);
    
    public abstract void onStopTrackingTouch(SeekBar paramSeekBar);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\CustomSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */