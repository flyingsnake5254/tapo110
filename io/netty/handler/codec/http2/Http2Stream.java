package io.netty.handler.codec.http2;

public abstract interface Http2Stream
{
  public abstract Http2Stream close();
  
  public abstract Http2Stream closeLocalSide();
  
  public abstract Http2Stream closeRemoteSide();
  
  public abstract <V> V getProperty(Http2Connection.a parama);
  
  public abstract Http2Stream headersReceived(boolean paramBoolean);
  
  public abstract Http2Stream headersSent(boolean paramBoolean);
  
  public abstract int id();
  
  public abstract boolean isHeadersReceived();
  
  public abstract boolean isHeadersSent();
  
  public abstract boolean isPushPromiseSent();
  
  public abstract boolean isResetSent();
  
  public abstract boolean isTrailersReceived();
  
  public abstract boolean isTrailersSent();
  
  public abstract Http2Stream open(boolean paramBoolean)
    throws Http2Exception;
  
  public abstract Http2Stream pushPromiseSent();
  
  public abstract <V> V removeProperty(Http2Connection.a parama);
  
  public abstract Http2Stream resetSent();
  
  public abstract <V> V setProperty(Http2Connection.a parama, V paramV);
  
  public abstract State state();
  
  public static enum State
  {
    private final boolean localSideOpen;
    private final boolean remoteSideOpen;
    
    static
    {
      State localState1 = new State("IDLE", 0, false, false);
      IDLE = localState1;
      State localState2 = new State("RESERVED_LOCAL", 1, false, false);
      RESERVED_LOCAL = localState2;
      State localState3 = new State("RESERVED_REMOTE", 2, false, false);
      RESERVED_REMOTE = localState3;
      State localState4 = new State("OPEN", 3, true, true);
      OPEN = localState4;
      State localState5 = new State("HALF_CLOSED_LOCAL", 4, false, true);
      HALF_CLOSED_LOCAL = localState5;
      State localState6 = new State("HALF_CLOSED_REMOTE", 5, true, false);
      HALF_CLOSED_REMOTE = localState6;
      State localState7 = new State("CLOSED", 6, false, false);
      CLOSED = localState7;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6, localState7 };
    }
    
    private State(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.localSideOpen = paramBoolean1;
      this.remoteSideOpen = paramBoolean2;
    }
    
    public boolean localSideOpen()
    {
      return this.localSideOpen;
    }
    
    public boolean remoteSideOpen()
    {
      return this.remoteSideOpen;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2Stream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */