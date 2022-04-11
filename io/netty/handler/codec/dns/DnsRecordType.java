package io.netty.handler.codec.dns;

import io.netty.util.collection.IntObjectHashMap;
import java.util.HashMap;
import java.util.Map;

public class DnsRecordType
  implements Comparable<DnsRecordType>
{
  public static final DnsRecordType A;
  public static final DnsRecordType AAAA;
  public static final DnsRecordType AFSDB;
  public static final DnsRecordType ANY;
  public static final DnsRecordType APL;
  public static final DnsRecordType AXFR;
  private static final Map<String, DnsRecordType> BY_NAME;
  private static final IntObjectHashMap<DnsRecordType> BY_TYPE;
  public static final DnsRecordType CAA;
  public static final DnsRecordType CERT;
  public static final DnsRecordType CNAME;
  public static final DnsRecordType DHCID;
  public static final DnsRecordType DLV;
  public static final DnsRecordType DNAME;
  public static final DnsRecordType DNSKEY;
  public static final DnsRecordType DS;
  private static final String EXPECTED;
  public static final DnsRecordType HIP;
  public static final DnsRecordType IPSECKEY;
  public static final DnsRecordType IXFR;
  public static final DnsRecordType KEY;
  public static final DnsRecordType KX;
  public static final DnsRecordType LOC;
  public static final DnsRecordType MX;
  public static final DnsRecordType NAPTR;
  public static final DnsRecordType NS;
  public static final DnsRecordType NSEC;
  public static final DnsRecordType NSEC3;
  public static final DnsRecordType NSEC3PARAM;
  public static final DnsRecordType OPT;
  public static final DnsRecordType PTR;
  public static final DnsRecordType RP;
  public static final DnsRecordType RRSIG;
  public static final DnsRecordType SIG;
  public static final DnsRecordType SOA;
  public static final DnsRecordType SPF;
  public static final DnsRecordType SRV;
  public static final DnsRecordType SSHFP;
  public static final DnsRecordType TA;
  public static final DnsRecordType TKEY;
  public static final DnsRecordType TLSA;
  public static final DnsRecordType TSIG;
  public static final DnsRecordType TXT;
  private final int intValue;
  private final String name;
  private String text;
  
  static
  {
    DnsRecordType localDnsRecordType1 = new DnsRecordType(1, "A");
    A = localDnsRecordType1;
    DnsRecordType localDnsRecordType2 = new DnsRecordType(2, "NS");
    NS = localDnsRecordType2;
    DnsRecordType localDnsRecordType3 = new DnsRecordType(5, "CNAME");
    CNAME = localDnsRecordType3;
    DnsRecordType localDnsRecordType4 = new DnsRecordType(6, "SOA");
    SOA = localDnsRecordType4;
    DnsRecordType localDnsRecordType5 = new DnsRecordType(12, "PTR");
    PTR = localDnsRecordType5;
    DnsRecordType localDnsRecordType6 = new DnsRecordType(15, "MX");
    MX = localDnsRecordType6;
    DnsRecordType localDnsRecordType7 = new DnsRecordType(16, "TXT");
    TXT = localDnsRecordType7;
    DnsRecordType localDnsRecordType8 = new DnsRecordType(17, "RP");
    RP = localDnsRecordType8;
    DnsRecordType localDnsRecordType9 = new DnsRecordType(18, "AFSDB");
    AFSDB = localDnsRecordType9;
    DnsRecordType localDnsRecordType10 = new DnsRecordType(24, "SIG");
    SIG = localDnsRecordType10;
    DnsRecordType localDnsRecordType11 = new DnsRecordType(25, "KEY");
    KEY = localDnsRecordType11;
    DnsRecordType localDnsRecordType12 = new DnsRecordType(28, "AAAA");
    AAAA = localDnsRecordType12;
    DnsRecordType localDnsRecordType13 = new DnsRecordType(29, "LOC");
    LOC = localDnsRecordType13;
    DnsRecordType localDnsRecordType14 = new DnsRecordType(33, "SRV");
    SRV = localDnsRecordType14;
    DnsRecordType localDnsRecordType15 = new DnsRecordType(35, "NAPTR");
    NAPTR = localDnsRecordType15;
    DnsRecordType localDnsRecordType16 = new DnsRecordType(36, "KX");
    KX = localDnsRecordType16;
    DnsRecordType localDnsRecordType17 = new DnsRecordType(37, "CERT");
    CERT = localDnsRecordType17;
    DnsRecordType localDnsRecordType18 = new DnsRecordType(39, "DNAME");
    DNAME = localDnsRecordType18;
    DnsRecordType localDnsRecordType19 = new DnsRecordType(41, "OPT");
    OPT = localDnsRecordType19;
    DnsRecordType localDnsRecordType20 = new DnsRecordType(42, "APL");
    APL = localDnsRecordType20;
    DnsRecordType localDnsRecordType21 = new DnsRecordType(43, "DS");
    DS = localDnsRecordType21;
    DnsRecordType localDnsRecordType22 = new DnsRecordType(44, "SSHFP");
    SSHFP = localDnsRecordType22;
    DnsRecordType localDnsRecordType23 = new DnsRecordType(45, "IPSECKEY");
    IPSECKEY = localDnsRecordType23;
    DnsRecordType localDnsRecordType24 = new DnsRecordType(46, "RRSIG");
    RRSIG = localDnsRecordType24;
    DnsRecordType localDnsRecordType25 = new DnsRecordType(47, "NSEC");
    NSEC = localDnsRecordType25;
    DnsRecordType localDnsRecordType26 = new DnsRecordType(48, "DNSKEY");
    DNSKEY = localDnsRecordType26;
    DnsRecordType localDnsRecordType27 = new DnsRecordType(49, "DHCID");
    DHCID = localDnsRecordType27;
    DnsRecordType localDnsRecordType28 = new DnsRecordType(50, "NSEC3");
    NSEC3 = localDnsRecordType28;
    DnsRecordType localDnsRecordType29 = new DnsRecordType(51, "NSEC3PARAM");
    NSEC3PARAM = localDnsRecordType29;
    DnsRecordType localDnsRecordType30 = new DnsRecordType(52, "TLSA");
    TLSA = localDnsRecordType30;
    DnsRecordType localDnsRecordType31 = new DnsRecordType(55, "HIP");
    HIP = localDnsRecordType31;
    DnsRecordType localDnsRecordType32 = new DnsRecordType(99, "SPF");
    SPF = localDnsRecordType32;
    DnsRecordType localDnsRecordType33 = new DnsRecordType(249, "TKEY");
    TKEY = localDnsRecordType33;
    DnsRecordType localDnsRecordType34 = new DnsRecordType(250, "TSIG");
    TSIG = localDnsRecordType34;
    DnsRecordType localDnsRecordType35 = new DnsRecordType(251, "IXFR");
    IXFR = localDnsRecordType35;
    DnsRecordType localDnsRecordType36 = new DnsRecordType(252, "AXFR");
    AXFR = localDnsRecordType36;
    DnsRecordType localDnsRecordType37 = new DnsRecordType(255, "ANY");
    ANY = localDnsRecordType37;
    DnsRecordType localDnsRecordType38 = new DnsRecordType(257, "CAA");
    CAA = localDnsRecordType38;
    DnsRecordType localDnsRecordType39 = new DnsRecordType(32768, "TA");
    TA = localDnsRecordType39;
    DnsRecordType localDnsRecordType40 = new DnsRecordType(32769, "DLV");
    DLV = localDnsRecordType40;
    BY_NAME = new HashMap();
    BY_TYPE = new IntObjectHashMap();
    StringBuilder localStringBuilder = new StringBuilder(512);
    localStringBuilder.append(" (expected: ");
    for (int i = 0; i < 40; i++)
    {
      DnsRecordType localDnsRecordType41 = new DnsRecordType[] { localDnsRecordType1, localDnsRecordType2, localDnsRecordType3, localDnsRecordType4, localDnsRecordType5, localDnsRecordType6, localDnsRecordType7, localDnsRecordType8, localDnsRecordType9, localDnsRecordType10, localDnsRecordType11, localDnsRecordType12, localDnsRecordType13, localDnsRecordType14, localDnsRecordType15, localDnsRecordType16, localDnsRecordType17, localDnsRecordType18, localDnsRecordType19, localDnsRecordType20, localDnsRecordType21, localDnsRecordType22, localDnsRecordType23, localDnsRecordType24, localDnsRecordType25, localDnsRecordType26, localDnsRecordType27, localDnsRecordType28, localDnsRecordType29, localDnsRecordType30, localDnsRecordType31, localDnsRecordType32, localDnsRecordType33, localDnsRecordType34, localDnsRecordType35, localDnsRecordType36, localDnsRecordType37, localDnsRecordType38, localDnsRecordType39, localDnsRecordType40 }[i];
      BY_NAME.put(localDnsRecordType41.name(), localDnsRecordType41);
      BY_TYPE.put(localDnsRecordType41.intValue(), localDnsRecordType41);
      localStringBuilder.append(localDnsRecordType41.name());
      localStringBuilder.append('(');
      localStringBuilder.append(localDnsRecordType41.intValue());
      localStringBuilder.append("), ");
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    localStringBuilder.append(')');
    EXPECTED = localStringBuilder.toString();
  }
  
  private DnsRecordType(int paramInt)
  {
    this(paramInt, "UNKNOWN");
  }
  
  public DnsRecordType(int paramInt, String paramString)
  {
    if ((0xFFFF & paramInt) == paramInt)
    {
      this.intValue = paramInt;
      this.name = paramString;
      return;
    }
    paramString = new StringBuilder();
    paramString.append("intValue: ");
    paramString.append(paramInt);
    paramString.append(" (expected: 0 ~ 65535)");
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static DnsRecordType valueOf(int paramInt)
  {
    DnsRecordType localDnsRecordType1 = (DnsRecordType)BY_TYPE.get(paramInt);
    DnsRecordType localDnsRecordType2 = localDnsRecordType1;
    if (localDnsRecordType1 == null) {
      localDnsRecordType2 = new DnsRecordType(paramInt);
    }
    return localDnsRecordType2;
  }
  
  public static DnsRecordType valueOf(String paramString)
  {
    Object localObject = (DnsRecordType)BY_NAME.get(paramString);
    if (localObject != null) {
      return (DnsRecordType)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("name: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(EXPECTED);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public int compareTo(DnsRecordType paramDnsRecordType)
  {
    return intValue() - paramDnsRecordType.intValue();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof DnsRecordType)) && (((DnsRecordType)paramObject).intValue == this.intValue)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.intValue;
  }
  
  public int intValue()
  {
    return this.intValue;
  }
  
  public String name()
  {
    return this.name;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsRecordType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */