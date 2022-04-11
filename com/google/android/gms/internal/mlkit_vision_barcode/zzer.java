package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzer<MessageType extends zzer<MessageType, BuilderType>, BuilderType extends zzeq<MessageType, BuilderType>>
  implements zzhk
{
  protected int zza = 0;
  
  protected static <T> void zza(Iterable<T> paramIterable, List<? super T> paramList)
  {
    zzgc.zza(paramIterable);
    Object localObject;
    int j;
    if ((paramIterable instanceof zzgv))
    {
      localObject = ((zzgv)paramIterable).zzd();
      paramIterable = (zzgv)paramList;
      i = paramList.size();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = ((Iterator)localObject).next();
        if (paramList == null)
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
        if ((paramList instanceof zzew)) {
          paramIterable.zza((zzew)paramList);
        } else {
          paramIterable.add((String)paramList);
        }
      }
      return;
    }
    if ((paramIterable instanceof zzhx))
    {
      paramList.addAll((Collection)paramIterable);
      return;
    }
    if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection))) {
      ((ArrayList)paramList).ensureCapacity(paramList.size() + ((Collection)paramIterable).size());
    }
    int i = paramList.size();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localObject = paramIterable.next();
      if (localObject == null)
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
      paramList.add(localObject);
    }
  }
  
  void zza(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final zzew zze()
  {
    try
    {
      localObject = zzew.zzc(zzj());
      zza(((zzfe)localObject).zzb());
      localObject = ((zzfe)localObject).zza();
      return (zzew)localObject;
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
      zzfn localzzfn = zzfn.zza((byte[])localObject);
      zza(localzzfn);
      localzzfn.zzb();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      Object localObject = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 62 + "byte array".length());
      localStringBuilder.append("Serializing ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" to a ");
      localStringBuilder.append("byte array");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  int zzg()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */