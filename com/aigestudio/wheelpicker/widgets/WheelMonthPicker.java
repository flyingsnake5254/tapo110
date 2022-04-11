package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WheelMonthPicker
  extends WheelPicker
{
  private int C4;
  
  public WheelMonthPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WheelMonthPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new ArrayList();
    for (int i = 1; i <= 12; i++) {
      paramContext.add(Integer.valueOf(i));
    }
    super.setData(paramContext);
    this.C4 = (Calendar.getInstance().get(2) + 1);
    n();
  }
  
  private void n()
  {
    setSelectedItemPosition(this.C4 - 1);
  }
  
  public int getCurrentMonth()
  {
    return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
  }
  
  public int getSelectedMonth()
  {
    return this.C4;
  }
  
  public void setData(List paramList)
  {
    throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
  }
  
  public void setSelectedMonth(int paramInt)
  {
    this.C4 = paramInt;
    n();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\widgets\WheelMonthPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */