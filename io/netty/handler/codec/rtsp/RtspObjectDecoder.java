package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;

@Deprecated
public abstract class RtspObjectDecoder
  extends HttpObjectDecoder
{
  protected RtspObjectDecoder()
  {
    this(4096, 8192, 8192);
  }
  
  protected RtspObjectDecoder(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3 * 2, false);
  }
  
  protected RtspObjectDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3 * 2, false, paramBoolean);
  }
  
  protected boolean isContentAlwaysEmpty(HttpMessage paramHttpMessage)
  {
    boolean bool = super.isContentAlwaysEmpty(paramHttpMessage);
    if (bool) {
      return true;
    }
    if (!paramHttpMessage.headers().contains(RtspHeaderNames.CONTENT_LENGTH)) {
      return true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\rtsp\RtspObjectDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */