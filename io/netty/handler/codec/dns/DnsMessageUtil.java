package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.util.internal.StringUtil;

final class DnsMessageUtil
{
  private static StringBuilder appendAddresses(StringBuilder paramStringBuilder, DnsMessage paramDnsMessage)
  {
    if (!(paramDnsMessage instanceof AddressedEnvelope)) {
      return paramStringBuilder;
    }
    AddressedEnvelope localAddressedEnvelope = (AddressedEnvelope)paramDnsMessage;
    paramDnsMessage = localAddressedEnvelope.sender();
    if (paramDnsMessage != null)
    {
      paramStringBuilder.append("from: ");
      paramStringBuilder.append(paramDnsMessage);
      paramStringBuilder.append(", ");
    }
    paramDnsMessage = localAddressedEnvelope.recipient();
    if (paramDnsMessage != null)
    {
      paramStringBuilder.append("to: ");
      paramStringBuilder.append(paramDnsMessage);
      paramStringBuilder.append(", ");
    }
    return paramStringBuilder;
  }
  
  private static void appendAllRecords(StringBuilder paramStringBuilder, DnsMessage paramDnsMessage)
  {
    appendRecords(paramStringBuilder, paramDnsMessage, DnsSection.QUESTION);
    appendRecords(paramStringBuilder, paramDnsMessage, DnsSection.ANSWER);
    appendRecords(paramStringBuilder, paramDnsMessage, DnsSection.AUTHORITY);
    appendRecords(paramStringBuilder, paramDnsMessage, DnsSection.ADDITIONAL);
  }
  
  static StringBuilder appendQuery(StringBuilder paramStringBuilder, DnsQuery paramDnsQuery)
  {
    appendQueryHeader(paramStringBuilder, paramDnsQuery);
    appendAllRecords(paramStringBuilder, paramDnsQuery);
    return paramStringBuilder;
  }
  
  private static void appendQueryHeader(StringBuilder paramStringBuilder, DnsQuery paramDnsQuery)
  {
    paramStringBuilder.append(StringUtil.simpleClassName(paramDnsQuery));
    paramStringBuilder.append('(');
    StringBuilder localStringBuilder = appendAddresses(paramStringBuilder, paramDnsQuery);
    localStringBuilder.append(paramDnsQuery.id());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramDnsQuery.opCode());
    if (paramDnsQuery.isRecursionDesired()) {
      paramStringBuilder.append(", RD");
    }
    if (paramDnsQuery.z() != 0)
    {
      paramStringBuilder.append(", Z: ");
      paramStringBuilder.append(paramDnsQuery.z());
    }
    paramStringBuilder.append(')');
  }
  
  static StringBuilder appendRecordClass(StringBuilder paramStringBuilder, int paramInt)
  {
    paramInt &= 0xFFFF;
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 254)
            {
              if (paramInt != 255) {
                str = null;
              } else {
                str = "ANY";
              }
            }
            else {
              str = "NONE";
            }
          }
          else {
            str = "HESIOD";
          }
        }
        else {
          str = "CHAOS";
        }
      }
      else {
        str = "CSNET";
      }
    }
    else {
      str = "IN";
    }
    if (str != null)
    {
      paramStringBuilder.append(str);
    }
    else
    {
      paramStringBuilder.append("UNKNOWN(");
      paramStringBuilder.append(paramInt);
      paramStringBuilder.append(')');
    }
    return paramStringBuilder;
  }
  
  private static void appendRecords(StringBuilder paramStringBuilder, DnsMessage paramDnsMessage, DnsSection paramDnsSection)
  {
    int i = paramDnsMessage.count(paramDnsSection);
    for (int j = 0; j < i; j++)
    {
      paramStringBuilder.append(StringUtil.NEWLINE);
      paramStringBuilder.append('\t');
      paramStringBuilder.append(paramDnsMessage.recordAt(paramDnsSection, j));
    }
  }
  
  static StringBuilder appendResponse(StringBuilder paramStringBuilder, DnsResponse paramDnsResponse)
  {
    appendResponseHeader(paramStringBuilder, paramDnsResponse);
    appendAllRecords(paramStringBuilder, paramDnsResponse);
    return paramStringBuilder;
  }
  
  private static void appendResponseHeader(StringBuilder paramStringBuilder, DnsResponse paramDnsResponse)
  {
    paramStringBuilder.append(StringUtil.simpleClassName(paramDnsResponse));
    paramStringBuilder.append('(');
    StringBuilder localStringBuilder = appendAddresses(paramStringBuilder, paramDnsResponse);
    localStringBuilder.append(paramDnsResponse.id());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramDnsResponse.opCode());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramDnsResponse.code());
    localStringBuilder.append(',');
    boolean bool = paramDnsResponse.isRecursionDesired();
    int i = 0;
    int j;
    if (bool)
    {
      paramStringBuilder.append(" RD");
      j = 0;
    }
    else
    {
      j = 1;
    }
    if (paramDnsResponse.isAuthoritativeAnswer())
    {
      paramStringBuilder.append(" AA");
      j = 0;
    }
    if (paramDnsResponse.isTruncated())
    {
      paramStringBuilder.append(" TC");
      j = 0;
    }
    if (paramDnsResponse.isRecursionAvailable())
    {
      paramStringBuilder.append(" RA");
      j = i;
    }
    if (paramDnsResponse.z() != 0)
    {
      if (j == 0) {
        paramStringBuilder.append(',');
      }
      paramStringBuilder.append(" Z: ");
      paramStringBuilder.append(paramDnsResponse.z());
    }
    if (j != 0) {
      paramStringBuilder.setCharAt(paramStringBuilder.length() - 1, ')');
    } else {
      paramStringBuilder.append(')');
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsMessageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */