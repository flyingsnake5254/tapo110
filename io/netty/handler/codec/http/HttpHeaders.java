package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.HeadersUtils;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class HttpHeaders
  implements Iterable<Map.Entry<String, String>>
{
  @Deprecated
  public static final HttpHeaders EMPTY_HEADERS = ;
  
  @Deprecated
  public static void addDateHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Date paramDate)
  {
    paramHttpMessage.headers().add(paramCharSequence, paramDate);
  }
  
  @Deprecated
  public static void addDateHeader(HttpMessage paramHttpMessage, String paramString, Date paramDate)
  {
    paramHttpMessage.headers().add(paramString, paramDate);
  }
  
  @Deprecated
  public static void addHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Object paramObject)
  {
    paramHttpMessage.headers().add(paramCharSequence, paramObject);
  }
  
  @Deprecated
  public static void addHeader(HttpMessage paramHttpMessage, String paramString, Object paramObject)
  {
    paramHttpMessage.headers().add(paramString, paramObject);
  }
  
  @Deprecated
  public static void addIntHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, int paramInt)
  {
    paramHttpMessage.headers().addInt(paramCharSequence, paramInt);
  }
  
  @Deprecated
  public static void addIntHeader(HttpMessage paramHttpMessage, String paramString, int paramInt)
  {
    paramHttpMessage.headers().add(paramString, Integer.valueOf(paramInt));
  }
  
  @Deprecated
  public static void clearHeaders(HttpMessage paramHttpMessage)
  {
    paramHttpMessage.headers().clear();
  }
  
  private static boolean containsCommaSeparatedTrimmed(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    int m;
    if (paramBoolean)
    {
      i = AsciiString.indexOf(paramCharSequence1, ',', 0);
      if (i == -1)
      {
        if (AsciiString.contentEqualsIgnoreCase(AsciiString.trim(paramCharSequence1), paramCharSequence2)) {
          return true;
        }
      }
      else
      {
        j = 0;
        do
        {
          if (AsciiString.contentEqualsIgnoreCase(AsciiString.trim(paramCharSequence1.subSequence(j, i)), paramCharSequence2)) {
            return true;
          }
          k = i + 1;
          m = AsciiString.indexOf(paramCharSequence1, ',', k);
          j = k;
          i = m;
        } while (m != -1);
        if ((k < paramCharSequence1.length()) && (AsciiString.contentEqualsIgnoreCase(AsciiString.trim(paramCharSequence1.subSequence(k, paramCharSequence1.length())), paramCharSequence2))) {
          return true;
        }
      }
    }
    else
    {
      i = AsciiString.indexOf(paramCharSequence1, ',', 0);
      if (i == -1)
      {
        if (AsciiString.contentEquals(AsciiString.trim(paramCharSequence1), paramCharSequence2)) {
          return true;
        }
      }
      else
      {
        j = 0;
        do
        {
          if (AsciiString.contentEquals(AsciiString.trim(paramCharSequence1.subSequence(j, i)), paramCharSequence2)) {
            return true;
          }
          k = i + 1;
          m = AsciiString.indexOf(paramCharSequence1, ',', k);
          j = k;
          i = m;
        } while (m != -1);
        if ((k < paramCharSequence1.length()) && (AsciiString.contentEquals(AsciiString.trim(paramCharSequence1.subSequence(k, paramCharSequence1.length())), paramCharSequence2))) {
          return true;
        }
      }
    }
    return false;
  }
  
  @Deprecated
  public static void encodeAscii(CharSequence paramCharSequence, ByteBuf paramByteBuf)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      ByteBufUtil.copy((AsciiString)paramCharSequence, 0, paramByteBuf, paramCharSequence.length());
    } else {
      paramByteBuf.writeCharSequence(paramCharSequence, CharsetUtil.US_ASCII);
    }
  }
  
  @Deprecated
  public static boolean equalsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return AsciiString.contentEqualsIgnoreCase(paramCharSequence1, paramCharSequence2);
  }
  
  @Deprecated
  public static long getContentLength(HttpMessage paramHttpMessage)
  {
    return HttpUtil.getContentLength(paramHttpMessage);
  }
  
  @Deprecated
  public static long getContentLength(HttpMessage paramHttpMessage, long paramLong)
  {
    return HttpUtil.getContentLength(paramHttpMessage, paramLong);
  }
  
  @Deprecated
  public static Date getDate(HttpMessage paramHttpMessage)
    throws ParseException
  {
    return getDateHeader(paramHttpMessage, HttpHeaderNames.DATE);
  }
  
  @Deprecated
  public static Date getDate(HttpMessage paramHttpMessage, Date paramDate)
  {
    return getDateHeader(paramHttpMessage, HttpHeaderNames.DATE, paramDate);
  }
  
  @Deprecated
  public static Date getDateHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence)
    throws ParseException
  {
    paramHttpMessage = paramHttpMessage.headers().get(paramCharSequence);
    if (paramHttpMessage != null)
    {
      paramCharSequence = DateFormatter.parseHttpDate(paramHttpMessage);
      if (paramCharSequence != null) {
        return paramCharSequence;
      }
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("header can't be parsed into a Date: ");
      paramCharSequence.append(paramHttpMessage);
      throw new ParseException(paramCharSequence.toString(), 0);
    }
    paramHttpMessage = new StringBuilder();
    paramHttpMessage.append("header not found: ");
    paramHttpMessage.append(paramCharSequence);
    throw new ParseException(paramHttpMessage.toString(), 0);
  }
  
  @Deprecated
  public static Date getDateHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Date paramDate)
  {
    paramHttpMessage = DateFormatter.parseHttpDate(getHeader(paramHttpMessage, paramCharSequence));
    if (paramHttpMessage != null) {
      paramDate = paramHttpMessage;
    }
    return paramDate;
  }
  
  @Deprecated
  public static Date getDateHeader(HttpMessage paramHttpMessage, String paramString)
    throws ParseException
  {
    return getDateHeader(paramHttpMessage, paramString);
  }
  
  @Deprecated
  public static Date getDateHeader(HttpMessage paramHttpMessage, String paramString, Date paramDate)
  {
    return getDateHeader(paramHttpMessage, paramString, paramDate);
  }
  
  @Deprecated
  public static String getHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence)
  {
    return paramHttpMessage.headers().get(paramCharSequence);
  }
  
  @Deprecated
  public static String getHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, String paramString)
  {
    return paramHttpMessage.headers().get(paramCharSequence, paramString);
  }
  
  @Deprecated
  public static String getHeader(HttpMessage paramHttpMessage, String paramString)
  {
    return paramHttpMessage.headers().get(paramString);
  }
  
  @Deprecated
  public static String getHeader(HttpMessage paramHttpMessage, String paramString1, String paramString2)
  {
    return paramHttpMessage.headers().get(paramString1, paramString2);
  }
  
  @Deprecated
  public static String getHost(HttpMessage paramHttpMessage)
  {
    return paramHttpMessage.headers().get(HttpHeaderNames.HOST);
  }
  
  @Deprecated
  public static String getHost(HttpMessage paramHttpMessage, String paramString)
  {
    return paramHttpMessage.headers().get(HttpHeaderNames.HOST, paramString);
  }
  
  @Deprecated
  public static int getIntHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence)
  {
    paramHttpMessage = paramHttpMessage.headers().get(paramCharSequence);
    if (paramHttpMessage != null) {
      return Integer.parseInt(paramHttpMessage);
    }
    paramHttpMessage = new StringBuilder();
    paramHttpMessage.append("header not found: ");
    paramHttpMessage.append(paramCharSequence);
    throw new NumberFormatException(paramHttpMessage.toString());
  }
  
  @Deprecated
  public static int getIntHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, int paramInt)
  {
    return paramHttpMessage.headers().getInt(paramCharSequence, paramInt);
  }
  
  @Deprecated
  public static int getIntHeader(HttpMessage paramHttpMessage, String paramString)
  {
    return getIntHeader(paramHttpMessage, paramString);
  }
  
  @Deprecated
  public static int getIntHeader(HttpMessage paramHttpMessage, String paramString, int paramInt)
  {
    return paramHttpMessage.headers().getInt(paramString, paramInt);
  }
  
  @Deprecated
  public static boolean is100ContinueExpected(HttpMessage paramHttpMessage)
  {
    return HttpUtil.is100ContinueExpected(paramHttpMessage);
  }
  
  @Deprecated
  public static boolean isContentLengthSet(HttpMessage paramHttpMessage)
  {
    return HttpUtil.isContentLengthSet(paramHttpMessage);
  }
  
  @Deprecated
  public static boolean isKeepAlive(HttpMessage paramHttpMessage)
  {
    return HttpUtil.isKeepAlive(paramHttpMessage);
  }
  
  @Deprecated
  public static boolean isTransferEncodingChunked(HttpMessage paramHttpMessage)
  {
    return HttpUtil.isTransferEncodingChunked(paramHttpMessage);
  }
  
  @Deprecated
  public static CharSequence newEntity(String paramString)
  {
    return new AsciiString(paramString);
  }
  
  @Deprecated
  public static void removeHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence)
  {
    paramHttpMessage.headers().remove(paramCharSequence);
  }
  
  @Deprecated
  public static void removeHeader(HttpMessage paramHttpMessage, String paramString)
  {
    paramHttpMessage.headers().remove(paramString);
  }
  
  @Deprecated
  public static void removeTransferEncodingChunked(HttpMessage paramHttpMessage)
  {
    HttpUtil.setTransferEncodingChunked(paramHttpMessage, false);
  }
  
  @Deprecated
  public static void set100ContinueExpected(HttpMessage paramHttpMessage)
  {
    HttpUtil.set100ContinueExpected(paramHttpMessage, true);
  }
  
  @Deprecated
  public static void set100ContinueExpected(HttpMessage paramHttpMessage, boolean paramBoolean)
  {
    HttpUtil.set100ContinueExpected(paramHttpMessage, paramBoolean);
  }
  
  @Deprecated
  public static void setContentLength(HttpMessage paramHttpMessage, long paramLong)
  {
    HttpUtil.setContentLength(paramHttpMessage, paramLong);
  }
  
  @Deprecated
  public static void setDate(HttpMessage paramHttpMessage, Date paramDate)
  {
    paramHttpMessage.headers().set(HttpHeaderNames.DATE, paramDate);
  }
  
  @Deprecated
  public static void setDateHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Iterable<Date> paramIterable)
  {
    paramHttpMessage.headers().set(paramCharSequence, paramIterable);
  }
  
  @Deprecated
  public static void setDateHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Date paramDate)
  {
    if (paramDate != null) {
      paramHttpMessage.headers().set(paramCharSequence, DateFormatter.format(paramDate));
    } else {
      paramHttpMessage.headers().set(paramCharSequence, null);
    }
  }
  
  @Deprecated
  public static void setDateHeader(HttpMessage paramHttpMessage, String paramString, Iterable<Date> paramIterable)
  {
    paramHttpMessage.headers().set(paramString, paramIterable);
  }
  
  @Deprecated
  public static void setDateHeader(HttpMessage paramHttpMessage, String paramString, Date paramDate)
  {
    setDateHeader(paramHttpMessage, paramString, paramDate);
  }
  
  @Deprecated
  public static void setHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Iterable<?> paramIterable)
  {
    paramHttpMessage.headers().set(paramCharSequence, paramIterable);
  }
  
  @Deprecated
  public static void setHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Object paramObject)
  {
    paramHttpMessage.headers().set(paramCharSequence, paramObject);
  }
  
  @Deprecated
  public static void setHeader(HttpMessage paramHttpMessage, String paramString, Iterable<?> paramIterable)
  {
    paramHttpMessage.headers().set(paramString, paramIterable);
  }
  
  @Deprecated
  public static void setHeader(HttpMessage paramHttpMessage, String paramString, Object paramObject)
  {
    paramHttpMessage.headers().set(paramString, paramObject);
  }
  
  @Deprecated
  public static void setHost(HttpMessage paramHttpMessage, CharSequence paramCharSequence)
  {
    paramHttpMessage.headers().set(HttpHeaderNames.HOST, paramCharSequence);
  }
  
  @Deprecated
  public static void setHost(HttpMessage paramHttpMessage, String paramString)
  {
    paramHttpMessage.headers().set(HttpHeaderNames.HOST, paramString);
  }
  
  @Deprecated
  public static void setIntHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, int paramInt)
  {
    paramHttpMessage.headers().setInt(paramCharSequence, paramInt);
  }
  
  @Deprecated
  public static void setIntHeader(HttpMessage paramHttpMessage, CharSequence paramCharSequence, Iterable<Integer> paramIterable)
  {
    paramHttpMessage.headers().set(paramCharSequence, paramIterable);
  }
  
  @Deprecated
  public static void setIntHeader(HttpMessage paramHttpMessage, String paramString, int paramInt)
  {
    paramHttpMessage.headers().setInt(paramString, paramInt);
  }
  
  @Deprecated
  public static void setIntHeader(HttpMessage paramHttpMessage, String paramString, Iterable<Integer> paramIterable)
  {
    paramHttpMessage.headers().set(paramString, paramIterable);
  }
  
  @Deprecated
  public static void setKeepAlive(HttpMessage paramHttpMessage, boolean paramBoolean)
  {
    HttpUtil.setKeepAlive(paramHttpMessage, paramBoolean);
  }
  
  @Deprecated
  public static void setTransferEncodingChunked(HttpMessage paramHttpMessage)
  {
    HttpUtil.setTransferEncodingChunked(paramHttpMessage, true);
  }
  
  public HttpHeaders add(HttpHeaders paramHttpHeaders)
  {
    ObjectUtil.checkNotNull(paramHttpHeaders, "headers");
    paramHttpHeaders = paramHttpHeaders.iterator();
    while (paramHttpHeaders.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHttpHeaders.next();
      add((String)localEntry.getKey(), localEntry.getValue());
    }
    return this;
  }
  
  public HttpHeaders add(CharSequence paramCharSequence, Iterable<?> paramIterable)
  {
    return add(paramCharSequence.toString(), paramIterable);
  }
  
  public HttpHeaders add(CharSequence paramCharSequence, Object paramObject)
  {
    return add(paramCharSequence.toString(), paramObject);
  }
  
  public abstract HttpHeaders add(String paramString, Iterable<?> paramIterable);
  
  public abstract HttpHeaders add(String paramString, Object paramObject);
  
  public abstract HttpHeaders addInt(CharSequence paramCharSequence, int paramInt);
  
  public abstract HttpHeaders addShort(CharSequence paramCharSequence, short paramShort);
  
  public abstract HttpHeaders clear();
  
  public boolean contains(CharSequence paramCharSequence)
  {
    return contains(paramCharSequence.toString());
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    return contains(paramCharSequence1.toString(), paramCharSequence2.toString(), paramBoolean);
  }
  
  public abstract boolean contains(String paramString);
  
  public boolean contains(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = valueStringIterator(paramString1);
    if (paramBoolean)
    {
      do
      {
        if (!paramString1.hasNext()) {
          break;
        }
      } while (!((String)paramString1.next()).equalsIgnoreCase(paramString2));
      return true;
    }
    while (paramString1.hasNext()) {
      if (((String)paramString1.next()).equals(paramString2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    paramCharSequence1 = valueCharSequenceIterator(paramCharSequence1);
    while (paramCharSequence1.hasNext()) {
      if (containsCommaSeparatedTrimmed((CharSequence)paramCharSequence1.next(), paramCharSequence2, paramBoolean)) {
        return true;
      }
    }
    return false;
  }
  
  public HttpHeaders copy()
  {
    return new DefaultHttpHeaders().set(this);
  }
  
  public abstract List<Map.Entry<String, String>> entries();
  
  public String get(CharSequence paramCharSequence)
  {
    return get(paramCharSequence.toString());
  }
  
  public String get(CharSequence paramCharSequence, String paramString)
  {
    paramCharSequence = get(paramCharSequence);
    if (paramCharSequence == null) {
      return paramString;
    }
    return paramCharSequence;
  }
  
  public abstract String get(String paramString);
  
  public List<String> getAll(CharSequence paramCharSequence)
  {
    return getAll(paramCharSequence.toString());
  }
  
  public abstract List<String> getAll(String paramString);
  
  public final List<String> getAllAsString(CharSequence paramCharSequence)
  {
    return getAll(paramCharSequence);
  }
  
  public final String getAsString(CharSequence paramCharSequence)
  {
    return get(paramCharSequence);
  }
  
  public abstract int getInt(CharSequence paramCharSequence, int paramInt);
  
  public abstract Integer getInt(CharSequence paramCharSequence);
  
  public abstract Short getShort(CharSequence paramCharSequence);
  
  public abstract short getShort(CharSequence paramCharSequence, short paramShort);
  
  public abstract long getTimeMillis(CharSequence paramCharSequence, long paramLong);
  
  public abstract Long getTimeMillis(CharSequence paramCharSequence);
  
  public abstract boolean isEmpty();
  
  @Deprecated
  public abstract Iterator<Map.Entry<String, String>> iterator();
  
  public final Iterator<Map.Entry<String, String>> iteratorAsString()
  {
    return iterator();
  }
  
  public abstract Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence();
  
  public abstract Set<String> names();
  
  public HttpHeaders remove(CharSequence paramCharSequence)
  {
    return remove(paramCharSequence.toString());
  }
  
  public abstract HttpHeaders remove(String paramString);
  
  public HttpHeaders set(HttpHeaders paramHttpHeaders)
  {
    ObjectUtil.checkNotNull(paramHttpHeaders, "headers");
    clear();
    if (paramHttpHeaders.isEmpty()) {
      return this;
    }
    Iterator localIterator = paramHttpHeaders.iterator();
    while (localIterator.hasNext())
    {
      paramHttpHeaders = (Map.Entry)localIterator.next();
      add((String)paramHttpHeaders.getKey(), paramHttpHeaders.getValue());
    }
    return this;
  }
  
  public HttpHeaders set(CharSequence paramCharSequence, Iterable<?> paramIterable)
  {
    return set(paramCharSequence.toString(), paramIterable);
  }
  
  public HttpHeaders set(CharSequence paramCharSequence, Object paramObject)
  {
    return set(paramCharSequence.toString(), paramObject);
  }
  
  public abstract HttpHeaders set(String paramString, Iterable<?> paramIterable);
  
  public abstract HttpHeaders set(String paramString, Object paramObject);
  
  public HttpHeaders setAll(HttpHeaders paramHttpHeaders)
  {
    ObjectUtil.checkNotNull(paramHttpHeaders, "headers");
    if (paramHttpHeaders.isEmpty()) {
      return this;
    }
    Iterator localIterator = paramHttpHeaders.iterator();
    while (localIterator.hasNext())
    {
      paramHttpHeaders = (Map.Entry)localIterator.next();
      set((String)paramHttpHeaders.getKey(), paramHttpHeaders.getValue());
    }
    return this;
  }
  
  public abstract HttpHeaders setInt(CharSequence paramCharSequence, int paramInt);
  
  public abstract HttpHeaders setShort(CharSequence paramCharSequence, short paramShort);
  
  public abstract int size();
  
  public String toString()
  {
    return HeadersUtils.toString(getClass(), iteratorCharSequence(), size());
  }
  
  public Iterator<? extends CharSequence> valueCharSequenceIterator(CharSequence paramCharSequence)
  {
    return valueStringIterator(paramCharSequence);
  }
  
  public Iterator<String> valueStringIterator(CharSequence paramCharSequence)
  {
    return getAll(paramCharSequence).iterator();
  }
  
  @Deprecated
  public static final class Names
  {
    public static final String ACCEPT = "Accept";
    public static final String ACCEPT_CHARSET = "Accept-Charset";
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    public static final String ACCEPT_PATCH = "Accept-Patch";
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
    public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
    public static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
    public static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
    public static final String AGE = "Age";
    public static final String ALLOW = "Allow";
    public static final String AUTHORIZATION = "Authorization";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_BASE = "Content-Base";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LANGUAGE = "Content-Language";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_LOCATION = "Content-Location";
    public static final String CONTENT_MD5 = "Content-MD5";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String COOKIE = "Cookie";
    public static final String DATE = "Date";
    public static final String ETAG = "ETag";
    public static final String EXPECT = "Expect";
    public static final String EXPIRES = "Expires";
    public static final String FROM = "From";
    public static final String HOST = "Host";
    public static final String IF_MATCH = "If-Match";
    public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String IF_RANGE = "If-Range";
    public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
    public static final String LAST_MODIFIED = "Last-Modified";
    public static final String LOCATION = "Location";
    public static final String MAX_FORWARDS = "Max-Forwards";
    public static final String ORIGIN = "Origin";
    public static final String PRAGMA = "Pragma";
    public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
    public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
    public static final String RANGE = "Range";
    public static final String REFERER = "Referer";
    public static final String RETRY_AFTER = "Retry-After";
    public static final String SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
    public static final String SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
    public static final String SEC_WEBSOCKET_KEY1 = "Sec-WebSocket-Key1";
    public static final String SEC_WEBSOCKET_KEY2 = "Sec-WebSocket-Key2";
    public static final String SEC_WEBSOCKET_LOCATION = "Sec-WebSocket-Location";
    public static final String SEC_WEBSOCKET_ORIGIN = "Sec-WebSocket-Origin";
    public static final String SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    public static final String SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
    public static final String SERVER = "Server";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String SET_COOKIE2 = "Set-Cookie2";
    public static final String TE = "TE";
    public static final String TRAILER = "Trailer";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String UPGRADE = "Upgrade";
    public static final String USER_AGENT = "User-Agent";
    public static final String VARY = "Vary";
    public static final String VIA = "Via";
    public static final String WARNING = "Warning";
    public static final String WEBSOCKET_LOCATION = "WebSocket-Location";
    public static final String WEBSOCKET_ORIGIN = "WebSocket-Origin";
    public static final String WEBSOCKET_PROTOCOL = "WebSocket-Protocol";
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
  }
  
  @Deprecated
  public static final class Values
  {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String BASE64 = "base64";
    public static final String BINARY = "binary";
    public static final String BOUNDARY = "boundary";
    public static final String BYTES = "bytes";
    public static final String CHARSET = "charset";
    public static final String CHUNKED = "chunked";
    public static final String CLOSE = "close";
    public static final String COMPRESS = "compress";
    public static final String CONTINUE = "100-continue";
    public static final String DEFLATE = "deflate";
    public static final String GZIP = "gzip";
    public static final String GZIP_DEFLATE = "gzip,deflate";
    public static final String IDENTITY = "identity";
    public static final String KEEP_ALIVE = "keep-alive";
    public static final String MAX_AGE = "max-age";
    public static final String MAX_STALE = "max-stale";
    public static final String MIN_FRESH = "min-fresh";
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    public static final String MUST_REVALIDATE = "must-revalidate";
    public static final String NONE = "none";
    public static final String NO_CACHE = "no-cache";
    public static final String NO_STORE = "no-store";
    public static final String NO_TRANSFORM = "no-transform";
    public static final String ONLY_IF_CACHED = "only-if-cached";
    public static final String PRIVATE = "private";
    public static final String PROXY_REVALIDATE = "proxy-revalidate";
    public static final String PUBLIC = "public";
    public static final String QUOTED_PRINTABLE = "quoted-printable";
    public static final String S_MAXAGE = "s-maxage";
    public static final String TRAILERS = "trailers";
    public static final String UPGRADE = "Upgrade";
    public static final String WEBSOCKET = "WebSocket";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */