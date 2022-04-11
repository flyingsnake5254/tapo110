package io.netty.handler.codec.compression;

final class Bzip2DivSufSort
{
  private static final int BUCKET_A_SIZE = 256;
  private static final int BUCKET_B_SIZE = 65536;
  private static final int INSERTIONSORT_THRESHOLD = 8;
  private static final int[] LOG_2_TABLE = { -1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
  private static final int SS_BLOCKSIZE = 1024;
  private static final int STACK_SIZE = 64;
  private final int[] SA;
  private final byte[] T;
  private final int n;
  
  Bzip2DivSufSort(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt)
  {
    this.T = paramArrayOfByte;
    this.SA = paramArrayOfInt;
    this.n = paramInt;
  }
  
  private static int BUCKET_B(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2 << 8;
  }
  
  private static int BUCKET_BSTAR(int paramInt1, int paramInt2)
  {
    return paramInt1 << 8 | paramInt2;
  }
  
  private int constructBWT(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    byte[] arrayOfByte = this.T;
    int[] arrayOfInt = this.SA;
    int i = this.n;
    int j = 0;
    int k = 254;
    int m = 0;
    int i1 = 0;
    int i2;
    int i5;
    int i7;
    int i8;
    while (k >= 0)
    {
      m = k + 1;
      i2 = paramArrayOfInt2[BUCKET_BSTAR(k, m)];
      i3 = paramArrayOfInt1[m];
      i1 = 0;
      for (m = -1; i2 <= i3; m = i8)
      {
        int i4 = arrayOfInt[i3];
        if (i4 >= 0)
        {
          i5 = i4 - 1;
          i6 = i5;
          if (i5 < 0) {
            i6 = i - 1;
          }
          i7 = arrayOfByte[i6] & 0xFF;
          i5 = i1;
          i8 = m;
          if (i7 <= k)
          {
            arrayOfInt[i3] = (i4 ^ 0xFFFFFFFF);
            i5 = i6;
            if (i6 > 0)
            {
              i5 = i6;
              if ((arrayOfByte[(i6 - 1)] & 0xFF) > i7) {
                i5 = i6 ^ 0xFFFFFFFF;
              }
            }
            if (m == i7)
            {
              i1--;
              arrayOfInt[i1] = i5;
              i5 = i1;
              i8 = m;
            }
            else
            {
              if (m >= 0) {
                paramArrayOfInt2[BUCKET_B(m, k)] = i1;
              }
              m = paramArrayOfInt2[BUCKET_B(i7, k)] - 1;
              arrayOfInt[m] = i5;
              i8 = i7;
              i5 = m;
            }
          }
        }
        else
        {
          arrayOfInt[i3] = (i4 ^ 0xFFFFFFFF);
          i8 = m;
          i5 = i1;
        }
        i3--;
        i1 = i5;
      }
      k--;
      i5 = i1;
      i1 = m;
      m = i5;
    }
    int i6 = -1;
    k = i1;
    int i3 = m;
    m = j;
    while (m < i)
    {
      i7 = arrayOfInt[m];
      if (i7 >= 0)
      {
        i1 = i7 - 1;
        i5 = i1;
        if (i1 < 0) {
          i5 = i - 1;
        }
        i2 = arrayOfByte[i5] & 0xFF;
        j = i7;
        i1 = i3;
        i8 = k;
        if (i2 >= (arrayOfByte[(i5 + 1)] & 0xFF))
        {
          i1 = i5;
          if (i5 > 0)
          {
            i1 = i5;
            if ((arrayOfByte[(i5 - 1)] & 0xFF) < i2) {
              i1 = i5 ^ 0xFFFFFFFF;
            }
          }
          if (i2 == k)
          {
            i5 = i3 + 1;
            arrayOfInt[i5] = i1;
            j = i7;
            i1 = i5;
            i8 = k;
          }
          else
          {
            if (k != -1) {
              paramArrayOfInt1[k] = i3;
            }
            i5 = paramArrayOfInt1[i2] + 1;
            arrayOfInt[i5] = i1;
            i8 = i2;
            j = i7;
            i1 = i5;
          }
        }
      }
      else
      {
        j = i7 ^ 0xFFFFFFFF;
        i8 = k;
        i1 = i3;
      }
      if (j == 0)
      {
        arrayOfInt[m] = arrayOfByte[(i - 1)];
        i6 = m;
      }
      else
      {
        arrayOfInt[m] = arrayOfByte[(j - 1)];
      }
      m++;
      i3 = i1;
      k = i8;
    }
    return i6;
  }
  
  private static int getIDX(int paramInt)
  {
    if (paramInt < 0) {
      paramInt ^= 0xFFFFFFFF;
    }
    return paramInt;
  }
  
  private void lsIntroSort(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.SA;
    StackEntry[] arrayOfStackEntry = new StackEntry[64];
    int i = trLog(paramInt5 - paramInt4);
    int j = 0;
    int k = 0;
    for (;;)
    {
      int m = paramInt5 - paramInt4;
      StackEntry localStackEntry;
      if (m <= 8)
      {
        if (1 < m)
        {
          trInsertionSort(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
          lsUpdateGroup(paramInt1, paramInt4, paramInt5);
        }
        else if (m == 1)
        {
          arrayOfInt[paramInt4] = -1;
        }
        if (j == 0) {
          return;
        }
        j--;
        localStackEntry = arrayOfStackEntry[j];
        paramInt4 = localStackEntry.a;
        paramInt5 = localStackEntry.b;
        i = localStackEntry.c;
      }
      else
      {
        int i1 = i - 1;
        if (i == 0)
        {
          trHeapSort(paramInt1, paramInt2, paramInt3, paramInt4, m);
          i = paramInt5 - 1;
          while (paramInt4 < i)
          {
            k = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i]);
            i--;
            while ((paramInt4 <= i) && (trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i]) == k))
            {
              arrayOfInt[i] ^= 0xFFFFFFFF;
              i--;
            }
          }
          lsUpdateGroup(paramInt1, paramInt4, paramInt5);
          if (j == 0) {
            return;
          }
          j--;
          localStackEntry = arrayOfStackEntry[j];
          paramInt4 = localStackEntry.a;
          paramInt5 = localStackEntry.b;
          i = localStackEntry.c;
        }
        else
        {
          swapElements(arrayOfInt, paramInt4, arrayOfInt, trPivot(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
          int i2 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt4]);
          i = paramInt4 + 1;
          while (i < paramInt5)
          {
            m = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i]);
            k = m;
            if (m != i2) {
              break;
            }
            i++;
            k = m;
          }
          int i5;
          if ((i < paramInt5) && (k < i2))
          {
            m = i;
            i3 = i;
            for (;;)
            {
              i = i3 + 1;
              i3 = i;
              i4 = m;
              if (i >= paramInt5) {
                break;
              }
              i5 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i]);
              i3 = i;
              i4 = m;
              k = i5;
              if (i5 > i2) {
                break;
              }
              i3 = i;
              k = i5;
              if (i5 == i2)
              {
                swapElements(arrayOfInt, i, arrayOfInt, m);
                m++;
                i3 = i;
                k = i5;
              }
            }
          }
          int i4 = i;
          int i3 = i;
          i = paramInt5 - 1;
          while (i3 < i)
          {
            m = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i]);
            k = m;
            if (m != i2) {
              break;
            }
            i--;
            k = m;
          }
          int i6;
          int i7;
          int i8;
          int i9;
          int i10;
          int i11;
          int i12;
          if ((i3 < i) && (k > i2))
          {
            i6 = i;
            m = i;
            i = k;
            for (;;)
            {
              i7 = m - 1;
              i8 = i3;
              i9 = i4;
              m = i7;
              i5 = i6;
              i10 = paramInt4;
              i11 = paramInt5;
              k = j;
              if (i3 >= i7) {
                break;
              }
              i12 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i7]);
              i8 = i3;
              i9 = i4;
              i = i12;
              m = i7;
              i5 = i6;
              i10 = paramInt4;
              i11 = paramInt5;
              k = j;
              if (i12 < i2) {
                break;
              }
              i = i12;
              m = i7;
              if (i12 == i2)
              {
                swapElements(arrayOfInt, i7, arrayOfInt, i6);
                i6--;
                i = i12;
                m = i7;
              }
            }
            i3 = i;
            i = i8;
            i4 = i9;
            paramInt4 = i10;
            paramInt5 = i11;
            j = k;
            k = i3;
          }
          else
          {
            i5 = i;
            m = i;
            i = i3;
          }
          label727:
          if (i < m)
          {
            swapElements(arrayOfInt, i, arrayOfInt, m);
            i11 = k;
            k = i4;
            i6 = i;
            int i13;
            int i14;
            int i15;
            for (;;)
            {
              i6++;
              i3 = k;
              i = m;
              i13 = i5;
              i7 = paramInt4;
              i12 = paramInt5;
              i14 = j;
              if (i6 >= m) {
                break label899;
              }
              i3 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i6]);
              i10 = k;
              i11 = i3;
              i = m;
              i4 = i5;
              i9 = paramInt4;
              i15 = paramInt5;
              i8 = j;
              if (i3 > i2) {
                break;
              }
              i = k;
              if (i3 == i2)
              {
                swapElements(arrayOfInt, i6, arrayOfInt, k);
                i = k + 1;
              }
              k = i;
              i11 = i3;
            }
            for (;;)
            {
              i14 = i8;
              i12 = i15;
              i7 = i9;
              i13 = i4;
              i3 = i10;
              label899:
              int i16 = i - 1;
              i = i6;
              i4 = i3;
              m = i16;
              i5 = i13;
              paramInt4 = i7;
              paramInt5 = i12;
              j = i14;
              k = i11;
              if (i6 >= i16) {
                break label727;
              }
              paramInt4 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i16]);
              i8 = i6;
              i9 = i3;
              i = paramInt4;
              m = i16;
              i5 = i13;
              i10 = i7;
              i11 = i12;
              k = i14;
              if (paramInt4 < i2) {
                break;
              }
              i10 = i3;
              i11 = paramInt4;
              i = i16;
              i4 = i13;
              i9 = i7;
              i15 = i12;
              i8 = i14;
              if (paramInt4 == i2)
              {
                swapElements(arrayOfInt, i16, arrayOfInt, i13);
                i4 = i13 - 1;
                i10 = i3;
                i11 = paramInt4;
                i = i16;
                i9 = i7;
                i15 = i12;
                i8 = i14;
              }
            }
          }
          if (i4 <= i5)
          {
            i3 = i4 - paramInt4;
            i6 = i - i4;
            m = i3;
            if (i3 > i6) {
              m = i6;
            }
            i3 = i - m;
            i4 = paramInt4;
            while (m > 0)
            {
              swapElements(arrayOfInt, i4, arrayOfInt, i3);
              m--;
              i4++;
              i3++;
            }
            i3 = i5 - (i - 1);
            m = paramInt5 - i5 - 1;
            if (i3 <= m) {
              m = i3;
            }
            for (i5 = paramInt5 - m; m > 0; i5++)
            {
              swapElements(arrayOfInt, i, arrayOfInt, i5);
              m--;
              i++;
            }
            i = paramInt4 + i6;
            m = paramInt5 - i3;
            for (i5 = paramInt4; i5 < i; i5++) {
              arrayOfInt[(arrayOfInt[i5] + paramInt1)] = (i - 1);
            }
            if (m < paramInt5) {
              for (i5 = i; i5 < m; i5++) {
                arrayOfInt[(arrayOfInt[i5] + paramInt1)] = (m - 1);
              }
            }
            if (m - i == 1) {
              arrayOfInt[i] = -1;
            }
            if (i - paramInt4 <= paramInt5 - m)
            {
              if (paramInt4 < i)
              {
                i5 = j + 1;
                arrayOfStackEntry[j] = new StackEntry(m, paramInt5, i1, 0);
                paramInt5 = i;
                j = i5;
              }
              else
              {
                paramInt4 = m;
                break label1426;
              }
            }
            else
            {
              if (m >= paramInt5) {
                break label1422;
              }
              i5 = j + 1;
              arrayOfStackEntry[j] = new StackEntry(paramInt4, i, i1, 0);
              paramInt4 = m;
              j = i5;
            }
            break label1426;
            label1422:
            paramInt5 = i;
            label1426:
            i = i1;
          }
          else
          {
            if (j == 0) {
              return;
            }
            j--;
            localStackEntry = arrayOfStackEntry[j];
            paramInt4 = localStackEntry.a;
            paramInt5 = localStackEntry.b;
            i = localStackEntry.c;
          }
        }
      }
    }
  }
  
  private void lsSort(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.SA;
    int i = paramInt3 + paramInt1;
    for (;;)
    {
      paramInt3 = -paramInt2;
      int j = 0;
      if (paramInt3 >= arrayOfInt[0]) {
        break;
      }
      paramInt3 = 0;
      int k = 0;
      int m;
      int i1;
      do
      {
        m = arrayOfInt[k];
        if (m < 0)
        {
          i1 = k - m;
          m = paramInt3 + m;
        }
        else
        {
          if (paramInt3 != 0)
          {
            arrayOfInt[(k + paramInt3)] = paramInt3;
            paramInt3 = 0;
          }
          i1 = arrayOfInt[(m + paramInt1)] + 1;
          lsIntroSort(paramInt1, i, paramInt1 + paramInt2, k, i1);
          m = paramInt3;
        }
        paramInt3 = m;
        k = i1;
      } while (i1 < paramInt2);
      if (m != 0) {
        arrayOfInt[(i1 + m)] = m;
      }
      paramInt3 = i - paramInt1;
      if (paramInt2 < paramInt3)
      {
        paramInt3 = j;
        do
        {
          i1 = arrayOfInt[paramInt3];
          if (i1 < 0)
          {
            i1 = paramInt3 - i1;
          }
          else
          {
            i1 = arrayOfInt[(i1 + paramInt1)] + 1;
            while (paramInt3 < i1)
            {
              arrayOfInt[(arrayOfInt[paramInt3] + paramInt1)] = paramInt3;
              paramInt3++;
            }
          }
          paramInt3 = i1;
        } while (i1 < paramInt2);
        break;
      }
      i += paramInt3;
    }
  }
  
  private void lsUpdateGroup(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.SA;
    while (paramInt2 < paramInt3)
    {
      int i = paramInt2;
      int j;
      if (arrayOfInt[paramInt2] >= 0)
      {
        j = paramInt2;
        do
        {
          arrayOfInt[(arrayOfInt[j] + paramInt1)] = j;
          i = j + 1;
          if (i >= paramInt3) {
            break;
          }
          j = i;
        } while (arrayOfInt[i] >= 0);
        arrayOfInt[paramInt2] = (paramInt2 - i);
        if (paramInt3 <= i) {
          break;
        }
      }
      paramInt2 = i;
      do
      {
        arrayOfInt[paramInt2] ^= 0xFFFFFFFF;
        j = paramInt2 + 1;
        paramInt2 = j;
      } while (arrayOfInt[j] < 0);
      do
      {
        arrayOfInt[(arrayOfInt[i] + paramInt1)] = j;
        paramInt2 = i + 1;
        i = paramInt2;
      } while (paramInt2 <= j);
      paramInt2 = j + 1;
    }
  }
  
  private int sortTypeBstar(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    byte[] arrayOfByte = this.T;
    int[] arrayOfInt1 = this.SA;
    int i = this.n;
    int[] arrayOfInt2 = new int['Ā'];
    for (int j = 1; j < i; j++)
    {
      k = j - 1;
      if (arrayOfByte[k] != arrayOfByte[j])
      {
        if ((arrayOfByte[k] & 0xFF) <= (arrayOfByte[j] & 0xFF)) {
          break;
        }
        m = 0;
        break label85;
      }
    }
    int m = 1;
    label85:
    int i1 = i - 1;
    int k = arrayOfByte[i1] & 0xFF;
    j = arrayOfByte[0] & 0xFF;
    int i4;
    if ((k >= j) && ((arrayOfByte[i1] != arrayOfByte[0]) || (m == 0)))
    {
      k = i;
      j = i1;
    }
    else
    {
      if (m == 0)
      {
        j = BUCKET_BSTAR(k, j);
        paramArrayOfInt2[j] += 1;
        i2 = i - 1;
        arrayOfInt1[i2] = i1;
      }
      else
      {
        j = BUCKET_B(k, j);
        paramArrayOfInt2[j] += 1;
        i2 = i;
      }
      for (i3 = i1 - 1;; i3--)
      {
        k = i2;
        j = i3;
        if (i3 < 0) {
          break;
        }
        i4 = arrayOfByte[i3] & 0xFF;
        i5 = arrayOfByte[(i3 + 1)] & 0xFF;
        k = i2;
        j = i3;
        if (i4 > i5) {
          break;
        }
        j = BUCKET_B(i4, i5);
        paramArrayOfInt2[j] += 1;
      }
    }
    while (j >= 0)
    {
      do
      {
        i2 = arrayOfByte[j] & 0xFF;
        paramArrayOfInt1[i2] += 1;
        i2 = j - 1;
        if (i2 < 0) {
          break;
        }
        j = i2;
      } while ((arrayOfByte[i2] & 0xFF) >= (arrayOfByte[(i2 + 1)] & 0xFF));
      j = i2;
      if (i2 >= 0)
      {
        j = BUCKET_BSTAR(arrayOfByte[i2] & 0xFF, arrayOfByte[(i2 + 1)] & 0xFF);
        paramArrayOfInt2[j] += 1;
        i3 = k - 1;
        arrayOfInt1[i3] = i2;
        for (;;)
        {
          i2--;
          k = i3;
          j = i2;
          if (i2 < 0) {
            break;
          }
          i5 = arrayOfByte[i2] & 0xFF;
          i4 = arrayOfByte[(i2 + 1)] & 0xFF;
          k = i3;
          j = i2;
          if (i5 > i4) {
            break;
          }
          j = BUCKET_B(i5, i4);
          paramArrayOfInt2[j] += 1;
        }
      }
    }
    k = i - k;
    if (k == 0)
    {
      for (j = 0; j < i; j++) {
        arrayOfInt1[j] = j;
      }
      return 0;
    }
    int i2 = 0;
    j = -1;
    int i5 = 0;
    while (i2 < 256)
    {
      i3 = paramArrayOfInt1[i2];
      paramArrayOfInt1[i2] = (j + i5);
      j = i3 + j + paramArrayOfInt2[BUCKET_B(i2, i2)];
      i3 = i2 + 1;
      for (i4 = i3; i4 < 256; i4++)
      {
        i5 += paramArrayOfInt2[BUCKET_BSTAR(i2, i4)];
        paramArrayOfInt2[(i2 << 8 | i4)] = i5;
        j += paramArrayOfInt2[BUCKET_B(i2, i4)];
      }
      i2 = i3;
    }
    int i6 = i - k;
    for (j = k - 2; j >= 0; j--)
    {
      i2 = arrayOfInt1[(i6 + j)];
      i3 = BUCKET_BSTAR(arrayOfByte[i2] & 0xFF, arrayOfByte[(i2 + 1)] & 0xFF);
      i2 = paramArrayOfInt2[i3] - 1;
      paramArrayOfInt2[i3] = i2;
      arrayOfInt1[i2] = j;
    }
    j = arrayOfInt1[(i6 + k - 1)];
    i2 = BUCKET_BSTAR(arrayOfByte[j] & 0xFF, arrayOfByte[(j + 1)] & 0xFF);
    j = paramArrayOfInt2[i2] - 1;
    paramArrayOfInt2[i2] = j;
    i2 = k - 1;
    arrayOfInt1[j] = i2;
    i5 = i - k * 2;
    if (i5 <= 256)
    {
      i5 = 256;
      i4 = 0;
    }
    else
    {
      i4 = k;
      arrayOfInt2 = arrayOfInt1;
    }
    int i3 = k;
    int i8;
    for (j = 255; i3 > 0; j = i8)
    {
      int i7 = i3;
      i8 = 255;
      i3 = j;
      for (j = i7; i3 < i8; j = i7)
      {
        i7 = paramArrayOfInt2[BUCKET_BSTAR(i3, i8)];
        if (1 < j - i7)
        {
          boolean bool;
          if (arrayOfInt1[i7] == i2) {
            bool = true;
          } else {
            bool = false;
          }
          subStringSort(i6, i7, j, arrayOfInt2, i4, i5, 2, bool, i);
        }
        i8--;
      }
      i8 = i3 - 1;
      i3 = j;
    }
    for (i3 = i2; i3 >= 0; i3 = i - 1)
    {
      j = i3;
      if (arrayOfInt1[i3] >= 0)
      {
        j = i3;
        do
        {
          arrayOfInt1[(k + arrayOfInt1[j])] = j;
          i = j - 1;
          if (i < 0) {
            break;
          }
          j = i;
        } while (arrayOfInt1[i] >= 0);
        arrayOfInt1[(i + 1)] = (i - i3);
        if (i <= 0) {
          break;
        }
        j = i;
      }
      i3 = j;
      do
      {
        i = arrayOfInt1[i3] ^ 0xFFFFFFFF;
        arrayOfInt1[i3] = i;
        arrayOfInt1[(k + i)] = j;
        i = i3 - 1;
        i3 = i;
      } while (arrayOfInt1[i] < 0);
      arrayOfInt1[(k + arrayOfInt1[i])] = j;
    }
    trSort(k, k, 1);
    if (((arrayOfByte[i1] & 0xFF) >= (arrayOfByte[0] & 0xFF)) && ((arrayOfByte[i1] != arrayOfByte[0]) || (m == 0)))
    {
      i3 = k;
      j = i1;
    }
    else
    {
      if (m == 0)
      {
        m = k - 1;
        arrayOfInt1[arrayOfInt1[(k + m)]] = i1;
      }
      else
      {
        m = k;
      }
      for (i = i1 - 1;; i--)
      {
        j = i;
        i3 = m;
        if (i < 0) {
          break;
        }
        j = i;
        i3 = m;
        if ((arrayOfByte[i] & 0xFF) > (arrayOfByte[(i + 1)] & 0xFF)) {
          break;
        }
      }
    }
    while (j >= 0)
    {
      for (;;)
      {
        m = j - 1;
        if ((m < 0) || ((arrayOfByte[m] & 0xFF) < (arrayOfByte[(m + 1)] & 0xFF))) {
          break;
        }
        j = m;
      }
      j = m;
      if (m >= 0)
      {
        i = i3 - 1;
        arrayOfInt1[arrayOfInt1[(k + i)]] = m;
        for (;;)
        {
          m--;
          j = m;
          i3 = i;
          if (m < 0) {
            break;
          }
          j = m;
          i3 = i;
          if ((arrayOfByte[m] & 0xFF) > (arrayOfByte[(m + 1)] & 0xFF)) {
            break;
          }
        }
      }
    }
    i3 = i2;
    i2 = 255;
    while (i2 >= 0)
    {
      m = 255;
      j = i1;
      i1 = i3;
      for (i3 = m; i2 < i3; i3--)
      {
        i = paramArrayOfInt2[BUCKET_B(i2, i3)];
        paramArrayOfInt2[BUCKET_B(i2, i3)] = (j + 1);
        m = paramArrayOfInt2[BUCKET_BSTAR(i2, i3)];
        j -= i;
        while (m <= i1)
        {
          arrayOfInt1[j] = arrayOfInt1[i1];
          j--;
          i1--;
        }
      }
      i3 = paramArrayOfInt2[BUCKET_B(i2, i2)];
      paramArrayOfInt2[BUCKET_B(i2, i2)] = (j + 1);
      if (i2 < 255) {
        paramArrayOfInt2[BUCKET_BSTAR(i2, i2 + 1)] = (j - i3 + 1);
      }
      j = paramArrayOfInt1[i2];
      i2--;
      i3 = i1;
      i1 = j;
    }
    return k;
  }
  
  private static void ssBlockSwap(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    while (paramInt3 > 0)
    {
      swapElements(paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2);
      paramInt3--;
      paramInt1++;
      paramInt2++;
    }
  }
  
  private int ssCompare(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.SA;
    byte[] arrayOfByte = this.T;
    int i = arrayOfInt[(paramInt1 + 1)] + 2;
    int j = arrayOfInt[(paramInt2 + 1)] + 2;
    int k = arrayOfInt[paramInt1] + paramInt3;
    paramInt1 = paramInt3 + arrayOfInt[paramInt2];
    paramInt2 = k;
    while ((paramInt2 < i) && (paramInt1 < j) && (arrayOfByte[paramInt2] == arrayOfByte[paramInt1]))
    {
      paramInt2++;
      paramInt1++;
    }
    if (paramInt2 < i)
    {
      if (paramInt1 < j) {
        paramInt1 = (arrayOfByte[paramInt2] & 0xFF) - (arrayOfByte[paramInt1] & 0xFF);
      } else {
        paramInt1 = 1;
      }
    }
    else if (paramInt1 < j) {
      paramInt1 = -1;
    } else {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  private int ssCompareLast(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.SA;
    byte[] arrayOfByte = this.T;
    int i = arrayOfInt[paramInt2] + paramInt4;
    paramInt2 = paramInt4 + arrayOfInt[paramInt3];
    paramInt4 = 1;
    int j = 1;
    int k = arrayOfInt[(paramInt3 + 1)] + 2;
    paramInt3 = i;
    while ((paramInt3 < paramInt5) && (paramInt2 < k) && (arrayOfByte[paramInt3] == arrayOfByte[paramInt2]))
    {
      paramInt3++;
      paramInt2++;
    }
    if (paramInt3 < paramInt5)
    {
      paramInt1 = j;
      if (paramInt2 < k) {
        paramInt1 = (arrayOfByte[paramInt3] & 0xFF) - (arrayOfByte[paramInt2] & 0xFF);
      }
      return paramInt1;
    }
    if (paramInt2 == k) {
      return 1;
    }
    paramInt3 %= paramInt5;
    paramInt1 = arrayOfInt[paramInt1] + 2;
    while ((paramInt3 < paramInt1) && (paramInt2 < k) && (arrayOfByte[paramInt3] == arrayOfByte[paramInt2]))
    {
      paramInt3++;
      paramInt2++;
    }
    if (paramInt3 < paramInt1)
    {
      paramInt1 = paramInt4;
      if (paramInt2 < k) {
        paramInt1 = (arrayOfByte[paramInt3] & 0xFF) - (arrayOfByte[paramInt2] & 0xFF);
      }
    }
    else if (paramInt2 < k)
    {
      paramInt1 = -1;
    }
    else
    {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  private void ssFixdown(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.SA;
    byte[] arrayOfByte = this.T;
    int i = arrayOfInt[(paramInt3 + paramInt4)];
    int j = arrayOfByte[(arrayOfInt[(paramInt2 + i)] + paramInt1)];
    for (int k = paramInt4;; k = paramInt4)
    {
      paramInt4 = k * 2 + 1;
      if (paramInt4 >= paramInt5) {
        break;
      }
      int m = paramInt4 + 1;
      int i1 = arrayOfByte[(arrayOfInt[(arrayOfInt[(paramInt3 + paramInt4)] + paramInt2)] + paramInt1)] & 0xFF;
      int i2 = arrayOfByte[(arrayOfInt[(arrayOfInt[(paramInt3 + m)] + paramInt2)] + paramInt1)] & 0xFF;
      int i3 = i1;
      if (i1 < i2)
      {
        paramInt4 = m;
        i3 = i2;
      }
      if (i3 <= (j & 0xFF)) {
        break;
      }
      arrayOfInt[(k + paramInt3)] = arrayOfInt[(paramInt3 + paramInt4)];
    }
    arrayOfInt[(paramInt3 + k)] = i;
  }
  
  private void ssHeapSort(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = this.SA;
    byte[] arrayOfByte = this.T;
    int i = paramInt4 % 2;
    if (i == 0)
    {
      paramInt4--;
      j = paramInt4 / 2 + paramInt3;
      int k = arrayOfByte[(arrayOfInt[(arrayOfInt[j] + paramInt2)] + paramInt1)];
      int m = paramInt3 + paramInt4;
      if ((k & 0xFF) < (arrayOfByte[(arrayOfInt[(arrayOfInt[m] + paramInt2)] + paramInt1)] & 0xFF)) {
        swapElements(arrayOfInt, m, arrayOfInt, j);
      }
    }
    for (int j = paramInt4 / 2 - 1; j >= 0; j--) {
      ssFixdown(paramInt1, paramInt2, paramInt3, j, paramInt4);
    }
    if (i == 0)
    {
      swapElements(arrayOfInt, paramInt3, arrayOfInt, paramInt3 + paramInt4);
      ssFixdown(paramInt1, paramInt2, paramInt3, 0, paramInt4);
    }
    paramInt4--;
    while (paramInt4 > 0)
    {
      i = arrayOfInt[paramInt3];
      j = paramInt3 + paramInt4;
      arrayOfInt[paramInt3] = arrayOfInt[j];
      ssFixdown(paramInt1, paramInt2, paramInt3, 0, paramInt4);
      arrayOfInt[j] = i;
      paramInt4--;
    }
  }
  
  private void ssInsertionSort(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = this.SA;
    for (int i = paramInt3 - 2; paramInt2 <= i; i--)
    {
      int j = arrayOfInt[i];
      int k = i + 1;
      int m;
      int i1;
      do
      {
        m = ssCompare(paramInt1 + j, arrayOfInt[k] + paramInt1, paramInt4);
        i1 = k;
        if (m <= 0) {
          break;
        }
        do
        {
          arrayOfInt[(k - 1)] = arrayOfInt[k];
          i1 = k + 1;
          if (i1 >= paramInt3) {
            break;
          }
          k = i1;
        } while (arrayOfInt[i1] < 0);
        k = i1;
      } while (paramInt3 > i1);
      if (m == 0) {
        arrayOfInt[i1] ^= 0xFFFFFFFF;
      }
      arrayOfInt[(i1 - 1)] = j;
    }
  }
  
  private static int ssLog(int paramInt)
  {
    if ((0xFF00 & paramInt) != 0) {
      paramInt = LOG_2_TABLE[(paramInt >> 8 & 0xFF)] + 8;
    } else {
      paramInt = LOG_2_TABLE[(paramInt & 0xFF)];
    }
    return paramInt;
  }
  
  private int ssMedian3(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.SA;
    byte[] arrayOfByte = this.T;
    int i = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt3] + paramInt2)] + paramInt1)] & 0xFF;
    int j = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt4] + paramInt2)] + paramInt1)] & 0xFF;
    int k = arrayOfByte[(paramInt1 + arrayOfInt[(paramInt2 + arrayOfInt[paramInt5])])] & 0xFF;
    if (i > j)
    {
      paramInt1 = j;
      paramInt2 = paramInt3;
      paramInt3 = paramInt4;
    }
    else
    {
      paramInt2 = paramInt4;
      paramInt1 = i;
      i = j;
    }
    if (i > k)
    {
      if (paramInt1 > k) {
        return paramInt3;
      }
      return paramInt5;
    }
    return paramInt2;
  }
  
  private int ssMedian5(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int[] arrayOfInt = this.SA;
    byte[] arrayOfByte = this.T;
    int i = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt3] + paramInt2)] + paramInt1)] & 0xFF;
    int j = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt4] + paramInt2)] + paramInt1)] & 0xFF;
    int k = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt5] + paramInt2)] + paramInt1)] & 0xFF;
    int m = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt6] + paramInt2)] + paramInt1)] & 0xFF;
    int i1 = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt7] + paramInt2)] + paramInt1)] & 0xFF;
    if (j > k)
    {
      paramInt2 = j;
      paramInt1 = paramInt4;
      j = paramInt5;
    }
    else
    {
      paramInt2 = k;
      k = j;
      paramInt1 = paramInt5;
      j = paramInt4;
    }
    if (m > i1)
    {
      paramInt5 = m;
      paramInt4 = paramInt6;
      paramInt6 = i1;
    }
    else
    {
      paramInt5 = i1;
      i1 = m;
      paramInt4 = paramInt6;
      m = paramInt7;
      paramInt6 = i1;
      paramInt7 = paramInt4;
      paramInt4 = m;
    }
    if (k > paramInt6)
    {
      paramInt7 = paramInt4;
      paramInt6 = paramInt2;
      paramInt2 = paramInt5;
      paramInt4 = paramInt1;
      paramInt1 = paramInt7;
      paramInt5 = paramInt6;
    }
    else
    {
      k = paramInt6;
      j = paramInt7;
    }
    if (i > paramInt2)
    {
      paramInt6 = paramInt3;
      paramInt3 = paramInt1;
      paramInt1 = i;
    }
    else
    {
      paramInt6 = paramInt2;
      paramInt2 = i;
      paramInt7 = paramInt1;
      paramInt1 = paramInt6;
      paramInt6 = paramInt7;
    }
    if (paramInt2 > k)
    {
      j = paramInt3;
      k = paramInt2;
    }
    else
    {
      paramInt5 = paramInt1;
      paramInt4 = paramInt6;
    }
    if (paramInt5 > k) {
      return j;
    }
    return paramInt4;
  }
  
  private void ssMerge(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6, int paramInt7)
  {
    int[] arrayOfInt = this.SA;
    StackEntry[] arrayOfStackEntry = new StackEntry[64];
    int i = paramInt2;
    paramInt2 = paramInt3;
    paramInt3 = paramInt4;
    int j = 0;
    paramInt4 = 0;
    int k = paramInt3;
    int m = k - paramInt2;
    StackEntry localStackEntry;
    if (m <= paramInt6)
    {
      if ((i < paramInt2) && (paramInt2 < k)) {
        ssMergeBackward(paramInt1, paramArrayOfInt, paramInt5, i, paramInt2, k, paramInt7);
      }
      if ((j & 0x1) != 0) {
        ssMergeCheckEqual(paramInt1, paramInt7, i);
      }
      if ((j & 0x2) != 0) {
        ssMergeCheckEqual(paramInt1, paramInt7, k);
      }
      if (paramInt4 == 0) {
        return;
      }
      paramInt4--;
      localStackEntry = arrayOfStackEntry[paramInt4];
      j = localStackEntry.a;
      paramInt2 = localStackEntry.b;
      paramInt3 = localStackEntry.c;
      i = localStackEntry.d;
    }
    for (;;)
    {
      m = i;
      i = j;
      j = m;
      break;
      paramInt3 = paramInt2 - i;
      if (paramInt3 <= paramInt6)
      {
        if (i < paramInt2) {
          ssMergeForward(paramInt1, paramArrayOfInt, paramInt5, i, paramInt2, k, paramInt7);
        }
        if ((j & 0x1) != 0) {
          ssMergeCheckEqual(paramInt1, paramInt7, i);
        }
        if ((j & 0x2) != 0) {
          ssMergeCheckEqual(paramInt1, paramInt7, k);
        }
        if (paramInt4 == 0) {
          return;
        }
        paramInt4--;
        localStackEntry = arrayOfStackEntry[paramInt4];
        j = localStackEntry.a;
        paramInt2 = localStackEntry.b;
        paramInt3 = localStackEntry.c;
        i = localStackEntry.d;
      }
      else
      {
        int i1 = Math.min(paramInt3, m);
        paramInt3 = i1 >> 1;
        int i3;
        for (int i2 = 0; i1 > 0; i2 = i3)
        {
          m = paramInt3;
          i3 = i2;
          if (ssCompare(getIDX(arrayOfInt[(paramInt2 + i2 + paramInt3)]) + paramInt1, getIDX(arrayOfInt[(paramInt2 - i2 - paramInt3 - 1)]) + paramInt1, paramInt7) < 0)
          {
            i3 = i2 + (paramInt3 + 1);
            m = paramInt3 - (i1 & 0x1 ^ 0x1);
          }
          paramInt3 = m >> 1;
          i1 = m;
        }
        if (i2 > 0)
        {
          i1 = paramInt2 - i2;
          ssBlockSwap(arrayOfInt, i1, arrayOfInt, paramInt2, i2);
          int i4 = paramInt2 + i2;
          if (i4 < k)
          {
            if (arrayOfInt[i4] < 0)
            {
              for (m = paramInt2; arrayOfInt[(m - 1)] < 0; m--) {}
              arrayOfInt[i4] ^= 0xFFFFFFFF;
            }
            else
            {
              m = paramInt2;
            }
            for (paramInt3 = paramInt2; arrayOfInt[paramInt3] < 0; paramInt3++) {}
            i3 = 1;
          }
          else
          {
            paramInt3 = paramInt2;
            m = paramInt3;
            i3 = 0;
          }
          if (m - i <= k - paramInt3)
          {
            arrayOfStackEntry[paramInt4] = new StackEntry(paramInt3, i4, k, i3 & 0x1 | j & 0x2);
            j &= 0x1;
            paramInt2 = i1;
            paramInt4++;
            paramInt3 = m;
            break;
          }
          i2 = i3;
          if (m == paramInt2)
          {
            i2 = i3;
            if (paramInt2 == paramInt3) {
              i2 = i3 << 1;
            }
          }
          arrayOfStackEntry[paramInt4] = new StackEntry(i, i1, m, j & 0x1 | i2 & 0x2);
          j = j & 0x2 | i2 & 0x1;
          paramInt2 = i4;
          paramInt4++;
          i = paramInt3;
          paramInt3 = k;
          break;
        }
        if ((j & 0x1) != 0) {
          ssMergeCheckEqual(paramInt1, paramInt7, i);
        }
        ssMergeCheckEqual(paramInt1, paramInt7, paramInt2);
        if ((j & 0x2) != 0) {
          ssMergeCheckEqual(paramInt1, paramInt7, k);
        }
        if (paramInt4 == 0) {
          return;
        }
        paramInt4--;
        localStackEntry = arrayOfStackEntry[paramInt4];
        j = localStackEntry.a;
        paramInt2 = localStackEntry.b;
        paramInt3 = localStackEntry.c;
        i = localStackEntry.d;
      }
    }
  }
  
  private void ssMergeBackward(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int[] arrayOfInt = this.SA;
    int i = paramInt5 - paramInt4;
    ssBlockSwap(paramArrayOfInt, paramInt2, arrayOfInt, paramInt4, i);
    i = paramInt2 + i - 1;
    int j;
    int k;
    if (paramArrayOfInt[i] < 0)
    {
      j = paramInt1 + (paramArrayOfInt[i] ^ 0xFFFFFFFF);
      k = 1;
    }
    else
    {
      j = paramInt1 + paramArrayOfInt[i];
      k = 0;
    }
    int m = paramInt4 - 1;
    if (arrayOfInt[m] < 0)
    {
      k |= 0x2;
      paramInt4 = arrayOfInt[m] ^ 0xFFFFFFFF;
    }
    else
    {
      paramInt4 = arrayOfInt[m];
    }
    int i1 = paramInt1 + paramInt4;
    paramInt4 = paramInt5 - 1;
    int i2 = arrayOfInt[paramInt4];
    paramInt5 = i;
    i = m;
    for (;;)
    {
      m = ssCompare(j, i1, paramInt6);
      int i3;
      if (m > 0)
      {
        i3 = paramInt4;
        m = paramInt5;
        j = k;
        if ((k & 0x1) != 0) {
          for (j = paramInt4;; j = paramInt4)
          {
            paramInt4 = j - 1;
            arrayOfInt[j] = paramArrayOfInt[paramInt5];
            m = paramInt5 - 1;
            paramArrayOfInt[paramInt5] = arrayOfInt[paramInt4];
            if (paramArrayOfInt[m] >= 0)
            {
              j = k ^ 0x1;
              i3 = paramInt4;
              break;
            }
            paramInt5 = m;
          }
        }
        int i4 = i3 - 1;
        arrayOfInt[i3] = paramArrayOfInt[m];
        if (m <= paramInt2)
        {
          paramArrayOfInt[m] = i2;
          return;
        }
        paramInt5 = m - 1;
        paramArrayOfInt[m] = arrayOfInt[i4];
        if (paramArrayOfInt[paramInt5] < 0)
        {
          k = j | 0x1;
          paramInt4 = paramArrayOfInt[paramInt5] ^ 0xFFFFFFFF;
        }
        else
        {
          paramInt4 = paramArrayOfInt[paramInt5];
          k = j;
        }
        j = i4;
        m = paramInt1 + paramInt4;
        paramInt4 = j;
        j = m;
      }
      else if (m < 0)
      {
        m = i;
        i3 = paramInt4;
        i1 = k;
        if ((k & 0x2) != 0) {
          for (i1 = paramInt4;; i1 = paramInt4)
          {
            paramInt4 = i1 - 1;
            arrayOfInt[i1] = arrayOfInt[i];
            i1 = i - 1;
            arrayOfInt[i] = arrayOfInt[paramInt4];
            if (arrayOfInt[i1] >= 0)
            {
              i = k ^ 0x2;
              m = i1;
              i3 = paramInt4;
              i1 = i;
              break;
            }
            i = i1;
          }
        }
        paramInt4 = i3 - 1;
        arrayOfInt[i3] = arrayOfInt[m];
        i3 = m - 1;
        arrayOfInt[m] = arrayOfInt[paramInt4];
        if (i3 < paramInt3)
        {
          while (paramInt2 < paramInt5)
          {
            paramInt1 = paramInt4 - 1;
            arrayOfInt[paramInt4] = paramArrayOfInt[paramInt5];
            paramArrayOfInt[paramInt5] = arrayOfInt[paramInt1];
            paramInt4 = paramInt1;
            paramInt5--;
          }
          arrayOfInt[paramInt4] = paramArrayOfInt[paramInt5];
          paramArrayOfInt[paramInt5] = i2;
          return;
        }
        if (arrayOfInt[i3] < 0)
        {
          k = i1 | 0x2;
          i = arrayOfInt[i3] ^ 0xFFFFFFFF;
        }
        else
        {
          i = arrayOfInt[i3];
          k = i1;
        }
        i1 = paramInt1 + i;
        i = i3;
      }
      else
      {
        m = paramInt4;
        i1 = paramInt5;
        j = k;
        if ((k & 0x1) != 0) {
          for (j = paramInt4;; j = paramInt4)
          {
            paramInt4 = j - 1;
            arrayOfInt[j] = paramArrayOfInt[paramInt5];
            j = paramInt5 - 1;
            paramArrayOfInt[paramInt5] = arrayOfInt[paramInt4];
            if (paramArrayOfInt[j] >= 0)
            {
              paramInt5 = k ^ 0x1;
              m = paramInt4;
              i1 = j;
              j = paramInt5;
              break;
            }
            paramInt5 = j;
          }
        }
        i3 = m - 1;
        paramArrayOfInt[i1] ^= 0xFFFFFFFF;
        if (i1 <= paramInt2)
        {
          paramArrayOfInt[i1] = i2;
          return;
        }
        k = i1 - 1;
        paramArrayOfInt[i1] = arrayOfInt[i3];
        paramInt5 = i;
        i1 = i3;
        paramInt4 = j;
        if ((j & 0x2) != 0) {
          for (;;)
          {
            paramInt4 = i3 - 1;
            arrayOfInt[i3] = arrayOfInt[i];
            paramInt5 = i - 1;
            arrayOfInt[i] = arrayOfInt[paramInt4];
            if (arrayOfInt[paramInt5] >= 0)
            {
              i = j ^ 0x2;
              i1 = paramInt4;
              paramInt4 = i;
              break;
            }
            i = paramInt5;
            i3 = paramInt4;
          }
        }
        i = i1 - 1;
        arrayOfInt[i1] = arrayOfInt[paramInt5];
        m = paramInt5 - 1;
        arrayOfInt[paramInt5] = arrayOfInt[i];
        if (m < paramInt3)
        {
          while (paramInt2 < k)
          {
            paramInt1 = i - 1;
            arrayOfInt[i] = paramArrayOfInt[k];
            paramArrayOfInt[k] = arrayOfInt[paramInt1];
            i = paramInt1;
            k--;
          }
          arrayOfInt[i] = paramArrayOfInt[k];
          paramArrayOfInt[k] = i2;
          return;
        }
        if (paramArrayOfInt[k] < 0)
        {
          paramInt5 = paramInt4 | 0x1;
          paramInt4 = paramInt1 + (paramArrayOfInt[k] ^ 0xFFFFFFFF);
        }
        else
        {
          j = paramInt1 + paramArrayOfInt[k];
          paramInt5 = paramInt4;
          paramInt4 = j;
        }
        if (arrayOfInt[m] < 0)
        {
          paramInt5 |= 0x2;
          j = arrayOfInt[m] ^ 0xFFFFFFFF;
        }
        else
        {
          j = arrayOfInt[m];
        }
        i3 = paramInt1 + j;
        i1 = paramInt5;
        paramInt5 = m;
        j = paramInt4;
        paramInt4 = i;
        i = paramInt5;
        paramInt5 = k;
        k = i1;
        i1 = i3;
      }
    }
  }
  
  private void ssMergeCheckEqual(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.SA;
    if ((arrayOfInt[paramInt3] >= 0) && (ssCompare(getIDX(arrayOfInt[(paramInt3 - 1)]) + paramInt1, paramInt1 + arrayOfInt[paramInt3], paramInt2) == 0)) {
      arrayOfInt[paramInt3] ^= 0xFFFFFFFF;
    }
  }
  
  private void ssMergeForward(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int[] arrayOfInt = this.SA;
    int i = paramInt4 - paramInt3;
    int j = paramInt2 + i - 1;
    ssBlockSwap(paramArrayOfInt, paramInt2, arrayOfInt, paramInt3, i);
    int k = arrayOfInt[paramInt3];
    i = ssCompare(paramArrayOfInt[paramInt2] + paramInt1, arrayOfInt[paramInt4] + paramInt1, paramInt6);
    if (i < 0) {
      for (i = paramInt3;; i = paramInt3)
      {
        paramInt3 = i + 1;
        arrayOfInt[i] = paramArrayOfInt[paramInt2];
        if (j <= paramInt2)
        {
          paramArrayOfInt[paramInt2] = k;
          return;
        }
        i = paramInt2 + 1;
        paramArrayOfInt[paramInt2] = arrayOfInt[paramInt3];
        if (paramArrayOfInt[i] >= 0)
        {
          paramInt2 = i;
          break;
        }
        paramInt2 = i;
      }
    }
    if (i > 0) {
      for (i = paramInt3;; i = paramInt3)
      {
        paramInt3 = i + 1;
        arrayOfInt[i] = arrayOfInt[paramInt4];
        i = paramInt4 + 1;
        arrayOfInt[paramInt4] = arrayOfInt[paramInt3];
        if (paramInt5 <= i)
        {
          while (paramInt2 < j)
          {
            paramInt1 = paramInt3 + 1;
            arrayOfInt[paramInt3] = paramArrayOfInt[paramInt2];
            paramArrayOfInt[paramInt2] = arrayOfInt[paramInt1];
            paramInt3 = paramInt1;
            paramInt2++;
          }
          arrayOfInt[paramInt3] = paramArrayOfInt[paramInt2];
          paramArrayOfInt[paramInt2] = k;
          return;
        }
        if (arrayOfInt[i] >= 0)
        {
          paramInt4 = i;
          break;
        }
        paramInt4 = i;
      }
    }
    arrayOfInt[paramInt4] ^= 0xFFFFFFFF;
    int m = paramInt3;
    i = paramInt2;
    for (;;)
    {
      paramInt3 = m + 1;
      arrayOfInt[m] = paramArrayOfInt[i];
      if (j <= i)
      {
        paramArrayOfInt[i] = k;
        return;
      }
      paramInt2 = i + 1;
      paramArrayOfInt[i] = arrayOfInt[paramInt3];
      if (paramArrayOfInt[paramInt2] >= 0) {
        for (i = paramInt3;; i = paramInt3)
        {
          paramInt3 = i + 1;
          arrayOfInt[i] = arrayOfInt[paramInt4];
          i = paramInt4 + 1;
          arrayOfInt[paramInt4] = arrayOfInt[paramInt3];
          if (paramInt5 <= i)
          {
            while (paramInt2 < j)
            {
              paramInt1 = paramInt3 + 1;
              arrayOfInt[paramInt3] = paramArrayOfInt[paramInt2];
              paramArrayOfInt[paramInt2] = arrayOfInt[paramInt1];
              paramInt2++;
              paramInt3 = paramInt1;
            }
            arrayOfInt[paramInt3] = paramArrayOfInt[paramInt2];
            paramArrayOfInt[paramInt2] = k;
            return;
          }
          if (arrayOfInt[i] >= 0)
          {
            paramInt4 = i;
            break;
          }
          paramInt4 = i;
        }
      }
      i = paramInt2;
      m = paramInt3;
    }
  }
  
  private void ssMultiKeyIntroSort(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bzip2DivSufSort localBzip2DivSufSort = this;
    int[] arrayOfInt = localBzip2DivSufSort.SA;
    byte[] arrayOfByte = localBzip2DivSufSort.T;
    StackEntry[] arrayOfStackEntry = new StackEntry[64];
    int i = ssLog(paramInt3 - paramInt2);
    int j = paramInt3;
    int k = paramInt4;
    paramInt4 = 0;
    paramInt3 = 0;
    label405:
    label423:
    label836:
    label861:
    label1711:
    label1850:
    for (;;)
    {
      int m = j - paramInt2;
      if (m <= 8)
      {
        if (1 < m) {
          localBzip2DivSufSort.ssInsertionSort(paramInt1, paramInt2, j, k);
        }
        if (paramInt4 == 0) {
          return;
        }
        paramInt4--;
        StackEntry localStackEntry = arrayOfStackEntry[paramInt4];
        paramInt2 = localStackEntry.a;
        j = localStackEntry.b;
        k = localStackEntry.c;
        i = localStackEntry.d;
      }
      else
      {
        int i1 = i - 1;
        if (i == 0) {
          localBzip2DivSufSort.ssHeapSort(k, paramInt1, paramInt2, m);
        }
        int i2;
        if (i1 < 0)
        {
          i2 = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt2] + paramInt1)] + k)] & 0xFF;
          m = paramInt2;
          paramInt2++;
          while (paramInt2 < j)
          {
            paramInt3 = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt2] + paramInt1)] + k)] & 0xFF;
            i1 = m;
            i = i2;
            if (paramInt3 != i2)
            {
              if (1 < paramInt2 - m) {
                break;
              }
              i1 = paramInt2;
              i = paramInt3;
            }
            paramInt2++;
            m = i1;
            i2 = i;
          }
          i = m;
          if ((arrayOfByte[(arrayOfInt[(arrayOfInt[m] + paramInt1)] + k - 1)] & 0xFF) < i2) {
            i = localBzip2DivSufSort.ssSubstringPartition(paramInt1, m, paramInt2, k);
          }
          i2 = paramInt2 - i;
          m = j - paramInt2;
          if (i2 <= m)
          {
            m = paramInt4;
            if (1 < i2)
            {
              arrayOfStackEntry[paramInt4] = new StackEntry(paramInt2, j, k, -1);
              k++;
              j = ssLog(i2);
              m = paramInt4 + 1;
              paramInt4 = j;
              break label423;
            }
          }
          else
          {
            if (1 >= m) {
              break label405;
            }
            arrayOfStackEntry[paramInt4] = new StackEntry(i, paramInt2, k + 1, ssLog(i2));
            m = paramInt4 + 1;
          }
          i = -1;
          paramInt4 = m;
          continue;
          k++;
          j = ssLog(i2);
          m = paramInt4;
          paramInt4 = j;
          j = paramInt2;
          paramInt2 = i;
          i = paramInt4;
          paramInt4 = m;
        }
        else
        {
          i = localBzip2DivSufSort.ssPivot(k, paramInt1, paramInt2, j);
          int i3 = arrayOfByte[(arrayOfInt[(arrayOfInt[i] + paramInt1)] + k)] & 0xFF;
          swapElements(arrayOfInt, paramInt2, arrayOfInt, i);
          m = paramInt2 + 1;
          i = paramInt3;
          paramInt3 = m;
          while (paramInt3 < j)
          {
            m = arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt3] + paramInt1)] + k)] & 0xFF;
            i = m;
            if (m != i3) {
              break;
            }
            paramInt3++;
            i = m;
          }
          int i4;
          if ((paramInt3 < j) && (i < i3))
          {
            i2 = paramInt3;
            m = paramInt3;
            for (;;)
            {
              i4 = m + 1;
              m = i4;
              i5 = i2;
              if (i4 >= j) {
                break;
              }
              paramInt3 = arrayOfByte[(arrayOfInt[(arrayOfInt[i4] + paramInt1)] + k)] & 0xFF;
              m = i4;
              i5 = i2;
              i = paramInt3;
              if (paramInt3 > i3) {
                break;
              }
              m = i4;
              i = paramInt3;
              if (paramInt3 == i3)
              {
                swapElements(arrayOfInt, i4, arrayOfInt, i2);
                i2++;
                m = i4;
                i = paramInt3;
              }
            }
          }
          int i5 = paramInt3;
          m = paramInt3;
          i2 = j - 1;
          paramInt3 = i;
          i = i2;
          while (m < i)
          {
            i2 = arrayOfByte[(arrayOfInt[(arrayOfInt[i] + paramInt1)] + k)] & 0xFF;
            paramInt3 = i2;
            if (i2 != i3) {
              break;
            }
            i--;
            paramInt3 = i2;
          }
          int i6;
          if ((m < i) && (paramInt3 > i3))
          {
            i2 = paramInt3;
            paramInt3 = i;
            i4 = i;
            for (;;)
            {
              i4--;
              if (m >= i4) {
                break label836;
              }
              i2 = arrayOfByte[(k + arrayOfInt[(paramInt1 + arrayOfInt[i4])])] & 0xFF;
              if (i2 < i3) {
                break;
              }
              i = paramInt3;
              if (i2 == i3)
              {
                swapElements(arrayOfInt, i4, arrayOfInt, paramInt3);
                i = paramInt3 - 1;
              }
              paramInt3 = i;
            }
            i6 = i2;
            i = paramInt3;
            i2 = i4;
            paramInt3 = i6;
            break label861;
            i = paramInt3;
            paramInt3 = i2;
            i2 = i4;
          }
          else
          {
            i4 = i;
            i2 = i;
            i = i4;
          }
          int i8;
          if (m < i2)
          {
            swapElements(arrayOfInt, m, arrayOfInt, i2);
            i6 = i5;
            i5 = m;
            for (;;)
            {
              i4 = i5 + 1;
              if (i4 >= i2) {
                break;
              }
              m = arrayOfByte[(arrayOfInt[(arrayOfInt[i4] + paramInt1)] + k)] & 0xFF;
              paramInt3 = m;
              if (m > i3) {
                break;
              }
              i5 = i4;
              paramInt3 = m;
              if (m == i3)
              {
                swapElements(arrayOfInt, i4, arrayOfInt, i6);
                i6++;
                i5 = i4;
                paramInt3 = m;
              }
            }
            int i7 = i;
            for (;;)
            {
              i8 = i2 - 1;
              i = i7;
              m = i4;
              i5 = i6;
              i2 = i8;
              if (i4 >= i8) {
                break;
              }
              int i9 = arrayOfByte[(arrayOfInt[(arrayOfInt[i8] + paramInt1)] + k)] & 0xFF;
              i = i7;
              m = i4;
              i5 = i6;
              i2 = i8;
              paramInt3 = i9;
              if (i9 < i3) {
                break;
              }
              i2 = i8;
              paramInt3 = i9;
              if (i9 == i3)
              {
                swapElements(arrayOfInt, i8, arrayOfInt, i7);
                i7--;
                i2 = i8;
                paramInt3 = i9;
              }
            }
          }
          if (i5 <= i)
          {
            i4 = i5 - paramInt2;
            i6 = m - i5;
            i2 = i4;
            if (i4 > i6) {
              i2 = i6;
            }
            i5 = paramInt2;
            i8 = m - i2;
            i4 = i2;
            i2 = i5;
            for (i5 = i8; i4 > 0; i5++)
            {
              swapElements(arrayOfInt, i2, arrayOfInt, i5);
              i4--;
              i2++;
            }
            i5 = i - (m - 1);
            i = j - i - 1;
            if (i5 <= i) {
              i = i5;
            }
            i4 = j - i;
            i2 = m;
            for (m = i4; i > 0; m++)
            {
              swapElements(arrayOfInt, i2, arrayOfInt, m);
              i--;
              i2++;
            }
            i2 = paramInt2 + i6;
            m = j - i5;
            if (i3 <= (arrayOfByte[(arrayOfInt[(arrayOfInt[i2] + paramInt1)] + k - 1)] & 0xFF)) {
              i = i2;
            } else {
              i = localBzip2DivSufSort.ssSubstringPartition(paramInt1, i2, m, k);
            }
            i6 = i2 - paramInt2;
            i8 = j - m;
            if (i6 <= i8)
            {
              i4 = m - i;
              if (i8 <= i4)
              {
                i5 = paramInt4 + 1;
                arrayOfStackEntry[paramInt4] = new StackEntry(i, m, k + 1, ssLog(i4));
                paramInt4 = i5 + 1;
                arrayOfStackEntry[i5] = new StackEntry(m, j, k, i1);
              }
              for (;;)
              {
                j = i2;
                i = i1;
                break label1850;
                i5 = i1;
                if (i6 > i4) {
                  break;
                }
                i6 = paramInt4 + 1;
                arrayOfStackEntry[paramInt4] = new StackEntry(m, j, k, i5);
                paramInt4 = i6 + 1;
                arrayOfStackEntry[i6] = new StackEntry(i, m, k + 1, ssLog(i4));
              }
              i6 = paramInt4 + 1;
              arrayOfStackEntry[paramInt4] = new StackEntry(m, j, k, i5);
              i1 = i6 + 1;
              arrayOfStackEntry[i6] = new StackEntry(paramInt2, i2, k, i5);
              k++;
              paramInt4 = ssLog(i4);
              j = m;
              paramInt2 = i;
              i = paramInt4;
              paramInt4 = i1;
            }
            else
            {
              i5 = m - i;
              if (i6 <= i5)
              {
                i4 = paramInt4 + 1;
                arrayOfStackEntry[paramInt4] = new StackEntry(i, m, k + 1, ssLog(i5));
                paramInt4 = i4 + 1;
                arrayOfStackEntry[i4] = new StackEntry(paramInt2, i2, k, i1);
              }
              for (;;)
              {
                localBzip2DivSufSort = this;
                paramInt2 = m;
                i = i1;
                break;
                if (i8 > i5) {
                  break label1711;
                }
                i4 = paramInt4 + 1;
                arrayOfStackEntry[paramInt4] = new StackEntry(paramInt2, i2, k, i1);
                paramInt4 = i4 + 1;
                arrayOfStackEntry[i4] = new StackEntry(i, m, k + 1, ssLog(i5));
              }
              i4 = paramInt4 + 1;
              arrayOfStackEntry[paramInt4] = new StackEntry(paramInt2, i2, k, i1);
              paramInt4 = i4 + 1;
              arrayOfStackEntry[i4] = new StackEntry(m, j, k, i1);
              k++;
              i2 = ssLog(i5);
              j = m;
              paramInt2 = i;
              i = i2;
              localBzip2DivSufSort = this;
            }
          }
          else
          {
            if ((arrayOfByte[(arrayOfInt[(arrayOfInt[paramInt2] + paramInt1)] + k - 1)] & 0xFF) < i3)
            {
              paramInt2 = ssSubstringPartition(paramInt1, paramInt2, j, k);
              i = ssLog(j - paramInt2);
            }
            else
            {
              i = i1 + 1;
            }
            localBzip2DivSufSort = this;
            k++;
          }
        }
      }
    }
  }
  
  private int ssPivot(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4 - paramInt3;
    int j = paramInt3 + i / 2;
    if (i <= 512)
    {
      if (i <= 32) {
        return ssMedian3(paramInt1, paramInt2, paramInt3, j, paramInt4 - 1);
      }
      i >>= 2;
      paramInt4--;
      return ssMedian5(paramInt1, paramInt2, paramInt3, paramInt3 + i, j, paramInt4 - i, paramInt4);
    }
    int k = i >> 3;
    i = k << 1;
    paramInt3 = ssMedian3(paramInt1, paramInt2, paramInt3, paramInt3 + k, paramInt3 + i);
    j = ssMedian3(paramInt1, paramInt2, j - k, j, j + k);
    paramInt4--;
    return ssMedian3(paramInt1, paramInt2, paramInt3, j, ssMedian3(paramInt1, paramInt2, paramInt4 - i, paramInt4 - k, paramInt4));
  }
  
  private int ssSubstringPartition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = this.SA;
    int i = paramInt2 - 1;
    for (;;)
    {
      int j = i + 1;
      i = paramInt3;
      if (j < paramInt3)
      {
        i = paramInt3;
        if (arrayOfInt[(arrayOfInt[j] + paramInt1)] + paramInt4 >= arrayOfInt[(arrayOfInt[j] + paramInt1 + 1)] + 1)
        {
          arrayOfInt[j] ^= 0xFFFFFFFF;
          i = j;
          continue;
        }
      }
      for (;;)
      {
        paramInt3 = i - 1;
        if ((j >= paramInt3) || (arrayOfInt[(arrayOfInt[paramInt3] + paramInt1)] + paramInt4 >= arrayOfInt[(arrayOfInt[paramInt3] + paramInt1 + 1)] + 1)) {
          break;
        }
        i = paramInt3;
      }
      if (paramInt3 <= j)
      {
        if (paramInt2 < j) {
          arrayOfInt[paramInt2] ^= 0xFFFFFFFF;
        }
        return j;
      }
      i = arrayOfInt[paramInt3];
      arrayOfInt[paramInt3] = arrayOfInt[j];
      arrayOfInt[j] = (i ^ 0xFFFFFFFF);
      i = j;
    }
  }
  
  private void subStringSort(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    int[] arrayOfInt1 = this.SA;
    if (paramBoolean) {
      paramInt2++;
    }
    int i = paramInt2;
    int i1;
    for (int j = 0;; j++)
    {
      int k = i + 1024;
      if (k >= paramInt3) {
        break;
      }
      ssMultiKeyIntroSort(paramInt1, i, k, paramInt6);
      m = paramInt3 - k;
      int[] arrayOfInt2;
      if (m <= paramInt5)
      {
        arrayOfInt2 = paramArrayOfInt;
        i1 = paramInt4;
        m = paramInt5;
      }
      else
      {
        i1 = k;
        arrayOfInt2 = arrayOfInt1;
      }
      int i2 = i;
      int i3 = j;
      int i4 = 1024;
      i = k;
      for (k = i2; (i3 & 0x1) != 0; k = i2)
      {
        i2 = k - i4;
        ssMerge(paramInt1, i2, k, k + i4, arrayOfInt2, i1, m, paramInt6);
        i4 <<= 1;
        i3 >>>= 1;
      }
    }
    ssMultiKeyIntroSort(paramInt1, i, paramInt3, paramInt6);
    int m = i;
    i = 1024;
    while (j != 0)
    {
      i1 = m;
      if ((j & 0x1) != 0)
      {
        i1 = m - i;
        ssMerge(paramInt1, i1, m, paramInt3, paramArrayOfInt, paramInt4, paramInt5, paramInt6);
      }
      i <<= 1;
      j >>= 1;
      m = i1;
    }
    if (paramBoolean)
    {
      j = arrayOfInt1[(paramInt2 - 1)];
      paramInt5 = 1;
      paramInt4 = paramInt2;
      paramInt2 = paramInt5;
      for (;;)
      {
        paramInt5 = paramInt2;
        if (paramInt4 >= paramInt3) {
          break;
        }
        if (arrayOfInt1[paramInt4] >= 0)
        {
          paramInt2 = ssCompareLast(paramInt1, paramInt1 + j, paramInt1 + arrayOfInt1[paramInt4], paramInt6, paramInt7);
          paramInt5 = paramInt2;
          if (paramInt2 <= 0) {
            break;
          }
        }
        arrayOfInt1[(paramInt4 - 1)] = arrayOfInt1[paramInt4];
        paramInt4++;
      }
      if (paramInt5 == 0) {
        arrayOfInt1[paramInt4] ^= 0xFFFFFFFF;
      }
      arrayOfInt1[(paramInt4 - 1)] = j;
    }
  }
  
  private static void swapElements(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    int i = paramArrayOfInt1[paramInt1];
    paramArrayOfInt1[paramInt1] = paramArrayOfInt2[paramInt2];
    paramArrayOfInt2[paramInt2] = i;
  }
  
  private void trCopy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int[] arrayOfInt = this.SA;
    int i = paramInt5 - 1;
    paramInt4--;
    int j;
    int k;
    while (paramInt3 <= paramInt4)
    {
      j = arrayOfInt[paramInt3] - paramInt7;
      k = j;
      if (j < 0) {
        k = j + (paramInt2 - paramInt1);
      }
      int m = paramInt1 + k;
      j = paramInt4;
      if (arrayOfInt[m] == i)
      {
        j = paramInt4 + 1;
        arrayOfInt[j] = k;
        arrayOfInt[m] = j;
      }
      paramInt3++;
      paramInt4 = j;
    }
    paramInt3 = paramInt6 - 1;
    while (paramInt4 + 1 < paramInt5)
    {
      k = arrayOfInt[paramInt3] - paramInt7;
      paramInt6 = k;
      if (k < 0) {
        paramInt6 = k + (paramInt2 - paramInt1);
      }
      j = paramInt1 + paramInt6;
      k = paramInt5;
      if (arrayOfInt[j] == i)
      {
        k = paramInt5 - 1;
        arrayOfInt[k] = paramInt6;
        arrayOfInt[j] = k;
      }
      paramInt3--;
      paramInt5 = k;
    }
  }
  
  private void trFixdown(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int[] arrayOfInt = this.SA;
    int i = arrayOfInt[(paramInt4 + paramInt5)];
    int j = trGetC(paramInt1, paramInt2, paramInt3, i);
    for (int k = paramInt5;; k = paramInt5)
    {
      paramInt5 = k * 2 + 1;
      if (paramInt5 >= paramInt6) {
        break;
      }
      int m = paramInt5 + 1;
      int i1 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[(paramInt4 + paramInt5)]);
      int i2 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[(paramInt4 + m)]);
      int i3 = i1;
      if (i1 < i2)
      {
        paramInt5 = m;
        i3 = i2;
      }
      if (i3 <= j) {
        break;
      }
      arrayOfInt[(k + paramInt4)] = arrayOfInt[(paramInt4 + paramInt5)];
    }
    arrayOfInt[(paramInt4 + k)] = i;
  }
  
  private int trGetC(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 + paramInt4;
    if (i < paramInt3) {
      paramInt1 = this.SA[i];
    } else {
      paramInt1 = this.SA[(paramInt1 + (paramInt2 - paramInt1 + paramInt4) % (paramInt3 - paramInt1))];
    }
    return paramInt1;
  }
  
  private void trHeapSort(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.SA;
    int i = paramInt5 % 2;
    if (i == 0)
    {
      paramInt5--;
      j = paramInt5 / 2 + paramInt4;
      int k = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[j]);
      int m = paramInt4 + paramInt5;
      if (k < trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[m])) {
        swapElements(arrayOfInt, m, arrayOfInt, j);
      }
    }
    for (int j = paramInt5 / 2 - 1; j >= 0; j--) {
      trFixdown(paramInt1, paramInt2, paramInt3, paramInt4, j, paramInt5);
    }
    if (i == 0)
    {
      swapElements(arrayOfInt, paramInt4, arrayOfInt, paramInt4 + paramInt5);
      trFixdown(paramInt1, paramInt2, paramInt3, paramInt4, 0, paramInt5);
    }
    paramInt5--;
    while (paramInt5 > 0)
    {
      i = arrayOfInt[paramInt4];
      j = paramInt4 + paramInt5;
      arrayOfInt[paramInt4] = arrayOfInt[j];
      trFixdown(paramInt1, paramInt2, paramInt3, paramInt4, 0, paramInt5);
      arrayOfInt[j] = i;
      paramInt5--;
    }
  }
  
  private void trInsertionSort(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.SA;
    for (int i = paramInt4 + 1; i < paramInt5; i++)
    {
      int j = arrayOfInt[i];
      int k = i - 1;
      int m;
      int i1;
      do
      {
        m = trGetC(paramInt1, paramInt2, paramInt3, j) - trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[k]);
        i1 = k;
        if (m >= 0) {
          break;
        }
        do
        {
          arrayOfInt[(k + 1)] = arrayOfInt[k];
          i1 = k - 1;
          if (paramInt4 > i1) {
            break;
          }
          k = i1;
        } while (arrayOfInt[i1] < 0);
        k = i1;
      } while (i1 >= paramInt4);
      if (m == 0) {
        arrayOfInt[i1] ^= 0xFFFFFFFF;
      }
      arrayOfInt[(i1 + 1)] = j;
    }
  }
  
  private void trIntroSort(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, TRBudget paramTRBudget, int paramInt6)
  {
    int i = paramInt3;
    Object localObject1 = paramTRBudget;
    int j = paramInt6;
    int[] arrayOfInt = this.SA;
    StackEntry[] arrayOfStackEntry = new StackEntry[64];
    int k = trLog(paramInt5 - paramInt4);
    int m = paramInt2;
    paramInt2 = paramInt4;
    int i1 = 0;
    int i2 = 0;
    paramInt4 = m;
    int i3 = paramInt5;
    paramInt5 = i1;
    m = k;
    int i4;
    int i5;
    int i6;
    for (;;)
    {
      i4 = paramInt5;
      if (m >= 0) {
        break label1081;
      }
      if (m == -1)
      {
        if (!((TRBudget)localObject1).update(j, i3 - paramInt2)) {
          break label3203;
        }
        i5 = paramInt4 - 1;
        m = paramInt4;
        localObject2 = trPartition(paramInt1, i5, paramInt3, paramInt2, i3, i3 - 1);
        k = ((PartitionResult)localObject2).first;
        paramInt5 = ((PartitionResult)localObject2).last;
        if ((paramInt2 >= k) && (paramInt5 >= i3))
        {
          while (paramInt2 < i3)
          {
            arrayOfInt[(arrayOfInt[paramInt2] + paramInt1)] = paramInt2;
            paramInt2++;
          }
          if (i4 == 0) {
            return;
          }
          paramInt5 = i4 - 1;
          localObject2 = arrayOfStackEntry[paramInt5];
          paramInt4 = ((StackEntry)localObject2).a;
          paramInt2 = ((StackEntry)localObject2).b;
          i3 = ((StackEntry)localObject2).c;
          m = ((StackEntry)localObject2).d;
          break label1136;
        }
        if (k < i3) {
          for (i1 = paramInt2; i1 < k; i1++) {
            arrayOfInt[(arrayOfInt[i1] + paramInt1)] = (k - 1);
          }
        }
        if (paramInt5 < i3) {
          for (i1 = k; i1 < paramInt5; i1++) {
            arrayOfInt[(arrayOfInt[i1] + paramInt1)] = (paramInt5 - 1);
          }
        }
        i6 = i4 + 1;
        arrayOfStackEntry[i4] = new StackEntry(0, k, paramInt5, 0);
        i1 = i6 + 1;
        arrayOfStackEntry[i6] = new StackEntry(i5, paramInt2, i3, -2);
        i5 = k - paramInt2;
        i6 = i3 - paramInt5;
        if (i5 <= i6) {
          if (1 < i5)
          {
            arrayOfStackEntry[i1] = new StackEntry(m, paramInt5, i3, trLog(i6));
            m = trLog(i5);
          }
        }
        for (paramInt5 = i1 + 1;; paramInt5 = i1)
        {
          i3 = k;
          break label1008;
          if (1 < i6)
          {
            m = trLog(i6);
            paramInt2 = paramInt5;
            paramInt5 = i1;
            break label1008;
          }
          if (i1 == 0) {
            return;
          }
          paramInt2 = i1 - 1;
          localObject2 = arrayOfStackEntry[paramInt2];
          paramInt5 = ((StackEntry)localObject2).a;
          paramInt4 = ((StackEntry)localObject2).b;
          i3 = ((StackEntry)localObject2).c;
          m = ((StackEntry)localObject2).d;
          break label610;
          if (1 < i6)
          {
            arrayOfStackEntry[i1] = new StackEntry(m, paramInt2, k, trLog(i5));
            i5 = trLog(i6);
            k = i1 + 1;
            paramInt4 = m;
            paramInt2 = paramInt5;
            m = i5;
            paramInt5 = k;
            break label1136;
          }
          if (1 >= i5) {
            break;
          }
          m = trLog(i5);
        }
        if (i1 == 0) {
          return;
        }
        paramInt2 = i1 - 1;
        localObject2 = arrayOfStackEntry[paramInt2];
        paramInt5 = ((StackEntry)localObject2).a;
        paramInt4 = ((StackEntry)localObject2).b;
        i3 = ((StackEntry)localObject2).c;
        m = ((StackEntry)localObject2).d;
        label610:
        k = paramInt5;
        paramInt5 = paramInt2;
        paramInt2 = paramInt4;
        paramInt4 = k;
        break label1136;
      }
      paramInt5 = paramInt2;
      i1 = paramInt4;
      if (m == -2)
      {
        paramInt2 = i4 - 1;
        trCopy(paramInt1, paramInt3, paramInt5, arrayOfStackEntry[paramInt2].b, arrayOfStackEntry[paramInt2].c, i3, i1 - paramInt1);
        if (paramInt2 == 0) {
          return;
        }
        paramInt5 = paramInt2 - 1;
        localObject2 = arrayOfStackEntry[paramInt5];
        paramInt4 = ((StackEntry)localObject2).a;
        paramInt2 = ((StackEntry)localObject2).b;
        i3 = ((StackEntry)localObject2).c;
        m = ((StackEntry)localObject2).d;
        break label1136;
      }
      paramInt2 = paramInt5;
      if (arrayOfInt[paramInt5] >= 0)
      {
        paramInt2 = paramInt5;
        do
        {
          arrayOfInt[(arrayOfInt[paramInt2] + paramInt1)] = paramInt2;
          paramInt5 = paramInt2 + 1;
          paramInt2 = paramInt5;
          if (paramInt5 >= i3) {
            break;
          }
          paramInt2 = paramInt5;
        } while (arrayOfInt[paramInt5] >= 0);
        paramInt2 = paramInt5;
      }
      if (paramInt2 >= i3) {
        break;
      }
      paramInt5 = paramInt2;
      do
      {
        arrayOfInt[paramInt5] ^= 0xFFFFFFFF;
        m = paramInt5 + 1;
        paramInt5 = m;
      } while (arrayOfInt[m] < 0);
      if (arrayOfInt[(arrayOfInt[m] + paramInt1)] != arrayOfInt[(arrayOfInt[m] + i1)]) {
        paramInt5 = trLog(m - paramInt2 + 1);
      } else {
        paramInt5 = -1;
      }
      k = m + 1;
      if (k < i3) {
        for (m = paramInt2; m < k; m++) {
          arrayOfInt[(arrayOfInt[m] + paramInt1)] = (k - 1);
        }
      }
      m = i3 - k;
      if (k - paramInt2 <= m)
      {
        i5 = i4 + 1;
        arrayOfStackEntry[i4] = new StackEntry(i1, k, i3, -3);
        paramInt4 = i1 + 1;
        m = paramInt5;
        paramInt5 = i5;
        i3 = k;
      }
      else
      {
        if (1 < m)
        {
          m = i4 + 1;
          arrayOfStackEntry[i4] = new StackEntry(i1 + 1, paramInt2, k, paramInt5);
          i1 = -3;
          paramInt2 = k;
          paramInt5 = m;
          m = i1;
          label1008:
          break label1136;
        }
        paramInt4 = i1 + 1;
        m = paramInt5;
        paramInt5 = i4;
        i3 = k;
      }
    }
    if (i4 == 0) {
      return;
    }
    paramInt5 = i4 - 1;
    Object localObject2 = arrayOfStackEntry[paramInt5];
    paramInt4 = ((StackEntry)localObject2).a;
    paramInt2 = ((StackEntry)localObject2).b;
    i3 = ((StackEntry)localObject2).c;
    m = ((StackEntry)localObject2).d;
    break label1136;
    label1081:
    paramInt5 = i4;
    k = paramInt4;
    int i7 = i3 - paramInt2;
    if (i7 <= 8)
    {
      if (!((TRBudget)localObject1).update(j, i7)) {}
    }
    else
    {
      label1136:
      do
      {
        trInsertionSort(paramInt1, k, paramInt3, paramInt2, i3);
        m = -3;
        paramInt4 = k;
        break;
        i6 = m - 1;
        if (m != 0) {
          break label1276;
        }
      } while (!((TRBudget)localObject1).update(j, i7));
      trHeapSort(paramInt1, k, paramInt3, paramInt2, i7);
      paramInt4 = i3 - 1;
      while (paramInt2 < paramInt4)
      {
        i2 = trGetC(paramInt1, k, i, arrayOfInt[paramInt4]);
        paramInt4--;
        while ((paramInt2 <= paramInt4) && (trGetC(paramInt1, k, i, arrayOfInt[paramInt4]) == i2))
        {
          arrayOfInt[paramInt4] ^= 0xFFFFFFFF;
          paramInt4--;
        }
      }
      m = k;
      paramInt4 = -3;
    }
    for (;;)
    {
      k = m;
      m = paramInt4;
      paramInt4 = k;
      break;
      label1276:
      localObject1 = this;
      swapElements(arrayOfInt, paramInt2, arrayOfInt, trPivot(paramInt1, k, paramInt3, paramInt2, i3));
      m = arrayOfInt[paramInt2];
      int i8 = k;
      int i9 = ((Bzip2DivSufSort)localObject1).trGetC(paramInt1, i8, i, m);
      m = paramInt2 + 1;
      while (m < i3)
      {
        j = ((Bzip2DivSufSort)localObject1).trGetC(paramInt1, i8, i, arrayOfInt[m]);
        i2 = j;
        if (j != i9) {
          break;
        }
        m++;
        i2 = j;
      }
      if ((m < i3) && (i2 < i9))
      {
        j = m;
        k = m;
        m = j;
        for (;;)
        {
          j = k + 1;
          k = m;
          i1 = j;
          if (j >= i3) {
            break;
          }
          i5 = ((Bzip2DivSufSort)localObject1).trGetC(paramInt1, i8, i, arrayOfInt[j]);
          i2 = i5;
          k = m;
          i1 = j;
          if (i5 > i9) {
            break;
          }
          i2 = i5;
          k = j;
          if (i5 == i9)
          {
            swapElements(arrayOfInt, j, arrayOfInt, m);
            m++;
            i2 = i5;
            k = j;
          }
        }
      }
      k = m;
      i1 = m;
      m = i3 - 1;
      while (i1 < m)
      {
        j = ((Bzip2DivSufSort)localObject1).trGetC(paramInt1, i8, i, arrayOfInt[m]);
        i2 = j;
        if (j != i9) {
          break;
        }
        m--;
        i2 = j;
      }
      int i10;
      int i11;
      int i12;
      int i13;
      int i14;
      if ((i1 < m) && (i2 > i9))
      {
        i10 = m;
        j = m;
        m = i2;
        for (;;)
        {
          i11 = j - 1;
          i12 = k;
          i13 = i11;
          i2 = i1;
          i5 = i;
          j = i10;
          if (i1 >= i11) {
            break;
          }
          i14 = ((Bzip2DivSufSort)localObject1).trGetC(paramInt1, i8, i, arrayOfInt[i11]);
          m = i14;
          i12 = k;
          i13 = i11;
          i2 = i1;
          i5 = i;
          j = i10;
          if (i14 < i9) {
            break;
          }
          m = i14;
          j = i11;
          if (i14 == i9)
          {
            swapElements(arrayOfInt, i11, arrayOfInt, i10);
            i10--;
            m = i14;
            j = i11;
          }
        }
        k = m;
        i1 = i12;
        m = i13;
        i = i2;
        i2 = k;
      }
      else
      {
        j = m;
        i5 = i;
        i = i1;
        i1 = k;
      }
      label1740:
      if (i < m)
      {
        swapElements(arrayOfInt, i, arrayOfInt, m);
        i10 = i;
        i = i1;
        int i15;
        for (;;)
        {
          i10++;
          k = i;
          i1 = m;
          i11 = i5;
          i14 = j;
          i13 = i2;
          if (i10 >= m) {
            break label1895;
          }
          k = ((Bzip2DivSufSort)localObject1).trGetC(paramInt1, i8, i5, arrayOfInt[i10]);
          i13 = k;
          i12 = i;
          i2 = m;
          i15 = i5;
          i1 = j;
          if (k > i9) {
            break;
          }
          i2 = i;
          if (k == i9)
          {
            swapElements(arrayOfInt, i10, arrayOfInt, i);
            i2 = i + 1;
          }
          i = i2;
          i2 = k;
        }
        for (;;)
        {
          i14 = i1;
          i11 = i15;
          i1 = i2;
          k = i12;
          label1895:
          int i16 = i1 - 1;
          i1 = k;
          m = i16;
          i = i10;
          i5 = i11;
          j = i14;
          i2 = i13;
          if (i10 >= i16) {
            break label1740;
          }
          i = ((Bzip2DivSufSort)localObject1).trGetC(paramInt1, i8, i11, arrayOfInt[i16]);
          m = i;
          i12 = k;
          i13 = i16;
          i2 = i10;
          i5 = i11;
          j = i14;
          if (i < i9) {
            break;
          }
          i13 = i;
          i12 = k;
          i2 = i16;
          i15 = i11;
          i1 = i14;
          if (i == i9)
          {
            swapElements(arrayOfInt, i16, arrayOfInt, i14);
            i1 = i14 - 1;
            i13 = i;
            i12 = k;
            i2 = i16;
            i15 = i11;
          }
        }
      }
      if (i1 <= j)
      {
        k = i1 - paramInt2;
        i5 = i - i1;
        m = k;
        if (k > i5) {
          m = i5;
        }
        k = i - m;
        i1 = paramInt2;
        while (m > 0)
        {
          swapElements(arrayOfInt, i1, arrayOfInt, k);
          m--;
          i1++;
          k++;
        }
        k = j - (i - 1);
        m = i3 - j - 1;
        if (k <= m) {
          m = k;
        }
        i1 = i3 - m;
        j = i;
        for (i = i1; m > 0; i++)
        {
          swapElements(arrayOfInt, j, arrayOfInt, i);
          m--;
          j++;
        }
        j = paramInt2 + i5;
        i = i3 - k;
        if (arrayOfInt[(arrayOfInt[j] + paramInt1)] != i9) {
          m = trLog(i - j);
        } else {
          m = -1;
        }
        for (k = paramInt2; k < j; k++) {
          arrayOfInt[(arrayOfInt[k] + paramInt1)] = (j - 1);
        }
        if (i < i3) {
          for (k = j; k < i; k++) {
            arrayOfInt[(arrayOfInt[k] + paramInt1)] = (i - 1);
          }
        }
        i1 = j - paramInt2;
        k = i3 - i;
        if (i1 <= k)
        {
          i5 = i - j;
          if (k <= i5) {
            if (1 < i1)
            {
              k = paramInt5 + 1;
              arrayOfStackEntry[paramInt5] = new StackEntry(i8 + 1, j, i, m);
              arrayOfStackEntry[k] = new StackEntry(i8, i, i3, i6);
            }
          }
          for (paramInt5 = k + 1;; paramInt5 = k + 1)
          {
            label2397:
            k = paramInt6;
            i = paramInt3;
            m = i6;
            localObject1 = paramTRBudget;
            i3 = j;
            j = k;
            break;
            if (1 < k)
            {
              paramInt2 = paramInt5 + 1;
              arrayOfStackEntry[paramInt5] = new StackEntry(i8 + 1, j, i, m);
              paramInt5 = paramInt2;
              break label3188;
            }
            if (1 < i5) {
              break label2882;
            }
            if (paramInt5 == 0) {
              return;
            }
            paramInt5--;
            localObject1 = arrayOfStackEntry[paramInt5];
            paramInt4 = ((StackEntry)localObject1).a;
            paramInt2 = ((StackEntry)localObject1).b;
            i3 = ((StackEntry)localObject1).c;
            m = ((StackEntry)localObject1).d;
            i = paramInt3;
            localObject1 = paramTRBudget;
            j = paramInt6;
            break;
            if (i1 > i5) {
              break label2641;
            }
            if (1 >= i1) {
              break label2598;
            }
            k = paramInt5 + 1;
            arrayOfStackEntry[paramInt5] = new StackEntry(i8, i, i3, i6);
            arrayOfStackEntry[k] = new StackEntry(i8 + 1, j, i, m);
          }
          label2598:
          if (1 < i5)
          {
            paramInt2 = paramInt5 + 1;
            arrayOfStackEntry[paramInt5] = new StackEntry(i8, i, i3, i6);
            paramInt5 = paramInt2;
            break label3053;
          }
          paramInt2 = i;
          break label2813;
          label2641:
          if (1 < i5)
          {
            k = paramInt5 + 1;
            arrayOfStackEntry[paramInt5] = new StackEntry(i8, i, i3, i6);
            paramInt4 = k + 1;
            arrayOfStackEntry[k] = new StackEntry(i8, paramInt2, j, i6);
            paramInt2 = paramInt4;
            break label3121;
          }
          m = paramInt5 + 1;
          arrayOfStackEntry[paramInt5] = new StackEntry(i8, i, i3, i6);
          paramInt5 = m;
          break label2873;
        }
        else
        {
          i5 = i - j;
          if (i1 > i5) {
            break label2923;
          }
          if (1 >= k) {
            break label2835;
          }
          paramInt4 = paramInt5 + 1;
          arrayOfStackEntry[paramInt5] = new StackEntry(i8 + 1, j, i, m);
          arrayOfStackEntry[paramInt4] = new StackEntry(i8, paramInt2, j, i6);
        }
        label2813:
        label2835:
        label2873:
        label2882:
        label2923:
        label3053:
        label3121:
        label3130:
        label3188:
        for (paramInt5 = paramInt4 + 1;; paramInt5 = paramInt4)
        {
          paramInt2 = i;
          for (;;)
          {
            j = paramInt6;
            i = paramInt3;
            paramInt4 = i6;
            localObject1 = paramTRBudget;
            m = i8;
            break;
            if (1 < i1)
            {
              i3 = paramInt5 + 1;
              arrayOfStackEntry[paramInt5] = new StackEntry(i8 + 1, j, i, m);
              paramInt5 = i3;
              break label2397;
            }
            if (1 < i5)
            {
              paramInt4 = i8 + 1;
              break label3130;
            }
            paramInt4 = paramInt5 + 1;
            arrayOfStackEntry[paramInt5] = new StackEntry(i8, paramInt2, i3, i6);
            paramInt5 = paramInt4;
          }
          if (k <= i5)
          {
            if (1 < k)
            {
              paramInt4 = paramInt5 + 1;
              arrayOfStackEntry[paramInt5] = new StackEntry(i8, paramInt2, j, i6);
              arrayOfStackEntry[paramInt4] = new StackEntry(i8 + 1, j, i, m);
              k = paramInt3;
              j = paramInt6;
              paramInt5 = paramInt4 + 1;
              m = i6;
              localObject1 = paramTRBudget;
              paramInt4 = i8;
              paramInt2 = i;
              i = k;
              break;
            }
            if (1 < i5)
            {
              paramInt4 = paramInt5 + 1;
              arrayOfStackEntry[paramInt5] = new StackEntry(i8, paramInt2, j, i6);
              paramInt5 = paramInt4;
              paramInt4 = i8 + 1;
              break label3130;
            }
            break label2397;
          }
          if (1 < i5)
          {
            paramInt4 = paramInt5 + 1;
            arrayOfStackEntry[paramInt5] = new StackEntry(i8, paramInt2, j, i6);
            paramInt2 = paramInt4 + 1;
            arrayOfStackEntry[paramInt4] = new StackEntry(i8, i, i3, i6);
            paramInt4 = i8 + 1;
            paramInt5 = paramInt2;
            k = paramInt6;
            localObject1 = paramTRBudget;
            i1 = paramInt3;
            paramInt2 = j;
            i3 = i;
            i = i1;
            j = k;
            break;
          }
          paramInt4 = paramInt5 + 1;
          arrayOfStackEntry[paramInt5] = new StackEntry(i8, paramInt2, j, i6);
        }
      }
      if (!paramTRBudget.update(paramInt6, i7))
      {
        label3203:
        for (paramInt2 = 0; paramInt2 < i4; paramInt2++) {
          if (arrayOfStackEntry[paramInt2].d == -3) {
            lsUpdateGroup(paramInt1, arrayOfStackEntry[paramInt2].b, arrayOfStackEntry[paramInt2].c);
          }
        }
        return;
      }
      m = i8 + 1;
      i = paramInt3;
      localObject1 = paramTRBudget;
      j = paramInt6;
      paramInt4 = i6 + 1;
    }
  }
  
  private static int trLog(int paramInt)
  {
    if ((0xFFFF0000 & paramInt) != 0)
    {
      if ((0xFF000000 & paramInt) != 0) {
        paramInt = LOG_2_TABLE[(paramInt >> 24 & 0xFF)] + 24;
      } else {
        paramInt = LOG_2_TABLE[(paramInt >> 16 & 0x10F)];
      }
    }
    else if ((0xFF00 & paramInt) != 0) {
      paramInt = LOG_2_TABLE[(paramInt >> 8 & 0xFF)] + 8;
    } else {
      paramInt = LOG_2_TABLE[(paramInt & 0xFF)];
    }
    return paramInt;
  }
  
  private int trMedian3(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int[] arrayOfInt = this.SA;
    int i = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt4]);
    int j = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt5]);
    paramInt3 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt6]);
    if (i > j)
    {
      paramInt1 = i;
    }
    else
    {
      paramInt2 = paramInt5;
      paramInt1 = j;
      paramInt5 = paramInt4;
      paramInt4 = paramInt2;
      j = i;
    }
    if (paramInt1 > paramInt3)
    {
      if (j > paramInt3) {
        return paramInt5;
      }
      return paramInt6;
    }
    return paramInt4;
  }
  
  private int trMedian5(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int[] arrayOfInt = this.SA;
    int i = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt4]);
    int j = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt5]);
    int k = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt6]);
    int m = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt7]);
    paramInt3 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[paramInt8]);
    int i1 = j;
    paramInt2 = k;
    int i2 = paramInt5;
    paramInt1 = paramInt6;
    if (j > k)
    {
      paramInt1 = paramInt5;
      paramInt2 = j;
      i1 = k;
      i2 = paramInt6;
    }
    if (m > paramInt3)
    {
      paramInt5 = paramInt3;
      paramInt3 = m;
    }
    else
    {
      paramInt5 = paramInt8;
      paramInt8 = paramInt7;
      paramInt7 = paramInt5;
      paramInt5 = m;
    }
    if (i1 > paramInt5)
    {
      paramInt5 = paramInt3;
      paramInt8 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = paramInt7;
      paramInt3 = i1;
      paramInt2 = paramInt5;
      paramInt5 = paramInt8;
      paramInt7 = paramInt6;
    }
    else
    {
      paramInt6 = paramInt5;
      i2 = paramInt8;
      paramInt5 = paramInt3;
      paramInt3 = paramInt6;
    }
    m = i;
    i1 = paramInt2;
    paramInt8 = paramInt4;
    paramInt6 = paramInt1;
    if (i > paramInt2)
    {
      i1 = i;
      paramInt6 = paramInt4;
      paramInt8 = paramInt1;
      m = paramInt2;
    }
    if (m > paramInt3)
    {
      paramInt3 = m;
    }
    else
    {
      paramInt5 = i1;
      paramInt7 = paramInt6;
      paramInt8 = i2;
    }
    if (paramInt5 > paramInt3) {
      return paramInt8;
    }
    return paramInt7;
  }
  
  private PartitionResult trPartition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int[] arrayOfInt = this.SA;
    int i = 0;
    int j = paramInt4;
    while (j < paramInt5)
    {
      k = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[j]);
      i = k;
      if (k != paramInt6) {
        break;
      }
      j++;
      i = k;
    }
    int i1;
    if ((j < paramInt5) && (i < paramInt6))
    {
      k = j;
      m = j;
      for (;;)
      {
        i1 = m + 1;
        i2 = i1;
        m = k;
        if (i1 >= paramInt5) {
          break;
        }
        j = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i1]);
        i = j;
        i2 = i1;
        m = k;
        if (j > paramInt6) {
          break;
        }
        i = j;
        m = i1;
        if (j == paramInt6)
        {
          swapElements(arrayOfInt, i1, arrayOfInt, k);
          k++;
          i = j;
          m = i1;
        }
      }
    }
    int m = j;
    int i2 = j;
    for (j = paramInt5 - 1;; j--)
    {
      k = i;
      if (i2 >= j) {
        break;
      }
      i = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[j]);
      k = i;
      if (i != paramInt6) {
        break;
      }
    }
    int i3;
    int i5;
    if ((i2 < j) && (k > paramInt6))
    {
      i1 = j;
      for (;;)
      {
        i3 = j - 1;
        k = i1;
        j = i2;
        i4 = m;
        i = i3;
        if (i2 >= i3) {
          break;
        }
        i5 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i3]);
        k = i1;
        j = i2;
        i4 = m;
        i = i3;
        if (i5 < paramInt6) {
          break;
        }
        j = i3;
        if (i5 == paramInt6)
        {
          swapElements(arrayOfInt, i3, arrayOfInt, i1);
          i1--;
          j = i3;
        }
      }
    }
    int k = j;
    i = j;
    int i4 = m;
    j = i2;
    if (j < i)
    {
      swapElements(arrayOfInt, j, arrayOfInt, i);
      i2 = i4;
      for (;;)
      {
        m = j + 1;
        i3 = k;
        j = i;
        if (m >= i) {
          break;
        }
        i1 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[m]);
        i3 = k;
        j = i;
        if (i1 > paramInt6) {
          break;
        }
        j = m;
        if (i1 == paramInt6)
        {
          swapElements(arrayOfInt, m, arrayOfInt, i2);
          i2++;
          j = m;
        }
      }
      for (;;)
      {
        i1 = j - 1;
        k = i3;
        j = m;
        i4 = i2;
        i = i1;
        if (m >= i1) {
          break;
        }
        i5 = trGetC(paramInt1, paramInt2, paramInt3, arrayOfInt[i1]);
        k = i3;
        j = m;
        i4 = i2;
        i = i1;
        if (i5 < paramInt6) {
          break;
        }
        j = i1;
        if (i5 == paramInt6)
        {
          swapElements(arrayOfInt, i1, arrayOfInt, i3);
          i3--;
          j = i1;
        }
      }
    }
    paramInt2 = paramInt4;
    paramInt1 = paramInt5;
    if (i4 <= k)
    {
      paramInt2 = i4 - paramInt4;
      paramInt6 = j - i4;
      paramInt1 = paramInt2;
      if (paramInt2 > paramInt6) {
        paramInt1 = paramInt6;
      }
      paramInt2 = j - paramInt1;
      paramInt3 = paramInt4;
      while (paramInt1 > 0)
      {
        swapElements(arrayOfInt, paramInt3, arrayOfInt, paramInt2);
        paramInt1--;
        paramInt3++;
        paramInt2++;
      }
      paramInt3 = k - (j - 1);
      paramInt1 = paramInt5 - k - 1;
      if (paramInt3 <= paramInt1) {
        paramInt1 = paramInt3;
      }
      for (paramInt2 = paramInt5 - paramInt1; paramInt1 > 0; paramInt2++)
      {
        swapElements(arrayOfInt, j, arrayOfInt, paramInt2);
        paramInt1--;
        j++;
      }
      paramInt2 = paramInt4 + paramInt6;
      paramInt1 = paramInt5 - paramInt3;
    }
    return new PartitionResult(paramInt2, paramInt1);
  }
  
  private int trPivot(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt5 - paramInt4;
    int j = paramInt4 + i / 2;
    if (i <= 512)
    {
      if (i <= 32) {
        return trMedian3(paramInt1, paramInt2, paramInt3, paramInt4, j, paramInt5 - 1);
      }
      i >>= 2;
      paramInt5--;
      return trMedian5(paramInt1, paramInt2, paramInt3, paramInt4, paramInt4 + i, j, paramInt5 - i, paramInt5);
    }
    int k = i >> 3;
    i = k << 1;
    paramInt4 = trMedian3(paramInt1, paramInt2, paramInt3, paramInt4, paramInt4 + k, paramInt4 + i);
    j = trMedian3(paramInt1, paramInt2, paramInt3, j - k, j, j + k);
    paramInt5--;
    return trMedian3(paramInt1, paramInt2, paramInt3, paramInt4, j, trMedian3(paramInt1, paramInt2, paramInt3, paramInt5 - i, paramInt5 - k, paramInt5));
  }
  
  private void trSort(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.SA;
    if (-paramInt2 < arrayOfInt[0])
    {
      TRBudget localTRBudget = new TRBudget(paramInt2, trLog(paramInt2) * 2 / 3 + 1);
      int i = 0;
      int j;
      do
      {
        j = arrayOfInt[i];
        if (j < 0)
        {
          j = i - j;
        }
        else
        {
          j = arrayOfInt[(paramInt1 + j)] + 1;
          if (1 < j - i)
          {
            trIntroSort(paramInt1, paramInt1 + paramInt3, paramInt1 + paramInt2, i, j, localTRBudget, paramInt2);
            if (localTRBudget.chance == 0)
            {
              if (i > 0) {
                arrayOfInt[0] = (-i);
              }
              lsSort(paramInt1, paramInt2, paramInt3);
              break;
            }
          }
        }
        i = j;
      } while (j < paramInt2);
    }
  }
  
  public int bwt()
  {
    int[] arrayOfInt1 = this.SA;
    byte[] arrayOfByte = this.T;
    int i = this.n;
    int[] arrayOfInt2 = new int['Ā'];
    int[] arrayOfInt3 = new int[65536];
    if (i == 0) {
      return 0;
    }
    if (i == 1)
    {
      arrayOfInt1[0] = arrayOfByte[0];
      return 0;
    }
    if (sortTypeBstar(arrayOfInt2, arrayOfInt3) > 0) {
      return constructBWT(arrayOfInt2, arrayOfInt3);
    }
    return 0;
  }
  
  private static class PartitionResult
  {
    final int first;
    final int last;
    
    PartitionResult(int paramInt1, int paramInt2)
    {
      this.first = paramInt1;
      this.last = paramInt2;
    }
  }
  
  private static class StackEntry
  {
    final int a;
    final int b;
    final int c;
    final int d;
    
    StackEntry(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
  }
  
  private static class TRBudget
  {
    int budget;
    int chance;
    
    TRBudget(int paramInt1, int paramInt2)
    {
      this.budget = paramInt1;
      this.chance = paramInt2;
    }
    
    boolean update(int paramInt1, int paramInt2)
    {
      int i = this.budget - paramInt2;
      this.budget = i;
      if (i <= 0)
      {
        paramInt2 = this.chance - 1;
        this.chance = paramInt2;
        if (paramInt2 == 0) {
          return false;
        }
        this.budget = (i + paramInt1);
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2DivSufSort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */