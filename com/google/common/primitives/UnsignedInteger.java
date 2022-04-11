package com.google.common.primitives;

import com.google.common.base.n;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class UnsignedInteger
  extends Number
  implements Comparable<UnsignedInteger>
{
  public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);
  public static final UnsignedInteger ONE;
  public static final UnsignedInteger ZERO = fromIntBits(0);
  private final int value;
  
  static
  {
    ONE = fromIntBits(1);
  }
  
  private UnsignedInteger(int paramInt)
  {
    this.value = (paramInt & 0xFFFFFFFF);
  }
  
  public static UnsignedInteger fromIntBits(int paramInt)
  {
    return new UnsignedInteger(paramInt);
  }
  
  public static UnsignedInteger valueOf(long paramLong)
  {
    boolean bool;
    if ((0xFFFFFFFF & paramLong) == paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    n.h(bool, "value (%s) is outside the range for an unsigned integer value", paramLong);
    return fromIntBits((int)paramLong);
  }
  
  public static UnsignedInteger valueOf(String paramString)
  {
    return valueOf(paramString, 10);
  }
  
  public static UnsignedInteger valueOf(String paramString, int paramInt)
  {
    return fromIntBits(i.d(paramString, paramInt));
  }
  
  public static UnsignedInteger valueOf(BigInteger paramBigInteger)
  {
    n.o(paramBigInteger);
    boolean bool;
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 32)) {
      bool = true;
    } else {
      bool = false;
    }
    n.j(bool, "value (%s) is outside the range for an unsigned integer value", paramBigInteger);
    return fromIntBits(paramBigInteger.intValue());
  }
  
  public BigInteger bigIntegerValue()
  {
    return BigInteger.valueOf(longValue());
  }
  
  public int compareTo(UnsignedInteger paramUnsignedInteger)
  {
    n.o(paramUnsignedInteger);
    return i.a(this.value, paramUnsignedInteger.value);
  }
  
  public UnsignedInteger dividedBy(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(i.b(this.value, ((UnsignedInteger)n.o(paramUnsignedInteger)).value));
  }
  
  public double doubleValue()
  {
    return longValue();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof UnsignedInteger;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (UnsignedInteger)paramObject;
      bool3 = bool2;
      if (this.value == ((UnsignedInteger)paramObject).value) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public float floatValue()
  {
    return (float)longValue();
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return i.f(this.value);
  }
  
  public UnsignedInteger minus(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(this.value - ((UnsignedInteger)n.o(paramUnsignedInteger)).value);
  }
  
  public UnsignedInteger mod(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(i.e(this.value, ((UnsignedInteger)n.o(paramUnsignedInteger)).value));
  }
  
  public UnsignedInteger plus(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(this.value + ((UnsignedInteger)n.o(paramUnsignedInteger)).value);
  }
  
  public UnsignedInteger times(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(this.value * ((UnsignedInteger)n.o(paramUnsignedInteger)).value);
  }
  
  public String toString()
  {
    return toString(10);
  }
  
  public String toString(int paramInt)
  {
    return i.g(this.value, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\UnsignedInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */