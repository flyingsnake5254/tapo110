package com.google.mlkit.vision.barcode;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdv.zza;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdv.zza.zza;
import com.google.android.gms.internal.mlkit_vision_barcode.zzen;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga.zzb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class b
{
  @SuppressLint({"UseSparseArrays"})
  private static final Map<Integer, zzen> a;
  private final int b;
  @Nullable
  private final Executor c;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(Integer.valueOf(1), zzen.zza);
    localHashMap.put(Integer.valueOf(2), zzen.zzb);
    localHashMap.put(Integer.valueOf(4), zzen.zzc);
    localHashMap.put(Integer.valueOf(8), zzen.zzd);
    localHashMap.put(Integer.valueOf(16), zzen.zze);
    localHashMap.put(Integer.valueOf(32), zzen.zzf);
    localHashMap.put(Integer.valueOf(64), zzen.zzg);
    localHashMap.put(Integer.valueOf(128), zzen.zzh);
    localHashMap.put(Integer.valueOf(256), zzen.zzi);
    localHashMap.put(Integer.valueOf(512), zzen.zzj);
    localHashMap.put(Integer.valueOf(1024), zzen.zzk);
    localHashMap.put(Integer.valueOf(2048), zzen.zzl);
    localHashMap.put(Integer.valueOf(4096), zzen.zzm);
  }
  
  private b(int paramInt, @Nullable Executor paramExecutor)
  {
    this.b = paramInt;
    this.c = paramExecutor;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  @Nullable
  public final Executor b()
  {
    return this.c;
  }
  
  public final zzdv.zza c()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b == 0)
    {
      localArrayList.addAll(a.values());
    }
    else
    {
      Iterator localIterator = a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((this.b & ((Integer)localEntry.getKey()).intValue()) != 0) {
          localArrayList.add((zzen)localEntry.getValue());
        }
      }
    }
    return (zzdv.zza)zzdv.zza.zza().zza(localArrayList).zzg();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    paramObject = (b)paramObject;
    return this.b == ((b)paramObject).b;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.b) });
  }
  
  public static class a
  {
    private int a = 0;
    @Nullable
    private Executor b;
    
    @NonNull
    public b a()
    {
      return new b(this.a, this.b, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */