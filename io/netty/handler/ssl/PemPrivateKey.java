package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.security.PrivateKey;

public final class PemPrivateKey
  extends AbstractReferenceCounted
  implements PrivateKey, PemEncoded
{
  private static final byte[] BEGIN_PRIVATE_KEY;
  private static final byte[] END_PRIVATE_KEY;
  private static final String PKCS8_FORMAT = "PKCS#8";
  private static final long serialVersionUID = 7978017465645018936L;
  private final ByteBuf content;
  
  static
  {
    Charset localCharset = CharsetUtil.US_ASCII;
    BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n".getBytes(localCharset);
    END_PRIVATE_KEY = "\n-----END PRIVATE KEY-----\n".getBytes(localCharset);
  }
  
  private PemPrivateKey(ByteBuf paramByteBuf)
  {
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
  }
  
  static PemEncoded toPEM(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, PrivateKey paramPrivateKey)
  {
    if ((paramPrivateKey instanceof PemEncoded)) {
      return ((PemEncoded)paramPrivateKey).retain();
    }
    byte[] arrayOfByte = paramPrivateKey.getEncoded();
    if (arrayOfByte != null) {
      return toPEM(paramByteBufAllocator, paramBoolean, arrayOfByte);
    }
    paramByteBufAllocator = new StringBuilder();
    paramByteBufAllocator.append(paramPrivateKey.getClass().getName());
    paramByteBufAllocator.append(" does not support encoding");
    throw new IllegalArgumentException(paramByteBufAllocator.toString());
  }
  
  /* Error */
  static PemEncoded toPEM(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 107	io/netty/buffer/Unpooled:wrappedBuffer	([B)Lio/netty/buffer/ByteBuf;
    //   4: astore_2
    //   5: aload_0
    //   6: aload_2
    //   7: invokestatic 113	io/netty/handler/ssl/SslUtils:toBase64	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   10: astore_3
    //   11: getstatic 39	io/netty/handler/ssl/PemPrivateKey:BEGIN_PRIVATE_KEY	[B
    //   14: astore 4
    //   16: aload 4
    //   18: arraylength
    //   19: istore 5
    //   21: aload_3
    //   22: invokevirtual 117	io/netty/buffer/ByteBuf:readableBytes	()I
    //   25: istore 6
    //   27: getstatic 43	io/netty/handler/ssl/PemPrivateKey:END_PRIVATE_KEY	[B
    //   30: astore 7
    //   32: iload 5
    //   34: iload 6
    //   36: iadd
    //   37: aload 7
    //   39: arraylength
    //   40: iadd
    //   41: istore 5
    //   43: iload_1
    //   44: ifeq +15 -> 59
    //   47: aload_0
    //   48: iload 5
    //   50: invokeinterface 123 2 0
    //   55: astore_0
    //   56: goto +12 -> 68
    //   59: aload_0
    //   60: iload 5
    //   62: invokeinterface 126 2 0
    //   67: astore_0
    //   68: aload_0
    //   69: aload 4
    //   71: invokevirtual 129	io/netty/buffer/ByteBuf:writeBytes	([B)Lio/netty/buffer/ByteBuf;
    //   74: pop
    //   75: aload_0
    //   76: aload_3
    //   77: invokevirtual 132	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   80: pop
    //   81: aload_0
    //   82: aload 7
    //   84: invokevirtual 129	io/netty/buffer/ByteBuf:writeBytes	([B)Lio/netty/buffer/ByteBuf;
    //   87: pop
    //   88: new 134	io/netty/handler/ssl/PemValue
    //   91: astore 4
    //   93: aload 4
    //   95: aload_0
    //   96: iconst_1
    //   97: invokespecial 137	io/netty/handler/ssl/PemValue:<init>	(Lio/netty/buffer/ByteBuf;Z)V
    //   100: aload_3
    //   101: invokestatic 140	io/netty/handler/ssl/SslUtils:zerooutAndRelease	(Lio/netty/buffer/ByteBuf;)V
    //   104: aload_2
    //   105: invokestatic 140	io/netty/handler/ssl/SslUtils:zerooutAndRelease	(Lio/netty/buffer/ByteBuf;)V
    //   108: aload 4
    //   110: areturn
    //   111: astore 4
    //   113: aload_0
    //   114: invokestatic 140	io/netty/handler/ssl/SslUtils:zerooutAndRelease	(Lio/netty/buffer/ByteBuf;)V
    //   117: aload 4
    //   119: athrow
    //   120: astore_0
    //   121: aload_3
    //   122: invokestatic 140	io/netty/handler/ssl/SslUtils:zerooutAndRelease	(Lio/netty/buffer/ByteBuf;)V
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: aload_2
    //   129: invokestatic 140	io/netty/handler/ssl/SslUtils:zerooutAndRelease	(Lio/netty/buffer/ByteBuf;)V
    //   132: aload_0
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramByteBufAllocator	ByteBufAllocator
    //   0	134	1	paramBoolean	boolean
    //   0	134	2	paramArrayOfByte	byte[]
    //   10	112	3	localByteBuf	ByteBuf
    //   14	95	4	localObject1	Object
    //   111	7	4	localObject2	Object
    //   19	42	5	i	int
    //   25	12	6	j	int
    //   30	53	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   68	100	111	finally
    //   11	43	120	finally
    //   47	56	120	finally
    //   59	68	120	finally
    //   113	120	120	finally
    //   5	11	127	finally
    //   100	104	127	finally
    //   121	127	127	finally
  }
  
  public static PemPrivateKey valueOf(ByteBuf paramByteBuf)
  {
    return new PemPrivateKey(paramByteBuf);
  }
  
  public static PemPrivateKey valueOf(byte[] paramArrayOfByte)
  {
    return valueOf(Unpooled.wrappedBuffer(paramArrayOfByte));
  }
  
  public ByteBuf content()
  {
    int i = refCnt();
    if (i > 0) {
      return this.content;
    }
    throw new IllegalReferenceCountException(i);
  }
  
  public PemPrivateKey copy()
  {
    return replace(this.content.copy());
  }
  
  protected void deallocate()
  {
    SslUtils.zerooutAndRelease(this.content);
  }
  
  public void destroy()
  {
    release(refCnt());
  }
  
  public PemPrivateKey duplicate()
  {
    return replace(this.content.duplicate());
  }
  
  public String getAlgorithm()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getEncoded()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public boolean isDestroyed()
  {
    boolean bool;
    if (refCnt() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSensitive()
  {
    return true;
  }
  
  public PemPrivateKey replace(ByteBuf paramByteBuf)
  {
    return new PemPrivateKey(paramByteBuf);
  }
  
  public PemPrivateKey retain()
  {
    return (PemPrivateKey)super.retain();
  }
  
  public PemPrivateKey retain(int paramInt)
  {
    return (PemPrivateKey)super.retain(paramInt);
  }
  
  public PemPrivateKey retainedDuplicate()
  {
    return replace(this.content.retainedDuplicate());
  }
  
  public PemPrivateKey touch()
  {
    this.content.touch();
    return this;
  }
  
  public PemPrivateKey touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\PemPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */