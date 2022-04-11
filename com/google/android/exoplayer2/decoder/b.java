package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class b
{
  @Nullable
  public byte[] a;
  @Nullable
  public byte[] b;
  public int c;
  @Nullable
  public int[] d;
  @Nullable
  public int[] e;
  public int f;
  public int g;
  public int h;
  private final MediaCodec.CryptoInfo i;
  @Nullable
  private final b j;
  
  public b()
  {
    MediaCodec.CryptoInfo localCryptoInfo = new MediaCodec.CryptoInfo();
    this.i = localCryptoInfo;
    int k = o0.a;
    b localb = null;
    if (k >= 24) {
      localb = new b(localCryptoInfo, null);
    }
    this.j = localb;
  }
  
  public MediaCodec.CryptoInfo a()
  {
    return this.i;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (this.d == null)
    {
      arrayOfInt = new int[1];
      this.d = arrayOfInt;
      this.i.numBytesOfClearData = arrayOfInt;
    }
    int[] arrayOfInt = this.d;
    arrayOfInt[0] += paramInt;
  }
  
  public void c(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = paramInt1;
    this.d = paramArrayOfInt1;
    this.e = paramArrayOfInt2;
    this.b = paramArrayOfByte1;
    this.a = paramArrayOfByte2;
    this.c = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    MediaCodec.CryptoInfo localCryptoInfo = this.i;
    localCryptoInfo.numSubSamples = paramInt1;
    localCryptoInfo.numBytesOfClearData = paramArrayOfInt1;
    localCryptoInfo.numBytesOfEncryptedData = paramArrayOfInt2;
    localCryptoInfo.key = paramArrayOfByte1;
    localCryptoInfo.iv = paramArrayOfByte2;
    localCryptoInfo.mode = paramInt2;
    if (o0.a >= 24) {
      b.a((b)g.e(this.j), paramInt3, paramInt4);
    }
  }
  
  @RequiresApi(24)
  private static final class b
  {
    private final MediaCodec.CryptoInfo a;
    private final MediaCodec.CryptoInfo.Pattern b;
    
    private b(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      this.a = paramCryptoInfo;
      this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }
    
    private void b(int paramInt1, int paramInt2)
    {
      this.b.set(paramInt1, paramInt2);
      this.a.setPattern(this.b);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\decoder\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */