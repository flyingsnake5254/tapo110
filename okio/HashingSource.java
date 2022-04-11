package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource
  extends ForwardingSource
{
  private final Mac mac;
  private final MessageDigest messageDigest;
  
  private HashingSource(Source paramSource, String paramString)
  {
    super(paramSource);
    try
    {
      this.messageDigest = MessageDigest.getInstance(paramString);
      this.mac = null;
      return;
    }
    catch (NoSuchAlgorithmException paramSource)
    {
      throw new AssertionError();
    }
  }
  
  private HashingSource(Source paramSource, ByteString paramByteString, String paramString)
  {
    super(paramSource);
    try
    {
      paramSource = Mac.getInstance(paramString);
      this.mac = paramSource;
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramByteString.toByteArray(), paramString);
      paramSource.init(localSecretKeySpec);
      this.messageDigest = null;
      return;
    }
    catch (InvalidKeyException paramSource)
    {
      throw new IllegalArgumentException(paramSource);
    }
    catch (NoSuchAlgorithmException paramSource)
    {
      throw new AssertionError();
    }
  }
  
  public static HashingSource hmacSha1(Source paramSource, ByteString paramByteString)
  {
    return new HashingSource(paramSource, paramByteString, "HmacSHA1");
  }
  
  public static HashingSource hmacSha256(Source paramSource, ByteString paramByteString)
  {
    return new HashingSource(paramSource, paramByteString, "HmacSHA256");
  }
  
  public static HashingSource md5(Source paramSource)
  {
    return new HashingSource(paramSource, "MD5");
  }
  
  public static HashingSource sha1(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-1");
  }
  
  public static HashingSource sha256(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-256");
  }
  
  public final ByteString hash()
  {
    Object localObject = this.messageDigest;
    if (localObject != null) {
      localObject = ((MessageDigest)localObject).digest();
    } else {
      localObject = this.mac.doFinal();
    }
    return ByteString.of((byte[])localObject);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    long l1 = super.read(paramBuffer, paramLong);
    if (l1 != -1L)
    {
      paramLong = paramBuffer.size;
      long l2 = paramLong - l1;
      Object localObject1 = paramBuffer.head;
      long l3;
      long l4;
      Object localObject2;
      for (;;)
      {
        l3 = paramLong;
        l4 = l2;
        localObject2 = localObject1;
        if (paramLong <= l2) {
          break;
        }
        localObject1 = ((Segment)localObject1).prev;
        paramLong -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
      }
      while (l3 < paramBuffer.size)
      {
        int i = (int)(((Segment)localObject2).pos + l4 - l3);
        localObject1 = this.messageDigest;
        if (localObject1 != null) {
          ((MessageDigest)localObject1).update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        } else {
          this.mac.update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        }
        l4 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l3;
        localObject2 = ((Segment)localObject2).next;
        l3 = l4;
      }
    }
    return l1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\HashingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */