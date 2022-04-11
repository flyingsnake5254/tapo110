package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

class TimeSource
{
  private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);
  @Nullable
  private final Long fixedTimeMs;
  @Nullable
  private final TimeZone fixedTimeZone;
  
  private TimeSource(@Nullable Long paramLong, @Nullable TimeZone paramTimeZone)
  {
    this.fixedTimeMs = paramLong;
    this.fixedTimeZone = paramTimeZone;
  }
  
  static TimeSource fixed(long paramLong)
  {
    return new TimeSource(Long.valueOf(paramLong), null);
  }
  
  static TimeSource fixed(long paramLong, @Nullable TimeZone paramTimeZone)
  {
    return new TimeSource(Long.valueOf(paramLong), paramTimeZone);
  }
  
  static TimeSource system()
  {
    return SYSTEM_TIME_SOURCE;
  }
  
  Calendar now()
  {
    return now(this.fixedTimeZone);
  }
  
  Calendar now(@Nullable TimeZone paramTimeZone)
  {
    if (paramTimeZone == null) {
      paramTimeZone = Calendar.getInstance();
    } else {
      paramTimeZone = Calendar.getInstance(paramTimeZone);
    }
    Long localLong = this.fixedTimeMs;
    if (localLong != null) {
      paramTimeZone.setTimeInMillis(localLong.longValue());
    }
    return paramTimeZone;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\TimeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */