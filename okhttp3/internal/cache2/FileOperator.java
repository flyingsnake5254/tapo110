package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

final class FileOperator
{
  private final FileChannel fileChannel;
  
  FileOperator(FileChannel paramFileChannel)
  {
    this.fileChannel = paramFileChannel;
  }
  
  public void read(long paramLong1, Buffer paramBuffer, long paramLong2)
    throws IOException
  {
    if (paramLong2 >= 0L)
    {
      while (paramLong2 > 0L)
      {
        long l = this.fileChannel.transferTo(paramLong1, paramLong2, paramBuffer);
        paramLong1 += l;
        paramLong2 -= l;
      }
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public void write(long paramLong1, Buffer paramBuffer, long paramLong2)
    throws IOException
  {
    if ((paramLong2 >= 0L) && (paramLong2 <= paramBuffer.size()))
    {
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
      while (paramLong1 > 0L)
      {
        l = this.fileChannel.transferFrom(paramBuffer, paramLong2, paramLong1);
        paramLong2 += l;
        paramLong1 -= l;
      }
      return;
    }
    throw new IndexOutOfBoundsException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\cache2\FileOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */