package okhttp3.internal.http2;

public enum ErrorCode
{
  public final int httpCode;
  
  static
  {
    ErrorCode localErrorCode1 = new ErrorCode("NO_ERROR", 0, 0);
    NO_ERROR = localErrorCode1;
    ErrorCode localErrorCode2 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
    PROTOCOL_ERROR = localErrorCode2;
    ErrorCode localErrorCode3 = new ErrorCode("INTERNAL_ERROR", 2, 2);
    INTERNAL_ERROR = localErrorCode3;
    ErrorCode localErrorCode4 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
    FLOW_CONTROL_ERROR = localErrorCode4;
    ErrorCode localErrorCode5 = new ErrorCode("REFUSED_STREAM", 4, 7);
    REFUSED_STREAM = localErrorCode5;
    ErrorCode localErrorCode6 = new ErrorCode("CANCEL", 5, 8);
    CANCEL = localErrorCode6;
    ErrorCode localErrorCode7 = new ErrorCode("COMPRESSION_ERROR", 6, 9);
    COMPRESSION_ERROR = localErrorCode7;
    ErrorCode localErrorCode8 = new ErrorCode("CONNECT_ERROR", 7, 10);
    CONNECT_ERROR = localErrorCode8;
    ErrorCode localErrorCode9 = new ErrorCode("ENHANCE_YOUR_CALM", 8, 11);
    ENHANCE_YOUR_CALM = localErrorCode9;
    ErrorCode localErrorCode10 = new ErrorCode("INADEQUATE_SECURITY", 9, 12);
    INADEQUATE_SECURITY = localErrorCode10;
    ErrorCode localErrorCode11 = new ErrorCode("HTTP_1_1_REQUIRED", 10, 13);
    HTTP_1_1_REQUIRED = localErrorCode11;
    $VALUES = new ErrorCode[] { localErrorCode1, localErrorCode2, localErrorCode3, localErrorCode4, localErrorCode5, localErrorCode6, localErrorCode7, localErrorCode8, localErrorCode9, localErrorCode10, localErrorCode11 };
  }
  
  private ErrorCode(int paramInt)
  {
    this.httpCode = paramInt;
  }
  
  public static ErrorCode fromHttp2(int paramInt)
  {
    for (ErrorCode localErrorCode : ) {
      if (localErrorCode.httpCode == paramInt) {
        return localErrorCode;
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http2\ErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */