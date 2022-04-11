package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R.id;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

final class MaterialCalendarGridView
  extends GridView
{
  private final Calendar dayCompute = UtcDates.getUtcCalendar();
  
  public MaterialCalendarGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (MaterialDatePicker.isFullscreen(getContext()))
    {
      setNextFocusLeftId(R.id.cancel_button);
      setNextFocusRightId(R.id.confirm_button);
    }
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, @NonNull AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        paramAnonymousAccessibilityNodeInfoCompat.setCollectionInfo(null);
      }
    });
  }
  
  private void gainFocus(int paramInt, Rect paramRect)
  {
    if (paramInt == 33) {
      setSelection(getAdapter().lastPositionInMonth());
    } else if (paramInt == 130) {
      setSelection(getAdapter().firstPositionInMonth());
    } else {
      super.onFocusChanged(true, paramInt, paramRect);
    }
  }
  
  private static int horizontalMidPoint(@NonNull View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private static boolean skipMonth(@Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Long paramLong4)
  {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramLong1 != null)
    {
      bool2 = bool1;
      if (paramLong2 != null)
      {
        bool2 = bool1;
        if (paramLong3 != null) {
          if (paramLong4 == null)
          {
            bool2 = bool1;
          }
          else
          {
            bool2 = bool1;
            if (paramLong3.longValue() <= paramLong2.longValue()) {
              if (paramLong4.longValue() < paramLong1.longValue()) {
                bool2 = bool1;
              } else {
                bool2 = false;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  @NonNull
  public MonthAdapter getAdapter()
  {
    return (MonthAdapter)super.getAdapter();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getAdapter().notifyDataSetChanged();
  }
  
  protected final void onDraw(@NonNull Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    MonthAdapter localMonthAdapter = getAdapter();
    Object localObject1 = localMonthAdapter.dateSelector;
    CalendarStyle localCalendarStyle = localMonthAdapter.calendarStyle;
    Long localLong1 = localMonthAdapter.getItem(localMonthAdapter.firstPositionInMonth());
    Long localLong2 = localMonthAdapter.getItem(localMonthAdapter.lastPositionInMonth());
    Iterator localIterator = ((DateSelector)localObject1).getSelectedRanges().iterator();
    for (;;)
    {
      localObject1 = this;
      if (!localIterator.hasNext()) {
        break;
      }
      Pair localPair = (Pair)localIterator.next();
      Object localObject2 = localPair.first;
      if (localObject2 != null) {
        if (localPair.second != null)
        {
          long l1 = ((Long)localObject2).longValue();
          long l2 = ((Long)localPair.second).longValue();
          if (skipMonth(localLong1, localLong2, Long.valueOf(l1), Long.valueOf(l2))) {
            return;
          }
          int i;
          int j;
          if (l1 < localLong1.longValue())
          {
            i = localMonthAdapter.firstPositionInMonth();
            if (localMonthAdapter.isFirstInRow(i)) {
              j = 0;
            } else {
              j = ((GridView)localObject1).getChildAt(i - 1).getRight();
            }
          }
          else
          {
            ((MaterialCalendarGridView)localObject1).dayCompute.setTimeInMillis(l1);
            i = localMonthAdapter.dayToPosition(((MaterialCalendarGridView)localObject1).dayCompute.get(5));
            j = horizontalMidPoint(((GridView)localObject1).getChildAt(i));
          }
          int k;
          int m;
          if (l2 > localLong2.longValue())
          {
            k = Math.min(localMonthAdapter.lastPositionInMonth(), getChildCount() - 1);
            if (localMonthAdapter.isLastInRow(k)) {
              m = getWidth();
            } else {
              m = ((GridView)localObject1).getChildAt(k).getRight();
            }
          }
          else
          {
            ((MaterialCalendarGridView)localObject1).dayCompute.setTimeInMillis(l2);
            k = localMonthAdapter.dayToPosition(((MaterialCalendarGridView)localObject1).dayCompute.get(5));
            m = horizontalMidPoint(((GridView)localObject1).getChildAt(k));
          }
          int n = (int)localMonthAdapter.getItemId(i);
          int i1 = (int)localMonthAdapter.getItemId(k);
          while (n <= i1)
          {
            int i2 = getNumColumns() * n;
            int i3 = getNumColumns();
            localObject1 = getChildAt(i2);
            int i4 = ((View)localObject1).getTop();
            int i5 = localCalendarStyle.day.getTopInset();
            int i6 = ((View)localObject1).getBottom();
            int i7 = localCalendarStyle.day.getBottomInset();
            int i8;
            if (i2 > i) {
              i8 = 0;
            } else {
              i8 = j;
            }
            if (k > i3 + i2 - 1) {
              i3 = getWidth();
            } else {
              i3 = m;
            }
            paramCanvas.drawRect(i8, i4 + i5, i3, i6 - i7, localCalendarStyle.rangeFill);
            n++;
          }
        }
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {
      gainFocus(paramInt, paramRect);
    } else {
      super.onFocusChanged(false, paramInt, paramRect);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!super.onKeyDown(paramInt, paramKeyEvent)) {
      return false;
    }
    if ((getSelectedItemPosition() != -1) && (getSelectedItemPosition() < getAdapter().firstPositionInMonth()))
    {
      if (19 == paramInt)
      {
        setSelection(getAdapter().firstPositionInMonth());
        return true;
      }
      return false;
    }
    return true;
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof MonthAdapter))
    {
      super.setAdapter(paramListAdapter);
      return;
    }
    throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[] { MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName() }));
  }
  
  public void setSelection(int paramInt)
  {
    if (paramInt < getAdapter().firstPositionInMonth()) {
      super.setSelection(getAdapter().firstPositionInMonth());
    } else {
      super.setSelection(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\MaterialCalendarGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */