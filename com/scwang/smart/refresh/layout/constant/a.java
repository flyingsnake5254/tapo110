package com.scwang.smart.refresh.layout.constant;

public class a
{
  public static final a a;
  public static final a b;
  public static final a c;
  public static final a d;
  public static final a e;
  public static final a f;
  public static final a g;
  public static final a h;
  public static final a i;
  public static final a j;
  public static final a k;
  public static final a l;
  public static final a[] m;
  public final int n;
  public final boolean o;
  
  static
  {
    a locala1 = new a(0, false);
    a = locala1;
    a locala2 = new a(1, true);
    b = locala2;
    a locala3 = new a(2, false);
    c = locala3;
    a locala4 = new a(3, true);
    d = locala4;
    a locala5 = new a(4, false);
    e = locala5;
    a locala6 = new a(5, true);
    f = locala6;
    a locala7 = new a(6, false);
    g = locala7;
    a locala8 = new a(7, true);
    h = locala8;
    a locala9 = new a(8, false);
    i = locala9;
    a locala10 = new a(9, true);
    j = locala10;
    a locala11 = new a(10, false);
    k = locala11;
    a locala12 = new a(10, true);
    l = locala12;
    m = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12 };
  }
  
  private a(int paramInt, boolean paramBoolean)
  {
    this.n = paramInt;
    this.o = paramBoolean;
  }
  
  public boolean a(a parama)
  {
    int i1 = this.n;
    int i2 = parama.n;
    boolean bool;
    if ((i1 >= i2) && (((this.o) && (j != this)) || (i1 != i2))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public a b()
  {
    if (!this.o) {
      return m[(this.n + 1)];
    }
    return this;
  }
  
  public a c()
  {
    if (this.o)
    {
      a locala = m[(this.n - 1)];
      if (!locala.o) {
        return locala;
      }
      return a;
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\constant\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */