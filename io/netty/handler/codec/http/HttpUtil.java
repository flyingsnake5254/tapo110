package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class HttpUtil
{
  private static final AsciiString CHARSET_EQUALS;
  private static final AsciiString SEMICOLON = AsciiString.cached(";");
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpHeaderValues.CHARSET);
    localStringBuilder.append("=");
    CHARSET_EQUALS = AsciiString.of(localStringBuilder.toString());
  }
  
  public static String formatHostnameForHttp(InetSocketAddress paramInetSocketAddress)
  {
    String str = NetUtil.getHostname(paramInetSocketAddress);
    if (NetUtil.isValidIpV6Address(str))
    {
      if (!paramInetSocketAddress.isUnresolved()) {
        str = NetUtil.toAddressString(paramInetSocketAddress.getAddress());
      }
      paramInetSocketAddress = new StringBuilder();
      paramInetSocketAddress.append('[');
      paramInetSocketAddress.append(str);
      paramInetSocketAddress.append(']');
      return paramInetSocketAddress.toString();
    }
    return str;
  }
  
  public static Charset getCharset(HttpMessage paramHttpMessage)
  {
    return getCharset(paramHttpMessage, CharsetUtil.ISO_8859_1);
  }
  
  public static Charset getCharset(HttpMessage paramHttpMessage, Charset paramCharset)
  {
    paramHttpMessage = paramHttpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
    if (paramHttpMessage != null) {
      return getCharset(paramHttpMessage, paramCharset);
    }
    return paramCharset;
  }
  
  public static Charset getCharset(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return getCharset(paramCharSequence, CharsetUtil.ISO_8859_1);
    }
    return CharsetUtil.ISO_8859_1;
  }
  
  public static Charset getCharset(CharSequence paramCharSequence, Charset paramCharset)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = getCharsetAsSequence(paramCharSequence);
      if (paramCharSequence == null) {}
    }
    try
    {
      paramCharSequence = Charset.forName(paramCharSequence.toString());
      return paramCharSequence;
    }
    catch (IllegalCharsetNameException|UnsupportedCharsetException paramCharSequence)
    {
      for (;;) {}
    }
    return paramCharset;
  }
  
  public static CharSequence getCharsetAsSequence(HttpMessage paramHttpMessage)
  {
    paramHttpMessage = paramHttpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
    if (paramHttpMessage != null) {
      return getCharsetAsSequence(paramHttpMessage);
    }
    return null;
  }
  
  public static CharSequence getCharsetAsSequence(CharSequence paramCharSequence)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "contentTypeValue");
    AsciiString localAsciiString = CHARSET_EQUALS;
    int i = AsciiString.indexOfIgnoreCaseAscii(paramCharSequence, localAsciiString, 0);
    if (i == -1) {
      return null;
    }
    i += localAsciiString.length();
    if (i < paramCharSequence.length())
    {
      paramCharSequence = paramCharSequence.subSequence(i, paramCharSequence.length());
      i = AsciiString.indexOfIgnoreCaseAscii(paramCharSequence, SEMICOLON, 0);
      if (i == -1) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(0, i);
    }
    return null;
  }
  
  @Deprecated
  public static CharSequence getCharsetAsString(HttpMessage paramHttpMessage)
  {
    return getCharsetAsSequence(paramHttpMessage);
  }
  
  public static int getContentLength(HttpMessage paramHttpMessage, int paramInt)
  {
    return (int)Math.min(2147483647L, getContentLength(paramHttpMessage, paramInt));
  }
  
  public static long getContentLength(HttpMessage paramHttpMessage)
  {
    Object localObject = paramHttpMessage.headers();
    AsciiString localAsciiString = HttpHeaderNames.CONTENT_LENGTH;
    localObject = ((HttpHeaders)localObject).get(localAsciiString);
    if (localObject != null) {
      return Long.parseLong((String)localObject);
    }
    long l = getWebSocketContentLength(paramHttpMessage);
    if (l >= 0L) {
      return l;
    }
    paramHttpMessage = new StringBuilder();
    paramHttpMessage.append("header not found: ");
    paramHttpMessage.append(localAsciiString);
    throw new NumberFormatException(paramHttpMessage.toString());
  }
  
  public static long getContentLength(HttpMessage paramHttpMessage, long paramLong)
  {
    String str = paramHttpMessage.headers().get(HttpHeaderNames.CONTENT_LENGTH);
    if (str != null) {
      return Long.parseLong(str);
    }
    long l = getWebSocketContentLength(paramHttpMessage);
    if (l >= 0L) {
      return l;
    }
    return paramLong;
  }
  
  public static CharSequence getMimeType(HttpMessage paramHttpMessage)
  {
    paramHttpMessage = paramHttpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
    if (paramHttpMessage != null) {
      return getMimeType(paramHttpMessage);
    }
    return null;
  }
  
  public static CharSequence getMimeType(CharSequence paramCharSequence)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "contentTypeValue");
    int i = AsciiString.indexOfIgnoreCaseAscii(paramCharSequence, SEMICOLON, 0);
    if (i != -1) {
      return paramCharSequence.subSequence(0, i);
    }
    if (paramCharSequence.length() <= 0) {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  private static int getWebSocketContentLength(HttpMessage paramHttpMessage)
  {
    HttpHeaders localHttpHeaders = paramHttpMessage.headers();
    if ((paramHttpMessage instanceof HttpRequest))
    {
      paramHttpMessage = (HttpRequest)paramHttpMessage;
      if ((HttpMethod.GET.equals(paramHttpMessage.method())) && (localHttpHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY1)) && (localHttpHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2))) {
        return 8;
      }
    }
    else if (((paramHttpMessage instanceof HttpResponse)) && (((HttpResponse)paramHttpMessage).status().code() == 101) && (localHttpHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN)) && (localHttpHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_LOCATION)))
    {
      return 16;
    }
    return -1;
  }
  
  public static boolean is100ContinueExpected(HttpMessage paramHttpMessage)
  {
    boolean bool1 = isExpectHeaderValid(paramHttpMessage);
    boolean bool2 = true;
    if ((!bool1) || (!paramHttpMessage.headers().contains(HttpHeaderNames.EXPECT, HttpHeaderValues.CONTINUE, true))) {
      bool2 = false;
    }
    return bool2;
  }
  
  public static boolean isAsteriskForm(URI paramURI)
  {
    boolean bool;
    if (("*".equals(paramURI.getPath())) && (paramURI.getScheme() == null) && (paramURI.getSchemeSpecificPart() == null) && (paramURI.getHost() == null) && (paramURI.getAuthority() == null) && (paramURI.getQuery() == null) && (paramURI.getFragment() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isContentLengthSet(HttpMessage paramHttpMessage)
  {
    return paramHttpMessage.headers().contains(HttpHeaderNames.CONTENT_LENGTH);
  }
  
  private static boolean isExpectHeaderValid(HttpMessage paramHttpMessage)
  {
    boolean bool;
    if (((paramHttpMessage instanceof HttpRequest)) && (paramHttpMessage.protocolVersion().compareTo(HttpVersion.HTTP_1_1) >= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isKeepAlive(HttpMessage paramHttpMessage)
  {
    HttpHeaders localHttpHeaders = paramHttpMessage.headers();
    AsciiString localAsciiString1 = HttpHeaderNames.CONNECTION;
    AsciiString localAsciiString2 = HttpHeaderValues.CLOSE;
    boolean bool1 = true;
    if (!localHttpHeaders.containsValue(localAsciiString1, localAsciiString2, true))
    {
      bool2 = bool1;
      if (paramHttpMessage.protocolVersion().isKeepAliveDefault()) {
        break label71;
      }
      if (paramHttpMessage.headers().containsValue(localAsciiString1, HttpHeaderValues.KEEP_ALIVE, true))
      {
        bool2 = bool1;
        break label71;
      }
    }
    boolean bool2 = false;
    label71:
    return bool2;
  }
  
  public static boolean isOriginForm(URI paramURI)
  {
    boolean bool;
    if ((paramURI.getScheme() == null) && (paramURI.getSchemeSpecificPart() == null) && (paramURI.getHost() == null) && (paramURI.getAuthority() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isTransferEncodingChunked(HttpMessage paramHttpMessage)
  {
    return paramHttpMessage.headers().containsValue(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED, true);
  }
  
  static boolean isUnsupportedExpectation(HttpMessage paramHttpMessage)
  {
    boolean bool1 = isExpectHeaderValid(paramHttpMessage);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramHttpMessage = paramHttpMessage.headers().get(HttpHeaderNames.EXPECT);
    bool1 = bool2;
    if (paramHttpMessage != null)
    {
      bool1 = bool2;
      if (!HttpHeaderValues.CONTINUE.toString().equalsIgnoreCase(paramHttpMessage)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void set100ContinueExpected(HttpMessage paramHttpMessage, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramHttpMessage.headers().set(HttpHeaderNames.EXPECT, HttpHeaderValues.CONTINUE);
    } else {
      paramHttpMessage.headers().remove(HttpHeaderNames.EXPECT);
    }
  }
  
  public static void setContentLength(HttpMessage paramHttpMessage, long paramLong)
  {
    paramHttpMessage.headers().set(HttpHeaderNames.CONTENT_LENGTH, Long.valueOf(paramLong));
  }
  
  public static void setKeepAlive(HttpHeaders paramHttpHeaders, HttpVersion paramHttpVersion, boolean paramBoolean)
  {
    if (paramHttpVersion.isKeepAliveDefault())
    {
      if (paramBoolean) {
        paramHttpHeaders.remove(HttpHeaderNames.CONNECTION);
      } else {
        paramHttpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
      }
    }
    else if (paramBoolean) {
      paramHttpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
    } else {
      paramHttpHeaders.remove(HttpHeaderNames.CONNECTION);
    }
  }
  
  public static void setKeepAlive(HttpMessage paramHttpMessage, boolean paramBoolean)
  {
    setKeepAlive(paramHttpMessage.headers(), paramHttpMessage.protocolVersion(), paramBoolean);
  }
  
  public static void setTransferEncodingChunked(HttpMessage paramHttpMessage, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramHttpMessage.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
      paramHttpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
    }
    else
    {
      Object localObject = paramHttpMessage.headers().getAll(HttpHeaderNames.TRANSFER_ENCODING);
      if (((List)localObject).isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList((Collection)localObject);
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CharSequence localCharSequence = (CharSequence)((Iterator)localObject).next();
        if (HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase(localCharSequence)) {
          ((Iterator)localObject).remove();
        }
      }
      if (localArrayList.isEmpty()) {
        paramHttpMessage.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
      } else {
        paramHttpMessage.headers().set(HttpHeaderNames.TRANSFER_ENCODING, localArrayList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */