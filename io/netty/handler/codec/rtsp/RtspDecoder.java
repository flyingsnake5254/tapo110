package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RtspDecoder
  extends HttpObjectDecoder
{
  public static final int DEFAULT_MAX_CONTENT_LENGTH = 8192;
  private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(999, "Unknown");
  private static final Pattern versionPattern = Pattern.compile("RTSP/\\d\\.\\d");
  private boolean isDecodingRequest;
  
  public RtspDecoder()
  {
    this(4096, 8192, 8192);
  }
  
  public RtspDecoder(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3 * 2, false);
  }
  
  public RtspDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3 * 2, false, paramBoolean);
  }
  
  protected HttpMessage createInvalidMessage()
  {
    if (this.isDecodingRequest) {
      return new DefaultFullHttpRequest(RtspVersions.RTSP_1_0, RtspMethods.OPTIONS, "/bad-request", this.validateHeaders);
    }
    return new DefaultFullHttpResponse(RtspVersions.RTSP_1_0, UNKNOWN_STATUS, this.validateHeaders);
  }
  
  protected HttpMessage createMessage(String[] paramArrayOfString)
    throws Exception
  {
    if (versionPattern.matcher(paramArrayOfString[0]).matches())
    {
      this.isDecodingRequest = false;
      return new DefaultHttpResponse(RtspVersions.valueOf(paramArrayOfString[0]), new HttpResponseStatus(Integer.parseInt(paramArrayOfString[1]), paramArrayOfString[2]), this.validateHeaders);
    }
    this.isDecodingRequest = true;
    return new DefaultHttpRequest(RtspVersions.valueOf(paramArrayOfString[2]), RtspMethods.valueOf(paramArrayOfString[0]), paramArrayOfString[1], this.validateHeaders);
  }
  
  protected boolean isContentAlwaysEmpty(HttpMessage paramHttpMessage)
  {
    boolean bool;
    if ((!super.isContentAlwaysEmpty(paramHttpMessage)) && (paramHttpMessage.headers().contains(RtspHeaderNames.CONTENT_LENGTH))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected boolean isDecodingRequest()
  {
    return this.isDecodingRequest;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\rtsp\RtspDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */