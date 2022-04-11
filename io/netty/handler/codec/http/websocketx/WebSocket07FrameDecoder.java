package io.netty.handler.codec.http.websocketx;

public class WebSocket07FrameDecoder
  extends WebSocket08FrameDecoder
{
  public WebSocket07FrameDecoder(WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    super(paramWebSocketDecoderConfig);
  }
  
  public WebSocket07FrameDecoder(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(paramBoolean1).allowExtensions(paramBoolean2).maxFramePayloadLength(paramInt).build());
  }
  
  public WebSocket07FrameDecoder(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(paramBoolean1).allowExtensions(paramBoolean2).maxFramePayloadLength(paramInt).allowMaskMismatch(paramBoolean3).build());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocket07FrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */