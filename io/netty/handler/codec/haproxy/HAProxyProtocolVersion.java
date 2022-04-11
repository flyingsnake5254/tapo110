package io.netty.handler.codec.haproxy;

public enum HAProxyProtocolVersion
{
  private static final byte VERSION_MASK = -16;
  private final byte byteValue;
  
  static
  {
    HAProxyProtocolVersion localHAProxyProtocolVersion1 = new HAProxyProtocolVersion("V1", 0, (byte)16);
    V1 = localHAProxyProtocolVersion1;
    HAProxyProtocolVersion localHAProxyProtocolVersion2 = new HAProxyProtocolVersion("V2", 1, (byte)32);
    V2 = localHAProxyProtocolVersion2;
    $VALUES = new HAProxyProtocolVersion[] { localHAProxyProtocolVersion1, localHAProxyProtocolVersion2 };
  }
  
  private HAProxyProtocolVersion(byte paramByte)
  {
    this.byteValue = ((byte)paramByte);
  }
  
  public static HAProxyProtocolVersion valueOf(byte paramByte)
  {
    int i = paramByte & 0xFFFFFFF0;
    paramByte = (byte)i;
    if (paramByte != 16)
    {
      if (paramByte == 32) {
        return V2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown version: ");
      localStringBuilder.append(i);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return V1;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyProtocolVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */