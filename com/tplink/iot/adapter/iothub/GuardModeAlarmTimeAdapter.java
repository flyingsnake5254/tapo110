package com.tplink.iot.adapter.iothub;

import android.content.Context;
import android.widget.TextView;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.v.d;

public final class GuardModeAlarmTimeAdapter
  extends SingleCheckMarkAdapter<a>
{
  private static final List<Integer> g;
  private static final List<Integer> h;
  private static final Integer[] i;
  private static final List<a> j;
  public static final b k = new b(null);
  
  static
  {
    int m = 0;
    g = kotlin.collections.l.S(new d(0, 9));
    h = kotlin.collections.l.S(kotlin.v.e.h(new d(0, 55), 5));
    Integer[] arrayOfInteger = new Integer[6];
    arrayOfInteger[0] = Integer.valueOf(5);
    arrayOfInteger[1] = Integer.valueOf(10);
    arrayOfInteger[2] = Integer.valueOf(30);
    arrayOfInteger[3] = Integer.valueOf(60);
    arrayOfInteger[4] = Integer.valueOf(300);
    arrayOfInteger[5] = Integer.valueOf(600);
    i = arrayOfInteger;
    Object localObject = new ArrayList(arrayOfInteger.length);
    int n = arrayOfInteger.length;
    while (m < n)
    {
      ((Collection)localObject).add(new a(arrayOfInteger[m].intValue(), EnumGuardModeAlarmTimeType.CUSTOM_TIME, AlarmTimeItemType.PRESET));
      m++;
    }
    localObject = kotlin.collections.l.U((Collection)localObject);
    ((List)localObject).add(new a(300, EnumGuardModeAlarmTimeType.CUSTOM_TIME, AlarmTimeItemType.CUSTOM));
    j = (List)localObject;
  }
  
  public GuardModeAlarmTimeAdapter(Context paramContext)
  {
    super(paramContext, j, 2);
  }
  
  public void C(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, a parama, int paramInt)
  {
    j.e(paramSingleCheckMarkViewHolder, "holder");
    j.e(parama, "data");
    if (parama.a() == AlarmTimeItemType.ALWAYS) {
      paramSingleCheckMarkViewHolder.d().setText(2131952744);
    } else if (parama.a() == AlarmTimeItemType.PRESET) {
      paramSingleCheckMarkViewHolder.d().setText(k.c(p(), parama.b()));
    } else {
      paramSingleCheckMarkViewHolder.d().setText(2131952399);
    }
  }
  
  public final void D(int paramInt, kotlin.jvm.b.l<? super Integer, p> paraml)
  {
    j.e(paraml, "customAction");
    if (kotlin.collections.e.j(i, Integer.valueOf(paramInt)))
    {
      Iterator localIterator = j.iterator();
      for (int m = 0; localIterator.hasNext(); m++)
      {
        paraml = (a)localIterator.next();
        int n;
        if ((paraml.a() == AlarmTimeItemType.PRESET) && (paraml.b() == paramInt)) {
          n = 1;
        } else {
          n = 0;
        }
        if (n != 0) {
          break label94;
        }
      }
      m = -1;
      label94:
      z(m);
    }
    else
    {
      z(kotlin.collections.l.f(j));
      paraml.invoke(Integer.valueOf(paramInt));
    }
  }
  
  public static enum AlarmTimeItemType
  {
    static
    {
      AlarmTimeItemType localAlarmTimeItemType1 = new AlarmTimeItemType("ALWAYS", 0);
      ALWAYS = localAlarmTimeItemType1;
      AlarmTimeItemType localAlarmTimeItemType2 = new AlarmTimeItemType("PRESET", 1);
      PRESET = localAlarmTimeItemType2;
      AlarmTimeItemType localAlarmTimeItemType3 = new AlarmTimeItemType("CUSTOM", 2);
      CUSTOM = localAlarmTimeItemType3;
      $VALUES = new AlarmTimeItemType[] { localAlarmTimeItemType1, localAlarmTimeItemType2, localAlarmTimeItemType3 };
    }
  }
  
  public static final class a
  {
    private final int a;
    private final EnumGuardModeAlarmTimeType b;
    private final GuardModeAlarmTimeAdapter.AlarmTimeItemType c;
    
    public a(int paramInt, EnumGuardModeAlarmTimeType paramEnumGuardModeAlarmTimeType, GuardModeAlarmTimeAdapter.AlarmTimeItemType paramAlarmTimeItemType)
    {
      this.a = paramInt;
      this.b = paramEnumGuardModeAlarmTimeType;
      this.c = paramAlarmTimeItemType;
    }
    
    public final GuardModeAlarmTimeAdapter.AlarmTimeItemType a()
    {
      return this.c;
    }
    
    public final int b()
    {
      return this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.a == ((a)paramObject).a) && (j.a(this.b, ((a)paramObject).b)) && (j.a(this.c, ((a)paramObject).c))) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      int i = this.a;
      Object localObject = this.b;
      int j = 0;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.c;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return (i * 31 + k) * 31 + j;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlarmTime(time=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", itemType=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
  {
    public final List<Integer> a()
    {
      return GuardModeAlarmTimeAdapter.A();
    }
    
    public final List<Integer> b()
    {
      return GuardModeAlarmTimeAdapter.B();
    }
    
    public final String c(Context paramContext, int paramInt)
    {
      j.e(paramContext, "context");
      int i = paramInt / 60;
      paramInt %= 60;
      if (i == 0)
      {
        paramContext = paramContext.getString(2131954292, new Object[] { Integer.valueOf(paramInt) });
        j.d(paramContext, "context.getString(R.string.time_second_abbr, sec)");
      }
      else if (paramInt == 0)
      {
        paramContext = paramContext.getString(2131954289, new Object[] { Integer.valueOf(i) });
        j.d(paramContext, "context.getString(R.string.time_minute_abbr, min)");
      }
      else
      {
        paramContext = paramContext.getString(2131954287, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
        j.d(paramContext, "context.getString(R.string.time_min_sec, min, sec)");
      }
      return paramContext;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iothub\GuardModeAlarmTimeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */