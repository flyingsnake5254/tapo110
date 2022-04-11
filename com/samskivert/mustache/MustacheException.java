package com.samskivert.mustache;

public class MustacheException
  extends RuntimeException
{
  public MustacheException(String paramString)
  {
    super(paramString);
  }
  
  public MustacheException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MustacheException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public static class Context
    extends MustacheException
  {
    public final String key;
    public final int lineNo;
    
    public Context(String paramString1, String paramString2, int paramInt)
    {
      super();
      this.key = paramString2;
      this.lineNo = paramInt;
    }
    
    public Context(String paramString1, String paramString2, int paramInt, Throwable paramThrowable)
    {
      super(paramThrowable);
      this.key = paramString2;
      this.lineNo = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\MustacheException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */