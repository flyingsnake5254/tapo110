package io.netty.handler.ssl;

public final class SniCompletionEvent
  extends SslCompletionEvent
{
  private final String hostname;
  
  SniCompletionEvent(String paramString)
  {
    this.hostname = paramString;
  }
  
  SniCompletionEvent(String paramString, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.hostname = paramString;
  }
  
  SniCompletionEvent(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public String hostname()
  {
    return this.hostname;
  }
  
  public String toString()
  {
    Object localObject = cause();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SniCompletionEvent.class.getSimpleName());
      ((StringBuilder)localObject).append("(SUCCESS='");
      ((StringBuilder)localObject).append(this.hostname);
      ((StringBuilder)localObject).append("'\")");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(SniCompletionEvent.class.getSimpleName());
      localStringBuilder.append('(');
      localStringBuilder.append(localObject);
      localStringBuilder.append(')');
      localObject = localStringBuilder.toString();
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SniCompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */