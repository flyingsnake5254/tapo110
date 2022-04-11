package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;
import java.util.Comparator;

@SafeParcelable.Class(creator="FlagCreator")
@SafeParcelable.Reserved({1})
public final class zzi
  extends AbstractSafeParcelable
  implements Comparable<zzi>
{
  public static final Parcelable.Creator<zzi> CREATOR = new zzk();
  private static final Comparator<zzi> zzai = new zzj();
  @SafeParcelable.Field(id=2)
  public final String name;
  @SafeParcelable.Field(id=3)
  private final long zzab;
  @SafeParcelable.Field(id=4)
  private final boolean zzac;
  @SafeParcelable.Field(id=5)
  private final double zzad;
  @SafeParcelable.Field(id=6)
  private final String zzae;
  @SafeParcelable.Field(id=7)
  private final byte[] zzaf;
  @SafeParcelable.Field(id=8)
  private final int zzag;
  @SafeParcelable.Field(id=9)
  public final int zzah;
  
  @SafeParcelable.Constructor
  public zzi(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=4) boolean paramBoolean, @SafeParcelable.Param(id=5) double paramDouble, @SafeParcelable.Param(id=6) String paramString2, @SafeParcelable.Param(id=7) byte[] paramArrayOfByte, @SafeParcelable.Param(id=8) int paramInt1, @SafeParcelable.Param(id=9) int paramInt2)
  {
    this.name = paramString1;
    this.zzab = paramLong;
    this.zzac = paramBoolean;
    this.zzad = paramDouble;
    this.zzae = paramString2;
    this.zzaf = paramArrayOfByte;
    this.zzag = paramInt1;
    this.zzah = paramInt2;
  }
  
  private static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof zzi))
    {
      paramObject = (zzi)paramObject;
      if (zzn.equals(this.name, ((zzi)paramObject).name))
      {
        int i = this.zzag;
        if ((i == ((zzi)paramObject).zzag) && (this.zzah == ((zzi)paramObject).zzah))
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  if (i == 5) {
                    return Arrays.equals(this.zzaf, ((zzi)paramObject).zzaf);
                  }
                  i = this.zzag;
                  paramObject = new StringBuilder(31);
                  ((StringBuilder)paramObject).append("Invalid enum value: ");
                  ((StringBuilder)paramObject).append(i);
                  throw new AssertionError(((StringBuilder)paramObject).toString());
                }
                return zzn.equals(this.zzae, ((zzi)paramObject).zzae);
              }
              return this.zzad == ((zzi)paramObject).zzad;
            }
            return this.zzac == ((zzi)paramObject).zzac;
          }
          if (this.zzab == ((zzi)paramObject).zzab) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Flag(");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", ");
    int i = this.zzag;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          String str;
          if (i != 4)
          {
            if (i == 5)
            {
              if (this.zzaf == null)
              {
                localStringBuilder.append("null");
                break label224;
              }
              localStringBuilder.append("'");
              str = Base64.encodeToString(this.zzaf, 3);
            }
            else
            {
              str = this.name;
              i = this.zzag;
              localStringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
              localStringBuilder.append("Invalid type: ");
              localStringBuilder.append(str);
              localStringBuilder.append(", ");
              localStringBuilder.append(i);
              throw new AssertionError(localStringBuilder.toString());
            }
          }
          else
          {
            localStringBuilder.append("'");
            str = this.zzae;
          }
          localStringBuilder.append(str);
          localStringBuilder.append("'");
        }
        else
        {
          localStringBuilder.append(this.zzad);
        }
      }
      else {
        localStringBuilder.append(this.zzac);
      }
    }
    else {
      localStringBuilder.append(this.zzab);
    }
    label224:
    localStringBuilder.append(", ");
    localStringBuilder.append(this.zzag);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.zzah);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzab);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzac);
    SafeParcelWriter.writeDouble(paramParcel, 5, this.zzad);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzae, false);
    SafeParcelWriter.writeByteArray(paramParcel, 7, this.zzaf, false);
    SafeParcelWriter.writeInt(paramParcel, 8, this.zzag);
    SafeParcelWriter.writeInt(paramParcel, 9, this.zzah);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\phenotype\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */