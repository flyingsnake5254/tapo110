package io.netty.handler.codec.http2;

public abstract interface StreamByteDistributor
{
  public abstract boolean distribute(int paramInt, Writer paramWriter)
    throws Http2Exception;
  
  public abstract void updateDependencyTree(int paramInt1, int paramInt2, short paramShort, boolean paramBoolean);
  
  public abstract void updateStreamableBytes(StreamState paramStreamState);
  
  public static abstract interface StreamState
  {
    public abstract boolean hasFrame();
    
    public abstract long pendingBytes();
    
    public abstract Http2Stream stream();
    
    public abstract int windowSize();
  }
  
  public static abstract interface Writer
  {
    public abstract void write(Http2Stream paramHttp2Stream, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\StreamByteDistributor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */