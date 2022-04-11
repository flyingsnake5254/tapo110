package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Calendar;

public class DateValidatorPointBackward
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public DateValidatorPointBackward createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      return new DateValidatorPointBackward(paramAnonymousParcel.readLong(), null);
    }
    
    @NonNull
    public DateValidatorPointBackward[] newArray(int paramAnonymousInt)
    {
      return new DateValidatorPointBackward[paramAnonymousInt];
    }
  };
  private final long point;
  
  private DateValidatorPointBackward(long paramLong)
  {
    this.point = paramLong;
  }
  
  @NonNull
  public static DateValidatorPointBackward before(long paramLong)
  {
    return new DateValidatorPointBackward(paramLong);
  }
  
  @NonNull
  public static DateValidatorPointBackward now()
  {
    return before(UtcDates.getTodayCalendar().getTimeInMillis());
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
    if (!(paramObject instanceof DateValidatorPointBackward)) {
      return false;
    }
    paramObject = (DateValidatorPointBackward)paramObject;
    if (this.point != ((DateValidatorPointBackward)paramObject).point) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(this.point) });
  }
  
  public boolean isValid(long paramLong)
  {
    boolean bool;
    if (paramLong <= this.point) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.point);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\DateValidatorPointBackward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */