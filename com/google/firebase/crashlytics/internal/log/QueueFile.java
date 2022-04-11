package com.google.firebase.crashlytics.internal.log;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

class QueueFile
  implements Closeable
{
  static final int HEADER_LENGTH = 16;
  private static final int INITIAL_LENGTH = 4096;
  private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
  private final byte[] buffer = new byte[16];
  private int elementCount;
  int fileLength;
  private Element first;
  private Element last;
  private final RandomAccessFile raf;
  
  public QueueFile(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      initialize(paramFile);
    }
    this.raf = open(paramFile);
    readHeader();
  }
  
  QueueFile(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    this.raf = paramRandomAccessFile;
    readHeader();
  }
  
  private void expandIfNecessary(int paramInt)
    throws IOException
  {
    int i = paramInt + 4;
    int j = remainingBytes();
    if (j >= i) {
      return;
    }
    paramInt = this.fileLength;
    int k;
    int m;
    do
    {
      k = j + paramInt;
      m = paramInt << 1;
      j = k;
      paramInt = m;
    } while (k < i);
    setLength(m);
    Object localObject = this.last;
    paramInt = wrapPosition(((Element)localObject).position + 4 + ((Element)localObject).length);
    if (paramInt < this.first.position)
    {
      localObject = this.raf.getChannel();
      ((FileChannel)localObject).position(this.fileLength);
      long l = paramInt - 4;
      if (((FileChannel)localObject).transferTo(16L, l, (WritableByteChannel)localObject) != l) {
        throw new AssertionError("Copied insufficient number of bytes!");
      }
    }
    j = this.last.position;
    paramInt = this.first.position;
    if (j < paramInt)
    {
      j = this.fileLength + j - 16;
      writeHeader(m, this.elementCount, paramInt, j);
      this.last = new Element(j, this.last.length);
    }
    else
    {
      writeHeader(m, this.elementCount, paramInt, j);
    }
    this.fileLength = m;
  }
  
  private static void initialize(File paramFile)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile.getPath());
    ((StringBuilder)localObject).append(".tmp");
    File localFile = new File(((StringBuilder)localObject).toString());
    localObject = open(localFile);
    try
    {
      ((RandomAccessFile)localObject).setLength(4096L);
      ((RandomAccessFile)localObject).seek(0L);
      byte[] arrayOfByte = new byte[16];
      writeInts(arrayOfByte, new int[] { 4096, 0, 0, 0 });
      ((RandomAccessFile)localObject).write(arrayOfByte);
      ((RandomAccessFile)localObject).close();
      if (localFile.renameTo(paramFile)) {
        return;
      }
      throw new IOException("Rename failed!");
    }
    finally
    {
      ((RandomAccessFile)localObject).close();
    }
  }
  
  private static <T> T nonNull(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  private static RandomAccessFile open(File paramFile)
    throws FileNotFoundException
  {
    return new RandomAccessFile(paramFile, "rwd");
  }
  
  private Element readElement(int paramInt)
    throws IOException
  {
    if (paramInt == 0) {
      return Element.NULL;
    }
    this.raf.seek(paramInt);
    return new Element(paramInt, this.raf.readInt());
  }
  
  private void readHeader()
    throws IOException
  {
    this.raf.seek(0L);
    this.raf.readFully(this.buffer);
    int i = readInt(this.buffer, 0);
    this.fileLength = i;
    if (i <= this.raf.length())
    {
      this.elementCount = readInt(this.buffer, 4);
      int j = readInt(this.buffer, 8);
      i = readInt(this.buffer, 12);
      this.first = readElement(j);
      this.last = readElement(i);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("File is truncated. Expected length: ");
    localStringBuilder.append(this.fileLength);
    localStringBuilder.append(", Actual length: ");
    localStringBuilder.append(this.raf.length());
    throw new IOException(localStringBuilder.toString());
  }
  
  private static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + (paramArrayOfByte[(paramInt + 3)] & 0xFF);
  }
  
  private int remainingBytes()
  {
    return this.fileLength - usedBytes();
  }
  
  private void ringRead(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = wrapPosition(paramInt1);
    int i = this.fileLength;
    if (paramInt1 + paramInt3 <= i)
    {
      this.raf.seek(paramInt1);
      this.raf.readFully(paramArrayOfByte, paramInt2, paramInt3);
    }
    else
    {
      i -= paramInt1;
      this.raf.seek(paramInt1);
      this.raf.readFully(paramArrayOfByte, paramInt2, i);
      this.raf.seek(16L);
      this.raf.readFully(paramArrayOfByte, paramInt2 + i, paramInt3 - i);
    }
  }
  
  private void ringWrite(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = wrapPosition(paramInt1);
    int i = this.fileLength;
    if (paramInt1 + paramInt3 <= i)
    {
      this.raf.seek(paramInt1);
      this.raf.write(paramArrayOfByte, paramInt2, paramInt3);
    }
    else
    {
      i -= paramInt1;
      this.raf.seek(paramInt1);
      this.raf.write(paramArrayOfByte, paramInt2, i);
      this.raf.seek(16L);
      this.raf.write(paramArrayOfByte, paramInt2 + i, paramInt3 - i);
    }
  }
  
  private void setLength(int paramInt)
    throws IOException
  {
    this.raf.setLength(paramInt);
    this.raf.getChannel().force(true);
  }
  
  private int wrapPosition(int paramInt)
  {
    int i = this.fileLength;
    if (paramInt >= i) {
      paramInt = paramInt + 16 - i;
    }
    return paramInt;
  }
  
  private void writeHeader(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    writeInts(this.buffer, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
    this.raf.seek(0L);
    this.raf.write(this.buffer);
  }
  
  private static void writeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)(paramInt2 >> 24));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(byte)paramInt2);
  }
  
  private static void writeInts(byte[] paramArrayOfByte, int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      writeInt(paramArrayOfByte, k, paramVarArgs[j]);
      k += 4;
      j++;
    }
  }
  
  public void add(byte[] paramArrayOfByte)
    throws IOException
  {
    add(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void add(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      nonNull(paramArrayOfByte, "buffer");
      if (((paramInt1 | paramInt2) >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1))
      {
        expandIfNecessary(paramInt2);
        boolean bool = isEmpty();
        int i;
        if (bool)
        {
          i = 16;
        }
        else
        {
          localElement = this.last;
          i = wrapPosition(localElement.position + 4 + localElement.length);
        }
        Element localElement = new com/google/firebase/crashlytics/internal/log/QueueFile$Element;
        localElement.<init>(i, paramInt2);
        writeInt(this.buffer, 0, paramInt2);
        ringWrite(localElement.position, this.buffer, 0, 4);
        ringWrite(localElement.position + 4, paramArrayOfByte, paramInt1, paramInt2);
        if (bool) {
          paramInt1 = localElement.position;
        } else {
          paramInt1 = this.first.position;
        }
        writeHeader(this.fileLength, this.elementCount + 1, paramInt1, localElement.position);
        this.last = localElement;
        this.elementCount += 1;
        if (bool) {
          this.first = localElement;
        }
        return;
      }
      paramArrayOfByte = new java/lang/IndexOutOfBoundsException;
      paramArrayOfByte.<init>();
      throw paramArrayOfByte;
    }
    finally {}
  }
  
  public void clear()
    throws IOException
  {
    try
    {
      writeHeader(4096, 0, 0, 0);
      this.elementCount = 0;
      Element localElement = Element.NULL;
      this.first = localElement;
      this.last = localElement;
      if (this.fileLength > 4096) {
        setLength(4096);
      }
      this.fileLength = 4096;
      return;
    }
    finally {}
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.raf.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void forEach(ElementReader paramElementReader)
    throws IOException
  {
    try
    {
      int i = this.first.position;
      for (int j = 0; j < this.elementCount; j++)
      {
        Element localElement = readElement(i);
        ElementInputStream localElementInputStream = new com/google/firebase/crashlytics/internal/log/QueueFile$ElementInputStream;
        localElementInputStream.<init>(this, localElement, null);
        paramElementReader.read(localElementInputStream, localElement.length);
        i = wrapPosition(localElement.position + 4 + localElement.length);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasSpaceFor(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (usedBytes() + 4 + paramInt1 <= paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEmpty()
  {
    try
    {
      int i = this.elementCount;
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void peek(ElementReader paramElementReader)
    throws IOException
  {
    try
    {
      if (this.elementCount > 0)
      {
        ElementInputStream localElementInputStream = new com/google/firebase/crashlytics/internal/log/QueueFile$ElementInputStream;
        localElementInputStream.<init>(this, this.first, null);
        paramElementReader.read(localElementInputStream, this.first.length);
      }
      return;
    }
    finally
    {
      paramElementReader = finally;
      throw paramElementReader;
    }
  }
  
  public byte[] peek()
    throws IOException
  {
    try
    {
      boolean bool = isEmpty();
      if (bool) {
        return null;
      }
      Element localElement = this.first;
      int i = localElement.length;
      byte[] arrayOfByte = new byte[i];
      ringRead(localElement.position + 4, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    finally {}
  }
  
  public void remove()
    throws IOException
  {
    try
    {
      if (!isEmpty())
      {
        if (this.elementCount == 1)
        {
          clear();
        }
        else
        {
          localObject1 = this.first;
          int i = wrapPosition(((Element)localObject1).position + 4 + ((Element)localObject1).length);
          ringRead(i, this.buffer, 0, 4);
          int j = readInt(this.buffer, 0);
          writeHeader(this.fileLength, this.elementCount - 1, i, this.last.position);
          this.elementCount -= 1;
          localObject1 = new com/google/firebase/crashlytics/internal/log/QueueFile$Element;
          ((Element)localObject1).<init>(i, j);
          this.first = ((Element)localObject1);
        }
        return;
      }
      Object localObject1 = new java/util/NoSuchElementException;
      ((NoSuchElementException)localObject1).<init>();
      throw ((Throwable)localObject1);
    }
    finally {}
  }
  
  public int size()
  {
    try
    {
      int i = this.elementCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('[');
    localStringBuilder.append("fileLength=");
    localStringBuilder.append(this.fileLength);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.elementCount);
    localStringBuilder.append(", first=");
    localStringBuilder.append(this.first);
    localStringBuilder.append(", last=");
    localStringBuilder.append(this.last);
    localStringBuilder.append(", element lengths=[");
    try
    {
      ElementReader local1 = new com/google/firebase/crashlytics/internal/log/QueueFile$1;
      local1.<init>(this, localStringBuilder);
      forEach(local1);
    }
    catch (IOException localIOException)
    {
      LOGGER.log(Level.WARNING, "read error", localIOException);
    }
    localStringBuilder.append("]]");
    return localStringBuilder.toString();
  }
  
  public int usedBytes()
  {
    if (this.elementCount == 0) {
      return 16;
    }
    Element localElement = this.last;
    int i = localElement.position;
    int j = this.first.position;
    if (i >= j) {
      return i - j + 4 + localElement.length + 16;
    }
    return i + 4 + localElement.length + this.fileLength - j;
  }
  
  static class Element
  {
    static final int HEADER_LENGTH = 4;
    static final Element NULL = new Element(0, 0);
    final int length;
    final int position;
    
    Element(int paramInt1, int paramInt2)
    {
      this.position = paramInt1;
      this.length = paramInt2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append("[position = ");
      localStringBuilder.append(this.position);
      localStringBuilder.append(", length = ");
      localStringBuilder.append(this.length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  private final class ElementInputStream
    extends InputStream
  {
    private int position;
    private int remaining;
    
    private ElementInputStream(QueueFile.Element paramElement)
    {
      this.position = QueueFile.this.wrapPosition(paramElement.position + 4);
      this.remaining = paramElement.length;
    }
    
    public int read()
      throws IOException
    {
      if (this.remaining == 0) {
        return -1;
      }
      QueueFile.this.raf.seek(this.position);
      int i = QueueFile.this.raf.read();
      this.position = QueueFile.this.wrapPosition(this.position + 1);
      this.remaining -= 1;
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      QueueFile.nonNull(paramArrayOfByte, "buffer");
      if (((paramInt1 | paramInt2) >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1))
      {
        int i = this.remaining;
        if (i > 0)
        {
          int j = paramInt2;
          if (paramInt2 > i) {
            j = i;
          }
          QueueFile.this.ringRead(this.position, paramArrayOfByte, paramInt1, j);
          this.position = QueueFile.this.wrapPosition(this.position + j);
          this.remaining -= j;
          return j;
        }
        return -1;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static abstract interface ElementReader
  {
    public abstract void read(InputStream paramInputStream, int paramInt)
      throws IOException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\log\QueueFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */