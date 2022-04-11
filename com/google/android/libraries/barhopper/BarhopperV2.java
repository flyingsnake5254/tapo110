package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

public class BarhopperV2
  implements Closeable
{
  private static final String c = BarhopperV2.class.getSimpleName();
  private long d;
  
  public BarhopperV2()
  {
    System.loadLibrary("barhopper_v2");
  }
  
  private native void closeNative(long paramLong);
  
  private native long createNative();
  
  private native Barcode[] recognizeBitmapNative(long paramLong, Bitmap paramBitmap, RecognitionOptions paramRecognitionOptions);
  
  private native Barcode[] recognizeBufferNative(long paramLong, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, RecognitionOptions paramRecognitionOptions);
  
  private native Barcode[] recognizeNative(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, RecognitionOptions paramRecognitionOptions);
  
  public void a()
  {
    if (this.d != 0L)
    {
      Log.w(c, "Native context already exists.");
      return;
    }
    long l = createNative();
    this.d = l;
    if (l != 0L) {
      return;
    }
    throw new RuntimeException("Failed to create native context.");
  }
  
  public Barcode[] c(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, RecognitionOptions paramRecognitionOptions)
  {
    long l = this.d;
    if (l != 0L) {
      return recognizeBufferNative(l, paramInt1, paramInt2, paramByteBuffer, paramRecognitionOptions);
    }
    throw new RuntimeException("Native context does not exist.");
  }
  
  public void close()
  {
    long l = this.d;
    if (l != 0L)
    {
      closeNative(l);
      this.d = 0L;
    }
  }
  
  public Barcode[] e(int paramInt1, int paramInt2, byte[] paramArrayOfByte, RecognitionOptions paramRecognitionOptions)
  {
    long l = this.d;
    if (l != 0L) {
      return recognizeNative(l, paramInt1, paramInt2, paramArrayOfByte, paramRecognitionOptions);
    }
    throw new RuntimeException("Native context does not exist.");
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public Barcode[] g(Bitmap paramBitmap, RecognitionOptions paramRecognitionOptions)
  {
    long l = this.d;
    if (l != 0L) {
      return recognizeBitmapNative(l, paramBitmap, paramRecognitionOptions);
    }
    throw new RuntimeException("Native context does not exist.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\libraries\barhopper\BarhopperV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */