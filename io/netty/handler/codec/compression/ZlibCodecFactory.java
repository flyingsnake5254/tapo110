package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class ZlibCodecFactory
{
  private static final int DEFAULT_JDK_MEM_LEVEL = 8;
  private static final int DEFAULT_JDK_WINDOW_SIZE = 15;
  private static final InternalLogger logger;
  private static final boolean noJdkZlibDecoder;
  private static final boolean noJdkZlibEncoder;
  private static final boolean supportsWindowSizeAndMemLevel;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(ZlibCodecFactory.class);
    logger = localInternalLogger;
    int i = PlatformDependent.javaVersion();
    boolean bool1 = true;
    if (i < 7) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibDecoder", bool2);
    noJdkZlibDecoder = bool3;
    localInternalLogger.debug("-Dio.netty.noJdkZlibDecoder: {}", Boolean.valueOf(bool3));
    boolean bool2 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibEncoder", false);
    noJdkZlibEncoder = bool2;
    localInternalLogger.debug("-Dio.netty.noJdkZlibEncoder: {}", Boolean.valueOf(bool2));
    bool2 = bool1;
    if (!bool3) {
      if (PlatformDependent.javaVersion() >= 7) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    supportsWindowSizeAndMemLevel = bool2;
  }
  
  public static boolean isSupportingWindowSizeAndMemLevel()
  {
    return supportsWindowSizeAndMemLevel;
  }
  
  public static ZlibDecoder newZlibDecoder()
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibDecoder)) {
      return new JdkZlibDecoder(true);
    }
    return new JZlibDecoder();
  }
  
  public static ZlibDecoder newZlibDecoder(ZlibWrapper paramZlibWrapper)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibDecoder)) {
      return new JdkZlibDecoder(paramZlibWrapper, true);
    }
    return new JZlibDecoder(paramZlibWrapper);
  }
  
  public static ZlibDecoder newZlibDecoder(byte[] paramArrayOfByte)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibDecoder)) {
      return new JdkZlibDecoder(paramArrayOfByte);
    }
    return new JZlibDecoder(paramArrayOfByte);
  }
  
  public static ZlibEncoder newZlibEncoder(int paramInt)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibEncoder)) {
      return new JdkZlibEncoder(paramInt);
    }
    return new JZlibEncoder(paramInt);
  }
  
  public static ZlibEncoder newZlibEncoder(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibEncoder) && (paramInt2 == 15) && (paramInt3 == 8)) {
      return new JdkZlibEncoder(paramInt1, paramArrayOfByte);
    }
    return new JZlibEncoder(paramInt1, paramInt2, paramInt3, paramArrayOfByte);
  }
  
  public static ZlibEncoder newZlibEncoder(int paramInt, byte[] paramArrayOfByte)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibEncoder)) {
      return new JdkZlibEncoder(paramInt, paramArrayOfByte);
    }
    return new JZlibEncoder(paramInt, paramArrayOfByte);
  }
  
  public static ZlibEncoder newZlibEncoder(ZlibWrapper paramZlibWrapper)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibEncoder)) {
      return new JdkZlibEncoder(paramZlibWrapper);
    }
    return new JZlibEncoder(paramZlibWrapper);
  }
  
  public static ZlibEncoder newZlibEncoder(ZlibWrapper paramZlibWrapper, int paramInt)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibEncoder)) {
      return new JdkZlibEncoder(paramZlibWrapper, paramInt);
    }
    return new JZlibEncoder(paramZlibWrapper, paramInt);
  }
  
  public static ZlibEncoder newZlibEncoder(ZlibWrapper paramZlibWrapper, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibEncoder) && (paramInt2 == 15) && (paramInt3 == 8)) {
      return new JdkZlibEncoder(paramZlibWrapper, paramInt1);
    }
    return new JZlibEncoder(paramZlibWrapper, paramInt1, paramInt2, paramInt3);
  }
  
  public static ZlibEncoder newZlibEncoder(byte[] paramArrayOfByte)
  {
    if ((PlatformDependent.javaVersion() >= 7) && (!noJdkZlibEncoder)) {
      return new JdkZlibEncoder(paramArrayOfByte);
    }
    return new JZlibEncoder(paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\ZlibCodecFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */