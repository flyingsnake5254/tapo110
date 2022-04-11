package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ExecutionError
  extends Error
{
  private static final long serialVersionUID = 0L;
  
  protected ExecutionError() {}
  
  public ExecutionError(@NullableDecl Error paramError)
  {
    super(paramError);
  }
  
  protected ExecutionError(@NullableDecl String paramString)
  {
    super(paramString);
  }
  
  public ExecutionError(@NullableDecl String paramString, @NullableDecl Error paramError)
  {
    super(paramString, paramError);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\ExecutionError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */