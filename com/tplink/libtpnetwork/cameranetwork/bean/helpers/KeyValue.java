package com.tplink.libtpnetwork.cameranetwork.bean.helpers;

public class KeyValue<T>
{
  private String key;
  private T value;
  
  public KeyValue() {}
  
  public KeyValue(String paramString, T paramT)
  {
    this.key = paramString;
    this.value = paramT;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public T getValue()
  {
    return (T)this.value;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setValue(T paramT)
  {
    this.value = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\helpers\KeyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */