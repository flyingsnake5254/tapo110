package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSink
  extends ForwardingSink
{
  @Nullable
  private final Mac mac;
  @Nullable
  private final MessageDigest messageDigest;
  
  private HashingSink(Sink paramSink, String paramString)
  {
    super(paramSink);
    try
    {
      this.messageDigest = MessageDigest.getInstance(paramString);
      this.mac = null;
      return;
    }
    catch (NoSuchAlgorithmException paramSink)
    {
      throw new AssertionError();
    }
  }
  
  private HashingSink(Sink paramSink, ByteString paramByteString, String paramString)
  {
    super(paramSink);
    try
    {
      paramSink = Mac.getInstance(paramString);
      this.mac = paramSink;
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramByteString.toByteArray(), paramString);
      paramSink.init(localSecretKeySpec);
      this.messageDigest = null;
      return;
    }
    catch (InvalidKeyException paramSink)
    {
      throw new IllegalArgumentException(paramSink);
    }
    catch (NoSuchAlgorithmException paramSink)
    {
      throw new AssertionError();
    }
  }
  
  public static HashingSink hmacSha1(Sink paramSink, ByteString paramByteString)
  {
    return new HashingSink(paramSink, paramByteString, "HmacSHA1");
  }
  
  public static HashingSink hmacSha256(Sink paramSink, ByteString paramByteString)
  {
    return new HashingSink(paramSink, paramByteString, "HmacSHA256");
  }
  
  public static HashingSink hmacSha512(Sink paramSink, ByteString paramByteString)
  {
    return new HashingSink(paramSink, paramByteString, "HmacSHA512");
  }
  
  public static HashingSink md5(Sink paramSink)
  {
    return new HashingSink(paramSink, "MD5");
  }
  
  public static HashingSink sha1(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-1");
  }
  
  public static HashingSink sha256(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-256");
  }
  
  public static HashingSink sha512(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-512");
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
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    Segment localSegment = paramBuffer.head;
    long l = 0L;
    while (l < paramLong)
    {
      int i = (int)Math.min(paramLong - l, localSegment.limit - localSegment.pos);
      MessageDigest localMessageDigest = this.messageDigest;
      if (localMessageDigest != null) {
        localMessageDigest.update(localSegment.data, localSegment.pos, i);
      } else {
        this.mac.update(localSegment.data, localSegment.pos, i);
      }
      l += i;
      localSegment = localSegment.next;
    }
    super.write(paramBuffer, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\HashingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */