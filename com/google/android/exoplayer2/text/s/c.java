package com.google.android.exoplayer2.text.s;

import android.text.Layout.Alignment;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class c
  extends com.google.android.exoplayer2.text.d
{
  private static final Pattern o = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
  private static final Pattern p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
  private static final Pattern q = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
  static final Pattern r = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
  static final Pattern s = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
  private static final Pattern t = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
  private static final Pattern u = Pattern.compile("^(\\d+) (\\d+)$");
  private static final b v = new b(30.0F, 1, 1);
  private static final a w = new a(32, 15);
  private final XmlPullParserFactory x;
  
  public c()
  {
    super("TtmlDecoder");
    try
    {
      XmlPullParserFactory localXmlPullParserFactory = XmlPullParserFactory.newInstance();
      this.x = localXmlPullParserFactory;
      localXmlPullParserFactory.setNamespaceAware(true);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
    }
  }
  
  private static g B(@Nullable g paramg)
  {
    g localg = paramg;
    if (paramg == null) {
      localg = new g();
    }
    return localg;
  }
  
  private static boolean C(String paramString)
  {
    boolean bool;
    if ((!paramString.equals("tt")) && (!paramString.equals("head")) && (!paramString.equals("body")) && (!paramString.equals("div")) && (!paramString.equals("p")) && (!paramString.equals("span")) && (!paramString.equals("br")) && (!paramString.equals("style")) && (!paramString.equals("styling")) && (!paramString.equals("layout")) && (!paramString.equals("region")) && (!paramString.equals("metadata")) && (!paramString.equals("image")) && (!paramString.equals("data")) && (!paramString.equals("information"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  private static Layout.Alignment D(String paramString)
  {
    paramString = com.google.common.base.c.e(paramString);
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        j = 4;
      }
      break;
    case 108511772: 
      if (paramString.equals("right")) {
        j = 3;
      }
      break;
    case 3317767: 
      if (paramString.equals("left")) {
        j = 2;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        j = 1;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return null;
    case 2: 
    case 4: 
      return Layout.Alignment.ALIGN_NORMAL;
    case 1: 
    case 3: 
      return Layout.Alignment.ALIGN_OPPOSITE;
    }
    return Layout.Alignment.ALIGN_CENTER;
  }
  
  private static a E(XmlPullParser paramXmlPullParser, a parama)
    throws SubtitleDecoderException
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
    if (paramXmlPullParser == null) {
      return parama;
    }
    Object localObject = u.matcher(paramXmlPullParser);
    if (!((Matcher)localObject).matches())
    {
      if (paramXmlPullParser.length() != 0) {
        paramXmlPullParser = "Ignoring malformed cell resolution: ".concat(paramXmlPullParser);
      } else {
        paramXmlPullParser = new String("Ignoring malformed cell resolution: ");
      }
      u.h("TtmlDecoder", paramXmlPullParser);
      return parama;
    }
    try
    {
      int i = Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject).group(1)));
      int j = Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject).group(2)));
      if ((i != 0) && (j != 0)) {
        return new a(i, j);
      }
      localObject = new com/google/android/exoplayer2/text/SubtitleDecoderException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(47);
      localStringBuilder.append("Invalid cell resolution ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(j);
      ((SubtitleDecoderException)localObject).<init>(localStringBuilder.toString());
      throw ((Throwable)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramXmlPullParser.length() != 0) {
        paramXmlPullParser = "Ignoring malformed cell resolution: ".concat(paramXmlPullParser);
      } else {
        paramXmlPullParser = new String("Ignoring malformed cell resolution: ");
      }
      u.h("TtmlDecoder", paramXmlPullParser);
    }
    return parama;
  }
  
  private static void F(String paramString, g paramg)
    throws SubtitleDecoderException
  {
    Object localObject = o0.E0(paramString, "\\s+");
    if (localObject.length == 1)
    {
      localObject = q.matcher(paramString);
    }
    else
    {
      if (localObject.length != 2) {
        break label337;
      }
      localObject = q.matcher(localObject[1]);
      u.h("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
    }
    if (((Matcher)localObject).matches())
    {
      paramString = (String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject).group(3));
      paramString.hashCode();
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 3592: 
        if (paramString.equals("px")) {
          i = 2;
        }
        break;
      case 3240: 
        if (paramString.equals("em")) {
          i = 1;
        }
        break;
      case 37: 
        if (paramString.equals("%")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramg = new StringBuilder(paramString.length() + 30);
        paramg.append("Invalid unit for fontSize: '");
        paramg.append(paramString);
        paramg.append("'.");
        throw new SubtitleDecoderException(paramg.toString());
      case 2: 
        paramg.z(1);
        break;
      case 1: 
        paramg.z(2);
        break;
      case 0: 
        paramg.z(3);
      }
      paramg.y(Float.parseFloat((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject).group(1))));
      return;
    }
    paramg = new StringBuilder(String.valueOf(paramString).length() + 36);
    paramg.append("Invalid expression for fontSize: '");
    paramg.append(paramString);
    paramg.append("'.");
    throw new SubtitleDecoderException(paramg.toString());
    label337:
    int i = localObject.length;
    paramString = new StringBuilder(52);
    paramString.append("Invalid number of entries for fontSize: ");
    paramString.append(i);
    paramString.append(".");
    throw new SubtitleDecoderException(paramString.toString());
  }
  
  private static b G(XmlPullParser paramXmlPullParser)
    throws SubtitleDecoderException
  {
    Object localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
    int i;
    if (localObject != null) {
      i = Integer.parseInt((String)localObject);
    } else {
      i = 30;
    }
    float f = 1.0F;
    localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
    if (localObject != null)
    {
      localObject = o0.E0((String)localObject, " ");
      if (localObject.length == 2) {
        f = Integer.parseInt(localObject[0]) / Integer.parseInt(localObject[1]);
      } else {
        throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
      }
    }
    b localb = v;
    int j = localb.b;
    localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
    if (localObject != null) {
      j = Integer.parseInt((String)localObject);
    }
    int k = localb.c;
    paramXmlPullParser = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
    if (paramXmlPullParser != null) {
      k = Integer.parseInt(paramXmlPullParser);
    }
    return new b(i * f, j, k);
  }
  
  private static Map<String, g> H(XmlPullParser paramXmlPullParser, Map<String, g> paramMap, a parama, @Nullable c paramc, Map<String, e> paramMap1, Map<String, String> paramMap2)
    throws IOException, XmlPullParserException
  {
    do
    {
      paramXmlPullParser.next();
      Object localObject2;
      if (p0.e(paramXmlPullParser, "style"))
      {
        Object localObject1 = p0.a(paramXmlPullParser, "style");
        localObject2 = M(paramXmlPullParser, new g());
        if (localObject1 != null)
        {
          localObject1 = N((String)localObject1);
          int i = localObject1.length;
          for (int j = 0; j < i; j++) {
            ((g)localObject2).a((g)paramMap.get(localObject1[j]));
          }
        }
        localObject1 = ((g)localObject2).g();
        if (localObject1 != null) {
          paramMap.put(localObject1, localObject2);
        }
      }
      else if (p0.e(paramXmlPullParser, "region"))
      {
        localObject2 = K(paramXmlPullParser, parama, paramc);
        if (localObject2 != null) {
          paramMap1.put(((e)localObject2).a, localObject2);
        }
      }
      else if (p0.e(paramXmlPullParser, "metadata"))
      {
        I(paramXmlPullParser, paramMap2);
      }
    } while (!p0.c(paramXmlPullParser, "head"));
    return paramMap;
  }
  
  private static void I(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
    throws IOException, XmlPullParserException
  {
    do
    {
      paramXmlPullParser.next();
      if (p0.e(paramXmlPullParser, "image"))
      {
        String str = p0.a(paramXmlPullParser, "id");
        if (str != null) {
          paramMap.put(str, paramXmlPullParser.nextText());
        }
      }
    } while (!p0.c(paramXmlPullParser, "metadata"));
  }
  
  private static d J(XmlPullParser paramXmlPullParser, @Nullable d paramd, Map<String, e> paramMap, b paramb)
    throws SubtitleDecoderException
  {
    int i = paramXmlPullParser.getAttributeCount();
    g localg = M(paramXmlPullParser, null);
    Object localObject1 = null;
    Object localObject2 = "";
    long l1 = -9223372036854775807L;
    long l2 = -9223372036854775807L;
    long l3 = -9223372036854775807L;
    Object localObject3 = localObject1;
    int j = 0;
    long l4;
    long l5;
    long l6;
    while (j < i)
    {
      Object localObject4 = paramXmlPullParser.getAttributeName(j);
      Object localObject5 = paramXmlPullParser.getAttributeValue(j);
      ((String)localObject4).hashCode();
      switch (((String)localObject4).hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  k = -1;
                  break;
                } while (!((String)localObject4).equals("backgroundImage"));
                k = 5;
                break;
              } while (!((String)localObject4).equals("style"));
              k = 4;
              break;
            } while (!((String)localObject4).equals("begin"));
            k = 3;
            break;
          } while (!((String)localObject4).equals("end"));
          k = 2;
          break;
        } while (!((String)localObject4).equals("dur"));
        k = 1;
        break;
      } while (!((String)localObject4).equals("region"));
      int k = 0;
      Object localObject6;
      switch (k)
      {
      default: 
        localObject6 = localObject3;
        localObject4 = localObject1;
        l4 = l1;
        l5 = l2;
        l6 = l3;
        break;
      case 5: 
        localObject6 = localObject3;
        localObject4 = localObject1;
        l4 = l1;
        l5 = l2;
        l6 = l3;
        if (((String)localObject5).startsWith("#"))
        {
          localObject4 = ((String)localObject5).substring(1);
          localObject6 = localObject3;
          l4 = l1;
          l5 = l2;
          l6 = l3;
        }
        break;
      case 4: 
        localObject5 = N((String)localObject5);
        localObject6 = localObject3;
        localObject4 = localObject1;
        l4 = l1;
        l5 = l2;
        l6 = l3;
        if (localObject5.length > 0)
        {
          localObject6 = localObject5;
          localObject4 = localObject1;
          l4 = l1;
          l5 = l2;
          l6 = l3;
        }
        break;
      case 3: 
        l4 = O((String)localObject5, paramb);
        l6 = l3;
        l5 = l2;
        localObject4 = localObject1;
        localObject6 = localObject3;
      }
      for (;;)
      {
        break;
        l5 = O((String)localObject5, paramb);
        localObject6 = localObject3;
        localObject4 = localObject1;
        l4 = l1;
        l6 = l3;
        continue;
        l6 = O((String)localObject5, paramb);
        localObject6 = localObject3;
        localObject4 = localObject1;
        l4 = l1;
        l5 = l2;
        continue;
        localObject6 = localObject3;
        localObject4 = localObject1;
        l4 = l1;
        l5 = l2;
        l6 = l3;
        if (paramMap.containsKey(localObject5))
        {
          localObject2 = localObject5;
          l6 = l3;
          l5 = l2;
          l4 = l1;
          localObject4 = localObject1;
          localObject6 = localObject3;
        }
      }
      j++;
      localObject3 = localObject6;
      localObject1 = localObject4;
      l1 = l4;
      l2 = l5;
      l3 = l6;
    }
    if (paramd != null)
    {
      long l7 = paramd.d;
      l4 = l1;
      l5 = l2;
      if (l7 != -9223372036854775807L)
      {
        l6 = l1;
        if (l1 != -9223372036854775807L) {
          l6 = l1 + l7;
        }
        l4 = l6;
        l5 = l2;
        if (l2 != -9223372036854775807L)
        {
          l5 = l2 + l7;
          l4 = l6;
        }
      }
    }
    else
    {
      l5 = l2;
      l4 = l1;
    }
    if (l5 == -9223372036854775807L) {
      if (l3 != -9223372036854775807L)
      {
        l1 = l4 + l3;
      }
      else if (paramd != null)
      {
        l1 = paramd.e;
        if (l1 != -9223372036854775807L) {
          break label739;
        }
      }
    }
    l1 = l5;
    label739:
    return d.c(paramXmlPullParser.getName(), l4, l1, localg, (String[])localObject3, (String)localObject2, (String)localObject1, paramd);
  }
  
  @Nullable
  private static e K(XmlPullParser paramXmlPullParser, a parama, @Nullable c paramc)
  {
    String str1 = p0.a(paramXmlPullParser, "id");
    if (str1 == null) {
      return null;
    }
    String str2 = p0.a(paramXmlPullParser, "origin");
    if (str2 != null)
    {
      Object localObject1 = s;
      Matcher localMatcher = ((Pattern)localObject1).matcher(str2);
      Object localObject2 = t;
      Object localObject3 = ((Pattern)localObject2).matcher(str2);
      float f1;
      float f2;
      if (localMatcher.matches())
      {
        try
        {
          f1 = Float.parseFloat((String)com.google.android.exoplayer2.util.g.e(localMatcher.group(1))) / 100.0F;
          f2 = Float.parseFloat((String)com.google.android.exoplayer2.util.g.e(localMatcher.group(2)));
          f2 /= 100.0F;
        }
        catch (NumberFormatException paramXmlPullParser)
        {
          if (str2.length() != 0) {
            paramXmlPullParser = "Ignoring region with malformed origin: ".concat(str2);
          } else {
            paramXmlPullParser = new String("Ignoring region with malformed origin: ");
          }
          u.h("TtmlDecoder", paramXmlPullParser);
          return null;
        }
      }
      else
      {
        if (!((Matcher)localObject3).matches()) {
          break label918;
        }
        if (paramc == null)
        {
          if (str2.length() != 0) {
            paramXmlPullParser = "Ignoring region with missing tts:extent: ".concat(str2);
          } else {
            paramXmlPullParser = new String("Ignoring region with missing tts:extent: ");
          }
          u.h("TtmlDecoder", paramXmlPullParser);
          return null;
        }
      }
      try
      {
        int i = Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject3).group(1)));
        int j = Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject3).group(2)));
        f1 = i / paramc.a;
        f2 = j;
        i = paramc.b;
        f2 /= i;
        localObject3 = p0.a(paramXmlPullParser, "extent");
        if (localObject3 != null)
        {
          localObject1 = ((Pattern)localObject1).matcher((CharSequence)localObject3);
          localObject2 = ((Pattern)localObject2).matcher((CharSequence)localObject3);
          float f3;
          float f4;
          if (((Matcher)localObject1).matches())
          {
            try
            {
              f3 = Float.parseFloat((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject1).group(1))) / 100.0F;
              f4 = Float.parseFloat((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject1).group(2)));
              f4 /= 100.0F;
            }
            catch (NumberFormatException paramXmlPullParser)
            {
              if (str2.length() != 0) {
                paramXmlPullParser = "Ignoring region with malformed extent: ".concat(str2);
              } else {
                paramXmlPullParser = new String("Ignoring region with malformed extent: ");
              }
              u.h("TtmlDecoder", paramXmlPullParser);
              return null;
            }
          }
          else
          {
            if (!((Matcher)localObject2).matches()) {
              break label829;
            }
            if (paramc == null)
            {
              if (str2.length() != 0) {
                paramXmlPullParser = "Ignoring region with missing tts:extent: ".concat(str2);
              } else {
                paramXmlPullParser = new String("Ignoring region with missing tts:extent: ");
              }
              u.h("TtmlDecoder", paramXmlPullParser);
              return null;
            }
          }
          try
          {
            j = Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject2).group(1)));
            i = Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject2).group(2)));
            f3 = j / paramc.a;
            f4 = i;
            i = paramc.b;
            f4 /= i;
            paramc = p0.a(paramXmlPullParser, "displayAlign");
            i = 0;
            if (paramc != null)
            {
              paramc = com.google.common.base.c.e(paramc);
              paramc.hashCode();
              if (!paramc.equals("center"))
              {
                if (paramc.equals("after"))
                {
                  f2 += f4;
                  j = 2;
                  break label590;
                }
              }
              else
              {
                f2 += f4 / 2.0F;
                j = 1;
                break label590;
              }
            }
            j = 0;
            label590:
            float f5 = 1.0F / parama.b;
            paramXmlPullParser = p0.a(paramXmlPullParser, "writingMode");
            if (paramXmlPullParser != null)
            {
              paramXmlPullParser = com.google.common.base.c.e(paramXmlPullParser);
              paramXmlPullParser.hashCode();
              switch (paramXmlPullParser.hashCode())
              {
              }
              do
              {
                do
                {
                  do
                  {
                    i = -1;
                    break;
                  } while (!paramXmlPullParser.equals("tbrl"));
                  i = 2;
                  break;
                } while (!paramXmlPullParser.equals("tblr"));
                i = 1;
                break;
              } while (!paramXmlPullParser.equals("tb"));
              switch (i)
              {
              default: 
                break;
              case 2: 
                i = 1;
                break;
              case 0: 
              case 1: 
                i = 2;
                break;
              }
            }
            i = Integer.MIN_VALUE;
            return new e(str1, f1, f2, 0, j, f3, f4, 1, f5, i);
          }
          catch (NumberFormatException paramXmlPullParser)
          {
            if (str2.length() != 0) {
              paramXmlPullParser = "Ignoring region with malformed extent: ".concat(str2);
            } else {
              paramXmlPullParser = new String("Ignoring region with malformed extent: ");
            }
            u.h("TtmlDecoder", paramXmlPullParser);
            return null;
          }
          label829:
          if (str2.length() != 0) {
            paramXmlPullParser = "Ignoring region with unsupported extent: ".concat(str2);
          } else {
            paramXmlPullParser = new String("Ignoring region with unsupported extent: ");
          }
          u.h("TtmlDecoder", paramXmlPullParser);
          return null;
        }
        u.h("TtmlDecoder", "Ignoring region without an extent");
        return null;
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        if (str2.length() != 0) {
          paramXmlPullParser = "Ignoring region with malformed origin: ".concat(str2);
        } else {
          paramXmlPullParser = new String("Ignoring region with malformed origin: ");
        }
        u.h("TtmlDecoder", paramXmlPullParser);
        return null;
      }
      label918:
      if (str2.length() != 0) {
        paramXmlPullParser = "Ignoring region with unsupported origin: ".concat(str2);
      } else {
        paramXmlPullParser = new String("Ignoring region with unsupported origin: ");
      }
      u.h("TtmlDecoder", paramXmlPullParser);
      return null;
    }
    u.h("TtmlDecoder", "Ignoring region without an origin");
    return null;
  }
  
  private static float L(String paramString)
  {
    Matcher localMatcher = r.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Invalid value for shear: ".concat(paramString);
      } else {
        paramString = new String("Invalid value for shear: ");
      }
      u.h("TtmlDecoder", paramString);
      return Float.MAX_VALUE;
    }
    try
    {
      float f = Math.min(100.0F, Math.max(-100.0F, Float.parseFloat((String)com.google.android.exoplayer2.util.g.e(localMatcher.group(1)))));
      return f;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Failed to parse shear: ".concat(paramString);
      } else {
        paramString = new String("Failed to parse shear: ");
      }
      u.i("TtmlDecoder", paramString, localNumberFormatException);
    }
    return Float.MAX_VALUE;
  }
  
  private static g M(XmlPullParser paramXmlPullParser, g paramg)
  {
    int i = paramXmlPullParser.getAttributeCount();
    int j = 0;
    Object localObject;
    for (g localg = paramg; j < i; localObject = paramg)
    {
      String str = paramXmlPullParser.getAttributeValue(j);
      paramg = paramXmlPullParser.getAttributeName(j);
      paramg.hashCode();
      int k = paramg.hashCode();
      int m = 5;
      int n = -1;
      switch (k)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    k = -1;
                                    break;
                                  } while (!paramg.equals("multiRowAlign"));
                                  k = 14;
                                  break;
                                } while (!paramg.equals("backgroundColor"));
                                k = 13;
                                break;
                              } while (!paramg.equals("rubyPosition"));
                              k = 12;
                              break;
                            } while (!paramg.equals("textEmphasis"));
                            k = 11;
                            break;
                          } while (!paramg.equals("fontSize"));
                          k = 10;
                          break;
                        } while (!paramg.equals("textCombine"));
                        k = 9;
                        break;
                      } while (!paramg.equals("shear"));
                      k = 8;
                      break;
                    } while (!paramg.equals("color"));
                    k = 7;
                    break;
                  } while (!paramg.equals("ruby"));
                  k = 6;
                  break;
                } while (!paramg.equals("id"));
                k = 5;
                break;
              } while (!paramg.equals("fontWeight"));
              k = 4;
              break;
            } while (!paramg.equals("textDecoration"));
            k = 3;
            break;
          } while (!paramg.equals("textAlign"));
          k = 2;
          break;
        } while (!paramg.equals("fontFamily"));
        k = 1;
        break;
      } while (!paramg.equals("fontStyle"));
      k = 0;
      switch (k)
      {
      default: 
        paramg = localg;
        break;
      case 14: 
        paramg = B(localg).D(D(str));
        break;
      case 13: 
        localg = B(localg);
        try
        {
          localg.u(j.c(str));
          paramg = localg;
        }
        catch (IllegalArgumentException paramg)
        {
          paramg = String.valueOf(str);
          if (paramg.length() != 0) {
            paramg = "Failed parsing background value: ".concat(paramg);
          } else {
            paramg = new String("Failed parsing background value: ");
          }
          u.h("TtmlDecoder", paramg);
          paramg = localg;
        }
      case 12: 
        paramg = com.google.common.base.c.e(str);
        paramg.hashCode();
        if (!paramg.equals("before"))
        {
          if (!paramg.equals("after")) {
            paramg = localg;
          } else {
            paramg = B(localg).E(2);
          }
        }
        else {
          paramg = B(localg).E(1);
        }
        break;
      case 11: 
        paramg = B(localg).J(b.a(str));
        break;
      case 10: 
        paramg = localg;
        try
        {
          localg = B(localg);
          paramg = localg;
          F(str, localg);
          paramg = localg;
        }
        catch (SubtitleDecoderException localSubtitleDecoderException)
        {
          localObject = String.valueOf(str);
          if (((String)localObject).length() != 0) {
            localObject = "Failed parsing fontSize value: ".concat((String)localObject);
          } else {
            localObject = new String("Failed parsing fontSize value: ");
          }
          u.h("TtmlDecoder", (String)localObject);
        }
      case 9: 
        paramg = com.google.common.base.c.e(str);
        paramg.hashCode();
        if (!paramg.equals("all"))
        {
          if (!paramg.equals("none")) {
            paramg = (g)localObject;
          } else {
            paramg = B((g)localObject).I(false);
          }
        }
        else {
          paramg = B((g)localObject).I(true);
        }
        break;
      case 8: 
        paramg = B((g)localObject).G(L(str));
        break;
      case 7: 
        localObject = B((g)localObject);
        try
        {
          ((g)localObject).w(j.c(str));
          paramg = (g)localObject;
        }
        catch (IllegalArgumentException paramg)
        {
          paramg = String.valueOf(str);
          if (paramg.length() != 0) {
            paramg = "Failed parsing color value: ".concat(paramg);
          } else {
            paramg = new String("Failed parsing color value: ");
          }
          u.h("TtmlDecoder", paramg);
          paramg = (g)localObject;
        }
      case 6: 
        paramg = com.google.common.base.c.e(str);
        paramg.hashCode();
        switch (paramg.hashCode())
        {
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  k = -1;
                  break;
                  k = m;
                  if (paramg.equals("text")) {
                    break;
                  }
                } while ((goto 1036) || (!paramg.equals("base")));
                k = 4;
                break;
              } while (!paramg.equals("textContainer"));
              k = 3;
              break;
            } while (!paramg.equals("delimiter"));
            k = 2;
            break;
          } while (!paramg.equals("container"));
          k = 1;
          break;
        } while (!paramg.equals("baseContainer"));
        k = 0;
        switch (k)
        {
        default: 
          paramg = (g)localObject;
          break;
        case 3: 
        case 5: 
          paramg = B((g)localObject).F(3);
          break;
        case 2: 
          paramg = B((g)localObject).F(4);
          break;
        case 1: 
          paramg = B((g)localObject).F(1);
          break;
        case 0: 
        case 4: 
          paramg = B((g)localObject).F(2);
        }
        break;
      case 5: 
        paramg = (g)localObject;
        if ("style".equals(paramXmlPullParser.getName())) {
          paramg = B((g)localObject).A(str);
        }
        break;
      case 4: 
        paramg = B((g)localObject).v("bold".equalsIgnoreCase(str));
        break;
      case 3: 
        paramg = com.google.common.base.c.e(str);
        paramg.hashCode();
        switch (paramg.hashCode())
        {
        default: 
          k = n;
          break;
        case 1679736913: 
          if (!paramg.equals("linethrough")) {
            k = n;
          } else {
            k = 3;
          }
          break;
        case 913457136: 
          if (!paramg.equals("nolinethrough")) {
            k = n;
          } else {
            k = 2;
          }
          break;
        case -1026963764: 
          if (!paramg.equals("underline")) {
            k = n;
          } else {
            k = 1;
          }
          break;
        case -1461280213: 
          if (!paramg.equals("nounderline")) {
            k = n;
          } else {
            k = 0;
          }
          break;
        }
        switch (k)
        {
        default: 
          paramg = (g)localObject;
          break;
        case 3: 
          paramg = B((g)localObject).C(true);
          break;
        case 2: 
          paramg = B((g)localObject).C(false);
          break;
        case 1: 
          paramg = B((g)localObject).K(true);
          break;
        case 0: 
          paramg = B((g)localObject).K(false);
        }
        break;
      case 2: 
        paramg = B((g)localObject).H(D(str));
        break;
      case 1: 
        paramg = B((g)localObject).x(str);
        break;
      case 0: 
        paramg = B((g)localObject).B("italic".equalsIgnoreCase(str));
      }
      j++;
    }
    return (g)localObject;
  }
  
  private static String[] N(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.isEmpty()) {
      paramString = new String[0];
    } else {
      paramString = o0.E0(paramString, "\\s+");
    }
    return paramString;
  }
  
  private static long O(String paramString, b paramb)
    throws SubtitleDecoderException
  {
    Matcher localMatcher = o.matcher(paramString);
    boolean bool = localMatcher.matches();
    int i = 4;
    double d5;
    double d6;
    if (bool)
    {
      double d1 = Long.parseLong((String)com.google.android.exoplayer2.util.g.e(localMatcher.group(1))) * 3600L;
      double d2 = Long.parseLong((String)com.google.android.exoplayer2.util.g.e(localMatcher.group(2))) * 60L;
      double d3 = Long.parseLong((String)com.google.android.exoplayer2.util.g.e(localMatcher.group(3)));
      paramString = localMatcher.group(4);
      double d4 = 0.0D;
      if (paramString != null) {
        d5 = Double.parseDouble(paramString);
      } else {
        d5 = 0.0D;
      }
      paramString = localMatcher.group(5);
      if (paramString != null) {
        d6 = (float)Long.parseLong(paramString) / paramb.a;
      } else {
        d6 = 0.0D;
      }
      paramString = localMatcher.group(6);
      if (paramString != null) {
        d4 = Long.parseLong(paramString) / paramb.b / paramb.a;
      }
      return ((d1 + d2 + d3 + d5 + d6 + d4) * 1000000.0D);
    }
    localMatcher = p.matcher(paramString);
    if (localMatcher.matches())
    {
      d6 = Double.parseDouble((String)com.google.android.exoplayer2.util.g.e(localMatcher.group(1)));
      paramString = (String)com.google.android.exoplayer2.util.g.e(localMatcher.group(2));
      paramString.hashCode();
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              i = -1;
              break;
              if (paramString.equals("ms")) {
                break;
              }
            } while ((goto 288) || (!paramString.equals("t")));
            i = 3;
            break;
          } while (!paramString.equals("m"));
          i = 2;
          break;
        } while (!paramString.equals("h"));
        i = 1;
        break;
      } while (!paramString.equals("f"));
      i = 0;
      switch (i)
      {
      default: 
        d5 = d6;
        break;
      case 4: 
        d5 = 1000.0D;
      case 3: 
      case 2: 
      case 1: 
      case 0: 
        for (;;)
        {
          d5 = d6 / d5;
          break;
          d5 = paramb.c;
          continue;
          d5 = 60.0D;
          break label461;
          d5 = 3600.0D;
          label461:
          d5 = d6 * d5;
          break;
          d5 = paramb.a;
        }
      }
      return (d5 * 1000000.0D);
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Malformed time expression: ".concat(paramString);
    } else {
      paramString = new String("Malformed time expression: ");
    }
    throw new SubtitleDecoderException(paramString);
  }
  
  @Nullable
  private static c P(XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser = p0.a(paramXmlPullParser, "extent");
    if (paramXmlPullParser == null) {
      return null;
    }
    Object localObject = t.matcher(paramXmlPullParser);
    if (!((Matcher)localObject).matches())
    {
      if (paramXmlPullParser.length() != 0) {
        paramXmlPullParser = "Ignoring non-pixel tts extent: ".concat(paramXmlPullParser);
      } else {
        paramXmlPullParser = new String("Ignoring non-pixel tts extent: ");
      }
      u.h("TtmlDecoder", paramXmlPullParser);
      return null;
    }
    try
    {
      localObject = new c(Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject).group(1))), Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(((Matcher)localObject).group(2))));
      return (c)localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramXmlPullParser.length() != 0) {
        paramXmlPullParser = "Ignoring malformed tts extent: ".concat(paramXmlPullParser);
      } else {
        paramXmlPullParser = new String("Ignoring malformed tts extent: ");
      }
      u.h("TtmlDecoder", paramXmlPullParser);
    }
    return null;
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws SubtitleDecoderException
  {
    try
    {
      XmlPullParser localXmlPullParser = this.x.newPullParser();
      HashMap localHashMap1 = new java/util/HashMap;
      localHashMap1.<init>();
      HashMap localHashMap2 = new java/util/HashMap;
      localHashMap2.<init>();
      HashMap localHashMap3 = new java/util/HashMap;
      localHashMap3.<init>();
      Object localObject1 = new com/google/android/exoplayer2/text/s/e;
      ((e)localObject1).<init>("");
      localHashMap2.put("", localObject1);
      localObject1 = new java/io/ByteArrayInputStream;
      ((ByteArrayInputStream)localObject1).<init>(paramArrayOfByte, 0, paramInt);
      Object localObject2 = null;
      localXmlPullParser.setInput((InputStream)localObject1, null);
      ArrayDeque localArrayDeque = new java/util/ArrayDeque;
      localArrayDeque.<init>();
      int i = localXmlPullParser.getEventType();
      paramArrayOfByte = v;
      Object localObject3 = w;
      localObject1 = null;
      int j = 0;
      while (i != 1)
      {
        Object localObject4 = (d)localArrayDeque.peek();
        Object localObject6;
        Object localObject7;
        Object localObject8;
        Object localObject5;
        if (j == 0)
        {
          localObject6 = localXmlPullParser.getName();
          if (i == 2)
          {
            if ("tt".equals(localObject6))
            {
              paramArrayOfByte = G(localXmlPullParser);
              localObject3 = E(localXmlPullParser, w);
              localObject2 = P(localXmlPullParser);
            }
            paramBoolean = C((String)localObject6);
            if (!paramBoolean)
            {
              localObject4 = String.valueOf(localXmlPullParser.getName());
              if (((String)localObject4).length() != 0) {
                localObject4 = "Ignoring unsupported tag: ".concat((String)localObject4);
              } else {
                localObject4 = new String("Ignoring unsupported tag: ");
              }
              u.f("TtmlDecoder", (String)localObject4);
              paramInt = j + 1;
            }
            else if ("head".equals(localObject6))
            {
              H(localXmlPullParser, localHashMap1, (a)localObject3, (c)localObject2, localHashMap2, localHashMap3);
              paramInt = j;
            }
            try
            {
              localObject6 = J(localXmlPullParser, (d)localObject4, localHashMap2, paramArrayOfByte);
              localArrayDeque.push(localObject6);
              paramInt = j;
              if (localObject4 != null)
              {
                ((d)localObject4).a((d)localObject6);
                paramInt = j;
              }
            }
            catch (SubtitleDecoderException localSubtitleDecoderException)
            {
              for (;;)
              {
                u.i("TtmlDecoder", "Suppressing parser error", localSubtitleDecoderException);
                paramInt = j + 1;
              }
            }
            localObject4 = localObject2;
            localObject6 = paramArrayOfByte;
            localObject7 = localObject3;
            localObject8 = localObject1;
          }
          else if (i == 4)
          {
            ((d)com.google.android.exoplayer2.util.g.e(localSubtitleDecoderException)).a(d.d(localXmlPullParser.getText()));
            localObject5 = localObject2;
            localObject6 = paramArrayOfByte;
            localObject7 = localObject3;
            paramInt = j;
            localObject8 = localObject1;
          }
          else
          {
            localObject5 = localObject2;
            localObject6 = paramArrayOfByte;
            localObject7 = localObject3;
            paramInt = j;
            localObject8 = localObject1;
            if (i == 3)
            {
              if (localXmlPullParser.getName().equals("tt"))
              {
                localObject1 = new com/google/android/exoplayer2/text/s/h;
                ((h)localObject1).<init>((d)com.google.android.exoplayer2.util.g.e((d)localArrayDeque.peek()), localHashMap1, localHashMap2, localHashMap3);
              }
              localArrayDeque.pop();
              localObject5 = localObject2;
              localObject6 = paramArrayOfByte;
              localObject7 = localObject3;
              paramInt = j;
              localObject8 = localObject1;
            }
          }
        }
        else if (i == 2)
        {
          paramInt = j + 1;
          localObject5 = localObject2;
          localObject6 = paramArrayOfByte;
          localObject7 = localObject3;
          localObject8 = localObject1;
        }
        else
        {
          localObject5 = localObject2;
          localObject6 = paramArrayOfByte;
          localObject7 = localObject3;
          paramInt = j;
          localObject8 = localObject1;
          if (i == 3)
          {
            paramInt = j - 1;
            localObject8 = localObject1;
            localObject7 = localObject3;
            localObject6 = paramArrayOfByte;
            localObject5 = localObject2;
          }
        }
        localXmlPullParser.next();
        i = localXmlPullParser.getEventType();
        localObject2 = localObject5;
        paramArrayOfByte = (byte[])localObject6;
        localObject3 = localObject7;
        j = paramInt;
        localObject1 = localObject8;
      }
      if (localObject1 != null) {
        return (f)localObject1;
      }
      paramArrayOfByte = new com/google/android/exoplayer2/text/SubtitleDecoderException;
      paramArrayOfByte.<init>("No TTML subtitles found");
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new IllegalStateException("Unexpected error when reading input.", paramArrayOfByte);
    }
    catch (XmlPullParserException paramArrayOfByte)
    {
      throw new SubtitleDecoderException("Unable to decode source", paramArrayOfByte);
    }
  }
  
  private static final class a
  {
    final int a;
    final int b;
    
    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
  
  private static final class b
  {
    final float a;
    final int b;
    final int c;
    
    b(float paramFloat, int paramInt1, int paramInt2)
    {
      this.a = paramFloat;
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }
  
  private static final class c
  {
    final int a;
    final int b;
    
    c(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\s\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */