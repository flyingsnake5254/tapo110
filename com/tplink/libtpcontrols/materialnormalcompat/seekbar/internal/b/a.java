package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b;

import android.os.Build.VERSION;

public abstract class a
{
  public static final a b(float paramFloat1, float paramFloat2, a parama)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return new b(paramFloat1, paramFloat2, parama);
    }
    return new b(paramFloat1, paramFloat2, parama);
  }
  
  public abstract void a();
  
  public abstract boolean c();
  
  public abstract void d(int paramInt);
  
  public abstract void e();
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat);
  }
  
  private static class b
    extends a
  {
    private final a.a a;
    private final float b;
    
    public b(float paramFloat1, float paramFloat2, a.a parama)
    {
      this.a = parama;
      this.b = paramFloat2;
    }
    
    public void a() {}
    
    public boolean c()
    {
      return false;
    }
    
    public void d(int paramInt) {}
    
    public void e()
    {
      this.a.a(this.b);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */