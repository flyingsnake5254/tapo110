package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;

public final class CompositeDateValidator
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public CompositeDateValidator createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      return new CompositeDateValidator((List)Preconditions.checkNotNull(paramAnonymousParcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader())), null);
    }
    
    @NonNull
    public CompositeDateValidator[] newArray(int paramAnonymousInt)
    {
      return new CompositeDateValidator[paramAnonymousInt];
    }
  };
  @NonNull
  private final List<CalendarConstraints.DateValidator> validators;
  
  private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> paramList)
  {
    this.validators = paramList;
  }
  
  @NonNull
  public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> paramList)
  {
    return new CompositeDateValidator(paramList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CompositeDateValidator)) {
      return false;
    }
    paramObject = (CompositeDateValidator)paramObject;
    return this.validators.equals(((CompositeDateValidator)paramObject).validators);
  }
  
  public int hashCode()
  {
    return this.validators.hashCode();
  }
  
  public boolean isValid(long paramLong)
  {
    Iterator localIterator = this.validators.iterator();
    while (localIterator.hasNext())
    {
      CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)localIterator.next();
      if ((localDateValidator != null) && (!localDateValidator.isValid(paramLong))) {
        return false;
      }
    }
    return true;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.validators);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\CompositeDateValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */