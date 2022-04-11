package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.util.internal.ObjectUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;

@Deprecated
public abstract class OioByteStreamChannel
  extends AbstractOioByteChannel
{
  private static final InputStream CLOSED_IN = new InputStream()
  {
    public int read()
    {
      return -1;
    }
  };
  private static final OutputStream CLOSED_OUT = new OutputStream()
  {
    public void write(int paramAnonymousInt)
      throws IOException
    {
      throw new ClosedChannelException();
    }
  };
  private InputStream is;
  private OutputStream os;
  private WritableByteChannel outChannel;
  
  protected OioByteStreamChannel(Channel paramChannel)
  {
    super(paramChannel);
  }
  
  private static void checkEOF(FileRegion paramFileRegion)
    throws IOException
  {
    if (paramFileRegion.transferred() >= paramFileRegion.count()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected to be able to write ");
    localStringBuilder.append(paramFileRegion.count());
    localStringBuilder.append(" bytes, but only wrote ");
    localStringBuilder.append(paramFileRegion.transferred());
    throw new EOFException(localStringBuilder.toString());
  }
  
  protected final void activate(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (this.is == null)
    {
      if (this.os == null)
      {
        this.is = ((InputStream)ObjectUtil.checkNotNull(paramInputStream, "is"));
        this.os = ((OutputStream)ObjectUtil.checkNotNull(paramOutputStream, "os"));
        return;
      }
      throw new IllegalStateException("output was set already");
    }
    throw new IllegalStateException("input was set already");
  }
  
  protected int available()
  {
    try
    {
      int i = this.is.available();
      return i;
    }
    catch (IOException localIOException) {}
    return 0;
  }
  
  /* Error */
  protected void doClose()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	io/netty/channel/oio/OioByteStreamChannel:is	Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 74	io/netty/channel/oio/OioByteStreamChannel:os	Ljava/io/OutputStream;
    //   9: astore_2
    //   10: aload_0
    //   11: getstatic 24	io/netty/channel/oio/OioByteStreamChannel:CLOSED_IN	Ljava/io/InputStream;
    //   14: putfield 72	io/netty/channel/oio/OioByteStreamChannel:is	Ljava/io/InputStream;
    //   17: aload_0
    //   18: getstatic 27	io/netty/channel/oio/OioByteStreamChannel:CLOSED_OUT	Ljava/io/OutputStream;
    //   21: putfield 74	io/netty/channel/oio/OioByteStreamChannel:os	Ljava/io/OutputStream;
    //   24: aload_1
    //   25: ifnull +21 -> 46
    //   28: aload_1
    //   29: invokevirtual 103	java/io/InputStream:close	()V
    //   32: goto +14 -> 46
    //   35: astore_1
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 104	java/io/OutputStream:close	()V
    //   44: aload_1
    //   45: athrow
    //   46: aload_2
    //   47: ifnull +7 -> 54
    //   50: aload_2
    //   51: invokevirtual 104	java/io/OutputStream:close	()V
    //   54: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	OioByteStreamChannel
    //   4	25	1	localInputStream	InputStream
    //   35	10	1	localObject	Object
    //   9	42	2	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   28	32	35	finally
  }
  
  protected int doReadBytes(ByteBuf paramByteBuf)
    throws Exception
  {
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    localHandle.attemptedBytesRead(Math.max(1, Math.min(available(), paramByteBuf.maxWritableBytes())));
    return paramByteBuf.writeBytes(this.is, localHandle.attemptedBytesRead());
  }
  
  protected void doWriteBytes(ByteBuf paramByteBuf)
    throws Exception
  {
    OutputStream localOutputStream = this.os;
    if (localOutputStream != null)
    {
      paramByteBuf.readBytes(localOutputStream, paramByteBuf.readableBytes());
      return;
    }
    throw new NotYetConnectedException();
  }
  
  protected void doWriteFileRegion(FileRegion paramFileRegion)
    throws Exception
  {
    OutputStream localOutputStream = this.os;
    if (localOutputStream != null)
    {
      if (this.outChannel == null) {
        this.outChannel = Channels.newChannel(localOutputStream);
      }
      long l1 = 0L;
      long l2;
      do
      {
        l2 = paramFileRegion.transferTo(this.outChannel, l1);
        if (l2 == -1L)
        {
          checkEOF(paramFileRegion);
          return;
        }
        l2 = l1 + l2;
        l1 = l2;
      } while (l2 < paramFileRegion.count());
      return;
    }
    throw new NotYetConnectedException();
  }
  
  public boolean isActive()
  {
    Object localObject = this.is;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null) {
      if (localObject == CLOSED_IN)
      {
        bool2 = bool1;
      }
      else
      {
        localObject = this.os;
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (localObject != CLOSED_OUT) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\oio\OioByteStreamChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */