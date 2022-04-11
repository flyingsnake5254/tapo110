package io.netty.handler.codec.spdy;

import io.netty.util.AsciiString;

public final class SpdyHttpHeaders
{
  public static final class Names
  {
    public static final AsciiString ASSOCIATED_TO_STREAM_ID = AsciiString.cached("x-spdy-associated-to-stream-id");
    public static final AsciiString PRIORITY = AsciiString.cached("x-spdy-priority");
    public static final AsciiString SCHEME = AsciiString.cached("x-spdy-scheme");
    public static final AsciiString STREAM_ID = AsciiString.cached("x-spdy-stream-id");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */