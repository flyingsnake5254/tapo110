package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;

public class DnsOpCode
  implements Comparable<DnsOpCode>
{
  public static final DnsOpCode IQUERY;
  public static final DnsOpCode NOTIFY = new DnsOpCode(4, "NOTIFY");
  public static final DnsOpCode QUERY = new DnsOpCode(0, "QUERY");
  public static final DnsOpCode STATUS;
  public static final DnsOpCode UPDATE = new DnsOpCode(5, "UPDATE");
  private final byte byteValue;
  private final String name;
  private String text;
  
  static
  {
    IQUERY = new DnsOpCode(1, "IQUERY");
    STATUS = new DnsOpCode(2, "STATUS");
  }
  
  private DnsOpCode(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public DnsOpCode(int paramInt, String paramString)
  {
    this.byteValue = ((byte)(byte)paramInt);
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
  }
  
  public static DnsOpCode valueOf(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return new DnsOpCode(paramInt);
            }
            return UPDATE;
          }
          return NOTIFY;
        }
        return STATUS;
      }
      return IQUERY;
    }
    return QUERY;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
  
  public int compareTo(DnsOpCode paramDnsOpCode)
  {
    return this.byteValue - paramDnsOpCode.byteValue;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DnsOpCode)) {
      return false;
    }
    if (this.byteValue != ((DnsOpCode)paramObject).byteValue) {
      bool = false;
    }
    return bool;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsOpCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */