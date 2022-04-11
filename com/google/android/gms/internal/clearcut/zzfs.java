package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzfs
{
  private final ByteBuffer zzgd;
  private zzbn zzrh;
  private int zzri;
  
  private zzfs(ByteBuffer paramByteBuffer)
  {
    this.zzgd = paramByteBuffer;
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzfs(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  private static int zza(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 0;
    for (int k = 0; (k < i) && (paramCharSequence.charAt(k) < ''); k++) {}
    int m = i;
    for (;;)
    {
      n = m;
      if (k >= i) {
        break label237;
      }
      n = paramCharSequence.charAt(k);
      if (n >= 2048) {
        break;
      }
      m += (127 - n >>> 31);
      k++;
    }
    int i1 = paramCharSequence.length();
    int n = j;
    while (k < i1)
    {
      int i2 = paramCharSequence.charAt(k);
      if (i2 < 2048)
      {
        n += (127 - i2 >>> 31);
        j = k;
      }
      else
      {
        int i3 = n + 2;
        n = i3;
        j = k;
        if (55296 <= i2)
        {
          n = i3;
          j = k;
          if (i2 <= 57343) {
            if (Character.codePointAt(paramCharSequence, k) >= 65536)
            {
              j = k + 1;
              n = i3;
            }
            else
            {
              paramCharSequence = new StringBuilder(39);
              paramCharSequence.append("Unpaired surrogate at index ");
              paramCharSequence.append(k);
              throw new IllegalArgumentException(paramCharSequence.toString());
            }
          }
        }
      }
      k = j + 1;
    }
    n = m + n;
    label237:
    if (n >= i) {
      return n;
    }
    long l = n;
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(l + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  private final void zzao(int paramInt)
    throws IOException
  {
    byte b = (byte)paramInt;
    if (this.zzgd.hasRemaining())
    {
      this.zzgd.put(b);
      return;
    }
    throw new zzft(this.zzgd.position(), this.zzgd.limit());
  }
  
  private final void zzap(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzao(paramInt);
        return;
      }
      zzao(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int zzb(int paramInt, zzfz paramzzfz)
  {
    int i = zzr(paramInt);
    paramInt = paramzzfz.zzas();
    return i + (zzz(paramInt) + paramInt);
  }
  
  public static int zzb(int paramInt, String paramString)
  {
    return zzr(paramInt) + zzh(paramString);
  }
  
  public static int zzb(int paramInt, byte[] paramArrayOfByte)
  {
    return zzr(paramInt) + zzh(paramArrayOfByte);
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zzr(paramInt) + zzo(paramLong);
  }
  
  private static void zzd(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (!paramByteBuffer.isReadOnly())
    {
      boolean bool = paramByteBuffer.hasArray();
      int i = 0;
      int j = 0;
      char c;
      if (bool) {
        try
        {
          byte[] arrayOfByte = paramByteBuffer.array();
          i = paramByteBuffer.arrayOffset() + paramByteBuffer.position();
          k = paramByteBuffer.remaining();
          int m = paramCharSequence.length();
          int n = k + i;
          int i1;
          while (j < m)
          {
            k = j + i;
            if (k >= n) {
              break;
            }
            i1 = paramCharSequence.charAt(j);
            if (i1 >= 128) {
              break;
            }
            arrayOfByte[k] = ((byte)(byte)i1);
            j++;
          }
          if (j == m)
          {
            k = i + m;
          }
          else
          {
            i += j;
            int i2;
            for (;;)
            {
              k = i;
              if (j >= m) {
                break label582;
              }
              i2 = paramCharSequence.charAt(j);
              if ((i2 < 128) && (i < n))
              {
                k = i + 1;
                arrayOfByte[i] = ((byte)(byte)i2);
                i = k;
              }
              for (;;)
              {
                break;
                if ((i2 < 2048) && (i <= n - 2))
                {
                  k = i + 1;
                  arrayOfByte[i] = ((byte)(byte)(i2 >>> 6 | 0x3C0));
                  i = k + 1;
                  arrayOfByte[k] = ((byte)(byte)(i2 & 0x3F | 0x80));
                }
                else if (((i2 < 55296) || (57343 < i2)) && (i <= n - 3))
                {
                  i1 = i + 1;
                  arrayOfByte[i] = ((byte)(byte)(i2 >>> 12 | 0x1E0));
                  k = i1 + 1;
                  arrayOfByte[i1] = ((byte)(byte)(i2 >>> 6 & 0x3F | 0x80));
                  i = k + 1;
                  arrayOfByte[k] = ((byte)(byte)(i2 & 0x3F | 0x80));
                }
                else
                {
                  if (i > n - 4) {
                    break label531;
                  }
                  k = j + 1;
                  if (k == paramCharSequence.length()) {
                    break label491;
                  }
                  c = paramCharSequence.charAt(k);
                  if (!Character.isSurrogatePair(i2, c)) {
                    break label487;
                  }
                  j = Character.toCodePoint(i2, c);
                  i1 = i + 1;
                  arrayOfByte[i] = ((byte)(byte)(j >>> 18 | 0xF0));
                  i = i1 + 1;
                  arrayOfByte[i1] = ((byte)(byte)(j >>> 12 & 0x3F | 0x80));
                  i1 = i + 1;
                  arrayOfByte[i] = ((byte)(byte)(j >>> 6 & 0x3F | 0x80));
                  i = i1 + 1;
                  arrayOfByte[i1] = ((byte)(byte)(j & 0x3F | 0x80));
                  j = k;
                }
              }
              j++;
            }
            label487:
            j = k;
            label491:
            paramCharSequence = new java/lang/IllegalArgumentException;
            paramByteBuffer = new java/lang/StringBuilder;
            paramByteBuffer.<init>(39);
            paramByteBuffer.append("Unpaired surrogate at index ");
            paramByteBuffer.append(j - 1);
            paramCharSequence.<init>(paramByteBuffer.toString());
            throw paramCharSequence;
            label531:
            paramByteBuffer = new java/lang/ArrayIndexOutOfBoundsException;
            paramCharSequence = new java/lang/StringBuilder;
            paramCharSequence.<init>(37);
            paramCharSequence.append("Failed writing ");
            paramCharSequence.append(i2);
            paramCharSequence.append(" at index ");
            paramCharSequence.append(i);
            paramByteBuffer.<init>(paramCharSequence.toString());
            throw paramByteBuffer;
          }
          label582:
          paramByteBuffer.position(k - paramByteBuffer.arrayOffset());
          return;
        }
        catch (ArrayIndexOutOfBoundsException paramByteBuffer)
        {
          paramCharSequence = new BufferOverflowException();
          paramCharSequence.initCause(paramByteBuffer);
          throw paramCharSequence;
        }
      }
      int k = paramCharSequence.length();
      label903:
      for (j = i; j < k; j++)
      {
        int i3 = paramCharSequence.charAt(j);
        if (i3 < 128)
        {
          i = i3;
          paramByteBuffer.put((byte)i);
        }
        else
        {
          if (i3 < 2048) {}
          for (i = i3 >>> 6 | 0x3C0;; i = i3 >>> 6 & 0x3F | 0x80)
          {
            paramByteBuffer.put((byte)i);
            i = i3 & 0x3F | 0x80;
            break;
            if ((i3 >= 55296) && (57343 >= i3))
            {
              i = j + 1;
              if (i != paramCharSequence.length())
              {
                c = paramCharSequence.charAt(i);
                if (Character.isSurrogatePair(i3, c))
                {
                  j = Character.toCodePoint(i3, c);
                  paramByteBuffer.put((byte)(j >>> 18 | 0xF0));
                  paramByteBuffer.put((byte)(j >>> 12 & 0x3F | 0x80));
                  paramByteBuffer.put((byte)(j >>> 6 & 0x3F | 0x80));
                  paramByteBuffer.put((byte)(j & 0x3F | 0x80));
                  j = i;
                  break label903;
                }
                j = i;
              }
              paramCharSequence = new StringBuilder(39);
              paramCharSequence.append("Unpaired surrogate at index ");
              paramCharSequence.append(j - 1);
              throw new IllegalArgumentException(paramCharSequence.toString());
            }
            paramByteBuffer.put((byte)(i3 >>> 12 | 0x1E0));
          }
        }
      }
      return;
    }
    throw new ReadOnlyBufferException();
  }
  
  public static zzfs zzg(byte[] paramArrayOfByte)
  {
    return zzh(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzh(String paramString)
  {
    int i = zza(paramString);
    return zzz(i) + i;
  }
  
  public static int zzh(byte[] paramArrayOfByte)
  {
    return zzz(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static zzfs zzh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzfs(paramArrayOfByte, 0, paramInt2);
  }
  
  public static long zzj(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int zzo(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((paramLong & 0x8000000000000000) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int zzr(int paramInt)
  {
    return zzz(paramInt << 3);
  }
  
  public static int zzs(int paramInt)
  {
    if (paramInt >= 0) {
      return zzz(paramInt);
    }
    return 10;
  }
  
  private static int zzz(int paramInt)
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
  
  public final void zza(int paramInt, zzfz paramzzfz)
    throws IOException
  {
    zzb(paramInt, 2);
    if (paramzzfz.zzrs < 0) {
      paramzzfz.zzas();
    }
    zzap(paramzzfz.zzrs);
    paramzzfz.zza(this);
  }
  
  public final void zza(int paramInt, String paramString)
    throws IOException
  {
    zzb(paramInt, 2);
    try
    {
      int i = zzz(paramString.length());
      if (i == zzz(paramString.length() * 3))
      {
        int j = this.zzgd.position();
        if (this.zzgd.remaining() >= i)
        {
          this.zzgd.position(j + i);
          zzd(paramString, this.zzgd);
          paramInt = this.zzgd.position();
          this.zzgd.position(j);
          zzap(paramInt - j - i);
          this.zzgd.position(paramInt);
          return;
        }
        paramString = new com/google/android/gms/internal/clearcut/zzft;
        paramString.<init>(j + i, this.zzgd.limit());
        throw paramString;
      }
      zzap(zza(paramString));
      zzd(paramString, this.zzgd);
      return;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      paramString = new zzft(this.zzgd.position(), this.zzgd.limit());
      paramString.initCause(localBufferOverflowException);
      throw paramString;
    }
  }
  
  public final void zza(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    zzb(paramInt, 2);
    zzap(paramArrayOfByte.length);
    paramInt = paramArrayOfByte.length;
    if (this.zzgd.remaining() >= paramInt)
    {
      this.zzgd.put(paramArrayOfByte, 0, paramInt);
      return;
    }
    throw new zzft(this.zzgd.position(), this.zzgd.limit());
  }
  
  public final void zzb(int paramInt1, int paramInt2)
    throws IOException
  {
    zzap(paramInt1 << 3 | paramInt2);
  }
  
  public final void zzb(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzb(25, 0);
    byte b = (byte)paramBoolean;
    if (this.zzgd.hasRemaining())
    {
      this.zzgd.put(b);
      return;
    }
    throw new zzft(this.zzgd.position(), this.zzgd.limit());
  }
  
  public final void zzc(int paramInt1, int paramInt2)
    throws IOException
  {
    zzb(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      zzap(paramInt2);
      return;
    }
    zzn(paramInt2);
  }
  
  public final void zze(int paramInt, zzdo paramzzdo)
    throws IOException
  {
    if (this.zzrh == null) {
      this.zzrh = zzbn.zza(this.zzgd);
    }
    for (;;)
    {
      this.zzri = this.zzgd.position();
      break;
      if (this.zzri == this.zzgd.position()) {
        break;
      }
      this.zzrh.write(this.zzgd.array(), this.zzri, this.zzgd.position() - this.zzri);
    }
    zzbn localzzbn = this.zzrh;
    localzzbn.zza(paramInt, paramzzdo);
    localzzbn.flush();
    this.zzri = this.zzgd.position();
  }
  
  public final void zzem()
  {
    if (this.zzgd.remaining() == 0) {
      return;
    }
    throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[] { Integer.valueOf(this.zzgd.remaining()) }));
  }
  
  public final void zzi(int paramInt, long paramLong)
    throws IOException
  {
    zzb(paramInt, 0);
    zzn(paramLong);
  }
  
  public final void zzn(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        zzao((int)paramLong);
        return;
      }
      zzao((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */