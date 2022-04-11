package com.tplink.iot.widget.time;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.NumberPickerView.d;
import com.tplink.iot.widget.h;

public class TimeMinSecSelectView
  extends FrameLayout
  implements NumberPickerView.d
{
  private NumberPickerView c;
  private NumberPickerView d;
  
  public TimeMinSecSelectView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimeMinSecSelectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeMinSecSelectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559444, this, true);
    this.c = ((NumberPickerView)findViewById(2131363458));
    this.d = ((NumberPickerView)findViewById(2131363994));
    this.c.setWrapSelectorWheel(false);
    this.d.setWrapSelectorWheel(false);
    this.c.S(h.f());
    this.d.S(h.i());
    this.c.setOnValueChangedListener(this);
    this.d.setOnValueChangedListener(this);
    if (getSecondOfTime() == 0) {
      this.d.setValue(1);
    }
  }
  
  public void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (this.c.getValue() == 0) && (this.d.getValue() == 0)) {
      this.d.a0(1);
    }
  }
  
  public int getSecondOfTime()
  {
    int i = this.c.getValue() * 60 + this.d.getValue();
    int j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
  
  public void setSecondOfTime(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    paramInt = i / 60;
    this.c.setValue(paramInt % 60);
    this.d.setValue(i % 60);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\time\TimeMinSecSelectView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */