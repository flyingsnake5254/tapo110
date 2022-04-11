package io.netty.handler.codec.socksx.v4;

import io.netty.util.internal.ObjectUtil;

public class Socks4CommandStatus
  implements Comparable<Socks4CommandStatus>
{
  public static final Socks4CommandStatus IDENTD_AUTH_FAILURE = new Socks4CommandStatus(93, "IDENTD_AUTH_FAILURE");
  public static final Socks4CommandStatus IDENTD_UNREACHABLE;
  public static final Socks4CommandStatus REJECTED_OR_FAILED;
  public static final Socks4CommandStatus SUCCESS = new Socks4CommandStatus(90, "SUCCESS");
  private final byte byteValue;
  private final String name;
  private String text;
  
  static
  {
    REJECTED_OR_FAILED = new Socks4CommandStatus(91, "REJECTED_OR_FAILED");
    IDENTD_UNREACHABLE = new Socks4CommandStatus(92, "IDENTD_UNREACHABLE");
  }
  
  public Socks4CommandStatus(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public Socks4CommandStatus(int paramInt, String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.byteValue = ((byte)(byte)paramInt);
  }
  
  public static Socks4CommandStatus valueOf(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      return new Socks4CommandStatus(paramByte);
    case 93: 
      return IDENTD_AUTH_FAILURE;
    case 92: 
      return IDENTD_UNREACHABLE;
    case 91: 
      return REJECTED_OR_FAILED;
    }
    return SUCCESS;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(Socks4CommandStatus paramSocks4CommandStatus)
  {
    return this.byteValue - paramSocks4CommandStatus.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Socks4CommandStatus;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.byteValue == ((Socks4CommandStatus)paramObject).byteValue) {
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
    if (this.byteValue == 90) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4CommandStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */