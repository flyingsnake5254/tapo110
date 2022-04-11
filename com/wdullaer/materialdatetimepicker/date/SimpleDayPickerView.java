package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.util.AttributeSet;

public class SimpleDayPickerView
  extends DayPickerView
{
  public SimpleDayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MonthAdapter a(a parama)
  {
    return new SimpleMonthAdapter(parama);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\SimpleDayPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */