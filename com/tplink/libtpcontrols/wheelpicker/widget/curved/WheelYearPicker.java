package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCurvedPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WheelYearPicker
  extends WheelCurvedPicker
{
  private static final List<String> B4 = new ArrayList();
  private List<String> C4 = B4;
  private int D4 = 1900;
  private int E4 = 2100;
  private int F4;
  
  static
  {
    for (int i = 1900; i <= 2100; i++) {
      B4.add(String.valueOf(i));
    }
  }
  
  public WheelYearPicker(Context paramContext)
  {
    super(paramContext);
    x();
  }
  
  public WheelYearPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    x();
  }
  
  private void x()
  {
    super.setData(this.C4);
    setCurrentYear(Calendar.getInstance().get(1));
  }
  
  public void setCurrentYear(int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, this.D4), this.E4);
    this.F4 = paramInt;
    setItemIndex(paramInt - this.D4);
  }
  
  public void setData(List<String> paramList)
  {
    throw new RuntimeException("Set data will not allow here!");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\widget\curved\WheelYearPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */