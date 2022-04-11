package io.netty.handler.codec.http2;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class HttpConversionUtil
{
  private static final AsciiString EMPTY_REQUEST_PATH = AsciiString.cached("/");
  private static final CharSequenceMap<AsciiString> HTTP_TO_HTTP2_HEADER_BLACKLIST;
  public static final HttpMethod OUT_OF_MESSAGE_SEQUENCE_METHOD;
  public static final String OUT_OF_MESSAGE_SEQUENCE_PATH = "";
  public static final HttpResponseStatus OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE;
  
  static
  {
    CharSequenceMap localCharSequenceMap = new CharSequenceMap();
    HTTP_TO_HTTP2_HEADER_BLACKLIST = localCharSequenceMap;
    AsciiString localAsciiString1 = HttpHeaderNames.CONNECTION;
    AsciiString localAsciiString2 = AsciiString.EMPTY_STRING;
    localCharSequenceMap.add(localAsciiString1, localAsciiString2);
    localCharSequenceMap.add(HttpHeaderNames.KEEP_ALIVE, localAsciiString2);
    localCharSequenceMap.add(HttpHeaderNames.PROXY_CONNECTION, localAsciiString2);
    localCharSequenceMap.add(HttpHeaderNames.TRANSFER_ENCODING, localAsciiString2);
    localCharSequenceMap.add(HttpHeaderNames.HOST, localAsciiString2);
    localCharSequenceMap.add(HttpHeaderNames.UPGRADE, localAsciiString2);
    localCharSequenceMap.add(ExtensionHeaderNames.STREAM_ID.text(), localAsciiString2);
    localCharSequenceMap.add(ExtensionHeaderNames.SCHEME.text(), localAsciiString2);
    localCharSequenceMap.add(ExtensionHeaderNames.PATH.text(), localAsciiString2);
    OUT_OF_MESSAGE_SEQUENCE_METHOD = HttpMethod.OPTIONS;
    OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE = HttpResponseStatus.OK;
  }
  
  public static void addHttp2ToHttpHeaders(int paramInt, Http2Headers paramHttp2Headers, FullHttpMessage paramFullHttpMessage, boolean paramBoolean)
    throws Http2Exception
  {
    HttpHeaders localHttpHeaders;
    if (paramBoolean) {
      localHttpHeaders = paramFullHttpMessage.trailingHeaders();
    } else {
      localHttpHeaders = paramFullHttpMessage.headers();
    }
    addHttp2ToHttpHeaders(paramInt, paramHttp2Headers, localHttpHeaders, paramFullHttpMessage.protocolVersion(), paramBoolean, paramFullHttpMessage instanceof HttpRequest);
  }
  
  /* Error */
  public static void addHttp2ToHttpHeaders(int paramInt, Http2Headers paramHttp2Headers, HttpHeaders paramHttpHeaders, io.netty.handler.codec.http.HttpVersion paramHttpVersion, boolean paramBoolean1, boolean paramBoolean2)
    throws Http2Exception
  {
    // Byte code:
    //   0: new 9	io/netty/handler/codec/http2/HttpConversionUtil$Http2ToHttpHeaderTranslator
    //   3: dup
    //   4: iload_0
    //   5: aload_2
    //   6: iload 5
    //   8: invokespecial 129	io/netty/handler/codec/http2/HttpConversionUtil$Http2ToHttpHeaderTranslator:<init>	(ILio/netty/handler/codec/http/HttpHeaders;Z)V
    //   11: astore 6
    //   13: aload 6
    //   15: aload_1
    //   16: invokevirtual 133	io/netty/handler/codec/http2/HttpConversionUtil$Http2ToHttpHeaderTranslator:translateHeaders	(Ljava/lang/Iterable;)V
    //   19: aload_2
    //   20: getstatic 57	io/netty/handler/codec/http/HttpHeaderNames:TRANSFER_ENCODING	Lio/netty/util/AsciiString;
    //   23: invokevirtual 139	io/netty/handler/codec/http/HttpHeaders:remove	(Ljava/lang/CharSequence;)Lio/netty/handler/codec/http/HttpHeaders;
    //   26: pop
    //   27: aload_2
    //   28: getstatic 142	io/netty/handler/codec/http/HttpHeaderNames:TRAILER	Lio/netty/util/AsciiString;
    //   31: invokevirtual 139	io/netty/handler/codec/http/HttpHeaders:remove	(Ljava/lang/CharSequence;)Lio/netty/handler/codec/http/HttpHeaders;
    //   34: pop
    //   35: iload 4
    //   37: ifne +21 -> 58
    //   40: aload_2
    //   41: getstatic 67	io/netty/handler/codec/http2/HttpConversionUtil$ExtensionHeaderNames:STREAM_ID	Lio/netty/handler/codec/http2/HttpConversionUtil$ExtensionHeaderNames;
    //   44: invokevirtual 71	io/netty/handler/codec/http2/HttpConversionUtil$ExtensionHeaderNames:text	()Lio/netty/util/AsciiString;
    //   47: iload_0
    //   48: invokevirtual 146	io/netty/handler/codec/http/HttpHeaders:setInt	(Ljava/lang/CharSequence;I)Lio/netty/handler/codec/http/HttpHeaders;
    //   51: pop
    //   52: aload_2
    //   53: aload_3
    //   54: iconst_1
    //   55: invokestatic 152	io/netty/handler/codec/http/HttpUtil:setKeepAlive	(Lio/netty/handler/codec/http/HttpHeaders;Lio/netty/handler/codec/http/HttpVersion;Z)V
    //   58: return
    //   59: astore_1
    //   60: iload_0
    //   61: getstatic 158	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   64: aload_1
    //   65: ldc -96
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 164	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   74: athrow
    //   75: astore_1
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramInt	int
    //   0	78	1	paramHttp2Headers	Http2Headers
    //   0	78	2	paramHttpHeaders	HttpHeaders
    //   0	78	3	paramHttpVersion	io.netty.handler.codec.http.HttpVersion
    //   0	78	4	paramBoolean1	boolean
    //   0	78	5	paramBoolean2	boolean
    //   11	3	6	localHttp2ToHttpHeaderTranslator	Http2ToHttpHeaderTranslator
    // Exception table:
    //   from	to	target	type
    //   13	19	59	finally
    //   13	19	75	io/netty/handler/codec/http2/Http2Exception
  }
  
  /* Error */
  public static HttpResponseStatus parseStatus(CharSequence paramCharSequence)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 169	io/netty/handler/codec/http/HttpResponseStatus:parseLine	(Ljava/lang/CharSequence;)Lio/netty/handler/codec/http/HttpResponseStatus;
    //   4: astore_1
    //   5: aload_1
    //   6: getstatic 172	io/netty/handler/codec/http/HttpResponseStatus:SWITCHING_PROTOCOLS	Lio/netty/handler/codec/http/HttpResponseStatus;
    //   9: if_acmpeq +5 -> 14
    //   12: aload_1
    //   13: areturn
    //   14: getstatic 158	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   17: ldc -82
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: invokevirtual 178	io/netty/handler/codec/http/HttpResponseStatus:code	()I
    //   29: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 188	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   36: athrow
    //   37: astore_1
    //   38: getstatic 158	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   41: aload_1
    //   42: ldc -66
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: aastore
    //   52: invokestatic 193	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   55: athrow
    //   56: astore_0
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramCharSequence	CharSequence
    //   4	22	1	localHttpResponseStatus	HttpResponseStatus
    //   37	5	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	12	37	finally
    //   14	37	37	finally
    //   0	12	56	io/netty/handler/codec/http2/Http2Exception
    //   14	37	56	io/netty/handler/codec/http2/Http2Exception
  }
  
  static void setHttp2Authority(String paramString, Http2Headers paramHttp2Headers)
  {
    if (paramString != null) {
      if (paramString.isEmpty())
      {
        paramHttp2Headers.authority(AsciiString.EMPTY_STRING);
      }
      else
      {
        int i = paramString.indexOf('@') + 1;
        int j = paramString.length() - i;
        if (j != 0)
        {
          paramHttp2Headers.authority(new AsciiString(paramString, i, j));
        }
        else
        {
          paramHttp2Headers = new StringBuilder();
          paramHttp2Headers.append("authority: ");
          paramHttp2Headers.append(paramString);
          throw new IllegalArgumentException(paramHttp2Headers.toString());
        }
      }
    }
  }
  
  private static void setHttp2Scheme(HttpHeaders paramHttpHeaders, URI paramURI, Http2Headers paramHttp2Headers)
  {
    String str = paramURI.getScheme();
    if (str != null)
    {
      paramHttp2Headers.scheme(new AsciiString(str));
      return;
    }
    paramHttpHeaders = paramHttpHeaders.get(ExtensionHeaderNames.SCHEME.text());
    if (paramHttpHeaders != null)
    {
      paramHttp2Headers.scheme(AsciiString.of(paramHttpHeaders));
      return;
    }
    int i = paramURI.getPort();
    paramHttpHeaders = HttpScheme.HTTPS;
    if (i == paramHttpHeaders.port())
    {
      paramHttp2Headers.scheme(paramHttpHeaders.name());
    }
    else
    {
      i = paramURI.getPort();
      paramHttpHeaders = HttpScheme.HTTP;
      if (i != paramHttpHeaders.port()) {
        break label116;
      }
      paramHttp2Headers.scheme(paramHttpHeaders.name());
    }
    return;
    label116:
    throw new IllegalArgumentException(":scheme must be specified. see https://tools.ietf.org/html/rfc7540#section-8.1.2.3");
  }
  
  /* Error */
  public static io.netty.handler.codec.http.FullHttpRequest toFullHttpRequest(int paramInt, Http2Headers paramHttp2Headers, io.netty.buffer.ByteBufAllocator paramByteBufAllocator, boolean paramBoolean)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 282 1 0
    //   6: ldc_w 284
    //   9: invokestatic 290	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 292	java/lang/CharSequence
    //   15: astore 4
    //   17: aload_1
    //   18: invokeinterface 295 1 0
    //   23: ldc_w 297
    //   26: invokestatic 290	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 292	java/lang/CharSequence
    //   32: astore 5
    //   34: new 299	io/netty/handler/codec/http/DefaultFullHttpRequest
    //   37: dup
    //   38: getstatic 305	io/netty/handler/codec/http/HttpVersion:HTTP_1_1	Lio/netty/handler/codec/http/HttpVersion;
    //   41: aload 4
    //   43: invokeinterface 306 1 0
    //   48: invokestatic 309	io/netty/handler/codec/http/HttpMethod:valueOf	(Ljava/lang/String;)Lio/netty/handler/codec/http/HttpMethod;
    //   51: aload 5
    //   53: invokeinterface 306 1 0
    //   58: aload_2
    //   59: invokeinterface 315 1 0
    //   64: iload_3
    //   65: invokespecial 318	io/netty/handler/codec/http/DefaultFullHttpRequest:<init>	(Lio/netty/handler/codec/http/HttpVersion;Lio/netty/handler/codec/http/HttpMethod;Ljava/lang/String;Lio/netty/buffer/ByteBuf;Z)V
    //   68: astore_2
    //   69: iload_0
    //   70: aload_1
    //   71: aload_2
    //   72: iconst_0
    //   73: invokestatic 320	io/netty/handler/codec/http2/HttpConversionUtil:addHttp2ToHttpHeaders	(ILio/netty/handler/codec/http2/Http2Headers;Lio/netty/handler/codec/http/FullHttpMessage;Z)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_1
    //   79: aload_2
    //   80: invokeinterface 325 1 0
    //   85: pop
    //   86: iload_0
    //   87: getstatic 158	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   90: aload_1
    //   91: ldc -96
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 164	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   100: athrow
    //   101: astore_1
    //   102: aload_2
    //   103: invokeinterface 325 1 0
    //   108: pop
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramInt	int
    //   0	111	1	paramHttp2Headers	Http2Headers
    //   0	111	2	paramByteBufAllocator	io.netty.buffer.ByteBufAllocator
    //   0	111	3	paramBoolean	boolean
    //   15	27	4	localCharSequence1	CharSequence
    //   32	20	5	localCharSequence2	CharSequence
    // Exception table:
    //   from	to	target	type
    //   69	76	78	finally
    //   69	76	101	io/netty/handler/codec/http2/Http2Exception
  }
  
  /* Error */
  public static io.netty.handler.codec.http.FullHttpResponse toFullHttpResponse(int paramInt, Http2Headers paramHttp2Headers, io.netty.buffer.ByteBufAllocator paramByteBufAllocator, boolean paramBoolean)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 330 1 0
    //   6: invokestatic 332	io/netty/handler/codec/http2/HttpConversionUtil:parseStatus	(Ljava/lang/CharSequence;)Lio/netty/handler/codec/http/HttpResponseStatus;
    //   9: astore 4
    //   11: new 334	io/netty/handler/codec/http/DefaultFullHttpResponse
    //   14: dup
    //   15: getstatic 305	io/netty/handler/codec/http/HttpVersion:HTTP_1_1	Lio/netty/handler/codec/http/HttpVersion;
    //   18: aload 4
    //   20: aload_2
    //   21: invokeinterface 315 1 0
    //   26: iload_3
    //   27: invokespecial 337	io/netty/handler/codec/http/DefaultFullHttpResponse:<init>	(Lio/netty/handler/codec/http/HttpVersion;Lio/netty/handler/codec/http/HttpResponseStatus;Lio/netty/buffer/ByteBuf;Z)V
    //   30: astore_2
    //   31: iload_0
    //   32: aload_1
    //   33: aload_2
    //   34: iconst_0
    //   35: invokestatic 320	io/netty/handler/codec/http2/HttpConversionUtil:addHttp2ToHttpHeaders	(ILio/netty/handler/codec/http2/Http2Headers;Lio/netty/handler/codec/http/FullHttpMessage;Z)V
    //   38: aload_2
    //   39: areturn
    //   40: astore_1
    //   41: aload_2
    //   42: invokeinterface 325 1 0
    //   47: pop
    //   48: iload_0
    //   49: getstatic 158	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   52: aload_1
    //   53: ldc -96
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 164	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   62: athrow
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 325 1 0
    //   70: pop
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramInt	int
    //   0	73	1	paramHttp2Headers	Http2Headers
    //   0	73	2	paramByteBufAllocator	io.netty.buffer.ByteBufAllocator
    //   0	73	3	paramBoolean	boolean
    //   9	10	4	localHttpResponseStatus	HttpResponseStatus
    // Exception table:
    //   from	to	target	type
    //   31	38	40	finally
    //   31	38	63	io/netty/handler/codec/http2/Http2Exception
  }
  
  public static Http2Headers toHttp2Headers(HttpHeaders paramHttpHeaders, boolean paramBoolean)
  {
    if (paramHttpHeaders.isEmpty()) {
      return EmptyHttp2Headers.INSTANCE;
    }
    DefaultHttp2Headers localDefaultHttp2Headers = new DefaultHttp2Headers(paramBoolean, paramHttpHeaders.size());
    toHttp2Headers(paramHttpHeaders, localDefaultHttp2Headers);
    return localDefaultHttp2Headers;
  }
  
  public static Http2Headers toHttp2Headers(HttpMessage paramHttpMessage, boolean paramBoolean)
  {
    HttpHeaders localHttpHeaders = paramHttpMessage.headers();
    DefaultHttp2Headers localDefaultHttp2Headers = new DefaultHttp2Headers(paramBoolean, localHttpHeaders.size());
    if ((paramHttpMessage instanceof HttpRequest))
    {
      paramHttpMessage = (HttpRequest)paramHttpMessage;
      URI localURI = URI.create(paramHttpMessage.uri());
      localDefaultHttp2Headers.path(toHttp2Path(localURI));
      localDefaultHttp2Headers.method(paramHttpMessage.method().asciiName());
      setHttp2Scheme(localHttpHeaders, localURI, localDefaultHttp2Headers);
      if ((!HttpUtil.isOriginForm(localURI)) && (!HttpUtil.isAsteriskForm(localURI)))
      {
        String str = localHttpHeaders.getAsString(HttpHeaderNames.HOST);
        if (str != null)
        {
          paramHttpMessage = str;
          if (!str.isEmpty()) {}
        }
        else
        {
          paramHttpMessage = localURI.getAuthority();
        }
        setHttp2Authority(paramHttpMessage, localDefaultHttp2Headers);
      }
    }
    else if ((paramHttpMessage instanceof HttpResponse))
    {
      localDefaultHttp2Headers.status(((HttpResponse)paramHttpMessage).status().codeAsText());
    }
    toHttp2Headers(localHttpHeaders, localDefaultHttp2Headers);
    return localDefaultHttp2Headers;
  }
  
  public static void toHttp2Headers(HttpHeaders paramHttpHeaders, Http2Headers paramHttp2Headers)
  {
    Object localObject = paramHttpHeaders.iteratorCharSequence();
    CharSequenceMap localCharSequenceMap = toLowercaseMap(paramHttpHeaders.valueCharSequenceIterator(HttpHeaderNames.CONNECTION), 8);
    while (((Iterator)localObject).hasNext())
    {
      paramHttpHeaders = (Map.Entry)((Iterator)localObject).next();
      AsciiString localAsciiString1 = AsciiString.of((CharSequence)paramHttpHeaders.getKey()).toLowerCase();
      if ((!HTTP_TO_HTTP2_HEADER_BLACKLIST.contains(localAsciiString1)) && (!localCharSequenceMap.contains(localAsciiString1))) {
        if (localAsciiString1.contentEqualsIgnoreCase(HttpHeaderNames.TE))
        {
          toHttp2HeadersFilterTE(paramHttpHeaders, paramHttp2Headers);
        }
        else
        {
          AsciiString localAsciiString2 = HttpHeaderNames.COOKIE;
          if (localAsciiString1.contentEqualsIgnoreCase(localAsciiString2))
          {
            paramHttpHeaders = AsciiString.of((CharSequence)paramHttpHeaders.getValue());
            try
            {
              int i = paramHttpHeaders.forEachByte(ByteProcessor.FIND_SEMI_COLON);
              if (i != -1)
              {
                int j = 0;
                int k;
                int m;
                do
                {
                  localAsciiString2 = HttpHeaderNames.COOKIE;
                  paramHttp2Headers.add(localAsciiString2, paramHttpHeaders.subSequence(j, i, false));
                  k = i + 2;
                  if (k >= paramHttpHeaders.length()) {
                    break;
                  }
                  m = paramHttpHeaders.forEachByte(k, paramHttpHeaders.length() - k, ByteProcessor.FIND_SEMI_COLON);
                  i = m;
                  j = k;
                } while (m != -1);
                if (k < paramHttpHeaders.length())
                {
                  paramHttp2Headers.add(localAsciiString2, paramHttpHeaders.subSequence(k, paramHttpHeaders.length(), false));
                  continue;
                }
                localObject = new java/lang/IllegalArgumentException;
                paramHttp2Headers = new java/lang/StringBuilder;
                paramHttp2Headers.<init>();
                paramHttp2Headers.append("cookie value is of unexpected format: ");
                paramHttp2Headers.append(paramHttpHeaders);
                ((IllegalArgumentException)localObject).<init>(paramHttp2Headers.toString());
                throw ((Throwable)localObject);
              }
              paramHttp2Headers.add(localAsciiString2, paramHttpHeaders);
            }
            catch (Exception paramHttpHeaders)
            {
              throw new IllegalStateException(paramHttpHeaders);
            }
          }
          else
          {
            paramHttp2Headers.add(localAsciiString1, paramHttpHeaders.getValue());
          }
        }
      }
    }
  }
  
  private static void toHttp2HeadersFilterTE(Map.Entry<CharSequence, CharSequence> paramEntry, Http2Headers paramHttp2Headers)
  {
    CharSequence localCharSequence;
    if (AsciiString.indexOf((CharSequence)paramEntry.getValue(), ',', 0) == -1)
    {
      localCharSequence = AsciiString.trim((CharSequence)paramEntry.getValue());
      paramEntry = HttpHeaderValues.TRAILERS;
      if (AsciiString.contentEqualsIgnoreCase(localCharSequence, paramEntry)) {
        paramHttp2Headers.add(HttpHeaderNames.TE, paramEntry);
      }
    }
    else
    {
      Iterator localIterator = StringUtil.unescapeCsvFields((CharSequence)paramEntry.getValue()).iterator();
      while (localIterator.hasNext())
      {
        localCharSequence = AsciiString.trim((CharSequence)localIterator.next());
        paramEntry = HttpHeaderValues.TRAILERS;
        if (AsciiString.contentEqualsIgnoreCase(localCharSequence, paramEntry)) {
          paramHttp2Headers.add(HttpHeaderNames.TE, paramEntry);
        }
      }
    }
  }
  
  private static AsciiString toHttp2Path(URI paramURI)
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.length(paramURI.getRawPath()) + StringUtil.length(paramURI.getRawQuery()) + StringUtil.length(paramURI.getRawFragment()) + 2);
    if (!StringUtil.isNullOrEmpty(paramURI.getRawPath())) {
      localStringBuilder.append(paramURI.getRawPath());
    }
    if (!StringUtil.isNullOrEmpty(paramURI.getRawQuery()))
    {
      localStringBuilder.append('?');
      localStringBuilder.append(paramURI.getRawQuery());
    }
    if (!StringUtil.isNullOrEmpty(paramURI.getRawFragment()))
    {
      localStringBuilder.append('#');
      localStringBuilder.append(paramURI.getRawFragment());
    }
    paramURI = localStringBuilder.toString();
    if (paramURI.isEmpty()) {
      paramURI = EMPTY_REQUEST_PATH;
    } else {
      paramURI = new AsciiString(paramURI);
    }
    return paramURI;
  }
  
  /* Error */
  public static HttpRequest toHttpRequest(int paramInt, Http2Headers paramHttp2Headers, boolean paramBoolean)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 282 1 0
    //   6: ldc_w 284
    //   9: invokestatic 290	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 292	java/lang/CharSequence
    //   15: astore_3
    //   16: aload_1
    //   17: invokeinterface 295 1 0
    //   22: ldc_w 297
    //   25: invokestatic 290	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast 292	java/lang/CharSequence
    //   31: astore 4
    //   33: new 543	io/netty/handler/codec/http/DefaultHttpRequest
    //   36: dup
    //   37: getstatic 305	io/netty/handler/codec/http/HttpVersion:HTTP_1_1	Lio/netty/handler/codec/http/HttpVersion;
    //   40: aload_3
    //   41: invokeinterface 306 1 0
    //   46: invokestatic 309	io/netty/handler/codec/http/HttpMethod:valueOf	(Ljava/lang/String;)Lio/netty/handler/codec/http/HttpMethod;
    //   49: aload 4
    //   51: invokeinterface 306 1 0
    //   56: iload_2
    //   57: invokespecial 546	io/netty/handler/codec/http/DefaultHttpRequest:<init>	(Lio/netty/handler/codec/http/HttpVersion;Lio/netty/handler/codec/http/HttpMethod;Ljava/lang/String;Z)V
    //   60: astore_3
    //   61: iload_0
    //   62: aload_1
    //   63: aload_3
    //   64: invokeinterface 116 1 0
    //   69: aload_3
    //   70: invokeinterface 120 1 0
    //   75: iconst_0
    //   76: iconst_1
    //   77: invokestatic 125	io/netty/handler/codec/http2/HttpConversionUtil:addHttp2ToHttpHeaders	(ILio/netty/handler/codec/http2/Http2Headers;Lio/netty/handler/codec/http/HttpHeaders;Lio/netty/handler/codec/http/HttpVersion;ZZ)V
    //   80: aload_3
    //   81: areturn
    //   82: astore_1
    //   83: iload_0
    //   84: getstatic 158	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   87: aload_1
    //   88: ldc -96
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 164	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   97: athrow
    //   98: astore_1
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramInt	int
    //   0	101	1	paramHttp2Headers	Http2Headers
    //   0	101	2	paramBoolean	boolean
    //   15	66	3	localObject	Object
    //   31	19	4	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   61	80	82	finally
    //   61	80	98	io/netty/handler/codec/http2/Http2Exception
  }
  
  /* Error */
  public static HttpResponse toHttpResponse(int paramInt, Http2Headers paramHttp2Headers, boolean paramBoolean)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 330 1 0
    //   6: invokestatic 332	io/netty/handler/codec/http2/HttpConversionUtil:parseStatus	(Ljava/lang/CharSequence;)Lio/netty/handler/codec/http/HttpResponseStatus;
    //   9: astore_3
    //   10: new 550	io/netty/handler/codec/http/DefaultHttpResponse
    //   13: dup
    //   14: getstatic 305	io/netty/handler/codec/http/HttpVersion:HTTP_1_1	Lio/netty/handler/codec/http/HttpVersion;
    //   17: aload_3
    //   18: iload_2
    //   19: invokespecial 553	io/netty/handler/codec/http/DefaultHttpResponse:<init>	(Lio/netty/handler/codec/http/HttpVersion;Lio/netty/handler/codec/http/HttpResponseStatus;Z)V
    //   22: astore_3
    //   23: iload_0
    //   24: aload_1
    //   25: aload_3
    //   26: invokeinterface 116 1 0
    //   31: aload_3
    //   32: invokeinterface 120 1 0
    //   37: iconst_0
    //   38: iconst_1
    //   39: invokestatic 125	io/netty/handler/codec/http2/HttpConversionUtil:addHttp2ToHttpHeaders	(ILio/netty/handler/codec/http2/Http2Headers;Lio/netty/handler/codec/http/HttpHeaders;Lio/netty/handler/codec/http/HttpVersion;ZZ)V
    //   42: aload_3
    //   43: areturn
    //   44: astore_1
    //   45: iload_0
    //   46: getstatic 158	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   49: aload_1
    //   50: ldc -96
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 164	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   59: athrow
    //   60: astore_1
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramInt	int
    //   0	63	1	paramHttp2Headers	Http2Headers
    //   0	63	2	paramBoolean	boolean
    //   9	34	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	42	44	finally
    //   23	42	60	io/netty/handler/codec/http2/Http2Exception
  }
  
  private static CharSequenceMap<AsciiString> toLowercaseMap(Iterator<? extends CharSequence> paramIterator, int paramInt)
  {
    CharSequenceMap localCharSequenceMap = new CharSequenceMap(true, UnsupportedValueConverter.instance(), paramInt);
    while (paramIterator.hasNext())
    {
      AsciiString localAsciiString1 = AsciiString.of((CharSequence)paramIterator.next()).toLowerCase();
      try
      {
        int i = localAsciiString1.forEachByte(ByteProcessor.FIND_COMMA);
        if (i != -1)
        {
          paramInt = 0;
          AsciiString localAsciiString3;
          int j;
          int k;
          do
          {
            AsciiString localAsciiString2 = localAsciiString1.subSequence(paramInt, i, false).trim();
            localAsciiString3 = AsciiString.EMPTY_STRING;
            localCharSequenceMap.add(localAsciiString2, localAsciiString3);
            j = i + 1;
            if (j >= localAsciiString1.length()) {
              break;
            }
            k = localAsciiString1.forEachByte(j, localAsciiString1.length() - j, ByteProcessor.FIND_COMMA);
            i = k;
            paramInt = j;
          } while (k != -1);
          localCharSequenceMap.add(localAsciiString1.subSequence(j, localAsciiString1.length(), false).trim(), localAsciiString3);
        }
        else
        {
          localCharSequenceMap.add(localAsciiString1.trim(), AsciiString.EMPTY_STRING);
        }
      }
      catch (Exception paramIterator)
      {
        throw new IllegalStateException(paramIterator);
      }
    }
    return localCharSequenceMap;
  }
  
  public static enum ExtensionHeaderNames
  {
    private final AsciiString text;
    
    static
    {
      ExtensionHeaderNames localExtensionHeaderNames1 = new ExtensionHeaderNames("STREAM_ID", 0, "x-http2-stream-id");
      STREAM_ID = localExtensionHeaderNames1;
      ExtensionHeaderNames localExtensionHeaderNames2 = new ExtensionHeaderNames("SCHEME", 1, "x-http2-scheme");
      SCHEME = localExtensionHeaderNames2;
      ExtensionHeaderNames localExtensionHeaderNames3 = new ExtensionHeaderNames("PATH", 2, "x-http2-path");
      PATH = localExtensionHeaderNames3;
      ExtensionHeaderNames localExtensionHeaderNames4 = new ExtensionHeaderNames("STREAM_PROMISE_ID", 3, "x-http2-stream-promise-id");
      STREAM_PROMISE_ID = localExtensionHeaderNames4;
      ExtensionHeaderNames localExtensionHeaderNames5 = new ExtensionHeaderNames("STREAM_DEPENDENCY_ID", 4, "x-http2-stream-dependency-id");
      STREAM_DEPENDENCY_ID = localExtensionHeaderNames5;
      ExtensionHeaderNames localExtensionHeaderNames6 = new ExtensionHeaderNames("STREAM_WEIGHT", 5, "x-http2-stream-weight");
      STREAM_WEIGHT = localExtensionHeaderNames6;
      $VALUES = new ExtensionHeaderNames[] { localExtensionHeaderNames1, localExtensionHeaderNames2, localExtensionHeaderNames3, localExtensionHeaderNames4, localExtensionHeaderNames5, localExtensionHeaderNames6 };
    }
    
    private ExtensionHeaderNames(String paramString)
    {
      this.text = AsciiString.cached(paramString);
    }
    
    public AsciiString text()
    {
      return this.text;
    }
  }
  
  private static final class Http2ToHttpHeaderTranslator
  {
    private static final CharSequenceMap<AsciiString> REQUEST_HEADER_TRANSLATIONS;
    private static final CharSequenceMap<AsciiString> RESPONSE_HEADER_TRANSLATIONS;
    private final HttpHeaders output;
    private final int streamId;
    private final CharSequenceMap<AsciiString> translations;
    
    static
    {
      CharSequenceMap localCharSequenceMap1 = new CharSequenceMap();
      REQUEST_HEADER_TRANSLATIONS = localCharSequenceMap1;
      CharSequenceMap localCharSequenceMap2 = new CharSequenceMap();
      RESPONSE_HEADER_TRANSLATIONS = localCharSequenceMap2;
      localCharSequenceMap2.add(Http2Headers.PseudoHeaderName.AUTHORITY.value(), HttpHeaderNames.HOST);
      localCharSequenceMap2.add(Http2Headers.PseudoHeaderName.SCHEME.value(), HttpConversionUtil.ExtensionHeaderNames.SCHEME.text());
      localCharSequenceMap1.add(localCharSequenceMap2);
      localCharSequenceMap2.add(Http2Headers.PseudoHeaderName.PATH.value(), HttpConversionUtil.ExtensionHeaderNames.PATH.text());
    }
    
    Http2ToHttpHeaderTranslator(int paramInt, HttpHeaders paramHttpHeaders, boolean paramBoolean)
    {
      this.streamId = paramInt;
      this.output = paramHttpHeaders;
      if (paramBoolean) {
        paramHttpHeaders = REQUEST_HEADER_TRANSLATIONS;
      } else {
        paramHttpHeaders = RESPONSE_HEADER_TRANSLATIONS;
      }
      this.translations = paramHttpHeaders;
    }
    
    public void translateHeaders(Iterable<Map.Entry<CharSequence, CharSequence>> paramIterable)
      throws Http2Exception
    {
      Iterator localIterator = paramIterable.iterator();
      paramIterable = null;
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (CharSequence)((Map.Entry)localObject1).getKey();
        localObject1 = (CharSequence)((Map.Entry)localObject1).getValue();
        AsciiString localAsciiString = (AsciiString)this.translations.get(localObject2);
        if (localAsciiString != null) {
          this.output.add(localAsciiString, AsciiString.of((CharSequence)localObject1));
        } else if (!Http2Headers.PseudoHeaderName.isPseudoHeader((CharSequence)localObject2)) {
          if ((((CharSequence)localObject2).length() != 0) && (((CharSequence)localObject2).charAt(0) != ':'))
          {
            if (HttpHeaderNames.COOKIE.equals(localObject2))
            {
              if (paramIterable == null)
              {
                localObject2 = InternalThreadLocalMap.get().stringBuilder();
              }
              else
              {
                localObject2 = paramIterable;
                if (paramIterable.length() > 0)
                {
                  paramIterable.append("; ");
                  localObject2 = paramIterable;
                }
              }
              ((StringBuilder)localObject2).append((CharSequence)localObject1);
              paramIterable = (Iterable<Map.Entry<CharSequence, CharSequence>>)localObject2;
            }
            else
            {
              this.output.add((CharSequence)localObject2, localObject1);
            }
          }
          else {
            throw Http2Exception.streamError(this.streamId, Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 header '%s' encountered in translation to HTTP/1.x", new Object[] { localObject2 });
          }
        }
      }
      if (paramIterable != null) {
        this.output.add(HttpHeaderNames.COOKIE, paramIterable.toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HttpConversionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */