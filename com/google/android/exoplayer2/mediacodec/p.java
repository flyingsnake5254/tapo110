package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.e0;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;

final class p
{
  private long a;
  private long b;
  private boolean c;
  
  private long a(Format paramFormat)
  {
    return this.a * 1000000L / paramFormat.V3;
  }
  
  public void b()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = false;
  }
  
  public long c(Format paramFormat, DecoderInputBuffer paramDecoderInputBuffer)
  {
    if (this.c) {
      return paramDecoderInputBuffer.x;
    }
    ByteBuffer localByteBuffer = (ByteBuffer)g.e(paramDecoderInputBuffer.f);
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = j << 8 | localByteBuffer.get(i) & 0xFF;
      i++;
    }
    i = e0.m(j);
    if (i == -1)
    {
      this.c = true;
      u.h("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
      return paramDecoderInputBuffer.x;
    }
    if (this.a == 0L)
    {
      l = paramDecoderInputBuffer.x;
      this.b = l;
      this.a = (i - 529L);
      return l;
    }
    long l = a(paramFormat);
    this.a += i;
    return this.b + l;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */