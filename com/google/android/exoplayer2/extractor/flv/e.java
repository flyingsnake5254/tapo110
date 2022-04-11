package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.video.m;

final class e
  extends TagPayloadReader
{
  private final d0 b = new d0(z.a);
  private final d0 c = new d0(4);
  private int d;
  private boolean e;
  private boolean f;
  private int g;
  
  public e(b0 paramb0)
  {
    super(paramb0);
  }
  
  protected boolean b(d0 paramd0)
    throws TagPayloadReader.UnsupportedFormatException
  {
    int i = paramd0.D();
    int j = i >> 4 & 0xF;
    i &= 0xF;
    if (i == 7)
    {
      this.g = j;
      boolean bool;
      if (j != 5) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    paramd0 = new StringBuilder(39);
    paramd0.append("Video format not supported: ");
    paramd0.append(i);
    throw new TagPayloadReader.UnsupportedFormatException(paramd0.toString());
  }
  
  protected boolean c(d0 paramd0, long paramLong)
    throws ParserException
  {
    int i = paramd0.D();
    long l = paramd0.o();
    Object localObject;
    if ((i == 0) && (!this.e))
    {
      localObject = new d0(new byte[paramd0.a()]);
      paramd0.j(((d0)localObject).d(), 0, paramd0.a());
      paramd0 = m.b((d0)localObject);
      this.d = paramd0.b;
      paramd0 = new Format.b().e0("video/avc").I(paramd0.f).j0(paramd0.c).Q(paramd0.d).a0(paramd0.e).T(paramd0.a).E();
      this.a.d(paramd0);
      this.e = true;
      return false;
    }
    if ((i == 1) && (this.e))
    {
      if (this.g == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if ((!this.f) && (i == 0)) {
        return false;
      }
      localObject = this.c.d();
      localObject[0] = ((byte)0);
      localObject[1] = ((byte)0);
      localObject[2] = ((byte)0);
      int j = this.d;
      int m;
      for (int k = 0; paramd0.a() > 0; k = k + 4 + m)
      {
        paramd0.j(this.c.d(), 4 - j, this.d);
        this.c.P(0);
        m = this.c.H();
        this.b.P(0);
        this.a.c(this.b, 4);
        this.a.c(paramd0, m);
      }
      this.a.e(paramLong + l * 1000L, i, k, 0, null);
      this.f = true;
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\extractor\flv\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */