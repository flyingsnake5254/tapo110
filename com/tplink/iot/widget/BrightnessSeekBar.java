package com.tplink.iot.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;

public class BrightnessSeekBar
  extends LinearLayout
{
  private TextView c;
  private AppCompatSeekBar d;
  private int f;
  private int q;
  private boolean x = false;
  private b y;
  
  public BrightnessSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BrightnessSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BrightnessSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559401, this, true);
    this.c = ((TextView)findViewById(2131364355));
    paramContext = (AppCompatSeekBar)findViewById(2131364008);
    this.d = paramContext;
    this.q = Math.max(paramContext.getPaddingLeft(), this.d.getPaddingRight());
    this.d.setOnSeekBarChangeListener(new a());
  }
  
  private void setTextProgress(int paramInt)
  {
    String str = String.format("%s%%", new Object[] { String.valueOf(paramInt) });
    int i = (int)this.c.getPaint().measureText(str);
    int j = this.q;
    int k = this.f;
    j = j + (k - j * 2) * paramInt / 100 - i / 2;
    if (j <= 0)
    {
      paramInt = 0;
    }
    else
    {
      paramInt = j;
      if (j >= k - i) {
        paramInt = k - i;
      }
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.gravity = 0;
    localLayoutParams.leftMargin = paramInt;
    this.c.setLayoutParams(localLayoutParams);
    this.c.setText(str);
  }
  
  public void e(int paramInt)
  {
    post(new a(this, paramInt));
  }
  
  public int getProgress()
  {
    return this.d.getProgress();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.x)
    {
      this.x = true;
      setTextProgress(this.d.getProgress());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.f = getMeasuredWidth();
  }
  
  public void setOnSeekbarChangeListener(b paramb)
  {
    this.y = paramb;
  }
  
  public void setProgress(int paramInt)
  {
    int i;
    if (paramInt >= 1)
    {
      i = paramInt;
      if (paramInt <= 100) {}
    }
    else if (paramInt < 1)
    {
      i = 1;
    }
    else
    {
      i = 100;
    }
    this.d.setProgress(i);
    setTextProgress(i);
  }
  
  public void setProgressTextColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
  }
  
  class a
    implements SeekBar.OnSeekBarChangeListener
  {
    a() {}
    
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      int i;
      if (paramInt >= 1)
      {
        i = paramInt;
        if (paramInt <= 100) {}
      }
      else
      {
        if (paramInt < 1) {
          paramInt = 1;
        } else {
          paramInt = 100;
        }
        paramSeekBar.setProgress(paramInt);
        i = paramInt;
      }
      BrightnessSeekBar.a(BrightnessSeekBar.this, i);
      if (BrightnessSeekBar.b(BrightnessSeekBar.this) != null) {
        BrightnessSeekBar.b(BrightnessSeekBar.this).a(paramBoolean);
      }
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      if (BrightnessSeekBar.b(BrightnessSeekBar.this) != null) {
        BrightnessSeekBar.b(BrightnessSeekBar.this).onStartTrackingTouch(paramSeekBar);
      }
    }
    
    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      if (BrightnessSeekBar.b(BrightnessSeekBar.this) != null) {
        BrightnessSeekBar.b(BrightnessSeekBar.this).onStopTrackingTouch(paramSeekBar);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
    
    public abstract void onStartTrackingTouch(SeekBar paramSeekBar);
    
    public abstract void onStopTrackingTouch(SeekBar paramSeekBar);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\BrightnessSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */