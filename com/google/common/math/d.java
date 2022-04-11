package com.google.common.math;

import com.google.common.base.n;
import com.google.errorprone.annotations.concurrent.LazyInit;

public abstract class d
{
  public static d a()
  {
    return c.a;
  }
  
  public static d b(double paramDouble)
  {
    n.d(b.c(paramDouble));
    return new d(0.0D, paramDouble);
  }
  
  public static b c(double paramDouble1, double paramDouble2)
  {
    boolean bool;
    if ((b.c(paramDouble1)) && (b.c(paramDouble2))) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    return new b(paramDouble1, paramDouble2, null);
  }
  
  public static d d(double paramDouble)
  {
    n.d(b.c(paramDouble));
    return new e(paramDouble);
  }
  
  public static final class b
  {
    private final double a;
    private final double b;
    
    private b(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
    
    public d a(double paramDouble)
    {
      n.d(Double.isNaN(paramDouble) ^ true);
      if (b.c(paramDouble)) {
        return new d.d(paramDouble, this.b - this.a * paramDouble);
      }
      return new d.e(this.a);
    }
  }
  
  private static final class c
    extends d
  {
    static final c a = new c();
    
    public String toString()
    {
      return "NaN";
    }
  }
  
  private static final class d
    extends d
  {
    final double a;
    final double b;
    @LazyInit
    d c;
    
    d(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
      this.c = null;
    }
    
    public String toString()
    {
      return String.format("y = %g * x + %g", new Object[] { Double.valueOf(this.a), Double.valueOf(this.b) });
    }
  }
  
  private static final class e
    extends d
  {
    final double a;
    @LazyInit
    d b;
    
    e(double paramDouble)
    {
      this.a = paramDouble;
      this.b = null;
    }
    
    public String toString()
    {
      return String.format("x = %g", new Object[] { Double.valueOf(this.a) });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\math\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */