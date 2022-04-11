package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;

final class c0
  extends y
{
  private static final int i = Float.floatToIntBits(NaN.0F);
  
  private static void l(int paramInt, ByteBuffer paramByteBuffer)
  {
    int j = Float.floatToIntBits((float)(paramInt * 4.656612875245797E-10D));
    paramInt = j;
    if (j == i) {
      paramInt = Float.floatToIntBits(0.0F);
    }
    paramByteBuffer.putInt(paramInt);
  }
  
  public void b(ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int m = k - j;
    int n = this.b.d;
    ByteBuffer localByteBuffer2;
    if (n != 536870912)
    {
      if (n == 805306368)
      {
        localByteBuffer1 = k(m);
        for (;;)
        {
          localByteBuffer2 = localByteBuffer1;
          if (j >= k) {
            break;
          }
          l(paramByteBuffer.get(j) & 0xFF | (paramByteBuffer.get(j + 1) & 0xFF) << 8 | (paramByteBuffer.get(j + 2) & 0xFF) << 16 | (paramByteBuffer.get(j + 3) & 0xFF) << 24, localByteBuffer1);
          j += 4;
        }
      }
      throw new IllegalStateException();
    }
    ByteBuffer localByteBuffer1 = k(m / 3 * 4);
    for (;;)
    {
      localByteBuffer2 = localByteBuffer1;
      if (j >= k) {
        break;
      }
      l((paramByteBuffer.get(j) & 0xFF) << 8 | (paramByteBuffer.get(j + 1) & 0xFF) << 16 | (paramByteBuffer.get(j + 2) & 0xFF) << 24, localByteBuffer1);
      j += 3;
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    localByteBuffer2.flip();
  }
  
  public AudioProcessor.a g(AudioProcessor.a parama)
    throws AudioProcessor.UnhandledAudioFormatException
  {
    int j = parama.d;
    if (o0.j0(j))
    {
      if (j != 4) {
        parama = new AudioProcessor.a(parama.b, parama.c, 4);
      } else {
        parama = AudioProcessor.a.a;
      }
      return parama;
    }
    throw new AudioProcessor.UnhandledAudioFormatException(parama);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */