package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FileUtil
{
  @SuppressLint({"LambdaLast"})
  public static void copy(@NonNull ReadableByteChannel paramReadableByteChannel, @NonNull FileChannel paramFileChannel)
    throws IOException
  {
    try
    {
      if (Build.VERSION.SDK_INT > 23)
      {
        paramFileChannel.transferFrom(paramReadableByteChannel, 0L, Long.MAX_VALUE);
      }
      else
      {
        InputStream localInputStream = Channels.newInputStream(paramReadableByteChannel);
        OutputStream localOutputStream = Channels.newOutputStream(paramFileChannel);
        byte[] arrayOfByte = new byte['က'];
        for (;;)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localOutputStream.write(arrayOfByte, 0, i);
        }
      }
      paramFileChannel.force(false);
      return;
    }
    finally
    {
      paramReadableByteChannel.close();
      paramFileChannel.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\util\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */