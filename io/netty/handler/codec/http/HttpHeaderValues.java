package io.netty.handler.codec.http;

import io.netty.util.AsciiString;

public final class HttpHeaderValues
{
  public static final AsciiString APPLICATION_JSON = AsciiString.cached("application/json");
  public static final AsciiString APPLICATION_OCTET_STREAM;
  public static final AsciiString APPLICATION_XHTML;
  public static final AsciiString APPLICATION_XML;
  public static final AsciiString APPLICATION_X_WWW_FORM_URLENCODED = AsciiString.cached("application/x-www-form-urlencoded");
  public static final AsciiString ATTACHMENT;
  public static final AsciiString BASE64;
  public static final AsciiString BINARY;
  public static final AsciiString BOUNDARY;
  public static final AsciiString BYTES;
  public static final AsciiString CHARSET;
  public static final AsciiString CHUNKED;
  public static final AsciiString CLOSE;
  public static final AsciiString COMPRESS;
  public static final AsciiString CONTINUE;
  public static final AsciiString DEFLATE;
  public static final AsciiString FILE;
  public static final AsciiString FILENAME;
  public static final AsciiString FORM_DATA;
  public static final AsciiString GZIP;
  public static final AsciiString GZIP_DEFLATE;
  public static final AsciiString IDENTITY;
  public static final AsciiString KEEP_ALIVE;
  public static final AsciiString MAX_AGE;
  public static final AsciiString MAX_STALE;
  public static final AsciiString MIN_FRESH;
  public static final AsciiString MULTIPART_FORM_DATA;
  public static final AsciiString MULTIPART_MIXED;
  public static final AsciiString MUST_REVALIDATE;
  public static final AsciiString NAME;
  public static final AsciiString NONE;
  public static final AsciiString NO_CACHE;
  public static final AsciiString NO_STORE;
  public static final AsciiString NO_TRANSFORM;
  public static final AsciiString ONLY_IF_CACHED;
  public static final AsciiString PRIVATE;
  public static final AsciiString PROXY_REVALIDATE;
  public static final AsciiString PUBLIC;
  public static final AsciiString QUOTED_PRINTABLE;
  public static final AsciiString S_MAXAGE;
  public static final AsciiString TEXT_CSS;
  public static final AsciiString TEXT_EVENT_STREAM = AsciiString.cached("text/event-stream");
  public static final AsciiString TEXT_HTML;
  public static final AsciiString TEXT_PLAIN = AsciiString.cached("text/plain");
  public static final AsciiString TRAILERS = AsciiString.cached("trailers");
  public static final AsciiString UPGRADE = AsciiString.cached("upgrade");
  public static final AsciiString WEBSOCKET = AsciiString.cached("websocket");
  public static final AsciiString XML_HTTP_REQUEST = AsciiString.cached("XmlHttpRequest");
  public static final AsciiString X_DEFLATE;
  public static final AsciiString X_GZIP;
  public static final AsciiString ZERO;
  
  static
  {
    APPLICATION_OCTET_STREAM = AsciiString.cached("application/octet-stream");
    APPLICATION_XHTML = AsciiString.cached("application/xhtml+xml");
    APPLICATION_XML = AsciiString.cached("application/xml");
    ATTACHMENT = AsciiString.cached("attachment");
    BASE64 = AsciiString.cached("base64");
    BINARY = AsciiString.cached("binary");
    BOUNDARY = AsciiString.cached("boundary");
    BYTES = AsciiString.cached("bytes");
    CHARSET = AsciiString.cached("charset");
    CHUNKED = AsciiString.cached("chunked");
    CLOSE = AsciiString.cached("close");
    COMPRESS = AsciiString.cached("compress");
    CONTINUE = AsciiString.cached("100-continue");
    DEFLATE = AsciiString.cached("deflate");
    X_DEFLATE = AsciiString.cached("x-deflate");
    FILE = AsciiString.cached("file");
    FILENAME = AsciiString.cached("filename");
    FORM_DATA = AsciiString.cached("form-data");
    GZIP = AsciiString.cached("gzip");
    GZIP_DEFLATE = AsciiString.cached("gzip,deflate");
    X_GZIP = AsciiString.cached("x-gzip");
    IDENTITY = AsciiString.cached("identity");
    KEEP_ALIVE = AsciiString.cached("keep-alive");
    MAX_AGE = AsciiString.cached("max-age");
    MAX_STALE = AsciiString.cached("max-stale");
    MIN_FRESH = AsciiString.cached("min-fresh");
    MULTIPART_FORM_DATA = AsciiString.cached("multipart/form-data");
    MULTIPART_MIXED = AsciiString.cached("multipart/mixed");
    MUST_REVALIDATE = AsciiString.cached("must-revalidate");
    NAME = AsciiString.cached("name");
    NO_CACHE = AsciiString.cached("no-cache");
    NO_STORE = AsciiString.cached("no-store");
    NO_TRANSFORM = AsciiString.cached("no-transform");
    NONE = AsciiString.cached("none");
    ZERO = AsciiString.cached("0");
    ONLY_IF_CACHED = AsciiString.cached("only-if-cached");
    PRIVATE = AsciiString.cached("private");
    PROXY_REVALIDATE = AsciiString.cached("proxy-revalidate");
    PUBLIC = AsciiString.cached("public");
    QUOTED_PRINTABLE = AsciiString.cached("quoted-printable");
    S_MAXAGE = AsciiString.cached("s-maxage");
    TEXT_CSS = AsciiString.cached("text/css");
    TEXT_HTML = AsciiString.cached("text/html");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpHeaderValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */