package com.google.common.math;

import com.google.common.primitives.b;
import java.util.Iterator;

public final class g
{
  private long a = 0L;
  private double b = 0.0D;
  private double c = 0.0D;
  private double d = NaN.0D;
  private double e = NaN.0D;
  
  static double g(double paramDouble1, double paramDouble2)
  {
    if (b.f(paramDouble1)) {
      return paramDouble2;
    }
    double d1 = paramDouble1;
    if (!b.f(paramDouble2)) {
      if (paramDouble1 == paramDouble2) {
        d1 = paramDouble1;
      } else {
        d1 = NaN.0D;
      }
    }
    return d1;
  }
  
  public void a(double paramDouble)
  {
    long l = this.a;
    if (l == 0L)
    {
      this.a = 1L;
      this.b = paramDouble;
      this.d = paramDouble;
      this.e = paramDouble;
      if (!b.f(paramDouble)) {
        this.c = NaN.0D;
      }
    }
    else
    {
      this.a = (l + 1L);
      if ((b.f(paramDouble)) && (b.f(this.b)))
      {
        double d1 = this.b;
        double d2 = paramDouble - d1;
        d1 += d2 / this.a;
        this.b = d1;
        this.c += d2 * (paramDouble - d1);
      }
      else
      {
        this.b = g(this.b, paramDouble);
        this.c = NaN.0D;
      }
      this.d = Math.min(this.d, paramDouble);
      this.e = Math.max(this.e, paramDouble);
    }
  }
  
  public void b(Iterable<? extends Number> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      a(((Number)paramIterable.next()).doubleValue());
    }
  }
  
  public void c(Iterator<? extends Number> paramIterator)
  {
    while (paramIterator.hasNext()) {
      a(((Number)paramIterator.next()).doubleValue());
    }
  }
  
  public void d(double... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      a(paramVarArgs[j]);
    }
  }
  
  public void e(int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      a(paramVarArgs[j]);
    }
  }
  
  public void f(long... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      a(paramVarArgs[j]);
    }
  }
  
  public Stats h()
  {
    return new Stats(this.a, this.b, this.c, this.d, this.e);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\math\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */