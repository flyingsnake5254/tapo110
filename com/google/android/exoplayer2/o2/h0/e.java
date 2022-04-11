package com.google.android.exoplayer2.o2.h0;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.m.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.b0.a;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.p;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class e
  implements j
{
  public static final o a = a.b;
  private static final byte[] b = { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
  private static final byte[] c = o0.e0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
  private static final byte[] d = { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
  private static final UUID e = new UUID(72057594037932032L, -9223371306706625679L);
  private static final Map<String, Integer> f;
  @Nullable
  private c A;
  private boolean B;
  private int C;
  private long D;
  private boolean E;
  private long F = -1L;
  private long G = -1L;
  private long H = -9223372036854775807L;
  @Nullable
  private v I;
  @Nullable
  private v J;
  private boolean K;
  private boolean L;
  private int M;
  private long N;
  private long O;
  private int P;
  private int Q;
  private int[] R;
  private int S;
  private int T;
  private int U;
  private int V;
  private boolean W;
  private int X;
  private int Y;
  private int Z;
  private boolean a0;
  private boolean b0;
  private boolean c0;
  private int d0;
  private byte e0;
  private boolean f0;
  private final d g;
  private l g0;
  private final g h;
  private final SparseArray<c> i;
  private final boolean j;
  private final d0 k;
  private final d0 l;
  private final d0 m;
  private final d0 n;
  private final d0 o;
  private final d0 p;
  private final d0 q;
  private final d0 r;
  private final d0 s;
  private final d0 t;
  private ByteBuffer u;
  private long v;
  private long w = -1L;
  private long x = -9223372036854775807L;
  private long y = -9223372036854775807L;
  private long z = -9223372036854775807L;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("htc_video_rotA-000", Integer.valueOf(0));
    localHashMap.put("htc_video_rotA-090", Integer.valueOf(90));
    localHashMap.put("htc_video_rotA-180", Integer.valueOf(180));
    localHashMap.put("htc_video_rotA-270", Integer.valueOf(270));
    f = Collections.unmodifiableMap(localHashMap);
  }
  
  public e()
  {
    this(0);
  }
  
  public e(int paramInt)
  {
    this(new b(), paramInt);
  }
  
  e(d paramd, int paramInt)
  {
    this.g = paramd;
    paramd.b(new b(null));
    boolean bool;
    if ((paramInt & 0x1) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.j = bool;
    this.h = new g();
    this.i = new SparseArray();
    this.m = new d0(4);
    this.n = new d0(ByteBuffer.allocate(4).putInt(-1).array());
    this.o = new d0(4);
    this.k = new d0(z.a);
    this.l = new d0(4);
    this.p = new d0();
    this.q = new d0();
    this.r = new d0(8);
    this.s = new d0();
    this.t = new d0();
    this.R = new int[1];
  }
  
  private boolean A(x paramx, long paramLong)
  {
    if (this.E)
    {
      this.G = paramLong;
      paramx.a = this.F;
      this.E = false;
      return true;
    }
    if (this.B)
    {
      paramLong = this.G;
      if (paramLong != -1L)
      {
        paramx.a = paramLong;
        this.G = -1L;
        return true;
      }
    }
    return false;
  }
  
  private void B(k paramk, int paramInt)
    throws IOException
  {
    if (this.m.f() >= paramInt) {
      return;
    }
    if (this.m.b() < paramInt)
    {
      d0 locald0 = this.m;
      locald0.c(Math.max(locald0.b() * 2, paramInt));
    }
    paramk.readFully(this.m.d(), this.m.f(), paramInt - this.m.f());
    this.m.O(paramInt);
  }
  
  private void C()
  {
    this.X = 0;
    this.Y = 0;
    this.Z = 0;
    this.a0 = false;
    this.b0 = false;
    this.c0 = false;
    this.d0 = 0;
    this.e0 = ((byte)0);
    this.f0 = false;
    this.p.L(0);
  }
  
  private long D(long paramLong)
    throws ParserException
  {
    long l1 = this.x;
    if (l1 != -9223372036854775807L) {
      return o0.C0(paramLong, l1, 1000L);
    }
    throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
  }
  
  private static void E(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    paramString.hashCode();
    int i1;
    if (!paramString.equals("S_TEXT/ASS"))
    {
      if (!paramString.equals("S_TEXT/UTF8")) {
        throw new IllegalArgumentException();
      }
      paramString = r(paramLong, "%02d:%02d:%02d,%03d", 1000L);
      i1 = 19;
    }
    else
    {
      paramString = r(paramLong, "%01d:%02d:%02d:%02d", 10000L);
      i1 = 21;
    }
    System.arraycopy(paramString, 0, paramArrayOfByte, i1, paramString.length);
  }
  
  @RequiresNonNull({"#2.output"})
  private int H(k paramk, c paramc, int paramInt)
    throws IOException
  {
    if ("S_TEXT/UTF8".equals(paramc.b))
    {
      I(paramk, b, paramInt);
      return p();
    }
    if ("S_TEXT/ASS".equals(paramc.b))
    {
      I(paramk, d, paramInt);
      return p();
    }
    b0 localb0 = paramc.X;
    boolean bool1 = this.a0;
    boolean bool2 = true;
    int i1;
    if (!bool1)
    {
      if (paramc.h)
      {
        this.U &= 0xBFFFFFFF;
        bool1 = this.b0;
        i1 = 128;
        if (!bool1)
        {
          paramk.readFully(this.m.d(), 0, 1);
          this.X += 1;
          if ((this.m.d()[0] & 0x80) != 128)
          {
            this.e0 = ((byte)this.m.d()[0]);
            this.b0 = true;
          }
          else
          {
            throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
          }
        }
        int i2 = this.e0;
        if ((i2 & 0x1) == 1) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if (i3 != 0)
        {
          if ((i2 & 0x2) == 2) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          this.U |= 0x40000000;
          if (!this.f0)
          {
            paramk.readFully(this.r.d(), 0, 8);
            this.X += 8;
            this.f0 = true;
            localObject = this.m.d();
            if (i3 == 0) {
              i1 = 0;
            }
            localObject[0] = ((byte)(byte)(i1 | 0x8));
            this.m.P(0);
            localb0.f(this.m, 1, 1);
            this.Y += 1;
            this.r.P(0);
            localb0.f(this.r, 8, 1);
            this.Y += 8;
          }
          if (i3 != 0)
          {
            if (!this.c0)
            {
              paramk.readFully(this.m.d(), 0, 1);
              this.X += 1;
              this.m.P(0);
              this.d0 = this.m.D();
              this.c0 = true;
            }
            i3 = this.d0 * 4;
            this.m.L(i3);
            paramk.readFully(this.m.d(), 0, i3);
            this.X += i3;
            short s1 = (short)(this.d0 / 2 + 1);
            int i4 = s1 * 6 + 2;
            localObject = this.u;
            if ((localObject == null) || (((ByteBuffer)localObject).capacity() < i4)) {
              this.u = ByteBuffer.allocate(i4);
            }
            this.u.position(0);
            this.u.putShort(s1);
            i3 = 0;
            for (i1 = 0;; i1 = i2)
            {
              i2 = this.d0;
              if (i3 >= i2) {
                break;
              }
              i2 = this.m.H();
              if (i3 % 2 == 0) {
                this.u.putShort((short)(i2 - i1));
              } else {
                this.u.putInt(i2 - i1);
              }
              i3++;
            }
            i3 = paramInt - this.X - i1;
            if (i2 % 2 == 1)
            {
              this.u.putInt(i3);
            }
            else
            {
              this.u.putShort((short)i3);
              this.u.putInt(0);
            }
            this.s.N(this.u.array(), i4);
            localb0.f(this.s, i4, 1);
            this.Y += i4;
          }
        }
      }
      else
      {
        localObject = paramc.i;
        if (localObject != null) {
          this.p.N((byte[])localObject, localObject.length);
        }
      }
      if (paramc.f > 0)
      {
        this.U |= 0x10000000;
        this.t.L(0);
        this.m.L(4);
        this.m.d()[0] = ((byte)(byte)(paramInt >> 24 & 0xFF));
        this.m.d()[1] = ((byte)(byte)(paramInt >> 16 & 0xFF));
        this.m.d()[2] = ((byte)(byte)(paramInt >> 8 & 0xFF));
        this.m.d()[3] = ((byte)(byte)(paramInt & 0xFF));
        localb0.f(this.m, 4, 2);
        this.Y += 4;
      }
      this.a0 = true;
    }
    paramInt += this.p.f();
    if ((!"V_MPEG4/ISO/AVC".equals(paramc.b)) && (!"V_MPEGH/ISO/HEVC".equals(paramc.b)))
    {
      if (paramc.T != null)
      {
        if (this.p.f() != 0) {
          bool2 = false;
        }
        com.google.android.exoplayer2.util.g.g(bool2);
        paramc.T.d(paramk);
      }
      for (;;)
      {
        i3 = this.X;
        if (i3 >= paramInt) {
          break;
        }
        i3 = J(paramk, localb0, paramInt - i3);
        this.X += i3;
        this.Y += i3;
      }
    }
    Object localObject = this.l.d();
    localObject[0] = ((byte)0);
    localObject[1] = ((byte)0);
    localObject[2] = ((byte)0);
    int i3 = paramc.Y;
    while (this.X < paramInt)
    {
      i1 = this.Z;
      if (i1 == 0)
      {
        K(paramk, (byte[])localObject, 4 - i3, i3);
        this.X += i3;
        this.l.P(0);
        this.Z = this.l.H();
        this.k.P(0);
        localb0.c(this.k, 4);
        this.Y += 4;
      }
      else
      {
        i1 = J(paramk, localb0, i1);
        this.X += i1;
        this.Y += i1;
        this.Z -= i1;
      }
    }
    if ("A_VORBIS".equals(paramc.b))
    {
      this.n.P(0);
      localb0.c(this.n, 4);
      this.Y += 4;
    }
    return p();
  }
  
  private void I(k paramk, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i1 = paramArrayOfByte.length + paramInt;
    if (this.q.b() < i1) {
      this.q.M(Arrays.copyOf(paramArrayOfByte, i1 + paramInt));
    } else {
      System.arraycopy(paramArrayOfByte, 0, this.q.d(), 0, paramArrayOfByte.length);
    }
    paramk.readFully(this.q.d(), paramArrayOfByte.length, paramInt);
    this.q.P(0);
    this.q.O(i1);
  }
  
  private int J(k paramk, b0 paramb0, int paramInt)
    throws IOException
  {
    int i1 = this.p.a();
    if (i1 > 0)
    {
      paramInt = Math.min(paramInt, i1);
      paramb0.c(this.p, paramInt);
    }
    else
    {
      paramInt = paramb0.b(paramk, paramInt, false);
    }
    return paramInt;
  }
  
  private void K(k paramk, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i1 = Math.min(paramInt2, this.p.a());
    paramk.readFully(paramArrayOfByte, paramInt1 + i1, paramInt2 - i1);
    if (i1 > 0) {
      this.p.j(paramArrayOfByte, paramInt1, i1);
    }
  }
  
  @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
  private void h(int paramInt)
    throws ParserException
  {
    if ((this.I != null) && (this.J != null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(37);
    localStringBuilder.append("Element ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" must be in a Cues");
    throw ParserException.createForMalformedContainer(localStringBuilder.toString(), null);
  }
  
  @EnsuresNonNull({"currentTrack"})
  private void i(int paramInt)
    throws ParserException
  {
    if (this.A != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(43);
    localStringBuilder.append("Element ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" must be in a TrackEntry");
    throw ParserException.createForMalformedContainer(localStringBuilder.toString(), null);
  }
  
  @EnsuresNonNull({"extractorOutput"})
  private void j()
  {
    com.google.android.exoplayer2.util.g.i(this.g0);
  }
  
  private com.google.android.exoplayer2.o2.y l(@Nullable v paramv1, @Nullable v paramv2)
  {
    if ((this.w != -1L) && (this.z != -9223372036854775807L) && (paramv1 != null) && (paramv1.c() != 0) && (paramv2 != null) && (paramv2.c() == paramv1.c()))
    {
      int i1 = paramv1.c();
      int[] arrayOfInt1 = new int[i1];
      long[] arrayOfLong1 = new long[i1];
      long[] arrayOfLong2 = new long[i1];
      long[] arrayOfLong3 = new long[i1];
      int i2 = 0;
      int i4;
      for (int i3 = 0;; i3++)
      {
        i4 = i2;
        if (i3 >= i1) {
          break;
        }
        arrayOfLong3[i3] = paramv1.b(i3);
        arrayOfLong1[i3] = (this.w + paramv2.b(i3));
      }
      for (;;)
      {
        i3 = i1 - 1;
        if (i4 >= i3) {
          break;
        }
        i3 = i4 + 1;
        arrayOfInt1[i4] = ((int)(arrayOfLong1[i3] - arrayOfLong1[i4]));
        arrayOfLong3[i3] -= arrayOfLong3[i4];
        i4 = i3;
      }
      arrayOfInt1[i3] = ((int)(this.w + this.v - arrayOfLong1[i3]));
      arrayOfLong2[i3] = (this.z - arrayOfLong3[i3]);
      long l1 = arrayOfLong2[i3];
      int[] arrayOfInt2 = arrayOfInt1;
      long[] arrayOfLong4 = arrayOfLong1;
      paramv2 = arrayOfLong2;
      paramv1 = arrayOfLong3;
      if (l1 <= 0L)
      {
        paramv1 = new StringBuilder(72);
        paramv1.append("Discarding last cue point with unexpected duration: ");
        paramv1.append(l1);
        u.h("MatroskaExtractor", paramv1.toString());
        arrayOfInt2 = Arrays.copyOf(arrayOfInt1, i3);
        arrayOfLong4 = Arrays.copyOf(arrayOfLong1, i3);
        paramv2 = Arrays.copyOf(arrayOfLong2, i3);
        paramv1 = Arrays.copyOf(arrayOfLong3, i3);
      }
      return new com.google.android.exoplayer2.o2.e(arrayOfInt2, arrayOfLong4, paramv2, paramv1);
    }
    return new y.b(this.z);
  }
  
  @RequiresNonNull({"#1.output"})
  private void m(c paramc, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = paramc.T;
    if (localObject != null)
    {
      ((d)localObject).c(paramc, paramLong, paramInt1, paramInt2, paramInt3);
    }
    else
    {
      int i1;
      if (!"S_TEXT/UTF8".equals(paramc.b))
      {
        i1 = paramInt2;
        if (!"S_TEXT/ASS".equals(paramc.b)) {}
      }
      else if (this.Q > 1)
      {
        u.h("MatroskaExtractor", "Skipping subtitle sample in laced block.");
        i1 = paramInt2;
      }
      else
      {
        long l1 = this.O;
        if (l1 == -9223372036854775807L)
        {
          u.h("MatroskaExtractor", "Skipping subtitle sample with no duration.");
          i1 = paramInt2;
        }
        else
        {
          E(paramc.b, l1, this.q.d());
          for (i1 = this.q.e(); i1 < this.q.f(); i1++) {
            if (this.q.d()[i1] == 0)
            {
              this.q.O(i1);
              break;
            }
          }
          b0 localb0 = paramc.X;
          localObject = this.q;
          localb0.c((d0)localObject, ((d0)localObject).f());
          i1 = paramInt2 + this.q.f();
        }
      }
      paramInt2 = paramInt1;
      int i2 = i1;
      if ((0x10000000 & paramInt1) != 0) {
        if (this.Q > 1)
        {
          paramInt2 = paramInt1 & 0xEFFFFFFF;
          i2 = i1;
        }
        else
        {
          paramInt2 = this.t.f();
          paramc.X.f(this.t, paramInt2, 2);
          i2 = i1 + paramInt2;
          paramInt2 = paramInt1;
        }
      }
      paramc.X.e(paramLong, paramInt2, i2, paramInt3, paramc.j);
    }
    this.L = true;
  }
  
  private static int[] o(@Nullable int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    if (paramArrayOfInt.length >= paramInt) {
      return paramArrayOfInt;
    }
    return new int[Math.max(paramArrayOfInt.length * 2, paramInt)];
  }
  
  private int p()
  {
    int i1 = this.Y;
    C();
    return i1;
  }
  
  private static byte[] r(long paramLong1, String paramString, long paramLong2)
  {
    boolean bool;
    if (paramLong1 != -9223372036854775807L) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.a(bool);
    int i1 = (int)(paramLong1 / 3600000000L);
    paramLong1 -= i1 * 3600 * 1000000L;
    int i2 = (int)(paramLong1 / 60000000L);
    paramLong1 -= i2 * 60 * 1000000L;
    int i3 = (int)(paramLong1 / 1000000L);
    int i4 = (int)((paramLong1 - i3 * 1000000L) / paramLong2);
    return o0.e0(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
  }
  
  private c s(int paramInt)
    throws ParserException
  {
    i(paramInt);
    return this.A;
  }
  
  private static boolean x(String paramString)
  {
    paramString.hashCode();
    int i1 = paramString.hashCode();
    int i2 = -1;
    switch (i1)
    {
    default: 
      break;
    case 1951062397: 
      if (paramString.equals("A_OPUS")) {
        i2 = 31;
      }
      break;
    case 1950789798: 
      if (paramString.equals("A_FLAC")) {
        i2 = 30;
      }
      break;
    case 1950749482: 
      if (paramString.equals("A_EAC3")) {
        i2 = 29;
      }
      break;
    case 1809237540: 
      if (paramString.equals("V_MPEG2")) {
        i2 = 28;
      }
      break;
    case 1422270023: 
      if (paramString.equals("S_TEXT/UTF8")) {
        i2 = 27;
      }
      break;
    case 855502857: 
      if (paramString.equals("V_MPEGH/ISO/HEVC")) {
        i2 = 26;
      }
      break;
    case 738597099: 
      if (paramString.equals("S_TEXT/ASS")) {
        i2 = 25;
      }
      break;
    case 725957860: 
      if (paramString.equals("A_PCM/INT/LIT")) {
        i2 = 24;
      }
      break;
    case 725948237: 
      if (paramString.equals("A_PCM/INT/BIG")) {
        i2 = 23;
      }
      break;
    case 635596514: 
      if (paramString.equals("A_PCM/FLOAT/IEEE")) {
        i2 = 22;
      }
      break;
    case 542569478: 
      if (paramString.equals("A_DTS/EXPRESS")) {
        i2 = 21;
      }
      break;
    case 444813526: 
      if (paramString.equals("V_THEORA")) {
        i2 = 20;
      }
      break;
    case 99146302: 
      if (paramString.equals("S_HDMV/PGS")) {
        i2 = 19;
      }
      break;
    case 82338134: 
      if (paramString.equals("V_VP9")) {
        i2 = 18;
      }
      break;
    case 82338133: 
      if (paramString.equals("V_VP8")) {
        i2 = 17;
      }
      break;
    case 82318131: 
      if (paramString.equals("V_AV1")) {
        i2 = 16;
      }
      break;
    case 62927045: 
      if (paramString.equals("A_DTS")) {
        i2 = 15;
      }
      break;
    case 62923603: 
      if (paramString.equals("A_AC3")) {
        i2 = 14;
      }
      break;
    case 62923557: 
      if (paramString.equals("A_AAC")) {
        i2 = 13;
      }
      break;
    case -356037306: 
      if (paramString.equals("A_DTS/LOSSLESS")) {
        i2 = 12;
      }
      break;
    case -425012669: 
      if (paramString.equals("S_VOBSUB")) {
        i2 = 11;
      }
      break;
    case -538363109: 
      if (paramString.equals("V_MPEG4/ISO/AVC")) {
        i2 = 10;
      }
      break;
    case -538363189: 
      if (paramString.equals("V_MPEG4/ISO/ASP")) {
        i2 = 9;
      }
      break;
    case -933872740: 
      if (paramString.equals("S_DVBSUB")) {
        i2 = 8;
      }
      break;
    case -1373388978: 
      if (paramString.equals("V_MS/VFW/FOURCC")) {
        i2 = 7;
      }
      break;
    case -1482641357: 
      if (paramString.equals("A_MPEG/L3")) {
        i2 = 6;
      }
      break;
    case -1482641358: 
      if (paramString.equals("A_MPEG/L2")) {
        i2 = 5;
      }
      break;
    case -1730367663: 
      if (paramString.equals("A_VORBIS")) {
        i2 = 4;
      }
      break;
    case -1784763192: 
      if (paramString.equals("A_TRUEHD")) {
        i2 = 3;
      }
      break;
    case -1985379776: 
      if (paramString.equals("A_MS/ACM")) {
        i2 = 2;
      }
      break;
    case -2095575984: 
      if (paramString.equals("V_MPEG4/ISO/SP")) {
        i2 = 1;
      }
      break;
    case -2095576542: 
      if (paramString.equals("V_MPEG4/ISO/AP")) {
        i2 = 0;
      }
      break;
    }
    switch (i2)
    {
    default: 
      return false;
    }
    return true;
  }
  
  @CallSuper
  protected void F(int paramInt, long paramLong1, long paramLong2)
    throws ParserException
  {
    j();
    if (paramInt != 160)
    {
      if (paramInt != 174)
      {
        if (paramInt != 187)
        {
          if (paramInt != 19899)
          {
            if (paramInt != 20533)
            {
              if (paramInt != 21968)
              {
                if (paramInt != 408125543)
                {
                  if (paramInt != 475249515)
                  {
                    if ((paramInt == 524531317) && (!this.B)) {
                      if ((this.j) && (this.F != -1L))
                      {
                        this.E = true;
                      }
                      else
                      {
                        this.g0.o(new y.b(this.z));
                        this.B = true;
                      }
                    }
                  }
                  else
                  {
                    this.I = new v();
                    this.J = new v();
                  }
                }
                else
                {
                  long l1 = this.w;
                  if ((l1 != -1L) && (l1 != paramLong1)) {
                    throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
                  }
                  this.w = paramLong1;
                  this.v = paramLong2;
                }
              }
              else {
                s(paramInt).x = true;
              }
            }
            else {
              s(paramInt).h = true;
            }
          }
          else
          {
            this.C = -1;
            this.D = -1L;
          }
        }
        else {
          this.K = false;
        }
      }
      else {
        this.A = new c(null);
      }
    }
    else {
      this.W = false;
    }
  }
  
  @CallSuper
  protected void G(int paramInt, String paramString)
    throws ParserException
  {
    if (paramInt != 134)
    {
      if (paramInt != 17026)
      {
        if (paramInt != 21358)
        {
          if (paramInt == 2274716) {
            c.d(s(paramInt), paramString);
          }
        }
        else {
          s(paramInt).a = paramString;
        }
      }
      else if ((!"webm".equals(paramString)) && (!"matroska".equals(paramString)))
      {
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 22);
        localStringBuilder.append("DocType ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" not supported");
        throw ParserException.createForMalformedContainer(localStringBuilder.toString(), null);
      }
    }
    else {
      s(paramInt).b = paramString;
    }
  }
  
  public final void b(l paraml)
  {
    this.g0 = paraml;
  }
  
  @CallSuper
  public void c(long paramLong1, long paramLong2)
  {
    this.H = -9223372036854775807L;
    int i1 = 0;
    this.M = 0;
    this.g.reset();
    this.h.e();
    C();
    while (i1 < this.i.size())
    {
      ((c)this.i.valueAt(i1)).m();
      i1++;
    }
  }
  
  public final boolean d(k paramk)
    throws IOException
  {
    return new f().b(paramk);
  }
  
  public final int e(k paramk, x paramx)
    throws IOException
  {
    int i1 = 0;
    this.L = false;
    int i2 = 1;
    while ((i2 != 0) && (!this.L))
    {
      boolean bool = this.g.a(paramk);
      i2 = bool;
      if (bool)
      {
        i2 = bool;
        if (A(paramx, paramk.getPosition())) {
          return 1;
        }
      }
    }
    if (i2 == 0)
    {
      while (i1 < this.i.size())
      {
        paramk = (c)this.i.valueAt(i1);
        c.a(paramk);
        paramk.i();
        i1++;
      }
      return -1;
    }
    return 0;
  }
  
  @CallSuper
  protected void k(int paramInt1, int paramInt2, k paramk)
    throws IOException
  {
    Object localObject1;
    Object localObject2;
    if ((paramInt1 != 161) && (paramInt1 != 163))
    {
      if (paramInt1 != 165)
      {
        if (paramInt1 != 16877)
        {
          if (paramInt1 != 16981)
          {
            if (paramInt1 != 18402)
            {
              if (paramInt1 != 21419)
              {
                if (paramInt1 != 25506)
                {
                  if (paramInt1 == 30322)
                  {
                    i(paramInt1);
                    localObject1 = this.A;
                    localObject2 = new byte[paramInt2];
                    ((c)localObject1).v = ((byte[])localObject2);
                    paramk.readFully((byte[])localObject2, 0, paramInt2);
                  }
                  else
                  {
                    paramk = new StringBuilder(26);
                    paramk.append("Unexpected id: ");
                    paramk.append(paramInt1);
                    throw ParserException.createForMalformedContainer(paramk.toString(), null);
                  }
                }
                else
                {
                  i(paramInt1);
                  localObject1 = this.A;
                  localObject2 = new byte[paramInt2];
                  ((c)localObject1).k = ((byte[])localObject2);
                  paramk.readFully((byte[])localObject2, 0, paramInt2);
                }
              }
              else
              {
                Arrays.fill(this.o.d(), (byte)0);
                paramk.readFully(this.o.d(), 4 - paramInt2, paramInt2);
                this.o.P(0);
                this.C = ((int)this.o.F());
              }
            }
            else
            {
              localObject2 = new byte[paramInt2];
              paramk.readFully((byte[])localObject2, 0, paramInt2);
              s(paramInt1).j = new b0.a(1, (byte[])localObject2, 0, 0);
            }
          }
          else
          {
            i(paramInt1);
            localObject1 = this.A;
            localObject2 = new byte[paramInt2];
            ((c)localObject1).i = ((byte[])localObject2);
            paramk.readFully((byte[])localObject2, 0, paramInt2);
          }
        }
        else {
          u(s(paramInt1), paramk, paramInt2);
        }
      }
      else
      {
        if (this.M != 2) {
          return;
        }
        v((c)this.i.get(this.S), this.V, paramk, paramInt2);
      }
    }
    else
    {
      if (this.M == 0)
      {
        this.S = ((int)this.h.d(paramk, false, true, 8));
        this.T = this.h.b();
        this.O = -9223372036854775807L;
        this.M = 1;
        this.m.L(0);
      }
      localObject2 = (c)this.i.get(this.S);
      if (localObject2 == null)
      {
        paramk.l(paramInt2 - this.T);
        this.M = 0;
        return;
      }
      c.a((c)localObject2);
      long l1;
      if (this.M == 1)
      {
        B(paramk, 3);
        int i1 = (this.m.d()[2] & 0x6) >> 1;
        if (i1 == 0)
        {
          this.Q = 1;
          localObject1 = o(this.R, 1);
          this.R = ((int[])localObject1);
          localObject1[0] = (paramInt2 - this.T - 3);
        }
        for (;;)
        {
          break;
          i2 = 4;
          B(paramk, 4);
          int i3 = (this.m.d()[3] & 0xFF) + 1;
          this.Q = i3;
          localObject1 = o(this.R, i3);
          this.R = ((int[])localObject1);
          if (i1 == 2)
          {
            i2 = this.T;
            i1 = this.Q;
            Arrays.fill((int[])localObject1, 0, i1, (paramInt2 - i2 - 4) / i1);
          }
          else
          {
            int i4;
            int i5;
            if (i1 == 1)
            {
              i1 = 0;
              i3 = 0;
              for (;;)
              {
                i4 = this.Q;
                if (i1 >= i4 - 1) {
                  break;
                }
                this.R[i1] = 0;
                i4 = i2;
                do
                {
                  i2 = i4 + 1;
                  B(paramk, i2);
                  i5 = this.m.d()[(i2 - 1)] & 0xFF;
                  localObject1 = this.R;
                  localObject1[i1] += i5;
                  i4 = i2;
                } while (i5 == 255);
                i3 += localObject1[i1];
                i1++;
              }
              this.R[(i4 - 1)] = (paramInt2 - this.T - i2 - i3);
            }
            else
            {
              if (i1 != 3) {
                break label1179;
              }
              i3 = 0;
              i1 = 0;
              for (;;)
              {
                i4 = this.Q;
                if (i3 >= i4 - 1) {
                  break label1049;
                }
                this.R[i3] = 0;
                i2++;
                B(paramk, i2);
                localObject1 = this.m.d();
                i5 = i2 - 1;
                if (localObject1[i5] == 0) {
                  break label1041;
                }
                for (i4 = 0; i4 < 8; i4++)
                {
                  int i6 = 1 << 7 - i4;
                  if ((this.m.d()[i5] & i6) != 0)
                  {
                    i2 += i4;
                    B(paramk, i2);
                    l1 = (i6 ^ 0xFFFFFFFF) & this.m.d()[i5] & 0xFF;
                    i5++;
                    long l2;
                    for (;;)
                    {
                      l2 = l1;
                      if (i5 >= i2) {
                        break;
                      }
                      l1 = l2 << 8 | this.m.d()[i5] & 0xFF;
                      i5++;
                    }
                    l1 = l2;
                    if (i3 > 0) {
                      l1 = l2 - ((1L << i4 * 7 + 6) - 1L);
                    }
                    break label961;
                  }
                }
                l1 = 0L;
                label961:
                if ((l1 < -2147483648L) || (l1 > 2147483647L)) {
                  break;
                }
                i4 = (int)l1;
                localObject1 = this.R;
                if (i3 != 0) {
                  i4 += localObject1[(i3 - 1)];
                }
                localObject1[i3] = i4;
                i1 += localObject1[i3];
                i3++;
              }
              throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
              label1041:
              throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
              label1049:
              this.R[(i4 - 1)] = (paramInt2 - this.T - i2 - i1);
            }
          }
        }
        int i2 = this.m.d()[0];
        paramInt2 = this.m.d()[1];
        this.N = (this.H + D(i2 << 8 | paramInt2 & 0xFF));
        if ((((c)localObject2).d != 2) && ((paramInt1 != 163) || ((this.m.d()[2] & 0x80) != 128))) {
          paramInt2 = 0;
        } else {
          paramInt2 = 1;
        }
        this.U = paramInt2;
        this.M = 2;
        this.P = 0;
        break label1213;
        label1179:
        paramk = new StringBuilder(36);
        paramk.append("Unexpected lacing value: ");
        paramk.append(i1);
        throw ParserException.createForMalformedContainer(paramk.toString(), null);
      }
      label1213:
      if (paramInt1 == 163)
      {
        for (;;)
        {
          paramInt1 = this.P;
          if (paramInt1 >= this.Q) {
            break;
          }
          paramInt1 = H(paramk, (c)localObject2, this.R[paramInt1]);
          l1 = this.N;
          m((c)localObject2, this.P * ((c)localObject2).e / 1000 + l1, this.U, paramInt1, 0);
          this.P += 1;
        }
        this.M = 0;
      }
      else
      {
        for (;;)
        {
          paramInt1 = this.P;
          if (paramInt1 >= this.Q) {
            break;
          }
          localObject1 = this.R;
          localObject1[paramInt1] = H(paramk, (c)localObject2, localObject1[paramInt1]);
          this.P += 1;
        }
      }
    }
  }
  
  @CallSuper
  protected void n(int paramInt)
    throws ParserException
  {
    j();
    long l1;
    c localc;
    if (paramInt != 160)
    {
      if (paramInt != 174)
      {
        if (paramInt != 19899)
        {
          if (paramInt != 25152)
          {
            if (paramInt != 28032)
            {
              if (paramInt != 357149030)
              {
                if (paramInt != 374648427)
                {
                  if (paramInt == 475249515)
                  {
                    if (!this.B)
                    {
                      this.g0.o(l(this.I, this.J));
                      this.B = true;
                    }
                    this.I = null;
                    this.J = null;
                  }
                }
                else if (this.i.size() != 0) {
                  this.g0.r();
                } else {
                  throw ParserException.createForMalformedContainer("No valid tracks were found", null);
                }
              }
              else
              {
                if (this.x == -9223372036854775807L) {
                  this.x = 1000000L;
                }
                l1 = this.y;
                if (l1 != -9223372036854775807L) {
                  this.z = D(l1);
                }
              }
            }
            else
            {
              i(paramInt);
              localc = this.A;
              if ((localc.h) && (localc.i != null)) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
              }
            }
          }
          else
          {
            i(paramInt);
            localc = this.A;
            if (localc.h) {
              if (localc.j != null) {
                localc.l = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(w0.a, "video/webm", this.A.j.b) });
              } else {
                throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
              }
            }
          }
        }
        else
        {
          paramInt = this.C;
          if (paramInt != -1)
          {
            l1 = this.D;
            if (l1 != -1L)
            {
              if (paramInt != 475249515) {
                return;
              }
              this.F = l1;
              return;
            }
          }
          throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
      }
      else
      {
        localc = (c)com.google.android.exoplayer2.util.g.i(this.A);
        String str = localc.b;
        if (str != null)
        {
          if (x(str))
          {
            localc.h(this.g0, localc.c);
            this.i.put(localc.c, localc);
          }
          this.A = null;
        }
        else
        {
          throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
        }
      }
    }
    else
    {
      if (this.M != 2) {
        return;
      }
      int i1 = 0;
      paramInt = 0;
      while (i1 < this.Q)
      {
        paramInt += this.R[i1];
        i1++;
      }
      localc = (c)this.i.get(this.S);
      c.a(localc);
      for (i1 = 0; i1 < this.Q; i1++)
      {
        l1 = this.N;
        long l2 = localc.e * i1 / 1000;
        int i2 = this.U;
        int i3 = i2;
        if (i1 == 0)
        {
          i3 = i2;
          if (!this.W) {
            i3 = i2 | 0x1;
          }
        }
        i2 = this.R[i1];
        paramInt -= i2;
        m(localc, l2 + l1, i3, i2, paramInt);
      }
      this.M = 0;
    }
  }
  
  @CallSuper
  protected void q(int paramInt, double paramDouble)
    throws ParserException
  {
    if (paramInt != 181)
    {
      if (paramInt != 17545) {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            break;
          case 30325: 
            s(paramInt).u = ((float)paramDouble);
            break;
          case 30324: 
            s(paramInt).t = ((float)paramDouble);
            break;
          case 30323: 
            s(paramInt).s = ((float)paramDouble);
          }
          break;
        case 21978: 
          s(paramInt).M = ((float)paramDouble);
          break;
        case 21977: 
          s(paramInt).L = ((float)paramDouble);
          break;
        case 21976: 
          s(paramInt).K = ((float)paramDouble);
          break;
        case 21975: 
          s(paramInt).J = ((float)paramDouble);
          break;
        case 21974: 
          s(paramInt).I = ((float)paramDouble);
          break;
        case 21973: 
          s(paramInt).H = ((float)paramDouble);
          break;
        case 21972: 
          s(paramInt).G = ((float)paramDouble);
          break;
        case 21971: 
          s(paramInt).F = ((float)paramDouble);
          break;
        case 21970: 
          s(paramInt).E = ((float)paramDouble);
          break;
        case 21969: 
          s(paramInt).D = ((float)paramDouble);
          break;
        }
      } else {
        this.y = (paramDouble);
      }
    }
    else {
      s(paramInt).Q = ((int)paramDouble);
    }
  }
  
  public final void release() {}
  
  @CallSuper
  protected int t(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 181: 
    case 17545: 
    case 21969: 
    case 21970: 
    case 21971: 
    case 21972: 
    case 21973: 
    case 21974: 
    case 21975: 
    case 21976: 
    case 21977: 
    case 21978: 
    case 30323: 
    case 30324: 
    case 30325: 
      return 5;
    case 161: 
    case 163: 
    case 165: 
    case 16877: 
    case 16981: 
    case 18402: 
    case 21419: 
    case 25506: 
    case 30322: 
      return 4;
    case 160: 
    case 166: 
    case 174: 
    case 183: 
    case 187: 
    case 224: 
    case 225: 
    case 16868: 
    case 18407: 
    case 19899: 
    case 20532: 
    case 20533: 
    case 21936: 
    case 21968: 
    case 25152: 
    case 28032: 
    case 30113: 
    case 30320: 
    case 290298740: 
    case 357149030: 
    case 374648427: 
    case 408125543: 
    case 440786851: 
    case 475249515: 
    case 524531317: 
      return 1;
    case 134: 
    case 17026: 
    case 21358: 
    case 2274716: 
      return 3;
    }
    return 2;
  }
  
  protected void u(c paramc, k paramk, int paramInt)
    throws IOException
  {
    if ((c.b(paramc) != 1685485123) && (c.b(paramc) != 1685480259))
    {
      paramk.l(paramInt);
    }
    else
    {
      byte[] arrayOfByte = new byte[paramInt];
      paramc.N = arrayOfByte;
      paramk.readFully(arrayOfByte, 0, paramInt);
    }
  }
  
  protected void v(c paramc, int paramInt1, k paramk, int paramInt2)
    throws IOException
  {
    if ((paramInt1 == 4) && ("V_VP9".equals(paramc.b)))
    {
      this.t.L(paramInt2);
      paramk.readFully(this.t.d(), 0, paramInt2);
    }
    else
    {
      paramk.l(paramInt2);
    }
  }
  
  @CallSuper
  protected void w(int paramInt, long paramLong)
    throws ParserException
  {
    if (paramInt != 20529)
    {
      if (paramInt != 20530)
      {
        boolean bool1 = false;
        boolean bool2 = false;
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            break;
          case 21949: 
            s(paramInt).C = ((int)paramLong);
            break;
          case 21948: 
            s(paramInt).B = ((int)paramLong);
            break;
          case 21947: 
            i(paramInt);
            this.A.x = true;
            paramInt = ColorInfo.a((int)paramLong);
            if (paramInt == -1) {
              break;
            }
            this.A.y = paramInt;
            break;
          case 21946: 
            i(paramInt);
            paramInt = ColorInfo.b((int)paramLong);
            if (paramInt == -1) {
              break;
            }
            this.A.z = paramInt;
            break;
          case 21945: 
            i(paramInt);
            paramInt = (int)paramLong;
            if (paramInt != 1)
            {
              if (paramInt == 2) {
                this.A.A = 1;
              }
            }
            else {
              this.A.A = 2;
            }
            break;
          }
          break;
        case 2807729: 
          this.x = paramLong;
          break;
        case 2352003: 
          s(paramInt).e = ((int)paramLong);
          break;
        case 30321: 
          i(paramInt);
          paramInt = (int)paramLong;
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt == 3) {
                  this.A.r = 3;
                }
              }
              else {
                this.A.r = 2;
              }
            }
            else {
              this.A.r = 1;
            }
          }
          else {
            this.A.r = 0;
          }
          break;
        case 25188: 
          s(paramInt).P = ((int)paramLong);
          break;
        case 22203: 
          s(paramInt).S = paramLong;
          break;
        case 22186: 
          s(paramInt).R = paramLong;
          break;
        case 21998: 
          s(paramInt).f = ((int)paramLong);
          break;
        case 21930: 
          localObject = s(paramInt);
          if (paramLong == 1L) {
            bool2 = true;
          }
          ((c)localObject).U = bool2;
          break;
        case 21690: 
          s(paramInt).p = ((int)paramLong);
          break;
        case 21682: 
          s(paramInt).q = ((int)paramLong);
          break;
        case 21680: 
          s(paramInt).o = ((int)paramLong);
          break;
        case 21432: 
          int i1 = (int)paramLong;
          i(paramInt);
          if (i1 != 0)
          {
            if (i1 != 1)
            {
              if (i1 != 3)
              {
                if (i1 == 15) {
                  this.A.w = 3;
                }
              }
              else {
                this.A.w = 1;
              }
            }
            else {
              this.A.w = 2;
            }
          }
          else {
            this.A.w = 0;
          }
          break;
        case 21420: 
          this.D = (paramLong + this.w);
          break;
        case 18408: 
          if (paramLong == 1L) {
            break;
          }
          localObject = new StringBuilder(56);
          ((StringBuilder)localObject).append("AESSettingsCipherMode ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw ParserException.createForMalformedContainer(((StringBuilder)localObject).toString(), null);
        case 18401: 
          if (paramLong == 5L) {
            break;
          }
          localObject = new StringBuilder(49);
          ((StringBuilder)localObject).append("ContentEncAlgo ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw ParserException.createForMalformedContainer(((StringBuilder)localObject).toString(), null);
        case 17143: 
          if (paramLong == 1L) {
            break;
          }
          localObject = new StringBuilder(50);
          ((StringBuilder)localObject).append("EBMLReadVersion ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw ParserException.createForMalformedContainer(((StringBuilder)localObject).toString(), null);
        case 17029: 
          if ((paramLong >= 1L) && (paramLong <= 2L)) {
            break;
          }
          localObject = new StringBuilder(53);
          ((StringBuilder)localObject).append("DocTypeReadVersion ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw ParserException.createForMalformedContainer(((StringBuilder)localObject).toString(), null);
        case 16980: 
          if (paramLong == 3L) {
            break;
          }
          localObject = new StringBuilder(50);
          ((StringBuilder)localObject).append("ContentCompAlgo ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw ParserException.createForMalformedContainer(((StringBuilder)localObject).toString(), null);
        case 16871: 
          c.c(s(paramInt), (int)paramLong);
          break;
        case 251: 
          this.W = true;
          break;
        case 241: 
          if (this.K) {
            break;
          }
          h(paramInt);
          this.J.a(paramLong);
          this.K = true;
          break;
        case 238: 
          this.V = ((int)paramLong);
          break;
        case 231: 
          this.H = D(paramLong);
          break;
        case 215: 
          s(paramInt).c = ((int)paramLong);
          break;
        case 186: 
          s(paramInt).n = ((int)paramLong);
          break;
        case 179: 
          h(paramInt);
          this.I.a(D(paramLong));
          break;
        case 176: 
          s(paramInt).m = ((int)paramLong);
          break;
        case 159: 
          s(paramInt).O = ((int)paramLong);
          break;
        case 155: 
          this.O = D(paramLong);
          break;
        case 136: 
          localObject = s(paramInt);
          bool2 = bool1;
          if (paramLong == 1L) {
            bool2 = true;
          }
          ((c)localObject).V = bool2;
          break;
        case 131: 
          s(paramInt).d = ((int)paramLong);
          break;
        }
      }
      else if (paramLong != 1L)
      {
        localObject = new StringBuilder(55);
        ((StringBuilder)localObject).append("ContentEncodingScope ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" not supported");
        throw ParserException.createForMalformedContainer(((StringBuilder)localObject).toString(), null);
      }
    }
    else {
      if (paramLong != 0L) {
        break label1300;
      }
    }
    return;
    label1300:
    Object localObject = new StringBuilder(55);
    ((StringBuilder)localObject).append("ContentEncodingOrder ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" not supported");
    throw ParserException.createForMalformedContainer(((StringBuilder)localObject).toString(), null);
  }
  
  @CallSuper
  protected boolean y(int paramInt)
  {
    boolean bool;
    if ((paramInt != 357149030) && (paramInt != 524531317) && (paramInt != 475249515) && (paramInt != 374648427)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private final class b
    implements c
  {
    private b() {}
    
    public void a(int paramInt)
      throws ParserException
    {
      e.this.n(paramInt);
    }
    
    public void b(int paramInt, double paramDouble)
      throws ParserException
    {
      e.this.q(paramInt, paramDouble);
    }
    
    public void c(int paramInt, long paramLong)
      throws ParserException
    {
      e.this.w(paramInt, paramLong);
    }
    
    public int d(int paramInt)
    {
      return e.this.t(paramInt);
    }
    
    public boolean e(int paramInt)
    {
      return e.this.y(paramInt);
    }
    
    public void f(int paramInt1, int paramInt2, k paramk)
      throws IOException
    {
      e.this.k(paramInt1, paramInt2, paramk);
    }
    
    public void g(int paramInt, String paramString)
      throws ParserException
    {
      e.this.G(paramInt, paramString);
    }
    
    public void h(int paramInt, long paramLong1, long paramLong2)
      throws ParserException
    {
      e.this.F(paramInt, paramLong1, paramLong2);
    }
  }
  
  private static final class c
  {
    public int A = -1;
    public int B = 1000;
    public int C = 200;
    public float D = -1.0F;
    public float E = -1.0F;
    public float F = -1.0F;
    public float G = -1.0F;
    public float H = -1.0F;
    public float I = -1.0F;
    public float J = -1.0F;
    public float K = -1.0F;
    public float L = -1.0F;
    public float M = -1.0F;
    public byte[] N;
    public int O = 1;
    public int P = -1;
    public int Q = 8000;
    public long R = 0L;
    public long S = 0L;
    public e.d T;
    public boolean U;
    public boolean V = true;
    private String W = "eng";
    public b0 X;
    public int Y;
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    private int g;
    public boolean h;
    public byte[] i;
    public b0.a j;
    public byte[] k;
    public DrmInitData l;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = -1;
    public int q = 0;
    public int r = -1;
    public float s = 0.0F;
    public float t = 0.0F;
    public float u = 0.0F;
    public byte[] v = null;
    public int w = -1;
    public boolean x = false;
    public int y = -1;
    public int z = -1;
    
    @EnsuresNonNull({"output"})
    private void e()
    {
      com.google.android.exoplayer2.util.g.e(this.X);
    }
    
    @EnsuresNonNull({"codecPrivate"})
    private byte[] f(String paramString)
      throws ParserException
    {
      byte[] arrayOfByte = this.k;
      if (arrayOfByte == null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Missing CodecPrivate for codec ".concat(paramString);
        } else {
          paramString = new String("Missing CodecPrivate for codec ");
        }
        throw ParserException.createForMalformedContainer(paramString, null);
      }
      return arrayOfByte;
    }
    
    @Nullable
    private byte[] g()
    {
      if ((this.D != -1.0F) && (this.E != -1.0F) && (this.F != -1.0F) && (this.G != -1.0F) && (this.H != -1.0F) && (this.I != -1.0F) && (this.J != -1.0F) && (this.K != -1.0F) && (this.L != -1.0F) && (this.M != -1.0F))
      {
        byte[] arrayOfByte = new byte[25];
        ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.put((byte)0);
        localByteBuffer.putShort((short)(int)(this.D * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.E * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.F * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.G * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.H * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.I * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.J * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.K * 50000.0F + 0.5F));
        localByteBuffer.putShort((short)(int)(this.L + 0.5F));
        localByteBuffer.putShort((short)(int)(this.M + 0.5F));
        localByteBuffer.putShort((short)this.B);
        localByteBuffer.putShort((short)this.C);
        return arrayOfByte;
      }
      return null;
    }
    
    private static Pair<String, List<byte[]>> j(d0 paramd0)
      throws ParserException
    {
      try
      {
        paramd0.Q(16);
        long l1 = paramd0.t();
        if (l1 == 1482049860L) {
          return new Pair("video/divx", null);
        }
        if (l1 == 859189832L) {
          return new Pair("video/3gpp", null);
        }
        if (l1 == 826496599L)
        {
          int i1 = paramd0.e() + 20;
          paramd0 = paramd0.d();
          while (i1 < paramd0.length - 4)
          {
            if ((paramd0[i1] == 0) && (paramd0[(i1 + 1)] == 0) && (paramd0[(i1 + 2)] == 1) && (paramd0[(i1 + 3)] == 15)) {
              return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(paramd0, i1, paramd0.length)));
            }
            i1++;
          }
          throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
        }
        u.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
        return new Pair("video/x-unknown", null);
      }
      catch (ArrayIndexOutOfBoundsException paramd0)
      {
        throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
      }
    }
    
    private static boolean k(d0 paramd0)
      throws ParserException
    {
      try
      {
        int i1 = paramd0.v();
        boolean bool = true;
        if (i1 == 1) {
          return true;
        }
        if (i1 == 65534)
        {
          paramd0.P(24);
          if (paramd0.w() == e.g().getMostSignificantBits())
          {
            long l1 = paramd0.w();
            long l2 = e.g().getLeastSignificantBits();
            if (l1 == l2) {}
          }
          else
          {
            bool = false;
          }
          return bool;
        }
        return false;
      }
      catch (ArrayIndexOutOfBoundsException paramd0)
      {
        throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
      }
    }
    
    private static List<byte[]> l(byte[] paramArrayOfByte)
      throws ParserException
    {
      int i1;
      int i2;
      int i3;
      int i4;
      if (paramArrayOfByte[0] == 2)
      {
        i1 = 1;
        i2 = 0;
        while ((paramArrayOfByte[i1] & 0xFF) == 255)
        {
          i2 += 255;
          i1++;
        }
        i3 = i1 + 1;
        i4 = i2 + (paramArrayOfByte[i1] & 0xFF);
        i2 = 0;
        for (i1 = i3; (paramArrayOfByte[i1] & 0xFF) == 255; i1++) {
          i2 += 255;
        }
        i3 = i1 + 1;
        i1 = paramArrayOfByte[i1];
        if (paramArrayOfByte[i3] != 1) {}
      }
      try
      {
        byte[] arrayOfByte1 = new byte[i4];
        System.arraycopy(paramArrayOfByte, i3, arrayOfByte1, 0, i4);
        i3 += i4;
        if (paramArrayOfByte[i3] == 3)
        {
          i2 = i3 + (i2 + (i1 & 0xFF));
          if (paramArrayOfByte[i2] == 5)
          {
            byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i2];
            System.arraycopy(paramArrayOfByte, i2, arrayOfByte2, 0, paramArrayOfByte.length - i2);
            paramArrayOfByte = new java/util/ArrayList;
            paramArrayOfByte.<init>(2);
            paramArrayOfByte.add(arrayOfByte1);
            paramArrayOfByte.add(arrayOfByte2);
            return paramArrayOfByte;
          }
          throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
        }
        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
      }
      throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
      throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
    }
    
    @EnsuresNonNull({"this.output"})
    @RequiresNonNull({"codecId"})
    public void h(l paraml, int paramInt)
      throws ParserException
    {
      Object localObject1 = this.b;
      ((String)localObject1).hashCode();
      int i1 = ((String)localObject1).hashCode();
      int i2 = 4;
      int i3 = 3;
      int i4 = 0;
      switch (i1)
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
                                                                  do
                                                                  {
                                                                    do
                                                                    {
                                                                      i1 = -1;
                                                                      break;
                                                                    } while (!((String)localObject1).equals("A_OPUS"));
                                                                    i1 = 31;
                                                                    break;
                                                                  } while (!((String)localObject1).equals("A_FLAC"));
                                                                  i1 = 30;
                                                                  break;
                                                                } while (!((String)localObject1).equals("A_EAC3"));
                                                                i1 = 29;
                                                                break;
                                                              } while (!((String)localObject1).equals("V_MPEG2"));
                                                              i1 = 28;
                                                              break;
                                                            } while (!((String)localObject1).equals("S_TEXT/UTF8"));
                                                            i1 = 27;
                                                            break;
                                                          } while (!((String)localObject1).equals("V_MPEGH/ISO/HEVC"));
                                                          i1 = 26;
                                                          break;
                                                        } while (!((String)localObject1).equals("S_TEXT/ASS"));
                                                        i1 = 25;
                                                        break;
                                                      } while (!((String)localObject1).equals("A_PCM/INT/LIT"));
                                                      i1 = 24;
                                                      break;
                                                    } while (!((String)localObject1).equals("A_PCM/INT/BIG"));
                                                    i1 = 23;
                                                    break;
                                                  } while (!((String)localObject1).equals("A_PCM/FLOAT/IEEE"));
                                                  i1 = 22;
                                                  break;
                                                } while (!((String)localObject1).equals("A_DTS/EXPRESS"));
                                                i1 = 21;
                                                break;
                                              } while (!((String)localObject1).equals("V_THEORA"));
                                              i1 = 20;
                                              break;
                                            } while (!((String)localObject1).equals("S_HDMV/PGS"));
                                            i1 = 19;
                                            break;
                                          } while (!((String)localObject1).equals("V_VP9"));
                                          i1 = 18;
                                          break;
                                        } while (!((String)localObject1).equals("V_VP8"));
                                        i1 = 17;
                                        break;
                                      } while (!((String)localObject1).equals("V_AV1"));
                                      i1 = 16;
                                      break;
                                    } while (!((String)localObject1).equals("A_DTS"));
                                    i1 = 15;
                                    break;
                                  } while (!((String)localObject1).equals("A_AC3"));
                                  i1 = 14;
                                  break;
                                } while (!((String)localObject1).equals("A_AAC"));
                                i1 = 13;
                                break;
                              } while (!((String)localObject1).equals("A_DTS/LOSSLESS"));
                              i1 = 12;
                              break;
                            } while (!((String)localObject1).equals("S_VOBSUB"));
                            i1 = 11;
                            break;
                          } while (!((String)localObject1).equals("V_MPEG4/ISO/AVC"));
                          i1 = 10;
                          break;
                        } while (!((String)localObject1).equals("V_MPEG4/ISO/ASP"));
                        i1 = 9;
                        break;
                      } while (!((String)localObject1).equals("S_DVBSUB"));
                      i1 = 8;
                      break;
                    } while (!((String)localObject1).equals("V_MS/VFW/FOURCC"));
                    i1 = 7;
                    break;
                  } while (!((String)localObject1).equals("A_MPEG/L3"));
                  i1 = 6;
                  break;
                } while (!((String)localObject1).equals("A_MPEG/L2"));
                i1 = 5;
                break;
              } while (!((String)localObject1).equals("A_VORBIS"));
              i1 = 4;
              break;
            } while (!((String)localObject1).equals("A_TRUEHD"));
            i1 = 3;
            break;
          } while (!((String)localObject1).equals("A_MS/ACM"));
          i1 = 2;
          break;
        } while (!((String)localObject1).equals("V_MPEG4/ISO/SP"));
        i1 = 1;
        break;
      } while (!((String)localObject1).equals("V_MPEG4/ISO/AP"));
      i1 = 0;
      Object localObject2 = "audio/raw";
      Object localObject3;
      switch (i1)
      {
      default: 
        throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
      case 31: 
        i2 = 5760;
        localObject3 = new ArrayList(3);
        ((List)localObject3).add(f(this.b));
        localObject1 = ByteBuffer.allocate(8);
        localObject2 = ByteOrder.LITTLE_ENDIAN;
        ((List)localObject3).add(((ByteBuffer)localObject1).order((ByteOrder)localObject2).putLong(this.R).array());
        ((List)localObject3).add(ByteBuffer.allocate(8).order((ByteOrder)localObject2).putLong(this.S).array());
        localObject2 = "audio/opus";
        break;
      case 30: 
        localObject1 = Collections.singletonList(f(this.b));
        localObject2 = "audio/flac";
        break;
      case 29: 
        localObject1 = "audio/eac3";
        break;
      case 28: 
        localObject1 = "video/mpeg2";
        break;
      case 27: 
        localObject1 = "application/x-subrip";
        break;
      case 26: 
        localObject2 = p.a(new d0(f(this.b)));
        localObject1 = ((p)localObject2).a;
        this.Y = ((p)localObject2).b;
        localObject3 = ((p)localObject2).c;
        localObject2 = "video/hevc";
        break;
      case 25: 
        localObject1 = ImmutableList.of(e.a(), f(this.b));
        localObject2 = "text/x-ssa";
        break;
      case 24: 
        i2 = o0.U(this.P);
        i1 = i2;
        if (i2 == 0)
        {
          i1 = this.P;
          localObject1 = new StringBuilder("audio/x-unknown".length() + 74);
          ((StringBuilder)localObject1).append("Unsupported little endian PCM bit depth: ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(". Setting mimeType to ");
          ((StringBuilder)localObject1).append("audio/x-unknown");
          u.h("MatroskaExtractor", ((StringBuilder)localObject1).toString());
        }
      case 23: 
      case 22: 
        for (;;)
        {
          localObject1 = "audio/x-unknown";
          break;
          for (;;)
          {
            localObject3 = null;
            localObject1 = null;
            break label1628;
            i1 = this.P;
            if (i1 == 8)
            {
              localObject3 = null;
              localObject1 = null;
              i1 = 3;
              break label1628;
            }
            if (i1 == 16)
            {
              i1 = 268435456;
            }
            else
            {
              localObject1 = new StringBuilder("audio/x-unknown".length() + 71);
              ((StringBuilder)localObject1).append("Unsupported big endian PCM bit depth: ");
              ((StringBuilder)localObject1).append(i1);
              ((StringBuilder)localObject1).append(". Setting mimeType to ");
              ((StringBuilder)localObject1).append("audio/x-unknown");
              u.h("MatroskaExtractor", ((StringBuilder)localObject1).toString());
              break;
              i1 = this.P;
              if (i1 != 32) {
                break label1521;
              }
              i1 = i2;
            }
          }
          localObject1 = new StringBuilder("audio/x-unknown".length() + 75);
          ((StringBuilder)localObject1).append("Unsupported floating point PCM bit depth: ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(". Setting mimeType to ");
          ((StringBuilder)localObject1).append("audio/x-unknown");
          u.h("MatroskaExtractor", ((StringBuilder)localObject1).toString());
        }
      case 20: 
        localObject1 = "video/x-unknown";
        break;
      case 19: 
        localObject1 = "application/pgs";
        break;
      case 18: 
        localObject1 = "video/x-vnd.on2.vp9";
        break;
      case 17: 
        label1393:
        label1521:
        localObject1 = "video/x-vnd.on2.vp8";
        label1607:
        localObject3 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject4 = null;
        localObject3 = localObject1;
        for (;;)
        {
          i1 = -1;
          localObject1 = localObject4;
          label1628:
          i2 = -1;
          break label2124;
          localObject1 = "video/av01";
          break;
          localObject1 = "audio/vnd.dts";
          break;
          localObject1 = "audio/ac3";
          break;
          localObject3 = Collections.singletonList(f(this.b));
          localObject1 = com.google.android.exoplayer2.audio.m.f(this.k);
          this.Q = ((m.b)localObject1).a;
          this.O = ((m.b)localObject1).b;
          localObject4 = ((m.b)localObject1).c;
          localObject2 = "audio/mp4a-latm";
        }
        localObject1 = "audio/vnd.dts.hd";
        break label1607;
        localObject1 = ImmutableList.of(f(this.b));
        localObject2 = "application/vobsub";
        continue;
        localObject2 = com.google.android.exoplayer2.video.m.b(new d0(f(this.b)));
        localObject1 = ((com.google.android.exoplayer2.video.m)localObject2).a;
        this.Y = ((com.google.android.exoplayer2.video.m)localObject2).b;
        localObject3 = ((com.google.android.exoplayer2.video.m)localObject2).f;
        localObject2 = "video/avc";
        i1 = -1;
        i2 = -1;
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject4;
        break label2124;
        localObject1 = new byte[4];
        System.arraycopy(f(this.b), 0, localObject1, 0, 4);
        localObject1 = ImmutableList.of(localObject1);
        localObject2 = "application/dvbsubs";
        continue;
        localObject1 = j(new d0(f(this.b)));
        localObject2 = (String)((Pair)localObject1).first;
        localObject1 = (List)((Pair)localObject1).second;
        continue;
        localObject2 = "audio/mpeg";
        break label1883;
        localObject2 = "audio/mpeg-L2";
        label1883:
        localObject3 = null;
        localObject1 = null;
        i1 = -1;
        i2 = 4096;
        break label2124;
        i2 = 8192;
        localObject3 = l(f(this.b));
        localObject2 = "audio/vorbis";
        localObject1 = null;
        i1 = -1;
        break label2124;
        this.T = new e.d();
        localObject1 = "audio/true-hd";
        break label1607;
        if (k(new d0(f(this.b))))
        {
          i2 = o0.U(this.P);
          i1 = i2;
          if (i2 != 0) {
            break label1393;
          }
          i1 = this.P;
          localObject1 = new StringBuilder("audio/x-unknown".length() + 60);
          ((StringBuilder)localObject1).append("Unsupported PCM bit depth: ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(". Setting mimeType to ");
          ((StringBuilder)localObject1).append("audio/x-unknown");
          u.h("MatroskaExtractor", ((StringBuilder)localObject1).toString());
          break;
        }
        if ("audio/x-unknown".length() != 0) {
          localObject1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown");
        } else {
          localObject1 = new String("Non-PCM MS/ACM is unsupported. Setting mimeType to ");
        }
        u.h("MatroskaExtractor", (String)localObject1);
        break;
        localObject1 = this.k;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Collections.singletonList(localObject1);
        }
        localObject2 = "video/mp4v-es";
      }
      label2124:
      Object localObject5 = this.N;
      Object localObject6 = localObject1;
      Object localObject4 = localObject2;
      if (localObject5 != null)
      {
        localObject5 = com.google.android.exoplayer2.video.n.a(new d0((byte[])localObject5));
        localObject6 = localObject1;
        localObject4 = localObject2;
        if (localObject5 != null)
        {
          localObject6 = ((com.google.android.exoplayer2.video.n)localObject5).c;
          localObject4 = "video/dolby-vision";
        }
      }
      boolean bool = this.V;
      int i5;
      if (this.U) {
        i5 = 2;
      } else {
        i5 = 0;
      }
      localObject2 = new Format.b();
      if (com.google.android.exoplayer2.util.y.o((String)localObject4))
      {
        ((Format.b)localObject2).H(this.O).f0(this.Q).Y(i1);
        i1 = 1;
      }
      else if (com.google.android.exoplayer2.util.y.q((String)localObject4))
      {
        if (this.q == 0)
        {
          i3 = this.o;
          i1 = i3;
          if (i3 == -1) {
            i1 = this.m;
          }
          this.o = i1;
          i3 = this.p;
          i1 = i3;
          if (i3 == -1) {
            i1 = this.n;
          }
          this.p = i1;
        }
        i3 = -1;
        float f1 = -1.0F;
        int i6 = this.o;
        float f2 = f1;
        if (i6 != -1)
        {
          i1 = this.p;
          f2 = f1;
          if (i1 != -1) {
            f2 = this.n * i6 / (this.m * i1);
          }
        }
        if (this.x)
        {
          localObject1 = g();
          localObject1 = new ColorInfo(this.y, this.A, this.z, (byte[])localObject1);
        }
        else
        {
          localObject1 = null;
        }
        i1 = i3;
        if (this.a != null)
        {
          i1 = i3;
          if (e.f().containsKey(this.a)) {
            i1 = ((Integer)e.f().get(this.a)).intValue();
          }
        }
        if ((this.r == 0) && (Float.compare(this.s, 0.0F) == 0) && (Float.compare(this.t, 0.0F) == 0)) {
          if (Float.compare(this.u, 0.0F) == 0) {
            i1 = i4;
          } else if (Float.compare(this.t, 90.0F) == 0) {
            i1 = 90;
          } else if ((Float.compare(this.t, -180.0F) != 0) && (Float.compare(this.t, 180.0F) != 0))
          {
            if (Float.compare(this.t, -90.0F) == 0) {
              i1 = 270;
            }
          }
          else {
            i1 = 180;
          }
        }
        ((Format.b)localObject2).j0(this.m).Q(this.n).a0(f2).d0(i1).b0(this.v).h0(this.w).J((ColorInfo)localObject1);
        i1 = 2;
      }
      else
      {
        i1 = i3;
        if (!"application/x-subrip".equals(localObject4))
        {
          i1 = i3;
          if (!"text/x-ssa".equals(localObject4))
          {
            i1 = i3;
            if (!"application/vobsub".equals(localObject4))
            {
              i1 = i3;
              if (!"application/pgs".equals(localObject4)) {
                if ("application/dvbsubs".equals(localObject4)) {
                  i1 = i3;
                } else {
                  throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                }
              }
            }
          }
        }
      }
      if ((this.a != null) && (!e.f().containsKey(this.a))) {
        ((Format.b)localObject2).U(this.a);
      }
      localObject1 = ((Format.b)localObject2).R(paramInt).e0((String)localObject4).W(i2).V(this.W).g0(bool | false | i5).T((List)localObject3).I((String)localObject6).L(this.l).E();
      paraml = paraml.t(this.c, i1);
      this.X = paraml;
      paraml.d((Format)localObject1);
    }
    
    @RequiresNonNull({"output"})
    public void i()
    {
      e.d locald = this.T;
      if (locald != null) {
        locald.a(this);
      }
    }
    
    public void m()
    {
      e.d locald = this.T;
      if (locald != null) {
        locald.b();
      }
    }
  }
  
  private static final class d
  {
    private final byte[] a = new byte[10];
    private boolean b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;
    
    @RequiresNonNull({"#1.output"})
    public void a(e.c paramc)
    {
      if (this.c > 0)
      {
        paramc.X.e(this.d, this.e, this.f, this.g, paramc.j);
        this.c = 0;
      }
    }
    
    public void b()
    {
      this.b = false;
      this.c = 0;
    }
    
    @RequiresNonNull({"#1.output"})
    public void c(e.c paramc, long paramLong, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.b) {
        return;
      }
      int i = this.c;
      int j = i + 1;
      this.c = j;
      if (i == 0)
      {
        this.d = paramLong;
        this.e = paramInt1;
        this.f = 0;
      }
      this.f += paramInt2;
      this.g = paramInt3;
      if (j >= 16) {
        a(paramc);
      }
    }
    
    public void d(k paramk)
      throws IOException
    {
      if (this.b) {
        return;
      }
      paramk.n(this.a, 0, 10);
      paramk.e();
      if (com.google.android.exoplayer2.audio.n.i(this.a) == 0) {
        return;
      }
      this.b = true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\h0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */