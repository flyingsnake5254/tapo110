package io.netty.handler.codec.dns;

import io.netty.channel.socket.InternetProtocolFamily;
import java.net.InetAddress;
import java.util.Arrays;

public final class DefaultDnsOptEcsRecord
  extends AbstractDnsOptPseudoRrRecord
  implements DnsOptEcsRecord
{
  private final byte[] address;
  private final int srcPrefixLength;
  
  public DefaultDnsOptEcsRecord(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    super(paramInt1, paramInt2, paramInt3);
    this.srcPrefixLength = paramInt4;
    this.address = ((byte[])verifyAddress(paramArrayOfByte).clone());
  }
  
  public DefaultDnsOptEcsRecord(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this(paramInt1, 0, 0, paramInt2, paramArrayOfByte);
  }
  
  public DefaultDnsOptEcsRecord(int paramInt, InternetProtocolFamily paramInternetProtocolFamily)
  {
    this(paramInt, 0, 0, 0, paramInternetProtocolFamily.localhost().getAddress());
  }
  
  private static byte[] verifyAddress(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length != 4) && (paramArrayOfByte.length != 16)) {
      throw new IllegalArgumentException("bytes.length must either 4 or 16");
    }
    return paramArrayOfByte;
  }
  
  public byte[] address()
  {
    return (byte[])this.address.clone();
  }
  
  public int scopePrefixLength()
  {
    return 0;
  }
  
  public int sourcePrefixLength()
  {
    return this.srcPrefixLength;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = toStringBuilder();
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    localStringBuilder.append(" address:");
    localStringBuilder.append(Arrays.toString(this.address));
    localStringBuilder.append(" sourcePrefixLength:");
    localStringBuilder.append(sourcePrefixLength());
    localStringBuilder.append(" scopePrefixLength:");
    localStringBuilder.append(scopePrefixLength());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsOptEcsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */