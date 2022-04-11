package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
  extends com.google.android.exoplayer2.metadata.g
{
  protected Metadata b(d paramd, ByteBuffer paramByteBuffer)
  {
    return new Metadata(new Metadata.Entry[] { c(new d0(paramByteBuffer.array(), paramByteBuffer.limit())) });
  }
  
  public EventMessage c(d0 paramd0)
  {
    return new EventMessage((String)com.google.android.exoplayer2.util.g.e(paramd0.x()), (String)com.google.android.exoplayer2.util.g.e(paramd0.x()), paramd0.w(), paramd0.w(), Arrays.copyOfRange(paramd0.d(), paramd0.e(), paramd0.f()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\emsg\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */