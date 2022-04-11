package io.netty.channel.rxtx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

@Deprecated
public abstract interface RxtxChannelConfig
  extends ChannelConfig
{
  public abstract int getBaudrate();
  
  public abstract Databits getDatabits();
  
  public abstract Paritybit getParitybit();
  
  public abstract int getReadTimeout();
  
  public abstract Stopbits getStopbits();
  
  public abstract int getWaitTimeMillis();
  
  public abstract boolean isDtr();
  
  public abstract boolean isRts();
  
  public abstract RxtxChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract RxtxChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract RxtxChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract RxtxChannelConfig setBaudrate(int paramInt);
  
  public abstract RxtxChannelConfig setConnectTimeoutMillis(int paramInt);
  
  public abstract RxtxChannelConfig setDatabits(Databits paramDatabits);
  
  public abstract RxtxChannelConfig setDtr(boolean paramBoolean);
  
  @Deprecated
  public abstract RxtxChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract RxtxChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract RxtxChannelConfig setParitybit(Paritybit paramParitybit);
  
  public abstract RxtxChannelConfig setReadTimeout(int paramInt);
  
  public abstract RxtxChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract RxtxChannelConfig setRts(boolean paramBoolean);
  
  public abstract RxtxChannelConfig setStopbits(Stopbits paramStopbits);
  
  public abstract RxtxChannelConfig setWaitTimeMillis(int paramInt);
  
  public abstract RxtxChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  public abstract RxtxChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract RxtxChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract RxtxChannelConfig setWriteSpinCount(int paramInt);
  
  public static enum Databits
  {
    private final int value;
    
    static
    {
      Databits localDatabits1 = new Databits("DATABITS_5", 0, 5);
      DATABITS_5 = localDatabits1;
      Databits localDatabits2 = new Databits("DATABITS_6", 1, 6);
      DATABITS_6 = localDatabits2;
      Databits localDatabits3 = new Databits("DATABITS_7", 2, 7);
      DATABITS_7 = localDatabits3;
      Databits localDatabits4 = new Databits("DATABITS_8", 3, 8);
      DATABITS_8 = localDatabits4;
      $VALUES = new Databits[] { localDatabits1, localDatabits2, localDatabits3, localDatabits4 };
    }
    
    private Databits(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static Databits valueOf(int paramInt)
    {
      for (Databits localDatabits : ) {
        if (localDatabits.value == paramInt) {
          return localDatabits;
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("unknown ");
      ((StringBuilder)???).append(Databits.class.getSimpleName());
      ((StringBuilder)???).append(" value: ");
      ((StringBuilder)???).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)???).toString());
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum Paritybit
  {
    private final int value;
    
    static
    {
      Paritybit localParitybit1 = new Paritybit("NONE", 0, 0);
      NONE = localParitybit1;
      Paritybit localParitybit2 = new Paritybit("ODD", 1, 1);
      ODD = localParitybit2;
      Paritybit localParitybit3 = new Paritybit("EVEN", 2, 2);
      EVEN = localParitybit3;
      Paritybit localParitybit4 = new Paritybit("MARK", 3, 3);
      MARK = localParitybit4;
      Paritybit localParitybit5 = new Paritybit("SPACE", 4, 4);
      SPACE = localParitybit5;
      $VALUES = new Paritybit[] { localParitybit1, localParitybit2, localParitybit3, localParitybit4, localParitybit5 };
    }
    
    private Paritybit(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static Paritybit valueOf(int paramInt)
    {
      for (Paritybit localParitybit : ) {
        if (localParitybit.value == paramInt) {
          return localParitybit;
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("unknown ");
      ((StringBuilder)???).append(Paritybit.class.getSimpleName());
      ((StringBuilder)???).append(" value: ");
      ((StringBuilder)???).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)???).toString());
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum Stopbits
  {
    private final int value;
    
    static
    {
      Stopbits localStopbits1 = new Stopbits("STOPBITS_1", 0, 1);
      STOPBITS_1 = localStopbits1;
      Stopbits localStopbits2 = new Stopbits("STOPBITS_2", 1, 2);
      STOPBITS_2 = localStopbits2;
      Stopbits localStopbits3 = new Stopbits("STOPBITS_1_5", 2, 3);
      STOPBITS_1_5 = localStopbits3;
      $VALUES = new Stopbits[] { localStopbits1, localStopbits2, localStopbits3 };
    }
    
    private Stopbits(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static Stopbits valueOf(int paramInt)
    {
      for (localObject : ) {
        if (((Stopbits)localObject).value == paramInt) {
          return (Stopbits)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown ");
      ((StringBuilder)localObject).append(Stopbits.class.getSimpleName());
      ((StringBuilder)localObject).append(" value: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\rxtx\RxtxChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */