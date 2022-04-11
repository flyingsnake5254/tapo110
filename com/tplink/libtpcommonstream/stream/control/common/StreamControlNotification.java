package com.tplink.libtpcommonstream.stream.control.common;

import com.google.gson.q.a;
import com.google.gson.q.c;

public class StreamControlNotification<T>
{
  @c("event_type")
  private String eventType;
  @a(deserialize=false, serialize=false)
  private T result;
  
  public StreamControlNotification() {}
  
  public StreamControlNotification(String paramString, T paramT)
  {
    this.eventType = paramString;
    this.result = paramT;
  }
  
  public String getEventType()
  {
    return this.eventType;
  }
  
  public T getResult()
  {
    return (T)this.result;
  }
  
  public void setEventType(String paramString)
  {
    this.eventType = paramString;
  }
  
  public void setResult(T paramT)
  {
    this.result = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\StreamControlNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */