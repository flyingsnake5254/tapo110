package io.netty.channel.unix;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Buffer
{
  public static int addressSize()
  {
    if (PlatformDependent.hasUnsafe()) {
      return PlatformDependent.addressSize();
    }
    return addressSize0();
  }
  
  private static native int addressSize0();
  
  public static ByteBuffer allocateDirectWithNativeOrder(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);
    ByteOrder localByteOrder;
    if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    return localByteBuffer.order(localByteOrder);
  }
  
  public static void free(ByteBuffer paramByteBuffer)
  {
    PlatformDependent.freeDirectBuffer(paramByteBuffer);
  }
  
  public static long memoryAddress(ByteBuffer paramByteBuffer)
  {
    if (PlatformDependent.hasUnsafe()) {
      return PlatformDependent.directBufferAddress(paramByteBuffer);
    }
    return memoryAddress0(paramByteBuffer);
  }
  
  private static native long memoryAddress0(ByteBuffer paramByteBuffer);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\Buffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */