package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2
{
  static final String[] BINARY;
  static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final String[] FLAGS;
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PADDED = 8;
  static final byte FLAG_PRIORITY = 32;
  private static final String[] FRAME_NAMES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;
  
  static
  {
    FLAGS = new String[64];
    BINARY = new String['Ā'];
    int i = 0;
    for (int j = 0;; j++)
    {
      localObject = BINARY;
      if (j >= localObject.length) {
        break;
      }
      localObject[j] = Util.format("%8s", new Object[] { Integer.toBinaryString(j) }).replace(' ', '0');
    }
    String[] arrayOfString = FLAGS;
    arrayOfString[0] = "";
    arrayOfString[1] = "END_STREAM";
    Object localObject = new int[1];
    localObject[0] = 1;
    arrayOfString[8] = "PADDED";
    int k;
    StringBuilder localStringBuilder;
    for (j = 0; j < 1; j++)
    {
      k = localObject[j];
      arrayOfString = FLAGS;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(arrayOfString[k]);
      localStringBuilder.append("|PADDED");
      arrayOfString[(k | 0x8)] = localStringBuilder.toString();
    }
    arrayOfString = FLAGS;
    arrayOfString[4] = "END_HEADERS";
    arrayOfString[32] = "PRIORITY";
    arrayOfString[36] = "END_HEADERS|PRIORITY";
    for (j = 0;; j++)
    {
      k = i;
      if (j >= 3) {
        break;
      }
      int m = new int[] { 4, 32, 36 }[j];
      for (k = 0; k < 1; k++)
      {
        int n = localObject[k];
        arrayOfString = FLAGS;
        int i1 = n | m;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[n]);
        localStringBuilder.append('|');
        localStringBuilder.append(arrayOfString[m]);
        arrayOfString[i1] = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[n]);
        localStringBuilder.append('|');
        localStringBuilder.append(arrayOfString[m]);
        localStringBuilder.append("|PADDED");
        arrayOfString[(i1 | 0x8)] = localStringBuilder.toString();
      }
    }
    for (;;)
    {
      localObject = FLAGS;
      if (k >= localObject.length) {
        break;
      }
      if (localObject[k] == null) {
        localObject[k] = BINARY[k];
      }
      k++;
    }
  }
  
  static String formatFlags(byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 0) {
      return "";
    }
    if ((paramByte1 != 2) && (paramByte1 != 3))
    {
      Object localObject;
      if ((paramByte1 != 4) && (paramByte1 != 6))
      {
        if ((paramByte1 != 7) && (paramByte1 != 8))
        {
          localObject = FLAGS;
          if (paramByte2 < localObject.length) {
            localObject = localObject[paramByte2];
          } else {
            localObject = BINARY[paramByte2];
          }
          if ((paramByte1 == 5) && ((paramByte2 & 0x4) != 0)) {
            return ((String)localObject).replace("HEADERS", "PUSH_PROMISE");
          }
          if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
            return ((String)localObject).replace("PRIORITY", "COMPRESSED");
          }
          return (String)localObject;
        }
      }
      else
      {
        if (paramByte2 == 1) {
          localObject = "ACK";
        } else {
          localObject = BINARY[paramByte2];
        }
        return (String)localObject;
      }
    }
    return BINARY[paramByte2];
  }
  
  static String frameLog(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    Object localObject = FRAME_NAMES;
    if (paramByte1 < localObject.length) {
      localObject = localObject[paramByte1];
    } else {
      localObject = Util.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
    }
    String str1 = formatFlags(paramByte1, paramByte2);
    String str2;
    if (paramBoolean) {
      str2 = "<<";
    } else {
      str2 = ">>";
    }
    return Util.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject, str1 });
  }
  
  static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(Util.format(paramString, paramVarArgs));
  }
  
  static IOException ioException(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(Util.format(paramString, paramVarArgs));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http2\Http2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */