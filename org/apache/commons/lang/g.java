package org.apache.commons.lang;

public class g
{
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException("The validated expression is false");
  }
  
  public static void b(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramBoolean) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(paramLong);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */