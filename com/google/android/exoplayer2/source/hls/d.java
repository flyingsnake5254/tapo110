package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.m;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class d
  implements l
{
  private final l b;
  private final byte[] c;
  private final byte[] d;
  @Nullable
  private CipherInputStream e;
  
  public d(l paraml, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.b = paraml;
    this.c = paramArrayOfByte1;
    this.d = paramArrayOfByte2;
  }
  
  public final void b(a0 parama0)
  {
    g.e(parama0);
    this.b.b(parama0);
  }
  
  public void close()
    throws IOException
  {
    if (this.e != null)
    {
      this.e = null;
      this.b.close();
    }
  }
  
  public final Map<String, List<String>> d()
  {
    return this.b.d();
  }
  
  @Nullable
  public final Uri getUri()
  {
    return this.b.getUri();
  }
  
  public final long j(n paramn)
    throws IOException
  {
    try
    {
      Cipher localCipher = o();
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.c, "AES");
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.d);
      try
      {
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        paramn = new m(this.b, paramn);
        this.e = new CipherInputStream(paramn, localCipher);
        paramn.c();
        return -1L;
      }
      catch (InvalidAlgorithmParameterException paramn) {}catch (InvalidKeyException paramn) {}
      throw new RuntimeException(paramn);
    }
    catch (NoSuchPaddingException paramn) {}catch (NoSuchAlgorithmException paramn) {}
    throw new RuntimeException(paramn);
  }
  
  protected Cipher o()
    throws NoSuchPaddingException, NoSuchAlgorithmException
  {
    return Cipher.getInstance("AES/CBC/PKCS7Padding");
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    g.e(this.e);
    paramInt2 = this.e.read(paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = -1;
    }
    return paramInt1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */