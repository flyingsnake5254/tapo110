package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;

public abstract class a
  extends OutputStream
{
  public void close() {}
  
  public void flush() {}
  
  public void write(int paramInt)
    throws IOException
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\io\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */