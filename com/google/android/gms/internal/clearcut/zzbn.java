package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbn
  extends zzba
{
  private static final Logger logger = Logger.getLogger(zzbn.class.getName());
  private static final boolean zzfy = zzfd.zzed();
  zzbp zzfz;
  
  public static int zza(int paramInt, zzcv paramzzcv)
  {
    paramInt = zzr(paramInt);
    int i = paramzzcv.zzas();
    return paramInt + (zzt(i) + i);
  }
  
  public static int zza(zzcv paramzzcv)
  {
    int i = paramzzcv.zzas();
    return zzt(i) + i;
  }
  
  public static zzbn zza(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray()) {
      return new zzb(paramByteBuffer);
    }
    if ((paramByteBuffer.isDirect()) && (!paramByteBuffer.isReadOnly()))
    {
      if (zzfd.zzee()) {
        return new zze(paramByteBuffer);
      }
      return new zzd(paramByteBuffer);
    }
    throw new IllegalArgumentException("ByteBuffer is read-only");
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
    return zzr(paramInt) + 8;
  }
  
  public static int zzb(int paramInt, float paramFloat)
  {
    return zzr(paramInt) + 4;
  }
  
  public static int zzb(int paramInt, zzcv paramzzcv)
  {
    return (zzr(1) << 1) + zzh(2, paramInt) + zza(3, paramzzcv);
  }
  
  static int zzb(int paramInt, zzdo paramzzdo, zzef paramzzef)
  {
    return zzr(paramInt) + zzb(paramzzdo, paramzzef);
  }
  
  public static int zzb(int paramInt, String paramString)
  {
    return zzr(paramInt) + zzh(paramString);
  }
  
  public static int zzb(zzbb paramzzbb)
  {
    int i = paramzzbb.size();
    return zzt(i) + i;
  }
  
  static int zzb(zzdo paramzzdo, zzef paramzzef)
  {
    paramzzdo = (zzas)paramzzdo;
    int i = paramzzdo.zzs();
    int j = i;
    if (i == -1)
    {
      j = paramzzef.zzm(paramzzdo);
      paramzzdo.zzf(j);
    }
    return zzt(j) + j;
  }
  
  public static int zzb(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int zzc(int paramInt, zzbb paramzzbb)
  {
    int i = zzr(paramInt);
    paramInt = paramzzbb.size();
    return i + (zzt(paramInt) + paramInt);
  }
  
  public static int zzc(int paramInt, zzdo paramzzdo)
  {
    return zzr(paramInt) + zzc(paramzzdo);
  }
  
  @Deprecated
  static int zzc(int paramInt, zzdo paramzzdo, zzef paramzzef)
  {
    int i = zzr(paramInt);
    paramzzdo = (zzas)paramzzdo;
    int j = paramzzdo.zzs();
    paramInt = j;
    if (j == -1)
    {
      paramInt = paramzzef.zzm(paramzzdo);
      paramzzdo.zzf(paramInt);
    }
    return (i << 1) + paramInt;
  }
  
  public static int zzc(int paramInt, boolean paramBoolean)
  {
    return zzr(paramInt) + 1;
  }
  
  public static int zzc(zzdo paramzzdo)
  {
    int i = paramzzdo.zzas();
    return zzt(i) + i;
  }
  
  public static zzbn zzc(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zzr(paramInt) + zzf(paramLong);
  }
  
  public static int zzd(int paramInt, zzbb paramzzbb)
  {
    return (zzr(1) << 1) + zzh(2, paramInt) + zzc(3, paramzzbb);
  }
  
  public static int zzd(int paramInt, zzdo paramzzdo)
  {
    return (zzr(1) << 1) + zzh(2, paramInt) + zzc(3, paramzzdo);
  }
  
  @Deprecated
  public static int zzd(zzdo paramzzdo)
  {
    return paramzzdo.zzas();
  }
  
  public static int zzd(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return zzt(i) + i;
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zzr(paramInt) + zzf(paramLong);
  }
  
  public static int zze(long paramLong)
  {
    return zzf(paramLong);
  }
  
  public static int zzf(int paramInt, long paramLong)
  {
    return zzr(paramInt) + zzf(zzj(paramLong));
  }
  
  public static int zzf(long paramLong)
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
  
  public static int zzg(int paramInt1, int paramInt2)
  {
    return zzr(paramInt1) + zzs(paramInt2);
  }
  
  public static int zzg(int paramInt, long paramLong)
  {
    return zzr(paramInt) + 8;
  }
  
  public static int zzg(long paramLong)
  {
    return zzf(zzj(paramLong));
  }
  
  public static int zzh(int paramInt1, int paramInt2)
  {
    return zzr(paramInt1) + zzt(paramInt2);
  }
  
  public static int zzh(int paramInt, long paramLong)
  {
    return zzr(paramInt) + 8;
  }
  
  public static int zzh(long paramLong)
  {
    return 8;
  }
  
  public static int zzh(String paramString)
  {
    int i;
    try
    {
      i = zzff.zza(paramString);
    }
    catch (zzfi localzzfi)
    {
      i = paramString.getBytes(zzci.UTF_8).length;
    }
    return zzt(i) + i;
  }
  
  public static int zzi(int paramInt1, int paramInt2)
  {
    return zzr(paramInt1) + zzt(zzy(paramInt2));
  }
  
  public static int zzi(long paramLong)
  {
    return 8;
  }
  
  public static int zzj(int paramInt1, int paramInt2)
  {
    return zzr(paramInt1) + 4;
  }
  
  private static long zzj(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int zzk(int paramInt1, int paramInt2)
  {
    return zzr(paramInt1) + 4;
  }
  
  public static int zzl(int paramInt1, int paramInt2)
  {
    return zzr(paramInt1) + zzs(paramInt2);
  }
  
  public static int zzr(int paramInt)
  {
    return zzt(paramInt << 3);
  }
  
  public static int zzs(int paramInt)
  {
    if (paramInt >= 0) {
      return zzt(paramInt);
    }
    return 10;
  }
  
  public static int zzt(int paramInt)
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
  
  public static int zzu(int paramInt)
  {
    return zzt(zzy(paramInt));
  }
  
  public static int zzv(int paramInt)
  {
    return 4;
  }
  
  public static int zzw(int paramInt)
  {
    return 4;
  }
  
  public static int zzx(int paramInt)
  {
    return zzs(paramInt);
  }
  
  private static int zzy(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  @Deprecated
  public static int zzz(int paramInt)
  {
    return zzt(paramInt);
  }
  
  public abstract void flush()
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zza(byte paramByte)
    throws IOException;
  
  public final void zza(double paramDouble)
    throws IOException
  {
    zzd(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(float paramFloat)
    throws IOException
  {
    zzq(Float.floatToRawIntBits(paramFloat));
  }
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzc(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    zzf(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zza(int paramInt, zzbb paramzzbb)
    throws IOException;
  
  public abstract void zza(int paramInt, zzdo paramzzdo)
    throws IOException;
  
  abstract void zza(int paramInt, zzdo paramzzdo, zzef paramzzef)
    throws IOException;
  
  public abstract void zza(int paramInt, String paramString)
    throws IOException;
  
  public abstract void zza(zzbb paramzzbb)
    throws IOException;
  
  abstract void zza(zzdo paramzzdo, zzef paramzzef)
    throws IOException;
  
  final void zza(String paramString, zzfi paramzzfi)
    throws IOException
  {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzfi);
    paramString = paramString.getBytes(zzci.UTF_8);
    try
    {
      zzo(paramString.length);
      zza(paramString, 0, paramString.length);
      return;
    }
    catch (zzc paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzc(paramString);
    }
  }
  
  public final void zza(boolean paramBoolean)
    throws IOException
  {
    zza((byte)paramBoolean);
  }
  
  public abstract int zzag();
  
  public abstract void zzb(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zza(paramInt, zzj(paramLong));
  }
  
  public abstract void zzb(int paramInt, zzbb paramzzbb)
    throws IOException;
  
  public abstract void zzb(int paramInt, zzdo paramzzdo)
    throws IOException;
  
  public abstract void zzb(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void zzb(long paramLong)
    throws IOException;
  
  public abstract void zzb(zzdo paramzzdo)
    throws IOException;
  
  public abstract void zzc(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzc(int paramInt, long paramLong)
    throws IOException;
  
  public final void zzc(long paramLong)
    throws IOException
  {
    zzb(zzj(paramLong));
  }
  
  public abstract void zzd(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzd(long paramLong)
    throws IOException;
  
  abstract void zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zze(int paramInt1, int paramInt2)
    throws IOException
  {
    zzd(paramInt1, zzy(paramInt2));
  }
  
  public abstract void zzf(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzg(String paramString)
    throws IOException;
  
  public abstract void zzn(int paramInt)
    throws IOException;
  
  public abstract void zzo(int paramInt)
    throws IOException;
  
  public final void zzp(int paramInt)
    throws IOException
  {
    zzo(zzy(paramInt));
  }
  
  public abstract void zzq(int paramInt)
    throws IOException;
  
  static class zza
    extends zzbn
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;
    
    zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      Objects.requireNonNull(paramArrayOfByte, "buffer");
      int i = paramArrayOfByte.length;
      int j = paramInt1 + paramInt2;
      if ((paramInt1 | paramInt2 | i - j) >= 0)
      {
        this.buffer = paramArrayOfByte;
        this.offset = paramInt1;
        this.position = paramInt1;
        this.limit = j;
        return;
      }
      throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    
    public void flush() {}
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void zza(byte paramByte)
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
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zzb(paramInt, 0);
      zzb(paramLong);
    }
    
    public final void zza(int paramInt, zzbb paramzzbb)
      throws IOException
    {
      zzb(paramInt, 2);
      zza(paramzzbb);
    }
    
    public final void zza(int paramInt, zzdo paramzzdo)
      throws IOException
    {
      zzb(paramInt, 2);
      zzb(paramzzdo);
    }
    
    final void zza(int paramInt, zzdo paramzzdo, zzef paramzzef)
      throws IOException
    {
      zzb(paramInt, 2);
      zzas localzzas = (zzas)paramzzdo;
      int i = localzzas.zzs();
      paramInt = i;
      if (i == -1)
      {
        paramInt = paramzzef.zzm(localzzas);
        localzzas.zzf(paramInt);
      }
      zzo(paramInt);
      paramzzef.zza(paramzzdo, this.zzfz);
    }
    
    public final void zza(int paramInt, String paramString)
      throws IOException
    {
      zzb(paramInt, 2);
      zzg(paramString);
    }
    
    public final void zza(zzbb paramzzbb)
      throws IOException
    {
      zzo(paramzzbb.size());
      paramzzbb.zza(this);
    }
    
    final void zza(zzdo paramzzdo, zzef paramzzef)
      throws IOException
    {
      zzas localzzas = (zzas)paramzzdo;
      int i = localzzas.zzs();
      int j = i;
      if (i == -1)
      {
        j = paramzzef.zzm(localzzas);
        localzzas.zzf(j);
      }
      zzo(j);
      paramzzef.zza(paramzzdo, this.zzfz);
    }
    
    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final int zzag()
    {
      return this.limit - this.position;
    }
    
    public final int zzai()
    {
      return this.position - this.offset;
    }
    
    public final void zzb(int paramInt1, int paramInt2)
      throws IOException
    {
      zzo(paramInt1 << 3 | paramInt2);
    }
    
    public final void zzb(int paramInt, zzbb paramzzbb)
      throws IOException
    {
      zzb(1, 3);
      zzd(2, paramInt);
      zza(3, paramzzbb);
      zzb(1, 4);
    }
    
    public final void zzb(int paramInt, zzdo paramzzdo)
      throws IOException
    {
      zzb(1, 3);
      zzd(2, paramInt);
      zza(3, paramzzdo);
      zzb(1, 4);
    }
    
    public final void zzb(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzb(paramInt, 0);
      zza((byte)paramBoolean);
    }
    
    public final void zzb(long paramLong)
      throws IOException
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (zzbn.zzah())
      {
        l = paramLong;
        if (zzag() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              zzfd.zza(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzfd.zza(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
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
          throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(byte)((int)l & 0x7F | 0x80));
        l >>>= 7;
      }
    }
    
    public final void zzb(zzdo paramzzdo)
      throws IOException
    {
      zzo(paramzzdo.zzas());
      paramzzdo.zzb(this);
    }
    
    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 0);
      zzn(paramInt2);
    }
    
    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zzb(paramInt, 1);
      zzd(paramLong);
    }
    
    public final void zzd(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 0);
      zzo(paramInt2);
    }
    
    public final void zzd(long paramLong)
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
        int k = j + 1;
        this.position = k;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 24));
        i = k + 1;
        this.position = i;
        arrayOfByte[k] = ((byte)(byte)(int)(paramLong >> 32));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 40));
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)(byte)(int)(paramLong >> 48));
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(byte)(int)(paramLong >> 56));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzo(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void zzf(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 5);
      zzq(paramInt2);
    }
    
    public final void zzg(String paramString)
      throws IOException
    {
      int i = this.position;
      try
      {
        int j = zzbn.zzt(paramString.length() * 3);
        int k = zzbn.zzt(paramString.length());
        if (k == j)
        {
          j = i + k;
          this.position = j;
          j = zzff.zza(paramString, this.buffer, j, zzag());
          this.position = i;
          zzo(j - i - k);
          this.position = j;
          return;
        }
        zzo(zzff.zza(paramString));
        this.position = zzff.zza(paramString, this.buffer, this.position, zzag());
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzbn.zzc(paramString);
      }
      catch (zzfi localzzfi)
      {
        this.position = i;
        zza(paramString, localzzfi);
      }
    }
    
    public final void zzn(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzo(paramInt);
        return;
      }
      zzb(paramInt);
    }
    
    public final void zzo(int paramInt)
      throws IOException
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (zzbn.zzah())
      {
        i = paramInt;
        if (zzag() >= 10) {
          for (;;)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              zzfd.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            zzfd.zza(arrayOfByte, i, (byte)(paramInt & 0x7F | 0x80));
            paramInt >>>= 7;
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
          throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
    }
    
    public final void zzq(int paramInt)
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
        arrayOfByte[j] = ((byte)(paramInt >> 24));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
  }
  
  static final class zzb
    extends zzbn.zza
  {
    private final ByteBuffer zzga;
    private int zzgb;
    
    zzb(ByteBuffer paramByteBuffer)
    {
      super(paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      this.zzga = paramByteBuffer;
      this.zzgb = paramByteBuffer.position();
    }
    
    public final void flush()
    {
      this.zzga.position(this.zzgb + zzai());
    }
  }
  
  public static final class zzc
    extends IOException
  {
    zzc()
    {
      super();
    }
    
    zzc(String paramString)
    {
      super();
    }
    
    zzc(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    zzc(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static final class zzd
    extends zzbn
  {
    private final int zzgb;
    private final ByteBuffer zzgc;
    private final ByteBuffer zzgd;
    
    zzd(ByteBuffer paramByteBuffer)
    {
      super();
      this.zzgc = paramByteBuffer;
      this.zzgd = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzgb = paramByteBuffer.position();
    }
    
    private final void zzi(String paramString)
      throws IOException
    {
      try
      {
        zzff.zza(paramString, this.zzgd);
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzbn.zzc(paramString);
      }
    }
    
    public final void flush()
    {
      this.zzgc.position(this.zzgd.position());
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        this.zzgd.put(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (BufferOverflowException paramArrayOfByte)
      {
        throw new zzbn.zzc(paramArrayOfByte);
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new zzbn.zzc(paramArrayOfByte);
      }
    }
    
    public final void zza(byte paramByte)
      throws IOException
    {
      try
      {
        this.zzgd.put(paramByte);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zzbn.zzc(localBufferOverflowException);
      }
    }
    
    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zzb(paramInt, 0);
      zzb(paramLong);
    }
    
    public final void zza(int paramInt, zzbb paramzzbb)
      throws IOException
    {
      zzb(paramInt, 2);
      zza(paramzzbb);
    }
    
    public final void zza(int paramInt, zzdo paramzzdo)
      throws IOException
    {
      zzb(paramInt, 2);
      zzb(paramzzdo);
    }
    
    final void zza(int paramInt, zzdo paramzzdo, zzef paramzzef)
      throws IOException
    {
      zzb(paramInt, 2);
      zza(paramzzdo, paramzzef);
    }
    
    public final void zza(int paramInt, String paramString)
      throws IOException
    {
      zzb(paramInt, 2);
      zzg(paramString);
    }
    
    public final void zza(zzbb paramzzbb)
      throws IOException
    {
      zzo(paramzzbb.size());
      paramzzbb.zza(this);
    }
    
    final void zza(zzdo paramzzdo, zzef paramzzef)
      throws IOException
    {
      zzas localzzas = (zzas)paramzzdo;
      int i = localzzas.zzs();
      int j = i;
      if (i == -1)
      {
        j = paramzzef.zzm(localzzas);
        localzzas.zzf(j);
      }
      zzo(j);
      paramzzef.zza(paramzzdo, this.zzfz);
    }
    
    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final int zzag()
    {
      return this.zzgd.remaining();
    }
    
    public final void zzb(int paramInt1, int paramInt2)
      throws IOException
    {
      zzo(paramInt1 << 3 | paramInt2);
    }
    
    public final void zzb(int paramInt, zzbb paramzzbb)
      throws IOException
    {
      zzb(1, 3);
      zzd(2, paramInt);
      zza(3, paramzzbb);
      zzb(1, 4);
    }
    
    public final void zzb(int paramInt, zzdo paramzzdo)
      throws IOException
    {
      zzb(1, 3);
      zzd(2, paramInt);
      zza(3, paramzzdo);
      zzb(1, 4);
    }
    
    public final void zzb(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzb(paramInt, 0);
      zza((byte)paramBoolean);
    }
    
    public final void zzb(long paramLong)
      throws IOException
    {
      for (;;)
      {
        if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {}
        try
        {
          this.zzgd.put((byte)(int)paramLong);
          return;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new zzbn.zzc(localBufferOverflowException);
        }
        this.zzgd.put((byte)((int)paramLong & 0x7F | 0x80));
        paramLong >>>= 7;
      }
    }
    
    public final void zzb(zzdo paramzzdo)
      throws IOException
    {
      zzo(paramzzdo.zzas());
      paramzzdo.zzb(this);
    }
    
    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 0);
      zzn(paramInt2);
    }
    
    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zzb(paramInt, 1);
      zzd(paramLong);
    }
    
    public final void zzd(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 0);
      zzo(paramInt2);
    }
    
    public final void zzd(long paramLong)
      throws IOException
    {
      try
      {
        this.zzgd.putLong(paramLong);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zzbn.zzc(localBufferOverflowException);
      }
    }
    
    public final void zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzo(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void zzf(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 5);
      zzq(paramInt2);
    }
    
    public final void zzg(String paramString)
      throws IOException
    {
      int i = this.zzgd.position();
      try
      {
        int j = zzbn.zzt(paramString.length() * 3);
        int k = zzbn.zzt(paramString.length());
        if (k == j)
        {
          k = this.zzgd.position() + k;
          this.zzgd.position(k);
          zzi(paramString);
          j = this.zzgd.position();
          this.zzgd.position(i);
          zzo(j - k);
          this.zzgd.position(j);
          return;
        }
        zzo(zzff.zza(paramString));
        zzi(paramString);
        return;
      }
      catch (IllegalArgumentException paramString)
      {
        throw new zzbn.zzc(paramString);
      }
      catch (zzfi localzzfi)
      {
        this.zzgd.position(i);
        zza(paramString, localzzfi);
      }
    }
    
    public final void zzn(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzo(paramInt);
        return;
      }
      zzb(paramInt);
    }
    
    public final void zzo(int paramInt)
      throws IOException
    {
      for (;;)
      {
        if ((paramInt & 0xFFFFFF80) == 0) {}
        try
        {
          this.zzgd.put((byte)paramInt);
          return;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new zzbn.zzc(localBufferOverflowException);
        }
        this.zzgd.put((byte)(paramInt & 0x7F | 0x80));
        paramInt >>>= 7;
      }
    }
    
    public final void zzq(int paramInt)
      throws IOException
    {
      try
      {
        this.zzgd.putInt(paramInt);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zzbn.zzc(localBufferOverflowException);
      }
    }
  }
  
  static final class zze
    extends zzbn
  {
    private final ByteBuffer zzgc;
    private final ByteBuffer zzgd;
    private final long zzge;
    private final long zzgf;
    private final long zzgg;
    private final long zzgh;
    private long zzgi;
    
    zze(ByteBuffer paramByteBuffer)
    {
      super();
      this.zzgc = paramByteBuffer;
      this.zzgd = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      long l1 = zzfd.zzb(paramByteBuffer);
      this.zzge = l1;
      long l2 = paramByteBuffer.position() + l1;
      this.zzgf = l2;
      l1 += paramByteBuffer.limit();
      this.zzgg = l1;
      this.zzgh = (l1 - 10L);
      this.zzgi = l2;
    }
    
    private final void zzk(long paramLong)
    {
      this.zzgd.position((int)(paramLong - this.zzge));
    }
    
    public final void flush()
    {
      this.zzgc.position((int)(this.zzgi - this.zzge));
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if ((paramArrayOfByte != null) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramArrayOfByte.length - paramInt2 >= paramInt1))
      {
        long l1 = this.zzgg;
        long l2 = paramInt2;
        long l3 = this.zzgi;
        if (l1 - l2 >= l3)
        {
          zzfd.zza(paramArrayOfByte, paramInt1, l3, l2);
          this.zzgi += l2;
          return;
        }
      }
      Objects.requireNonNull(paramArrayOfByte, "value");
      throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), Integer.valueOf(paramInt2) }));
    }
    
    public final void zza(byte paramByte)
      throws IOException
    {
      long l = this.zzgi;
      if (l < this.zzgg)
      {
        this.zzgi = (1L + l);
        zzfd.zza(l, paramByte);
        return;
      }
      throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), Integer.valueOf(1) }));
    }
    
    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zzb(paramInt, 0);
      zzb(paramLong);
    }
    
    public final void zza(int paramInt, zzbb paramzzbb)
      throws IOException
    {
      zzb(paramInt, 2);
      zza(paramzzbb);
    }
    
    public final void zza(int paramInt, zzdo paramzzdo)
      throws IOException
    {
      zzb(paramInt, 2);
      zzb(paramzzdo);
    }
    
    final void zza(int paramInt, zzdo paramzzdo, zzef paramzzef)
      throws IOException
    {
      zzb(paramInt, 2);
      zza(paramzzdo, paramzzef);
    }
    
    public final void zza(int paramInt, String paramString)
      throws IOException
    {
      zzb(paramInt, 2);
      zzg(paramString);
    }
    
    public final void zza(zzbb paramzzbb)
      throws IOException
    {
      zzo(paramzzbb.size());
      paramzzbb.zza(this);
    }
    
    final void zza(zzdo paramzzdo, zzef paramzzef)
      throws IOException
    {
      zzas localzzas = (zzas)paramzzdo;
      int i = localzzas.zzs();
      int j = i;
      if (i == -1)
      {
        j = paramzzef.zzm(localzzas);
        localzzas.zzf(j);
      }
      zzo(j);
      paramzzef.zza(paramzzdo, this.zzfz);
    }
    
    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final int zzag()
    {
      return (int)(this.zzgg - this.zzgi);
    }
    
    public final void zzb(int paramInt1, int paramInt2)
      throws IOException
    {
      zzo(paramInt1 << 3 | paramInt2);
    }
    
    public final void zzb(int paramInt, zzbb paramzzbb)
      throws IOException
    {
      zzb(1, 3);
      zzd(2, paramInt);
      zza(3, paramzzbb);
      zzb(1, 4);
    }
    
    public final void zzb(int paramInt, zzdo paramzzdo)
      throws IOException
    {
      zzb(1, 3);
      zzd(2, paramInt);
      zza(3, paramzzdo);
      zzb(1, 4);
    }
    
    public final void zzb(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzb(paramInt, 0);
      zza((byte)paramBoolean);
    }
    
    public final void zzb(long paramLong)
      throws IOException
    {
      long l1 = paramLong;
      if (this.zzgi <= this.zzgh) {
        for (;;)
        {
          long l2 = this.zzgi;
          if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
          {
            l1 = paramLong;
            paramLong = l2;
            this.zzgi = (1L + paramLong);
            zzfd.zza(paramLong, (byte)(int)l1);
            return;
          }
          this.zzgi = (l2 + 1L);
          zzfd.zza(l2, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
      for (;;)
      {
        paramLong = this.zzgi;
        if (paramLong >= this.zzgg) {
          break label137;
        }
        if ((l1 & 0xFFFFFFFFFFFFFF80) == 0L) {
          break;
        }
        this.zzgi = (paramLong + 1L);
        zzfd.zza(paramLong, (byte)((int)l1 & 0x7F | 0x80));
        l1 >>>= 7;
      }
      label137:
      throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), Integer.valueOf(1) }));
    }
    
    public final void zzb(zzdo paramzzdo)
      throws IOException
    {
      zzo(paramzzdo.zzas());
      paramzzdo.zzb(this);
    }
    
    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 0);
      zzn(paramInt2);
    }
    
    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zzb(paramInt, 1);
      zzd(paramLong);
    }
    
    public final void zzd(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 0);
      zzo(paramInt2);
    }
    
    public final void zzd(long paramLong)
      throws IOException
    {
      this.zzgd.putLong((int)(this.zzgi - this.zzge), paramLong);
      this.zzgi += 8L;
    }
    
    public final void zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzo(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void zzf(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1, 5);
      zzq(paramInt2);
    }
    
    public final void zzg(String paramString)
      throws IOException
    {
      long l = this.zzgi;
      try
      {
        int i = zzbn.zzt(paramString.length() * 3);
        int j = zzbn.zzt(paramString.length());
        if (j == i)
        {
          j = (int)(this.zzgi - this.zzge) + j;
          this.zzgd.position(j);
          zzff.zza(paramString, this.zzgd);
          j = this.zzgd.position() - j;
          zzo(j);
          this.zzgi += j;
          return;
        }
        j = zzff.zza(paramString);
        zzo(j);
        zzk(this.zzgi);
        zzff.zza(paramString, this.zzgd);
        this.zzgi += j;
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzbn.zzc(paramString);
      }
      catch (IllegalArgumentException paramString)
      {
        throw new zzbn.zzc(paramString);
      }
      catch (zzfi localzzfi)
      {
        this.zzgi = l;
        zzk(l);
        zza(paramString, localzzfi);
      }
    }
    
    public final void zzn(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzo(paramInt);
        return;
      }
      zzb(paramInt);
    }
    
    public final void zzo(int paramInt)
      throws IOException
    {
      int i = paramInt;
      long l;
      if (this.zzgi <= this.zzgh) {
        for (;;)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            l = this.zzgi;
            this.zzgi = (1L + l);
            zzfd.zza(l, (byte)paramInt);
            return;
          }
          l = this.zzgi;
          this.zzgi = (l + 1L);
          zzfd.zza(l, (byte)(paramInt & 0x7F | 0x80));
          paramInt >>>= 7;
        }
      }
      for (;;)
      {
        l = this.zzgi;
        if (l >= this.zzgg) {
          break label127;
        }
        if ((i & 0xFFFFFF80) == 0)
        {
          paramInt = i;
          break;
        }
        this.zzgi = (l + 1L);
        zzfd.zza(l, (byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
      label127:
      throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), Integer.valueOf(1) }));
    }
    
    public final void zzq(int paramInt)
      throws IOException
    {
      this.zzgd.putInt((int)(this.zzgi - this.zzge), paramInt);
      this.zzgi += 4L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */