package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.util.d0;

abstract class TagPayloadReader
{
  protected final b0 a;
  
  protected TagPayloadReader(b0 paramb0)
  {
    this.a = paramb0;
  }
  
  public final boolean a(d0 paramd0, long paramLong)
    throws ParserException
  {
    boolean bool;
    if ((b(paramd0)) && (c(paramd0, paramLong))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract boolean b(d0 paramd0)
    throws ParserException;
  
  protected abstract boolean c(d0 paramd0, long paramLong)
    throws ParserException;
  
  public static final class UnsupportedFormatException
    extends ParserException
  {
    public UnsupportedFormatException(String paramString)
    {
      super(null, false, 1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\extractor\flv\TagPayloadReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */