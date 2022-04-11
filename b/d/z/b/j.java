package b.d.z.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

public class j
{
  public static Bitmap a(int[] paramArrayOfInt, ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    if (11 == paramInt3)
    {
      c(paramArrayOfInt, paramArrayOfByteBuffer, paramInt1, paramInt2);
      paramArrayOfByteBuffer = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramArrayOfByteBuffer.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      return paramArrayOfByteBuffer;
    }
    b(paramArrayOfInt, paramArrayOfByteBuffer, paramInt1, paramInt2);
    paramArrayOfByteBuffer = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramArrayOfByteBuffer.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    return paramArrayOfByteBuffer;
  }
  
  public static void b(int[] paramArrayOfInt, ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
  {
    for (int i = 0; i < paramInt2; i++) {
      for (int j = 0; j < paramInt1; j++)
      {
        ByteBuffer localByteBuffer = paramArrayOfByteBuffer[0];
        int k = paramInt1 * i + j;
        int m = localByteBuffer.get(k);
        localByteBuffer = paramArrayOfByteBuffer[1];
        int n = i / 4 * paramInt1 + j / 2;
        int i1 = localByteBuffer.get(n);
        n = paramArrayOfByteBuffer[2].get(n);
        double d1 = m & 0xFF;
        double d2 = (n & 0xFF) - 128;
        int i2 = (int)(1.370705D * d2 + d1);
        double d3 = (i1 & 0xFF) - 128;
        n = (int)(d1 - (d2 * 0.698001D + 0.337633D * d3));
        m = (int)(d1 + d3 * 1.732446D);
        if (m > 255)
        {
          i1 = 255;
        }
        else
        {
          i1 = m;
          if (m < 0) {
            i1 = 0;
          }
        }
        if (n > 255)
        {
          m = 255;
        }
        else
        {
          m = n;
          if (n < 0) {
            m = 0;
          }
        }
        if (i2 > 255)
        {
          n = 255;
        }
        else
        {
          n = i2;
          if (i2 < 0) {
            n = 0;
          }
        }
        paramArrayOfInt[k] = (n << 16 & 0xFF0000 | 0xFF000000 | 0xFF00 & m << 8 | 0xFF & i1);
      }
    }
  }
  
  public static void c(int[] paramArrayOfInt, ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
  {
    for (int i = 0; i < paramInt2; i++) {
      for (int j = 0; j < paramInt1; j++)
      {
        if (j % 2 == 0) {
          k = j;
        } else {
          k = j - 1;
        }
        ByteBuffer localByteBuffer = paramArrayOfByteBuffer[0];
        int m = paramInt1 * i + j;
        int n = localByteBuffer.get(m);
        localByteBuffer = paramArrayOfByteBuffer[1];
        int i1 = i / 2 * paramInt1 + k;
        int k = localByteBuffer.get(i1);
        i1 = paramArrayOfByteBuffer[1].get(i1 + 1);
        double d1 = n & 0xFF;
        double d2 = (i1 & 0xFF) - 128;
        int i2 = (int)(1.370705D * d2 + d1);
        double d3 = (k & 0xFF) - 128;
        i1 = (int)(d1 - (d2 * 0.698001D + 0.337633D * d3));
        n = (int)(d1 + d3 * 1.732446D);
        if (n > 255)
        {
          k = 255;
        }
        else
        {
          k = n;
          if (n < 0) {
            k = 0;
          }
        }
        if (i1 > 255)
        {
          n = 255;
        }
        else
        {
          n = i1;
          if (i1 < 0) {
            n = 0;
          }
        }
        if (i2 > 255)
        {
          i1 = 255;
        }
        else
        {
          i1 = i2;
          if (i2 < 0) {
            i1 = 0;
          }
        }
        paramArrayOfInt[m] = (k & 0xFF | 0xFF000000 | i1 << 16 & 0xFF0000 | n << 8 & 0xFF00);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */