package io.netty.handler.codec.http2;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.util.AsciiString;
import java.util.Arrays;
import java.util.List;

final class HpackStaticTable
{
  private static final CharSequenceMap<Integer> STATIC_INDEX_BY_NAME;
  private static final List<HpackHeaderField> STATIC_TABLE;
  static final int length;
  
  static
  {
    List localList = Arrays.asList(new HpackHeaderField[] { newEmptyHeaderField(":authority"), newHeaderField(":method", "GET"), newHeaderField(":method", "POST"), newHeaderField(":path", "/"), newHeaderField(":path", "/index.html"), newHeaderField(":scheme", "http"), newHeaderField(":scheme", "https"), newHeaderField(":status", "200"), newHeaderField(":status", "204"), newHeaderField(":status", "206"), newHeaderField(":status", "304"), newHeaderField(":status", "400"), newHeaderField(":status", "404"), newHeaderField(":status", "500"), newEmptyHeaderField("accept-charset"), newHeaderField("accept-encoding", "gzip, deflate"), newEmptyHeaderField("accept-language"), newEmptyHeaderField("accept-ranges"), newEmptyHeaderField("accept"), newEmptyHeaderField("access-control-allow-origin"), newEmptyHeaderField("age"), newEmptyHeaderField("allow"), newEmptyHeaderField("authorization"), newEmptyHeaderField("cache-control"), newEmptyHeaderField("content-disposition"), newEmptyHeaderField("content-encoding"), newEmptyHeaderField("content-language"), newEmptyHeaderField("content-length"), newEmptyHeaderField("content-location"), newEmptyHeaderField("content-range"), newEmptyHeaderField("content-type"), newEmptyHeaderField("cookie"), newEmptyHeaderField("date"), newEmptyHeaderField("etag"), newEmptyHeaderField("expect"), newEmptyHeaderField("expires"), newEmptyHeaderField("from"), newEmptyHeaderField("host"), newEmptyHeaderField("if-match"), newEmptyHeaderField("if-modified-since"), newEmptyHeaderField("if-none-match"), newEmptyHeaderField("if-range"), newEmptyHeaderField("if-unmodified-since"), newEmptyHeaderField("last-modified"), newEmptyHeaderField("link"), newEmptyHeaderField("location"), newEmptyHeaderField("max-forwards"), newEmptyHeaderField("proxy-authenticate"), newEmptyHeaderField("proxy-authorization"), newEmptyHeaderField("range"), newEmptyHeaderField("referer"), newEmptyHeaderField("refresh"), newEmptyHeaderField("retry-after"), newEmptyHeaderField("server"), newEmptyHeaderField("set-cookie"), newEmptyHeaderField("strict-transport-security"), newEmptyHeaderField("transfer-encoding"), newEmptyHeaderField("user-agent"), newEmptyHeaderField("vary"), newEmptyHeaderField("via"), newEmptyHeaderField("www-authenticate") });
    STATIC_TABLE = localList;
    STATIC_INDEX_BY_NAME = createMap();
    length = localList.size();
  }
  
  private static CharSequenceMap<Integer> createMap()
  {
    int i = STATIC_TABLE.size();
    CharSequenceMap localCharSequenceMap = new CharSequenceMap(true, UnsupportedValueConverter.instance(), i);
    while (i > 0)
    {
      localCharSequenceMap.set(getEntry(i).name, Integer.valueOf(i));
      i--;
    }
    return localCharSequenceMap;
  }
  
  static HpackHeaderField getEntry(int paramInt)
  {
    return (HpackHeaderField)STATIC_TABLE.get(paramInt - 1);
  }
  
  static int getIndex(CharSequence paramCharSequence)
  {
    paramCharSequence = (Integer)STATIC_INDEX_BY_NAME.get(paramCharSequence);
    if (paramCharSequence == null) {
      return -1;
    }
    return paramCharSequence.intValue();
  }
  
  static int getIndexInsensitive(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = getIndex(paramCharSequence1);
    int j = i;
    if (i == -1) {
      return -1;
    }
    while (j <= length)
    {
      HpackHeaderField localHpackHeaderField = getEntry(j);
      if ((HpackUtil.equalsVariableTime(paramCharSequence1, localHpackHeaderField.name)) && (HpackUtil.equalsVariableTime(paramCharSequence2, localHpackHeaderField.value))) {
        return j;
      }
      j++;
    }
    return -1;
  }
  
  private static HpackHeaderField newEmptyHeaderField(String paramString)
  {
    return new HpackHeaderField(AsciiString.cached(paramString), AsciiString.EMPTY_STRING);
  }
  
  private static HpackHeaderField newHeaderField(String paramString1, String paramString2)
  {
    return new HpackHeaderField(AsciiString.cached(paramString1), AsciiString.cached(paramString2));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HpackStaticTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */