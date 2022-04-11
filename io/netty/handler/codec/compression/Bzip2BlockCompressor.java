package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

final class Bzip2BlockCompressor
{
  private final byte[] block;
  private int blockLength;
  private final int blockLengthLimit;
  private final boolean[] blockValuesPresent = new boolean['Ā'];
  private final int[] bwtBlock;
  private final Crc32 crc = new Crc32();
  private int rleCurrentValue = -1;
  private int rleLength;
  private final ByteProcessor writeProcessor = new ByteProcessor()
  {
    public boolean process(byte paramAnonymousByte)
      throws Exception
    {
      return Bzip2BlockCompressor.this.write(paramAnonymousByte);
    }
  };
  private final Bzip2BitWriter writer;
  
  Bzip2BlockCompressor(Bzip2BitWriter paramBzip2BitWriter, int paramInt)
  {
    this.writer = paramBzip2BitWriter;
    int i = paramInt + 1;
    this.block = new byte[i];
    this.bwtBlock = new int[i];
    this.blockLengthLimit = (paramInt - 6);
  }
  
  private void writeRun(int paramInt1, int paramInt2)
  {
    int i = this.blockLength;
    byte[] arrayOfByte = this.block;
    this.blockValuesPresent[paramInt1] = true;
    this.crc.updateCRC(paramInt1, paramInt2);
    paramInt1 = (byte)paramInt1;
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3)
        {
          paramInt2 -= 4;
          this.blockValuesPresent[paramInt2] = true;
          arrayOfByte[i] = ((byte)paramInt1);
          arrayOfByte[(i + 1)] = ((byte)paramInt1);
          arrayOfByte[(i + 2)] = ((byte)paramInt1);
          arrayOfByte[(i + 3)] = ((byte)paramInt1);
          arrayOfByte[(i + 4)] = ((byte)(byte)paramInt2);
          this.blockLength = (i + 5);
        }
        else
        {
          arrayOfByte[i] = ((byte)paramInt1);
          arrayOfByte[(i + 1)] = ((byte)paramInt1);
          arrayOfByte[(i + 2)] = ((byte)paramInt1);
          this.blockLength = (i + 3);
        }
      }
      else
      {
        arrayOfByte[i] = ((byte)paramInt1);
        arrayOfByte[(i + 1)] = ((byte)paramInt1);
        this.blockLength = (i + 2);
      }
    }
    else
    {
      arrayOfByte[i] = ((byte)paramInt1);
      this.blockLength = (i + 1);
    }
  }
  
  private void writeSymbolMap(ByteBuf paramByteBuf)
  {
    Bzip2BitWriter localBzip2BitWriter = this.writer;
    boolean[] arrayOfBoolean1 = this.blockValuesPresent;
    boolean[] arrayOfBoolean2 = new boolean[16];
    int j;
    int k;
    for (int i = 0; i < 16; i++)
    {
      j = i << 4;
      k = 0;
      while (k < 16)
      {
        if (arrayOfBoolean1[j] != 0) {
          arrayOfBoolean2[i] = true;
        }
        k++;
        j++;
      }
    }
    for (i = 0; i < 16; i++) {
      localBzip2BitWriter.writeBoolean(paramByteBuf, arrayOfBoolean2[i]);
    }
    for (i = 0; i < 16; i++) {
      if (arrayOfBoolean2[i] != 0)
      {
        k = i << 4;
        j = 0;
        while (j < 16)
        {
          localBzip2BitWriter.writeBoolean(paramByteBuf, arrayOfBoolean1[k]);
          j++;
          k++;
        }
      }
    }
  }
  
  int availableSize()
  {
    int i = this.blockLength;
    if (i == 0) {
      return this.blockLengthLimit + 2;
    }
    return this.blockLengthLimit - i + 1;
  }
  
  void close(ByteBuf paramByteBuf)
  {
    int i = this.rleLength;
    if (i > 0) {
      writeRun(this.rleCurrentValue & 0xFF, i);
    }
    Object localObject = this.block;
    localObject[this.blockLength] = ((byte)localObject[0]);
    i = new Bzip2DivSufSort(this.block, this.bwtBlock, this.blockLength).bwt();
    Bzip2BitWriter localBzip2BitWriter = this.writer;
    localBzip2BitWriter.writeBits(paramByteBuf, 24, 3227993L);
    localBzip2BitWriter.writeBits(paramByteBuf, 24, 2511705L);
    localBzip2BitWriter.writeInt(paramByteBuf, this.crc.getCRC());
    localBzip2BitWriter.writeBoolean(paramByteBuf, false);
    localBzip2BitWriter.writeBits(paramByteBuf, 24, i);
    writeSymbolMap(paramByteBuf);
    localObject = new Bzip2MTFAndRLE2StageEncoder(this.bwtBlock, this.blockLength, this.blockValuesPresent);
    ((Bzip2MTFAndRLE2StageEncoder)localObject).encode();
    new Bzip2HuffmanStageEncoder(localBzip2BitWriter, ((Bzip2MTFAndRLE2StageEncoder)localObject).mtfBlock(), ((Bzip2MTFAndRLE2StageEncoder)localObject).mtfLength(), ((Bzip2MTFAndRLE2StageEncoder)localObject).mtfAlphabetSize(), ((Bzip2MTFAndRLE2StageEncoder)localObject).mtfSymbolFrequencies()).encode(paramByteBuf);
  }
  
  int crc()
  {
    return this.crc.getCRC();
  }
  
  boolean isEmpty()
  {
    boolean bool;
    if ((this.blockLength == 0) && (this.rleLength == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isFull()
  {
    boolean bool;
    if (this.blockLength > this.blockLengthLimit) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  int write(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    int i = paramByteBuf.forEachByte(paramInt1, paramInt2, this.writeProcessor);
    if (i != -1) {
      paramInt2 = i - paramInt1;
    }
    return paramInt2;
  }
  
  boolean write(int paramInt)
  {
    if (this.blockLength > this.blockLengthLimit) {
      return false;
    }
    int i = this.rleCurrentValue;
    int j = this.rleLength;
    if (j == 0)
    {
      this.rleCurrentValue = paramInt;
      this.rleLength = 1;
    }
    else if (i != paramInt)
    {
      writeRun(i & 0xFF, j);
      this.rleCurrentValue = paramInt;
      this.rleLength = 1;
    }
    else if (j == 254)
    {
      writeRun(i & 0xFF, 255);
      this.rleLength = 0;
    }
    else
    {
      this.rleLength = (j + 1);
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2BlockCompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */