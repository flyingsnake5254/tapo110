package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

final class SpdyCodecUtil
{
  static final byte SPDY_DATA_FLAG_FIN = 1;
  static final int SPDY_DATA_FRAME = 0;
  static final byte[] SPDY_DICT = { 0, 0, 0, 7, 111, 112, 116, 105, 111, 110, 115, 0, 0, 0, 4, 104, 101, 97, 100, 0, 0, 0, 4, 112, 111, 115, 116, 0, 0, 0, 3, 112, 117, 116, 0, 0, 0, 6, 100, 101, 108, 101, 116, 101, 0, 0, 0, 5, 116, 114, 97, 99, 101, 0, 0, 0, 6, 97, 99, 99, 101, 112, 116, 0, 0, 0, 14, 97, 99, 99, 101, 112, 116, 45, 99, 104, 97, 114, 115, 101, 116, 0, 0, 0, 15, 97, 99, 99, 101, 112, 116, 45, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 15, 97, 99, 99, 101, 112, 116, 45, 108, 97, 110, 103, 117, 97, 103, 101, 0, 0, 0, 13, 97, 99, 99, 101, 112, 116, 45, 114, 97, 110, 103, 101, 115, 0, 0, 0, 3, 97, 103, 101, 0, 0, 0, 5, 97, 108, 108, 111, 119, 0, 0, 0, 13, 97, 117, 116, 104, 111, 114, 105, 122, 97, 116, 105, 111, 110, 0, 0, 0, 13, 99, 97, 99, 104, 101, 45, 99, 111, 110, 116, 114, 111, 108, 0, 0, 0, 10, 99, 111, 110, 110, 101, 99, 116, 105, 111, 110, 0, 0, 0, 12, 99, 111, 110, 116, 101, 110, 116, 45, 98, 97, 115, 101, 0, 0, 0, 16, 99, 111, 110, 116, 101, 110, 116, 45, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 16, 99, 111, 110, 116, 101, 110, 116, 45, 108, 97, 110, 103, 117, 97, 103, 101, 0, 0, 0, 14, 99, 111, 110, 116, 101, 110, 116, 45, 108, 101, 110, 103, 116, 104, 0, 0, 0, 16, 99, 111, 110, 116, 101, 110, 116, 45, 108, 111, 99, 97, 116, 105, 111, 110, 0, 0, 0, 11, 99, 111, 110, 116, 101, 110, 116, 45, 109, 100, 53, 0, 0, 0, 13, 99, 111, 110, 116, 101, 110, 116, 45, 114, 97, 110, 103, 101, 0, 0, 0, 12, 99, 111, 110, 116, 101, 110, 116, 45, 116, 121, 112, 101, 0, 0, 0, 4, 100, 97, 116, 101, 0, 0, 0, 4, 101, 116, 97, 103, 0, 0, 0, 6, 101, 120, 112, 101, 99, 116, 0, 0, 0, 7, 101, 120, 112, 105, 114, 101, 115, 0, 0, 0, 4, 102, 114, 111, 109, 0, 0, 0, 4, 104, 111, 115, 116, 0, 0, 0, 8, 105, 102, 45, 109, 97, 116, 99, 104, 0, 0, 0, 17, 105, 102, 45, 109, 111, 100, 105, 102, 105, 101, 100, 45, 115, 105, 110, 99, 101, 0, 0, 0, 13, 105, 102, 45, 110, 111, 110, 101, 45, 109, 97, 116, 99, 104, 0, 0, 0, 8, 105, 102, 45, 114, 97, 110, 103, 101, 0, 0, 0, 19, 105, 102, 45, 117, 110, 109, 111, 100, 105, 102, 105, 101, 100, 45, 115, 105, 110, 99, 101, 0, 0, 0, 13, 108, 97, 115, 116, 45, 109, 111, 100, 105, 102, 105, 101, 100, 0, 0, 0, 8, 108, 111, 99, 97, 116, 105, 111, 110, 0, 0, 0, 12, 109, 97, 120, 45, 102, 111, 114, 119, 97, 114, 100, 115, 0, 0, 0, 6, 112, 114, 97, 103, 109, 97, 0, 0, 0, 18, 112, 114, 111, 120, 121, 45, 97, 117, 116, 104, 101, 110, 116, 105, 99, 97, 116, 101, 0, 0, 0, 19, 112, 114, 111, 120, 121, 45, 97, 117, 116, 104, 111, 114, 105, 122, 97, 116, 105, 111, 110, 0, 0, 0, 5, 114, 97, 110, 103, 101, 0, 0, 0, 7, 114, 101, 102, 101, 114, 101, 114, 0, 0, 0, 11, 114, 101, 116, 114, 121, 45, 97, 102, 116, 101, 114, 0, 0, 0, 6, 115, 101, 114, 118, 101, 114, 0, 0, 0, 2, 116, 101, 0, 0, 0, 7, 116, 114, 97, 105, 108, 101, 114, 0, 0, 0, 17, 116, 114, 97, 110, 115, 102, 101, 114, 45, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 7, 117, 112, 103, 114, 97, 100, 101, 0, 0, 0, 10, 117, 115, 101, 114, 45, 97, 103, 101, 110, 116, 0, 0, 0, 4, 118, 97, 114, 121, 0, 0, 0, 3, 118, 105, 97, 0, 0, 0, 7, 119, 97, 114, 110, 105, 110, 103, 0, 0, 0, 16, 119, 119, 119, 45, 97, 117, 116, 104, 101, 110, 116, 105, 99, 97, 116, 101, 0, 0, 0, 6, 109, 101, 116, 104, 111, 100, 0, 0, 0, 3, 103, 101, 116, 0, 0, 0, 6, 115, 116, 97, 116, 117, 115, 0, 0, 0, 6, 50, 48, 48, 32, 79, 75, 0, 0, 0, 7, 118, 101, 114, 115, 105, 111, 110, 0, 0, 0, 8, 72, 84, 84, 80, 47, 49, 46, 49, 0, 0, 0, 3, 117, 114, 108, 0, 0, 0, 6, 112, 117, 98, 108, 105, 99, 0, 0, 0, 10, 115, 101, 116, 45, 99, 111, 111, 107, 105, 101, 0, 0, 0, 10, 107, 101, 101, 112, 45, 97, 108, 105, 118, 101, 0, 0, 0, 6, 111, 114, 105, 103, 105, 110, 49, 48, 48, 49, 48, 49, 50, 48, 49, 50, 48, 50, 50, 48, 53, 50, 48, 54, 51, 48, 48, 51, 48, 50, 51, 48, 51, 51, 48, 52, 51, 48, 53, 51, 48, 54, 51, 48, 55, 52, 48, 50, 52, 48, 53, 52, 48, 54, 52, 48, 55, 52, 48, 56, 52, 48, 57, 52, 49, 48, 52, 49, 49, 52, 49, 50, 52, 49, 51, 52, 49, 52, 52, 49, 53, 52, 49, 54, 52, 49, 55, 53, 48, 50, 53, 48, 52, 53, 48, 53, 50, 48, 51, 32, 78, 111, 110, 45, 65, 117, 116, 104, 111, 114, 105, 116, 97, 116, 105, 118, 101, 32, 73, 110, 102, 111, 114, 109, 97, 116, 105, 111, 110, 50, 48, 52, 32, 78, 111, 32, 67, 111, 110, 116, 101, 110, 116, 51, 48, 49, 32, 77, 111, 118, 101, 100, 32, 80, 101, 114, 109, 97, 110, 101, 110, 116, 108, 121, 52, 48, 48, 32, 66, 97, 100, 32, 82, 101, 113, 117, 101, 115, 116, 52, 48, 49, 32, 85, 110, 97, 117, 116, 104, 111, 114, 105, 122, 101, 100, 52, 48, 51, 32, 70, 111, 114, 98, 105, 100, 100, 101, 110, 52, 48, 52, 32, 78, 111, 116, 32, 70, 111, 117, 110, 100, 53, 48, 48, 32, 73, 110, 116, 101, 114, 110, 97, 108, 32, 83, 101, 114, 118, 101, 114, 32, 69, 114, 114, 111, 114, 53, 48, 49, 32, 78, 111, 116, 32, 73, 109, 112, 108, 101, 109, 101, 110, 116, 101, 100, 53, 48, 51, 32, 83, 101, 114, 118, 105, 99, 101, 32, 85, 110, 97, 118, 97, 105, 108, 97, 98, 108, 101, 74, 97, 110, 32, 70, 101, 98, 32, 77, 97, 114, 32, 65, 112, 114, 32, 77, 97, 121, 32, 74, 117, 110, 32, 74, 117, 108, 32, 65, 117, 103, 32, 83, 101, 112, 116, 32, 79, 99, 116, 32, 78, 111, 118, 32, 68, 101, 99, 32, 48, 48, 58, 48, 48, 58, 48, 48, 32, 77, 111, 110, 44, 32, 84, 117, 101, 44, 32, 87, 101, 100, 44, 32, 84, 104, 117, 44, 32, 70, 114, 105, 44, 32, 83, 97, 116, 44, 32, 83, 117, 110, 44, 32, 71, 77, 84, 99, 104, 117, 110, 107, 101, 100, 44, 116, 101, 120, 116, 47, 104, 116, 109, 108, 44, 105, 109, 97, 103, 101, 47, 112, 110, 103, 44, 105, 109, 97, 103, 101, 47, 106, 112, 103, 44, 105, 109, 97, 103, 101, 47, 103, 105, 102, 44, 97, 112, 112, 108, 105, 99, 97, 116, 105, 111, 110, 47, 120, 109, 108, 44, 97, 112, 112, 108, 105, 99, 97, 116, 105, 111, 110, 47, 120, 104, 116, 109, 108, 43, 120, 109, 108, 44, 116, 101, 120, 116, 47, 112, 108, 97, 105, 110, 44, 116, 101, 120, 116, 47, 106, 97, 118, 97, 115, 99, 114, 105, 112, 116, 44, 112, 117, 98, 108, 105, 99, 112, 114, 105, 118, 97, 116, 101, 109, 97, 120, 45, 97, 103, 101, 61, 103, 122, 105, 112, 44, 100, 101, 102, 108, 97, 116, 101, 44, 115, 100, 99, 104, 99, 104, 97, 114, 115, 101, 116, 61, 117, 116, 102, 45, 56, 99, 104, 97, 114, 115, 101, 116, 61, 105, 115, 111, 45, 56, 56, 53, 57, 45, 49, 44, 117, 116, 102, 45, 44, 42, 44, 101, 110, 113, 61, 48, 46 };
  static final byte SPDY_FLAG_FIN = 1;
  static final byte SPDY_FLAG_UNIDIRECTIONAL = 2;
  static final int SPDY_GOAWAY_FRAME = 7;
  static final int SPDY_HEADERS_FRAME = 8;
  static final int SPDY_HEADER_FLAGS_OFFSET = 4;
  static final int SPDY_HEADER_LENGTH_OFFSET = 5;
  static final int SPDY_HEADER_SIZE = 8;
  static final int SPDY_HEADER_TYPE_OFFSET = 2;
  static final int SPDY_MAX_LENGTH = 16777215;
  static final int SPDY_MAX_NV_LENGTH = 65535;
  static final int SPDY_PING_FRAME = 6;
  static final int SPDY_PUSH_PROMISE_FRAME = 5;
  static final int SPDY_RST_STREAM_FRAME = 3;
  static final int SPDY_SESSION_STREAM_ID = 0;
  static final byte SPDY_SETTINGS_CLEAR = 1;
  static final int SPDY_SETTINGS_FRAME = 4;
  static final int SPDY_SETTINGS_MAX_ID = 16777215;
  static final byte SPDY_SETTINGS_PERSISTED = 2;
  static final byte SPDY_SETTINGS_PERSIST_VALUE = 1;
  static final int SPDY_SYN_REPLY_FRAME = 2;
  static final int SPDY_SYN_STREAM_FRAME = 1;
  static final int SPDY_WINDOW_UPDATE_FRAME = 9;
  
  static int getSignedInt(ByteBuf paramByteBuf, int paramInt)
  {
    int i = paramByteBuf.getByte(paramInt);
    int j = paramByteBuf.getByte(paramInt + 1);
    int k = paramByteBuf.getByte(paramInt + 2);
    return paramByteBuf.getByte(paramInt + 3) & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  static int getUnsignedInt(ByteBuf paramByteBuf, int paramInt)
  {
    int i = paramByteBuf.getByte(paramInt);
    int j = paramByteBuf.getByte(paramInt + 1);
    int k = paramByteBuf.getByte(paramInt + 2);
    return paramByteBuf.getByte(paramInt + 3) & 0xFF | (i & 0x7F) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  static int getUnsignedMedium(ByteBuf paramByteBuf, int paramInt)
  {
    int i = paramByteBuf.getByte(paramInt);
    int j = paramByteBuf.getByte(paramInt + 1);
    return paramByteBuf.getByte(paramInt + 2) & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  static int getUnsignedShort(ByteBuf paramByteBuf, int paramInt)
  {
    int i = paramByteBuf.getByte(paramInt);
    return paramByteBuf.getByte(paramInt + 1) & 0xFF | (i & 0xFF) << 8;
  }
  
  static boolean isServerId(int paramInt)
  {
    boolean bool;
    if (paramInt % 2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static void validateHeaderName(CharSequence paramCharSequence)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "name");
    if (paramCharSequence.length() != 0)
    {
      if (paramCharSequence.length() <= 65535)
      {
        int i = 0;
        while (i < paramCharSequence.length())
        {
          int j = paramCharSequence.charAt(i);
          if (j != 0)
          {
            if ((j >= 65) && (j <= 90)) {
              throw new IllegalArgumentException("name must be all lower case.");
            }
            if (j <= 127)
            {
              i++;
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("name contains non-ascii character: ");
              localStringBuilder.append(paramCharSequence);
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("name contains null character: ");
            localStringBuilder.append(paramCharSequence);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
        }
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("name exceeds allowable length: ");
      localStringBuilder.append(paramCharSequence);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("name cannot be length zero");
  }
  
  static void validateHeaderValue(CharSequence paramCharSequence)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "value");
    int i = 0;
    while (i < paramCharSequence.length()) {
      if (paramCharSequence.charAt(i) != 0)
      {
        i++;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("value contains null character: ");
        localStringBuilder.append(paramCharSequence);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyCodecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */