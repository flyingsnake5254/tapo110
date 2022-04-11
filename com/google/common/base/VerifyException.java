package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class VerifyException
  extends RuntimeException
{
  public VerifyException() {}
  
  public VerifyException(@NullableDecl String paramString)
  {
    super(paramString);
  }
  
  public VerifyException(@NullableDecl String paramString, @NullableDecl Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public VerifyException(@NullableDecl Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\VerifyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */