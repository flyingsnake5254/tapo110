package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class f0
{
  public static List<byte[]> a(byte[] paramArrayOfByte)
  {
    long l1 = e(d(paramArrayOfByte));
    long l2 = e(3840L);
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(paramArrayOfByte);
    localArrayList.add(b(l1));
    localArrayList.add(b(l2));
    return localArrayList;
  }
  
  private static byte[] b(long paramLong)
  {
    return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(paramLong).array();
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[9] & 0xFF;
  }
  
  private static int d(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[11];
    return paramArrayOfByte[10] & 0xFF | (i & 0xFF) << 8;
  }
  
  private static long e(long paramLong)
  {
    return paramLong * 1000000000L / 48000L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */