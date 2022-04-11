package org.apache.commons.lang;

public class b
{
  public static boolean a(Boolean paramBoolean)
  {
    return b(paramBoolean) ^ true;
  }
  
  public static boolean b(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return false;
    }
    return paramBoolean.booleanValue();
  }
  
  public static Boolean c(boolean paramBoolean)
  {
    Boolean localBoolean;
    if (paramBoolean) {
      localBoolean = Boolean.TRUE;
    } else {
      localBoolean = Boolean.FALSE;
    }
    return localBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */