package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.Calendar;
import java.util.TimeZone;

public abstract class MonthAdapter
  extends RecyclerView.Adapter<b>
  implements MonthView.a
{
  protected final a a;
  private a b;
  
  public MonthAdapter(a parama)
  {
    this.a = parama;
    n();
    r(parama.i());
    setHasStableIds(true);
  }
  
  public int getItemCount()
  {
    Calendar localCalendar1 = this.a.e();
    Calendar localCalendar2 = this.a.p();
    return localCalendar1.get(1) * 12 + localCalendar1.get(2) - (localCalendar2.get(1) * 12 + localCalendar2.get(2)) + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void k(MonthView paramMonthView, a parama)
  {
    if (parama != null) {
      q(parama);
    }
  }
  
  public abstract MonthView m(Context paramContext);
  
  protected void n()
  {
    this.b = new a(System.currentTimeMillis(), this.a.m());
  }
  
  public void o(b paramb, int paramInt)
  {
    paramb.c(paramInt, this.a, this.b);
  }
  
  public b p(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = m(paramViewGroup.getContext());
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    paramViewGroup.setClickable(true);
    paramViewGroup.setOnDayClickListener(this);
    return new b(paramViewGroup);
  }
  
  protected void q(a parama)
  {
    this.a.a();
    this.a.l(parama.b, parama.c, parama.d);
    r(parama);
  }
  
  public void r(a parama)
  {
    this.b = parama;
    notifyDataSetChanged();
  }
  
  public static class a
  {
    private Calendar a;
    int b;
    int c;
    int d;
    TimeZone e;
    
    public a(int paramInt1, int paramInt2, int paramInt3, TimeZone paramTimeZone)
    {
      this.e = paramTimeZone;
      b(paramInt1, paramInt2, paramInt3);
    }
    
    public a(long paramLong, TimeZone paramTimeZone)
    {
      this.e = paramTimeZone;
      c(paramLong);
    }
    
    public a(TimeZone paramTimeZone)
    {
      this.e = paramTimeZone;
      c(System.currentTimeMillis());
    }
    
    private void c(long paramLong)
    {
      if (this.a == null) {
        this.a = Calendar.getInstance(this.e);
      }
      this.a.setTimeInMillis(paramLong);
      this.c = this.a.get(2);
      this.b = this.a.get(1);
      this.d = this.a.get(5);
    }
    
    public void a(a parama)
    {
      this.b = parama.b;
      this.c = parama.c;
      this.d = parama.d;
    }
    
    public void b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
    }
  }
  
  static class b
    extends RecyclerView.ViewHolder
  {
    public b(MonthView paramMonthView)
    {
      super();
    }
    
    private boolean d(MonthAdapter.a parama, int paramInt1, int paramInt2)
    {
      boolean bool;
      if ((parama.b == paramInt1) && (parama.c == paramInt2)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void c(int paramInt, a parama, MonthAdapter.a parama1)
    {
      int i = (parama.p().get(2) + paramInt) % 12;
      int j = (paramInt + parama.p().get(2)) / 12 + parama.o();
      if (d(parama1, j, i)) {
        paramInt = parama1.d;
      } else {
        paramInt = -1;
      }
      ((MonthView)this.itemView).q(paramInt, j, i, parama.j());
      this.itemView.invalidate();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\MonthAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */