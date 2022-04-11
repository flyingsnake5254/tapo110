package com.tplink.libmediakit.jniinterface;

import androidx.annotation.NonNull;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import java.nio.ByteBuffer;

public class DecoderProperty
{
  public static final byte[] a = { 0, 0, 0, 1, 103, 77, 64, 40, -90, -128, 120, 2, 39, -27, -101, 32, 0, 0, 3, 0, 32, 0, 0, 3, 3, -48, -128 };
  public static final byte[] b = { 0, 0, 0, 0, 0, 0, 0, 0 };
  
  static
  {
    System.loadLibrary("native-utils-lib");
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, ByteBuffer paramByteBuffer, @NonNull YUVBuffer paramYUVBuffer)
  {
    return initYuvBufferNative(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong, paramByteBuffer, paramYUVBuffer);
  }
  
  private static native int initYuvBufferNative(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, ByteBuffer paramByteBuffer, @NonNull YUVBuffer paramYUVBuffer);
  
  private native int[] parseH264Resolution(byte[] paramArrayOfByte, int paramInt);
  
  public void a(byte[] paramArrayOfByte, a parama)
  {
    paramArrayOfByte = parseH264Resolution(paramArrayOfByte, paramArrayOfByte.length);
    parama.d(paramArrayOfByte[0]);
    parama.c(paramArrayOfByte[1]);
  }
  
  public static class a
  {
    private int a;
    private int b;
    
    public int a()
    {
      return this.b;
    }
    
    public int b()
    {
      return this.a;
    }
    
    public void c(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void d(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\jniinterface\DecoderProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */