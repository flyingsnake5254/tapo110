package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.internal.ObjectUtil;

public final class RtspVersions
{
  public static final HttpVersion RTSP_1_0 = new HttpVersion("RTSP", 1, 0, true);
  
  public static HttpVersion valueOf(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "text");
    paramString = paramString.trim().toUpperCase();
    if ("RTSP/1.0".equals(paramString)) {
      return RTSP_1_0;
    }
    return new HttpVersion(paramString, true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\rtsp\RtspVersions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */