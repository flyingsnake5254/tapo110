package io.netty.handler.codec.marshalling;

import java.io.IOException;
import org.jboss.marshalling.ByteInput;

class LimitingByteInput
  implements ByteInput
{
  private static final TooBigObjectException EXCEPTION = new TooBigObjectException();
  private final ByteInput input;
  private final long limit;
  private long read;
  
  LimitingByteInput(ByteInput paramByteInput, long paramLong)
  {
    if (paramLong > 0L)
    {
      this.input = paramByteInput;
      this.limit = paramLong;
      return;
    }
    throw new IllegalArgumentException("The limit MUST be > 0");
  }
  
  private int readable(int paramInt)
  {
    return (int)Math.min(paramInt, this.limit - this.read);
  }
  
  public int available()
    throws IOException
  {
    return readable(this.input.available());
  }
  
  public void close()
    throws IOException
  {}
  
  public int read()
    throws IOException
  {
    if (readable(1) > 0)
    {
      int i = this.input.read();
      this.read += 1L;
      return i;
    }
    throw EXCEPTION;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = readable(paramInt2);
    if (paramInt2 > 0)
    {
      paramInt1 = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
      this.read += paramInt1;
      return paramInt1;
    }
    throw EXCEPTION;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    int i = readable((int)paramLong);
    if (i > 0)
    {
      paramLong = this.input.skip(i);
      this.read += paramLong;
      return paramLong;
    }
    throw EXCEPTION;
  }
  
  static final class TooBigObjectException
    extends IOException
  {
    private static final long serialVersionUID = 1L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\LimitingByteInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */