package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.net.ssl.X509KeyManager;

final class OpenSslCachingKeyMaterialProvider
  extends OpenSslKeyMaterialProvider
{
  private final ConcurrentMap<String, OpenSslKeyMaterial> cache = new ConcurrentHashMap();
  private volatile boolean full;
  private final int maxCachedEntries;
  
  OpenSslCachingKeyMaterialProvider(X509KeyManager paramX509KeyManager, String paramString, int paramInt)
  {
    super(paramX509KeyManager, paramString);
    this.maxCachedEntries = paramInt;
  }
  
  OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator paramByteBufAllocator, String paramString)
    throws Exception
  {
    OpenSslKeyMaterial localOpenSslKeyMaterial = (OpenSslKeyMaterial)this.cache.get(paramString);
    Object localObject = localOpenSslKeyMaterial;
    if (localOpenSslKeyMaterial == null)
    {
      paramByteBufAllocator = super.chooseKeyMaterial(paramByteBufAllocator, paramString);
      if (paramByteBufAllocator == null) {
        return null;
      }
      if (this.full) {
        return paramByteBufAllocator;
      }
      if (this.cache.size() > this.maxCachedEntries)
      {
        this.full = true;
        return paramByteBufAllocator;
      }
      paramString = (OpenSslKeyMaterial)this.cache.putIfAbsent(paramString, paramByteBufAllocator);
      localObject = paramByteBufAllocator;
      if (paramString != null)
      {
        paramByteBufAllocator.release();
        localObject = paramString;
      }
    }
    return ((OpenSslKeyMaterial)localObject).retain();
  }
  
  void destroy()
  {
    do
    {
      Iterator localIterator = this.cache.values().iterator();
      while (localIterator.hasNext())
      {
        ((OpenSslKeyMaterial)localIterator.next()).release();
        localIterator.remove();
      }
    } while (!this.cache.isEmpty());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslCachingKeyMaterialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */