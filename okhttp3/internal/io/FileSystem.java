package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public abstract interface FileSystem
{
  public static final FileSystem SYSTEM = new FileSystem()
  {
    public Sink appendingSink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        Sink localSink = Okio.appendingSink(paramAnonymousFile);
        return localSink;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return Okio.appendingSink(paramAnonymousFile);
    }
    
    public void delete(File paramAnonymousFile)
      throws IOException
    {
      if ((!paramAnonymousFile.delete()) && (paramAnonymousFile.exists()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed to delete ");
        localStringBuilder.append(paramAnonymousFile);
        throw new IOException(localStringBuilder.toString());
      }
    }
    
    public void deleteContents(File paramAnonymousFile)
      throws IOException
    {
      Object localObject = paramAnonymousFile.listFiles();
      if (localObject != null)
      {
        int i = localObject.length;
        int j = 0;
        while (j < i)
        {
          paramAnonymousFile = localObject[j];
          if (paramAnonymousFile.isDirectory()) {
            deleteContents(paramAnonymousFile);
          }
          if (paramAnonymousFile.delete())
          {
            j++;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("failed to delete ");
            ((StringBuilder)localObject).append(paramAnonymousFile);
            throw new IOException(((StringBuilder)localObject).toString());
          }
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not a readable directory: ");
      ((StringBuilder)localObject).append(paramAnonymousFile);
      throw new IOException(((StringBuilder)localObject).toString());
    }
    
    public boolean exists(File paramAnonymousFile)
    {
      return paramAnonymousFile.exists();
    }
    
    public void rename(File paramAnonymousFile1, File paramAnonymousFile2)
      throws IOException
    {
      delete(paramAnonymousFile2);
      if (paramAnonymousFile1.renameTo(paramAnonymousFile2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to rename ");
      localStringBuilder.append(paramAnonymousFile1);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramAnonymousFile2);
      throw new IOException(localStringBuilder.toString());
    }
    
    public Sink sink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        Sink localSink = Okio.sink(paramAnonymousFile);
        return localSink;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return Okio.sink(paramAnonymousFile);
    }
    
    public long size(File paramAnonymousFile)
    {
      return paramAnonymousFile.length();
    }
    
    public Source source(File paramAnonymousFile)
      throws FileNotFoundException
    {
      return Okio.source(paramAnonymousFile);
    }
  };
  
  public abstract Sink appendingSink(File paramFile)
    throws FileNotFoundException;
  
  public abstract void delete(File paramFile)
    throws IOException;
  
  public abstract void deleteContents(File paramFile)
    throws IOException;
  
  public abstract boolean exists(File paramFile);
  
  public abstract void rename(File paramFile1, File paramFile2)
    throws IOException;
  
  public abstract Sink sink(File paramFile)
    throws FileNotFoundException;
  
  public abstract long size(File paramFile);
  
  public abstract Source source(File paramFile)
    throws FileNotFoundException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\io\FileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */