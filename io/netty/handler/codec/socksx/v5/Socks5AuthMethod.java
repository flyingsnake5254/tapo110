package io.netty.handler.codec.socksx.v5;

import io.netty.util.internal.ObjectUtil;

public class Socks5AuthMethod
  implements Comparable<Socks5AuthMethod>
{
  public static final Socks5AuthMethod GSSAPI = new Socks5AuthMethod(1, "GSSAPI");
  public static final Socks5AuthMethod NO_AUTH = new Socks5AuthMethod(0, "NO_AUTH");
  public static final Socks5AuthMethod PASSWORD = new Socks5AuthMethod(2, "PASSWORD");
  public static final Socks5AuthMethod UNACCEPTED = new Socks5AuthMethod(255, "UNACCEPTED");
  private final byte byteValue;
  private final String name;
  private String text;
  
  public Socks5AuthMethod(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public Socks5AuthMethod(int paramInt, String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.byteValue = ((byte)(byte)paramInt);
  }
  
  public static Socks5AuthMethod valueOf(byte paramByte)
  {
    if (paramByte != -1)
    {
      if (paramByte != 0)
      {
        if (paramByte != 1)
        {
          if (paramByte != 2) {
            return new Socks5AuthMethod(paramByte);
          }
          return PASSWORD;
        }
        return GSSAPI;
      }
      return NO_AUTH;
    }
    return UNACCEPTED;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(Socks5AuthMethod paramSocks5AuthMethod)
  {
    return this.byteValue - paramSocks5AuthMethod.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Socks5AuthMethod;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.byteValue == ((Socks5AuthMethod)paramObject).byteValue) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5AuthMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */