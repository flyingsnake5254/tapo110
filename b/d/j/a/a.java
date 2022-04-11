package b.d.j.a;

import b.d.d.m.e;
import b.d.p.d;
import com.tplink.libtpdemux.tsdemux.common.EnumESFrameType;
import com.tplink.libtpdemux.tsdemux.common.EnumESType;
import com.tplink.libtpdemux.tsdemux.common.EnumTSAudioEncodeType;
import com.tplink.libtpdemux.tsdemux.common.EnumTSPacketType;
import com.tplink.libtpdemux.tsdemux.common.EnumTSVideoEncodeType;
import com.tplink.libtpdemux.tsdemux.common.b;
import com.tplink.libtpdemux.tsdemux.common.c;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class a
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private final b d = new b();
  private boolean e = false;
  private ByteBuffer f = ByteBuffer.allocateDirect(1024000);
  private ByteBuffer g = ByteBuffer.allocateDirect(102400);
  private final byte[] h = new byte['¼'];
  private final byte[] i = new byte['¼'];
  private final byte[] j = new byte['¼'];
  private final byte[] k = new byte['¼'];
  private final byte[] l = new byte['¼'];
  private final e m = new e();
  private long n;
  private int o = 90000;
  private long p = 0L;
  private long q = 0L;
  private long r = 0L;
  private long s = 0L;
  private final long t = 268435456L;
  private long u = 16L;
  a v;
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0) && (paramInt <= this.g.remaining())) {
      this.g.put(paramArrayOfByte, 0, paramInt);
    }
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0) && (paramInt <= this.f.remaining())) {
      this.f.put(paramArrayOfByte, 0, paramInt);
    }
  }
  
  private boolean c(byte[] paramArrayOfByte, int paramInt)
  {
    
    boolean bool;
    if (((paramArrayOfByte[paramInt] & 0x1F) != 5) && ((paramArrayOfByte[paramInt] & 0x1F) != 2) && ((paramArrayOfByte[paramInt] & 0x1F) != 7) && ((paramArrayOfByte[paramInt] & 0x1F) != 8)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean d(ByteBuffer paramByteBuffer, int paramInt)
  {
    if ((paramByteBuffer != null) && (paramInt >= 4))
    {
      paramInt -= 3;
      int i1 = 3;
      while (paramInt >= 0) {
        if ((paramByteBuffer.get(i1) & 0xFF) == 1)
        {
          if (((paramByteBuffer.get(i1 - 1) & 0xFF) == 0) && ((paramByteBuffer.get(i1 - 2) & 0xFF) == 0) && ((paramByteBuffer.get(i1 - 3) & 0xFF) == 0)) {
            return true;
          }
          i1 += 4;
          paramInt -= 4;
        }
        else
        {
          i1++;
          paramInt--;
        }
      }
    }
    return false;
  }
  
  private long e(byte[] paramArrayOfByte)
  {
    return (0xE & paramArrayOfByte[14]) << 29 | l(paramArrayOfByte[15], paramArrayOfByte[16]) >> 1 << 15 | l(paramArrayOfByte[17], paramArrayOfByte[18]) >> 1;
  }
  
  private int f(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramInt;
    if (j(paramArrayOfByte)) {
      i1 = paramInt - (paramArrayOfByte[8] & 0xFF) - 9;
    }
    return i1;
  }
  
  private int g(byte[] paramArrayOfByte)
  {
    int i1;
    if (j(paramArrayOfByte)) {
      i1 = (paramArrayOfByte[8] & 0xFF) + 9;
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  private long h(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[9] & 0xE) << 29 | l(paramArrayOfByte[10], paramArrayOfByte[11]) >> 1 << 15 | l(paramArrayOfByte[12], paramArrayOfByte[13]) >> 1;
  }
  
  private EnumESFrameType i(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return EnumESFrameType.TS_ES_FRAME_TYPE_INVALID;
    }
    paramInt = paramArrayOfByte[(paramInt + 4)] & 0x1F;
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7)
          {
            if (paramInt != 8) {
              return EnumESFrameType.TS_ES_FRAME_TYPE_INVALID;
            }
            return EnumESFrameType.TS_ES_FRAME_TYPE_PPS;
          }
          return EnumESFrameType.TS_ES_FRAME_TYPE_SPS;
        }
        return EnumESFrameType.TS_ES_FRAME_TYPE_SEI;
      }
      return EnumESFrameType.TS_ES_FRAME_TYPE_IDR;
    }
    return EnumESFrameType.TS_ES_FRAME_TYPE_DATA;
  }
  
  private boolean j(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 3) && ((paramArrayOfByte[0] & 0xFF) == 0) && ((paramArrayOfByte[1] & 0xFF) == 0) && ((paramArrayOfByte[2] & 0xFF) == 1);
  }
  
  private boolean k(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 4) && ((paramArrayOfByte[0] & 0xFF) == 0) && ((paramArrayOfByte[1] & 0xFF) == 0) && ((paramArrayOfByte[2] & 0xFF) == 0) && ((paramArrayOfByte[3] & 0xFF) == 1);
  }
  
  private long l(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF) & 0xFFFF;
  }
  
  private b m(byte[] paramArrayOfByte, EnumTSPacketType paramEnumTSPacketType, int paramInt)
  {
    if (71 != (paramArrayOfByte[0] & 0xFF)) {
      return new b(-1, paramEnumTSPacketType, paramInt);
    }
    if ((paramArrayOfByte[3] & 0x10) == 0) {
      return new b(-1, paramEnumTSPacketType, paramInt);
    }
    int i1 = paramArrayOfByte[3];
    paramInt = 4;
    if ((i1 & 0x20) != 0) {
      paramInt = (paramArrayOfByte[4] & 0xFF) + 5;
    }
    n(paramArrayOfByte, paramInt);
    if (((paramArrayOfByte[1] & 0x1F) == 0) && ((paramArrayOfByte[2] & 0xFF) == 0)) {
      return new b(0, EnumTSPacketType.TS_TS_PACKET_TYPE_PAT, paramInt + ((paramArrayOfByte[paramInt] & 0xFF) + 1));
    }
    i1 = this.a;
    if (-1 == i1) {
      return new b(-1, paramEnumTSPacketType, paramInt);
    }
    i1 &= 0x1FFF;
    if ((i1 >> 8 == (paramArrayOfByte[1] & 0x1F)) && ((i1 & 0xFF) == (paramArrayOfByte[2] & 0xFF))) {
      return new b(0, EnumTSPacketType.TS_TS_PACKET_TYPE_PMT, paramInt + ((paramArrayOfByte[paramInt] & 0xFF) + 1));
    }
    i1 = this.b;
    if (-1 == i1) {
      return new b(-1, paramEnumTSPacketType, paramInt);
    }
    i1 &= 0x1FFF;
    if ((i1 >> 8 == (paramArrayOfByte[1] & 0x1F)) && ((i1 & 0xFF) == (paramArrayOfByte[2] & 0xFF))) {
      return new b(0, EnumTSPacketType.TS_TS_PACKET_TYPE_VIDEO, paramInt);
    }
    i1 = this.c;
    if (-1 == i1) {
      return new b(-1, paramEnumTSPacketType, paramInt);
    }
    i1 &= 0x1FFF;
    if ((i1 >> 8 == (paramArrayOfByte[1] & 0x1F)) && ((i1 & 0xFF) == (paramArrayOfByte[2] & 0xFF))) {
      return new b(0, EnumTSPacketType.TS_TS_PACKET_TYPE_AUDIO, paramInt);
    }
    return new b(-1, paramEnumTSPacketType, paramInt);
  }
  
  private void n(byte[] paramArrayOfByte, int paramInt)
  {
    if ((31 == (paramArrayOfByte[1] & 0x1F)) && (255 == (paramArrayOfByte[2] & 0xFF))) {
      if ((paramArrayOfByte[paramInt] & 0xFF) == 1)
      {
        d.a("MPEGTSDemuxer", "MPEGTS_NULL_PACKET_TYPE_AUX");
        this.n = ((paramArrayOfByte[(paramInt + 3)] & 0xFF) * 16777216L + (paramArrayOfByte[(paramInt + 4)] & 0xFF) * 65536L + (paramArrayOfByte[(paramInt + 5)] & 0xFF) * 256L + (paramArrayOfByte[(paramInt + 6)] & 0xFF) * 1L + (paramArrayOfByte[(paramInt + 7)] & 0xFF) * 16777216L + (paramArrayOfByte[(paramInt + 8)] & 0xFF) * 65536L + (paramArrayOfByte[(paramInt + 9)] & 0xFF) * 256L + (0xFF & paramArrayOfByte[(paramInt + 10)]));
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("lastUCT ");
        paramArrayOfByte.append(this.n);
        d.a("MPEGTSDemuxer", paramArrayOfByte.toString());
      }
      else if ((paramArrayOfByte[paramInt] & 0xFF) == 242)
      {
        d.a("MPEGTSDemuxer", "MPEGTS_NULL_PACKET_TYPE_REPEAT");
      }
    }
  }
  
  private void p(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (188 <= paramArrayOfByte.length))
    {
      int i1 = paramArrayOfByte.length;
      if (188 <= paramArrayOfByte.length)
      {
        System.arraycopy(paramArrayOfByte, 0, this.h, 0, 188);
        int i2 = i1 - 188;
        i1 = 188;
        while (i2 >= 0)
        {
          Object localObject1 = EnumTSPacketType.TS_TS_PACKET_TYPE_INVALID;
          Object localObject2 = m(this.h, (EnumTSPacketType)localObject1, 0);
          int i3 = ((b)localObject2).a();
          localObject1 = ((b)localObject2).c();
          int i4 = ((b)localObject2).b();
          if (i3 != 0)
          {
            if (i1 < paramArrayOfByte.length)
            {
              i4 = i1 + 188;
              if (i4 <= paramArrayOfByte.length)
              {
                System.arraycopy(paramArrayOfByte, i1, this.h, 0, 188);
                i2 -= 188;
                i1 = i4;
              }
              else
              {
                d.a("MPEGTSDemuxer", "out of range 156");
              }
            }
          }
          else
          {
            localObject2 = EnumTSPacketType.TS_TS_PACKET_TYPE_AUDIO;
            int i5;
            if ((EnumTSPacketType.TS_TS_PACKET_TYPE_PAT == localObject1) && (-1 == this.a))
            {
              System.arraycopy(this.h, i4, this.i, 0, 188 - i4);
              localObject1 = this.i;
              if (((localObject1[0] & 0xFF) == 0) && ((localObject1[5] & 0x1) != 0))
              {
                i3 = (((localObject1[1] & 0xF & 0xFF) << 8) + (localObject1[2] & 0xFF) - 9) / 4;
                i4 = 0;
              }
              for (;;)
              {
                if (i4 != i3)
                {
                  i5 = i4 * 4 + 8;
                  localObject1 = this.i;
                  if (((localObject1[i5] & 0xFF) == 0) && ((localObject1[(i5 + 1)] & 0xFF) == 1))
                  {
                    this.a = (((localObject1[(i5 + 2)] & 0x1F & 0xFF) << 8) + (localObject1[(i5 + 3)] & 0xFF));
                  }
                  else
                  {
                    i4++;
                    continue;
                    if (i1 >= paramArrayOfByte.length) {
                      break label1678;
                    }
                    i4 = i1 + 188;
                    if (i4 <= paramArrayOfByte.length)
                    {
                      System.arraycopy(paramArrayOfByte, i1, this.h, 0, 188);
                      i1 = i4;
                    }
                  }
                }
              }
            }
            for (;;)
            {
              label386:
              i2 -= 188;
              for (;;)
              {
                break;
                d.a("MPEGTSDemuxer", "out of range 186");
                return;
                if ((EnumTSPacketType.TS_TS_PACKET_TYPE_PMT == localObject1) && ((-1 == this.b) || (-1 == this.c)))
                {
                  System.arraycopy(this.h, i4, this.j, 0, 188 - i4);
                  localObject1 = this.j;
                  if ((2 == (localObject1[0] & 0xFF)) && ((localObject1[5] & 0x1) != 0))
                  {
                    i4 = ((localObject1[1] & 0xF & 0xFF) << 8) + (localObject1[2] & 0xFF) - 13;
                    i3 = 12;
                    while (i4 > 0)
                    {
                      localObject1 = this.j;
                      if ((localObject1[i3] & 0xFF) == 27)
                      {
                        this.b = (((localObject1[(i3 + 1)] & 0x1F & 0xFF) << 8) + (localObject1[(i3 + 2)] & 0xFF));
                        this.d.c().j(EnumTSVideoEncodeType.TS_VIDEO_ENCODE_TYPE_H264);
                      }
                      localObject1 = this.j;
                      if ((localObject1[i3] & 0xFF) == 15)
                      {
                        this.c = (((localObject1[(i3 + 1)] & 0x1F & 0xFF) << 8) + (localObject1[(i3 + 2)] & 0xFF));
                        this.d.a().g(EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_AAC);
                      }
                      localObject1 = this.j;
                      if ((localObject1[i3] & 0xFF) == 144)
                      {
                        this.c = (((localObject1[(i3 + 1)] & 0x1F & 0xFF) << 8) + (localObject1[(i3 + 2)] & 0xFF));
                        this.d.a().g(EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_PCMA);
                      }
                      localObject1 = this.j;
                      if ((localObject1[i3] & 0xFF) == 145)
                      {
                        this.c = (((localObject1[(i3 + 1)] & 0x1F & 0xFF) << 8) + (localObject1[(i3 + 2)] & 0xFF));
                        this.d.a().g(EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_PCMU);
                      }
                      localObject1 = this.j;
                      if ((localObject1[i3] & 0xFF) == 4)
                      {
                        this.c = (((localObject1[(i3 + 1)] & 0x1F & 0xFF) << 8) + (localObject1[(i3 + 2)] & 0xFF));
                        this.d.a().g(EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_MP2);
                      }
                      localObject1 = this.j;
                      if ((localObject1[i3] & 0xFF) == 3)
                      {
                        this.c = (((localObject1[(i3 + 1)] & 0x1F & 0xFF) << 8) + (localObject1[(i3 + 2)] & 0xFF));
                        this.d.a().g(EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_MP3);
                      }
                      localObject1 = this.j;
                      i5 = (localObject1[(i3 + 3)] & 0xF) + (localObject1[(i3 + 4)] & 0xFF);
                      i3 += i5 + 4 + 1;
                      i4 = i4 - i5 - 4 - 1;
                    }
                  }
                  if (i1 >= paramArrayOfByte.length) {
                    break label1678;
                  }
                  i4 = i1 + 188;
                  if (i4 <= paramArrayOfByte.length)
                  {
                    System.arraycopy(paramArrayOfByte, i1, this.h, 0, 188);
                    i1 = i4;
                    break label386;
                  }
                  d.a("MPEGTSDemuxer", "out of range 237");
                  return;
                }
                if (EnumTSPacketType.TS_TS_PACKET_TYPE_VIDEO == localObject1)
                {
                  i3 = 188 - i4;
                  System.arraycopy(this.h, i4, this.k, 0, i3);
                  i4 = g(this.k);
                  i3 = f(this.k, i3);
                  System.arraycopy(this.k, i4, this.l, 0, i3);
                  if ((j(this.k)) && (k(this.l)))
                  {
                    localObject1 = this.f;
                    if (d((ByteBuffer)localObject1, ((ByteBuffer)localObject1).position()))
                    {
                      this.f.flip();
                      i4 = this.f.remaining();
                      localObject2 = new byte[i4];
                      this.f.get((byte[])localObject2);
                      this.d.c().g(c((byte[])localObject2, 0));
                      this.d.c().f(i((byte[])localObject2, 0));
                      this.d.d(EnumESType.TS_ES_TYPE_VIDEO);
                      localObject1 = this.v;
                      if (localObject1 != null) {
                        ((a)localObject1).e((byte[])localObject2, i4, this.d);
                      }
                    }
                    this.f.clear();
                    this.d.c().g(false);
                    this.d.c().h(h(this.k));
                    this.d.c().e(e(this.k));
                    this.d.c().i(this.n);
                    b(this.l, i3);
                    break label1628;
                  }
                  b(this.l, i3);
                  break label1628;
                }
                if (localObject2 != localObject1) {
                  break label1628;
                }
                i3 = 188 - i4;
                System.arraycopy(this.h, i4, this.k, 0, i3);
                if (this.e) {
                  break label1438;
                }
                if (!s(this.k, i3))
                {
                  if (i1 >= paramArrayOfByte.length) {
                    break label1678;
                  }
                  i4 = i1 + 188;
                  if (i4 <= paramArrayOfByte.length)
                  {
                    System.arraycopy(paramArrayOfByte, i1, this.h, 0, 188);
                    i1 = i4;
                    break label386;
                  }
                  d.a("MPEGTSDemuxer", "out of range 156");
                  return;
                }
                this.e = true;
              }
              label1438:
              s(this.k, i3);
              i4 = g(this.k);
              i3 = f(this.k, i3);
              System.arraycopy(this.k, i4, this.l, 0, i3);
              if (!j(this.k))
              {
                a(this.l, i3);
              }
              else
              {
                this.d.d(EnumESType.TS_ES_TYPE_AUDIO);
                if (this.v != null)
                {
                  this.g.flip();
                  i4 = this.g.remaining();
                  localObject1 = new byte[i4];
                  this.g.get((byte[])localObject1);
                  this.v.e((byte[])localObject1, i4, this.d);
                }
                this.g.clear();
                this.d.a().k(h(this.k));
                this.d.a().m(this.n);
                a(this.l, i3);
              }
              label1628:
              if (i1 >= paramArrayOfByte.length) {
                break label1678;
              }
              i4 = i1 + 188;
              if (i4 > paramArrayOfByte.length) {
                break label1670;
              }
              System.arraycopy(paramArrayOfByte, i1, this.h, 0, 188);
              i1 = i4;
            }
            label1670:
            d.a("MPEGTSDemuxer", "out of range 419");
          }
        }
        label1678:
        return;
      }
      d.a("MPEGTSDemuxer", "out of range 126");
    }
  }
  
  private boolean s(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (9 <= paramInt))
    {
      if (!j(paramArrayOfByte)) {
        return false;
      }
      if (this.d.a().a() == EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_PCMA)
      {
        this.d.a().i(1);
        this.d.a().l(8000);
      }
      else if (this.d.a().a() != EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_PCMU)
      {
        int i1;
        int i2;
        if (this.d.a().a() == EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_MP2)
        {
          i1 = (paramArrayOfByte[8] & 0xFF) + 9;
          i2 = i1 + 3;
          if (i2 > paramInt) {
            return false;
          }
          if (255 == (paramArrayOfByte[i1] & 0xFF))
          {
            paramInt = i1 + 1;
            if (224 == (paramArrayOfByte[paramInt] & 0xF0))
            {
              paramInt = (paramArrayOfByte[i2] & 0xFF) * 16777216 + (paramArrayOfByte[(i1 + 2)] & 0xFF) * 65536 + (paramArrayOfByte[paramInt] & 0xFF) * 256 + (paramArrayOfByte[i1] & 0xFF);
              this.d.a().i(this.m.e(paramInt));
              this.d.a().l(this.m.j(paramInt));
              this.d.a().j(this.m.g(paramInt));
              this.d.a().h(this.m.c(paramInt));
              break label1016;
            }
          }
          return false;
        }
        else if (this.d.a().a() == EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_MP3)
        {
          i2 = (paramArrayOfByte[8] & 0xFF) + 9;
          i1 = i2 + 3;
          if (i1 > paramInt) {
            return false;
          }
          if (255 == (paramArrayOfByte[i2] & 0xFF))
          {
            paramInt = i2 + 1;
            if (240 == (paramArrayOfByte[paramInt] & 0xF0))
            {
              paramInt = (paramArrayOfByte[i1] & 0xFF) * 16777216 + (paramArrayOfByte[(i2 + 2)] & 0xFF) * 65536 + (paramArrayOfByte[paramInt] & 0xFF) * 256 + (paramArrayOfByte[i2] & 0xFF);
              this.d.a().i(this.m.e(paramInt));
              this.d.a().l(this.m.j(paramInt));
              this.d.a().j(this.m.g(paramInt));
              this.d.a().h(this.m.c(paramInt));
              break label1016;
            }
          }
          return false;
        }
        else
        {
          if (this.d.a().a() != EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_AAC) {
            break label1038;
          }
          i1 = (paramArrayOfByte[8] & 0xFF) + 9;
          i2 = i1 + 3;
          if (i2 > paramInt) {
            return false;
          }
          if ((255 != (paramArrayOfByte[i1] & 0xFF)) || (240 != (paramArrayOfByte[(i1 + 1)] & 0xF0))) {
            break label1036;
          }
          i1 += 2;
          paramInt = (paramArrayOfByte[i1] & 0x3C) >> 2;
          if (paramInt == 0)
          {
            this.d.a().l(96000);
          }
          else if (1 == paramInt)
          {
            this.d.a().l(88200);
          }
          else if (2 == paramInt)
          {
            this.d.a().l(64000);
          }
          else if (3 == paramInt)
          {
            this.d.a().l(48000);
          }
          else if (4 == paramInt)
          {
            this.d.a().l(44100);
          }
          else if (5 == paramInt)
          {
            this.d.a().l(32000);
          }
          else if (6 == paramInt)
          {
            this.d.a().l(24000);
          }
          else if (7 == paramInt)
          {
            this.d.a().l(22050);
          }
          else if (8 == paramInt)
          {
            this.d.a().l(16000);
          }
          else if (9 == paramInt)
          {
            this.d.a().l(12000);
          }
          else if (10 == paramInt)
          {
            this.d.a().l(11025);
          }
          else if (11 == paramInt)
          {
            this.d.a().l(8000);
          }
          else
          {
            if (12 != paramInt) {
              break label1028;
            }
            this.d.a().l(7350);
          }
          paramInt = ((paramArrayOfByte[i1] & 0x1) << 2) + ((paramArrayOfByte[i2] & 0xC0) >> 6);
          if (paramInt == 0)
          {
            this.d.a().i(2);
          }
          else if (1 == paramInt)
          {
            this.d.a().i(1);
          }
          else if (2 == paramInt)
          {
            this.d.a().i(2);
          }
          else if (3 == paramInt)
          {
            this.d.a().i(3);
          }
          else if (4 == paramInt)
          {
            this.d.a().i(4);
          }
          else if (5 == paramInt)
          {
            this.d.a().i(5);
          }
          else if (6 == paramInt)
          {
            this.d.a().i(6);
          }
          else
          {
            if (7 != paramInt) {
              break label1018;
            }
            this.d.a().i(8);
          }
        }
      }
      label1016:
      return true;
      label1018:
      d.a("MPEGTSDemuxer", "unknow audio channle num!");
      return false;
      label1028:
      d.a("MPEGTSDemuxer", "unkown audio frequency");
      label1036:
      return false;
      label1038:
      d.a("MPEGTSDemuxer", "know audio decode type!");
    }
    return false;
  }
  
  public void o(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > paramInt) {
      arrayOfByte = Arrays.copyOf(paramArrayOfByte, paramInt);
    }
    p(arrayOfByte);
  }
  
  public void q()
  {
    this.f = null;
    this.g = null;
  }
  
  public void r(a parama)
  {
    this.v = parama;
  }
  
  public static abstract interface a
  {
    public abstract void e(byte[] paramArrayOfByte, int paramInt, b paramb);
  }
  
  class b
  {
    int a;
    EnumTSPacketType b;
    int c;
    
    public b(int paramInt1, EnumTSPacketType paramEnumTSPacketType, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramEnumTSPacketType;
      this.c = paramInt2;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public int b()
    {
      return this.c;
    }
    
    public EnumTSPacketType c()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\j\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */