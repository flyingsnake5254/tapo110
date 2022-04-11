package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

public final class AspectRatioFrameLayout
  extends FrameLayout
{
  private final c c;
  @Nullable
  private b d;
  private float f;
  private int q = 0;
  
  public AspectRatioFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AspectRatioFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null) {
      paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, t0.AspectRatioFrameLayout, 0, 0);
    }
    try
    {
      this.q = paramContext.getInt(t0.AspectRatioFrameLayout_resize_mode, 0);
      paramContext.recycle();
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public int getResizeMode()
  {
    return this.q;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.f <= 0.0F) {
      return;
    }
    paramInt2 = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    float f1 = paramInt2;
    float f2 = paramInt1;
    float f3 = f1 / f2;
    float f4 = this.f / f3 - 1.0F;
    if (Math.abs(f4) <= 0.01F)
    {
      this.c.a(this.f, f3, false);
      return;
    }
    int i = this.q;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 4) {
            break label189;
          }
          if (f4 > 0.0F)
          {
            f4 = this.f;
            break label139;
          }
          f4 = this.f;
          break label155;
        }
      }
    }
    for (f4 = this.f;; f4 = this.f)
    {
      label139:
      paramInt2 = (int)(f2 * f4);
      break;
      for (f4 = this.f;; f4 = this.f)
      {
        label155:
        paramInt1 = (int)(f1 / f4);
        break label189;
        if (f4 <= 0.0F) {
          break;
        }
      }
    }
    label189:
    this.c.a(this.f, f3, true);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  public void setAspectRatio(float paramFloat)
  {
    if (this.f != paramFloat)
    {
      this.f = paramFloat;
      requestLayout();
    }
  }
  
  public void setAspectRatioListener(@Nullable b paramb)
  {
    this.d = paramb;
  }
  
  public void setResizeMode(int paramInt)
  {
    if (this.q != paramInt)
    {
      this.q = paramInt;
      requestLayout();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat1, float paramFloat2, boolean paramBoolean);
  }
  
  private final class c
    implements Runnable
  {
    private float c;
    private float d;
    private boolean f;
    private boolean q;
    
    private c() {}
    
    public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      this.c = paramFloat1;
      this.d = paramFloat2;
      this.f = paramBoolean;
      if (!this.q)
      {
        this.q = true;
        AspectRatioFrameLayout.this.post(this);
      }
    }
    
    public void run()
    {
      this.q = false;
      if (AspectRatioFrameLayout.a(AspectRatioFrameLayout.this) == null) {
        return;
      }
      AspectRatioFrameLayout.a(AspectRatioFrameLayout.this).a(this.c, this.d, this.f);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\AspectRatioFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */