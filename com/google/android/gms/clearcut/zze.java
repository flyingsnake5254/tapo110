package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.Arrays;

@SafeParcelable.Class(creator="LogEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zze
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zze> CREATOR = new zzf();
  public final zzha zzaa;
  @SafeParcelable.Field(id=2)
  public zzr zzag;
  @SafeParcelable.Field(id=3)
  public byte[] zzah;
  @SafeParcelable.Field(id=4)
  private int[] zzai;
  @SafeParcelable.Field(id=5)
  private String[] zzaj;
  @SafeParcelable.Field(id=6)
  private int[] zzak;
  @SafeParcelable.Field(id=7)
  private byte[][] zzal;
  @SafeParcelable.Field(id=9)
  private ExperimentTokens[] zzam;
  public final ClearcutLogger.zzb zzan;
  public final ClearcutLogger.zzb zzt;
  @SafeParcelable.Field(defaultValue="true", id=8)
  private boolean zzz;
  
  public zze(zzr paramzzr, zzha paramzzha, ClearcutLogger.zzb paramzzb1, ClearcutLogger.zzb paramzzb2, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2, byte[][] paramArrayOfByte, ExperimentTokens[] paramArrayOfExperimentTokens, boolean paramBoolean)
  {
    this.zzag = paramzzr;
    this.zzaa = paramzzha;
    this.zzt = paramzzb1;
    this.zzan = null;
    this.zzai = paramArrayOfInt1;
    this.zzaj = null;
    this.zzak = paramArrayOfInt2;
    this.zzal = null;
    this.zzam = null;
    this.zzz = paramBoolean;
  }
  
  @SafeParcelable.Constructor
  zze(@SafeParcelable.Param(id=2) zzr paramzzr, @SafeParcelable.Param(id=3) byte[] paramArrayOfByte, @SafeParcelable.Param(id=4) int[] paramArrayOfInt1, @SafeParcelable.Param(id=5) String[] paramArrayOfString, @SafeParcelable.Param(id=6) int[] paramArrayOfInt2, @SafeParcelable.Param(id=7) byte[][] paramArrayOfByte1, @SafeParcelable.Param(id=8) boolean paramBoolean, @SafeParcelable.Param(id=9) ExperimentTokens[] paramArrayOfExperimentTokens)
  {
    this.zzag = paramzzr;
    this.zzah = paramArrayOfByte;
    this.zzai = paramArrayOfInt1;
    this.zzaj = paramArrayOfString;
    this.zzaa = null;
    this.zzt = null;
    this.zzan = null;
    this.zzak = paramArrayOfInt2;
    this.zzal = paramArrayOfByte1;
    this.zzam = paramArrayOfExperimentTokens;
    this.zzz = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof zze))
    {
      paramObject = (zze)paramObject;
      if ((Objects.equal(this.zzag, ((zze)paramObject).zzag)) && (Arrays.equals(this.zzah, ((zze)paramObject).zzah)) && (Arrays.equals(this.zzai, ((zze)paramObject).zzai)) && (Arrays.equals(this.zzaj, ((zze)paramObject).zzaj)) && (Objects.equal(this.zzaa, ((zze)paramObject).zzaa)) && (Objects.equal(this.zzt, ((zze)paramObject).zzt)) && (Objects.equal(this.zzan, ((zze)paramObject).zzan)) && (Arrays.equals(this.zzak, ((zze)paramObject).zzak)) && (Arrays.deepEquals(this.zzal, ((zze)paramObject).zzal)) && (Arrays.equals(this.zzam, ((zze)paramObject).zzam)) && (this.zzz == ((zze)paramObject).zzz)) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzag, this.zzah, this.zzai, this.zzaj, this.zzaa, this.zzt, this.zzan, this.zzak, this.zzal, this.zzam, Boolean.valueOf(this.zzz) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[");
    localStringBuilder.append(this.zzag);
    localStringBuilder.append(", LogEventBytes: ");
    String str;
    if (this.zzah == null) {
      str = null;
    } else {
      str = new String(this.zzah);
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", TestCodes: ");
    localStringBuilder.append(Arrays.toString(this.zzai));
    localStringBuilder.append(", MendelPackages: ");
    localStringBuilder.append(Arrays.toString(this.zzaj));
    localStringBuilder.append(", LogEvent: ");
    localStringBuilder.append(this.zzaa);
    localStringBuilder.append(", ExtensionProducer: ");
    localStringBuilder.append(this.zzt);
    localStringBuilder.append(", VeProducer: ");
    localStringBuilder.append(this.zzan);
    localStringBuilder.append(", ExperimentIDs: ");
    localStringBuilder.append(Arrays.toString(this.zzak));
    localStringBuilder.append(", ExperimentTokens: ");
    localStringBuilder.append(Arrays.toString(this.zzal));
    localStringBuilder.append(", ExperimentTokensParcelables: ");
    localStringBuilder.append(Arrays.toString(this.zzam));
    localStringBuilder.append(", AddPhenotypeExperimentTokens: ");
    localStringBuilder.append(this.zzz);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzag, paramInt, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, this.zzah, false);
    SafeParcelWriter.writeIntArray(paramParcel, 4, this.zzai, false);
    SafeParcelWriter.writeStringArray(paramParcel, 5, this.zzaj, false);
    SafeParcelWriter.writeIntArray(paramParcel, 6, this.zzak, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 7, this.zzal, false);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzz);
    SafeParcelWriter.writeTypedArray(paramParcel, 9, this.zzam, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\clearcut\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */