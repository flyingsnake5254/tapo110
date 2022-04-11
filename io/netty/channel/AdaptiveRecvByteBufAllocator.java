package io.netty.channel;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.List;

public class AdaptiveRecvByteBufAllocator
  extends DefaultMaxMessagesRecvByteBufAllocator
{
  @Deprecated
  public static final AdaptiveRecvByteBufAllocator DEFAULT = new AdaptiveRecvByteBufAllocator();
  static final int DEFAULT_INITIAL = 1024;
  static final int DEFAULT_MAXIMUM = 65536;
  static final int DEFAULT_MINIMUM = 64;
  private static final int INDEX_DECREMENT = 1;
  private static final int INDEX_INCREMENT = 4;
  private static final int[] SIZE_TABLE;
  private final int initial;
  private final int maxIndex;
  private final int minIndex;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    for (int i = 16;; i += 16)
    {
      j = 512;
      if (i >= 512) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
    }
    while (j > 0)
    {
      localArrayList.add(Integer.valueOf(j));
      j <<= 1;
    }
    SIZE_TABLE = new int[localArrayList.size()];
    for (i = 0;; i++)
    {
      int[] arrayOfInt = SIZE_TABLE;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
    }
  }
  
  public AdaptiveRecvByteBufAllocator()
  {
    this(64, 1024, 65536);
  }
  
  public AdaptiveRecvByteBufAllocator(int paramInt1, int paramInt2, int paramInt3)
  {
    ObjectUtil.checkPositive(paramInt1, "minimum");
    if (paramInt2 >= paramInt1)
    {
      if (paramInt3 >= paramInt2)
      {
        int i = getSizeTableIndex(paramInt1);
        localObject = SIZE_TABLE;
        if (localObject[i] < paramInt1) {
          this.minIndex = (i + 1);
        } else {
          this.minIndex = i;
        }
        paramInt1 = getSizeTableIndex(paramInt3);
        if (localObject[paramInt1] > paramInt3) {
          this.maxIndex = (paramInt1 - 1);
        } else {
          this.maxIndex = paramInt1;
        }
        this.initial = paramInt2;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("maximum: ");
      ((StringBuilder)localObject).append(paramInt3);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initial: ");
    ((StringBuilder)localObject).append(paramInt2);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static int getSizeTableIndex(int paramInt)
  {
    int i = SIZE_TABLE.length - 1;
    int j = 0;
    int k;
    int m;
    int n;
    for (;;)
    {
      if (i < j) {
        return j;
      }
      if (i == j) {
        return i;
      }
      k = j + i >>> 1;
      int[] arrayOfInt = SIZE_TABLE;
      m = arrayOfInt[k];
      n = k + 1;
      if (paramInt > arrayOfInt[n])
      {
        j = n;
      }
      else
      {
        if (paramInt >= m) {
          break;
        }
        i = k - 1;
      }
    }
    if (paramInt == m) {
      return k;
    }
    return n;
  }
  
  public RecvByteBufAllocator.Handle newHandle()
  {
    return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
  }
  
  public AdaptiveRecvByteBufAllocator respectMaybeMoreData(boolean paramBoolean)
  {
    super.respectMaybeMoreData(paramBoolean);
    return this;
  }
  
  private final class HandleImpl
    extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle
  {
    private boolean decreaseNow;
    private int index;
    private final int maxIndex;
    private final int minIndex;
    private int nextReceiveBufferSize;
    
    HandleImpl(int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      this.minIndex = paramInt1;
      this.maxIndex = paramInt2;
      this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(paramInt3);
      this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
    }
    
    private void record(int paramInt)
    {
      if (paramInt <= AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 1)])
      {
        if (this.decreaseNow)
        {
          this.index = Math.max(this.index - 1, this.minIndex);
          this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
          this.decreaseNow = false;
        }
        else
        {
          this.decreaseNow = true;
        }
      }
      else if (paramInt >= this.nextReceiveBufferSize)
      {
        this.index = Math.min(this.index + 4, this.maxIndex);
        this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        this.decreaseNow = false;
      }
    }
    
    public int guess()
    {
      return this.nextReceiveBufferSize;
    }
    
    public void lastBytesRead(int paramInt)
    {
      if (paramInt == attemptedBytesRead()) {
        record(paramInt);
      }
      super.lastBytesRead(paramInt);
    }
    
    public void readComplete()
    {
      record(totalBytesRead());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\AdaptiveRecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */