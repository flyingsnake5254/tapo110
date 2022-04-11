package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.audio.m;
import com.google.common.base.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class y
{
  private static final ArrayList<a> a = new ArrayList();
  private static final Pattern b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");
  
  public static boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    boolean bool1 = false;
    if (paramString1 == null) {
      return false;
    }
    int i = -1;
    switch (paramString1.hashCode())
    {
    default: 
      break;
    case 1903589369: 
      if (paramString1.equals("audio/g711-mlaw")) {
        i = 10;
      }
      break;
    case 1903231877: 
      if (paramString1.equals("audio/g711-alaw")) {
        i = 9;
      }
      break;
    case 1504831518: 
      if (paramString1.equals("audio/mpeg")) {
        i = 8;
      }
      break;
    case 1504619009: 
      if (paramString1.equals("audio/flac")) {
        i = 7;
      }
      break;
    case 1504578661: 
      if (paramString1.equals("audio/eac3")) {
        i = 6;
      }
      break;
    case 187094639: 
      if (paramString1.equals("audio/raw")) {
        i = 5;
      }
      break;
    case 187078296: 
      if (paramString1.equals("audio/ac3")) {
        i = 4;
      }
      break;
    case -53558318: 
      if (paramString1.equals("audio/mp4a-latm")) {
        i = 3;
      }
      break;
    case -432837259: 
      if (paramString1.equals("audio/mpeg-L2")) {
        i = 2;
      }
      break;
    case -432837260: 
      if (paramString1.equals("audio/mpeg-L1")) {
        i = 1;
      }
      break;
    case -2123537834: 
      if (paramString1.equals("audio/eac3-joc")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return false;
    case 3: 
      if (paramString2 == null) {
        return false;
      }
      paramString1 = i(paramString2);
      if (paramString1 == null) {
        return false;
      }
      i = m.c(paramString1.b);
      boolean bool2 = bool1;
      if (i != 0)
      {
        bool2 = bool1;
        if (i != 16) {
          bool2 = true;
        }
      }
      return bool2;
    }
    return true;
  }
  
  public static boolean b(@Nullable String paramString1, String paramString2)
  {
    boolean bool;
    if (d(paramString1, paramString2) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  public static String c(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String[] arrayOfString = o0.G0(paramString);
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      paramString = g(arrayOfString[j]);
      if ((paramString != null) && (o(paramString))) {
        return paramString;
      }
    }
    return null;
  }
  
  @Nullable
  public static String d(@Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramString1 != null) {
      if (paramString2 == null)
      {
        localObject2 = localObject1;
      }
      else
      {
        String[] arrayOfString = o0.G0(paramString1);
        paramString1 = new StringBuilder();
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          localObject2 = arrayOfString[j];
          if (paramString2.equals(g((String)localObject2)))
          {
            if (paramString1.length() > 0) {
              paramString1.append(",");
            }
            paramString1.append((String)localObject2);
          }
        }
        localObject2 = localObject1;
        if (paramString1.length() > 0) {
          localObject2 = paramString1.toString();
        }
      }
    }
    return (String)localObject2;
  }
  
  @Nullable
  private static String e(String paramString)
  {
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      a locala = (a)a.get(j);
      if (paramString.startsWith(locala.b)) {
        return locala.a;
      }
    }
    return null;
  }
  
  public static int f(String paramString1, @Nullable String paramString2)
  {
    paramString1.hashCode();
    int i = paramString1.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1556697186: 
      if (paramString1.equals("audio/true-hd")) {
        j = 8;
      }
      break;
    case 1505942594: 
      if (paramString1.equals("audio/vnd.dts.hd")) {
        j = 7;
      }
      break;
    case 1504831518: 
      if (paramString1.equals("audio/mpeg")) {
        j = 6;
      }
      break;
    case 1504578661: 
      if (paramString1.equals("audio/eac3")) {
        j = 5;
      }
      break;
    case 187078297: 
      if (paramString1.equals("audio/ac4")) {
        j = 4;
      }
      break;
    case 187078296: 
      if (paramString1.equals("audio/ac3")) {
        j = 3;
      }
      break;
    case -53558318: 
      if (paramString1.equals("audio/mp4a-latm")) {
        j = 2;
      }
      break;
    case -1095064472: 
      if (paramString1.equals("audio/vnd.dts")) {
        j = 1;
      }
      break;
    case -2123537834: 
      if (paramString1.equals("audio/eac3-joc")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return 0;
    case 8: 
      return 14;
    case 7: 
      return 8;
    case 6: 
      return 9;
    case 5: 
      return 6;
    case 4: 
      return 17;
    case 3: 
      return 5;
    case 2: 
      if (paramString2 == null) {
        return 0;
      }
      paramString1 = i(paramString2);
      if (paramString1 == null) {
        return 0;
      }
      return m.c(paramString1.b);
    case 1: 
      return 7;
    }
    return 18;
  }
  
  @Nullable
  public static String g(@Nullable String paramString)
  {
    String str = null;
    if (paramString == null) {
      return null;
    }
    Object localObject = c.e(paramString.trim());
    if ((!((String)localObject).startsWith("avc1")) && (!((String)localObject).startsWith("avc3")))
    {
      if ((!((String)localObject).startsWith("hev1")) && (!((String)localObject).startsWith("hvc1")))
      {
        if ((!((String)localObject).startsWith("dvav")) && (!((String)localObject).startsWith("dva1")) && (!((String)localObject).startsWith("dvhe")) && (!((String)localObject).startsWith("dvh1")))
        {
          if (((String)localObject).startsWith("av01")) {
            return "video/av01";
          }
          if ((!((String)localObject).startsWith("vp9")) && (!((String)localObject).startsWith("vp09")))
          {
            if ((!((String)localObject).startsWith("vp8")) && (!((String)localObject).startsWith("vp08")))
            {
              if (((String)localObject).startsWith("mp4a"))
              {
                paramString = str;
                if (((String)localObject).startsWith("mp4a."))
                {
                  localObject = i((String)localObject);
                  paramString = str;
                  if (localObject != null) {
                    paramString = h(((b)localObject).a);
                  }
                }
                str = paramString;
                if (paramString == null) {
                  str = "audio/mp4a-latm";
                }
                return str;
              }
              if (((String)localObject).startsWith("mha1")) {
                return "audio/mha1";
              }
              if (((String)localObject).startsWith("mhm1")) {
                return "audio/mhm1";
              }
              if ((!((String)localObject).startsWith("ac-3")) && (!((String)localObject).startsWith("dac3")))
              {
                if ((!((String)localObject).startsWith("ec-3")) && (!((String)localObject).startsWith("dec3")))
                {
                  if (((String)localObject).startsWith("ec+3")) {
                    return "audio/eac3-joc";
                  }
                  if ((!((String)localObject).startsWith("ac-4")) && (!((String)localObject).startsWith("dac4")))
                  {
                    if (((String)localObject).startsWith("dtsc")) {
                      return "audio/vnd.dts";
                    }
                    if (((String)localObject).startsWith("dtse")) {
                      return "audio/vnd.dts.hd;profile=lbr";
                    }
                    if ((!((String)localObject).startsWith("dtsh")) && (!((String)localObject).startsWith("dtsl")))
                    {
                      if (((String)localObject).startsWith("dtsx")) {
                        return "audio/vnd.dts.uhd";
                      }
                      if (((String)localObject).startsWith("opus")) {
                        return "audio/opus";
                      }
                      if (((String)localObject).startsWith("vorbis")) {
                        return "audio/vorbis";
                      }
                      if (((String)localObject).startsWith("flac")) {
                        return "audio/flac";
                      }
                      if (((String)localObject).startsWith("stpp")) {
                        return "application/ttml+xml";
                      }
                      if (((String)localObject).startsWith("wvtt")) {
                        return "text/vtt";
                      }
                      if (((String)localObject).contains("cea708")) {
                        return "application/cea-708";
                      }
                      if ((!((String)localObject).contains("eia608")) && (!((String)localObject).contains("cea608"))) {
                        return e((String)localObject);
                      }
                      return "application/cea-608";
                    }
                    return "audio/vnd.dts.hd";
                  }
                  return "audio/ac4";
                }
                return "audio/eac3";
              }
              return "audio/ac3";
            }
            return "video/x-vnd.on2.vp8";
          }
          return "video/x-vnd.on2.vp9";
        }
        return "video/dolby-vision";
      }
      return "video/hevc";
    }
    return "video/avc";
  }
  
  @Nullable
  public static String h(int paramInt)
  {
    if (paramInt != 32)
    {
      if (paramInt != 33)
      {
        if (paramInt != 35)
        {
          if (paramInt != 64)
          {
            if (paramInt != 163) {
              if (paramInt != 177) {
                if (paramInt != 165) {
                  if (paramInt == 166) {}
                }
              }
            }
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return null;
              case 174: 
                return "audio/ac4";
              case 173: 
                return "audio/opus";
              case 170: 
              case 171: 
                return "audio/vnd.dts.hd";
              }
              return "audio/vnd.dts";
            case 106: 
              return "video/mpeg";
            case 105: 
            case 107: 
              return "audio/mpeg";
            case 96: 
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: 
              return "video/mpeg2";
              return "audio/eac3";
              return "audio/ac3";
              return "video/x-vnd.on2.vp9";
              return "video/wvc1";
            }
          }
          return "audio/mp4a-latm";
        }
        return "video/hevc";
      }
      return "video/avc";
    }
    return "video/mp4v-es";
  }
  
  @Nullable
  @VisibleForTesting
  static b i(String paramString)
  {
    Object localObject = b.matcher(paramString);
    if (!((Matcher)localObject).matches()) {
      return null;
    }
    paramString = (String)g.e(((Matcher)localObject).group(1));
    localObject = ((Matcher)localObject).group(2);
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramString, 16);
      if (localObject != null) {
        i = Integer.parseInt((String)localObject);
      }
      return new b(j, i);
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  @Nullable
  private static String j(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.indexOf('/');
    if (i == -1) {
      return null;
    }
    return paramString.substring(0, i);
  }
  
  public static int k(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (o(paramString)) {
      return 1;
    }
    if (q(paramString)) {
      return 2;
    }
    if (p(paramString)) {
      return 3;
    }
    if ((!"application/id3".equals(paramString)) && (!"application/x-emsg".equals(paramString)) && (!"application/x-scte35".equals(paramString)))
    {
      if ("application/x-camera-motion".equals(paramString)) {
        return 6;
      }
      return l(paramString);
    }
    return 5;
  }
  
  private static int l(String paramString)
  {
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      a locala = (a)a.get(j);
      if (paramString.equals(locala.a)) {
        return locala.c;
      }
    }
    return -1;
  }
  
  public static int m(String paramString)
  {
    return k(g(paramString));
  }
  
  @Nullable
  public static String n(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String[] arrayOfString = o0.G0(paramString);
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      paramString = g(arrayOfString[j]);
      if ((paramString != null) && (q(paramString))) {
        return paramString;
      }
    }
    return null;
  }
  
  public static boolean o(@Nullable String paramString)
  {
    return "audio".equals(j(paramString));
  }
  
  public static boolean p(@Nullable String paramString)
  {
    boolean bool;
    if ((!"text".equals(j(paramString))) && (!"application/cea-608".equals(paramString)) && (!"application/cea-708".equals(paramString)) && (!"application/x-mp4-cea-608".equals(paramString)) && (!"application/x-subrip".equals(paramString)) && (!"application/ttml+xml".equals(paramString)) && (!"application/x-quicktime-tx3g".equals(paramString)) && (!"application/x-mp4-vtt".equals(paramString)) && (!"application/x-rawcc".equals(paramString)) && (!"application/vobsub".equals(paramString)) && (!"application/pgs".equals(paramString)) && (!"application/dvbsubs".equals(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean q(@Nullable String paramString)
  {
    return "video".equals(j(paramString));
  }
  
  public static String r(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 187090231: 
      if (paramString.equals("audio/mp3")) {
        j = 2;
      }
      break;
    case -586683234: 
      if (paramString.equals("audio/x-wav")) {
        j = 1;
      }
      break;
    case -1007807498: 
      if (paramString.equals("audio/x-flac")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return paramString;
    case 2: 
      return "audio/mpeg";
    case 1: 
      return "audio/wav";
    }
    return "audio/flac";
  }
  
  private static final class a
  {
    public final String a;
    public final String b;
    public final int c;
  }
  
  @VisibleForTesting
  static final class b
  {
    public final int a;
    public final int b;
    
    public b(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */