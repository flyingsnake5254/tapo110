package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.util.g;
import java.util.Arrays;

final class w
{
  private final int a;
  private boolean b;
  private boolean c;
  public byte[] d;
  public int e;
  
  public w(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    byte[] arrayOfByte = new byte[paramInt2 + 3];
    this.d = arrayOfByte;
    arrayOfByte[2] = ((byte)1);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.b) {
      return;
    }
    paramInt2 -= paramInt1;
    byte[] arrayOfByte = this.d;
    int i = arrayOfByte.length;
    int j = this.e;
    if (i < j + paramInt2) {
      this.d = Arrays.copyOf(arrayOfByte, (j + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.d, this.e, paramInt2);
    this.e += paramInt2;
  }
  
  public boolean b(int paramInt)
  {
    if (!this.b) {
      return false;
    }
    this.e -= paramInt;
    this.b = false;
    this.c = true;
    return true;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d()
  {
    this.b = false;
    this.c = false;
  }
  
  public void e(int paramInt)
  {
    boolean bool1 = this.b;
    boolean bool2 = true;
    g.g(bool1 ^ true);
    if (paramInt != this.a) {
      bool2 = false;
    }
    this.b = bool2;
    if (bool2)
    {
      this.e = 3;
      this.c = false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */