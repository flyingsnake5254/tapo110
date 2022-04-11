package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;

public class DefaultHttpObject
  implements HttpObject
{
  private static final int HASH_CODE_PRIME = 31;
  private DecoderResult decoderResult = DecoderResult.SUCCESS;
  
  public DecoderResult decoderResult()
  {
    return this.decoderResult;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DefaultHttpObject)) {
      return false;
    }
    paramObject = (DefaultHttpObject)paramObject;
    return decoderResult().equals(((DefaultHttpObject)paramObject).decoderResult());
  }
  
  @Deprecated
  public DecoderResult getDecoderResult()
  {
    return decoderResult();
  }
  
  public int hashCode()
  {
    return 31 + this.decoderResult.hashCode();
  }
  
  public void setDecoderResult(DecoderResult paramDecoderResult)
  {
    this.decoderResult = ((DecoderResult)ObjectUtil.checkNotNull(paramDecoderResult, "decoderResult"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultHttpObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */