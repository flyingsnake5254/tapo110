package io.netty.util;

import java.util.Arrays;

@Deprecated
public class ResourceLeakException
  extends RuntimeException
{
  private static final long serialVersionUID = 7186453858343358280L;
  private final StackTraceElement[] cachedStackTrace = getStackTrace();
  
  public ResourceLeakException() {}
  
  public ResourceLeakException(String paramString)
  {
    super(paramString);
  }
  
  public ResourceLeakException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ResourceLeakException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ResourceLeakException)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    return Arrays.equals(this.cachedStackTrace, ((ResourceLeakException)paramObject).cachedStackTrace);
  }
  
  public int hashCode()
  {
    StackTraceElement[] arrayOfStackTraceElement = this.cachedStackTrace;
    int i = arrayOfStackTraceElement.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k = k * 31 + arrayOfStackTraceElement[j].hashCode();
      j++;
    }
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ResourceLeakException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */