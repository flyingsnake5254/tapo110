package io.netty.handler.codec.compression;

final class Bzip2HuffmanStageDecoder
{
  final int alphabetSize;
  private final int[][] codeBases;
  private final int[][] codeLimits;
  private final int[][] codeSymbols;
  int currentAlpha;
  int currentGroup;
  int currentLength = -1;
  int currentSelector;
  private int currentTable;
  private int groupIndex = -1;
  private int groupPosition = -1;
  private final int[] minimumLengths;
  boolean modifyLength;
  private final Bzip2BitReader reader;
  byte[] selectors;
  final byte[][] tableCodeLengths;
  final Bzip2MoveToFrontTable tableMTF = new Bzip2MoveToFrontTable();
  final int totalTables;
  
  Bzip2HuffmanStageDecoder(Bzip2BitReader paramBzip2BitReader, int paramInt1, int paramInt2)
  {
    this.reader = paramBzip2BitReader;
    this.totalTables = paramInt1;
    this.alphabetSize = paramInt2;
    this.minimumLengths = new int[paramInt1];
    this.codeBases = new int[paramInt1][25];
    this.codeLimits = new int[paramInt1][24];
    this.codeSymbols = new int[paramInt1]['Ă'];
    this.tableCodeLengths = new byte[paramInt1]['Ă'];
  }
  
  void createHuffmanDecodingTables()
  {
    int i = this.alphabetSize;
    for (int j = 0;; j++)
    {
      Object localObject = this.tableCodeLengths;
      if (j >= localObject.length) {
        break;
      }
      int[] arrayOfInt1 = this.codeBases[j];
      int[] arrayOfInt2 = this.codeLimits[j];
      int[] arrayOfInt3 = this.codeSymbols[j];
      localObject = localObject[j];
      int k = 23;
      int m = 0;
      int n = 0;
      while (m < i)
      {
        i1 = localObject[m];
        n = Math.max(i1, n);
        k = Math.min(i1, k);
        m++;
      }
      this.minimumLengths[j] = k;
      for (m = 0; m < i; m++)
      {
        i1 = localObject[m] + 1;
        arrayOfInt1[i1] += 1;
      }
      int i1 = arrayOfInt1[0];
      for (m = 1; m < 25; m++)
      {
        i1 += arrayOfInt1[m];
        arrayOfInt1[m] = i1;
      }
      i1 = k;
      m = 0;
      int i2;
      while (i1 <= n)
      {
        i2 = i1 + 1;
        int i3 = arrayOfInt1[i2] - arrayOfInt1[i1] + m;
        arrayOfInt1[i1] = (m - arrayOfInt1[i1]);
        arrayOfInt2[i1] = (i3 - 1);
        m = i3 << 1;
        i1 = i2;
      }
      i1 = 0;
      while (k <= n)
      {
        m = 0;
        while (m < i)
        {
          i2 = i1;
          if (localObject[m] == k)
          {
            arrayOfInt3[i1] = m;
            i2 = i1 + 1;
          }
          m++;
          i1 = i2;
        }
        k++;
      }
    }
    this.currentTable = this.selectors[0];
  }
  
  int nextSymbol()
  {
    int i = this.groupPosition + 1;
    this.groupPosition = i;
    if (i % 50 == 0)
    {
      i = this.groupIndex + 1;
      this.groupIndex = i;
      localObject = this.selectors;
      if (i != localObject.length) {
        this.currentTable = (localObject[i] & 0xFF);
      } else {
        throw new DecompressionException("error decoding block");
      }
    }
    Bzip2BitReader localBzip2BitReader = this.reader;
    i = this.currentTable;
    Object localObject = this.codeLimits[i];
    int[] arrayOfInt1 = this.codeBases[i];
    int[] arrayOfInt2 = this.codeSymbols[i];
    int j = this.minimumLengths[i];
    i = localBzip2BitReader.readBits(j);
    while (j <= 23)
    {
      if (i <= localObject[j]) {
        return arrayOfInt2[(i - arrayOfInt1[j])];
      }
      i = i << 1 | localBzip2BitReader.readBits(1);
      j++;
    }
    throw new DecompressionException("a valid code was not recognised");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2HuffmanStageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */