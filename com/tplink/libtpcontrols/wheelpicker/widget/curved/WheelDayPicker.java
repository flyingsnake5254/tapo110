package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCurvedPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class WheelDayPicker
  extends WheelCurvedPicker
{
  private static final HashMap<Integer, List<String>> B4 = new HashMap();
  private static final Calendar C4 = Calendar.getInstance();
  private List<String> D4 = new ArrayList();
  private int E4;
  private int F4;
  private int G4;
  private int H4;
  
  public WheelDayPicker(Context paramContext)
  {
    super(paramContext);
    paramContext = C4;
    this.E4 = paramContext.get(5);
    this.F4 = (paramContext.get(2) + 1);
    this.G4 = paramContext.get(1);
    x();
  }
  
  public WheelDayPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = C4;
    this.E4 = paramContext.get(5);
    this.F4 = (paramContext.get(2) + 1);
    this.G4 = paramContext.get(1);
    x();
  }
  
  private void setMonth(int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 1), 12);
    this.F4 = paramInt;
    C4.set(2, paramInt - 1);
  }
  
  private void setYear(int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 1), 2147483646);
    this.G4 = paramInt;
    C4.set(1, paramInt);
  }
  
  private void x()
  {
    y();
    z();
  }
  
  private void y()
  {
    int i = C4.getActualMaximum(5);
    if (i == this.H4) {
      return;
    }
    this.H4 = i;
    Object localObject = B4;
    if (((HashMap)localObject).containsKey(Integer.valueOf(i)))
    {
      localObject = (List)((HashMap)localObject).get(Integer.valueOf(i));
    }
    else
    {
      localObject = new ArrayList();
      for (int j = 1; j <= i; j++) {
        ((List)localObject).add(String.valueOf(j));
      }
      B4.put(Integer.valueOf(i), localObject);
    }
    this.D4 = ((List)localObject);
    super.setData((List)localObject);
  }
  
  private void z()
  {
    setItemIndex(this.E4 - 1);
  }
  
  public void A(int paramInt1, int paramInt2)
  {
    setYear(paramInt1);
    setMonth(paramInt2);
    y();
    q();
  }
  
  public void setCurrentDay(int paramInt)
  {
    this.E4 = Math.min(Math.max(paramInt, 1), this.H4);
    z();
  }
  
  public void setCurrentMonth(int paramInt)
  {
    setMonth(paramInt);
    y();
  }
  
  public void setCurrentYear(int paramInt)
  {
    setYear(paramInt);
    y();
  }
  
  public void setData(List<String> paramList)
  {
    throw new RuntimeException("Set data will not allow here!");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\widget\curved\WheelDayPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */