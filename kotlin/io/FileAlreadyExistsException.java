package kotlin.io;

import java.io.File;

public final class FileAlreadyExistsException
  extends FileSystemException
{
  public FileAlreadyExistsException(File paramFile1, File paramFile2, String paramString)
  {
    super(paramFile1, paramFile2, paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\io\FileAlreadyExistsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */