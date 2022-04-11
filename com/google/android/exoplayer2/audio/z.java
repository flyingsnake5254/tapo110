package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;

final class z
  extends y
{
  @Nullable
  private int[] i;
  @Nullable
  private int[] j;
  
  public void b(ByteBuffer paramByteBuffer)
  {
    int[] arrayOfInt = (int[])g.e(this.j);
    int k = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    ByteBuffer localByteBuffer = k((m - k) / this.b.e * this.c.e);
    while (k < m)
    {
      int n = arrayOfInt.length;
      for (int i1 = 0; i1 < n; i1++) {
        localByteBuffer.putShort(paramByteBuffer.getShort(arrayOfInt[i1] * 2 + k));
      }
      k += this.b.e;
    }
    paramByteBuffer.position(m);
    localByteBuffer.flip();
  }
  
  public AudioProcessor.a g(AudioProcessor.a parama)
    throws AudioProcessor.UnhandledAudioFormatException
  {
    int[] arrayOfInt = this.i;
    if (arrayOfInt == null) {
      return AudioProcessor.a.a;
    }
    if (parama.d == 2)
    {
      int k;
      if (parama.c != arrayOfInt.length) {
        k = 1;
      } else {
        k = 0;
      }
      int m = 0;
      while (m < arrayOfInt.length)
      {
        int n = arrayOfInt[m];
        if (n < parama.c)
        {
          if (n != m) {
            n = 1;
          } else {
            n = 0;
          }
          k |= n;
          m++;
        }
        else
        {
          throw new AudioProcessor.UnhandledAudioFormatException(parama);
        }
      }
      if (k != 0) {
        parama = new AudioProcessor.a(parama.b, arrayOfInt.length, 2);
      } else {
        parama = AudioProcessor.a.a;
      }
      return parama;
    }
    throw new AudioProcessor.UnhandledAudioFormatException(parama);
  }
  
  protected void h()
  {
    this.j = this.i;
  }
  
  protected void j()
  {
    this.j = null;
    this.i = null;
  }
  
  public void l(@Nullable int[] paramArrayOfInt)
  {
    this.i = paramArrayOfInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */