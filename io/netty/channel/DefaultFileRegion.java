package io.netty.channel;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class DefaultFileRegion
  extends AbstractReferenceCounted
  implements FileRegion
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultFileRegion.class);
  private final long count;
  private final File f;
  private FileChannel file;
  private final long position;
  private long transferred;
  
  public DefaultFileRegion(File paramFile, long paramLong1, long paramLong2)
  {
    this.f = ((File)ObjectUtil.checkNotNull(paramFile, "f"));
    this.position = ObjectUtil.checkPositiveOrZero(paramLong1, "position");
    this.count = ObjectUtil.checkPositiveOrZero(paramLong2, "count");
  }
  
  public DefaultFileRegion(FileChannel paramFileChannel, long paramLong1, long paramLong2)
  {
    this.file = ((FileChannel)ObjectUtil.checkNotNull(paramFileChannel, "file"));
    this.position = ObjectUtil.checkPositiveOrZero(paramLong1, "position");
    this.count = ObjectUtil.checkPositiveOrZero(paramLong2, "count");
    this.f = null;
  }
  
  static void validate(DefaultFileRegion paramDefaultFileRegion, long paramLong)
    throws IOException
  {
    long l1 = paramDefaultFileRegion.file.size();
    long l2 = paramDefaultFileRegion.count;
    if (paramDefaultFileRegion.position + (l2 - paramLong) + paramLong <= l1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Underlying file size ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" smaller then requested count ");
    localStringBuilder.append(paramDefaultFileRegion.count);
    throw new IOException(localStringBuilder.toString());
  }
  
  public long count()
  {
    return this.count;
  }
  
  protected void deallocate()
  {
    FileChannel localFileChannel = this.file;
    if (localFileChannel == null) {
      return;
    }
    this.file = null;
    try
    {
      localFileChannel.close();
    }
    catch (IOException localIOException)
    {
      logger.warn("Failed to close a file.", localIOException);
    }
  }
  
  public boolean isOpen()
  {
    boolean bool;
    if (this.file != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void open()
    throws IOException
  {
    if ((!isOpen()) && (refCnt() > 0)) {
      this.file = new RandomAccessFile(this.f, "r").getChannel();
    }
  }
  
  public long position()
  {
    return this.position;
  }
  
  public FileRegion retain()
  {
    super.retain();
    return this;
  }
  
  public FileRegion retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public FileRegion touch()
  {
    return this;
  }
  
  public FileRegion touch(Object paramObject)
  {
    return this;
  }
  
  public long transferTo(WritableByteChannel paramWritableByteChannel, long paramLong)
    throws IOException
  {
    long l = this.count - paramLong;
    boolean bool = l < 0L;
    if ((!bool) && (paramLong >= 0L))
    {
      if (!bool) {
        return 0L;
      }
      if (refCnt() != 0)
      {
        open();
        l = this.file.transferTo(this.position + paramLong, l, paramWritableByteChannel);
        bool = l < 0L;
        if (bool) {
          this.transferred += l;
        } else if (!bool) {
          validate(this, paramLong);
        }
        return l;
      }
      throw new IllegalReferenceCountException(0);
    }
    paramWritableByteChannel = new StringBuilder();
    paramWritableByteChannel.append("position out of range: ");
    paramWritableByteChannel.append(paramLong);
    paramWritableByteChannel.append(" (expected: 0 - ");
    paramWritableByteChannel.append(this.count - 1L);
    paramWritableByteChannel.append(')');
    throw new IllegalArgumentException(paramWritableByteChannel.toString());
  }
  
  @Deprecated
  public long transfered()
  {
    return this.transferred;
  }
  
  public long transferred()
  {
    return this.transferred;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultFileRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */