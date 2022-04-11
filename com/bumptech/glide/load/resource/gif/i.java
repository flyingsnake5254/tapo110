package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class i
  implements g<InputStream, GifDrawable>
{
  private final List<ImageHeaderParser> a;
  private final g<ByteBuffer, GifDrawable> b;
  private final com.bumptech.glide.load.engine.z.b c;
  
  public i(List<ImageHeaderParser> paramList, g<ByteBuffer, GifDrawable> paramg, com.bumptech.glide.load.engine.z.b paramb)
  {
    this.a = paramList;
    this.b = paramg;
    this.c = paramb;
  }
  
  private static byte[] e(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(16384);
    try
    {
      byte[] arrayOfByte = new byte['䀀'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.flush();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramInputStream)
    {
      if (Log.isLoggable("StreamGifDecoder", 5)) {
        Log.w("StreamGifDecoder", "Error reading data from stream", paramInputStream);
      }
    }
    return null;
  }
  
  public u<GifDrawable> c(@NonNull InputStream paramInputStream, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    paramInputStream = e(paramInputStream);
    if (paramInputStream == null) {
      return null;
    }
    paramInputStream = ByteBuffer.wrap(paramInputStream);
    return this.b.b(paramInputStream, paramInt1, paramInt2, paramf);
  }
  
  public boolean d(@NonNull InputStream paramInputStream, @NonNull f paramf)
    throws IOException
  {
    boolean bool;
    if ((!((Boolean)paramf.c(h.b)).booleanValue()) && (com.bumptech.glide.load.b.e(this.a, paramInputStream, this.c) == ImageHeaderParser.ImageType.GIF)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */