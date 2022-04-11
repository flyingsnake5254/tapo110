package com.google.android.exoplayer2.util;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

public final class x
{
  public static void a(MediaFormat paramMediaFormat, String paramString, @Nullable byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      paramMediaFormat.setByteBuffer(paramString, ByteBuffer.wrap(paramArrayOfByte));
    }
  }
  
  public static void b(MediaFormat paramMediaFormat, @Nullable ColorInfo paramColorInfo)
  {
    if (paramColorInfo != null)
    {
      d(paramMediaFormat, "color-transfer", paramColorInfo.f);
      d(paramMediaFormat, "color-standard", paramColorInfo.c);
      d(paramMediaFormat, "color-range", paramColorInfo.d);
      a(paramMediaFormat, "hdr-static-info", paramColorInfo.q);
    }
  }
  
  public static void c(MediaFormat paramMediaFormat, String paramString, float paramFloat)
  {
    if (paramFloat != -1.0F) {
      paramMediaFormat.setFloat(paramString, paramFloat);
    }
  }
  
  public static void d(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
  }
  
  public static void e(MediaFormat paramMediaFormat, List<byte[]> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      StringBuilder localStringBuilder = new StringBuilder(15);
      localStringBuilder.append("csd-");
      localStringBuilder.append(i);
      paramMediaFormat.setByteBuffer(localStringBuilder.toString(), ByteBuffer.wrap((byte[])paramList.get(i)));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */