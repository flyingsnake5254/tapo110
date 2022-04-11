package io.netty.handler.codec.serialization;

import io.netty.util.internal.ObjectUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;

public class ObjectEncoderOutputStream
  extends OutputStream
  implements ObjectOutput
{
  private final int estimatedLength;
  private final DataOutputStream out;
  
  public ObjectEncoderOutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 512);
  }
  
  public ObjectEncoderOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    ObjectUtil.checkNotNull(paramOutputStream, "out");
    ObjectUtil.checkPositiveOrZero(paramInt, "estimatedLength");
    if ((paramOutputStream instanceof DataOutputStream)) {
      this.out = ((DataOutputStream)paramOutputStream);
    } else {
      this.out = new DataOutputStream(paramOutputStream);
    }
    this.estimatedLength = paramInt;
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public final int size()
  {
    return this.out.size();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.out.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    this.out.writeBoolean(paramBoolean);
  }
  
  public final void writeByte(int paramInt)
    throws IOException
  {
    this.out.writeByte(paramInt);
  }
  
  public final void writeBytes(String paramString)
    throws IOException
  {
    this.out.writeBytes(paramString);
  }
  
  public final void writeChar(int paramInt)
    throws IOException
  {
    this.out.writeChar(paramInt);
  }
  
  public final void writeChars(String paramString)
    throws IOException
  {
    this.out.writeChars(paramString);
  }
  
  public final void writeDouble(double paramDouble)
    throws IOException
  {
    this.out.writeDouble(paramDouble);
  }
  
  public final void writeFloat(float paramFloat)
    throws IOException
  {
    this.out.writeFloat(paramFloat);
  }
  
  public final void writeInt(int paramInt)
    throws IOException
  {
    this.out.writeInt(paramInt);
  }
  
  public final void writeLong(long paramLong)
    throws IOException
  {
    this.out.writeLong(paramLong);
  }
  
  /* Error */
  public void writeObject(Object paramObject)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	io/netty/handler/codec/serialization/ObjectEncoderOutputStream:estimatedLength	I
    //   4: invokestatic 102	io/netty/buffer/Unpooled:buffer	(I)Lio/netty/buffer/ByteBuf;
    //   7: astore_2
    //   8: new 104	io/netty/handler/codec/serialization/CompactObjectOutputStream
    //   11: astore_3
    //   12: new 106	io/netty/buffer/ByteBufOutputStream
    //   15: astore 4
    //   17: aload 4
    //   19: aload_2
    //   20: invokespecial 109	io/netty/buffer/ByteBufOutputStream:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   23: aload_3
    //   24: aload 4
    //   26: invokespecial 110	io/netty/handler/codec/serialization/CompactObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: aload_3
    //   30: aload_1
    //   31: invokevirtual 114	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   34: aload_3
    //   35: invokevirtual 115	java/io/ObjectOutputStream:flush	()V
    //   38: aload_3
    //   39: invokevirtual 116	java/io/ObjectOutputStream:close	()V
    //   42: aload_2
    //   43: invokevirtual 121	io/netty/buffer/ByteBuf:readableBytes	()I
    //   46: istore 5
    //   48: aload_0
    //   49: iload 5
    //   51: invokevirtual 122	io/netty/handler/codec/serialization/ObjectEncoderOutputStream:writeInt	(I)V
    //   54: aload_2
    //   55: iconst_0
    //   56: aload_0
    //   57: iload 5
    //   59: invokevirtual 126	io/netty/buffer/ByteBuf:getBytes	(ILjava/io/OutputStream;I)Lio/netty/buffer/ByteBuf;
    //   62: pop
    //   63: aload_2
    //   64: invokeinterface 132 1 0
    //   69: pop
    //   70: return
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 116	java/io/ObjectOutputStream:close	()V
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_2
    //   80: invokeinterface 132 1 0
    //   85: pop
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ObjectEncoderOutputStream
    //   0	88	1	paramObject	Object
    //   7	73	2	localByteBuf	io.netty.buffer.ByteBuf
    //   11	62	3	localCompactObjectOutputStream	CompactObjectOutputStream
    //   15	10	4	localByteBufOutputStream	io.netty.buffer.ByteBufOutputStream
    //   46	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   29	38	71	finally
    //   8	29	78	finally
    //   38	63	78	finally
    //   72	78	78	finally
  }
  
  public final void writeShort(int paramInt)
    throws IOException
  {
    this.out.writeShort(paramInt);
  }
  
  public final void writeUTF(String paramString)
    throws IOException
  {
    this.out.writeUTF(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\ObjectEncoderOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */