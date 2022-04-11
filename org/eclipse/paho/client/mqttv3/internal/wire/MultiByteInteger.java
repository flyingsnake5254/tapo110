package org.eclipse.paho.client.mqttv3.internal.wire;

public class MultiByteInteger
{
  private int length;
  private int value;
  
  public MultiByteInteger(int paramInt)
  {
    this(paramInt, -1);
  }
  
  public MultiByteInteger(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
    this.length = paramInt2;
  }
  
  public int getEncodedLength()
  {
    return this.length;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MultiByteInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */