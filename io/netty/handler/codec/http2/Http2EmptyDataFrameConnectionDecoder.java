package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

final class Http2EmptyDataFrameConnectionDecoder
  extends DecoratingHttp2ConnectionDecoder
{
  private final int maxConsecutiveEmptyFrames;
  
  Http2EmptyDataFrameConnectionDecoder(Http2ConnectionDecoder paramHttp2ConnectionDecoder, int paramInt)
  {
    super(paramHttp2ConnectionDecoder);
    this.maxConsecutiveEmptyFrames = ObjectUtil.checkPositive(paramInt, "maxConsecutiveEmptyFrames");
  }
  
  public Http2FrameListener frameListener()
  {
    Http2FrameListener localHttp2FrameListener1 = frameListener0();
    Http2FrameListener localHttp2FrameListener2 = localHttp2FrameListener1;
    if ((localHttp2FrameListener1 instanceof Http2EmptyDataFrameListener)) {
      localHttp2FrameListener2 = ((Http2EmptyDataFrameListener)localHttp2FrameListener1).listener;
    }
    return localHttp2FrameListener2;
  }
  
  public void frameListener(Http2FrameListener paramHttp2FrameListener)
  {
    if (paramHttp2FrameListener != null) {
      super.frameListener(new Http2EmptyDataFrameListener(paramHttp2FrameListener, this.maxConsecutiveEmptyFrames));
    } else {
      super.frameListener(null);
    }
  }
  
  Http2FrameListener frameListener0()
  {
    return super.frameListener();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2EmptyDataFrameConnectionDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */