package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpVersion
  implements Comparable<HttpVersion>
{
  public static final HttpVersion HTTP_1_0 = new HttpVersion("HTTP", 1, 0, false, true);
  private static final String HTTP_1_0_STRING = "HTTP/1.0";
  public static final HttpVersion HTTP_1_1 = new HttpVersion("HTTP", 1, 1, true, true);
  private static final String HTTP_1_1_STRING = "HTTP/1.1";
  private static final Pattern VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");
  private final byte[] bytes;
  private final boolean keepAliveDefault;
  private final int majorVersion;
  private final int minorVersion;
  private final String protocolName;
  private final String text;
  
  public HttpVersion(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramString, paramInt1, paramInt2, paramBoolean, false);
  }
  
  private HttpVersion(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ObjectUtil.checkNotNull(paramString, "protocolName");
    String str = paramString.trim().toUpperCase();
    if (!str.isEmpty())
    {
      int i = 0;
      while (i < str.length()) {
        if ((!Character.isISOControl(str.charAt(i))) && (!Character.isWhitespace(str.charAt(i)))) {
          i++;
        } else {
          throw new IllegalArgumentException("invalid character in protocolName");
        }
      }
      ObjectUtil.checkPositiveOrZero(paramInt1, "majorVersion");
      ObjectUtil.checkPositiveOrZero(paramInt2, "minorVersion");
      this.protocolName = str;
      this.majorVersion = paramInt1;
      this.minorVersion = paramInt2;
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append('/');
      paramString.append(paramInt1);
      paramString.append('.');
      paramString.append(paramInt2);
      paramString = paramString.toString();
      this.text = paramString;
      this.keepAliveDefault = paramBoolean1;
      if (paramBoolean2) {
        this.bytes = paramString.getBytes(CharsetUtil.US_ASCII);
      } else {
        this.bytes = null;
      }
      return;
    }
    throw new IllegalArgumentException("empty protocolName");
  }
  
  public HttpVersion(String paramString, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramString, "text");
    paramString = paramString.trim().toUpperCase();
    if (!paramString.isEmpty())
    {
      Object localObject = VERSION_PATTERN.matcher(paramString);
      if (((Matcher)localObject).matches())
      {
        paramString = ((Matcher)localObject).group(1);
        this.protocolName = paramString;
        int i = Integer.parseInt(((Matcher)localObject).group(2));
        this.majorVersion = i;
        int j = Integer.parseInt(((Matcher)localObject).group(3));
        this.minorVersion = j;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append('/');
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append('.');
        ((StringBuilder)localObject).append(j);
        this.text = ((StringBuilder)localObject).toString();
        this.keepAliveDefault = paramBoolean;
        this.bytes = null;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid version format: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("empty text");
  }
  
  public static HttpVersion valueOf(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "text");
    String str = paramString.trim();
    if (!str.isEmpty())
    {
      HttpVersion localHttpVersion = version0(str);
      paramString = localHttpVersion;
      if (localHttpVersion == null) {
        paramString = new HttpVersion(str, true);
      }
      return paramString;
    }
    throw new IllegalArgumentException("text is empty (possibly HTTP/0.9)");
  }
  
  private static HttpVersion version0(String paramString)
  {
    if ("HTTP/1.1".equals(paramString)) {
      return HTTP_1_1;
    }
    if ("HTTP/1.0".equals(paramString)) {
      return HTTP_1_0;
    }
    return null;
  }
  
  public int compareTo(HttpVersion paramHttpVersion)
  {
    int i = protocolName().compareTo(paramHttpVersion.protocolName());
    if (i != 0) {
      return i;
    }
    i = majorVersion() - paramHttpVersion.majorVersion();
    if (i != 0) {
      return i;
    }
    return minorVersion() - paramHttpVersion.minorVersion();
  }
  
  void encode(ByteBuf paramByteBuf)
  {
    byte[] arrayOfByte = this.bytes;
    if (arrayOfByte == null) {
      paramByteBuf.writeCharSequence(this.text, CharsetUtil.US_ASCII);
    } else {
      paramByteBuf.writeBytes(arrayOfByte);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof HttpVersion;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (HttpVersion)paramObject;
    bool1 = bool2;
    if (minorVersion() == ((HttpVersion)paramObject).minorVersion())
    {
      bool1 = bool2;
      if (majorVersion() == ((HttpVersion)paramObject).majorVersion())
      {
        bool1 = bool2;
        if (protocolName().equals(((HttpVersion)paramObject).protocolName())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (protocolName().hashCode() * 31 + majorVersion()) * 31 + minorVersion();
  }
  
  public boolean isKeepAliveDefault()
  {
    return this.keepAliveDefault;
  }
  
  public int majorVersion()
  {
    return this.majorVersion;
  }
  
  public int minorVersion()
  {
    return this.minorVersion;
  }
  
  public String protocolName()
  {
    return this.protocolName;
  }
  
  public String text()
  {
    return this.text;
  }
  
  public String toString()
  {
    return text();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */