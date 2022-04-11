package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.layout;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

class MonthAdapter
  extends BaseAdapter
{
  static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
  final CalendarConstraints calendarConstraints;
  CalendarStyle calendarStyle;
  final DateSelector<?> dateSelector;
  final Month month;
  
  MonthAdapter(Month paramMonth, DateSelector<?> paramDateSelector, CalendarConstraints paramCalendarConstraints)
  {
    this.month = paramMonth;
    this.dateSelector = paramDateSelector;
    this.calendarConstraints = paramCalendarConstraints;
  }
  
  private void initializeStyles(Context paramContext)
  {
    if (this.calendarStyle == null) {
      this.calendarStyle = new CalendarStyle(paramContext);
    }
  }
  
  int dayToPosition(int paramInt)
  {
    return firstPositionInMonth() + (paramInt - 1);
  }
  
  int firstPositionInMonth()
  {
    return this.month.daysFromStartOfWeekToFirstOfMonth();
  }
  
  public int getCount()
  {
    return this.month.daysInMonth + firstPositionInMonth();
  }
  
  @Nullable
  public Long getItem(int paramInt)
  {
    if ((paramInt >= this.month.daysFromStartOfWeekToFirstOfMonth()) && (paramInt <= lastPositionInMonth())) {
      return Long.valueOf(this.month.getDay(positionToDay(paramInt)));
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt / this.month.daysInWeek;
  }
  
  @NonNull
  public TextView getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    initializeStyles(paramViewGroup.getContext());
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, paramViewGroup, false);
    }
    int i = paramInt - firstPositionInMonth();
    long l;
    if (i >= 0)
    {
      paramView = this.month;
      if (i < paramView.daysInMonth)
      {
        i++;
        localTextView.setTag(paramView);
        localTextView.setText(String.valueOf(i));
        l = this.month.getDay(i);
        if (this.month.year == Month.current().year) {
          localTextView.setContentDescription(DateStrings.getMonthDayOfWeekDay(l));
        } else {
          localTextView.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(l));
        }
        localTextView.setVisibility(0);
        localTextView.setEnabled(true);
        break label165;
      }
    }
    localTextView.setVisibility(8);
    localTextView.setEnabled(false);
    label165:
    paramViewGroup = getItem(paramInt);
    if (paramViewGroup == null) {
      return localTextView;
    }
    if (this.calendarConstraints.getDateValidator().isValid(paramViewGroup.longValue()))
    {
      localTextView.setEnabled(true);
      paramView = this.dateSelector.getSelectedDays().iterator();
      while (paramView.hasNext())
      {
        l = ((Long)paramView.next()).longValue();
        if (UtcDates.canonicalYearMonthDay(paramViewGroup.longValue()) == UtcDates.canonicalYearMonthDay(l))
        {
          this.calendarStyle.selectedDay.styleItem(localTextView);
          return localTextView;
        }
      }
      if (UtcDates.getTodayCalendar().getTimeInMillis() == paramViewGroup.longValue())
      {
        this.calendarStyle.todayDay.styleItem(localTextView);
        return localTextView;
      }
      this.calendarStyle.day.styleItem(localTextView);
      return localTextView;
    }
    localTextView.setEnabled(false);
    this.calendarStyle.invalidDay.styleItem(localTextView);
    return localTextView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  boolean isFirstInRow(int paramInt)
  {
    boolean bool;
    if (paramInt % this.month.daysInWeek == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isLastInRow(int paramInt)
  {
    boolean bool = true;
    if ((paramInt + 1) % this.month.daysInWeek != 0) {
      bool = false;
    }
    return bool;
  }
  
  int lastPositionInMonth()
  {
    return this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth - 1;
  }
  
  int positionToDay(int paramInt)
  {
    return paramInt - this.month.daysFromStartOfWeekToFirstOfMonth() + 1;
  }
  
  boolean withinMonth(int paramInt)
  {
    boolean bool;
    if ((paramInt >= firstPositionInMonth()) && (paramInt <= lastPositionInMonth())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\MonthAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */