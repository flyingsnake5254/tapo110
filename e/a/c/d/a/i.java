package e.a.c.d.a;

public class i
{
  private b a;
  private int b;
  private int[] c;
  
  public i(b paramb, int paramInt)
  {
    this.a = paramb;
    this.b = paramInt;
    paramb = new int[paramInt + 1];
    this.c = paramb;
    paramb[paramInt] = 1;
  }
  
  public i(b paramb, byte[] paramArrayOfByte)
  {
    this.a = paramb;
    int i = 8;
    int j = 1;
    while (paramb.d() > i)
    {
      j++;
      i += 8;
    }
    if (paramArrayOfByte.length % j == 0)
    {
      this.c = new int[paramArrayOfByte.length / j];
      j = 0;
      int k = 0;
      for (;;)
      {
        paramb = this.c;
        if (j >= paramb.length) {
          break label149;
        }
        int m = 0;
        while (m < i)
        {
          paramb = this.c;
          int n = paramb[j];
          paramb[j] = ((paramArrayOfByte[k] & 0xFF) << m ^ n);
          m += 8;
          k++;
        }
        if (!this.a.g(this.c[j])) {
          break;
        }
        j++;
      }
      throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
      label149:
      if ((paramb.length != 1) && (paramb[(paramb.length - 1)] == 0)) {
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
      }
      d();
      return;
    }
    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
  }
  
  public i(b paramb, int[] paramArrayOfInt)
  {
    this.a = paramb;
    this.c = q(paramArrayOfInt);
    d();
  }
  
  public i(i parami)
  {
    this.a = parami.a;
    this.b = parami.b;
    this.c = d.a(parami.c);
  }
  
  private int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt1.length < paramArrayOfInt2.length)
    {
      arrayOfInt = new int[paramArrayOfInt2.length];
      System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      paramArrayOfInt2 = arrayOfInt;
    }
    else
    {
      arrayOfInt = new int[paramArrayOfInt1.length];
      System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, paramArrayOfInt1.length);
      paramArrayOfInt1 = paramArrayOfInt2;
      paramArrayOfInt2 = arrayOfInt;
    }
    for (int i = paramArrayOfInt1.length - 1; i >= 0; i--) {
      paramArrayOfInt2[i] = this.a.a(paramArrayOfInt2[i], paramArrayOfInt1[i]);
    }
    return paramArrayOfInt2;
  }
  
  private static int c(int[] paramArrayOfInt)
  {
    for (int i = paramArrayOfInt.length - 1; (i >= 0) && (paramArrayOfInt[i] == 0); i--) {}
    return i;
  }
  
  private void d()
  {
    int i = this.c.length;
    do
    {
      this.b = (i - 1);
      i = this.b;
    } while ((i >= 0) && (this.c[i] == 0));
  }
  
  private static int i(int[] paramArrayOfInt)
  {
    int i = c(paramArrayOfInt);
    if (i == -1) {
      return 0;
    }
    return paramArrayOfInt[i];
  }
  
  private static boolean j(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = c(paramArrayOfInt1);
    if (i != c(paramArrayOfInt2)) {
      return false;
    }
    for (int j = 0; j <= i; j++) {
      if (paramArrayOfInt1[j] != paramArrayOfInt2[j]) {
        return false;
      }
    }
    return true;
  }
  
  private int[] l(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = c(paramArrayOfInt2);
    if (i != -1)
    {
      int j = paramArrayOfInt1.length;
      int[] arrayOfInt = new int[j];
      int k = i(paramArrayOfInt2);
      k = this.a.f(k);
      System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, j);
      for (paramArrayOfInt1 = arrayOfInt; i <= c(paramArrayOfInt1); paramArrayOfInt1 = a(o(p(paramArrayOfInt2, c(paramArrayOfInt1) - i), j), paramArrayOfInt1)) {
        j = this.a.h(i(paramArrayOfInt1), k);
      }
      return paramArrayOfInt1;
    }
    throw new ArithmeticException("Division by zero");
  }
  
  private int[] o(int[] paramArrayOfInt, int paramInt)
  {
    int i = c(paramArrayOfInt);
    if ((i != -1) && (paramInt != 0))
    {
      if (paramInt == 1) {
        return d.a(paramArrayOfInt);
      }
      int[] arrayOfInt = new int[i + 1];
      while (i >= 0)
      {
        arrayOfInt[i] = this.a.h(paramArrayOfInt[i], paramInt);
        i--;
      }
      return arrayOfInt;
    }
    return new int[1];
  }
  
  private static int[] p(int[] paramArrayOfInt, int paramInt)
  {
    int i = c(paramArrayOfInt);
    if (i == -1) {
      return new int[1];
    }
    int[] arrayOfInt = new int[i + paramInt + 1];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, paramInt, i + 1);
    return arrayOfInt;
  }
  
  private static int[] q(int[] paramArrayOfInt)
  {
    int i = c(paramArrayOfInt);
    if (i == -1) {
      return new int[1];
    }
    int j = paramArrayOfInt.length;
    i++;
    if (j == i) {
      return d.a(paramArrayOfInt);
    }
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    return arrayOfInt;
  }
  
  public void b(i parami)
  {
    this.c = a(this.c, parami.c);
    d();
  }
  
  public int e(int paramInt)
  {
    int[] arrayOfInt = this.c;
    int i = this.b;
    int j = arrayOfInt[i];
    i--;
    while (i >= 0)
    {
      j = this.a.h(j, paramInt) ^ this.c[i];
      i--;
    }
    return j;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof i)))
    {
      paramObject = (i)paramObject;
      if ((this.a.equals(((i)paramObject).a)) && (this.b == ((i)paramObject).b) && (j(this.c, ((i)paramObject).c))) {
        return true;
      }
    }
    return false;
  }
  
  public int f(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.b)) {
      return this.c[paramInt];
    }
    return 0;
  }
  
  public int g()
  {
    int[] arrayOfInt = this.c;
    int i = arrayOfInt.length - 1;
    if (arrayOfInt[i] == 0) {
      return -1;
    }
    return i;
  }
  
  public byte[] h()
  {
    int i = 8;
    int j = 1;
    while (this.a.d() > i)
    {
      j++;
      i += 8;
    }
    byte[] arrayOfByte = new byte[this.c.length * j];
    j = 0;
    int k = 0;
    while (j < this.c.length)
    {
      int m = 0;
      while (m < i)
      {
        arrayOfByte[k] = ((byte)(byte)(this.c[j] >>> m));
        m += 8;
        k++;
      }
      j++;
    }
    return arrayOfByte;
  }
  
  public int hashCode()
  {
    int i = this.a.hashCode();
    for (int j = 0;; j++)
    {
      int[] arrayOfInt = this.c;
      if (j >= arrayOfInt.length) {
        break;
      }
      i = i * 31 + arrayOfInt[j];
    }
    return i;
  }
  
  public i k(i parami)
  {
    parami = l(this.c, parami.c);
    return new i(this.a, parami);
  }
  
  public void m(int paramInt)
  {
    if (this.a.g(paramInt))
    {
      this.c = o(this.c, paramInt);
      d();
      return;
    }
    throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
  }
  
  public i n(int paramInt)
  {
    if (this.a.g(paramInt))
    {
      int[] arrayOfInt = o(this.c, paramInt);
      return new i(this.a, arrayOfInt);
    }
    throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" Polynomial over ");
    ((StringBuilder)localObject).append(this.a.toString());
    ((StringBuilder)localObject).append(": \n");
    localObject = ((StringBuilder)localObject).toString();
    for (int i = 0; i < this.c.length; i++)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.a.b(this.c[i]));
      localStringBuilder.append("Y^");
      localStringBuilder.append(i);
      localStringBuilder.append("+");
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */