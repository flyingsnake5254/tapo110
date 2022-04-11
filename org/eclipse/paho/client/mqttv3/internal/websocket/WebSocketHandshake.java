package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

public class WebSocketHandshake
{
  private static final String ACCEPT_SALT = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  private static final String EMPTY = "";
  private static final String HTTP_HEADER_CONNECTION = "connection";
  private static final String HTTP_HEADER_CONNECTION_VALUE = "upgrade";
  private static final String HTTP_HEADER_SEC_WEBSOCKET_ACCEPT = "sec-websocket-accept";
  private static final String HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";
  private static final String HTTP_HEADER_UPGRADE = "upgrade";
  private static final String HTTP_HEADER_UPGRADE_WEBSOCKET = "websocket";
  private static final String LINE_SEPARATOR = "\r\n";
  private static final String SHA1_PROTOCOL = "SHA1";
  Properties customWebSocketHeaders;
  String host;
  InputStream input;
  OutputStream output;
  int port;
  String uri;
  
  public WebSocketHandshake(InputStream paramInputStream, OutputStream paramOutputStream, String paramString1, String paramString2, int paramInt, Properties paramProperties)
  {
    this.input = paramInputStream;
    this.output = paramOutputStream;
    this.uri = paramString1;
    this.host = paramString2;
    this.port = paramInt;
    this.customWebSocketHeaders = paramProperties;
  }
  
  private Map<String, String> getHeaders(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    for (int i = 1;; i++)
    {
      if (i >= paramArrayList.size()) {
        return localHashMap;
      }
      String[] arrayOfString = ((String)paramArrayList.get(i)).split(":");
      localHashMap.put(arrayOfString[0].toLowerCase(), arrayOfString[1]);
    }
  }
  
  private void receiveHandshakeResponse(String paramString)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.input));
    Object localObject1 = new ArrayList();
    Object localObject2 = localBufferedReader.readLine();
    if (localObject2 != null) {
      for (;;)
      {
        if (((String)localObject2).equals(""))
        {
          localObject2 = getHeaders((ArrayList)localObject1);
          localObject1 = (String)((Map)localObject2).get("connection");
          if ((localObject1 != null) && (!((String)localObject1).equalsIgnoreCase("upgrade")))
          {
            localObject1 = (String)((Map)localObject2).get("upgrade");
            if ((localObject1 != null) && (((String)localObject1).toLowerCase().contains("websocket")))
            {
              if ((String)((Map)localObject2).get("sec-websocket-protocol") != null)
              {
                if (((Map)localObject2).containsKey("sec-websocket-accept")) {
                  try
                  {
                    verifyWebSocketKey(paramString, (String)((Map)localObject2).get("sec-websocket-accept"));
                    return;
                  }
                  catch (HandshakeFailedException paramString)
                  {
                    throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
                  }
                  catch (NoSuchAlgorithmException paramString)
                  {
                    throw new IOException(paramString.getMessage());
                  }
                }
                throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
              }
              throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
            }
            throw new IOException("WebSocket Response header: Incorrect upgrade.");
          }
          throw new IOException("WebSocket Response header: Incorrect connection header");
        }
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = localBufferedReader.readLine();
      }
    }
    throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
  }
  
  private void sendHandshakeRequest(String paramString)
    throws IOException
  {
    Object localObject1 = "/mqtt";
    try
    {
      URI localURI = new java/net/URI;
      localURI.<init>(this.uri);
      Object localObject2 = localObject1;
      if (localURI.getRawPath() != null)
      {
        localObject2 = localObject1;
        if (!localURI.getRawPath().isEmpty())
        {
          localObject1 = localURI.getRawPath();
          localObject2 = localObject1;
          if (localURI.getRawQuery() != null)
          {
            localObject2 = localObject1;
            if (!localURI.getRawQuery().isEmpty())
            {
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>(String.valueOf(localObject1));
              ((StringBuilder)localObject2).append("?");
              ((StringBuilder)localObject2).append(localURI.getRawQuery());
              localObject2 = ((StringBuilder)localObject2).toString();
            }
          }
        }
      }
      localObject1 = new java/io/PrintWriter;
      ((PrintWriter)localObject1).<init>(this.output);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("GET ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" HTTP/1.1");
      localStringBuilder.append("\r\n");
      ((PrintWriter)localObject1).print(localStringBuilder.toString());
      int i = this.port;
      if (i != 80)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("Host: ");
        ((StringBuilder)localObject2).append(this.host);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(this.port);
        ((StringBuilder)localObject2).append("\r\n");
        ((PrintWriter)localObject1).print(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("Host: ");
        ((StringBuilder)localObject2).append(this.host);
        ((StringBuilder)localObject2).append("\r\n");
        ((PrintWriter)localObject1).print(((StringBuilder)localObject2).toString());
      }
      ((PrintWriter)localObject1).print("Upgrade: websocket\r\n");
      ((PrintWriter)localObject1).print("Connection: Upgrade\r\n");
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("Sec-WebSocket-Key: ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("\r\n");
      ((PrintWriter)localObject1).print(((StringBuilder)localObject2).toString());
      ((PrintWriter)localObject1).print("Sec-WebSocket-Protocol: mqtt\r\n");
      ((PrintWriter)localObject1).print("Sec-WebSocket-Version: 13\r\n");
      paramString = this.customWebSocketHeaders;
      if (paramString != null)
      {
        Iterator localIterator = paramString.keySet().iterator();
        while (localIterator.hasNext())
        {
          paramString = (String)localIterator.next();
          localObject2 = this.customWebSocketHeaders.getProperty(paramString);
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(String.valueOf(paramString));
          localStringBuilder.append(": ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("\r\n");
          ((PrintWriter)localObject1).print(localStringBuilder.toString());
        }
      }
      paramString = localURI.getUserInfo();
      if (paramString != null)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("Authorization: Basic ");
        ((StringBuilder)localObject2).append(Base64.encode(paramString));
        ((StringBuilder)localObject2).append("\r\n");
        ((PrintWriter)localObject1).print(((StringBuilder)localObject2).toString());
      }
      ((PrintWriter)localObject1).print("\r\n");
      ((PrintWriter)localObject1).flush();
      return;
    }
    catch (URISyntaxException paramString)
    {
      throw new IllegalStateException(paramString.getMessage());
    }
  }
  
  private byte[] sha1(String paramString)
    throws NoSuchAlgorithmException
  {
    return MessageDigest.getInstance("SHA1").digest(paramString.getBytes());
  }
  
  private void verifyWebSocketKey(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, HandshakeFailedException
  {
    paramString1 = new StringBuilder(String.valueOf(paramString1));
    paramString1.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    if (Base64.encodeBytes(sha1(paramString1.toString())).trim().equals(paramString2.trim())) {
      return;
    }
    throw new HandshakeFailedException();
  }
  
  public void execute()
    throws IOException
  {
    Object localObject = new byte[16];
    System.arraycopy(UUID.randomUUID().toString().getBytes(), 0, localObject, 0, 16);
    localObject = Base64.encodeBytes((byte[])localObject);
    sendHandshakeRequest((String)localObject);
    receiveHandshakeResponse((String)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\WebSocketHandshake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */