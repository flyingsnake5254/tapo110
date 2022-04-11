package io.netty.handler.codec.compression;

final class Bzip2MTFAndRLE2StageEncoder
{
  private int alphabetSize;
  private final int[] bwtBlock;
  private final int bwtLength;
  private final boolean[] bwtValuesPresent;
  private final char[] mtfBlock;
  private int mtfLength;
  private final int[] mtfSymbolFrequencies = new int['Ă'];
  
  Bzip2MTFAndRLE2StageEncoder(int[] paramArrayOfInt, int paramInt, boolean[] paramArrayOfBoolean)
  {
    this.bwtBlock = paramArrayOfInt;
    this.bwtLength = paramInt;
    this.bwtValuesPresent = paramArrayOfBoolean;
    this.mtfBlock = new char[paramInt + 1];
  }
  
  void encode()
  {
    int i = this.bwtLength;
    boolean[] arrayOfBoolean = this.bwtValuesPresent;
    int[] arrayOfInt1 = this.bwtBlock;
    char[] arrayOfChar = this.mtfBlock;
    int[] arrayOfInt2 = this.mtfSymbolFrequencies;
    byte[] arrayOfByte = new byte['Ā'];
    Bzip2MoveToFrontTable localBzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
    int j = 0;
    for (int k = 0; j < 256; k = m)
    {
      m = k;
      if (arrayOfBoolean[j] != 0)
      {
        arrayOfByte[j] = ((byte)(byte)k);
        m = k + 1;
      }
      j++;
    }
    int n = k + 1;
    int i1 = 0;
    int i2 = 0;
    j = 0;
    int m = 0;
    k = 0;
    while (i1 < i)
    {
      int i3 = localBzip2MoveToFrontTable.valueToFront(arrayOfByte[(arrayOfInt1[i1] & 0xFF)]);
      if (i3 == 0)
      {
        i4 = i2 + 1;
      }
      else
      {
        i4 = i2;
        int i5 = j;
        i6 = m;
        i7 = k;
        if (i2 > 0)
        {
          i2--;
          i4 = k;
          i6 = m;
          m = j;
          k = i2;
          for (;;)
          {
            if ((k & 0x1) == 0)
            {
              i2 = m + 1;
              arrayOfChar[m] = ((char)0);
              i6++;
              j = i4;
              m = i2;
            }
            else
            {
              j = m + 1;
              arrayOfChar[m] = ((char)1);
              i4++;
              m = j;
              j = i4;
            }
            if (k <= 1)
            {
              i4 = 0;
              i5 = m;
              i7 = j;
              break;
            }
            k = k - 2 >>> 1;
            i4 = j;
          }
        }
        j = i3 + 1;
        arrayOfChar[i5] = ((char)(char)j);
        arrayOfInt2[j] += 1;
        j = i5 + 1;
        k = i7;
        m = i6;
      }
      i1++;
      i2 = i4;
    }
    int i4 = j;
    int i6 = m;
    int i7 = k;
    if (i2 > 0)
    {
      i4 = i2 - 1;
      i2 = k;
      k = j;
      for (;;)
      {
        if ((i4 & 0x1) == 0)
        {
          j = k + 1;
          arrayOfChar[k] = ((char)0);
          m++;
          k = j;
          j = i2;
        }
        else
        {
          i6 = k + 1;
          arrayOfChar[k] = ((char)1);
          j = i2 + 1;
          k = i6;
        }
        if (i4 <= 1)
        {
          i4 = k;
          i6 = m;
          i7 = j;
          break;
        }
        i4 = i4 - 2 >>> 1;
        i2 = j;
      }
    }
    arrayOfChar[i4] = ((char)(char)n);
    arrayOfInt2[n] += 1;
    arrayOfInt2[0] += i6;
    arrayOfInt2[1] += i7;
    this.mtfLength = (i4 + 1);
    this.alphabetSize = (n + 1);
  }
  
  int mtfAlphabetSize()
  {
    return this.alphabetSize;
  }
  
  char[] mtfBlock()
  {
    return this.mtfBlock;
  }
  
  int mtfLength()
  {
    return this.mtfLength;
  }
  
  int[] mtfSymbolFrequencies()
  {
    return this.mtfSymbolFrequencies;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2MTFAndRLE2StageEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */