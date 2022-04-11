package io.netty.handler.codec.http;

import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.Map.Entry;

final class HttpMessageUtil
{
  private static void appendCommon(StringBuilder paramStringBuilder, HttpMessage paramHttpMessage)
  {
    paramStringBuilder.append(StringUtil.simpleClassName(paramHttpMessage));
    paramStringBuilder.append("(decodeResult: ");
    paramStringBuilder.append(paramHttpMessage.decoderResult());
    paramStringBuilder.append(", version: ");
    paramStringBuilder.append(paramHttpMessage.protocolVersion());
    paramStringBuilder.append(')');
    paramStringBuilder.append(StringUtil.NEWLINE);
  }
  
  private static void appendFullCommon(StringBuilder paramStringBuilder, FullHttpMessage paramFullHttpMessage)
  {
    paramStringBuilder.append(StringUtil.simpleClassName(paramFullHttpMessage));
    paramStringBuilder.append("(decodeResult: ");
    paramStringBuilder.append(paramFullHttpMessage.decoderResult());
    paramStringBuilder.append(", version: ");
    paramStringBuilder.append(paramFullHttpMessage.protocolVersion());
    paramStringBuilder.append(", content: ");
    paramStringBuilder.append(paramFullHttpMessage.content());
    paramStringBuilder.append(')');
    paramStringBuilder.append(StringUtil.NEWLINE);
  }
  
  static StringBuilder appendFullRequest(StringBuilder paramStringBuilder, FullHttpRequest paramFullHttpRequest)
  {
    appendFullCommon(paramStringBuilder, paramFullHttpRequest);
    appendInitialLine(paramStringBuilder, paramFullHttpRequest);
    appendHeaders(paramStringBuilder, paramFullHttpRequest.headers());
    appendHeaders(paramStringBuilder, paramFullHttpRequest.trailingHeaders());
    removeLastNewLine(paramStringBuilder);
    return paramStringBuilder;
  }
  
  static StringBuilder appendFullResponse(StringBuilder paramStringBuilder, FullHttpResponse paramFullHttpResponse)
  {
    appendFullCommon(paramStringBuilder, paramFullHttpResponse);
    appendInitialLine(paramStringBuilder, paramFullHttpResponse);
    appendHeaders(paramStringBuilder, paramFullHttpResponse.headers());
    appendHeaders(paramStringBuilder, paramFullHttpResponse.trailingHeaders());
    removeLastNewLine(paramStringBuilder);
    return paramStringBuilder;
  }
  
  private static void appendHeaders(StringBuilder paramStringBuilder, HttpHeaders paramHttpHeaders)
  {
    Iterator localIterator = paramHttpHeaders.iterator();
    while (localIterator.hasNext())
    {
      paramHttpHeaders = (Map.Entry)localIterator.next();
      paramStringBuilder.append((String)paramHttpHeaders.getKey());
      paramStringBuilder.append(": ");
      paramStringBuilder.append((String)paramHttpHeaders.getValue());
      paramStringBuilder.append(StringUtil.NEWLINE);
    }
  }
  
  private static void appendInitialLine(StringBuilder paramStringBuilder, HttpRequest paramHttpRequest)
  {
    paramStringBuilder.append(paramHttpRequest.method());
    paramStringBuilder.append(' ');
    paramStringBuilder.append(paramHttpRequest.uri());
    paramStringBuilder.append(' ');
    paramStringBuilder.append(paramHttpRequest.protocolVersion());
    paramStringBuilder.append(StringUtil.NEWLINE);
  }
  
  private static void appendInitialLine(StringBuilder paramStringBuilder, HttpResponse paramHttpResponse)
  {
    paramStringBuilder.append(paramHttpResponse.protocolVersion());
    paramStringBuilder.append(' ');
    paramStringBuilder.append(paramHttpResponse.status());
    paramStringBuilder.append(StringUtil.NEWLINE);
  }
  
  static StringBuilder appendRequest(StringBuilder paramStringBuilder, HttpRequest paramHttpRequest)
  {
    appendCommon(paramStringBuilder, paramHttpRequest);
    appendInitialLine(paramStringBuilder, paramHttpRequest);
    appendHeaders(paramStringBuilder, paramHttpRequest.headers());
    removeLastNewLine(paramStringBuilder);
    return paramStringBuilder;
  }
  
  static StringBuilder appendResponse(StringBuilder paramStringBuilder, HttpResponse paramHttpResponse)
  {
    appendCommon(paramStringBuilder, paramHttpResponse);
    appendInitialLine(paramStringBuilder, paramHttpResponse);
    appendHeaders(paramStringBuilder, paramHttpResponse.headers());
    removeLastNewLine(paramStringBuilder);
    return paramStringBuilder;
  }
  
  private static void removeLastNewLine(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.setLength(paramStringBuilder.length() - StringUtil.NEWLINE.length());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpMessageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */