package kotlin.io;

import java.io.File;
import java.io.IOException;

public class FileSystemException
  extends IOException
{
  private final File file;
  private final File other;
  private final String reason;
  
  public FileSystemException(File paramFile1, File paramFile2, String paramString)
  {
    super(b.a(paramFile1, paramFile2, paramString));
    this.file = paramFile1;
    this.other = paramFile2;
    this.reason = paramString;
  }
  
  public final File getFile()
  {
    return this.file;
  }
  
  public final File getOther()
  {
    return this.other;
  }
  
  public final String getReason()
  {
    return this.reason;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\io\FileSystemException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */