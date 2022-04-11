package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;

public class UnrecognizedInputFormatException
  extends ParserException
{
  public final Uri uri;
  
  public UnrecognizedInputFormatException(String paramString, Uri paramUri)
  {
    super(paramString, null, false, 1);
    this.uri = paramUri;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\UnrecognizedInputFormatException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */