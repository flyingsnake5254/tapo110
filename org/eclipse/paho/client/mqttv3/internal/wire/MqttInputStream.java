package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.ClientState;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class MqttInputStream
  extends InputStream
{
  private final String CLASS_NAME;
  private ByteArrayOutputStream bais;
  private ClientState clientState;
  private DataInputStream in;
  private final Logger log;
  private byte[] packet;
  private int packetLen;
  private int remLen;
  
  public MqttInputStream(ClientState paramClientState, InputStream paramInputStream)
  {
    String str = MqttInputStream.class.getName();
    this.CLASS_NAME = str;
    this.log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", str);
    this.clientState = null;
    this.clientState = paramClientState;
    this.in = new DataInputStream(paramInputStream);
    this.bais = new ByteArrayOutputStream();
    this.remLen = -1;
  }
  
  private void readFully()
    throws IOException
  {
    int i = this.bais.size();
    int j = this.packetLen;
    int k = this.remLen - j;
    if (k >= 0)
    {
      int m = 0;
      for (;;)
      {
        if (m >= k) {
          return;
        }
        try
        {
          int n = this.in.read(this.packet, i + j + m, k - m);
          if (n >= 0)
          {
            this.clientState.notifyReceivedBytes(n);
            m += n;
          }
          else
          {
            throw new EOFException();
          }
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          this.packetLen += m;
          throw localSocketTimeoutException;
        }
      }
    }
    throw new IndexOutOfBoundsException();
  }
  
  public int available()
    throws IOException
  {
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    this.in.close();
  }
  
  public int read()
    throws IOException
  {
    return this.in.read();
  }
  
  public MqttWireMessage readMqttWireMessage()
    throws IOException, MqttException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    localObject4 = localObject1;
    try
    {
      if (this.remLen < 0)
      {
        localObject4 = localObject1;
        this.bais.reset();
        localObject4 = localObject1;
        int i = this.in.readByte();
        localObject4 = localObject1;
        this.clientState.notifyReceivedBytes(1);
        int j = (byte)(i >>> 4 & 0xF);
        if ((j >= 1) && (j <= 14))
        {
          localObject4 = localObject1;
          this.remLen = MqttWireMessage.readMBI(this.in).getValue();
          localObject4 = localObject1;
          this.bais.write(i);
          localObject4 = localObject1;
          this.bais.write(MqttWireMessage.encodeMBI(this.remLen));
          localObject4 = localObject1;
          this.packet = new byte[this.bais.size() + this.remLen];
          localObject4 = localObject1;
          this.packetLen = 0;
        }
        else
        {
          localObject4 = localObject1;
          throw ExceptionHelper.createMqttException(32108);
        }
      }
      localObject4 = localObject1;
      if (this.remLen >= 0)
      {
        localObject4 = localObject1;
        readFully();
        localObject4 = localObject1;
        this.remLen = -1;
        localObject4 = localObject1;
        localObject2 = this.bais.toByteArray();
        localObject4 = localObject1;
        System.arraycopy(localObject2, 0, this.packet, 0, localObject2.length);
        localObject4 = localObject1;
        localObject2 = MqttWireMessage.createWireMessage(this.packet);
        localObject4 = localObject2;
        this.log.fine(this.CLASS_NAME, "readMqttWireMessage", "301", new Object[] { localObject2 });
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      for (;;)
      {
        Object localObject3 = localObject4;
      }
    }
    return (MqttWireMessage)localObject2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */