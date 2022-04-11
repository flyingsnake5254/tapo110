package io.netty.handler.codec.http;

public class HttpResponseDecoder
  extends HttpObjectDecoder
{
  private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(999, "Unknown");
  
  public HttpResponseDecoder() {}
  
  public HttpResponseDecoder(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3, true);
  }
  
  public HttpResponseDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, true, paramBoolean);
  }
  
  public HttpResponseDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, true, paramBoolean, paramInt4);
  }
  
  public HttpResponseDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2, paramInt3, true, paramBoolean1, paramInt4, paramBoolean2);
  }
  
  protected HttpMessage createInvalidMessage()
  {
    return new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, UNKNOWN_STATUS, this.validateHeaders);
  }
  
  protected HttpMessage createMessage(String[] paramArrayOfString)
  {
    return new DefaultHttpResponse(HttpVersion.valueOf(paramArrayOfString[0]), HttpResponseStatus.valueOf(Integer.parseInt(paramArrayOfString[1]), paramArrayOfString[2]), this.validateHeaders);
  }
  
  protected boolean isDecodingRequest()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */