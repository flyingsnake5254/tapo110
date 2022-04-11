package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class MultiByteArrayInputStream
  extends InputStream
{
  private byte[] bytesA;
  private byte[] bytesB;
  private int lengthA;
  private int lengthB;
  private int offsetA;
  private int offsetB;
  private int pos = 0;
  
  public MultiByteArrayInputStream(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    this.bytesA = ((byte[])paramArrayOfByte1.clone());
    this.bytesB = ((byte[])paramArrayOfByte2.clone());
    this.offsetA = paramInt1;
    this.offsetB = paramInt3;
    this.lengthA = paramInt2;
    this.lengthB = paramInt4;
  }
  
  public int read()
    throws IOException
  {
    int i = this.pos;
    int j = this.lengthA;
    if (i < j)
    {
      j = this.bytesA[(this.offsetA + i)];
    }
    else
    {
      if (i >= this.lengthB + j) {
        break label75;
      }
      j = this.bytesB[(this.offsetB + i - j)];
    }
    int k = j;
    if (j < 0) {
      k = j + 256;
    }
    this.pos = (i + 1);
    return k;
    label75:
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MultiByteArrayInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */