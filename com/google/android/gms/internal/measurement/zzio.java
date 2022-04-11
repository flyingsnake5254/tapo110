package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzio<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>>
  implements zzli
{
  protected int zzb = 0;
  
  protected static <T> void zzbs(Iterable<T> paramIterable, List<? super T> paramList)
  {
    zzkl.zza(paramIterable);
    Object localObject;
    int i;
    int j;
    if ((paramIterable instanceof zzks))
    {
      localObject = ((zzks)paramIterable).zzh();
      paramIterable = (zzks)paramList;
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
          j = paramIterable.size();
          for (;;)
          {
            j--;
            if (j < i) {
              break;
            }
            paramIterable.remove(j);
          }
          throw new NullPointerException(paramList);
        }
        if ((paramList instanceof zzjd)) {
          paramIterable.zzf((zzjd)paramList);
        } else {
          paramIterable.add((String)paramList);
        }
      }
    }
    if (!(paramIterable instanceof zzlp))
    {
      if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection))) {
        ((ArrayList)paramList).ensureCapacity(paramList.size() + paramIterable.size());
      }
      i = paramList.size();
      localObject = paramIterable.iterator();
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
          j = paramList.size();
          for (;;)
          {
            j--;
            if (j < i) {
              break;
            }
            paramList.remove(j);
          }
          throw new NullPointerException(paramIterable);
        }
        paramList.add(paramIterable);
      }
      return;
    }
    paramList.addAll(paramIterable);
  }
  
  public final zzjd zzbo()
  {
    try
    {
      int i = zzbw();
      localObject = zzjd.zzb;
      localObject = new byte[i];
      zzjk localzzjk = zzjk.zzt((byte[])localObject);
      zzbv(localzzjk);
      localzzjk.zzC();
      localObject = new zzjb((byte[])localObject);
      return (zzjd)localObject;
    }
    catch (IOException localIOException)
    {
      Object localObject = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 72);
      localStringBuilder.append("Serializing ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" to a ByteString threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public final byte[] zzbp()
  {
    try
    {
      localObject1 = new byte[zzbw()];
      localObject2 = zzjk.zzt((byte[])localObject1);
      zzbv((zzjk)localObject2);
      ((zzjk)localObject2).zzC();
      return (byte[])localObject1;
    }
    catch (IOException localIOException)
    {
      Object localObject2 = getClass().getName();
      Object localObject1 = new StringBuilder(((String)localObject2).length() + 72);
      ((StringBuilder)localObject1).append("Serializing ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" to a byte array threw an IOException (should never happen).");
      throw new RuntimeException(((StringBuilder)localObject1).toString(), localIOException);
    }
  }
  
  int zzbq()
  {
    throw null;
  }
  
  void zzbr(int paramInt)
  {
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */