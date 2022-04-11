package e.a.c.d.a;

public final class f
{
  public static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)(paramInt1 >>> 24));
  }
  
  public static void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    
    while (paramInt3 >= 0)
    {
      paramArrayOfByte[(paramInt2 + paramInt3)] = ((byte)(byte)(paramInt1 >>> paramInt3 * 8));
      paramInt3--;
    }
  }
  
  public static byte[] c(int paramInt)
  {
    return new byte[] { (byte)paramInt, (byte)(paramInt >>> 8), (byte)(paramInt >>> 16), (byte)(paramInt >>> 24) };
  }
  
  public static int d(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return (paramArrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static int e(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int j = i + 1;
    int k = paramArrayOfByte[i];
    i = paramArrayOfByte[j];
    return (paramArrayOfByte[(j + 1)] & 0xFF) << 24 | paramInt & 0xFF | (k & 0xFF) << 8 | (i & 0xFF) << 16;
  }
  
  public static int f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2--;
    int i = 0;
    while (paramInt2 >= 0)
    {
      i |= (paramArrayOfByte[(paramInt1 + paramInt2)] & 0xFF) << paramInt2 * 8;
      paramInt2--;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */