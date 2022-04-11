package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class zzfx
  implements Cloneable
{
  private Object value;
  private zzfv<?, ?> zzrp;
  private List<Object> zzrq = new ArrayList();
  
  private final byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzen()];
    zza(zzfs.zzg(arrayOfByte));
    return arrayOfByte;
  }
  
  private final zzfx zzeq()
  {
    zzfx localzzfx = new zzfx();
    try
    {
      localzzfx.zzrp = this.zzrp;
      Object localObject1 = this.zzrq;
      if (localObject1 == null) {
        localzzfx.zzrq = null;
      } else {
        localzzfx.zzrq.addAll((Collection)localObject1);
      }
      localObject1 = this.value;
      if (localObject1 != null)
      {
        if ((localObject1 instanceof zzfz)) {
          localObject1 = (zzfz)((zzfz)localObject1).clone();
        }
        int i;
        int j;
        Object localObject2;
        for (;;)
        {
          localzzfx.value = localObject1;
          break label306;
          if ((localObject1 instanceof byte[]))
          {
            localObject1 = ((byte[])localObject1).clone();
          }
          else
          {
            boolean bool = localObject1 instanceof byte[][];
            i = 0;
            j = 0;
            if (bool)
            {
              localObject1 = (byte[][])localObject1;
              localObject2 = new byte[localObject1.length][];
              localzzfx.value = localObject2;
              while (j < localObject1.length)
              {
                localObject2[j] = ((byte[])localObject1[j].clone());
                j++;
              }
            }
            if ((localObject1 instanceof boolean[]))
            {
              localObject1 = ((boolean[])localObject1).clone();
            }
            else if ((localObject1 instanceof int[]))
            {
              localObject1 = ((int[])localObject1).clone();
            }
            else if ((localObject1 instanceof long[]))
            {
              localObject1 = ((long[])localObject1).clone();
            }
            else if ((localObject1 instanceof float[]))
            {
              localObject1 = ((float[])localObject1).clone();
            }
            else
            {
              if (!(localObject1 instanceof double[])) {
                break;
              }
              localObject1 = ((double[])localObject1).clone();
            }
          }
        }
        if ((localObject1 instanceof zzfz[]))
        {
          localObject2 = (zzfz[])localObject1;
          localObject1 = new zzfz[localObject2.length];
          localzzfx.value = localObject1;
          for (j = i; j < localObject2.length; j++) {
            localObject1[j] = ((zzfz)localObject2[j].clone());
          }
        }
      }
      label306:
      return localzzfx;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzfx)) {
      return false;
    }
    paramObject = (zzfx)paramObject;
    Object localObject;
    if ((this.value != null) && (((zzfx)paramObject).value != null))
    {
      localObject = this.zzrp;
      if (localObject != ((zzfx)paramObject).zzrp) {
        return false;
      }
      if (!((zzfv)localObject).zzrk.isArray()) {
        return this.value.equals(((zzfx)paramObject).value);
      }
      localObject = this.value;
      if ((localObject instanceof byte[])) {
        return Arrays.equals((byte[])localObject, (byte[])((zzfx)paramObject).value);
      }
      if ((localObject instanceof int[])) {
        return Arrays.equals((int[])localObject, (int[])((zzfx)paramObject).value);
      }
      if ((localObject instanceof long[])) {
        return Arrays.equals((long[])localObject, (long[])((zzfx)paramObject).value);
      }
      if ((localObject instanceof float[])) {
        return Arrays.equals((float[])localObject, (float[])((zzfx)paramObject).value);
      }
      if ((localObject instanceof double[])) {
        return Arrays.equals((double[])localObject, (double[])((zzfx)paramObject).value);
      }
      if ((localObject instanceof boolean[])) {
        return Arrays.equals((boolean[])localObject, (boolean[])((zzfx)paramObject).value);
      }
      return Arrays.deepEquals((Object[])localObject, (Object[])((zzfx)paramObject).value);
    }
    List localList = this.zzrq;
    if (localList != null)
    {
      localObject = ((zzfx)paramObject).zzrq;
      if (localObject != null) {
        return localList.equals(localObject);
      }
    }
    try
    {
      boolean bool = Arrays.equals(toByteArray(), ((zzfx)paramObject).toByteArray());
      return bool;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  final void zza(zzfs paramzzfs)
    throws IOException
  {
    if (this.value == null)
    {
      paramzzfs = this.zzrq.iterator();
      if (!paramzzfs.hasNext()) {
        return;
      }
      paramzzfs.next();
      throw new NoSuchMethodError();
    }
    throw new NoSuchMethodError();
  }
  
  final int zzen()
  {
    if (this.value == null)
    {
      Iterator localIterator = this.zzrq.iterator();
      if (!localIterator.hasNext()) {
        return 0;
      }
      localIterator.next();
      throw new NoSuchMethodError();
    }
    throw new NoSuchMethodError();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */