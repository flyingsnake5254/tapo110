package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SocksInitRequest
  extends SocksRequest
{
  private final List<SocksAuthScheme> authSchemes;
  
  public SocksInitRequest(List<SocksAuthScheme> paramList)
  {
    super(SocksRequestType.INIT);
    this.authSchemes = ((List)ObjectUtil.checkNotNull(paramList, "authSchemes"));
  }
  
  public List<SocksAuthScheme> authSchemes()
  {
    return Collections.unmodifiableList(this.authSchemes);
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(protocolVersion().byteValue());
    paramByteBuf.writeByte(this.authSchemes.size());
    Iterator localIterator = this.authSchemes.iterator();
    while (localIterator.hasNext()) {
      paramByteBuf.writeByte(((SocksAuthScheme)localIterator.next()).byteValue());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksInitRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */