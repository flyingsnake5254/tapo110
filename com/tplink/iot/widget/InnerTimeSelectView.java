package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class InnerTimeSelectView
  extends LinearLayout
  implements NumberPickerView.d
{
  private NumberPickerView c;
  private NumberPickerView d;
  private TextView f;
  private a q;
  
  public InnerTimeSelectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerTimeSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InnerTimeSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131558779, this, true);
    this.c = ((NumberPickerView)findViewById(2131362784));
    this.d = ((NumberPickerView)findViewById(2131363458));
    this.f = ((TextView)findViewById(2131364643));
    findViewById(2131364294).setVisibility(8);
    this.c.setWrapSelectorWheel(false);
    this.d.setWrapSelectorWheel(false);
    this.c.S(h.b());
    this.d.S(h.f());
    this.c.setOnValueChangedListener(this);
    this.d.setOnValueChangedListener(this);
  }
  
  public void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
  {
    paramNumberPickerView = this.q;
    if (paramNumberPickerView != null) {
      paramNumberPickerView.m();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.c.setHintText(getContext().getString(2131953394));
      this.d.setHintText(getContext().getString(2131953395));
      this.c.setHintTextColor(getResources().getColor(2131099808));
      this.d.setHintTextColor(getResources().getColor(2131099808));
    }
    else
    {
      this.f.setVisibility(0);
    }
  }
  
  public int getMinutesOfDay()
  {
    return this.c.getValue() * 60 + this.d.getValue();
  }
  
  public void setMinuteOfDay(int paramInt)
  {
    int i = paramInt / 60;
    this.c.setValue(i % 24);
    this.d.setValue(paramInt % 60);
  }
  
  public void setOnTimePickerChangeListener(a parama)
  {
    this.q = parama;
  }
  
  public static abstract interface a
  {
    public abstract void m();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\InnerTimeSelectView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */