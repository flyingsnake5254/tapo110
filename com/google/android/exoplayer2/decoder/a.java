package com.google.android.exoplayer2.decoder;

public abstract class a
{
  private int c;
  
  public final void e(int paramInt)
  {
    this.c = (paramInt | this.c);
  }
  
  public void f()
  {
    this.c = 0;
  }
  
  public final void g(int paramInt)
  {
    this.c = ((paramInt ^ 0xFFFFFFFF) & this.c);
  }
  
  protected final boolean h(int paramInt)
  {
    boolean bool;
    if ((this.c & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean i()
  {
    return h(268435456);
  }
  
  public final boolean j()
  {
    return h(Integer.MIN_VALUE);
  }
  
  public final boolean k()
  {
    return h(4);
  }
  
  public final boolean l()
  {
    return h(1);
  }
  
  public final void m(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\decoder\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */