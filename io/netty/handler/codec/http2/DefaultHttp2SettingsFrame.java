package io.netty.handler.codec.http2;

import io.netty.util.collection.CharObjectHashMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultHttp2SettingsFrame
  implements Http2SettingsFrame
{
  private final Http2Settings settings;
  
  public DefaultHttp2SettingsFrame(Http2Settings paramHttp2Settings)
  {
    this.settings = ((Http2Settings)ObjectUtil.checkNotNull(paramHttp2Settings, "settings"));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Http2SettingsFrame)) {
      return false;
    }
    paramObject = (Http2SettingsFrame)paramObject;
    return this.settings.equals(((Http2SettingsFrame)paramObject).settings());
  }
  
  public int hashCode()
  {
    return this.settings.hashCode();
  }
  
  public String name()
  {
    return "SETTINGS";
  }
  
  public Http2Settings settings()
  {
    return this.settings;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(settings=");
    localStringBuilder.append(this.settings);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2SettingsFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */