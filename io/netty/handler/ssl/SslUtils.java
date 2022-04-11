package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

final class SslUtils
{
  static final String[] DEFAULT_CIPHER_SUITES;
  static final String[] DEFAULT_TLSV13_CIPHER_SUITES;
  static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
  static final int NOT_ENCRYPTED = -2;
  static final int NOT_ENOUGH_DATA = -1;
  static final String PROTOCOL_SSL_V2 = "SSLv2";
  static final String PROTOCOL_SSL_V2_HELLO = "SSLv2Hello";
  static final String PROTOCOL_SSL_V3 = "SSLv3";
  static final String PROTOCOL_TLS_V1 = "TLSv1";
  static final String PROTOCOL_TLS_V1_1 = "TLSv1.1";
  static final String PROTOCOL_TLS_V1_2 = "TLSv1.2";
  static final String PROTOCOL_TLS_V1_3 = "TLSv1.3";
  static final int SSL_CONTENT_TYPE_ALERT = 21;
  static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
  static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
  static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;
  static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
  static final int SSL_RECORD_HEADER_LENGTH = 5;
  static final Set<String> TLSV13_CIPHERS = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(new String[] { "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256" })));
  static final String[] TLSV13_CIPHER_SUITES;
  
  static
  {
    Object localObject = new String[2];
    localObject[0] = "TLS_AES_128_GCM_SHA256";
    localObject[1] = "TLS_AES_256_GCM_SHA384";
    TLSV13_CIPHER_SUITES = (String[])localObject;
    if (PlatformDependent.javaVersion() >= 11) {
      DEFAULT_TLSV13_CIPHER_SUITES = (String[])localObject;
    } else {
      DEFAULT_TLSV13_CIPHER_SUITES = EmptyArrays.EMPTY_STRINGS;
    }
    localObject = new ArrayList();
    ((List)localObject).add("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
    ((List)localObject).add("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    ((List)localObject).add("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    ((List)localObject).add("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
    ((List)localObject).add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
    ((List)localObject).add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
    ((List)localObject).add("TLS_RSA_WITH_AES_128_GCM_SHA256");
    ((List)localObject).add("TLS_RSA_WITH_AES_128_CBC_SHA");
    ((List)localObject).add("TLS_RSA_WITH_AES_256_CBC_SHA");
    Collections.addAll((Collection)localObject, DEFAULT_TLSV13_CIPHER_SUITES);
    DEFAULT_CIPHER_SUITES = (String[])((List)localObject).toArray(new String[0]);
  }
  
  static void addIfSupported(Set<String> paramSet, List<String> paramList, String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramVarArgs[j];
      if (paramSet.contains(str)) {
        paramList.add(str);
      }
    }
  }
  
  static int getEncryptedPacketLength(ByteBuf paramByteBuf, int paramInt)
  {
    int i = paramByteBuf.getUnsignedByte(paramInt);
    int j = 0;
    int k = 0;
    switch (i)
    {
    default: 
      i = 0;
      break;
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
      i = 1;
    }
    if (i != 0)
    {
      if (paramByteBuf.getUnsignedByte(paramInt + 1) == 3)
      {
        int m = unsignedShortBE(paramByteBuf, paramInt + 3) + 5;
        if (m <= 5)
        {
          k = j;
          i = m;
          break label110;
        }
        k = i;
        i = m;
        break label110;
      }
    }
    else {
      k = i;
    }
    i = 0;
    label110:
    j = i;
    if (k == 0)
    {
      if ((paramByteBuf.getUnsignedByte(paramInt) & 0x80) != 0) {
        i = 2;
      } else {
        i = 3;
      }
      k = paramByteBuf.getUnsignedByte(paramInt + i + 1);
      if ((k != 2) && (k != 3)) {
        return -2;
      }
      if (i == 2) {
        paramInt = (shortBE(paramByteBuf, paramInt) & 0x7FFF) + 2;
      } else {
        paramInt = (shortBE(paramByteBuf, paramInt) & 0x3FFF) + 3;
      }
      j = paramInt;
      if (paramInt <= i) {
        return -1;
      }
    }
    return j;
  }
  
  private static int getEncryptedPacketLength(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = unsignedByte(paramByteBuffer.get(i));
    int k = 0;
    int m = 0;
    switch (j)
    {
    default: 
      j = 0;
      break;
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
      j = 1;
    }
    if (j != 0)
    {
      if (unsignedByte(paramByteBuffer.get(i + 1)) == 3)
      {
        int n = unsignedShortBE(paramByteBuffer, i + 3) + 5;
        if (n <= 5)
        {
          m = k;
          j = n;
          break label121;
        }
        m = j;
        j = n;
        break label121;
      }
    }
    else {
      m = j;
    }
    j = 0;
    label121:
    if (m == 0)
    {
      if ((unsignedByte(paramByteBuffer.get(i)) & 0x80) != 0) {
        m = 2;
      } else {
        m = 3;
      }
      j = unsignedByte(paramByteBuffer.get(i + m + 1));
      if ((j != 2) && (j != 3)) {
        return -2;
      }
      if (m == 2) {
        j = (shortBE(paramByteBuffer, i) & 0x7FFF) + 2;
      } else {
        j = (shortBE(paramByteBuffer, i) & 0x3FFF) + 3;
      }
      k = j;
      j = k;
      if (k <= m) {
        return -1;
      }
    }
    return j;
  }
  
  static int getEncryptedPacketLength(ByteBuffer[] paramArrayOfByteBuffer, int paramInt)
  {
    ByteBuffer localByteBuffer1 = paramArrayOfByteBuffer[paramInt];
    if (localByteBuffer1.remaining() >= 5) {
      return getEncryptedPacketLength(localByteBuffer1);
    }
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(5);
    for (;;)
    {
      localByteBuffer1 = paramArrayOfByteBuffer[paramInt].duplicate();
      if (localByteBuffer1.remaining() > localByteBuffer2.remaining()) {
        localByteBuffer1.limit(localByteBuffer1.position() + localByteBuffer2.remaining());
      }
      localByteBuffer2.put(localByteBuffer1);
      if (!localByteBuffer2.hasRemaining())
      {
        localByteBuffer2.flip();
        return getEncryptedPacketLength(localByteBuffer2);
      }
      paramInt++;
    }
  }
  
  static void handleHandshakeFailure(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable, boolean paramBoolean)
  {
    paramChannelHandlerContext.flush();
    if (paramBoolean) {
      paramChannelHandlerContext.fireUserEventTriggered(new SslHandshakeCompletionEvent(paramThrowable));
    }
    paramChannelHandlerContext.close();
  }
  
  static boolean isTLSv13Cipher(String paramString)
  {
    return TLSV13_CIPHERS.contains(paramString);
  }
  
  static boolean isValidHostNameForSNI(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.indexOf('.') > 0) && (!paramString.endsWith(".")) && (!NetUtil.isValidIpV4Address(paramString)) && (!NetUtil.isValidIpV6Address(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static short shortBE(ByteBuf paramByteBuf, int paramInt)
  {
    int i;
    if (paramByteBuf.order() == ByteOrder.BIG_ENDIAN)
    {
      paramInt = paramByteBuf.getShort(paramInt);
      i = paramInt;
    }
    else
    {
      paramInt = paramByteBuf.getShortLE(paramInt);
      i = paramInt;
    }
    return i;
  }
  
  private static short shortBE(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i;
    if (paramByteBuffer.order() == ByteOrder.BIG_ENDIAN)
    {
      paramInt = paramByteBuffer.getShort(paramInt);
      i = paramInt;
    }
    else
    {
      paramInt = ByteBufUtil.swapShort(paramByteBuffer.getShort(paramInt));
      i = paramInt;
    }
    return i;
  }
  
  static ByteBuf toBase64(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf)
  {
    paramByteBufAllocator = Base64.encode(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes(), true, Base64Dialect.STANDARD, paramByteBufAllocator);
    paramByteBuf.readerIndex(paramByteBuf.writerIndex());
    return paramByteBufAllocator;
  }
  
  static SSLHandshakeException toSSLHandshakeException(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof SSLHandshakeException)) {
      return (SSLHandshakeException)paramThrowable;
    }
    return (SSLHandshakeException)new SSLHandshakeException(paramThrowable.getMessage()).initCause(paramThrowable);
  }
  
  private static short unsignedByte(byte paramByte)
  {
    return (short)(paramByte & 0xFF);
  }
  
  private static int unsignedShortBE(ByteBuf paramByteBuf, int paramInt)
  {
    if (paramByteBuf.order() == ByteOrder.BIG_ENDIAN) {
      paramInt = paramByteBuf.getUnsignedShort(paramInt);
    } else {
      paramInt = paramByteBuf.getUnsignedShortLE(paramInt);
    }
    return paramInt;
  }
  
  private static int unsignedShortBE(ByteBuffer paramByteBuffer, int paramInt)
  {
    return shortBE(paramByteBuffer, paramInt) & 0xFFFF;
  }
  
  static void useFallbackCiphersIfDefaultIsEmpty(List<String> paramList, Iterable<String> paramIterable)
  {
    if (paramList.isEmpty())
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        paramIterable = (String)localIterator.next();
        if ((!paramIterable.startsWith("SSL_")) && (!paramIterable.contains("_RC4_"))) {
          paramList.add(paramIterable);
        }
      }
    }
  }
  
  static void useFallbackCiphersIfDefaultIsEmpty(List<String> paramList, String... paramVarArgs)
  {
    useFallbackCiphersIfDefaultIsEmpty(paramList, Arrays.asList(paramVarArgs));
  }
  
  static void zeroout(ByteBuf paramByteBuf)
  {
    if (!paramByteBuf.isReadOnly()) {
      paramByteBuf.setZero(0, paramByteBuf.capacity());
    }
  }
  
  static void zerooutAndRelease(ByteBuf paramByteBuf)
  {
    zeroout(paramByteBuf);
    paramByteBuf.release();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */