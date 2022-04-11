package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.util.ReferenceCounted;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MixedFileUpload
  implements FileUpload
{
  private final String baseDir;
  private final long definedSize;
  private final boolean deleteOnExit;
  private FileUpload fileUpload;
  private final long limitSize;
  private long maxSize = -1L;
  
  public MixedFileUpload(String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, long paramLong1, long paramLong2)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramCharset, paramLong1, paramLong2, DiskFileUpload.baseDirectory, DiskFileUpload.deleteOnExitTemporaryFile);
  }
  
  public MixedFileUpload(String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean)
  {
    this.limitSize = paramLong2;
    if (paramLong1 > paramLong2) {
      this.fileUpload = new DiskFileUpload(paramString1, paramString2, paramString3, paramString4, paramCharset, paramLong1);
    } else {
      this.fileUpload = new MemoryFileUpload(paramString1, paramString2, paramString3, paramString4, paramCharset, paramLong1);
    }
    this.definedSize = paramLong1;
    this.baseDir = paramString5;
    this.deleteOnExit = paramBoolean;
  }
  
  public void addContent(ByteBuf paramByteBuf, boolean paramBoolean)
    throws IOException
  {
    Object localObject = this.fileUpload;
    if ((localObject instanceof MemoryFileUpload))
    {
      checkSize(((HttpData)localObject).length() + paramByteBuf.readableBytes());
      if (this.fileUpload.length() + paramByteBuf.readableBytes() > this.limitSize)
      {
        localObject = new DiskFileUpload(this.fileUpload.getName(), this.fileUpload.getFilename(), this.fileUpload.getContentType(), this.fileUpload.getContentTransferEncoding(), this.fileUpload.getCharset(), this.definedSize, this.baseDir, this.deleteOnExit);
        ((AbstractHttpData)localObject).setMaxSize(this.maxSize);
        ByteBuf localByteBuf = this.fileUpload.getByteBuf();
        if ((localByteBuf != null) && (localByteBuf.isReadable())) {
          ((AbstractDiskHttpData)localObject).addContent(localByteBuf.retain(), false);
        }
        this.fileUpload.release();
        this.fileUpload = ((FileUpload)localObject);
      }
    }
    this.fileUpload.addContent(paramByteBuf, paramBoolean);
  }
  
  public void checkSize(long paramLong)
    throws IOException
  {
    long l = this.maxSize;
    if ((l >= 0L) && (paramLong > l)) {
      throw new IOException("Size exceed allowed maximum capacity");
    }
  }
  
  public int compareTo(InterfaceHttpData paramInterfaceHttpData)
  {
    return this.fileUpload.compareTo(paramInterfaceHttpData);
  }
  
  public ByteBuf content()
  {
    return this.fileUpload.content();
  }
  
  public FileUpload copy()
  {
    return this.fileUpload.copy();
  }
  
  public long definedLength()
  {
    return this.fileUpload.definedLength();
  }
  
  public void delete()
  {
    this.fileUpload.delete();
  }
  
  public FileUpload duplicate()
  {
    return this.fileUpload.duplicate();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.fileUpload.equals(paramObject);
  }
  
  public byte[] get()
    throws IOException
  {
    return this.fileUpload.get();
  }
  
  public ByteBuf getByteBuf()
    throws IOException
  {
    return this.fileUpload.getByteBuf();
  }
  
  public Charset getCharset()
  {
    return this.fileUpload.getCharset();
  }
  
  public ByteBuf getChunk(int paramInt)
    throws IOException
  {
    return this.fileUpload.getChunk(paramInt);
  }
  
  public String getContentTransferEncoding()
  {
    return this.fileUpload.getContentTransferEncoding();
  }
  
  public String getContentType()
  {
    return this.fileUpload.getContentType();
  }
  
  public File getFile()
    throws IOException
  {
    return this.fileUpload.getFile();
  }
  
  public String getFilename()
  {
    return this.fileUpload.getFilename();
  }
  
  public InterfaceHttpData.HttpDataType getHttpDataType()
  {
    return this.fileUpload.getHttpDataType();
  }
  
  public long getMaxSize()
  {
    return this.maxSize;
  }
  
  public String getName()
  {
    return this.fileUpload.getName();
  }
  
  public String getString()
    throws IOException
  {
    return this.fileUpload.getString();
  }
  
  public String getString(Charset paramCharset)
    throws IOException
  {
    return this.fileUpload.getString(paramCharset);
  }
  
  public int hashCode()
  {
    return this.fileUpload.hashCode();
  }
  
  public boolean isCompleted()
  {
    return this.fileUpload.isCompleted();
  }
  
  public boolean isInMemory()
  {
    return this.fileUpload.isInMemory();
  }
  
  public long length()
  {
    return this.fileUpload.length();
  }
  
  public int refCnt()
  {
    return this.fileUpload.refCnt();
  }
  
  public boolean release()
  {
    return this.fileUpload.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.fileUpload.release(paramInt);
  }
  
  public boolean renameTo(File paramFile)
    throws IOException
  {
    return this.fileUpload.renameTo(paramFile);
  }
  
  public FileUpload replace(ByteBuf paramByteBuf)
  {
    return this.fileUpload.replace(paramByteBuf);
  }
  
  public FileUpload retain()
  {
    this.fileUpload.retain();
    return this;
  }
  
  public FileUpload retain(int paramInt)
  {
    this.fileUpload.retain(paramInt);
    return this;
  }
  
  public FileUpload retainedDuplicate()
  {
    return this.fileUpload.retainedDuplicate();
  }
  
  public void setCharset(Charset paramCharset)
  {
    this.fileUpload.setCharset(paramCharset);
  }
  
  public void setContent(ByteBuf paramByteBuf)
    throws IOException
  {
    checkSize(paramByteBuf.readableBytes());
    if (paramByteBuf.readableBytes() > this.limitSize)
    {
      FileUpload localFileUpload = this.fileUpload;
      if ((localFileUpload instanceof MemoryFileUpload))
      {
        DiskFileUpload localDiskFileUpload = new DiskFileUpload(localFileUpload.getName(), localFileUpload.getFilename(), localFileUpload.getContentType(), localFileUpload.getContentTransferEncoding(), localFileUpload.getCharset(), this.definedSize, this.baseDir, this.deleteOnExit);
        this.fileUpload = localDiskFileUpload;
        localDiskFileUpload.setMaxSize(this.maxSize);
        localFileUpload.release();
      }
    }
    this.fileUpload.setContent(paramByteBuf);
  }
  
  public void setContent(File paramFile)
    throws IOException
  {
    checkSize(paramFile.length());
    if (paramFile.length() > this.limitSize)
    {
      FileUpload localFileUpload = this.fileUpload;
      if ((localFileUpload instanceof MemoryFileUpload))
      {
        DiskFileUpload localDiskFileUpload = new DiskFileUpload(localFileUpload.getName(), localFileUpload.getFilename(), localFileUpload.getContentType(), localFileUpload.getContentTransferEncoding(), localFileUpload.getCharset(), this.definedSize, this.baseDir, this.deleteOnExit);
        this.fileUpload = localDiskFileUpload;
        localDiskFileUpload.setMaxSize(this.maxSize);
        localFileUpload.release();
      }
    }
    this.fileUpload.setContent(paramFile);
  }
  
  public void setContent(InputStream paramInputStream)
    throws IOException
  {
    FileUpload localFileUpload = this.fileUpload;
    if ((localFileUpload instanceof MemoryFileUpload))
    {
      DiskFileUpload localDiskFileUpload = new DiskFileUpload(this.fileUpload.getName(), this.fileUpload.getFilename(), this.fileUpload.getContentType(), this.fileUpload.getContentTransferEncoding(), this.fileUpload.getCharset(), this.definedSize, this.baseDir, this.deleteOnExit);
      this.fileUpload = localDiskFileUpload;
      localDiskFileUpload.setMaxSize(this.maxSize);
      localFileUpload.release();
    }
    this.fileUpload.setContent(paramInputStream);
  }
  
  public void setContentTransferEncoding(String paramString)
  {
    this.fileUpload.setContentTransferEncoding(paramString);
  }
  
  public void setContentType(String paramString)
  {
    this.fileUpload.setContentType(paramString);
  }
  
  public void setFilename(String paramString)
  {
    this.fileUpload.setFilename(paramString);
  }
  
  public void setMaxSize(long paramLong)
  {
    this.maxSize = paramLong;
    this.fileUpload.setMaxSize(paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mixed: ");
    localStringBuilder.append(this.fileUpload);
    return localStringBuilder.toString();
  }
  
  public FileUpload touch()
  {
    this.fileUpload.touch();
    return this;
  }
  
  public FileUpload touch(Object paramObject)
  {
    this.fileUpload.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\MixedFileUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */