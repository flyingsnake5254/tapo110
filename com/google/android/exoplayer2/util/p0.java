package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class p0
{
  @Nullable
  public static String a(XmlPullParser paramXmlPullParser, String paramString)
  {
    int i = paramXmlPullParser.getAttributeCount();
    for (int j = 0; j < i; j++) {
      if (paramXmlPullParser.getAttributeName(j).equals(paramString)) {
        return paramXmlPullParser.getAttributeValue(j);
      }
    }
    return null;
  }
  
  public static boolean b(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    boolean bool;
    if (paramXmlPullParser.getEventType() == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean c(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException
  {
    boolean bool;
    if ((b(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean d(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    boolean bool;
    if (paramXmlPullParser.getEventType() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean e(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException
  {
    boolean bool;
    if ((d(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */