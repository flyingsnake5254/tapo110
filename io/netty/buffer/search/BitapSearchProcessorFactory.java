package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

public class BitapSearchProcessorFactory
  extends AbstractSearchProcessorFactory
{
  private final long[] bitMasks = new long['Ā'];
  private final long successBit;
  
  BitapSearchProcessorFactory(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length <= 64)
    {
      int i = paramArrayOfByte.length;
      int j = 0;
      long l = 1L;
      while (j < i)
      {
        int k = paramArrayOfByte[j];
        localObject = this.bitMasks;
        k &= 0xFF;
        localObject[k] |= l;
        l <<= 1;
        j++;
      }
      this.successBit = (1L << paramArrayOfByte.length - 1);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Maximum supported search pattern length is 64, got ");
    ((StringBuilder)localObject).append(paramArrayOfByte.length);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public Processor newSearchProcessor()
  {
    return new Processor(this.bitMasks, this.successBit);
  }
  
  public static class Processor
    implements SearchProcessor
  {
    private final long[] bitMasks;
    private long currentMask;
    private final long successBit;
    
    Processor(long[] paramArrayOfLong, long paramLong)
    {
      this.bitMasks = paramArrayOfLong;
      this.successBit = paramLong;
    }
    
    public boolean process(byte paramByte)
    {
      long l = this.currentMask;
      boolean bool = true;
      l = (l << 1 | 1L) & PlatformDependent.getLong(this.bitMasks, paramByte & 0xFF);
      this.currentMask = l;
      if ((l & this.successBit) != 0L) {
        bool = false;
      }
      return bool;
    }
    
    public void reset()
    {
      this.currentMask = 0L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\search\BitapSearchProcessorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */