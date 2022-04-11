package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.base.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil
{
  private static final Pattern a = Pattern.compile("^\\D?(\\d+)$");
  @GuardedBy("MediaCodecUtil.class")
  private static final HashMap<b, List<r>> b = new HashMap();
  private static int c = -1;
  
  private static boolean A(MediaCodecInfo paramMediaCodecInfo)
  {
    if (o0.a >= 29) {
      return B(paramMediaCodecInfo);
    }
    paramMediaCodecInfo = c.e(paramMediaCodecInfo.getName());
    boolean bool1 = paramMediaCodecInfo.startsWith("arc.");
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((!paramMediaCodecInfo.startsWith("omx.google.")) && (!paramMediaCodecInfo.startsWith("omx.ffmpeg.")) && ((!paramMediaCodecInfo.startsWith("omx.sec.")) || (!paramMediaCodecInfo.contains(".sw."))) && (!paramMediaCodecInfo.equals("omx.qcom.video.decoder.hevcswvdec")) && (!paramMediaCodecInfo.startsWith("c2.android.")) && (!paramMediaCodecInfo.startsWith("c2.google.")))
    {
      bool1 = bool2;
      if (!paramMediaCodecInfo.startsWith("omx."))
      {
        bool1 = bool2;
        if (paramMediaCodecInfo.startsWith("c2.")) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  @RequiresApi(29)
  private static boolean B(MediaCodecInfo paramMediaCodecInfo)
  {
    return paramMediaCodecInfo.isSoftwareOnly();
  }
  
  private static boolean C(MediaCodecInfo paramMediaCodecInfo)
  {
    if (o0.a >= 29) {
      return D(paramMediaCodecInfo);
    }
    paramMediaCodecInfo = c.e(paramMediaCodecInfo.getName());
    boolean bool;
    if ((!paramMediaCodecInfo.startsWith("omx.google.")) && (!paramMediaCodecInfo.startsWith("c2.android.")) && (!paramMediaCodecInfo.startsWith("c2.google."))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(29)
  private static boolean D(MediaCodecInfo paramMediaCodecInfo)
  {
    return paramMediaCodecInfo.isVendor();
  }
  
  public static int I()
    throws MediaCodecUtil.DecoderQueryException
  {
    if (c == -1)
    {
      int i = 0;
      int j = 0;
      Object localObject = m("video/avc", false, false);
      if (localObject != null)
      {
        localObject = ((r)localObject).g();
        int k = localObject.length;
        i = 0;
        while (j < k)
        {
          i = Math.max(d(localObject[j].level), i);
          j++;
        }
        if (o0.a >= 21) {
          j = 345600;
        } else {
          j = 172800;
        }
        i = Math.max(i, j);
      }
      c = i;
    }
    return c;
  }
  
  private static int J(int paramInt)
  {
    int i = 17;
    if (paramInt != 17)
    {
      i = 20;
      if (paramInt != 20)
      {
        i = 23;
        if (paramInt != 23)
        {
          i = 29;
          if (paramInt != 29)
          {
            i = 39;
            if (paramInt != 39)
            {
              i = 42;
              if (paramInt != 42)
              {
                switch (paramInt)
                {
                default: 
                  return -1;
                case 6: 
                  return 6;
                case 5: 
                  return 5;
                case 4: 
                  return 4;
                case 3: 
                  return 3;
                case 2: 
                  return 2;
                }
                return 1;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  private static <T> void K(List<T> paramList, f<T> paramf)
  {
    Collections.sort(paramList, new h(paramf));
  }
  
  private static int L(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 11)
      {
        if (paramInt != 20)
        {
          if (paramInt != 21)
          {
            if (paramInt != 30)
            {
              if (paramInt != 31)
              {
                if (paramInt != 40)
                {
                  if (paramInt != 41)
                  {
                    if (paramInt != 50)
                    {
                      if (paramInt != 51)
                      {
                        switch (paramInt)
                        {
                        default: 
                          return -1;
                        case 62: 
                          return 8192;
                        case 61: 
                          return 4096;
                        }
                        return 2048;
                      }
                      return 512;
                    }
                    return 256;
                  }
                  return 128;
                }
                return 64;
              }
              return 32;
            }
            return 16;
          }
          return 8;
        }
        return 4;
      }
      return 2;
    }
    return 1;
  }
  
  private static int M(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return -1;
          }
          return 8;
        }
        return 4;
      }
      return 2;
    }
    return 1;
  }
  
  private static void a(String paramString, List<r> paramList)
  {
    if ("audio/raw".equals(paramString))
    {
      if ((o0.a < 26) && (o0.b.equals("R9")) && (paramList.size() == 1) && (((r)paramList.get(0)).a.equals("OMX.MTK.AUDIO.DECODER.RAW"))) {
        paramList.add(r.A("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
      }
      K(paramList, e.a);
    }
    int i = o0.a;
    if ((i < 21) && (paramList.size() > 1))
    {
      paramString = ((r)paramList.get(0)).a;
      if (("OMX.SEC.mp3.dec".equals(paramString)) || ("OMX.SEC.MP3.Decoder".equals(paramString)) || ("OMX.brcm.audio.mp3.decoder".equals(paramString))) {
        K(paramList, f.a);
      }
    }
    if ((i < 30) && (paramList.size() > 1) && ("OMX.qti.audio.decoder.flac".equals(((r)paramList.get(0)).a))) {
      paramList.add((r)paramList.remove(0));
    }
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 23: 
      return 8388608;
    case 22: 
      return 4194304;
    case 21: 
      return 2097152;
    case 20: 
      return 1048576;
    case 19: 
      return 524288;
    case 18: 
      return 262144;
    case 17: 
      return 131072;
    case 16: 
      return 65536;
    case 15: 
      return 32768;
    case 14: 
      return 16384;
    case 13: 
      return 8192;
    case 12: 
      return 4096;
    case 11: 
      return 2048;
    case 10: 
      return 1024;
    case 9: 
      return 512;
    case 8: 
      return 256;
    case 7: 
      return 128;
    case 6: 
      return 64;
    case 5: 
      return 32;
    case 4: 
      return 16;
    case 3: 
      return 8;
    case 2: 
      return 4;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  private static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return -1;
            case 52: 
              return 65536;
            case 51: 
              return 32768;
            }
            return 16384;
          case 42: 
            return 8192;
          case 41: 
            return 4096;
          }
          return 2048;
        case 32: 
          return 1024;
        case 31: 
          return 512;
        }
        return 256;
      case 22: 
        return 128;
      case 21: 
        return 64;
      }
      return 32;
    case 13: 
      return 16;
    case 12: 
      return 8;
    case 11: 
      return 4;
    }
    return 1;
  }
  
  private static int d(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      switch (paramInt)
      {
      default: 
        return -1;
      case 131072: 
      case 262144: 
      case 524288: 
        return 35651584;
      case 32768: 
      case 65536: 
        return 9437184;
      case 16384: 
        return 5652480;
      case 8192: 
        return 2228224;
      case 2048: 
      case 4096: 
        return 2097152;
      case 1024: 
        return 1310720;
      case 512: 
        return 921600;
      case 128: 
      case 256: 
        return 414720;
      case 64: 
        return 202752;
      }
      return 101376;
    }
    return 25344;
  }
  
  private static int e(int paramInt)
  {
    if (paramInt != 66)
    {
      if (paramInt != 77)
      {
        if (paramInt != 88)
        {
          if (paramInt != 100)
          {
            if (paramInt != 110)
            {
              if (paramInt != 122)
              {
                if (paramInt != 244) {
                  return -1;
                }
                return 64;
              }
              return 32;
            }
            return 16;
          }
          return 8;
        }
        return 4;
      }
      return 2;
    }
    return 1;
  }
  
  @Nullable
  private static Integer f(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1570: 
      if (paramString.equals("13")) {
        i = 12;
      }
      break;
    case 1569: 
      if (paramString.equals("12")) {
        i = 11;
      }
      break;
    case 1568: 
      if (paramString.equals("11")) {
        i = 10;
      }
      break;
    case 1567: 
      if (paramString.equals("10")) {
        i = 9;
      }
      break;
    case 1545: 
      if (paramString.equals("09")) {
        i = 8;
      }
      break;
    case 1544: 
      if (paramString.equals("08")) {
        i = 7;
      }
      break;
    case 1543: 
      if (paramString.equals("07")) {
        i = 6;
      }
      break;
    case 1542: 
      if (paramString.equals("06")) {
        i = 5;
      }
      break;
    case 1541: 
      if (paramString.equals("05")) {
        i = 4;
      }
      break;
    case 1540: 
      if (paramString.equals("04")) {
        i = 3;
      }
      break;
    case 1539: 
      if (paramString.equals("03")) {
        i = 2;
      }
      break;
    case 1538: 
      if (paramString.equals("02")) {
        i = 1;
      }
      break;
    case 1537: 
      if (paramString.equals("01")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 12: 
      return Integer.valueOf(4096);
    case 11: 
      return Integer.valueOf(2048);
    case 10: 
      return Integer.valueOf(1024);
    case 9: 
      return Integer.valueOf(512);
    case 8: 
      return Integer.valueOf(256);
    case 7: 
      return Integer.valueOf(128);
    case 6: 
      return Integer.valueOf(64);
    case 5: 
      return Integer.valueOf(32);
    case 4: 
      return Integer.valueOf(16);
    case 3: 
      return Integer.valueOf(8);
    case 2: 
      return Integer.valueOf(4);
    case 1: 
      return Integer.valueOf(2);
    }
    return Integer.valueOf(1);
  }
  
  @Nullable
  private static Integer g(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1545: 
      if (paramString.equals("09")) {
        i = 9;
      }
      break;
    case 1544: 
      if (paramString.equals("08")) {
        i = 8;
      }
      break;
    case 1543: 
      if (paramString.equals("07")) {
        i = 7;
      }
      break;
    case 1542: 
      if (paramString.equals("06")) {
        i = 6;
      }
      break;
    case 1541: 
      if (paramString.equals("05")) {
        i = 5;
      }
      break;
    case 1540: 
      if (paramString.equals("04")) {
        i = 4;
      }
      break;
    case 1539: 
      if (paramString.equals("03")) {
        i = 3;
      }
      break;
    case 1538: 
      if (paramString.equals("02")) {
        i = 2;
      }
      break;
    case 1537: 
      if (paramString.equals("01")) {
        i = 1;
      }
      break;
    case 1536: 
      if (paramString.equals("00")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 9: 
      return Integer.valueOf(512);
    case 8: 
      return Integer.valueOf(256);
    case 7: 
      return Integer.valueOf(128);
    case 6: 
      return Integer.valueOf(64);
    case 5: 
      return Integer.valueOf(32);
    case 4: 
      return Integer.valueOf(16);
    case 3: 
      return Integer.valueOf(8);
    case 2: 
      return Integer.valueOf(4);
    case 1: 
      return Integer.valueOf(2);
    }
    return Integer.valueOf(1);
  }
  
  @Nullable
  private static Pair<Integer, Integer> h(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != 3)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed MP4A codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed MP4A codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    try
    {
      if ("audio/mp4a-latm".equals(y.h(Integer.parseInt(paramArrayOfString[1], 16))))
      {
        int i = J(Integer.parseInt(paramArrayOfString[2]));
        if (i != -1)
        {
          paramArrayOfString = new Pair(Integer.valueOf(i), Integer.valueOf(0));
          return paramArrayOfString;
        }
      }
    }
    catch (NumberFormatException paramArrayOfString)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed MP4A codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed MP4A codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
    }
    return null;
  }
  
  @Nullable
  private static Pair<Integer, Integer> i(String paramString, String[] paramArrayOfString, @Nullable ColorInfo paramColorInfo)
  {
    if (paramArrayOfString.length < 4)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed AV1 codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed AV1 codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    int i = 1;
    try
    {
      int j = Integer.parseInt(paramArrayOfString[1]);
      int k = Integer.parseInt(paramArrayOfString[2].substring(0, 2));
      int m = Integer.parseInt(paramArrayOfString[3]);
      if (j != 0)
      {
        paramString = new StringBuilder(32);
        paramString.append("Unknown AV1 profile: ");
        paramString.append(j);
        u.h("MediaCodecUtil", paramString.toString());
        return null;
      }
      if ((m != 8) && (m != 10))
      {
        paramString = new StringBuilder(34);
        paramString.append("Unknown AV1 bit depth: ");
        paramString.append(m);
        u.h("MediaCodecUtil", paramString.toString());
        return null;
      }
      if (m != 8)
      {
        if (paramColorInfo != null) {
          if (paramColorInfo.q == null)
          {
            i = paramColorInfo.f;
            if ((i != 7) && (i != 6)) {}
          }
          else
          {
            i = 4096;
            break label220;
          }
        }
        i = 2;
      }
      label220:
      j = b(k);
      if (j == -1)
      {
        paramString = new StringBuilder(30);
        paramString.append("Unknown AV1 level: ");
        paramString.append(k);
        u.h("MediaCodecUtil", paramString.toString());
        return null;
      }
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
    }
    catch (NumberFormatException paramArrayOfString)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed AV1 codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed AV1 codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
    }
    return null;
  }
  
  @Nullable
  private static Pair<Integer, Integer> j(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed AVC codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed AVC codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    try
    {
      int j;
      if (paramArrayOfString[1].length() == 6)
      {
        i = Integer.parseInt(paramArrayOfString[1].substring(0, 2), 16);
        j = Integer.parseInt(paramArrayOfString[1].substring(4), 16);
      }
      else
      {
        if (paramArrayOfString.length < 3) {
          break label221;
        }
        i = Integer.parseInt(paramArrayOfString[1]);
        j = Integer.parseInt(paramArrayOfString[2]);
      }
      int k = e(i);
      if (k == -1)
      {
        paramString = new StringBuilder(32);
        paramString.append("Unknown AVC profile: ");
        paramString.append(i);
        u.h("MediaCodecUtil", paramString.toString());
        return null;
      }
      int i = c(j);
      if (i == -1)
      {
        paramString = new StringBuilder(30);
        paramString.append("Unknown AVC level: ");
        paramString.append(j);
        u.h("MediaCodecUtil", paramString.toString());
        return null;
      }
      return new Pair(Integer.valueOf(k), Integer.valueOf(i));
      label221:
      paramArrayOfString = String.valueOf(paramString);
      if (paramArrayOfString.length() != 0) {
        paramArrayOfString = "Ignoring malformed AVC codec string: ".concat(paramArrayOfString);
      } else {
        paramArrayOfString = new String("Ignoring malformed AVC codec string: ");
      }
      u.h("MediaCodecUtil", paramArrayOfString);
      return null;
    }
    catch (NumberFormatException paramArrayOfString)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed AVC codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed AVC codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
    }
    return null;
  }
  
  @Nullable
  private static String k(MediaCodecInfo paramMediaCodecInfo, String paramString1, String paramString2)
  {
    for (paramMediaCodecInfo : paramMediaCodecInfo.getSupportedTypes()) {
      if (paramMediaCodecInfo.equalsIgnoreCase(paramString2)) {
        return paramMediaCodecInfo;
      }
    }
    if (paramString2.equals("video/dolby-vision"))
    {
      if ("OMX.MS.HEVCDV.Decoder".equals(paramString1)) {
        return "video/hevcdv";
      }
      if (("OMX.RTK.video.decoder".equals(paramString1)) || ("OMX.realtek.video.decoder.tunneled".equals(paramString1))) {
        return "video/dv_hevc";
      }
    }
    else
    {
      if ((paramString2.equals("audio/alac")) && ("OMX.lge.alac.decoder".equals(paramString1))) {
        return "audio/x-lg-alac";
      }
      if ((paramString2.equals("audio/flac")) && ("OMX.lge.flac.decoder".equals(paramString1))) {
        return "audio/x-lg-flac";
      }
    }
    return null;
  }
  
  @Nullable
  public static Pair<Integer, Integer> l(Format paramFormat)
  {
    String str = paramFormat.p1;
    if (str == null) {
      return null;
    }
    String[] arrayOfString = str.split("\\.");
    if ("video/dolby-vision".equals(paramFormat.H3)) {
      return r(paramFormat.p1, arrayOfString);
    }
    int i = 0;
    str = arrayOfString[0];
    str.hashCode();
    switch (str.hashCode())
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
                  i = -1;
                  break;
                } while (!str.equals("vp09"));
                i = 6;
                break;
              } while (!str.equals("mp4a"));
              i = 5;
              break;
            } while (!str.equals("hvc1"));
            i = 4;
            break;
          } while (!str.equals("hev1"));
          i = 3;
          break;
        } while (!str.equals("avc2"));
        i = 2;
        break;
      } while (!str.equals("avc1"));
      i = 1;
      break;
    } while (!str.equals("av01"));
    switch (i)
    {
    default: 
      return null;
    case 6: 
      return t(paramFormat.p1, arrayOfString);
    case 5: 
      return h(paramFormat.p1, arrayOfString);
    case 3: 
    case 4: 
      return s(paramFormat.p1, arrayOfString);
    case 1: 
    case 2: 
      return j(paramFormat.p1, arrayOfString);
    }
    return i(paramFormat.p1, arrayOfString, paramFormat.T3);
  }
  
  @Nullable
  public static r m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws MediaCodecUtil.DecoderQueryException
  {
    paramString = n(paramString, paramBoolean1, paramBoolean2);
    if (paramString.isEmpty()) {
      paramString = null;
    } else {
      paramString = (r)paramString.get(0);
    }
    return paramString;
  }
  
  public static List<r> n(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws MediaCodecUtil.DecoderQueryException
  {
    try
    {
      b localb = new com/google/android/exoplayer2/mediacodec/MediaCodecUtil$b;
      localb.<init>(paramString, paramBoolean1, paramBoolean2);
      HashMap localHashMap = b;
      Object localObject = (List)localHashMap.get(localb);
      if (localObject != null) {
        return (List<r>)localObject;
      }
      int i = o0.a;
      if (i >= 21)
      {
        localObject = new com/google/android/exoplayer2/mediacodec/MediaCodecUtil$e;
        ((e)localObject).<init>(paramBoolean1, paramBoolean2);
      }
      else
      {
        localObject = new d(null);
      }
      ArrayList localArrayList = o(localb, (c)localObject);
      localObject = localArrayList;
      if (paramBoolean1)
      {
        localObject = localArrayList;
        if (localArrayList.isEmpty())
        {
          localObject = localArrayList;
          if (21 <= i)
          {
            localObject = localArrayList;
            if (i <= 23)
            {
              localObject = new com/google/android/exoplayer2/mediacodec/MediaCodecUtil$d;
              ((d)localObject).<init>(null);
              localArrayList = o(localb, (c)localObject);
              localObject = localArrayList;
              if (!localArrayList.isEmpty())
              {
                localObject = ((r)localArrayList.get(0)).a;
                i = String.valueOf(paramString).length();
                int j = String.valueOf(localObject).length();
                StringBuilder localStringBuilder = new java/lang/StringBuilder;
                localStringBuilder.<init>(i + 63 + j);
                localStringBuilder.append("MediaCodecList API didn't list secure decoder for: ");
                localStringBuilder.append(paramString);
                localStringBuilder.append(". Assuming: ");
                localStringBuilder.append((String)localObject);
                u.h("MediaCodecUtil", localStringBuilder.toString());
                localObject = localArrayList;
              }
            }
          }
        }
      }
      a(paramString, (List)localObject);
      paramString = Collections.unmodifiableList((List)localObject);
      localHashMap.put(localb, paramString);
      return paramString;
    }
    finally {}
  }
  
  private static ArrayList<r> o(b paramb, c paramc)
    throws MediaCodecUtil.DecoderQueryException
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      String str1 = paramb.a;
      int i = paramc.d();
      boolean bool1 = paramc.e();
      int j = 0;
      while (j < i)
      {
        MediaCodecInfo localMediaCodecInfo = paramc.a(j);
        String str2;
        String str3;
        label356:
        StringBuilder localStringBuilder;
        if (!v(localMediaCodecInfo))
        {
          int k;
          for (;;)
          {
            str2 = localMediaCodecInfo.getName();
            if (x(localMediaCodecInfo, str2, bool1, str1))
            {
              str3 = k(localMediaCodecInfo, str2, str1);
              if (str3 != null) {
                try
                {
                  MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
                  boolean bool2 = paramc.b("tunneled-playback", str3, localCodecCapabilities);
                  boolean bool3 = paramc.c("tunneled-playback", str3, localCodecCapabilities);
                  boolean bool4 = paramb.c;
                  if (((bool4) || (!bool3)) && ((!bool4) || (bool2)))
                  {
                    bool4 = paramc.b("secure-playback", str3, localCodecCapabilities);
                    bool3 = paramc.c("secure-playback", str3, localCodecCapabilities);
                    bool2 = paramb.b;
                    if (((bool2) || (!bool3)) && ((!bool2) || (bool4)))
                    {
                      bool2 = y(localMediaCodecInfo);
                      boolean bool5 = A(localMediaCodecInfo);
                      boolean bool6 = C(localMediaCodecInfo);
                      if ((!bool1) || (paramb.b != bool4))
                      {
                        if (!bool1)
                        {
                          bool3 = paramb.b;
                          if (bool3) {}
                        }
                      }
                      else {
                        try
                        {
                          localArrayList.add(r.A(str2, str1, str3, localCodecCapabilities, bool2, bool5, bool6, false, false));
                        }
                        catch (Exception localException1)
                        {
                          break label356;
                        }
                      }
                      if ((bool1) || (!bool4)) {
                        break label437;
                      }
                      localArrayList.add(r.A(String.valueOf(str2).concat(".secure"), str1, str3, localCodecCapabilities, bool2, bool5, bool6, false, true));
                      return localArrayList;
                    }
                  }
                }
                catch (Exception localException2)
                {
                  k = o0.a;
                  if (k > 23) {
                    break label443;
                  }
                }
              }
            }
          }
          if (!localArrayList.isEmpty())
          {
            k = String.valueOf(str2).length();
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>(k + 46);
            localStringBuilder.append("Skipping codec ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" (failed to query capabilities)");
            u.c("MediaCodecUtil", localStringBuilder.toString());
          }
        }
        else
        {
          label437:
          j++;
          continue;
        }
        label443:
        j = String.valueOf(str2).length();
        i = str3.length();
        paramb = new java/lang/StringBuilder;
        paramb.<init>(j + 25 + i);
        paramb.append("Failed to query codec ");
        paramb.append(str2);
        paramb.append(" (");
        paramb.append(str3);
        paramb.append(")");
        u.c("MediaCodecUtil", paramb.toString());
        throw localStringBuilder;
      }
      return localArrayList;
    }
    catch (Exception paramb)
    {
      throw new DecoderQueryException(paramb, null);
    }
  }
  
  @CheckResult
  public static List<r> p(List<r> paramList, Format paramFormat)
  {
    paramList = new ArrayList(paramList);
    K(paramList, new g(paramFormat));
    return paramList;
  }
  
  @Nullable
  public static r q()
    throws MediaCodecUtil.DecoderQueryException
  {
    return m("audio/raw", false, false);
  }
  
  @Nullable
  private static Pair<Integer, Integer> r(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 3)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed Dolby Vision codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed Dolby Vision codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    Object localObject = a.matcher(paramArrayOfString[1]);
    if (!((Matcher)localObject).matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed Dolby Vision codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed Dolby Vision codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    localObject = ((Matcher)localObject).group(1);
    paramString = g((String)localObject);
    if (paramString == null)
    {
      paramString = String.valueOf(localObject);
      if (paramString.length() != 0) {
        paramString = "Unknown Dolby Vision profile string: ".concat(paramString);
      } else {
        paramString = new String("Unknown Dolby Vision profile string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    localObject = paramArrayOfString[2];
    paramArrayOfString = f((String)localObject);
    if (paramArrayOfString == null)
    {
      paramString = String.valueOf(localObject);
      if (paramString.length() != 0) {
        paramString = "Unknown Dolby Vision level string: ".concat(paramString);
      } else {
        paramString = new String("Unknown Dolby Vision level string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    return new Pair(paramString, paramArrayOfString);
  }
  
  @Nullable
  private static Pair<Integer, Integer> s(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 4)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed HEVC codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed HEVC codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    Object localObject = a;
    int i = 1;
    localObject = ((Pattern)localObject).matcher(paramArrayOfString[1]);
    if (!((Matcher)localObject).matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed HEVC codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed HEVC codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    paramString = ((Matcher)localObject).group(1);
    if (!"1".equals(paramString))
    {
      if ("2".equals(paramString)) {
        i = 2;
      }
    }
    else
    {
      paramArrayOfString = paramArrayOfString[3];
      paramString = u(paramArrayOfString);
      if (paramString == null)
      {
        paramString = String.valueOf(paramArrayOfString);
        if (paramString.length() != 0) {
          paramString = "Unknown HEVC level string: ".concat(paramString);
        } else {
          paramString = new String("Unknown HEVC level string: ");
        }
        u.h("MediaCodecUtil", paramString);
        return null;
      }
      return new Pair(Integer.valueOf(i), paramString);
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Unknown HEVC profile string: ".concat(paramString);
    } else {
      paramString = new String("Unknown HEVC profile string: ");
    }
    u.h("MediaCodecUtil", paramString);
    return null;
  }
  
  @Nullable
  private static Pair<Integer, Integer> t(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 3)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed VP9 codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed VP9 codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramArrayOfString[1]);
      int j = Integer.parseInt(paramArrayOfString[2]);
      int k = M(i);
      if (k == -1)
      {
        paramString = new StringBuilder(32);
        paramString.append("Unknown VP9 profile: ");
        paramString.append(i);
        u.h("MediaCodecUtil", paramString.toString());
        return null;
      }
      i = L(j);
      if (i == -1)
      {
        paramString = new StringBuilder(30);
        paramString.append("Unknown VP9 level: ");
        paramString.append(j);
        u.h("MediaCodecUtil", paramString.toString());
        return null;
      }
      return new Pair(Integer.valueOf(k), Integer.valueOf(i));
    }
    catch (NumberFormatException paramArrayOfString)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring malformed VP9 codec string: ".concat(paramString);
      } else {
        paramString = new String("Ignoring malformed VP9 codec string: ");
      }
      u.h("MediaCodecUtil", paramString);
    }
    return null;
  }
  
  @Nullable
  private static Integer u(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2312995: 
      if (paramString.equals("L186")) {
        i = 25;
      }
      break;
    case 2312992: 
      if (paramString.equals("L183")) {
        i = 24;
      }
      break;
    case 2312989: 
      if (paramString.equals("L180")) {
        i = 23;
      }
      break;
    case 2312902: 
      if (paramString.equals("L156")) {
        i = 22;
      }
      break;
    case 2312899: 
      if (paramString.equals("L153")) {
        i = 21;
      }
      break;
    case 2312896: 
      if (paramString.equals("L150")) {
        i = 20;
      }
      break;
    case 2312806: 
      if (paramString.equals("L123")) {
        i = 19;
      }
      break;
    case 2312803: 
      if (paramString.equals("L120")) {
        i = 18;
      }
      break;
    case 2193831: 
      if (paramString.equals("H186")) {
        i = 17;
      }
      break;
    case 2193828: 
      if (paramString.equals("H183")) {
        i = 16;
      }
      break;
    case 2193825: 
      if (paramString.equals("H180")) {
        i = 15;
      }
      break;
    case 2193738: 
      if (paramString.equals("H156")) {
        i = 14;
      }
      break;
    case 2193735: 
      if (paramString.equals("H153")) {
        i = 13;
      }
      break;
    case 2193732: 
      if (paramString.equals("H150")) {
        i = 12;
      }
      break;
    case 2193642: 
      if (paramString.equals("H123")) {
        i = 11;
      }
      break;
    case 2193639: 
      if (paramString.equals("H120")) {
        i = 10;
      }
      break;
    case 74854: 
      if (paramString.equals("L93")) {
        i = 9;
      }
      break;
    case 74851: 
      if (paramString.equals("L90")) {
        i = 8;
      }
      break;
    case 74761: 
      if (paramString.equals("L63")) {
        i = 7;
      }
      break;
    case 74758: 
      if (paramString.equals("L60")) {
        i = 6;
      }
      break;
    case 74665: 
      if (paramString.equals("L30")) {
        i = 5;
      }
      break;
    case 71010: 
      if (paramString.equals("H93")) {
        i = 4;
      }
      break;
    case 71007: 
      if (paramString.equals("H90")) {
        i = 3;
      }
      break;
    case 70917: 
      if (paramString.equals("H63")) {
        i = 2;
      }
      break;
    case 70914: 
      if (paramString.equals("H60")) {
        i = 1;
      }
      break;
    case 70821: 
      if (paramString.equals("H30")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 25: 
      return Integer.valueOf(16777216);
    case 24: 
      return Integer.valueOf(4194304);
    case 23: 
      return Integer.valueOf(1048576);
    case 22: 
      return Integer.valueOf(262144);
    case 21: 
      return Integer.valueOf(65536);
    case 20: 
      return Integer.valueOf(16384);
    case 19: 
      return Integer.valueOf(4096);
    case 18: 
      return Integer.valueOf(1024);
    case 17: 
      return Integer.valueOf(33554432);
    case 16: 
      return Integer.valueOf(8388608);
    case 15: 
      return Integer.valueOf(2097152);
    case 14: 
      return Integer.valueOf(524288);
    case 13: 
      return Integer.valueOf(131072);
    case 12: 
      return Integer.valueOf(32768);
    case 11: 
      return Integer.valueOf(8192);
    case 10: 
      return Integer.valueOf(2048);
    case 9: 
      return Integer.valueOf(256);
    case 8: 
      return Integer.valueOf(64);
    case 7: 
      return Integer.valueOf(16);
    case 6: 
      return Integer.valueOf(4);
    case 5: 
      return Integer.valueOf(1);
    case 4: 
      return Integer.valueOf(512);
    case 3: 
      return Integer.valueOf(128);
    case 2: 
      return Integer.valueOf(32);
    case 1: 
      return Integer.valueOf(8);
    }
    return Integer.valueOf(2);
  }
  
  private static boolean v(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool;
    if ((o0.a >= 29) && (w(paramMediaCodecInfo))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(29)
  private static boolean w(MediaCodecInfo paramMediaCodecInfo)
  {
    return paramMediaCodecInfo.isAlias();
  }
  
  private static boolean x(MediaCodecInfo paramMediaCodecInfo, String paramString1, boolean paramBoolean, String paramString2)
  {
    if ((!paramMediaCodecInfo.isEncoder()) && ((paramBoolean) || (!paramString1.endsWith(".secure"))))
    {
      int i = o0.a;
      if ((i < 21) && (("CIPAACDecoder".equals(paramString1)) || ("CIPMP3Decoder".equals(paramString1)) || ("CIPVorbisDecoder".equals(paramString1)) || ("CIPAMRNBDecoder".equals(paramString1)) || ("AACDecoder".equals(paramString1)) || ("MP3Decoder".equals(paramString1)))) {
        return false;
      }
      if ((i < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(paramString1)))
      {
        paramMediaCodecInfo = o0.b;
        if (("a70".equals(paramMediaCodecInfo)) || (("Xiaomi".equals(o0.c)) && (paramMediaCodecInfo.startsWith("HM")))) {
          return false;
        }
      }
      if ((i == 16) && ("OMX.qcom.audio.decoder.mp3".equals(paramString1)))
      {
        paramMediaCodecInfo = o0.b;
        if (("dlxu".equals(paramMediaCodecInfo)) || ("protou".equals(paramMediaCodecInfo)) || ("ville".equals(paramMediaCodecInfo)) || ("villeplus".equals(paramMediaCodecInfo)) || ("villec2".equals(paramMediaCodecInfo)) || (paramMediaCodecInfo.startsWith("gee")) || ("C6602".equals(paramMediaCodecInfo)) || ("C6603".equals(paramMediaCodecInfo)) || ("C6606".equals(paramMediaCodecInfo)) || ("C6616".equals(paramMediaCodecInfo)) || ("L36h".equals(paramMediaCodecInfo)) || ("SO-02E".equals(paramMediaCodecInfo))) {
          return false;
        }
      }
      if ((i == 16) && ("OMX.qcom.audio.decoder.aac".equals(paramString1)))
      {
        paramMediaCodecInfo = o0.b;
        if (("C1504".equals(paramMediaCodecInfo)) || ("C1505".equals(paramMediaCodecInfo)) || ("C1604".equals(paramMediaCodecInfo)) || ("C1605".equals(paramMediaCodecInfo))) {
          return false;
        }
      }
      if ((i < 24) && (("OMX.SEC.aac.dec".equals(paramString1)) || ("OMX.Exynos.AAC.Decoder".equals(paramString1))) && ("samsung".equals(o0.c)))
      {
        paramMediaCodecInfo = o0.b;
        if ((paramMediaCodecInfo.startsWith("zeroflte")) || (paramMediaCodecInfo.startsWith("zerolte")) || (paramMediaCodecInfo.startsWith("zenlte")) || ("SC-05G".equals(paramMediaCodecInfo)) || ("marinelteatt".equals(paramMediaCodecInfo)) || ("404SC".equals(paramMediaCodecInfo)) || ("SC-04G".equals(paramMediaCodecInfo)) || ("SCV31".equals(paramMediaCodecInfo))) {
          return false;
        }
      }
      if ((i <= 19) && ("OMX.SEC.vp8.dec".equals(paramString1)) && ("samsung".equals(o0.c)))
      {
        paramMediaCodecInfo = o0.b;
        if ((paramMediaCodecInfo.startsWith("d2")) || (paramMediaCodecInfo.startsWith("serrano")) || (paramMediaCodecInfo.startsWith("jflte")) || (paramMediaCodecInfo.startsWith("santos")) || (paramMediaCodecInfo.startsWith("t0"))) {
          return false;
        }
      }
      if ((i <= 19) && (o0.b.startsWith("jflte")) && ("OMX.qcom.video.decoder.vp8".equals(paramString1))) {
        return false;
      }
      return (!"audio/eac3-joc".equals(paramString2)) || (!"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(paramString1));
    }
    return false;
  }
  
  private static boolean y(MediaCodecInfo paramMediaCodecInfo)
  {
    if (o0.a >= 29) {
      return z(paramMediaCodecInfo);
    }
    return A(paramMediaCodecInfo) ^ true;
  }
  
  @RequiresApi(29)
  private static boolean z(MediaCodecInfo paramMediaCodecInfo)
  {
    return paramMediaCodecInfo.isHardwareAccelerated();
  }
  
  public static class DecoderQueryException
    extends Exception
  {
    private DecoderQueryException(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  private static final class b
  {
    public final String a;
    public final boolean b;
    public final boolean c;
    
    public b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramString;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (paramObject.getClass() == b.class))
      {
        paramObject = (b)paramObject;
        if ((!TextUtils.equals(this.a, ((b)paramObject).a)) || (this.b != ((b)paramObject).b) || (this.c != ((b)paramObject).c)) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = this.a.hashCode();
      boolean bool = this.b;
      int j = 1231;
      int k;
      if (bool) {
        k = 1231;
      } else {
        k = 1237;
      }
      if (!this.c) {
        j = 1237;
      }
      return ((i + 31) * 31 + k) * 31 + j;
    }
  }
  
  private static abstract interface c
  {
    public abstract MediaCodecInfo a(int paramInt);
    
    public abstract boolean b(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);
    
    public abstract boolean c(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);
    
    public abstract int d();
    
    public abstract boolean e();
  }
  
  private static final class d
    implements MediaCodecUtil.c
  {
    public MediaCodecInfo a(int paramInt)
    {
      return MediaCodecList.getCodecInfoAt(paramInt);
    }
    
    public boolean b(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      boolean bool;
      if (("secure-playback".equals(paramString1)) && ("video/avc".equals(paramString2))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean c(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      return false;
    }
    
    public int d()
    {
      return MediaCodecList.getCodecCount();
    }
    
    public boolean e()
    {
      return false;
    }
  }
  
  @RequiresApi(21)
  private static final class e
    implements MediaCodecUtil.c
  {
    private final int a;
    @Nullable
    private MediaCodecInfo[] b;
    
    public e(boolean paramBoolean1, boolean paramBoolean2)
    {
      int i;
      if ((!paramBoolean1) && (!paramBoolean2)) {
        i = 0;
      } else {
        i = 1;
      }
      this.a = i;
    }
    
    @EnsuresNonNull({"mediaCodecInfos"})
    private void f()
    {
      if (this.b == null) {
        this.b = new MediaCodecList(this.a).getCodecInfos();
      }
    }
    
    public MediaCodecInfo a(int paramInt)
    {
      f();
      return this.b[paramInt];
    }
    
    public boolean b(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      return paramCodecCapabilities.isFeatureSupported(paramString1);
    }
    
    public boolean c(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      return paramCodecCapabilities.isFeatureRequired(paramString1);
    }
    
    public int d()
    {
      f();
      return this.b.length;
    }
    
    public boolean e()
    {
      return true;
    }
  }
  
  private static abstract interface f<T>
  {
    public abstract int a(T paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\MediaCodecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */