package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

public final class PemX509Certificate
  extends X509Certificate
  implements PemEncoded
{
  private static final byte[] BEGIN_CERT;
  private static final byte[] END_CERT;
  private final ByteBuf content;
  
  static
  {
    Charset localCharset = CharsetUtil.US_ASCII;
    BEGIN_CERT = "-----BEGIN CERTIFICATE-----\n".getBytes(localCharset);
    END_CERT = "\n-----END CERTIFICATE-----\n".getBytes(localCharset);
  }
  
  private PemX509Certificate(ByteBuf paramByteBuf)
  {
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
  }
  
  private static ByteBuf append(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, PemEncoded paramPemEncoded, int paramInt, ByteBuf paramByteBuf)
  {
    ByteBuf localByteBuf = paramPemEncoded.content();
    paramPemEncoded = paramByteBuf;
    if (paramByteBuf == null) {
      paramPemEncoded = newBuffer(paramByteBufAllocator, paramBoolean, localByteBuf.readableBytes() * paramInt);
    }
    paramPemEncoded.writeBytes(localByteBuf.slice());
    return paramPemEncoded;
  }
  
  /* Error */
  private static ByteBuf append(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, X509Certificate paramX509Certificate, int paramInt, ByteBuf paramByteBuf)
    throws CertificateEncodingException
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 78	java/security/cert/X509Certificate:getEncoded	()[B
    //   4: invokestatic 84	io/netty/buffer/Unpooled:wrappedBuffer	([B)Lio/netty/buffer/ByteBuf;
    //   7: astore 5
    //   9: aload_0
    //   10: aload 5
    //   12: invokestatic 90	io/netty/handler/ssl/SslUtils:toBase64	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   15: astore 6
    //   17: aload 4
    //   19: astore_2
    //   20: aload 4
    //   22: ifnonnull +26 -> 48
    //   25: aload_0
    //   26: iload_1
    //   27: getstatic 29	io/netty/handler/ssl/PemX509Certificate:BEGIN_CERT	[B
    //   30: arraylength
    //   31: aload 6
    //   33: invokevirtual 60	io/netty/buffer/ByteBuf:readableBytes	()I
    //   36: iadd
    //   37: getstatic 33	io/netty/handler/ssl/PemX509Certificate:END_CERT	[B
    //   40: arraylength
    //   41: iadd
    //   42: iload_3
    //   43: imul
    //   44: invokestatic 64	io/netty/handler/ssl/PemX509Certificate:newBuffer	(Lio/netty/buffer/ByteBufAllocator;ZI)Lio/netty/buffer/ByteBuf;
    //   47: astore_2
    //   48: aload_2
    //   49: getstatic 29	io/netty/handler/ssl/PemX509Certificate:BEGIN_CERT	[B
    //   52: invokevirtual 92	io/netty/buffer/ByteBuf:writeBytes	([B)Lio/netty/buffer/ByteBuf;
    //   55: pop
    //   56: aload_2
    //   57: aload 6
    //   59: invokevirtual 71	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   62: pop
    //   63: aload_2
    //   64: getstatic 33	io/netty/handler/ssl/PemX509Certificate:END_CERT	[B
    //   67: invokevirtual 92	io/netty/buffer/ByteBuf:writeBytes	([B)Lio/netty/buffer/ByteBuf;
    //   70: pop
    //   71: aload 6
    //   73: invokeinterface 98 1 0
    //   78: pop
    //   79: aload 5
    //   81: invokeinterface 98 1 0
    //   86: pop
    //   87: aload_2
    //   88: areturn
    //   89: astore_0
    //   90: aload 6
    //   92: invokeinterface 98 1 0
    //   97: pop
    //   98: aload_0
    //   99: athrow
    //   100: astore_0
    //   101: aload 5
    //   103: invokeinterface 98 1 0
    //   108: pop
    //   109: aload_0
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramByteBufAllocator	ByteBufAllocator
    //   0	111	1	paramBoolean	boolean
    //   0	111	2	paramX509Certificate	X509Certificate
    //   0	111	3	paramInt	int
    //   0	111	4	paramByteBuf	ByteBuf
    //   7	95	5	localByteBuf1	ByteBuf
    //   15	76	6	localByteBuf2	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   25	48	89	finally
    //   48	71	89	finally
    //   9	17	100	finally
    //   71	79	100	finally
    //   90	100	100	finally
  }
  
  private static ByteBuf newBuffer(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      paramByteBufAllocator = paramByteBufAllocator.directBuffer(paramInt);
    } else {
      paramByteBufAllocator = paramByteBufAllocator.buffer(paramInt);
    }
    return paramByteBufAllocator;
  }
  
  static PemEncoded toPEM(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, X509Certificate... paramVarArgs)
    throws CertificateEncodingException
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (paramVarArgs.length == 1)
      {
        localObject1 = paramVarArgs[0];
        if ((localObject1 instanceof PemEncoded)) {
          return ((PemEncoded)localObject1).retain();
        }
      }
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        int i = paramVarArgs.length;
        int j = 0;
        while (j < i)
        {
          Object localObject3 = paramVarArgs[j];
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if ((localObject3 instanceof PemEncoded))
            {
              localObject2 = localObject1;
              localObject1 = append(paramByteBufAllocator, paramBoolean, (PemEncoded)localObject3, paramVarArgs.length, (ByteBuf)localObject1);
            }
            else
            {
              localObject2 = localObject1;
              localObject1 = append(paramByteBufAllocator, paramBoolean, (X509Certificate)localObject3, paramVarArgs.length, (ByteBuf)localObject1);
            }
            j++;
          }
          else
          {
            localObject2 = localObject1;
            localObject3 = new java/lang/IllegalArgumentException;
            localObject2 = localObject1;
            paramByteBufAllocator = new java/lang/StringBuilder;
            localObject2 = localObject1;
            paramByteBufAllocator.<init>();
            localObject2 = localObject1;
            paramByteBufAllocator.append("Null element in chain: ");
            localObject2 = localObject1;
            paramByteBufAllocator.append(Arrays.toString(paramVarArgs));
            localObject2 = localObject1;
            ((IllegalArgumentException)localObject3).<init>(paramByteBufAllocator.toString());
            localObject2 = localObject1;
            throw ((Throwable)localObject3);
          }
        }
        localObject2 = localObject1;
        paramByteBufAllocator = new PemValue((ByteBuf)localObject1, false);
        return paramByteBufAllocator;
      }
      finally
      {
        if (localObject2 != null) {
          ((ReferenceCounted)localObject2).release();
        }
      }
    }
    throw new IllegalArgumentException("X.509 certificate chain can't be null or empty");
  }
  
  public static PemX509Certificate valueOf(ByteBuf paramByteBuf)
  {
    return new PemX509Certificate(paramByteBuf);
  }
  
  public static PemX509Certificate valueOf(byte[] paramArrayOfByte)
  {
    return valueOf(Unpooled.wrappedBuffer(paramArrayOfByte));
  }
  
  public void checkValidity()
  {
    throw new UnsupportedOperationException();
  }
  
  public void checkValidity(Date paramDate)
  {
    throw new UnsupportedOperationException();
  }
  
  public ByteBuf content()
  {
    int i = refCnt();
    if (i > 0) {
      return this.content;
    }
    throw new IllegalReferenceCountException(i);
  }
  
  public PemX509Certificate copy()
  {
    return replace(this.content.copy());
  }
  
  public PemX509Certificate duplicate()
  {
    return replace(this.content.duplicate());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof PemX509Certificate)) {
      return false;
    }
    paramObject = (PemX509Certificate)paramObject;
    return this.content.equals(((PemX509Certificate)paramObject).content);
  }
  
  public int getBasicConstraints()
  {
    throw new UnsupportedOperationException();
  }
  
  public Set<String> getCriticalExtensionOIDs()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getEncoded()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getExtensionValue(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public Principal getIssuerDN()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean[] getIssuerUniqueID()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean[] getKeyUsage()
  {
    throw new UnsupportedOperationException();
  }
  
  public Set<String> getNonCriticalExtensionOIDs()
  {
    throw new UnsupportedOperationException();
  }
  
  public Date getNotAfter()
  {
    throw new UnsupportedOperationException();
  }
  
  public Date getNotBefore()
  {
    throw new UnsupportedOperationException();
  }
  
  public PublicKey getPublicKey()
  {
    throw new UnsupportedOperationException();
  }
  
  public BigInteger getSerialNumber()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getSigAlgName()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getSigAlgOID()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getSigAlgParams()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getSignature()
  {
    throw new UnsupportedOperationException();
  }
  
  public Principal getSubjectDN()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean[] getSubjectUniqueID()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getTBSCertificate()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getVersion()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasUnsupportedCriticalExtension()
  {
    throw new UnsupportedOperationException();
  }
  
  public int hashCode()
  {
    return this.content.hashCode();
  }
  
  public boolean isSensitive()
  {
    return false;
  }
  
  public int refCnt()
  {
    return this.content.refCnt();
  }
  
  public boolean release()
  {
    return this.content.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.content.release(paramInt);
  }
  
  public PemX509Certificate replace(ByteBuf paramByteBuf)
  {
    return new PemX509Certificate(paramByteBuf);
  }
  
  public PemX509Certificate retain()
  {
    this.content.retain();
    return this;
  }
  
  public PemX509Certificate retain(int paramInt)
  {
    this.content.retain(paramInt);
    return this;
  }
  
  public PemX509Certificate retainedDuplicate()
  {
    return replace(this.content.retainedDuplicate());
  }
  
  public String toString()
  {
    return this.content.toString(CharsetUtil.UTF_8);
  }
  
  public PemX509Certificate touch()
  {
    this.content.touch();
    return this;
  }
  
  public PemX509Certificate touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
  
  public void verify(PublicKey paramPublicKey)
  {
    throw new UnsupportedOperationException();
  }
  
  public void verify(PublicKey paramPublicKey, String paramString)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\PemX509Certificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */