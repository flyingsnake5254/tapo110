package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class UncheckedTimeoutException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  public UncheckedTimeoutException() {}
  
  public UncheckedTimeoutException(@NullableDecl String paramString)
  {
    super(paramString);
  }
  
  public UncheckedTimeoutException(@NullableDecl String paramString, @NullableDecl Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UncheckedTimeoutException(@NullableDecl Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\UncheckedTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */