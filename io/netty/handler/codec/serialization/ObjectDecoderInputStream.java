package io.netty.handler.codec.serialization;

import io.netty.util.internal.ObjectUtil;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class ObjectDecoderInputStream
  extends InputStream
  implements ObjectInput
{
  private final ClassResolver classResolver;
  private final DataInputStream in;
  private final int maxObjectSize;
  
  public ObjectDecoderInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, null);
  }
  
  public ObjectDecoderInputStream(InputStream paramInputStream, int paramInt)
  {
    this(paramInputStream, null, paramInt);
  }
  
  public ObjectDecoderInputStream(InputStream paramInputStream, ClassLoader paramClassLoader)
  {
    this(paramInputStream, paramClassLoader, 1048576);
  }
  
  public ObjectDecoderInputStream(InputStream paramInputStream, ClassLoader paramClassLoader, int paramInt)
  {
    ObjectUtil.checkNotNull(paramInputStream, "in");
    ObjectUtil.checkPositive(paramInt, "maxObjectSize");
    if ((paramInputStream instanceof DataInputStream)) {
      this.in = ((DataInputStream)paramInputStream);
    } else {
      this.in = new DataInputStream(paramInputStream);
    }
    this.classResolver = ClassResolvers.weakCachingResolver(paramClassLoader);
    this.maxObjectSize = paramInt;
  }
  
  public int available()
    throws IOException
  {
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    this.in.close();
  }
  
  public void mark(int paramInt)
  {
    this.in.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
    throws IOException
  {
    return this.in.read();
  }
  
  public final int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.in.read(paramArrayOfByte);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final boolean readBoolean()
    throws IOException
  {
    return this.in.readBoolean();
  }
  
  public final byte readByte()
    throws IOException
  {
    return this.in.readByte();
  }
  
  public final char readChar()
    throws IOException
  {
    return this.in.readChar();
  }
  
  public final double readDouble()
    throws IOException
  {
    return this.in.readDouble();
  }
  
  public final float readFloat()
    throws IOException
  {
    return this.in.readFloat();
  }
  
  public final void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    this.in.readFully(paramArrayOfByte);
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.in.readFully(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final int readInt()
    throws IOException
  {
    return this.in.readInt();
  }
  
  @Deprecated
  public final String readLine()
    throws IOException
  {
    return this.in.readLine();
  }
  
  public final long readLong()
    throws IOException
  {
    return this.in.readLong();
  }
  
  public Object readObject()
    throws ClassNotFoundException, IOException
  {
    int i = readInt();
    if (i > 0)
    {
      if (i <= this.maxObjectSize) {
        return new CompactObjectInputStream(this.in, this.classResolver).readObject();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("data length too big: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" (max: ");
      localStringBuilder.append(this.maxObjectSize);
      localStringBuilder.append(')');
      throw new StreamCorruptedException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid data length: ");
    localStringBuilder.append(i);
    throw new StreamCorruptedException(localStringBuilder.toString());
  }
  
  public final short readShort()
    throws IOException
  {
    return this.in.readShort();
  }
  
  public final String readUTF()
    throws IOException
  {
    return this.in.readUTF();
  }
  
  public final int readUnsignedByte()
    throws IOException
  {
    return this.in.readUnsignedByte();
  }
  
  public final int readUnsignedShort()
    throws IOException
  {
    return this.in.readUnsignedShort();
  }
  
  public void reset()
    throws IOException
  {
    this.in.reset();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.in.skip(paramLong);
  }
  
  public final int skipBytes(int paramInt)
    throws IOException
  {
    return this.in.skipBytes(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\ObjectDecoderInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */