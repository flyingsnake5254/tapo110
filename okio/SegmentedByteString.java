package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString
  extends ByteString
{
  final transient int[] directory;
  final transient byte[][] segments;
  
  SegmentedByteString(Buffer paramBuffer, int paramInt)
  {
    super(null);
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramInt);
    Object localObject = paramBuffer.head;
    int i = 0;
    int j = 0;
    int k = 0;
    int n;
    while (j < paramInt)
    {
      int m = ((Segment)localObject).limit;
      n = ((Segment)localObject).pos;
      if (m != n)
      {
        j += m - n;
        k++;
        localObject = ((Segment)localObject).next;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    this.segments = new byte[k][];
    this.directory = new int[k * 2];
    paramBuffer = paramBuffer.head;
    j = 0;
    k = i;
    while (k < paramInt)
    {
      localObject = this.segments;
      localObject[j] = paramBuffer.data;
      i = paramBuffer.limit;
      n = paramBuffer.pos;
      i = k + (i - n);
      k = i;
      if (i > paramInt) {
        k = paramInt;
      }
      int[] arrayOfInt = this.directory;
      arrayOfInt[j] = k;
      arrayOfInt[(localObject.length + j)] = n;
      paramBuffer.shared = true;
      j++;
      paramBuffer = paramBuffer.next;
    }
  }
  
  private int segment(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.directory, 0, this.segments.length, paramInt + 1);
    if (paramInt < 0) {
      paramInt ^= 0xFFFFFFFF;
    }
    return paramInt;
  }
  
  private ByteString toByteString()
  {
    return new ByteString(toByteArray());
  }
  
  private Object writeReplace()
  {
    return toByteString();
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public String base64()
  {
    return toByteString().base64();
  }
  
  public String base64Url()
  {
    return toByteString().base64Url();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((((ByteString)paramObject).size() == size()) && (rangeEquals(0, (ByteString)paramObject, 0, size()))) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public byte getByte(int paramInt)
  {
    Util.checkOffsetAndCount(this.directory[(this.segments.length - 1)], paramInt, 1L);
    int i = segment(paramInt);
    int j;
    if (i == 0) {
      j = 0;
    } else {
      j = this.directory[(i - 1)];
    }
    int[] arrayOfInt = this.directory;
    byte[][] arrayOfByte = this.segments;
    int k = arrayOfInt[(arrayOfByte.length + i)];
    return arrayOfByte[i][(paramInt - j + k)];
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    int j = this.segments.length;
    int k = 0;
    int m = 0;
    int n = 1;
    while (k < j)
    {
      byte[] arrayOfByte = this.segments[k];
      int[] arrayOfInt = this.directory;
      int i1 = arrayOfInt[(j + k)];
      int i2 = arrayOfInt[k];
      for (i = i1; i < i2 - m + i1; i++) {
        n = n * 31 + arrayOfByte[i];
      }
      k++;
      m = i2;
    }
    this.hashCode = n;
    return n;
  }
  
  public String hex()
  {
    return toByteString().hex();
  }
  
  public ByteString hmacSha1(ByteString paramByteString)
  {
    return toByteString().hmacSha1(paramByteString);
  }
  
  public ByteString hmacSha256(ByteString paramByteString)
  {
    return toByteString().hmacSha256(paramByteString);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return toByteString().indexOf(paramArrayOfByte, paramInt);
  }
  
  byte[] internalArray()
  {
    return toByteArray();
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return toByteString().lastIndexOf(paramArrayOfByte, paramInt);
  }
  
  public ByteString md5()
  {
    return toByteString().md5();
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= size() - paramInt3))
    {
      for (int i = segment(paramInt1); paramInt3 > 0; i++)
      {
        int j;
        if (i == 0) {
          j = 0;
        } else {
          j = this.directory[(i - 1)];
        }
        int k = Math.min(paramInt3, this.directory[i] - j + j - paramInt1);
        int[] arrayOfInt = this.directory;
        byte[][] arrayOfByte = this.segments;
        int m = arrayOfInt[(arrayOfByte.length + i)];
        if (!paramByteString.rangeEquals(paramInt2, arrayOfByte[i], paramInt1 - j + m, k)) {
          return false;
        }
        paramInt1 += k;
        paramInt2 += k;
        paramInt3 -= k;
      }
      return true;
    }
    return false;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= size() - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3))
    {
      for (int i = segment(paramInt1); paramInt3 > 0; i++)
      {
        int j;
        if (i == 0) {
          j = 0;
        } else {
          j = this.directory[(i - 1)];
        }
        int k = Math.min(paramInt3, this.directory[i] - j + j - paramInt1);
        int[] arrayOfInt = this.directory;
        byte[][] arrayOfByte = this.segments;
        int m = arrayOfInt[(arrayOfByte.length + i)];
        if (!Util.arrayRangeEquals(arrayOfByte[i], paramInt1 - j + m, paramArrayOfByte, paramInt2, k)) {
          return false;
        }
        paramInt1 += k;
        paramInt2 += k;
        paramInt3 -= k;
      }
      return true;
    }
    return false;
  }
  
  public ByteString sha1()
  {
    return toByteString().sha1();
  }
  
  public ByteString sha256()
  {
    return toByteString().sha256();
  }
  
  public int size()
  {
    return this.directory[(this.segments.length - 1)];
  }
  
  public String string(Charset paramCharset)
  {
    return toByteString().string(paramCharset);
  }
  
  public ByteString substring(int paramInt)
  {
    return toByteString().substring(paramInt);
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    return toByteString().substring(paramInt1, paramInt2);
  }
  
  public ByteString toAsciiLowercase()
  {
    return toByteString().toAsciiLowercase();
  }
  
  public ByteString toAsciiUppercase()
  {
    return toByteString().toAsciiUppercase();
  }
  
  public byte[] toByteArray()
  {
    Object localObject1 = this.directory;
    Object localObject2 = this.segments;
    localObject1 = new byte[localObject1[(localObject2.length - 1)]];
    int i = localObject2.length;
    int j = 0;
    int n;
    for (int k = 0; j < i; k = n)
    {
      localObject2 = this.directory;
      int m = localObject2[(i + j)];
      n = localObject2[j];
      System.arraycopy(this.segments[j], m, localObject1, k, n - k);
      j++;
    }
    return (byte[])localObject1;
  }
  
  public String toString()
  {
    return toByteString().toString();
  }
  
  public String utf8()
  {
    return toByteString().utf8();
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      int i = this.segments.length;
      int j = 0;
      int n;
      for (int k = 0; j < i; k = n)
      {
        int[] arrayOfInt = this.directory;
        int m = arrayOfInt[(i + j)];
        n = arrayOfInt[j];
        paramOutputStream.write(this.segments[j], m, n - k);
        j++;
      }
      return;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  void write(Buffer paramBuffer)
  {
    int i = this.segments.length;
    int j = 0;
    int n;
    for (int k = 0; j < i; k = n)
    {
      Object localObject = this.directory;
      int m = localObject[(i + j)];
      n = localObject[j];
      Segment localSegment = new Segment(this.segments[j], m, m + n - k, true, false);
      localObject = paramBuffer.head;
      if (localObject == null)
      {
        localSegment.prev = localSegment;
        localSegment.next = localSegment;
        paramBuffer.head = localSegment;
      }
      else
      {
        ((Segment)localObject).prev.push(localSegment);
      }
      j++;
    }
    paramBuffer.size += k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\SegmentedByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */