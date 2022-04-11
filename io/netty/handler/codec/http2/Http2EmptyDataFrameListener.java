package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;

final class Http2EmptyDataFrameListener
  extends Http2FrameListenerDecorator
{
  private int emptyDataFrames;
  private final int maxConsecutiveEmptyFrames;
  private boolean violationDetected;
  
  Http2EmptyDataFrameListener(Http2FrameListener paramHttp2FrameListener, int paramInt)
  {
    super(paramHttp2FrameListener);
    this.maxConsecutiveEmptyFrames = ObjectUtil.checkPositive(paramInt, "maxConsecutiveEmptyFrames");
  }
  
  public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    if ((!paramBoolean) && (!paramByteBuf.isReadable()))
    {
      int i = this.emptyDataFrames;
      this.emptyDataFrames = (i + 1);
      int j = this.maxConsecutiveEmptyFrames;
      if ((i == j) && (!this.violationDetected))
      {
        this.violationDetected = true;
        throw Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number %d of empty data frames without end_of_stream flag received", new Object[] { Integer.valueOf(j) });
      }
    }
    else
    {
      this.emptyDataFrames = 0;
    }
    return super.onDataRead(paramChannelHandlerContext, paramInt1, paramByteBuf, paramInt2, paramBoolean);
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
    throws Http2Exception
  {
    this.emptyDataFrames = 0;
    super.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2);
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    this.emptyDataFrames = 0;
    super.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2EmptyDataFrameListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */