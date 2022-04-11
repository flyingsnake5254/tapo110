package io.netty.handler.ssl;

abstract interface OpenSslEngineMap
{
  public abstract void add(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine);
  
  public abstract ReferenceCountedOpenSslEngine get(long paramLong);
  
  public abstract ReferenceCountedOpenSslEngine remove(long paramLong);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslEngineMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */