package org.bouncycastle.tsp;

public class TSPValidationException
  extends TSPException
{
  private int failureCode = -1;
  
  public TSPValidationException(String paramString)
  {
    super(paramString);
  }
  
  public TSPValidationException(String paramString, int paramInt)
  {
    super(paramString);
    this.failureCode = paramInt;
  }
  
  public int getFailureCode()
  {
    return this.failureCode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\tsp\TSPValidationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */