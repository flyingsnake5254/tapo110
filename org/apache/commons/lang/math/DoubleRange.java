package org.apache.commons.lang.math;

import java.io.Serializable;

public final class DoubleRange
  extends b
  implements Serializable
{
  private static final long serialVersionUID = 71849363892740L;
  private transient int hashCode = 0;
  private final double max;
  private transient Double maxObject = null;
  private final double min;
  private transient Double minObject = null;
  private transient String toString = null;
  
  public DoubleRange(double paramDouble)
  {
    if (!Double.isNaN(paramDouble))
    {
      this.min = paramDouble;
      this.max = paramDouble;
      return;
    }
    throw new IllegalArgumentException("The number must not be NaN");
  }
  
  public DoubleRange(double paramDouble1, double paramDouble2)
  {
    if ((!Double.isNaN(paramDouble1)) && (!Double.isNaN(paramDouble2)))
    {
      if (paramDouble2 < paramDouble1)
      {
        this.min = paramDouble2;
        this.max = paramDouble1;
      }
      else
      {
        this.min = paramDouble1;
        this.max = paramDouble2;
      }
      return;
    }
    throw new IllegalArgumentException("The numbers must not be NaN");
  }
  
  public DoubleRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      double d1 = paramNumber.doubleValue();
      this.min = d1;
      double d2 = paramNumber.doubleValue();
      this.max = d2;
      if ((!Double.isNaN(d1)) && (!Double.isNaN(d2)))
      {
        if ((paramNumber instanceof Double))
        {
          paramNumber = (Double)paramNumber;
          this.minObject = paramNumber;
          this.maxObject = paramNumber;
        }
        return;
      }
      throw new IllegalArgumentException("The number must not be NaN");
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public DoubleRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      double d1 = paramNumber1.doubleValue();
      double d2 = paramNumber2.doubleValue();
      if ((!Double.isNaN(d1)) && (!Double.isNaN(d2)))
      {
        if (d2 < d1)
        {
          this.min = d2;
          this.max = d1;
          if ((paramNumber2 instanceof Double)) {
            this.minObject = ((Double)paramNumber2);
          }
          if ((paramNumber1 instanceof Double)) {
            this.maxObject = ((Double)paramNumber1);
          }
        }
        else
        {
          this.min = d1;
          this.max = d2;
          if ((paramNumber1 instanceof Double)) {
            this.minObject = ((Double)paramNumber1);
          }
          if ((paramNumber2 instanceof Double)) {
            this.maxObject = ((Double)paramNumber2);
          }
        }
        return;
      }
      throw new IllegalArgumentException("The numbers must not be NaN");
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsDouble(double paramDouble)
  {
    boolean bool;
    if ((paramDouble >= this.min) && (paramDouble <= this.max)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsNumber(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsDouble(paramNumber.doubleValue());
  }
  
  public boolean containsRange(b paramb)
  {
    boolean bool1 = false;
    if (paramb == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (containsDouble(paramb.getMinimumDouble()))
    {
      bool2 = bool1;
      if (containsDouble(paramb.getMaximumDouble())) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DoubleRange)) {
      return false;
    }
    paramObject = (DoubleRange)paramObject;
    if ((Double.doubleToLongBits(this.min) != Double.doubleToLongBits(((DoubleRange)paramObject).min)) || (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(((DoubleRange)paramObject).max))) {
      bool = false;
    }
    return bool;
  }
  
  public double getMaximumDouble()
  {
    return this.max;
  }
  
  public float getMaximumFloat()
  {
    return (float)this.max;
  }
  
  public int getMaximumInteger()
  {
    return (int)this.max;
  }
  
  public long getMaximumLong()
  {
    return this.max;
  }
  
  public Number getMaximumNumber()
  {
    if (this.maxObject == null) {
      this.maxObject = new Double(this.max);
    }
    return this.maxObject;
  }
  
  public double getMinimumDouble()
  {
    return this.min;
  }
  
  public float getMinimumFloat()
  {
    return (float)this.min;
  }
  
  public int getMinimumInteger()
  {
    return (int)this.min;
  }
  
  public long getMinimumLong()
  {
    return this.min;
  }
  
  public Number getMinimumNumber()
  {
    if (this.minObject == null) {
      this.minObject = new Double(this.min);
    }
    return this.minObject;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      this.hashCode = (17 * 37 + DoubleRange.class.hashCode());
      long l = Double.doubleToLongBits(this.min);
      this.hashCode = (this.hashCode * 37 + (int)(l ^ l >> 32));
      l = Double.doubleToLongBits(this.max);
      this.hashCode = (this.hashCode * 37 + (int)(l ^ l >> 32));
    }
    return this.hashCode;
  }
  
  public boolean overlapsRange(b paramb)
  {
    boolean bool = false;
    if (paramb == null) {
      return false;
    }
    if ((paramb.containsDouble(this.min)) || (paramb.containsDouble(this.max)) || (containsDouble(paramb.getMinimumDouble()))) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    if (this.toString == null)
    {
      org.apache.commons.lang.text.b localb = new org.apache.commons.lang.text.b(32);
      localb.f("Range[");
      localb.b(this.min);
      localb.a(',');
      localb.b(this.max);
      localb.a(']');
      this.toString = localb.toString();
    }
    return this.toString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\DoubleRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */