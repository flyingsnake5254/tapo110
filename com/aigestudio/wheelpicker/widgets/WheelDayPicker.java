package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WheelDayPicker
  extends WheelPicker
{
  private static final Map<Integer, List<Integer>> C4 = new HashMap();
  private Calendar D4;
  private int E4;
  private int F4;
  private int G4;
  
  public WheelDayPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WheelDayPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = Calendar.getInstance();
    this.D4 = paramContext;
    this.E4 = paramContext.get(1);
    this.F4 = this.D4.get(2);
    n();
    this.G4 = this.D4.get(5);
    o();
  }
  
  private void n()
  {
    Object localObject = this.D4;
    int i = this.E4;
    int j = 1;
    ((Calendar)localObject).set(1, i);
    this.D4.set(2, this.F4);
    i = this.D4.getActualMaximum(5);
    List localList = (List)C4.get(Integer.valueOf(i));
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      while (j <= i)
      {
        ((List)localObject).add(Integer.valueOf(j));
        j++;
      }
      C4.put(Integer.valueOf(i), localObject);
    }
    super.setData((List)localObject);
  }
  
  private void o()
  {
    setSelectedItemPosition(this.G4 - 1);
  }
  
  public int getCurrentDay()
  {
    return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
  }
  
  public int getMonth()
  {
    return this.F4;
  }
  
  public int getSelectedDay()
  {
    return this.G4;
  }
  
  public int getYear()
  {
    return this.E4;
  }
  
  public void setData(List paramList)
  {
    throw new UnsupportedOperationException("You can not invoke setData in WheelDayPicker");
  }
  
  public void setMonth(int paramInt)
  {
    this.F4 = (paramInt - 1);
    n();
  }
  
  public void setSelectedDay(int paramInt)
  {
    this.G4 = paramInt;
    o();
  }
  
  public void setYear(int paramInt)
  {
    this.E4 = paramInt;
    n();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\widgets\WheelDayPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */