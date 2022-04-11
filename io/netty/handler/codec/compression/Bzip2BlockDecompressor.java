package io.netty.handler.codec.compression;

final class Bzip2BlockDecompressor
{
  private final int blockCRC;
  private final boolean blockRandomised;
  private final byte[] bwtBlock;
  private int bwtBlockLength;
  private final int[] bwtByteCounts = new int['Ā'];
  private int bwtBytesDecoded;
  private int bwtCurrentMergedPointer;
  private int[] bwtMergedPointers;
  private final int bwtStartPointer;
  private final Crc32 crc = new Crc32();
  int huffmanEndOfBlockSymbol;
  int huffmanInUse16;
  final byte[] huffmanSymbolMap = new byte['Ā'];
  private int mtfValue;
  private int randomCount = Bzip2Rand.rNums(0) - 1;
  private int randomIndex;
  private final Bzip2BitReader reader;
  private int repeatCount;
  private int repeatIncrement = 1;
  private int rleAccumulator;
  private int rleLastDecodedByte = -1;
  private int rleRepeat;
  private final Bzip2MoveToFrontTable symbolMTF = new Bzip2MoveToFrontTable();
  
  Bzip2BlockDecompressor(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, Bzip2BitReader paramBzip2BitReader)
  {
    this.bwtBlock = new byte[paramInt1];
    this.blockCRC = paramInt2;
    this.blockRandomised = paramBoolean;
    this.bwtStartPointer = paramInt3;
    this.reader = paramBzip2BitReader;
  }
  
  private int decodeNextBWTByte()
  {
    int i = this.bwtCurrentMergedPointer;
    int j = i & 0xFF;
    this.bwtCurrentMergedPointer = this.bwtMergedPointers[(i >>> 8)];
    i = j;
    if (this.blockRandomised)
    {
      int k = this.randomCount - 1;
      this.randomCount = k;
      i = j;
      if (k == 0)
      {
        i = j ^ 0x1;
        j = (this.randomIndex + 1) % 512;
        this.randomIndex = j;
        this.randomCount = Bzip2Rand.rNums(j);
      }
    }
    this.bwtBytesDecoded += 1;
    return i;
  }
  
  private void initialiseInverseBWT()
  {
    int i = this.bwtStartPointer;
    byte[] arrayOfByte = this.bwtBlock;
    int j = this.bwtBlockLength;
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int['Ā'];
    if ((i >= 0) && (i < j))
    {
      int[] arrayOfInt3 = this.bwtByteCounts;
      int k = 0;
      System.arraycopy(arrayOfInt3, 0, arrayOfInt2, 1, 255);
      for (int m = 2;; m++)
      {
        j = k;
        if (m > 255) {
          break;
        }
        arrayOfInt2[m] += arrayOfInt2[(m - 1)];
      }
      while (j < this.bwtBlockLength)
      {
        m = arrayOfByte[j] & 0xFF;
        k = arrayOfInt2[m];
        arrayOfInt2[m] = (k + 1);
        arrayOfInt1[k] = ((j << 8) + m);
        j++;
      }
      this.bwtMergedPointers = arrayOfInt1;
      this.bwtCurrentMergedPointer = arrayOfInt1[i];
      return;
    }
    throw new DecompressionException("start pointer invalid");
  }
  
  public int blockLength()
  {
    return this.bwtBlockLength;
  }
  
  int checkCRC()
  {
    int i = this.crc.getCRC();
    if (this.blockCRC == i) {
      return i;
    }
    throw new DecompressionException("block CRC error");
  }
  
  boolean decodeHuffmanData(Bzip2HuffmanStageDecoder paramBzip2HuffmanStageDecoder)
  {
    Bzip2BitReader localBzip2BitReader = this.reader;
    byte[] arrayOfByte1 = this.bwtBlock;
    byte[] arrayOfByte2 = this.huffmanSymbolMap;
    int i = arrayOfByte1.length;
    int j = this.huffmanEndOfBlockSymbol;
    int[] arrayOfInt = this.bwtByteCounts;
    Bzip2MoveToFrontTable localBzip2MoveToFrontTable = this.symbolMTF;
    int k = this.bwtBlockLength;
    int m = this.repeatCount;
    int n = this.repeatIncrement;
    int i1 = this.mtfValue;
    for (;;)
    {
      if (!localBzip2BitReader.hasReadableBits(23))
      {
        this.bwtBlockLength = k;
        this.repeatCount = m;
        this.repeatIncrement = n;
        this.mtfValue = i1;
        return false;
      }
      int i2 = paramBzip2HuffmanStageDecoder.nextSymbol();
      if (i2 == 0)
      {
        m += n;
        n <<= 1;
      }
      else if (i2 == 1)
      {
        n <<= 1;
        m += n;
      }
      else
      {
        int i3 = k;
        int i4 = m;
        if (m > 0) {
          if (k + m <= i)
          {
            n = arrayOfByte2[i1];
            i1 = n & 0xFF;
            arrayOfInt[i1] += m;
            for (;;)
            {
              m--;
              if (m < 0) {
                break;
              }
              arrayOfByte1[k] = ((byte)n);
              k++;
            }
            i4 = 0;
            n = 1;
            i3 = k;
          }
          else
          {
            throw new DecompressionException("block exceeds declared block size");
          }
        }
        if (i2 == j)
        {
          this.bwtBlockLength = i3;
          initialiseInverseBWT();
          return true;
        }
        if (i3 >= i) {
          break;
        }
        i1 = localBzip2MoveToFrontTable.indexToFront(i2 - 1) & 0xFF;
        k = arrayOfByte2[i1];
        m = k & 0xFF;
        arrayOfInt[m] += 1;
        arrayOfByte1[i3] = ((byte)k);
        k = i3 + 1;
        m = i4;
      }
    }
    throw new DecompressionException("block exceeds declared block size");
  }
  
  public int read()
  {
    int i;
    for (;;)
    {
      i = this.rleRepeat;
      if (i >= 1) {
        break;
      }
      if (this.bwtBytesDecoded == this.bwtBlockLength) {
        return -1;
      }
      i = decodeNextBWTByte();
      if (i != this.rleLastDecodedByte)
      {
        this.rleLastDecodedByte = i;
        this.rleRepeat = 1;
        this.rleAccumulator = 1;
        this.crc.updateCRC(i);
      }
      else
      {
        int j = this.rleAccumulator + 1;
        this.rleAccumulator = j;
        if (j == 4)
        {
          j = decodeNextBWTByte() + 1;
          this.rleRepeat = j;
          this.rleAccumulator = 0;
          this.crc.updateCRC(i, j);
        }
        else
        {
          this.rleRepeat = 1;
          this.crc.updateCRC(i);
        }
      }
    }
    this.rleRepeat = (i - 1);
    return this.rleLastDecodedByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2BlockDecompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */