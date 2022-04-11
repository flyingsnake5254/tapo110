package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.z.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface ImageHeaderParser
{
  @NonNull
  public abstract ImageType a(@NonNull ByteBuffer paramByteBuffer)
    throws IOException;
  
  @NonNull
  public abstract ImageType b(@NonNull InputStream paramInputStream)
    throws IOException;
  
  public abstract int c(@NonNull InputStream paramInputStream, @NonNull b paramb)
    throws IOException;
  
  public static enum ImageType
  {
    private final boolean hasAlpha;
    
    static
    {
      ImageType localImageType1 = new ImageType("GIF", 0, true);
      GIF = localImageType1;
      ImageType localImageType2 = new ImageType("JPEG", 1, false);
      JPEG = localImageType2;
      ImageType localImageType3 = new ImageType("RAW", 2, false);
      RAW = localImageType3;
      ImageType localImageType4 = new ImageType("PNG_A", 3, true);
      PNG_A = localImageType4;
      ImageType localImageType5 = new ImageType("PNG", 4, false);
      PNG = localImageType5;
      ImageType localImageType6 = new ImageType("WEBP_A", 5, true);
      WEBP_A = localImageType6;
      ImageType localImageType7 = new ImageType("WEBP", 6, false);
      WEBP = localImageType7;
      ImageType localImageType8 = new ImageType("UNKNOWN", 7, false);
      UNKNOWN = localImageType8;
      $VALUES = new ImageType[] { localImageType1, localImageType2, localImageType3, localImageType4, localImageType5, localImageType6, localImageType7, localImageType8 };
    }
    
    private ImageType(boolean paramBoolean)
    {
      this.hasAlpha = paramBoolean;
    }
    
    public boolean hasAlpha()
    {
      return this.hasAlpha;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\ImageHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */