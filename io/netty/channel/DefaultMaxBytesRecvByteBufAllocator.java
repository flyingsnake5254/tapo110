package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class DefaultMaxBytesRecvByteBufAllocator
  implements MaxBytesRecvByteBufAllocator
{
  private volatile int maxBytesPerIndividualRead;
  private volatile int maxBytesPerRead;
  
  public DefaultMaxBytesRecvByteBufAllocator()
  {
    this(65536, 65536);
  }
  
  public DefaultMaxBytesRecvByteBufAllocator(int paramInt1, int paramInt2)
  {
    checkMaxBytesPerReadPair(paramInt1, paramInt2);
    this.maxBytesPerRead = paramInt1;
    this.maxBytesPerIndividualRead = paramInt2;
  }
  
  private static void checkMaxBytesPerReadPair(int paramInt1, int paramInt2)
  {
    ObjectUtil.checkPositive(paramInt1, "maxBytesPerRead");
    ObjectUtil.checkPositive(paramInt2, "maxBytesPerIndividualRead");
    if (paramInt1 >= paramInt2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("): ");
    localStringBuilder.append(paramInt1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int maxBytesPerIndividualRead()
  {
    return this.maxBytesPerIndividualRead;
  }
  
  public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "maxBytesPerIndividualRead");
    try
    {
      int i = maxBytesPerRead();
      if (paramInt <= i)
      {
        this.maxBytesPerIndividualRead = paramInt;
        return this;
      }
      IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (");
      localStringBuilder.append(i);
      localStringBuilder.append("): ");
      localStringBuilder.append(paramInt);
      localIllegalArgumentException.<init>(localStringBuilder.toString());
      throw localIllegalArgumentException;
    }
    finally {}
  }
  
  public int maxBytesPerRead()
  {
    return this.maxBytesPerRead;
  }
  
  public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "maxBytesPerRead");
    try
    {
      int i = maxBytesPerIndividualRead();
      if (paramInt >= i)
      {
        this.maxBytesPerRead = paramInt;
        return this;
      }
      IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (");
      localStringBuilder.append(i);
      localStringBuilder.append("): ");
      localStringBuilder.append(paramInt);
      localIllegalArgumentException.<init>(localStringBuilder.toString());
      throw localIllegalArgumentException;
    }
    finally {}
  }
  
  public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int paramInt1, int paramInt2)
  {
    checkMaxBytesPerReadPair(paramInt1, paramInt2);
    try
    {
      this.maxBytesPerRead = paramInt1;
      this.maxBytesPerIndividualRead = paramInt2;
      return this;
    }
    finally {}
  }
  
  public Map.Entry<Integer, Integer> maxBytesPerReadPair()
  {
    try
    {
      AbstractMap.SimpleEntry localSimpleEntry = new AbstractMap.SimpleEntry(Integer.valueOf(this.maxBytesPerRead), Integer.valueOf(this.maxBytesPerIndividualRead));
      return localSimpleEntry;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public RecvByteBufAllocator.Handle newHandle()
  {
    return new HandleImpl(null);
  }
  
  private final class HandleImpl
    implements RecvByteBufAllocator.ExtendedHandle
  {
    private int attemptBytesRead;
    private int bytesToRead;
    private final UncheckedBooleanSupplier defaultMaybeMoreSupplier = new UncheckedBooleanSupplier()
    {
      public boolean get()
      {
        boolean bool;
        if (DefaultMaxBytesRecvByteBufAllocator.HandleImpl.this.attemptBytesRead == DefaultMaxBytesRecvByteBufAllocator.HandleImpl.this.lastBytesRead) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    private int individualReadMax;
    private int lastBytesRead;
    
    private HandleImpl() {}
    
    public ByteBuf allocate(ByteBufAllocator paramByteBufAllocator)
    {
      return paramByteBufAllocator.ioBuffer(guess());
    }
    
    public int attemptedBytesRead()
    {
      return this.attemptBytesRead;
    }
    
    public void attemptedBytesRead(int paramInt)
    {
      this.attemptBytesRead = paramInt;
    }
    
    public boolean continueReading()
    {
      return continueReading(this.defaultMaybeMoreSupplier);
    }
    
    public boolean continueReading(UncheckedBooleanSupplier paramUncheckedBooleanSupplier)
    {
      boolean bool;
      if ((this.bytesToRead > 0) && (paramUncheckedBooleanSupplier.get())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int guess()
    {
      return Math.min(this.individualReadMax, this.bytesToRead);
    }
    
    public void incMessagesRead(int paramInt) {}
    
    public int lastBytesRead()
    {
      return this.lastBytesRead;
    }
    
    public void lastBytesRead(int paramInt)
    {
      this.lastBytesRead = paramInt;
      this.bytesToRead -= paramInt;
    }
    
    public void readComplete() {}
    
    public void reset(ChannelConfig paramChannelConfig)
    {
      this.bytesToRead = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerRead();
      this.individualReadMax = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerIndividualRead();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultMaxBytesRecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */