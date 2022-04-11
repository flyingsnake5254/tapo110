package com.google.android.exoplayer2.util;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import com.google.common.base.c;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
{
  private static final Pattern a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
  private static final Pattern b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
  private static final Pattern c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
  private static final Map<String, Integer> d;
  
  static
  {
    HashMap localHashMap = new HashMap();
    d = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    localHashMap.put("antiquewhite", Integer.valueOf(-332841));
    Integer localInteger1 = Integer.valueOf(-16711681);
    localHashMap.put("aqua", localInteger1);
    localHashMap.put("aquamarine", Integer.valueOf(-8388652));
    localHashMap.put("azure", Integer.valueOf(-983041));
    localHashMap.put("beige", Integer.valueOf(-657956));
    localHashMap.put("bisque", Integer.valueOf(58564));
    localHashMap.put("black", Integer.valueOf(-16777216));
    localHashMap.put("blanchedalmond", Integer.valueOf(60365));
    localHashMap.put("blue", Integer.valueOf(-16776961));
    localHashMap.put("blueviolet", Integer.valueOf(-7722014));
    localHashMap.put("brown", Integer.valueOf(-5952982));
    localHashMap.put("burlywood", Integer.valueOf(-2180985));
    localHashMap.put("cadetblue", Integer.valueOf(-10510688));
    localHashMap.put("chartreuse", Integer.valueOf(-8388864));
    localHashMap.put("chocolate", Integer.valueOf(-2987746));
    localHashMap.put("coral", Integer.valueOf(-32944));
    localHashMap.put("cornflowerblue", Integer.valueOf(-10185235));
    localHashMap.put("cornsilk", Integer.valueOf(63708));
    localHashMap.put("crimson", Integer.valueOf(-2354116));
    localHashMap.put("cyan", localInteger1);
    localHashMap.put("darkblue", Integer.valueOf(-16777077));
    localHashMap.put("darkcyan", Integer.valueOf(-16741493));
    localHashMap.put("darkgoldenrod", Integer.valueOf(-4684277));
    localInteger1 = Integer.valueOf(-5658199);
    localHashMap.put("darkgray", localInteger1);
    localHashMap.put("darkgreen", Integer.valueOf(-16751616));
    localHashMap.put("darkgrey", localInteger1);
    localHashMap.put("darkkhaki", Integer.valueOf(-4343957));
    localHashMap.put("darkmagenta", Integer.valueOf(-7667573));
    localHashMap.put("darkolivegreen", Integer.valueOf(-11179217));
    localHashMap.put("darkorange", Integer.valueOf(35840));
    localHashMap.put("darkorchid", Integer.valueOf(-6737204));
    localHashMap.put("darkred", Integer.valueOf(-7667712));
    localHashMap.put("darksalmon", Integer.valueOf(-1468806));
    localHashMap.put("darkseagreen", Integer.valueOf(-7357297));
    localHashMap.put("darkslateblue", Integer.valueOf(-12042869));
    localInteger1 = Integer.valueOf(-13676721);
    localHashMap.put("darkslategray", localInteger1);
    localHashMap.put("darkslategrey", localInteger1);
    localHashMap.put("darkturquoise", Integer.valueOf(-16724271));
    localHashMap.put("darkviolet", Integer.valueOf(-7077677));
    localHashMap.put("deeppink", Integer.valueOf(-60269));
    localHashMap.put("deepskyblue", Integer.valueOf(-16728065));
    localInteger1 = Integer.valueOf(-9868951);
    localHashMap.put("dimgray", localInteger1);
    localHashMap.put("dimgrey", localInteger1);
    localHashMap.put("dodgerblue", Integer.valueOf(-14774017));
    localHashMap.put("firebrick", Integer.valueOf(-5103070));
    localHashMap.put("floralwhite", Integer.valueOf(64240));
    localHashMap.put("forestgreen", Integer.valueOf(-14513374));
    localInteger1 = Integer.valueOf(-65281);
    localHashMap.put("fuchsia", localInteger1);
    localHashMap.put("gainsboro", Integer.valueOf(-2302756));
    localHashMap.put("ghostwhite", Integer.valueOf(-460545));
    localHashMap.put("gold", Integer.valueOf(55040));
    localHashMap.put("goldenrod", Integer.valueOf(-2448096));
    Integer localInteger2 = Integer.valueOf(-8355712);
    localHashMap.put("gray", localInteger2);
    localHashMap.put("green", Integer.valueOf(-16744448));
    localHashMap.put("greenyellow", Integer.valueOf(-5374161));
    localHashMap.put("grey", localInteger2);
    localHashMap.put("honeydew", Integer.valueOf(-983056));
    localHashMap.put("hotpink", Integer.valueOf(-38476));
    localHashMap.put("indianred", Integer.valueOf(-3318692));
    localHashMap.put("indigo", Integer.valueOf(-11861886));
    localHashMap.put("ivory", Integer.valueOf(-16));
    localHashMap.put("khaki", Integer.valueOf(-989556));
    localHashMap.put("lavender", Integer.valueOf(-1644806));
    localHashMap.put("lavenderblush", Integer.valueOf(61685));
    localHashMap.put("lawngreen", Integer.valueOf(-8586240));
    localHashMap.put("lemonchiffon", Integer.valueOf(64205));
    localHashMap.put("lightblue", Integer.valueOf(-5383962));
    localHashMap.put("lightcoral", Integer.valueOf(-1015680));
    localHashMap.put("lightcyan", Integer.valueOf(-2031617));
    localHashMap.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    localInteger2 = Integer.valueOf(-2894893);
    localHashMap.put("lightgray", localInteger2);
    localHashMap.put("lightgreen", Integer.valueOf(-7278960));
    localHashMap.put("lightgrey", localInteger2);
    localHashMap.put("lightpink", Integer.valueOf(46785));
    localHashMap.put("lightsalmon", Integer.valueOf(41082));
    localHashMap.put("lightseagreen", Integer.valueOf(-14634326));
    localHashMap.put("lightskyblue", Integer.valueOf(-7876870));
    localInteger2 = Integer.valueOf(-8943463);
    localHashMap.put("lightslategray", localInteger2);
    localHashMap.put("lightslategrey", localInteger2);
    localHashMap.put("lightsteelblue", Integer.valueOf(-5192482));
    localHashMap.put("lightyellow", Integer.valueOf(-32));
    localHashMap.put("lime", Integer.valueOf(-16711936));
    localHashMap.put("limegreen", Integer.valueOf(-13447886));
    localHashMap.put("linen", Integer.valueOf(-331546));
    localHashMap.put("magenta", localInteger1);
    localHashMap.put("maroon", Integer.valueOf(-8388608));
    localHashMap.put("mediumaquamarine", Integer.valueOf(-10039894));
    localHashMap.put("mediumblue", Integer.valueOf(-16777011));
    localHashMap.put("mediumorchid", Integer.valueOf(-4565549));
    localHashMap.put("mediumpurple", Integer.valueOf(-7114533));
    localHashMap.put("mediumseagreen", Integer.valueOf(-12799119));
    localHashMap.put("mediumslateblue", Integer.valueOf(-8689426));
    localHashMap.put("mediumspringgreen", Integer.valueOf(-16713062));
    localHashMap.put("mediumturquoise", Integer.valueOf(-12004916));
    localHashMap.put("mediumvioletred", Integer.valueOf(-3730043));
    localHashMap.put("midnightblue", Integer.valueOf(-15132304));
    localHashMap.put("mintcream", Integer.valueOf(-655366));
    localHashMap.put("mistyrose", Integer.valueOf(58593));
    localHashMap.put("moccasin", Integer.valueOf(58549));
    localHashMap.put("navajowhite", Integer.valueOf(57005));
    localHashMap.put("navy", Integer.valueOf(-16777088));
    localHashMap.put("oldlace", Integer.valueOf(-133658));
    localHashMap.put("olive", Integer.valueOf(-8355840));
    localHashMap.put("olivedrab", Integer.valueOf(-9728477));
    localHashMap.put("orange", Integer.valueOf(42240));
    localHashMap.put("orangered", Integer.valueOf(-47872));
    localHashMap.put("orchid", Integer.valueOf(-2461482));
    localHashMap.put("palegoldenrod", Integer.valueOf(-1120086));
    localHashMap.put("palegreen", Integer.valueOf(-6751336));
    localHashMap.put("paleturquoise", Integer.valueOf(-5247250));
    localHashMap.put("palevioletred", Integer.valueOf(-2396013));
    localHashMap.put("papayawhip", Integer.valueOf(61397));
    localHashMap.put("peachpuff", Integer.valueOf(55993));
    localHashMap.put("peru", Integer.valueOf(-3308225));
    localHashMap.put("pink", Integer.valueOf(49355));
    localHashMap.put("plum", Integer.valueOf(-2252579));
    localHashMap.put("powderblue", Integer.valueOf(-5185306));
    localHashMap.put("purple", Integer.valueOf(-8388480));
    localHashMap.put("rebeccapurple", Integer.valueOf(-10079335));
    localHashMap.put("red", Integer.valueOf(-65536));
    localHashMap.put("rosybrown", Integer.valueOf(-4419697));
    localHashMap.put("royalblue", Integer.valueOf(-12490271));
    localHashMap.put("saddlebrown", Integer.valueOf(-7650029));
    localHashMap.put("salmon", Integer.valueOf(-360334));
    localHashMap.put("sandybrown", Integer.valueOf(-744352));
    localHashMap.put("seagreen", Integer.valueOf(-13726889));
    localHashMap.put("seashell", Integer.valueOf(62958));
    localHashMap.put("sienna", Integer.valueOf(-6270419));
    localHashMap.put("silver", Integer.valueOf(-4144960));
    localHashMap.put("skyblue", Integer.valueOf(-7876885));
    localHashMap.put("slateblue", Integer.valueOf(-9807155));
    localInteger1 = Integer.valueOf(-9404272);
    localHashMap.put("slategray", localInteger1);
    localHashMap.put("slategrey", localInteger1);
    localHashMap.put("snow", Integer.valueOf(64250));
    localHashMap.put("springgreen", Integer.valueOf(-16711809));
    localHashMap.put("steelblue", Integer.valueOf(-12156236));
    localHashMap.put("tan", Integer.valueOf(-2968436));
    localHashMap.put("teal", Integer.valueOf(-16744320));
    localHashMap.put("thistle", Integer.valueOf(-2572328));
    localHashMap.put("tomato", Integer.valueOf(-40121));
    localHashMap.put("transparent", Integer.valueOf(0));
    localHashMap.put("turquoise", Integer.valueOf(-12525360));
    localHashMap.put("violet", Integer.valueOf(-1146130));
    localHashMap.put("wheat", Integer.valueOf(-663885));
    localHashMap.put("white", Integer.valueOf(-1));
    localHashMap.put("whitesmoke", Integer.valueOf(-657931));
    localHashMap.put("yellow", Integer.valueOf(65280));
    localHashMap.put("yellowgreen", Integer.valueOf(-6632142));
  }
  
  @ColorInt
  private static int a(String paramString, boolean paramBoolean)
  {
    g.a(TextUtils.isEmpty(paramString) ^ true);
    String str = paramString.replace(" ", "");
    int i;
    if (str.charAt(0) == '#')
    {
      i = (int)Long.parseLong(str.substring(1), 16);
      if (str.length() == 7)
      {
        i = 0xFF000000 | i;
      }
      else
      {
        if (str.length() != 9) {
          break label84;
        }
        i = (i & 0xFF) << 24 | i >>> 8;
      }
      return i;
      label84:
      throw new IllegalArgumentException();
    }
    if (str.startsWith("rgba"))
    {
      if (paramBoolean) {
        paramString = c;
      } else {
        paramString = b;
      }
      paramString = paramString.matcher(str);
      if (paramString.matches())
      {
        if (paramBoolean) {
          i = (int)(Float.parseFloat((String)g.e(paramString.group(4))) * 255.0F);
        } else {
          i = Integer.parseInt((String)g.e(paramString.group(4)), 10);
        }
        return Color.argb(i, Integer.parseInt((String)g.e(paramString.group(1)), 10), Integer.parseInt((String)g.e(paramString.group(2)), 10), Integer.parseInt((String)g.e(paramString.group(3)), 10));
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = a.matcher(str);
      if (paramString.matches()) {
        return Color.rgb(Integer.parseInt((String)g.e(paramString.group(1)), 10), Integer.parseInt((String)g.e(paramString.group(2)), 10), Integer.parseInt((String)g.e(paramString.group(3)), 10));
      }
    }
    else
    {
      paramString = (Integer)d.get(c.e(str));
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    throw new IllegalArgumentException();
  }
  
  @ColorInt
  public static int b(String paramString)
  {
    return a(paramString, true);
  }
  
  @ColorInt
  public static int c(String paramString)
  {
    return a(paramString, false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */