package org.apache.commons.lang.mutable;

import org.apache.commons.lang.math.a;

public class MutableDouble
  extends Number
  implements Comparable
{
  private static final long serialVersionUID = 1587163916L;
  private double value;
  
  public MutableDouble() {}
  
  public MutableDouble(double paramDouble)
  {
    this.value = paramDouble;
  }
  
  public MutableDouble(Number paramNumber)
  {
    this.value = paramNumber.doubleValue();
  }
  
  public MutableDouble(String paramString)
    throws NumberFormatException
  {
    this.value = Double.parseDouble(paramString);
  }
  
  public void add(double paramDouble)
  {
    this.value += paramDouble;
  }
  
  public void add(Number paramNumber)
  {
    this.value += paramNumber.doubleValue();
  }
  
  public int compareTo(Object paramObject)
  {
    double d = ((MutableDouble)paramObject).value;
    return a.a(this.value, d);
  }
  
  public void decrement()
  {
    this.value -= 1.0D;
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof MutableDouble)) && (Double.doubleToLongBits(((MutableDouble)paramObject).value) == Double.doubleToLongBits(this.value))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public float floatValue()
  {
    return (float)this.value;
  }
  
  public Object getValue()
  {
    return new Double(this.value);
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.value);
    return (int)(l ^ l >>> 32);
  }
  
  public void increment()
  {
    this.value += 1.0D;
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public boolean isInfinite()
  {
    return Double.isInfinite(this.value);
  }
  
  public boolean isNaN()
  {
    return Double.isNaN(this.value);
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(double paramDouble)
  {
    this.value = paramDouble;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Number)paramObject).doubleValue());
  }
  
  public void subtract(double paramDouble)
  {
    this.value -= paramDouble;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value -= paramNumber.doubleValue();
  }
  
  public Double toDouble()
  {
    return new Double(doubleValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\mutable\MutableDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */