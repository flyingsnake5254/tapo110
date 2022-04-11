package com.google.mlkit.vision.common.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image.Plane;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.b.a.a.a.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;

@KeepForSdk
public class c
{
  private static final c a = new c();
  
  @KeepForSdk
  public static c d()
  {
    return a;
  }
  
  private static Bitmap e(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return Bitmap.createBitmap(paramBitmap, 0, 0, paramInt2, paramInt3);
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt1);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramInt2, paramInt3, localMatrix, true);
  }
  
  private final Bitmap f(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    paramByteBuffer = j(a(paramByteBuffer), paramInt1, paramInt2);
    return e(BitmapFactory.decodeByteArray(paramByteBuffer, 0, paramByteBuffer.length), paramInt3, paramInt1, paramInt2);
  }
  
  @VisibleForTesting
  private static ByteBuffer g(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    paramByteBuffer.rewind();
    int i = paramByteBuffer.limit();
    int j = i / 6;
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = ByteBuffer.allocate(i);
    } else {
      localByteBuffer = ByteBuffer.allocateDirect(i);
    }
    int k = 0;
    int n;
    for (int m = 0;; m++)
    {
      n = j << 2;
      i = k;
      if (m >= n) {
        break;
      }
      localByteBuffer.put(m, paramByteBuffer.get(m));
    }
    while (i < j << 1)
    {
      localByteBuffer.put(n + i, paramByteBuffer.get(i % 2 * j + n + i / 2));
      i++;
    }
    return localByteBuffer;
  }
  
  @RequiresApi(19)
  @VisibleForTesting
  private static ByteBuffer h(Image.Plane[] paramArrayOfPlane, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    byte[] arrayOfByte = new byte[i / 4 * 2 + i];
    ByteBuffer localByteBuffer1 = paramArrayOfPlane[1].getBuffer();
    ByteBuffer localByteBuffer2 = paramArrayOfPlane[2].getBuffer();
    int j = localByteBuffer2.position();
    int k = localByteBuffer1.limit();
    localByteBuffer2.position(j + 1);
    localByteBuffer1.limit(k - 1);
    int m = localByteBuffer2.remaining();
    int n = i * 2 / 4;
    if ((m == n - 2) && (localByteBuffer2.compareTo(localByteBuffer1) == 0)) {
      m = 1;
    } else {
      m = 0;
    }
    localByteBuffer2.position(j);
    localByteBuffer1.limit(k);
    if (m != 0)
    {
      paramArrayOfPlane[0].getBuffer().get(arrayOfByte, 0, i);
      localByteBuffer2 = paramArrayOfPlane[1].getBuffer();
      paramArrayOfPlane[2].getBuffer().get(arrayOfByte, i, 1);
      localByteBuffer2.get(arrayOfByte, i + 1, n - 1);
    }
    else
    {
      i(paramArrayOfPlane[0], paramInt1, paramInt2, arrayOfByte, 0, 1);
      i(paramArrayOfPlane[1], paramInt1, paramInt2, arrayOfByte, i + 1, 2);
      i(paramArrayOfPlane[2], paramInt1, paramInt2, arrayOfByte, i, 2);
    }
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  @TargetApi(19)
  private static void i(Image.Plane paramPlane, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    ByteBuffer localByteBuffer = paramPlane.getBuffer();
    localByteBuffer.rewind();
    int i = (localByteBuffer.limit() + paramPlane.getRowStride() - 1) / paramPlane.getRowStride();
    if (i == 0) {
      return;
    }
    int j = paramInt1 / (paramInt2 / i);
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt2 < i)
    {
      int k = paramInt1;
      for (int m = 0; m < j; m++)
      {
        paramArrayOfByte[paramInt3] = localByteBuffer.get(k);
        paramInt3 += paramInt4;
        k += paramPlane.getPixelStride();
      }
      paramInt1 += paramPlane.getRowStride();
      paramInt2++;
    }
  }
  
  /* Error */
  private static byte[] j(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 131	android/graphics/YuvImage
    //   3: dup
    //   4: aload_0
    //   5: bipush 17
    //   7: iload_1
    //   8: iload_2
    //   9: aconst_null
    //   10: invokespecial 134	android/graphics/YuvImage:<init>	([BIII[I)V
    //   13: astore_0
    //   14: new 136	java/io/ByteArrayOutputStream
    //   17: astore_3
    //   18: aload_3
    //   19: invokespecial 137	java/io/ByteArrayOutputStream:<init>	()V
    //   22: new 139	android/graphics/Rect
    //   25: astore 4
    //   27: aload 4
    //   29: iconst_0
    //   30: iconst_0
    //   31: iload_1
    //   32: iload_2
    //   33: invokespecial 142	android/graphics/Rect:<init>	(IIII)V
    //   36: aload_0
    //   37: aload 4
    //   39: bipush 100
    //   41: aload_3
    //   42: invokevirtual 146	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 150	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   50: astore_0
    //   51: aload_3
    //   52: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   55: goto +30 -> 85
    //   58: astore_0
    //   59: aload_3
    //   60: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   63: goto +9 -> 72
    //   66: astore_3
    //   67: aload_0
    //   68: aload_3
    //   69: invokestatic 159	com/google/android/gms/internal/mlkit_vision_common/zzn:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_0
    //   77: ldc -95
    //   79: ldc -93
    //   81: invokestatic 169	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: aload_0
    //   86: areturn
    //   87: astore_3
    //   88: goto -11 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramArrayOfByte	byte[]
    //   0	91	1	paramInt1	int
    //   0	91	2	paramInt2	int
    //   17	43	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   66	3	3	localThrowable	Throwable
    //   87	1	3	localIOException	java.io.IOException
    //   25	13	4	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   22	51	58	finally
    //   59	63	66	finally
    //   14	22	74	java/io/IOException
    //   67	72	74	java/io/IOException
    //   72	74	74	java/io/IOException
    //   51	55	87	java/io/IOException
  }
  
  @KeepForSdk
  public byte[] a(@NonNull ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer.hasArray()) && (paramByteBuffer.arrayOffset() == 0)) {
      return paramByteBuffer.array();
    }
    paramByteBuffer.rewind();
    int i = paramByteBuffer.limit();
    byte[] arrayOfByte = new byte[i];
    paramByteBuffer.get(arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  @NonNull
  @KeepForSdk
  public ByteBuffer b(@NonNull a parama, boolean paramBoolean)
    throws MlKitException
  {
    int i = parama.d();
    if (i != -1)
    {
      if (i != 17)
      {
        if (i != 35)
        {
          if (i == 842094169) {
            return g(parama.c(), paramBoolean);
          }
          throw new MlKitException("Unsupported image format", 13);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          return h(parama.f(), parama.h(), parama.e());
        }
        throw new MlKitException("Unsupported image format", 13);
      }
      if (paramBoolean)
      {
        localObject = parama.c();
        if (((ByteBuffer)localObject).hasArray()) {
          return (ByteBuffer)localObject;
        }
        ((ByteBuffer)localObject).rewind();
        parama = new byte[((ByteBuffer)localObject).limit()];
        ((ByteBuffer)localObject).get(parama);
        return ByteBuffer.wrap(parama);
      }
      return parama.c();
    }
    parama = parama.b();
    int j = parama.getWidth();
    int k = parama.getHeight();
    int m = j * k;
    Object localObject = new int[m];
    parama.getPixels((int[])localObject, 0, j, 0, 0, j, k);
    i = (int)Math.ceil(k / 2.0D) * 2 * (int)Math.ceil(j / 2.0D) + m;
    if (paramBoolean) {
      parama = ByteBuffer.allocate(i);
    } else {
      parama = ByteBuffer.allocateDirect(i);
    }
    i = 0;
    int n = 0;
    int i1 = 0;
    while (i < k)
    {
      int i2 = 0;
      while (i2 < j)
      {
        int i3 = localObject[n] >> 16 & 0xFF;
        int i4 = localObject[n] >> 8 & 0xFF;
        int i5 = localObject[n] & 0xFF;
        int i6 = (i3 * 66 + i4 * 129 + i5 * 25 + 128 >> 8) + 16;
        int i7 = (i3 * -38 - i4 * 74 + i5 * 112 + 128 >> 8) + 128;
        i5 = (i3 * 112 - i4 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i6 < 0) {
          i6 = 0;
        } else {
          i6 = Math.min(255, i6);
        }
        parama.put(i1, (byte)i6);
        i6 = m;
        if (i % 2 == 0)
        {
          i6 = m;
          if (n % 2 == 0)
          {
            i4 = m + 1;
            if (i5 < 0) {
              i6 = 0;
            } else {
              i6 = Math.min(255, i5);
            }
            parama.put(m, (byte)i6);
            i6 = i4 + 1;
            if (i7 < 0) {
              m = 0;
            } else {
              m = Math.min(255, i7);
            }
            parama.put(i4, (byte)m);
          }
        }
        n++;
        i2++;
        i1++;
        m = i6;
      }
      i++;
    }
    return parama;
  }
  
  @NonNull
  @KeepForSdk
  public Bitmap c(@NonNull a parama)
    throws MlKitException
  {
    int i = parama.d();
    if (i != -1)
    {
      if (i != 17)
      {
        if (i != 35)
        {
          if (i == 842094169)
          {
            ByteBuffer localByteBuffer = parama.c();
            int j = parama.h();
            int k = parama.e();
            i = parama.g();
            parama = j(g(localByteBuffer, true).array(), j, k);
            return e(BitmapFactory.decodeByteArray(parama, 0, parama.length), i, j, k);
          }
          throw new MlKitException("Unsupported image format", 13);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          return f(h(parama.f(), parama.h(), parama.e()), parama.h(), parama.e(), parama.g());
        }
        throw new MlKitException("Unsupported image format", 13);
      }
      return f(parama.c(), parama.h(), parama.e(), parama.g());
    }
    return e(parama.b(), parama.g(), parama.h(), parama.e());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */