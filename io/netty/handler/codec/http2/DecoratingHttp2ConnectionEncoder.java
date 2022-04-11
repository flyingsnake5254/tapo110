package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

public class DecoratingHttp2ConnectionEncoder
  extends DecoratingHttp2FrameWriter
  implements Http2ConnectionEncoder, Http2SettingsReceivedConsumer
{
  private final Http2ConnectionEncoder delegate;
  
  public DecoratingHttp2ConnectionEncoder(Http2ConnectionEncoder paramHttp2ConnectionEncoder)
  {
    super(paramHttp2ConnectionEncoder);
    this.delegate = ((Http2ConnectionEncoder)ObjectUtil.checkNotNull(paramHttp2ConnectionEncoder, "delegate"));
  }
  
  public Http2Connection connection()
  {
    return this.delegate.connection();
  }
  
  public void consumeReceivedSettings(Http2Settings paramHttp2Settings)
  {
    Http2ConnectionEncoder localHttp2ConnectionEncoder = this.delegate;
    if ((localHttp2ConnectionEncoder instanceof Http2SettingsReceivedConsumer))
    {
      ((Http2SettingsReceivedConsumer)localHttp2ConnectionEncoder).consumeReceivedSettings(paramHttp2Settings);
      return;
    }
    paramHttp2Settings = new StringBuilder();
    paramHttp2Settings.append("delegate ");
    paramHttp2Settings.append(this.delegate);
    paramHttp2Settings.append(" is not an instance of ");
    paramHttp2Settings.append(Http2SettingsReceivedConsumer.class);
    throw new IllegalStateException(paramHttp2Settings.toString());
  }
  
  public Http2RemoteFlowController flowController()
  {
    return this.delegate.flowController();
  }
  
  public Http2FrameWriter frameWriter()
  {
    return this.delegate.frameWriter();
  }
  
  public void lifecycleManager(Http2LifecycleManager paramHttp2LifecycleManager)
  {
    this.delegate.lifecycleManager(paramHttp2LifecycleManager);
  }
  
  public Http2Settings pollSentSettings()
  {
    return this.delegate.pollSentSettings();
  }
  
  public void remoteSettings(Http2Settings paramHttp2Settings)
    throws Http2Exception
  {
    this.delegate.remoteSettings(paramHttp2Settings);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DecoratingHttp2ConnectionEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */