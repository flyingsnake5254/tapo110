package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
  implements Comparator<SchemeData>, Parcelable
{
  public static final Parcelable.Creator<DrmInitData> CREATOR = new a();
  private final SchemeData[] c;
  private int d;
  @Nullable
  public final String f;
  public final int q;
  
  DrmInitData(Parcel paramParcel)
  {
    this.f = paramParcel.readString();
    paramParcel = (SchemeData[])o0.i((SchemeData[])paramParcel.createTypedArray(SchemeData.CREATOR));
    this.c = paramParcel;
    this.q = paramParcel.length;
  }
  
  public DrmInitData(@Nullable String paramString, List<SchemeData> paramList)
  {
    this(paramString, false, (SchemeData[])paramList.toArray(new SchemeData[0]));
  }
  
  private DrmInitData(@Nullable String paramString, boolean paramBoolean, SchemeData... paramVarArgs)
  {
    this.f = paramString;
    paramString = paramVarArgs;
    if (paramBoolean) {
      paramString = (SchemeData[])paramVarArgs.clone();
    }
    this.c = paramString;
    this.q = paramString.length;
    Arrays.sort(paramString, this);
  }
  
  public DrmInitData(@Nullable String paramString, SchemeData... paramVarArgs)
  {
    this(paramString, true, paramVarArgs);
  }
  
  public DrmInitData(List<SchemeData> paramList)
  {
    this(null, false, (SchemeData[])paramList.toArray(new SchemeData[0]));
  }
  
  public DrmInitData(SchemeData... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  private static boolean b(ArrayList<SchemeData> paramArrayList, int paramInt, UUID paramUUID)
  {
    for (int i = 0; i < paramInt; i++) {
      if (((SchemeData)paramArrayList.get(i)).d.equals(paramUUID)) {
        return true;
      }
    }
    return false;
  }
  
  @Nullable
  public static DrmInitData d(@Nullable DrmInitData paramDrmInitData1, @Nullable DrmInitData paramDrmInitData2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    int j;
    int k;
    if (paramDrmInitData1 != null)
    {
      localObject2 = paramDrmInitData1.f;
      localObject3 = paramDrmInitData1.c;
      j = localObject3.length;
      for (k = 0;; k++)
      {
        paramDrmInitData1 = (DrmInitData)localObject2;
        if (k >= j) {
          break;
        }
        paramDrmInitData1 = localObject3[k];
        if (paramDrmInitData1.b()) {
          localArrayList.add(paramDrmInitData1);
        }
      }
    }
    paramDrmInitData1 = null;
    Object localObject3 = paramDrmInitData1;
    if (paramDrmInitData2 != null)
    {
      localObject2 = paramDrmInitData1;
      if (paramDrmInitData1 == null) {
        localObject2 = paramDrmInitData2.f;
      }
      int m = localArrayList.size();
      paramDrmInitData1 = paramDrmInitData2.c;
      j = paramDrmInitData1.length;
      for (k = i;; k++)
      {
        localObject3 = localObject2;
        if (k >= j) {
          break;
        }
        paramDrmInitData2 = paramDrmInitData1[k];
        if ((paramDrmInitData2.b()) && (!b(localArrayList, m, paramDrmInitData2.d))) {
          localArrayList.add(paramDrmInitData2);
        }
      }
    }
    if (localArrayList.isEmpty()) {
      paramDrmInitData1 = (DrmInitData)localObject1;
    } else {
      paramDrmInitData1 = new DrmInitData((String)localObject3, localArrayList);
    }
    return paramDrmInitData1;
  }
  
  public int a(SchemeData paramSchemeData1, SchemeData paramSchemeData2)
  {
    UUID localUUID = w0.a;
    int i;
    if (localUUID.equals(paramSchemeData1.d))
    {
      if (localUUID.equals(paramSchemeData2.d)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    else {
      i = paramSchemeData1.d.compareTo(paramSchemeData2.d);
    }
    return i;
  }
  
  public DrmInitData c(@Nullable String paramString)
  {
    if (o0.b(this.f, paramString)) {
      return this;
    }
    return new DrmInitData(paramString, false, this.c);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public SchemeData e(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (DrmInitData.class == paramObject.getClass()))
    {
      paramObject = (DrmInitData)paramObject;
      if ((!o0.b(this.f, ((DrmInitData)paramObject).f)) || (!Arrays.equals(this.c, ((DrmInitData)paramObject).c))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public DrmInitData f(DrmInitData paramDrmInitData)
  {
    String str1 = this.f;
    if (str1 != null)
    {
      str2 = paramDrmInitData.f;
      if ((str2 != null) && (!TextUtils.equals(str1, str2)))
      {
        bool = false;
        break label38;
      }
    }
    boolean bool = true;
    label38:
    g.g(bool);
    String str2 = this.f;
    if (str2 == null) {
      str2 = paramDrmInitData.f;
    }
    return new DrmInitData(str2, (SchemeData[])o0.v0(this.c, paramDrmInitData.c));
  }
  
  public int hashCode()
  {
    if (this.d == 0)
    {
      String str = this.f;
      int i;
      if (str == null) {
        i = 0;
      } else {
        i = str.hashCode();
      }
      this.d = (i * 31 + Arrays.hashCode(this.c));
    }
    return this.d;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.f);
    paramParcel.writeTypedArray(this.c, 0);
  }
  
  public static final class SchemeData
    implements Parcelable
  {
    public static final Parcelable.Creator<SchemeData> CREATOR = new a();
    private int c;
    public final UUID d;
    @Nullable
    public final String f;
    public final String q;
    @Nullable
    public final byte[] x;
    
    SchemeData(Parcel paramParcel)
    {
      this.d = new UUID(paramParcel.readLong(), paramParcel.readLong());
      this.f = paramParcel.readString();
      this.q = ((String)o0.i(paramParcel.readString()));
      this.x = paramParcel.createByteArray();
    }
    
    public SchemeData(UUID paramUUID, @Nullable String paramString1, String paramString2, @Nullable byte[] paramArrayOfByte)
    {
      this.d = ((UUID)g.e(paramUUID));
      this.f = paramString1;
      this.q = ((String)g.e(paramString2));
      this.x = paramArrayOfByte;
    }
    
    public SchemeData(UUID paramUUID, String paramString, @Nullable byte[] paramArrayOfByte)
    {
      this(paramUUID, null, paramString, paramArrayOfByte);
    }
    
    public SchemeData a(@Nullable byte[] paramArrayOfByte)
    {
      return new SchemeData(this.d, this.f, this.q, paramArrayOfByte);
    }
    
    public boolean b()
    {
      boolean bool;
      if (this.x != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean c(UUID paramUUID)
    {
      boolean bool;
      if ((!w0.a.equals(this.d)) && (!paramUUID.equals(this.d))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool1 = paramObject instanceof SchemeData;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      if (paramObject == this) {
        return true;
      }
      paramObject = (SchemeData)paramObject;
      bool1 = bool2;
      if (o0.b(this.f, ((SchemeData)paramObject).f))
      {
        bool1 = bool2;
        if (o0.b(this.q, ((SchemeData)paramObject).q))
        {
          bool1 = bool2;
          if (o0.b(this.d, ((SchemeData)paramObject).d))
          {
            bool1 = bool2;
            if (Arrays.equals(this.x, ((SchemeData)paramObject).x)) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      if (this.c == 0)
      {
        int i = this.d.hashCode();
        String str = this.f;
        int j;
        if (str == null) {
          j = 0;
        } else {
          j = str.hashCode();
        }
        this.c = (((i * 31 + j) * 31 + this.q.hashCode()) * 31 + Arrays.hashCode(this.x));
      }
      return this.c;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.d.getMostSignificantBits());
      paramParcel.writeLong(this.d.getLeastSignificantBits());
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.q);
      paramParcel.writeByteArray(this.x);
    }
    
    class a
      implements Parcelable.Creator<DrmInitData.SchemeData>
    {
      public DrmInitData.SchemeData a(Parcel paramParcel)
      {
        return new DrmInitData.SchemeData(paramParcel);
      }
      
      public DrmInitData.SchemeData[] b(int paramInt)
      {
        return new DrmInitData.SchemeData[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<DrmInitData>
  {
    public DrmInitData a(Parcel paramParcel)
    {
      return new DrmInitData(paramParcel);
    }
    
    public DrmInitData[] b(int paramInt)
    {
      return new DrmInitData[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\DrmInitData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */