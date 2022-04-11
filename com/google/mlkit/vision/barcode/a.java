package com.google.mlkit.vision.barcode;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzao.zza;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzao.zzb;
import com.google.mlkit.vision.barcode.internal.h;

public class a
{
  private static final SparseArray<zzbl.zzao.zza> a;
  private static final SparseArray<zzbl.zzao.zzb> b;
  private final h c;
  
  static
  {
    SparseArray localSparseArray1 = new SparseArray();
    a = localSparseArray1;
    SparseArray localSparseArray2 = new SparseArray();
    b = localSparseArray2;
    localSparseArray1.put(-1, zzbl.zzao.zza.zza);
    localSparseArray1.put(1, zzbl.zzao.zza.zzb);
    localSparseArray1.put(2, zzbl.zzao.zza.zzc);
    localSparseArray1.put(4, zzbl.zzao.zza.zzd);
    localSparseArray1.put(8, zzbl.zzao.zza.zze);
    localSparseArray1.put(16, zzbl.zzao.zza.zzf);
    localSparseArray1.put(32, zzbl.zzao.zza.zzg);
    localSparseArray1.put(64, zzbl.zzao.zza.zzh);
    localSparseArray1.put(128, zzbl.zzao.zza.zzi);
    localSparseArray1.put(256, zzbl.zzao.zza.zzj);
    localSparseArray1.put(512, zzbl.zzao.zza.zzk);
    localSparseArray1.put(1024, zzbl.zzao.zza.zzl);
    localSparseArray1.put(2048, zzbl.zzao.zza.zzm);
    localSparseArray1.put(4096, zzbl.zzao.zza.zzn);
    localSparseArray2.put(0, zzbl.zzao.zzb.zza);
    localSparseArray2.put(1, zzbl.zzao.zzb.zzb);
    localSparseArray2.put(2, zzbl.zzao.zzb.zzc);
    localSparseArray2.put(3, zzbl.zzao.zzb.zzd);
    localSparseArray2.put(4, zzbl.zzao.zzb.zze);
    localSparseArray2.put(5, zzbl.zzao.zzb.zzf);
    localSparseArray2.put(6, zzbl.zzao.zzb.zzg);
    localSparseArray2.put(7, zzbl.zzao.zzb.zzh);
    localSparseArray2.put(8, zzbl.zzao.zzb.zzi);
    localSparseArray2.put(9, zzbl.zzao.zzb.zzj);
    localSparseArray2.put(10, zzbl.zzao.zzb.zzk);
    localSparseArray2.put(11, zzbl.zzao.zzb.zzl);
    localSparseArray2.put(12, zzbl.zzao.zzb.zzm);
  }
  
  public a(@NonNull h paramh)
  {
    this.c = ((h)Preconditions.checkNotNull(paramh));
  }
  
  public int a()
  {
    int i = this.c.zzf();
    int j;
    if (i <= 4096)
    {
      j = i;
      if (i != 0) {}
    }
    else
    {
      j = -1;
    }
    return j;
  }
  
  @Nullable
  public String b()
  {
    return this.c.zzc();
  }
  
  public int c()
  {
    return this.c.zzg();
  }
  
  public final zzbl.zzao.zza d()
  {
    zzbl.zzao.zza localzza1 = (zzbl.zzao.zza)a.get(a());
    zzbl.zzao.zza localzza2 = localzza1;
    if (localzza1 == null) {
      localzza2 = zzbl.zzao.zza.zza;
    }
    return localzza2;
  }
  
  public final zzbl.zzao.zzb e()
  {
    zzbl.zzao.zzb localzzb1 = (zzbl.zzao.zzb)b.get(c());
    zzbl.zzao.zzb localzzb2 = localzzb1;
    if (localzzb1 == null) {
      localzzb2 = zzbl.zzao.zzb.zza;
    }
    return localzzb2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */