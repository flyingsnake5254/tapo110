package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;
import android.util.Range;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;

public final class r
{
  public final String a;
  public final String b;
  public final String c;
  @Nullable
  public final MediaCodecInfo.CodecCapabilities d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  private final boolean k;
  
  @VisibleForTesting
  r(String paramString1, String paramString2, String paramString3, @Nullable MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.a = ((String)g.e(paramString1));
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramCodecCapabilities;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramBoolean3;
    this.e = paramBoolean4;
    this.f = paramBoolean5;
    this.g = paramBoolean6;
    this.k = y.q(paramString2);
  }
  
  public static r A(String paramString1, String paramString2, String paramString3, @Nullable MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if ((!paramBoolean4) && (paramCodecCapabilities != null) && (h(paramCodecCapabilities)) && (!y(paramString1))) {
      paramBoolean4 = true;
    } else {
      paramBoolean4 = false;
    }
    boolean bool;
    if ((paramCodecCapabilities != null) && (r(paramCodecCapabilities))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!paramBoolean5) && ((paramCodecCapabilities == null) || (!p(paramCodecCapabilities)))) {
      paramBoolean5 = false;
    } else {
      paramBoolean5 = true;
    }
    return new r(paramString1, paramString2, paramString3, paramCodecCapabilities, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, bool, paramBoolean5);
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt <= 1) && ((o0.a < 26) || (paramInt <= 0)) && (!"audio/mpeg".equals(paramString2)) && (!"audio/3gpp".equals(paramString2)) && (!"audio/amr-wb".equals(paramString2)) && (!"audio/mp4a-latm".equals(paramString2)) && (!"audio/vorbis".equals(paramString2)) && (!"audio/opus".equals(paramString2)) && (!"audio/raw".equals(paramString2)) && (!"audio/flac".equals(paramString2)) && (!"audio/g711-alaw".equals(paramString2)) && (!"audio/g711-mlaw".equals(paramString2)) && (!"audio/gsm".equals(paramString2)))
    {
      int m;
      if ("audio/ac3".equals(paramString2)) {
        m = 6;
      } else if ("audio/eac3".equals(paramString2)) {
        m = 16;
      } else {
        m = 30;
      }
      paramString2 = new StringBuilder(String.valueOf(paramString1).length() + 59);
      paramString2.append("AssumedMaxChannelAdjustment: ");
      paramString2.append(paramString1);
      paramString2.append(", [");
      paramString2.append(paramInt);
      paramString2.append(" to ");
      paramString2.append(m);
      paramString2.append("]");
      u.h("MediaCodecInfo", paramString2.toString());
      return m;
    }
    return paramInt;
  }
  
  @RequiresApi(21)
  private static Point c(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2)
  {
    int m = paramVideoCapabilities.getWidthAlignment();
    int n = paramVideoCapabilities.getHeightAlignment();
    return new Point(o0.k(paramInt1, m) * m, o0.k(paramInt2, n) * n);
  }
  
  @RequiresApi(21)
  private static boolean d(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    Point localPoint = c(paramVideoCapabilities, paramInt1, paramInt2);
    paramInt2 = localPoint.x;
    paramInt1 = localPoint.y;
    if ((paramDouble != -1.0D) && (paramDouble >= 1.0D)) {
      return paramVideoCapabilities.areSizeAndRateSupported(paramInt2, paramInt1, Math.floor(paramDouble));
    }
    return paramVideoCapabilities.isSizeSupported(paramInt2, paramInt1);
  }
  
  private static MediaCodecInfo.CodecProfileLevel[] f(@Nullable MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    if (paramCodecCapabilities != null)
    {
      paramCodecCapabilities = paramCodecCapabilities.getVideoCapabilities();
      if (paramCodecCapabilities != null)
      {
        m = ((Integer)paramCodecCapabilities.getBitrateRange().getUpper()).intValue();
        break label32;
      }
    }
    int m = 0;
    label32:
    if (m >= 180000000) {
      m = 1024;
    } else if (m >= 120000000) {
      m = 512;
    } else if (m >= 60000000) {
      m = 256;
    } else if (m >= 30000000) {
      m = 128;
    } else if (m >= 18000000) {
      m = 64;
    } else if (m >= 12000000) {
      m = 32;
    } else if (m >= 7200000) {
      m = 16;
    } else if (m >= 3600000) {
      m = 8;
    } else if (m >= 1800000) {
      m = 4;
    } else if (m >= 800000) {
      m = 2;
    } else {
      m = 1;
    }
    paramCodecCapabilities = new MediaCodecInfo.CodecProfileLevel();
    paramCodecCapabilities.profile = 1;
    paramCodecCapabilities.level = m;
    return new MediaCodecInfo.CodecProfileLevel[] { paramCodecCapabilities };
  }
  
  private static boolean h(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    boolean bool;
    if ((o0.a >= 19) && (i(paramCodecCapabilities))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(19)
  private static boolean i(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("adaptive-playback");
  }
  
  private static boolean p(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    boolean bool;
    if ((o0.a >= 21) && (q(paramCodecCapabilities))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(21)
  private static boolean q(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  private static boolean r(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    boolean bool;
    if ((o0.a >= 21) && (s(paramCodecCapabilities))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(21)
  private static boolean s(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("tunneled-playback");
  }
  
  private void u(String paramString)
  {
    String str1 = this.a;
    String str2 = this.b;
    String str3 = o0.e;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 25 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append("AssumedSupport [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] [");
    localStringBuilder.append(str1);
    localStringBuilder.append(", ");
    localStringBuilder.append(str2);
    localStringBuilder.append("] [");
    localStringBuilder.append(str3);
    localStringBuilder.append("]");
    u.b("MediaCodecInfo", localStringBuilder.toString());
  }
  
  private void v(String paramString)
  {
    String str1 = this.a;
    String str2 = this.b;
    String str3 = o0.e;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 20 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append("NoSupport [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] [");
    localStringBuilder.append(str1);
    localStringBuilder.append(", ");
    localStringBuilder.append(str2);
    localStringBuilder.append("] [");
    localStringBuilder.append(str3);
    localStringBuilder.append("]");
    u.b("MediaCodecInfo", localStringBuilder.toString());
  }
  
  private static boolean w(String paramString)
  {
    return "audio/opus".equals(paramString);
  }
  
  private static boolean x(String paramString)
  {
    boolean bool;
    if ((o0.d.startsWith("SM-T230")) && ("OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean y(String paramString)
  {
    if (o0.a <= 22)
    {
      String str = o0.d;
      if ((("ODROID-XU3".equals(str)) || ("Nexus 10".equals(str))) && (("OMX.Exynos.AVC.Decoder".equals(paramString)) || ("OMX.Exynos.AVC.Decoder.secure".equals(paramString)))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private static final boolean z(String paramString)
  {
    return (!"OMX.MTK.VIDEO.DECODER.HEVC".equals(paramString)) || (!"mcv5a".equals(o0.b));
  }
  
  @Nullable
  @RequiresApi(21)
  public Point b(int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return null;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
    if (localObject == null) {
      return null;
    }
    return c((MediaCodecInfo.VideoCapabilities)localObject, paramInt1, paramInt2);
  }
  
  public e e(Format paramFormat1, Format paramFormat2)
  {
    int m;
    if (!o0.b(paramFormat1.H3, paramFormat2.H3)) {
      m = 8;
    } else {
      m = 0;
    }
    int n;
    Object localObject;
    if (this.k)
    {
      n = m;
      if (paramFormat1.P3 != paramFormat2.P3) {
        n = m | 0x400;
      }
      m = n;
      if (!this.e) {
        if (paramFormat1.M3 == paramFormat2.M3)
        {
          m = n;
          if (paramFormat1.N3 == paramFormat2.N3) {}
        }
        else
        {
          m = n | 0x200;
        }
      }
      n = m;
      if (!o0.b(paramFormat1.T3, paramFormat2.T3)) {
        n = m | 0x800;
      }
      m = n;
      if (x(this.a))
      {
        m = n;
        if (!paramFormat1.d(paramFormat2)) {
          m = n | 0x2;
        }
      }
      n = m;
      if (m == 0)
      {
        localObject = this.a;
        if (paramFormat1.d(paramFormat2)) {
          m = 3;
        } else {
          m = 2;
        }
        return new e((String)localObject, paramFormat1, paramFormat2, m, 0);
      }
    }
    for (;;)
    {
      break;
      int i1 = m;
      if (paramFormat1.U3 != paramFormat2.U3) {
        i1 = m | 0x1000;
      }
      n = i1;
      if (paramFormat1.V3 != paramFormat2.V3) {
        n = i1 | 0x2000;
      }
      m = n;
      if (paramFormat1.W3 != paramFormat2.W3) {
        m = n | 0x4000;
      }
      if ((m == 0) && ("audio/mp4a-latm".equals(this.b)))
      {
        Pair localPair = MediaCodecUtil.l(paramFormat1);
        localObject = MediaCodecUtil.l(paramFormat2);
        if ((localPair != null) && (localObject != null))
        {
          i1 = ((Integer)localPair.first).intValue();
          n = ((Integer)((Pair)localObject).first).intValue();
          if ((i1 == 42) && (n == 42)) {
            return new e(this.a, paramFormat1, paramFormat2, 3, 0);
          }
        }
      }
      n = m;
      if (!paramFormat1.d(paramFormat2)) {
        n = m | 0x20;
      }
      m = n;
      if (w(this.b)) {
        m = n | 0x2;
      }
      n = m;
      if (m == 0) {
        return new e(this.a, paramFormat1, paramFormat2, 1, 0);
      }
    }
    return new e(this.a, paramFormat1, paramFormat2, 0, n);
  }
  
  public MediaCodecInfo.CodecProfileLevel[] g()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels;
      localObject = arrayOfCodecProfileLevel;
      if (arrayOfCodecProfileLevel != null) {}
    }
    else
    {
      localObject = new MediaCodecInfo.CodecProfileLevel[0];
    }
    return (MediaCodecInfo.CodecProfileLevel[])localObject;
  }
  
  @RequiresApi(21)
  public boolean j(int paramInt)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      v("channelCount.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getAudioCapabilities();
    if (localObject == null)
    {
      v("channelCount.aCaps");
      return false;
    }
    if (a(this.a, this.b, ((MediaCodecInfo.AudioCapabilities)localObject).getMaxInputChannelCount()) < paramInt)
    {
      localObject = new StringBuilder(33);
      ((StringBuilder)localObject).append("channelCount.support, ");
      ((StringBuilder)localObject).append(paramInt);
      v(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  @RequiresApi(21)
  public boolean k(int paramInt)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      v("sampleRate.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getAudioCapabilities();
    if (localObject == null)
    {
      v("sampleRate.aCaps");
      return false;
    }
    if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(paramInt))
    {
      localObject = new StringBuilder(31);
      ((StringBuilder)localObject).append("sampleRate.support, ");
      ((StringBuilder)localObject).append(paramInt);
      v(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public boolean l(Format paramFormat)
  {
    Object localObject = paramFormat.p1;
    if ((localObject != null) && (this.b != null))
    {
      String str = y.g((String)localObject);
      if (str == null) {
        return true;
      }
      if (!this.b.equals(str))
      {
        paramFormat = paramFormat.p1;
        localObject = new StringBuilder(String.valueOf(paramFormat).length() + 13 + str.length());
        ((StringBuilder)localObject).append("codec.mime ");
        ((StringBuilder)localObject).append(paramFormat);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(str);
        v(((StringBuilder)localObject).toString());
        return false;
      }
      localObject = MediaCodecUtil.l(paramFormat);
      if (localObject == null) {
        return true;
      }
      int m = ((Integer)((Pair)localObject).first).intValue();
      int n = ((Integer)((Pair)localObject).second).intValue();
      if ((!this.k) && (m != 42)) {
        return true;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = g();
      localObject = arrayOfCodecProfileLevel;
      if (o0.a <= 23)
      {
        localObject = arrayOfCodecProfileLevel;
        if ("video/x-vnd.on2.vp9".equals(this.b))
        {
          localObject = arrayOfCodecProfileLevel;
          if (arrayOfCodecProfileLevel.length != 0) {}
        }
      }
      for (arrayOfCodecProfileLevel : f(this.d)) {
        if ((arrayOfCodecProfileLevel.profile == m) && (arrayOfCodecProfileLevel.level >= n)) {
          return true;
        }
      }
      localObject = paramFormat.p1;
      paramFormat = new StringBuilder(String.valueOf(localObject).length() + 22 + str.length());
      paramFormat.append("codec.profileLevel, ");
      paramFormat.append((String)localObject);
      paramFormat.append(", ");
      paramFormat.append(str);
      v(paramFormat.toString());
      return false;
    }
    return true;
  }
  
  public boolean m(Format paramFormat)
    throws MediaCodecUtil.DecoderQueryException
  {
    boolean bool1 = l(paramFormat);
    boolean bool2 = false;
    boolean bool3 = false;
    if (!bool1) {
      return false;
    }
    int n;
    if (this.k)
    {
      int m = paramFormat.M3;
      if (m > 0)
      {
        n = paramFormat.N3;
        if (n > 0)
        {
          if (o0.a >= 21) {
            return t(m, n, paramFormat.O3);
          }
          if (m * n <= MediaCodecUtil.I()) {
            bool3 = true;
          }
          if (!bool3)
          {
            m = paramFormat.M3;
            n = paramFormat.N3;
            paramFormat = new StringBuilder(40);
            paramFormat.append("legacyFrameSize, ");
            paramFormat.append(m);
            paramFormat.append("x");
            paramFormat.append(n);
            v(paramFormat.toString());
          }
          return bool3;
        }
      }
      return true;
    }
    if (o0.a >= 21)
    {
      n = paramFormat.V3;
      if (n != -1)
      {
        bool3 = bool2;
        if (!k(n)) {
          break label214;
        }
      }
      n = paramFormat.U3;
      if (n != -1)
      {
        bool3 = bool2;
        if (!j(n)) {
          break label214;
        }
      }
    }
    bool3 = true;
    label214:
    return bool3;
  }
  
  public boolean n()
  {
    if ((o0.a >= 29) && ("video/x-vnd.on2.vp9".equals(this.b)))
    {
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = g();
      int m = arrayOfCodecProfileLevel.length;
      for (int n = 0; n < m; n++) {
        if (arrayOfCodecProfileLevel[n].profile == 16384) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean o(Format paramFormat)
  {
    if (this.k) {
      return this.e;
    }
    paramFormat = MediaCodecUtil.l(paramFormat);
    boolean bool;
    if ((paramFormat != null) && (((Integer)paramFormat.first).intValue() == 42)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(21)
  public boolean t(int paramInt1, int paramInt2, double paramDouble)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      v("sizeAndRate.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
    if (localObject == null)
    {
      v("sizeAndRate.vCaps");
      return false;
    }
    if (!d((MediaCodecInfo.VideoCapabilities)localObject, paramInt1, paramInt2, paramDouble)) {
      if ((paramInt1 < paramInt2) && (z(this.a)) && (d((MediaCodecInfo.VideoCapabilities)localObject, paramInt2, paramInt1, paramDouble)))
      {
        localObject = new StringBuilder(69);
        ((StringBuilder)localObject).append("sizeAndRate.rotated, ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramDouble);
        u(((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder(69);
        ((StringBuilder)localObject).append("sizeAndRate.support, ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramDouble);
        v(((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */