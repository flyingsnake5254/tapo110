package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.audio.m.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.util.d0;
import java.util.Collections;

final class b
  extends TagPayloadReader
{
  private static final int[] b = { 5512, 11025, 22050, 44100 };
  private boolean c;
  private boolean d;
  private int e;
  
  public b(b0 paramb0)
  {
    super(paramb0);
  }
  
  protected boolean b(d0 paramd0)
    throws TagPayloadReader.UnsupportedFormatException
  {
    if (!this.c)
    {
      int i = paramd0.D();
      int j = i >> 4 & 0xF;
      this.e = j;
      if (j == 2)
      {
        i = b[(i >> 2 & 0x3)];
        paramd0 = new Format.b().e0("audio/mpeg").H(1).f0(i).E();
        this.a.d(paramd0);
        this.d = true;
      }
      else if ((j != 7) && (j != 8))
      {
        if (j != 10)
        {
          i = this.e;
          paramd0 = new StringBuilder(39);
          paramd0.append("Audio format not supported: ");
          paramd0.append(i);
          throw new TagPayloadReader.UnsupportedFormatException(paramd0.toString());
        }
      }
      else
      {
        if (j == 7) {
          paramd0 = "audio/g711-alaw";
        } else {
          paramd0 = "audio/g711-mlaw";
        }
        paramd0 = new Format.b().e0(paramd0).H(1).f0(8000).E();
        this.a.d(paramd0);
        this.d = true;
      }
      this.c = true;
    }
    else
    {
      paramd0.Q(1);
    }
    return true;
  }
  
  protected boolean c(d0 paramd0, long paramLong)
    throws ParserException
  {
    if (this.e == 2)
    {
      i = paramd0.a();
      this.a.c(paramd0, i);
      this.a.e(paramLong, 1, i, 0, null);
      return true;
    }
    int i = paramd0.D();
    if ((i == 0) && (!this.d))
    {
      i = paramd0.a();
      byte[] arrayOfByte = new byte[i];
      paramd0.j(arrayOfByte, 0, i);
      paramd0 = m.f(arrayOfByte);
      paramd0 = new Format.b().e0("audio/mp4a-latm").I(paramd0.c).H(paramd0.b).f0(paramd0.a).T(Collections.singletonList(arrayOfByte)).E();
      this.a.d(paramd0);
      this.d = true;
      return false;
    }
    if ((this.e == 10) && (i != 1)) {
      return false;
    }
    i = paramd0.a();
    this.a.c(paramd0, i);
    this.a.e(paramLong, 1, i, 0, null);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\extractor\flv\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */