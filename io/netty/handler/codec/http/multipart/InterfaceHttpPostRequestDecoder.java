package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpContent;
import java.util.List;

public abstract interface InterfaceHttpPostRequestDecoder
{
  public abstract void cleanFiles();
  
  public abstract InterfaceHttpData currentPartialHttpData();
  
  public abstract void destroy();
  
  public abstract InterfaceHttpData getBodyHttpData(String paramString);
  
  public abstract List<InterfaceHttpData> getBodyHttpDatas();
  
  public abstract List<InterfaceHttpData> getBodyHttpDatas(String paramString);
  
  public abstract int getDiscardThreshold();
  
  public abstract boolean hasNext();
  
  public abstract boolean isMultipart();
  
  public abstract InterfaceHttpData next();
  
  public abstract InterfaceHttpPostRequestDecoder offer(HttpContent paramHttpContent);
  
  public abstract void removeHttpDataFromClean(InterfaceHttpData paramInterfaceHttpData);
  
  public abstract void setDiscardThreshold(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\InterfaceHttpPostRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */