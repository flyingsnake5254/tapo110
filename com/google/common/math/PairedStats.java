package com.google.common.math;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class PairedStats
  implements Serializable
{
  private static final int BYTES = 88;
  private static final long serialVersionUID = 0L;
  private final double sumOfProductsOfDeltas;
  private final Stats xStats;
  private final Stats yStats;
  
  PairedStats(Stats paramStats1, Stats paramStats2, double paramDouble)
  {
    this.xStats = paramStats1;
    this.yStats = paramStats2;
    this.sumOfProductsOfDeltas = paramDouble;
  }
  
  private static double ensureInUnitRange(double paramDouble)
  {
    if (paramDouble >= 1.0D) {
      return 1.0D;
    }
    if (paramDouble <= -1.0D) {
      return -1.0D;
    }
    return paramDouble;
  }
  
  private static double ensurePositive(double paramDouble)
  {
    if (paramDouble > 0.0D) {
      return paramDouble;
    }
    return Double.MIN_VALUE;
  }
  
  public static PairedStats fromByteArray(byte[] paramArrayOfByte)
  {
    n.o(paramArrayOfByte);
    boolean bool;
    if (paramArrayOfByte.length == 88) {
      bool = true;
    } else {
      bool = false;
    }
    n.g(bool, "Expected PairedStats.BYTES = %s, got %s", 88, paramArrayOfByte.length);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
    return new PairedStats(Stats.readFrom(paramArrayOfByte), Stats.readFrom(paramArrayOfByte), paramArrayOfByte.getDouble());
  }
  
  public long count()
  {
    return this.xStats.count();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject == null) {
      return false;
    }
    if (PairedStats.class != paramObject.getClass()) {
      return false;
    }
    paramObject = (PairedStats)paramObject;
    boolean bool2 = bool1;
    if (this.xStats.equals(((PairedStats)paramObject).xStats))
    {
      bool2 = bool1;
      if (this.yStats.equals(((PairedStats)paramObject).yStats))
      {
        bool2 = bool1;
        if (Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(((PairedStats)paramObject).sumOfProductsOfDeltas)) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas) });
  }
  
  public d leastSquaresFit()
  {
    long l = count();
    boolean bool1 = true;
    boolean bool2;
    if (l > 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.u(bool2);
    if (Double.isNaN(this.sumOfProductsOfDeltas)) {
      return d.a();
    }
    double d = this.xStats.sumOfSquaresOfDeltas();
    if (d > 0.0D)
    {
      if (this.yStats.sumOfSquaresOfDeltas() > 0.0D) {
        return d.c(this.xStats.mean(), this.yStats.mean()).a(this.sumOfProductsOfDeltas / d);
      }
      return d.b(this.yStats.mean());
    }
    if (this.yStats.sumOfSquaresOfDeltas() > 0.0D) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    n.u(bool2);
    return d.d(this.xStats.mean());
  }
  
  public double pearsonsCorrelationCoefficient()
  {
    long l = count();
    boolean bool1 = true;
    boolean bool2;
    if (l > 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.u(bool2);
    if (Double.isNaN(this.sumOfProductsOfDeltas)) {
      return NaN.0D;
    }
    double d1 = xStats().sumOfSquaresOfDeltas();
    double d2 = yStats().sumOfSquaresOfDeltas();
    if (d1 > 0.0D) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.u(bool2);
    if (d2 > 0.0D) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    n.u(bool2);
    d2 = ensurePositive(d1 * d2);
    return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(d2));
  }
  
  public double populationCovariance()
  {
    boolean bool;
    if (count() != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    return this.sumOfProductsOfDeltas / count();
  }
  
  public double sampleCovariance()
  {
    boolean bool;
    if (count() > 1L) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    return this.sumOfProductsOfDeltas / (count() - 1L);
  }
  
  double sumOfProductsOfDeltas()
  {
    return this.sumOfProductsOfDeltas;
  }
  
  public byte[] toByteArray()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
    this.xStats.writeTo(localByteBuffer);
    this.yStats.writeTo(localByteBuffer);
    localByteBuffer.putDouble(this.sumOfProductsOfDeltas);
    return localByteBuffer.array();
  }
  
  public String toString()
  {
    if (count() > 0L) {
      return j.b(this).d("xStats", this.xStats).d("yStats", this.yStats).a("populationCovariance", populationCovariance()).toString();
    }
    return j.b(this).d("xStats", this.xStats).d("yStats", this.yStats).toString();
  }
  
  public Stats xStats()
  {
    return this.xStats;
  }
  
  public Stats yStats()
  {
    return this.yStats;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\math\PairedStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */