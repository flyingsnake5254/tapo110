package com.google.android.material.datepicker;

import android.os.Build.VERSION;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings
{
  static Pair<String, String> getDateRangeString(@Nullable Long paramLong1, @Nullable Long paramLong2)
  {
    return getDateRangeString(paramLong1, paramLong2, null);
  }
  
  static Pair<String, String> getDateRangeString(@Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable SimpleDateFormat paramSimpleDateFormat)
  {
    if ((paramLong1 == null) && (paramLong2 == null)) {
      return Pair.create(null, null);
    }
    if (paramLong1 == null) {
      return Pair.create(null, getDateString(paramLong2.longValue(), paramSimpleDateFormat));
    }
    if (paramLong2 == null) {
      return Pair.create(getDateString(paramLong1.longValue(), paramSimpleDateFormat), null);
    }
    Calendar localCalendar1 = UtcDates.getTodayCalendar();
    Calendar localCalendar2 = UtcDates.getUtcCalendar();
    localCalendar2.setTimeInMillis(paramLong1.longValue());
    Calendar localCalendar3 = UtcDates.getUtcCalendar();
    localCalendar3.setTimeInMillis(paramLong2.longValue());
    if (paramSimpleDateFormat != null)
    {
      paramLong1 = new Date(paramLong1.longValue());
      paramLong2 = new Date(paramLong2.longValue());
      return Pair.create(paramSimpleDateFormat.format(paramLong1), paramSimpleDateFormat.format(paramLong2));
    }
    if (localCalendar2.get(1) == localCalendar3.get(1))
    {
      if (localCalendar2.get(1) == localCalendar1.get(1)) {
        return Pair.create(getMonthDay(paramLong1.longValue(), Locale.getDefault()), getMonthDay(paramLong2.longValue(), Locale.getDefault()));
      }
      return Pair.create(getMonthDay(paramLong1.longValue(), Locale.getDefault()), getYearMonthDay(paramLong2.longValue(), Locale.getDefault()));
    }
    return Pair.create(getYearMonthDay(paramLong1.longValue(), Locale.getDefault()), getYearMonthDay(paramLong2.longValue(), Locale.getDefault()));
  }
  
  static String getDateString(long paramLong)
  {
    return getDateString(paramLong, null);
  }
  
  static String getDateString(long paramLong, @Nullable SimpleDateFormat paramSimpleDateFormat)
  {
    Calendar localCalendar1 = UtcDates.getTodayCalendar();
    Calendar localCalendar2 = UtcDates.getUtcCalendar();
    localCalendar2.setTimeInMillis(paramLong);
    if (paramSimpleDateFormat != null) {
      return paramSimpleDateFormat.format(new Date(paramLong));
    }
    if (localCalendar1.get(1) == localCalendar2.get(1)) {
      return getMonthDay(paramLong);
    }
    return getYearMonthDay(paramLong);
  }
  
  static String getMonthDay(long paramLong)
  {
    return getMonthDay(paramLong, Locale.getDefault());
  }
  
  static String getMonthDay(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.getAbbrMonthDayFormat(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.getMediumNoYear(paramLocale).format(new Date(paramLong));
  }
  
  static String getMonthDayOfWeekDay(long paramLong)
  {
    return getMonthDayOfWeekDay(paramLong, Locale.getDefault());
  }
  
  static String getMonthDayOfWeekDay(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.getAbbrMonthWeekdayDayFormat(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.getFullFormat(paramLocale).format(new Date(paramLong));
  }
  
  static String getYearMonthDay(long paramLong)
  {
    return getYearMonthDay(paramLong, Locale.getDefault());
  }
  
  static String getYearMonthDay(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.getYearAbbrMonthDayFormat(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.getMediumFormat(paramLocale).format(new Date(paramLong));
  }
  
  static String getYearMonthDayOfWeekDay(long paramLong)
  {
    return getYearMonthDayOfWeekDay(paramLong, Locale.getDefault());
  }
  
  static String getYearMonthDayOfWeekDay(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.getYearAbbrMonthWeekdayDayFormat(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.getFullFormat(paramLocale).format(new Date(paramLong));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\DateStrings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */