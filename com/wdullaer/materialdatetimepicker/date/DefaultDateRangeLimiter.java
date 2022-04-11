package com.wdullaer.materialdatetimepicker.date;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Calendar;
import java.util.HashSet;
import java.util.TreeSet;

class DefaultDateRangeLimiter
  implements DateRangeLimiter
{
  public static final Parcelable.Creator<DefaultDateRangeLimiter> CREATOR = new a();
  private int c = 1900;
  private int d = 2100;
  private Calendar f;
  private Calendar q;
  private TreeSet<Calendar> x = new TreeSet();
  private HashSet<Calendar> y = new HashSet();
  
  DefaultDateRangeLimiter() {}
  
  public DefaultDateRangeLimiter(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.f = ((Calendar)paramParcel.readSerializable());
    this.q = ((Calendar)paramParcel.readSerializable());
    this.x = ((TreeSet)paramParcel.readSerializable());
    this.y = ((HashSet)paramParcel.readSerializable());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeSerializable(this.f);
    paramParcel.writeSerializable(this.q);
    paramParcel.writeSerializable(this.x);
    paramParcel.writeSerializable(this.y);
  }
  
  static final class a
    implements Parcelable.Creator<DefaultDateRangeLimiter>
  {
    public DefaultDateRangeLimiter a(Parcel paramParcel)
    {
      return new DefaultDateRangeLimiter(paramParcel);
    }
    
    public DefaultDateRangeLimiter[] b(int paramInt)
    {
      return new DefaultDateRangeLimiter[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\DefaultDateRangeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */