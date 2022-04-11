package com.google.android.exoplayer2.o2.j0;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.f0;
import com.google.android.exoplayer2.audio.m.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class f
{
  private static final byte[] a = o0.e0("OpusHead");
  
  public static Pair<Metadata, Metadata> A(e.b paramb)
  {
    d0 locald0 = paramb.b;
    locald0.P(8);
    paramb = null;
    Metadata localMetadata = null;
    while (locald0.a() >= 8)
    {
      int i = locald0.e();
      int j = locald0.n();
      int k = locald0.n();
      Object localObject;
      if (k == 1835365473)
      {
        locald0.P(i);
        localObject = B(locald0, i + j);
      }
      else
      {
        localObject = paramb;
        if (k == 1936553057)
        {
          locald0.P(i);
          localMetadata = t(locald0, i + j);
          localObject = paramb;
        }
      }
      locald0.P(i + j);
      paramb = (e.b)localObject;
    }
    return Pair.create(paramb, localMetadata);
  }
  
  @Nullable
  private static Metadata B(d0 paramd0, int paramInt)
  {
    paramd0.Q(8);
    d(paramd0);
    while (paramd0.e() < paramInt)
    {
      int i = paramd0.e();
      int j = paramd0.n();
      if (paramd0.n() == 1768715124)
      {
        paramd0.P(i);
        return k(paramd0, i + j);
      }
      paramd0.P(i + j);
    }
    return null;
  }
  
  private static void C(d0 paramd0, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @Nullable DrmInitData paramDrmInitData, c paramc, int paramInt6)
    throws ParserException
  {
    Object localObject1 = paramd0;
    int i = paramInt2;
    ((d0)localObject1).P(i + 8 + 8);
    ((d0)localObject1).Q(16);
    int j = paramd0.J();
    int k = paramd0.J();
    ((d0)localObject1).Q(50);
    int m = paramd0.e();
    Object localObject2 = paramDrmInitData;
    int n = paramInt1;
    if (paramInt1 == 1701733238)
    {
      localObject3 = r((d0)localObject1, i, paramInt3);
      localObject2 = paramDrmInitData;
      if (localObject3 != null)
      {
        paramInt1 = ((Integer)((Pair)localObject3).first).intValue();
        if (paramDrmInitData == null) {
          localObject2 = null;
        } else {
          localObject2 = paramDrmInitData.c(((p)((Pair)localObject3).second).b);
        }
        paramc.a[paramInt6] = ((p)((Pair)localObject3).second);
      }
      ((d0)localObject1).P(m);
      n = paramInt1;
    }
    String str = "video/3gpp";
    if (n == 1831958048) {
      localObject1 = "video/mpeg";
    } else if (n == 1211250227) {
      localObject1 = "video/3gpp";
    } else {
      localObject1 = null;
    }
    paramInt6 = -1;
    float f1 = 1.0F;
    Object localObject3 = null;
    paramDrmInitData = null;
    Object localObject4 = null;
    Object localObject5 = null;
    i = 0;
    Object localObject6 = localObject1;
    Object localObject7 = localObject2;
    for (;;)
    {
      paramInt1 = paramInt3;
      int i1 = paramInt2;
      Object localObject8 = paramd0;
      if (m - i1 >= paramInt1) {
        break;
      }
      ((d0)localObject8).P(m);
      int i2 = paramd0.e();
      int i3 = paramd0.n();
      if ((i3 == 0) && (paramd0.e() - i1 == paramInt1)) {
        break;
      }
      boolean bool;
      if (i3 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.o2.m.a(bool, "childAtomSize must be positive");
      i1 = paramd0.n();
      if (i1 == 1635148611)
      {
        if (localObject6 == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.google.android.exoplayer2.o2.m.a(bool, null);
        ((d0)localObject8).P(i2 + 8);
        localObject1 = com.google.android.exoplayer2.video.m.b(paramd0);
        paramDrmInitData = ((com.google.android.exoplayer2.video.m)localObject1).a;
        paramc.c = ((com.google.android.exoplayer2.video.m)localObject1).b;
        if (i == 0) {
          f1 = ((com.google.android.exoplayer2.video.m)localObject1).e;
        }
        localObject3 = ((com.google.android.exoplayer2.video.m)localObject1).f;
        localObject1 = "video/avc";
      }
      else
      {
        if (i1 != 1752589123) {
          break label487;
        }
        if (localObject6 == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.google.android.exoplayer2.o2.m.a(bool, null);
        ((d0)localObject8).P(i2 + 8);
        localObject1 = com.google.android.exoplayer2.video.p.a(paramd0);
        paramDrmInitData = ((com.google.android.exoplayer2.video.p)localObject1).a;
        paramc.c = ((com.google.android.exoplayer2.video.p)localObject1).b;
        localObject3 = ((com.google.android.exoplayer2.video.p)localObject1).c;
        localObject1 = "video/hevc";
      }
      Object localObject9 = localObject4;
      localObject2 = paramDrmInitData;
      float f2 = f1;
      Object localObject10 = localObject3;
      paramInt1 = paramInt6;
      for (;;)
      {
        localObject3 = localObject10;
        localObject10 = localObject5;
        i1 = i;
        break label1347;
        label487:
        if ((i1 == 1685480259) || (i1 == 1685485123)) {
          break label1274;
        }
        if (i1 == 1987076931)
        {
          if (localObject6 == null) {
            bool = true;
          } else {
            bool = false;
          }
          com.google.android.exoplayer2.o2.m.a(bool, null);
          if (n == 1987063864)
          {
            localObject1 = "video/x-vnd.on2.vp8";
            break;
          }
          localObject1 = "video/x-vnd.on2.vp9";
          break;
        }
        if (i1 == 1635135811)
        {
          if (localObject6 == null) {
            bool = true;
          } else {
            bool = false;
          }
          com.google.android.exoplayer2.o2.m.a(bool, null);
          localObject1 = "video/av01";
          paramInt1 = paramInt6;
          f2 = f1;
          localObject2 = paramDrmInitData;
          localObject9 = localObject4;
          localObject10 = localObject5;
          i1 = i;
          break label1347;
        }
        if (i1 == 1681012275)
        {
          if (localObject6 == null) {
            bool = true;
          } else {
            bool = false;
          }
          com.google.android.exoplayer2.o2.m.a(bool, null);
          localObject1 = str;
          paramInt1 = paramInt6;
          f2 = f1;
          localObject2 = paramDrmInitData;
          localObject9 = localObject4;
          localObject10 = localObject5;
          i1 = i;
          break label1347;
        }
        if (i1 == 1702061171)
        {
          if (localObject6 == null) {
            bool = true;
          } else {
            bool = false;
          }
          com.google.android.exoplayer2.o2.m.a(bool, null);
          localObject2 = h((d0)localObject8, i2);
          localObject1 = (String)((Pair)localObject2).first;
          localObject2 = (byte[])((Pair)localObject2).second;
          if (localObject2 != null) {
            paramDrmInitData = ImmutableList.of(localObject2);
          }
          paramInt1 = paramInt6;
          localObject10 = localObject3;
          f2 = f1;
          localObject2 = paramDrmInitData;
          localObject9 = localObject4;
        }
        else
        {
          if (i1 == 1885434736)
          {
            f2 = p((d0)localObject8, i2);
            i1 = 1;
            localObject1 = localObject6;
            paramInt1 = paramInt6;
            localObject2 = paramDrmInitData;
            localObject9 = localObject4;
            localObject10 = localObject5;
            break label1347;
          }
          if (i1 == 1937126244)
          {
            localObject9 = q((d0)localObject8, i2, i3);
            localObject1 = localObject6;
            paramInt1 = paramInt6;
            localObject10 = localObject3;
            f2 = f1;
            localObject2 = paramDrmInitData;
          }
          else if (i1 == 1936995172)
          {
            i1 = paramd0.D();
            ((d0)localObject8).Q(3);
            localObject1 = localObject6;
            paramInt1 = paramInt6;
            localObject10 = localObject3;
            f2 = f1;
            localObject2 = paramDrmInitData;
            localObject9 = localObject4;
            if (i1 == 0)
            {
              paramInt1 = paramd0.D();
              if (paramInt1 != 0)
              {
                if (paramInt1 != 1)
                {
                  if (paramInt1 != 2)
                  {
                    if (paramInt1 != 3)
                    {
                      localObject1 = localObject6;
                      paramInt1 = paramInt6;
                      localObject10 = localObject3;
                      f2 = f1;
                      localObject2 = paramDrmInitData;
                      localObject9 = localObject4;
                    }
                    else
                    {
                      paramInt1 = 3;
                      localObject1 = localObject6;
                      localObject10 = localObject3;
                      f2 = f1;
                      localObject2 = paramDrmInitData;
                      localObject9 = localObject4;
                    }
                  }
                  else
                  {
                    paramInt1 = 2;
                    localObject1 = localObject6;
                    localObject10 = localObject3;
                    f2 = f1;
                    localObject2 = paramDrmInitData;
                    localObject9 = localObject4;
                  }
                }
                else
                {
                  paramInt1 = 1;
                  localObject1 = localObject6;
                  localObject10 = localObject3;
                  f2 = f1;
                  localObject2 = paramDrmInitData;
                  localObject9 = localObject4;
                }
              }
              else
              {
                paramInt1 = 0;
                localObject1 = localObject6;
                localObject10 = localObject3;
                f2 = f1;
                localObject2 = paramDrmInitData;
                localObject9 = localObject4;
              }
            }
          }
          else
          {
            localObject1 = localObject6;
            paramInt1 = paramInt6;
            localObject10 = localObject3;
            f2 = f1;
            localObject2 = paramDrmInitData;
            localObject9 = localObject4;
            if (i1 == 1668246642)
            {
              i1 = paramd0.n();
              if (i1 == 1852009592) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              }
              if ((paramInt1 != 0) || (i1 == 1852009571)) {
                break label1172;
              }
              localObject1 = String.valueOf(e.a(i1));
              if (((String)localObject1).length() != 0) {
                localObject1 = "Unsupported color type: ".concat((String)localObject1);
              } else {
                localObject1 = new String("Unsupported color type: ");
              }
              com.google.android.exoplayer2.util.u.h("AtomParsers", (String)localObject1);
              localObject1 = localObject6;
              paramInt1 = paramInt6;
              localObject10 = localObject3;
              f2 = f1;
              localObject2 = paramDrmInitData;
              localObject9 = localObject4;
            }
          }
        }
      }
      label1172:
      i2 = paramd0.J();
      i1 = paramd0.J();
      ((d0)localObject8).Q(2);
      if ((paramInt1 != 0) && ((paramd0.D() & 0x80) != 0)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      i2 = ColorInfo.a(i2);
      if (paramInt1 != 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      localObject10 = new ColorInfo(i2, paramInt1, ColorInfo.b(i1), null);
      localObject1 = localObject6;
      paramInt1 = paramInt6;
      f2 = f1;
      localObject2 = paramDrmInitData;
      localObject9 = localObject4;
      i1 = i;
      break label1347;
      label1274:
      localObject8 = com.google.android.exoplayer2.video.n.a(paramd0);
      localObject1 = localObject6;
      paramInt1 = paramInt6;
      f2 = f1;
      localObject2 = paramDrmInitData;
      localObject9 = localObject4;
      localObject10 = localObject5;
      i1 = i;
      if (localObject8 != null)
      {
        localObject3 = ((com.google.android.exoplayer2.video.n)localObject8).c;
        localObject1 = "video/dolby-vision";
        i1 = i;
        localObject10 = localObject5;
        localObject9 = localObject4;
        localObject2 = paramDrmInitData;
        f2 = f1;
        paramInt1 = paramInt6;
      }
      label1347:
      m += i3;
      localObject6 = localObject1;
      paramInt6 = paramInt1;
      f1 = f2;
      paramDrmInitData = (DrmInitData)localObject2;
      localObject4 = localObject9;
      localObject5 = localObject10;
      i = i1;
    }
    if (localObject6 == null) {
      return;
    }
    paramc.b = new Format.b().R(paramInt4).e0((String)localObject6).I((String)localObject3).j0(j).Q(k).a0(f1).d0(paramInt5).b0((byte[])localObject4).h0(paramInt6).T(paramDrmInitData).L((DrmInitData)localObject7).J((ColorInfo)localObject5).E();
  }
  
  private static boolean a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3)
  {
    int i = paramArrayOfLong.length;
    boolean bool = true;
    int j = i - 1;
    i = o0.p(4, 0, j);
    j = o0.p(paramArrayOfLong.length - 4, 0, j);
    if ((paramArrayOfLong[0] > paramLong2) || (paramLong2 >= paramArrayOfLong[i]) || (paramArrayOfLong[j] >= paramLong3) || (paramLong3 > paramLong1)) {
      bool = false;
    }
    return bool;
  }
  
  private static int b(d0 paramd0, int paramInt1, int paramInt2)
    throws ParserException
  {
    int i = paramd0.e();
    while (i - paramInt1 < paramInt2)
    {
      paramd0.P(i);
      int j = paramd0.n();
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.o2.m.a(bool, "childAtomSize must be positive");
      if (paramd0.n() == 1702061171) {
        return i;
      }
      i += j;
    }
    return -1;
  }
  
  private static int c(int paramInt)
  {
    if (paramInt == 1936684398) {
      return 1;
    }
    if (paramInt == 1986618469) {
      return 2;
    }
    if ((paramInt != 1952807028) && (paramInt != 1935832172) && (paramInt != 1937072756) && (paramInt != 1668047728))
    {
      if (paramInt == 1835365473) {
        return 5;
      }
      return -1;
    }
    return 3;
  }
  
  public static void d(d0 paramd0)
  {
    int i = paramd0.e();
    paramd0.Q(4);
    int j = i;
    if (paramd0.n() != 1751411826) {
      j = i + 4;
    }
    paramd0.P(j);
  }
  
  private static void e(d0 paramd0, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, boolean paramBoolean, @Nullable DrmInitData paramDrmInitData, c paramc, int paramInt5)
    throws ParserException
  {
    int i = paramInt2;
    paramd0.P(i + 8 + 8);
    int j;
    if (paramBoolean)
    {
      j = paramd0.J();
      paramd0.Q(6);
    }
    else
    {
      paramd0.Q(8);
      j = 0;
    }
    int k;
    if ((j != 0) && (j != 1))
    {
      if (j == 2)
      {
        paramd0.Q(16);
        k = (int)Math.round(paramd0.l());
        j = paramd0.H();
        paramd0.Q(20);
      }
    }
    else
    {
      m = paramd0.J();
      paramd0.Q(6);
      k = paramd0.E();
      if (j == 1) {
        paramd0.Q(16);
      }
      j = m;
    }
    int m = paramd0.e();
    DrmInitData localDrmInitData;
    if (paramInt1 == 1701733217)
    {
      localObject1 = r(paramd0, i, paramInt3);
      if (localObject1 != null)
      {
        paramInt1 = ((Integer)((Pair)localObject1).first).intValue();
        if (paramDrmInitData == null) {
          paramDrmInitData = null;
        } else {
          paramDrmInitData = paramDrmInitData.c(((p)((Pair)localObject1).second).b);
        }
        paramc.a[paramInt5] = ((p)((Pair)localObject1).second);
      }
      paramd0.P(m);
      localDrmInitData = paramDrmInitData;
    }
    else
    {
      localDrmInitData = paramDrmInitData;
    }
    paramDrmInitData = "audio/raw";
    if (paramInt1 == 1633889587) {
      paramDrmInitData = "audio/ac3";
    }
    for (;;)
    {
      paramInt1 = -1;
      break;
      if (paramInt1 == 1700998451) {
        paramDrmInitData = "audio/eac3";
      } else if (paramInt1 == 1633889588) {
        paramDrmInitData = "audio/ac4";
      } else if (paramInt1 == 1685353315) {
        paramDrmInitData = "audio/vnd.dts";
      } else if ((paramInt1 != 1685353320) && (paramInt1 != 1685353324))
      {
        if (paramInt1 == 1685353317)
        {
          paramDrmInitData = "audio/vnd.dts.hd;profile=lbr";
        }
        else if (paramInt1 == 1685353336)
        {
          paramDrmInitData = "audio/vnd.dts.uhd";
        }
        else if (paramInt1 == 1935764850)
        {
          paramDrmInitData = "audio/3gpp";
        }
        else if (paramInt1 == 1935767394)
        {
          paramDrmInitData = "audio/amr-wb";
        }
        else if ((paramInt1 != 1819304813) && (paramInt1 != 1936684916))
        {
          if (paramInt1 == 1953984371)
          {
            paramInt1 = 268435456;
            break;
          }
          if ((paramInt1 != 778924082) && (paramInt1 != 778924083))
          {
            if (paramInt1 == 1835557169)
            {
              paramDrmInitData = "audio/mha1";
            }
            else if (paramInt1 == 1835560241)
            {
              paramDrmInitData = "audio/mhm1";
            }
            else if (paramInt1 == 1634492771)
            {
              paramDrmInitData = "audio/alac";
            }
            else if (paramInt1 == 1634492791)
            {
              paramDrmInitData = "audio/g711-alaw";
            }
            else if (paramInt1 == 1970037111)
            {
              paramDrmInitData = "audio/g711-mlaw";
            }
            else if (paramInt1 == 1332770163)
            {
              paramDrmInitData = "audio/opus";
            }
            else if (paramInt1 == 1716281667)
            {
              paramDrmInitData = "audio/flac";
            }
            else
            {
              paramInt1 = -1;
              paramDrmInitData = null;
              break;
            }
          }
          else {
            paramDrmInitData = "audio/mpeg";
          }
        }
        else
        {
          paramInt1 = 2;
          break;
        }
      }
      else {
        paramDrmInitData = "audio/vnd.dts.hd";
      }
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = paramDrmInitData;
    paramInt5 = m;
    for (;;)
    {
      boolean bool = true;
      if (paramInt5 - paramInt2 >= paramInt3) {
        break;
      }
      paramd0.P(paramInt5);
      int n = paramd0.n();
      if (n <= 0) {
        bool = false;
      }
      com.google.android.exoplayer2.o2.m.a(bool, "childAtomSize must be positive");
      i = paramd0.n();
      if (i == 1835557187)
      {
        i = n - 13;
        paramDrmInitData = new byte[i];
        paramd0.P(paramInt5 + 13);
        paramd0.j(paramDrmInitData, 0, i);
        paramDrmInitData = ImmutableList.of(paramDrmInitData);
      }
      label1111:
      for (;;)
      {
        i = j;
        m = k;
        localObject4 = localObject1;
        break label1275;
        if ((i == 1702061171) || ((paramBoolean) && (i == 2002876005))) {
          break;
        }
        if (i == 1684103987)
        {
          paramd0.P(paramInt5 + 8);
          paramc.b = com.google.android.exoplayer2.audio.n.c(paramd0, Integer.toString(paramInt4), paramString, localDrmInitData);
        }
        for (;;)
        {
          paramDrmInitData = (DrmInitData)localObject2;
          break label1111;
          if (i == 1684366131)
          {
            paramd0.P(paramInt5 + 8);
            paramc.b = com.google.android.exoplayer2.audio.n.g(paramd0, Integer.toString(paramInt4), paramString, localDrmInitData);
          }
          else if (i == 1684103988)
          {
            paramd0.P(paramInt5 + 8);
            paramc.b = com.google.android.exoplayer2.audio.o.b(paramd0, Integer.toString(paramInt4), paramString, localDrmInitData);
          }
          else
          {
            if (i != 1684305011) {
              break;
            }
            paramc.b = new Format.b().R(paramInt4).e0((String)localObject3).H(j).f0(k).L(localDrmInitData).V(paramString).E();
          }
        }
        if (i == 1682927731)
        {
          i = n - 8;
          paramDrmInitData = a;
          localObject2 = Arrays.copyOf(paramDrmInitData, paramDrmInitData.length + i);
          paramd0.P(paramInt5 + 8);
          paramd0.j((byte[])localObject2, paramDrmInitData.length, i);
          paramDrmInitData = f0.a((byte[])localObject2);
        }
        else if (i == 1684425825)
        {
          i = n - 12;
          paramDrmInitData = new byte[i + 4];
          paramDrmInitData[0] = ((byte)102);
          paramDrmInitData[1] = ((byte)76);
          paramDrmInitData[2] = ((byte)97);
          paramDrmInitData[3] = ((byte)67);
          paramd0.P(paramInt5 + 12);
          paramd0.j(paramDrmInitData, 4, i);
          paramDrmInitData = ImmutableList.of(paramDrmInitData);
        }
        else
        {
          if (i == 1634492771)
          {
            j = n - 12;
            paramDrmInitData = new byte[j];
            paramd0.P(paramInt5 + 12);
            paramd0.j(paramDrmInitData, 0, j);
            localObject2 = i.e(paramDrmInitData);
            m = ((Integer)((Pair)localObject2).first).intValue();
            i = ((Integer)((Pair)localObject2).second).intValue();
            paramDrmInitData = ImmutableList.of(paramDrmInitData);
            localObject4 = localObject1;
            break label1275;
          }
          paramDrmInitData = (DrmInitData)localObject2;
        }
      }
      int i1;
      if (i == 1702061171) {
        i1 = paramInt5;
      } else {
        i1 = b(paramd0, paramInt5, n);
      }
      i = j;
      m = k;
      Object localObject4 = localObject1;
      paramDrmInitData = (DrmInitData)localObject2;
      if (i1 != -1)
      {
        paramDrmInitData = h(paramd0, i1);
        String str = (String)paramDrmInitData.first;
        byte[] arrayOfByte = (byte[])paramDrmInitData.second;
        i = j;
        m = k;
        localObject3 = str;
        localObject4 = localObject1;
        paramDrmInitData = (DrmInitData)localObject2;
        if (arrayOfByte != null)
        {
          if ("audio/mp4a-latm".equals(str))
          {
            paramDrmInitData = com.google.android.exoplayer2.audio.m.f(arrayOfByte);
            k = paramDrmInitData.a;
            j = paramDrmInitData.b;
            localObject1 = paramDrmInitData.c;
          }
          paramDrmInitData = ImmutableList.of(arrayOfByte);
          localObject4 = localObject1;
          localObject3 = str;
          m = k;
          i = j;
        }
      }
      label1275:
      paramInt5 += n;
      j = i;
      k = m;
      localObject1 = localObject4;
      localObject2 = paramDrmInitData;
    }
    if ((paramc.b == null) && (localObject3 != null)) {
      paramc.b = new Format.b().R(paramInt4).e0((String)localObject3).I((String)localObject1).H(j).f0(k).Y(paramInt1).T((List)localObject2).L(localDrmInitData).V(paramString).E();
    }
  }
  
  @Nullable
  static Pair<Integer, p> f(d0 paramd0, int paramInt1, int paramInt2)
    throws ParserException
  {
    int i = paramInt1 + 8;
    boolean bool1 = false;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    int j = -1;
    int k = 0;
    while (i - paramInt1 < paramInt2)
    {
      paramd0.P(i);
      int m = paramd0.n();
      int n = paramd0.n();
      Object localObject3;
      Object localObject4;
      if (n == 1718775137)
      {
        localObject3 = Integer.valueOf(paramd0.n());
        localObject4 = localObject1;
      }
      else if (n == 1935894637)
      {
        paramd0.Q(4);
        localObject4 = paramd0.A(4);
        localObject3 = localObject2;
      }
      else
      {
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (n == 1935894633)
        {
          j = i;
          k = m;
          localObject3 = localObject2;
          localObject4 = localObject1;
        }
      }
      i += m;
      localObject1 = localObject4;
      localObject2 = localObject3;
    }
    if ((!"cenc".equals(localObject1)) && (!"cbc1".equals(localObject1)) && (!"cens".equals(localObject1)) && (!"cbcs".equals(localObject1))) {
      return null;
    }
    if (localObject2 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.o2.m.a(bool2, "frma atom is mandatory");
    if (j != -1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.o2.m.a(bool2, "schi atom is mandatory");
    paramd0 = s(paramd0, j, k, (String)localObject1);
    boolean bool2 = bool1;
    if (paramd0 != null) {
      bool2 = true;
    }
    com.google.android.exoplayer2.o2.m.a(bool2, "tenc atom is mandatory");
    return Pair.create(localObject2, (p)o0.i(paramd0));
  }
  
  @Nullable
  private static Pair<long[], long[]> g(e.a parama)
  {
    parama = parama.g(1701606260);
    if (parama == null) {
      return null;
    }
    parama = parama.b;
    parama.P(8);
    int i = e.c(parama.n());
    int j = parama.H();
    long[] arrayOfLong1 = new long[j];
    long[] arrayOfLong2 = new long[j];
    int k = 0;
    while (k < j)
    {
      long l;
      if (i == 1) {
        l = parama.I();
      } else {
        l = parama.F();
      }
      arrayOfLong1[k] = l;
      if (i == 1) {
        l = parama.w();
      } else {
        l = parama.n();
      }
      arrayOfLong2[k] = l;
      if (parama.z() == 1)
      {
        parama.Q(2);
        k++;
      }
      else
      {
        throw new IllegalArgumentException("Unsupported media rate.");
      }
    }
    return Pair.create(arrayOfLong1, arrayOfLong2);
  }
  
  private static Pair<String, byte[]> h(d0 paramd0, int paramInt)
  {
    paramd0.P(paramInt + 8 + 4);
    paramd0.Q(1);
    i(paramd0);
    paramd0.Q(2);
    paramInt = paramd0.D();
    if ((paramInt & 0x80) != 0) {
      paramd0.Q(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramd0.Q(paramd0.J());
    }
    if ((paramInt & 0x20) != 0) {
      paramd0.Q(2);
    }
    paramd0.Q(1);
    i(paramd0);
    String str = y.h(paramd0.D());
    if ((!"audio/mpeg".equals(str)) && (!"audio/vnd.dts".equals(str)) && (!"audio/vnd.dts.hd".equals(str)))
    {
      paramd0.Q(12);
      paramd0.Q(1);
      paramInt = i(paramd0);
      byte[] arrayOfByte = new byte[paramInt];
      paramd0.j(arrayOfByte, 0, paramInt);
      return Pair.create(str, arrayOfByte);
    }
    return Pair.create(str, null);
  }
  
  private static int i(d0 paramd0)
  {
    int i = paramd0.D();
    for (int j = i & 0x7F; (i & 0x80) == 128; j = j << 7 | i & 0x7F) {
      i = paramd0.D();
    }
    return j;
  }
  
  private static int j(d0 paramd0)
  {
    paramd0.P(16);
    return paramd0.n();
  }
  
  @Nullable
  private static Metadata k(d0 paramd0, int paramInt)
  {
    paramd0.Q(8);
    ArrayList localArrayList = new ArrayList();
    while (paramd0.e() < paramInt)
    {
      Metadata.Entry localEntry = j.c(paramd0);
      if (localEntry != null) {
        localArrayList.add(localEntry);
      }
    }
    if (localArrayList.isEmpty()) {
      paramd0 = null;
    } else {
      paramd0 = new Metadata(localArrayList);
    }
    return paramd0;
  }
  
  private static Pair<Long, String> l(d0 paramd0)
  {
    int i = 8;
    paramd0.P(8);
    int j = e.c(paramd0.n());
    if (j == 0) {
      k = 8;
    } else {
      k = 16;
    }
    paramd0.Q(k);
    long l = paramd0.F();
    int k = i;
    if (j == 0) {
      k = 4;
    }
    paramd0.Q(k);
    k = paramd0.J();
    char c1 = (char)((k >> 10 & 0x1F) + 96);
    char c2 = (char)((k >> 5 & 0x1F) + 96);
    char c3 = (char)((k & 0x1F) + 96);
    paramd0 = new StringBuilder(3);
    paramd0.append(c1);
    paramd0.append(c2);
    paramd0.append(c3);
    return Pair.create(Long.valueOf(l), paramd0.toString());
  }
  
  @Nullable
  public static Metadata m(e.a parama)
  {
    Object localObject1 = parama.g(1751411826);
    Object localObject2 = parama.g(1801812339);
    Object localObject3 = parama.g(1768715124);
    Object localObject4 = null;
    parama = (e.a)localObject4;
    if (localObject1 != null)
    {
      parama = (e.a)localObject4;
      if (localObject2 != null)
      {
        parama = (e.a)localObject4;
        if (localObject3 != null) {
          if (j(((e.b)localObject1).b) != 1835299937)
          {
            parama = (e.a)localObject4;
          }
          else
          {
            localObject1 = ((e.b)localObject2).b;
            ((d0)localObject1).P(12);
            int i = ((d0)localObject1).n();
            parama = new String[i];
            int k;
            for (int j = 0; j < i; j++)
            {
              k = ((d0)localObject1).n();
              ((d0)localObject1).Q(4);
              parama[j] = ((d0)localObject1).A(k - 8);
            }
            localObject1 = ((e.b)localObject3).b;
            ((d0)localObject1).P(8);
            localObject3 = new ArrayList();
            while (((d0)localObject1).a() > 8)
            {
              k = ((d0)localObject1).e();
              int m = ((d0)localObject1).n();
              j = ((d0)localObject1).n() - 1;
              if ((j >= 0) && (j < i))
              {
                localObject2 = j.f((d0)localObject1, k + m, parama[j]);
                if (localObject2 != null) {
                  ((ArrayList)localObject3).add(localObject2);
                }
              }
              else
              {
                localObject2 = new StringBuilder(52);
                ((StringBuilder)localObject2).append("Skipped metadata with unknown key index: ");
                ((StringBuilder)localObject2).append(j);
                com.google.android.exoplayer2.util.u.h("AtomParsers", ((StringBuilder)localObject2).toString());
              }
              ((d0)localObject1).P(k + m);
            }
            if (((ArrayList)localObject3).isEmpty()) {
              parama = (e.a)localObject4;
            } else {
              parama = new Metadata((List)localObject3);
            }
          }
        }
      }
    }
    return parama;
  }
  
  private static void n(d0 paramd0, int paramInt1, int paramInt2, int paramInt3, c paramc)
  {
    paramd0.P(paramInt2 + 8 + 8);
    if (paramInt1 == 1835365492)
    {
      paramd0.x();
      paramd0 = paramd0.x();
      if (paramd0 != null) {
        paramc.b = new Format.b().R(paramInt3).e0(paramd0).E();
      }
    }
  }
  
  private static long o(d0 paramd0)
  {
    int i = 8;
    paramd0.P(8);
    if (e.c(paramd0.n()) != 0) {
      i = 16;
    }
    paramd0.Q(i);
    return paramd0.F();
  }
  
  private static float p(d0 paramd0, int paramInt)
  {
    paramd0.P(paramInt + 8);
    paramInt = paramd0.H();
    int i = paramd0.H();
    return paramInt / i;
  }
  
  @Nullable
  private static byte[] q(d0 paramd0, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    while (i - paramInt1 < paramInt2)
    {
      paramd0.P(i);
      int j = paramd0.n();
      if (paramd0.n() == 1886547818) {
        return Arrays.copyOfRange(paramd0.d(), i, j + i);
      }
      i += j;
    }
    return null;
  }
  
  @Nullable
  private static Pair<Integer, p> r(d0 paramd0, int paramInt1, int paramInt2)
    throws ParserException
  {
    int i = paramd0.e();
    while (i - paramInt1 < paramInt2)
    {
      paramd0.P(i);
      int j = paramd0.n();
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.o2.m.a(bool, "childAtomSize must be positive");
      if (paramd0.n() == 1936289382)
      {
        Pair localPair = f(paramd0, i, j);
        if (localPair != null) {
          return localPair;
        }
      }
      i += j;
    }
    return null;
  }
  
  @Nullable
  private static p s(d0 paramd0, int paramInt1, int paramInt2, String paramString)
  {
    int i = paramInt1 + 8;
    for (;;)
    {
      Object localObject1 = null;
      if (i - paramInt1 >= paramInt2) {
        break;
      }
      paramd0.P(i);
      int j = paramd0.n();
      if (paramd0.n() == 1952804451)
      {
        paramInt1 = e.c(paramd0.n());
        paramd0.Q(1);
        if (paramInt1 == 0)
        {
          paramd0.Q(1);
          paramInt2 = 0;
          paramInt1 = 0;
        }
        else
        {
          paramInt2 = paramd0.D();
          paramInt1 = paramInt2 & 0xF;
          paramInt2 = (paramInt2 & 0xF0) >> 4;
        }
        boolean bool;
        if (paramd0.D() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        j = paramd0.D();
        byte[] arrayOfByte = new byte[16];
        paramd0.j(arrayOfByte, 0, 16);
        Object localObject2 = localObject1;
        if (bool)
        {
          localObject2 = localObject1;
          if (j == 0)
          {
            i = paramd0.D();
            localObject2 = new byte[i];
            paramd0.j((byte[])localObject2, 0, i);
          }
        }
        return new p(bool, paramString, j, arrayOfByte, paramInt2, paramInt1, (byte[])localObject2);
      }
      i += j;
    }
    return null;
  }
  
  @Nullable
  private static Metadata t(d0 paramd0, int paramInt)
  {
    paramd0.Q(12);
    while (paramd0.e() < paramInt)
    {
      int i = paramd0.e();
      int j = paramd0.n();
      if (paramd0.n() == 1935766900)
      {
        if (j < 14) {
          return null;
        }
        paramd0.Q(5);
        paramInt = paramd0.D();
        if ((paramInt != 12) && (paramInt != 13)) {
          return null;
        }
        float f;
        if (paramInt == 12) {
          f = 240.0F;
        } else {
          f = 120.0F;
        }
        paramd0.Q(1);
        return new Metadata(new Metadata.Entry[] { new SmtaMetadataEntry(f, paramd0.D()) });
      }
      paramd0.P(i + j);
    }
    return null;
  }
  
  private static r u(o paramo, e.a parama, com.google.android.exoplayer2.o2.u paramu)
    throws ParserException
  {
    Object localObject1 = parama.g(1937011578);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new d((e.b)localObject1, paramo.f);
    }
    else
    {
      localObject1 = parama.g(1937013298);
      if (localObject1 == null) {
        break label2314;
      }
      localObject2 = new e((e.b)localObject1);
    }
    int i = ((b)localObject2).c();
    if (i == 0) {
      return new r(paramo, new long[0], new int[0], 0, new long[0], new int[0], 0L);
    }
    localObject1 = parama.g(1937007471);
    boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = (e.b)g.e(parama.g(1668232756));
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    Object localObject3 = ((e.b)localObject1).b;
    Object localObject4 = ((e.b)g.e(parama.g(1937011555))).b;
    Object localObject5 = ((e.b)g.e(parama.g(1937011827))).b;
    localObject1 = parama.g(1937011571);
    if (localObject1 != null) {
      localObject1 = ((e.b)localObject1).b;
    } else {
      localObject1 = null;
    }
    parama = parama.g(1668576371);
    if (parama != null) {
      localObject6 = parama.b;
    } else {
      localObject6 = null;
    }
    Object localObject7 = new a((d0)localObject4, (d0)localObject3, bool1);
    ((d0)localObject5).P(12);
    int j = ((d0)localObject5).H() - 1;
    int k = ((d0)localObject5).H();
    int m = ((d0)localObject5).H();
    if (localObject6 != null)
    {
      ((d0)localObject6).P(12);
      n = ((d0)localObject6).H();
    }
    else
    {
      n = 0;
    }
    if (localObject1 != null)
    {
      ((d0)localObject1).P(12);
      i1 = ((d0)localObject1).H();
      if (i1 > 0)
      {
        i2 = ((d0)localObject1).H() - 1;
        break label324;
      }
      localObject1 = null;
    }
    else
    {
      i1 = 0;
    }
    int i2 = -1;
    label324:
    int i3 = ((b)localObject2).b();
    parama = paramo.f.H3;
    if ((i3 != -1) && (("audio/raw".equals(parama)) || ("audio/g711-mlaw".equals(parama)) || ("audio/g711-alaw".equals(parama))) && (j == 0) && (n == 0) && (i1 == 0)) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    long l3;
    if (i4 != 0)
    {
      i1 = ((a)localObject7).a;
      localObject1 = new long[i1];
      parama = new int[i1];
      while (((a)localObject7).a())
      {
        i1 = ((a)localObject7).b;
        localObject1[i1] = ((a)localObject7).d;
        parama[i1] = ((a)localObject7).c;
      }
      localObject6 = h.a(i3, (long[])localObject1, parama, m);
      parama = ((h.b)localObject6).a;
      localObject2 = ((h.b)localObject6).b;
      i1 = ((h.b)localObject6).c;
      localObject1 = ((h.b)localObject6).d;
      localObject3 = ((h.b)localObject6).e;
      l1 = ((h.b)localObject6).f;
      i2 = i;
    }
    else
    {
      localObject8 = new long[i];
      localObject4 = new int[i];
      localObject3 = new long[i];
      parama = new int[i];
      int i5 = i2;
      int i6 = 0;
      i3 = 0;
      int i7 = 0;
      int i8 = 0;
      int i9 = 0;
      l2 = 0L;
      l1 = 0L;
      i2 = n;
      i4 = k;
      int i10 = i1;
      k = i8;
      n = i7;
      i1 = i2;
      i2 = i;
      i = i6;
      while (i < i2)
      {
        bool1 = true;
        boolean bool2;
        for (;;)
        {
          bool2 = bool1;
          if (k != 0) {
            break;
          }
          bool1 = ((a)localObject7).a();
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          l1 = ((a)localObject7).d;
          k = ((a)localObject7).c;
        }
        i8 = i4;
        if (!bool2)
        {
          com.google.android.exoplayer2.util.u.h("AtomParsers", "Unexpected end of chunk data");
          localObject8 = Arrays.copyOf((long[])localObject8, i);
          localObject2 = Arrays.copyOf((int[])localObject4, i);
          localObject1 = Arrays.copyOf((long[])localObject3, i);
          localObject4 = Arrays.copyOf(parama, i);
          i2 = i;
          i4 = k;
          localObject3 = localObject8;
          parama = (e.a)localObject1;
          localObject1 = localObject4;
          break label1045;
        }
        i7 = i1;
        i4 = n;
        i6 = i9;
        if (localObject6 != null)
        {
          while ((i9 == 0) && (i1 > 0))
          {
            i9 = ((d0)localObject6).H();
            n = ((d0)localObject6).n();
            i1--;
          }
          i6 = i9 - 1;
          i4 = n;
          i7 = i1;
        }
        localObject8[i] = l1;
        localObject4[i] = ((b)localObject2).a();
        i9 = i3;
        if (localObject4[i] > i3) {
          i9 = localObject4[i];
        }
        localObject3[i] = (l2 + i4);
        if (localObject1 == null) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        parama[i] = i1;
        i1 = i5;
        int i11 = i10;
        if (i == i5)
        {
          parama[i] = 1;
          n = i10 - 1;
          i1 = i5;
          i11 = n;
          if (n > 0)
          {
            i1 = ((d0)g.e(localObject1)).H() - 1;
            i11 = n;
          }
        }
        l2 += m;
        n = i8 - 1;
        if ((n == 0) && (j > 0))
        {
          n = ((d0)localObject5).H();
          i3 = ((d0)localObject5).n();
          j--;
        }
        else
        {
          i3 = m;
        }
        l3 = localObject4[i];
        i8 = k - 1;
        i++;
        l1 += l3;
        m = i3;
        k = i4;
        i5 = i1;
        i10 = i11;
        i3 = i9;
        i4 = n;
        i1 = i7;
        n = k;
        k = i8;
        i9 = i6;
      }
      i8 = i4;
      i4 = k;
      localObject1 = parama;
      parama = (e.a)localObject3;
      localObject2 = localObject4;
      localObject3 = localObject8;
      label1045:
      l1 = n;
      if (localObject6 != null) {
        while (i1 > 0)
        {
          if (((d0)localObject6).H() != 0)
          {
            i1 = 0;
            break label1089;
          }
          ((d0)localObject6).n();
          i1--;
        }
      }
      i1 = 1;
      label1089:
      if ((i10 == 0) && (i8 == 0) && (i4 == 0) && (j == 0) && (i9 == 0) && (i1 != 0)) {
        break label1287;
      }
      n = paramo.a;
      if (i1 == 0) {
        localObject6 = ", ctts invalid";
      } else {
        localObject6 = "";
      }
      localObject4 = new StringBuilder(((String)localObject6).length() + 262);
      ((StringBuilder)localObject4).append("Inconsistent stbl box for track ");
      ((StringBuilder)localObject4).append(n);
      ((StringBuilder)localObject4).append(": remainingSynchronizationSamples ");
      ((StringBuilder)localObject4).append(i10);
      ((StringBuilder)localObject4).append(", remainingSamplesAtTimestampDelta ");
      ((StringBuilder)localObject4).append(i8);
      ((StringBuilder)localObject4).append(", remainingSamplesInChunk ");
      ((StringBuilder)localObject4).append(i4);
      ((StringBuilder)localObject4).append(", remainingTimestampDeltaChanges ");
      ((StringBuilder)localObject4).append(j);
      ((StringBuilder)localObject4).append(", remainingSamplesAtTimestampOffset ");
      ((StringBuilder)localObject4).append(i9);
      ((StringBuilder)localObject4).append((String)localObject6);
      com.google.android.exoplayer2.util.u.h("AtomParsers", ((StringBuilder)localObject4).toString());
      label1287:
      localObject6 = localObject3;
      i1 = i3;
      l1 = l2 + l1;
      localObject3 = localObject1;
      localObject1 = parama;
      parama = (e.a)localObject6;
    }
    o localo = paramo;
    long l2 = o0.C0(l1, 1000000L, localo.c);
    Object localObject6 = localo.h;
    if (localObject6 == null)
    {
      o0.D0((long[])localObject1, 1000000L, localo.c);
      return new r(paramo, parama, (int[])localObject2, i1, (long[])localObject1, (int[])localObject3, l2);
    }
    if ((localObject6.length == 1) && (localo.b == 1) && (localObject1.length >= 2))
    {
      l2 = ((long[])g.e(localo.i))[0];
      l3 = l2 + o0.C0(localo.h[0], localo.c, localo.d);
      if (a((long[])localObject1, l1, l2, l3))
      {
        l2 = o0.C0(l2 - localObject1[0], localo.f.V3, localo.c);
        l3 = o0.C0(l1 - l3, localo.f.V3, localo.c);
        if (((l2 != 0L) || (l3 != 0L)) && (l2 <= 2147483647L) && (l3 <= 2147483647L))
        {
          paramu.b = ((int)l2);
          paramu.c = ((int)l3);
          o0.D0((long[])localObject1, 1000000L, localo.c);
          return new r(paramo, parama, (int[])localObject2, i1, (long[])localObject1, (int[])localObject3, o0.C0(localo.h[0], 1000000L, localo.d));
        }
      }
    }
    paramu = (com.google.android.exoplayer2.o2.u)localObject3;
    localObject3 = localo.h;
    if ((localObject3.length == 1) && (localObject3[0] == 0L))
    {
      l2 = ((long[])g.e(localo.i))[0];
      for (n = 0; n < localObject1.length; n++) {
        localObject1[n] = o0.C0(localObject1[n] - l2, 1000000L, localo.c);
      }
      return new r(paramo, parama, (int[])localObject2, i1, (long[])localObject1, paramu, o0.C0(l1 - l2, 1000000L, localo.c));
    }
    if (localo.b == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject8 = new int[localObject3.length];
    localObject7 = new int[localObject3.length];
    localObject3 = (long[])g.e(localo.i);
    j = 0;
    int i4 = 0;
    k = 0;
    int n = 0;
    for (;;)
    {
      localObject6 = localo.h;
      if (j >= localObject6.length) {
        break;
      }
      l1 = localObject3[j];
      if (l1 != -1L)
      {
        l2 = o0.C0(localObject6[j], localo.c, localo.d);
        localObject8[j] = o0.h((long[])localObject1, l1, true, true);
        localObject7[j] = o0.d((long[])localObject1, l1 + l2, bool1, false);
        while ((localObject8[j] < localObject7[j]) && ((paramu[localObject8[j]] & 0x1) == 0)) {
          localObject8[j] += 1;
        }
        k += localObject7[j] - localObject8[j];
        if (n != localObject8[j]) {
          n = 1;
        } else {
          n = 0;
        }
        i = localObject7[j];
        i4 = n | i4;
        n = i;
      }
      j++;
    }
    j = 0;
    n = 1;
    if (k == i2) {
      n = 0;
    }
    i = i4 | n;
    if (i != 0) {
      localObject3 = new long[k];
    } else {
      localObject3 = parama;
    }
    if (i != 0) {
      localObject6 = new int[k];
    } else {
      localObject6 = localObject2;
    }
    n = i1;
    if (i != 0) {
      n = 0;
    }
    if (i != 0) {
      localObject4 = new int[k];
    } else {
      localObject4 = paramu;
    }
    long[] arrayOfLong = new long[k];
    long l1 = 0L;
    i4 = 0;
    int i1 = j;
    localObject5 = parama;
    while (i1 < localo.h.length)
    {
      l2 = localo.i[i1];
      i2 = localObject8[i1];
      j = localObject7[i1];
      if (i != 0)
      {
        k = j - i2;
        System.arraycopy(localObject5, i2, localObject3, i4, k);
        System.arraycopy(localObject2, i2, localObject6, i4, k);
        System.arraycopy(paramu, i2, localObject4, i4, k);
      }
      parama = paramu;
      k = n;
      n = i4;
      i4 = i1;
      for (i1 = k; i2 < j; i1 = k)
      {
        arrayOfLong[n] = (o0.C0(l1, 1000000L, localo.d) + o0.C0(Math.max(0L, localObject1[i2] - l2), 1000000L, localo.c));
        k = i1;
        if (i != 0)
        {
          k = i1;
          if (localObject6[n] > i1) {
            k = localObject2[i2];
          }
        }
        n++;
        i2++;
      }
      l1 += localo.h[i4];
      i4++;
      i2 = i1;
      i1 = i4;
      i4 = n;
      n = i2;
      paramu = parama;
    }
    return new r(paramo, (long[])localObject3, (int[])localObject6, n, arrayOfLong, (int[])localObject4, o0.C0(l1, 1000000L, localo.d));
    label2314:
    throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
  }
  
  private static c v(d0 paramd0, int paramInt1, int paramInt2, String paramString, @Nullable DrmInitData paramDrmInitData, boolean paramBoolean)
    throws ParserException
  {
    paramd0.P(12);
    int i = paramd0.n();
    c localc = new c(i);
    for (int j = 0; j < i; j++)
    {
      int k = paramd0.e();
      int m = paramd0.n();
      boolean bool;
      if (m > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.o2.m.a(bool, "childAtomSize must be positive");
      int n = paramd0.n();
      if ((n != 1635148593) && (n != 1635148595) && (n != 1701733238) && (n != 1831958048) && (n != 1836070006) && (n != 1752589105) && (n != 1751479857) && (n != 1932670515) && (n != 1211250227) && (n != 1987063864) && (n != 1987063865) && (n != 1635135537) && (n != 1685479798) && (n != 1685479729) && (n != 1685481573) && (n != 1685481521))
      {
        if ((n != 1836069985) && (n != 1701733217) && (n != 1633889587) && (n != 1700998451) && (n != 1633889588) && (n != 1685353315) && (n != 1685353317) && (n != 1685353320) && (n != 1685353324) && (n != 1685353336) && (n != 1935764850) && (n != 1935767394) && (n != 1819304813) && (n != 1936684916) && (n != 1953984371) && (n != 778924082) && (n != 778924083) && (n != 1835557169) && (n != 1835560241) && (n != 1634492771) && (n != 1634492791) && (n != 1970037111) && (n != 1332770163) && (n != 1716281667))
        {
          if ((n != 1414810956) && (n != 1954034535) && (n != 2004251764) && (n != 1937010800) && (n != 1664495672))
          {
            if (n == 1835365492) {
              n(paramd0, n, k, paramInt1, localc);
            } else if (n == 1667329389) {
              localc.b = new Format.b().R(paramInt1).e0("application/x-camera-motion").E();
            }
          }
          else {
            w(paramd0, n, k, m, paramInt1, paramString, localc);
          }
        }
        else {
          e(paramd0, n, k, m, paramInt1, paramString, paramBoolean, paramDrmInitData, localc, j);
        }
      }
      else {
        C(paramd0, n, k, m, paramInt1, paramInt2, paramDrmInitData, localc, j);
      }
      paramd0.P(k + m);
    }
    return localc;
  }
  
  private static void w(d0 paramd0, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, c paramc)
  {
    paramd0.P(paramInt2 + 8 + 8);
    String str = "application/ttml+xml";
    Object localObject = null;
    long l = Long.MAX_VALUE;
    if (paramInt1 == 1414810956)
    {
      paramd0 = str;
    }
    else if (paramInt1 == 1954034535)
    {
      paramInt1 = paramInt3 - 8 - 8;
      localObject = new byte[paramInt1];
      paramd0.j((byte[])localObject, 0, paramInt1);
      localObject = ImmutableList.of(localObject);
      paramd0 = "application/x-quicktime-tx3g";
    }
    else if (paramInt1 == 2004251764)
    {
      paramd0 = "application/x-mp4-vtt";
    }
    else if (paramInt1 == 1937010800)
    {
      l = 0L;
      paramd0 = str;
    }
    else
    {
      if (paramInt1 != 1664495672) {
        break label166;
      }
      paramc.d = 1;
      paramd0 = "application/x-mp4-cea-608";
    }
    paramc.b = new Format.b().R(paramInt4).e0(paramd0).V(paramString).i0(l).T((List)localObject).E();
    return;
    label166:
    throw new IllegalStateException();
  }
  
  private static f x(d0 paramd0)
  {
    int i = 8;
    paramd0.P(8);
    int j = e.c(paramd0.n());
    if (j == 0) {
      k = 8;
    } else {
      k = 16;
    }
    paramd0.Q(k);
    int m = paramd0.n();
    paramd0.Q(4);
    int n = paramd0.e();
    int k = i;
    if (j == 0) {
      k = 4;
    }
    int i1 = 0;
    for (i = 0; i < k; i++) {
      if (paramd0.d()[(n + i)] != -1)
      {
        i = 0;
        break label96;
      }
    }
    i = 1;
    label96:
    long l1 = -9223372036854775807L;
    long l2;
    if (i != 0)
    {
      paramd0.Q(k);
      l2 = l1;
    }
    else
    {
      if (j == 0) {
        l2 = paramd0.F();
      } else {
        l2 = paramd0.I();
      }
      if (l2 == 0L) {
        l2 = l1;
      }
    }
    paramd0.Q(16);
    int i2 = paramd0.n();
    i = paramd0.n();
    paramd0.Q(4);
    n = paramd0.n();
    j = paramd0.n();
    if ((i2 == 0) && (i == 65536) && (n == -65536) && (j == 0))
    {
      k = 90;
    }
    else if ((i2 == 0) && (i == -65536) && (n == 65536) && (j == 0))
    {
      k = 270;
    }
    else
    {
      k = i1;
      if (i2 == -65536)
      {
        k = i1;
        if (i == 0)
        {
          k = i1;
          if (n == 0)
          {
            k = i1;
            if (j == -65536) {
              k = 180;
            }
          }
        }
      }
    }
    return new f(m, l2, k);
  }
  
  @Nullable
  private static o y(e.a parama, e.b paramb, long paramLong, @Nullable DrmInitData paramDrmInitData, boolean paramBoolean1, boolean paramBoolean2)
    throws ParserException
  {
    Object localObject1 = (e.a)g.e(parama.f(1835297121));
    int i = c(j(((e.b)g.e(((e.a)localObject1).g(1751411826))).b));
    Object localObject2 = null;
    if (i == -1) {
      return null;
    }
    f localf = x(((e.b)g.e(parama.g(1953196132))).b);
    long l1 = -9223372036854775807L;
    if (paramLong == -9223372036854775807L) {
      paramLong = f.a(localf);
    }
    long l2 = o(paramb.b);
    if (paramLong == -9223372036854775807L) {
      paramLong = l1;
    } else {
      paramLong = o0.C0(paramLong, 1000000L, l2);
    }
    paramb = (e.a)g.e(((e.a)g.e(((e.a)localObject1).f(1835626086))).f(1937007212));
    localObject1 = l(((e.b)g.e(((e.a)localObject1).g(1835296868))).b);
    paramDrmInitData = v(((e.b)g.e(paramb.g(1937011556))).b, f.b(localf), f.c(localf), (String)((Pair)localObject1).second, paramDrmInitData, paramBoolean2);
    if (!paramBoolean1)
    {
      parama = parama.f(1701082227);
      if (parama != null)
      {
        paramb = g(parama);
        if (paramb != null)
        {
          parama = (long[])paramb.first;
          paramb = (long[])paramb.second;
          break label268;
        }
      }
    }
    parama = null;
    paramb = parama;
    label268:
    if (paramDrmInitData.b == null) {
      parama = (e.a)localObject2;
    } else {
      parama = new o(f.b(localf), i, ((Long)((Pair)localObject1).first).longValue(), l2, paramLong, paramDrmInitData.b, paramDrmInitData.d, paramDrmInitData.a, paramDrmInitData.c, parama, paramb);
    }
    return parama;
  }
  
  public static List<r> z(e.a parama, com.google.android.exoplayer2.o2.u paramu, long paramLong, @Nullable DrmInitData paramDrmInitData, boolean paramBoolean1, boolean paramBoolean2, com.google.common.base.h<o, o> paramh)
    throws ParserException
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < parama.d.size(); i++)
    {
      e.a locala = (e.a)parama.d.get(i);
      if (locala.a == 1953653099)
      {
        o localo = (o)paramh.apply(y(locala, (e.b)g.e(parama.g(1836476516)), paramLong, paramDrmInitData, paramBoolean1, paramBoolean2));
        if (localo != null) {
          localArrayList.add(u(localo, (e.a)g.e(((e.a)g.e(((e.a)g.e(locala.f(1835297121))).f(1835626086))).f(1937007212)), paramu));
        }
      }
    }
    return localArrayList;
  }
  
  private static final class a
  {
    public final int a;
    public int b;
    public int c;
    public long d;
    private final boolean e;
    private final d0 f;
    private final d0 g;
    private int h;
    private int i;
    
    public a(d0 paramd01, d0 paramd02, boolean paramBoolean)
      throws ParserException
    {
      this.g = paramd01;
      this.f = paramd02;
      this.e = paramBoolean;
      paramd02.P(12);
      this.a = paramd02.H();
      paramd01.P(12);
      this.i = paramd01.H();
      int j = paramd01.n();
      paramBoolean = true;
      if (j != 1) {
        paramBoolean = false;
      }
      com.google.android.exoplayer2.o2.m.a(paramBoolean, "first_chunk must be 1");
      this.b = -1;
    }
    
    public boolean a()
    {
      int j = this.b + 1;
      this.b = j;
      if (j == this.a) {
        return false;
      }
      long l;
      if (this.e) {
        l = this.f.I();
      } else {
        l = this.f.F();
      }
      this.d = l;
      if (this.b == this.h)
      {
        this.c = this.g.H();
        this.g.Q(4);
        j = this.i - 1;
        this.i = j;
        if (j > 0) {
          j = this.g.H() - 1;
        } else {
          j = -1;
        }
        this.h = j;
      }
      return true;
    }
  }
  
  private static abstract interface b
  {
    public abstract int a();
    
    public abstract int b();
    
    public abstract int c();
  }
  
  private static final class c
  {
    public final p[] a;
    @Nullable
    public Format b;
    public int c;
    public int d;
    
    public c(int paramInt)
    {
      this.a = new p[paramInt];
      this.d = 0;
    }
  }
  
  static final class d
    implements f.b
  {
    private final int a;
    private final int b;
    private final d0 c;
    
    public d(e.b paramb, Format paramFormat)
    {
      paramb = paramb.b;
      this.c = paramb;
      paramb.P(12);
      int i = paramb.H();
      int j = i;
      if ("audio/raw".equals(paramFormat.H3))
      {
        int k = o0.W(paramFormat.W3, paramFormat.U3);
        if (i != 0)
        {
          j = i;
          if (i % k == 0) {}
        }
        else
        {
          paramFormat = new StringBuilder(88);
          paramFormat.append("Audio sample size mismatch. stsd sample size: ");
          paramFormat.append(k);
          paramFormat.append(", stsz sample size: ");
          paramFormat.append(i);
          com.google.android.exoplayer2.util.u.h("AtomParsers", paramFormat.toString());
          j = k;
        }
      }
      i = j;
      if (j == 0) {
        i = -1;
      }
      this.a = i;
      this.b = paramb.H();
    }
    
    public int a()
    {
      int i = this.a;
      int j = i;
      if (i == -1) {
        j = this.c.H();
      }
      return j;
    }
    
    public int b()
    {
      return this.a;
    }
    
    public int c()
    {
      return this.b;
    }
  }
  
  static final class e
    implements f.b
  {
    private final d0 a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    
    public e(e.b paramb)
    {
      paramb = paramb.b;
      this.a = paramb;
      paramb.P(12);
      this.c = (paramb.H() & 0xFF);
      this.b = paramb.H();
    }
    
    public int a()
    {
      int i = this.c;
      if (i == 8) {
        return this.a.D();
      }
      if (i == 16) {
        return this.a.J();
      }
      i = this.d;
      this.d = (i + 1);
      if (i % 2 == 0)
      {
        i = this.a.D();
        this.e = i;
        return (i & 0xF0) >> 4;
      }
      return this.e & 0xF;
    }
    
    public int b()
    {
      return -1;
    }
    
    public int c()
    {
      return this.b;
    }
  }
  
  private static final class f
  {
    private final int a;
    private final long b;
    private final int c;
    
    public f(int paramInt1, long paramLong, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramLong;
      this.c = paramInt2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */