package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.o2.j0.l;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo;
import com.google.android.exoplayer2.upstream.y.a;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.j1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class HlsPlaylistParser
  implements y.a<h>
{
  private static final Pattern A = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
  private static final Pattern B = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
  private static final Pattern C = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
  private static final Pattern D = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
  private static final Pattern E = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
  private static final Pattern F = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
  private static final Pattern G = Pattern.compile("KEYFORMAT=\"(.+?)\"");
  private static final Pattern H = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
  private static final Pattern I = Pattern.compile("URI=\"(.+?)\"");
  private static final Pattern J = Pattern.compile("IV=([^,.*]+)");
  private static final Pattern K = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
  private static final Pattern L = Pattern.compile("TYPE=(PART|MAP)");
  private static final Pattern M = Pattern.compile("LANGUAGE=\"(.+?)\"");
  private static final Pattern N = Pattern.compile("NAME=\"(.+?)\"");
  private static final Pattern O = Pattern.compile("GROUP-ID=\"(.+?)\"");
  private static final Pattern P = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
  private static final Pattern Q = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
  private static final Pattern R = c("AUTOSELECT");
  private static final Pattern S = c("DEFAULT");
  private static final Pattern T = c("FORCED");
  private static final Pattern U = c("INDEPENDENT");
  private static final Pattern V = c("GAP");
  private static final Pattern W = c("PRECISE");
  private static final Pattern X = Pattern.compile("VALUE=\"(.+?)\"");
  private static final Pattern Y = Pattern.compile("IMPORT=\"(.+?)\"");
  private static final Pattern Z = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
  private static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
  private static final Pattern b = Pattern.compile("VIDEO=\"(.+?)\"");
  private static final Pattern c = Pattern.compile("AUDIO=\"(.+?)\"");
  private static final Pattern d = Pattern.compile("SUBTITLES=\"(.+?)\"");
  private static final Pattern e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
  private static final Pattern f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
  private static final Pattern g = Pattern.compile("CHANNELS=\"(.+?)\"");
  private static final Pattern h = Pattern.compile("CODECS=\"(.+?)\"");
  private static final Pattern i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
  private static final Pattern j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
  private static final Pattern k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
  private static final Pattern l = Pattern.compile("DURATION=([\\d\\.]+)\\b");
  private static final Pattern m = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
  private static final Pattern n = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
  private static final Pattern o = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
  private static final Pattern p = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
  private static final Pattern q = c("CAN-SKIP-DATERANGES");
  private static final Pattern r = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
  private static final Pattern s = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
  private static final Pattern t = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
  private static final Pattern u = c("CAN-BLOCK-RELOAD");
  private static final Pattern v = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
  private static final Pattern w = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
  private static final Pattern x = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
  private static final Pattern y = Pattern.compile("LAST-MSN=(\\d+)\\b");
  private static final Pattern z = Pattern.compile("LAST-PART=(\\d+)\\b");
  private final f a0;
  @Nullable
  private final g b0;
  
  public HlsPlaylistParser()
  {
    this(f.d, null);
  }
  
  public HlsPlaylistParser(f paramf, @Nullable g paramg)
  {
    this.a0 = paramf;
    this.b0 = paramg;
  }
  
  private static String A(String paramString, Map<String, String> paramMap)
  {
    paramString = Z.matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.find())
    {
      String str = paramString.group(1);
      if (paramMap.containsKey(str)) {
        paramString.appendReplacement(localStringBuffer, Matcher.quoteReplacement((String)paramMap.get(str)));
      }
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  private static int B(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
    throws IOException
  {
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!o0.l0(paramInt)))) {
      paramInt = paramBufferedReader.read();
    }
    return paramInt;
  }
  
  private static boolean b(BufferedReader paramBufferedReader)
    throws IOException
  {
    int i1 = paramBufferedReader.read();
    int i2 = i1;
    if (i1 == 239) {
      if ((paramBufferedReader.read() == 187) && (paramBufferedReader.read() == 191)) {
        i2 = paramBufferedReader.read();
      } else {
        return false;
      }
    }
    i1 = B(paramBufferedReader, true, i2);
    for (i2 = 0; i2 < 7; i2++)
    {
      if (i1 != "#EXTM3U".charAt(i2)) {
        return false;
      }
      i1 = paramBufferedReader.read();
    }
    return o0.l0(B(paramBufferedReader, false, i1));
  }
  
  private static Pattern c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 9);
    localStringBuilder.append(paramString);
    localStringBuilder.append("=(");
    localStringBuilder.append("NO");
    localStringBuilder.append("|");
    localStringBuilder.append("YES");
    localStringBuilder.append(")");
    return Pattern.compile(localStringBuilder.toString());
  }
  
  private static DrmInitData d(@Nullable String paramString, DrmInitData.SchemeData[] paramArrayOfSchemeData)
  {
    DrmInitData.SchemeData[] arrayOfSchemeData = new DrmInitData.SchemeData[paramArrayOfSchemeData.length];
    for (int i1 = 0; i1 < paramArrayOfSchemeData.length; i1++) {
      arrayOfSchemeData[i1] = paramArrayOfSchemeData[i1].a(null);
    }
    return new DrmInitData(paramString, arrayOfSchemeData);
  }
  
  @Nullable
  private static String e(long paramLong, @Nullable String paramString1, @Nullable String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 != null) {
      return paramString2;
    }
    return Long.toHexString(paramLong);
  }
  
  @Nullable
  private static f.b f(ArrayList<f.b> paramArrayList, String paramString)
  {
    for (int i1 = 0; i1 < paramArrayList.size(); i1++)
    {
      f.b localb = (f.b)paramArrayList.get(i1);
      if (paramString.equals(localb.d)) {
        return localb;
      }
    }
    return null;
  }
  
  @Nullable
  private static f.b g(ArrayList<f.b> paramArrayList, String paramString)
  {
    for (int i1 = 0; i1 < paramArrayList.size(); i1++)
    {
      f.b localb = (f.b)paramArrayList.get(i1);
      if (paramString.equals(localb.e)) {
        return localb;
      }
    }
    return null;
  }
  
  @Nullable
  private static f.b h(ArrayList<f.b> paramArrayList, String paramString)
  {
    for (int i1 = 0; i1 < paramArrayList.size(); i1++)
    {
      f.b localb = (f.b)paramArrayList.get(i1);
      if (paramString.equals(localb.c)) {
        return localb;
      }
    }
    return null;
  }
  
  private static double j(String paramString, Pattern paramPattern)
    throws ParserException
  {
    return Double.parseDouble(z(paramString, paramPattern, Collections.emptyMap()));
  }
  
  @Nullable
  private static DrmInitData.SchemeData k(String paramString1, String paramString2, Map<String, String> paramMap)
    throws ParserException
  {
    String str = u(paramString1, H, "1", paramMap);
    if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(paramString2))
    {
      paramString1 = z(paramString1, I, paramMap);
      return new DrmInitData.SchemeData(w0.d, "video/mp4", Base64.decode(paramString1.substring(paramString1.indexOf(',')), 0));
    }
    if ("com.widevine".equals(paramString2)) {
      return new DrmInitData.SchemeData(w0.d, "hls", o0.e0(paramString1));
    }
    if (("com.microsoft.playready".equals(paramString2)) && ("1".equals(str)))
    {
      paramString1 = z(paramString1, I, paramMap);
      paramString1 = Base64.decode(paramString1.substring(paramString1.indexOf(',')), 0);
      paramString2 = w0.e;
      return new DrmInitData.SchemeData(paramString2, "video/mp4", l.a(paramString2, paramString1));
    }
    return null;
  }
  
  private static String l(String paramString)
  {
    if ((!"SAMPLE-AES-CENC".equals(paramString)) && (!"SAMPLE-AES-CTR".equals(paramString))) {
      paramString = "cbcs";
    } else {
      paramString = "cenc";
    }
    return paramString;
  }
  
  private static int m(String paramString, Pattern paramPattern)
    throws ParserException
  {
    return Integer.parseInt(z(paramString, paramPattern, Collections.emptyMap()));
  }
  
  private static long n(String paramString, Pattern paramPattern)
    throws ParserException
  {
    return Long.parseLong(z(paramString, paramPattern, Collections.emptyMap()));
  }
  
  private static f o(a parama, String paramString)
    throws IOException
  {
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject5 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    boolean bool1 = false;
    boolean bool2;
    Object localObject7;
    label327:
    Object localObject9;
    label454:
    String str1;
    Object localObject10;
    String str2;
    for (int i1 = 0;; i1 = i2)
    {
      localObject6 = paramString;
      bool2 = parama.a();
      localObject7 = "application/x-mpegURL";
      if (!bool2) {
        break label753;
      }
      localObject7 = parama.b();
      if (((String)localObject7).startsWith("#EXT")) {
        localArrayList4.add(localObject7);
      }
      bool2 = ((String)localObject7).startsWith("#EXT-X-I-FRAME-STREAM-INF");
      if (((String)localObject7).startsWith("#EXT-X-DEFINE"))
      {
        localHashMap.put(z((String)localObject7, N, localHashMap), z((String)localObject7, X, localHashMap));
      }
      else
      {
        if (((String)localObject7).equals("#EXT-X-INDEPENDENT-SEGMENTS"))
        {
          bool1 = true;
          i2 = i1;
          continue;
        }
        if (((String)localObject7).startsWith("#EXT-X-MEDIA"))
        {
          ((ArrayList)localObject5).add(localObject7);
        }
        else if (((String)localObject7).startsWith("#EXT-X-SESSION-KEY"))
        {
          localObject6 = k((String)localObject7, u((String)localObject7, G, "identity", localHashMap), localHashMap);
          if (localObject6 != null) {
            localArrayList3.add(new DrmInitData(l(z((String)localObject7, F, localHashMap)), new DrmInitData.SchemeData[] { localObject6 }));
          }
        }
        else
        {
          if ((((String)localObject7).startsWith("#EXT-X-STREAM-INF")) || (bool2)) {
            break label327;
          }
        }
      }
      i2 = i1;
      continue;
      int i3 = i1 | ((String)localObject7).contains("CLOSED-CAPTIONS=NONE");
      if (bool2) {
        i4 = 16384;
      } else {
        i4 = 0;
      }
      int i5 = m((String)localObject7, f);
      int i6 = s((String)localObject7, a, -1);
      localObject8 = v((String)localObject7, h, localHashMap);
      localObject9 = v((String)localObject7, i, localHashMap);
      if (localObject9 != null)
      {
        localObject9 = o0.E0((String)localObject9, "x");
        i2 = Integer.parseInt(localObject9[0]);
        i1 = Integer.parseInt(localObject9[1]);
        if ((i2 > 0) && (i1 > 0)) {
          break label454;
        }
        i1 = -1;
        i2 = -1;
      }
      else
      {
        i2 = -1;
        i1 = -1;
      }
      localObject9 = v((String)localObject7, j, localHashMap);
      float f1;
      if (localObject9 != null) {
        f1 = Float.parseFloat((String)localObject9);
      } else {
        f1 = -1.0F;
      }
      str1 = v((String)localObject7, b, localHashMap);
      localObject10 = v((String)localObject7, c, localHashMap);
      str2 = v((String)localObject7, d, localHashMap);
      localObject11 = v((String)localObject7, e, localHashMap);
      if (bool2)
      {
        localObject6 = n0.d((String)localObject6, z((String)localObject7, I, localHashMap));
      }
      else
      {
        if (!parama.a()) {
          break;
        }
        localObject6 = n0.d((String)localObject6, A(parama.b(), localHashMap));
      }
      localArrayList1.add(new f.b((Uri)localObject6, new Format.b().R(localArrayList1.size()).K("application/x-mpegURL").I((String)localObject8).G(i6).Z(i5).j0(i2).Q(i1).P(f1).c0(i4).E(), str1, (String)localObject10, str2, (String)localObject11));
      localObject7 = localObject1;
      localObject9 = (ArrayList)((HashMap)localObject7).get(localObject6);
      localObject8 = localObject9;
      if (localObject9 == null)
      {
        localObject8 = new ArrayList();
        ((HashMap)localObject7).put(localObject6, localObject8);
      }
      ((ArrayList)localObject8).add(new HlsTrackMetadataEntry.VariantInfo(i6, i5, str1, (String)localObject10, str2, (String)localObject11));
      i2 = i3;
    }
    throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
    label753:
    Object localObject6 = localObject5;
    parama = (a)localObject3;
    localObject5 = localObject4;
    Object localObject11 = new ArrayList();
    localObject4 = new HashSet();
    for (int i2 = 0; i2 < localArrayList1.size(); i2++)
    {
      localObject3 = (f.b)localArrayList1.get(i2);
      if (((HashSet)localObject4).add(((f.b)localObject3).a))
      {
        if (((f.b)localObject3).b.p2 == null) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        com.google.android.exoplayer2.util.g.g(bool2);
        localObject8 = new Metadata(new Metadata.Entry[] { new HlsTrackMetadataEntry(null, null, (List)com.google.android.exoplayer2.util.g.e((ArrayList)((HashMap)localObject1).get(((f.b)localObject3).a))) });
        ((ArrayList)localObject11).add(((f.b)localObject3).a(((f.b)localObject3).b.a().X((Metadata)localObject8).E()));
      }
    }
    localObject1 = null;
    Object localObject8 = localObject1;
    int i4 = 0;
    localObject4 = localObject6;
    localObject3 = localObject2;
    localObject2 = parama;
    localObject6 = localObject7;
    parama = (a)localObject8;
    while (i4 < ((ArrayList)localObject4).size())
    {
      localObject7 = (String)((ArrayList)localObject4).get(i4);
      str2 = z((String)localObject7, O, localHashMap);
      str1 = z((String)localObject7, N, localHashMap);
      localObject8 = new Format.b();
      localObject9 = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str1).length());
      ((StringBuilder)localObject9).append(str2);
      ((StringBuilder)localObject9).append(":");
      ((StringBuilder)localObject9).append(str1);
      localObject10 = ((Format.b)localObject8).S(((StringBuilder)localObject9).toString()).U(str1).K((String)localObject6).g0(x((String)localObject7)).c0(w((String)localObject7, localHashMap)).V(v((String)localObject7, M, localHashMap));
      localObject8 = v((String)localObject7, I, localHashMap);
      if (localObject8 == null) {
        localObject8 = null;
      } else {
        localObject8 = n0.d(paramString, (String)localObject8);
      }
      localObject9 = localObject4;
      Metadata localMetadata = new Metadata(new Metadata.Entry[] { new HlsTrackMetadataEntry(str2, str1, Collections.emptyList()) });
      localObject4 = z((String)localObject7, K, localHashMap);
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
              i2 = -1;
              break;
            } while (!((String)localObject4).equals("VIDEO"));
            i2 = 3;
            break;
          } while (!((String)localObject4).equals("AUDIO"));
          i2 = 2;
          break;
        } while (!((String)localObject4).equals("CLOSED-CAPTIONS"));
        i2 = 1;
        break;
      } while (!((String)localObject4).equals("SUBTITLES"));
      i2 = 0;
      switch (i2)
      {
      }
      for (;;)
      {
        break;
        localObject4 = h(localArrayList1, str2);
        if (localObject4 != null)
        {
          localObject4 = ((f.b)localObject4).b;
          localObject7 = o0.G(((Format)localObject4).p1, 2);
          ((Format.b)localObject10).I((String)localObject7).e0(y.g((String)localObject7)).j0(((Format)localObject4).M3).Q(((Format)localObject4).N3).P(((Format)localObject4).O3);
        }
        if (localObject8 != null)
        {
          ((Format.b)localObject10).X(localMetadata);
          ((ArrayList)localObject3).add(new f.a((Uri)localObject8, ((Format.b)localObject10).E(), str2, str1));
          continue;
          f.b localb = f(localArrayList1, str2);
          if (localb != null)
          {
            localObject4 = o0.G(localb.b.p1, 1);
            ((Format.b)localObject10).I((String)localObject4);
            localObject4 = y.g((String)localObject4);
          }
          else
          {
            localObject4 = null;
          }
          String str3 = v((String)localObject7, g, localHashMap);
          if (str3 != null)
          {
            ((Format.b)localObject10).H(Integer.parseInt(o0.F0(str3, "/")[0]));
            localObject7 = localObject4;
            if ("audio/eac3".equals(localObject4))
            {
              localObject7 = localObject4;
              if (str3.endsWith("/JOC"))
              {
                ((Format.b)localObject10).I("ec+3");
                localObject7 = "audio/eac3-joc";
              }
            }
          }
          else
          {
            localObject7 = localObject4;
          }
          ((Format.b)localObject10).e0((String)localObject7);
          if (localObject8 != null)
          {
            ((Format.b)localObject10).X(localMetadata);
            ((ArrayList)localObject2).add(new f.a((Uri)localObject8, ((Format.b)localObject10).E(), str2, str1));
            localObject4 = localObject1;
          }
          else
          {
            localObject4 = localObject1;
            if (localb != null)
            {
              parama = ((Format.b)localObject10).E();
              localObject4 = localObject1;
              break label1776;
              localObject4 = z((String)localObject7, Q, localHashMap);
              if (((String)localObject4).startsWith("CC"))
              {
                i2 = Integer.parseInt(((String)localObject4).substring(2));
                localObject8 = "application/cea-608";
              }
              else
              {
                i2 = Integer.parseInt(((String)localObject4).substring(7));
                localObject8 = "application/cea-708";
              }
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = new ArrayList();
              }
              ((Format.b)localObject10).e0((String)localObject8).F(i2);
              ((List)localObject4).add(((Format.b)localObject10).E());
            }
          }
          label1776:
          localObject1 = localObject4;
          break;
          localObject4 = parama;
          parama = g(localArrayList1, str2);
          if (parama != null)
          {
            parama = o0.G(parama.b.p1, 3);
            ((Format.b)localObject10).I(parama);
            parama = y.g(parama);
          }
          else
          {
            parama = null;
          }
          localObject7 = parama;
          if (parama == null) {
            localObject7 = "text/vtt";
          }
          ((Format.b)localObject10).e0((String)localObject7).X(localMetadata);
          if (localObject8 != null)
          {
            ((ArrayList)localObject5).add(new f.a((Uri)localObject8, ((Format.b)localObject10).E(), str2, str1));
            parama = (a)localObject4;
          }
          else
          {
            u.h("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
            parama = (a)localObject4;
          }
        }
      }
      i4++;
      localObject4 = localObject9;
    }
    if (i1 != 0) {
      localObject1 = Collections.emptyList();
    }
    return new f(paramString, localArrayList4, (List)localObject11, (List)localObject3, (List)localObject2, (List)localObject5, localArrayList2, parama, (List)localObject1, bool1, localHashMap, localArrayList3);
  }
  
  private static g p(f paramf, @Nullable g paramg, a parama, String paramString)
    throws IOException
  {
    Object localObject1 = paramg;
    boolean bool1 = paramf.c;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = new HashMap();
    ArrayList localArrayList3 = new ArrayList();
    g.f localf = new g.f(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
    TreeMap localTreeMap = new TreeMap();
    Object localObject3 = "";
    Object localObject4 = "";
    long l1 = 0L;
    long l2 = l1;
    long l3 = l2;
    long l4 = l3;
    long l5 = l4;
    long l6 = l5;
    long l7 = l6;
    long l8 = l7;
    boolean bool2 = false;
    int i1 = 0;
    long l9 = -9223372036854775807L;
    boolean bool3 = false;
    int i2 = 0;
    int i3 = 1;
    long l10 = -9223372036854775807L;
    long l11 = -9223372036854775807L;
    boolean bool4 = false;
    Object localObject5 = null;
    Object localObject6 = null;
    boolean bool5 = false;
    Object localObject7 = null;
    Object localObject8 = null;
    long l12 = -1L;
    Object localObject9 = null;
    Object localObject10 = null;
    int i4 = 0;
    int i5 = 0;
    Object localObject11 = null;
    long l13 = l2;
    l2 = l1;
    while (parama.a())
    {
      Object localObject12 = parama.b();
      if (((String)localObject12).startsWith("#EXT")) {
        localArrayList3.add(localObject12);
      }
      Object localObject13;
      if (((String)localObject12).startsWith("#EXT-X-PLAYLIST-TYPE"))
      {
        localObject13 = z((String)localObject12, o, localHashMap1);
        if ("VOD".equals(localObject13)) {
          i1 = 1;
        } else if ("EVENT".equals(localObject13)) {
          i1 = 2;
        }
      }
      else if (((String)localObject12).equals("#EXT-X-I-FRAMES-ONLY"))
      {
        i5 = 1;
      }
      else if (((String)localObject12).startsWith("#EXT-X-START"))
      {
        l9 = (j((String)localObject12, A) * 1000000.0D);
        bool2 = q((String)localObject12, W, false);
      }
      else if (((String)localObject12).startsWith("#EXT-X-SERVER-CONTROL"))
      {
        localf = y((String)localObject12);
      }
      else if (((String)localObject12).startsWith("#EXT-X-PART-INF"))
      {
        l11 = (j((String)localObject12, m) * 1000000.0D);
      }
      else
      {
        long l14;
        if (((String)localObject12).startsWith("#EXT-X-MAP"))
        {
          localObject11 = z((String)localObject12, I, localHashMap1);
          localObject13 = v((String)localObject12, C, localHashMap1);
          l1 = l3;
          if (localObject13 != null)
          {
            localObject13 = o0.E0((String)localObject13, "@");
            l14 = Long.parseLong(localObject13[0]);
            l1 = l3;
            l12 = l14;
            if (localObject13.length > 1)
            {
              l1 = Long.parseLong(localObject13[1]);
              l12 = l14;
            }
          }
          boolean bool6 = l12 < -1L;
          if (!bool6) {
            l1 = 0L;
          }
          if ((localObject8 != null) && (localObject9 == null)) {
            throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
          }
          localObject11 = new g.d((String)localObject11, l1, l12, (String)localObject8, (String)localObject9);
          l3 = l1;
          if (bool6) {
            l3 = l1 + l12;
          }
          l12 = -1L;
        }
        else
        {
          if (((String)localObject12).startsWith("#EXT-X-TARGETDURATION")) {
            l10 = 1000000L * m((String)localObject12, k);
          }
          for (;;)
          {
            break;
            if (((String)localObject12).startsWith("#EXT-X-MEDIA-SEQUENCE"))
            {
              l6 = n((String)localObject12, v);
              l13 = l6;
            }
            else
            {
              if (!((String)localObject12).startsWith("#EXT-X-VERSION")) {
                break label659;
              }
              i3 = m((String)localObject12, n);
            }
          }
          label659:
          if (((String)localObject12).startsWith("#EXT-X-DEFINE"))
          {
            localObject1 = v((String)localObject12, Y, localHashMap1);
            if (localObject1 != null)
            {
              localObject13 = (String)paramf.m.get(localObject1);
              if (localObject13 != null) {
                localHashMap1.put(localObject1, localObject13);
              }
            }
            else
            {
              localHashMap1.put(z((String)localObject12, N, localHashMap1), z((String)localObject12, X, localHashMap1));
            }
          }
          else
          {
            if (((String)localObject12).startsWith("#EXTINF"))
            {
              double d1 = j((String)localObject12, w);
              l7 = (d1 * 1000000.0D);
              localObject4 = u((String)localObject12, x, (String)localObject3, localHashMap1);
              localObject13 = localObject8;
            }
            label802:
            int i7;
            boolean bool9;
            int i6;
            for (localObject8 = localObject1;; localObject8 = paramg)
            {
              localObject1 = localObject8;
              localObject8 = localObject13;
              break;
              localObject13 = localObject8;
              if (!((String)localObject12).startsWith("#EXT-X-SKIP")) {
                break label1115;
              }
              i7 = m((String)localObject12, r);
              if ((localObject1 != null) && (localArrayList1.isEmpty())) {
                bool9 = true;
              } else {
                bool9 = false;
              }
              com.google.android.exoplayer2.util.g.g(bool9);
              i6 = (int)(l13 - ((g)o0.i(paramg)).k);
              i7 += i6;
              if ((i6 < 0) || (i7 > ((g)localObject1).r.size())) {
                break label1107;
              }
              while (i6 < i7)
              {
                localObject8 = (g.d)((g)localObject1).r.get(i6);
                localObject6 = localObject8;
                if (l13 != ((g)localObject1).k) {
                  localObject6 = ((g.d)localObject8).b(l5, ((g)localObject1).j - i2 + ((g.e)localObject8).q);
                }
                localArrayList1.add(localObject6);
                l5 += ((g.e)localObject6).f;
                l4 = ((g.e)localObject6).p2;
                if (l4 != -1L) {
                  l3 = ((g.e)localObject6).p1 + l4;
                }
                i4 = ((g.e)localObject6).q;
                localObject11 = ((g.e)localObject6).d;
                localObject8 = ((g.e)localObject6).y;
                localObject13 = ((g.e)localObject6).z;
                localObject1 = ((g.e)localObject6).p0;
                if ((localObject1 == null) || (!((String)localObject1).equals(Long.toHexString(l6)))) {
                  localObject9 = ((g.e)localObject6).p0;
                }
                l6 += 1L;
                i6++;
                localObject1 = paramg;
                l4 = l5;
                localObject6 = localObject8;
              }
            }
            label1107:
            throw new DeltaUpdateException();
            label1115:
            localObject1 = localObject3;
            if (((String)localObject12).startsWith("#EXT-X-KEY"))
            {
              localObject13 = z((String)localObject12, F, localHashMap1);
              localObject8 = u((String)localObject12, G, "identity", localHashMap1);
              if ("NONE".equals(localObject13))
              {
                localTreeMap.clear();
                localObject9 = null;
                localObject8 = localObject9;
                localObject6 = localObject8;
              }
              else
              {
                localObject9 = v((String)localObject12, J, localHashMap1);
                if ("identity".equals(localObject8))
                {
                  localObject1 = localObject10;
                  if ("AES-128".equals(localObject13))
                  {
                    localObject8 = z((String)localObject12, I, localHashMap1);
                    localObject1 = localObject9;
                    localObject9 = localObject8;
                    localObject8 = localObject6;
                    localObject6 = localObject1;
                    break label1334;
                  }
                }
                do
                {
                  localObject10 = localObject9;
                  localObject9 = null;
                  localObject8 = localObject6;
                  localObject6 = localObject10;
                  localObject10 = localObject1;
                  break;
                  if (localObject10 == null) {
                    localObject10 = l((String)localObject13);
                  }
                  localObject13 = k((String)localObject12, (String)localObject8, localHashMap1);
                  localObject1 = localObject10;
                } while (localObject13 == null);
                localTreeMap.put(localObject8, localObject13);
                localObject6 = localObject9;
                localObject9 = null;
                localObject8 = localObject9;
              }
              label1334:
              localObject13 = localObject9;
              localObject9 = localObject6;
              localObject6 = localObject8;
            }
            label1569:
            label1572:
            boolean bool7;
            for (;;)
            {
              localObject1 = paramg;
              localObject8 = localObject13;
              break;
              if (((String)localObject12).startsWith("#EXT-X-BYTERANGE"))
              {
                localObject8 = o0.E0(z((String)localObject12, B, localHashMap1), "@");
                l14 = Long.parseLong(localObject8[0]);
                l1 = l2;
                l12 = l14;
                i6 = i4;
                if (localObject8.length > 1)
                {
                  l3 = Long.parseLong(localObject8[1]);
                  i6 = i4;
                  l12 = l14;
                  l1 = l2;
                }
              }
              for (;;)
              {
                localObject8 = paramg;
                localObject3 = localObject1;
                l2 = l1;
                i4 = i6;
                break;
                if (((String)localObject12).startsWith("#EXT-X-DISCONTINUITY-SEQUENCE"))
                {
                  i2 = Integer.parseInt(((String)localObject12).substring(((String)localObject12).indexOf(':') + 1));
                  localObject8 = paramg;
                  localObject3 = localObject1;
                  bool3 = true;
                  break;
                }
                if (((String)localObject12).equals("#EXT-X-DISCONTINUITY"))
                {
                  i6 = i4 + 1;
                  l1 = l2;
                }
                else
                {
                  if (!((String)localObject12).startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                    break label1572;
                  }
                  if (l2 != 0L) {
                    break label1569;
                  }
                  l1 = w0.d(o0.y0(((String)localObject12).substring(((String)localObject12).indexOf(':') + 1))) - l5;
                  i6 = i4;
                }
              }
              break label2773;
              if (((String)localObject12).equals("#EXT-X-GAP"))
              {
                localObject8 = paramg;
                localObject3 = localObject1;
                bool5 = true;
                break label802;
              }
              if (((String)localObject12).equals("#EXT-X-INDEPENDENT-SEGMENTS"))
              {
                localObject8 = paramg;
                localObject3 = localObject1;
                bool1 = true;
                break label802;
              }
              if (((String)localObject12).equals("#EXT-X-ENDLIST"))
              {
                localObject8 = paramg;
                localObject3 = localObject1;
                bool4 = true;
                break label802;
              }
              if (((String)localObject12).startsWith("#EXT-X-RENDITION-REPORT"))
              {
                l1 = localArrayList1.size();
                l14 = localArrayList2.isEmpty();
                l1 = t((String)localObject12, y, l13 + l1 - l14);
                if (localArrayList2.isEmpty()) {
                  localObject1 = ((g.d)j1.f(localArrayList1)).I3;
                } else {
                  localObject1 = localArrayList2;
                }
                if (l11 != -9223372036854775807L) {
                  i6 = ((List)localObject1).size() - 1;
                } else {
                  i6 = -1;
                }
                i6 = s((String)localObject12, z, i6);
                localObject1 = Uri.parse(n0.c(paramString, z((String)localObject12, I, localHashMap1)));
                ((Map)localObject2).put(localObject1, new g.c((Uri)localObject1, l1, i6));
              }
              else
              {
                if (!((String)localObject12).startsWith("#EXT-X-PRELOAD-HINT")) {
                  break label2053;
                }
                localObject1 = localObject7;
              }
              while (!"PART".equals(z((String)localObject12, L, localHashMap1))) {}
              localObject14 = z((String)localObject12, I, localHashMap1);
              l1 = t((String)localObject12, D, -1L);
              l14 = t((String)localObject12, E, -1L);
              localObject15 = e(l6, (String)localObject13, (String)localObject9);
              if ((localObject6 == null) && (!localTreeMap.isEmpty()))
              {
                localObject12 = (DrmInitData.SchemeData[])localTreeMap.values().toArray(new DrmInitData.SchemeData[0]);
                localObject7 = localObject10;
                localObject8 = new DrmInitData((String)localObject7, (DrmInitData.SchemeData[])localObject12);
                localObject6 = localObject5;
                if (localObject5 == null) {
                  localObject6 = d((String)localObject7, (DrmInitData.SchemeData[])localObject12);
                }
                localObject5 = localObject6;
                localObject6 = localObject8;
              }
              bool7 = l1 < -1L;
              if (bool7)
              {
                localObject8 = localObject1;
                if (l14 == -1L) {}
              }
              else
              {
                if (!bool7) {
                  l1 = 0L;
                }
                localObject8 = new g.b((String)localObject14, (g.d)localObject11, 0L, i4, l4, (DrmInitData)localObject6, (String)localObject13, (String)localObject15, l1, l14, false, false, true);
              }
              localObject7 = localObject8;
            }
            label2053:
            Object localObject14 = localObject2;
            Object localObject15 = localObject10;
            Object localObject16;
            if (((String)localObject12).startsWith("#EXT-X-PART"))
            {
              localObject16 = e(l6, (String)localObject13, (String)localObject9);
              localObject2 = z((String)localObject12, I, localHashMap1);
              long l15 = (j((String)localObject12, l) * 1000000.0D);
              bool9 = q((String)localObject12, U, false);
              if ((bool1) && (localArrayList2.isEmpty())) {
                bool7 = true;
              } else {
                bool7 = false;
              }
              boolean bool10 = q((String)localObject12, V, false);
              localObject10 = v((String)localObject12, C, localHashMap1);
              if (localObject10 != null)
              {
                localObject10 = o0.E0((String)localObject10, "@");
                l14 = Long.parseLong(localObject10[0]);
                i7 = localObject10.length;
                l1 = l14;
                if (i7 > 1)
                {
                  l8 = Long.parseLong(localObject10[1]);
                  l1 = l14;
                }
              }
              else
              {
                l1 = -1L;
              }
              boolean bool8 = l1 < -1L;
              if (!bool8) {
                l8 = 0L;
              }
              localObject1 = localObject5;
              localObject10 = localObject6;
              if (localObject6 == null)
              {
                localObject1 = localObject5;
                localObject10 = localObject6;
                if (!localTreeMap.isEmpty())
                {
                  localObject6 = (DrmInitData.SchemeData[])localTreeMap.values().toArray(new DrmInitData.SchemeData[0]);
                  localObject10 = new DrmInitData((String)localObject15, (DrmInitData.SchemeData[])localObject6);
                  localObject1 = localObject5;
                  if (localObject5 == null) {
                    localObject1 = d((String)localObject15, (DrmInitData.SchemeData[])localObject6);
                  }
                }
              }
              localArrayList2.add(new g.b((String)localObject2, (g.d)localObject11, l15, i4, l4, (DrmInitData)localObject10, (String)localObject13, (String)localObject16, l8, l1, bool10, bool9 | bool7, false));
              l14 = l4 + l15;
              l4 = l8;
              if (bool8) {
                l4 = l8 + l1;
              }
              localObject2 = localObject14;
              localObject5 = localObject1;
              localObject6 = localObject10;
              l1 = l14;
              localObject10 = localObject15;
              l8 = l4;
              break label2777;
            }
            if (!((String)localObject12).startsWith("#"))
            {
              localObject3 = e(l6, (String)localObject13, (String)localObject9);
              l1 = l6 + 1L;
              localObject12 = A((String)localObject12, localHashMap1);
              localObject10 = (g.d)localHashMap2.get(localObject12);
              bool7 = l12 < -1L;
              if (!bool7)
              {
                l6 = 0L;
                localObject8 = localObject10;
              }
              else
              {
                localObject8 = localObject10;
                if (i5 != 0)
                {
                  localObject8 = localObject10;
                  if (localObject11 == null)
                  {
                    localObject8 = localObject10;
                    if (localObject10 == null)
                    {
                      localObject8 = new g.d((String)localObject12, 0L, l3, null, null);
                      localHashMap2.put(localObject12, localObject8);
                    }
                  }
                }
                l6 = l3;
              }
              if ((localObject6 == null) && (!localTreeMap.isEmpty()))
              {
                localObject16 = (DrmInitData.SchemeData[])localTreeMap.values().toArray(new DrmInitData.SchemeData[0]);
                localObject2 = new DrmInitData((String)localObject15, (DrmInitData.SchemeData[])localObject16);
                localObject10 = localObject2;
                localObject6 = localObject5;
                if (localObject5 == null)
                {
                  localObject6 = d((String)localObject15, (DrmInitData.SchemeData[])localObject16);
                  localObject10 = localObject2;
                }
              }
              else
              {
                localObject10 = localObject6;
                localObject6 = localObject5;
              }
              if (localObject11 != null) {
                localObject8 = localObject11;
              }
              localArrayList1.add(new g.d((String)localObject12, (g.d)localObject8, (String)localObject4, l7, i4, l5, (DrmInitData)localObject10, (String)localObject13, (String)localObject3, l6, l12, bool5, localArrayList2));
              l4 = l5 + l7;
              localArrayList2 = new ArrayList();
              l3 = l6;
              if (bool7) {
                l3 = l6 + l12;
              }
              localObject5 = paramg;
              localObject8 = localObject10;
              localObject10 = localObject15;
              l7 = 0L;
              l5 = l4;
              localObject2 = localObject14;
              localObject4 = localObject1;
              bool5 = false;
              l12 = -1L;
              localObject3 = localObject4;
              localObject1 = localObject5;
              localObject5 = localObject6;
              localObject6 = localObject8;
              localObject8 = localObject13;
              l6 = l1;
              continue;
            }
          }
          label2773:
          l1 = l4;
          label2777:
          localObject1 = paramg;
          l4 = l1;
        }
      }
    }
    if (localObject7 != null) {
      localArrayList2.add(localObject7);
    }
    if (l2 != 0L) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    return new g(i1, paramString, localArrayList3, l9, bool2, l2, bool3, i2, l13, i3, l10, l11, bool1, bool4, bool5, (DrmInitData)localObject5, localArrayList1, localArrayList2, localf, (Map)localObject2);
  }
  
  private static boolean q(String paramString, Pattern paramPattern, boolean paramBoolean)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return "YES".equals(paramString.group(1));
    }
    return paramBoolean;
  }
  
  private static double r(String paramString, Pattern paramPattern, double paramDouble)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return Double.parseDouble((String)com.google.android.exoplayer2.util.g.e(paramString.group(1)));
    }
    return paramDouble;
  }
  
  private static int s(String paramString, Pattern paramPattern, int paramInt)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return Integer.parseInt((String)com.google.android.exoplayer2.util.g.e(paramString.group(1)));
    }
    return paramInt;
  }
  
  private static long t(String paramString, Pattern paramPattern, long paramLong)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return Long.parseLong((String)com.google.android.exoplayer2.util.g.e(paramString.group(1)));
    }
    return paramLong;
  }
  
  private static String u(String paramString1, Pattern paramPattern, String paramString2, Map<String, String> paramMap)
  {
    paramString1 = paramPattern.matcher(paramString1);
    if (paramString1.find()) {
      paramString2 = (String)com.google.android.exoplayer2.util.g.e(paramString1.group(1));
    }
    paramString1 = paramString2;
    if (!paramMap.isEmpty()) {
      if (paramString2 == null) {
        paramString1 = paramString2;
      } else {
        paramString1 = A(paramString2, paramMap);
      }
    }
    return paramString1;
  }
  
  @Nullable
  private static String v(String paramString, Pattern paramPattern, Map<String, String> paramMap)
  {
    return u(paramString, paramPattern, null, paramMap);
  }
  
  private static int w(String paramString, Map<String, String> paramMap)
  {
    paramString = v(paramString, P, paramMap);
    boolean bool = TextUtils.isEmpty(paramString);
    int i1 = 0;
    if (bool) {
      return 0;
    }
    paramString = o0.E0(paramString, ",");
    if (o0.r(paramString, "public.accessibility.describes-video")) {
      i1 = 512;
    }
    int i2 = i1;
    if (o0.r(paramString, "public.accessibility.transcribes-spoken-dialog")) {
      i2 = i1 | 0x1000;
    }
    i1 = i2;
    if (o0.r(paramString, "public.accessibility.describes-music-and-sound")) {
      i1 = i2 | 0x400;
    }
    i2 = i1;
    if (o0.r(paramString, "public.easy-to-read")) {
      i2 = i1 | 0x2000;
    }
    return i2;
  }
  
  private static int x(String paramString)
  {
    if (q(paramString, S, false)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (q(paramString, T, false)) {
      i2 = i1 | 0x2;
    }
    int i1 = i2;
    if (q(paramString, R, false)) {
      i1 = i2 | 0x4;
    }
    return i1;
  }
  
  private static g.f y(String paramString)
  {
    double d1 = r(paramString, p, -9.223372036854776E18D);
    long l1 = -9223372036854775807L;
    long l2;
    if (d1 == -9.223372036854776E18D) {
      l2 = -9223372036854775807L;
    } else {
      l2 = (d1 * 1000000.0D);
    }
    boolean bool = q(paramString, q, false);
    d1 = r(paramString, s, -9.223372036854776E18D);
    long l3;
    if (d1 == -9.223372036854776E18D) {
      l3 = -9223372036854775807L;
    } else {
      l3 = (d1 * 1000000.0D);
    }
    d1 = r(paramString, t, -9.223372036854776E18D);
    if (d1 != -9.223372036854776E18D) {
      l1 = (d1 * 1000000.0D);
    }
    return new g.f(l2, bool, l3, l1, q(paramString, u, false));
  }
  
  private static String z(String paramString, Pattern paramPattern, Map<String, String> paramMap)
    throws ParserException
  {
    paramMap = v(paramString, paramPattern, paramMap);
    if (paramMap != null) {
      return paramMap;
    }
    paramPattern = paramPattern.pattern();
    paramMap = new StringBuilder(String.valueOf(paramPattern).length() + 19 + String.valueOf(paramString).length());
    paramMap.append("Couldn't match ");
    paramMap.append(paramPattern);
    paramMap.append(" in ");
    paramMap.append(paramString);
    throw ParserException.createForMalformedManifest(paramMap.toString(), null);
  }
  
  public h i(Uri paramUri, InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    ArrayDeque localArrayDeque = new ArrayDeque();
    try
    {
      if (b(paramInputStream))
      {
        for (;;)
        {
          localObject = paramInputStream.readLine();
          if (localObject == null) {
            break label264;
          }
          localObject = ((String)localObject).trim();
          if (!((String)localObject).isEmpty())
          {
            if (((String)localObject).startsWith("#EXT-X-STREAM-INF"))
            {
              localArrayDeque.add(localObject);
              localObject = new com/google/android/exoplayer2/source/hls/playlist/HlsPlaylistParser$a;
              ((a)localObject).<init>(localArrayDeque, paramInputStream);
              paramUri = o((a)localObject, paramUri.toString());
              return paramUri;
            }
            if ((((String)localObject).startsWith("#EXT-X-TARGETDURATION")) || (((String)localObject).startsWith("#EXT-X-MEDIA-SEQUENCE")) || (((String)localObject).startsWith("#EXTINF")) || (((String)localObject).startsWith("#EXT-X-KEY")) || (((String)localObject).startsWith("#EXT-X-BYTERANGE")) || (((String)localObject).equals("#EXT-X-DISCONTINUITY")) || (((String)localObject).equals("#EXT-X-DISCONTINUITY-SEQUENCE")) || (((String)localObject).equals("#EXT-X-ENDLIST"))) {
              break;
            }
            localArrayDeque.add(localObject);
          }
        }
        localArrayDeque.add(localObject);
        f localf = this.a0;
        Object localObject = this.b0;
        a locala = new com/google/android/exoplayer2/source/hls/playlist/HlsPlaylistParser$a;
        locala.<init>(localArrayDeque, paramInputStream);
        paramUri = p(localf, (g)localObject, locala, paramUri.toString());
        return paramUri;
        label264:
        throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
      }
      throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
    }
    finally
    {
      o0.m(paramInputStream);
    }
  }
  
  public static final class DeltaUpdateException
    extends IOException
  {}
  
  private static class a
  {
    private final BufferedReader a;
    private final Queue<String> b;
    @Nullable
    private String c;
    
    public a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
    {
      this.b = paramQueue;
      this.a = paramBufferedReader;
    }
    
    @EnsuresNonNullIf(expression={"next"}, result=true)
    public boolean a()
      throws IOException
    {
      if (this.c != null) {
        return true;
      }
      if (!this.b.isEmpty())
      {
        this.c = ((String)com.google.android.exoplayer2.util.g.e((String)this.b.poll()));
        return true;
      }
      String str;
      do
      {
        str = this.a.readLine();
        this.c = str;
        if (str == null) {
          break;
        }
        str = str.trim();
        this.c = str;
      } while (str.isEmpty());
      return true;
      return false;
    }
    
    public String b()
      throws IOException
    {
      if (a())
      {
        String str = this.c;
        this.c = null;
        return str;
      }
      throw new NoSuchElementException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\playlist\HlsPlaylistParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */