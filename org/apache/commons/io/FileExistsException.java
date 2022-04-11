package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class FileExistsException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public FileExistsException() {}
  
  public FileExistsException(File paramFile)
  {
    super(localStringBuilder.toString());
  }
  
  public FileExistsException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\FileExistsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */