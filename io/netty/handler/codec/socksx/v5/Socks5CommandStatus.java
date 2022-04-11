package io.netty.handler.codec.socksx.v5;

import io.netty.util.internal.ObjectUtil;

public class Socks5CommandStatus
  implements Comparable<Socks5CommandStatus>
{
  public static final Socks5CommandStatus ADDRESS_UNSUPPORTED = new Socks5CommandStatus(8, "ADDRESS_UNSUPPORTED");
  public static final Socks5CommandStatus COMMAND_UNSUPPORTED;
  public static final Socks5CommandStatus CONNECTION_REFUSED;
  public static final Socks5CommandStatus FAILURE;
  public static final Socks5CommandStatus FORBIDDEN;
  public static final Socks5CommandStatus HOST_UNREACHABLE;
  public static final Socks5CommandStatus NETWORK_UNREACHABLE;
  public static final Socks5CommandStatus SUCCESS = new Socks5CommandStatus(0, "SUCCESS");
  public static final Socks5CommandStatus TTL_EXPIRED;
  private final byte byteValue;
  private final String name;
  private String text;
  
  static
  {
    FAILURE = new Socks5CommandStatus(1, "FAILURE");
    FORBIDDEN = new Socks5CommandStatus(2, "FORBIDDEN");
    NETWORK_UNREACHABLE = new Socks5CommandStatus(3, "NETWORK_UNREACHABLE");
    HOST_UNREACHABLE = new Socks5CommandStatus(4, "HOST_UNREACHABLE");
    CONNECTION_REFUSED = new Socks5CommandStatus(5, "CONNECTION_REFUSED");
    TTL_EXPIRED = new Socks5CommandStatus(6, "TTL_EXPIRED");
    COMMAND_UNSUPPORTED = new Socks5CommandStatus(7, "COMMAND_UNSUPPORTED");
  }
  
  public Socks5CommandStatus(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public Socks5CommandStatus(int paramInt, String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.byteValue = ((byte)(byte)paramInt);
  }
  
  public static Socks5CommandStatus valueOf(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      return new Socks5CommandStatus(paramByte);
    case 8: 
      return ADDRESS_UNSUPPORTED;
    case 7: 
      return COMMAND_UNSUPPORTED;
    case 6: 
      return TTL_EXPIRED;
    case 5: 
      return CONNECTION_REFUSED;
    case 4: 
      return HOST_UNREACHABLE;
    case 3: 
      return NETWORK_UNREACHABLE;
    case 2: 
      return FORBIDDEN;
    case 1: 
      return FAILURE;
    }
    return SUCCESS;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(Socks5CommandStatus paramSocks5CommandStatus)
  {
    return this.byteValue - paramSocks5CommandStatus.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Socks5CommandStatus;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.byteValue == ((Socks5CommandStatus)paramObject).byteValue) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5CommandStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */