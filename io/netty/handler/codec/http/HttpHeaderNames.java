package io.netty.handler.codec.http;

import io.netty.util.AsciiString;

public final class HttpHeaderNames
{
  public static final AsciiString ACCEPT = AsciiString.cached("accept");
  public static final AsciiString ACCEPT_CHARSET = AsciiString.cached("accept-charset");
  public static final AsciiString ACCEPT_ENCODING = AsciiString.cached("accept-encoding");
  public static final AsciiString ACCEPT_LANGUAGE = AsciiString.cached("accept-language");
  public static final AsciiString ACCEPT_PATCH;
  public static final AsciiString ACCEPT_RANGES = AsciiString.cached("accept-ranges");
  public static final AsciiString ACCESS_CONTROL_ALLOW_CREDENTIALS;
  public static final AsciiString ACCESS_CONTROL_ALLOW_HEADERS;
  public static final AsciiString ACCESS_CONTROL_ALLOW_METHODS;
  public static final AsciiString ACCESS_CONTROL_ALLOW_ORIGIN;
  public static final AsciiString ACCESS_CONTROL_EXPOSE_HEADERS;
  public static final AsciiString ACCESS_CONTROL_MAX_AGE;
  public static final AsciiString ACCESS_CONTROL_REQUEST_HEADERS;
  public static final AsciiString ACCESS_CONTROL_REQUEST_METHOD;
  public static final AsciiString AGE;
  public static final AsciiString ALLOW;
  public static final AsciiString AUTHORIZATION;
  public static final AsciiString CACHE_CONTROL;
  public static final AsciiString CONNECTION;
  public static final AsciiString CONTENT_BASE;
  public static final AsciiString CONTENT_DISPOSITION;
  public static final AsciiString CONTENT_ENCODING;
  public static final AsciiString CONTENT_LANGUAGE;
  public static final AsciiString CONTENT_LENGTH;
  public static final AsciiString CONTENT_LOCATION;
  public static final AsciiString CONTENT_MD5;
  public static final AsciiString CONTENT_RANGE;
  public static final AsciiString CONTENT_SECURITY_POLICY;
  public static final AsciiString CONTENT_TRANSFER_ENCODING;
  public static final AsciiString CONTENT_TYPE;
  public static final AsciiString COOKIE;
  public static final AsciiString DATE;
  public static final AsciiString DNT;
  public static final AsciiString ETAG;
  public static final AsciiString EXPECT;
  public static final AsciiString EXPIRES;
  public static final AsciiString FROM;
  public static final AsciiString HOST;
  public static final AsciiString IF_MATCH;
  public static final AsciiString IF_MODIFIED_SINCE;
  public static final AsciiString IF_NONE_MATCH;
  public static final AsciiString IF_RANGE;
  public static final AsciiString IF_UNMODIFIED_SINCE;
  @Deprecated
  public static final AsciiString KEEP_ALIVE;
  public static final AsciiString LAST_MODIFIED;
  public static final AsciiString LOCATION;
  public static final AsciiString MAX_FORWARDS;
  public static final AsciiString ORIGIN;
  public static final AsciiString PRAGMA;
  public static final AsciiString PROXY_AUTHENTICATE;
  public static final AsciiString PROXY_AUTHORIZATION;
  @Deprecated
  public static final AsciiString PROXY_CONNECTION;
  public static final AsciiString RANGE;
  public static final AsciiString REFERER;
  public static final AsciiString RETRY_AFTER;
  public static final AsciiString SEC_WEBSOCKET_ACCEPT = AsciiString.cached("sec-websocket-accept");
  public static final AsciiString SEC_WEBSOCKET_EXTENSIONS = AsciiString.cached("sec-websocket-extensions");
  public static final AsciiString SEC_WEBSOCKET_KEY;
  public static final AsciiString SEC_WEBSOCKET_KEY1;
  public static final AsciiString SEC_WEBSOCKET_KEY2;
  public static final AsciiString SEC_WEBSOCKET_LOCATION;
  public static final AsciiString SEC_WEBSOCKET_ORIGIN;
  public static final AsciiString SEC_WEBSOCKET_PROTOCOL;
  public static final AsciiString SEC_WEBSOCKET_VERSION;
  public static final AsciiString SERVER = AsciiString.cached("server");
  public static final AsciiString SET_COOKIE = AsciiString.cached("set-cookie");
  public static final AsciiString SET_COOKIE2 = AsciiString.cached("set-cookie2");
  public static final AsciiString TE = AsciiString.cached("te");
  public static final AsciiString TRAILER = AsciiString.cached("trailer");
  public static final AsciiString TRANSFER_ENCODING = AsciiString.cached("transfer-encoding");
  public static final AsciiString UPGRADE = AsciiString.cached("upgrade");
  public static final AsciiString UPGRADE_INSECURE_REQUESTS = AsciiString.cached("upgrade-insecure-requests");
  public static final AsciiString USER_AGENT = AsciiString.cached("user-agent");
  public static final AsciiString VARY = AsciiString.cached("vary");
  public static final AsciiString VIA = AsciiString.cached("via");
  public static final AsciiString WARNING = AsciiString.cached("warning");
  public static final AsciiString WEBSOCKET_LOCATION = AsciiString.cached("websocket-location");
  public static final AsciiString WEBSOCKET_ORIGIN = AsciiString.cached("websocket-origin");
  public static final AsciiString WEBSOCKET_PROTOCOL = AsciiString.cached("websocket-protocol");
  public static final AsciiString WWW_AUTHENTICATE = AsciiString.cached("www-authenticate");
  public static final AsciiString X_FRAME_OPTIONS = AsciiString.cached("x-frame-options");
  public static final AsciiString X_REQUESTED_WITH = AsciiString.cached("x-requested-with");
  
  static
  {
    ACCEPT_PATCH = AsciiString.cached("accept-patch");
    ACCESS_CONTROL_ALLOW_CREDENTIALS = AsciiString.cached("access-control-allow-credentials");
    ACCESS_CONTROL_ALLOW_HEADERS = AsciiString.cached("access-control-allow-headers");
    ACCESS_CONTROL_ALLOW_METHODS = AsciiString.cached("access-control-allow-methods");
    ACCESS_CONTROL_ALLOW_ORIGIN = AsciiString.cached("access-control-allow-origin");
    ACCESS_CONTROL_EXPOSE_HEADERS = AsciiString.cached("access-control-expose-headers");
    ACCESS_CONTROL_MAX_AGE = AsciiString.cached("access-control-max-age");
    ACCESS_CONTROL_REQUEST_HEADERS = AsciiString.cached("access-control-request-headers");
    ACCESS_CONTROL_REQUEST_METHOD = AsciiString.cached("access-control-request-method");
    AGE = AsciiString.cached("age");
    ALLOW = AsciiString.cached("allow");
    AUTHORIZATION = AsciiString.cached("authorization");
    CACHE_CONTROL = AsciiString.cached("cache-control");
    CONNECTION = AsciiString.cached("connection");
    CONTENT_BASE = AsciiString.cached("content-base");
    CONTENT_ENCODING = AsciiString.cached("content-encoding");
    CONTENT_LANGUAGE = AsciiString.cached("content-language");
    CONTENT_LENGTH = AsciiString.cached("content-length");
    CONTENT_LOCATION = AsciiString.cached("content-location");
    CONTENT_TRANSFER_ENCODING = AsciiString.cached("content-transfer-encoding");
    CONTENT_DISPOSITION = AsciiString.cached("content-disposition");
    CONTENT_MD5 = AsciiString.cached("content-md5");
    CONTENT_RANGE = AsciiString.cached("content-range");
    CONTENT_SECURITY_POLICY = AsciiString.cached("content-security-policy");
    CONTENT_TYPE = AsciiString.cached("content-type");
    COOKIE = AsciiString.cached("cookie");
    DATE = AsciiString.cached("date");
    DNT = AsciiString.cached("dnt");
    ETAG = AsciiString.cached("etag");
    EXPECT = AsciiString.cached("expect");
    EXPIRES = AsciiString.cached("expires");
    FROM = AsciiString.cached("from");
    HOST = AsciiString.cached("host");
    IF_MATCH = AsciiString.cached("if-match");
    IF_MODIFIED_SINCE = AsciiString.cached("if-modified-since");
    IF_NONE_MATCH = AsciiString.cached("if-none-match");
    IF_RANGE = AsciiString.cached("if-range");
    IF_UNMODIFIED_SINCE = AsciiString.cached("if-unmodified-since");
    KEEP_ALIVE = AsciiString.cached("keep-alive");
    LAST_MODIFIED = AsciiString.cached("last-modified");
    LOCATION = AsciiString.cached("location");
    MAX_FORWARDS = AsciiString.cached("max-forwards");
    ORIGIN = AsciiString.cached("origin");
    PRAGMA = AsciiString.cached("pragma");
    PROXY_AUTHENTICATE = AsciiString.cached("proxy-authenticate");
    PROXY_AUTHORIZATION = AsciiString.cached("proxy-authorization");
    PROXY_CONNECTION = AsciiString.cached("proxy-connection");
    RANGE = AsciiString.cached("range");
    REFERER = AsciiString.cached("referer");
    RETRY_AFTER = AsciiString.cached("retry-after");
    SEC_WEBSOCKET_KEY1 = AsciiString.cached("sec-websocket-key1");
    SEC_WEBSOCKET_KEY2 = AsciiString.cached("sec-websocket-key2");
    SEC_WEBSOCKET_LOCATION = AsciiString.cached("sec-websocket-location");
    SEC_WEBSOCKET_ORIGIN = AsciiString.cached("sec-websocket-origin");
    SEC_WEBSOCKET_PROTOCOL = AsciiString.cached("sec-websocket-protocol");
    SEC_WEBSOCKET_VERSION = AsciiString.cached("sec-websocket-version");
    SEC_WEBSOCKET_KEY = AsciiString.cached("sec-websocket-key");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpHeaderNames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */