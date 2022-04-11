package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import b.d.q.b.o;

public class ScheduleWeekView
  extends LinearLayout
{
  TextView[] c;
  int[] d = { 2131954456, 2131954454, 2131954458, 2131954459, 2131954457, 2131954453, 2131954455 };
  int f = 0;
  private b q;
  private boolean[] x;
  
  public ScheduleWeekView(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ScheduleWeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ScheduleWeekView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.f = (o.c(paramContext) / 8);
    setOrientation(0);
    this.c = new TextView[7];
    this.x = new boolean[7];
    for (int i = 0;; i++)
    {
      Object localObject = this.c;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = new TextView(paramContext);
      addView(this.c[i]);
      this.x[i] = true;
      localObject = (LinearLayout.LayoutParams)this.c[i].getLayoutParams();
      int j = this.f;
      ((LinearLayout.LayoutParams)localObject).width = (j / 8 * 7);
      ((LinearLayout.LayoutParams)localObject).height = (j / 8 * 7);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(j / 4, 0, 0, 0);
      }
      this.c[i].setGravity(17);
      this.c[i].setText(this.d[i]);
      this.c[i].setBackground(getResources().getDrawable(2131231009));
      this.c[i].setTextColor(getResources().getColor(2131100140));
      this.c[i].setTag(Integer.valueOf(i));
      this.c[i].setTextSize(2, 18.0F);
      this.c[i].setOnClickListener(new a());
    }
  }
  
  public boolean[] getChosenArray()
  {
    return this.x;
  }
  
  public void setInitial(boolean[] paramArrayOfBoolean)
  {
    if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean.length == 7))
    {
      this.x = paramArrayOfBoolean;
      for (int i = 0; i < 7; i++) {
        if (paramArrayOfBoolean[i] != 0)
        {
          this.c[i].setBackground(getResources().getDrawable(2131231009));
          this.c[i].setTextColor(getResources().getColor(2131100140));
        }
        else
        {
          this.c[i].setBackground(getResources().getDrawable(2131231014));
          this.c[i].setTextColor(getResources().getColor(2131099808));
        }
      }
    }
  }
  
  public void setListener(b paramb)
  {
    this.q = paramb;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      ScheduleWeekView.a(ScheduleWeekView.this)[i] ^= 0x1;
      if (ScheduleWeekView.a(ScheduleWeekView.this)[i] != 0)
      {
        paramView = ScheduleWeekView.this;
        paramView.c[i].setBackground(paramView.getResources().getDrawable(2131231009));
        paramView = ScheduleWeekView.this;
        paramView.c[i].setTextColor(paramView.getResources().getColor(2131100140));
      }
      else
      {
        paramView = ScheduleWeekView.this;
        paramView.c[i].setBackground(paramView.getResources().getDrawable(2131231014));
        paramView = ScheduleWeekView.this;
        paramView.c[i].setTextColor(paramView.getResources().getColor(2131099808));
      }
      if (ScheduleWeekView.b(ScheduleWeekView.this) != null) {
        ScheduleWeekView.b(ScheduleWeekView.this).a(i, ScheduleWeekView.a(ScheduleWeekView.this)[i]);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\ScheduleWeekView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */