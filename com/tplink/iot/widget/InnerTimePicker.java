package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.o0;

public class InnerTimePicker
  extends LinearLayout
  implements NumberPickerView.d
{
  private NumberPickerView c;
  private NumberPickerView d;
  private NumberPickerView f;
  private boolean p0;
  private int p1 = 0;
  private NumberPickerView q;
  private TextView x;
  private a y;
  private boolean z = true;
  
  public InnerTimePicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerTimePicker(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InnerTimePicker(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131558746, this, true);
    this.c = ((NumberPickerView)findViewById(2131362784));
    this.d = ((NumberPickerView)findViewById(2131363458));
    this.f = ((NumberPickerView)findViewById(2131361963));
    this.q = ((NumberPickerView)findViewById(2131361962));
    this.x = ((TextView)findViewById(2131364643));
    findViewById(2131364294).setVisibility(8);
    this.f.S(h.c());
    this.q.S(h.c());
    this.c.S(h.b());
    this.d.S(h.f());
    d(paramContext);
    this.c.setWrapSelectorWheel(false);
    this.d.setWrapSelectorWheel(false);
    this.f.setOnValueChangedListener(this);
    this.q.setOnValueChangedListener(this);
    this.c.setOnValueChangedListener(this);
    this.d.setOnValueChangedListener(this);
  }
  
  private int b(NumberPickerView paramNumberPickerView)
  {
    if (this.c.getValue() == 11)
    {
      if (paramNumberPickerView.getValue() == 0) {
        return this.d.getValue();
      }
      return this.d.getValue() + 720;
    }
    return (paramNumberPickerView.getValue() * 12 + this.c.getValue() + 1) * 60 + this.d.getValue();
  }
  
  private void d(Context paramContext)
  {
    this.z = o0.p(paramContext);
    boolean bool = o0.q(paramContext);
    this.p0 = bool;
    if (this.z)
    {
      this.f.setVisibility(8);
      this.q.setVisibility(8);
      this.c.S(h.b());
      this.d.S(h.f());
    }
    else
    {
      if (bool)
      {
        this.f.setVisibility(0);
        this.q.setVisibility(8);
        this.f.S(h.c());
      }
      else
      {
        this.f.setVisibility(8);
        this.q.setVisibility(0);
        this.q.S(h.c());
      }
      this.c.S(h.a());
      this.d.S(h.f());
    }
  }
  
  public void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
  {
    paramNumberPickerView = this.y;
    if (paramNumberPickerView != null) {
      paramNumberPickerView.m();
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.p1 = paramInt;
    int i = paramInt / 60 % 24;
    int j;
    if (i < 12) {
      j = 0;
    } else {
      j = 1;
    }
    int k = i;
    if (!this.z)
    {
      k = i % 12;
      if (k == 0) {
        k = 11;
      } else {
        k--;
      }
    }
    if (this.p0) {
      this.f.a0(j);
    } else {
      this.q.a0(j);
    }
    this.c.a0(k);
    this.d.a0(paramInt % 60);
  }
  
  public int getMinutesOfDay()
  {
    if (this.z) {
      return this.c.getValue() * 60 + this.d.getValue();
    }
    if (this.p0) {
      return b(this.f);
    }
    return b(this.q);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      d(getContext());
      setMinuteOfDay(this.p1);
    }
    else
    {
      this.p1 = getMinutesOfDay();
    }
  }
  
  public void setMinuteOfDay(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.p1 = paramInt;
    int i = paramInt / 60 % 24;
    int j;
    if (i < 12) {
      j = 0;
    } else {
      j = 1;
    }
    int k = i;
    if (!this.z)
    {
      k = i % 12;
      if (k == 0) {
        k = 11;
      } else {
        k--;
      }
    }
    if (this.p0) {
      this.f.setValue(j);
    } else {
      this.q.setValue(j);
    }
    this.c.setValue(k);
    this.d.setValue(paramInt % 60);
  }
  
  public void setOnTimePickerChangeListener(a parama)
  {
    this.y = parama;
  }
  
  public static abstract interface a
  {
    public abstract void m();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\InnerTimePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */