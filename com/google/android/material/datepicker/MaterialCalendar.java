package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.SnapHelper;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.integer;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S>
  extends PickerFragment<S>
{
  private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
  private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
  private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
  @VisibleForTesting
  static final Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
  @VisibleForTesting
  static final Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
  @VisibleForTesting
  static final Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
  @VisibleForTesting
  static final Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
  private static final int SMOOTH_SCROLL_MAX = 3;
  private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
  @Nullable
  private CalendarConstraints calendarConstraints;
  private CalendarSelector calendarSelector;
  private CalendarStyle calendarStyle;
  @Nullable
  private Month current;
  @Nullable
  private DateSelector<S> dateSelector;
  private View dayFrame;
  private RecyclerView recyclerView;
  private int themeResId;
  private View yearFrame;
  private RecyclerView yearSelector;
  
  private void addActionsToMonthNavigation(@NonNull View paramView, @NonNull final MonthsPagerAdapter paramMonthsPagerAdapter)
  {
    final MaterialButton localMaterialButton1 = (MaterialButton)paramView.findViewById(R.id.month_navigation_fragment_toggle);
    localMaterialButton1.setTag(SELECTOR_TOGGLE_TAG);
    ViewCompat.setAccessibilityDelegate(localMaterialButton1, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, @NonNull AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        if (MaterialCalendar.this.dayFrame.getVisibility() == 0) {
          paramAnonymousView = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_year_selection);
        } else {
          paramAnonymousView = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_day_selection);
        }
        paramAnonymousAccessibilityNodeInfoCompat.setHintText(paramAnonymousView);
      }
    });
    MaterialButton localMaterialButton2 = (MaterialButton)paramView.findViewById(R.id.month_navigation_previous);
    localMaterialButton2.setTag(NAVIGATION_PREV_TAG);
    MaterialButton localMaterialButton3 = (MaterialButton)paramView.findViewById(R.id.month_navigation_next);
    localMaterialButton3.setTag(NAVIGATION_NEXT_TAG);
    this.yearFrame = paramView.findViewById(R.id.mtrl_calendar_year_selector_frame);
    this.dayFrame = paramView.findViewById(R.id.mtrl_calendar_day_selector_frame);
    setSelector(CalendarSelector.DAY);
    localMaterialButton1.setText(this.current.getLongName());
    this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
    {
      public void onScrollStateChanged(@NonNull RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          CharSequence localCharSequence = localMaterialButton1.getText();
          if (Build.VERSION.SDK_INT >= 16) {
            paramAnonymousRecyclerView.announceForAccessibility(localCharSequence);
          } else {
            paramAnonymousRecyclerView.sendAccessibilityEvent(2048);
          }
        }
      }
      
      public void onScrolled(@NonNull RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt1 < 0) {
          paramAnonymousInt1 = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition();
        } else {
          paramAnonymousInt1 = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
        }
        MaterialCalendar.access$602(MaterialCalendar.this, paramMonthsPagerAdapter.getPageMonth(paramAnonymousInt1));
        localMaterialButton1.setText(paramMonthsPagerAdapter.getPageTitle(paramAnonymousInt1));
      }
    });
    localMaterialButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MaterialCalendar.this.toggleVisibleSelector();
      }
    });
    localMaterialButton3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
        if (i < MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
          MaterialCalendar.this.setCurrentMonth(paramMonthsPagerAdapter.getPageMonth(i));
        }
      }
    });
    localMaterialButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
        if (i >= 0) {
          MaterialCalendar.this.setCurrentMonth(paramMonthsPagerAdapter.getPageMonth(i));
        }
      }
    });
  }
  
  @NonNull
  private RecyclerView.ItemDecoration createItemDecoration()
  {
    new RecyclerView.ItemDecoration()
    {
      private final Calendar endItem = UtcDates.getUtcCalendar();
      private final Calendar startItem = UtcDates.getUtcCalendar();
      
      public void onDraw(@NonNull Canvas paramAnonymousCanvas, @NonNull RecyclerView paramAnonymousRecyclerView, @NonNull RecyclerView.State paramAnonymousState)
      {
        if (((paramAnonymousRecyclerView.getAdapter() instanceof YearGridAdapter)) && ((paramAnonymousRecyclerView.getLayoutManager() instanceof GridLayoutManager)))
        {
          YearGridAdapter localYearGridAdapter = (YearGridAdapter)paramAnonymousRecyclerView.getAdapter();
          GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          paramAnonymousState = MaterialCalendar.this.dateSelector.getSelectedRanges().iterator();
          while (paramAnonymousState.hasNext())
          {
            Object localObject1 = (Pair)paramAnonymousState.next();
            Object localObject2 = ((Pair)localObject1).first;
            if ((localObject2 != null) && (((Pair)localObject1).second != null))
            {
              this.startItem.setTimeInMillis(((Long)localObject2).longValue());
              this.endItem.setTimeInMillis(((Long)((Pair)localObject1).second).longValue());
              int i = localYearGridAdapter.getPositionForYear(this.startItem.get(1));
              int j = localYearGridAdapter.getPositionForYear(this.endItem.get(1));
              View localView = localGridLayoutManager.findViewByPosition(i);
              localObject2 = localGridLayoutManager.findViewByPosition(j);
              int k = i / localGridLayoutManager.getSpanCount();
              int m = j / localGridLayoutManager.getSpanCount();
              for (j = k; j <= m; j++)
              {
                localObject1 = localGridLayoutManager.findViewByPosition(localGridLayoutManager.getSpanCount() * j);
                if (localObject1 != null)
                {
                  int n = ((View)localObject1).getTop();
                  int i1 = MaterialCalendar.this.calendarStyle.year.getTopInset();
                  int i2 = ((View)localObject1).getBottom();
                  int i3 = MaterialCalendar.this.calendarStyle.year.getBottomInset();
                  if (j == k) {
                    i = localView.getLeft() + localView.getWidth() / 2;
                  } else {
                    i = 0;
                  }
                  int i4;
                  if (j == m) {
                    i4 = ((View)localObject2).getLeft() + ((View)localObject2).getWidth() / 2;
                  } else {
                    i4 = paramAnonymousRecyclerView.getWidth();
                  }
                  paramAnonymousCanvas.drawRect(i, n + i1, i4, i2 - i3, MaterialCalendar.this.calendarStyle.rangeFill);
                }
              }
            }
          }
        }
      }
    };
  }
  
  @Px
  static int getDayHeight(@NonNull Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
  }
  
  @NonNull
  static <T> MaterialCalendar<T> newInstance(DateSelector<T> paramDateSelector, int paramInt, @NonNull CalendarConstraints paramCalendarConstraints)
  {
    MaterialCalendar localMaterialCalendar = new MaterialCalendar();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("GRID_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localBundle.putParcelable("CURRENT_MONTH_KEY", paramCalendarConstraints.getOpenAt());
    localMaterialCalendar.setArguments(localBundle);
    return localMaterialCalendar;
  }
  
  private void postSmoothRecyclerViewScroll(final int paramInt)
  {
    this.recyclerView.post(new Runnable()
    {
      public void run()
      {
        MaterialCalendar.this.recyclerView.smoothScrollToPosition(paramInt);
      }
    });
  }
  
  @Nullable
  CalendarConstraints getCalendarConstraints()
  {
    return this.calendarConstraints;
  }
  
  CalendarStyle getCalendarStyle()
  {
    return this.calendarStyle;
  }
  
  @Nullable
  Month getCurrentMonth()
  {
    return this.current;
  }
  
  @Nullable
  public DateSelector<S> getDateSelector()
  {
    return this.dateSelector;
  }
  
  @NonNull
  LinearLayoutManager getLayoutManager()
  {
    return (LinearLayoutManager)this.recyclerView.getLayoutManager();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.themeResId = localBundle.getInt("THEME_RES_ID_KEY");
    this.dateSelector = ((DateSelector)localBundle.getParcelable("GRID_SELECTOR_KEY"));
    this.calendarConstraints = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.current = ((Month)localBundle.getParcelable("CURRENT_MONTH_KEY"));
  }
  
  @NonNull
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = new ContextThemeWrapper(getContext(), this.themeResId);
    this.calendarStyle = new CalendarStyle(paramBundle);
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramBundle);
    Object localObject = this.calendarConstraints.getStart();
    int i;
    if (MaterialDatePicker.isFullscreen(paramBundle))
    {
      i = R.layout.mtrl_calendar_vertical;
      j = 1;
    }
    else
    {
      i = R.layout.mtrl_calendar_horizontal;
      j = 0;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup, false);
    paramViewGroup = (GridView)paramLayoutInflater.findViewById(R.id.mtrl_calendar_days_of_week);
    ViewCompat.setAccessibilityDelegate(paramViewGroup, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, @NonNull AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        paramAnonymousAccessibilityNodeInfoCompat.setCollectionInfo(null);
      }
    });
    paramViewGroup.setAdapter(new DaysOfWeekAdapter());
    paramViewGroup.setNumColumns(((Month)localObject).daysInWeek);
    paramViewGroup.setEnabled(false);
    this.recyclerView = ((RecyclerView)paramLayoutInflater.findViewById(R.id.mtrl_calendar_months));
    paramViewGroup = new SmoothCalendarLayoutManager(getContext(), j, false)
    {
      protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State paramAnonymousState, @NonNull int[] paramAnonymousArrayOfInt)
      {
        if (j == 0)
        {
          paramAnonymousArrayOfInt[0] = MaterialCalendar.this.recyclerView.getWidth();
          paramAnonymousArrayOfInt[1] = MaterialCalendar.this.recyclerView.getWidth();
        }
        else
        {
          paramAnonymousArrayOfInt[0] = MaterialCalendar.this.recyclerView.getHeight();
          paramAnonymousArrayOfInt[1] = MaterialCalendar.this.recyclerView.getHeight();
        }
      }
    };
    this.recyclerView.setLayoutManager(paramViewGroup);
    this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
    paramViewGroup = new MonthsPagerAdapter(paramBundle, this.dateSelector, this.calendarConstraints, new OnDayClickListener()
    {
      public void onDayClick(long paramAnonymousLong)
      {
        if (MaterialCalendar.this.calendarConstraints.getDateValidator().isValid(paramAnonymousLong))
        {
          MaterialCalendar.this.dateSelector.select(paramAnonymousLong);
          Iterator localIterator = MaterialCalendar.this.onSelectionChangedListeners.iterator();
          while (localIterator.hasNext()) {
            ((OnSelectionChangedListener)localIterator.next()).onSelectionChanged(MaterialCalendar.this.dateSelector.getSelection());
          }
          MaterialCalendar.this.recyclerView.getAdapter().notifyDataSetChanged();
          if (MaterialCalendar.this.yearSelector != null) {
            MaterialCalendar.this.yearSelector.getAdapter().notifyDataSetChanged();
          }
        }
      }
    });
    this.recyclerView.setAdapter(paramViewGroup);
    final int j = paramBundle.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
    localObject = (RecyclerView)paramLayoutInflater.findViewById(R.id.mtrl_calendar_year_selector_frame);
    this.yearSelector = ((RecyclerView)localObject);
    if (localObject != null)
    {
      ((RecyclerView)localObject).setHasFixedSize(true);
      this.yearSelector.setLayoutManager(new GridLayoutManager(paramBundle, j, 1, false));
      this.yearSelector.setAdapter(new YearGridAdapter(this));
      this.yearSelector.addItemDecoration(createItemDecoration());
    }
    if (paramLayoutInflater.findViewById(R.id.month_navigation_fragment_toggle) != null) {
      addActionsToMonthNavigation(paramLayoutInflater, paramViewGroup);
    }
    if (!MaterialDatePicker.isFullscreen(paramBundle)) {
      new LinearSnapHelper().attachToRecyclerView(this.recyclerView);
    }
    this.recyclerView.scrollToPosition(paramViewGroup.getPosition(this.current));
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.themeResId);
    paramBundle.putParcelable("GRID_SELECTOR_KEY", this.dateSelector);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
    paramBundle.putParcelable("CURRENT_MONTH_KEY", this.current);
  }
  
  void setCurrentMonth(Month paramMonth)
  {
    MonthsPagerAdapter localMonthsPagerAdapter = (MonthsPagerAdapter)this.recyclerView.getAdapter();
    int i = localMonthsPagerAdapter.getPosition(paramMonth);
    int j = i - localMonthsPagerAdapter.getPosition(this.current);
    int k = Math.abs(j);
    int m = 1;
    if (k > 3) {
      k = 1;
    } else {
      k = 0;
    }
    if (j <= 0) {
      m = 0;
    }
    this.current = paramMonth;
    if ((k != 0) && (m != 0))
    {
      this.recyclerView.scrollToPosition(i - 3);
      postSmoothRecyclerViewScroll(i);
    }
    else if (k != 0)
    {
      this.recyclerView.scrollToPosition(i + 3);
      postSmoothRecyclerViewScroll(i);
    }
    else
    {
      postSmoothRecyclerViewScroll(i);
    }
  }
  
  void setSelector(CalendarSelector paramCalendarSelector)
  {
    this.calendarSelector = paramCalendarSelector;
    if (paramCalendarSelector == CalendarSelector.YEAR)
    {
      this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter)this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
      this.yearFrame.setVisibility(0);
      this.dayFrame.setVisibility(8);
    }
    else if (paramCalendarSelector == CalendarSelector.DAY)
    {
      this.yearFrame.setVisibility(8);
      this.dayFrame.setVisibility(0);
      setCurrentMonth(this.current);
    }
  }
  
  void toggleVisibleSelector()
  {
    CalendarSelector localCalendarSelector1 = this.calendarSelector;
    CalendarSelector localCalendarSelector2 = CalendarSelector.YEAR;
    if (localCalendarSelector1 == localCalendarSelector2) {
      setSelector(CalendarSelector.DAY);
    } else if (localCalendarSelector1 == CalendarSelector.DAY) {
      setSelector(localCalendarSelector2);
    }
  }
  
  static enum CalendarSelector
  {
    static
    {
      CalendarSelector localCalendarSelector1 = new CalendarSelector("DAY", 0);
      DAY = localCalendarSelector1;
      CalendarSelector localCalendarSelector2 = new CalendarSelector("YEAR", 1);
      YEAR = localCalendarSelector2;
      $VALUES = new CalendarSelector[] { localCalendarSelector1, localCalendarSelector2 };
    }
  }
  
  static abstract interface OnDayClickListener
  {
    public abstract void onDayClick(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\MaterialCalendar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */