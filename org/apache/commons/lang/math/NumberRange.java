package org.apache.commons.lang.math;

import java.io.Serializable;

public final class NumberRange
  extends b
  implements Serializable
{
  private static final long serialVersionUID = 71849363892710L;
  private transient int hashCode = 0;
  private final Number max;
  private final Number min;
  private transient String toString = null;
  
  public NumberRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      if ((paramNumber instanceof Comparable))
      {
        if (((paramNumber instanceof Double)) && (((Double)paramNumber).isNaN())) {
          throw new IllegalArgumentException("The number must not be NaN");
        }
        if (((paramNumber instanceof Float)) && (((Float)paramNumber).isNaN())) {
          throw new IllegalArgumentException("The number must not be NaN");
        }
        this.min = paramNumber;
        this.max = paramNumber;
        return;
      }
      throw new IllegalArgumentException("The number must implement Comparable");
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public NumberRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      if (paramNumber1.getClass() == paramNumber2.getClass())
      {
        if ((paramNumber1 instanceof Comparable))
        {
          if ((paramNumber1 instanceof Double))
          {
            if ((((Double)paramNumber1).isNaN()) || (((Double)paramNumber2).isNaN())) {
              throw new IllegalArgumentException("The number must not be NaN");
            }
          }
          else if (((paramNumber1 instanceof Float)) && ((((Float)paramNumber1).isNaN()) || (((Float)paramNumber2).isNaN()))) {
            throw new IllegalArgumentException("The number must not be NaN");
          }
          int i = ((Comparable)paramNumber1).compareTo(paramNumber2);
          if (i == 0)
          {
            this.min = paramNumber1;
            this.max = paramNumber1;
          }
          else if (i > 0)
          {
            this.min = paramNumber2;
            this.max = paramNumber1;
          }
          else
          {
            this.min = paramNumber1;
            this.max = paramNumber2;
          }
          return;
        }
        throw new IllegalArgumentException("The numbers must implement Comparable");
      }
      throw new IllegalArgumentException("The numbers must be of the same type");
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsNumber(Number paramNumber)
  {
    boolean bool1 = false;
    if (paramNumber == null) {
      return false;
    }
    if (paramNumber.getClass() == this.min.getClass())
    {
      int i = ((Comparable)this.min).compareTo(paramNumber);
      int j = ((Comparable)this.max).compareTo(paramNumber);
      boolean bool2 = bool1;
      if (i <= 0)
      {
        bool2 = bool1;
        if (j >= 0) {
          bool2 = true;
        }
      }
      return bool2;
    }
    throw new IllegalArgumentException("The number must be of the same type as the range numbers");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof NumberRange)) {
      return false;
    }
    paramObject = (NumberRange)paramObject;
    if ((!this.min.equals(((NumberRange)paramObject).min)) || (!this.max.equals(((NumberRange)paramObject).max))) {
      bool = false;
    }
    return bool;
  }
  
  public Number getMaximumNumber()
  {
    return this.max;
  }
  
  public Number getMinimumNumber()
  {
    return this.min;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      int i = 17 * 37 + NumberRange.class.hashCode();
      this.hashCode = i;
      i = i * 37 + this.min.hashCode();
      this.hashCode = i;
      this.hashCode = (i * 37 + this.max.hashCode());
    }
    return this.hashCode;
  }
  
  public String toString()
  {
    if (this.toString == null)
    {
      org.apache.commons.lang.text.b localb = new org.apache.commons.lang.text.b(32);
      localb.f("Range[");
      localb.e(this.min);
      localb.a(',');
      localb.e(this.max);
      localb.a(']');
      this.toString = localb.toString();
    }
    return this.toString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\NumberRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */