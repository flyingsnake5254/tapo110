package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.StringUtil;
import java.io.IOException;

public abstract class AbstractOioByteChannel
  extends AbstractOioChannel
{
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA = new ChannelMetadata(false);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(FileRegion.class));
    localStringBuilder.append(')');
    EXPECTED_TYPES = localStringBuilder.toString();
  }
  
  protected AbstractOioByteChannel(Channel paramChannel)
  {
    super(paramChannel);
  }
  
  private void closeOnRead(ChannelPipeline paramChannelPipeline)
  {
    if (isOpen())
    {
      if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE)))
      {
        shutdownInput();
        paramChannelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
      }
      else
      {
        unsafe().close(unsafe().voidPromise());
      }
      paramChannelPipeline.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
    }
  }
  
  private void handleReadException(ChannelPipeline paramChannelPipeline, ByteBuf paramByteBuf, Throwable paramThrowable, boolean paramBoolean, RecvByteBufAllocator.Handle paramHandle)
  {
    if (paramByteBuf != null) {
      if (paramByteBuf.isReadable())
      {
        this.readPending = false;
        paramChannelPipeline.fireChannelRead(paramByteBuf);
      }
      else
      {
        paramByteBuf.release();
      }
    }
    paramHandle.readComplete();
    paramChannelPipeline.fireChannelReadComplete();
    paramChannelPipeline.fireExceptionCaught(paramThrowable);
    if ((paramBoolean) || ((paramThrowable instanceof IOException))) {
      closeOnRead(paramChannelPipeline);
    }
  }
  
  protected abstract int available();
  
  /* Error */
  protected void doRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 71 1 0
    //   6: astore_1
    //   7: aload_0
    //   8: invokevirtual 164	io/netty/channel/oio/AbstractOioByteChannel:isInputShutdown	()Z
    //   11: ifne +661 -> 672
    //   14: aload_0
    //   15: getfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   18: ifne +6 -> 24
    //   21: goto +651 -> 672
    //   24: iconst_0
    //   25: istore_2
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   31: aload_0
    //   32: invokevirtual 167	io/netty/channel/AbstractChannel:pipeline	()Lio/netty/channel/ChannelPipeline;
    //   35: astore_3
    //   36: aload_1
    //   37: invokeinterface 171 1 0
    //   42: astore 4
    //   44: aload_0
    //   45: invokevirtual 109	io/netty/channel/AbstractChannel:unsafe	()Lio/netty/channel/Channel$Unsafe;
    //   48: invokeinterface 175 1 0
    //   53: astore 5
    //   55: aload 5
    //   57: aload_1
    //   58: invokeinterface 179 2 0
    //   63: iconst_1
    //   64: istore 6
    //   66: aconst_null
    //   67: astore 7
    //   69: aconst_null
    //   70: astore 8
    //   72: aload 5
    //   74: aload 4
    //   76: invokeinterface 183 2 0
    //   81: astore 9
    //   83: iconst_0
    //   84: istore_2
    //   85: aload 5
    //   87: aload_0
    //   88: aload 9
    //   90: invokevirtual 187	io/netty/channel/oio/AbstractOioByteChannel:doReadBytes	(Lio/netty/buffer/ByteBuf;)I
    //   93: invokeinterface 191 2 0
    //   98: aload 5
    //   100: invokeinterface 193 1 0
    //   105: ifgt +77 -> 182
    //   108: aload 9
    //   110: invokevirtual 129	io/netty/buffer/ByteBuf:isReadable	()Z
    //   113: ifne +63 -> 176
    //   116: aload 9
    //   118: invokeinterface 141 1 0
    //   123: pop
    //   124: aload 5
    //   126: invokeinterface 193 1 0
    //   131: istore 10
    //   133: iload 10
    //   135: ifge +6 -> 141
    //   138: goto +6 -> 144
    //   141: iconst_0
    //   142: istore 6
    //   144: iload 6
    //   146: ifeq +19 -> 165
    //   149: iload 6
    //   151: istore 11
    //   153: aload 7
    //   155: astore 9
    //   157: iload_2
    //   158: istore 10
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   165: aconst_null
    //   166: astore 9
    //   168: goto +207 -> 375
    //   171: astore 9
    //   173: goto +398 -> 571
    //   176: iconst_0
    //   177: istore 6
    //   179: goto +196 -> 375
    //   182: aload 9
    //   184: astore 12
    //   186: aload_0
    //   187: invokevirtual 195	io/netty/channel/oio/AbstractOioByteChannel:available	()I
    //   190: istore_2
    //   191: iload_2
    //   192: ifgt +11 -> 203
    //   195: iconst_0
    //   196: istore 6
    //   198: iconst_1
    //   199: istore_2
    //   200: goto +175 -> 375
    //   203: aload 9
    //   205: astore 13
    //   207: aload 9
    //   209: astore 12
    //   211: aload 9
    //   213: invokevirtual 198	io/netty/buffer/ByteBuf:isWritable	()Z
    //   216: ifne +134 -> 350
    //   219: aload 9
    //   221: astore 12
    //   223: aload 9
    //   225: invokevirtual 201	io/netty/buffer/ByteBuf:capacity	()I
    //   228: istore 10
    //   230: aload 9
    //   232: astore 12
    //   234: aload 9
    //   236: invokevirtual 204	io/netty/buffer/ByteBuf:maxCapacity	()I
    //   239: istore 14
    //   241: iload 10
    //   243: iload 14
    //   245: if_icmpne +55 -> 300
    //   248: aload 9
    //   250: astore 12
    //   252: aload 5
    //   254: iconst_1
    //   255: invokeinterface 207 2 0
    //   260: aload 9
    //   262: astore 12
    //   264: aload_0
    //   265: iconst_0
    //   266: putfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   269: aload 9
    //   271: astore 12
    //   273: aload_3
    //   274: aload 9
    //   276: invokeinterface 136 2 0
    //   281: pop
    //   282: aload 9
    //   284: astore 12
    //   286: aload 5
    //   288: aload 4
    //   290: invokeinterface 183 2 0
    //   295: astore 13
    //   297: goto +53 -> 350
    //   300: aload 9
    //   302: astore 12
    //   304: aload 9
    //   306: invokevirtual 210	io/netty/buffer/ByteBuf:writerIndex	()I
    //   309: iload_2
    //   310: iadd
    //   311: iload 14
    //   313: if_icmple +22 -> 335
    //   316: aload 9
    //   318: astore 12
    //   320: aload 9
    //   322: iload 14
    //   324: invokevirtual 213	io/netty/buffer/ByteBuf:capacity	(I)Lio/netty/buffer/ByteBuf;
    //   327: pop
    //   328: aload 9
    //   330: astore 13
    //   332: goto +18 -> 350
    //   335: aload 9
    //   337: astore 12
    //   339: aload 9
    //   341: iload_2
    //   342: invokevirtual 216	io/netty/buffer/ByteBuf:ensureWritable	(I)Lio/netty/buffer/ByteBuf;
    //   345: pop
    //   346: aload 9
    //   348: astore 13
    //   350: aload 13
    //   352: astore 12
    //   354: aload 5
    //   356: invokeinterface 219 1 0
    //   361: istore 11
    //   363: iload 11
    //   365: ifne +176 -> 541
    //   368: aload 13
    //   370: astore 9
    //   372: goto -177 -> 195
    //   375: aload 9
    //   377: ifnull +52 -> 429
    //   380: aload 9
    //   382: invokevirtual 129	io/netty/buffer/ByteBuf:isReadable	()Z
    //   385: ifeq +24 -> 409
    //   388: aload_0
    //   389: iconst_0
    //   390: putfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   393: aload_3
    //   394: aload 9
    //   396: invokeinterface 136 2 0
    //   401: pop
    //   402: aload 8
    //   404: astore 13
    //   406: goto +27 -> 433
    //   409: aload 9
    //   411: invokeinterface 141 1 0
    //   416: pop
    //   417: aload 8
    //   419: astore 13
    //   421: goto +12 -> 433
    //   424: astore 13
    //   426: goto +159 -> 585
    //   429: aload 9
    //   431: astore 13
    //   433: iload_2
    //   434: ifeq +54 -> 488
    //   437: iload 6
    //   439: istore 11
    //   441: aload 13
    //   443: astore 9
    //   445: iload_2
    //   446: istore 10
    //   448: aload 5
    //   450: invokeinterface 146 1 0
    //   455: iload 6
    //   457: istore 11
    //   459: aload 13
    //   461: astore 9
    //   463: iload_2
    //   464: istore 10
    //   466: aload_3
    //   467: invokeinterface 150 1 0
    //   472: pop
    //   473: goto +15 -> 488
    //   476: astore 13
    //   478: iload 11
    //   480: istore 6
    //   482: iload 10
    //   484: istore_2
    //   485: goto +100 -> 585
    //   488: iload 6
    //   490: ifeq +19 -> 509
    //   493: iload 6
    //   495: istore 11
    //   497: aload 13
    //   499: astore 9
    //   501: iload_2
    //   502: istore 10
    //   504: aload_0
    //   505: aload_3
    //   506: invokespecial 158	io/netty/channel/oio/AbstractOioByteChannel:closeOnRead	(Lio/netty/channel/ChannelPipeline;)V
    //   509: aload_0
    //   510: getfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   513: ifne +114 -> 627
    //   516: aload_1
    //   517: invokeinterface 222 1 0
    //   522: ifne +105 -> 627
    //   525: iload_2
    //   526: ifne +106 -> 632
    //   529: aload_0
    //   530: invokeinterface 225 1 0
    //   535: ifeq +97 -> 632
    //   538: goto +89 -> 627
    //   541: iconst_1
    //   542: istore_2
    //   543: aload 13
    //   545: astore 9
    //   547: goto -462 -> 85
    //   550: astore 13
    //   552: aload 12
    //   554: astore 9
    //   556: iconst_1
    //   557: istore_2
    //   558: goto +5 -> 563
    //   561: astore 13
    //   563: iconst_0
    //   564: istore 6
    //   566: goto +19 -> 585
    //   569: astore 9
    //   571: aconst_null
    //   572: astore 12
    //   574: iconst_0
    //   575: istore 6
    //   577: aload 9
    //   579: astore 13
    //   581: aload 12
    //   583: astore 9
    //   585: aload_0
    //   586: aload_3
    //   587: aload 9
    //   589: aload 13
    //   591: iload 6
    //   593: aload 5
    //   595: invokespecial 227	io/netty/channel/oio/AbstractOioByteChannel:handleReadException	(Lio/netty/channel/ChannelPipeline;Lio/netty/buffer/ByteBuf;Ljava/lang/Throwable;ZLio/netty/channel/RecvByteBufAllocator$Handle;)V
    //   598: aload_0
    //   599: getfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   602: ifne +25 -> 627
    //   605: aload_1
    //   606: invokeinterface 222 1 0
    //   611: ifne +16 -> 627
    //   614: iload_2
    //   615: ifne +17 -> 632
    //   618: aload_0
    //   619: invokeinterface 225 1 0
    //   624: ifeq +8 -> 632
    //   627: aload_0
    //   628: invokevirtual 231	io/netty/channel/AbstractChannel:read	()Lio/netty/channel/Channel;
    //   631: pop
    //   632: return
    //   633: astore 9
    //   635: aload_0
    //   636: getfield 133	io/netty/channel/oio/AbstractOioChannel:readPending	Z
    //   639: ifne +25 -> 664
    //   642: aload_1
    //   643: invokeinterface 222 1 0
    //   648: ifne +16 -> 664
    //   651: iload_2
    //   652: ifne +17 -> 669
    //   655: aload_0
    //   656: invokeinterface 225 1 0
    //   661: ifeq +8 -> 669
    //   664: aload_0
    //   665: invokevirtual 231	io/netty/channel/AbstractChannel:read	()Lio/netty/channel/Channel;
    //   668: pop
    //   669: aload 9
    //   671: athrow
    //   672: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	this	AbstractOioByteChannel
    //   6	637	1	localChannelConfig	ChannelConfig
    //   25	627	2	i	int
    //   35	552	3	localChannelPipeline	ChannelPipeline
    //   42	247	4	localByteBufAllocator	io.netty.buffer.ByteBufAllocator
    //   53	541	5	localHandle	RecvByteBufAllocator.Handle
    //   64	528	6	bool1	boolean
    //   67	87	7	localObject1	Object
    //   70	348	8	localObject2	Object
    //   81	86	9	localObject3	Object
    //   171	176	9	localObject4	Object
    //   370	185	9	localObject5	Object
    //   569	9	9	localObject6	Object
    //   583	5	9	localObject7	Object
    //   633	37	9	localObject8	Object
    //   131	372	10	j	int
    //   151	345	11	bool2	boolean
    //   184	398	12	localObject9	Object
    //   205	215	13	localObject10	Object
    //   424	1	13	localObject11	Object
    //   431	29	13	localObject12	Object
    //   476	68	13	localObject13	Object
    //   550	1	13	localObject14	Object
    //   561	1	13	localObject15	Object
    //   579	11	13	localObject16	Object
    //   239	84	14	k	int
    // Exception table:
    //   from	to	target	type
    //   124	133	171	finally
    //   380	402	424	finally
    //   409	417	424	finally
    //   160	165	476	finally
    //   448	455	476	finally
    //   466	473	476	finally
    //   504	509	476	finally
    //   186	191	550	finally
    //   211	219	550	finally
    //   223	230	550	finally
    //   234	241	550	finally
    //   252	260	550	finally
    //   264	269	550	finally
    //   273	282	550	finally
    //   286	297	550	finally
    //   304	316	550	finally
    //   320	328	550	finally
    //   339	346	550	finally
    //   354	363	550	finally
    //   85	124	561	finally
    //   72	83	569	finally
    //   585	598	633	finally
  }
  
  protected abstract int doReadBytes(ByteBuf paramByteBuf)
    throws Exception;
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    for (;;)
    {
      Object localObject = paramChannelOutboundBuffer.current();
      if (localObject == null) {
        return;
      }
      if ((localObject instanceof ByteBuf))
      {
        localObject = (ByteBuf)localObject;
        int j;
        for (int i = ((ByteBuf)localObject).readableBytes(); i > 0; i = j)
        {
          doWriteBytes((ByteBuf)localObject);
          j = ((ByteBuf)localObject).readableBytes();
          paramChannelOutboundBuffer.progress(i - j);
        }
        paramChannelOutboundBuffer.remove();
      }
      else if ((localObject instanceof FileRegion))
      {
        localObject = (FileRegion)localObject;
        long l = ((FileRegion)localObject).transferred();
        doWriteFileRegion((FileRegion)localObject);
        paramChannelOutboundBuffer.progress(((FileRegion)localObject).transferred() - l);
        paramChannelOutboundBuffer.remove();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unsupported message type: ");
        localStringBuilder.append(StringUtil.simpleClassName(localObject));
        paramChannelOutboundBuffer.remove(new UnsupportedOperationException(localStringBuilder.toString()));
      }
    }
  }
  
  protected abstract void doWriteBytes(ByteBuf paramByteBuf)
    throws Exception;
  
  protected abstract void doWriteFileRegion(FileRegion paramFileRegion)
    throws Exception;
  
  protected final Object filterOutboundMessage(Object paramObject)
    throws Exception
  {
    if ((!(paramObject instanceof ByteBuf)) && (!(paramObject instanceof FileRegion)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unsupported message type: ");
      localStringBuilder.append(StringUtil.simpleClassName(paramObject));
      localStringBuilder.append(EXPECTED_TYPES);
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    return paramObject;
  }
  
  protected abstract boolean isInputShutdown();
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected abstract ChannelFuture shutdownInput();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\oio\AbstractOioByteChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */