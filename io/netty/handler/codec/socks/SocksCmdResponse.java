package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.IDN;

public final class SocksCmdResponse
  extends SocksResponse
{
  private static final byte[] DOMAIN_ZEROED = { 0 };
  private static final byte[] IPv4_HOSTNAME_ZEROED = { 0, 0, 0, 0 };
  private static final byte[] IPv6_HOSTNAME_ZEROED = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private final SocksAddressType addressType;
  private final SocksCmdStatus cmdStatus;
  private final String host;
  private final int port;
  
  public SocksCmdResponse(SocksCmdStatus paramSocksCmdStatus, SocksAddressType paramSocksAddressType)
  {
    this(paramSocksCmdStatus, paramSocksAddressType, null, 0);
  }
  
  public SocksCmdResponse(SocksCmdStatus paramSocksCmdStatus, SocksAddressType paramSocksAddressType, String paramString, int paramInt)
  {
    super(SocksResponseType.CMD);
    ObjectUtil.checkNotNull(paramSocksCmdStatus, "cmdStatus");
    ObjectUtil.checkNotNull(paramSocksAddressType, "addressType");
    String str = paramString;
    if (paramString != null)
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[paramSocksAddressType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            str = paramString;
          }
          else if (NetUtil.isValidIpV6Address(paramString))
          {
            str = paramString;
          }
          else
          {
            paramSocksCmdStatus = new StringBuilder();
            paramSocksCmdStatus.append(paramString);
            paramSocksCmdStatus.append(" is not a valid IPv6 address");
            throw new IllegalArgumentException(paramSocksCmdStatus.toString());
          }
        }
        else
        {
          str = IDN.toASCII(paramString);
          if (str.length() > 255)
          {
            paramSocksCmdStatus = new StringBuilder();
            paramSocksCmdStatus.append(paramString);
            paramSocksCmdStatus.append(" IDN: ");
            paramSocksCmdStatus.append(str);
            paramSocksCmdStatus.append(" exceeds 255 char limit");
            throw new IllegalArgumentException(paramSocksCmdStatus.toString());
          }
        }
      }
      else if (NetUtil.isValidIpV4Address(paramString))
      {
        str = paramString;
      }
      else
      {
        paramSocksCmdStatus = new StringBuilder();
        paramSocksCmdStatus.append(paramString);
        paramSocksCmdStatus.append(" is not a valid IPv4 address");
        throw new IllegalArgumentException(paramSocksCmdStatus.toString());
      }
    }
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      this.cmdStatus = paramSocksCmdStatus;
      this.addressType = paramSocksAddressType;
      this.host = str;
      this.port = paramInt;
      return;
    }
    paramSocksCmdStatus = new StringBuilder();
    paramSocksCmdStatus.append(paramInt);
    paramSocksCmdStatus.append(" is not in bounds 0 <= x <= 65535");
    throw new IllegalArgumentException(paramSocksCmdStatus.toString());
  }
  
  public SocksAddressType addressType()
  {
    return this.addressType;
  }
  
  public SocksCmdStatus cmdStatus()
  {
    return this.cmdStatus;
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(protocolVersion().byteValue());
    paramByteBuf.writeByte(this.cmdStatus.byteValue());
    paramByteBuf.writeByte(0);
    paramByteBuf.writeByte(this.addressType.byteValue());
    int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = this.host;
          if (localObject == null) {
            localObject = IPv6_HOSTNAME_ZEROED;
          } else {
            localObject = NetUtil.createByteArrayFromIpAddressString((String)localObject);
          }
          paramByteBuf.writeBytes((byte[])localObject);
          paramByteBuf.writeShort(this.port);
        }
      }
      else
      {
        localObject = this.host;
        if (localObject != null)
        {
          paramByteBuf.writeByte(((String)localObject).length());
          paramByteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
        }
        else
        {
          localObject = DOMAIN_ZEROED;
          paramByteBuf.writeByte(localObject.length);
          paramByteBuf.writeBytes((byte[])localObject);
        }
        paramByteBuf.writeShort(this.port);
      }
    }
    else
    {
      localObject = this.host;
      if (localObject == null) {
        localObject = IPv4_HOSTNAME_ZEROED;
      } else {
        localObject = NetUtil.createByteArrayFromIpAddressString((String)localObject);
      }
      paramByteBuf.writeBytes((byte[])localObject);
      paramByteBuf.writeShort(this.port);
    }
  }
  
  public String host()
  {
    String str1 = this.host;
    String str2 = str1;
    if (str1 != null)
    {
      str2 = str1;
      if (this.addressType == SocksAddressType.DOMAIN) {
        str2 = IDN.toUnicode(str1);
      }
    }
    return str2;
  }
  
  public int port()
  {
    return this.port;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksCmdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */