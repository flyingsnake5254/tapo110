package io.netty.handler.codec.socksx.v5;

import io.netty.util.internal.ObjectUtil;

public class Socks5PasswordAuthStatus
  implements Comparable<Socks5PasswordAuthStatus>
{
  public static final Socks5PasswordAuthStatus FAILURE = new Socks5PasswordAuthStatus(255, "FAILURE");
  public static final Socks5PasswordAuthStatus SUCCESS = new Socks5PasswordAuthStatus(0, "SUCCESS");
  private final byte byteValue;
  private final String name;
  private String text;
  
  public Socks5PasswordAuthStatus(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public Socks5PasswordAuthStatus(int paramInt, String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.byteValue = ((byte)(byte)paramInt);
  }
  
  public static Socks5PasswordAuthStatus valueOf(byte paramByte)
  {
    if (paramByte != -1)
    {
      if (paramByte != 0) {
        return new Socks5PasswordAuthStatus(paramByte);
      }
      return SUCCESS;
    }
    return FAILURE;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(Socks5PasswordAuthStatus paramSocks5PasswordAuthStatus)
  {
    return this.byteValue - paramSocks5PasswordAuthStatus.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Socks5PasswordAuthStatus;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.byteValue == ((Socks5PasswordAuthStatus)paramObject).byteValue) {
      bool2 = true;
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return this.byteValue;
  }
  
  public boolean isSuccess()
  {
    boolean bool;
    if (this.byteValue == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5PasswordAuthStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */