package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.ClientState;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class MqttOutputStream
  extends OutputStream
{
  private static final String CLASS_NAME = MqttOutputStream.class.getName();
  private ClientState clientState = null;
  private Logger log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
  private BufferedOutputStream out;
  
  public MqttOutputStream(ClientState paramClientState, OutputStream paramOutputStream)
  {
    this.clientState = paramClientState;
    this.out = new BufferedOutputStream(paramOutputStream);
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
  }
  
  public void write(MqttWireMessage paramMqttWireMessage)
    throws IOException, MqttException
  {
    byte[] arrayOfByte1 = paramMqttWireMessage.getHeader();
    byte[] arrayOfByte2 = paramMqttWireMessage.getPayload();
    this.out.write(arrayOfByte1, 0, arrayOfByte1.length);
    this.clientState.notifySentBytes(arrayOfByte1.length);
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfByte2.length)
      {
        this.log.fine(CLASS_NAME, "write", "529", new Object[] { paramMqttWireMessage });
        return;
      }
      int j = Math.min(1024, arrayOfByte2.length - i);
      this.out.write(arrayOfByte2, i, j);
      i += 1024;
      this.clientState.notifySentBytes(j);
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.out.write(paramArrayOfByte);
    this.clientState.notifySentBytes(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.clientState.notifySentBytes(paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */