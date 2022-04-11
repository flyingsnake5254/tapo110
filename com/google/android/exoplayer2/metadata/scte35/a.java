package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import java.nio.ByteBuffer;

public final class a
  extends g
{
  private final d0 a = new d0();
  private final c0 b = new c0();
  private l0 c;
  
  protected Metadata b(d paramd, ByteBuffer paramByteBuffer)
  {
    l0 locall0 = this.c;
    if ((locall0 == null) || (paramd.p1 != locall0.e()))
    {
      locall0 = new l0(paramd.x);
      this.c = locall0;
      locall0.a(paramd.x - paramd.p1);
    }
    paramd = paramByteBuffer.array();
    int i = paramByteBuffer.limit();
    this.a.N(paramd, i);
    this.b.o(paramd, i);
    this.b.r(39);
    long l = this.b.h(1) << 32 | this.b.h(32);
    this.b.r(20);
    int j = this.b.h(12);
    i = this.b.h(8);
    paramd = null;
    this.a.Q(14);
    if (i != 0)
    {
      if (i != 255)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i == 6) {
              paramd = TimeSignalCommand.a(this.a, l, this.c);
            }
          }
          else {
            paramd = SpliceInsertCommand.a(this.a, l, this.c);
          }
        }
        else {
          paramd = SpliceScheduleCommand.a(this.a);
        }
      }
      else {
        paramd = PrivateCommand.a(this.a, j, l);
      }
    }
    else {
      paramd = new SpliceNullCommand();
    }
    if (paramd == null) {
      paramd = new Metadata(new Metadata.Entry[0]);
    } else {
      paramd = new Metadata(new Metadata.Entry[] { paramd });
    }
    return paramd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\scte35\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */