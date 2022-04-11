package com.wdullaer.materialdatetimepicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.wdullaer.materialdatetimepicker.GravitySnapHelper;
import com.wdullaer.materialdatetimepicker.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public abstract class DayPickerView
  extends RecyclerView
  implements b
{
  private static SimpleDateFormat c = new SimpleDateFormat("yyyy", Locale.getDefault());
  private a H3;
  private LinearLayoutManager I3;
  protected int d = 6;
  protected boolean f = false;
  protected MonthAdapter p0;
  protected MonthAdapter.a p1;
  protected int p2;
  protected int p3 = 0;
  protected int q = 7;
  protected Context x;
  protected Handler y;
  protected MonthAdapter.a z;
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e(paramContext);
  }
  
  private MonthAdapter.a b()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      Object localObject = getChildAt(j);
      if ((localObject instanceof MonthView))
      {
        MonthView localMonthView = (MonthView)localObject;
        localObject = localMonthView.getAccessibilityFocus();
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT == 17) {
            localMonthView.c();
          }
          return (MonthAdapter.a)localObject;
        }
      }
    }
    return null;
  }
  
  private static String c(MonthAdapter.a parama, Locale paramLocale)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(parama.b, parama.c, parama.d);
    parama = new StringBuilder();
    parama.append("");
    parama.append(localCalendar.getDisplayName(2, 2, paramLocale));
    paramLocale = parama.toString();
    parama = new StringBuilder();
    parama.append(paramLocale);
    parama.append(" ");
    paramLocale = parama.toString();
    parama = new StringBuilder();
    parama.append(paramLocale);
    parama.append(c.format(localCalendar.getTime()));
    return parama.toString();
  }
  
  private int getFirstVisiblePosition()
  {
    return getChildAdapterPosition(getChildAt(0));
  }
  
  private boolean i(MonthAdapter.a parama)
  {
    if (parama == null) {
      return false;
    }
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (((localView instanceof MonthView)) && (((MonthView)localView).o(parama))) {
        return true;
      }
    }
    return false;
  }
  
  public abstract MonthAdapter a(a parama);
  
  public boolean d(MonthAdapter.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2) {
      this.z.a(parama);
    }
    this.p1.a(parama);
    int i = this.H3.p().get(2);
    int j = (parama.b - this.H3.o()) * 12 + parama.c - i;
    int k;
    for (i = 0;; i = k)
    {
      k = i + 1;
      parama = getChildAt(i);
      if (parama != null)
      {
        i = parama.getTop();
        if (Log.isLoggable("MonthFragment", 3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("child at ");
          localStringBuilder.append(k - 1);
          localStringBuilder.append(" has top ");
          localStringBuilder.append(i);
          Log.d("MonthFragment", localStringBuilder.toString());
        }
        if (i < 0) {}
      }
      else
      {
        if (parama != null) {
          i = getChildAdapterPosition(parama);
        } else {
          i = 0;
        }
        if (paramBoolean2) {
          this.p0.r(this.z);
        }
        if (Log.isLoggable("MonthFragment", 3))
        {
          parama = new StringBuilder();
          parama.append("GoTo position ");
          parama.append(j);
          Log.d("MonthFragment", parama.toString());
        }
        if ((j == i) && (!paramBoolean3))
        {
          if (paramBoolean2) {
            setMonthDisplayed(this.z);
          }
        }
        else
        {
          setMonthDisplayed(this.p1);
          this.p3 = 1;
          if (paramBoolean1)
          {
            smoothScrollToPosition(j);
            return true;
          }
          g(j);
        }
        return false;
      }
    }
  }
  
  public void e(Context paramContext)
  {
    int i;
    if (this.H3.b() == DatePickerDialog.ScrollOrientation.VERTICAL) {
      i = 1;
    } else {
      i = 0;
    }
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, i, false);
    this.I3 = localLinearLayoutManager;
    setLayoutManager(localLinearLayoutManager);
    this.y = new Handler();
    setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.x = paramContext;
    j();
  }
  
  public void f()
  {
    d(this.H3.i(), false, true, true);
  }
  
  public void g(final int paramInt)
  {
    clearFocus();
    post(new a(paramInt));
  }
  
  public MonthView getMostVisibleMonth()
  {
    int i = ((LinearLayoutManager)getLayoutManager()).getOrientation();
    int j = 1;
    if (i != 1) {
      j = 0;
    }
    int k;
    if (j != 0) {
      k = getHeight();
    } else {
      k = getWidth();
    }
    MonthView localMonthView = null;
    i = 0;
    int m = 0;
    int i2;
    for (int n = 0; i < k; n = i2)
    {
      View localView = getChildAt(m);
      if (localView == null) {
        break;
      }
      if (j != 0) {
        i = localView.getBottom();
      } else {
        i = getRight();
      }
      int i1 = Math.min(i, k) - Math.max(0, localView.getTop());
      i2 = n;
      if (i1 > n)
      {
        localMonthView = (MonthView)localView;
        i2 = i1;
      }
      m++;
    }
    return localMonthView;
  }
  
  public int getMostVisiblePosition()
  {
    return getChildAdapterPosition(getMostVisibleMonth());
  }
  
  protected void h()
  {
    MonthAdapter localMonthAdapter = this.p0;
    if (localMonthAdapter == null) {
      this.p0 = a(this.H3);
    } else {
      localMonthAdapter.r(this.z);
    }
    setAdapter(this.p0);
  }
  
  protected void j()
  {
    setVerticalScrollBarEnabled(false);
    setFadingEdgeLength(0);
    int i;
    if (this.H3.b() == DatePickerDialog.ScrollOrientation.VERTICAL) {
      i = 48;
    } else {
      i = 8388611;
    }
    new GravitySnapHelper(i).attachToRecyclerView(this);
  }
  
  public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setItemCount(-1);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
      paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
    }
    else
    {
      paramAccessibilityNodeInfo.addAction(4096);
      paramAccessibilityNodeInfo.addAction(8192);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    i(b());
  }
  
  @SuppressLint({"NewApi"})
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if ((paramInt != 4096) && (paramInt != 8192)) {
      return super.performAccessibilityAction(paramInt, paramBundle);
    }
    int i = getFirstVisiblePosition() + this.H3.p().get(2);
    MonthAdapter.a locala = new MonthAdapter.a(i / 12 + this.H3.o(), i % 12, 1, this.H3.m());
    if (paramInt == 4096)
    {
      paramInt = locala.c + 1;
      locala.c = paramInt;
      if (paramInt == 12)
      {
        locala.c = 0;
        locala.b += 1;
      }
    }
    else if (paramInt == 8192)
    {
      paramBundle = getChildAt(0);
      if ((paramBundle != null) && (paramBundle.getTop() >= -1))
      {
        paramInt = locala.c - 1;
        locala.c = paramInt;
        if (paramInt == -1)
        {
          locala.c = 11;
          locala.b -= 1;
        }
      }
    }
    d.b(this, c(locala, this.H3.c()));
    d(locala, true, false, true);
    return true;
  }
  
  public void setController(a parama)
  {
    this.H3 = parama;
    parama.d(this);
    this.z = new MonthAdapter.a(this.H3.m());
    this.p1 = new MonthAdapter.a(this.H3.m());
    c = new SimpleDateFormat("yyyy", parama.c());
    h();
    f();
  }
  
  protected void setMonthDisplayed(MonthAdapter.a parama)
  {
    this.p2 = parama.c;
  }
  
  public void setScrollOrientation(int paramInt)
  {
    this.I3.setOrientation(paramInt);
  }
  
  class a
    implements Runnable
  {
    a(int paramInt) {}
    
    public void run()
    {
      ((LinearLayoutManager)DayPickerView.this.getLayoutManager()).scrollToPositionWithOffset(paramInt, 0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\DayPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */