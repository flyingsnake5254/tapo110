package kotlin.io;

import java.io.File;

public final class NoSuchFileException
  extends FileSystemException
{
  public NoSuchFileException(File paramFile1, File paramFile2, String paramString)
  {
    super(paramFile1, paramFile2, paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\io\NoSuchFileException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */