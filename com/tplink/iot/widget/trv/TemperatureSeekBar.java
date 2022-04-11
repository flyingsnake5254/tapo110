package com.tplink.iot.widget.trv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class TemperatureSeekBar
  extends FrameLayout
{
  private b c;
  private final TextView d;
  private final SeekBar f;
  private int p0 = this.y;
  private boolean q;
  private EnumTemperatureUnit x = EnumTemperatureUnit.CELSIUS;
  private int y;
  private int z = 100;
  
  public TemperatureSeekBar(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public TemperatureSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public TemperatureSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559442, this, true);
    paramContext = findViewById(2131364667);
    j.d(paramContext, "findViewById(R.id.tv_text)");
    this.d = ((TextView)paramContext);
    paramContext = findViewById(2131363996);
    j.d(paramContext, "findViewById(R.id.seekBar)");
    paramContext = (SeekBar)paramContext;
    this.f = paramContext;
    paramContext.setOnSeekBarChangeListener(new a(this));
    i(this.y, this.z, this.x);
  }
  
  @SuppressLint({"SetTextI18n"})
  private final void j(int paramInt)
  {
    this.d.setText(b.d(paramInt, this.x));
    this.d.measure(0, 0);
    paramInt = Math.max(Math.min(Math.max(0, (int)((this.f.getWidth() - this.f.getPaddingLeft() - this.f.getPaddingRight()) * (this.f.getProgress() / this.f.getMax()) + this.f.getPaddingLeft() - this.d.getMeasuredWidth() / 2.0F)), this.f.getWidth() - this.d.getMeasuredWidth()), 0);
    TextView localTextView = this.d;
    Object localObject = localTextView.getLayoutParams();
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    localObject = (LinearLayout.LayoutParams)localObject;
    ((LinearLayout.LayoutParams)localObject).setMarginStart(paramInt);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void setTemperatureInternal(int paramInt)
  {
    int i = this.y;
    int j = this.z;
    if ((i <= paramInt) && (j >= paramInt))
    {
      this.p0 = paramInt;
      paramInt -= i;
      if (Build.VERSION.SDK_INT >= 24) {
        this.f.setProgress(paramInt, true);
      } else {
        this.f.setProgress(paramInt);
      }
      j(this.p0);
      b localb = this.c;
      if (localb != null) {
        localb.a(this.f, this.p0, this.x, false);
      }
    }
  }
  
  public final int getMaxTemperature()
  {
    return this.z;
  }
  
  public final int getMinTemperature()
  {
    return this.y;
  }
  
  public final int getTemperature()
  {
    return this.p0;
  }
  
  public final void h(final int paramInt)
  {
    this.f.post(new c(this, paramInt));
  }
  
  public final void i(int paramInt1, int paramInt2, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "tempUnit");
    this.x = paramEnumTemperatureUnit;
    this.y = paramInt1;
    this.z = paramInt2;
    this.f.setMax(paramInt2 - paramInt1);
    h(this.p0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.q)
    {
      this.q = true;
      j(this.p0);
    }
  }
  
  public final void setOnSeekBarChangeListener(b paramb)
  {
    j.e(paramb, "listener");
    paramb.a(this.f, getTemperature(), this.x, false);
    p localp = p.a;
    this.c = paramb;
  }
  
  public final void setTemperature(int paramInt)
  {
    setTemperatureInternal(paramInt);
  }
  
  public final void setTemperatureUnit(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "tempUnit");
    this.x = paramEnumTemperatureUnit;
    j(this.p0);
  }
  
  public static final class a
    implements SeekBar.OnSeekBarChangeListener
  {
    a(TemperatureSeekBar paramTemperatureSeekBar) {}
    
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = this.c;
        TemperatureSeekBar.e((TemperatureSeekBar)localObject, paramInt + TemperatureSeekBar.b((TemperatureSeekBar)localObject));
        localObject = this.c;
        TemperatureSeekBar.g((TemperatureSeekBar)localObject, TemperatureSeekBar.d((TemperatureSeekBar)localObject));
        localObject = TemperatureSeekBar.a(this.c);
        if (localObject != null) {
          ((TemperatureSeekBar.b)localObject).a(paramSeekBar, TemperatureSeekBar.d(this.c), TemperatureSeekBar.c(this.c), paramBoolean);
        }
      }
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      TemperatureSeekBar.b localb = TemperatureSeekBar.a(this.c);
      if (localb != null) {
        localb.onStartTrackingTouch(paramSeekBar);
      }
    }
    
    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      TemperatureSeekBar.b localb = TemperatureSeekBar.a(this.c);
      if (localb != null) {
        localb.onStopTrackingTouch(paramSeekBar);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(SeekBar paramSeekBar, int paramInt, EnumTemperatureUnit paramEnumTemperatureUnit, boolean paramBoolean);
    
    public abstract void onStartTrackingTouch(SeekBar paramSeekBar);
    
    public abstract void onStopTrackingTouch(SeekBar paramSeekBar);
  }
  
  static final class c
    implements Runnable
  {
    c(TemperatureSeekBar paramTemperatureSeekBar, int paramInt) {}
    
    public final void run()
    {
      TemperatureSeekBar.f(this.c, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\trv\TemperatureSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */