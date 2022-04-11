package com.tplink.libtpnetwork.IoTNetwork.bean.common;

public class IoTDataWrapper<T>
{
  private T data;
  private Throwable throwable;
  
  public IoTDataWrapper() {}
  
  public IoTDataWrapper(T paramT)
  {
    this.data = paramT;
  }
  
  public IoTDataWrapper(T paramT, Throwable paramThrowable)
  {
    this.data = paramT;
    this.throwable = paramThrowable;
  }
  
  public IoTDataWrapper(Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
  }
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  public void setData(T paramT)
  {
    this.data = paramT;
  }
  
  public void setThrowable(Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\IoTDataWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */