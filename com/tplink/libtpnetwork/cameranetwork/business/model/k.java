package com.tplink.libtpnetwork.cameranetwork.business.model;

import android.os.Build.VERSION;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.tplink.libtpnetwork.cameranetwork.util.d.b;
import java.time.Instant;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class k
{
  private final int a;
  private final long b;
  private boolean c;
  private boolean d;
  private int e;
  private TimeZone f;
  private String g;
  private final Map<String, Long> h = new HashMap();
  private final Map<String, Long> i = new HashMap();
  private final Map<String, Calendar> j = new HashMap();
  private final Map<String, Calendar> k = new HashMap();
  private final Calendar l = Calendar.getInstance();
  
  public k()
  {
    this.a = 0;
    this.b = 0L;
    this.c = false;
    this.d = false;
    this.e = 0;
  }
  
  public k(int paramInt, long paramLong)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = false;
    this.d = false;
    this.e = 0;
  }
  
  @RequiresApi(api=26)
  private long a(long paramLong, int paramInt)
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (((TimeZone)localObject1).useDaylightTime()))
    {
      localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).setTimeInMillis(paramLong);
      paramInt = ((Calendar)localObject1).get(1) + paramInt;
      localObject1 = (Long)this.i.get(String.valueOf(paramInt));
      if (localObject1 != null) {
        return ((Long)localObject1).longValue();
      }
      Object localObject2 = this.f.toZoneId().getRules();
      localObject1 = ((ZoneRules)localObject2).nextTransition(Instant.parse(String.format(Locale.US, "%d-01-01T00:00:00.00Z", new Object[] { Integer.valueOf(paramInt) })));
      localObject2 = ((ZoneRules)localObject2).nextTransition(((ZoneOffsetTransition)localObject1).getInstant());
      if (((ZoneOffsetTransition)localObject1).isGap()) {
        localObject1 = ((ZoneOffsetTransition)localObject2).getInstant();
      } else {
        localObject1 = ((ZoneOffsetTransition)localObject1).getInstant();
      }
      paramLong = ((Instant)localObject1).toEpochMilli();
      this.i.put(String.valueOf(paramInt), Long.valueOf(paramLong));
      return paramLong;
    }
    return 0L;
  }
  
  @RequiresApi(api=26)
  private long b(long paramLong, int paramInt)
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (((TimeZone)localObject1).useDaylightTime()))
    {
      localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).setTimeInMillis(paramLong);
      paramInt = ((Calendar)localObject1).get(1) + paramInt;
      localObject1 = (Long)this.h.get(String.valueOf(paramInt));
      if (localObject1 != null) {
        return ((Long)localObject1).longValue();
      }
      Object localObject2 = this.f.toZoneId().getRules();
      localObject1 = ((ZoneRules)localObject2).nextTransition(Instant.parse(String.format(Locale.US, "%d-01-01T00:00:00.00Z", new Object[] { Integer.valueOf(paramInt) })));
      localObject2 = ((ZoneRules)localObject2).nextTransition(((ZoneOffsetTransition)localObject1).getInstant());
      if (((ZoneOffsetTransition)localObject1).isGap()) {
        localObject1 = ((ZoneOffsetTransition)localObject1).getInstant();
      } else {
        localObject1 = ((ZoneOffsetTransition)localObject2).getInstant();
      }
      paramLong = ((Instant)localObject1).toEpochMilli();
      this.h.put(String.valueOf(paramInt), Long.valueOf(paramLong));
      return paramLong;
    }
    return 0L;
  }
  
  private TimeZone c()
  {
    String str = this.g;
    if ((str != null) && (str.startsWith("UTC"))) {
      return TimeZone.getTimeZone(this.g.replace("UTC", "GMT"));
    }
    return this.f;
  }
  
  private Calendar n(TimeZone paramTimeZone, long paramLong)
  {
    if ((paramTimeZone != null) && (paramLong > 0L))
    {
      this.l.setTimeZone(paramTimeZone);
      this.l.setTimeInMillis(paramLong);
      paramTimeZone = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      paramTimeZone.set(1, this.l.get(1));
      paramTimeZone.set(2, this.l.get(2));
      paramTimeZone.set(5, this.l.get(5));
      paramTimeZone.set(11, this.l.get(11));
      paramTimeZone.set(12, this.l.get(12));
      paramTimeZone.set(13, this.l.get(13));
      paramTimeZone.set(14, 0);
      return paramTimeZone;
    }
    return null;
  }
  
  private long s(long paramLong, int paramInt)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int m = ((Calendar)localObject).get(1);
    localObject = (Long)this.i.get(String.valueOf(m + paramInt));
    if (localObject != null) {
      paramLong = ((Long)localObject).longValue();
    } else {
      paramLong = 0L;
    }
    return paramLong;
  }
  
  private long t(long paramLong, int paramInt)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int m = ((Calendar)localObject).get(1);
    localObject = (Long)this.h.get(String.valueOf(m + paramInt));
    if (localObject != null) {
      paramLong = ((Long)localObject).longValue();
    } else {
      paramLong = 0L;
    }
    return paramLong;
  }
  
  @RequiresApi(api=26)
  public void d(String paramString1, String paramString2)
  {
    paramString1 = TimeZone.getTimeZone(paramString1);
    this.f = paramString1;
    this.g = paramString2;
    this.e = paramString1.getDSTSavings();
    this.c = this.f.useDaylightTime();
    if (this.f.useDaylightTime())
    {
      paramString1 = Calendar.getInstance();
      paramString1.setTimeInMillis(this.b);
      boolean bool1 = true;
      boolean bool2 = true;
      int m = paramString1.get(1);
      paramString1 = this.f.toZoneId().getRules();
      paramString2 = paramString1.nextTransition(Instant.parse(String.format(Locale.US, "%d-01-01T00:00:00.00Z", new Object[] { Integer.valueOf(m) })));
      ZoneOffsetTransition localZoneOffsetTransition = paramString1.nextTransition(paramString2.getInstant());
      if (paramString2.isGap()) {
        paramString1 = paramString2.getInstant();
      } else {
        paramString1 = localZoneOffsetTransition.getInstant();
      }
      long l1 = paramString1.toEpochMilli();
      if (paramString2.isGap()) {
        paramString1 = localZoneOffsetTransition.getInstant();
      } else {
        paramString1 = paramString2.getInstant();
      }
      long l2 = paramString1.toEpochMilli();
      long l3;
      if (paramString2.isGap())
      {
        l3 = this.b;
        if ((l3 < l1) || (l3 >= l2)) {
          bool2 = false;
        }
        this.d = bool2;
      }
      else
      {
        l3 = this.b;
        bool2 = bool1;
        if (l3 < l1) {
          if (l3 < l2) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
        this.d = bool2;
      }
    }
  }
  
  public void e(String paramString1, String paramString2, Map<String, d.b> paramMap)
  {
    paramString1 = TimeZone.getTimeZone(paramString1);
    this.f = paramString1;
    this.g = paramString2;
    this.e = paramString1.getDSTSavings();
    this.c = this.f.useDaylightTime();
    if ((this.f != null) && (!paramMap.isEmpty()))
    {
      paramString2 = paramMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramMap = (Map.Entry)paramString2.next();
        paramString1 = (String)paramMap.getKey();
        paramMap = (d.b)paramMap.getValue();
        this.h.put(paramString1, Long.valueOf(paramMap.b()));
        this.i.put(paramString1, Long.valueOf(paramMap.a()));
        Calendar localCalendar = n(this.f, paramMap.b());
        if (localCalendar != null) {
          this.j.put(paramString1, localCalendar);
        }
        paramMap = n(this.f, paramMap.b());
        if (paramMap != null) {
          this.k.put(paramString1, paramMap);
        }
      }
      long l1 = this.b;
      if (l1 != 0L)
      {
        boolean bool1 = false;
        boolean bool2 = false;
        l1 = h(l1, 0);
        long l2 = g(this.b, 0);
        long l3;
        if (l1 < l2)
        {
          l3 = this.b;
          bool1 = bool2;
          if (l3 >= l1)
          {
            bool1 = bool2;
            if (l3 < l2) {
              bool1 = true;
            }
          }
          this.d = bool1;
        }
        else
        {
          l3 = this.b;
          if ((l3 >= l1) || (l3 < l2)) {
            bool1 = true;
          }
          this.d = bool1;
        }
      }
    }
  }
  
  public long f()
  {
    return this.b;
  }
  
  public long g(long paramLong, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return a(paramLong, paramInt);
    }
    return s(paramLong, paramInt);
  }
  
  public long h(long paramLong, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return b(paramLong, paramInt);
    }
    return t(paramLong, paramInt);
  }
  
  public Pair<Long, Long> i(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar;
    if (l() != null) {
      localCalendar = Calendar.getInstance(l());
    } else {
      localCalendar = Calendar.getInstance();
    }
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l1 = localCalendar.getTimeInMillis() / 1000L;
    localCalendar.add(6, 1);
    return new Pair(Long.valueOf(l1), Long.valueOf(localCalendar.getTimeInMillis() / 1000L - 1L));
  }
  
  public int j()
  {
    return this.a;
  }
  
  public int k()
  {
    return this.e;
  }
  
  public TimeZone l()
  {
    if (this.c) {
      return this.f;
    }
    return c();
  }
  
  public long m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar;
    if (l() != null) {
      localCalendar = Calendar.getInstance(l());
    } else {
      localCalendar = Calendar.getInstance();
    }
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  public boolean o()
  {
    return this.d;
  }
  
  public boolean p()
  {
    return this.c;
  }
  
  public boolean q(long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool;
    if ((paramLong1 >= paramLong2) && (paramLong1 < paramLong3)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean r(long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool;
    if ((paramLong1 < paramLong2) && (paramLong1 >= paramLong3)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void u(String paramString1, String paramString2)
  {
    this.f = TimeZone.getTimeZone(paramString1);
    this.g = paramString2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */