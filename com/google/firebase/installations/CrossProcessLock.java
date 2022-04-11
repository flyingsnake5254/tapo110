package com.google.firebase.installations;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

class CrossProcessLock
{
  private static final String TAG = "CrossProcessLock";
  private final FileChannel channel;
  private final FileLock lock;
  
  private CrossProcessLock(FileChannel paramFileChannel, FileLock paramFileLock)
  {
    this.channel = paramFileChannel;
    this.lock = paramFileLock;
  }
  
  static CrossProcessLock acquire(Context paramContext, String paramString)
  {
    try
    {
      localObject = new java/io/File;
      ((File)localObject).<init>(paramContext.getFilesDir(), paramString);
      paramContext = new java/io/RandomAccessFile;
      paramContext.<init>((File)localObject, "rw");
      localObject = paramContext.getChannel();
      try
      {
        paramString = ((FileChannel)localObject).lock();
        try
        {
          paramContext = new CrossProcessLock((FileChannel)localObject, paramString);
          return paramContext;
        }
        catch (OverlappingFileLockException paramContext) {}catch (Error paramContext) {}catch (IOException paramContext) {}
        paramString = null;
      }
      catch (OverlappingFileLockException paramContext) {}catch (Error paramContext) {}catch (IOException paramContext) {}
    }
    catch (OverlappingFileLockException paramContext) {}catch (Error paramContext) {}catch (IOException paramContext) {}
    Object localObject = null;
    paramString = (String)localObject;
    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", paramContext);
    if (paramString != null) {
      try
      {
        paramString.release();
      }
      catch (IOException paramContext) {}
    }
    if (localObject != null) {}
    try
    {
      ((FileChannel)localObject).close();
      return null;
    }
    catch (IOException paramContext)
    {
      for (;;) {}
    }
  }
  
  void releaseAndClose()
  {
    try
    {
      this.lock.release();
      this.channel.close();
    }
    catch (IOException localIOException)
    {
      Log.e("CrossProcessLock", "encountered error while releasing, ignoring", localIOException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\CrossProcessLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */