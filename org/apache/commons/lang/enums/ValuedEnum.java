package org.apache.commons.lang.enums;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.d;

public abstract class ValuedEnum
  extends Enum
{
  private static final long serialVersionUID = -7129650521543789085L;
  private final int iValue;
  
  protected ValuedEnum(String paramString, int paramInt)
  {
    super(paramString);
    this.iValue = paramInt;
  }
  
  protected static Enum getEnum(Class paramClass, int paramInt)
  {
    if (paramClass != null)
    {
      Iterator localIterator = Enum.getEnumList(paramClass).iterator();
      while (localIterator.hasNext())
      {
        paramClass = (ValuedEnum)localIterator.next();
        if (paramClass.getValue() == paramInt) {
          return paramClass;
        }
      }
      return null;
    }
    throw new IllegalArgumentException("The Enum Class must not be null");
  }
  
  private int getValueInOtherClassLoader(Object paramObject)
  {
    try
    {
      int i = ((Integer)paramObject.getClass().getMethod("getValue", null).invoke(paramObject, null)).intValue();
      return i;
    }
    catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramObject)
    {
      throw new IllegalStateException("This should not happen");
    }
  }
  
  public int compareTo(Object paramObject)
  {
    if (paramObject == this) {
      return 0;
    }
    int i;
    if (paramObject.getClass() != getClass()) {
      if (paramObject.getClass().getName().equals(getClass().getName())) {
        i = this.iValue;
      }
    }
    for (int j = getValueInOtherClassLoader(paramObject);; j = ((ValuedEnum)paramObject).iValue)
    {
      return i - j;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Different enum class '");
      localStringBuffer.append(d.c(paramObject.getClass()));
      localStringBuffer.append("'");
      throw new ClassCastException(localStringBuffer.toString());
      i = this.iValue;
    }
  }
  
  public final int getValue()
  {
    return this.iValue;
  }
  
  public String toString()
  {
    if (this.iToString == null)
    {
      String str = d.c(getEnumClass());
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str);
      localStringBuffer.append("[");
      localStringBuffer.append(getName());
      localStringBuffer.append("=");
      localStringBuffer.append(getValue());
      localStringBuffer.append("]");
      this.iToString = localStringBuffer.toString();
    }
    return this.iToString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\enums\ValuedEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */