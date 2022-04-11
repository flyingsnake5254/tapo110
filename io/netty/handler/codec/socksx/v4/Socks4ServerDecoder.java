package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.util.List;

public class Socks4ServerDecoder
  extends ReplayingDecoder<State>
{
  private static final int MAX_FIELD_LENGTH = 255;
  private String dstAddr;
  private int dstPort;
  private Socks4CommandType type;
  private String userId;
  
  public Socks4ServerDecoder()
  {
    super(State.START);
    setSingleDecode(true);
  }
  
  private void fail(List<Object> paramList, Exception paramException)
  {
    Object localObject1 = paramException;
    if (!(paramException instanceof DecoderException)) {
      localObject1 = new DecoderException(paramException);
    }
    paramException = this.type;
    if (paramException == null) {
      paramException = Socks4CommandType.CONNECT;
    }
    String str1 = this.dstAddr;
    Object localObject2 = "";
    if (str1 == null) {
      str1 = "";
    }
    int i = this.dstPort;
    if (i == 0) {
      i = 65535;
    }
    String str2 = this.userId;
    if (str2 != null) {
      localObject2 = str2;
    }
    paramException = new DefaultSocks4CommandRequest(paramException, str1, i, (String)localObject2);
    paramException.setDecoderResult(DecoderResult.failure((Throwable)localObject1));
    paramList.add(paramException);
    checkpoint(State.FAILURE);
  }
  
  private static String readString(String paramString, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.bytesBefore(256, (byte)0);
    if (i >= 0)
    {
      paramString = paramByteBuf.readSlice(i).toString(CharsetUtil.US_ASCII);
      paramByteBuf.skipBytes(1);
      return paramString;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("field '");
    paramByteBuf.append(paramString);
    paramByteBuf.append("' longer than ");
    paramByteBuf.append(255);
    paramByteBuf.append(" chars");
    throw new DecoderException(paramByteBuf.toString());
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[((State)state()).ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            break label132;
          }
          if (i == 4) {
            break label205;
          }
          if (i != 5) {
            return;
          }
          paramByteBuf.skipBytes(actualReadableBytes());
          return;
        }
      }
      else
      {
        i = paramByteBuf.readUnsignedByte();
        if (i != SocksVersion.SOCKS4a.byteValue()) {
          break label232;
        }
        this.type = Socks4CommandType.valueOf(paramByteBuf.readByte());
        this.dstPort = paramByteBuf.readUnsignedShort();
        this.dstAddr = NetUtil.intToIpAddress(paramByteBuf.readInt());
        checkpoint(State.READ_USERID);
      }
      this.userId = readString("userid", paramByteBuf);
      checkpoint(State.READ_DOMAIN);
      label132:
      if ((!"0.0.0.0".equals(this.dstAddr)) && (this.dstAddr.startsWith("0.0.0."))) {
        this.dstAddr = readString("dstAddr", paramByteBuf);
      }
      paramChannelHandlerContext = new io/netty/handler/codec/socksx/v4/DefaultSocks4CommandRequest;
      paramChannelHandlerContext.<init>(this.type, this.dstAddr, this.dstPort, this.userId);
      paramList.add(paramChannelHandlerContext);
      checkpoint(State.SUCCESS);
      label205:
      i = actualReadableBytes();
      if (i > 0)
      {
        paramList.add(paramByteBuf.readRetainedSlice(i));
        return;
        label232:
        paramByteBuf = new io/netty/handler/codec/DecoderException;
        paramChannelHandlerContext = new java/lang/StringBuilder;
        paramChannelHandlerContext.<init>();
        paramChannelHandlerContext.append("unsupported protocol version: ");
        paramChannelHandlerContext.append(i);
        paramByteBuf.<init>(paramChannelHandlerContext.toString());
        throw paramByteBuf;
      }
    }
    catch (Exception paramChannelHandlerContext)
    {
      fail(paramList, paramChannelHandlerContext);
    }
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("START", 0);
      START = localState1;
      State localState2 = new State("READ_USERID", 1);
      READ_USERID = localState2;
      State localState3 = new State("READ_DOMAIN", 2);
      READ_DOMAIN = localState3;
      State localState4 = new State("SUCCESS", 3);
      SUCCESS = localState4;
      State localState5 = new State("FAILURE", 4);
      FAILURE = localState5;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4ServerDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */