package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import java.util.Calendar;
import java.util.Locale;

class DaysOfWeekAdapter
  extends BaseAdapter
{
  private static final int CALENDAR_DAY_STYLE;
  private static final int NARROW_FORMAT = 4;
  @NonNull
  private final Calendar calendar;
  private final int daysInWeek;
  private final int firstDayOfWeek;
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 4;
    } else {
      i = 1;
    }
    CALENDAR_DAY_STYLE = i;
  }
  
  public DaysOfWeekAdapter()
  {
    Calendar localCalendar = UtcDates.getUtcCalendar();
    this.calendar = localCalendar;
    this.daysInWeek = localCalendar.getMaximum(7);
    this.firstDayOfWeek = localCalendar.getFirstDayOfWeek();
  }
  
  private int positionToDayOfWeek(int paramInt)
  {
    int i = paramInt + this.firstDayOfWeek;
    int j = this.daysInWeek;
    paramInt = i;
    if (i > j) {
      paramInt = i - j;
    }
    return paramInt;
  }
  
  public int getCount()
  {
    return this.daysInWeek;
  }
  
  @Nullable
  public Integer getItem(int paramInt)
  {
    if (paramInt >= this.daysInWeek) {
      return null;
    }
    return Integer.valueOf(positionToDayOfWeek(paramInt));
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @SuppressLint({"WrongConstant"})
  @Nullable
  public View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, paramViewGroup, false);
    }
    this.calendar.set(7, positionToDayOfWeek(paramInt));
    localTextView.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, Locale.getDefault()));
    localTextView.setContentDescription(String.format(paramViewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), new Object[] { this.calendar.getDisplayName(7, 2, Locale.getDefault()) }));
    return localTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\DaysOfWeekAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */