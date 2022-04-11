package org.mp4parser.aspectj.lang.reflect;

public class NoSuchPointcutException
  extends Exception
{
  private static final long serialVersionUID = 3256444698657634352L;
  private String name;
  
  public NoSuchPointcutException(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\mp4parser\aspectj\lang\reflect\NoSuchPointcutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */