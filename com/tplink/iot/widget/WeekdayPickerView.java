package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.iot.b;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class WeekdayPickerView
  extends FrameLayout
  implements View.OnClickListener
{
  private int H3;
  private boolean I3 = false;
  private int c = 0;
  private int d = 0;
  private TextView f;
  private TextView p0;
  private TextView p1;
  private TextView p2;
  private a p3;
  private TextView q;
  private TextView x;
  private TextView y;
  private TextView z;
  
  public WeekdayPickerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public WeekdayPickerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e(paramContext, paramAttributeSet);
  }
  
  public WeekdayPickerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = 7 - paramInt2;
    int j = b(i);
    int k = b(i);
    int m = b(7);
    return (paramInt1 & k & b(7)) << paramInt2 | ((j ^ 0xFFFFFFFF) & paramInt1 & m) >> i % 7;
  }
  
  private int b(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j |= 1 << i;
      i++;
    }
    return j;
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    int i = b(paramInt2);
    int j = b(paramInt2);
    int k = b(7);
    return (paramInt1 & j & b(7)) << (7 - paramInt2) % 7 | ((i ^ 0xFFFFFFFF) & paramInt1 & k) >> paramInt2;
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.WeekdayPickerView);
    this.c = paramAttributeSet.getInt(1, 0);
    this.d = paramAttributeSet.getInt(0, 0);
    paramAttributeSet.recycle();
    if (this.c == 0) {
      LayoutInflater.from(paramContext).inflate(2131559192, this, true);
    } else {
      LayoutInflater.from(paramContext).inflate(2131559191, this, true);
    }
    f();
    g();
  }
  
  private void f()
  {
    this.f = ((TextView)findViewById(2131364719));
    this.q = ((TextView)findViewById(2131364720));
    this.x = ((TextView)findViewById(2131364721));
    this.y = ((TextView)findViewById(2131364722));
    this.z = ((TextView)findViewById(2131364723));
    this.p0 = ((TextView)findViewById(2131364724));
    this.p1 = ((TextView)findViewById(2131364725));
    this.f.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.p0.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.p2 = ((TextView)findViewById(2131364401));
  }
  
  private void g()
  {
    Object localObject = this.f;
    int i = 0;
    localObject = Arrays.asList(new TextView[] { localObject, this.q, this.x, this.y, this.z, this.p0, this.p1 });
    List localList = Arrays.asList(new Integer[] { Integer.valueOf(2131954456), Integer.valueOf(2131954454), Integer.valueOf(2131954458), Integer.valueOf(2131954459), Integer.valueOf(2131954457), Integer.valueOf(2131954453), Integer.valueOf(2131954455) });
    if ((((List)localObject).size() == 7) && (localList.size() == 7)) {
      while (i < 7)
      {
        int j = ((Integer)localList.get((this.d + i) % 7)).intValue();
        ((TextView)((List)localObject).get(i)).setText(j);
        i++;
      }
    }
  }
  
  private void h(int paramInt)
  {
    int i = this.H3;
    boolean bool = true;
    int j = 1 << paramInt;
    if ((i & j) > 0)
    {
      this.H3 = (i ^ j);
      bool = false;
    }
    else
    {
      this.H3 = (i | j);
    }
    j(paramInt, bool);
    n();
  }
  
  private void j(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      this.p1.setSelected(paramBoolean);
      break;
    case 5: 
      this.p0.setSelected(paramBoolean);
      break;
    case 4: 
      this.z.setSelected(paramBoolean);
      break;
    case 3: 
      this.y.setSelected(paramBoolean);
      break;
    case 2: 
      this.x.setSelected(paramBoolean);
      break;
    case 1: 
      this.q.setSelected(paramBoolean);
      break;
    case 0: 
      this.f.setSelected(paramBoolean);
    }
  }
  
  private void k(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      this.p1.setClickable(paramBoolean);
      break;
    case 5: 
      this.p0.setClickable(paramBoolean);
      break;
    case 4: 
      this.z.setClickable(paramBoolean);
      break;
    case 3: 
      this.y.setClickable(paramBoolean);
      break;
    case 2: 
      this.x.setClickable(paramBoolean);
      break;
    case 1: 
      this.q.setClickable(paramBoolean);
      break;
    case 0: 
      this.f.setClickable(paramBoolean);
    }
  }
  
  private void n()
  {
    if (!this.I3) {
      return;
    }
    int i = getWeekDay();
    if (i == 0)
    {
      this.p2.setText(2131953393);
    }
    else if (i == 127)
    {
      this.p2.setText(2131953728);
    }
    else if (i == 62)
    {
      this.p2.setText(2131953729);
    }
    else if (i == 65)
    {
      this.p2.setText(2131953730);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getContext().getString(2131953091));
      localStringBuilder.append(" ");
      String[] arrayOfString = DateFormatSymbols.getInstance(Locale.getDefault()).getWeekdays();
      int j = 1;
      int k = 1;
      int n;
      for (int m = 1; j < arrayOfString.length; m = n)
      {
        n = m;
        if ((i & k) == k) {
          if (m != 0)
          {
            n = 0;
            localStringBuilder.append(arrayOfString[j]);
          }
          else
          {
            localStringBuilder.append(", ");
            localStringBuilder.append(arrayOfString[j]);
            n = m;
          }
        }
        k <<= 1;
        j++;
      }
      this.p2.setText(localStringBuilder.toString());
    }
  }
  
  private void setWeekdayTime(int paramInt)
  {
    for (int i = 0; i < 7; i++)
    {
      boolean bool = true;
      if ((1 << i & paramInt) <= 0) {
        bool = false;
      }
      j(i, bool);
    }
    this.H3 = paramInt;
    n();
  }
  
  public int d(int paramInt)
  {
    int i = this.d;
    if (paramInt - i > 0) {
      return c(this.H3, paramInt - i);
    }
    if (paramInt - i < 0) {
      return a(this.H3, i - paramInt);
    }
    return this.H3;
  }
  
  public int getWeekDay()
  {
    return d(this.d);
  }
  
  public void i()
  {
    this.f.setClickable(false);
    this.q.setClickable(false);
    this.x.setClickable(false);
    this.y.setClickable(false);
    this.z.setClickable(false);
    this.p0.setClickable(false);
    this.p1.setClickable(false);
  }
  
  public void l(int paramInt, boolean paramBoolean)
  {
    for (int i = 0; i < 7; i++) {
      if ((1 << i & paramInt) > 0) {
        k(i, paramBoolean);
      }
    }
  }
  
  public void m(int paramInt1, int paramInt2)
  {
    int i = this.d;
    int j;
    if (paramInt2 - i > 0)
    {
      j = a(paramInt1, paramInt2 - i);
    }
    else
    {
      j = paramInt1;
      if (paramInt2 - i < 0) {
        j = c(paramInt1, i - paramInt2);
      }
    }
    setWeekdayTime(j);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364725: 
      h(6);
      paramView = this.p3;
      if (paramView != null) {
        paramView.a(6);
      }
      break;
    case 2131364724: 
      h(5);
      paramView = this.p3;
      if (paramView != null) {
        paramView.a(5);
      }
      break;
    case 2131364723: 
      h(4);
      paramView = this.p3;
      if (paramView != null) {
        paramView.a(4);
      }
      break;
    case 2131364722: 
      h(3);
      paramView = this.p3;
      if (paramView != null) {
        paramView.a(3);
      }
      break;
    case 2131364721: 
      h(2);
      paramView = this.p3;
      if (paramView != null) {
        paramView.a(2);
      }
      break;
    case 2131364720: 
      h(1);
      paramView = this.p3;
      if (paramView != null) {
        paramView.a(1);
      }
      break;
    case 2131364719: 
      h(0);
      paramView = this.p3;
      if (paramView != null) {
        paramView.a(0);
      }
      break;
    }
  }
  
  public void setDescriptionVisibility(boolean paramBoolean)
  {
    this.I3 = paramBoolean;
    TextView localTextView = this.p2;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public void setOnWeekPickClick(a parama)
  {
    this.p3 = parama;
  }
  
  public void setWeekDay(int paramInt)
  {
    m(paramInt, this.d);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\WeekdayPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */