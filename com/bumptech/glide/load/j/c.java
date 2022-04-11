package com.bumptech.glide.load.j;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c
  implements com.bumptech.glide.load.a<ByteBuffer>
{
  public boolean c(@NonNull ByteBuffer paramByteBuffer, @NonNull File paramFile, @NonNull f paramf)
  {
    boolean bool;
    try
    {
      com.bumptech.glide.util.a.e(paramByteBuffer, paramFile);
      bool = true;
    }
    catch (IOException paramByteBuffer)
    {
      if (Log.isLoggable("ByteBufferEncoder", 3)) {
        Log.d("ByteBufferEncoder", "Failed to write data", paramByteBuffer);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */