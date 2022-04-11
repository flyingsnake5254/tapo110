package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.Formatter;

public class CustomTimePicker
  extends FrameLayout
{
  NumberPicker c;
  NumberPicker d;
  NumberPicker f;
  
  public CustomTimePicker(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = FrameLayout.inflate(paramContext, 2131559456, this);
    this.c = ((NumberPicker)paramContext.findViewById(2131364236));
    this.d = ((NumberPicker)paramContext.findViewById(2131364237));
    this.f = ((NumberPicker)paramContext.findViewById(2131361961));
    this.c.setMinValue(0);
    this.c.setMaxValue(23);
    this.c.setFormatter(new a());
    this.c.setDescendantFocusability(393216);
    this.d.setMaxValue(59);
    this.d.setMinValue(0);
    this.d.setFormatter(new b());
    this.d.setDescendantFocusability(393216);
  }
  
  public int getCurrentHour()
  {
    return this.c.getValue();
  }
  
  public int getCurrentMinute()
  {
    return this.d.getValue();
  }
  
  public void setCurrentHour(int paramInt)
  {
    this.c.setValue(paramInt);
  }
  
  public void setCurrentMinute(int paramInt)
  {
    this.d.setValue(paramInt);
  }
  
  class a
    implements NumberPicker.Formatter
  {
    a() {}
    
    public String format(int paramInt)
    {
      Object localObject;
      if (paramInt < 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = String.valueOf(paramInt);
      }
      return (String)localObject;
    }
  }
  
  class b
    implements NumberPicker.Formatter
  {
    b() {}
    
    public String format(int paramInt)
    {
      Object localObject;
      if (paramInt < 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = String.valueOf(paramInt);
      }
      return (String)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\CustomTimePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */