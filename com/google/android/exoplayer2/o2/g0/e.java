package com.google.android.exoplayer2.o2.g0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.u;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class e
{
  private static final String[] a = { "Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo" };
  private static final String[] b = { "Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs" };
  private static final String[] c = { "Camera:MicroVideoOffset", "GCamera:MicroVideoOffset" };
  
  @Nullable
  public static b a(String paramString)
    throws IOException
  {
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    catch (XmlPullParserException|ParserException|NumberFormatException paramString)
    {
      u.h("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
    }
    return null;
  }
  
  @Nullable
  private static b b(String paramString)
    throws XmlPullParserException, IOException
  {
    XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    localXmlPullParser.setInput(new StringReader(paramString));
    localXmlPullParser.next();
    if (p0.e(localXmlPullParser, "x:xmpmeta"))
    {
      long l1 = -9223372036854775807L;
      Object localObject = ImmutableList.of();
      long l2;
      do
      {
        localXmlPullParser.next();
        if (p0.e(localXmlPullParser, "rdf:Description"))
        {
          if (!d(localXmlPullParser)) {
            return null;
          }
          l2 = e(localXmlPullParser);
          paramString = c(localXmlPullParser);
        }
        else if (p0.e(localXmlPullParser, "Container:Directory"))
        {
          paramString = f(localXmlPullParser, "Container", "Item");
          l2 = l1;
        }
        else
        {
          paramString = (String)localObject;
          l2 = l1;
          if (p0.e(localXmlPullParser, "GContainer:Directory"))
          {
            paramString = f(localXmlPullParser, "GContainer", "GContainerItem");
            l2 = l1;
          }
        }
        localObject = paramString;
        l1 = l2;
      } while (!p0.c(localXmlPullParser, "x:xmpmeta"));
      if (paramString.isEmpty()) {
        return null;
      }
      return new b(l2, paramString);
    }
    throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
  }
  
  private static ImmutableList<b.a> c(XmlPullParser paramXmlPullParser)
  {
    String[] arrayOfString = c;
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = p0.a(paramXmlPullParser, arrayOfString[j]);
      if (str != null)
      {
        long l = Long.parseLong(str);
        return ImmutableList.of(new b.a("image/jpeg", "Primary", 0L, 0L), new b.a("video/mp4", "MotionPhoto", l, 0L));
      }
    }
    return ImmutableList.of();
  }
  
  private static boolean d(XmlPullParser paramXmlPullParser)
  {
    String[] arrayOfString = a;
    int i = arrayOfString.length;
    boolean bool = false;
    for (int j = 0; j < i; j++)
    {
      String str = p0.a(paramXmlPullParser, arrayOfString[j]);
      if (str != null)
      {
        if (Integer.parseInt(str) == 1) {
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  private static long e(XmlPullParser paramXmlPullParser)
  {
    String[] arrayOfString = b;
    int i = arrayOfString.length;
    for (int j = 0;; j++)
    {
      long l1 = -9223372036854775807L;
      if (j >= i) {
        break;
      }
      String str = p0.a(paramXmlPullParser, arrayOfString[j]);
      if (str != null)
      {
        long l2 = Long.parseLong(str);
        if (l2 == -1L) {
          l2 = l1;
        }
        return l2;
      }
    }
    return -9223372036854775807L;
  }
  
  private static ImmutableList<b.a> f(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
    throws XmlPullParserException, IOException
  {
    ImmutableList.a locala = ImmutableList.builder();
    String str1 = String.valueOf(paramString1).concat(":Item");
    paramString1 = String.valueOf(paramString1).concat(":Directory");
    do
    {
      paramXmlPullParser.next();
      if (p0.e(paramXmlPullParser, str1))
      {
        String str2 = String.valueOf(paramString2).concat(":Mime");
        String str3 = String.valueOf(paramString2).concat(":Semantic");
        String str4 = String.valueOf(paramString2).concat(":Length");
        String str5 = String.valueOf(paramString2).concat(":Padding");
        str2 = p0.a(paramXmlPullParser, str2);
        str3 = p0.a(paramXmlPullParser, str3);
        str4 = p0.a(paramXmlPullParser, str4);
        str5 = p0.a(paramXmlPullParser, str5);
        if ((str2 != null) && (str3 != null))
        {
          long l1;
          if (str4 != null) {
            l1 = Long.parseLong(str4);
          } else {
            l1 = 0L;
          }
          long l2;
          if (str5 != null) {
            l2 = Long.parseLong(str5);
          } else {
            l2 = 0L;
          }
          locala.h(new b.a(str2, str3, l1, l2));
        }
        else
        {
          return ImmutableList.of();
        }
      }
    } while (!p0.c(paramXmlPullParser, paramString1));
    return locala.j();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\g0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */