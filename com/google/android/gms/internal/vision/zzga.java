package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Arrays;

final class zzga
  extends zzfy
{
  private final byte[] buffer;
  private int limit;
  private int pos;
  private final boolean zzsz;
  private int zzta;
  private int zztb;
  private int zztc;
  private int zztd = Integer.MAX_VALUE;
  
  private zzga(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    this.buffer = paramArrayOfByte;
    this.limit = (paramInt2 + paramInt1);
    this.pos = paramInt1;
    this.zztb = paramInt1;
    this.zzsz = paramBoolean;
  }
  
  private final void zzaw(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      int i = this.limit;
      int j = this.pos;
      if (paramInt <= i - j)
      {
        this.pos = (j + paramInt);
        return;
      }
    }
    if (paramInt < 0) {
      throw zzhh.zzgo();
    }
    throw zzhh.zzgn();
  }
  
  private final int zzfb()
    throws IOException
  {
    int i = this.pos;
    int j = this.limit;
    if (j != i)
    {
      byte[] arrayOfByte = this.buffer;
      int k = i + 1;
      i = arrayOfByte[i];
      if (i >= 0)
      {
        this.pos = k;
        return i;
      }
      if (j - k >= 9)
      {
        j = k + 1;
        i ^= arrayOfByte[k] << 7;
        if (i < 0)
        {
          k = i ^ 0xFFFFFF80;
        }
        else
        {
          k = j + 1;
          i ^= arrayOfByte[j] << 14;
          if (i >= 0)
          {
            i ^= 0x3F80;
            j = k;
            k = i;
          }
          for (;;)
          {
            break;
            j = k + 1;
            k = i ^ arrayOfByte[k] << 21;
            if (k < 0)
            {
              k ^= 0xFFE03F80;
            }
            else
            {
              int m = j + 1;
              int n = arrayOfByte[j];
              i = k ^ n << 28 ^ 0xFE03F80;
              k = i;
              j = m;
              if (n < 0)
              {
                n = m + 1;
                k = i;
                j = n;
                if (arrayOfByte[m] < 0)
                {
                  m = n + 1;
                  k = i;
                  j = m;
                  if (arrayOfByte[n] < 0)
                  {
                    n = m + 1;
                    k = i;
                    j = n;
                    if (arrayOfByte[m] < 0)
                    {
                      m = n + 1;
                      k = i;
                      j = m;
                      if (arrayOfByte[n] < 0)
                      {
                        j = m + 1;
                        if (arrayOfByte[m] < 0) {
                          break label274;
                        }
                        k = i;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        this.pos = j;
        return k;
      }
    }
    label274:
    return (int)zzez();
  }
  
  private final long zzfc()
    throws IOException
  {
    int i = this.pos;
    int j = this.limit;
    if (j != i)
    {
      byte[] arrayOfByte = this.buffer;
      int k = i + 1;
      i = arrayOfByte[i];
      if (i >= 0)
      {
        this.pos = k;
        return i;
      }
      if (j - k >= 9)
      {
        j = k + 1;
        i ^= arrayOfByte[k] << 7;
        if (i < 0) {
          k = i ^ 0xFFFFFF80;
        }
        for (;;)
        {
          l1 = k;
          break label351;
          k = j + 1;
          i ^= arrayOfByte[j] << 14;
          if (i >= 0)
          {
            l1 = i ^ 0x3F80;
            j = k;
            break label351;
          }
          j = k + 1;
          k = i ^ arrayOfByte[k] << 21;
          if (k >= 0) {
            break;
          }
          k ^= 0xFFE03F80;
        }
        long l1 = k;
        k = j + 1;
        long l2 = l1 ^ arrayOfByte[j] << 28;
        if (l2 >= 0L)
        {
          l1 = 266354560L;
          j = k;
          l1 = l2 ^ l1;
        }
        else
        {
          j = k + 1;
          l1 = l2 ^ arrayOfByte[k] << 35;
          if (l1 < 0L) {
            l2 = -34093383808L;
          }
          for (;;)
          {
            l1 ^= l2;
            break label351;
            i = j + 1;
            l2 = l1 ^ arrayOfByte[j] << 42;
            if (l2 >= 0L)
            {
              l1 = 4363953127296L;
              j = i;
              break;
            }
            k = i + 1;
            l1 = l2 ^ arrayOfByte[i] << 49;
            if (l1 >= 0L) {
              break label302;
            }
            l2 = -558586000294016L;
            j = k;
          }
          label302:
          j = k + 1;
          l1 = l1 ^ arrayOfByte[k] << 56 ^ 0xFE03F80FE03F80;
          if (l1 < 0L)
          {
            k = j + 1;
            if (arrayOfByte[j] < 0L) {
              break label359;
            }
            j = k;
          }
        }
        label351:
        this.pos = j;
        return l1;
      }
    }
    label359:
    return zzez();
  }
  
  private final int zzfd()
    throws IOException
  {
    int i = this.pos;
    if (this.limit - i >= 4)
    {
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 4);
      int j = arrayOfByte[i];
      int k = arrayOfByte[(i + 1)];
      int m = arrayOfByte[(i + 2)];
      return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
    }
    throw zzhh.zzgn();
  }
  
  private final long zzfe()
    throws IOException
  {
    int i = this.pos;
    if (this.limit - i >= 8)
    {
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 8);
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[(i + 1)];
      long l3 = arrayOfByte[(i + 2)];
      long l4 = arrayOfByte[(i + 3)];
      long l5 = arrayOfByte[(i + 4)];
      long l6 = arrayOfByte[(i + 5)];
      long l7 = arrayOfByte[(i + 6)];
      return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    throw zzhh.zzgn();
  }
  
  private final void zzff()
  {
    int i = this.limit + this.zzta;
    this.limit = i;
    int j = i - this.zztb;
    int k = this.zztd;
    if (j > k)
    {
      k = j - k;
      this.zzta = k;
      this.limit = (i - k);
      return;
    }
    this.zzta = 0;
  }
  
  private final byte zzfg()
    throws IOException
  {
    int i = this.pos;
    if (i != this.limit)
    {
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 1);
      return arrayOfByte[i];
    }
    throw zzhh.zzgn();
  }
  
  public final double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzfe());
  }
  
  public final float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzfd());
  }
  
  public final String readString()
    throws IOException
  {
    int i = zzfb();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      String str = new String(this.buffer, this.pos, i, zzgy.UTF_8);
      this.pos += i;
      return str;
    }
    if (i == 0) {
      return "";
    }
    if (i < 0) {
      throw zzhh.zzgo();
    }
    throw zzhh.zzgn();
  }
  
  public final void zzar(int paramInt)
    throws zzhh
  {
    if (this.zztc == paramInt) {
      return;
    }
    throw zzhh.zzgr();
  }
  
  public final boolean zzas(int paramInt)
    throws IOException
  {
    int i = paramInt & 0x7;
    int j = 0;
    int k = 0;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                zzaw(4);
                return true;
              }
              throw zzhh.zzgs();
            }
            return false;
          }
          do
          {
            k = zzey();
          } while ((k != 0) && (zzas(k)));
          zzar(paramInt >>> 3 << 3 | 0x4);
          return true;
        }
        zzaw(zzfb());
        return true;
      }
      zzaw(8);
      return true;
    }
    paramInt = j;
    if (this.limit - this.pos >= 10)
    {
      for (paramInt = k; paramInt < 10; paramInt++)
      {
        byte[] arrayOfByte = this.buffer;
        k = this.pos;
        this.pos = (k + 1);
        if (arrayOfByte[k] >= 0) {
          break label185;
        }
      }
      throw zzhh.zzgp();
    }
    for (;;)
    {
      if (paramInt >= 10) {
        break label187;
      }
      if (zzfg() >= 0) {
        break;
      }
      paramInt++;
    }
    label185:
    return true;
    label187:
    throw zzhh.zzgp();
  }
  
  public final int zzat(int paramInt)
    throws zzhh
  {
    if (paramInt >= 0)
    {
      paramInt += zzfa();
      int i = this.zztd;
      if (paramInt <= i)
      {
        this.zztd = paramInt;
        zzff();
        return i;
      }
      throw zzhh.zzgn();
    }
    throw zzhh.zzgo();
  }
  
  public final void zzau(int paramInt)
  {
    this.zztd = paramInt;
    zzff();
  }
  
  public final boolean zzdu()
    throws IOException
  {
    return this.pos == this.limit;
  }
  
  public final long zzdx()
    throws IOException
  {
    return zzfc();
  }
  
  public final long zzdy()
    throws IOException
  {
    return zzfc();
  }
  
  public final int zzdz()
    throws IOException
  {
    return zzfb();
  }
  
  public final long zzea()
    throws IOException
  {
    return zzfe();
  }
  
  public final int zzeb()
    throws IOException
  {
    return zzfd();
  }
  
  public final boolean zzec()
    throws IOException
  {
    return zzfc() != 0L;
  }
  
  public final String zzed()
    throws IOException
  {
    int i = zzfb();
    if (i > 0)
    {
      int j = this.limit;
      int k = this.pos;
      if (i <= j - k)
      {
        String str = zzjx.zzh(this.buffer, k, i);
        this.pos += i;
        return str;
      }
    }
    if (i == 0) {
      return "";
    }
    if (i <= 0) {
      throw zzhh.zzgo();
    }
    throw zzhh.zzgn();
  }
  
  public final zzfm zzee()
    throws IOException
  {
    int i = zzfb();
    int j;
    int k;
    Object localObject;
    if (i > 0)
    {
      j = this.limit;
      k = this.pos;
      if (i <= j - k)
      {
        localObject = zzfm.zza(this.buffer, k, i);
        this.pos += i;
        return (zzfm)localObject;
      }
    }
    if (i == 0) {
      return zzfm.zzsm;
    }
    if (i > 0)
    {
      j = this.limit;
      k = this.pos;
      if (i <= j - k)
      {
        i += k;
        this.pos = i;
        localObject = Arrays.copyOfRange(this.buffer, k, i);
        break label115;
      }
    }
    if (i <= 0)
    {
      if (i == 0)
      {
        localObject = zzgy.zzxr;
        label115:
        return zzfm.zzd((byte[])localObject);
      }
      throw zzhh.zzgo();
    }
    throw zzhh.zzgn();
  }
  
  public final int zzef()
    throws IOException
  {
    return zzfb();
  }
  
  public final int zzeg()
    throws IOException
  {
    return zzfb();
  }
  
  public final int zzeh()
    throws IOException
  {
    return zzfd();
  }
  
  public final long zzei()
    throws IOException
  {
    return zzfe();
  }
  
  public final int zzej()
    throws IOException
  {
    return zzfy.zzav(zzfb());
  }
  
  public final long zzek()
    throws IOException
  {
    return zzfy.zzr(zzfc());
  }
  
  public final int zzey()
    throws IOException
  {
    if (zzdu())
    {
      this.zztc = 0;
      return 0;
    }
    int i = zzfb();
    this.zztc = i;
    if (i >>> 3 != 0) {
      return i;
    }
    throw zzhh.zzgq();
  }
  
  final long zzez()
    throws IOException
  {
    long l = 0L;
    for (int i = 0; i < 64; i += 7)
    {
      int j = zzfg();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
    }
    throw zzhh.zzgp();
  }
  
  public final int zzfa()
  {
    return this.pos - this.zztb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */