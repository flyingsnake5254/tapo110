package com.tplink.iot.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekdayView
  extends LinearLayout
{
  private static final int c = Color.parseColor("#999999");
  private static final int d = Color.parseColor("#4D999999");
  private int f;
  private List<TextView> q = new ArrayList();
  
  public WeekdayView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WeekdayView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WeekdayView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    int i = 0;
    setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = 16;
    List localList = Arrays.asList(new Integer[] { Integer.valueOf(2131954456), Integer.valueOf(2131954454), Integer.valueOf(2131954458), Integer.valueOf(2131954459), Integer.valueOf(2131954457), Integer.valueOf(2131954453), Integer.valueOf(2131954455) });
    while (i < localList.size())
    {
      TextView localTextView = new TextView(paramContext);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setText(((Integer)localList.get(i)).intValue());
      localTextView.setTextColor(d);
      if (i == 0) {
        addView(localTextView);
      } else {
        addView(localTextView, localLayoutParams);
      }
      this.q.add(localTextView);
      i++;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.q.get(paramInt);
    if (paramBoolean) {
      paramInt = c;
    } else {
      paramInt = d;
    }
    localTextView.setTextColor(paramInt);
  }
  
  public int getWeekdayTime()
  {
    return this.f;
  }
  
  public void setWeekdayTime(int paramInt)
  {
    this.f = paramInt;
    for (int i = 0; i < 7; i++)
    {
      boolean bool = true;
      if ((1 << i & paramInt) <= 0) {
        bool = false;
      }
      b(i, bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\WeekdayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */