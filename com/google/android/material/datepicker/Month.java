package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month
  implements Comparable<Month>, Parcelable
{
  public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public Month createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      return Month.create(paramAnonymousParcel.readInt(), paramAnonymousParcel.readInt());
    }
    
    @NonNull
    public Month[] newArray(int paramAnonymousInt)
    {
      return new Month[paramAnonymousInt];
    }
  };
  final int daysInMonth;
  final int daysInWeek;
  @NonNull
  private final Calendar firstOfMonth;
  @NonNull
  private final String longName;
  final int month;
  final long timeInMillis;
  final int year;
  
  private Month(@NonNull Calendar paramCalendar)
  {
    paramCalendar.set(5, 1);
    paramCalendar = UtcDates.getDayCopy(paramCalendar);
    this.firstOfMonth = paramCalendar;
    this.month = paramCalendar.get(2);
    this.year = paramCalendar.get(1);
    this.daysInWeek = paramCalendar.getMaximum(7);
    this.daysInMonth = paramCalendar.getActualMaximum(5);
    this.longName = UtcDates.getYearMonthFormat().format(paramCalendar.getTime());
    this.timeInMillis = paramCalendar.getTimeInMillis();
  }
  
  @NonNull
  static Month create(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = UtcDates.getUtcCalendar();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    return new Month(localCalendar);
  }
  
  @NonNull
  static Month create(long paramLong)
  {
    Calendar localCalendar = UtcDates.getUtcCalendar();
    localCalendar.setTimeInMillis(paramLong);
    return new Month(localCalendar);
  }
  
  @NonNull
  static Month current()
  {
    return new Month(UtcDates.getTodayCalendar());
  }
  
  public int compareTo(@NonNull Month paramMonth)
  {
    return this.firstOfMonth.compareTo(paramMonth.firstOfMonth);
  }
  
  int daysFromStartOfWeekToFirstOfMonth()
  {
    int i = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
    int j = i;
    if (i < 0) {
      j = i + this.daysInWeek;
    }
    return j;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Month)) {
      return false;
    }
    paramObject = (Month)paramObject;
    if ((this.month != ((Month)paramObject).month) || (this.year != ((Month)paramObject).year)) {
      bool = false;
    }
    return bool;
  }
  
  long getDay(int paramInt)
  {
    Calendar localCalendar = UtcDates.getDayCopy(this.firstOfMonth);
    localCalendar.set(5, paramInt);
    return localCalendar.getTimeInMillis();
  }
  
  @NonNull
  String getLongName()
  {
    return this.longName;
  }
  
  long getStableId()
  {
    return this.firstOfMonth.getTimeInMillis();
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.month), Integer.valueOf(this.year) });
  }
  
  @NonNull
  Month monthsLater(int paramInt)
  {
    Calendar localCalendar = UtcDates.getDayCopy(this.firstOfMonth);
    localCalendar.add(2, paramInt);
    return new Month(localCalendar);
  }
  
  int monthsUntil(@NonNull Month paramMonth)
  {
    if ((this.firstOfMonth instanceof GregorianCalendar)) {
      return (paramMonth.year - this.year) * 12 + (paramMonth.month - this.month);
    }
    throw new IllegalArgumentException("Only Gregorian calendars are supported.");
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.year);
    paramParcel.writeInt(this.month);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\Month.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */