package com.google.android.exoplayer2.util;

import java.util.NoSuchElementException;

public final class s
{
  private int a = 0;
  private int b = -1;
  private int c = 0;
  private int[] d;
  private int e;
  
  public s()
  {
    int[] arrayOfInt = new int[16];
    this.d = arrayOfInt;
    this.e = (arrayOfInt.length - 1);
  }
  
  private void c()
  {
    int[] arrayOfInt1 = this.d;
    int i = arrayOfInt1.length << 1;
    if (i >= 0)
    {
      int[] arrayOfInt2 = new int[i];
      int j = arrayOfInt1.length;
      i = this.a;
      j -= i;
      System.arraycopy(arrayOfInt1, i, arrayOfInt2, 0, j);
      System.arraycopy(this.d, 0, arrayOfInt2, j, i);
      this.a = 0;
      this.b = (this.c - 1);
      this.d = arrayOfInt2;
      this.e = (arrayOfInt2.length - 1);
      return;
    }
    throw new IllegalStateException();
  }
  
  public void a(int paramInt)
  {
    if (this.c == this.d.length) {
      c();
    }
    int i = this.b + 1 & this.e;
    this.b = i;
    this.d[i] = paramInt;
    this.c += 1;
  }
  
  public void b()
  {
    this.a = 0;
    this.b = -1;
    this.c = 0;
  }
  
  public boolean d()
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int e()
  {
    int i = this.c;
    if (i != 0)
    {
      int[] arrayOfInt = this.d;
      int j = this.a;
      int k = arrayOfInt[j];
      this.a = (j + 1 & this.e);
      this.c = (i - 1);
      return k;
    }
    throw new NoSuchElementException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */