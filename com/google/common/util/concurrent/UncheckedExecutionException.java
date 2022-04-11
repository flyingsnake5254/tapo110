package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class UncheckedExecutionException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  protected UncheckedExecutionException() {}
  
  protected UncheckedExecutionException(@NullableDecl String paramString)
  {
    super(paramString);
  }
  
  public UncheckedExecutionException(@NullableDecl String paramString, @NullableDecl Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UncheckedExecutionException(@NullableDecl Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\UncheckedExecutionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */