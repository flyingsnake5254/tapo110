package org.apache.commons.lang.math;

public abstract class b
{
  public boolean containsDouble(double paramDouble)
  {
    int i = a.a(getMinimumDouble(), paramDouble);
    int j = a.a(getMaximumDouble(), paramDouble);
    boolean bool;
    if ((i <= 0) && (j >= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsDouble(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsDouble(paramNumber.doubleValue());
  }
  
  public boolean containsFloat(float paramFloat)
  {
    int i = a.b(getMinimumFloat(), paramFloat);
    int j = a.b(getMaximumFloat(), paramFloat);
    boolean bool;
    if ((i <= 0) && (j >= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsFloat(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsFloat(paramNumber.floatValue());
  }
  
  public boolean containsInteger(int paramInt)
  {
    boolean bool;
    if ((paramInt >= getMinimumInteger()) && (paramInt <= getMaximumInteger())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsInteger(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsInteger(paramNumber.intValue());
  }
  
  public boolean containsLong(long paramLong)
  {
    boolean bool;
    if ((paramLong >= getMinimumLong()) && (paramLong <= getMaximumLong())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsLong(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsLong(paramNumber.longValue());
  }
  
  public abstract boolean containsNumber(Number paramNumber);
  
  public boolean containsRange(b paramb)
  {
    boolean bool1 = false;
    if (paramb == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (containsNumber(paramb.getMinimumNumber()))
    {
      bool2 = bool1;
      if (containsNumber(paramb.getMaximumNumber())) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public abstract boolean equals(Object paramObject);
  
  public double getMaximumDouble()
  {
    return getMaximumNumber().doubleValue();
  }
  
  public float getMaximumFloat()
  {
    return getMaximumNumber().floatValue();
  }
  
  public int getMaximumInteger()
  {
    return getMaximumNumber().intValue();
  }
  
  public long getMaximumLong()
  {
    return getMaximumNumber().longValue();
  }
  
  public abstract Number getMaximumNumber();
  
  public double getMinimumDouble()
  {
    return getMinimumNumber().doubleValue();
  }
  
  public float getMinimumFloat()
  {
    return getMinimumNumber().floatValue();
  }
  
  public int getMinimumInteger()
  {
    return getMinimumNumber().intValue();
  }
  
  public long getMinimumLong()
  {
    return getMinimumNumber().longValue();
  }
  
  public abstract Number getMinimumNumber();
  
  public abstract int hashCode();
  
  public boolean overlapsRange(b paramb)
  {
    boolean bool = false;
    if (paramb == null) {
      return false;
    }
    if ((paramb.containsNumber(getMinimumNumber())) || (paramb.containsNumber(getMaximumNumber())) || (containsNumber(paramb.getMinimumNumber()))) {
      bool = true;
    }
    return bool;
  }
  
  public abstract String toString();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */