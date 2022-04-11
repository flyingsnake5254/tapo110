package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

final class Utf8Validator
  implements ByteProcessor
{
  private static final byte[] STATES = { 0, 12, 24, 36, 60, 96, 84, 12, 12, 12, 48, 72, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 12, 12, 12, 12, 12, 0, 12, 0, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
  private static final byte[] TYPES = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
  private static final int UTF8_ACCEPT = 0;
  private static final int UTF8_REJECT = 12;
  private boolean checking;
  private int codep;
  private int state = 0;
  
  public void check(ByteBuf paramByteBuf)
  {
    this.checking = true;
    paramByteBuf.forEachByte(this);
  }
  
  public void finish()
  {
    this.checking = false;
    this.codep = 0;
    if (this.state == 0) {
      return;
    }
    this.state = 0;
    throw new CorruptedWebSocketFrameException(WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "bytes are not UTF-8");
  }
  
  public boolean isChecking()
  {
    return this.checking;
  }
  
  public boolean process(byte paramByte)
    throws Exception
  {
    int i = TYPES[(paramByte & 0xFF)];
    int j = this.state;
    if (j != 0) {
      paramByte = paramByte & 0x3F | this.codep << 6;
    } else {
      paramByte &= 255 >> i;
    }
    this.codep = paramByte;
    paramByte = STATES[(j + i)];
    this.state = paramByte;
    if (paramByte != 12) {
      return true;
    }
    this.checking = false;
    throw new CorruptedWebSocketFrameException(WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "bytes are not UTF-8");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\Utf8Validator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */