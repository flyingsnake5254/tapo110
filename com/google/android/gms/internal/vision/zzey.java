package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzey<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zzfb<MessageType, BuilderType>>
  implements zzih
{
  protected int zzrx = 0;
  
  protected static <T> void zza(Iterable<T> paramIterable, List<? super T> paramList)
  {
    zzgy.checkNotNull(paramIterable);
    Object localObject;
    int j;
    if ((paramIterable instanceof zzho))
    {
      localObject = ((zzho)paramIterable).zzgy();
      paramIterable = (zzho)paramList;
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
        if ((paramList instanceof zzfm)) {
          paramIterable.zzc((zzfm)paramList);
        } else {
          paramIterable.add((String)paramList);
        }
      }
      return;
    }
    if ((paramIterable instanceof zzit))
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
  
  public final byte[] toByteArray()
  {
    try
    {
      localObject1 = new byte[zzgg()];
      localObject2 = zzgf.zze((byte[])localObject1);
      zzb((zzgf)localObject2);
      ((zzgf)localObject2).zzfi();
      return (byte[])localObject1;
    }
    catch (IOException localIOException)
    {
      Object localObject1 = getClass().getName();
      Object localObject2 = new StringBuilder(((String)localObject1).length() + 62 + "byte array".length());
      ((StringBuilder)localObject2).append("Serializing ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" to a ");
      ((StringBuilder)localObject2).append("byte array");
      ((StringBuilder)localObject2).append(" threw an IOException (should never happen).");
      throw new RuntimeException(((StringBuilder)localObject2).toString(), localIOException);
    }
  }
  
  void zzae(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final zzfm zzdl()
  {
    try
    {
      localObject = zzfm.zzaq(zzgg());
      zzb(((zzfu)localObject).zzex());
      localObject = ((zzfu)localObject).zzew();
      return (zzfm)localObject;
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
  
  int zzdm()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */