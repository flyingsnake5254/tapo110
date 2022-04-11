package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.util.g;

public final class c0
{
  private final byte[] a;
  private final int b;
  private int c;
  private int d;
  
  public c0(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = paramArrayOfByte.length;
  }
  
  private void a()
  {
    int i = this.c;
    if (i >= 0)
    {
      int j = this.b;
      if ((i < j) || ((i == j) && (this.d == 0)))
      {
        bool = true;
        break label38;
      }
    }
    boolean bool = false;
    label38:
    g.g(bool);
  }
  
  public int b()
  {
    return this.c * 8 + this.d;
  }
  
  public boolean c()
  {
    boolean bool;
    if (((this.a[this.c] & 0xFF) >> this.d & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    e(1);
    return bool;
  }
  
  public int d(int paramInt)
  {
    int i = this.c;
    int j = Math.min(paramInt, 8 - this.d);
    byte[] arrayOfByte = this.a;
    int k = i + 1;
    i = (arrayOfByte[i] & 0xFF) >> this.d & 255 >> 8 - j;
    while (j < paramInt)
    {
      i |= (this.a[k] & 0xFF) << j;
      j += 8;
      k++;
    }
    e(paramInt);
    return i & -1 >>> 32 - paramInt;
  }
  
  public void e(int paramInt)
  {
    int i = paramInt / 8;
    int j = this.c + i;
    this.c = j;
    paramInt = this.d + (paramInt - i * 8);
    this.d = paramInt;
    if (paramInt > 7)
    {
      this.c = (j + 1);
      this.d = (paramInt - 8);
    }
    a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */