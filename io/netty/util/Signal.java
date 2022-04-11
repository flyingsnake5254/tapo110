package io.netty.util;

public final class Signal
  extends Error
  implements Constant<Signal>
{
  private static final ConstantPool<Signal> pool = new ConstantPool()
  {
    protected Signal newConstant(int paramAnonymousInt, String paramAnonymousString)
    {
      return new Signal(paramAnonymousInt, paramAnonymousString, null);
    }
  };
  private static final long serialVersionUID = -221145131122459977L;
  private final SignalConstant constant;
  
  private Signal(int paramInt, String paramString)
  {
    this.constant = new SignalConstant(paramInt, paramString);
  }
  
  public static Signal valueOf(Class<?> paramClass, String paramString)
  {
    return (Signal)pool.valueOf(paramClass, paramString);
  }
  
  public static Signal valueOf(String paramString)
  {
    return (Signal)pool.valueOf(paramString);
  }
  
  public int compareTo(Signal paramSignal)
  {
    if (this == paramSignal) {
      return 0;
    }
    return this.constant.compareTo(paramSignal.constant);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void expect(Signal paramSignal)
  {
    if (this == paramSignal) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected signal: ");
    localStringBuilder.append(paramSignal);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this);
  }
  
  public int id()
  {
    return this.constant.id();
  }
  
  public Throwable initCause(Throwable paramThrowable)
  {
    return this;
  }
  
  public String name()
  {
    return this.constant.name();
  }
  
  public String toString()
  {
    return name();
  }
  
  private static final class SignalConstant
    extends AbstractConstant<SignalConstant>
  {
    SignalConstant(int paramInt, String paramString)
    {
      super(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\Signal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */