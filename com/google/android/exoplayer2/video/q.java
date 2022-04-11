package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.mediacodec.q.c;
import com.google.android.exoplayer2.mediacodec.r;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.x;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class q
  extends MediaCodecRenderer
{
  private static final int[] e5 = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private static boolean f5;
  private static boolean g5;
  private int A5;
  private int B5;
  private int C5;
  private long D5;
  private long E5;
  private long F5;
  private int G5;
  private int H5;
  private int I5;
  private int J5;
  private float K5;
  @Nullable
  private z L5;
  private boolean M5;
  private int N5;
  @Nullable
  b O5;
  @Nullable
  private t P5;
  private final Context h5;
  private final u i5;
  private final y.a j5;
  private final long k5;
  private final int l5;
  private final boolean m5;
  private a n5;
  private boolean o5;
  private boolean p5;
  @Nullable
  private Surface q5;
  @Nullable
  private DummySurface r5;
  private boolean s5;
  private int t5;
  private boolean u5;
  private boolean v5;
  private boolean w5;
  private long x5;
  private long y5;
  private long z5;
  
  public q(Context paramContext, com.google.android.exoplayer2.mediacodec.q.b paramb, s params, long paramLong, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable y paramy, int paramInt)
  {
    super(2, paramb, params, paramBoolean, 30.0F);
    this.k5 = paramLong;
    this.l5 = paramInt;
    paramContext = paramContext.getApplicationContext();
    this.h5 = paramContext;
    this.i5 = new u(paramContext);
    this.j5 = new y.a(paramHandler, paramy);
    this.m5 = u1();
    this.y5 = -9223372036854775807L;
    this.H5 = -1;
    this.I5 = -1;
    this.K5 = -1.0F;
    this.t5 = 1;
    this.N5 = 0;
    r1();
  }
  
  public q(Context paramContext, s params, long paramLong, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable y paramy, int paramInt)
  {
    this(paramContext, com.google.android.exoplayer2.mediacodec.q.b.a, params, paramLong, paramBoolean, paramHandler, paramy, paramInt);
  }
  
  private static List<r> A1(s params, Format paramFormat, boolean paramBoolean1, boolean paramBoolean2)
    throws MediaCodecUtil.DecoderQueryException
  {
    String str = paramFormat.H3;
    if (str == null) {
      return Collections.emptyList();
    }
    List localList = MediaCodecUtil.p(params.a(str, paramBoolean1, paramBoolean2), paramFormat);
    if ("video/dolby-vision".equals(str))
    {
      paramFormat = MediaCodecUtil.l(paramFormat);
      if (paramFormat != null)
      {
        int i = ((Integer)paramFormat.first).intValue();
        if ((i != 16) && (i != 256))
        {
          if (i == 512) {
            localList.addAll(params.a("video/avc", paramBoolean1, paramBoolean2));
          }
        }
        else {
          localList.addAll(params.a("video/hevc", paramBoolean1, paramBoolean2));
        }
      }
    }
    return Collections.unmodifiableList(localList);
  }
  
  protected static int B1(r paramr, Format paramFormat)
  {
    if (paramFormat.I3 != -1)
    {
      int i = paramFormat.J3.size();
      int j = 0;
      int k = 0;
      while (j < i)
      {
        k += ((byte[])paramFormat.J3.get(j)).length;
        j++;
      }
      return paramFormat.I3 + k;
    }
    return x1(paramr, paramFormat.H3, paramFormat.M3, paramFormat.N3);
  }
  
  private static boolean D1(long paramLong)
  {
    boolean bool;
    if (paramLong < -30000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean E1(long paramLong)
  {
    boolean bool;
    if (paramLong < -500000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void G1()
  {
    if (this.A5 > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.z5;
      this.j5.d(this.A5, l1 - l2);
      this.A5 = 0;
      this.z5 = l1;
    }
  }
  
  private void I1()
  {
    int i = this.G5;
    if (i != 0)
    {
      this.j5.B(this.F5, i);
      this.F5 = 0L;
      this.G5 = 0;
    }
  }
  
  private void J1()
  {
    int i = this.H5;
    if ((i != -1) || (this.I5 != -1))
    {
      z localz = this.L5;
      if ((localz == null) || (localz.c != i) || (localz.d != this.I5) || (localz.e != this.J5) || (localz.f != this.K5))
      {
        localz = new z(this.H5, this.I5, this.J5, this.K5);
        this.L5 = localz;
        this.j5.D(localz);
      }
    }
  }
  
  private void K1()
  {
    if (this.s5) {
      this.j5.A(this.q5);
    }
  }
  
  private void L1()
  {
    z localz = this.L5;
    if (localz != null) {
      this.j5.D(localz);
    }
  }
  
  private void M1(long paramLong1, long paramLong2, Format paramFormat)
  {
    t localt = this.P5;
    if (localt != null) {
      localt.a(paramLong1, paramLong2, paramFormat, s0());
    }
  }
  
  private void O1()
  {
    d1();
  }
  
  @RequiresApi(29)
  private static void R1(com.google.android.exoplayer2.mediacodec.q paramq, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("hdr10-plus-info", paramArrayOfByte);
    paramq.i(localBundle);
  }
  
  private void S1()
  {
    long l;
    if (this.k5 > 0L) {
      l = SystemClock.elapsedRealtime() + this.k5;
    } else {
      l = -9223372036854775807L;
    }
    this.y5 = l;
  }
  
  private void T1(@Nullable Object paramObject)
    throws ExoPlaybackException
  {
    if ((paramObject instanceof Surface)) {
      paramObject = (Surface)paramObject;
    } else {
      paramObject = null;
    }
    Object localObject = paramObject;
    if (paramObject == null)
    {
      localObject = this.r5;
      if (localObject == null)
      {
        r localr = p0();
        localObject = paramObject;
        if (localr != null)
        {
          localObject = paramObject;
          if (Y1(localr))
          {
            localObject = DummySurface.c(this.h5, localr.g);
            this.r5 = ((DummySurface)localObject);
          }
        }
      }
    }
    if (this.q5 != localObject)
    {
      this.q5 = ((Surface)localObject);
      this.i5.o((Surface)localObject);
      this.s5 = false;
      int i = getState();
      paramObject = o0();
      if (paramObject != null) {
        if ((o0.a >= 23) && (localObject != null) && (!this.o5))
        {
          U1((com.google.android.exoplayer2.mediacodec.q)paramObject, (Surface)localObject);
        }
        else
        {
          W0();
          G0();
        }
      }
      if ((localObject != null) && (localObject != this.r5))
      {
        L1();
        q1();
        if (i == 2) {
          S1();
        }
      }
      else
      {
        r1();
        q1();
      }
    }
    else if ((localObject != null) && (localObject != this.r5))
    {
      L1();
      K1();
    }
  }
  
  private boolean Y1(r paramr)
  {
    boolean bool;
    if ((o0.a >= 23) && (!this.M5) && (!s1(paramr.a)) && ((!paramr.g) || (DummySurface.b(this.h5)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void q1()
  {
    this.u5 = false;
    if ((o0.a >= 23) && (this.M5))
    {
      com.google.android.exoplayer2.mediacodec.q localq = o0();
      if (localq != null) {
        this.O5 = new b(localq);
      }
    }
  }
  
  private void r1()
  {
    this.L5 = null;
  }
  
  @RequiresApi(21)
  private static void t1(MediaFormat paramMediaFormat, int paramInt)
  {
    paramMediaFormat.setFeatureEnabled("tunneled-playback", true);
    paramMediaFormat.setInteger("audio-session-id", paramInt);
  }
  
  private static boolean u1()
  {
    return "NVIDIA".equals(o0.c);
  }
  
  private static boolean w1()
  {
    int i = o0.a;
    int j = 6;
    int k = 2;
    String str;
    int m;
    if (i <= 28)
    {
      str = o0.b;
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
                    m = -1;
                    break;
                  } while (!str.equals("machuca"));
                  m = 6;
                  break;
                } while (!str.equals("once"));
                m = 5;
                break;
              } while (!str.equals("magnolia"));
              m = 4;
              break;
            } while (!str.equals("oneday"));
            m = 3;
            break;
          } while (!str.equals("dangalUHD"));
          m = 2;
          break;
        } while (!str.equals("dangalFHD"));
        m = 1;
        break;
      } while (!str.equals("dangal"));
      m = 0;
      switch (m)
      {
      default: 
        break;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
        return true;
      }
    }
    if ((i <= 27) && ("HWEML".equals(o0.b))) {
      return true;
    }
    if (i <= 26)
    {
      str = o0.b;
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
                                                                                                                                                                                                                                                                                    do
                                                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                                                      do
                                                                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                                                                        do
                                                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                                                          do
                                                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                                                            m = -1;
                                                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                                                          } while (!str.equals("HWWAS-H"));
                                                                                                                                                                                                                                                                                          m = 139;
                                                                                                                                                                                                                                                                                          break;
                                                                                                                                                                                                                                                                                        } while (!str.equals("HWVNS-H"));
                                                                                                                                                                                                                                                                                        m = 138;
                                                                                                                                                                                                                                                                                        break;
                                                                                                                                                                                                                                                                                      } while (!str.equals("ELUGA_Prim"));
                                                                                                                                                                                                                                                                                      m = 137;
                                                                                                                                                                                                                                                                                      break;
                                                                                                                                                                                                                                                                                    } while (!str.equals("ELUGA_Note"));
                                                                                                                                                                                                                                                                                    m = 136;
                                                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                                                  } while (!str.equals("ASUS_X00AD_2"));
                                                                                                                                                                                                                                                                                  m = 135;
                                                                                                                                                                                                                                                                                  break;
                                                                                                                                                                                                                                                                                } while (!str.equals("HWCAM-H"));
                                                                                                                                                                                                                                                                                m = 134;
                                                                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                                                                              } while (!str.equals("HWBLN-H"));
                                                                                                                                                                                                                                                                              m = 133;
                                                                                                                                                                                                                                                                              break;
                                                                                                                                                                                                                                                                            } while (!str.equals("DM-01K"));
                                                                                                                                                                                                                                                                            m = 132;
                                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                                          } while (!str.equals("BRAVIA_ATV3_4K"));
                                                                                                                                                                                                                                                                          m = 131;
                                                                                                                                                                                                                                                                          break;
                                                                                                                                                                                                                                                                        } while (!str.equals("Infinix-X572"));
                                                                                                                                                                                                                                                                        m = 130;
                                                                                                                                                                                                                                                                        break;
                                                                                                                                                                                                                                                                      } while (!str.equals("PB2-670M"));
                                                                                                                                                                                                                                                                      m = 129;
                                                                                                                                                                                                                                                                      break;
                                                                                                                                                                                                                                                                    } while (!str.equals("santoni"));
                                                                                                                                                                                                                                                                    m = 128;
                                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                                  } while (!str.equals("iball8735_9806"));
                                                                                                                                                                                                                                                                  m = 127;
                                                                                                                                                                                                                                                                  break;
                                                                                                                                                                                                                                                                } while (!str.equals("CPH1715"));
                                                                                                                                                                                                                                                                m = 126;
                                                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                                                              } while (!str.equals("CPH1609"));
                                                                                                                                                                                                                                                              m = 125;
                                                                                                                                                                                                                                                              break;
                                                                                                                                                                                                                                                            } while (!str.equals("woods_f"));
                                                                                                                                                                                                                                                            m = 124;
                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                          } while (!str.equals("htc_e56ml_dtul"));
                                                                                                                                                                                                                                                          m = 123;
                                                                                                                                                                                                                                                          break;
                                                                                                                                                                                                                                                        } while (!str.equals("EverStar_S"));
                                                                                                                                                                                                                                                        m = 122;
                                                                                                                                                                                                                                                        break;
                                                                                                                                                                                                                                                      } while (!str.equals("hwALE-H"));
                                                                                                                                                                                                                                                      m = 121;
                                                                                                                                                                                                                                                      break;
                                                                                                                                                                                                                                                    } while (!str.equals("itel_S41"));
                                                                                                                                                                                                                                                    m = 120;
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                  } while (!str.equals("LS-5017"));
                                                                                                                                                                                                                                                  m = 119;
                                                                                                                                                                                                                                                  break;
                                                                                                                                                                                                                                                } while (!str.equals("panell_d"));
                                                                                                                                                                                                                                                m = 118;
                                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                                              } while (!str.equals("j2xlteins"));
                                                                                                                                                                                                                                              m = 117;
                                                                                                                                                                                                                                              break;
                                                                                                                                                                                                                                            } while (!str.equals("A7000plus"));
                                                                                                                                                                                                                                            m = 116;
                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                          } while (!str.equals("manning"));
                                                                                                                                                                                                                                          m = 115;
                                                                                                                                                                                                                                          break;
                                                                                                                                                                                                                                        } while (!str.equals("GIONEE_WBL7519"));
                                                                                                                                                                                                                                        m = 114;
                                                                                                                                                                                                                                        break;
                                                                                                                                                                                                                                      } while (!str.equals("GIONEE_WBL7365"));
                                                                                                                                                                                                                                      m = 113;
                                                                                                                                                                                                                                      break;
                                                                                                                                                                                                                                    } while (!str.equals("GIONEE_WBL5708"));
                                                                                                                                                                                                                                    m = 112;
                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                  } while (!str.equals("QM16XE_U"));
                                                                                                                                                                                                                                  m = 111;
                                                                                                                                                                                                                                  break;
                                                                                                                                                                                                                                } while (!str.equals("Pixi5-10_4G"));
                                                                                                                                                                                                                                m = 110;
                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                              } while (!str.equals("TB3-850M"));
                                                                                                                                                                                                                              m = 109;
                                                                                                                                                                                                                              break;
                                                                                                                                                                                                                            } while (!str.equals("TB3-850F"));
                                                                                                                                                                                                                            m = 108;
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                          } while (!str.equals("TB3-730X"));
                                                                                                                                                                                                                          m = 107;
                                                                                                                                                                                                                          break;
                                                                                                                                                                                                                        } while (!str.equals("TB3-730F"));
                                                                                                                                                                                                                        m = 106;
                                                                                                                                                                                                                        break;
                                                                                                                                                                                                                      } while (!str.equals("A7020a48"));
                                                                                                                                                                                                                      m = 105;
                                                                                                                                                                                                                      break;
                                                                                                                                                                                                                    } while (!str.equals("A7010a48"));
                                                                                                                                                                                                                    m = 104;
                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                  } while (!str.equals("griffin"));
                                                                                                                                                                                                                  m = 103;
                                                                                                                                                                                                                  break;
                                                                                                                                                                                                                } while (!str.equals("marino_f"));
                                                                                                                                                                                                                m = 102;
                                                                                                                                                                                                                break;
                                                                                                                                                                                                              } while (!str.equals("CPY83_I00"));
                                                                                                                                                                                                              m = 101;
                                                                                                                                                                                                              break;
                                                                                                                                                                                                            } while (!str.equals("A2016a40"));
                                                                                                                                                                                                            m = 100;
                                                                                                                                                                                                            break;
                                                                                                                                                                                                          } while (!str.equals("le_x6"));
                                                                                                                                                                                                          m = 99;
                                                                                                                                                                                                          break;
                                                                                                                                                                                                        } while (!str.equals("l5460"));
                                                                                                                                                                                                        m = 98;
                                                                                                                                                                                                        break;
                                                                                                                                                                                                      } while (!str.equals("i9031"));
                                                                                                                                                                                                      m = 97;
                                                                                                                                                                                                      break;
                                                                                                                                                                                                    } while (!str.equals("X3_HK"));
                                                                                                                                                                                                    m = 96;
                                                                                                                                                                                                    break;
                                                                                                                                                                                                  } while (!str.equals("V23GB"));
                                                                                                                                                                                                  m = 95;
                                                                                                                                                                                                  break;
                                                                                                                                                                                                } while (!str.equals("Q4310"));
                                                                                                                                                                                                m = 94;
                                                                                                                                                                                                break;
                                                                                                                                                                                              } while (!str.equals("Q4260"));
                                                                                                                                                                                              m = 93;
                                                                                                                                                                                              break;
                                                                                                                                                                                            } while (!str.equals("PRO7S"));
                                                                                                                                                                                            m = 92;
                                                                                                                                                                                            break;
                                                                                                                                                                                          } while (!str.equals("F3311"));
                                                                                                                                                                                          m = 91;
                                                                                                                                                                                          break;
                                                                                                                                                                                        } while (!str.equals("F3215"));
                                                                                                                                                                                        m = 90;
                                                                                                                                                                                        break;
                                                                                                                                                                                      } while (!str.equals("F3213"));
                                                                                                                                                                                      m = 89;
                                                                                                                                                                                      break;
                                                                                                                                                                                    } while (!str.equals("F3211"));
                                                                                                                                                                                    m = 88;
                                                                                                                                                                                    break;
                                                                                                                                                                                  } while (!str.equals("F3116"));
                                                                                                                                                                                  m = 87;
                                                                                                                                                                                  break;
                                                                                                                                                                                } while (!str.equals("F3113"));
                                                                                                                                                                                m = 86;
                                                                                                                                                                                break;
                                                                                                                                                                              } while (!str.equals("F3111"));
                                                                                                                                                                              m = 85;
                                                                                                                                                                              break;
                                                                                                                                                                            } while (!str.equals("E5643"));
                                                                                                                                                                            m = 84;
                                                                                                                                                                            break;
                                                                                                                                                                          } while (!str.equals("A1601"));
                                                                                                                                                                          m = 83;
                                                                                                                                                                          break;
                                                                                                                                                                        } while (!str.equals("Aura_Note_2"));
                                                                                                                                                                        m = 82;
                                                                                                                                                                        break;
                                                                                                                                                                      } while (!str.equals("602LV"));
                                                                                                                                                                      m = 81;
                                                                                                                                                                      break;
                                                                                                                                                                    } while (!str.equals("601LV"));
                                                                                                                                                                    m = 80;
                                                                                                                                                                    break;
                                                                                                                                                                  } while (!str.equals("MEIZU_M5"));
                                                                                                                                                                  m = 79;
                                                                                                                                                                  break;
                                                                                                                                                                } while (!str.equals("p212"));
                                                                                                                                                                m = 78;
                                                                                                                                                                break;
                                                                                                                                                              } while (!str.equals("mido"));
                                                                                                                                                              m = 77;
                                                                                                                                                              break;
                                                                                                                                                            } while (!str.equals("kate"));
                                                                                                                                                            m = 76;
                                                                                                                                                            break;
                                                                                                                                                          } while (!str.equals("fugu"));
                                                                                                                                                          m = 75;
                                                                                                                                                          break;
                                                                                                                                                        } while (!str.equals("XE2X"));
                                                                                                                                                        m = 74;
                                                                                                                                                        break;
                                                                                                                                                      } while (!str.equals("Q427"));
                                                                                                                                                      m = 73;
                                                                                                                                                      break;
                                                                                                                                                    } while (!str.equals("Q350"));
                                                                                                                                                    m = 72;
                                                                                                                                                    break;
                                                                                                                                                  } while (!str.equals("P681"));
                                                                                                                                                  m = 71;
                                                                                                                                                  break;
                                                                                                                                                } while (!str.equals("F04J"));
                                                                                                                                                m = 70;
                                                                                                                                                break;
                                                                                                                                              } while (!str.equals("F04H"));
                                                                                                                                              m = 69;
                                                                                                                                              break;
                                                                                                                                            } while (!str.equals("F03H"));
                                                                                                                                            m = 68;
                                                                                                                                            break;
                                                                                                                                          } while (!str.equals("F02H"));
                                                                                                                                          m = 67;
                                                                                                                                          break;
                                                                                                                                        } while (!str.equals("F01J"));
                                                                                                                                        m = 66;
                                                                                                                                        break;
                                                                                                                                      } while (!str.equals("F01H"));
                                                                                                                                      m = 65;
                                                                                                                                      break;
                                                                                                                                    } while (!str.equals("1714"));
                                                                                                                                    m = 64;
                                                                                                                                    break;
                                                                                                                                  } while (!str.equals("1713"));
                                                                                                                                  m = 63;
                                                                                                                                  break;
                                                                                                                                } while (!str.equals("1601"));
                                                                                                                                m = 62;
                                                                                                                                break;
                                                                                                                              } while (!str.equals("flo"));
                                                                                                                              m = 61;
                                                                                                                              break;
                                                                                                                            } while (!str.equals("deb"));
                                                                                                                            m = 60;
                                                                                                                            break;
                                                                                                                          } while (!str.equals("cv3"));
                                                                                                                          m = 59;
                                                                                                                          break;
                                                                                                                        } while (!str.equals("cv1"));
                                                                                                                        m = 58;
                                                                                                                        break;
                                                                                                                      } while (!str.equals("Z80"));
                                                                                                                      m = 57;
                                                                                                                      break;
                                                                                                                    } while (!str.equals("QX1"));
                                                                                                                    m = 56;
                                                                                                                    break;
                                                                                                                  } while (!str.equals("PLE"));
                                                                                                                  m = 55;
                                                                                                                  break;
                                                                                                                } while (!str.equals("P85"));
                                                                                                                m = 54;
                                                                                                                break;
                                                                                                              } while (!str.equals("MX6"));
                                                                                                              m = 53;
                                                                                                              break;
                                                                                                            } while (!str.equals("M5c"));
                                                                                                            m = 52;
                                                                                                            break;
                                                                                                          } while (!str.equals("M04"));
                                                                                                          m = 51;
                                                                                                          break;
                                                                                                        } while (!str.equals("JGZ"));
                                                                                                        m = 50;
                                                                                                        break;
                                                                                                      } while (!str.equals("mh"));
                                                                                                      m = 49;
                                                                                                      break;
                                                                                                    } while (!str.equals("b5"));
                                                                                                    m = 48;
                                                                                                    break;
                                                                                                  } while (!str.equals("V5"));
                                                                                                  m = 47;
                                                                                                  break;
                                                                                                } while (!str.equals("V1"));
                                                                                                m = 46;
                                                                                                break;
                                                                                              } while (!str.equals("Q5"));
                                                                                              m = 45;
                                                                                              break;
                                                                                            } while (!str.equals("C1"));
                                                                                            m = 44;
                                                                                            break;
                                                                                          } while (!str.equals("woods_fn"));
                                                                                          m = 43;
                                                                                          break;
                                                                                        } while (!str.equals("ELUGA_A3_Pro"));
                                                                                        m = 42;
                                                                                        break;
                                                                                      } while (!str.equals("Z12_PRO"));
                                                                                      m = 41;
                                                                                      break;
                                                                                    } while (!str.equals("BLACK-1X"));
                                                                                    m = 40;
                                                                                    break;
                                                                                  } while (!str.equals("taido_row"));
                                                                                  m = 39;
                                                                                  break;
                                                                                } while (!str.equals("Pixi4-7_3G"));
                                                                                m = 38;
                                                                                break;
                                                                              } while (!str.equals("GIONEE_GBL7360"));
                                                                              m = 37;
                                                                              break;
                                                                            } while (!str.equals("GiONEE_CBL7513"));
                                                                            m = 36;
                                                                            break;
                                                                          } while (!str.equals("OnePlus5T"));
                                                                          m = 35;
                                                                          break;
                                                                        } while (!str.equals("whyred"));
                                                                        m = 34;
                                                                        break;
                                                                      } while (!str.equals("watson"));
                                                                      m = 33;
                                                                      break;
                                                                    } while (!str.equals("SVP-DTV15"));
                                                                    m = 32;
                                                                    break;
                                                                  } while (!str.equals("A7000-a"));
                                                                  m = 31;
                                                                  break;
                                                                } while (!str.equals("nicklaus_f"));
                                                                m = 30;
                                                                break;
                                                              } while (!str.equals("tcl_eu"));
                                                              m = 29;
                                                              break;
                                                            } while (!str.equals("ELUGA_Ray_X"));
                                                            m = 28;
                                                            break;
                                                          } while (!str.equals("s905x018"));
                                                          m = 27;
                                                          break;
                                                        } while (!str.equals("A10-70L"));
                                                        m = 26;
                                                        break;
                                                      } while (!str.equals("A10-70F"));
                                                      m = 25;
                                                      break;
                                                    } while (!str.equals("namath"));
                                                    m = 24;
                                                    break;
                                                  } while (!str.equals("Slate_Pro"));
                                                  m = 23;
                                                  break;
                                                } while (!str.equals("iris60"));
                                                m = 22;
                                                break;
                                              } while (!str.equals("BRAVIA_ATV2"));
                                              m = 21;
                                              break;
                                            } while (!str.equals("GiONEE_GBL7319"));
                                            m = 20;
                                            break;
                                          } while (!str.equals("panell_dt"));
                                          m = 19;
                                          break;
                                        } while (!str.equals("panell_ds"));
                                        m = 18;
                                        break;
                                      } while (!str.equals("panell_dl"));
                                      m = 17;
                                      break;
                                    } while (!str.equals("vernee_M5"));
                                    m = 16;
                                    break;
                                  } while (!str.equals("pacificrim"));
                                  m = 15;
                                  break;
                                } while (!str.equals("Phantom6"));
                                m = 14;
                                break;
                              } while (!str.equals("ComioS1"));
                              m = 13;
                              break;
                            } while (!str.equals("XT1663"));
                            m = 12;
                            break;
                          } while (!str.equals("RAIJIN"));
                          m = 11;
                          break;
                        } while (!str.equals("AquaPowerM"));
                        m = 10;
                        break;
                      } while (!str.equals("PGN611"));
                      m = 9;
                      break;
                    } while (!str.equals("PGN610"));
                    m = 8;
                    break;
                  } while (!str.equals("PGN528"));
                  m = 7;
                  break;
                  m = j;
                  if (str.equals("NX573J")) {
                    break;
                  }
                } while ((goto 1452) || (!str.equals("NX541J")));
                m = 5;
                break;
              } while (!str.equals("CP8676_I02"));
              m = 4;
              break;
            } while (!str.equals("K50a40"));
            m = 3;
            break;
          } while (!str.equals("GIONEE_SWW1631"));
          m = 2;
          break;
        } while (!str.equals("GIONEE_SWW1627"));
        m = 1;
        break;
      } while (!str.equals("GIONEE_SWW1609"));
      m = 0;
      switch (m)
      {
      default: 
        str = o0.d;
        str.hashCode();
        switch (str.hashCode())
        {
        }
        do
        {
          do
          {
            m = -1;
            break;
            m = k;
            if (str.equals("AFTN")) {
              break;
            }
          } while ((goto 4880) || (!str.equals("AFTA")));
          m = 1;
          break;
        } while (!str.equals("JSN-L21"));
        m = 0;
        switch (m)
        {
        }
        break;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      case 69: 
      case 70: 
      case 71: 
      case 72: 
      case 73: 
      case 74: 
      case 75: 
      case 76: 
      case 77: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 83: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      case 91: 
      case 92: 
      case 93: 
      case 94: 
      case 95: 
      case 96: 
      case 97: 
      case 98: 
      case 99: 
      case 100: 
      case 101: 
      case 102: 
      case 103: 
      case 104: 
      case 105: 
      case 106: 
      case 107: 
      case 108: 
      case 109: 
      case 110: 
      case 111: 
      case 112: 
      case 113: 
      case 114: 
      case 115: 
      case 116: 
      case 117: 
      case 118: 
      case 119: 
      case 120: 
      case 121: 
      case 122: 
      case 123: 
      case 124: 
      case 125: 
      case 126: 
      case 127: 
      case 128: 
      case 129: 
      case 130: 
      case 131: 
      case 132: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 138: 
      case 139: 
        return true;
      }
    }
    return false;
  }
  
  private static int x1(r paramr, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      paramString.hashCode();
      int i = paramString.hashCode();
      int j = 4;
      switch (i)
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
                  } while (!paramString.equals("video/x-vnd.on2.vp9"));
                  i = 6;
                  break;
                } while (!paramString.equals("video/x-vnd.on2.vp8"));
                i = 5;
                break;
              } while (!paramString.equals("video/avc"));
              i = 4;
              break;
            } while (!paramString.equals("video/mp4v-es"));
            i = 3;
            break;
          } while (!paramString.equals("video/hevc"));
          i = 2;
          break;
        } while (!paramString.equals("video/3gpp"));
        i = 1;
        break;
      } while (!paramString.equals("video/dolby-vision"));
      i = 0;
      switch (i)
      {
      default: 
        return -1;
      case 2: 
      case 6: 
        paramInt1 *= paramInt2;
        paramInt2 = j;
        break;
      case 1: 
      case 3: 
      case 5: 
        paramInt1 *= paramInt2;
      case 0: 
      case 4: 
        for (;;)
        {
          paramInt2 = 2;
          break;
          paramString = o0.d;
          if (("BRAVIA 4K 2015".equals(paramString)) || (("Amazon".equals(o0.c)) && (("KFSOWI".equals(paramString)) || (("AFTS".equals(paramString)) && (paramr.g))))) {
            break label384;
          }
          paramInt1 = o0.k(paramInt1, 16) * o0.k(paramInt2, 16) * 16 * 16;
        }
      }
      return paramInt1 * 3 / (paramInt2 * 2);
    }
    label384:
    return -1;
  }
  
  private static Point y1(r paramr, Format paramFormat)
  {
    int i = paramFormat.N3;
    int j = paramFormat.M3;
    int k = 0;
    int m;
    if (i > j) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if (m != 0) {
      n = i;
    } else {
      n = j;
    }
    if (m != 0) {
      i = j;
    }
    float f1 = i / n;
    int[] arrayOfInt = e5;
    int i1 = arrayOfInt.length;
    j = k;
    for (;;)
    {
      int i2;
      int i3;
      if (j < i1)
      {
        i2 = arrayOfInt[j];
        i3 = (int)(i2 * f1);
        if ((i2 > n) && (i3 > i)) {
          if (o0.a >= 21)
          {
            if (m != 0) {
              k = i3;
            } else {
              k = i2;
            }
            if (m == 0) {
              i2 = i3;
            }
            Point localPoint = paramr.b(k, i2);
            float f2 = paramFormat.O3;
            if (!paramr.t(localPoint.x, localPoint.y, f2)) {
              break label258;
            }
            return localPoint;
          }
        }
      }
      try
      {
        k = o0.k(i2, 16) * 16;
        i3 = o0.k(i3, 16) * 16;
        if (k * i3 <= MediaCodecUtil.I())
        {
          if (m != 0) {
            n = i3;
          } else {
            n = k;
          }
          if (m == 0) {
            k = i3;
          }
          paramr = new Point(n, k);
          return paramr;
        }
        label258:
        j++;
      }
      catch (MediaCodecUtil.DecoderQueryException paramr)
      {
        for (;;) {}
      }
    }
    return null;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(21)
  protected MediaFormat C1(Format paramFormat, String paramString, a parama, float paramFloat, boolean paramBoolean, int paramInt)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramString);
    localMediaFormat.setInteger("width", paramFormat.M3);
    localMediaFormat.setInteger("height", paramFormat.N3);
    x.e(localMediaFormat, paramFormat.J3);
    x.c(localMediaFormat, "frame-rate", paramFormat.O3);
    x.d(localMediaFormat, "rotation-degrees", paramFormat.P3);
    x.b(localMediaFormat, paramFormat.T3);
    if ("video/dolby-vision".equals(paramFormat.H3))
    {
      paramFormat = MediaCodecUtil.l(paramFormat);
      if (paramFormat != null) {
        x.d(localMediaFormat, "profile", ((Integer)paramFormat.first).intValue());
      }
    }
    localMediaFormat.setInteger("max-width", parama.a);
    localMediaFormat.setInteger("max-height", parama.b);
    x.d(localMediaFormat, "max-input-size", parama.c);
    if (o0.a >= 23)
    {
      localMediaFormat.setInteger("priority", 0);
      if (paramFloat != -1.0F) {
        localMediaFormat.setFloat("operating-rate", paramFloat);
      }
    }
    if (paramBoolean)
    {
      localMediaFormat.setInteger("no-post-process", 1);
      localMediaFormat.setInteger("auto-frc", 0);
    }
    if (paramInt != 0) {
      t1(localMediaFormat, paramInt);
    }
    return localMediaFormat;
  }
  
  protected void E()
  {
    r1();
    q1();
    this.s5 = false;
    this.i5.g();
    this.O5 = null;
    try
    {
      super.E();
      return;
    }
    finally
    {
      this.j5.c(this.a5);
    }
  }
  
  protected void F(boolean paramBoolean1, boolean paramBoolean2)
    throws ExoPlaybackException
  {
    super.F(paramBoolean1, paramBoolean2);
    boolean bool = z().b;
    if ((bool) && (this.N5 == 0)) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    g.g(paramBoolean1);
    if (this.M5 != bool)
    {
      this.M5 = bool;
      W0();
    }
    this.j5.e(this.a5);
    this.i5.h();
    this.v5 = paramBoolean2;
    this.w5 = false;
  }
  
  protected boolean F1(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    int i = M(paramLong);
    if (i == 0) {
      return false;
    }
    d locald = this.a5;
    locald.i += 1;
    i = this.C5 + i;
    if (paramBoolean) {
      locald.f += i;
    } else {
      a2(i);
    }
    l0();
    return true;
  }
  
  protected void G(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    super.G(paramLong, paramBoolean);
    q1();
    this.i5.l();
    this.D5 = -9223372036854775807L;
    this.x5 = -9223372036854775807L;
    this.B5 = 0;
    if (paramBoolean) {
      S1();
    } else {
      this.y5 = -9223372036854775807L;
    }
  }
  
  @TargetApi(17)
  protected void H()
  {
    try
    {
      super.H();
      localObject1 = this.r5;
      if (localObject1 != null)
      {
        if (this.q5 == localObject1) {
          this.q5 = null;
        }
        ((DummySurface)localObject1).release();
        this.r5 = null;
      }
      return;
    }
    finally
    {
      Object localObject1;
      if (this.r5 != null)
      {
        localObject1 = this.q5;
        DummySurface localDummySurface = this.r5;
        if (localObject1 == localDummySurface) {
          this.q5 = null;
        }
        localDummySurface.release();
        this.r5 = null;
      }
    }
  }
  
  void H1()
  {
    this.w5 = true;
    if (!this.u5)
    {
      this.u5 = true;
      this.j5.A(this.q5);
      this.s5 = true;
    }
  }
  
  protected void I()
  {
    super.I();
    this.A5 = 0;
    this.z5 = SystemClock.elapsedRealtime();
    this.E5 = (SystemClock.elapsedRealtime() * 1000L);
    this.F5 = 0L;
    this.G5 = 0;
    this.i5.m();
  }
  
  protected void J()
  {
    this.y5 = -9223372036854775807L;
    G1();
    I1();
    this.i5.n();
    super.J();
  }
  
  protected void J0(Exception paramException)
  {
    com.google.android.exoplayer2.util.u.d("MediaCodecVideoRenderer", "Video codec error", paramException);
    this.j5.C(paramException);
  }
  
  protected void K0(String paramString, long paramLong1, long paramLong2)
  {
    this.j5.a(paramString, paramLong1, paramLong2);
    this.o5 = s1(paramString);
    this.p5 = ((r)g.e(p0())).n();
    if ((o0.a >= 23) && (this.M5)) {
      this.O5 = new b((com.google.android.exoplayer2.mediacodec.q)g.e(o0()));
    }
  }
  
  protected void L0(String paramString)
  {
    this.j5.b(paramString);
  }
  
  @Nullable
  protected e M0(i1 parami1)
    throws ExoPlaybackException
  {
    e locale = super.M0(parami1);
    this.j5.f(parami1.b, locale);
    return locale;
  }
  
  protected void N0(Format paramFormat, @Nullable MediaFormat paramMediaFormat)
  {
    com.google.android.exoplayer2.mediacodec.q localq = o0();
    if (localq != null) {
      localq.d(this.t5);
    }
    int i;
    if (this.M5)
    {
      this.H5 = paramFormat.M3;
      this.I5 = paramFormat.N3;
    }
    else
    {
      g.e(paramMediaFormat);
      if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top"))) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (i != 0) {
        j = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
      } else {
        j = paramMediaFormat.getInteger("width");
      }
      this.H5 = j;
      if (i != 0) {
        i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      } else {
        i = paramMediaFormat.getInteger("height");
      }
      this.I5 = i;
    }
    float f = paramFormat.Q3;
    this.K5 = f;
    if (o0.a >= 21)
    {
      i = paramFormat.P3;
      if ((i == 90) || (i == 270))
      {
        i = this.H5;
        this.H5 = this.I5;
        this.I5 = i;
        this.K5 = (1.0F / f);
      }
    }
    else
    {
      this.J5 = paramFormat.P3;
    }
    this.i5.i(paramFormat.O3);
  }
  
  protected void N1(long paramLong)
    throws ExoPlaybackException
  {
    n1(paramLong);
    J1();
    d locald = this.a5;
    locald.e += 1;
    H1();
    O0(paramLong);
  }
  
  @CallSuper
  protected void O0(long paramLong)
  {
    super.O0(paramLong);
    if (!this.M5) {
      this.C5 -= 1;
    }
  }
  
  protected e P(r paramr, Format paramFormat1, Format paramFormat2)
  {
    e locale = paramr.e(paramFormat1, paramFormat2);
    int i = locale.e;
    int j = paramFormat2.M3;
    a locala = this.n5;
    if (j <= locala.a)
    {
      j = i;
      if (paramFormat2.N3 <= locala.b) {}
    }
    else
    {
      j = i | 0x100;
    }
    i = j;
    if (B1(paramr, paramFormat2) > this.n5.c) {
      i = j | 0x40;
    }
    paramr = paramr.a;
    if (i != 0) {
      j = 0;
    } else {
      j = locale.d;
    }
    return new e(paramr, paramFormat1, paramFormat2, j, i);
  }
  
  protected void P0()
  {
    super.P0();
    q1();
  }
  
  protected void P1(com.google.android.exoplayer2.mediacodec.q paramq, int paramInt, long paramLong)
  {
    J1();
    m0.a("releaseOutputBuffer");
    paramq.m(paramInt, true);
    m0.c();
    this.E5 = (SystemClock.elapsedRealtime() * 1000L);
    paramq = this.a5;
    paramq.e += 1;
    this.B5 = 0;
    H1();
  }
  
  @CallSuper
  protected void Q0(DecoderInputBuffer paramDecoderInputBuffer)
    throws ExoPlaybackException
  {
    boolean bool = this.M5;
    if (!bool) {
      this.C5 += 1;
    }
    if ((o0.a < 23) && (bool)) {
      N1(paramDecoderInputBuffer.x);
    }
  }
  
  @RequiresApi(21)
  protected void Q1(com.google.android.exoplayer2.mediacodec.q paramq, int paramInt, long paramLong1, long paramLong2)
  {
    J1();
    m0.a("releaseOutputBuffer");
    paramq.j(paramInt, paramLong2);
    m0.c();
    this.E5 = (SystemClock.elapsedRealtime() * 1000L);
    paramq = this.a5;
    paramq.e += 1;
    this.B5 = 0;
    H1();
  }
  
  protected boolean S0(long paramLong1, long paramLong2, @Nullable com.google.android.exoplayer2.mediacodec.q paramq, @Nullable ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat)
    throws ExoPlaybackException
  {
    g.e(paramq);
    if (this.x5 == -9223372036854775807L) {
      this.x5 = paramLong1;
    }
    if (paramLong3 != this.D5)
    {
      this.i5.j(paramLong3);
      this.D5 = paramLong3;
    }
    long l1 = w0();
    long l2 = paramLong3 - l1;
    if ((paramBoolean1) && (!paramBoolean2))
    {
      Z1(paramq, paramInt1, l2);
      return true;
    }
    double d = x0();
    if (getState() == 2) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    long l3 = SystemClock.elapsedRealtime() * 1000L;
    long l4 = ((paramLong3 - paramLong1) / d);
    paramLong3 = l4;
    if (paramInt2 != 0) {
      paramLong3 = l4 - (l3 - paramLong2);
    }
    if (this.q5 == this.r5)
    {
      if (D1(paramLong3))
      {
        Z1(paramq, paramInt1, l2);
        b2(paramLong3);
        return true;
      }
      return false;
    }
    l4 = l3 - this.E5;
    if (!this.w5 ? (paramInt2 != 0) || (this.v5) : !this.u5) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    if ((this.y5 == -9223372036854775807L) && (paramLong1 >= l1) && ((paramInt3 != 0) || ((paramInt2 != 0) && (X1(paramLong3, l4))))) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    if (paramInt3 != 0)
    {
      paramLong1 = System.nanoTime();
      M1(l2, paramLong1, paramFormat);
      if (o0.a >= 21) {
        Q1(paramq, paramInt1, l2, paramLong1);
      } else {
        P1(paramq, paramInt1, l2);
      }
      b2(paramLong3);
    }
    for (;;)
    {
      return true;
      if ((paramInt2 == 0) || (paramLong1 == this.x5)) {
        break;
      }
      l4 = System.nanoTime();
      paramLong3 = this.i5.a(paramLong3 * 1000L + l4);
      l4 = (paramLong3 - l4) / 1000L;
      if (this.y5 != -9223372036854775807L) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      if ((V1(l4, paramLong2, paramBoolean2)) && (F1(paramLong1, paramBoolean1))) {
        return false;
      }
      if (W1(l4, paramLong2, paramBoolean2))
      {
        if (paramBoolean1) {
          Z1(paramq, paramInt1, l2);
        } else {
          v1(paramq, paramInt1, l2);
        }
        b2(l4);
      }
      else if (o0.a >= 21)
      {
        if (l4 >= 50000L) {
          break;
        }
        M1(l2, paramLong3, paramFormat);
        Q1(paramq, paramInt1, l2, paramLong3);
        b2(l4);
      }
      else
      {
        if (l4 >= 30000L) {
          break;
        }
        if (l4 > 11000L) {
          try
          {
            Thread.sleep((l4 - 10000L) / 1000L);
          }
          catch (InterruptedException paramq)
          {
            Thread.currentThread().interrupt();
            return false;
          }
        }
        M1(l2, paramLong3, paramFormat);
        P1(paramq, paramInt1, l2);
        b2(l4);
      }
    }
    return false;
  }
  
  @RequiresApi(23)
  protected void U1(com.google.android.exoplayer2.mediacodec.q paramq, Surface paramSurface)
  {
    paramq.f(paramSurface);
  }
  
  protected boolean V1(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((E1(paramLong1)) && (!paramBoolean)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  protected boolean W1(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((D1(paramLong1)) && (!paramBoolean)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  protected boolean X1(long paramLong1, long paramLong2)
  {
    boolean bool;
    if ((D1(paramLong1)) && (paramLong2 > 100000L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @CallSuper
  protected void Y0()
  {
    super.Y0();
    this.C5 = 0;
  }
  
  protected MediaCodecDecoderException Z(Throwable paramThrowable, @Nullable r paramr)
  {
    return new MediaCodecVideoDecoderException(paramThrowable, paramr, this.q5);
  }
  
  protected void Z1(com.google.android.exoplayer2.mediacodec.q paramq, int paramInt, long paramLong)
  {
    m0.a("skipVideoBuffer");
    paramq.m(paramInt, false);
    m0.c();
    paramq = this.a5;
    paramq.f += 1;
  }
  
  protected void a2(int paramInt)
  {
    d locald = this.a5;
    locald.g += paramInt;
    this.A5 += paramInt;
    paramInt = this.B5 + paramInt;
    this.B5 = paramInt;
    locald.h = Math.max(paramInt, locald.h);
    paramInt = this.l5;
    if ((paramInt > 0) && (this.A5 >= paramInt)) {
      G1();
    }
  }
  
  protected void b2(long paramLong)
  {
    this.a5.a(paramLong);
    this.F5 += paramLong;
    this.G5 += 1;
  }
  
  public boolean g()
  {
    if (super.g()) {
      if (!this.u5)
      {
        DummySurface localDummySurface = this.r5;
        if (((localDummySurface == null) || (this.q5 != localDummySurface)) && (o0() != null) && (!this.M5)) {}
      }
      else
      {
        this.y5 = -9223372036854775807L;
        return true;
      }
    }
    if (this.y5 == -9223372036854775807L) {
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.y5) {
      return true;
    }
    this.y5 = -9223372036854775807L;
    return false;
  }
  
  public String getName()
  {
    return "MediaCodecVideoRenderer";
  }
  
  protected boolean h1(r paramr)
  {
    boolean bool;
    if ((this.q5 == null) && (!Y1(paramr))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected int j1(s params, Format paramFormat)
    throws MediaCodecUtil.DecoderQueryException
  {
    boolean bool1 = com.google.android.exoplayer2.util.y.q(paramFormat.H3);
    int i = 0;
    if (!bool1) {
      return c2.a(0);
    }
    if (paramFormat.K3 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    List localList = A1(params, paramFormat, bool1, false);
    Object localObject = localList;
    if (bool1)
    {
      localObject = localList;
      if (localList.isEmpty()) {
        localObject = A1(params, paramFormat, false, false);
      }
    }
    if (((List)localObject).isEmpty()) {
      return c2.a(1);
    }
    if (!MediaCodecRenderer.k1(paramFormat)) {
      return c2.a(2);
    }
    localObject = (r)((List)localObject).get(0);
    boolean bool2 = ((r)localObject).m(paramFormat);
    int j;
    if (((r)localObject).o(paramFormat)) {
      j = 16;
    } else {
      j = 8;
    }
    int k = i;
    if (bool2)
    {
      params = A1(params, paramFormat, bool1, true);
      k = i;
      if (!params.isEmpty())
      {
        params = (r)params.get(0);
        k = i;
        if (params.m(paramFormat))
        {
          k = i;
          if (params.o(paramFormat)) {
            k = 32;
          }
        }
      }
    }
    if (bool2) {
      i = 4;
    } else {
      i = 3;
    }
    return c2.b(i, j, k);
  }
  
  public void k(int paramInt, @Nullable Object paramObject)
    throws ExoPlaybackException
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 6)
        {
          if (paramInt != 102)
          {
            super.k(paramInt, paramObject);
          }
          else
          {
            paramInt = ((Integer)paramObject).intValue();
            if (this.N5 != paramInt)
            {
              this.N5 = paramInt;
              if (this.M5) {
                W0();
              }
            }
          }
        }
        else {
          this.P5 = ((t)paramObject);
        }
      }
      else
      {
        this.t5 = ((Integer)paramObject).intValue();
        paramObject = o0();
        if (paramObject != null) {
          ((com.google.android.exoplayer2.mediacodec.q)paramObject).d(this.t5);
        }
      }
    }
    else {
      T1(paramObject);
    }
  }
  
  public void q(float paramFloat1, float paramFloat2)
    throws ExoPlaybackException
  {
    super.q(paramFloat1, paramFloat2);
    this.i5.k(paramFloat1);
  }
  
  protected boolean q0()
  {
    boolean bool;
    if ((this.M5) && (o0.a < 23)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected float r0(float paramFloat, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int i = paramArrayOfFormat.length;
    float f1 = -1.0F;
    int j = 0;
    float f4;
    for (float f2 = -1.0F; j < i; f2 = f4)
    {
      float f3 = paramArrayOfFormat[j].O3;
      f4 = f2;
      if (f3 != -1.0F) {
        f4 = Math.max(f2, f3);
      }
      j++;
    }
    if (f2 == -1.0F) {
      paramFloat = f1;
    } else {
      paramFloat = f2 * paramFloat;
    }
    return paramFloat;
  }
  
  protected boolean s1(String paramString)
  {
    if (paramString.startsWith("OMX.google")) {
      return false;
    }
    try
    {
      if (!f5)
      {
        g5 = w1();
        f5 = true;
      }
      return g5;
    }
    finally {}
  }
  
  protected List<r> t0(s params, Format paramFormat, boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException
  {
    return A1(params, paramFormat, paramBoolean, this.M5);
  }
  
  @TargetApi(17)
  protected com.google.android.exoplayer2.mediacodec.q.a v0(r paramr, Format paramFormat, @Nullable MediaCrypto paramMediaCrypto, float paramFloat)
  {
    Object localObject = this.r5;
    if ((localObject != null) && (((DummySurface)localObject).f != paramr.g))
    {
      ((DummySurface)localObject).release();
      this.r5 = null;
    }
    localObject = paramr.c;
    a locala = z1(paramr, paramFormat, C());
    this.n5 = locala;
    boolean bool = this.m5;
    int i;
    if (this.M5) {
      i = this.N5;
    } else {
      i = 0;
    }
    localObject = C1(paramFormat, (String)localObject, locala, paramFloat, bool, i);
    if (this.q5 == null) {
      if (Y1(paramr))
      {
        if (this.r5 == null) {
          this.r5 = DummySurface.c(this.h5, paramr.g);
        }
        this.q5 = this.r5;
      }
      else
      {
        throw new IllegalStateException();
      }
    }
    return new com.google.android.exoplayer2.mediacodec.q.a(paramr, (MediaFormat)localObject, paramFormat, this.q5, paramMediaCrypto, 0);
  }
  
  protected void v1(com.google.android.exoplayer2.mediacodec.q paramq, int paramInt, long paramLong)
  {
    m0.a("dropVideoBuffer");
    paramq.m(paramInt, false);
    m0.c();
    a2(1);
  }
  
  @TargetApi(29)
  protected void y0(DecoderInputBuffer paramDecoderInputBuffer)
    throws ExoPlaybackException
  {
    if (!this.p5) {
      return;
    }
    ByteBuffer localByteBuffer = (ByteBuffer)g.e(paramDecoderInputBuffer.y);
    if (localByteBuffer.remaining() >= 7)
    {
      int i = localByteBuffer.get();
      int j = localByteBuffer.getShort();
      int k = localByteBuffer.getShort();
      int m = localByteBuffer.get();
      int n = localByteBuffer.get();
      localByteBuffer.position(0);
      if ((i == -75) && (j == 60) && (k == 1) && (m == 4) && (n == 0))
      {
        paramDecoderInputBuffer = new byte[localByteBuffer.remaining()];
        localByteBuffer.get(paramDecoderInputBuffer);
        localByteBuffer.position(0);
        R1(o0(), paramDecoderInputBuffer);
      }
    }
  }
  
  protected a z1(r paramr, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int i = paramFormat.M3;
    int j = paramFormat.N3;
    int k = B1(paramr, paramFormat);
    if (paramArrayOfFormat.length == 1)
    {
      m = k;
      if (k != -1)
      {
        n = x1(paramr, paramFormat.H3, paramFormat.M3, paramFormat.N3);
        m = k;
        if (n != -1) {
          m = Math.min((int)(k * 1.5F), n);
        }
      }
      return new a(i, j, m);
    }
    int i1 = paramArrayOfFormat.length;
    int i2 = 0;
    int n = 0;
    int m = j;
    while (i2 < i1)
    {
      Format localFormat1 = paramArrayOfFormat[i2];
      Format localFormat2 = localFormat1;
      if (paramFormat.T3 != null)
      {
        localFormat2 = localFormat1;
        if (localFormat1.T3 == null) {
          localFormat2 = localFormat1.a().J(paramFormat.T3).E();
        }
      }
      int i3 = i;
      int i4 = m;
      i6 = k;
      j = n;
      if (paramr.e(paramFormat, localFormat2).d != 0)
      {
        i6 = localFormat2.M3;
        if ((i6 != -1) && (localFormat2.N3 != -1)) {
          j = 0;
        } else {
          j = 1;
        }
        j = n | j;
        i3 = Math.max(i, i6);
        i4 = Math.max(m, localFormat2.N3);
        i6 = Math.max(k, B1(paramr, localFormat2));
      }
      i2++;
      i = i3;
      m = i4;
      k = i6;
      n = j;
    }
    int i6 = i;
    j = m;
    i2 = k;
    if (n != 0)
    {
      paramArrayOfFormat = new StringBuilder(66);
      paramArrayOfFormat.append("Resolutions unknown. Codec max resolution: ");
      paramArrayOfFormat.append(i);
      paramArrayOfFormat.append("x");
      paramArrayOfFormat.append(m);
      com.google.android.exoplayer2.util.u.h("MediaCodecVideoRenderer", paramArrayOfFormat.toString());
      paramArrayOfFormat = y1(paramr, paramFormat);
      i6 = i;
      j = m;
      i2 = k;
      if (paramArrayOfFormat != null)
      {
        i6 = Math.max(i, paramArrayOfFormat.x);
        j = Math.max(m, paramArrayOfFormat.y);
        i2 = Math.max(k, x1(paramr, paramFormat.H3, i6, j));
        paramr = new StringBuilder(57);
        paramr.append("Codec max resolution adjusted to: ");
        paramr.append(i6);
        paramr.append("x");
        paramr.append(j);
        com.google.android.exoplayer2.util.u.h("MediaCodecVideoRenderer", paramr.toString());
      }
    }
    return new a(i6, j, i2);
  }
  
  protected static final class a
  {
    public final int a;
    public final int b;
    public final int c;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
  }
  
  @RequiresApi(23)
  private final class b
    implements q.c, Handler.Callback
  {
    private final Handler c;
    
    public b(com.google.android.exoplayer2.mediacodec.q paramq)
    {
      this$1 = o0.w(this);
      this.c = q.this;
      paramq.c(this, q.this);
    }
    
    private void b(long paramLong)
    {
      q localq = q.this;
      if (this != localq.O5) {
        return;
      }
      if (paramLong == Long.MAX_VALUE) {
        q.o1(localq);
      } else {
        try
        {
          localq.N1(paramLong);
        }
        catch (ExoPlaybackException localExoPlaybackException)
        {
          q.p1(q.this, localExoPlaybackException);
        }
      }
    }
    
    public void a(com.google.android.exoplayer2.mediacodec.q paramq, long paramLong1, long paramLong2)
    {
      if (o0.a < 30)
      {
        paramq = Message.obtain(this.c, 0, (int)(paramLong1 >> 32), (int)paramLong1);
        this.c.sendMessageAtFrontOfQueue(paramq);
      }
      else
      {
        b(paramLong1);
      }
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 0) {
        return false;
      }
      b(o0.K0(paramMessage.arg1, paramMessage.arg2));
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */