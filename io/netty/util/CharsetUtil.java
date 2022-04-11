package io.netty.util;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Map;

public final class CharsetUtil
{
  private static final Charset[] CHARSETS;
  public static final Charset ISO_8859_1;
  public static final Charset US_ASCII;
  public static final Charset UTF_16;
  public static final Charset UTF_16BE;
  public static final Charset UTF_16LE;
  public static final Charset UTF_8;
  
  static
  {
    Charset localCharset1 = Charset.forName("UTF-16");
    UTF_16 = localCharset1;
    Charset localCharset2 = Charset.forName("UTF-16BE");
    UTF_16BE = localCharset2;
    Charset localCharset3 = Charset.forName("UTF-16LE");
    UTF_16LE = localCharset3;
    Charset localCharset4 = Charset.forName("UTF-8");
    UTF_8 = localCharset4;
    Charset localCharset5 = Charset.forName("ISO-8859-1");
    ISO_8859_1 = localCharset5;
    Charset localCharset6 = Charset.forName("US-ASCII");
    US_ASCII = localCharset6;
    CHARSETS = new Charset[] { localCharset1, localCharset2, localCharset3, localCharset4, localCharset5, localCharset6 };
  }
  
  public static CharsetDecoder decoder(Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramCharset, "charset");
    Map localMap = InternalThreadLocalMap.get().charsetDecoderCache();
    Object localObject = (CharsetDecoder)localMap.get(paramCharset);
    if (localObject != null)
    {
      ((CharsetDecoder)localObject).reset().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      return (CharsetDecoder)localObject;
    }
    localObject = CodingErrorAction.REPLACE;
    localObject = decoder(paramCharset, (CodingErrorAction)localObject, (CodingErrorAction)localObject);
    localMap.put(paramCharset, localObject);
    return (CharsetDecoder)localObject;
  }
  
  public static CharsetDecoder decoder(Charset paramCharset, CodingErrorAction paramCodingErrorAction)
  {
    return decoder(paramCharset, paramCodingErrorAction, paramCodingErrorAction);
  }
  
  public static CharsetDecoder decoder(Charset paramCharset, CodingErrorAction paramCodingErrorAction1, CodingErrorAction paramCodingErrorAction2)
  {
    ObjectUtil.checkNotNull(paramCharset, "charset");
    paramCharset = paramCharset.newDecoder();
    paramCharset.onMalformedInput(paramCodingErrorAction1).onUnmappableCharacter(paramCodingErrorAction2);
    return paramCharset;
  }
  
  public static CharsetEncoder encoder(Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramCharset, "charset");
    Map localMap = InternalThreadLocalMap.get().charsetEncoderCache();
    Object localObject = (CharsetEncoder)localMap.get(paramCharset);
    if (localObject != null)
    {
      ((CharsetEncoder)localObject).reset().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      return (CharsetEncoder)localObject;
    }
    localObject = CodingErrorAction.REPLACE;
    localObject = encoder(paramCharset, (CodingErrorAction)localObject, (CodingErrorAction)localObject);
    localMap.put(paramCharset, localObject);
    return (CharsetEncoder)localObject;
  }
  
  public static CharsetEncoder encoder(Charset paramCharset, CodingErrorAction paramCodingErrorAction)
  {
    return encoder(paramCharset, paramCodingErrorAction, paramCodingErrorAction);
  }
  
  public static CharsetEncoder encoder(Charset paramCharset, CodingErrorAction paramCodingErrorAction1, CodingErrorAction paramCodingErrorAction2)
  {
    ObjectUtil.checkNotNull(paramCharset, "charset");
    paramCharset = paramCharset.newEncoder();
    paramCharset.onMalformedInput(paramCodingErrorAction1).onUnmappableCharacter(paramCodingErrorAction2);
    return paramCharset;
  }
  
  @Deprecated
  public static CharsetDecoder getDecoder(Charset paramCharset)
  {
    return decoder(paramCharset);
  }
  
  @Deprecated
  public static CharsetEncoder getEncoder(Charset paramCharset)
  {
    return encoder(paramCharset);
  }
  
  public static Charset[] values()
  {
    return CHARSETS;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\CharsetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */