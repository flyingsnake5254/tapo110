package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class WebSocketReader
{
  boolean closed;
  private final Buffer controlFrameBuffer = new Buffer();
  final FrameCallback frameCallback;
  long frameLength;
  final boolean isClient;
  boolean isControlFrame;
  boolean isFinalFrame;
  private final Buffer.UnsafeCursor maskCursor;
  private final byte[] maskKey;
  private final Buffer messageFrameBuffer = new Buffer();
  int opcode;
  final BufferedSource source;
  
  WebSocketReader(boolean paramBoolean, BufferedSource paramBufferedSource, FrameCallback paramFrameCallback)
  {
    Objects.requireNonNull(paramBufferedSource, "source == null");
    Objects.requireNonNull(paramFrameCallback, "frameCallback == null");
    this.isClient = paramBoolean;
    this.source = paramBufferedSource;
    this.frameCallback = paramFrameCallback;
    paramFrameCallback = null;
    if (paramBoolean) {
      paramBufferedSource = null;
    } else {
      paramBufferedSource = new byte[4];
    }
    this.maskKey = paramBufferedSource;
    if (paramBoolean) {
      paramBufferedSource = paramFrameCallback;
    } else {
      paramBufferedSource = new Buffer.UnsafeCursor();
    }
    this.maskCursor = paramBufferedSource;
  }
  
  private void readControlFrame()
    throws IOException
  {
    long l = this.frameLength;
    if (l > 0L)
    {
      this.source.readFully(this.controlFrameBuffer, l);
      if (!this.isClient)
      {
        this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(0L);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
      }
    }
    Object localObject;
    switch (this.opcode)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown control opcode: ");
      ((StringBuilder)localObject).append(Integer.toHexString(this.opcode));
      throw new ProtocolException(((StringBuilder)localObject).toString());
    case 10: 
      this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
      break;
    case 9: 
      this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
      break;
    case 8: 
      int i = 1005;
      l = this.controlFrameBuffer.size();
      if (l == 1L) {
        break label265;
      }
      if (l != 0L)
      {
        i = this.controlFrameBuffer.readShort();
        localObject = this.controlFrameBuffer.readUtf8();
        String str = WebSocketProtocol.closeCodeExceptionMessage(i);
        if (str != null) {
          throw new ProtocolException(str);
        }
      }
      else
      {
        localObject = "";
      }
      this.frameCallback.onReadClose(i, (String)localObject);
      this.closed = true;
    }
    return;
    label265:
    throw new ProtocolException("Malformed close payload length of 1.");
  }
  
  private void readHeader()
    throws IOException
  {
    if (!this.closed)
    {
      long l = this.source.timeout().timeoutNanos();
      this.source.timeout().clearTimeout();
      try
      {
        int i = this.source.readByte();
        int j = i & 0xFF;
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
        this.opcode = (j & 0xF);
        boolean bool1 = true;
        boolean bool2;
        if ((j & 0x80) != 0) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.isFinalFrame = bool2;
        boolean bool3;
        if ((j & 0x8) != 0) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        this.isControlFrame = bool3;
        if ((bool3) && (!bool2)) {
          throw new ProtocolException("Control frames must be final.");
        }
        if ((j & 0x40) != 0) {
          i = 1;
        } else {
          i = 0;
        }
        int k;
        if ((j & 0x20) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        if ((j & 0x10) != 0) {
          j = 1;
        } else {
          j = 0;
        }
        if ((i == 0) && (k == 0) && (j == 0))
        {
          i = this.source.readByte() & 0xFF;
          if ((i & 0x80) != 0) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
          Object localObject1;
          if (bool2 == this.isClient)
          {
            if (this.isClient) {
              localObject1 = "Server-sent frames must not be masked.";
            } else {
              localObject1 = "Client-sent frames must be masked.";
            }
            throw new ProtocolException((String)localObject1);
          }
          l = i & 0x7F;
          this.frameLength = l;
          if (l == 126L)
          {
            this.frameLength = (this.source.readShort() & 0xFFFF);
          }
          else if (l == 127L)
          {
            l = this.source.readLong();
            this.frameLength = l;
            if (l < 0L)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Frame length 0x");
              ((StringBuilder)localObject1).append(Long.toHexString(this.frameLength));
              ((StringBuilder)localObject1).append(" > 0x7FFFFFFFFFFFFFFF");
              throw new ProtocolException(((StringBuilder)localObject1).toString());
            }
          }
          if ((this.isControlFrame) && (this.frameLength > 125L)) {
            throw new ProtocolException("Control frame must be less than 125B.");
          }
          if (bool2) {
            this.source.readFully(this.maskKey);
          }
          return;
        }
        throw new ProtocolException("Reserved flags are unsupported.");
      }
      finally
      {
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
      }
    }
    throw new IOException("closed");
  }
  
  private void readMessage()
    throws IOException
  {
    while (!this.closed)
    {
      long l = this.frameLength;
      if (l > 0L)
      {
        this.source.readFully(this.messageFrameBuffer, l);
        if (!this.isClient)
        {
          this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
          this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      if (this.isFinalFrame) {
        return;
      }
      readUntilNonControlFrame();
      if (this.opcode != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Expected continuation opcode. Got: ");
        localStringBuilder.append(Integer.toHexString(this.opcode));
        throw new ProtocolException(localStringBuilder.toString());
      }
    }
    throw new IOException("closed");
  }
  
  private void readMessageFrame()
    throws IOException
  {
    int i = this.opcode;
    if ((i != 1) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown opcode: ");
      localStringBuilder.append(Integer.toHexString(i));
      throw new ProtocolException(localStringBuilder.toString());
    }
    readMessage();
    if (i == 1) {
      this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
    } else {
      this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
    }
  }
  
  private void readUntilNonControlFrame()
    throws IOException
  {
    while (!this.closed)
    {
      readHeader();
      if (!this.isControlFrame) {
        break;
      }
      readControlFrame();
    }
  }
  
  void processNextFrame()
    throws IOException
  {
    readHeader();
    if (this.isControlFrame) {
      readControlFrame();
    } else {
      readMessageFrame();
    }
  }
  
  public static abstract interface FrameCallback
  {
    public abstract void onReadClose(int paramInt, String paramString);
    
    public abstract void onReadMessage(String paramString)
      throws IOException;
    
    public abstract void onReadMessage(ByteString paramByteString)
      throws IOException;
    
    public abstract void onReadPing(ByteString paramByteString);
    
    public abstract void onReadPong(ByteString paramByteString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\ws\WebSocketReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */