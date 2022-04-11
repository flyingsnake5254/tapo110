package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;

public class DnsResponseCode
  implements Comparable<DnsResponseCode>
{
  public static final DnsResponseCode BADALG = new DnsResponseCode(21, "BADALG");
  public static final DnsResponseCode BADKEY;
  public static final DnsResponseCode BADMODE;
  public static final DnsResponseCode BADNAME;
  public static final DnsResponseCode BADTIME;
  public static final DnsResponseCode BADVERS_OR_BADSIG;
  public static final DnsResponseCode FORMERR;
  public static final DnsResponseCode NOERROR = new DnsResponseCode(0, "NoError");
  public static final DnsResponseCode NOTAUTH;
  public static final DnsResponseCode NOTIMP;
  public static final DnsResponseCode NOTZONE;
  public static final DnsResponseCode NXDOMAIN;
  public static final DnsResponseCode NXRRSET;
  public static final DnsResponseCode REFUSED;
  public static final DnsResponseCode SERVFAIL;
  public static final DnsResponseCode YXDOMAIN;
  public static final DnsResponseCode YXRRSET;
  private final int code;
  private final String name;
  private String text;
  
  static
  {
    FORMERR = new DnsResponseCode(1, "FormErr");
    SERVFAIL = new DnsResponseCode(2, "ServFail");
    NXDOMAIN = new DnsResponseCode(3, "NXDomain");
    NOTIMP = new DnsResponseCode(4, "NotImp");
    REFUSED = new DnsResponseCode(5, "Refused");
    YXDOMAIN = new DnsResponseCode(6, "YXDomain");
    YXRRSET = new DnsResponseCode(7, "YXRRSet");
    NXRRSET = new DnsResponseCode(8, "NXRRSet");
    NOTAUTH = new DnsResponseCode(9, "NotAuth");
    NOTZONE = new DnsResponseCode(10, "NotZone");
    BADVERS_OR_BADSIG = new DnsResponseCode(16, "BADVERS_OR_BADSIG");
    BADKEY = new DnsResponseCode(17, "BADKEY");
    BADTIME = new DnsResponseCode(18, "BADTIME");
    BADMODE = new DnsResponseCode(19, "BADMODE");
    BADNAME = new DnsResponseCode(20, "BADNAME");
  }
  
  private DnsResponseCode(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public DnsResponseCode(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      this.code = paramInt;
      this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
      return;
    }
    paramString = new StringBuilder();
    paramString.append("code: ");
    paramString.append(paramInt);
    paramString.append(" (expected: 0 ~ 65535)");
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static DnsResponseCode valueOf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        return new DnsResponseCode(paramInt);
      case 21: 
        return BADALG;
      case 20: 
        return BADNAME;
      case 19: 
        return BADMODE;
      case 18: 
        return BADTIME;
      case 17: 
        return BADKEY;
      }
      return BADVERS_OR_BADSIG;
    case 10: 
      return NOTZONE;
    case 9: 
      return NOTAUTH;
    case 8: 
      return NXRRSET;
    case 7: 
      return YXRRSET;
    case 6: 
      return YXDOMAIN;
    case 5: 
      return REFUSED;
    case 4: 
      return NOTIMP;
    case 3: 
      return NXDOMAIN;
    case 2: 
      return SERVFAIL;
    case 1: 
      return FORMERR;
    }
    return NOERROR;
  }
  
  public int compareTo(DnsResponseCode paramDnsResponseCode)
  {
    return intValue() - paramDnsResponseCode.intValue();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DnsResponseCode;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (intValue() == ((DnsResponseCode)paramObject).intValue()) {
      bool2 = true;
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return intValue();
  }
  
  public int intValue()
  {
    return this.code;
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
      ((StringBuilder)localObject).append(intValue());
      ((StringBuilder)localObject).append(')');
      localObject = ((StringBuilder)localObject).toString();
      this.text = ((String)localObject);
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsResponseCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */