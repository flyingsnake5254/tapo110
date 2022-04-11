package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

public final class OpenSslEngine
  extends ReferenceCountedOpenSslEngine
{
  OpenSslEngine(OpenSslContext paramOpenSslContext, ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramOpenSslContext, paramByteBufAllocator, paramString, paramInt, paramBoolean, false);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    OpenSsl.releaseIfNeeded(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */