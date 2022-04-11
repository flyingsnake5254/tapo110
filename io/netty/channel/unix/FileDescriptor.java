package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class FileDescriptor
{
  private static final int STATE_ALL_MASK = 7;
  private static final int STATE_CLOSED_MASK = 1;
  private static final int STATE_INPUT_SHUTDOWN_MASK = 2;
  private static final int STATE_OUTPUT_SHUTDOWN_MASK = 4;
  private static final AtomicIntegerFieldUpdater<FileDescriptor> stateUpdater = AtomicIntegerFieldUpdater.newUpdater(FileDescriptor.class, "state");
  final int fd;
  volatile int state;
  
  public FileDescriptor(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "fd");
    this.fd = paramInt;
  }
  
  private static native int close(int paramInt);
  
  public static FileDescriptor from(File paramFile)
    throws IOException
  {
    return from(((File)ObjectUtil.checkNotNull(paramFile, "file")).getPath());
  }
  
  public static FileDescriptor from(String paramString)
    throws IOException
  {
    int i = open((String)ObjectUtil.checkNotNull(paramString, "path"));
    if (i >= 0) {
      return new FileDescriptor(i);
    }
    throw Errors.newIOException("open", i);
  }
  
  static int inputShutdown(int paramInt)
  {
    return paramInt | 0x2;
  }
  
  static boolean isClosed(int paramInt)
  {
    boolean bool = true;
    if ((paramInt & 0x1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  static boolean isInputShutdown(int paramInt)
  {
    boolean bool;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isOutputShutdown(int paramInt)
  {
    boolean bool;
    if ((paramInt & 0x4) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static native long newPipe();
  
  private static native int open(String paramString);
  
  static int outputShutdown(int paramInt)
  {
    return paramInt | 0x4;
  }
  
  public static FileDescriptor[] pipe()
    throws IOException
  {
    long l = newPipe();
    if (l >= 0L) {
      return new FileDescriptor[] { new FileDescriptor((int)(l >>> 32)), new FileDescriptor((int)l) };
    }
    throw Errors.newIOException("newPipe", (int)l);
  }
  
  private static native int read(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  
  private static native int readAddress(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  private static native int write(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  
  private static native int writeAddress(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  private static native long writev(int paramInt1, ByteBuffer[] paramArrayOfByteBuffer, int paramInt2, int paramInt3, long paramLong);
  
  private static native long writevAddresses(int paramInt1, long paramLong, int paramInt2);
  
  final boolean casState(int paramInt1, int paramInt2)
  {
    return stateUpdater.compareAndSet(this, paramInt1, paramInt2);
  }
  
  public void close()
    throws IOException
  {
    do
    {
      i = this.state;
      if (isClosed(i)) {
        return;
      }
    } while (!casState(i, i | 0x7));
    int i = close(this.fd);
    if (i >= 0) {
      return;
    }
    throw Errors.newIOException("close", i);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FileDescriptor)) {
      return false;
    }
    if (this.fd != ((FileDescriptor)paramObject).fd) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.fd;
  }
  
  public final int intValue()
  {
    return this.fd;
  }
  
  public boolean isOpen()
  {
    return isClosed(this.state) ^ true;
  }
  
  public final int read(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = read(this.fd, paramByteBuffer, paramInt1, paramInt2);
    if (paramInt1 > 0) {
      return paramInt1;
    }
    if (paramInt1 == 0) {
      return -1;
    }
    return Errors.ioResult("read", paramInt1);
  }
  
  public final int readAddress(long paramLong, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = readAddress(this.fd, paramLong, paramInt1, paramInt2);
    if (paramInt1 > 0) {
      return paramInt1;
    }
    if (paramInt1 == 0) {
      return -1;
    }
    return Errors.ioResult("readAddress", paramInt1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileDescriptor{fd=");
    localStringBuilder.append(this.fd);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final int write(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = write(this.fd, paramByteBuffer, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return Errors.ioResult("write", paramInt1);
  }
  
  public final int writeAddress(long paramLong, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = writeAddress(this.fd, paramLong, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return Errors.ioResult("writeAddress", paramInt1);
  }
  
  public final long writev(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    paramLong = writev(this.fd, paramArrayOfByteBuffer, paramInt1, Math.min(Limits.IOV_MAX, paramInt2), paramLong);
    if (paramLong >= 0L) {
      return paramLong;
    }
    return Errors.ioResult("writev", (int)paramLong);
  }
  
  public final long writevAddresses(long paramLong, int paramInt)
    throws IOException
  {
    paramLong = writevAddresses(this.fd, paramLong, paramInt);
    if (paramLong >= 0L) {
      return paramLong;
    }
    return Errors.ioResult("writevAddresses", (int)paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\FileDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */