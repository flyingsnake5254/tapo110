package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class SmtpRequestEncoder
  extends MessageToMessageEncoder<Object>
{
  private static final int CRLF_SHORT = 3338;
  private static final ByteBuf DOT_CRLF_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(3).writeByte(46).writeByte(13).writeByte(10));
  private static final byte SP = 32;
  private boolean contentExpected;
  
  private static void writeParameters(List<CharSequence> paramList, ByteBuf paramByteBuf, boolean paramBoolean)
  {
    if (paramList.isEmpty()) {
      return;
    }
    if (paramBoolean) {
      paramByteBuf.writeByte(32);
    }
    if ((paramList instanceof RandomAccess))
    {
      int i = paramList.size() - 1;
      for (int j = 0; j < i; j++)
      {
        ByteBufUtil.writeAscii(paramByteBuf, (CharSequence)paramList.get(j));
        paramByteBuf.writeByte(32);
      }
      ByteBufUtil.writeAscii(paramByteBuf, (CharSequence)paramList.get(i));
    }
    else
    {
      paramList = paramList.iterator();
      for (;;)
      {
        ByteBufUtil.writeAscii(paramByteBuf, (CharSequence)paramList.next());
        if (!paramList.hasNext()) {
          break;
        }
        paramByteBuf.writeByte(32);
      }
    }
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((!(paramObject instanceof SmtpRequest)) && (!(paramObject instanceof SmtpContent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  protected void encode(io.netty.channel.ChannelHandlerContext paramChannelHandlerContext, Object paramObject, List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 85
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 5
    //   9: iload 4
    //   11: ifeq +173 -> 184
    //   14: aload_2
    //   15: checkcast 85	io/netty/handler/codec/smtp/SmtpRequest
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 92	io/netty/handler/codec/smtp/SmtpRequestEncoder:contentExpected	Z
    //   24: ifeq +37 -> 61
    //   27: aload 6
    //   29: invokeinterface 96 1 0
    //   34: getstatic 102	io/netty/handler/codec/smtp/SmtpCommand:RSET	Lio/netty/handler/codec/smtp/SmtpCommand;
    //   37: invokevirtual 105	io/netty/handler/codec/smtp/SmtpCommand:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +11 -> 51
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 92	io/netty/handler/codec/smtp/SmtpRequestEncoder:contentExpected	Z
    //   48: goto +13 -> 61
    //   51: new 107	java/lang/IllegalStateException
    //   54: dup
    //   55: ldc 109
    //   57: invokespecial 112	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: aload_1
    //   62: invokeinterface 118 1 0
    //   67: invokeinterface 124 1 0
    //   72: astore 7
    //   74: aload 6
    //   76: invokeinterface 96 1 0
    //   81: aload 7
    //   83: invokevirtual 127	io/netty/handler/codec/smtp/SmtpCommand:encode	(Lio/netty/buffer/ByteBuf;)V
    //   86: aload 6
    //   88: invokeinterface 96 1 0
    //   93: getstatic 130	io/netty/handler/codec/smtp/SmtpCommand:EMPTY	Lio/netty/handler/codec/smtp/SmtpCommand;
    //   96: if_acmpeq +9 -> 105
    //   99: iconst_1
    //   100: istore 4
    //   102: goto +6 -> 108
    //   105: iconst_0
    //   106: istore 4
    //   108: aload 6
    //   110: invokeinterface 134 1 0
    //   115: aload 7
    //   117: iload 4
    //   119: invokestatic 136	io/netty/handler/codec/smtp/SmtpRequestEncoder:writeParameters	(Ljava/util/List;Lio/netty/buffer/ByteBuf;Z)V
    //   122: aload 7
    //   124: sipush 3338
    //   127: invokestatic 140	io/netty/buffer/ByteBufUtil:writeShortBE	(Lio/netty/buffer/ByteBuf;I)Lio/netty/buffer/ByteBuf;
    //   130: pop
    //   131: aload_3
    //   132: aload 7
    //   134: invokeinterface 143 2 0
    //   139: pop
    //   140: aload 6
    //   142: invokeinterface 96 1 0
    //   147: invokevirtual 146	io/netty/handler/codec/smtp/SmtpCommand:isContentExpected	()Z
    //   150: ifeq +34 -> 184
    //   153: aload_0
    //   154: iconst_1
    //   155: putfield 92	io/netty/handler/codec/smtp/SmtpRequestEncoder:contentExpected	Z
    //   158: goto +26 -> 184
    //   161: astore_1
    //   162: goto +7 -> 169
    //   165: astore_1
    //   166: iconst_1
    //   167: istore 5
    //   169: iload 5
    //   171: ifeq +11 -> 182
    //   174: aload 7
    //   176: invokeinterface 151 1 0
    //   181: pop
    //   182: aload_1
    //   183: athrow
    //   184: aload_2
    //   185: instanceof 87
    //   188: ifeq +67 -> 255
    //   191: aload_0
    //   192: getfield 92	io/netty/handler/codec/smtp/SmtpRequestEncoder:contentExpected	Z
    //   195: ifeq +50 -> 245
    //   198: aload_3
    //   199: aload_2
    //   200: checkcast 87	io/netty/handler/codec/smtp/SmtpContent
    //   203: invokeinterface 156 1 0
    //   208: invokevirtual 159	io/netty/buffer/ByteBuf:retain	()Lio/netty/buffer/ByteBuf;
    //   211: invokeinterface 143 2 0
    //   216: pop
    //   217: aload_2
    //   218: instanceof 161
    //   221: ifeq +34 -> 255
    //   224: aload_3
    //   225: getstatic 34	io/netty/handler/codec/smtp/SmtpRequestEncoder:DOT_CRLF_BUFFER	Lio/netty/buffer/ByteBuf;
    //   228: invokevirtual 164	io/netty/buffer/ByteBuf:retainedDuplicate	()Lio/netty/buffer/ByteBuf;
    //   231: invokeinterface 143 2 0
    //   236: pop
    //   237: aload_0
    //   238: iconst_0
    //   239: putfield 92	io/netty/handler/codec/smtp/SmtpRequestEncoder:contentExpected	Z
    //   242: goto +13 -> 255
    //   245: new 107	java/lang/IllegalStateException
    //   248: dup
    //   249: ldc -90
    //   251: invokespecial 112	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   254: athrow
    //   255: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	SmtpRequestEncoder
    //   0	256	1	paramChannelHandlerContext	io.netty.channel.ChannelHandlerContext
    //   0	256	2	paramObject	Object
    //   0	256	3	paramList	List<Object>
    //   4	114	4	bool	boolean
    //   7	163	5	i	int
    //   18	123	6	localSmtpRequest	SmtpRequest
    //   72	103	7	localByteBuf	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   140	158	161	finally
    //   74	99	165	finally
    //   108	140	165	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\SmtpRequestEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */