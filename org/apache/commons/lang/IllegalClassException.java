package org.apache.commons.lang;

public class IllegalClassException
  extends IllegalArgumentException
{
  private static final long serialVersionUID = 8063272569377254819L;
  
  public IllegalClassException(Class paramClass1, Class paramClass2)
  {
    super(localStringBuffer.toString());
  }
  
  public IllegalClassException(Class paramClass, Object paramObject)
  {
    super(localStringBuffer.toString());
  }
  
  public IllegalClassException(String paramString)
  {
    super(paramString);
  }
  
  private static final String safeGetClassName(Class paramClass)
  {
    if (paramClass == null) {
      paramClass = null;
    } else {
      paramClass = paramClass.getName();
    }
    return paramClass;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\IllegalClassException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */