package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCurvedPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WheelHourPicker
  extends WheelCurvedPicker
{
  private static final List<String> B4 = new ArrayList();
  private static final List<String> C4 = new ArrayList();
  private List<String> D4 = B4;
  private int E4;
  
  static
  {
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= 24) {
        break;
      }
      B4.add(String.valueOf(j));
    }
    while (k < 24)
    {
      String str = String.valueOf(k);
      Object localObject = str;
      if (str.length() == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      C4.add(localObject);
      k++;
    }
  }
  
  public WheelHourPicker(Context paramContext)
  {
    super(paramContext);
    x();
  }
  
  public WheelHourPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    x();
  }
  
  private void x()
  {
    super.setData(this.D4);
    setCurrentHour(Calendar.getInstance().get(11));
  }
  
  public void setCurrentHour(int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 0), 23);
    this.E4 = paramInt;
    setItemIndex(paramInt);
  }
  
  public void setData(List<String> paramList)
  {
    throw new RuntimeException("Set data will not allow here!");
  }
  
  public void setDigitType(int paramInt)
  {
    if (paramInt == 1) {
      this.D4 = B4;
    } else {
      this.D4 = C4;
    }
    super.setData(this.D4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\widget\curved\WheelHourPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */