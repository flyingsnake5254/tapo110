package io.netty.handler.codec.spdy;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract interface SpdyHeaders
  extends Headers<CharSequence, CharSequence, SpdyHeaders>
{
  public abstract boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean);
  
  public abstract List<String> getAllAsString(CharSequence paramCharSequence);
  
  public abstract String getAsString(CharSequence paramCharSequence);
  
  public abstract Iterator<Map.Entry<String, String>> iteratorAsString();
  
  public static final class HttpNames
  {
    public static final AsciiString HOST = AsciiString.cached(":host");
    public static final AsciiString METHOD = AsciiString.cached(":method");
    public static final AsciiString PATH = AsciiString.cached(":path");
    public static final AsciiString SCHEME = AsciiString.cached(":scheme");
    public static final AsciiString STATUS = AsciiString.cached(":status");
    public static final AsciiString VERSION = AsciiString.cached(":version");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */