package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class CalendarConstraints
  implements Parcelable
{
  public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public CalendarConstraints createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      return new CalendarConstraints((Month)paramAnonymousParcel.readParcelable(Month.class.getClassLoader()), (Month)paramAnonymousParcel.readParcelable(Month.class.getClassLoader()), (Month)paramAnonymousParcel.readParcelable(Month.class.getClassLoader()), (CalendarConstraints.DateValidator)paramAnonymousParcel.readParcelable(CalendarConstraints.DateValidator.class.getClassLoader()), null);
    }
    
    @NonNull
    public CalendarConstraints[] newArray(int paramAnonymousInt)
    {
      return new CalendarConstraints[paramAnonymousInt];
    }
  };
  @NonNull
  private final Month end;
  private final int monthSpan;
  @NonNull
  private final Month openAt;
  @NonNull
  private final Month start;
  private final DateValidator validator;
  private final int yearSpan;
  
  private CalendarConstraints(@NonNull Month paramMonth1, @NonNull Month paramMonth2, @NonNull Month paramMonth3, DateValidator paramDateValidator)
  {
    this.start = paramMonth1;
    this.end = paramMonth2;
    this.openAt = paramMonth3;
    this.validator = paramDateValidator;
    if (paramMonth1.compareTo(paramMonth3) <= 0)
    {
      if (paramMonth3.compareTo(paramMonth2) <= 0)
      {
        this.monthSpan = (paramMonth1.monthsUntil(paramMonth2) + 1);
        this.yearSpan = (paramMonth2.year - paramMonth1.year + 1);
        return;
      }
      throw new IllegalArgumentException("current Month cannot be after end Month");
    }
    throw new IllegalArgumentException("start Month cannot be after current Month");
  }
  
  Month clamp(Month paramMonth)
  {
    if (paramMonth.compareTo(this.start) < 0) {
      return this.start;
    }
    Month localMonth = paramMonth;
    if (paramMonth.compareTo(this.end) > 0) {
      localMonth = this.end;
    }
    return localMonth;
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
    if (!(paramObject instanceof CalendarConstraints)) {
      return false;
    }
    paramObject = (CalendarConstraints)paramObject;
    if ((!this.start.equals(((CalendarConstraints)paramObject).start)) || (!this.end.equals(((CalendarConstraints)paramObject).end)) || (!this.openAt.equals(((CalendarConstraints)paramObject).openAt)) || (!this.validator.equals(((CalendarConstraints)paramObject).validator))) {
      bool = false;
    }
    return bool;
  }
  
  public DateValidator getDateValidator()
  {
    return this.validator;
  }
  
  @NonNull
  Month getEnd()
  {
    return this.end;
  }
  
  int getMonthSpan()
  {
    return this.monthSpan;
  }
  
  @NonNull
  Month getOpenAt()
  {
    return this.openAt;
  }
  
  @NonNull
  Month getStart()
  {
    return this.start;
  }
  
  int getYearSpan()
  {
    return this.yearSpan;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.start, this.end, this.openAt, this.validator });
  }
  
  boolean isWithinBounds(long paramLong)
  {
    Month localMonth = this.start;
    boolean bool = true;
    if (localMonth.getDay(1) <= paramLong)
    {
      localMonth = this.end;
      if (paramLong <= localMonth.getDay(localMonth.daysInMonth)) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.start, 0);
    paramParcel.writeParcelable(this.end, 0);
    paramParcel.writeParcelable(this.openAt, 0);
    paramParcel.writeParcelable(this.validator, 0);
  }
  
  public static final class Builder
  {
    private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
    static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
    static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
    private long end = DEFAULT_END;
    private Long openAt;
    private long start = DEFAULT_START;
    private CalendarConstraints.DateValidator validator = DateValidatorPointForward.from(Long.MIN_VALUE);
    
    public Builder() {}
    
    Builder(@NonNull CalendarConstraints paramCalendarConstraints)
    {
      this.start = paramCalendarConstraints.start.timeInMillis;
      this.end = paramCalendarConstraints.end.timeInMillis;
      this.openAt = Long.valueOf(paramCalendarConstraints.openAt.timeInMillis);
      this.validator = paramCalendarConstraints.validator;
    }
    
    @NonNull
    public CalendarConstraints build()
    {
      if (this.openAt == null)
      {
        long l1 = MaterialDatePicker.thisMonthInUtcMilliseconds();
        long l2 = this.start;
        if ((l2 <= l1) && (l1 <= this.end)) {
          l2 = l1;
        }
        this.openAt = Long.valueOf(l2);
      }
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.validator);
      return new CalendarConstraints(Month.create(this.start), Month.create(this.end), Month.create(this.openAt.longValue()), (CalendarConstraints.DateValidator)localBundle.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null);
    }
    
    @NonNull
    public Builder setEnd(long paramLong)
    {
      this.end = paramLong;
      return this;
    }
    
    @NonNull
    public Builder setOpenAt(long paramLong)
    {
      this.openAt = Long.valueOf(paramLong);
      return this;
    }
    
    @NonNull
    public Builder setStart(long paramLong)
    {
      this.start = paramLong;
      return this;
    }
    
    @NonNull
    public Builder setValidator(CalendarConstraints.DateValidator paramDateValidator)
    {
      this.validator = paramDateValidator;
      return this;
    }
  }
  
  public static abstract interface DateValidator
    extends Parcelable
  {
    public abstract boolean isValid(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\CalendarConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */