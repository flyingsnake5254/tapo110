package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class SocketWritableByteChannel
  implements WritableByteChannel
{
  private final FileDescriptor fd;
  
  protected SocketWritableByteChannel(FileDescriptor paramFileDescriptor)
  {
    this.fd = ((FileDescriptor)ObjectUtil.checkNotNull(paramFileDescriptor, "fd"));
  }
  
  protected abstract ByteBufAllocator alloc();
  
  public final void close()
    throws IOException
  {
    this.fd.close();
  }
  
  public final boolean isOpen()
  {
    return this.fd.isOpen();
  }
  
  public final int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.limit();
    Object localObject1;
    Object localObject2;
    if (paramByteBuffer.isDirect())
    {
      j = this.fd.write(paramByteBuffer, i, paramByteBuffer.limit());
    }
    else
    {
      j -= i;
      localObject1 = null;
      if (j == 0) {
        localObject2 = localObject1;
      }
    }
    try
    {
      localObject1 = Unpooled.EMPTY_BUFFER;
      break label126;
      localObject2 = localObject1;
      Object localObject3 = alloc();
      localObject2 = localObject1;
      if (((ByteBufAllocator)localObject3).isDirectBufferPooled())
      {
        localObject2 = localObject1;
        localObject1 = ((ByteBufAllocator)localObject3).directBuffer(j);
      }
      else
      {
        localObject2 = localObject1;
        localObject3 = ByteBufUtil.threadLocalDirectBuffer();
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = localObject3;
          localObject1 = Unpooled.directBuffer(j);
        }
      }
      label126:
      localObject2 = localObject1;
      ((ByteBuf)localObject1).writeBytes(paramByteBuffer.duplicate());
      localObject2 = localObject1;
      localObject3 = ((ByteBuf)localObject1).internalNioBuffer(((ByteBuf)localObject1).readerIndex(), j);
      localObject2 = localObject1;
      j = this.fd.write((ByteBuffer)localObject3, ((ByteBuffer)localObject3).position(), ((ByteBuffer)localObject3).limit());
      ((ReferenceCounted)localObject1).release();
      if (j > 0) {
        paramByteBuffer.position(i + j);
      }
      return j;
    }
    finally
    {
      if (localObject2 != null) {
        ((ReferenceCounted)localObject2).release();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\SocketWritableByteChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */