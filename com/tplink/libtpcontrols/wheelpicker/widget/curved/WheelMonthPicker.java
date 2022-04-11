package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCurvedPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WheelMonthPicker
  extends WheelCurvedPicker
{
  private static final List<String> B4 = new ArrayList();
  private List<String> C4 = B4;
  private int D4;
  
  static
  {
    for (int i = 1; i <= 12; i++) {
      B4.add(String.valueOf(i));
    }
  }
  
  public WheelMonthPicker(Context paramContext)
  {
    super(paramContext);
    x();
  }
  
  public WheelMonthPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    x();
  }
  
  private void x()
  {
    super.setData(this.C4);
    setCurrentMonth(Calendar.getInstance().get(2) + 1);
  }
  
  public void setCurrentMonth(int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 1), 12);
    this.D4 = paramInt;
    setItemIndex(paramInt - 1);
  }
  
  public void setData(List<String> paramList)
  {
    throw new RuntimeException("Set data will not allow here!");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\widget\curved\WheelMonthPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */