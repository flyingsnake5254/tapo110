package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgf
  extends zzfn
{
  private static final Logger logger = Logger.getLogger(zzgf.class.getName());
  private static final boolean zztg = zzju.zzik();
  zzgh zzth;
  
  public static int zza(int paramInt, zzhm paramzzhm)
  {
    paramInt = zzbb(paramInt);
    int i = paramzzhm.zzgg();
    return paramInt + (zzbd(i) + i);
  }
  
  public static int zza(zzhm paramzzhm)
  {
    int i = paramzzhm.zzgg();
    return zzbd(i) + i;
  }
  
  static int zza(zzih paramzzih, zziw paramzziw)
  {
    paramzzih = (zzey)paramzzih;
    int i = paramzzih.zzdm();
    int j = i;
    if (i == -1)
    {
      j = paramzziw.zzs(paramzzih);
      paramzzih.zzae(j);
    }
    return zzbd(j) + j;
  }
  
  private static long zzaa(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int zzb(double paramDouble)
  {
    return 8;
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zzbb(paramInt) + 8;
  }
  
  public static int zzb(int paramInt, float paramFloat)
  {
    return zzbb(paramInt) + 4;
  }
  
  public static int zzb(int paramInt, zzhm paramzzhm)
  {
    return (zzbb(1) << 1) + zzm(2, paramInt) + zza(3, paramzzhm);
  }
  
  public static int zzb(int paramInt, zzih paramzzih)
  {
    return (zzbb(1) << 1) + zzm(2, paramInt) + (zzbb(3) + zzc(paramzzih));
  }
  
  static int zzb(int paramInt, zzih paramzzih, zziw paramzziw)
  {
    return zzbb(paramInt) + zza(paramzzih, paramzziw);
  }
  
  public static int zzb(int paramInt, String paramString)
  {
    return zzbb(paramInt) + zzy(paramString);
  }
  
  public static int zzb(int paramInt, boolean paramBoolean)
  {
    return zzbb(paramInt) + 1;
  }
  
  public static int zzb(zzfm paramzzfm)
  {
    int i = paramzzfm.size();
    return zzbd(i) + i;
  }
  
  public static int zzbb(int paramInt)
  {
    return zzbd(paramInt << 3);
  }
  
  public static int zzbc(int paramInt)
  {
    if (paramInt >= 0) {
      return zzbd(paramInt);
    }
    return 10;
  }
  
  public static int zzbd(int paramInt)
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
  
  public static int zzbe(int paramInt)
  {
    return zzbd(zzbi(paramInt));
  }
  
  public static int zzbf(int paramInt)
  {
    return 4;
  }
  
  public static int zzbg(int paramInt)
  {
    return 4;
  }
  
  public static int zzbh(int paramInt)
  {
    return zzbc(paramInt);
  }
  
  private static int zzbi(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  @Deprecated
  public static int zzbj(int paramInt)
  {
    return zzbd(paramInt);
  }
  
  public static int zzc(int paramInt, zzfm paramzzfm)
  {
    paramInt = zzbb(paramInt);
    int i = paramzzfm.size();
    return paramInt + (zzbd(i) + i);
  }
  
  @Deprecated
  static int zzc(int paramInt, zzih paramzzih, zziw paramzziw)
  {
    int i = zzbb(paramInt);
    paramzzih = (zzey)paramzzih;
    int j = paramzzih.zzdm();
    paramInt = j;
    if (j == -1)
    {
      paramInt = paramzziw.zzs(paramzzih);
      paramzzih.zzae(paramInt);
    }
    return (i << 1) + paramInt;
  }
  
  public static int zzc(zzih paramzzih)
  {
    int i = paramzzih.zzgg();
    return zzbd(i) + i;
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zzbb(paramInt) + zzw(paramLong);
  }
  
  public static int zzd(int paramInt, zzfm paramzzfm)
  {
    return (zzbb(1) << 1) + zzm(2, paramInt) + zzc(3, paramzzfm);
  }
  
  @Deprecated
  public static int zzd(zzih paramzzih)
  {
    return paramzzih.zzgg();
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zzbb(paramInt) + zzw(paramLong);
  }
  
  public static zzgf zze(byte[] paramArrayOfByte)
  {
    return new zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzf(int paramInt, long paramLong)
  {
    return zzbb(paramInt) + zzw(zzaa(paramLong));
  }
  
  public static int zzf(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return zzbd(i) + i;
  }
  
  public static int zzg(int paramInt, long paramLong)
  {
    return zzbb(paramInt) + 8;
  }
  
  public static int zzh(int paramInt, long paramLong)
  {
    return zzbb(paramInt) + 8;
  }
  
  public static int zzl(int paramInt1, int paramInt2)
  {
    return zzbb(paramInt1) + zzbc(paramInt2);
  }
  
  public static int zzl(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int zzm(int paramInt1, int paramInt2)
  {
    return zzbb(paramInt1) + zzbd(paramInt2);
  }
  
  public static int zzn(int paramInt1, int paramInt2)
  {
    return zzbb(paramInt1) + zzbd(zzbi(paramInt2));
  }
  
  public static int zzo(int paramInt1, int paramInt2)
  {
    return zzbb(paramInt1) + 4;
  }
  
  public static int zzp(int paramInt1, int paramInt2)
  {
    return zzbb(paramInt1) + 4;
  }
  
  public static int zzq(int paramInt1, int paramInt2)
  {
    return zzbb(paramInt1) + zzbc(paramInt2);
  }
  
  public static int zzt(float paramFloat)
  {
    return 4;
  }
  
  public static int zzv(long paramLong)
  {
    return zzw(paramLong);
  }
  
  public static int zzw(long paramLong)
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
  
  public static int zzx(long paramLong)
  {
    return zzw(zzaa(paramLong));
  }
  
  public static int zzy(long paramLong)
  {
    return 8;
  }
  
  public static int zzy(String paramString)
  {
    int i;
    try
    {
      i = zzjx.zza(paramString);
    }
    catch (zzka localzzka)
    {
      i = paramString.getBytes(zzgy.UTF_8).length;
    }
    return zzbd(i) + i;
  }
  
  public static int zzz(long paramLong)
  {
    return 8;
  }
  
  public abstract void writeTag(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zza(double paramDouble)
    throws IOException
  {
    zzu(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzc(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    zzk(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zza(int paramInt, zzfm paramzzfm)
    throws IOException;
  
  public abstract void zza(int paramInt, zzih paramzzih)
    throws IOException;
  
  abstract void zza(int paramInt, zzih paramzzih, zziw paramzziw)
    throws IOException;
  
  public abstract void zza(int paramInt, String paramString)
    throws IOException;
  
  public abstract void zza(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void zza(zzfm paramzzfm)
    throws IOException;
  
  final void zza(String paramString, zzka paramzzka)
    throws IOException
  {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzka);
    paramString = paramString.getBytes(zzgy.UTF_8);
    try
    {
      zzay(paramString.length);
      zzc(paramString, 0, paramString.length);
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
  
  public abstract void zzax(int paramInt)
    throws IOException;
  
  public abstract void zzay(int paramInt)
    throws IOException;
  
  public final void zzaz(int paramInt)
    throws IOException
  {
    zzay(zzbi(paramInt));
  }
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zza(paramInt, zzaa(paramLong));
  }
  
  public abstract void zzb(int paramInt, zzfm paramzzfm)
    throws IOException;
  
  public abstract void zzb(zzih paramzzih)
    throws IOException;
  
  public abstract void zzba(int paramInt)
    throws IOException;
  
  public abstract void zzc(byte paramByte)
    throws IOException;
  
  public abstract void zzc(int paramInt, long paramLong)
    throws IOException;
  
  abstract void zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract int zzfh();
  
  public final void zzfi()
  {
    if (zzfh() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public abstract void zzh(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzi(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zzj(int paramInt1, int paramInt2)
    throws IOException
  {
    zzi(paramInt1, zzbi(paramInt2));
  }
  
  public abstract void zzk(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zzk(boolean paramBoolean)
    throws IOException
  {
    zzc((byte)paramBoolean);
  }
  
  public final void zzs(float paramFloat)
    throws IOException
  {
    zzba(Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zzs(long paramLong)
    throws IOException;
  
  public final void zzt(long paramLong)
    throws IOException
  {
    zzs(zzaa(paramLong));
  }
  
  public abstract void zzu(long paramLong)
    throws IOException;
  
  public abstract void zzx(String paramString)
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
    extends zzgf
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;
    
    zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      Objects.requireNonNull(paramArrayOfByte, "buffer");
      paramInt1 = paramArrayOfByte.length;
      int i = paramInt2 + 0;
      if ((paramInt2 | 0x0 | paramInt1 - i) >= 0)
      {
        this.buffer = paramArrayOfByte;
        this.offset = 0;
        this.position = 0;
        this.limit = i;
        return;
      }
      throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt2) }));
    }
    
    private final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new zzgf.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void writeTag(int paramInt1, int paramInt2)
      throws IOException
    {
      zzay(paramInt1 << 3 | paramInt2);
    }
    
    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 0);
      zzs(paramLong);
    }
    
    public final void zza(int paramInt, zzfm paramzzfm)
      throws IOException
    {
      writeTag(paramInt, 2);
      zza(paramzzfm);
    }
    
    public final void zza(int paramInt, zzih paramzzih)
      throws IOException
    {
      writeTag(1, 3);
      zzi(2, paramInt);
      writeTag(3, 2);
      zzb(paramzzih);
      writeTag(1, 4);
    }
    
    final void zza(int paramInt, zzih paramzzih, zziw paramzziw)
      throws IOException
    {
      writeTag(paramInt, 2);
      zzey localzzey = (zzey)paramzzih;
      int i = localzzey.zzdm();
      paramInt = i;
      if (i == -1)
      {
        paramInt = paramzziw.zzs(localzzey);
        localzzey.zzae(paramInt);
      }
      zzay(paramInt);
      paramzziw.zza(paramzzih, this.zzth);
    }
    
    public final void zza(int paramInt, String paramString)
      throws IOException
    {
      writeTag(paramInt, 2);
      zzx(paramString);
    }
    
    public final void zza(int paramInt, boolean paramBoolean)
      throws IOException
    {
      writeTag(paramInt, 0);
      zzc((byte)paramBoolean);
    }
    
    public final void zza(zzfm paramzzfm)
      throws IOException
    {
      zzay(paramzzfm.size());
      paramzzfm.zza(this);
    }
    
    public final void zzax(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzay(paramInt);
        return;
      }
      zzs(paramInt);
    }
    
    public final void zzay(int paramInt)
      throws IOException
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (zzgf.zzfj())
      {
        i = paramInt;
        if (!zzff.zzds())
        {
          i = paramInt;
          if (zzfh() >= 5)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              zzju.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzju.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              zzju.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzju.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              zzju.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzju.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              zzju.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzju.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzju.zza(arrayOfByte, i, (byte)(paramInt >>> 7));
            return;
          }
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0) {}
        try
        {
          arrayOfByte = this.buffer;
          paramInt = this.position;
          this.position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)(byte)i);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new zzgf.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
    }
    
    public final void zzb(int paramInt, zzfm paramzzfm)
      throws IOException
    {
      writeTag(1, 3);
      zzi(2, paramInt);
      zza(3, paramzzfm);
      writeTag(1, 4);
    }
    
    public final void zzb(zzih paramzzih)
      throws IOException
    {
      zzay(paramzzih.zzgg());
      paramzzih.zzb(this);
    }
    
    public final void zzba(int paramInt)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        int j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(byte)paramInt);
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)(byte)(paramInt >> 8));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(byte)(paramInt >> 16));
        this.position = (j + 1);
        arrayOfByte[j] = ((byte)(byte)(paramInt >>> 24));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzgf.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zzc(byte paramByte)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)paramByte);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzgf.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 1);
      zzu(paramLong);
    }
    
    public final void zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzay(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }
    
    public final int zzfh()
    {
      return this.limit - this.position;
    }
    
    public final void zzh(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      zzax(paramInt2);
    }
    
    public final void zzi(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      zzay(paramInt2);
    }
    
    public final void zzk(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 5);
      zzba(paramInt2);
    }
    
    public final void zzs(long paramLong)
      throws IOException
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (zzgf.zzfj())
      {
        l = paramLong;
        if (zzfh() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              zzju.zza(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzju.zza(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
            paramLong >>>= 7;
          }
        }
      }
      for (;;)
      {
        if ((l & 0xFFFFFFFFFFFFFF80) == 0L) {}
        try
        {
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          arrayOfByte[i] = ((byte)(byte)(int)l);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new zzgf.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(byte)((int)l & 0x7F | 0x80));
        l >>>= 7;
      }
    }
    
    public final void zzu(long paramLong)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        int j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(byte)(int)paramLong);
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 8));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 16));
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 24));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 32));
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 40));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 48));
        this.position = (j + 1);
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 56));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzgf.zza(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zzx(String paramString)
      throws IOException
    {
      int i = this.position;
      try
      {
        int j = zzgf.zzbd(paramString.length() * 3);
        int k = zzgf.zzbd(paramString.length());
        if (k == j)
        {
          j = i + k;
          this.position = j;
          j = zzjx.zza(paramString, this.buffer, j, zzfh());
          this.position = i;
          zzay(j - i - k);
          this.position = j;
          return;
        }
        zzay(zzjx.zza(paramString));
        this.position = zzjx.zza(paramString, this.buffer, this.position, zzfh());
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzgf.zza(paramString);
      }
      catch (zzka localzzka)
      {
        this.position = i;
        zza(paramString, localzzka);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */