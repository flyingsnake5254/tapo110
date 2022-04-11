package b.d.e0.h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public final class g
  extends f
{
  private final byte[] c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  
  public g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt5, paramInt6);
    if ((paramInt5 + paramInt3 <= paramInt1) && (paramInt6 + paramInt4 <= paramInt2))
    {
      this.c = paramArrayOfByte;
      this.d = paramInt1;
      this.e = paramInt2;
      this.f = paramInt3;
      this.g = paramInt4;
      return;
    }
    throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
  }
  
  public byte[] b(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt >= 0) && (paramInt < a()))
    {
      int i = c();
      byte[] arrayOfByte;
      if (paramArrayOfByte != null)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte.length >= i) {}
      }
      else
      {
        arrayOfByte = new byte[i];
      }
      int j = this.g;
      int k = this.d;
      int m = this.f;
      System.arraycopy(this.c, (paramInt + j) * k + m, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Requested row is outside the image: ");
    paramArrayOfByte.append(paramInt);
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public Bitmap d()
  {
    int i = c();
    int j = a();
    int[] arrayOfInt = new int[i * j];
    Object localObject = this.c;
    int k = this.g * this.d + this.f;
    for (int m = 0; m < j; m++)
    {
      for (int n = 0; n < i; n++) {
        arrayOfInt[(m * i + n)] = ((localObject[(k + n)] & 0xFF) * 65793 | 0xFF000000);
      }
      k += this.d;
    }
    localObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return (Bitmap)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */