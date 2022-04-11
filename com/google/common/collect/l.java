package com.google.common.collect;

import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class l<T>
  extends j3<T>
{
  @NullableDecl
  private T c;
  
  protected l(@NullableDecl T paramT)
  {
    this.c = paramT;
  }
  
  @NullableDecl
  protected abstract T a(T paramT);
  
  public final boolean hasNext()
  {
    boolean bool;
    if (this.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final T next()
  {
    if (hasNext()) {
      try
      {
        Object localObject1 = this.c;
        this.c = a(localObject1);
        return (T)localObject1;
      }
      finally
      {
        this.c = a(this.c);
      }
    }
    throw new NoSuchElementException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */