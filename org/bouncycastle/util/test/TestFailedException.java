package org.bouncycastle.util.test;

public class TestFailedException
  extends RuntimeException
{
  private a _result;
  
  public TestFailedException(a parama)
  {
    this._result = parama;
  }
  
  public a getResult()
  {
    return this._result;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\test\TestFailedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */