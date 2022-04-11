package io.netty.handler.ssl;

public final class SslHandshakeCompletionEvent
  extends SslCompletionEvent
{
  public static final SslHandshakeCompletionEvent SUCCESS = new SslHandshakeCompletionEvent();
  
  private SslHandshakeCompletionEvent() {}
  
  public SslHandshakeCompletionEvent(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslHandshakeCompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */