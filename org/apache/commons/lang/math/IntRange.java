package org.apache.commons.lang.math;

import java.io.Serializable;

public final class IntRange
  extends b
  implements Serializable
{
  private static final long serialVersionUID = 71849363892730L;
  private transient int hashCode = 0;
  private final int max;
  private transient Integer maxObject = null;
  private final int min;
  private transient Integer minObject = null;
  private transient String toString = null;
  
  public IntRange(int paramInt)
  {
    this.min = paramInt;
    this.max = paramInt;
  }
  
  public IntRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
    {
      this.min = paramInt2;
      this.max = paramInt1;
    }
    else
    {
      this.min = paramInt1;
      this.max = paramInt2;
    }
  }
  
  public IntRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      this.min = paramNumber.intValue();
      this.max = paramNumber.intValue();
      if ((paramNumber instanceof Integer))
      {
        paramNumber = (Integer)paramNumber;
        this.minObject = paramNumber;
        this.maxObject = paramNumber;
      }
      return;
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public IntRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      int i = paramNumber1.intValue();
      int j = paramNumber2.intValue();
      if (j < i)
      {
        this.min = j;
        this.max = i;
        if ((paramNumber2 instanceof Integer)) {
          this.minObject = ((Integer)paramNumber2);
        }
        if ((paramNumber1 instanceof Integer)) {
          this.maxObject = ((Integer)paramNumber1);
        }
      }
      else
      {
        this.min = i;
        this.max = j;
        if ((paramNumber1 instanceof Integer)) {
          this.minObject = ((Integer)paramNumber1);
        }
        if ((paramNumber2 instanceof Integer)) {
          this.maxObject = ((Integer)paramNumber2);
        }
      }
      return;
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsInteger(int paramInt)
  {
    boolean bool;
    if ((paramInt >= this.min) && (paramInt <= this.max)) {
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
    return containsInteger(paramNumber.intValue());
  }
  
  public boolean containsRange(b paramb)
  {
    boolean bool1 = false;
    if (paramb == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (containsInteger(paramb.getMinimumInteger()))
    {
      bool2 = bool1;
      if (containsInteger(paramb.getMaximumInteger())) {
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
    if (!(paramObject instanceof IntRange)) {
      return false;
    }
    paramObject = (IntRange)paramObject;
    if ((this.min != ((IntRange)paramObject).min) || (this.max != ((IntRange)paramObject).max)) {
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
    return this.max;
  }
  
  public long getMaximumLong()
  {
    return this.max;
  }
  
  public Number getMaximumNumber()
  {
    if (this.maxObject == null) {
      this.maxObject = new Integer(this.max);
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
    return this.min;
  }
  
  public long getMinimumLong()
  {
    return this.min;
  }
  
  public Number getMinimumNumber()
  {
    if (this.minObject == null) {
      this.minObject = new Integer(this.min);
    }
    return this.minObject;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      int i = 17 * 37 + IntRange.class.hashCode();
      this.hashCode = i;
      i = i * 37 + this.min;
      this.hashCode = i;
      this.hashCode = (i * 37 + this.max);
    }
    return this.hashCode;
  }
  
  public boolean overlapsRange(b paramb)
  {
    boolean bool = false;
    if (paramb == null) {
      return false;
    }
    if ((paramb.containsInteger(this.min)) || (paramb.containsInteger(this.max)) || (containsInteger(paramb.getMinimumInteger()))) {
      bool = true;
    }
    return bool;
  }
  
  public int[] toArray()
  {
    int i = this.max - this.min + 1;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = (this.min + j);
    }
    return arrayOfInt;
  }
  
  public String toString()
  {
    if (this.toString == null)
    {
      org.apache.commons.lang.text.b localb = new org.apache.commons.lang.text.b(32);
      localb.f("Range[");
      localb.c(this.min);
      localb.a(',');
      localb.c(this.max);
      localb.a(']');
      this.toString = localb.toString();
    }
    return this.toString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\IntRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */