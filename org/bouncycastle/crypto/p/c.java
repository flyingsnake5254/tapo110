package org.bouncycastle.crypto.p;

import org.bouncycastle.crypto.h;
import org.bouncycastle.util.e;
import org.bouncycastle.util.f;

public abstract class c
  implements h, e
{
  static final long[] a = { 4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L };
  private byte[] b = new byte[8];
  private int c;
  private long d;
  private long e;
  protected long f;
  protected long g;
  protected long h;
  protected long i;
  protected long j;
  protected long k;
  protected long l;
  protected long m;
  private long[] n = new long[80];
  private int o;
  
  protected c()
  {
    this.c = 0;
    reset();
  }
  
  protected c(c paramc)
  {
    u(paramc);
  }
  
  private long n(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 ^ 0xFFFFFFFFFFFFFFFF) & paramLong3 ^ paramLong2 & paramLong1;
  }
  
  private long o(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 ^ paramLong1 & paramLong2 ^ paramLong2 & paramLong3;
  }
  
  private long p(long paramLong)
  {
    return paramLong >>> 7 ^ (paramLong << 63 | paramLong >>> 1) ^ (paramLong << 56 | paramLong >>> 8);
  }
  
  private long q(long paramLong)
  {
    return paramLong >>> 6 ^ (paramLong << 45 | paramLong >>> 19) ^ (paramLong << 3 | paramLong >>> 61);
  }
  
  private long r(long paramLong)
  {
    return (paramLong >>> 39 | paramLong << 25) ^ (paramLong << 36 | paramLong >>> 28) ^ (paramLong << 30 | paramLong >>> 34);
  }
  
  private long s(long paramLong)
  {
    return (paramLong >>> 41 | paramLong << 23) ^ (paramLong << 50 | paramLong >>> 14) ^ (paramLong << 46 | paramLong >>> 18);
  }
  
  private void t()
  {
    long l1 = this.d;
    if (l1 > 2305843009213693951L)
    {
      this.e += (l1 >>> 61);
      this.d = (l1 & 0x1FFFFFFFFFFFFFFF);
    }
  }
  
  public void c(byte paramByte)
  {
    byte[] arrayOfByte = this.b;
    int i1 = this.c;
    int i2 = i1 + 1;
    this.c = i2;
    arrayOfByte[i1] = ((byte)paramByte);
    if (i2 == arrayOfByte.length)
    {
      y(arrayOfByte, 0);
      this.c = 0;
    }
    this.d += 1L;
  }
  
  public int k()
  {
    return 128;
  }
  
  public void reset()
  {
    this.d = 0L;
    this.e = 0L;
    int i1 = 0;
    this.c = 0;
    Object localObject;
    for (int i2 = 0;; i2++)
    {
      localObject = this.b;
      if (i2 >= localObject.length) {
        break;
      }
      localObject[i2] = ((byte)0);
    }
    this.o = 0;
    for (i2 = i1;; i2++)
    {
      localObject = this.n;
      if (i2 == localObject.length) {
        break;
      }
      localObject[i2] = 0L;
    }
  }
  
  protected void u(c paramc)
  {
    Object localObject = paramc.b;
    System.arraycopy(localObject, 0, this.b, 0, localObject.length);
    this.c = paramc.c;
    this.d = paramc.d;
    this.e = paramc.e;
    this.f = paramc.f;
    this.g = paramc.g;
    this.h = paramc.h;
    this.i = paramc.i;
    this.j = paramc.j;
    this.k = paramc.k;
    this.l = paramc.l;
    this.m = paramc.m;
    localObject = paramc.n;
    System.arraycopy(localObject, 0, this.n, 0, localObject.length);
    this.o = paramc.o;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    int i2 = paramInt1;
    for (;;)
    {
      paramInt2 = i2;
      paramInt1 = i1;
      if (this.c == 0) {
        break;
      }
      paramInt2 = i2;
      paramInt1 = i1;
      if (i1 <= 0) {
        break;
      }
      c(paramArrayOfByte[i2]);
      i2++;
      i1--;
    }
    for (;;)
    {
      i1 = paramInt2;
      i2 = paramInt1;
      if (paramInt1 <= this.b.length) {
        break;
      }
      y(paramArrayOfByte, paramInt2);
      byte[] arrayOfByte = this.b;
      paramInt2 += arrayOfByte.length;
      paramInt1 -= arrayOfByte.length;
      this.d += arrayOfByte.length;
    }
    while (i2 > 0)
    {
      c(paramArrayOfByte[i1]);
      i1++;
      i2--;
    }
  }
  
  public void v()
  {
    t();
    long l1 = this.d;
    long l2 = this.e;
    byte b1 = Byte.MIN_VALUE;
    for (byte b2 = b1;; b2 = b1)
    {
      c(b2);
      if (this.c == 0) {
        break;
      }
      b1 = 0;
    }
    x(l1 << 3, l2);
    w();
  }
  
  protected void w()
  {
    t();
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    for (int i1 = 16; i1 <= 79; i1++)
    {
      arrayOfLong1 = this.n;
      l1 = q(arrayOfLong1[(i1 - 2)]);
      arrayOfLong2 = this.n;
      arrayOfLong1[i1] = (l1 + arrayOfLong2[(i1 - 7)] + p(arrayOfLong2[(i1 - 15)]) + this.n[(i1 - 16)]);
    }
    long l1 = this.f;
    long l2 = this.g;
    long l3 = this.h;
    long l4 = this.i;
    long l5 = this.j;
    long l6 = this.k;
    long l7 = this.l;
    long l8 = this.m;
    int i2 = 0;
    i1 = 0;
    while (i1 < 10)
    {
      long l9 = s(l5);
      long l10 = n(l5, l6, l7);
      arrayOfLong2 = a;
      long l11 = arrayOfLong2[i2];
      arrayOfLong1 = this.n;
      int i3 = i2 + 1;
      l10 = l8 + (l9 + l10 + l11 + arrayOfLong1[i2]);
      l8 = l4 + l10;
      l4 = l10 + (r(l1) + o(l1, l2, l3));
      l10 = s(l8);
      l11 = n(l8, l5, l6);
      l9 = arrayOfLong2[i3];
      arrayOfLong1 = this.n;
      i2 = i3 + 1;
      l10 = l7 + (l10 + l11 + l9 + arrayOfLong1[i3]);
      l3 += l10;
      l9 = l10 + (r(l4) + o(l4, l1, l2));
      l10 = s(l3);
      l7 = n(l3, l8, l5);
      l11 = arrayOfLong2[i2];
      arrayOfLong1 = this.n;
      i3 = i2 + 1;
      l6 += l10 + l7 + l11 + arrayOfLong1[i2];
      l2 += l6;
      l10 = l6 + (r(l9) + o(l9, l4, l1));
      l7 = s(l2);
      l6 = n(l2, l3, l8);
      l11 = arrayOfLong2[i3];
      arrayOfLong1 = this.n;
      i2 = i3 + 1;
      l5 += l7 + l6 + l11 + arrayOfLong1[i3];
      l7 = l1 + l5;
      l5 += r(l10) + o(l10, l9, l4);
      l6 = s(l7);
      l11 = n(l7, l2, l3);
      l1 = arrayOfLong2[i2];
      arrayOfLong1 = this.n;
      i3 = i2 + 1;
      l1 = l8 + (l6 + l11 + l1 + arrayOfLong1[i2]);
      l8 = l4 + l1;
      l4 = l1 + (r(l5) + o(l5, l10, l9));
      l11 = s(l8);
      l1 = n(l8, l7, l2);
      l6 = arrayOfLong2[i3];
      arrayOfLong1 = this.n;
      i2 = i3 + 1;
      l6 = l3 + (l11 + l1 + l6 + arrayOfLong1[i3]);
      l1 = l9 + l6;
      l3 = l6 + (r(l4) + o(l4, l5, l10));
      l9 = s(l1);
      l6 = l1;
      l1 = n(l1, l8, l7);
      l11 = arrayOfLong2[i2];
      arrayOfLong1 = this.n;
      i3 = i2 + 1;
      l2 += l9 + l1 + l11 + arrayOfLong1[i2];
      l1 = l10 + l2;
      l11 = r(l3);
      long l12 = o(l3, l4, l5);
      l9 = s(l1);
      l10 = l1;
      l2 += l11 + l12;
      l1 = l7 + (l9 + n(l1, l6, l8) + arrayOfLong2[i3] + this.n[i3]);
      l7 = r(l2);
      l9 = o(l2, l3, l4);
      i1++;
      l5 += l1;
      i2 = i3 + 1;
      l1 += l7 + l9;
      l7 = l6;
      l6 = l10;
    }
    this.f += l1;
    this.g += l2;
    this.h += l3;
    this.i += l4;
    this.j += l5;
    this.k += l6;
    this.l += l7;
    this.m += l8;
    this.o = 0;
    for (i1 = 0; i1 < 16; i1++) {
      this.n[i1] = 0L;
    }
  }
  
  protected void x(long paramLong1, long paramLong2)
  {
    if (this.o > 14) {
      w();
    }
    long[] arrayOfLong = this.n;
    arrayOfLong[14] = paramLong2;
    arrayOfLong[15] = paramLong1;
  }
  
  protected void y(byte[] paramArrayOfByte, int paramInt)
  {
    this.n[this.o] = f.b(paramArrayOfByte, paramInt);
    paramInt = this.o + 1;
    this.o = paramInt;
    if (paramInt == 16) {
      w();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */