package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzda<MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzdd<MessageType, BuilderType>>
  implements zzfv
{
  protected int zza = 0;
  
  protected static <T> void zza(Iterable<T> paramIterable, List<? super T> paramList)
  {
    zzem.zza(paramIterable);
    int j;
    if ((paramIterable instanceof zzfc))
    {
      localObject = ((zzfc)paramIterable).zzb();
      paramIterable = (zzfc)paramList;
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
        if ((paramList instanceof zzdj)) {
          paramIterable.zza((zzdj)paramList);
        } else {
          paramIterable.add((String)paramList);
        }
      }
      return;
    }
    if ((paramIterable instanceof zzge))
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
  
  public final zzdj zze()
  {
    try
    {
      localObject = zzdj.zzc(zzj());
      zza(((zzdr)localObject).zzb());
      localObject = ((zzdr)localObject).zza();
      return (zzdj)localObject;
    }
    catch (IOException localIOException)
    {
      Object localObject = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 62 + "ByteString".length());
      localStringBuilder.append("Serializing ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" to a ");
      localStringBuilder.append("ByteString");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public final byte[] zzf()
  {
    try
    {
      byte[] arrayOfByte = new byte[zzj()];
      localObject = zzdw.zza(arrayOfByte);
      zza((zzdw)localObject);
      ((zzdw)localObject).zzb();
      return arrayOfByte;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */