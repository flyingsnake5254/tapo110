package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import java.util.List;

public class BulbBrightnessView
  extends LinearLayout
{
  private BrightnessSeekBar c;
  private BulbPresetsView d;
  private c f;
  
  public BulbBrightnessView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BulbBrightnessView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BulbBrightnessView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559404, this, true);
    this.c = ((BrightnessSeekBar)findViewById(2131362028));
    paramContext = (BulbPresetsView)findViewById(2131363689);
    this.d = paramContext;
    paramContext.setOnPresetItemCheckListener(new a());
    this.c.setOnSeekbarChangeListener(new b());
  }
  
  public void f(int paramInt)
  {
    this.c.post(new b(this, paramInt));
  }
  
  public int getBrightness()
  {
    return this.c.getProgress();
  }
  
  public void setBrightness(int paramInt)
  {
    this.c.setProgress(paramInt);
  }
  
  public void setOnProgressBarChangeListener(c paramc)
  {
    this.f = paramc;
  }
  
  public void setPresets(List<Integer> paramList)
  {
    this.d.setPresets(paramList);
  }
  
  class a
    implements BulbPresetsView.c
  {
    a() {}
    
    public void a(int paramInt)
    {
      BulbBrightnessView.a(BulbBrightnessView.this).setProgress(paramInt);
    }
  }
  
  class b
    implements BrightnessSeekBar.b
  {
    b() {}
    
    public void a(boolean paramBoolean)
    {
      if (BulbBrightnessView.b(BulbBrightnessView.this) != null) {
        BulbBrightnessView.b(BulbBrightnessView.this).onChange();
      }
      if (paramBoolean) {
        BulbBrightnessView.c(BulbBrightnessView.this).d();
      }
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
  
  public static abstract interface c
  {
    public abstract void onChange();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\BulbBrightnessView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */