package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WheelYearPicker
  extends WheelPicker
{
  private int C4 = 1000;
  private int D4 = 3000;
  private int E4;
  
  public WheelYearPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WheelYearPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    o();
    this.E4 = Calendar.getInstance().get(1);
    n();
  }
  
  private void n()
  {
    setSelectedItemPosition(this.E4 - this.C4);
  }
  
  private void o()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = this.C4; i <= this.D4; i++) {
      localArrayList.add(Integer.valueOf(i));
    }
    super.setData(localArrayList);
  }
  
  public int getCurrentYear()
  {
    return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
  }
  
  public int getSelectedYear()
  {
    return this.E4;
  }
  
  public int getYearEnd()
  {
    return this.D4;
  }
  
  public int getYearStart()
  {
    return this.C4;
  }
  
  public void setData(List paramList)
  {
    throw new UnsupportedOperationException("You can not invoke setData in WheelYearPicker");
  }
  
  public void setSelectedYear(int paramInt)
  {
    this.E4 = paramInt;
    n();
  }
  
  public void setYearEnd(int paramInt)
  {
    this.D4 = paramInt;
    o();
  }
  
  public void setYearStart(int paramInt)
  {
    this.C4 = paramInt;
    this.E4 = getCurrentYear();
    o();
    n();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\widgets\WheelYearPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */