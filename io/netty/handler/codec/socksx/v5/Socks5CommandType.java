package io.netty.handler.codec.socksx.v5;

import io.netty.util.internal.ObjectUtil;

public class Socks5CommandType
  implements Comparable<Socks5CommandType>
{
  public static final Socks5CommandType BIND = new Socks5CommandType(2, "BIND");
  public static final Socks5CommandType CONNECT = new Socks5CommandType(1, "CONNECT");
  public static final Socks5CommandType UDP_ASSOCIATE = new Socks5CommandType(3, "UDP_ASSOCIATE");
  private final byte byteValue;
  private final String name;
  private String text;
  
  public Socks5CommandType(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public Socks5CommandType(int paramInt, String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.byteValue = ((byte)(byte)paramInt);
  }
  
  public static Socks5CommandType valueOf(byte paramByte)
  {
    if (paramByte != 1)
    {
      if (paramByte != 2)
      {
        if (paramByte != 3) {
          return new Socks5CommandType(paramByte);
        }
        return UDP_ASSOCIATE;
      }
      return BIND;
    }
    return CONNECT;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(Socks5CommandType paramSocks5CommandType)
  {
    return this.byteValue - paramSocks5CommandType.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Socks5CommandType;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.byteValue == ((Socks5CommandType)paramObject).byteValue) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5CommandType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */