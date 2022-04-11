package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

final class zzk
  extends FilterInputStream
{
  private long zza;
  private long zzb = -1L;
  
  zzk(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    Objects.requireNonNull(paramInputStream);
    this.zza = 1048577L;
  }
  
  public final int available()
    throws IOException
  {
    return (int)Math.min(this.in.available(), this.zza);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      this.zzb = this.zza;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int read()
    throws IOException
  {
    if (this.zza == 0L) {
      return -1;
    }
    int i = this.in.read();
    if (i != -1) {
      this.zza -= 1L;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l = this.zza;
    if (l == 0L) {
      return -1;
    }
    l = Math.min(paramInt2, l);
    paramInt1 = this.in.read(paramArrayOfByte, paramInt1, (int)l);
    if (paramInt1 != -1) {
      this.zza -= paramInt1;
    }
    return paramInt1;
  }
  
  public final void reset()
    throws IOException
  {
    try
    {
      if (this.in.markSupported())
      {
        if (this.zzb != -1L)
        {
          this.in.reset();
          this.zza = this.zzb;
          return;
        }
        localIOException = new java/io/IOException;
        localIOException.<init>("Mark not set");
        throw localIOException;
      }
      IOException localIOException = new java/io/IOException;
      localIOException.<init>("Mark not supported");
      throw localIOException;
    }
    finally {}
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    paramLong = Math.min(paramLong, this.zza);
    paramLong = this.in.skip(paramLong);
    this.zza -= paramLong;
    return paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */