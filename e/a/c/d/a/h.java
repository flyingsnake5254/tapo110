package e.a.c.d.a;

public class h
{
  private int[] a;
  
  public h(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 4)
    {
      int i = 0;
      int j = f.e(paramArrayOfByte, 0);
      int k = e.a(j - 1);
      if (paramArrayOfByte.length == j * k + 4)
      {
        this.a = new int[j];
        while (i < j)
        {
          this.a[i] = f.f(paramArrayOfByte, i * k + 4, k);
          i++;
        }
        if (b(this.a)) {
          return;
        }
        throw new IllegalArgumentException("invalid encoding");
      }
      throw new IllegalArgumentException("invalid encoding");
    }
    throw new IllegalArgumentException("invalid encoding");
  }
  
  private boolean b(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    boolean[] arrayOfBoolean = new boolean[i];
    int j = 0;
    while (j < i) {
      if ((paramArrayOfInt[j] >= 0) && (paramArrayOfInt[j] < i) && (arrayOfBoolean[paramArrayOfInt[j]] == 0))
      {
        arrayOfBoolean[paramArrayOfInt[j]] = true;
        j++;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public byte[] a()
  {
    int i = this.a.length;
    int j = e.a(i - 1);
    byte[] arrayOfByte = new byte[i * j + 4];
    int k = 0;
    f.a(i, arrayOfByte, 0);
    while (k < i)
    {
      f.b(this.a[k], arrayOfByte, k * j + 4, j);
      k++;
    }
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {
      return false;
    }
    paramObject = (h)paramObject;
    return d.b(this.a, ((h)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.a[0]);
    localObject = ((StringBuilder)localObject).toString();
    for (int i = 1; i < this.a.length; i++)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.a[i]);
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */