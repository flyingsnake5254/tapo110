package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public final class SocksAuthRequest
  extends SocksRequest
{
  private static final SocksSubnegotiationVersion SUBNEGOTIATION_VERSION = SocksSubnegotiationVersion.AUTH_PASSWORD;
  private final String password;
  private final String username;
  
  public SocksAuthRequest(String paramString1, String paramString2)
  {
    super(SocksRequestType.AUTH);
    ObjectUtil.checkNotNull(paramString1, "username");
    ObjectUtil.checkNotNull(paramString2, "password");
    CharsetEncoder localCharsetEncoder = CharsetUtil.encoder(CharsetUtil.US_ASCII);
    if ((localCharsetEncoder.canEncode(paramString1)) && (localCharsetEncoder.canEncode(paramString2)))
    {
      if (paramString1.length() <= 255)
      {
        if (paramString2.length() <= 255)
        {
          this.username = paramString1;
          this.password = paramString2;
          return;
        }
        throw new IllegalArgumentException("password: **** exceeds 255 char limit");
      }
      paramString2 = new StringBuilder();
      paramString2.append("username: ");
      paramString2.append(paramString1);
      paramString2.append(" exceeds 255 char limit");
      throw new IllegalArgumentException(paramString2.toString());
    }
    paramString2 = new StringBuilder();
    paramString2.append("username: ");
    paramString2.append(paramString1);
    paramString2.append(" or password: **** values should be in pure ascii");
    throw new IllegalArgumentException(paramString2.toString());
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(SUBNEGOTIATION_VERSION.byteValue());
    paramByteBuf.writeByte(this.username.length());
    String str = this.username;
    Charset localCharset = CharsetUtil.US_ASCII;
    paramByteBuf.writeCharSequence(str, localCharset);
    paramByteBuf.writeByte(this.password.length());
    paramByteBuf.writeCharSequence(this.password, localCharset);
  }
  
  public String password()
  {
    return this.password;
  }
  
  public String username()
  {
    return this.username;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksAuthRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */