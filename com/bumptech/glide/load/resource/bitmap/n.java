package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.z.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(27)
public final class n
  implements ImageHeaderParser
{
  @NonNull
  public ImageHeaderParser.ImageType a(@NonNull ByteBuffer paramByteBuffer)
  {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  @NonNull
  public ImageHeaderParser.ImageType b(@NonNull InputStream paramInputStream)
  {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  public int c(@NonNull InputStream paramInputStream, @NonNull b paramb)
    throws IOException
  {
    int i = new ExifInterface(paramInputStream).getAttributeInt("Orientation", 1);
    int j = i;
    if (i == 0) {
      j = -1;
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */