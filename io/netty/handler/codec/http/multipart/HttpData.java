package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public abstract interface HttpData
  extends InterfaceHttpData, ByteBufHolder
{
  public abstract void addContent(ByteBuf paramByteBuf, boolean paramBoolean)
    throws IOException;
  
  public abstract void checkSize(long paramLong)
    throws IOException;
  
  public abstract HttpData copy();
  
  public abstract long definedLength();
  
  public abstract void delete();
  
  public abstract HttpData duplicate();
  
  public abstract byte[] get()
    throws IOException;
  
  public abstract ByteBuf getByteBuf()
    throws IOException;
  
  public abstract Charset getCharset();
  
  public abstract ByteBuf getChunk(int paramInt)
    throws IOException;
  
  public abstract File getFile()
    throws IOException;
  
  public abstract long getMaxSize();
  
  public abstract String getString()
    throws IOException;
  
  public abstract String getString(Charset paramCharset)
    throws IOException;
  
  public abstract boolean isCompleted();
  
  public abstract boolean isInMemory();
  
  public abstract long length();
  
  public abstract boolean renameTo(File paramFile)
    throws IOException;
  
  public abstract HttpData replace(ByteBuf paramByteBuf);
  
  public abstract HttpData retain();
  
  public abstract HttpData retain(int paramInt);
  
  public abstract HttpData retainedDuplicate();
  
  public abstract void setCharset(Charset paramCharset);
  
  public abstract void setContent(ByteBuf paramByteBuf)
    throws IOException;
  
  public abstract void setContent(File paramFile)
    throws IOException;
  
  public abstract void setContent(InputStream paramInputStream)
    throws IOException;
  
  public abstract void setMaxSize(long paramLong);
  
  public abstract HttpData touch();
  
  public abstract HttpData touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\HttpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */