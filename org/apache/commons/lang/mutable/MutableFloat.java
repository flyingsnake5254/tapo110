package org.apache.commons.lang.mutable;

import org.apache.commons.lang.math.a;

public class MutableFloat
  extends Number
  implements Comparable
{
  private static final long serialVersionUID = 5787169186L;
  private float value;
  
  public MutableFloat() {}
  
  public MutableFloat(float paramFloat)
  {
    this.value = paramFloat;
  }
  
  public MutableFloat(Number paramNumber)
  {
    this.value = paramNumber.floatValue();
  }
  
  public MutableFloat(String paramString)
    throws NumberFormatException
  {
    this.value = Float.parseFloat(paramString);
  }
  
  public void add(float paramFloat)
  {
    this.value += paramFloat;
  }
  
  public void add(Number paramNumber)
  {
    this.value += paramNumber.floatValue();
  }
  
  public int compareTo(Object paramObject)
  {
    float f = ((MutableFloat)paramObject).value;
    return a.b(this.value, f);
  }
  
  public void decrement()
  {
    this.value -= 1.0F;
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof MutableFloat)) && (Float.floatToIntBits(((MutableFloat)paramObject).value) == Float.floatToIntBits(this.value))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public Object getValue()
  {
    return new Float(this.value);
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.value);
  }
  
  public void increment()
  {
    this.value += 1.0F;
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public boolean isInfinite()
  {
    return Float.isInfinite(this.value);
  }
  
  public boolean isNaN()
  {
    return Float.isNaN(this.value);
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(float paramFloat)
  {
    this.value = paramFloat;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Number)paramObject).floatValue());
  }
  
  public void subtract(float paramFloat)
  {
    this.value -= paramFloat;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value -= paramNumber.floatValue();
  }
  
  public Float toFloat()
  {
    return new Float(floatValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\mutable\MutableFloat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */