package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ComputationException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  public ComputationException(@NullableDecl Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ComputationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */