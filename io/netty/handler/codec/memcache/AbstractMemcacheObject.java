package io.netty.handler.codec.memcache;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public abstract class AbstractMemcacheObject
  extends AbstractReferenceCounted
  implements a
{
  private DecoderResult decoderResult = DecoderResult.SUCCESS;
  
  public DecoderResult decoderResult()
  {
    return this.decoderResult;
  }
  
  public void setDecoderResult(DecoderResult paramDecoderResult)
  {
    this.decoderResult = ((DecoderResult)ObjectUtil.checkNotNull(paramDecoderResult, "DecoderResult should not be null."));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\AbstractMemcacheObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */