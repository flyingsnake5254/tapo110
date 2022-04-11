package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.ReferenceCounted;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DefaultHttpDataFactory
  implements HttpDataFactory
{
  public static final long MAXSIZE = -1L;
  public static final long MINSIZE = 16384L;
  private String baseDir;
  private Charset charset = HttpConstants.DEFAULT_CHARSET;
  private final boolean checkSize;
  private boolean deleteOnExit;
  private long maxSize = -1L;
  private long minSize;
  private final Map<HttpRequest, List<HttpData>> requestFileDeleteMap = Collections.synchronizedMap(new IdentityHashMap());
  private final boolean useDisk;
  
  public DefaultHttpDataFactory()
  {
    this.useDisk = false;
    this.checkSize = true;
    this.minSize = 16384L;
  }
  
  public DefaultHttpDataFactory(long paramLong)
  {
    this.useDisk = false;
    this.checkSize = true;
    this.minSize = paramLong;
  }
  
  public DefaultHttpDataFactory(long paramLong, Charset paramCharset)
  {
    this(paramLong);
    this.charset = paramCharset;
  }
  
  public DefaultHttpDataFactory(Charset paramCharset)
  {
    this();
    this.charset = paramCharset;
  }
  
  public DefaultHttpDataFactory(boolean paramBoolean)
  {
    this.useDisk = paramBoolean;
    this.checkSize = false;
  }
  
  public DefaultHttpDataFactory(boolean paramBoolean, Charset paramCharset)
  {
    this(paramBoolean);
    this.charset = paramCharset;
  }
  
  private static void checkHttpDataSize(HttpData paramHttpData)
  {
    try
    {
      paramHttpData.checkSize(paramHttpData.length());
      return;
    }
    catch (IOException paramHttpData)
    {
      throw new IllegalArgumentException("Attribute bigger than maxSize allowed");
    }
  }
  
  private List<HttpData> getList(HttpRequest paramHttpRequest)
  {
    List localList = (List)this.requestFileDeleteMap.get(paramHttpRequest);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.requestFileDeleteMap.put(paramHttpRequest, localObject);
    }
    return (List<HttpData>)localObject;
  }
  
  public void cleanAllHttpData()
  {
    Iterator localIterator1 = this.requestFileDeleteMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext()) {
        ((HttpData)localIterator2.next()).release();
      }
      localIterator1.remove();
    }
  }
  
  public void cleanAllHttpDatas()
  {
    cleanAllHttpData();
  }
  
  public void cleanRequestHttpData(HttpRequest paramHttpRequest)
  {
    paramHttpRequest = (List)this.requestFileDeleteMap.remove(paramHttpRequest);
    if (paramHttpRequest != null)
    {
      paramHttpRequest = paramHttpRequest.iterator();
      while (paramHttpRequest.hasNext()) {
        ((HttpData)paramHttpRequest.next()).release();
      }
    }
  }
  
  public void cleanRequestHttpDatas(HttpRequest paramHttpRequest)
  {
    cleanRequestHttpData(paramHttpRequest);
  }
  
  public Attribute createAttribute(HttpRequest paramHttpRequest, String paramString)
  {
    if (this.useDisk)
    {
      paramString = new DiskAttribute(paramString, this.charset, this.baseDir, this.deleteOnExit);
      paramString.setMaxSize(this.maxSize);
      getList(paramHttpRequest).add(paramString);
      return paramString;
    }
    if (this.checkSize)
    {
      paramString = new MixedAttribute(paramString, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
      paramString.setMaxSize(this.maxSize);
      getList(paramHttpRequest).add(paramString);
      return paramString;
    }
    paramHttpRequest = new MemoryAttribute(paramString);
    paramHttpRequest.setMaxSize(this.maxSize);
    return paramHttpRequest;
  }
  
  public Attribute createAttribute(HttpRequest paramHttpRequest, String paramString, long paramLong)
  {
    if (this.useDisk)
    {
      paramString = new DiskAttribute(paramString, paramLong, this.charset, this.baseDir, this.deleteOnExit);
      paramString.setMaxSize(this.maxSize);
      getList(paramHttpRequest).add(paramString);
      return paramString;
    }
    if (this.checkSize)
    {
      paramString = new MixedAttribute(paramString, paramLong, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
      paramString.setMaxSize(this.maxSize);
      getList(paramHttpRequest).add(paramString);
      return paramString;
    }
    paramHttpRequest = new MemoryAttribute(paramString, paramLong);
    paramHttpRequest.setMaxSize(this.maxSize);
    return paramHttpRequest;
  }
  
  public Attribute createAttribute(HttpRequest paramHttpRequest, String paramString1, String paramString2)
  {
    if (this.useDisk)
    {
      try
      {
        DiskAttribute localDiskAttribute = new io/netty/handler/codec/http/multipart/DiskAttribute;
        localDiskAttribute.<init>(paramString1, paramString2, this.charset, this.baseDir, this.deleteOnExit);
        localDiskAttribute.setMaxSize(this.maxSize);
        paramString1 = localDiskAttribute;
      }
      catch (IOException localIOException)
      {
        paramString1 = new MixedAttribute(paramString1, paramString2, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
        paramString1.setMaxSize(this.maxSize);
      }
      checkHttpDataSize(paramString1);
      getList(paramHttpRequest).add(paramString1);
      return paramString1;
    }
    if (this.checkSize)
    {
      paramString1 = new MixedAttribute(paramString1, paramString2, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
      paramString1.setMaxSize(this.maxSize);
      checkHttpDataSize(paramString1);
      getList(paramHttpRequest).add(paramString1);
      return paramString1;
    }
    try
    {
      paramHttpRequest = new io/netty/handler/codec/http/multipart/MemoryAttribute;
      paramHttpRequest.<init>(paramString1, paramString2, this.charset);
      paramHttpRequest.setMaxSize(this.maxSize);
      checkHttpDataSize(paramHttpRequest);
      return paramHttpRequest;
    }
    catch (IOException paramHttpRequest)
    {
      throw new IllegalArgumentException(paramHttpRequest);
    }
  }
  
  public FileUpload createFileUpload(HttpRequest paramHttpRequest, String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, long paramLong)
  {
    if (this.useDisk)
    {
      paramString1 = new DiskFileUpload(paramString1, paramString2, paramString3, paramString4, paramCharset, paramLong, this.baseDir, this.deleteOnExit);
      paramString1.setMaxSize(this.maxSize);
      checkHttpDataSize(paramString1);
      getList(paramHttpRequest).add(paramString1);
      return paramString1;
    }
    if (this.checkSize)
    {
      paramString1 = new MixedFileUpload(paramString1, paramString2, paramString3, paramString4, paramCharset, paramLong, this.minSize, this.baseDir, this.deleteOnExit);
      paramString1.setMaxSize(this.maxSize);
      checkHttpDataSize(paramString1);
      getList(paramHttpRequest).add(paramString1);
      return paramString1;
    }
    paramHttpRequest = new MemoryFileUpload(paramString1, paramString2, paramString3, paramString4, paramCharset, paramLong);
    paramHttpRequest.setMaxSize(this.maxSize);
    checkHttpDataSize(paramHttpRequest);
    return paramHttpRequest;
  }
  
  public void removeHttpDataFromClean(HttpRequest paramHttpRequest, InterfaceHttpData paramInterfaceHttpData)
  {
    if (!(paramInterfaceHttpData instanceof HttpData)) {
      return;
    }
    List localList = (List)this.requestFileDeleteMap.get(paramHttpRequest);
    if (localList == null) {
      return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if ((HttpData)localIterator.next() == paramInterfaceHttpData)
      {
        localIterator.remove();
        if (localList.isEmpty()) {
          this.requestFileDeleteMap.remove(paramHttpRequest);
        }
      }
    }
  }
  
  public void setBaseDir(String paramString)
  {
    this.baseDir = paramString;
  }
  
  public void setDeleteOnExit(boolean paramBoolean)
  {
    this.deleteOnExit = paramBoolean;
  }
  
  public void setMaxLimit(long paramLong)
  {
    this.maxSize = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\DefaultHttpDataFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */