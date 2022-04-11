package org.apache.commons.lang.math;

import java.math.BigInteger;
import org.apache.commons.lang.text.b;

public final class Fraction
  extends Number
  implements Comparable
{
  public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
  public static final Fraction ONE;
  public static final Fraction ONE_FIFTH;
  public static final Fraction ONE_HALF;
  public static final Fraction ONE_QUARTER;
  public static final Fraction ONE_THIRD;
  public static final Fraction THREE_FIFTHS;
  public static final Fraction THREE_QUARTERS;
  public static final Fraction TWO_FIFTHS;
  public static final Fraction TWO_QUARTERS;
  public static final Fraction TWO_THIRDS;
  public static final Fraction ZERO = new Fraction(0, 1);
  private static final long serialVersionUID = 65382027393090L;
  private final int denominator;
  private transient int hashCode = 0;
  private final int numerator;
  private transient String toProperString = null;
  private transient String toString = null;
  
  static
  {
    ONE = new Fraction(1, 1);
    ONE_HALF = new Fraction(1, 2);
    ONE_THIRD = new Fraction(1, 3);
    TWO_THIRDS = new Fraction(2, 3);
    ONE_QUARTER = new Fraction(1, 4);
    TWO_QUARTERS = new Fraction(2, 4);
    THREE_QUARTERS = new Fraction(3, 4);
    ONE_FIFTH = new Fraction(1, 5);
    TWO_FIFTHS = new Fraction(2, 5);
    THREE_FIFTHS = new Fraction(3, 5);
  }
  
  private Fraction(int paramInt1, int paramInt2)
  {
    this.numerator = paramInt1;
    this.denominator = paramInt2;
  }
  
  private static int addAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 + paramInt2;
    if ((l >= -2147483648L) && (l <= 2147483647L)) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: add");
  }
  
  private Fraction addSub(Fraction paramFraction, boolean paramBoolean)
  {
    if (paramFraction != null)
    {
      if (this.numerator == 0)
      {
        if (!paramBoolean) {
          paramFraction = paramFraction.negate();
        }
        return paramFraction;
      }
      if (paramFraction.numerator == 0) {
        return this;
      }
      int i = greatestCommonDivisor(this.denominator, paramFraction.denominator);
      if (i == 1)
      {
        i = mulAndCheck(this.numerator, paramFraction.denominator);
        j = mulAndCheck(paramFraction.numerator, this.denominator);
        if (paramBoolean) {
          j = addAndCheck(i, j);
        } else {
          j = subAndCheck(i, j);
        }
        return new Fraction(j, mulPosAndCheck(this.denominator, paramFraction.denominator));
      }
      BigInteger localBigInteger1 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(paramFraction.denominator / i));
      BigInteger localBigInteger2 = BigInteger.valueOf(paramFraction.numerator).multiply(BigInteger.valueOf(this.denominator / i));
      if (paramBoolean) {
        localBigInteger2 = localBigInteger1.add(localBigInteger2);
      } else {
        localBigInteger2 = localBigInteger1.subtract(localBigInteger2);
      }
      int j = localBigInteger2.mod(BigInteger.valueOf(i)).intValue();
      if (j == 0) {
        j = i;
      } else {
        j = greatestCommonDivisor(j, i);
      }
      localBigInteger2 = localBigInteger2.divide(BigInteger.valueOf(j));
      if (localBigInteger2.bitLength() <= 31) {
        return new Fraction(localBigInteger2.intValue(), mulPosAndCheck(this.denominator / i, paramFraction.denominator / j));
      }
      throw new ArithmeticException("overflow: numerator too large after multiply");
    }
    throw new IllegalArgumentException("The fraction must not be null");
  }
  
  public static Fraction getFraction(double paramDouble)
  {
    int i;
    if (paramDouble < 0.0D) {
      i = -1;
    } else {
      i = 1;
    }
    paramDouble = Math.abs(paramDouble);
    if ((paramDouble <= 2.147483647E9D) && (!Double.isNaN(paramDouble)))
    {
      int j = (int)paramDouble;
      double d1 = paramDouble - j;
      int k = (int)d1;
      double d2 = 1.0D;
      paramDouble = d1 - k;
      double d3 = Double.MAX_VALUE;
      int m = 1;
      int n = 0;
      int i1 = 0;
      int i2 = 1;
      int i3 = 1;
      for (;;)
      {
        double d4 = d3;
        double d5 = d2;
        int i4 = (int)(d5 / paramDouble);
        double d6 = i4;
        int i5 = k * m + n;
        i2 = k * i1 + i2;
        d3 = Math.abs(d1 - i5 / i2);
        i3++;
        if ((d4 <= d3) || (i2 > 10000) || (i2 <= 0) || (i3 >= 25)) {
          break;
        }
        k = i4;
        n = m;
        m = i5;
        i5 = i1;
        d2 = paramDouble;
        paramDouble = d5 - d6 * paramDouble;
        i1 = i2;
        i2 = i5;
      }
      if (i3 != 25) {
        return getReducedFraction((m + j * i1) * i, i1);
      }
      throw new ArithmeticException("Unable to convert double to fraction");
    }
    throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
  }
  
  public static Fraction getFraction(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      int i = paramInt1;
      int j = paramInt2;
      if (paramInt2 < 0) {
        if ((paramInt1 != Integer.MIN_VALUE) && (paramInt2 != Integer.MIN_VALUE))
        {
          i = -paramInt1;
          j = -paramInt2;
        }
        else
        {
          throw new ArithmeticException("overflow: can't negate");
        }
      }
      return new Fraction(i, j);
    }
    throw new ArithmeticException("The denominator must not be zero");
  }
  
  public static Fraction getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 >= 0)
      {
        if (paramInt2 >= 0)
        {
          long l;
          if (paramInt1 < 0) {
            l = paramInt1 * paramInt3 - paramInt2;
          } else {
            l = paramInt1 * paramInt3 + paramInt2;
          }
          if ((l >= -2147483648L) && (l <= 2147483647L)) {
            return new Fraction((int)l, paramInt3);
          }
          throw new ArithmeticException("Numerator too large to represent as an Integer.");
        }
        throw new ArithmeticException("The numerator must not be negative");
      }
      throw new ArithmeticException("The denominator must not be negative");
    }
    throw new ArithmeticException("The denominator must not be zero");
  }
  
  public static Fraction getFraction(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.indexOf('.') >= 0) {
        return getFraction(Double.parseDouble(paramString));
      }
      int i = paramString.indexOf(' ');
      if (i > 0)
      {
        j = Integer.parseInt(paramString.substring(0, i));
        paramString = paramString.substring(i + 1);
        i = paramString.indexOf('/');
        if (i >= 0) {
          return getFraction(j, Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
        }
        throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
      }
      int j = paramString.indexOf('/');
      if (j < 0) {
        return getFraction(Integer.parseInt(paramString), 1);
      }
      return getFraction(Integer.parseInt(paramString.substring(0, j)), Integer.parseInt(paramString.substring(j + 1)));
    }
    throw new IllegalArgumentException("The string must not be null");
  }
  
  public static Fraction getReducedFraction(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt1 == 0) {
        return ZERO;
      }
      int i = paramInt1;
      int j = paramInt2;
      if (paramInt2 == Integer.MIN_VALUE)
      {
        i = paramInt1;
        j = paramInt2;
        if ((paramInt1 & 0x1) == 0)
        {
          i = paramInt1 / 2;
          j = paramInt2 / 2;
        }
      }
      paramInt1 = i;
      paramInt2 = j;
      if (j < 0) {
        if ((i != Integer.MIN_VALUE) && (j != Integer.MIN_VALUE))
        {
          paramInt1 = -i;
          paramInt2 = -j;
        }
        else
        {
          throw new ArithmeticException("overflow: can't negate");
        }
      }
      j = greatestCommonDivisor(paramInt1, paramInt2);
      return new Fraction(paramInt1 / j, paramInt2 / j);
    }
    throw new ArithmeticException("The denominator must not be zero");
  }
  
  private static int greatestCommonDivisor(int paramInt1, int paramInt2)
  {
    if ((Math.abs(paramInt1) > 1) && (Math.abs(paramInt2) > 1))
    {
      int i = paramInt1;
      if (paramInt1 > 0) {
        i = -paramInt1;
      }
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {
        paramInt1 = -paramInt2;
      }
      int j = 0;
      paramInt2 = paramInt1;
      for (;;)
      {
        paramInt1 = i & 0x1;
        if ((paramInt1 != 0) || ((paramInt2 & 0x1) != 0) || (j >= 31)) {
          break;
        }
        i /= 2;
        paramInt2 /= 2;
        j++;
      }
      if (j != 31)
      {
        if (paramInt1 == 1) {
          paramInt1 = paramInt2;
        } else {
          paramInt1 = -(i / 2);
        }
        int k;
        int m;
        do
        {
          while ((paramInt1 & 0x1) == 0) {
            paramInt1 /= 2;
          }
          if (paramInt1 > 0)
          {
            k = -paramInt1;
          }
          else
          {
            paramInt2 = paramInt1;
            k = i;
          }
          m = (paramInt2 - k) / 2;
          paramInt1 = m;
          i = k;
        } while (m != 0);
        return -k * (1 << j);
      }
      throw new ArithmeticException("overflow: gcd is 2^31");
    }
    return 1;
  }
  
  private static int mulAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    if ((l >= -2147483648L) && (l <= 2147483647L)) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: mul");
  }
  
  private static int mulPosAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    if (l <= 2147483647L) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: mulPos");
  }
  
  private static int subAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 - paramInt2;
    if ((l >= -2147483648L) && (l <= 2147483647L)) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: add");
  }
  
  public Fraction abs()
  {
    if (this.numerator >= 0) {
      return this;
    }
    return negate();
  }
  
  public Fraction add(Fraction paramFraction)
  {
    return addSub(paramFraction, true);
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (Fraction)paramObject;
    if (this == paramObject) {
      return 0;
    }
    int i = this.numerator;
    int j = ((Fraction)paramObject).numerator;
    if ((i == j) && (this.denominator == ((Fraction)paramObject).denominator)) {
      return 0;
    }
    boolean bool = i * ((Fraction)paramObject).denominator < j * this.denominator;
    if (!bool) {
      return 0;
    }
    if (bool) {
      return -1;
    }
    return 1;
  }
  
  public Fraction divideBy(Fraction paramFraction)
  {
    if (paramFraction != null)
    {
      if (paramFraction.numerator != 0) {
        return multiplyBy(paramFraction.invert());
      }
      throw new ArithmeticException("The fraction to divide by must not be zero");
    }
    throw new IllegalArgumentException("The fraction must not be null");
  }
  
  public double doubleValue()
  {
    return this.numerator / this.denominator;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Fraction)) {
      return false;
    }
    paramObject = (Fraction)paramObject;
    if ((getNumerator() != ((Fraction)paramObject).getNumerator()) || (getDenominator() != ((Fraction)paramObject).getDenominator())) {
      bool = false;
    }
    return bool;
  }
  
  public float floatValue()
  {
    return this.numerator / this.denominator;
  }
  
  public int getDenominator()
  {
    return this.denominator;
  }
  
  public int getNumerator()
  {
    return this.numerator;
  }
  
  public int getProperNumerator()
  {
    return Math.abs(this.numerator % this.denominator);
  }
  
  public int getProperWhole()
  {
    return this.numerator / this.denominator;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = ((getNumerator() + 629) * 37 + getDenominator());
    }
    return this.hashCode;
  }
  
  public int intValue()
  {
    return this.numerator / this.denominator;
  }
  
  public Fraction invert()
  {
    int i = this.numerator;
    if (i != 0)
    {
      if (i != Integer.MIN_VALUE)
      {
        if (i < 0) {
          return new Fraction(-this.denominator, -i);
        }
        return new Fraction(this.denominator, i);
      }
      throw new ArithmeticException("overflow: can't negate numerator");
    }
    throw new ArithmeticException("Unable to invert zero.");
  }
  
  public long longValue()
  {
    return this.numerator / this.denominator;
  }
  
  public Fraction multiplyBy(Fraction paramFraction)
  {
    if (paramFraction != null)
    {
      int i = this.numerator;
      if ((i != 0) && (paramFraction.numerator != 0))
      {
        int j = greatestCommonDivisor(i, paramFraction.denominator);
        i = greatestCommonDivisor(paramFraction.numerator, this.denominator);
        return getReducedFraction(mulAndCheck(this.numerator / j, paramFraction.numerator / i), mulPosAndCheck(this.denominator / i, paramFraction.denominator / j));
      }
      return ZERO;
    }
    throw new IllegalArgumentException("The fraction must not be null");
  }
  
  public Fraction negate()
  {
    int i = this.numerator;
    if (i != Integer.MIN_VALUE) {
      return new Fraction(-i, this.denominator);
    }
    throw new ArithmeticException("overflow: too large to negate");
  }
  
  public Fraction pow(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    if (paramInt == 0) {
      return ONE;
    }
    if (paramInt < 0)
    {
      if (paramInt == Integer.MIN_VALUE) {
        return invert().pow(2).pow(-(paramInt / 2));
      }
      return invert().pow(-paramInt);
    }
    Fraction localFraction = multiplyBy(this);
    if (paramInt % 2 == 0) {
      return localFraction.pow(paramInt / 2);
    }
    paramInt /= 2;
    try
    {
      localFraction = localFraction.pow(paramInt);
      return localFraction.multiplyBy(this);
    }
    finally {}
  }
  
  public Fraction reduce()
  {
    int i = this.numerator;
    if (i == 0)
    {
      Fraction localFraction1 = ZERO;
      Fraction localFraction2 = localFraction1;
      if (equals(localFraction1)) {
        localFraction2 = this;
      }
      return localFraction2;
    }
    i = greatestCommonDivisor(Math.abs(i), this.denominator);
    if (i == 1) {
      return this;
    }
    return getFraction(this.numerator / i, this.denominator / i);
  }
  
  public Fraction subtract(Fraction paramFraction)
  {
    return addSub(paramFraction, false);
  }
  
  public String toProperString()
  {
    if (this.toProperString == null)
    {
      int i = this.numerator;
      if (i == 0)
      {
        this.toProperString = "0";
      }
      else
      {
        int j = this.denominator;
        if (i == j)
        {
          this.toProperString = "1";
        }
        else if (i == j * -1)
        {
          this.toProperString = "-1";
        }
        else
        {
          int k = i;
          if (i > 0) {
            k = -i;
          }
          if (k < -j)
          {
            k = getProperNumerator();
            if (k == 0) {
              this.toProperString = Integer.toString(getProperWhole());
            } else {
              this.toProperString = new b(32).c(getProperWhole()).a(' ').c(k).a('/').c(getDenominator()).toString();
            }
          }
          else
          {
            this.toProperString = new b(32).c(getNumerator()).a('/').c(getDenominator()).toString();
          }
        }
      }
    }
    return this.toProperString;
  }
  
  public String toString()
  {
    if (this.toString == null) {
      this.toString = new b(32).c(getNumerator()).a('/').c(getDenominator()).toString();
    }
    return this.toString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\Fraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */