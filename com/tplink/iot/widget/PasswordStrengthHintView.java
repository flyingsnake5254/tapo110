package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class PasswordStrengthHintView
  extends LinearLayout
{
  private final int c = -1;
  private final int d = 0;
  private final int f = 1;
  private TextView p0;
  private TextView p1;
  private View q;
  private View x;
  private View y;
  private TextView z;
  
  public PasswordStrengthHintView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PasswordStrengthHintView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PasswordStrengthHintView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559434, this, true);
    this.q = findViewById(2131363238);
    this.x = findViewById(2131363239);
    this.y = findViewById(2131363240);
    this.z = ((TextView)findViewById(2131364650));
    this.p0 = ((TextView)findViewById(2131364648));
    this.p1 = ((TextView)findViewById(2131364649));
  }
  
  private int a(int paramInt)
  {
    return getContext().getResources().getColor(paramInt);
  }
  
  private int b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1;
      while (i < paramString.length())
      {
        i1 = paramString.charAt(i);
        if ((48 <= i1) && (i1 <= 57)) {
          m++;
        } else if ((97 <= i1) && (i1 <= 122)) {
          j++;
        } else if ((65 <= i1) && (i1 <= 90)) {
          k++;
        } else {
          n++;
        }
        i++;
      }
      i = paramString.length();
      int i2 = 25;
      int i3 = 5;
      if (i <= 4) {
        i = 5;
      } else if (paramString.length() <= 7) {
        i = 10;
      } else {
        i = 25;
      }
      int i4 = j + k;
      int i5 = 20;
      if (i4 == 0) {
        i1 = 0;
      } else if ((j != 0) && (k != 0)) {
        i1 = 20;
      } else {
        i1 = 10;
      }
      if (m == 0) {
        i5 = 0;
      } else if (1 == m) {
        i5 = 10;
      }
      if (n == 0) {
        i2 = 0;
      } else if (1 == n) {
        i2 = 10;
      }
      if ((k != 0) && (j != 0) && (m != 0) && (n != 0)) {
        n = i3;
      } else if ((i4 != 0) && (m != 0) && (n != 0)) {
        n = 3;
      } else if ((i4 != 0) && (m != 0)) {
        n = 2;
      } else {
        n = 0;
      }
      n = i + i1 + i5 + i2 + n;
      if (n >= 80) {
        return 1;
      }
      if (n >= 50) {
        return 0;
      }
    }
    return -1;
  }
  
  public void setPasswordStrength(String paramString)
  {
    int i = b(paramString);
    if (i == 1)
    {
      this.q.setBackgroundColor(a(2131099803));
      this.x.setBackgroundColor(a(2131099803));
      this.y.setBackgroundColor(a(2131099803));
      this.z.setVisibility(8);
      this.p0.setVisibility(8);
      this.p1.setVisibility(0);
    }
    else if (i == 0)
    {
      this.q.setBackgroundColor(a(2131099810));
      this.x.setBackgroundColor(a(2131099810));
      this.y.setBackgroundColor(a(2131099801));
      this.z.setVisibility(8);
      this.p0.setVisibility(0);
      this.p1.setVisibility(8);
    }
    else
    {
      this.q.setBackgroundColor(a(2131099812));
      this.x.setBackgroundColor(a(2131099801));
      this.y.setBackgroundColor(a(2131099801));
      this.z.setVisibility(0);
      this.p0.setVisibility(8);
      this.p1.setVisibility(8);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\PasswordStrengthHintView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */