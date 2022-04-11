package org.bouncycastle.cms;

public class CMSAttributeTableGenerationException
  extends CMSRuntimeException
{
  Exception e;
  
  public CMSAttributeTableGenerationException(String paramString)
  {
    super(paramString);
  }
  
  public CMSAttributeTableGenerationException(String paramString, Exception paramException)
  {
    super(paramString);
    this.e = paramException;
  }
  
  public Throwable getCause()
  {
    return this.e;
  }
  
  public Exception getUnderlyingException()
  {
    return this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cms\CMSAttributeTableGenerationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */