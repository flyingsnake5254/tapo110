package io.netty.handler.codec.http2;

public abstract interface Http2SettingsAckFrame
  extends Http2Frame
{
  public static final Http2SettingsAckFrame INSTANCE = new DefaultHttp2SettingsAckFrame();
  
  public abstract String name();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2SettingsAckFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */