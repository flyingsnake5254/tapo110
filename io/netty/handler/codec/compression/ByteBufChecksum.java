package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

abstract class ByteBufChecksum
  implements Checksum
{
  private static final Method ADLER32_UPDATE_METHOD = updateByteBuffer(new Adler32());
  private static final Method CRC32_UPDATE_METHOD = updateByteBuffer(new CRC32());
  private final ByteProcessor updateProcessor = new ByteProcessor()
  {
    public boolean process(byte paramAnonymousByte)
      throws Exception
    {
      ByteBufChecksum.this.update(paramAnonymousByte);
      return true;
    }
  };
  
  private static Method updateByteBuffer(Checksum paramChecksum)
  {
    if (PlatformDependent.javaVersion() >= 8) {}
    try
    {
      Method localMethod = paramChecksum.getClass().getDeclaredMethod("update", new Class[] { ByteBuffer.class });
      localMethod.invoke(paramChecksum, new Object[] { ByteBuffer.allocate(1) });
      return localMethod;
    }
    finally
    {
      for (;;) {}
    }
    return null;
  }
  
  static ByteBufChecksum wrapChecksum(Checksum paramChecksum)
  {
    ObjectUtil.checkNotNull(paramChecksum, "checksum");
    if ((paramChecksum instanceof ByteBufChecksum)) {
      return (ByteBufChecksum)paramChecksum;
    }
    Method localMethod;
    if ((paramChecksum instanceof Adler32))
    {
      localMethod = ADLER32_UPDATE_METHOD;
      if (localMethod != null) {
        return new ReflectiveByteBufChecksum(paramChecksum, localMethod);
      }
    }
    if ((paramChecksum instanceof CRC32))
    {
      localMethod = CRC32_UPDATE_METHOD;
      if (localMethod != null) {
        return new ReflectiveByteBufChecksum(paramChecksum, localMethod);
      }
    }
    return new SlowByteBufChecksum(paramChecksum);
  }
  
  public void update(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    if (paramByteBuf.hasArray()) {
      update(paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt1, paramInt2);
    } else {
      paramByteBuf.forEachByte(paramInt1, paramInt2, this.updateProcessor);
    }
  }
  
  private static final class ReflectiveByteBufChecksum
    extends ByteBufChecksum.SlowByteBufChecksum
  {
    private final Method method;
    
    ReflectiveByteBufChecksum(Checksum paramChecksum, Method paramMethod)
    {
      super();
      this.method = paramMethod;
    }
    
    public void update(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
    {
      if (paramByteBuf.hasArray()) {
        update(paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt1, paramInt2);
      }
      try
      {
        this.method.invoke(this.checksum, new Object[] { CompressionUtil.safeNioBuffer(paramByteBuf, paramInt1, paramInt2) });
        return;
      }
      finally {}
    }
  }
  
  private static class SlowByteBufChecksum
    extends ByteBufChecksum
  {
    protected final Checksum checksum;
    
    SlowByteBufChecksum(Checksum paramChecksum)
    {
      this.checksum = paramChecksum;
    }
    
    public long getValue()
    {
      return this.checksum.getValue();
    }
    
    public void reset()
    {
      this.checksum.reset();
    }
    
    public void update(int paramInt)
    {
      this.checksum.update(paramInt);
    }
    
    public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.checksum.update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\ByteBufChecksum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */