package e.a.c.d.a;

public class a
  extends g
{
  private int[][] c;
  private int d;
  
  public a(int paramInt, int[][] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt[0].length == paramInt + 31 >> 5)
    {
      this.b = paramInt;
      this.a = paramArrayOfInt.length;
      this.d = paramArrayOfInt[0].length;
      paramInt &= 0x1F;
      if (paramInt == 0) {
        paramInt = -1;
      } else {
        paramInt = (1 << paramInt) - 1;
      }
      while (i < this.a)
      {
        int[] arrayOfInt = paramArrayOfInt[i];
        int j = this.d - 1;
        arrayOfInt[j] &= paramInt;
        i++;
      }
      this.c = paramArrayOfInt;
      return;
    }
    throw new ArithmeticException("Int array does not match given number of columns.");
  }
  
  public a(a parama)
  {
    this.b = parama.a();
    this.a = parama.b();
    this.d = parama.d;
    this.c = new int[parama.c.length][];
    for (int i = 0;; i++)
    {
      int[][] arrayOfInt = this.c;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = d.a(parama.c[i]);
    }
  }
  
  public a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 9)
    {
      this.a = f.e(paramArrayOfByte, 0);
      int i = f.e(paramArrayOfByte, 4);
      this.b = i;
      int j = this.a;
      if (j > 0)
      {
        int k = paramArrayOfByte.length;
        int m = 8;
        if ((i + 7 >>> 3) * j == k - 8)
        {
          i = i + 31 >>> 5;
          this.d = i;
          this.c = new int[j][i];
          k = this.b;
          int n = k >> 5;
          for (j = 0; j < this.a; j++)
          {
            i = 0;
            while (i < n)
            {
              this.c[j][i] = f.e(paramArrayOfByte, m);
              i++;
              m += 4;
            }
            i = 0;
            while (i < (k & 0x1F))
            {
              int[] arrayOfInt = this.c[j];
              int i1 = arrayOfInt[n];
              arrayOfInt[n] = ((paramArrayOfByte[m] & 0xFF) << i ^ i1);
              i += 8;
              m++;
            }
          }
          return;
        }
      }
      throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }
    throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
  }
  
  public byte[] c()
  {
    int i = this.b;
    int j = this.a;
    int k = 8;
    byte[] arrayOfByte = new byte[(i + 7 >>> 3) * j + 8];
    f.a(j, arrayOfByte, 0);
    f.a(this.b, arrayOfByte, 4);
    int m = this.b;
    int n = m >>> 5;
    for (i = 0; i < this.a; i++)
    {
      j = 0;
      while (j < n)
      {
        f.a(this.c[i][j], arrayOfByte, k);
        j++;
        k += 4;
      }
      j = 0;
      while (j < (m & 0x1F))
      {
        arrayOfByte[k] = ((byte)(byte)(this.c[i][n] >>> j & 0xFF));
        j += 8;
        k++;
      }
    }
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.a == ((g)paramObject).a) && (this.b == ((g)paramObject).b) && (this.d == ((a)paramObject).d))
    {
      for (int i = 0; i < this.a; i++) {
        if (!d.b(this.c[i], paramObject.c[i])) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = (this.a * 31 + this.b) * 31 + this.d;
    for (int j = 0; j < this.a; j++) {
      i = i * 31 + this.c[j].hashCode();
    }
    return i;
  }
  
  public String toString()
  {
    int i = this.b & 0x1F;
    int j = this.d;
    if (i != 0) {
      j--;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    for (int k = 0; k < this.a; k++)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append(": ");
      localStringBuffer.append(localStringBuilder.toString());
      for (int m = 0; m < j; m++)
      {
        int n = this.c[k][m];
        for (i1 = 0; i1 < 32; i1++) {
          if ((n >>> i1 & 0x1) == 0) {
            localStringBuffer.append('0');
          } else {
            localStringBuffer.append('1');
          }
        }
        localStringBuffer.append(' ');
      }
      int i1 = this.c[k][(this.d - 1)];
      for (m = 0; m < i; m++) {
        if ((i1 >>> m & 0x1) == 0) {
          localStringBuffer.append('0');
        } else {
          localStringBuffer.append('1');
        }
      }
      localStringBuffer.append('\n');
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */