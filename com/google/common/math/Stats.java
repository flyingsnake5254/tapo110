package com.google.common.math;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Stats
  implements Serializable
{
  static final int BYTES = 40;
  private static final long serialVersionUID = 0L;
  private final long count;
  private final double max;
  private final double mean;
  private final double min;
  private final double sumOfSquaresOfDeltas;
  
  Stats(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.count = paramLong;
    this.mean = paramDouble1;
    this.sumOfSquaresOfDeltas = paramDouble2;
    this.min = paramDouble3;
    this.max = paramDouble4;
  }
  
  public static Stats fromByteArray(byte[] paramArrayOfByte)
  {
    n.o(paramArrayOfByte);
    boolean bool;
    if (paramArrayOfByte.length == 40) {
      bool = true;
    } else {
      bool = false;
    }
    n.g(bool, "Expected Stats.BYTES = %s remaining , got %s", 40, paramArrayOfByte.length);
    return readFrom(ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN));
  }
  
  public static double meanOf(Iterable<? extends Number> paramIterable)
  {
    return meanOf(paramIterable.iterator());
  }
  
  public static double meanOf(Iterator<? extends Number> paramIterator)
  {
    n.d(paramIterator.hasNext());
    double d1 = ((Number)paramIterator.next()).doubleValue();
    long l = 1L;
    while (paramIterator.hasNext())
    {
      double d2 = ((Number)paramIterator.next()).doubleValue();
      l += 1L;
      if ((com.google.common.primitives.b.f(d2)) && (com.google.common.primitives.b.f(d1))) {
        d1 += (d2 - d1) / l;
      } else {
        d1 = g.g(d1, d2);
      }
    }
    return d1;
  }
  
  public static double meanOf(double... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 1;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    double d1 = paramVarArgs[0];
    while (j < paramVarArgs.length)
    {
      double d2 = paramVarArgs[j];
      if ((com.google.common.primitives.b.f(d2)) && (com.google.common.primitives.b.f(d1))) {
        d1 += (d2 - d1) / (j + 1);
      } else {
        d1 = g.g(d1, d2);
      }
      j++;
    }
    return d1;
  }
  
  public static double meanOf(int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 1;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    double d1 = paramVarArgs[0];
    while (j < paramVarArgs.length)
    {
      double d2 = paramVarArgs[j];
      if ((com.google.common.primitives.b.f(d2)) && (com.google.common.primitives.b.f(d1))) {
        d1 += (d2 - d1) / (j + 1);
      } else {
        d1 = g.g(d1, d2);
      }
      j++;
    }
    return d1;
  }
  
  public static double meanOf(long... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 1;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    double d1 = paramVarArgs[0];
    while (j < paramVarArgs.length)
    {
      double d2 = paramVarArgs[j];
      if ((com.google.common.primitives.b.f(d2)) && (com.google.common.primitives.b.f(d1))) {
        d1 += (d2 - d1) / (j + 1);
      } else {
        d1 = g.g(d1, d2);
      }
      j++;
    }
    return d1;
  }
  
  public static Stats of(Iterable<? extends Number> paramIterable)
  {
    g localg = new g();
    localg.b(paramIterable);
    return localg.h();
  }
  
  public static Stats of(Iterator<? extends Number> paramIterator)
  {
    g localg = new g();
    localg.c(paramIterator);
    return localg.h();
  }
  
  public static Stats of(double... paramVarArgs)
  {
    g localg = new g();
    localg.d(paramVarArgs);
    return localg.h();
  }
  
  public static Stats of(int... paramVarArgs)
  {
    g localg = new g();
    localg.e(paramVarArgs);
    return localg.h();
  }
  
  public static Stats of(long... paramVarArgs)
  {
    g localg = new g();
    localg.f(paramVarArgs);
    return localg.h();
  }
  
  static Stats readFrom(ByteBuffer paramByteBuffer)
  {
    n.o(paramByteBuffer);
    boolean bool;
    if (paramByteBuffer.remaining() >= 40) {
      bool = true;
    } else {
      bool = false;
    }
    n.g(bool, "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer.remaining());
    return new Stats(paramByteBuffer.getLong(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble());
  }
  
  public long count()
  {
    return this.count;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject == null) {
      return false;
    }
    if (Stats.class != paramObject.getClass()) {
      return false;
    }
    paramObject = (Stats)paramObject;
    boolean bool2 = bool1;
    if (this.count == ((Stats)paramObject).count)
    {
      bool2 = bool1;
      if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(((Stats)paramObject).mean))
      {
        bool2 = bool1;
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(((Stats)paramObject).sumOfSquaresOfDeltas))
        {
          bool2 = bool1;
          if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(((Stats)paramObject).min))
          {
            bool2 = bool1;
            if (Double.doubleToLongBits(this.max) == Double.doubleToLongBits(((Stats)paramObject).max)) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max) });
  }
  
  public double max()
  {
    boolean bool;
    if (this.count != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    return this.max;
  }
  
  public double mean()
  {
    boolean bool;
    if (this.count != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    return this.mean;
  }
  
  public double min()
  {
    boolean bool;
    if (this.count != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    return this.min;
  }
  
  public double populationStandardDeviation()
  {
    return Math.sqrt(populationVariance());
  }
  
  public double populationVariance()
  {
    boolean bool;
    if (this.count > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
      return NaN.0D;
    }
    if (this.count == 1L) {
      return 0.0D;
    }
    return b.a(this.sumOfSquaresOfDeltas) / count();
  }
  
  public double sampleStandardDeviation()
  {
    return Math.sqrt(sampleVariance());
  }
  
  public double sampleVariance()
  {
    boolean bool;
    if (this.count > 1L) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
      return NaN.0D;
    }
    return b.a(this.sumOfSquaresOfDeltas) / (this.count - 1L);
  }
  
  public double sum()
  {
    return this.mean * this.count;
  }
  
  double sumOfSquaresOfDeltas()
  {
    return this.sumOfSquaresOfDeltas;
  }
  
  public byte[] toByteArray()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
    writeTo(localByteBuffer);
    return localByteBuffer.array();
  }
  
  public String toString()
  {
    if (count() > 0L) {
      return j.b(this).c("count", this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max).toString();
    }
    return j.b(this).c("count", this.count).toString();
  }
  
  void writeTo(ByteBuffer paramByteBuffer)
  {
    n.o(paramByteBuffer);
    boolean bool;
    if (paramByteBuffer.remaining() >= 40) {
      bool = true;
    } else {
      bool = false;
    }
    n.g(bool, "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer.remaining());
    paramByteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\math\Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */