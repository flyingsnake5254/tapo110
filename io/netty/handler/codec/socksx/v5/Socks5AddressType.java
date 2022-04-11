package io.netty.handler.codec.socksx.v5;

import io.netty.util.internal.ObjectUtil;

public class Socks5AddressType
  implements Comparable<Socks5AddressType>
{
  public static final Socks5AddressType DOMAIN = new Socks5AddressType(3, "DOMAIN");
  public static final Socks5AddressType IPv4 = new Socks5AddressType(1, "IPv4");
  public static final Socks5AddressType IPv6 = new Socks5AddressType(4, "IPv6");
  private final byte byteValue;
  private final String name;
  private String text;
  
  public Socks5AddressType(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public Socks5AddressType(int paramInt, String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.byteValue = ((byte)(byte)paramInt);
  }
  
  public static Socks5AddressType valueOf(byte paramByte)
  {
    if (paramByte != 1)
    {
      if (paramByte != 3)
      {
        if (paramByte != 4) {
          return new Socks5AddressType(paramByte);
        }
        return IPv6;
      }
      return DOMAIN;
    }
    return IPv4;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(Socks5AddressType paramSocks5AddressType)
  {
    return this.byteValue - paramSocks5AddressType.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Socks5AddressType;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.byteValue == ((Socks5AddressType)paramObject).byteValue) {
      bool2 = true;
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return this.byteValue;
  }
  
  public String toString()
  {
    String str = this.text;
    Object localObject = str;
    if (str == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.name);
      ((StringBuilder)localObject).append('(');
      ((StringBuilder)localObject).append(this.byteValue & 0xFF);
      ((StringBuilder)localObject).append(')');
      localObject = ((StringBuilder)localObject).toString();
      this.text = ((String)localObject);
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5AddressType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */