package io.netty.handler.codec.http;

public class HttpRequestDecoder
  extends HttpObjectDecoder
{
  public HttpRequestDecoder() {}
  
  public HttpRequestDecoder(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3, true);
  }
  
  public HttpRequestDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, true, paramBoolean);
  }
  
  public HttpRequestDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, true, paramBoolean, paramInt4);
  }
  
  public HttpRequestDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2, paramInt3, true, paramBoolean1, paramInt4, paramBoolean2);
  }
  
  protected HttpMessage createInvalidMessage()
  {
    return new DefaultFullHttpRequest(HttpVersion.HTTP_1_0, HttpMethod.GET, "/bad-request", this.validateHeaders);
  }
  
  protected HttpMessage createMessage(String[] paramArrayOfString)
    throws Exception
  {
    return new DefaultHttpRequest(HttpVersion.valueOf(paramArrayOfString[2]), HttpMethod.valueOf(paramArrayOfString[0]), paramArrayOfString[1], this.validateHeaders);
  }
  
  protected boolean isDecodingRequest()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */