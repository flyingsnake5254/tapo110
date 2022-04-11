package com.google.common.primitives;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class UnsignedLong
  extends Number
  implements Comparable<UnsignedLong>, Serializable
{
  public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1L);
  public static final UnsignedLong ONE;
  private static final long UNSIGNED_MASK = Long.MAX_VALUE;
  public static final UnsignedLong ZERO = new UnsignedLong(0L);
  private final long value;
  
  static
  {
    ONE = new UnsignedLong(1L);
  }
  
  private UnsignedLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public static UnsignedLong fromLongBits(long paramLong)
  {
    return new UnsignedLong(paramLong);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(long paramLong)
  {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    n.h(bool, "value (%s) is outside the range for an unsigned long value", paramLong);
    return fromLongBits(paramLong);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(String paramString)
  {
    return valueOf(paramString, 10);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(String paramString, int paramInt)
  {
    return fromLongBits(j.d(paramString, paramInt));
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(BigInteger paramBigInteger)
  {
    n.o(paramBigInteger);
    boolean bool;
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 64)) {
      bool = true;
    } else {
      bool = false;
    }
    n.j(bool, "value (%s) is outside the range for an unsigned long value", paramBigInteger);
    return fromLongBits(paramBigInteger.longValue());
  }
  
  public BigInteger bigIntegerValue()
  {
    BigInteger localBigInteger1 = BigInteger.valueOf(this.value & 0x7FFFFFFFFFFFFFFF);
    BigInteger localBigInteger2 = localBigInteger1;
    if (this.value < 0L) {
      localBigInteger2 = localBigInteger1.setBit(63);
    }
    return localBigInteger2;
  }
  
  public int compareTo(UnsignedLong paramUnsignedLong)
  {
    n.o(paramUnsignedLong);
    return j.a(this.value, paramUnsignedLong.value);
  }
  
  public UnsignedLong dividedBy(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(j.b(this.value, ((UnsignedLong)n.o(paramUnsignedLong)).value));
  }
  
  public double doubleValue()
  {
    long l = this.value;
    double d1 = 0x7FFFFFFFFFFFFFFF & l;
    double d2 = d1;
    if (l < 0L) {
      d2 = d1 + 9.223372036854776E18D;
    }
    return d2;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof UnsignedLong;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (UnsignedLong)paramObject;
      bool3 = bool2;
      if (this.value == ((UnsignedLong)paramObject).value) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public float floatValue()
  {
    long l = this.value;
    float f1 = (float)(0x7FFFFFFFFFFFFFFF & l);
    float f2 = f1;
    if (l < 0L) {
      f2 = f1 + 9.223372E18F;
    }
    return f2;
  }
  
  public int hashCode()
  {
    return e.e(this.value);
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public UnsignedLong minus(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(this.value - ((UnsignedLong)n.o(paramUnsignedLong)).value);
  }
  
  public UnsignedLong mod(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(j.e(this.value, ((UnsignedLong)n.o(paramUnsignedLong)).value));
  }
  
  public UnsignedLong plus(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(this.value + ((UnsignedLong)n.o(paramUnsignedLong)).value);
  }
  
  public UnsignedLong times(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(this.value * ((UnsignedLong)n.o(paramUnsignedLong)).value);
  }
  
  public String toString()
  {
    return j.f(this.value);
  }
  
  public String toString(int paramInt)
  {
    return j.g(this.value, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\UnsignedLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */