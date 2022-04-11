package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

public abstract interface Http2HeadersEncoder
{
  public static final SensitivityDetector ALWAYS_SENSITIVE = new SensitivityDetector()
  {
    public boolean isSensitive(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2)
    {
      return true;
    }
  };
  public static final SensitivityDetector NEVER_SENSITIVE = new SensitivityDetector()
  {
    public boolean isSensitive(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2)
    {
      return false;
    }
  };
  
  public abstract Configuration configuration();
  
  public abstract void encodeHeaders(int paramInt, Http2Headers paramHttp2Headers, ByteBuf paramByteBuf)
    throws Http2Exception;
  
  public static abstract interface Configuration
  {
    public abstract long maxHeaderListSize();
    
    public abstract void maxHeaderListSize(long paramLong)
      throws Http2Exception;
    
    public abstract long maxHeaderTableSize();
    
    public abstract void maxHeaderTableSize(long paramLong)
      throws Http2Exception;
  }
  
  public static abstract interface SensitivityDetector
  {
    public abstract boolean isSensitive(CharSequence paramCharSequence1, CharSequence paramCharSequence2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2HeadersEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */