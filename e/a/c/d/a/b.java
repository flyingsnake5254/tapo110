package e.a.c.d.a;

public class b
{
  private int a = 0;
  private int b;
  
  public b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 4)
    {
      int i = f.d(paramArrayOfByte);
      this.b = i;
      if (j.c(i))
      {
        this.a = j.a(this.b);
        return;
      }
      throw new IllegalArgumentException("byte array is not an encoded finite field");
    }
    throw new IllegalArgumentException("byte array is not an encoded finite field");
  }
  
  private static String i(int paramInt)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = "0";
    }
    else
    {
      if ((byte)(paramInt & 0x1) == 1) {
        localObject1 = "1";
      } else {
        localObject1 = "";
      }
      paramInt >>>= 1;
      int i = 1;
      while (paramInt != 0)
      {
        Object localObject2 = localObject1;
        if ((byte)(paramInt & 0x1) == 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("+x^");
          ((StringBuilder)localObject2).append(i);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        paramInt >>>= 1;
        i++;
        localObject1 = localObject2;
      }
    }
    return (String)localObject1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  public String b(int paramInt)
  {
    String str1 = "";
    for (int i = 0; i < this.a; i++)
    {
      StringBuilder localStringBuilder;
      String str2;
      if (((byte)paramInt & 0x1) == 0)
      {
        localStringBuilder = new StringBuilder();
        str2 = "0";
      }
      else
      {
        localStringBuilder = new StringBuilder();
        str2 = "1";
      }
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      str1 = localStringBuilder.toString();
      paramInt >>>= 1;
    }
    return str1;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 1;
    }
    if (paramInt1 == 0) {
      return 0;
    }
    if (paramInt1 == 1) {
      return 1;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt2 < 0)
    {
      i = f(paramInt1);
      j = -paramInt2;
    }
    for (paramInt1 = 1; j != 0; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1;
      if ((j & 0x1) == 1) {
        paramInt2 = h(paramInt1, i);
      }
      i = h(i, i);
      j >>>= 1;
    }
    return paramInt1;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public byte[] e()
  {
    return f.c(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((this.a == ((b)paramObject).a) && (this.b == ((b)paramObject).b)) {
        return true;
      }
    }
    return false;
  }
  
  public int f(int paramInt)
  {
    return c(paramInt, (1 << this.a) - 2);
  }
  
  public boolean g(int paramInt)
  {
    int i = this.a;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 31)
    {
      if (paramInt >= 0) {
        bool2 = true;
      }
      return bool2;
    }
    bool2 = bool1;
    if (paramInt >= 0)
    {
      bool2 = bool1;
      if (paramInt < 1 << i) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public int h(int paramInt1, int paramInt2)
  {
    return j.d(paramInt1, paramInt2, this.b);
  }
  
  public int hashCode()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Finite Field GF(2^");
    localStringBuilder.append(this.a);
    localStringBuilder.append(") = GF(2)[X]/<");
    localStringBuilder.append(i(this.b));
    localStringBuilder.append("> ");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */