package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

final class p
  implements n0
{
  private final int a;
  private final q b;
  private int c;
  
  public p(q paramq, int paramInt)
  {
    this.b = paramq;
    this.a = paramInt;
    this.c = -1;
  }
  
  private boolean e()
  {
    int i = this.c;
    boolean bool;
    if ((i != -1) && (i != -3) && (i != -2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void a()
    throws IOException
  {
    int i = this.c;
    if (i != -2)
    {
      if (i == -1) {
        this.b.T();
      } else if (i != -3) {
        this.b.U(i);
      }
      return;
    }
    throw new SampleQueueMappingException(this.b.s().a(this.a).a(0).H3);
  }
  
  public int b(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt)
  {
    int i = this.c;
    int j = -3;
    if (i == -3)
    {
      paramDecoderInputBuffer.e(4);
      return -4;
    }
    if (e()) {
      j = this.b.d0(this.c, parami1, paramDecoderInputBuffer, paramInt);
    }
    return j;
  }
  
  public int c(long paramLong)
  {
    int i;
    if (e()) {
      i = this.b.n0(this.c, paramLong);
    } else {
      i = 0;
    }
    return i;
  }
  
  public void d()
  {
    boolean bool;
    if (this.c == -1) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.c = this.b.w(this.a);
  }
  
  public void f()
  {
    if (this.c != -1)
    {
      this.b.o0(this.a);
      this.c = -1;
    }
  }
  
  public boolean g()
  {
    boolean bool;
    if ((this.c != -3) && ((!e()) || (!this.b.O(this.c)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */