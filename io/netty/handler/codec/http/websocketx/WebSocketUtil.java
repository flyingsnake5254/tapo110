package io.netty.handler.codec.http.websocketx;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

final class WebSocketUtil
{
  private static final FastThreadLocal<MessageDigest> MD5 = new FastThreadLocal()
  {
    protected MessageDigest initialValue()
      throws Exception
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new InternalError("MD5 not supported on this platform - Outdated?");
      }
    }
  };
  private static final FastThreadLocal<MessageDigest> SHA1 = new FastThreadLocal()
  {
    protected MessageDigest initialValue()
      throws Exception
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
        return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new InternalError("SHA-1 not supported on this platform - Outdated?");
      }
    }
  };
  
  /* Error */
  @io.netty.util.internal.SuppressJava6Requirement(reason="Guarded with java version check")
  static String base64(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 38	io/netty/util/internal/PlatformDependent:javaVersion	()I
    //   3: bipush 8
    //   5: if_icmplt +11 -> 16
    //   8: invokestatic 44	java/util/Base64:getEncoder	()Ljava/util/Base64$Encoder;
    //   11: aload_0
    //   12: invokevirtual 49	java/util/Base64$Encoder:encodeToString	([B)Ljava/lang/String;
    //   15: areturn
    //   16: aload_0
    //   17: invokestatic 55	io/netty/buffer/Unpooled:wrappedBuffer	([B)Lio/netty/buffer/ByteBuf;
    //   20: astore_0
    //   21: aload_0
    //   22: invokestatic 61	io/netty/handler/codec/base64/Base64:encode	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   25: astore_1
    //   26: aload_1
    //   27: getstatic 67	io/netty/util/CharsetUtil:UTF_8	Ljava/nio/charset/Charset;
    //   30: invokevirtual 73	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   33: astore_2
    //   34: aload_1
    //   35: invokeinterface 79 1 0
    //   40: pop
    //   41: aload_0
    //   42: invokeinterface 79 1 0
    //   47: pop
    //   48: aload_2
    //   49: areturn
    //   50: astore_2
    //   51: aload_1
    //   52: invokeinterface 79 1 0
    //   57: pop
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: invokeinterface 79 1 0
    //   67: pop
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramArrayOfByte	byte[]
    //   25	27	1	localByteBuf	io.netty.buffer.ByteBuf
    //   60	9	1	localObject1	Object
    //   33	16	2	str	String
    //   50	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	34	50	finally
    //   21	26	60	finally
    //   34	41	60	finally
    //   51	60	60	finally
  }
  
  private static byte[] digest(FastThreadLocal<MessageDigest> paramFastThreadLocal, byte[] paramArrayOfByte)
  {
    paramFastThreadLocal = (MessageDigest)paramFastThreadLocal.get();
    paramFastThreadLocal.reset();
    return paramFastThreadLocal.digest(paramArrayOfByte);
  }
  
  static byte[] md5(byte[] paramArrayOfByte)
  {
    return digest(MD5, paramArrayOfByte);
  }
  
  static byte[] randomBytes(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    PlatformDependent.threadLocalRandom().nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  static int randomNumber(int paramInt1, int paramInt2)
  {
    double d = PlatformDependent.threadLocalRandom().nextDouble();
    return (int)(paramInt1 + d * (paramInt2 - paramInt1));
  }
  
  static byte[] sha1(byte[] paramArrayOfByte)
  {
    return digest(SHA1, paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */