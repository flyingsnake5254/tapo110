package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzem
  extends zzdw
{
  private static final Logger zzb = Logger.getLogger(zzem.class.getName());
  private static final boolean zzc = zzhw.zza();
  zzeo zza;
  
  public static int zza(int paramInt, zzfq paramzzfq)
  {
    paramInt = zze(paramInt);
    int i = paramzzfq.zzb();
    return paramInt + (zzg(i) + i);
  }
  
  public static int zza(zzfq paramzzfq)
  {
    int i = paramzzfq.zzb();
    return zzg(i) + i;
  }
  
  static int zza(zzgh paramzzgh, zzgy paramzzgy)
  {
    paramzzgh = (zzdq)paramzzgh;
    int i = paramzzgh.zzg();
    int j = i;
    if (i == -1)
    {
      j = paramzzgy.zzb(paramzzgh);
      paramzzgh.zza(j);
    }
    return zzg(j) + j;
  }
  
  public static zzem zza(byte[] paramArrayOfByte)
  {
    return new zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzb(double paramDouble)
  {
    return 8;
  }
  
  public static int zzb(float paramFloat)
  {
    return 4;
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zze(paramInt) + 8;
  }
  
  public static int zzb(int paramInt, float paramFloat)
  {
    return zze(paramInt) + 4;
  }
  
  public static int zzb(int paramInt, zzfq paramzzfq)
  {
    return (zze(1) << 1) + zzg(2, paramInt) + zza(3, paramzzfq);
  }
  
  public static int zzb(int paramInt, zzgh paramzzgh)
  {
    return (zze(1) << 1) + zzg(2, paramInt) + (zze(3) + zzb(paramzzgh));
  }
  
  static int zzb(int paramInt, zzgh paramzzgh, zzgy paramzzgy)
  {
    return zze(paramInt) + zza(paramzzgh, paramzzgy);
  }
  
  public static int zzb(int paramInt, String paramString)
  {
    return zze(paramInt) + zzb(paramString);
  }
  
  public static int zzb(int paramInt, boolean paramBoolean)
  {
    return zze(paramInt) + 1;
  }
  
  public static int zzb(zzdv paramzzdv)
  {
    int i = paramzzdv.zza();
    return zzg(i) + i;
  }
  
  public static int zzb(zzgh paramzzgh)
  {
    int i = paramzzgh.zzj();
    return zzg(i) + i;
  }
  
  public static int zzb(String paramString)
  {
    int i;
    try
    {
      i = zzhy.zza(paramString);
    }
    catch (zzhz localzzhz)
    {
      i = paramString.getBytes(zzfc.zza).length;
    }
    return zzg(i) + i;
  }
  
  public static int zzb(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int zzb(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return zzg(i) + i;
  }
  
  public static int zzc(int paramInt, zzdv paramzzdv)
  {
    paramInt = zze(paramInt);
    int i = paramzzdv.zza();
    return paramInt + (zzg(i) + i);
  }
  
  @Deprecated
  static int zzc(int paramInt, zzgh paramzzgh, zzgy paramzzgy)
  {
    int i = zze(paramInt);
    paramzzgh = (zzdq)paramzzgh;
    int j = paramzzgh.zzg();
    paramInt = j;
    if (j == -1)
    {
      paramInt = paramzzgy.zzb(paramzzgh);
      paramzzgh.zza(paramInt);
    }
    return (i << 1) + paramInt;
  }
  
  @Deprecated
  public static int zzc(zzgh paramzzgh)
  {
    return paramzzgh.zzj();
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zze(paramInt) + zze(paramLong);
  }
  
  public static int zzd(int paramInt, zzdv paramzzdv)
  {
    return (zze(1) << 1) + zzg(2, paramInt) + zzc(3, paramzzdv);
  }
  
  public static int zzd(long paramLong)
  {
    return zze(paramLong);
  }
  
  public static int zze(int paramInt)
  {
    return zzg(paramInt << 3);
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zze(paramInt) + zze(paramLong);
  }
  
  public static int zze(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0xFFFFFFF800000000 & paramLong) != 0L)
    {
      i = 6;
      paramLong >>>= 28;
    }
    else
    {
      i = 2;
    }
    int j = i;
    long l = paramLong;
    if ((0xFFFFFFFFFFE00000 & paramLong) != 0L)
    {
      j = i + 2;
      l = paramLong >>> 14;
    }
    int i = j;
    if ((l & 0xFFFFFFFFFFFFC000) != 0L) {
      i = j + 1;
    }
    return i;
  }
  
  public static int zzf(int paramInt)
  {
    if (paramInt >= 0) {
      return zzg(paramInt);
    }
    return 10;
  }
  
  public static int zzf(int paramInt1, int paramInt2)
  {
    return zze(paramInt1) + zzf(paramInt2);
  }
  
  public static int zzf(int paramInt, long paramLong)
  {
    return zze(paramInt) + zze(zzi(paramLong));
  }
  
  public static int zzf(long paramLong)
  {
    return zze(zzi(paramLong));
  }
  
  public static int zzg(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzg(int paramInt1, int paramInt2)
  {
    return zze(paramInt1) + zzg(paramInt2);
  }
  
  public static int zzg(int paramInt, long paramLong)
  {
    return zze(paramInt) + 8;
  }
  
  public static int zzg(long paramLong)
  {
    return 8;
  }
  
  public static int zzh(int paramInt)
  {
    return zzg(zzm(paramInt));
  }
  
  public static int zzh(int paramInt1, int paramInt2)
  {
    return zze(paramInt1) + zzg(zzm(paramInt2));
  }
  
  public static int zzh(int paramInt, long paramLong)
  {
    return zze(paramInt) + 8;
  }
  
  public static int zzh(long paramLong)
  {
    return 8;
  }
  
  public static int zzi(int paramInt)
  {
    return 4;
  }
  
  public static int zzi(int paramInt1, int paramInt2)
  {
    return zze(paramInt1) + 4;
  }
  
  private static long zzi(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int zzj(int paramInt)
  {
    return 4;
  }
  
  public static int zzj(int paramInt1, int paramInt2)
  {
    return zze(paramInt1) + 4;
  }
  
  public static int zzk(int paramInt)
  {
    return zzf(paramInt);
  }
  
  public static int zzk(int paramInt1, int paramInt2)
  {
    return zze(paramInt1) + zzf(paramInt2);
  }
  
  @Deprecated
  public static int zzl(int paramInt)
  {
    return zzg(paramInt);
  }
  
  private static int zzm(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public abstract int zza();
  
  public abstract void zza(byte paramByte)
    throws IOException;
  
  public final void zza(double paramDouble)
    throws IOException
  {
    zzc(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(float paramFloat)
    throws IOException
  {
    zzd(Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt)
    throws IOException;
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzc(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    zze(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zza(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zza(int paramInt, zzdv paramzzdv)
    throws IOException;
  
  public abstract void zza(int paramInt, zzgh paramzzgh)
    throws IOException;
  
  abstract void zza(int paramInt, zzgh paramzzgh, zzgy paramzzgy)
    throws IOException;
  
  public abstract void zza(int paramInt, String paramString)
    throws IOException;
  
  public abstract void zza(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void zza(long paramLong)
    throws IOException;
  
  public abstract void zza(zzdv paramzzdv)
    throws IOException;
  
  public abstract void zza(zzgh paramzzgh)
    throws IOException;
  
  public abstract void zza(String paramString)
    throws IOException;
  
  final void zza(String paramString, zzhz paramzzhz)
    throws IOException
  {
    zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzhz);
    paramString = paramString.getBytes(zzfc.zza);
    try
    {
      zzb(paramString.length);
      zza(paramString, 0, paramString.length);
      return;
    }
    catch (zza paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zza(paramString);
    }
  }
  
  public final void zza(boolean paramBoolean)
    throws IOException
  {
    zza((byte)paramBoolean);
  }
  
  public final void zzb()
  {
    if (zza() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public abstract void zzb(int paramInt)
    throws IOException;
  
  public abstract void zzb(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zza(paramInt, zzi(paramLong));
  }
  
  public abstract void zzb(int paramInt, zzdv paramzzdv)
    throws IOException;
  
  public final void zzb(long paramLong)
    throws IOException
  {
    zza(zzi(paramLong));
  }
  
  abstract void zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zzc(int paramInt)
    throws IOException
  {
    zzb(zzm(paramInt));
  }
  
  public abstract void zzc(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzc(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zzc(long paramLong)
    throws IOException;
  
  public abstract void zzd(int paramInt)
    throws IOException;
  
  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    zzc(paramInt1, zzm(paramInt2));
  }
  
  public abstract void zze(int paramInt1, int paramInt2)
    throws IOException;
  
  public static final class zza
    extends IOException
  {
    zza()
    {
      super();
    }
    
    zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    zza(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static final class zzb
    extends zzem
  {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;
    private int zze;
    
    zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      Objects.requireNonNull(paramArrayOfByte, "buffer");
      int i = paramArrayOfByte.length;
      paramInt1 = paramInt2 + 0;
      if ((paramInt2 | 0x0 | i - paramInt1) >= 0)
      {
        this.zzb = paramArrayOfByte;
        this.zzc = 0;
        this.zze = 0;
        this.zzd = paramInt1;
        return;
      }
      throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt2) }));
    }
    
    private final void zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.zzb, this.zze, paramInt2);
        this.zze += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new zzem.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final int zza()
    {
      return this.zzd - this.zze;
    }
    
    public final void zza(byte paramByte)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.zzb;
        int i = this.zze;
        this.zze = (i + 1);
        arrayOfByte[i] = ((byte)paramByte);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzem.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zza(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzb(paramInt);
        return;
      }
      zza(paramInt);
    }
    
    public final void zza(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1 << 3 | paramInt2);
    }
    
    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zza(paramInt, 0);
      zza(paramLong);
    }
    
    public final void zza(int paramInt, zzdv paramzzdv)
      throws IOException
    {
      zza(paramInt, 2);
      zza(paramzzdv);
    }
    
    public final void zza(int paramInt, zzgh paramzzgh)
      throws IOException
    {
      zza(1, 3);
      zzc(2, paramInt);
      zza(3, 2);
      zza(paramzzgh);
      zza(1, 4);
    }
    
    final void zza(int paramInt, zzgh paramzzgh, zzgy paramzzgy)
      throws IOException
    {
      zza(paramInt, 2);
      zzdq localzzdq = (zzdq)paramzzgh;
      int i = localzzdq.zzg();
      paramInt = i;
      if (i == -1)
      {
        paramInt = paramzzgy.zzb(localzzdq);
        localzzdq.zza(paramInt);
      }
      zzb(paramInt);
      paramzzgy.zza(paramzzgh, this.zza);
    }
    
    public final void zza(int paramInt, String paramString)
      throws IOException
    {
      zza(paramInt, 2);
      zza(paramString);
    }
    
    public final void zza(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zza(paramInt, 0);
      zza((byte)paramBoolean);
    }
    
    public final void zza(long paramLong)
      throws IOException
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (zzem.zzc())
      {
        l = paramLong;
        if (zza() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzhw.zza(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzhw.zza(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
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
          i = this.zze;
          this.zze = (i + 1);
          arrayOfByte[i] = ((byte)(byte)(int)l);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new zzem.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.zzb;
        i = this.zze;
        this.zze = (i + 1);
        arrayOfByte[i] = ((byte)(byte)((int)l & 0x7F | 0x80));
        l >>>= 7;
      }
    }
    
    public final void zza(zzdv paramzzdv)
      throws IOException
    {
      zzb(paramzzdv.zza());
      paramzzdv.zza(this);
    }
    
    public final void zza(zzgh paramzzgh)
      throws IOException
    {
      zzb(paramzzgh.zzj());
      paramzzgh.zza(this);
    }
    
    public final void zza(String paramString)
      throws IOException
    {
      int i = this.zze;
      try
      {
        int j = zzem.zzg(paramString.length() * 3);
        int k = zzem.zzg(paramString.length());
        if (k == j)
        {
          j = i + k;
          this.zze = j;
          j = zzhy.zza(paramString, this.zzb, j, zza());
          this.zze = i;
          zzb(j - i - k);
          this.zze = j;
          return;
        }
        zzb(zzhy.zza(paramString));
        this.zze = zzhy.zza(paramString, this.zzb, this.zze, zza());
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzem.zza(paramString);
      }
      catch (zzhz localzzhz)
      {
        this.zze = i;
        zza(paramString, localzzhz);
      }
    }
    
    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void zzb(int paramInt)
      throws IOException
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (zzem.zzc())
      {
        i = paramInt;
        if (!zzdt.zza())
        {
          i = paramInt;
          if (zza() >= 5)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzhw.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzhw.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzhw.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzhw.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzhw.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzhw.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzhw.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzhw.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzhw.zza(arrayOfByte, i, (byte)(paramInt >>> 7));
            return;
          }
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0) {}
        try
        {
          arrayOfByte = this.zzb;
          paramInt = this.zze;
          this.zze = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)(byte)i);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new zzem.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.zzb;
        paramInt = this.zze;
        this.zze = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
    }
    
    public final void zzb(int paramInt1, int paramInt2)
      throws IOException
    {
      zza(paramInt1, 0);
      zza(paramInt2);
    }
    
    public final void zzb(int paramInt, zzdv paramzzdv)
      throws IOException
    {
      zza(1, 3);
      zzc(2, paramInt);
      zza(3, paramzzdv);
      zza(1, 4);
    }
    
    public final void zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt2);
      zzc(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zza(paramInt1, 0);
      zzb(paramInt2);
    }
    
    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zza(paramInt, 1);
      zzc(paramLong);
    }
    
    public final void zzc(long paramLong)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.zzb;
        int i = this.zze;
        int j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(byte)(int)paramLong);
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 8));
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 16));
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 24));
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 32));
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 40));
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 48));
        this.zze = (j + 1);
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 56));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzem.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zzd(int paramInt)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.zzb;
        int i = this.zze;
        int j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(byte)paramInt);
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(byte)(paramInt >> 8));
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(byte)(paramInt >> 16));
        this.zze = (j + 1);
        arrayOfByte[j] = ((byte)(byte)(paramInt >>> 24));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzem.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zze(int paramInt1, int paramInt2)
      throws IOException
    {
      zza(paramInt1, 5);
      zzd(paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */