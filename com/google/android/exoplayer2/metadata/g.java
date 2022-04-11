package com.google.android.exoplayer2.metadata;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import java.nio.ByteBuffer;

public abstract class g
  implements b
{
  @Nullable
  public final Metadata a(d paramd)
  {
    ByteBuffer localByteBuffer = (ByteBuffer)com.google.android.exoplayer2.util.g.e(paramd.f);
    boolean bool;
    if ((localByteBuffer.position() == 0) && (localByteBuffer.hasArray()) && (localByteBuffer.arrayOffset() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.a(bool);
    if (paramd.j()) {
      paramd = null;
    } else {
      paramd = b(paramd, localByteBuffer);
    }
    return paramd;
  }
  
  @Nullable
  protected abstract Metadata b(d paramd, ByteBuffer paramByteBuffer);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */