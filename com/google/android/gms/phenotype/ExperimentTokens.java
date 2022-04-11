package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@KeepForSdk
@SafeParcelable.Class(creator="ExperimentTokensCreator")
@SafeParcelable.Reserved({1})
public class ExperimentTokens
  extends AbstractSafeParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<ExperimentTokens> CREATOR = new zzh();
  private static final zza zzaa = new zzg();
  private static final byte[][] zzn;
  private static final ExperimentTokens zzo;
  private static final zza zzx;
  private static final zza zzy;
  private static final zza zzz;
  @SafeParcelable.Field(id=2)
  private final String zzp;
  @SafeParcelable.Field(id=3)
  private final byte[] zzq;
  @SafeParcelable.Field(id=4)
  private final byte[][] zzr;
  @SafeParcelable.Field(id=5)
  private final byte[][] zzs;
  @SafeParcelable.Field(id=6)
  private final byte[][] zzt;
  @SafeParcelable.Field(id=7)
  private final byte[][] zzu;
  @SafeParcelable.Field(id=8)
  private final int[] zzv;
  @SafeParcelable.Field(id=9)
  private final byte[][] zzw;
  
  static
  {
    byte[][] arrayOfByte = new byte[0][];
    zzn = arrayOfByte;
    zzo = new ExperimentTokens("", null, arrayOfByte, arrayOfByte, arrayOfByte, arrayOfByte, null, null);
    zzx = new zzd();
    zzy = new zze();
    zzz = new zzf();
  }
  
  @SafeParcelable.Constructor
  public ExperimentTokens(@SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) byte[] paramArrayOfByte, @SafeParcelable.Param(id=4) byte[][] paramArrayOfByte1, @SafeParcelable.Param(id=5) byte[][] paramArrayOfByte2, @SafeParcelable.Param(id=6) byte[][] paramArrayOfByte3, @SafeParcelable.Param(id=7) byte[][] paramArrayOfByte4, @SafeParcelable.Param(id=8) int[] paramArrayOfInt, @SafeParcelable.Param(id=9) byte[][] paramArrayOfByte5)
  {
    this.zzp = paramString;
    this.zzq = paramArrayOfByte;
    this.zzr = paramArrayOfByte1;
    this.zzs = paramArrayOfByte2;
    this.zzt = paramArrayOfByte3;
    this.zzu = paramArrayOfByte4;
    this.zzv = paramArrayOfInt;
    this.zzw = paramArrayOfByte5;
  }
  
  private static List<Integer> zza(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(Integer.valueOf(paramArrayOfInt[j]));
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  private static List<String> zza(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfByte.length);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(Base64.encodeToString(paramArrayOfByte[j], 3));
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  private static void zza(StringBuilder paramStringBuilder, String paramString, byte[][] paramArrayOfByte)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("=");
    if (paramArrayOfByte == null) {}
    for (paramString = "null";; paramString = ")")
    {
      paramStringBuilder.append(paramString);
      return;
      paramStringBuilder.append("(");
      int i = paramArrayOfByte.length;
      int j = 1;
      int k = 0;
      while (k < i)
      {
        paramString = paramArrayOfByte[k];
        if (j == 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append("'");
        paramStringBuilder.append(Base64.encodeToString(paramString, 3));
        paramStringBuilder.append("'");
        k++;
        j = 0;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ExperimentTokens))
    {
      paramObject = (ExperimentTokens)paramObject;
      if ((zzn.equals(this.zzp, ((ExperimentTokens)paramObject).zzp)) && (Arrays.equals(this.zzq, ((ExperimentTokens)paramObject).zzq)) && (zzn.equals(zza(this.zzr), zza(((ExperimentTokens)paramObject).zzr))) && (zzn.equals(zza(this.zzs), zza(((ExperimentTokens)paramObject).zzs))) && (zzn.equals(zza(this.zzt), zza(((ExperimentTokens)paramObject).zzt))) && (zzn.equals(zza(this.zzu), zza(((ExperimentTokens)paramObject).zzu))) && (zzn.equals(zza(this.zzv), zza(((ExperimentTokens)paramObject).zzv))) && (zzn.equals(zza(this.zzw), zza(((ExperimentTokens)paramObject).zzw)))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("ExperimentTokens");
    localStringBuilder1.append("(");
    Object localObject = this.zzp;
    if (localObject == null)
    {
      localObject = "null";
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder(String.valueOf(localObject).length() + 2);
      localStringBuilder2.append("'");
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append("'");
      localObject = localStringBuilder2.toString();
    }
    localStringBuilder1.append((String)localObject);
    localStringBuilder1.append(", ");
    localObject = this.zzq;
    localStringBuilder1.append("direct");
    localStringBuilder1.append("=");
    if (localObject == null)
    {
      localStringBuilder1.append("null");
    }
    else
    {
      localStringBuilder1.append("'");
      localStringBuilder1.append(Base64.encodeToString((byte[])localObject, 3));
      localStringBuilder1.append("'");
    }
    localStringBuilder1.append(", ");
    zza(localStringBuilder1, "GAIA", this.zzr);
    localStringBuilder1.append(", ");
    zza(localStringBuilder1, "PSEUDO", this.zzs);
    localStringBuilder1.append(", ");
    zza(localStringBuilder1, "ALWAYS", this.zzt);
    localStringBuilder1.append(", ");
    zza(localStringBuilder1, "OTHER", this.zzu);
    localStringBuilder1.append(", ");
    localObject = this.zzv;
    localStringBuilder1.append("weak");
    localStringBuilder1.append("=");
    if (localObject == null)
    {
      localStringBuilder1.append("null");
    }
    else
    {
      localStringBuilder1.append("(");
      int i = localObject.length;
      int j = 1;
      int k = 0;
      while (k < i)
      {
        int m = localObject[k];
        if (j == 0) {
          localStringBuilder1.append(", ");
        }
        localStringBuilder1.append(m);
        k++;
        j = 0;
      }
      localStringBuilder1.append(")");
    }
    localStringBuilder1.append(", ");
    zza(localStringBuilder1, "directs", this.zzw);
    localStringBuilder1.append(")");
    return localStringBuilder1.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzp, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, this.zzq, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 4, this.zzr, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 5, this.zzs, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 6, this.zzt, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 7, this.zzu, false);
    SafeParcelWriter.writeIntArray(paramParcel, 8, this.zzv, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 9, this.zzw, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  private static abstract interface zza {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\phenotype\ExperimentTokens.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */