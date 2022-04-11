package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

public final class WriteBufferWaterMark
{
  public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
  private static final int DEFAULT_HIGH_WATER_MARK = 65536;
  private static final int DEFAULT_LOW_WATER_MARK = 32768;
  private final int high;
  private final int low;
  
  public WriteBufferWaterMark(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, true);
  }
  
  WriteBufferWaterMark(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ObjectUtil.checkPositiveOrZero(paramInt1, "low");
      if (paramInt2 < paramInt1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("write buffer's high water mark cannot be less than  low water mark (");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("): ");
        localStringBuilder.append(paramInt2);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    this.low = paramInt1;
    this.high = paramInt2;
  }
  
  public int high()
  {
    return this.high;
  }
  
  public int low()
  {
    return this.low;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("WriteBufferWaterMark(low: ");
    localStringBuilder.append(this.low);
    localStringBuilder.append(", high: ");
    localStringBuilder.append(this.high);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\WriteBufferWaterMark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */