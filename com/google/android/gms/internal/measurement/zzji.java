package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzji
  extends zzjk
{
  private final byte[] zzb;
  private final int zzc;
  private int zzd;
  
  zzji(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(null);
    paramInt1 = paramArrayOfByte.length;
    if ((paramInt1 - paramInt2 | paramInt2) >= 0)
    {
      this.zzb = paramArrayOfByte;
      this.zzd = 0;
      this.zzc = paramInt2;
      return;
    }
    throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2) }));
  }
  
  public final void zza(int paramInt1, int paramInt2)
    throws IOException
  {
    zzl(paramInt1 << 3 | paramInt2);
  }
  
  public final void zzb(int paramInt1, int paramInt2)
    throws IOException
  {
    zzl(paramInt1 << 3);
    zzk(paramInt2);
  }
  
  public final void zzc(int paramInt1, int paramInt2)
    throws IOException
  {
    zzl(paramInt1 << 3);
    zzl(paramInt2);
  }
  
  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    zzl(paramInt1 << 3 | 0x5);
    zzm(paramInt2);
  }
  
  public final void zze(int paramInt, long paramLong)
    throws IOException
  {
    zzl(paramInt << 3);
    zzn(paramLong);
  }
  
  public final void zzf(int paramInt, long paramLong)
    throws IOException
  {
    zzl(paramInt << 3 | 0x1);
    zzo(paramLong);
  }
  
  public final void zzg(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzl(paramInt << 3);
    zzj(paramBoolean);
  }
  
  public final void zzh(int paramInt, String paramString)
    throws IOException
  {
    zzl(paramInt << 3 | 0x2);
    zzr(paramString);
  }
  
  public final void zzi(int paramInt, zzjd paramzzjd)
    throws IOException
  {
    zzl(paramInt << 3 | 0x2);
    zzl(paramzzjd.zzc());
    paramzzjd.zzf(this);
  }
  
  public final void zzj(byte paramByte)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.zzb;
      int i = this.zzd;
      this.zzd = (i + 1);
      arrayOfByte[i] = ((byte)paramByte);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(1) }), localIndexOutOfBoundsException);
    }
  }
  
  public final void zzk(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      zzl(paramInt);
      return;
    }
    zzn(paramInt);
  }
  
  public final void zzl(int paramInt)
    throws IOException
  {
    int i = paramInt;
    if (zzjk.zzF())
    {
      i = zziq.zza;
      i = paramInt;
    }
    for (;;)
    {
      if ((i & 0xFFFFFF80) == 0) {}
      try
      {
        arrayOfByte = this.zzb;
        paramInt = this.zzd;
        this.zzd = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(byte)i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        byte[] arrayOfByte;
        throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
      arrayOfByte = this.zzb;
      paramInt = this.zzd;
      this.zzd = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)(byte)(i & 0x7F | 0x80));
      i >>>= 7;
    }
  }
  
  public final void zzm(int paramInt)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.zzb;
      int i = this.zzd;
      int j = i + 1;
      this.zzd = j;
      arrayOfByte[i] = ((byte)(byte)(paramInt & 0xFF));
      i = j + 1;
      this.zzd = i;
      arrayOfByte[j] = ((byte)(byte)(paramInt >> 8 & 0xFF));
      j = i + 1;
      this.zzd = j;
      arrayOfByte[i] = ((byte)(byte)(paramInt >> 16 & 0xFF));
      this.zzd = (j + 1);
      arrayOfByte[j] = ((byte)(byte)(paramInt >> 24 & 0xFF));
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(1) }), localIndexOutOfBoundsException);
    }
  }
  
  public final void zzn(long paramLong)
    throws IOException
  {
    long l = paramLong;
    byte[] arrayOfByte;
    int i;
    if (zzjk.zzF())
    {
      l = paramLong;
      if (this.zzc - this.zzd >= 10) {
        for (;;)
        {
          if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
          {
            arrayOfByte = this.zzb;
            i = this.zzd;
            this.zzd = (i + 1);
            zzmr.zzp(arrayOfByte, i, (byte)(int)paramLong);
            return;
          }
          arrayOfByte = this.zzb;
          i = this.zzd;
          this.zzd = (i + 1);
          zzmr.zzp(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
    }
    for (;;)
    {
      if ((l & 0xFFFFFFFFFFFFFF80) == 0L) {}
      try
      {
        arrayOfByte = this.zzb;
        i = this.zzd;
        this.zzd = (i + 1);
        arrayOfByte[i] = ((byte)(byte)(int)l);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
      arrayOfByte = this.zzb;
      i = this.zzd;
      this.zzd = (i + 1);
      arrayOfByte[i] = ((byte)(byte)((int)l & 0x7F | 0x80));
      l >>>= 7;
    }
  }
  
  public final void zzo(long paramLong)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.zzb;
      int i = this.zzd;
      int j = i + 1;
      this.zzd = j;
      arrayOfByte[i] = ((byte)(byte)((int)paramLong & 0xFF));
      i = j + 1;
      this.zzd = i;
      arrayOfByte[j] = ((byte)(byte)((int)(paramLong >> 8) & 0xFF));
      j = i + 1;
      this.zzd = j;
      arrayOfByte[i] = ((byte)(byte)((int)(paramLong >> 16) & 0xFF));
      i = j + 1;
      this.zzd = i;
      arrayOfByte[j] = ((byte)(byte)((int)(paramLong >> 24) & 0xFF));
      j = i + 1;
      this.zzd = j;
      arrayOfByte[i] = ((byte)(byte)((int)(paramLong >> 32) & 0xFF));
      i = j + 1;
      this.zzd = i;
      arrayOfByte[j] = ((byte)(byte)((int)(paramLong >> 40) & 0xFF));
      j = i + 1;
      this.zzd = j;
      arrayOfByte[i] = ((byte)(byte)((int)(paramLong >> 48) & 0xFF));
      this.zzd = (j + 1);
      arrayOfByte[j] = ((byte)(byte)((int)(paramLong >> 56) & 0xFF));
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(1) }), localIndexOutOfBoundsException);
    }
  }
  
  public final void zzp(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      System.arraycopy(paramArrayOfByte, 0, this.zzb, this.zzd, paramInt2);
      this.zzd += paramInt2;
      return;
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(paramInt2) }), paramArrayOfByte);
    }
  }
  
  public final void zzq(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    zzp(paramArrayOfByte, 0, paramInt2);
  }
  
  public final void zzr(String paramString)
    throws IOException
  {
    int i = this.zzd;
    try
    {
      int j = zzjk.zzw(paramString.length() * 3);
      int k = zzjk.zzw(paramString.length());
      if (k == j)
      {
        j = i + k;
        this.zzd = j;
        j = zzmw.zzd(paramString, this.zzb, j, this.zzc - j);
        this.zzd = i;
        zzl(j - i - k);
        this.zzd = j;
        return;
      }
      zzl(zzmw.zzc(paramString));
      byte[] arrayOfByte = this.zzb;
      k = this.zzd;
      this.zzd = zzmw.zzd(paramString, arrayOfByte, k, this.zzc - k);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzjj(paramString);
    }
    catch (zzmv localzzmv)
    {
      this.zzd = i;
      zzD(paramString, localzzmv);
    }
  }
  
  public final int zzs()
  {
    return this.zzc - this.zzd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */