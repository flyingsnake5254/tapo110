package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final ByteString EMPTY = of(new byte[0]);
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long serialVersionUID = 1L;
  final byte[] data;
  transient int hashCode;
  transient String utf8;
  
  ByteString(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  static int codePointIndexToCharIndex(String paramString, int paramInt)
  {
    int i = paramString.length();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      if (k == paramInt) {
        return j;
      }
      int m = paramString.codePointAt(j);
      if (((Character.isISOControl(m)) && (m != 10) && (m != 13)) || (m == 65533)) {
        return -1;
      }
      k++;
      j += Character.charCount(m);
    }
    return paramString.length();
  }
  
  @Nullable
  public static ByteString decodeBase64(String paramString)
  {
    if (paramString != null)
    {
      paramString = Base64.decode(paramString);
      if (paramString != null) {
        paramString = new ByteString(paramString);
      } else {
        paramString = null;
      }
      return paramString;
    }
    throw new IllegalArgumentException("base64 == null");
  }
  
  public static ByteString decodeHex(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() % 2 == 0)
      {
        int i = paramString.length() / 2;
        localObject = new byte[i];
        for (int j = 0; j < i; j++)
        {
          int k = j * 2;
          localObject[j] = ((byte)(byte)((decodeHexDigit(paramString.charAt(k)) << 4) + decodeHexDigit(paramString.charAt(k + 1))));
        }
        return of((byte[])localObject);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected hex string: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("hex == null");
  }
  
  private static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      return paramChar - c + 10;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected hex digit: ");
    localStringBuilder.append(paramChar);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private ByteString digest(String paramString)
  {
    try
    {
      paramString = of(MessageDigest.getInstance(paramString).digest(this.data));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static ByteString encodeString(String paramString, Charset paramCharset)
  {
    if (paramString != null)
    {
      if (paramCharset != null) {
        return new ByteString(paramString.getBytes(paramCharset));
      }
      throw new IllegalArgumentException("charset == null");
    }
    throw new IllegalArgumentException("s == null");
  }
  
  public static ByteString encodeUtf8(String paramString)
  {
    if (paramString != null)
    {
      ByteString localByteString = new ByteString(paramString.getBytes(Util.UTF_8));
      localByteString.utf8 = paramString;
      return localByteString;
    }
    throw new IllegalArgumentException("s == null");
  }
  
  private ByteString hmac(String paramString, ByteString paramByteString)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramByteString.toByteArray(), paramString);
      localMac.init(localSecretKeySpec);
      paramString = of(localMac.doFinal(this.data));
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static ByteString of(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte);
      return new ByteString(arrayOfByte);
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString of(byte... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return new ByteString((byte[])paramVarArgs.clone());
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return new ByteString(arrayOfByte);
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream != null)
    {
      if (paramInt >= 0)
      {
        byte[] arrayOfByte = new byte[paramInt];
        int i = 0;
        while (i < paramInt)
        {
          int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
          if (j != -1) {
            i += j;
          } else {
            throw new EOFException();
          }
        }
        return new ByteString(arrayOfByte);
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("byteCount < 0: ");
      paramInputStream.append(paramInt);
      throw new IllegalArgumentException(paramInputStream.toString());
    }
    throw new IllegalArgumentException("in == null");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    ByteString localByteString = read(paramObjectInputStream, paramObjectInputStream.readInt());
    try
    {
      paramObjectInputStream = ByteString.class.getDeclaredField("data");
      paramObjectInputStream.setAccessible(true);
      paramObjectInputStream.set(this, localByteString.data);
      return;
    }
    catch (IllegalAccessException paramObjectInputStream)
    {
      throw new AssertionError();
    }
    catch (NoSuchFieldException paramObjectInputStream)
    {
      throw new AssertionError();
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
  }
  
  public String base64()
  {
    return Base64.encode(this.data);
  }
  
  public String base64Url()
  {
    return Base64.encodeUrl(this.data);
  }
  
  public int compareTo(ByteString paramByteString)
  {
    int i = size();
    int j = paramByteString.size();
    int k = Math.min(i, j);
    int n;
    int i1;
    int i2;
    for (int m = 0;; m++)
    {
      n = -1;
      if (m >= k) {
        break label83;
      }
      i1 = getByte(m) & 0xFF;
      i2 = paramByteString.getByte(m) & 0xFF;
      if (i1 != i2) {
        break;
      }
    }
    if (i1 >= i2) {
      n = 1;
    }
    return n;
    label83:
    if (i == j) {
      return 0;
    }
    if (i >= j) {
      n = 1;
    }
    return n;
  }
  
  public final boolean endsWith(ByteString paramByteString)
  {
    return rangeEquals(size() - paramByteString.size(), paramByteString, 0, paramByteString.size());
  }
  
  public final boolean endsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(size() - paramArrayOfByte.length, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      ByteString localByteString = (ByteString)paramObject;
      int i = localByteString.size();
      paramObject = this.data;
      if ((i == paramObject.length) && (localByteString.rangeEquals(0, (byte[])paramObject, 0, paramObject.length))) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public byte getByte(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i == 0)
    {
      i = Arrays.hashCode(this.data);
      this.hashCode = i;
    }
    return i;
  }
  
  public String hex()
  {
    byte[] arrayOfByte = this.data;
    char[] arrayOfChar1 = new char[arrayOfByte.length * 2];
    int i = arrayOfByte.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      int m = arrayOfByte[j];
      int n = k + 1;
      char[] arrayOfChar2 = HEX_DIGITS;
      arrayOfChar1[k] = ((char)arrayOfChar2[(m >> 4 & 0xF)]);
      k = n + 1;
      arrayOfChar1[n] = ((char)arrayOfChar2[(m & 0xF)]);
      j++;
    }
    return new String(arrayOfChar1);
  }
  
  public ByteString hmacSha1(ByteString paramByteString)
  {
    return hmac("HmacSHA1", paramByteString);
  }
  
  public ByteString hmacSha256(ByteString paramByteString)
  {
    return hmac("HmacSHA256", paramByteString);
  }
  
  public ByteString hmacSha512(ByteString paramByteString)
  {
    return hmac("HmacSHA512", paramByteString);
  }
  
  public final int indexOf(ByteString paramByteString)
  {
    return indexOf(paramByteString.internalArray(), 0);
  }
  
  public final int indexOf(ByteString paramByteString, int paramInt)
  {
    return indexOf(paramByteString.internalArray(), paramInt);
  }
  
  public final int indexOf(byte[] paramArrayOfByte)
  {
    return indexOf(paramArrayOfByte, 0);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    int i = this.data.length;
    int j = paramArrayOfByte.length;
    while (paramInt <= i - j)
    {
      if (Util.arrayRangeEquals(this.data, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt++;
    }
    return -1;
  }
  
  byte[] internalArray()
  {
    return this.data;
  }
  
  public final int lastIndexOf(ByteString paramByteString)
  {
    return lastIndexOf(paramByteString.internalArray(), size());
  }
  
  public final int lastIndexOf(ByteString paramByteString, int paramInt)
  {
    return lastIndexOf(paramByteString.internalArray(), paramInt);
  }
  
  public final int lastIndexOf(byte[] paramArrayOfByte)
  {
    return lastIndexOf(paramArrayOfByte, size());
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    for (paramInt = Math.min(paramInt, this.data.length - paramArrayOfByte.length); paramInt >= 0; paramInt--) {
      if (Util.arrayRangeEquals(this.data, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
    }
    return -1;
  }
  
  public ByteString md5()
  {
    return digest("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return paramByteString.rangeEquals(paramInt2, this.data, paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      byte[] arrayOfByte = this.data;
      if ((paramInt1 <= arrayOfByte.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (Util.arrayRangeEquals(arrayOfByte, paramInt1, paramArrayOfByte, paramInt2, paramInt3)))
      {
        bool = true;
        break label55;
      }
    }
    boolean bool = false;
    label55:
    return bool;
  }
  
  public ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  public ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public ByteString sha512()
  {
    return digest("SHA-512");
  }
  
  public int size()
  {
    return this.data.length;
  }
  
  public final boolean startsWith(ByteString paramByteString)
  {
    return rangeEquals(0, paramByteString, 0, paramByteString.size());
  }
  
  public final boolean startsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(0, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public String string(Charset paramCharset)
  {
    if (paramCharset != null) {
      return new String(this.data, paramCharset);
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public ByteString substring(int paramInt)
  {
    return substring(paramInt, this.data.length);
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      Object localObject = this.data;
      if (paramInt2 <= localObject.length)
      {
        int i = paramInt2 - paramInt1;
        if (i >= 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == localObject.length)) {
            return this;
          }
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(localObject, paramInt1, arrayOfByte, 0, i);
          return new ByteString(arrayOfByte);
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endIndex > length(");
      ((StringBuilder)localObject).append(this.data.length);
      ((StringBuilder)localObject).append(")");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("beginIndex < 0");
  }
  
  public ByteString toAsciiLowercase()
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = this.data;
      if (i >= arrayOfByte.length) {
        break;
      }
      int j = arrayOfByte[i];
      if ((j >= 65) && (j <= 90))
      {
        arrayOfByte = (byte[])arrayOfByte.clone();
        int k = i + 1;
        arrayOfByte[i] = ((byte)(byte)(j + 32));
        for (i = k; i < arrayOfByte.length; i++)
        {
          k = arrayOfByte[i];
          if ((k >= 65) && (k <= 90)) {
            arrayOfByte[i] = ((byte)(byte)(k + 32));
          }
        }
        return new ByteString(arrayOfByte);
      }
    }
    return this;
  }
  
  public ByteString toAsciiUppercase()
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = this.data;
      if (i >= arrayOfByte.length) {
        break;
      }
      int j = arrayOfByte[i];
      if ((j >= 97) && (j <= 122))
      {
        arrayOfByte = (byte[])arrayOfByte.clone();
        int k = i + 1;
        arrayOfByte[i] = ((byte)(byte)(j - 32));
        for (i = k; i < arrayOfByte.length; i++)
        {
          k = arrayOfByte[i];
          if ((k >= 97) && (k <= 122)) {
            arrayOfByte[i] = ((byte)(byte)(k - 32));
          }
        }
        return new ByteString(arrayOfByte);
      }
    }
    return this;
  }
  
  public byte[] toByteArray()
  {
    return (byte[])this.data.clone();
  }
  
  public String toString()
  {
    if (this.data.length == 0) {
      return "[size=0]";
    }
    Object localObject1 = utf8();
    int i = codePointIndexToCharIndex((String)localObject1, 64);
    if (i == -1)
    {
      if (this.data.length <= 64)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[hex=");
        ((StringBuilder)localObject2).append(hex());
        ((StringBuilder)localObject2).append("]");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[size=");
        ((StringBuilder)localObject2).append(this.data.length);
        ((StringBuilder)localObject2).append(" hex=");
        ((StringBuilder)localObject2).append(substring(0, 64).hex());
        ((StringBuilder)localObject2).append("…]");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      return (String)localObject2;
    }
    Object localObject2 = ((String)localObject1).substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < ((String)localObject1).length())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[size=");
      ((StringBuilder)localObject1).append(this.data.length);
      ((StringBuilder)localObject1).append(" text=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("…]");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[text=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("]");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    return (String)localObject2;
  }
  
  public String utf8()
  {
    String str = this.utf8;
    if (str == null)
    {
      str = new String(this.data, Util.UTF_8);
      this.utf8 = str;
    }
    return str;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      paramOutputStream.write(this.data);
      return;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  void write(Buffer paramBuffer)
  {
    byte[] arrayOfByte = this.data;
    paramBuffer.write(arrayOfByte, 0, arrayOfByte.length);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */