package io.netty.handler.codec.haproxy;

public enum HAProxyProxiedProtocol
{
  private final AddressFamily addressFamily;
  private final byte byteValue;
  private final TransportProtocol transportProtocol;
  
  static
  {
    HAProxyProxiedProtocol localHAProxyProxiedProtocol1 = new HAProxyProxiedProtocol("UNKNOWN", 0, (byte)0, AddressFamily.AF_UNSPEC, TransportProtocol.UNSPEC);
    UNKNOWN = localHAProxyProxiedProtocol1;
    Object localObject1 = AddressFamily.AF_IPv4;
    Object localObject2 = TransportProtocol.STREAM;
    HAProxyProxiedProtocol localHAProxyProxiedProtocol2 = new HAProxyProxiedProtocol("TCP4", 1, (byte)17, (AddressFamily)localObject1, (TransportProtocol)localObject2);
    TCP4 = localHAProxyProxiedProtocol2;
    Object localObject3 = AddressFamily.AF_IPv6;
    HAProxyProxiedProtocol localHAProxyProxiedProtocol3 = new HAProxyProxiedProtocol("TCP6", 2, (byte)33, (AddressFamily)localObject3, (TransportProtocol)localObject2);
    TCP6 = localHAProxyProxiedProtocol3;
    Object localObject4 = TransportProtocol.DGRAM;
    localObject1 = new HAProxyProxiedProtocol("UDP4", 3, (byte)18, (AddressFamily)localObject1, (TransportProtocol)localObject4);
    UDP4 = (HAProxyProxiedProtocol)localObject1;
    localObject3 = new HAProxyProxiedProtocol("UDP6", 4, (byte)34, (AddressFamily)localObject3, (TransportProtocol)localObject4);
    UDP6 = (HAProxyProxiedProtocol)localObject3;
    AddressFamily localAddressFamily = AddressFamily.AF_UNIX;
    localObject2 = new HAProxyProxiedProtocol("UNIX_STREAM", 5, (byte)49, localAddressFamily, (TransportProtocol)localObject2);
    UNIX_STREAM = (HAProxyProxiedProtocol)localObject2;
    localObject4 = new HAProxyProxiedProtocol("UNIX_DGRAM", 6, (byte)50, localAddressFamily, (TransportProtocol)localObject4);
    UNIX_DGRAM = (HAProxyProxiedProtocol)localObject4;
    $VALUES = new HAProxyProxiedProtocol[] { localHAProxyProxiedProtocol1, localHAProxyProxiedProtocol2, localHAProxyProxiedProtocol3, localObject1, localObject3, localObject2, localObject4 };
  }
  
  private HAProxyProxiedProtocol(byte paramByte, AddressFamily paramAddressFamily, TransportProtocol paramTransportProtocol)
  {
    this.byteValue = ((byte)paramByte);
    this.addressFamily = paramAddressFamily;
    this.transportProtocol = paramTransportProtocol;
  }
  
  public static HAProxyProxiedProtocol valueOf(byte paramByte)
  {
    if (paramByte != 0)
    {
      if (paramByte != 17)
      {
        if (paramByte != 18)
        {
          if (paramByte != 33)
          {
            if (paramByte != 34)
            {
              if (paramByte != 49)
              {
                if (paramByte == 50) {
                  return UNIX_DGRAM;
                }
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("unknown transport protocol + address family: ");
                localStringBuilder.append(paramByte & 0xFF);
                throw new IllegalArgumentException(localStringBuilder.toString());
              }
              return UNIX_STREAM;
            }
            return UDP6;
          }
          return TCP6;
        }
        return UDP4;
      }
      return TCP4;
    }
    return UNKNOWN;
  }
  
  public AddressFamily addressFamily()
  {
    return this.addressFamily;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public TransportProtocol transportProtocol()
  {
    return this.transportProtocol;
  }
  
  public static enum AddressFamily
  {
    private static final byte FAMILY_MASK = -16;
    private final byte byteValue;
    
    static
    {
      AddressFamily localAddressFamily1 = new AddressFamily("AF_UNSPEC", 0, (byte)0);
      AF_UNSPEC = localAddressFamily1;
      AddressFamily localAddressFamily2 = new AddressFamily("AF_IPv4", 1, (byte)16);
      AF_IPv4 = localAddressFamily2;
      AddressFamily localAddressFamily3 = new AddressFamily("AF_IPv6", 2, (byte)32);
      AF_IPv6 = localAddressFamily3;
      AddressFamily localAddressFamily4 = new AddressFamily("AF_UNIX", 3, (byte)48);
      AF_UNIX = localAddressFamily4;
      $VALUES = new AddressFamily[] { localAddressFamily1, localAddressFamily2, localAddressFamily3, localAddressFamily4 };
    }
    
    private AddressFamily(byte paramByte)
    {
      this.byteValue = ((byte)paramByte);
    }
    
    public static AddressFamily valueOf(byte paramByte)
    {
      paramByte &= 0xFFFFFFF0;
      int i = (byte)paramByte;
      if (i != 0)
      {
        if (i != 16)
        {
          if (i != 32)
          {
            if (i == 48) {
              return AF_UNIX;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("unknown address family: ");
            localStringBuilder.append(paramByte);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          return AF_IPv6;
        }
        return AF_IPv4;
      }
      return AF_UNSPEC;
    }
    
    public byte byteValue()
    {
      return this.byteValue;
    }
  }
  
  public static enum TransportProtocol
  {
    private static final byte TRANSPORT_MASK = 15;
    private final byte transportByte;
    
    static
    {
      TransportProtocol localTransportProtocol1 = new TransportProtocol("UNSPEC", 0, (byte)0);
      UNSPEC = localTransportProtocol1;
      TransportProtocol localTransportProtocol2 = new TransportProtocol("STREAM", 1, (byte)1);
      STREAM = localTransportProtocol2;
      TransportProtocol localTransportProtocol3 = new TransportProtocol("DGRAM", 2, (byte)2);
      DGRAM = localTransportProtocol3;
      $VALUES = new TransportProtocol[] { localTransportProtocol1, localTransportProtocol2, localTransportProtocol3 };
    }
    
    private TransportProtocol(byte paramByte)
    {
      this.transportByte = ((byte)paramByte);
    }
    
    public static TransportProtocol valueOf(byte paramByte)
    {
      paramByte &= 0xF;
      int i = (byte)paramByte;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            return DGRAM;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unknown transport protocol: ");
          localStringBuilder.append(paramByte);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return STREAM;
      }
      return UNSPEC;
    }
    
    public byte byteValue()
    {
      return this.transportByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyProxiedProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */