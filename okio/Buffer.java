package okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer
  implements BufferedSource, BufferedSink, Cloneable, ByteChannel
{
  private static final byte[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final int REPLACEMENT_CHARACTER = 65533;
  @Nullable
  Segment head;
  long size;
  
  private ByteString digest(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      paramString = this.head;
      if (paramString != null)
      {
        byte[] arrayOfByte = paramString.data;
        int i = paramString.pos;
        localMessageDigest.update(arrayOfByte, i, paramString.limit - i);
        paramString = this.head;
        for (;;)
        {
          paramString = paramString.next;
          if (paramString == this.head) {
            break;
          }
          arrayOfByte = paramString.data;
          i = paramString.pos;
          localMessageDigest.update(arrayOfByte, i, paramString.limit - i);
        }
      }
      paramString = ByteString.of(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError();
    }
  }
  
  private ByteString hmac(String paramString, ByteString paramByteString)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramByteString.toByteArray(), paramString);
      localMac.init(localSecretKeySpec);
      paramString = this.head;
      if (paramString != null)
      {
        paramByteString = paramString.data;
        int i = paramString.pos;
        localMac.update(paramByteString, i, paramString.limit - i);
        paramString = this.head;
        for (;;)
        {
          paramString = paramString.next;
          if (paramString == this.head) {
            break;
          }
          paramByteString = paramString.data;
          i = paramString.pos;
          localMac.update(paramByteString, i, paramString.limit - i);
        }
      }
      paramString = ByteString.of(localMac.doFinal());
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError();
    }
  }
  
  private boolean rangeEquals(Segment paramSegment, int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    int i = paramSegment.limit;
    byte[] arrayOfByte = paramSegment.data;
    for (Segment localSegment = paramSegment; paramInt2 < paramInt3; localSegment = paramSegment)
    {
      int j = i;
      paramSegment = localSegment;
      int k = paramInt1;
      if (paramInt1 == i)
      {
        paramSegment = localSegment.next;
        arrayOfByte = paramSegment.data;
        k = paramSegment.pos;
        j = paramSegment.limit;
      }
      if (arrayOfByte[k] != paramByteString.getByte(paramInt2)) {
        return false;
      }
      paramInt1 = k + 1;
      paramInt2++;
      i = j;
    }
    return true;
  }
  
  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
    throws IOException
  {
    if (paramInputStream != null) {
      for (;;)
      {
        if ((paramLong <= 0L) && (!paramBoolean)) {
          return;
        }
        Segment localSegment = writableSegment(1);
        int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
        i = paramInputStream.read(localSegment.data, localSegment.limit, i);
        if (i == -1)
        {
          if (paramBoolean) {
            return;
          }
          throw new EOFException();
        }
        localSegment.limit += i;
        long l1 = this.size;
        long l2 = i;
        this.size = (l1 + l2);
        paramLong -= l2;
      }
    }
    throw new IllegalArgumentException("in == null");
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  public final void clear()
  {
    try
    {
      skip(this.size);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public Buffer clone()
  {
    Buffer localBuffer = new Buffer();
    if (this.size == 0L) {
      return localBuffer;
    }
    Segment localSegment = this.head.sharedCopy();
    localBuffer.head = localSegment;
    localSegment.prev = localSegment;
    localSegment.next = localSegment;
    localSegment = this.head;
    for (;;)
    {
      localSegment = localSegment.next;
      if (localSegment == this.head) {
        break;
      }
      localBuffer.head.prev.push(localSegment.sharedCopy());
    }
    localBuffer.size = this.size;
    return localBuffer;
  }
  
  public void close() {}
  
  public final long completeSegmentByteCount()
  {
    long l1 = this.size;
    if (l1 == 0L) {
      return 0L;
    }
    Segment localSegment = this.head.prev;
    int i = localSegment.limit;
    long l2 = l1;
    if (i < 8192)
    {
      l2 = l1;
      if (localSegment.owner) {
        l2 = l1 - (i - localSegment.pos);
      }
    }
    return l2;
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    return copyTo(paramOutputStream, 0L, this.size);
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
      if (paramLong2 == 0L) {
        return this;
      }
      int i;
      int j;
      Segment localSegment2;
      long l1;
      long l2;
      for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
      {
        i = localSegment1.limit;
        j = localSegment1.pos;
        localSegment2 = localSegment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < i - j) {
          break;
        }
        paramLong1 -= i - j;
      }
      while (l2 > 0L)
      {
        i = (int)(localSegment2.pos + l1);
        j = (int)Math.min(localSegment2.limit - i, l2);
        paramOutputStream.write(localSegment2.data, i, j);
        l2 -= j;
        localSegment2 = localSegment2.next;
        l1 = 0L;
      }
      return this;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public final Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    if (paramBuffer != null)
    {
      Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
      if (paramLong2 == 0L) {
        return this;
      }
      paramBuffer.size += paramLong2;
      int j;
      Segment localSegment2;
      long l1;
      long l2;
      for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
      {
        int i = localSegment1.limit;
        j = localSegment1.pos;
        localSegment2 = localSegment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < i - j) {
          break;
        }
        paramLong1 -= i - j;
      }
      while (l2 > 0L)
      {
        localSegment1 = localSegment2.sharedCopy();
        j = (int)(localSegment1.pos + l1);
        localSegment1.pos = j;
        localSegment1.limit = Math.min(j + (int)l2, localSegment1.limit);
        Segment localSegment3 = paramBuffer.head;
        if (localSegment3 == null)
        {
          localSegment1.prev = localSegment1;
          localSegment1.next = localSegment1;
          paramBuffer.head = localSegment1;
        }
        else
        {
          localSegment3.prev.push(localSegment1);
        }
        l2 -= localSegment1.limit - localSegment1.pos;
        localSegment2 = localSegment2.next;
        l1 = 0L;
      }
      return this;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public BufferedSink emit()
  {
    return this;
  }
  
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    long l1 = this.size;
    if (l1 != ((Buffer)paramObject).size) {
      return false;
    }
    long l2 = 0L;
    if (l1 == 0L) {
      return true;
    }
    Object localObject1 = this.head;
    paramObject = ((Buffer)paramObject).head;
    int i = ((Segment)localObject1).pos;
    int j = ((Segment)paramObject).pos;
    while (l2 < this.size)
    {
      l1 = Math.min(((Segment)localObject1).limit - i, ((Segment)paramObject).limit - j);
      int k = 0;
      while (k < l1)
      {
        if (localObject1.data[i] != paramObject.data[j]) {
          return false;
        }
        k++;
        i++;
        j++;
      }
      Object localObject2 = localObject1;
      k = i;
      if (i == ((Segment)localObject1).limit)
      {
        localObject2 = ((Segment)localObject1).next;
        k = ((Segment)localObject2).pos;
      }
      int m = j;
      Object localObject3 = paramObject;
      if (j == ((Segment)paramObject).limit)
      {
        localObject3 = ((Segment)paramObject).next;
        m = ((Segment)localObject3).pos;
      }
      l2 += l1;
      localObject1 = localObject2;
      i = k;
      j = m;
      paramObject = localObject3;
    }
    return true;
  }
  
  public boolean exhausted()
  {
    boolean bool;
    if (this.size == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void flush() {}
  
  public Buffer getBuffer()
  {
    return this;
  }
  
  public final byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    long l = this.size;
    int i;
    int j;
    if (l - paramLong > paramLong) {
      for (localObject = this.head;; localObject = ((Segment)localObject).next)
      {
        i = ((Segment)localObject).limit;
        j = ((Segment)localObject).pos;
        l = i - j;
        if (paramLong < l) {
          return localObject.data[(j + (int)paramLong)];
        }
        paramLong -= l;
      }
    }
    paramLong -= l;
    Object localObject = this.head;
    Segment localSegment;
    do
    {
      localSegment = ((Segment)localObject).prev;
      i = localSegment.limit;
      j = localSegment.pos;
      l = paramLong + (i - j);
      localObject = localSegment;
      paramLong = l;
    } while (l < 0L);
    return localSegment.data[(j + (int)l)];
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject == null) {
      return 0;
    }
    int i = 1;
    int m;
    Segment localSegment;
    do
    {
      int j = ((Segment)localObject).pos;
      int k = ((Segment)localObject).limit;
      m = i;
      while (j < k)
      {
        m = m * 31 + localObject.data[j];
        j++;
      }
      localSegment = ((Segment)localObject).next;
      localObject = localSegment;
      i = m;
    } while (localSegment != this.head);
    return m;
  }
  
  public final ByteString hmacSha1(ByteString paramByteString)
  {
    return hmac("HmacSHA1", paramByteString);
  }
  
  public final ByteString hmacSha256(ByteString paramByteString)
  {
    return hmac("HmacSHA256", paramByteString);
  }
  
  public final ByteString hmacSha512(ByteString paramByteString)
  {
    return hmac("HmacSHA512", paramByteString);
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    return indexOf(paramByte, paramLong, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2)
  {
    long l1 = 0L;
    if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
    {
      long l2 = this.size;
      long l3;
      if (paramLong2 > l2) {
        l3 = l2;
      } else {
        l3 = paramLong2;
      }
      if (paramLong1 == l3) {
        return -1L;
      }
      Object localObject1 = this.head;
      if (localObject1 == null) {
        return -1L;
      }
      paramLong2 = l1;
      Object localObject2 = localObject1;
      if (l2 - paramLong1 < paramLong1) {
        for (;;)
        {
          paramLong2 = l2;
          localObject2 = localObject1;
          if (l2 <= paramLong1) {
            break;
          }
          localObject1 = ((Segment)localObject1).prev;
          l2 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
        }
      }
      for (;;)
      {
        l2 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + paramLong2;
        if (l2 >= paramLong1) {
          break;
        }
        localObject2 = ((Segment)localObject2).next;
        paramLong2 = l2;
      }
      l2 = paramLong2;
      paramLong2 = paramLong1;
      while (l2 < l3)
      {
        localObject1 = ((Segment)localObject2).data;
        int i = (int)Math.min(((Segment)localObject2).limit, ((Segment)localObject2).pos + l3 - l2);
        for (int j = (int)(((Segment)localObject2).pos + paramLong2 - l2); j < i; j++) {
          if (localObject1[j] == paramByte) {
            return j - ((Segment)localObject2).pos + l2;
          }
        }
        paramLong1 = l2 + (((Segment)localObject2).limit - ((Segment)localObject2).pos);
        localObject2 = ((Segment)localObject2).next;
        paramLong2 = paramLong1;
        l2 = paramLong1;
      }
      return -1L;
    }
    throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.size), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public long indexOf(ByteString paramByteString)
    throws IOException
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
    throws IOException
  {
    if (paramByteString.size() != 0)
    {
      long l1 = 0L;
      if (paramLong >= 0L)
      {
        Object localObject1 = this.head;
        if (localObject1 == null) {
          return -1L;
        }
        long l2 = this.size;
        Object localObject2 = localObject1;
        if (l2 - paramLong < paramLong) {
          for (;;)
          {
            localObject2 = localObject1;
            l1 = l2;
            if (l2 <= paramLong) {
              break;
            }
            localObject1 = ((Segment)localObject1).prev;
            l2 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
          }
        }
        for (;;)
        {
          l2 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1;
          if (l2 >= paramLong) {
            break;
          }
          localObject2 = ((Segment)localObject2).next;
          l1 = l2;
        }
        int i = paramByteString.getByte(0);
        int j = paramByteString.size();
        l2 = 1L + (this.size - j);
        while (l1 < l2)
        {
          localObject1 = ((Segment)localObject2).data;
          int k = (int)Math.min(((Segment)localObject2).limit, ((Segment)localObject2).pos + l2 - l1);
          for (int m = (int)(((Segment)localObject2).pos + paramLong - l1); m < k; m++) {
            if ((localObject1[m] == i) && (rangeEquals((Segment)localObject2, m + 1, paramByteString, 1, j))) {
              return m - ((Segment)localObject2).pos + l1;
            }
          }
          l1 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
          localObject2 = ((Segment)localObject2).next;
          paramLong = l1;
        }
        return -1L;
      }
      throw new IllegalArgumentException("fromIndex < 0");
    }
    throw new IllegalArgumentException("bytes is empty");
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    long l1 = 0L;
    if (paramLong >= 0L)
    {
      Object localObject1 = this.head;
      if (localObject1 == null) {
        return -1L;
      }
      long l2 = this.size;
      Object localObject2 = localObject1;
      if (l2 - paramLong < paramLong) {
        for (;;)
        {
          localObject2 = localObject1;
          l1 = l2;
          if (l2 <= paramLong) {
            break;
          }
          localObject1 = ((Segment)localObject1).prev;
          l2 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
        }
      }
      for (;;)
      {
        l2 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1;
        if (l2 >= paramLong) {
          break;
        }
        localObject2 = ((Segment)localObject2).next;
        l1 = l2;
      }
      int i;
      int j;
      int k;
      int m;
      int n;
      if (paramByteString.size() == 2)
      {
        i = paramByteString.getByte(0);
        j = paramByteString.getByte(1);
        while (l1 < this.size)
        {
          paramByteString = ((Segment)localObject2).data;
          k = (int)(((Segment)localObject2).pos + paramLong - l1);
          m = ((Segment)localObject2).limit;
          while (k < m)
          {
            n = paramByteString[k];
            if ((n != i) && (n != j))
            {
              k++;
            }
            else
            {
              m = ((Segment)localObject2).pos;
              return k - m + l1;
            }
          }
          l1 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
          localObject2 = ((Segment)localObject2).next;
          paramLong = l1;
        }
      }
      paramByteString = paramByteString.internalArray();
      for (;;)
      {
        if (l1 >= this.size) {
          break label397;
        }
        localObject1 = ((Segment)localObject2).data;
        k = (int)(((Segment)localObject2).pos + paramLong - l1);
        j = ((Segment)localObject2).limit;
        for (;;)
        {
          if (k >= j) {
            break label367;
          }
          n = localObject1[k];
          i = paramByteString.length;
          for (m = 0;; m++)
          {
            if (m >= i) {
              break label361;
            }
            if (n == paramByteString[m])
            {
              m = ((Segment)localObject2).pos;
              break;
            }
          }
          label361:
          k++;
        }
        label367:
        l1 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
        localObject2 = ((Segment)localObject2).next;
        paramLong = l1;
      }
      label397:
      return -1L;
    }
    throw new IllegalArgumentException("fromIndex < 0");
  }
  
  public InputStream inputStream()
  {
    new InputStream()
    {
      public int available()
      {
        return (int)Math.min(Buffer.this.size, 2147483647L);
      }
      
      public void close() {}
      
      public int read()
      {
        Buffer localBuffer = Buffer.this;
        if (localBuffer.size > 0L) {
          return localBuffer.readByte() & 0xFF;
        }
        return -1;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return Buffer.this.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Buffer.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public final ByteString md5()
  {
    return digest("MD5");
  }
  
  public OutputStream outputStream()
  {
    new OutputStream()
    {
      public void close() {}
      
      public void flush() {}
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Buffer.this);
        localStringBuilder.append(".outputStream()");
        return localStringBuilder.toString();
      }
      
      public void write(int paramAnonymousInt)
      {
        Buffer.this.writeByte((byte)paramAnonymousInt);
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Buffer.this.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public BufferedSource peek()
  {
    return Okio.buffer(new PeekSource(this));
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
  {
    if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 >= 0) && (this.size - paramLong >= paramInt2) && (paramByteString.size() - paramInt1 >= paramInt2))
    {
      for (int i = 0; i < paramInt2; i++) {
        if (getByte(i + paramLong) != paramByteString.getByte(paramInt1 + i)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    Segment localSegment = this.head;
    if (localSegment == null) {
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), localSegment.limit - localSegment.pos);
    paramByteBuffer.put(localSegment.data, localSegment.pos, i);
    int j = localSegment.pos + i;
    localSegment.pos = j;
    this.size -= i;
    if (j == localSegment.limit)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.head;
    if (localSegment == null) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
    System.arraycopy(localSegment.data, localSegment.pos, paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = localSegment.pos + paramInt2;
    localSegment.pos = paramInt1;
    this.size -= paramInt2;
    if (paramInt1 == localSegment.limit)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    return paramInt2;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer != null)
    {
      if (paramLong >= 0L)
      {
        long l1 = this.size;
        if (l1 == 0L) {
          return -1L;
        }
        long l2 = paramLong;
        if (paramLong > l1) {
          l2 = l1;
        }
        paramBuffer.write(this, l2);
        return l2;
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw new IllegalArgumentException(paramBuffer.toString());
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    long l = this.size;
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  public final UnsafeCursor readAndWriteUnsafe()
  {
    return readAndWriteUnsafe(new UnsafeCursor());
  }
  
  public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor paramUnsafeCursor)
  {
    if (paramUnsafeCursor.buffer == null)
    {
      paramUnsafeCursor.buffer = this;
      paramUnsafeCursor.readWrite = true;
      return paramUnsafeCursor;
    }
    throw new IllegalStateException("already attached to a buffer");
  }
  
  public byte readByte()
  {
    long l = this.size;
    if (l != 0L)
    {
      Segment localSegment = this.head;
      int i = localSegment.pos;
      int j = localSegment.limit;
      byte[] arrayOfByte = localSegment.data;
      int k = i + 1;
      byte b = arrayOfByte[i];
      this.size = (l - 1L);
      if (k == j)
      {
        this.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
      }
      else
      {
        localSegment.pos = k;
      }
      return b;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public byte[] readByteArray()
  {
    try
    {
      byte[] arrayOfByte = readByteArray(this.size);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public byte[] readByteArray(long paramLong)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramLong <= 2147483647L)
    {
      localObject = new byte[(int)paramLong];
      readFully((byte[])localObject);
      return (byte[])localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount > Integer.MAX_VALUE: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public ByteString readByteString()
  {
    return new ByteString(readByteArray());
  }
  
  public ByteString readByteString(long paramLong)
    throws EOFException
  {
    return new ByteString(readByteArray(paramLong));
  }
  
  public long readDecimalLong()
  {
    long l1 = this.size;
    long l2 = 0L;
    if (l1 != 0L)
    {
      l1 = -7L;
      int i = 0;
      int j = 0;
      int i1;
      for (int k = 0;; k = i1)
      {
        Object localObject1 = this.head;
        Object localObject2 = ((Segment)localObject1).data;
        int m = ((Segment)localObject1).pos;
        int n = ((Segment)localObject1).limit;
        int i2;
        for (;;)
        {
          i1 = k;
          if (m >= n) {
            break label285;
          }
          i2 = localObject2[m];
          if ((i2 >= 48) && (i2 <= 57))
          {
            i1 = 48 - i2;
            boolean bool = l2 < -922337203685477580L;
            if ((!bool) && ((bool) || (i1 >= l1)))
            {
              l2 = l2 * 10L + i1;
            }
            else
            {
              localObject1 = new Buffer().writeDecimalLong(l2).writeByte(i2);
              if (j == 0) {
                ((Buffer)localObject1).readByte();
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Number too large: ");
              ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
              throw new NumberFormatException(((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            if ((i2 != 45) || (i != 0)) {
              break;
            }
            l1 -= 1L;
            j = 1;
          }
          m++;
          i++;
        }
        if (i != 0)
        {
          i1 = 1;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Expected leading [0-9] or '-' character but was 0x");
          ((StringBuilder)localObject2).append(Integer.toHexString(i2));
          throw new NumberFormatException(((StringBuilder)localObject2).toString());
        }
        label285:
        if (m == n)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = m;
        }
        if ((i1 != 0) || (this.head == null)) {
          break;
        }
      }
      this.size -= i;
      if (j == 0) {
        l2 = -l2;
      }
      return l2;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public final Buffer readFrom(InputStream paramInputStream)
    throws IOException
  {
    readFrom(paramInputStream, Long.MAX_VALUE, true);
    return this;
  }
  
  public final Buffer readFrom(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong >= 0L)
    {
      readFrom(paramInputStream, paramLong, false);
      return this;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("byteCount < 0: ");
    paramInputStream.append(paramLong);
    throw new IllegalArgumentException(paramInputStream.toString());
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
    throws EOFException
  {
    long l = this.size;
    if (l >= paramLong)
    {
      paramBuffer.write(this, paramLong);
      return;
    }
    paramBuffer.write(this, l);
    throw new EOFException();
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws EOFException
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw new EOFException();
      }
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    if (this.size != 0L)
    {
      int i = 0;
      long l1 = 0L;
      int j = 0;
      long l2;
      int n;
      label229:
      label282:
      do
      {
        Object localObject1 = this.head;
        Object localObject2 = ((Segment)localObject1).data;
        int k = ((Segment)localObject1).pos;
        int m = ((Segment)localObject1).limit;
        l2 = l1;
        int i1;
        for (n = i;; n++)
        {
          i1 = j;
          if (k >= m) {
            break label282;
          }
          i1 = localObject2[k];
          if ((i1 >= 48) && (i1 <= 57))
          {
            i = i1 - 48;
          }
          else
          {
            if ((i1 >= 97) && (i1 <= 102)) {}
            for (i = i1 - 97;; i = i1 - 65)
            {
              i += 10;
              break;
              if ((i1 < 65) || (i1 > 70)) {
                break label229;
              }
            }
          }
          if ((0xF000000000000000 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | i;
          k++;
        }
        localObject1 = new Buffer().writeHexadecimalUnsignedLong(l2).writeByte(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Number too large: ");
        ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
        throw new NumberFormatException(((StringBuilder)localObject2).toString());
        if (n != 0)
        {
          i1 = 1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected leading [0-9a-fA-F] character but was 0x");
          ((StringBuilder)localObject1).append(Integer.toHexString(i1));
          throw new NumberFormatException(((StringBuilder)localObject1).toString());
        }
        if (k == m)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = k;
        }
        if (i1 != 0) {
          break;
        }
        i = n;
        j = i1;
        l1 = l2;
      } while (this.head != null);
      this.size -= n;
      return l2;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public int readInt()
  {
    long l = this.size;
    if (l >= 4L)
    {
      localObject = this.head;
      int i = ((Segment)localObject).pos;
      int j = ((Segment)localObject).limit;
      if (j - i < 4) {
        return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
      }
      byte[] arrayOfByte = ((Segment)localObject).data;
      int k = i + 1;
      i = arrayOfByte[i];
      int m = k + 1;
      k = arrayOfByte[k];
      int n = m + 1;
      int i1 = arrayOfByte[m];
      m = n + 1;
      n = arrayOfByte[n];
      this.size = (l - 4L);
      if (m == j)
      {
        this.head = ((Segment)localObject).pop();
        SegmentPool.recycle((Segment)localObject);
      }
      else
      {
        ((Segment)localObject).pos = m;
      }
      return (i & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | n & 0xFF;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 4: ");
    ((StringBuilder)localObject).append(this.size);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }
  
  public long readLong()
  {
    long l1 = this.size;
    if (l1 >= 8L)
    {
      Segment localSegment = this.head;
      int i = localSegment.pos;
      int j = localSegment.limit;
      if (j - i < 8) {
        return (readInt() & 0xFFFFFFFF) << 32 | 0xFFFFFFFF & readInt();
      }
      localObject = localSegment.data;
      int k = i + 1;
      long l2 = localObject[i];
      i = k + 1;
      long l3 = localObject[k];
      k = i + 1;
      long l4 = localObject[i];
      int m = k + 1;
      long l5 = localObject[k];
      i = m + 1;
      long l6 = localObject[m];
      k = i + 1;
      long l7 = localObject[i];
      i = k + 1;
      long l8 = localObject[k];
      k = i + 1;
      long l9 = localObject[i];
      this.size = (l1 - 8L);
      if (k == j)
      {
        this.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
      }
      else
      {
        localSegment.pos = k;
      }
      return (l3 & 0xFF) << 48 | (l2 & 0xFF) << 56 | (l4 & 0xFF) << 40 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 24 | (l7 & 0xFF) << 16 | (l8 & 0xFF) << 8 | l9 & 0xFF;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 8: ");
    ((StringBuilder)localObject).append(this.size);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public long readLongLe()
  {
    return Util.reverseBytesLong(readLong());
  }
  
  public short readShort()
  {
    long l = this.size;
    if (l >= 2L)
    {
      localObject = this.head;
      int i = ((Segment)localObject).pos;
      int j = ((Segment)localObject).limit;
      if (j - i < 2) {
        return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
      }
      byte[] arrayOfByte = ((Segment)localObject).data;
      int k = i + 1;
      i = arrayOfByte[i];
      int m = k + 1;
      k = arrayOfByte[k];
      this.size = (l - 2L);
      if (m == j)
      {
        this.head = ((Segment)localObject).pop();
        SegmentPool.recycle((Segment)localObject);
      }
      else
      {
        ((Segment)localObject).pos = m;
      }
      return (short)((i & 0xFF) << 8 | k & 0xFF);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 2: ");
    ((StringBuilder)localObject).append(this.size);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset != null)
    {
      if (paramLong <= 2147483647L)
      {
        if (paramLong == 0L) {
          return "";
        }
        Segment localSegment = this.head;
        if (localSegment.pos + paramLong > localSegment.limit) {
          return new String(readByteArray(paramLong), paramCharset);
        }
        paramCharset = new String(localSegment.data, localSegment.pos, (int)paramLong, paramCharset);
        int i = (int)(localSegment.pos + paramLong);
        localSegment.pos = i;
        this.size -= paramLong;
        if (i == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.recycle(localSegment);
        }
        return paramCharset;
      }
      paramCharset = new StringBuilder();
      paramCharset.append("byteCount > Integer.MAX_VALUE: ");
      paramCharset.append(paramLong);
      throw new IllegalArgumentException(paramCharset.toString());
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public String readString(Charset paramCharset)
  {
    try
    {
      paramCharset = readString(this.size, paramCharset);
      return paramCharset;
    }
    catch (EOFException paramCharset)
    {
      throw new AssertionError(paramCharset);
    }
  }
  
  public final UnsafeCursor readUnsafe()
  {
    return readUnsafe(new UnsafeCursor());
  }
  
  public final UnsafeCursor readUnsafe(UnsafeCursor paramUnsafeCursor)
  {
    if (paramUnsafeCursor.buffer == null)
    {
      paramUnsafeCursor.buffer = this;
      paramUnsafeCursor.readWrite = false;
      return paramUnsafeCursor;
    }
    throw new IllegalStateException("already attached to a buffer");
  }
  
  public String readUtf8()
  {
    try
    {
      String str = readString(this.size, Util.UTF_8);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String readUtf8(long paramLong)
    throws EOFException
  {
    return readString(paramLong, Util.UTF_8);
  }
  
  public int readUtf8CodePoint()
    throws EOFException
  {
    if (this.size != 0L)
    {
      int i = getByte(0L);
      int j = 1;
      int k;
      int m;
      int n;
      if ((i & 0x80) == 0)
      {
        k = i & 0x7F;
        m = 1;
        n = 0;
      }
      else if ((i & 0xE0) == 192)
      {
        k = i & 0x1F;
        m = 2;
        n = 128;
      }
      else if ((i & 0xF0) == 224)
      {
        k = i & 0xF;
        m = 3;
        n = 2048;
      }
      else
      {
        if ((i & 0xF8) != 240) {
          break label319;
        }
        k = i & 0x7;
        m = 4;
        n = 65536;
      }
      long l1 = this.size;
      long l2 = m;
      if (l1 >= l2)
      {
        while (j < m)
        {
          l1 = j;
          i = getByte(l1);
          if ((i & 0xC0) == 128)
          {
            k = k << 6 | i & 0x3F;
            j++;
          }
          else
          {
            skip(l1);
            return 65533;
          }
        }
        skip(l2);
        if (k > 1114111) {
          return 65533;
        }
        if ((k >= 55296) && (k <= 57343)) {
          return 65533;
        }
        if (k < n) {
          return 65533;
        }
        return k;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size < ");
      localStringBuilder.append(m);
      localStringBuilder.append(": ");
      localStringBuilder.append(this.size);
      localStringBuilder.append(" (to read code point prefixed 0x");
      localStringBuilder.append(Integer.toHexString(i));
      localStringBuilder.append(")");
      throw new EOFException(localStringBuilder.toString());
      label319:
      skip(1L);
      return 65533;
    }
    throw new EOFException();
  }
  
  @Nullable
  public String readUtf8Line()
    throws EOFException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      l = this.size;
      String str;
      if (l != 0L) {
        str = readUtf8(l);
      } else {
        str = null;
      }
      return str;
    }
    return readUtf8Line(l);
  }
  
  String readUtf8Line(long paramLong)
    throws EOFException
  {
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      if (getByte(l) == 13)
      {
        str = readUtf8(l);
        skip(2L);
        return str;
      }
    }
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public String readUtf8LineStrict()
    throws EOFException
  {
    return readUtf8LineStrict(Long.MAX_VALUE);
  }
  
  public String readUtf8LineStrict(long paramLong)
    throws EOFException
  {
    if (paramLong >= 0L)
    {
      long l1 = Long.MAX_VALUE;
      if (paramLong != Long.MAX_VALUE) {
        l1 = paramLong + 1L;
      }
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 != -1L) {
        return readUtf8Line(l2);
      }
      if ((l1 < size()) && (getByte(l1 - 1L) == 13) && (getByte(l1) == 10)) {
        return readUtf8Line(l1);
      }
      Buffer localBuffer = new Buffer();
      copyTo(localBuffer, 0L, Math.min(32L, size()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(size(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(localBuffer.readByteString().hex());
      localStringBuilder.append('…');
      throw new EOFException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("limit < 0: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean request(long paramLong)
  {
    boolean bool;
    if (this.size >= paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void require(long paramLong)
    throws EOFException
  {
    if (this.size >= paramLong) {
      return;
    }
    throw new EOFException();
  }
  
  List<Integer> segmentSizes()
  {
    if (this.head == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    Segment localSegment = this.head;
    localArrayList.add(Integer.valueOf(localSegment.limit - localSegment.pos));
    localSegment = this.head;
    for (;;)
    {
      localSegment = localSegment.next;
      if (localSegment == this.head) {
        break;
      }
      localArrayList.add(Integer.valueOf(localSegment.limit - localSegment.pos));
    }
    return localArrayList;
  }
  
  public int select(Options paramOptions)
  {
    int i = selectPrefix(paramOptions, false);
    if (i == -1) {
      return -1;
    }
    long l = paramOptions.byteStrings[i].size();
    try
    {
      skip(l);
      return i;
    }
    catch (EOFException paramOptions)
    {
      throw new AssertionError();
    }
  }
  
  int selectPrefix(Options paramOptions, boolean paramBoolean)
  {
    Segment localSegment1 = this.head;
    if (localSegment1 == null)
    {
      if (paramBoolean) {
        return -2;
      }
      return paramOptions.indexOf(ByteString.EMPTY);
    }
    Object localObject = localSegment1.data;
    int i = localSegment1.pos;
    int j = localSegment1.limit;
    int[] arrayOfInt = paramOptions.trie;
    paramOptions = localSegment1;
    int k = 0;
    int m = -1;
    int n = k + 1;
    int i1 = arrayOfInt[k];
    int i2 = n + 1;
    k = arrayOfInt[n];
    if (k != -1) {
      m = k;
    }
    int i3;
    if (paramOptions != null)
    {
      if (i1 >= 0) {}
    }
    else {
      for (k = i2;; k = n)
      {
        i3 = i + 1;
        i = localObject[i];
        n = k + 1;
        if ((i & 0xFF) != arrayOfInt[k]) {
          return m;
        }
        if (n == i2 + i1 * -1) {
          k = 1;
        } else {
          k = 0;
        }
        if (i3 == j)
        {
          paramOptions = paramOptions.next;
          i = paramOptions.pos;
          localObject = paramOptions.data;
          j = paramOptions.limit;
          if (paramOptions == localSegment1)
          {
            if (k == 0)
            {
              if (paramBoolean) {
                return -2;
              }
              return m;
            }
            paramOptions = null;
          }
        }
        else
        {
          i = i3;
        }
        if (k != 0)
        {
          i2 = arrayOfInt[n];
          k = j;
          j = i;
          i = i2;
          break;
        }
      }
    }
    k = i + 1;
    n = localObject[i];
    for (i = i2;; i++)
    {
      if (i == i2 + i1) {
        return m;
      }
      if ((n & 0xFF) == arrayOfInt[i])
      {
        n = arrayOfInt[(i + i1)];
        if (k == j)
        {
          Segment localSegment2 = paramOptions.next;
          i2 = localSegment2.pos;
          byte[] arrayOfByte = localSegment2.data;
          i3 = localSegment2.limit;
          j = i2;
          localObject = arrayOfByte;
          i = n;
          k = i3;
          paramOptions = localSegment2;
          if (localSegment2 == localSegment1)
          {
            paramOptions = null;
            j = i2;
            localObject = arrayOfByte;
            i = n;
            k = i3;
          }
        }
        else
        {
          i2 = k;
          k = j;
          i = n;
          j = i2;
        }
        if (i >= 0) {
          return i;
        }
        i2 = -i;
        i = j;
        j = k;
        k = i2;
        break;
      }
    }
  }
  
  public final ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  public final ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public final ByteString sha512()
  {
    return digest("SHA-512");
  }
  
  public final long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L)
    {
      Segment localSegment = this.head;
      if (localSegment != null)
      {
        int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
        long l1 = this.size;
        long l2 = i;
        this.size = (l1 - l2);
        l1 = paramLong - l2;
        localSegment = this.head;
        i = localSegment.pos + i;
        localSegment.pos = i;
        paramLong = l1;
        if (i == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.recycle(localSegment);
          paramLong = l1;
        }
      }
      else
      {
        throw new EOFException();
      }
    }
  }
  
  public final ByteString snapshot()
  {
    long l = this.size;
    if (l <= 2147483647L) {
      return snapshot((int)l);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size > Integer.MAX_VALUE: ");
    localStringBuilder.append(this.size);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final ByteString snapshot(int paramInt)
  {
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    return new SegmentedByteString(this, paramInt);
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public String toString()
  {
    return snapshot().toString();
  }
  
  Segment writableSegment(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 8192))
    {
      Object localObject = this.head;
      if (localObject == null)
      {
        localObject = SegmentPool.take();
        this.head = ((Segment)localObject);
        ((Segment)localObject).prev = ((Segment)localObject);
        ((Segment)localObject).next = ((Segment)localObject);
        return (Segment)localObject;
      }
      Segment localSegment = ((Segment)localObject).prev;
      if (localSegment.limit + paramInt <= 8192)
      {
        localObject = localSegment;
        if (localSegment.owner) {}
      }
      else
      {
        localObject = localSegment.push(SegmentPool.take());
      }
      return (Segment)localObject;
    }
    throw new IllegalArgumentException();
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramByteBuffer != null)
    {
      int i = paramByteBuffer.remaining();
      int j = i;
      while (j > 0)
      {
        Segment localSegment = writableSegment(1);
        int k = Math.min(j, 8192 - localSegment.limit);
        paramByteBuffer.get(localSegment.data, localSegment.limit, k);
        j -= k;
        localSegment.limit += k;
      }
      this.size += i;
      return i;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public Buffer write(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      paramByteString.write(this);
      return this;
    }
    throw new IllegalArgumentException("byteString == null");
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return write(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l1 = paramArrayOfByte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      Util.checkOffsetAndCount(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2)
      {
        Segment localSegment = writableSegment(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - localSegment.limit);
        System.arraycopy(paramArrayOfByte, paramInt1, localSegment.data, localSegment.limit, i);
        paramInt1 += i;
        localSegment.limit += i;
      }
      this.size += l3;
      return this;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = paramSource.read(this, paramLong);
      if (l != -1L) {
        paramLong -= l;
      } else {
        throw new EOFException();
      }
    }
    return this;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer != null)
    {
      if (paramBuffer != this)
      {
        Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
        while (paramLong > 0L)
        {
          Segment localSegment1 = paramBuffer.head;
          if (paramLong < localSegment1.limit - localSegment1.pos)
          {
            localSegment2 = this.head;
            if (localSegment2 != null) {
              localSegment2 = localSegment2.prev;
            } else {
              localSegment2 = null;
            }
            if ((localSegment2 != null) && (localSegment2.owner))
            {
              l = localSegment2.limit;
              int i;
              if (localSegment2.shared) {
                i = 0;
              } else {
                i = localSegment2.pos;
              }
              if (l + paramLong - i <= 8192L)
              {
                localSegment1.writeTo(localSegment2, (int)paramLong);
                paramBuffer.size -= paramLong;
                this.size += paramLong;
                return;
              }
            }
            paramBuffer.head = localSegment1.split((int)paramLong);
          }
          localSegment1 = paramBuffer.head;
          long l = localSegment1.limit - localSegment1.pos;
          paramBuffer.head = localSegment1.pop();
          Segment localSegment2 = this.head;
          if (localSegment2 == null)
          {
            this.head = localSegment1;
            localSegment1.prev = localSegment1;
            localSegment1.next = localSegment1;
          }
          else
          {
            localSegment2.prev.push(localSegment1).compact();
          }
          paramBuffer.size -= l;
          this.size += l;
          paramLong -= l;
        }
        return;
      }
      throw new IllegalArgumentException("source == this");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource != null)
    {
      long l2;
      for (long l1 = 0L;; l1 += l2)
      {
        l2 = paramSource.read(this, 8192L);
        if (l2 == -1L) {
          break;
        }
      }
      return l1;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)(byte)paramInt);
    this.size += 1L;
    return this;
  }
  
  public Buffer writeDecimalLong(long paramLong)
  {
    boolean bool = paramLong < 0L;
    if (!bool) {
      return writeByte(48);
    }
    int j = 0;
    int k = 1;
    long l = paramLong;
    if (bool)
    {
      l = -paramLong;
      if (l < 0L) {
        return writeUtf8("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            k = 2;
          }
        }
        else if (l < 1000L) {
          k = 3;
        } else {
          k = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          k = 5;
        } else {
          k = 6;
        }
      }
      else if (l < 10000000L) {
        k = 7;
      } else {
        k = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          k = 9;
        } else {
          k = 10;
        }
      }
      else if (l < 100000000000L) {
        k = 11;
      } else {
        k = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        k = 13;
      } else if (l < 100000000000000L) {
        k = 14;
      } else {
        k = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        k = 16;
      } else {
        k = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      k = 18;
    } else {
      k = 19;
    }
    bool = k;
    int i;
    if (j != 0) {
      i = k + 1;
    }
    Segment localSegment = writableSegment(i);
    byte[] arrayOfByte = localSegment.data;
    k = localSegment.limit + i;
    while (l != 0L)
    {
      int m = (int)(l % 10L);
      k--;
      arrayOfByte[k] = ((byte)DIGITS[m]);
      l /= 10L;
    }
    if (j != 0) {
      arrayOfByte[(k - 1)] = ((byte)45);
    }
    localSegment.limit += i;
    this.size += i;
    return this;
  }
  
  public Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int i = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    Segment localSegment = writableSegment(i);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    for (int k = j + i - 1; k >= j; k--)
    {
      arrayOfByte[k] = ((byte)DIGITS[((int)(0xF & paramLong))]);
      paramLong >>>= 4;
    }
    localSegment.limit += i;
    this.size += i;
    return this;
  }
  
  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment(4);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 24 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(byte)(paramInt >>> 16 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    this.size += 4L;
    return this;
  }
  
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment(8);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 56 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 48 & 0xFF));
    int k = i + 1;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 40 & 0xFF));
    j = k + 1;
    arrayOfByte[k] = ((byte)(byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 8L;
    return this;
  }
  
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(Util.reverseBytesLong(paramLong));
  }
  
  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    this.size += 2L;
    return this;
  }
  
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }
  
  public Buffer writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            if (paramCharset != null)
            {
              if (paramCharset.equals(Util.UTF_8)) {
                return writeUtf8(paramString, paramInt1, paramInt2);
              }
              paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
              return write(paramString, 0, paramString.length);
            }
            throw new IllegalArgumentException("charset == null");
          }
          paramCharset = new StringBuilder();
          paramCharset.append("endIndex > string.length: ");
          paramCharset.append(paramInt2);
          paramCharset.append(" > ");
          paramCharset.append(paramString.length());
          throw new IllegalArgumentException(paramCharset.toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalAccessError(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    return writeTo(paramOutputStream, this.size);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      Util.checkOffsetAndCount(this.size, 0L, paramLong);
      Object localObject = this.head;
      while (paramLong > 0L)
      {
        int i = (int)Math.min(paramLong, ((Segment)localObject).limit - ((Segment)localObject).pos);
        paramOutputStream.write(((Segment)localObject).data, ((Segment)localObject).pos, i);
        int j = ((Segment)localObject).pos + i;
        ((Segment)localObject).pos = j;
        long l1 = this.size;
        long l2 = i;
        this.size = (l1 - l2);
        l2 = paramLong - l2;
        paramLong = l2;
        if (j == ((Segment)localObject).limit)
        {
          Segment localSegment = ((Segment)localObject).pop();
          this.head = localSegment;
          SegmentPool.recycle((Segment)localObject);
          localObject = localSegment;
          paramLong = l2;
        }
      }
      return this;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public Buffer writeUtf8(String paramString)
  {
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            while (paramInt1 < paramInt2)
            {
              int i = paramString.charAt(paramInt1);
              int j;
              int m;
              if (i < 128)
              {
                Segment localSegment = writableSegment(1);
                localObject = localSegment.data;
                j = localSegment.limit - paramInt1;
                int k = Math.min(paramInt2, 8192 - j);
                m = paramInt1 + 1;
                localObject[(paramInt1 + j)] = ((byte)(byte)i);
                for (paramInt1 = m; paramInt1 < k; paramInt1++)
                {
                  m = paramString.charAt(paramInt1);
                  if (m >= 128) {
                    break;
                  }
                  localObject[(paramInt1 + j)] = ((byte)(byte)m);
                }
                m = localSegment.limit;
                j = j + paramInt1 - m;
                localSegment.limit = (m + j);
                this.size += j;
              }
              else
              {
                if (i < 2048)
                {
                  writeByte(i >> 6 | 0xC0);
                  writeByte(i & 0x3F | 0x80);
                }
                for (;;)
                {
                  paramInt1++;
                  break;
                  if ((i >= 55296) && (i <= 57343))
                  {
                    j = paramInt1 + 1;
                    if (j < paramInt2) {
                      m = paramString.charAt(j);
                    } else {
                      m = 0;
                    }
                    if ((i <= 56319) && (m >= 56320) && (m <= 57343))
                    {
                      m = ((i & 0xFFFF27FF) << 10 | 0xFFFF23FF & m) + 65536;
                      writeByte(m >> 18 | 0xF0);
                      writeByte(m >> 12 & 0x3F | 0x80);
                      writeByte(m >> 6 & 0x3F | 0x80);
                      writeByte(m & 0x3F | 0x80);
                      paramInt1 += 2;
                      break;
                    }
                    writeByte(63);
                    paramInt1 = j;
                    break;
                  }
                  writeByte(i >> 12 | 0xE0);
                  writeByte(i >> 6 & 0x3F | 0x80);
                  writeByte(i & 0x3F | 0x80);
                }
              }
            }
            return this;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("endIndex > string.length: ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" > ");
          ((StringBuilder)localObject).append(paramString.length());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public Buffer writeUtf8CodePoint(int paramInt)
  {
    if (paramInt < 128)
    {
      writeByte(paramInt);
    }
    else if (paramInt < 2048)
    {
      writeByte(paramInt >> 6 | 0xC0);
      writeByte(paramInt & 0x3F | 0x80);
    }
    else if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343))
      {
        writeByte(63);
      }
      else
      {
        writeByte(paramInt >> 12 | 0xE0);
        writeByte(paramInt >> 6 & 0x3F | 0x80);
        writeByte(paramInt & 0x3F | 0x80);
      }
    }
    else
    {
      if (paramInt > 1114111) {
        break label195;
      }
      writeByte(paramInt >> 18 | 0xF0);
      writeByte(paramInt >> 12 & 0x3F | 0x80);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
    }
    return this;
    label195:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected code point: ");
    localStringBuilder.append(Integer.toHexString(paramInt));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static final class UnsafeCursor
    implements Closeable
  {
    public Buffer buffer;
    public byte[] data;
    public int end = -1;
    public long offset = -1L;
    public boolean readWrite;
    private Segment segment;
    public int start = -1;
    
    public void close()
    {
      if (this.buffer != null)
      {
        this.buffer = null;
        this.segment = null;
        this.offset = -1L;
        this.data = null;
        this.start = -1;
        this.end = -1;
        return;
      }
      throw new IllegalStateException("not attached to a buffer");
    }
    
    public final long expandBuffer(int paramInt)
    {
      if (paramInt > 0)
      {
        if (paramInt <= 8192)
        {
          localObject = this.buffer;
          if (localObject != null)
          {
            if (this.readWrite)
            {
              long l1 = ((Buffer)localObject).size;
              localObject = ((Buffer)localObject).writableSegment(paramInt);
              paramInt = 8192 - ((Segment)localObject).limit;
              ((Segment)localObject).limit = 8192;
              Buffer localBuffer = this.buffer;
              long l2 = paramInt;
              localBuffer.size = (l1 + l2);
              this.segment = ((Segment)localObject);
              this.offset = l1;
              this.data = ((Segment)localObject).data;
              this.start = (8192 - paramInt);
              this.end = 8192;
              return l2;
            }
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
          }
          throw new IllegalStateException("not attached to a buffer");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("minByteCount > Segment.SIZE: ");
        ((StringBuilder)localObject).append(paramInt);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("minByteCount <= 0: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public final int next()
    {
      long l = this.offset;
      if (l != this.buffer.size)
      {
        if (l == -1L) {
          return seek(0L);
        }
        return seek(l + (this.end - this.start));
      }
      throw new IllegalStateException();
    }
    
    public final long resizeBuffer(long paramLong)
    {
      Object localObject = this.buffer;
      if (localObject != null)
      {
        if (this.readWrite)
        {
          long l1 = ((Buffer)localObject).size;
          boolean bool = paramLong < l1;
          long l2;
          int i;
          long l3;
          if (!bool)
          {
            if (paramLong >= 0L)
            {
              l2 = l1 - paramLong;
              while (l2 > 0L)
              {
                Buffer localBuffer = this.buffer;
                localObject = localBuffer.head.prev;
                i = ((Segment)localObject).limit;
                l3 = i - ((Segment)localObject).pos;
                if (l3 <= l2)
                {
                  localBuffer.head = ((Segment)localObject).pop();
                  SegmentPool.recycle((Segment)localObject);
                  l2 -= l3;
                }
                else
                {
                  ((Segment)localObject).limit = ((int)(i - l2));
                }
              }
              this.segment = null;
              this.offset = paramLong;
              this.data = null;
              this.start = -1;
              this.end = -1;
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("newSize < 0: ");
              ((StringBuilder)localObject).append(paramLong);
              throw new IllegalArgumentException(((StringBuilder)localObject).toString());
            }
          }
          else if (i > 0)
          {
            l2 = paramLong - l1;
            i = 1;
            while (l2 > 0L)
            {
              localObject = this.buffer.writableSegment(1);
              int j = (int)Math.min(l2, 8192 - ((Segment)localObject).limit);
              int k = ((Segment)localObject).limit + j;
              ((Segment)localObject).limit = k;
              l3 = l2 - j;
              l2 = l3;
              if (i != 0)
              {
                this.segment = ((Segment)localObject);
                this.offset = l1;
                this.data = ((Segment)localObject).data;
                this.start = (k - j);
                this.end = k;
                i = 0;
                l2 = l3;
              }
            }
          }
          this.buffer.size = paramLong;
          return l1;
        }
        throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
      }
      throw new IllegalStateException("not attached to a buffer");
    }
    
    public final int seek(long paramLong)
    {
      boolean bool = paramLong < -1L;
      if (!bool)
      {
        Object localObject1 = this.buffer;
        long l1 = ((Buffer)localObject1).size;
        if (paramLong <= l1)
        {
          if ((bool) && (paramLong != l1))
          {
            long l2 = 0L;
            Object localObject2 = ((Buffer)localObject1).head;
            localObject1 = this.segment;
            Object localObject3;
            if (localObject1 != null)
            {
              l3 = this.offset - (this.start - ((Segment)localObject1).pos);
              if (l3 > paramLong)
              {
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
              }
              else
              {
                l2 = l3;
                l3 = l1;
              }
            }
            else
            {
              localObject1 = localObject2;
              l3 = l1;
            }
            l1 = l3;
            if (l3 - paramLong > paramLong - l2) {
              for (localObject2 = localObject1;; localObject2 = ((Segment)localObject2).next)
              {
                j = ((Segment)localObject2).limit;
                i = ((Segment)localObject2).pos;
                l3 = l2;
                localObject1 = localObject2;
                if (paramLong < j - i + l2) {
                  break;
                }
                l2 += j - i;
              }
            }
            while (l1 > paramLong)
            {
              localObject2 = ((Segment)localObject2).prev;
              l1 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos;
            }
            localObject1 = localObject2;
            long l3 = l1;
            localObject2 = localObject1;
            if (this.readWrite)
            {
              localObject2 = localObject1;
              if (((Segment)localObject1).shared)
              {
                localObject3 = ((Segment)localObject1).unsharedCopy();
                localObject2 = this.buffer;
                if (((Buffer)localObject2).head == localObject1) {
                  ((Buffer)localObject2).head = ((Segment)localObject3);
                }
                localObject2 = ((Segment)localObject1).push((Segment)localObject3);
                ((Segment)localObject2).prev.pop();
              }
            }
            this.segment = ((Segment)localObject2);
            this.offset = paramLong;
            this.data = ((Segment)localObject2).data;
            int j = ((Segment)localObject2).pos + (int)(paramLong - l3);
            this.start = j;
            int i = ((Segment)localObject2).limit;
            this.end = i;
            return i - j;
          }
          this.segment = null;
          this.offset = paramLong;
          this.data = null;
          this.start = -1;
          this.end = -1;
          return -1;
        }
      }
      throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.buffer.size) }));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\Buffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */