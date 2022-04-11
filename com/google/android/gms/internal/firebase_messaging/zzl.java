package com.google.android.gms.internal.firebase_messaging;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzl
{
  private static final OutputStream zza = new zzj();
  
  public static byte[] zza(InputStream paramInputStream)
    throws IOException
  {
    ArrayDeque localArrayDeque = new ArrayDeque(20);
    int i = 8192;
    int j = 0;
    while (j < 2147483639)
    {
      int k = Math.min(i, 2147483639 - j);
      byte[] arrayOfByte = new byte[k];
      localArrayDeque.add(arrayOfByte);
      int m = 0;
      while (m < k)
      {
        int n = paramInputStream.read(arrayOfByte, m, k - m);
        if (n == -1)
        {
          paramInputStream = zzc(localArrayDeque, j);
          break label165;
        }
        m += n;
        j += n;
      }
      long l = i;
      l += l;
      if (l > 2147483647L) {
        i = Integer.MAX_VALUE;
      } else if (l < -2147483648L) {
        i = Integer.MIN_VALUE;
      } else {
        i = (int)l;
      }
    }
    if (paramInputStream.read() == -1)
    {
      paramInputStream = zzc(localArrayDeque, 2147483639);
      label165:
      return paramInputStream;
    }
    throw new OutOfMemoryError("input is too large to fit in a byte array");
  }
  
  public static InputStream zzb(InputStream paramInputStream, long paramLong)
  {
    return new zzk(paramInputStream, 1048577L);
  }
  
  private static byte[] zzc(Queue<byte[]> paramQueue, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    int i = paramInt;
    while (i > 0)
    {
      byte[] arrayOfByte2 = (byte[])paramQueue.remove();
      int j = Math.min(i, arrayOfByte2.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt - i, j);
      i -= j;
    }
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */