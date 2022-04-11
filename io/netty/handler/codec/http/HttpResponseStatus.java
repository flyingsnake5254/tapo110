package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;

public class HttpResponseStatus
  implements Comparable<HttpResponseStatus>
{
  public static final HttpResponseStatus ACCEPTED;
  public static final HttpResponseStatus BAD_GATEWAY;
  public static final HttpResponseStatus BAD_REQUEST;
  public static final HttpResponseStatus CONFLICT;
  public static final HttpResponseStatus CONTINUE = newStatus(100, "Continue");
  public static final HttpResponseStatus CREATED;
  public static final HttpResponseStatus EXPECTATION_FAILED;
  public static final HttpResponseStatus FAILED_DEPENDENCY;
  public static final HttpResponseStatus FORBIDDEN;
  public static final HttpResponseStatus FOUND;
  public static final HttpResponseStatus GATEWAY_TIMEOUT;
  public static final HttpResponseStatus GONE;
  public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED;
  public static final HttpResponseStatus INSUFFICIENT_STORAGE;
  public static final HttpResponseStatus INTERNAL_SERVER_ERROR;
  public static final HttpResponseStatus LENGTH_REQUIRED;
  public static final HttpResponseStatus LOCKED;
  public static final HttpResponseStatus METHOD_NOT_ALLOWED;
  public static final HttpResponseStatus MISDIRECTED_REQUEST;
  public static final HttpResponseStatus MOVED_PERMANENTLY;
  public static final HttpResponseStatus MULTIPLE_CHOICES;
  public static final HttpResponseStatus MULTI_STATUS;
  public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = newStatus(511, "Network Authentication Required");
  public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION;
  public static final HttpResponseStatus NOT_ACCEPTABLE;
  public static final HttpResponseStatus NOT_EXTENDED;
  public static final HttpResponseStatus NOT_FOUND;
  public static final HttpResponseStatus NOT_IMPLEMENTED;
  public static final HttpResponseStatus NOT_MODIFIED;
  public static final HttpResponseStatus NO_CONTENT;
  public static final HttpResponseStatus OK;
  public static final HttpResponseStatus PARTIAL_CONTENT;
  public static final HttpResponseStatus PAYMENT_REQUIRED;
  public static final HttpResponseStatus PERMANENT_REDIRECT;
  public static final HttpResponseStatus PRECONDITION_FAILED;
  public static final HttpResponseStatus PRECONDITION_REQUIRED;
  public static final HttpResponseStatus PROCESSING;
  public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED;
  public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE;
  public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE;
  public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE;
  public static final HttpResponseStatus REQUEST_TIMEOUT;
  public static final HttpResponseStatus REQUEST_URI_TOO_LONG;
  public static final HttpResponseStatus RESET_CONTENT;
  public static final HttpResponseStatus SEE_OTHER;
  public static final HttpResponseStatus SERVICE_UNAVAILABLE;
  public static final HttpResponseStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");
  public static final HttpResponseStatus TEMPORARY_REDIRECT;
  public static final HttpResponseStatus TOO_MANY_REQUESTS;
  public static final HttpResponseStatus UNAUTHORIZED;
  public static final HttpResponseStatus UNORDERED_COLLECTION;
  public static final HttpResponseStatus UNPROCESSABLE_ENTITY;
  public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE;
  public static final HttpResponseStatus UPGRADE_REQUIRED;
  public static final HttpResponseStatus USE_PROXY;
  public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES;
  private final byte[] bytes;
  private final int code;
  private final AsciiString codeAsText;
  private HttpStatusClass codeClass;
  private final String reasonPhrase;
  
  static
  {
    PROCESSING = newStatus(102, "Processing");
    OK = newStatus(200, "OK");
    CREATED = newStatus(201, "Created");
    ACCEPTED = newStatus(202, "Accepted");
    NON_AUTHORITATIVE_INFORMATION = newStatus(203, "Non-Authoritative Information");
    NO_CONTENT = newStatus(204, "No Content");
    RESET_CONTENT = newStatus(205, "Reset Content");
    PARTIAL_CONTENT = newStatus(206, "Partial Content");
    MULTI_STATUS = newStatus(207, "Multi-Status");
    MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");
    MOVED_PERMANENTLY = newStatus(301, "Moved Permanently");
    FOUND = newStatus(302, "Found");
    SEE_OTHER = newStatus(303, "See Other");
    NOT_MODIFIED = newStatus(304, "Not Modified");
    USE_PROXY = newStatus(305, "Use Proxy");
    TEMPORARY_REDIRECT = newStatus(307, "Temporary Redirect");
    PERMANENT_REDIRECT = newStatus(308, "Permanent Redirect");
    BAD_REQUEST = newStatus(400, "Bad Request");
    UNAUTHORIZED = newStatus(401, "Unauthorized");
    PAYMENT_REQUIRED = newStatus(402, "Payment Required");
    FORBIDDEN = newStatus(403, "Forbidden");
    NOT_FOUND = newStatus(404, "Not Found");
    METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");
    NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");
    PROXY_AUTHENTICATION_REQUIRED = newStatus(407, "Proxy Authentication Required");
    REQUEST_TIMEOUT = newStatus(408, "Request Timeout");
    CONFLICT = newStatus(409, "Conflict");
    GONE = newStatus(410, "Gone");
    LENGTH_REQUIRED = newStatus(411, "Length Required");
    PRECONDITION_FAILED = newStatus(412, "Precondition Failed");
    REQUEST_ENTITY_TOO_LARGE = newStatus(413, "Request Entity Too Large");
    REQUEST_URI_TOO_LONG = newStatus(414, "Request-URI Too Long");
    UNSUPPORTED_MEDIA_TYPE = newStatus(415, "Unsupported Media Type");
    REQUESTED_RANGE_NOT_SATISFIABLE = newStatus(416, "Requested Range Not Satisfiable");
    EXPECTATION_FAILED = newStatus(417, "Expectation Failed");
    MISDIRECTED_REQUEST = newStatus(421, "Misdirected Request");
    UNPROCESSABLE_ENTITY = newStatus(422, "Unprocessable Entity");
    LOCKED = newStatus(423, "Locked");
    FAILED_DEPENDENCY = newStatus(424, "Failed Dependency");
    UNORDERED_COLLECTION = newStatus(425, "Unordered Collection");
    UPGRADE_REQUIRED = newStatus(426, "Upgrade Required");
    PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");
    TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");
    REQUEST_HEADER_FIELDS_TOO_LARGE = newStatus(431, "Request Header Fields Too Large");
    INTERNAL_SERVER_ERROR = newStatus(500, "Internal Server Error");
    NOT_IMPLEMENTED = newStatus(501, "Not Implemented");
    BAD_GATEWAY = newStatus(502, "Bad Gateway");
    SERVICE_UNAVAILABLE = newStatus(503, "Service Unavailable");
    GATEWAY_TIMEOUT = newStatus(504, "Gateway Timeout");
    HTTP_VERSION_NOT_SUPPORTED = newStatus(505, "HTTP Version Not Supported");
    VARIANT_ALSO_NEGOTIATES = newStatus(506, "Variant Also Negotiates");
    INSUFFICIENT_STORAGE = newStatus(507, "Insufficient Storage");
    NOT_EXTENDED = newStatus(510, "Not Extended");
  }
  
  private HttpResponseStatus(int paramInt)
  {
    this(paramInt, localStringBuilder.toString(), false);
  }
  
  public HttpResponseStatus(int paramInt, String paramString)
  {
    this(paramInt, paramString, false);
  }
  
  private HttpResponseStatus(int paramInt, String paramString, boolean paramBoolean)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "code");
    ObjectUtil.checkNotNull(paramString, "reasonPhrase");
    int i = 0;
    StringBuilder localStringBuilder;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j != 10) && (j != 13))
      {
        i++;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("reasonPhrase contains one of the following prohibited characters: \\r\\n: ");
        localStringBuilder.append(paramString);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    this.code = paramInt;
    String str = Integer.toString(paramInt);
    this.codeAsText = new AsciiString(str);
    this.reasonPhrase = paramString;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(' ');
      localStringBuilder.append(paramString);
      this.bytes = localStringBuilder.toString().getBytes(CharsetUtil.US_ASCII);
    }
    else
    {
      this.bytes = null;
    }
  }
  
  private static HttpResponseStatus newStatus(int paramInt, String paramString)
  {
    return new HttpResponseStatus(paramInt, paramString, true);
  }
  
  public static HttpResponseStatus parseLine(AsciiString paramAsciiString)
  {
    try
    {
      int i = paramAsciiString.forEachByte(ByteProcessor.FIND_ASCII_SPACE);
      if (i == -1)
      {
        localObject = valueOf(paramAsciiString.parseInt());
        paramAsciiString = (AsciiString)localObject;
      }
      else
      {
        localObject = valueOf(paramAsciiString.parseInt(0, i), paramAsciiString.toString(i + 1));
        paramAsciiString = (AsciiString)localObject;
      }
      return paramAsciiString;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("malformed status line: ");
      ((StringBuilder)localObject).append(paramAsciiString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString(), localException);
    }
  }
  
  public static HttpResponseStatus parseLine(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      paramCharSequence = parseLine((AsciiString)paramCharSequence);
    } else {
      paramCharSequence = parseLine(paramCharSequence.toString());
    }
    return paramCharSequence;
  }
  
  public static HttpResponseStatus parseLine(String paramString)
  {
    try
    {
      int i = paramString.indexOf(' ');
      if (i == -1)
      {
        localObject = valueOf(Integer.parseInt(paramString));
        paramString = (String)localObject;
      }
      else
      {
        localObject = valueOf(Integer.parseInt(paramString.substring(0, i)), paramString.substring(i + 1));
        paramString = (String)localObject;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("malformed status line: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString(), localException);
    }
  }
  
  public static HttpResponseStatus valueOf(int paramInt)
  {
    HttpResponseStatus localHttpResponseStatus = valueOf0(paramInt);
    if (localHttpResponseStatus == null) {
      localHttpResponseStatus = new HttpResponseStatus(paramInt);
    }
    return localHttpResponseStatus;
  }
  
  public static HttpResponseStatus valueOf(int paramInt, String paramString)
  {
    HttpResponseStatus localHttpResponseStatus = valueOf0(paramInt);
    if ((localHttpResponseStatus != null) && (localHttpResponseStatus.reasonPhrase().contentEquals(paramString))) {
      paramString = localHttpResponseStatus;
    } else {
      paramString = new HttpResponseStatus(paramInt, paramString);
    }
    return paramString;
  }
  
  private static HttpResponseStatus valueOf0(int paramInt)
  {
    if (paramInt != 307)
    {
      if (paramInt != 308)
      {
        if (paramInt != 428)
        {
          if (paramInt != 429)
          {
            if (paramInt != 431)
            {
              if (paramInt != 510)
              {
                if (paramInt != 511)
                {
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            switch (paramInt)
                            {
                            default: 
                              return null;
                            case 507: 
                              return INSUFFICIENT_STORAGE;
                            case 506: 
                              return VARIANT_ALSO_NEGOTIATES;
                            case 505: 
                              return HTTP_VERSION_NOT_SUPPORTED;
                            case 504: 
                              return GATEWAY_TIMEOUT;
                            case 503: 
                              return SERVICE_UNAVAILABLE;
                            case 502: 
                              return BAD_GATEWAY;
                            case 501: 
                              return NOT_IMPLEMENTED;
                            }
                            return INTERNAL_SERVER_ERROR;
                          case 426: 
                            return UPGRADE_REQUIRED;
                          case 425: 
                            return UNORDERED_COLLECTION;
                          case 424: 
                            return FAILED_DEPENDENCY;
                          case 423: 
                            return LOCKED;
                          case 422: 
                            return UNPROCESSABLE_ENTITY;
                          }
                          return MISDIRECTED_REQUEST;
                        case 417: 
                          return EXPECTATION_FAILED;
                        case 416: 
                          return REQUESTED_RANGE_NOT_SATISFIABLE;
                        case 415: 
                          return UNSUPPORTED_MEDIA_TYPE;
                        case 414: 
                          return REQUEST_URI_TOO_LONG;
                        case 413: 
                          return REQUEST_ENTITY_TOO_LARGE;
                        case 412: 
                          return PRECONDITION_FAILED;
                        case 411: 
                          return LENGTH_REQUIRED;
                        case 410: 
                          return GONE;
                        case 409: 
                          return CONFLICT;
                        case 408: 
                          return REQUEST_TIMEOUT;
                        case 407: 
                          return PROXY_AUTHENTICATION_REQUIRED;
                        case 406: 
                          return NOT_ACCEPTABLE;
                        case 405: 
                          return METHOD_NOT_ALLOWED;
                        case 404: 
                          return NOT_FOUND;
                        case 403: 
                          return FORBIDDEN;
                        case 402: 
                          return PAYMENT_REQUIRED;
                        case 401: 
                          return UNAUTHORIZED;
                        }
                        return BAD_REQUEST;
                      case 305: 
                        return USE_PROXY;
                      case 304: 
                        return NOT_MODIFIED;
                      case 303: 
                        return SEE_OTHER;
                      case 302: 
                        return FOUND;
                      case 301: 
                        return MOVED_PERMANENTLY;
                      }
                      return MULTIPLE_CHOICES;
                    case 207: 
                      return MULTI_STATUS;
                    case 206: 
                      return PARTIAL_CONTENT;
                    case 205: 
                      return RESET_CONTENT;
                    case 204: 
                      return NO_CONTENT;
                    case 203: 
                      return NON_AUTHORITATIVE_INFORMATION;
                    case 202: 
                      return ACCEPTED;
                    case 201: 
                      return CREATED;
                    }
                    return OK;
                  case 102: 
                    return PROCESSING;
                  case 101: 
                    return SWITCHING_PROTOCOLS;
                  }
                  return CONTINUE;
                }
                return NETWORK_AUTHENTICATION_REQUIRED;
              }
              return NOT_EXTENDED;
            }
            return REQUEST_HEADER_FIELDS_TOO_LARGE;
          }
          return TOO_MANY_REQUESTS;
        }
        return PRECONDITION_REQUIRED;
      }
      return PERMANENT_REDIRECT;
    }
    return TEMPORARY_REDIRECT;
  }
  
  public int code()
  {
    return this.code;
  }
  
  public AsciiString codeAsText()
  {
    return this.codeAsText;
  }
  
  public HttpStatusClass codeClass()
  {
    HttpStatusClass localHttpStatusClass1 = this.codeClass;
    HttpStatusClass localHttpStatusClass2 = localHttpStatusClass1;
    if (localHttpStatusClass1 == null)
    {
      localHttpStatusClass2 = HttpStatusClass.valueOf(this.code);
      this.codeClass = localHttpStatusClass2;
    }
    return localHttpStatusClass2;
  }
  
  public int compareTo(HttpResponseStatus paramHttpResponseStatus)
  {
    return code() - paramHttpResponseStatus.code();
  }
  
  void encode(ByteBuf paramByteBuf)
  {
    byte[] arrayOfByte = this.bytes;
    if (arrayOfByte == null)
    {
      ByteBufUtil.copy(this.codeAsText, paramByteBuf);
      paramByteBuf.writeByte(32);
      paramByteBuf.writeCharSequence(this.reasonPhrase, CharsetUtil.US_ASCII);
    }
    else
    {
      paramByteBuf.writeBytes(arrayOfByte);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof HttpResponseStatus;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (code() == ((HttpResponseStatus)paramObject).code()) {
      bool2 = true;
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return code();
  }
  
  public String reasonPhrase()
  {
    return this.reasonPhrase;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.reasonPhrase.length() + 4);
    localStringBuilder.append(this.codeAsText);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.reasonPhrase);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpResponseStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */