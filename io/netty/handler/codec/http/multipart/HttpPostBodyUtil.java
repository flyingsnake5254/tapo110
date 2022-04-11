package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;

final class HttpPostBodyUtil
{
  public static final String DEFAULT_BINARY_CONTENT_TYPE = "application/octet-stream";
  public static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain";
  public static final int chunkSize = 8096;
  
  static int findEndOfString(String paramString)
  {
    for (int i = paramString.length(); (i > 0) && (Character.isWhitespace(paramString.charAt(i - 1))); i--) {}
    return i;
  }
  
  static int findNonWhitespace(String paramString, int paramInt)
  {
    while ((paramInt < paramString.length()) && (Character.isWhitespace(paramString.charAt(paramInt)))) {
      paramInt++;
    }
    return paramInt;
  }
  
  static class SeekAheadOptimize
  {
    ByteBuf buffer;
    byte[] bytes;
    int limit;
    int origPos;
    int pos;
    int readerIndex;
    
    SeekAheadOptimize(ByteBuf paramByteBuf)
    {
      if (paramByteBuf.hasArray())
      {
        this.buffer = paramByteBuf;
        this.bytes = paramByteBuf.array();
        this.readerIndex = paramByteBuf.readerIndex();
        int i = paramByteBuf.arrayOffset() + this.readerIndex;
        this.pos = i;
        this.origPos = i;
        this.limit = (paramByteBuf.arrayOffset() + paramByteBuf.writerIndex());
        return;
      }
      throw new IllegalArgumentException("buffer hasn't backing byte array");
    }
    
    int getReadPosition(int paramInt)
    {
      return paramInt - this.origPos + this.readerIndex;
    }
    
    void setReadPosition(int paramInt)
    {
      paramInt = this.pos - paramInt;
      this.pos = paramInt;
      paramInt = getReadPosition(paramInt);
      this.readerIndex = paramInt;
      this.buffer.readerIndex(paramInt);
    }
  }
  
  public static enum TransferEncodingMechanism
  {
    private final String value;
    
    static
    {
      TransferEncodingMechanism localTransferEncodingMechanism1 = new TransferEncodingMechanism("BIT7", 0, "7bit");
      BIT7 = localTransferEncodingMechanism1;
      TransferEncodingMechanism localTransferEncodingMechanism2 = new TransferEncodingMechanism("BIT8", 1, "8bit");
      BIT8 = localTransferEncodingMechanism2;
      TransferEncodingMechanism localTransferEncodingMechanism3 = new TransferEncodingMechanism("BINARY", 2, "binary");
      BINARY = localTransferEncodingMechanism3;
      $VALUES = new TransferEncodingMechanism[] { localTransferEncodingMechanism1, localTransferEncodingMechanism2, localTransferEncodingMechanism3 };
    }
    
    private TransferEncodingMechanism(String paramString)
    {
      this.value = paramString;
    }
    
    public String toString()
    {
      return this.value;
    }
    
    public String value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\HttpPostBodyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */