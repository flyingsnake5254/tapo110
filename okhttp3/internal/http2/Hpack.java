package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Hpack
{
  static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_5_BITS = 31;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  static final Header[] STATIC_HEADER_TABLE;
  
  static
  {
    Header localHeader1 = new Header(Header.TARGET_AUTHORITY, "");
    Object localObject1 = Header.TARGET_METHOD;
    Header localHeader2 = new Header((ByteString)localObject1, "GET");
    Header localHeader3 = new Header((ByteString)localObject1, "POST");
    Object localObject2 = Header.TARGET_PATH;
    localObject1 = new Header((ByteString)localObject2, "/");
    Header localHeader4 = new Header((ByteString)localObject2, "/index.html");
    Object localObject3 = Header.TARGET_SCHEME;
    localObject2 = new Header((ByteString)localObject3, "http");
    localObject3 = new Header((ByteString)localObject3, "https");
    ByteString localByteString = Header.RESPONSE_STATUS;
    STATIC_HEADER_TABLE = new Header[] { localHeader1, localHeader2, localHeader3, localObject1, localHeader4, localObject2, localObject3, new Header(localByteString, "200"), new Header(localByteString, "204"), new Header(localByteString, "206"), new Header(localByteString, "304"), new Header(localByteString, "400"), new Header(localByteString, "404"), new Header(localByteString, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "") };
  }
  
  static ByteString checkLowercase(ByteString paramByteString)
    throws IOException
  {
    int i = paramByteString.size();
    for (int j = 0; j < i; j++)
    {
      int k = paramByteString.getByte(j);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramByteString.utf8());
        throw new IOException(localStringBuilder.toString());
      }
    }
    return paramByteString;
  }
  
  private static Map<ByteString, Integer> nameToFirstIndex()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    for (int i = 0;; i++)
    {
      Header[] arrayOfHeader = STATIC_HEADER_TABLE;
      if (i >= arrayOfHeader.length) {
        break;
      }
      if (!localLinkedHashMap.containsKey(arrayOfHeader[i].name)) {
        localLinkedHashMap.put(arrayOfHeader[i].name, Integer.valueOf(i));
      }
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static final class Reader
  {
    Header[] dynamicTable;
    int dynamicTableByteCount;
    int headerCount;
    private final List<Header> headerList = new ArrayList();
    private final int headerTableSizeSetting;
    private int maxDynamicTableByteCount;
    int nextHeaderIndex;
    private final BufferedSource source;
    
    Reader(int paramInt1, int paramInt2, Source paramSource)
    {
      Header[] arrayOfHeader = new Header[8];
      this.dynamicTable = arrayOfHeader;
      this.nextHeaderIndex = (arrayOfHeader.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
      this.headerTableSizeSetting = paramInt1;
      this.maxDynamicTableByteCount = paramInt2;
      this.source = Okio.buffer(paramSource);
    }
    
    Reader(int paramInt, Source paramSource)
    {
      this(paramInt, paramInt, paramSource);
    }
    
    private void adjustDynamicTableByteCount()
    {
      int i = this.maxDynamicTableByteCount;
      int j = this.dynamicTableByteCount;
      if (i < j) {
        if (i == 0) {
          clearDynamicTable();
        } else {
          evictToRecoverBytes(j - i);
        }
      }
    }
    
    private void clearDynamicTable()
    {
      Arrays.fill(this.dynamicTable, null);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }
    
    private int dynamicTableIndex(int paramInt)
    {
      return this.nextHeaderIndex + 1 + paramInt;
    }
    
    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      int j = 0;
      if (paramInt > 0)
      {
        i = this.dynamicTable.length - 1;
        int k = paramInt;
        paramInt = j;
        for (;;)
        {
          j = this.nextHeaderIndex;
          if ((i < j) || (k <= 0)) {
            break;
          }
          arrayOfHeader = this.dynamicTable;
          k -= arrayOfHeader[i].hpackSize;
          this.dynamicTableByteCount -= arrayOfHeader[i].hpackSize;
          this.headerCount -= 1;
          paramInt++;
          i--;
        }
        Header[] arrayOfHeader = this.dynamicTable;
        System.arraycopy(arrayOfHeader, j + 1, arrayOfHeader, j + 1 + paramInt, this.headerCount);
        this.nextHeaderIndex += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private ByteString getName(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt)) {
        return Hpack.STATIC_HEADER_TABLE[paramInt].name;
      }
      int i = dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length);
      if (i >= 0)
      {
        localObject = this.dynamicTable;
        if (i < localObject.length) {
          return localObject[i].name;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Header index too large ");
      ((StringBuilder)localObject).append(paramInt + 1);
      throw new IOException(((StringBuilder)localObject).toString());
    }
    
    private void insertIntoDynamicTable(int paramInt, Header paramHeader)
    {
      this.headerList.add(paramHeader);
      int i = paramHeader.hpackSize;
      int j = i;
      if (paramInt != -1) {
        j = i - this.dynamicTable[dynamicTableIndex(paramInt)].hpackSize;
      }
      i = this.maxDynamicTableByteCount;
      if (j > i)
      {
        clearDynamicTable();
        return;
      }
      i = evictToRecoverBytes(this.dynamicTableByteCount + j - i);
      if (paramInt == -1)
      {
        paramInt = this.headerCount;
        Header[] arrayOfHeader1 = this.dynamicTable;
        if (paramInt + 1 > arrayOfHeader1.length)
        {
          Header[] arrayOfHeader2 = new Header[arrayOfHeader1.length * 2];
          System.arraycopy(arrayOfHeader1, 0, arrayOfHeader2, arrayOfHeader1.length, arrayOfHeader1.length);
          this.nextHeaderIndex = (this.dynamicTable.length - 1);
          this.dynamicTable = arrayOfHeader2;
        }
        paramInt = this.nextHeaderIndex;
        this.nextHeaderIndex = (paramInt - 1);
        this.dynamicTable[paramInt] = paramHeader;
        this.headerCount += 1;
      }
      else
      {
        int k = dynamicTableIndex(paramInt);
        this.dynamicTable[(paramInt + (k + i))] = paramHeader;
      }
      this.dynamicTableByteCount += j;
    }
    
    private boolean isStaticHeader(int paramInt)
    {
      boolean bool = true;
      if ((paramInt < 0) || (paramInt > Hpack.STATIC_HEADER_TABLE.length - 1)) {
        bool = false;
      }
      return bool;
    }
    
    private int readByte()
      throws IOException
    {
      return this.source.readByte() & 0xFF;
    }
    
    private void readIndexedHeader(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt))
      {
        localObject = Hpack.STATIC_HEADER_TABLE[paramInt];
        this.headerList.add(localObject);
      }
      else
      {
        int i = dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length);
        if (i < 0) {
          break label68;
        }
        localObject = this.dynamicTable;
        if (i >= localObject.length) {
          break label68;
        }
        this.headerList.add(localObject[i]);
      }
      return;
      label68:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Header index too large ");
      ((StringBuilder)localObject).append(paramInt + 1);
      throw new IOException(((StringBuilder)localObject).toString());
    }
    
    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(getName(paramInt), readByteString()));
    }
    
    private void readLiteralHeaderWithIncrementalIndexingNewName()
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
    }
    
    private void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
      throws IOException
    {
      ByteString localByteString1 = getName(paramInt);
      ByteString localByteString2 = readByteString();
      this.headerList.add(new Header(localByteString1, localByteString2));
    }
    
    private void readLiteralHeaderWithoutIndexingNewName()
      throws IOException
    {
      ByteString localByteString1 = Hpack.checkLowercase(readByteString());
      ByteString localByteString2 = readByteString();
      this.headerList.add(new Header(localByteString1, localByteString2));
    }
    
    public List<Header> getAndResetHeaderList()
    {
      ArrayList localArrayList = new ArrayList(this.headerList);
      this.headerList.clear();
      return localArrayList;
    }
    
    int maxDynamicTableByteCount()
    {
      return this.maxDynamicTableByteCount;
    }
    
    ByteString readByteString()
      throws IOException
    {
      int i = readByte();
      int j;
      if ((i & 0x80) == 128) {
        j = 1;
      } else {
        j = 0;
      }
      i = readInt(i, 127);
      if (j != 0) {
        return ByteString.of(Huffman.get().decode(this.source.readByteArray(i)));
      }
      return this.source.readByteString(i);
    }
    
    void readHeaders()
      throws IOException
    {
      while (!this.source.exhausted())
      {
        int i = this.source.readByte() & 0xFF;
        if (i != 128)
        {
          if ((i & 0x80) == 128)
          {
            readIndexedHeader(readInt(i, 127) - 1);
          }
          else if (i == 64)
          {
            readLiteralHeaderWithIncrementalIndexingNewName();
          }
          else if ((i & 0x40) == 64)
          {
            readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
          }
          else if ((i & 0x20) == 32)
          {
            i = readInt(i, 31);
            this.maxDynamicTableByteCount = i;
            if ((i >= 0) && (i <= this.headerTableSizeSetting))
            {
              adjustDynamicTableByteCount();
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Invalid dynamic table size update ");
              localStringBuilder.append(this.maxDynamicTableByteCount);
              throw new IOException(localStringBuilder.toString());
            }
          }
          else if ((i != 16) && (i != 0))
          {
            readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
          }
          else
          {
            readLiteralHeaderWithoutIndexingNewName();
          }
        }
        else {
          throw new IOException("index == 0");
        }
      }
    }
    
    int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      int i;
      for (paramInt1 = 0;; paramInt1 += 7)
      {
        i = readByte();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
      }
      return paramInt2 + (i << paramInt1);
    }
  }
  
  static final class Writer
  {
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    Header[] dynamicTable;
    int dynamicTableByteCount;
    private boolean emitDynamicTableSizeUpdate;
    int headerCount;
    int headerTableSizeSetting;
    int maxDynamicTableByteCount;
    int nextHeaderIndex;
    private final Buffer out;
    private int smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
    private final boolean useCompression;
    
    Writer(int paramInt, boolean paramBoolean, Buffer paramBuffer)
    {
      Header[] arrayOfHeader = new Header[8];
      this.dynamicTable = arrayOfHeader;
      this.nextHeaderIndex = (arrayOfHeader.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
      this.headerTableSizeSetting = paramInt;
      this.maxDynamicTableByteCount = paramInt;
      this.useCompression = paramBoolean;
      this.out = paramBuffer;
    }
    
    Writer(Buffer paramBuffer)
    {
      this(4096, true, paramBuffer);
    }
    
    private void adjustDynamicTableByteCount()
    {
      int i = this.maxDynamicTableByteCount;
      int j = this.dynamicTableByteCount;
      if (i < j) {
        if (i == 0) {
          clearDynamicTable();
        } else {
          evictToRecoverBytes(j - i);
        }
      }
    }
    
    private void clearDynamicTable()
    {
      Arrays.fill(this.dynamicTable, null);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }
    
    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      int j = 0;
      if (paramInt > 0)
      {
        i = this.dynamicTable.length - 1;
        int k = paramInt;
        paramInt = j;
        for (;;)
        {
          j = this.nextHeaderIndex;
          if ((i < j) || (k <= 0)) {
            break;
          }
          arrayOfHeader = this.dynamicTable;
          k -= arrayOfHeader[i].hpackSize;
          this.dynamicTableByteCount -= arrayOfHeader[i].hpackSize;
          this.headerCount -= 1;
          paramInt++;
          i--;
        }
        Header[] arrayOfHeader = this.dynamicTable;
        System.arraycopy(arrayOfHeader, j + 1, arrayOfHeader, j + 1 + paramInt, this.headerCount);
        arrayOfHeader = this.dynamicTable;
        i = this.nextHeaderIndex;
        Arrays.fill(arrayOfHeader, i + 1, i + 1 + paramInt, null);
        this.nextHeaderIndex += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private void insertIntoDynamicTable(Header paramHeader)
    {
      int i = paramHeader.hpackSize;
      int j = this.maxDynamicTableByteCount;
      if (i > j)
      {
        clearDynamicTable();
        return;
      }
      evictToRecoverBytes(this.dynamicTableByteCount + i - j);
      j = this.headerCount;
      Header[] arrayOfHeader1 = this.dynamicTable;
      if (j + 1 > arrayOfHeader1.length)
      {
        Header[] arrayOfHeader2 = new Header[arrayOfHeader1.length * 2];
        System.arraycopy(arrayOfHeader1, 0, arrayOfHeader2, arrayOfHeader1.length, arrayOfHeader1.length);
        this.nextHeaderIndex = (this.dynamicTable.length - 1);
        this.dynamicTable = arrayOfHeader2;
      }
      j = this.nextHeaderIndex;
      this.nextHeaderIndex = (j - 1);
      this.dynamicTable[j] = paramHeader;
      this.headerCount += 1;
      this.dynamicTableByteCount += i;
    }
    
    void setHeaderTableSizeSetting(int paramInt)
    {
      this.headerTableSizeSetting = paramInt;
      paramInt = Math.min(paramInt, 16384);
      int i = this.maxDynamicTableByteCount;
      if (i == paramInt) {
        return;
      }
      if (paramInt < i) {
        this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, paramInt);
      }
      this.emitDynamicTableSizeUpdate = true;
      this.maxDynamicTableByteCount = paramInt;
      adjustDynamicTableByteCount();
    }
    
    void writeByteString(ByteString paramByteString)
      throws IOException
    {
      if ((this.useCompression) && (Huffman.get().encodedLength(paramByteString) < paramByteString.size()))
      {
        Buffer localBuffer = new Buffer();
        Huffman.get().encode(paramByteString, localBuffer);
        paramByteString = localBuffer.readByteString();
        writeInt(paramByteString.size(), 127, 128);
        this.out.write(paramByteString);
      }
      else
      {
        writeInt(paramByteString.size(), 127, 0);
        this.out.write(paramByteString);
      }
    }
    
    void writeHeaders(List<Header> paramList)
      throws IOException
    {
      int i;
      if (this.emitDynamicTableSizeUpdate)
      {
        i = this.smallestHeaderTableSizeSetting;
        if (i < this.maxDynamicTableByteCount) {
          writeInt(i, 31, 32);
        }
        this.emitDynamicTableSizeUpdate = false;
        this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        writeInt(this.maxDynamicTableByteCount, 31, 32);
      }
      int j = paramList.size();
      for (int k = 0; k < j; k++)
      {
        Header localHeader = (Header)paramList.get(k);
        ByteString localByteString1 = localHeader.name.toAsciiLowercase();
        ByteString localByteString2 = localHeader.value;
        Object localObject = (Integer)Hpack.NAME_TO_FIRST_INDEX.get(localByteString1);
        int m;
        if (localObject != null)
        {
          m = ((Integer)localObject).intValue() + 1;
          if ((m > 1) && (m < 8))
          {
            localObject = Hpack.STATIC_HEADER_TABLE;
            if (Util.equal(localObject[(m - 1)].value, localByteString2))
            {
              i = m;
              break label208;
            }
            if (Util.equal(localObject[m].value, localByteString2))
            {
              i = m;
              m++;
              break label208;
            }
          }
          i = m;
          m = -1;
        }
        else
        {
          m = -1;
          i = -1;
        }
        label208:
        int n = m;
        int i1 = i;
        if (m == -1)
        {
          int i2 = this.nextHeaderIndex + 1;
          int i3 = this.dynamicTable.length;
          for (;;)
          {
            n = m;
            i1 = i;
            if (i2 >= i3) {
              break;
            }
            i1 = i;
            if (Util.equal(this.dynamicTable[i2].name, localByteString1))
            {
              if (Util.equal(this.dynamicTable[i2].value, localByteString2))
              {
                m = this.nextHeaderIndex;
                n = Hpack.STATIC_HEADER_TABLE.length + (i2 - m);
                i1 = i;
                break;
              }
              i1 = i;
              if (i == -1) {
                i1 = i2 - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
              }
            }
            i2++;
            i = i1;
          }
        }
        if (n != -1)
        {
          writeInt(n, 127, 128);
        }
        else if (i1 == -1)
        {
          this.out.writeByte(64);
          writeByteString(localByteString1);
          writeByteString(localByteString2);
          insertIntoDynamicTable(localHeader);
        }
        else if ((localByteString1.startsWith(Header.PSEUDO_PREFIX)) && (!Header.TARGET_AUTHORITY.equals(localByteString1)))
        {
          writeInt(i1, 15, 0);
          writeByteString(localByteString2);
        }
        else
        {
          writeInt(i1, 63, 64);
          writeByteString(localByteString2);
          insertIntoDynamicTable(localHeader);
        }
      }
    }
    
    void writeInt(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.out.writeByte(paramInt1 | paramInt3);
        return;
      }
      this.out.writeByte(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.out.writeByte(0x80 | paramInt1 & 0x7F);
        paramInt1 >>>= 7;
      }
      this.out.writeByte(paramInt1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http2\Hpack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */