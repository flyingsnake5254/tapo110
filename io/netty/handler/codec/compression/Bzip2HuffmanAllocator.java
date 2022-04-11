package io.netty.handler.codec.compression;

final class Bzip2HuffmanAllocator
{
  static void allocateHuffmanCodeLengths(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    if (i != 1)
    {
      if (i != 2)
      {
        setExtendedParentPointers(paramArrayOfInt);
        i = findNodesToRelocate(paramArrayOfInt, paramInt);
        if (paramArrayOfInt[0] % paramArrayOfInt.length >= i) {
          allocateNodeLengths(paramArrayOfInt);
        } else {
          allocateNodeLengthsWithRelocation(paramArrayOfInt, i, paramInt - (32 - Integer.numberOfLeadingZeros(i - 1)));
        }
        return;
      }
      paramArrayOfInt[1] = 1;
    }
    paramArrayOfInt[0] = 1;
  }
  
  private static void allocateNodeLengths(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int j = 2;
    int k = i - 2;
    int m = paramArrayOfInt.length;
    i = 1;
    m--;
    while (j > 0)
    {
      int n = first(paramArrayOfInt, k - 1, 0);
      k -= n;
      j -= k;
      while (j > 0)
      {
        paramArrayOfInt[m] = i;
        j--;
        m--;
      }
      j = k << 1;
      i++;
      k = n;
    }
  }
  
  private static void allocateNodeLengthsWithRelocation(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfInt.length;
    int j = 2;
    int k = i - 2;
    int m = paramArrayOfInt.length - 1;
    if (paramInt2 != 1) {
      j = 1;
    }
    if (paramInt2 == 1) {
      i = paramInt1 - 2;
    } else {
      i = paramInt1;
    }
    int n = j << 1;
    int i1 = i;
    int i2 = j;
    for (i = k; n > 0; i = k)
    {
      if (i <= paramInt1) {
        j = i;
      } else {
        j = first(paramArrayOfInt, i - 1, paramInt1);
      }
      int i3 = 0;
      if (i2 >= paramInt2)
      {
        i3 = Math.min(i1, 1 << i2 - paramInt2);
        k = j;
      }
      else
      {
        k = j;
        if (i2 == paramInt2 - 1)
        {
          k = j;
          if (paramArrayOfInt[j] == i) {
            k = j + 1;
          }
          i3 = 1;
        }
      }
      i = i - k + i3;
      j = n - i;
      while (j > 0)
      {
        paramArrayOfInt[m] = i2;
        j--;
        m--;
      }
      i1 -= i3;
      n = i << 1;
      i2++;
    }
  }
  
  private static int findNodesToRelocate(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length - 2;
    for (int j = 1; (j < paramInt - 1) && (i > 1); j++) {
      i = first(paramArrayOfInt, i - 1, 0);
    }
    return i;
  }
  
  private static int first(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfInt.length;
    int j = paramArrayOfInt.length - 2;
    int k = paramInt1;
    while ((k >= paramInt2) && (paramArrayOfInt[k] % i > paramInt1))
    {
      j = k;
      k -= paramInt1 - k + 1;
    }
    paramInt2 = Math.max(paramInt2 - 1, k);
    while (j > paramInt2 + 1)
    {
      k = paramInt2 + j >>> 1;
      if (paramArrayOfInt[k] % i > paramInt1) {
        j = k;
      } else {
        paramInt2 = k;
      }
    }
    return j;
  }
  
  private static void setExtendedParentPointers(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int j = 0;
    int k = paramArrayOfInt[0];
    int m = 1;
    paramArrayOfInt[0] = (k + paramArrayOfInt[1]);
    k = 2;
    while (m < i - 1)
    {
      int n;
      if ((k < i) && (paramArrayOfInt[j] >= paramArrayOfInt[k]))
      {
        n = paramArrayOfInt[k];
        k++;
      }
      else
      {
        n = paramArrayOfInt[j];
        paramArrayOfInt[j] = m;
        j++;
      }
      if ((k < i) && ((j >= m) || (paramArrayOfInt[j] >= paramArrayOfInt[k])))
      {
        n += paramArrayOfInt[k];
        k++;
      }
      else
      {
        n += paramArrayOfInt[j];
        paramArrayOfInt[j] = (m + i);
        j++;
      }
      paramArrayOfInt[m] = n;
      m++;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2HuffmanAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */