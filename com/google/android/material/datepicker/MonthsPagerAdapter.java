package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;

class MonthsPagerAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  @NonNull
  private final CalendarConstraints calendarConstraints;
  private final DateSelector<?> dateSelector;
  private final int itemHeight;
  private final MaterialCalendar.OnDayClickListener onDayClickListener;
  
  MonthsPagerAdapter(@NonNull Context paramContext, DateSelector<?> paramDateSelector, @NonNull CalendarConstraints paramCalendarConstraints, MaterialCalendar.OnDayClickListener paramOnDayClickListener)
  {
    Month localMonth1 = paramCalendarConstraints.getStart();
    Month localMonth2 = paramCalendarConstraints.getEnd();
    Month localMonth3 = paramCalendarConstraints.getOpenAt();
    if (localMonth1.compareTo(localMonth3) <= 0)
    {
      if (localMonth3.compareTo(localMonth2) <= 0)
      {
        int i = MonthAdapter.MAXIMUM_WEEKS;
        int j = MaterialCalendar.getDayHeight(paramContext);
        int k;
        if (MaterialDatePicker.isFullscreen(paramContext)) {
          k = MaterialCalendar.getDayHeight(paramContext);
        } else {
          k = 0;
        }
        this.itemHeight = (i * j + k);
        this.calendarConstraints = paramCalendarConstraints;
        this.dateSelector = paramDateSelector;
        this.onDayClickListener = paramOnDayClickListener;
        setHasStableIds(true);
        return;
      }
      throw new IllegalArgumentException("currentPage cannot be after lastPage");
    }
    throw new IllegalArgumentException("firstPage cannot be after currentPage");
  }
  
  public int getItemCount()
  {
    return this.calendarConstraints.getMonthSpan();
  }
  
  public long getItemId(int paramInt)
  {
    return this.calendarConstraints.getStart().monthsLater(paramInt).getStableId();
  }
  
  @NonNull
  Month getPageMonth(int paramInt)
  {
    return this.calendarConstraints.getStart().monthsLater(paramInt);
  }
  
  @NonNull
  CharSequence getPageTitle(int paramInt)
  {
    return getPageMonth(paramInt).getLongName();
  }
  
  int getPosition(@NonNull Month paramMonth)
  {
    return this.calendarConstraints.getStart().monthsUntil(paramMonth);
  }
  
  public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
  {
    Month localMonth = this.calendarConstraints.getStart().monthsLater(paramInt);
    paramViewHolder.monthTitle.setText(localMonth.getLongName());
    final MaterialCalendarGridView localMaterialCalendarGridView = (MaterialCalendarGridView)paramViewHolder.monthGrid.findViewById(R.id.month_grid);
    if ((localMaterialCalendarGridView.getAdapter() != null) && (localMonth.equals(localMaterialCalendarGridView.getAdapter().month)))
    {
      localMaterialCalendarGridView.getAdapter().notifyDataSetChanged();
    }
    else
    {
      paramViewHolder = new MonthAdapter(localMonth, this.dateSelector, this.calendarConstraints);
      localMaterialCalendarGridView.setNumColumns(localMonth.daysInWeek);
      localMaterialCalendarGridView.setAdapter(paramViewHolder);
    }
    localMaterialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (localMaterialCalendarGridView.getAdapter().withinMonth(paramAnonymousInt)) {
          MonthsPagerAdapter.this.onDayClickListener.onDayClick(localMaterialCalendarGridView.getAdapter().getItem(paramAnonymousInt).longValue());
        }
      }
    });
  }
  
  @NonNull
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, paramViewGroup, false);
    if (MaterialDatePicker.isFullscreen(paramViewGroup.getContext()))
    {
      localLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
      return new ViewHolder(localLinearLayout, true);
    }
    return new ViewHolder(localLinearLayout, false);
  }
  
  public static class ViewHolder
    extends RecyclerView.ViewHolder
  {
    final MaterialCalendarGridView monthGrid;
    final TextView monthTitle;
    
    ViewHolder(@NonNull LinearLayout paramLinearLayout, boolean paramBoolean)
    {
      super();
      TextView localTextView = (TextView)paramLinearLayout.findViewById(R.id.month_title);
      this.monthTitle = localTextView;
      ViewCompat.setAccessibilityHeading(localTextView, true);
      this.monthGrid = ((MaterialCalendarGridView)paramLinearLayout.findViewById(R.id.month_grid));
      if (!paramBoolean) {
        localTextView.setVisibility(8);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\MonthsPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */