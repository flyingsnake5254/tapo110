package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

class ExtendedByteArrayOutputStream
  extends ByteArrayOutputStream
{
  final WebSocketNetworkModule webSocketNetworkModule;
  final WebSocketSecureNetworkModule webSocketSecureNetworkModule;
  
  ExtendedByteArrayOutputStream(WebSocketNetworkModule paramWebSocketNetworkModule)
  {
    this.webSocketNetworkModule = paramWebSocketNetworkModule;
    this.webSocketSecureNetworkModule = null;
  }
  
  ExtendedByteArrayOutputStream(WebSocketSecureNetworkModule paramWebSocketSecureNetworkModule)
  {
    this.webSocketNetworkModule = null;
    this.webSocketSecureNetworkModule = paramWebSocketSecureNetworkModule;
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      Object localObject1 = ByteBuffer.wrap(toByteArray());
      reset();
      localObject1 = new WebSocketFrame((byte)2, true, ((ByteBuffer)localObject1).array()).encodeFrame();
      getSocketOutputStream().write((byte[])localObject1);
      getSocketOutputStream().flush();
      return;
    }
    finally {}
  }
  
  OutputStream getSocketOutputStream()
    throws IOException
  {
    Object localObject = this.webSocketNetworkModule;
    if (localObject != null) {
      return ((WebSocketNetworkModule)localObject).getSocketOutputStream();
    }
    localObject = this.webSocketSecureNetworkModule;
    if (localObject != null) {
      return ((WebSocketSecureNetworkModule)localObject).getSocketOutputStream();
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\ExtendedByteArrayOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */