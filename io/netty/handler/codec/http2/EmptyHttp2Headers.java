package io.netty.handler.codec.http2;

import io.netty.handler.codec.EmptyHeaders;

public final class EmptyHttp2Headers
  extends EmptyHeaders<CharSequence, CharSequence, Http2Headers>
  implements Http2Headers
{
  public static final EmptyHttp2Headers INSTANCE = new EmptyHttp2Headers();
  
  public EmptyHttp2Headers authority(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException();
  }
  
  public CharSequence authority()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.AUTHORITY.value());
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    return false;
  }
  
  public EmptyHttp2Headers method(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException();
  }
  
  public CharSequence method()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.METHOD.value());
  }
  
  public EmptyHttp2Headers path(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException();
  }
  
  public CharSequence path()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.PATH.value());
  }
  
  public EmptyHttp2Headers scheme(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException();
  }
  
  public CharSequence scheme()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.SCHEME.value());
  }
  
  public EmptyHttp2Headers status(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException();
  }
  
  public CharSequence status()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.STATUS.value());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\EmptyHttp2Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */