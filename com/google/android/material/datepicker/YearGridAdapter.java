package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

class YearGridAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  private final MaterialCalendar<?> materialCalendar;
  
  YearGridAdapter(MaterialCalendar<?> paramMaterialCalendar)
  {
    this.materialCalendar = paramMaterialCalendar;
  }
  
  @NonNull
  private View.OnClickListener createYearClickListener(final int paramInt)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = Month.create(paramInt, YearGridAdapter.this.materialCalendar.getCurrentMonth().month);
        paramAnonymousView = YearGridAdapter.this.materialCalendar.getCalendarConstraints().clamp(paramAnonymousView);
        YearGridAdapter.this.materialCalendar.setCurrentMonth(paramAnonymousView);
        YearGridAdapter.this.materialCalendar.setSelector(MaterialCalendar.CalendarSelector.DAY);
      }
    };
  }
  
  public int getItemCount()
  {
    return this.materialCalendar.getCalendarConstraints().getYearSpan();
  }
  
  int getPositionForYear(int paramInt)
  {
    return paramInt - this.materialCalendar.getCalendarConstraints().getStart().year;
  }
  
  int getYearForPosition(int paramInt)
  {
    return this.materialCalendar.getCalendarConstraints().getStart().year + paramInt;
  }
  
  public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
  {
    paramInt = getYearForPosition(paramInt);
    Object localObject = paramViewHolder.textView.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
    paramViewHolder.textView.setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(paramInt) }));
    paramViewHolder.textView.setContentDescription(String.format((String)localObject, new Object[] { Integer.valueOf(paramInt) }));
    CalendarStyle localCalendarStyle = this.materialCalendar.getCalendarStyle();
    Calendar localCalendar = UtcDates.getTodayCalendar();
    if (localCalendar.get(1) == paramInt) {
      localObject = localCalendarStyle.todayYear;
    } else {
      localObject = localCalendarStyle.year;
    }
    Iterator localIterator = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
    while (localIterator.hasNext())
    {
      localCalendar.setTimeInMillis(((Long)localIterator.next()).longValue());
      if (localCalendar.get(1) == paramInt) {
        localObject = localCalendarStyle.selectedYear;
      }
    }
    ((CalendarItemStyle)localObject).styleItem(paramViewHolder.textView);
    paramViewHolder.textView.setOnClickListener(createYearClickListener(paramInt));
  }
  
  @NonNull
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new ViewHolder((TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, paramViewGroup, false));
  }
  
  public static class ViewHolder
    extends RecyclerView.ViewHolder
  {
    final TextView textView;
    
    ViewHolder(TextView paramTextView)
    {
      super();
      this.textView = paramTextView;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\YearGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */