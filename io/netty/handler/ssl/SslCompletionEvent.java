package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;

public abstract class SslCompletionEvent
{
  private final Throwable cause;
  
  SslCompletionEvent()
  {
    this.cause = null;
  }
  
  SslCompletionEvent(Throwable paramThrowable)
  {
    this.cause = ((Throwable)ObjectUtil.checkNotNull(paramThrowable, "cause"));
  }
  
  public final Throwable cause()
  {
    return this.cause;
  }
  
  public final boolean isSuccess()
  {
    boolean bool;
    if (this.cause == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    Object localObject = cause();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append("(SUCCESS)");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append('(');
      localStringBuilder.append(localObject);
      localStringBuilder.append(')');
      localObject = localStringBuilder.toString();
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslCompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */