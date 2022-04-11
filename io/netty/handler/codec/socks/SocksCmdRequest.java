package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.IDN;

public final class SocksCmdRequest
  extends SocksRequest
{
  private final SocksAddressType addressType;
  private final SocksCmdType cmdType;
  private final String host;
  private final int port;
  
  public SocksCmdRequest(SocksCmdType paramSocksCmdType, SocksAddressType paramSocksAddressType, String paramString, int paramInt)
  {
    super(SocksRequestType.CMD);
    ObjectUtil.checkNotNull(paramSocksCmdType, "cmdType");
    ObjectUtil.checkNotNull(paramSocksAddressType, "addressType");
    ObjectUtil.checkNotNull(paramString, "host");
    int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[paramSocksAddressType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i == 3) && (!NetUtil.isValidIpV6Address(paramString)))
        {
          paramSocksCmdType = new StringBuilder();
          paramSocksCmdType.append(paramString);
          paramSocksCmdType.append(" is not a valid IPv6 address");
          throw new IllegalArgumentException(paramSocksCmdType.toString());
        }
      }
      else
      {
        String str = IDN.toASCII(paramString);
        if (str.length() <= 255)
        {
          paramString = str;
        }
        else
        {
          paramSocksCmdType = new StringBuilder();
          paramSocksCmdType.append(paramString);
          paramSocksCmdType.append(" IDN: ");
          paramSocksCmdType.append(str);
          paramSocksCmdType.append(" exceeds 255 char limit");
          throw new IllegalArgumentException(paramSocksCmdType.toString());
        }
      }
    }
    else {
      if (!NetUtil.isValidIpV4Address(paramString)) {
        break label247;
      }
    }
    if ((paramInt > 0) && (paramInt < 65536))
    {
      this.cmdType = paramSocksCmdType;
      this.addressType = paramSocksAddressType;
      this.host = paramString;
      this.port = paramInt;
      return;
    }
    paramSocksCmdType = new StringBuilder();
    paramSocksCmdType.append(paramInt);
    paramSocksCmdType.append(" is not in bounds 0 < x < 65536");
    throw new IllegalArgumentException(paramSocksCmdType.toString());
    label247:
    paramSocksCmdType = new StringBuilder();
    paramSocksCmdType.append(paramString);
    paramSocksCmdType.append(" is not a valid IPv4 address");
    throw new IllegalArgumentException(paramSocksCmdType.toString());
  }
  
  public SocksAddressType addressType()
  {
    return this.addressType;
  }
  
  public SocksCmdType cmdType()
  {
    return this.cmdType;
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(protocolVersion().byteValue());
    paramByteBuf.writeByte(this.cmdType.byteValue());
    paramByteBuf.writeByte(0);
    paramByteBuf.writeByte(this.addressType.byteValue());
    int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          paramByteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
          paramByteBuf.writeShort(this.port);
        }
      }
      else
      {
        paramByteBuf.writeByte(this.host.length());
        paramByteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
        paramByteBuf.writeShort(this.port);
      }
    }
    else
    {
      paramByteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
      paramByteBuf.writeShort(this.port);
    }
  }
  
  public String host()
  {
    String str;
    if (this.addressType == SocksAddressType.DOMAIN) {
      str = IDN.toUnicode(this.host);
    } else {
      str = this.host;
    }
    return str;
  }
  
  public int port()
  {
    return this.port;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksCmdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */