package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.g;

public final class AppInfoTable
  implements Metadata.Entry
{
  public static final Parcelable.Creator<AppInfoTable> CREATOR = new a();
  public final int c;
  public final String d;
  
  public AppInfoTable(int paramInt, String paramString)
  {
    this.c = paramInt;
    this.d = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    int i = this.c;
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 33);
    localStringBuilder.append("Ait(controlCode=");
    localStringBuilder.append(i);
    localStringBuilder.append(",url=");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.c);
  }
  
  class a
    implements Parcelable.Creator<AppInfoTable>
  {
    public AppInfoTable a(Parcel paramParcel)
    {
      String str = (String)g.e(paramParcel.readString());
      return new AppInfoTable(paramParcel.readInt(), str);
    }
    
    public AppInfoTable[] b(int paramInt)
    {
      return new AppInfoTable[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\dvbsi\AppInfoTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */