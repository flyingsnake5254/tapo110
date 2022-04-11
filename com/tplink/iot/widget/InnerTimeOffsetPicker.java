package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class InnerTimeOffsetPicker
  extends LinearLayout
{
  private NumberPickerView c;
  private NumberPickerView d;
  private NumberPickerView f;
  private Context q;
  private boolean x = false;
  
  public InnerTimeOffsetPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerTimeOffsetPicker(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InnerTimeOffsetPicker(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131558745, this, true);
    this.q = paramContext;
    this.c = ((NumberPickerView)findViewById(2131363580));
    this.d = ((NumberPickerView)findViewById(2131362784));
    this.f = ((NumberPickerView)findViewById(2131363458));
    this.c.setWrapSelectorWheel(false);
    this.d.setWrapSelectorWheel(false);
    this.f.setWrapSelectorWheel(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    b(paramBoolean);
    if (paramInt == 0) {
      return;
    }
    int i = Math.abs(paramInt);
    if (this.x)
    {
      paramInt = i / 60 % 60;
      i %= 60;
    }
    else
    {
      int j = i / 60;
      i %= 60;
      NumberPickerView localNumberPickerView = this.c;
      if (paramInt < 0) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      localNumberPickerView.setValue(paramInt);
      paramInt = j % 6;
    }
    this.d.setValue(paramInt);
    this.f.setValue(i);
  }
  
  public void b(boolean paramBoolean)
  {
    this.x = paramBoolean;
    NumberPickerView localNumberPickerView = this.c;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localNumberPickerView.setVisibility(i);
    if (this.x)
    {
      ((TextView)findViewById(2131364574)).setText(2131953395);
      ((TextView)findViewById(2131364576)).setText(2131953396);
      this.d.S(h.f());
      this.f.S(h.i());
    }
    else
    {
      ((TextView)findViewById(2131364574)).setText(2131953394);
      ((TextView)findViewById(2131364576)).setText(2131953395);
      this.c.S(h.k(this.q));
      this.d.S(h.j());
      this.f.S(h.f());
    }
  }
  
  public int getTimeOffset()
  {
    int i;
    if ((this.c.getVisibility() == 0) && (this.c.getValue() == 0)) {
      i = -1;
    } else {
      i = 1;
    }
    return i * (this.d.getValue() * 60 + this.f.getValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\InnerTimeOffsetPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */