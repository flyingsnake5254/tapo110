package org.apache.commons.lang;

import java.util.Arrays;

public class IncompleteArgumentException
  extends IllegalArgumentException
{
  private static final long serialVersionUID = 4954193403612068178L;
  
  public IncompleteArgumentException(String paramString)
  {
    super(localStringBuffer.toString());
  }
  
  public IncompleteArgumentException(String paramString, String[] paramArrayOfString)
  {
    super(localStringBuffer.toString());
  }
  
  private static final String safeArrayToString(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      paramArrayOfObject = null;
    } else {
      paramArrayOfObject = Arrays.asList(paramArrayOfObject).toString();
    }
    return paramArrayOfObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\IncompleteArgumentException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */