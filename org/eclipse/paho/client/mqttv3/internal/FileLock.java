package org.eclipse.paho.client.mqttv3.internal;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;

public class FileLock
{
  private RandomAccessFile file;
  private Object fileLock;
  private File lockFile;
  
  public FileLock(File paramFile, String paramString)
    throws Exception
  {
    this.lockFile = new File(paramFile, paramString);
    if (ExceptionHelper.isClassAvailable("java.nio.channels.FileLock"))
    {
      try
      {
        paramFile = new java/io/RandomAccessFile;
        paramFile.<init>(this.lockFile, "rw");
        this.file = paramFile;
        paramFile = paramFile.getClass().getMethod("getChannel", new Class[0]).invoke(this.file, new Object[0]);
        this.fileLock = paramFile.getClass().getMethod("tryLock", new Class[0]).invoke(paramFile, new Object[0]);
      }
      catch (IllegalAccessException paramFile)
      {
        this.fileLock = null;
      }
      catch (IllegalArgumentException paramFile)
      {
        this.fileLock = null;
      }
      catch (NoSuchMethodException paramFile)
      {
        this.fileLock = null;
      }
      if (this.fileLock == null)
      {
        release();
        throw new Exception("Problem obtaining file lock");
      }
    }
  }
  
  public void release()
  {
    try
    {
      Object localObject1 = this.fileLock;
      if (localObject1 != null)
      {
        localObject1.getClass().getMethod("release", new Class[0]).invoke(this.fileLock, new Object[0]);
        this.fileLock = null;
      }
    }
    catch (Exception localException) {}
    Object localObject2 = this.file;
    if (localObject2 != null) {}
    try
    {
      ((RandomAccessFile)localObject2).close();
      this.file = null;
      localObject2 = this.lockFile;
      if ((localObject2 != null) && (((File)localObject2).exists())) {
        this.lockFile.delete();
      }
      this.lockFile = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\FileLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */