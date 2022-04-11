package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzdq<MessageType extends zzdq<MessageType, BuilderType>, BuilderType extends zzdp<MessageType, BuilderType>>
  implements zzgh
{
  protected int zza = 0;
  
  protected static <T> void zza(Iterable<T> paramIterable, List<? super T> paramList)
  {
    zzfc.zza(paramIterable);
    int j;
    if ((paramIterable instanceof zzfs))
    {
      localObject = ((zzfs)paramIterable).zzd();
      paramIterable = (zzfs)paramList;
      i = paramList.size();
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = paramList.next();
        if (localObject == null)
        {
          j = paramIterable.size();
          paramList = new StringBuilder(37);
          paramList.append("Element at index ");
          paramList.append(j - i);
          paramList.append(" is null.");
          paramList = paramList.toString();
          for (j = paramIterable.size() - 1; j >= i; j--) {
            paramIterable.remove(j);
          }
          throw new NullPointerException(paramList);
        }
        if ((localObject instanceof zzdv)) {
          paramIterable.zza((zzdv)localObject);
        } else {
          paramIterable.add((String)localObject);
        }
      }
      return;
    }
    if ((paramIterable instanceof zzgu))
    {
      paramList.addAll((Collection)paramIterable);
      return;
    }
    if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection))) {
      ((ArrayList)paramList).ensureCapacity(paramList.size() + ((Collection)paramIterable).size());
    }
    int i = paramList.size();
    Object localObject = paramIterable.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramIterable = ((Iterator)localObject).next();
      if (paramIterable == null)
      {
        j = paramList.size();
        paramIterable = new StringBuilder(37);
        paramIterable.append("Element at index ");
        paramIterable.append(j - i);
        paramIterable.append(" is null.");
        paramIterable = paramIterable.toString();
        for (j = paramList.size() - 1; j >= i; j--) {
          paramList.remove(j);
        }
        throw new NullPointerException(paramIterable);
      }
      paramList.add(paramIterable);
    }
  }
  
  void zza(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final zzdv zze()
  {
    try
    {
      localObject = zzdv.zzc(zzj());
      zza(((zzed)localObject).zzb());
      localObject = ((zzed)localObject).zza();
      return (zzdv)localObject;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      Object localObject = new StringBuilder(str.length() + 62 + "ByteString".length());
      ((StringBuilder)localObject).append("Serializing ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" to a ");
      ((StringBuilder)localObject).append("ByteString");
      ((StringBuilder)localObject).append(" threw an IOException (should never happen).");
      throw new RuntimeException(((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  public final byte[] zzf()
  {
    try
    {
      localObject = new byte[zzj()];
      zzem localzzem = zzem.zza((byte[])localObject);
      zza(localzzem);
      localzzem.zzb();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      Object localObject = new StringBuilder(str.length() + 62 + "byte array".length());
      ((StringBuilder)localObject).append("Serializing ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" to a ");
      ((StringBuilder)localObject).append("byte array");
      ((StringBuilder)localObject).append(" threw an IOException (should never happen).");
      throw new RuntimeException(((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  int zzg()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */