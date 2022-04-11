package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

public class KmpSearchProcessorFactory
  extends AbstractSearchProcessorFactory
{
  private final int[] jumpTable;
  private final byte[] needle;
  
  KmpSearchProcessorFactory(byte[] paramArrayOfByte)
  {
    this.needle = ((byte[])paramArrayOfByte.clone());
    int i = paramArrayOfByte.length;
    int j = 1;
    this.jumpTable = new int[i + 1];
    i = 0;
    while (j < paramArrayOfByte.length)
    {
      for (int k = i; (k > 0) && (paramArrayOfByte[k] != paramArrayOfByte[j]); k = this.jumpTable[k]) {}
      i = k;
      if (paramArrayOfByte[k] == paramArrayOfByte[j]) {
        i = k + 1;
      }
      int[] arrayOfInt = this.jumpTable;
      j++;
      arrayOfInt[j] = i;
    }
  }
  
  public Processor newSearchProcessor()
  {
    return new Processor(this.needle, this.jumpTable);
  }
  
  public static class Processor
    implements SearchProcessor
  {
    private long currentPosition;
    private final int[] jumpTable;
    private final byte[] needle;
    
    Processor(byte[] paramArrayOfByte, int[] paramArrayOfInt)
    {
      this.needle = paramArrayOfByte;
      this.jumpTable = paramArrayOfInt;
    }
    
    public boolean process(byte paramByte)
    {
      for (;;)
      {
        l = this.currentPosition;
        if ((l <= 0L) || (PlatformDependent.getByte(this.needle, l) == paramByte)) {
          break;
        }
        this.currentPosition = PlatformDependent.getInt(this.jumpTable, this.currentPosition);
      }
      if (PlatformDependent.getByte(this.needle, this.currentPosition) == paramByte) {
        this.currentPosition += 1L;
      }
      long l = this.currentPosition;
      if (l == this.needle.length)
      {
        this.currentPosition = PlatformDependent.getInt(this.jumpTable, l);
        return false;
      }
      return true;
    }
    
    public void reset()
    {
      this.currentPosition = 0L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\search\KmpSearchProcessorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */