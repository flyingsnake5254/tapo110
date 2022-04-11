package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();
  public final String c;
  public final Uri d;
  @Nullable
  public final String f;
  public final List<StreamKey> q;
  @Nullable
  public final byte[] x;
  @Nullable
  public final String y;
  public final byte[] z;
  
  DownloadRequest(Parcel paramParcel)
  {
    this.c = ((String)o0.i(paramParcel.readString()));
    this.d = Uri.parse((String)o0.i(paramParcel.readString()));
    this.f = paramParcel.readString();
    int i = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add((StreamKey)paramParcel.readParcelable(StreamKey.class.getClassLoader()));
    }
    this.q = Collections.unmodifiableList(localArrayList);
    this.x = paramParcel.createByteArray();
    this.y = paramParcel.readString();
    this.z = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof DownloadRequest;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DownloadRequest)paramObject;
    bool1 = bool2;
    if (this.c.equals(((DownloadRequest)paramObject).c))
    {
      bool1 = bool2;
      if (this.d.equals(((DownloadRequest)paramObject).d))
      {
        bool1 = bool2;
        if (o0.b(this.f, ((DownloadRequest)paramObject).f))
        {
          bool1 = bool2;
          if (this.q.equals(((DownloadRequest)paramObject).q))
          {
            bool1 = bool2;
            if (Arrays.equals(this.x, ((DownloadRequest)paramObject).x))
            {
              bool1 = bool2;
              if (o0.b(this.y, ((DownloadRequest)paramObject).y))
              {
                bool1 = bool2;
                if (Arrays.equals(this.z, ((DownloadRequest)paramObject).z)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    int i = this.c.hashCode();
    int j = this.d.hashCode();
    String str = this.f;
    int k = 0;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    int n = this.q.hashCode();
    int i1 = Arrays.hashCode(this.x);
    str = this.y;
    if (str != null) {
      k = str.hashCode();
    }
    return (((((i * 31 * 31 + j) * 31 + m) * 31 + n) * 31 + i1) * 31 + k) * 31 + Arrays.hashCode(this.z);
  }
  
  public String toString()
  {
    String str1 = this.f;
    String str2 = this.c;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d.toString());
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.q.size());
    for (paramInt = 0; paramInt < this.q.size(); paramInt++) {
      paramParcel.writeParcelable((Parcelable)this.q.get(paramInt), 0);
    }
    paramParcel.writeByteArray(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeByteArray(this.z);
  }
  
  public static class UnsupportedRequestException
    extends IOException
  {}
  
  class a
    implements Parcelable.Creator<DownloadRequest>
  {
    public DownloadRequest a(Parcel paramParcel)
    {
      return new DownloadRequest(paramParcel);
    }
    
    public DownloadRequest[] b(int paramInt)
    {
      return new DownloadRequest[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\offline\DownloadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */