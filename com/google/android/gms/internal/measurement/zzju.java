package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

final class zzju<T extends zzjt<T>>
{
  private static final zzju zzd = new zzju(true);
  final zzmd<T, Object> zza;
  private boolean zzb;
  private boolean zzc;
  
  private zzju()
  {
    this.zza = new zzlw(16);
  }
  
  private zzju(boolean paramBoolean)
  {
    this.zza = localzzlw;
    zzb();
    zzb();
  }
  
  public static <T extends zzjt<T>> zzju<T> zza()
  {
    throw null;
  }
  
  private static final void zzd(T paramT, Object paramObject)
  {
    zzmx localzzmx = paramT.zzb();
    zzkl.zza(paramObject);
    Object localObject = zzmx.zza;
    localObject = zzmy.zza;
    boolean bool;
    switch (localzzmx.zza().ordinal())
    {
    default: 
      break;
    case 8: 
      if ((paramObject instanceof zzli)) {
        break label186;
      }
      if (!(paramObject instanceof zzkp)) {
        break label187;
      }
    case 7: 
      if ((goto 186) || ((paramObject instanceof Integer))) {
        break label186;
      }
      if (!(paramObject instanceof zzkf)) {
        break label187;
      }
    case 6: 
      if ((goto 186) || ((paramObject instanceof zzjd))) {
        break label186;
      }
      if (!(paramObject instanceof byte[])) {
        break label187;
      }
      break;
    case 5: 
      bool = paramObject instanceof String;
      break;
    case 4: 
      bool = paramObject instanceof Boolean;
      break;
    case 3: 
      bool = paramObject instanceof Double;
      break;
    case 2: 
      bool = paramObject instanceof Float;
      break;
    case 1: 
      bool = paramObject instanceof Long;
      break;
    case 0: 
      bool = paramObject instanceof Integer;
    }
    if (bool) {
      label186:
      return;
    }
    label187:
    throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[] { Integer.valueOf(paramT.zza()), paramT.zzb().zza(), paramObject.getClass().getName() }));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzju)) {
      return false;
    }
    paramObject = (zzju)paramObject;
    return this.zza.equals(((zzju)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final void zzb()
  {
    if (this.zzb) {
      return;
    }
    this.zza.zza();
    this.zzb = true;
  }
  
  public final void zzc(T paramT, Object paramObject)
  {
    if (paramT.zzc())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        int i = localArrayList.size();
        for (int j = 0; j < i; j++) {
          zzd(paramT, localArrayList.get(j));
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      zzd(paramT, paramObject);
    }
    if ((paramObject instanceof zzkp)) {
      this.zzc = true;
    }
    this.zza.zzf(paramT, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */