package io.netty.handler.codec.http2;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.collection.IntObjectMap.PrimitiveEntry;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.UnaryPromiseNotifier;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DefaultHttp2Connection
  implements Http2Connection
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultHttp2Connection.class);
  final ActiveStreams activeStreams;
  Promise<Void> closePromise;
  final ConnectionStream connectionStream;
  final List<Http2Connection.Listener> listeners;
  final DefaultEndpoint<Http2LocalFlowController> localEndpoint;
  final PropertyKeyRegistry propertyKeyRegistry;
  final DefaultEndpoint<Http2RemoteFlowController> remoteEndpoint;
  final IntObjectMap<Http2Stream> streamMap;
  
  public DefaultHttp2Connection(boolean paramBoolean)
  {
    this(paramBoolean, 100);
  }
  
  public DefaultHttp2Connection(boolean paramBoolean, int paramInt)
  {
    IntObjectHashMap localIntObjectHashMap = new IntObjectHashMap();
    this.streamMap = localIntObjectHashMap;
    this.propertyKeyRegistry = new PropertyKeyRegistry(null);
    ConnectionStream localConnectionStream = new ConnectionStream();
    this.connectionStream = localConnectionStream;
    ArrayList localArrayList = new ArrayList(4);
    this.listeners = localArrayList;
    this.activeStreams = new ActiveStreams(localArrayList);
    int i;
    if (paramBoolean) {
      i = Integer.MAX_VALUE;
    } else {
      i = paramInt;
    }
    this.localEndpoint = new DefaultEndpoint(paramBoolean, i);
    this.remoteEndpoint = new DefaultEndpoint(paramBoolean ^ true, paramInt);
    localIntObjectHashMap.put(localConnectionStream.id(), localConnectionStream);
  }
  
  static Http2Stream.State activeState(int paramInt, Http2Stream.State paramState, boolean paramBoolean1, boolean paramBoolean2)
    throws Http2Exception
  {
    int i = 2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[paramState.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return Http2Stream.State.HALF_CLOSED_LOCAL;
        }
        Http2Error localHttp2Error = Http2Error.PROTOCOL_ERROR;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Attempting to open a stream in an invalid state: ");
        localStringBuilder.append(paramState);
        throw Http2Exception.streamError(paramInt, localHttp2Error, localStringBuilder.toString(), new Object[0]);
      }
      return Http2Stream.State.HALF_CLOSED_REMOTE;
    }
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        paramState = Http2Stream.State.HALF_CLOSED_LOCAL;
      } else {
        paramState = Http2Stream.State.HALF_CLOSED_REMOTE;
      }
    }
    else {
      paramState = Http2Stream.State.OPEN;
    }
    return paramState;
  }
  
  private void closeStreamsGreaterThanLastKnownStreamId(final int paramInt, final DefaultEndpoint<?> paramDefaultEndpoint)
    throws Http2Exception
  {
    forEachActiveStream(new Http2StreamVisitor()
    {
      public boolean visit(Http2Stream paramAnonymousHttp2Stream)
      {
        if ((paramAnonymousHttp2Stream.id() > paramInt) && (paramDefaultEndpoint.isValidStreamId(paramAnonymousHttp2Stream.id()))) {
          paramAnonymousHttp2Stream.close();
        }
        return true;
      }
    });
  }
  
  private boolean isStreamMapEmpty()
  {
    int i = this.streamMap.size();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void addListener(Http2Connection.Listener paramListener)
  {
    this.listeners.add(paramListener);
  }
  
  public Future<Void> close(Promise<Void> paramPromise)
  {
    ObjectUtil.checkNotNull(paramPromise, "promise");
    Object localObject = this.closePromise;
    if (localObject != null)
    {
      if (localObject != paramPromise) {
        if (((paramPromise instanceof ChannelPromise)) && (((ChannelPromise)localObject).isVoid())) {
          this.closePromise = paramPromise;
        } else {
          this.closePromise.addListener(new UnaryPromiseNotifier(paramPromise));
        }
      }
    }
    else {
      this.closePromise = paramPromise;
    }
    if (isStreamMapEmpty())
    {
      paramPromise.trySuccess(null);
      return paramPromise;
    }
    paramPromise = this.streamMap.entries().iterator();
    if (this.activeStreams.allowModifications()) {
      this.activeStreams.incrementPendingIterations();
    }
    for (;;)
    {
      try
      {
        if (paramPromise.hasNext())
        {
          localObject = (DefaultStream)((IntObjectMap.PrimitiveEntry)paramPromise.next()).value();
          if (((DefaultStream)localObject).id() == 0) {
            continue;
          }
          ((DefaultStream)localObject).close(paramPromise);
          continue;
        }
        this.activeStreams.decrementPendingIterations();
      }
      finally
      {
        this.activeStreams.decrementPendingIterations();
      }
      localObject = (Http2Stream)((IntObjectMap.PrimitiveEntry)paramPromise.next()).value();
      if (((Http2Stream)localObject).id() != 0) {
        ((Http2Stream)localObject).close();
      }
    }
    return this.closePromise;
  }
  
  public Http2Stream connectionStream()
  {
    return this.connectionStream;
  }
  
  public Http2Stream forEachActiveStream(Http2StreamVisitor paramHttp2StreamVisitor)
    throws Http2Exception
  {
    return this.activeStreams.forEachActiveStream(paramHttp2StreamVisitor);
  }
  
  /* Error */
  public void goAwayReceived(int paramInt, long paramLong, io.netty.buffer.ByteBuf paramByteBuf)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	io/netty/handler/codec/http2/DefaultHttp2Connection:localEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   4: invokevirtual 286	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:lastStreamKnownByPeer	()I
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 6
    //   12: iload 5
    //   14: iflt +51 -> 65
    //   17: aload_0
    //   18: getfield 111	io/netty/handler/codec/http2/DefaultHttp2Connection:localEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   21: invokevirtual 286	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:lastStreamKnownByPeer	()I
    //   24: iload_1
    //   25: if_icmplt +6 -> 31
    //   28: goto +37 -> 65
    //   31: getstatic 150	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   34: ldc_w 288
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 111	io/netty/handler/codec/http2/DefaultHttp2Connection:localEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   47: invokevirtual 286	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:lastStreamKnownByPeer	()I
    //   50: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: iload_1
    //   57: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 298	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   64: athrow
    //   65: aload_0
    //   66: getfield 111	io/netty/handler/codec/http2/DefaultHttp2Connection:localEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   69: iload_1
    //   70: invokestatic 302	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:access$200	(Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;I)V
    //   73: iload 6
    //   75: aload_0
    //   76: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   79: invokeinterface 303 1 0
    //   84: if_icmpge +50 -> 134
    //   87: aload_0
    //   88: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   91: iload 6
    //   93: invokeinterface 307 2 0
    //   98: checkcast 309	io/netty/handler/codec/http2/Http2Connection$Listener
    //   101: iload_1
    //   102: lload_2
    //   103: aload 4
    //   105: invokeinterface 312 5 0
    //   110: goto +18 -> 128
    //   113: astore 7
    //   115: getstatic 70	io/netty/handler/codec/http2/DefaultHttp2Connection:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   118: ldc_w 314
    //   121: aload 7
    //   123: invokeinterface 320 3 0
    //   128: iinc 6 1
    //   131: goto -58 -> 73
    //   134: aload_0
    //   135: iload_1
    //   136: aload_0
    //   137: getfield 111	io/netty/handler/codec/http2/DefaultHttp2Connection:localEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   140: invokespecial 322	io/netty/handler/codec/http2/DefaultHttp2Connection:closeStreamsGreaterThanLastKnownStreamId	(ILio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;)V
    //   143: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	DefaultHttp2Connection
    //   0	144	1	paramInt	int
    //   0	144	2	paramLong	long
    //   0	144	4	paramByteBuf	io.netty.buffer.ByteBuf
    //   7	6	5	i	int
    //   10	119	6	j	int
    //   113	9	7	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   87	110	113	finally
  }
  
  public boolean goAwayReceived()
  {
    boolean bool;
    if (this.localEndpoint.lastStreamKnownByPeer >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean goAwaySent()
  {
    boolean bool;
    if (this.remoteEndpoint.lastStreamKnownByPeer >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public boolean goAwaySent(int paramInt, long paramLong, io.netty.buffer.ByteBuf paramByteBuf)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 113	io/netty/handler/codec/http2/DefaultHttp2Connection:remoteEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   4: invokevirtual 286	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:lastStreamKnownByPeer	()I
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 6
    //   12: iload 5
    //   14: iflt +64 -> 78
    //   17: iload_1
    //   18: aload_0
    //   19: getfield 113	io/netty/handler/codec/http2/DefaultHttp2Connection:remoteEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   22: invokevirtual 286	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:lastStreamKnownByPeer	()I
    //   25: if_icmpne +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: iload_1
    //   31: aload_0
    //   32: getfield 113	io/netty/handler/codec/http2/DefaultHttp2Connection:remoteEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   35: invokevirtual 286	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:lastStreamKnownByPeer	()I
    //   38: if_icmpgt +6 -> 44
    //   41: goto +37 -> 78
    //   44: getstatic 150	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   47: ldc_w 330
    //   50: iconst_2
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: getfield 113	io/netty/handler/codec/http2/DefaultHttp2Connection:remoteEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   60: invokevirtual 286	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:lastStreamKnownByPeer	()I
    //   63: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: iload_1
    //   70: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: aastore
    //   74: invokestatic 298	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   77: athrow
    //   78: aload_0
    //   79: getfield 113	io/netty/handler/codec/http2/DefaultHttp2Connection:remoteEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   82: iload_1
    //   83: invokestatic 302	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:access$200	(Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;I)V
    //   86: iload 6
    //   88: aload_0
    //   89: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   92: invokeinterface 303 1 0
    //   97: if_icmpge +50 -> 147
    //   100: aload_0
    //   101: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   104: iload 6
    //   106: invokeinterface 307 2 0
    //   111: checkcast 309	io/netty/handler/codec/http2/Http2Connection$Listener
    //   114: iload_1
    //   115: lload_2
    //   116: aload 4
    //   118: invokeinterface 333 5 0
    //   123: goto +18 -> 141
    //   126: astore 7
    //   128: getstatic 70	io/netty/handler/codec/http2/DefaultHttp2Connection:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   131: ldc_w 335
    //   134: aload 7
    //   136: invokeinterface 320 3 0
    //   141: iinc 6 1
    //   144: goto -58 -> 86
    //   147: aload_0
    //   148: iload_1
    //   149: aload_0
    //   150: getfield 113	io/netty/handler/codec/http2/DefaultHttp2Connection:remoteEndpoint	Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
    //   153: invokespecial 322	io/netty/handler/codec/http2/DefaultHttp2Connection:closeStreamsGreaterThanLastKnownStreamId	(ILio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;)V
    //   156: iconst_1
    //   157: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	DefaultHttp2Connection
    //   0	158	1	paramInt	int
    //   0	158	2	paramLong	long
    //   0	158	4	paramByteBuf	io.netty.buffer.ByteBuf
    //   7	6	5	i	int
    //   10	132	6	j	int
    //   126	9	7	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   100	123	126	finally
  }
  
  final boolean isClosed()
  {
    boolean bool;
    if (this.closePromise != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isServer()
  {
    return this.localEndpoint.isServer();
  }
  
  public Http2Connection.Endpoint<Http2LocalFlowController> local()
  {
    return this.localEndpoint;
  }
  
  public Http2Connection.a newKey()
  {
    return this.propertyKeyRegistry.newKey();
  }
  
  /* Error */
  void notifyClosed(Http2Stream paramHttp2Stream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   7: invokeinterface 303 1 0
    //   12: if_icmpge +44 -> 56
    //   15: aload_0
    //   16: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   19: iload_2
    //   20: invokeinterface 307 2 0
    //   25: checkcast 309	io/netty/handler/codec/http2/Http2Connection$Listener
    //   28: aload_1
    //   29: invokeinterface 352 2 0
    //   34: goto +16 -> 50
    //   37: astore_3
    //   38: getstatic 70	io/netty/handler/codec/http2/DefaultHttp2Connection:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   41: ldc_w 354
    //   44: aload_3
    //   45: invokeinterface 320 3 0
    //   50: iinc 2 1
    //   53: goto -51 -> 2
    //   56: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	DefaultHttp2Connection
    //   0	57	1	paramHttp2Stream	Http2Stream
    //   1	50	2	i	int
    //   37	8	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   15	34	37	finally
  }
  
  /* Error */
  void notifyHalfClosed(Http2Stream paramHttp2Stream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   7: invokeinterface 303 1 0
    //   12: if_icmpge +44 -> 56
    //   15: aload_0
    //   16: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   19: iload_2
    //   20: invokeinterface 307 2 0
    //   25: checkcast 309	io/netty/handler/codec/http2/Http2Connection$Listener
    //   28: aload_1
    //   29: invokeinterface 358 2 0
    //   34: goto +16 -> 50
    //   37: astore_3
    //   38: getstatic 70	io/netty/handler/codec/http2/DefaultHttp2Connection:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   41: ldc_w 360
    //   44: aload_3
    //   45: invokeinterface 320 3 0
    //   50: iinc 2 1
    //   53: goto -51 -> 2
    //   56: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	DefaultHttp2Connection
    //   0	57	1	paramHttp2Stream	Http2Stream
    //   1	50	2	i	int
    //   37	8	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   15	34	37	finally
  }
  
  public int numActiveStreams()
  {
    return this.activeStreams.size();
  }
  
  public Http2Connection.Endpoint<Http2RemoteFlowController> remote()
  {
    return this.remoteEndpoint;
  }
  
  public void removeListener(Http2Connection.Listener paramListener)
  {
    this.listeners.remove(paramListener);
  }
  
  /* Error */
  void removeStream(DefaultStream paramDefaultStream, Iterator<?> paramIterator)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 4
    //   5: aload_2
    //   6: ifnonnull +28 -> 34
    //   9: aload_0
    //   10: getfield 83	io/netty/handler/codec/http2/DefaultHttp2Connection:streamMap	Lio/netty/util/collection/IntObjectMap;
    //   13: aload_1
    //   14: invokevirtual 117	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultStream:id	()I
    //   17: invokeinterface 372 2 0
    //   22: ifnull +6 -> 28
    //   25: goto +15 -> 40
    //   28: iconst_0
    //   29: istore 4
    //   31: goto +9 -> 40
    //   34: aload_2
    //   35: invokeinterface 374 1 0
    //   40: iload 4
    //   42: ifeq +87 -> 129
    //   45: iload_3
    //   46: istore 4
    //   48: iload 4
    //   50: aload_0
    //   51: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   54: invokeinterface 303 1 0
    //   59: if_icmpge +45 -> 104
    //   62: aload_0
    //   63: getfield 100	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
    //   66: iload 4
    //   68: invokeinterface 307 2 0
    //   73: checkcast 309	io/netty/handler/codec/http2/Http2Connection$Listener
    //   76: aload_1
    //   77: invokeinterface 377 2 0
    //   82: goto +16 -> 98
    //   85: astore_2
    //   86: getstatic 70	io/netty/handler/codec/http2/DefaultHttp2Connection:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   89: ldc_w 379
    //   92: aload_2
    //   93: invokeinterface 320 3 0
    //   98: iinc 4 1
    //   101: goto -53 -> 48
    //   104: aload_0
    //   105: getfield 215	io/netty/handler/codec/http2/DefaultHttp2Connection:closePromise	Lio/netty/util/concurrent/Promise;
    //   108: ifnull +21 -> 129
    //   111: aload_0
    //   112: invokespecial 234	io/netty/handler/codec/http2/DefaultHttp2Connection:isStreamMapEmpty	()Z
    //   115: ifeq +14 -> 129
    //   118: aload_0
    //   119: getfield 215	io/netty/handler/codec/http2/DefaultHttp2Connection:closePromise	Lio/netty/util/concurrent/Promise;
    //   122: aconst_null
    //   123: invokeinterface 237 2 0
    //   128: pop
    //   129: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	DefaultHttp2Connection
    //   0	130	1	paramDefaultStream	DefaultStream
    //   0	130	2	paramIterator	Iterator<?>
    //   1	45	3	i	int
    //   3	96	4	j	int
    // Exception table:
    //   from	to	target	type
    //   62	82	85	finally
  }
  
  public Http2Stream stream(int paramInt)
  {
    return (Http2Stream)this.streamMap.get(paramInt);
  }
  
  public boolean streamMayHaveExisted(int paramInt)
  {
    boolean bool;
    if ((!this.remoteEndpoint.mayHaveCreatedStream(paramInt)) && (!this.localEndpoint.mayHaveCreatedStream(paramInt))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  final DefaultPropertyKey verifyKey(Http2Connection.a parama)
  {
    return ((DefaultPropertyKey)ObjectUtil.checkNotNull((DefaultPropertyKey)parama, "key")).verifyConnection(this);
  }
  
  private final class ActiveStreams
  {
    private final List<Http2Connection.Listener> listeners;
    private final Queue<DefaultHttp2Connection.Event> pendingEvents = new ArrayDeque(4);
    private int pendingIterations;
    private final Set<Http2Stream> streams = new LinkedHashSet();
    
    ActiveStreams()
    {
      List localList;
      this.listeners = localList;
    }
    
    public void activate(final DefaultHttp2Connection.DefaultStream paramDefaultStream)
    {
      if (allowModifications()) {
        addToActiveStreams(paramDefaultStream);
      } else {
        this.pendingEvents.add(new DefaultHttp2Connection.Event()
        {
          public void process()
          {
            DefaultHttp2Connection.ActiveStreams.this.addToActiveStreams(paramDefaultStream);
          }
        });
      }
    }
    
    /* Error */
    void addToActiveStreams(DefaultHttp2Connection.DefaultStream paramDefaultStream)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 43	io/netty/handler/codec/http2/DefaultHttp2Connection$ActiveStreams:streams	Ljava/util/Set;
      //   4: aload_1
      //   5: invokeinterface 69 2 0
      //   10: ifeq +73 -> 83
      //   13: aload_1
      //   14: invokevirtual 75	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultStream:createdBy	()Lio/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint;
      //   17: astore_2
      //   18: aload_2
      //   19: aload_2
      //   20: getfield 80	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:numActiveStreams	I
      //   23: iconst_1
      //   24: iadd
      //   25: putfield 80	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:numActiveStreams	I
      //   28: iconst_0
      //   29: istore_3
      //   30: iload_3
      //   31: aload_0
      //   32: getfield 45	io/netty/handler/codec/http2/DefaultHttp2Connection$ActiveStreams:listeners	Ljava/util/List;
      //   35: invokeinterface 86 1 0
      //   40: if_icmpge +43 -> 83
      //   43: aload_0
      //   44: getfield 45	io/netty/handler/codec/http2/DefaultHttp2Connection$ActiveStreams:listeners	Ljava/util/List;
      //   47: iload_3
      //   48: invokeinterface 90 2 0
      //   53: checkcast 92	io/netty/handler/codec/http2/Http2Connection$Listener
      //   56: aload_1
      //   57: invokeinterface 96 2 0
      //   62: goto +15 -> 77
      //   65: astore_2
      //   66: invokestatic 100	io/netty/handler/codec/http2/DefaultHttp2Connection:access$400	()Lio/netty/util/internal/logging/InternalLogger;
      //   69: ldc 102
      //   71: aload_2
      //   72: invokeinterface 108 3 0
      //   77: iinc 3 1
      //   80: goto -50 -> 30
      //   83: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	ActiveStreams
      //   0	84	1	paramDefaultStream	DefaultHttp2Connection.DefaultStream
      //   17	3	2	localDefaultEndpoint	DefaultHttp2Connection.DefaultEndpoint
      //   65	7	2	localThrowable	Throwable
      //   29	49	3	i	int
      // Exception table:
      //   from	to	target	type
      //   43	62	65	finally
    }
    
    boolean allowModifications()
    {
      boolean bool;
      if (this.pendingIterations == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void deactivate(final DefaultHttp2Connection.DefaultStream paramDefaultStream, final Iterator<?> paramIterator)
    {
      if ((!allowModifications()) && (paramIterator == null)) {
        this.pendingEvents.add(new DefaultHttp2Connection.Event()
        {
          public void process()
          {
            DefaultHttp2Connection.ActiveStreams.this.removeFromActiveStreams(paramDefaultStream, paramIterator);
          }
        });
      } else {
        removeFromActiveStreams(paramDefaultStream, paramIterator);
      }
    }
    
    /* Error */
    void decrementPendingIterations()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_0
      //   2: getfield 110	io/netty/handler/codec/http2/DefaultHttp2Connection$ActiveStreams:pendingIterations	I
      //   5: iconst_1
      //   6: isub
      //   7: putfield 110	io/netty/handler/codec/http2/DefaultHttp2Connection$ActiveStreams:pendingIterations	I
      //   10: aload_0
      //   11: invokevirtual 54	io/netty/handler/codec/http2/DefaultHttp2Connection$ActiveStreams:allowModifications	()Z
      //   14: ifeq +47 -> 61
      //   17: aload_0
      //   18: getfield 38	io/netty/handler/codec/http2/DefaultHttp2Connection$ActiveStreams:pendingEvents	Ljava/util/Queue;
      //   21: invokeinterface 124 1 0
      //   26: checkcast 126	io/netty/handler/codec/http2/DefaultHttp2Connection$Event
      //   29: astore_1
      //   30: aload_1
      //   31: ifnonnull +6 -> 37
      //   34: goto +27 -> 61
      //   37: aload_1
      //   38: invokeinterface 129 1 0
      //   43: goto -26 -> 17
      //   46: astore_1
      //   47: invokestatic 100	io/netty/handler/codec/http2/DefaultHttp2Connection:access$400	()Lio/netty/util/internal/logging/InternalLogger;
      //   50: ldc -125
      //   52: aload_1
      //   53: invokeinterface 108 3 0
      //   58: goto -41 -> 17
      //   61: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	62	0	this	ActiveStreams
      //   29	9	1	localEvent	DefaultHttp2Connection.Event
      //   46	7	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   37	43	46	finally
    }
    
    public Http2Stream forEachActiveStream(Http2StreamVisitor paramHttp2StreamVisitor)
      throws Http2Exception
    {
      incrementPendingIterations();
      try
      {
        Iterator localIterator = this.streams.iterator();
        while (localIterator.hasNext())
        {
          Http2Stream localHttp2Stream = (Http2Stream)localIterator.next();
          boolean bool = paramHttp2StreamVisitor.visit(localHttp2Stream);
          if (!bool) {
            return localHttp2Stream;
          }
        }
        return null;
      }
      finally
      {
        decrementPendingIterations();
      }
    }
    
    void incrementPendingIterations()
    {
      this.pendingIterations += 1;
    }
    
    void removeFromActiveStreams(DefaultHttp2Connection.DefaultStream paramDefaultStream, Iterator<?> paramIterator)
    {
      if (this.streams.remove(paramDefaultStream))
      {
        DefaultHttp2Connection.DefaultEndpoint localDefaultEndpoint = paramDefaultStream.createdBy();
        localDefaultEndpoint.numActiveStreams -= 1;
        DefaultHttp2Connection.this.notifyClosed(paramDefaultStream);
      }
      DefaultHttp2Connection.this.removeStream(paramDefaultStream, paramIterator);
    }
    
    public int size()
    {
      return this.streams.size();
    }
  }
  
  private final class ConnectionStream
    extends DefaultHttp2Connection.DefaultStream
  {
    ConnectionStream()
    {
      super(0, Http2Stream.State.IDLE);
    }
    
    public Http2Stream close()
    {
      throw new UnsupportedOperationException();
    }
    
    public Http2Stream closeLocalSide()
    {
      throw new UnsupportedOperationException();
    }
    
    public Http2Stream closeRemoteSide()
    {
      throw new UnsupportedOperationException();
    }
    
    DefaultHttp2Connection.DefaultEndpoint<? extends Http2FlowController> createdBy()
    {
      return null;
    }
    
    public Http2Stream headersSent(boolean paramBoolean)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean isHeadersSent()
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean isPushPromiseSent()
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean isResetSent()
    {
      return false;
    }
    
    public Http2Stream open(boolean paramBoolean)
    {
      throw new UnsupportedOperationException();
    }
    
    public Http2Stream pushPromiseSent()
    {
      throw new UnsupportedOperationException();
    }
    
    public Http2Stream resetSent()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private final class DefaultEndpoint<F extends Http2FlowController>
    implements Http2Connection.Endpoint<F>
  {
    private F flowController;
    private int lastStreamKnownByPeer = -1;
    private int maxActiveStreams;
    private final int maxReservedStreams;
    private int maxStreams;
    private int nextReservationStreamId;
    private int nextStreamIdToCreate;
    int numActiveStreams;
    int numStreams;
    private boolean pushToAllowed = true;
    private final boolean server;
    
    DefaultEndpoint(boolean paramBoolean, int paramInt)
    {
      this.server = paramBoolean;
      if (paramBoolean)
      {
        this.nextStreamIdToCreate = 2;
        this.nextReservationStreamId = 0;
      }
      else
      {
        this.nextStreamIdToCreate = 1;
        this.nextReservationStreamId = 1;
      }
      this.pushToAllowed = (true ^ paramBoolean);
      this.maxActiveStreams = Integer.MAX_VALUE;
      this.maxReservedStreams = ObjectUtil.checkPositiveOrZero(paramInt, "maxReservedStreams");
      updateMaxStreams();
    }
    
    /* Error */
    private void addStream(DefaultHttp2Connection.DefaultStream paramDefaultStream)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:this$0	Lio/netty/handler/codec/http2/DefaultHttp2Connection;
      //   4: getfield 76	io/netty/handler/codec/http2/DefaultHttp2Connection:streamMap	Lio/netty/util/collection/IntObjectMap;
      //   7: aload_1
      //   8: invokevirtual 82	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultStream:id	()I
      //   11: aload_1
      //   12: invokeinterface 88 3 0
      //   17: pop
      //   18: iconst_0
      //   19: istore_2
      //   20: iload_2
      //   21: aload_0
      //   22: getfield 36	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:this$0	Lio/netty/handler/codec/http2/DefaultHttp2Connection;
      //   25: getfield 92	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
      //   28: invokeinterface 97 1 0
      //   33: if_icmpge +46 -> 79
      //   36: aload_0
      //   37: getfield 36	io/netty/handler/codec/http2/DefaultHttp2Connection$DefaultEndpoint:this$0	Lio/netty/handler/codec/http2/DefaultHttp2Connection;
      //   40: getfield 92	io/netty/handler/codec/http2/DefaultHttp2Connection:listeners	Ljava/util/List;
      //   43: iload_2
      //   44: invokeinterface 101 2 0
      //   49: checkcast 103	io/netty/handler/codec/http2/Http2Connection$Listener
      //   52: aload_1
      //   53: invokeinterface 107 2 0
      //   58: goto +15 -> 73
      //   61: astore_3
      //   62: invokestatic 111	io/netty/handler/codec/http2/DefaultHttp2Connection:access$400	()Lio/netty/util/internal/logging/InternalLogger;
      //   65: ldc 113
      //   67: aload_3
      //   68: invokeinterface 119 3 0
      //   73: iinc 2 1
      //   76: goto -56 -> 20
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	DefaultEndpoint
      //   0	80	1	paramDefaultStream	DefaultHttp2Connection.DefaultStream
      //   19	55	2	i	int
      //   61	7	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   36	58	61	finally
    }
    
    private void checkNewStreamAllowed(int paramInt, Http2Stream.State paramState)
      throws Http2Exception
    {
      int i = this.lastStreamKnownByPeer;
      if ((i >= 0) && (paramInt > i)) {
        throw Http2Exception.streamError(paramInt, Http2Error.REFUSED_STREAM, "Cannot create stream %d greater than Last-Stream-ID %d from GOAWAY.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lastStreamKnownByPeer) });
      }
      if (!isValidStreamId(paramInt))
      {
        if (paramInt >= 0)
        {
          Http2Error localHttp2Error = Http2Error.PROTOCOL_ERROR;
          if (this.server) {
            paramState = "server";
          } else {
            paramState = "client";
          }
          throw Http2Exception.connectionError(localHttp2Error, "Request stream %d is not correct for %s connection", new Object[] { Integer.valueOf(paramInt), paramState });
        }
        throw new Http2NoMoreStreamIdsException();
      }
      i = this.nextStreamIdToCreate;
      if (paramInt >= i)
      {
        if (i > 0)
        {
          if ((paramState != Http2Stream.State.RESERVED_LOCAL) && (paramState != Http2Stream.State.RESERVED_REMOTE)) {
            i = 0;
          } else {
            i = 1;
          }
          if (((i == 0) && (!canOpenStream())) || ((i != 0) && (this.numStreams >= this.maxStreams))) {
            throw Http2Exception.streamError(paramInt, Http2Error.REFUSED_STREAM, "Maximum active streams violated for this endpoint.", new Object[0]);
          }
          if (!DefaultHttp2Connection.this.isClosed()) {
            return;
          }
          throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Attempted to create stream id %d after connection was closed", new Object[] { Integer.valueOf(paramInt) });
        }
        throw Http2Exception.connectionError(Http2Error.REFUSED_STREAM, "Stream IDs are exhausted for this endpoint.", new Object[0]);
      }
      throw Http2Exception.closedStreamError(Http2Error.PROTOCOL_ERROR, "Request stream %d is behind the next expected stream %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.nextStreamIdToCreate) });
    }
    
    private void incrementExpectedStreamId(int paramInt)
    {
      int i = this.nextReservationStreamId;
      if ((paramInt > i) && (i >= 0)) {
        this.nextReservationStreamId = paramInt;
      }
      this.nextStreamIdToCreate = (paramInt + 2);
      this.numStreams += 1;
    }
    
    private boolean isLocal()
    {
      boolean bool;
      if (this == DefaultHttp2Connection.this.localEndpoint) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private void lastStreamKnownByPeer(int paramInt)
    {
      this.lastStreamKnownByPeer = paramInt;
    }
    
    private void updateMaxStreams()
    {
      this.maxStreams = ((int)Math.min(2147483647L, this.maxActiveStreams + this.maxReservedStreams));
    }
    
    public void allowPushTo(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.server)) {
        throw new IllegalArgumentException("Servers do not allow push");
      }
      this.pushToAllowed = paramBoolean;
    }
    
    public boolean allowPushTo()
    {
      return this.pushToAllowed;
    }
    
    public boolean canOpenStream()
    {
      boolean bool;
      if (this.numActiveStreams < this.maxActiveStreams) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public DefaultHttp2Connection.DefaultStream createStream(int paramInt, boolean paramBoolean)
      throws Http2Exception
    {
      Object localObject = DefaultHttp2Connection.activeState(paramInt, Http2Stream.State.IDLE, isLocal(), paramBoolean);
      checkNewStreamAllowed(paramInt, (Http2Stream.State)localObject);
      localObject = new DefaultHttp2Connection.DefaultStream(DefaultHttp2Connection.this, paramInt, (Http2Stream.State)localObject);
      incrementExpectedStreamId(paramInt);
      addStream((DefaultHttp2Connection.DefaultStream)localObject);
      ((DefaultHttp2Connection.DefaultStream)localObject).activate();
      return (DefaultHttp2Connection.DefaultStream)localObject;
    }
    
    public boolean created(Http2Stream paramHttp2Stream)
    {
      boolean bool;
      if (((paramHttp2Stream instanceof DefaultHttp2Connection.DefaultStream)) && (((DefaultHttp2Connection.DefaultStream)paramHttp2Stream).createdBy() == this)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public F flowController()
    {
      return this.flowController;
    }
    
    public void flowController(F paramF)
    {
      this.flowController = ((Http2FlowController)ObjectUtil.checkNotNull(paramF, "flowController"));
    }
    
    public int incrementAndGetNextStreamId()
    {
      int i = this.nextReservationStreamId;
      int j = i;
      if (i >= 0)
      {
        j = i + 2;
        this.nextReservationStreamId = j;
      }
      return j;
    }
    
    public boolean isServer()
    {
      return this.server;
    }
    
    public boolean isValidStreamId(int paramInt)
    {
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (paramInt > 0)
      {
        boolean bool3 = this.server;
        boolean bool4;
        if ((paramInt & 0x1) == 0) {
          bool4 = true;
        } else {
          bool4 = false;
        }
        bool2 = bool1;
        if (bool3 == bool4) {
          bool2 = true;
        }
      }
      return bool2;
    }
    
    public int lastStreamCreated()
    {
      int i = this.nextStreamIdToCreate;
      if (i > 1) {
        i -= 2;
      } else {
        i = 0;
      }
      return i;
    }
    
    public int lastStreamKnownByPeer()
    {
      return this.lastStreamKnownByPeer;
    }
    
    public int maxActiveStreams()
    {
      return this.maxActiveStreams;
    }
    
    public void maxActiveStreams(int paramInt)
    {
      this.maxActiveStreams = paramInt;
      updateMaxStreams();
    }
    
    public boolean mayHaveCreatedStream(int paramInt)
    {
      boolean bool;
      if ((isValidStreamId(paramInt)) && (paramInt <= lastStreamCreated())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int numActiveStreams()
    {
      return this.numActiveStreams;
    }
    
    public Http2Connection.Endpoint<? extends Http2FlowController> opposite()
    {
      DefaultEndpoint localDefaultEndpoint;
      if (isLocal()) {
        localDefaultEndpoint = DefaultHttp2Connection.this.remoteEndpoint;
      } else {
        localDefaultEndpoint = DefaultHttp2Connection.this.localEndpoint;
      }
      return localDefaultEndpoint;
    }
    
    public DefaultHttp2Connection.DefaultStream reservePushStream(int paramInt, Http2Stream paramHttp2Stream)
      throws Http2Exception
    {
      if (paramHttp2Stream != null)
      {
        if (isLocal() ? paramHttp2Stream.state().localSideOpen() : paramHttp2Stream.state().remoteSideOpen())
        {
          if (opposite().allowPushTo())
          {
            if (isLocal()) {
              paramHttp2Stream = Http2Stream.State.RESERVED_LOCAL;
            } else {
              paramHttp2Stream = Http2Stream.State.RESERVED_REMOTE;
            }
            checkNewStreamAllowed(paramInt, paramHttp2Stream);
            paramHttp2Stream = new DefaultHttp2Connection.DefaultStream(DefaultHttp2Connection.this, paramInt, paramHttp2Stream);
            incrementExpectedStreamId(paramInt);
            addStream(paramHttp2Stream);
            return paramHttp2Stream;
          }
          throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server push not allowed to opposite endpoint", new Object[0]);
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d is not open for sending push promise", new Object[] { Integer.valueOf(paramHttp2Stream.id()) });
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Parent stream missing", new Object[0]);
    }
  }
  
  final class DefaultPropertyKey
    implements Http2Connection.a
  {
    final int index;
    
    DefaultPropertyKey(int paramInt)
    {
      this.index = paramInt;
    }
    
    DefaultPropertyKey verifyConnection(Http2Connection paramHttp2Connection)
    {
      if (paramHttp2Connection == DefaultHttp2Connection.this) {
        return this;
      }
      throw new IllegalArgumentException("Using a key that was not created by this connection");
    }
  }
  
  private class DefaultStream
    implements Http2Stream
  {
    private static final byte META_STATE_RECV_HEADERS = 16;
    private static final byte META_STATE_RECV_TRAILERS = 32;
    private static final byte META_STATE_SENT_HEADERS = 2;
    private static final byte META_STATE_SENT_PUSHPROMISE = 8;
    private static final byte META_STATE_SENT_RST = 1;
    private static final byte META_STATE_SENT_TRAILERS = 4;
    private final int id;
    private byte metaState;
    private final PropertyMap properties = new PropertyMap(null);
    private Http2Stream.State state;
    
    DefaultStream(int paramInt, Http2Stream.State paramState)
    {
      this.id = paramInt;
      this.state = paramState;
    }
    
    void activate()
    {
      Http2Stream.State localState = this.state;
      if (localState == Http2Stream.State.HALF_CLOSED_LOCAL) {
        headersSent(false);
      } else if (localState == Http2Stream.State.HALF_CLOSED_REMOTE) {
        headersReceived(false);
      }
      DefaultHttp2Connection.this.activeStreams.activate(this);
    }
    
    public Http2Stream close()
    {
      return close(null);
    }
    
    Http2Stream close(Iterator<?> paramIterator)
    {
      Http2Stream.State localState = this.state;
      Object localObject = Http2Stream.State.CLOSED;
      if (localState == localObject) {
        return this;
      }
      this.state = ((Http2Stream.State)localObject);
      localObject = createdBy();
      ((DefaultHttp2Connection.DefaultEndpoint)localObject).numStreams -= 1;
      DefaultHttp2Connection.this.activeStreams.deactivate(this, paramIterator);
      return this;
    }
    
    public Http2Stream closeLocalSide()
    {
      int i = DefaultHttp2Connection.2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
      if (i != 4)
      {
        if (i != 5) {
          close();
        }
      }
      else
      {
        this.state = Http2Stream.State.HALF_CLOSED_LOCAL;
        DefaultHttp2Connection.this.notifyHalfClosed(this);
      }
      return this;
    }
    
    public Http2Stream closeRemoteSide()
    {
      int i = DefaultHttp2Connection.2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
      if (i != 4)
      {
        if (i != 6) {
          close();
        }
      }
      else
      {
        this.state = Http2Stream.State.HALF_CLOSED_REMOTE;
        DefaultHttp2Connection.this.notifyHalfClosed(this);
      }
      return this;
    }
    
    DefaultHttp2Connection.DefaultEndpoint<? extends Http2FlowController> createdBy()
    {
      DefaultHttp2Connection.DefaultEndpoint localDefaultEndpoint;
      if (DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.id)) {
        localDefaultEndpoint = DefaultHttp2Connection.this.localEndpoint;
      } else {
        localDefaultEndpoint = DefaultHttp2Connection.this.remoteEndpoint;
      }
      return localDefaultEndpoint;
    }
    
    public final <V> V getProperty(Http2Connection.a parama)
    {
      return (V)this.properties.get(DefaultHttp2Connection.this.verifyKey(parama));
    }
    
    public Http2Stream headersReceived(boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        int i = this.metaState;
        int j;
        if (isHeadersReceived()) {
          j = 32;
        } else {
          j = 16;
        }
        this.metaState = ((byte)(byte)(i | j));
      }
      return this;
    }
    
    public Http2Stream headersSent(boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        int i = this.metaState;
        int j;
        if (isHeadersSent()) {
          j = 4;
        } else {
          j = 2;
        }
        this.metaState = ((byte)(byte)(i | j));
      }
      return this;
    }
    
    public final int id()
    {
      return this.id;
    }
    
    public boolean isHeadersReceived()
    {
      boolean bool;
      if ((this.metaState & 0x10) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isHeadersSent()
    {
      boolean bool;
      if ((this.metaState & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    final boolean isLocal()
    {
      return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.id);
    }
    
    public boolean isPushPromiseSent()
    {
      boolean bool;
      if ((this.metaState & 0x8) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isResetSent()
    {
      int i = this.metaState;
      boolean bool = true;
      if ((i & 0x1) == 0) {
        bool = false;
      }
      return bool;
    }
    
    public boolean isTrailersReceived()
    {
      boolean bool;
      if ((this.metaState & 0x20) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isTrailersSent()
    {
      boolean bool;
      if ((this.metaState & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Http2Stream open(boolean paramBoolean)
      throws Http2Exception
    {
      this.state = DefaultHttp2Connection.activeState(this.id, this.state, isLocal(), paramBoolean);
      if (createdBy().canOpenStream())
      {
        activate();
        return this;
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Maximum active streams violated for this endpoint.", new Object[0]);
    }
    
    public Http2Stream pushPromiseSent()
    {
      this.metaState = ((byte)(byte)(this.metaState | 0x8));
      return this;
    }
    
    public final <V> V removeProperty(Http2Connection.a parama)
    {
      return (V)this.properties.remove(DefaultHttp2Connection.this.verifyKey(parama));
    }
    
    public Http2Stream resetSent()
    {
      this.metaState = ((byte)(byte)(this.metaState | 0x1));
      return this;
    }
    
    public final <V> V setProperty(Http2Connection.a parama, V paramV)
    {
      return (V)this.properties.add(DefaultHttp2Connection.this.verifyKey(parama), paramV);
    }
    
    public final Http2Stream.State state()
    {
      return this.state;
    }
    
    private class PropertyMap
    {
      Object[] values = EmptyArrays.EMPTY_OBJECTS;
      
      private PropertyMap() {}
      
      <V> V add(DefaultHttp2Connection.DefaultPropertyKey paramDefaultPropertyKey, V paramV)
      {
        resizeIfNecessary(paramDefaultPropertyKey.index);
        Object[] arrayOfObject = this.values;
        int i = paramDefaultPropertyKey.index;
        paramDefaultPropertyKey = arrayOfObject[i];
        arrayOfObject[i] = paramV;
        return paramDefaultPropertyKey;
      }
      
      <V> V get(DefaultHttp2Connection.DefaultPropertyKey paramDefaultPropertyKey)
      {
        int i = paramDefaultPropertyKey.index;
        paramDefaultPropertyKey = this.values;
        if (i >= paramDefaultPropertyKey.length) {
          return null;
        }
        return paramDefaultPropertyKey[i];
      }
      
      <V> V remove(DefaultHttp2Connection.DefaultPropertyKey paramDefaultPropertyKey)
      {
        int i = paramDefaultPropertyKey.index;
        Object[] arrayOfObject = this.values;
        int j = arrayOfObject.length;
        paramDefaultPropertyKey = null;
        if (i < j)
        {
          paramDefaultPropertyKey = arrayOfObject[i];
          arrayOfObject[i] = null;
        }
        return paramDefaultPropertyKey;
      }
      
      void resizeIfNecessary(int paramInt)
      {
        Object[] arrayOfObject = this.values;
        if (paramInt >= arrayOfObject.length) {
          this.values = Arrays.copyOf(arrayOfObject, DefaultHttp2Connection.this.propertyKeyRegistry.size());
        }
      }
    }
  }
  
  static abstract interface Event
  {
    public abstract void process();
  }
  
  private final class PropertyKeyRegistry
  {
    final List<DefaultHttp2Connection.DefaultPropertyKey> keys = new ArrayList(4);
    
    private PropertyKeyRegistry() {}
    
    DefaultHttp2Connection.DefaultPropertyKey newKey()
    {
      DefaultHttp2Connection.DefaultPropertyKey localDefaultPropertyKey = new DefaultHttp2Connection.DefaultPropertyKey(DefaultHttp2Connection.this, this.keys.size());
      this.keys.add(localDefaultPropertyKey);
      return localDefaultPropertyKey;
    }
    
    int size()
    {
      return this.keys.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */