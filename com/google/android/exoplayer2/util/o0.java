package com.google.android.exoplayer2.util;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.l;
import com.google.common.base.c;
import com.google.common.base.e;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class o0
{
  public static final int a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final byte[] f = new byte[0];
  private static final Pattern g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
  private static final Pattern h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
  private static final Pattern i = Pattern.compile("%([A-Fa-f0-9]{2})");
  private static final Pattern j = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
  @Nullable
  private static HashMap<String, String> k;
  private static final String[] l = { "alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn" };
  private static final String[] m = { "i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn" };
  private static final int[] n = { 0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108 };
  private static final int[] o = { 0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243 };
  
  static
  {
    String str1 = Build.VERSION.CODENAME;
    int i1;
    if ("S".equals(str1)) {
      i1 = 31;
    } else if ("R".equals(str1)) {
      i1 = 30;
    } else {
      i1 = Build.VERSION.SDK_INT;
    }
    a = i1;
    String str2 = Build.DEVICE;
    b = str2;
    str1 = Build.MANUFACTURER;
    c = str1;
    String str3 = Build.MODEL;
    d = str3;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str2).length() + 17 + String.valueOf(str3).length() + String.valueOf(str1).length());
    localStringBuilder.append(str2);
    localStringBuilder.append(", ");
    localStringBuilder.append(str3);
    localStringBuilder.append(", ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", ");
    localStringBuilder.append(i1);
    e = localStringBuilder.toString();
  }
  
  public static String A(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static boolean A0(Parcel paramParcel)
  {
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static String B(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, e.c);
  }
  
  public static <T> void B0(List<T> paramList, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 <= paramList.size()) && (paramInt1 <= paramInt2))
    {
      if (paramInt1 != paramInt2) {
        paramList.subList(paramInt1, paramInt2).clear();
      }
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static String C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfByte, paramInt1, paramInt2, e.c);
  }
  
  public static long C0(long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = paramLong3 < paramLong2;
    if ((!bool) && (paramLong3 % paramLong2 == 0L)) {
      return paramLong1 / (paramLong3 / paramLong2);
    }
    if ((bool) && (paramLong2 % paramLong3 == 0L)) {
      return paramLong1 * (paramLong2 / paramLong3);
    }
    double d1 = paramLong2 / paramLong3;
    return (paramLong1 * d1);
  }
  
  public static int D(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8: 
      paramInt = a;
      if (paramInt >= 23) {
        return 6396;
      }
      if (paramInt >= 21) {
        return 6396;
      }
      return 0;
    case 7: 
      return 1276;
    case 6: 
      return 252;
    case 5: 
      return 220;
    case 4: 
      return 204;
    case 3: 
      return 28;
    case 2: 
      return 12;
    }
    return 4;
  }
  
  public static void D0(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    boolean bool = paramLong2 < paramLong1;
    if ((!bool) && (paramLong2 % paramLong1 == 0L)) {
      paramLong1 = paramLong2 / paramLong1;
    }
    while (i3 < paramArrayOfLong.length)
    {
      paramArrayOfLong[i3] /= paramLong1;
      i3++;
      continue;
      if ((bool) && (paramLong1 % paramLong2 == 0L))
      {
        paramLong1 /= paramLong2;
        i3 = i1;
      }
      while (i3 < paramArrayOfLong.length)
      {
        paramArrayOfLong[i3] *= paramLong1;
        i3++;
        continue;
        double d1 = paramLong1 / paramLong2;
        for (i3 = i2; i3 < paramArrayOfLong.length; i3++) {
          paramArrayOfLong[i3] = ((paramArrayOfLong[i3] * d1));
        }
      }
    }
  }
  
  public static int E(ByteBuffer paramByteBuffer, int paramInt)
  {
    paramInt = paramByteBuffer.getInt(paramInt);
    if (paramByteBuffer.order() != ByteOrder.BIG_ENDIAN) {
      paramInt = Integer.reverseBytes(paramInt);
    }
    return paramInt;
  }
  
  public static String[] E0(String paramString1, String paramString2)
  {
    return paramString1.split(paramString2, -1);
  }
  
  public static int F(@Nullable String paramString, int paramInt)
  {
    paramString = G0(paramString);
    int i1 = paramString.length;
    int i2 = 0;
    int i4;
    for (int i3 = 0; i2 < i1; i3 = i4)
    {
      i4 = i3;
      if (paramInt == y.m(paramString[i2])) {
        i4 = i3 + 1;
      }
      i2++;
    }
    return i3;
  }
  
  public static String[] F0(String paramString1, String paramString2)
  {
    return paramString1.split(paramString2, 2);
  }
  
  @Nullable
  public static String G(@Nullable String paramString, int paramInt)
  {
    String[] arrayOfString = G0(paramString);
    int i1 = arrayOfString.length;
    paramString = null;
    if (i1 == 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = arrayOfString.length;
    for (i1 = 0; i1 < i2; i1++)
    {
      String str = arrayOfString[i1];
      if (paramInt == y.m(str))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str);
      }
    }
    if (localStringBuilder.length() > 0) {
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  public static String[] G0(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new String[0];
    }
    return E0(paramString.trim(), "(\\s*,\\s*)");
  }
  
  public static String H(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i1 = 0; i1 < paramArrayOfObject.length; i1++)
    {
      localStringBuilder.append(paramArrayOfObject[i1].getClass().getSimpleName());
      if (i1 < paramArrayOfObject.length - 1) {
        localStringBuilder.append(", ");
      }
    }
    return localStringBuilder.toString();
  }
  
  @Nullable
  public static ComponentName H0(Context paramContext, Intent paramIntent)
  {
    if (a >= 26) {
      return paramContext.startForegroundService(paramIntent);
    }
    return paramContext.startService(paramIntent);
  }
  
  public static String I(@Nullable Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getNetworkCountryIso();
        if (!TextUtils.isEmpty(paramContext)) {
          return c.g(paramContext);
        }
      }
    }
    return c.g(Locale.getDefault().getCountry());
  }
  
  public static long I0(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = paramLong1 - paramLong2;
    if (((paramLong1 ^ l1) & (paramLong2 ^ paramLong1)) < 0L) {
      return paramLong3;
    }
    return l1;
  }
  
  public static Point J(Context paramContext)
  {
    if (a >= 17)
    {
      localObject1 = (DisplayManager)paramContext.getSystemService("display");
      if (localObject1 != null)
      {
        localObject1 = ((DisplayManager)localObject1).getDisplay(0);
        break label34;
      }
    }
    Object localObject1 = null;
    label34:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ((WindowManager)g.e((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay();
    }
    return K(paramContext, (Display)localObject2);
  }
  
  public static byte[] J0(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['က'];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i1);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static Point K(Context paramContext, Display paramDisplay)
  {
    int i1 = a;
    if ((i1 <= 29) && (paramDisplay.getDisplayId() == 0) && (n0(paramContext)))
    {
      if (("Sony".equals(c)) && (d.startsWith("BRAVIA")) && (paramContext.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd"))) {
        return new Point(3840, 2160);
      }
      if (i1 < 28) {
        paramContext = d0("sys.display-size");
      } else {
        paramContext = d0("vendor.display-size");
      }
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          Object localObject = E0(paramContext.trim(), "x");
          if (localObject.length == 2)
          {
            int i2 = Integer.parseInt(localObject[0]);
            i1 = Integer.parseInt(localObject[1]);
            if ((i2 > 0) && (i1 > 0))
            {
              localObject = new Point(i2, i1);
              return (Point)localObject;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          paramContext = String.valueOf(paramContext);
          if (paramContext.length() != 0) {
            paramContext = "Invalid display size: ".concat(paramContext);
          } else {
            paramContext = new String("Invalid display size: ");
          }
          u.c("Util", paramContext);
        }
      }
    }
    paramContext = new Point();
    i1 = a;
    if (i1 >= 23) {
      O(paramDisplay, paramContext);
    } else if (i1 >= 17) {
      N(paramDisplay, paramContext);
    } else {
      M(paramDisplay, paramContext);
    }
    return paramContext;
  }
  
  public static long K0(int paramInt1, int paramInt2)
  {
    long l1 = L0(paramInt1);
    return L0(paramInt2) | l1 << 32;
  }
  
  public static Looper L()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper == null) {
      localLooper = Looper.getMainLooper();
    }
    return localLooper;
  }
  
  public static long L0(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  private static void M(Display paramDisplay, Point paramPoint)
  {
    paramDisplay.getSize(paramPoint);
  }
  
  public static CharSequence M0(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence.length() > paramInt) {
      paramCharSequence = paramCharSequence.subSequence(0, paramInt);
    }
    return paramCharSequence;
  }
  
  @RequiresApi(17)
  private static void N(Display paramDisplay, Point paramPoint)
  {
    paramDisplay.getRealSize(paramPoint);
  }
  
  public static void N0(Parcel paramParcel, boolean paramBoolean)
  {
    paramParcel.writeInt(paramBoolean);
  }
  
  @RequiresApi(23)
  private static void O(Display paramDisplay, Point paramPoint)
  {
    paramDisplay = paramDisplay.getMode();
    paramPoint.x = paramDisplay.getPhysicalWidth();
    paramPoint.y = paramDisplay.getPhysicalHeight();
  }
  
  public static int P(@Nullable String paramString)
  {
    int i1 = 0;
    if (paramString == null) {
      return 0;
    }
    paramString = E0(paramString, "_");
    int i2 = paramString.length;
    if (i2 < 2) {
      return 0;
    }
    Object localObject = paramString[(i2 - 1)];
    if ((i2 >= 3) && ("neg".equals(paramString[(i2 - 2)]))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    try
    {
      int i3 = Integer.parseInt((String)g.e(localObject));
      i1 = i3;
      if (i2 != 0) {
        i1 = -i3;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return i1;
  }
  
  public static String Q(Locale paramLocale)
  {
    if (a >= 21) {
      paramLocale = R(paramLocale);
    } else {
      paramLocale = paramLocale.toString();
    }
    return paramLocale;
  }
  
  @RequiresApi(21)
  private static String R(Locale paramLocale)
  {
    return paramLocale.toLanguageTag();
  }
  
  public static long S(long paramLong, float paramFloat)
  {
    if (paramFloat == 1.0F) {
      return paramLong;
    }
    return Math.round(paramLong * paramFloat);
  }
  
  public static long T(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      paramLong = System.currentTimeMillis();
    } else {
      paramLong += SystemClock.elapsedRealtime();
    }
    return paramLong;
  }
  
  public static int U(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 16)
      {
        if (paramInt != 24)
        {
          if (paramInt != 32) {
            return 0;
          }
          return 805306368;
        }
        return 536870912;
      }
      return 2;
    }
    return 3;
  }
  
  public static Format V(int paramInt1, int paramInt2, int paramInt3)
  {
    return new Format.b().e0("audio/raw").H(paramInt2).f0(paramInt3).Y(paramInt1).E();
  }
  
  public static int W(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2)
    {
      int i1 = paramInt2;
      if (paramInt1 != 3)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 == 268435456) {
            break label59;
          }
          if (paramInt1 != 536870912)
          {
            if (paramInt1 != 805306368) {
              throw new IllegalArgumentException();
            }
          }
          else {
            return paramInt2 * 3;
          }
        }
        i1 = paramInt2 * 4;
      }
      else
      {
        return i1;
      }
    }
    label59:
    return paramInt2 * 2;
  }
  
  public static long X(long paramLong, float paramFloat)
  {
    if (paramFloat == 1.0F) {
      return paramLong;
    }
    return Math.round(paramLong / paramFloat);
  }
  
  public static int Y(int paramInt)
  {
    if (paramInt != 13)
    {
      switch (paramInt)
      {
      default: 
        return 3;
      case 6: 
        return 2;
      case 5: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
        return 5;
      case 4: 
        return 4;
      case 3: 
        return 8;
      }
      return 0;
    }
    return 1;
  }
  
  public static String Z(StringBuilder paramStringBuilder, Formatter paramFormatter, long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == -9223372036854775807L) {
      l1 = 0L;
    }
    String str;
    if (l1 < 0L) {
      str = "-";
    } else {
      str = "";
    }
    long l2 = (Math.abs(l1) + 500L) / 1000L;
    paramLong = l2 % 60L;
    l1 = l2 / 60L % 60L;
    l2 /= 3600L;
    paramStringBuilder.setLength(0);
    if (l2 > 0L) {
      paramStringBuilder = paramFormatter.format("%s%d:%02d:%02d", new Object[] { str, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    } else {
      paramStringBuilder = paramFormatter.format("%s%02d:%02d", new Object[] { str, Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    return paramStringBuilder;
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = paramLong1 + paramLong2;
    if (((paramLong1 ^ l1) & (paramLong2 ^ l1)) < 0L) {
      return paramLong3;
    }
    return l1;
  }
  
  public static String[] a0()
  {
    String[] arrayOfString = b0();
    for (int i1 = 0; i1 < arrayOfString.length; i1++) {
      arrayOfString[i1] = t0(arrayOfString[i1]);
    }
    return arrayOfString;
  }
  
  public static boolean b(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null)
    {
      if (paramObject2 == null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = paramObject1.equals(paramObject2);
    }
    return bool;
  }
  
  private static String[] b0()
  {
    Object localObject = Resources.getSystem().getConfiguration();
    if (a >= 24) {
      localObject = c0((Configuration)localObject);
    } else {
      localObject = new String[] { Q(((Configuration)localObject).locale) };
    }
    return (String[])localObject;
  }
  
  public static <T extends Comparable<? super T>> int c(List<? extends Comparable<? super T>> paramList, T paramT, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Collections.binarySearch(paramList, paramT);
    if (i1 < 0)
    {
      i1 ^= 0xFFFFFFFF;
    }
    else
    {
      i2 = paramList.size();
      do
      {
        i1++;
      } while ((i1 < i2) && (((Comparable)paramList.get(i1)).compareTo(paramT) == 0));
      if (paramBoolean1) {
        i1--;
      }
    }
    int i2 = i1;
    if (paramBoolean2) {
      i2 = Math.min(paramList.size() - 1, i1);
    }
    return i2;
  }
  
  @RequiresApi(24)
  private static String[] c0(Configuration paramConfiguration)
  {
    return E0(paramConfiguration.getLocales().toLanguageTags(), ",");
  }
  
  public static int d(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i2 = i1;
    if (i1 < 0)
    {
      i2 = i1 ^ 0xFFFFFFFF;
    }
    else
    {
      do
      {
        i2++;
      } while ((i2 < paramArrayOfLong.length) && (paramArrayOfLong[i2] == paramLong));
      if (paramBoolean1) {
        i2--;
      }
    }
    i1 = i2;
    if (paramBoolean2) {
      i1 = Math.min(paramArrayOfLong.length - 1, i2);
    }
    return i1;
  }
  
  @Nullable
  private static String d0(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { paramString });
      return (String)localObject;
    }
    catch (Exception localException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Failed to read system property ".concat(paramString);
      } else {
        paramString = new String("Failed to read system property ");
      }
      u.d("Util", paramString, localException);
    }
    return null;
  }
  
  public static int e(v paramv, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = paramv.c() - 1;
    int i2 = 0;
    int i3 = 0;
    while (i3 <= i1)
    {
      int i4 = i3 + i1 >>> 1;
      if (paramv.b(i4) < paramLong) {
        i3 = i4 + 1;
      } else {
        i1 = i4 - 1;
      }
    }
    if (paramBoolean1)
    {
      i3 = i1 + 1;
      if ((i3 < paramv.c()) && (paramv.b(i3) == paramLong))
      {
        i1 = i3;
        break label114;
      }
    }
    if ((paramBoolean2) && (i1 == -1)) {
      i1 = i2;
    }
    label114:
    return i1;
  }
  
  public static byte[] e0(String paramString)
  {
    return paramString.getBytes(e.c);
  }
  
  public static <T extends Comparable<? super T>> int f(List<? extends Comparable<? super T>> paramList, T paramT, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Collections.binarySearch(paramList, paramT);
    int i2 = i1;
    if (i1 < 0)
    {
      i2 = -(i1 + 2);
    }
    else
    {
      do
      {
        i2--;
      } while ((i2 >= 0) && (((Comparable)paramList.get(i2)).compareTo(paramT) == 0));
      if (paramBoolean1) {
        i2++;
      }
    }
    i1 = i2;
    if (paramBoolean2) {
      i1 = Math.max(0, i2);
    }
    return i1;
  }
  
  public static int f0(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str != null) && (c.a("rtsp", str))) {
      return 3;
    }
    paramUri = paramUri.getPath();
    int i1;
    if (paramUri == null) {
      i1 = 4;
    } else {
      i1 = g0(paramUri);
    }
    return i1;
  }
  
  public static int g(int[] paramArrayOfInt, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Arrays.binarySearch(paramArrayOfInt, paramInt);
    int i2 = i1;
    if (i1 < 0)
    {
      paramInt = -(i1 + 2);
    }
    else
    {
      do
      {
        i2--;
      } while ((i2 >= 0) && (paramArrayOfInt[i2] == paramInt));
      if (paramBoolean1) {
        paramInt = i2 + 1;
      } else {
        paramInt = i2;
      }
    }
    i2 = paramInt;
    if (paramBoolean2) {
      i2 = Math.max(0, paramInt);
    }
    return i2;
  }
  
  public static int g0(String paramString)
  {
    paramString = c.e(paramString);
    if (paramString.endsWith(".mpd")) {
      return 0;
    }
    if (paramString.endsWith(".m3u8")) {
      return 2;
    }
    paramString = j.matcher(paramString);
    if (paramString.matches())
    {
      paramString = paramString.group(2);
      if (paramString != null)
      {
        if (paramString.contains("format=mpd-time-csf")) {
          return 0;
        }
        if (paramString.contains("format=m3u8-aapl")) {
          return 2;
        }
      }
      return 1;
    }
    return 4;
  }
  
  public static int h(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i2 = i1;
    if (i1 < 0)
    {
      i2 = -(i1 + 2);
    }
    else
    {
      do
      {
        i2--;
      } while ((i2 >= 0) && (paramArrayOfLong[i2] == paramLong));
      if (paramBoolean1) {
        i2++;
      }
    }
    i1 = i2;
    if (paramBoolean2) {
      i1 = Math.max(0, i2);
    }
    return i1;
  }
  
  public static int h0(Uri paramUri, @Nullable String paramString)
  {
    if (paramString == null) {
      return f0(paramUri);
    }
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1154777587: 
      if (paramString.equals("application/x-rtsp")) {
        i1 = 3;
      }
      break;
    case 64194685: 
      if (paramString.equals("application/dash+xml")) {
        i1 = 2;
      }
      break;
    case -156749520: 
      if (paramString.equals("application/vnd.ms-sstr+xml")) {
        i1 = 1;
      }
      break;
    case -979127466: 
      if (paramString.equals("application/x-mpegURL")) {
        i1 = 0;
      }
      break;
    }
    switch (i1)
    {
    default: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  @EnsuresNonNull({"#1"})
  public static <T> T i(@Nullable T paramT)
  {
    return paramT;
  }
  
  /* Error */
  public static boolean i0(d0 paramd01, d0 paramd02, @Nullable java.util.zip.Inflater paramInflater)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1194	com/google/android/exoplayer2/util/d0:a	()I
    //   4: ifgt +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_1
    //   10: invokevirtual 1196	com/google/android/exoplayer2/util/d0:b	()I
    //   13: aload_0
    //   14: invokevirtual 1194	com/google/android/exoplayer2/util/d0:a	()I
    //   17: if_icmpge +13 -> 30
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 1194	com/google/android/exoplayer2/util/d0:a	()I
    //   25: iconst_2
    //   26: imul
    //   27: invokevirtual 1198	com/google/android/exoplayer2/util/d0:c	(I)V
    //   30: aload_2
    //   31: astore_3
    //   32: aload_2
    //   33: ifnonnull +11 -> 44
    //   36: new 1200	java/util/zip/Inflater
    //   39: dup
    //   40: invokespecial 1201	java/util/zip/Inflater:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: aload_0
    //   46: invokevirtual 1203	com/google/android/exoplayer2/util/d0:d	()[B
    //   49: aload_0
    //   50: invokevirtual 1205	com/google/android/exoplayer2/util/d0:e	()I
    //   53: aload_0
    //   54: invokevirtual 1194	com/google/android/exoplayer2/util/d0:a	()I
    //   57: invokevirtual 1208	java/util/zip/Inflater:setInput	([BII)V
    //   60: iconst_0
    //   61: istore 4
    //   63: iload 4
    //   65: aload_3
    //   66: aload_1
    //   67: invokevirtual 1203	com/google/android/exoplayer2/util/d0:d	()[B
    //   70: iload 4
    //   72: aload_1
    //   73: invokevirtual 1196	com/google/android/exoplayer2/util/d0:b	()I
    //   76: iload 4
    //   78: isub
    //   79: invokevirtual 1212	java/util/zip/Inflater:inflate	([BII)I
    //   82: iadd
    //   83: istore 5
    //   85: aload_3
    //   86: invokevirtual 1215	java/util/zip/Inflater:finished	()Z
    //   89: ifeq +15 -> 104
    //   92: aload_1
    //   93: iload 5
    //   95: invokevirtual 1217	com/google/android/exoplayer2/util/d0:O	(I)V
    //   98: aload_3
    //   99: invokevirtual 1220	java/util/zip/Inflater:reset	()V
    //   102: iconst_1
    //   103: ireturn
    //   104: aload_3
    //   105: invokevirtual 1223	java/util/zip/Inflater:needsDictionary	()Z
    //   108: ifne +43 -> 151
    //   111: aload_3
    //   112: invokevirtual 1226	java/util/zip/Inflater:needsInput	()Z
    //   115: ifeq +6 -> 121
    //   118: goto +33 -> 151
    //   121: iload 5
    //   123: istore 4
    //   125: iload 5
    //   127: aload_1
    //   128: invokevirtual 1196	com/google/android/exoplayer2/util/d0:b	()I
    //   131: if_icmpne -68 -> 63
    //   134: aload_1
    //   135: aload_1
    //   136: invokevirtual 1196	com/google/android/exoplayer2/util/d0:b	()I
    //   139: iconst_2
    //   140: imul
    //   141: invokevirtual 1198	com/google/android/exoplayer2/util/d0:c	(I)V
    //   144: iload 5
    //   146: istore 4
    //   148: goto -85 -> 63
    //   151: aload_3
    //   152: invokevirtual 1220	java/util/zip/Inflater:reset	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_0
    //   158: aload_3
    //   159: invokevirtual 1220	java/util/zip/Inflater:reset	()V
    //   162: aload_0
    //   163: athrow
    //   164: astore_0
    //   165: aload_3
    //   166: invokevirtual 1220	java/util/zip/Inflater:reset	()V
    //   169: iconst_0
    //   170: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramd01	d0
    //   0	171	1	paramd02	d0
    //   0	171	2	paramInflater	java.util.zip.Inflater
    //   31	135	3	localInflater	java.util.zip.Inflater
    //   61	86	4	i1	int
    //   83	62	5	i2	int
    // Exception table:
    //   from	to	target	type
    //   63	98	157	finally
    //   104	118	157	finally
    //   125	144	157	finally
    //   63	98	164	java/util/zip/DataFormatException
    //   104	118	164	java/util/zip/DataFormatException
    //   125	144	164	java/util/zip/DataFormatException
  }
  
  @EnsuresNonNull({"#1"})
  public static <T> T[] j(T[] paramArrayOfT)
  {
    return paramArrayOfT;
  }
  
  public static boolean j0(int paramInt)
  {
    boolean bool;
    if ((paramInt != 536870912) && (paramInt != 805306368) && (paramInt != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int k(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 1) / paramInt2;
  }
  
  public static boolean k0(int paramInt)
  {
    boolean bool;
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 268435456) && (paramInt != 536870912) && (paramInt != 805306368) && (paramInt != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void l(@Nullable l paraml)
  {
    if (paraml != null) {}
    try
    {
      paraml.close();
      return;
    }
    catch (IOException paraml)
    {
      for (;;) {}
    }
  }
  
  public static boolean l0(int paramInt)
  {
    boolean bool;
    if ((paramInt != 10) && (paramInt != 13)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void m(@Nullable Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;) {}
    }
  }
  
  public static boolean m0(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    boolean bool;
    if ((!TextUtils.isEmpty(paramUri)) && (!"file".equals(paramUri))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int n(long paramLong1, long paramLong2)
  {
    boolean bool = paramLong1 < paramLong2;
    int i1;
    if (bool) {
      i1 = -1;
    } else if (i1 == 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    return i1;
  }
  
  public static boolean n0(Context paramContext)
  {
    paramContext = (UiModeManager)paramContext.getApplicationContext().getSystemService("uimode");
    boolean bool;
    if ((paramContext != null) && (paramContext.getCurrentModeType() == 4)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static float o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static int p(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt1, paramInt3));
  }
  
  public static int p0(int[] paramArrayOfInt, int paramInt)
  {
    for (int i1 = 0; i1 < paramArrayOfInt.length; i1++) {
      if (paramArrayOfInt[i1] == paramInt) {
        return i1;
      }
    }
    return -1;
  }
  
  public static long q(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  private static String q0(String paramString)
  {
    for (int i1 = 0;; i1 += 2)
    {
      String[] arrayOfString = m;
      if (i1 >= arrayOfString.length) {
        break;
      }
      if (paramString.startsWith(arrayOfString[i1]))
      {
        String str = String.valueOf(arrayOfString[(i1 + 1)]);
        paramString = String.valueOf(paramString.substring(arrayOfString[i1].length()));
        if (paramString.length() != 0) {
          paramString = str.concat(paramString);
        } else {
          paramString = new String(str);
        }
        return paramString;
      }
    }
    return paramString;
  }
  
  public static boolean r(Object[] paramArrayOfObject, @Nullable Object paramObject)
  {
    int i1 = paramArrayOfObject.length;
    for (int i2 = 0; i2 < i1; i2++) {
      if (b(paramArrayOfObject[i2], paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public static <T> void r0(List<T> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    for (paramInt2 = paramInt2 - paramInt1 - 1; paramInt2 >= 0; paramInt2--) {
      localArrayDeque.addFirst(paramList.remove(paramInt1 + paramInt2));
    }
    paramList.addAll(Math.min(paramInt3, paramList.size()), localArrayDeque);
  }
  
  public static int s(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt1 < paramInt2)
    {
      paramInt3 = n[((paramInt3 >>> 24 ^ paramArrayOfByte[paramInt1] & 0xFF) & 0xFF)] ^ paramInt3 << 8;
      paramInt1++;
    }
    return paramInt3;
  }
  
  public static ExecutorService s0(String paramString)
  {
    return Executors.newSingleThreadExecutor(new f(paramString));
  }
  
  public static int t(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt1 < paramInt2)
    {
      paramInt3 = o[(paramInt3 ^ paramArrayOfByte[paramInt1] & 0xFF)];
      paramInt1++;
    }
    return paramInt3;
  }
  
  public static String t0(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str1 = paramString.replace('_', '-');
    Object localObject = paramString;
    if (!str1.isEmpty()) {
      if (str1.equals("und")) {
        localObject = paramString;
      } else {
        localObject = str1;
      }
    }
    String str2 = c.e((String)localObject);
    String str3 = F0(str2, "-")[0];
    if (k == null) {
      k = z();
    }
    str1 = (String)k.get(str3);
    localObject = str3;
    paramString = str2;
    if (str1 != null)
    {
      paramString = String.valueOf(str2.substring(str3.length()));
      if (paramString.length() != 0) {
        paramString = str1.concat(paramString);
      } else {
        paramString = new String(str1);
      }
      localObject = str1;
    }
    if ((!"no".equals(localObject)) && (!"i".equals(localObject)))
    {
      str1 = paramString;
      if (!"zh".equals(localObject)) {}
    }
    else
    {
      str1 = q0(paramString);
    }
    return str1;
  }
  
  public static Handler u(Looper paramLooper, @Nullable Handler.Callback paramCallback)
  {
    return new Handler(paramLooper, paramCallback);
  }
  
  public static <T> T[] u0(T[] paramArrayOfT, T paramT)
  {
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length + 1);
    arrayOfObject[paramArrayOfT.length] = paramT;
    return j(arrayOfObject);
  }
  
  public static Handler v()
  {
    return w(null);
  }
  
  public static <T> T[] v0(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    return arrayOfObject;
  }
  
  public static Handler w(@Nullable Handler.Callback paramCallback)
  {
    return u((Looper)g.i(Looper.myLooper()), paramCallback);
  }
  
  public static <T> T[] w0(T[] paramArrayOfT, int paramInt)
  {
    boolean bool;
    if (paramInt <= paramArrayOfT.length) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    return Arrays.copyOf(paramArrayOfT, paramInt);
  }
  
  public static Handler x()
  {
    return y(null);
  }
  
  public static <T> T[] x0(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt1 >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    if (paramInt2 <= paramArrayOfT.length) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    return Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
  }
  
  public static Handler y(@Nullable Handler.Callback paramCallback)
  {
    return u(L(), paramCallback);
  }
  
  public static long y0(String paramString)
    throws ParserException
  {
    Matcher localMatcher = g.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Invalid date/time format: ".concat(paramString);
      } else {
        paramString = new String("Invalid date/time format: ");
      }
      throw ParserException.createForMalformedContainer(paramString, null);
    }
    paramString = localMatcher.group(9);
    int i1 = 0;
    if ((paramString != null) && (!localMatcher.group(9).equalsIgnoreCase("Z")))
    {
      int i2 = Integer.parseInt(localMatcher.group(12)) * 60 + Integer.parseInt(localMatcher.group(13));
      i1 = i2;
      if ("-".equals(localMatcher.group(11))) {
        i1 = i2 * -1;
      }
    }
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
    localGregorianCalendar.clear();
    localGregorianCalendar.set(Integer.parseInt(localMatcher.group(1)), Integer.parseInt(localMatcher.group(2)) - 1, Integer.parseInt(localMatcher.group(3)), Integer.parseInt(localMatcher.group(4)), Integer.parseInt(localMatcher.group(5)), Integer.parseInt(localMatcher.group(6)));
    if (!TextUtils.isEmpty(localMatcher.group(8)))
    {
      paramString = String.valueOf(localMatcher.group(8));
      if (paramString.length() != 0) {
        paramString = "0.".concat(paramString);
      } else {
        paramString = new String("0.");
      }
      localGregorianCalendar.set(14, new BigDecimal(paramString).movePointRight(3).intValue());
    }
    long l1 = localGregorianCalendar.getTimeInMillis();
    long l2 = l1;
    if (i1 != 0) {
      l2 = l1 - i1 * 60000;
    }
    return l2;
  }
  
  private static HashMap<String, String> z()
  {
    String[] arrayOfString = Locale.getISOLanguages();
    HashMap localHashMap = new HashMap(arrayOfString.length + l.length);
    int i1 = arrayOfString.length;
    int i2 = 0;
    int i3 = 0;
    for (;;)
    {
      int i4 = i2;
      String str;
      if (i3 < i1) {
        str = arrayOfString[i3];
      }
      try
      {
        Object localObject = new java/util/Locale;
        ((Locale)localObject).<init>(str);
        localObject = ((Locale)localObject).getISO3Language();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put(localObject, str);
        }
        i3++;
        continue;
        for (;;)
        {
          arrayOfString = l;
          if (i4 >= arrayOfString.length) {
            break;
          }
          localHashMap.put(arrayOfString[i4], arrayOfString[(i4 + 1)]);
          i4 += 2;
        }
        return localHashMap;
      }
      catch (MissingResourceException localMissingResourceException)
      {
        for (;;) {}
      }
    }
  }
  
  public static boolean z0(Handler paramHandler, Runnable paramRunnable)
  {
    if (!paramHandler.getLooper().getThread().isAlive()) {
      return false;
    }
    if (paramHandler.getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return true;
    }
    return paramHandler.post(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\o0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */