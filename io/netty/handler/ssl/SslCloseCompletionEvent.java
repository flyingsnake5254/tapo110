package io.netty.handler.ssl;

public final class SslCloseCompletionEvent
  extends SslCompletionEvent
{
  public static final SslCloseCompletionEvent SUCCESS = new SslCloseCompletionEvent();
  
  private SslCloseCompletionEvent() {}
  
  public SslCloseCompletionEvent(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslCloseCompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */