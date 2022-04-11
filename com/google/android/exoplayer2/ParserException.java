package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import java.io.IOException;

public class ParserException
  extends IOException
{
  public final boolean contentIsMalformed;
  public final int dataType;
  
  protected ParserException(@Nullable String paramString, @Nullable Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    super(paramString, paramThrowable);
    this.contentIsMalformed = paramBoolean;
    this.dataType = paramInt;
  }
  
  public static ParserException createForMalformedContainer(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    return new ParserException(paramString, paramThrowable, true, 1);
  }
  
  public static ParserException createForMalformedDataOfUnknownType(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    return new ParserException(paramString, paramThrowable, true, 0);
  }
  
  public static ParserException createForMalformedManifest(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    return new ParserException(paramString, paramThrowable, true, 4);
  }
  
  public static ParserException createForManifestWithUnsupportedFeature(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    return new ParserException(paramString, paramThrowable, false, 4);
  }
  
  public static ParserException createForUnsupportedContainerFeature(@Nullable String paramString)
  {
    return new ParserException(paramString, null, false, 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ParserException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */