package io.netty.handler.codec.http2;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract interface Http2Headers
  extends Headers<CharSequence, CharSequence, Http2Headers>
{
  public abstract Http2Headers authority(CharSequence paramCharSequence);
  
  public abstract CharSequence authority();
  
  public abstract boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean);
  
  public abstract Iterator<Map.Entry<CharSequence, CharSequence>> iterator();
  
  public abstract Http2Headers method(CharSequence paramCharSequence);
  
  public abstract CharSequence method();
  
  public abstract Http2Headers path(CharSequence paramCharSequence);
  
  public abstract CharSequence path();
  
  public abstract Http2Headers scheme(CharSequence paramCharSequence);
  
  public abstract CharSequence scheme();
  
  public abstract Http2Headers status(CharSequence paramCharSequence);
  
  public abstract CharSequence status();
  
  public abstract Iterator<CharSequence> valueIterator(CharSequence paramCharSequence);
  
  public static enum PseudoHeaderName
  {
    private static final CharSequenceMap<PseudoHeaderName> PSEUDO_HEADERS;
    private static final char PSEUDO_HEADER_PREFIX = ':';
    private static final byte PSEUDO_HEADER_PREFIX_BYTE = 58;
    private final boolean requestOnly;
    private final AsciiString value;
    
    static
    {
      int i = 0;
      PseudoHeaderName localPseudoHeaderName1 = new PseudoHeaderName("METHOD", 0, ":method", true);
      METHOD = localPseudoHeaderName1;
      Object localObject = new PseudoHeaderName("SCHEME", 1, ":scheme", true);
      SCHEME = (PseudoHeaderName)localObject;
      PseudoHeaderName localPseudoHeaderName2 = new PseudoHeaderName("AUTHORITY", 2, ":authority", true);
      AUTHORITY = localPseudoHeaderName2;
      PseudoHeaderName localPseudoHeaderName3 = new PseudoHeaderName("PATH", 3, ":path", true);
      PATH = localPseudoHeaderName3;
      PseudoHeaderName localPseudoHeaderName4 = new PseudoHeaderName("STATUS", 4, ":status", false);
      STATUS = localPseudoHeaderName4;
      $VALUES = new PseudoHeaderName[] { localPseudoHeaderName1, localObject, localPseudoHeaderName2, localPseudoHeaderName3, localPseudoHeaderName4 };
      PSEUDO_HEADERS = new CharSequenceMap();
      localObject = values();
      int j = localObject.length;
      while (i < j)
      {
        localPseudoHeaderName2 = localObject[i];
        PSEUDO_HEADERS.add(localPseudoHeaderName2.value(), localPseudoHeaderName2);
        i++;
      }
    }
    
    private PseudoHeaderName(String paramString, boolean paramBoolean)
    {
      this.value = AsciiString.cached(paramString);
      this.requestOnly = paramBoolean;
    }
    
    public static PseudoHeaderName getPseudoHeader(CharSequence paramCharSequence)
    {
      return (PseudoHeaderName)PSEUDO_HEADERS.get(paramCharSequence);
    }
    
    public static boolean hasPseudoHeaderFormat(CharSequence paramCharSequence)
    {
      boolean bool1 = paramCharSequence instanceof AsciiString;
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        paramCharSequence = (AsciiString)paramCharSequence;
        if ((paramCharSequence.length() <= 0) || (paramCharSequence.byteAt(0) != 58)) {
          bool3 = false;
        }
        return bool3;
      }
      if ((paramCharSequence.length() > 0) && (paramCharSequence.charAt(0) == ':')) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    
    public static boolean isPseudoHeader(CharSequence paramCharSequence)
    {
      return PSEUDO_HEADERS.contains(paramCharSequence);
    }
    
    public boolean isRequestOnly()
    {
      return this.requestOnly;
    }
    
    public AsciiString value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */