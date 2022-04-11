package e.a.b.c;

public class a
{
  public static int a(int paramInt)
  {
    paramInt &= 0xFFFF;
    paramInt = (paramInt | paramInt << 8) & 0xFF00FF;
    paramInt = (paramInt | paramInt << 4) & 0xF0F0F0F;
    paramInt = (paramInt | paramInt << 2) & 0x33333333;
    return (paramInt | paramInt << 1) & 0x55555555;
  }
  
  public static long b(int paramInt)
  {
    int i = (paramInt >>> 8 ^ paramInt) & 0xFF00;
    i = paramInt ^ i ^ i << 8;
    paramInt = (i >>> 4 ^ i) & 0xF000F0;
    i ^= paramInt ^ paramInt << 4;
    paramInt = (i >>> 2 ^ i) & 0xC0C0C0C;
    paramInt = i ^ paramInt ^ paramInt << 2;
    i = (paramInt >>> 1 ^ paramInt) & 0x22222222;
    paramInt ^= i ^ i << 1;
    return (paramInt >>> 1 & 0x55555555) << 32 | 0x55555555 & paramInt;
  }
  
  public static void c(long paramLong, long[] paramArrayOfLong, int paramInt)
  {
    long l = (paramLong >>> 16 ^ paramLong) & 0xFFFF0000;
    paramLong ^= l ^ l << 16;
    l = (paramLong >>> 8 ^ paramLong) & 0xFF000000FF00;
    l = paramLong ^ l ^ l << 8;
    paramLong = (l >>> 4 ^ l) & 0xF000F000F000F0;
    paramLong = l ^ paramLong ^ paramLong << 4;
    l = (paramLong >>> 2 ^ paramLong) & 0xC0C0C0C0C0C0C0C;
    paramLong ^= l ^ l << 2;
    l = (paramLong >>> 1 ^ paramLong) & 0x2222222222222222;
    paramLong ^= l ^ l << 1;
    paramArrayOfLong[paramInt] = (paramLong & 0x5555555555555555);
    paramArrayOfLong[(paramInt + 1)] = (paramLong >>> 1 & 0x5555555555555555);
  }
  
  public static void d(long paramLong, long[] paramArrayOfLong, int paramInt)
  {
    long l = (paramLong >>> 16 ^ paramLong) & 0xFFFF0000;
    paramLong ^= l ^ l << 16;
    l = (paramLong >>> 8 ^ paramLong) & 0xFF000000FF00;
    l = paramLong ^ l ^ l << 8;
    paramLong = (l >>> 4 ^ l) & 0xF000F000F000F0;
    l ^= paramLong ^ paramLong << 4;
    paramLong = (l >>> 2 ^ l) & 0xC0C0C0C0C0C0C0C;
    paramLong = l ^ paramLong ^ paramLong << 2;
    l = (paramLong >>> 1 ^ paramLong) & 0x2222222222222222;
    paramLong ^= l ^ l << 1;
    paramArrayOfLong[paramInt] = (paramLong & 0xAAAAAAAAAAAAAAAA);
    paramArrayOfLong[(paramInt + 1)] = (paramLong << 1 & 0xAAAAAAAAAAAAAAAA);
  }
  
  public static int e(int paramInt)
  {
    paramInt &= 0xFF;
    paramInt = (paramInt | paramInt << 4) & 0xF0F;
    paramInt = (paramInt | paramInt << 2) & 0x3333;
    return (paramInt | paramInt << 1) & 0x5555;
  }
  
  public static long f(long paramLong)
  {
    long l = (paramLong >>> 1 ^ paramLong) & 0x2222222222222222;
    paramLong ^= l ^ l << 1;
    l = (paramLong >>> 2 ^ paramLong) & 0xC0C0C0C0C0C0C0C;
    paramLong ^= l ^ l << 2;
    l = (paramLong >>> 4 ^ paramLong) & 0xF000F000F000F0;
    paramLong ^= l ^ l << 4;
    l = (paramLong >>> 8 ^ paramLong) & 0xFF000000FF00;
    paramLong ^= l ^ l << 8;
    l = (paramLong >>> 16 ^ paramLong) & 0xFFFF0000;
    return paramLong ^ l ^ l << 16;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */