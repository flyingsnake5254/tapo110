package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.e;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

public final class j
  extends h
{
  @Nullable
  private n f;
  @Nullable
  private byte[] g;
  private int h;
  private int i;
  
  public j()
  {
    super(false);
  }
  
  public void close()
  {
    if (this.g != null)
    {
      this.g = null;
      p();
    }
    this.f = null;
  }
  
  @Nullable
  public Uri getUri()
  {
    Object localObject = this.f;
    if (localObject != null) {
      localObject = ((n)localObject).a;
    } else {
      localObject = null;
    }
    return (Uri)localObject;
  }
  
  public long j(n paramn)
    throws IOException
  {
    q(paramn);
    this.f = paramn;
    Uri localUri = paramn.a;
    Object localObject1 = localUri.getScheme();
    boolean bool = "data".equals(localObject1);
    localObject1 = String.valueOf(localObject1);
    if (((String)localObject1).length() != 0) {
      localObject1 = "Unsupported scheme: ".concat((String)localObject1);
    } else {
      localObject1 = new String("Unsupported scheme: ");
    }
    g.b(bool, localObject1);
    localObject1 = o0.E0(localUri.getSchemeSpecificPart(), ",");
    if (localObject1.length == 2)
    {
      localUri = localObject1[1];
      if (localObject1[0].contains(";base64")) {
        try
        {
          this.g = Base64.decode(localUri, 0);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          paramn = String.valueOf(localUri);
          if (paramn.length() != 0) {
            paramn = "Error while parsing Base64 encoded string: ".concat(paramn);
          } else {
            paramn = new String("Error while parsing Base64 encoded string: ");
          }
          throw ParserException.createForMalformedDataOfUnknownType(paramn, localIllegalArgumentException);
        }
      } else {
        this.g = o0.e0(URLDecoder.decode(localUri, e.a.name()));
      }
      long l = paramn.g;
      localObject2 = this.g;
      if (l <= localObject2.length)
      {
        int j = (int)l;
        this.h = j;
        j = localObject2.length - j;
        this.i = j;
        l = paramn.h;
        if (l != -1L) {
          this.i = ((int)Math.min(j, l));
        }
        r(paramn);
        l = paramn.h;
        if (l == -1L) {
          l = this.i;
        }
        return l;
      }
      this.g = null;
      throw new DataSourceException(2008);
    }
    paramn = String.valueOf(localUri);
    Object localObject2 = new StringBuilder(paramn.length() + 23);
    ((StringBuilder)localObject2).append("Unexpected URI format: ");
    ((StringBuilder)localObject2).append(paramn);
    throw ParserException.createForMalformedDataOfUnknownType(((StringBuilder)localObject2).toString(), null);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    int j = this.i;
    if (j == 0) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, j);
    System.arraycopy(o0.i(this.g), this.h, paramArrayOfByte, paramInt1, paramInt2);
    this.h += paramInt2;
    this.i -= paramInt2;
    o(paramInt2);
    return paramInt2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */