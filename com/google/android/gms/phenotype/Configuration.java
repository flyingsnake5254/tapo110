package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@KeepForSdk
@SafeParcelable.Class(creator="ConfigurationCreator")
@SafeParcelable.Reserved({1})
public class Configuration
  extends AbstractSafeParcelable
  implements Comparable<Configuration>
{
  @KeepForSdk
  public static final Parcelable.Creator<Configuration> CREATOR = new zzc();
  @SafeParcelable.Field(id=2)
  private final int zzc;
  @SafeParcelable.Field(id=3)
  private final zzi[] zzd;
  @SafeParcelable.Field(id=4)
  private final String[] zze;
  private final Map<String, zzi> zzf;
  
  @SafeParcelable.Constructor
  public Configuration(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) zzi[] paramArrayOfzzi, @SafeParcelable.Param(id=4) String[] paramArrayOfString)
  {
    this.zzc = paramInt;
    this.zzd = paramArrayOfzzi;
    this.zzf = new TreeMap();
    int i = paramArrayOfzzi.length;
    for (paramInt = 0; paramInt < i; paramInt++)
    {
      zzi localzzi = paramArrayOfzzi[paramInt];
      this.zzf.put(localzzi.name, localzzi);
    }
    this.zze = paramArrayOfString;
    if (paramArrayOfString != null) {
      Arrays.sort(paramArrayOfString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Configuration))
    {
      paramObject = (Configuration)paramObject;
      if ((this.zzc == ((Configuration)paramObject).zzc) && (zzn.equals(this.zzf, ((Configuration)paramObject).zzf)) && (Arrays.equals(this.zze, ((Configuration)paramObject).zze))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Configuration(");
    localStringBuilder.append(this.zzc);
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    Object localObject = this.zzf.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((zzi)((Iterator)localObject).next());
      localStringBuilder.append(", ");
    }
    localStringBuilder.append(")");
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    localObject = this.zze;
    if (localObject != null)
    {
      int i = localObject.length;
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append(localObject[j]);
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("null");
    localStringBuilder.append(")");
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzc);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzd, paramInt, false);
    SafeParcelWriter.writeStringArray(paramParcel, 4, this.zze, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\phenotype\Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */