package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;

public class SimpleMonthAdapter
  extends MonthAdapter
{
  public SimpleMonthAdapter(a parama)
  {
    super(parama);
  }
  
  public MonthView m(Context paramContext)
  {
    return new SimpleMonthView(paramContext, null, this.a);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\SimpleMonthAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */