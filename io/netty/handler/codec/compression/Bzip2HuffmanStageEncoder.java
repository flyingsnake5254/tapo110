package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.util.Arrays;

final class Bzip2HuffmanStageEncoder
{
  private static final int HUFFMAN_HIGH_SYMBOL_COST = 15;
  private final int[][] huffmanCodeLengths;
  private final int[][] huffmanMergedCodeSymbols;
  private final int mtfAlphabetSize;
  private final char[] mtfBlock;
  private final int mtfLength;
  private final int[] mtfSymbolFrequencies;
  private final byte[] selectors;
  private final Bzip2BitWriter writer;
  
  Bzip2HuffmanStageEncoder(Bzip2BitWriter paramBzip2BitWriter, char[] paramArrayOfChar, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.writer = paramBzip2BitWriter;
    this.mtfBlock = paramArrayOfChar;
    this.mtfLength = paramInt1;
    this.mtfAlphabetSize = paramInt2;
    this.mtfSymbolFrequencies = paramArrayOfInt;
    int i = selectTableCount(paramInt1);
    this.huffmanCodeLengths = new int[i][paramInt2];
    this.huffmanMergedCodeSymbols = new int[i][paramInt2];
    this.selectors = new byte[(paramInt1 + 50 - 1) / 50];
  }
  
  private void assignHuffmanCodeSymbols()
  {
    int[][] arrayOfInt1 = this.huffmanMergedCodeSymbols;
    int[][] arrayOfInt2 = this.huffmanCodeLengths;
    int i = this.mtfAlphabetSize;
    int j = arrayOfInt2.length;
    for (int k = 0; k < j; k++)
    {
      int[] arrayOfInt = arrayOfInt2[k];
      int m = 32;
      int n = 0;
      int i2;
      for (int i1 = 0; n < i; i1 = i3)
      {
        i2 = arrayOfInt[n];
        i3 = i1;
        if (i2 > i1) {
          i3 = i2;
        }
        i1 = m;
        if (i2 < m) {
          i1 = i2;
        }
        n++;
        m = i1;
      }
      int i3 = 0;
      n = m;
      m = i3;
      while (n <= i1)
      {
        i3 = 0;
        while (i3 < i)
        {
          i2 = m;
          if ((arrayOfInt2[k][i3] & 0xFF) == n)
          {
            arrayOfInt1[k][i3] = (n << 24 | m);
            i2 = m + 1;
          }
          i3++;
          m = i2;
        }
        m <<= 1;
        n++;
      }
    }
  }
  
  private static void generateHuffmanCodeLengths(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt1 = new int[paramInt];
    int[] arrayOfInt2 = new int[paramInt];
    int i = 0;
    for (int j = 0; j < paramInt; j++) {
      arrayOfInt1[j] = (paramArrayOfInt1[j] << 9 | j);
    }
    Arrays.sort(arrayOfInt1);
    for (j = 0; j < paramInt; j++) {
      arrayOfInt1[j] >>>= 9;
    }
    Bzip2HuffmanAllocator.allocateHuffmanCodeLengths(arrayOfInt2, 20);
    for (j = i; j < paramInt; j++) {
      paramArrayOfInt2[(arrayOfInt1[j] & 0x1FF)] = arrayOfInt2[j];
    }
  }
  
  private void generateHuffmanOptimisationSeeds()
  {
    int[][] arrayOfInt = this.huffmanCodeLengths;
    int[] arrayOfInt1 = this.mtfSymbolFrequencies;
    int i = this.mtfAlphabetSize;
    int j = arrayOfInt.length;
    int k = this.mtfLength;
    int m = -1;
    for (int n = 0; n < j; n++)
    {
      int i1 = j - n;
      int i2 = k / i1;
      int i3 = m + 1;
      int i4 = 0;
      int i5 = m;
      while ((i4 < i2) && (i5 < i - 1))
      {
        i5++;
        i4 += arrayOfInt1[i5];
      }
      m = i5;
      i2 = i4;
      if (i5 > i3)
      {
        m = i5;
        i2 = i4;
        if (n != 0)
        {
          m = i5;
          i2 = i4;
          if (n != j - 1)
          {
            m = i5;
            i2 = i4;
            if ((i1 & 0x1) == 0)
            {
              i2 = i4 - arrayOfInt1[i5];
              m = i5 - 1;
            }
          }
        }
      }
      int[] arrayOfInt2 = arrayOfInt[n];
      for (i4 = 0; i4 < i; i4++) {
        if ((i4 < i3) || (i4 > m)) {
          arrayOfInt2[i4] = 15;
        }
      }
      k -= i2;
    }
  }
  
  private void optimiseSelectorsAndHuffmanTables(boolean paramBoolean)
  {
    char[] arrayOfChar = this.mtfBlock;
    byte[] arrayOfByte = this.selectors;
    int[][] arrayOfInt1 = this.huffmanCodeLengths;
    int i = this.mtfLength;
    int j = this.mtfAlphabetSize;
    int k = arrayOfInt1.length;
    int[][] arrayOfInt2 = new int[k][j];
    int m = 0;
    int i2;
    for (int n = 0; m < i; n = i2)
    {
      int i1 = Math.min(m + 50, i) - 1;
      Object localObject = new short[k];
      for (i2 = m; i2 <= i1; i2++)
      {
        i3 = arrayOfChar[i2];
        for (i4 = 0; i4 < k; i4++) {
          localObject[i4] = ((short)(short)(localObject[i4] + arrayOfInt1[i4][i3]));
        }
      }
      int i3 = localObject[0];
      i2 = 1;
      int i4 = 0;
      while (i2 < k)
      {
        int i5 = localObject[i2];
        int i6 = i3;
        if (i5 < i3)
        {
          i6 = i5;
          i4 = i2;
        }
        i2 = (byte)(i2 + 1);
        i3 = i6;
      }
      localObject = arrayOfInt2[i4];
      while (m <= i1)
      {
        i2 = arrayOfChar[m];
        localObject[i2] += 1;
        m++;
      }
      i2 = n;
      if (paramBoolean)
      {
        arrayOfByte[n] = ((byte)i4);
        i2 = n + 1;
      }
      m = i1 + 1;
    }
    for (m = 0; m < k; m++) {
      generateHuffmanCodeLengths(j, arrayOfInt2[m], arrayOfInt1[m]);
    }
  }
  
  private static int selectTableCount(int paramInt)
  {
    if (paramInt >= 2400) {
      return 6;
    }
    if (paramInt >= 1200) {
      return 5;
    }
    if (paramInt >= 600) {
      return 4;
    }
    if (paramInt >= 200) {
      return 3;
    }
    return 2;
  }
  
  private void writeBlockData(ByteBuf paramByteBuf)
  {
    Bzip2BitWriter localBzip2BitWriter = this.writer;
    int[][] arrayOfInt = this.huffmanMergedCodeSymbols;
    byte[] arrayOfByte = this.selectors;
    char[] arrayOfChar = this.mtfBlock;
    int i = this.mtfLength;
    int j = 0;
    for (int k = 0; j < i; k++)
    {
      int m = Math.min(j + 50, i);
      int[] arrayOfInt1 = arrayOfInt[arrayOfByte[k]];
      while (j <= m - 1)
      {
        int n = arrayOfInt1[arrayOfChar[j]];
        localBzip2BitWriter.writeBits(paramByteBuf, n >>> 24, n);
        j++;
      }
    }
  }
  
  private void writeSelectorsAndHuffmanTables(ByteBuf paramByteBuf)
  {
    Bzip2BitWriter localBzip2BitWriter = this.writer;
    byte[] arrayOfByte = this.selectors;
    int i = arrayOfByte.length;
    int[][] arrayOfInt = this.huffmanCodeLengths;
    int j = arrayOfInt.length;
    int k = this.mtfAlphabetSize;
    localBzip2BitWriter.writeBits(paramByteBuf, 3, j);
    localBzip2BitWriter.writeBits(paramByteBuf, 15, i);
    Bzip2MoveToFrontTable localBzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
    i = arrayOfByte.length;
    for (j = 0; j < i; j++) {
      localBzip2BitWriter.writeUnary(paramByteBuf, localBzip2MoveToFrontTable.valueToFront(arrayOfByte[j]));
    }
    int m = arrayOfInt.length;
    for (j = 0; j < m; j++)
    {
      arrayOfByte = arrayOfInt[j];
      int n = arrayOfByte[0];
      localBzip2BitWriter.writeBits(paramByteBuf, 5, n);
      i = 0;
      while (i < k)
      {
        int i1 = arrayOfByte[i];
        int i2;
        if (n < i1) {
          i2 = 2;
        } else {
          i2 = 3;
        }
        for (n = Math.abs(i1 - n); n > 0; n--) {
          localBzip2BitWriter.writeBits(paramByteBuf, 2, i2);
        }
        localBzip2BitWriter.writeBoolean(paramByteBuf, false);
        i++;
        n = i1;
      }
    }
  }
  
  void encode(ByteBuf paramByteBuf)
  {
    generateHuffmanOptimisationSeeds();
    for (int i = 3; i >= 0; i--)
    {
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      optimiseSelectorsAndHuffmanTables(bool);
    }
    assignHuffmanCodeSymbols();
    writeSelectorsAndHuffmanTables(paramByteBuf);
    writeBlockData(paramByteBuf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2HuffmanStageEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */