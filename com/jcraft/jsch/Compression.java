package com.jcraft.jsch;

public abstract interface Compression
{
  public static final int DEFLATER = 1;
  public static final int INFLATER = 0;
  
  public abstract byte[] compress(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt);
  
  public abstract void init(int paramInt1, int paramInt2);
  
  public abstract byte[] uncompress(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Compression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */