package io.netty.handler.codec.socksx.v4;

import io.netty.util.internal.ObjectUtil;

public class Socks4CommandType
  implements Comparable<Socks4CommandType>
{
  public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");
  public static final Socks4CommandType CONNECT = new Socks4CommandType(1, "CONNECT");
  private final byte byteValue;
  private final String name;
  private String text;
  
  public Socks4CommandType(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public Socks4CommandType(int paramInt, String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.byteValue = ((byte)(byte)paramInt);
  }
  
  public static Socks4CommandType valueOf(byte paramByte)
  {
    if (paramByte != 1)
    {
      if (paramByte != 2) {
        return new Socks4CommandType(paramByte);
      }
      return BIND;
    }
    return CONNECT;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(Socks4CommandType paramSocks4CommandType)
  {
    return this.byteValue - paramSocks4CommandType.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Socks4CommandType;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.byteValue == ((Socks4CommandType)paramObject).byteValue) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4CommandType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */