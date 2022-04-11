package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class DirectoryWalker$CancelException
  extends IOException
{
  private static final long serialVersionUID = 1347339620135041008L;
  private final int depth;
  private final File file;
  
  public DirectoryWalker$CancelException(File paramFile, int paramInt)
  {
    this("Operation Cancelled", paramFile, paramInt);
  }
  
  public DirectoryWalker$CancelException(String paramString, File paramFile, int paramInt)
  {
    super(paramString);
    this.file = paramFile;
    this.depth = paramInt;
  }
  
  public int getDepth()
  {
    return this.depth;
  }
  
  public File getFile()
  {
    return this.file;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\DirectoryWalker$CancelException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */