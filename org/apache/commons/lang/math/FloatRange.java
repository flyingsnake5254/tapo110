package org.apache.commons.lang.math;

import java.io.Serializable;

public final class FloatRange
  extends b
  implements Serializable
{
  private static final long serialVersionUID = 71849363892750L;
  private transient int hashCode = 0;
  private final float max;
  private transient Float maxObject = null;
  private final float min;
  private transient Float minObject = null;
  private transient String toString = null;
  
  public FloatRange(float paramFloat)
  {
    if (!Float.isNaN(paramFloat))
    {
      this.min = paramFloat;
      this.max = paramFloat;
      return;
    }
    throw new IllegalArgumentException("The number must not be NaN");
  }
  
  public FloatRange(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2)))
    {
      if (paramFloat2 < paramFloat1)
      {
        this.min = paramFloat2;
        this.max = paramFloat1;
      }
      else
      {
        this.min = paramFloat1;
        this.max = paramFloat2;
      }
      return;
    }
    throw new IllegalArgumentException("The numbers must not be NaN");
  }
  
  public FloatRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      float f1 = paramNumber.floatValue();
      this.min = f1;
      float f2 = paramNumber.floatValue();
      this.max = f2;
      if ((!Float.isNaN(f1)) && (!Float.isNaN(f2)))
      {
        if ((paramNumber instanceof Float))
        {
          paramNumber = (Float)paramNumber;
          this.minObject = paramNumber;
          this.maxObject = paramNumber;
        }
        return;
      }
      throw new IllegalArgumentException("The number must not be NaN");
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public FloatRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      float f1 = paramNumber1.floatValue();
      float f2 = paramNumber2.floatValue();
      if ((!Float.isNaN(f1)) && (!Float.isNaN(f2)))
      {
        if (f2 < f1)
        {
          this.min = f2;
          this.max = f1;
          if ((paramNumber2 instanceof Float)) {
            this.minObject = ((Float)paramNumber2);
          }
          if ((paramNumber1 instanceof Float)) {
            this.maxObject = ((Float)paramNumber1);
          }
        }
        else
        {
          this.min = f1;
          this.max = f2;
          if ((paramNumber1 instanceof Float)) {
            this.minObject = ((Float)paramNumber1);
          }
          if ((paramNumber2 instanceof Float)) {
            this.maxObject = ((Float)paramNumber2);
          }
        }
        return;
      }
      throw new IllegalArgumentException("The numbers must not be NaN");
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsFloat(float paramFloat)
  {
    boolean bool;
    if ((paramFloat >= this.min) && (paramFloat <= this.max)) {
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
    return containsFloat(paramNumber.floatValue());
  }
  
  public boolean containsRange(b paramb)
  {
    boolean bool1 = false;
    if (paramb == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (containsFloat(paramb.getMinimumFloat()))
    {
      bool2 = bool1;
      if (containsFloat(paramb.getMaximumFloat())) {
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
    if (!(paramObject instanceof FloatRange)) {
      return false;
    }
    paramObject = (FloatRange)paramObject;
    if ((Float.floatToIntBits(this.min) != Float.floatToIntBits(((FloatRange)paramObject).min)) || (Float.floatToIntBits(this.max) != Float.floatToIntBits(((FloatRange)paramObject).max))) {
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
    return this.max;
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
      this.maxObject = new Float(this.max);
    }
    return this.maxObject;
  }
  
  public double getMinimumDouble()
  {
    return this.min;
  }
  
  public float getMinimumFloat()
  {
    return this.min;
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
      this.minObject = new Float(this.min);
    }
    return this.minObject;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      int i = 17 * 37 + FloatRange.class.hashCode();
      this.hashCode = i;
      i = i * 37 + Float.floatToIntBits(this.min);
      this.hashCode = i;
      this.hashCode = (i * 37 + Float.floatToIntBits(this.max));
    }
    return this.hashCode;
  }
  
  public boolean overlapsRange(b paramb)
  {
    boolean bool = false;
    if (paramb == null) {
      return false;
    }
    if ((paramb.containsFloat(this.min)) || (paramb.containsFloat(this.max)) || (containsFloat(paramb.getMinimumFloat()))) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    if (this.toString == null)
    {
      StringBuffer localStringBuffer = new StringBuffer(32);
      localStringBuffer.append("Range[");
      localStringBuffer.append(this.min);
      localStringBuffer.append(',');
      localStringBuffer.append(this.max);
      localStringBuffer.append(']');
      this.toString = localStringBuffer.toString();
    }
    return this.toString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\FloatRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */