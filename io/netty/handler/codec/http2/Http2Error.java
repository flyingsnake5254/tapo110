package io.netty.handler.codec.http2;

public enum Http2Error
{
  private static final Http2Error[] INT_TO_ENUM_MAP;
  private final long code;
  
  static
  {
    int i = 0;
    Http2Error localHttp2Error1 = new Http2Error("NO_ERROR", 0, 0L);
    NO_ERROR = localHttp2Error1;
    Http2Error localHttp2Error2 = new Http2Error("PROTOCOL_ERROR", 1, 1L);
    PROTOCOL_ERROR = localHttp2Error2;
    Http2Error localHttp2Error3 = new Http2Error("INTERNAL_ERROR", 2, 2L);
    INTERNAL_ERROR = localHttp2Error3;
    Object localObject1 = new Http2Error("FLOW_CONTROL_ERROR", 3, 3L);
    FLOW_CONTROL_ERROR = (Http2Error)localObject1;
    Http2Error localHttp2Error4 = new Http2Error("SETTINGS_TIMEOUT", 4, 4L);
    SETTINGS_TIMEOUT = localHttp2Error4;
    Http2Error localHttp2Error5 = new Http2Error("STREAM_CLOSED", 5, 5L);
    STREAM_CLOSED = localHttp2Error5;
    Http2Error localHttp2Error6 = new Http2Error("FRAME_SIZE_ERROR", 6, 6L);
    FRAME_SIZE_ERROR = localHttp2Error6;
    Http2Error localHttp2Error7 = new Http2Error("REFUSED_STREAM", 7, 7L);
    REFUSED_STREAM = localHttp2Error7;
    Http2Error localHttp2Error8 = new Http2Error("CANCEL", 8, 8L);
    CANCEL = localHttp2Error8;
    Http2Error localHttp2Error9 = new Http2Error("COMPRESSION_ERROR", 9, 9L);
    COMPRESSION_ERROR = localHttp2Error9;
    Http2Error localHttp2Error10 = new Http2Error("CONNECT_ERROR", 10, 10L);
    CONNECT_ERROR = localHttp2Error10;
    Http2Error localHttp2Error11 = new Http2Error("ENHANCE_YOUR_CALM", 11, 11L);
    ENHANCE_YOUR_CALM = localHttp2Error11;
    Http2Error localHttp2Error12 = new Http2Error("INADEQUATE_SECURITY", 12, 12L);
    INADEQUATE_SECURITY = localHttp2Error12;
    Object localObject2 = new Http2Error("HTTP_1_1_REQUIRED", 13, 13L);
    HTTP_1_1_REQUIRED = (Http2Error)localObject2;
    $VALUES = new Http2Error[] { localHttp2Error1, localHttp2Error2, localHttp2Error3, localObject1, localHttp2Error4, localHttp2Error5, localHttp2Error6, localHttp2Error7, localHttp2Error8, localHttp2Error9, localHttp2Error10, localHttp2Error11, localHttp2Error12, localObject2 };
    localObject2 = values();
    localObject1 = new Http2Error[localObject2.length];
    int j = localObject2.length;
    while (i < j)
    {
      localHttp2Error4 = localObject2[i];
      localObject1[((int)localHttp2Error4.code())] = localHttp2Error4;
      i++;
    }
    INT_TO_ENUM_MAP = (Http2Error[])localObject1;
  }
  
  private Http2Error(long paramLong)
  {
    this.code = paramLong;
  }
  
  public static Http2Error valueOf(long paramLong)
  {
    Object localObject = INT_TO_ENUM_MAP;
    if ((paramLong < localObject.length) && (paramLong >= 0L)) {
      localObject = localObject[((int)paramLong)];
    } else {
      localObject = null;
    }
    return (Http2Error)localObject;
  }
  
  public long code()
  {
    return this.code;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2Error.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */