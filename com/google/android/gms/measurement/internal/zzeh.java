package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzeh
  extends zzgo
{
  protected static final AtomicReference<String[]> zza = new AtomicReference();
  protected static final AtomicReference<String[]> zzb = new AtomicReference();
  protected static final AtomicReference<String[]> zzc = new AtomicReference();
  
  zzeh(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  private static final String zzi(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, AtomicReference<String[]> paramAtomicReference)
  {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    Preconditions.checkNotNull(paramAtomicReference);
    int i = paramArrayOfString1.length;
    int j = paramArrayOfString2.length;
    int k = 0;
    boolean bool;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    while (k < paramArrayOfString1.length)
    {
      if (zzku.zzS(paramString, paramArrayOfString1[k])) {
        try
        {
          Object localObject1 = (String[])paramAtomicReference.get();
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            paramString = new String[paramArrayOfString2.length];
            paramAtomicReference.set(paramString);
          }
          Object localObject2 = paramString[k];
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            ((StringBuilder)localObject1).append(paramArrayOfString2[k]);
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(paramArrayOfString1[k]);
            ((StringBuilder)localObject1).append(")");
            localObject1 = ((StringBuilder)localObject1).toString();
            paramString[k] = localObject1;
          }
          return (String)localObject1;
        }
        finally {}
      }
      k++;
    }
    return paramString;
  }
  
  protected final boolean zza()
  {
    return false;
  }
  
  protected final boolean zzb()
  {
    this.zzs.zzat();
    return (this.zzs.zzq()) && (Log.isLoggable(this.zzs.zzau().zzn(), 3));
  }
  
  protected final String zzc(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzb()) {
      return paramString;
    }
    return zzi(paramString, zzgr.zzc, zzgr.zza, zza);
  }
  
  protected final String zzd(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzb()) {
      return paramString;
    }
    return zzi(paramString, zzgs.zzb, zzgs.zza, zzb);
  }
  
  protected final String zze(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzb()) {
      return paramString;
    }
    if (paramString.startsWith("_exp_"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("experiment_id(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return zzi(paramString, zzgt.zzb, zzgt.zza, zzc);
  }
  
  protected final String zzf(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    if (!zzb()) {
      return paramBundle.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bundle[{");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (localStringBuilder.length() != 8) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(zzd((String)localObject));
      localStringBuilder.append("=");
      localObject = paramBundle.get((String)localObject);
      if ((localObject instanceof Bundle)) {
        localObject = zzh(new Object[] { localObject });
      } else if ((localObject instanceof Object[])) {
        localObject = zzh((Object[])localObject);
      } else if ((localObject instanceof ArrayList)) {
        localObject = zzh(((ArrayList)localObject).toArray());
      } else {
        localObject = String.valueOf(localObject);
      }
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append("}]");
    return localStringBuilder.toString();
  }
  
  protected final String zzh(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfObject[j];
      if ((localObject instanceof Bundle)) {
        localObject = zzf((Bundle)localObject);
      } else {
        localObject = String.valueOf(localObject);
      }
      if (localObject != null)
      {
        if (localStringBuilder.length() != 1) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append((String)localObject);
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */