package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.PlatformDependent;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class SpdySession
{
  private final AtomicInteger activeLocalStreams = new AtomicInteger();
  private final AtomicInteger activeRemoteStreams = new AtomicInteger();
  private final Map<Integer, StreamState> activeStreams = PlatformDependent.newConcurrentHashMap();
  private final AtomicInteger receiveWindowSize;
  private final AtomicInteger sendWindowSize;
  private final StreamComparator streamComparator = new StreamComparator();
  
  SpdySession(int paramInt1, int paramInt2)
  {
    this.sendWindowSize = new AtomicInteger(paramInt1);
    this.receiveWindowSize = new AtomicInteger(paramInt2);
  }
  
  private StreamState removeActiveStream(int paramInt, boolean paramBoolean)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.remove(Integer.valueOf(paramInt));
    if (localStreamState != null) {
      if (paramBoolean) {
        this.activeRemoteStreams.decrementAndGet();
      } else {
        this.activeLocalStreams.decrementAndGet();
      }
    }
    return localStreamState;
  }
  
  void acceptStream(int paramInt1, byte paramByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (((!paramBoolean1) || (!paramBoolean2)) && ((StreamState)this.activeStreams.put(Integer.valueOf(paramInt1), new StreamState(paramByte, paramBoolean1, paramBoolean2, paramInt2, paramInt3)) == null)) {
      if (paramBoolean3) {
        this.activeRemoteStreams.incrementAndGet();
      } else {
        this.activeLocalStreams.incrementAndGet();
      }
    }
  }
  
  Map<Integer, StreamState> activeStreams()
  {
    TreeMap localTreeMap = new TreeMap(this.streamComparator);
    localTreeMap.putAll(this.activeStreams);
    return localTreeMap;
  }
  
  void closeLocalSide(int paramInt, boolean paramBoolean)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    if (localStreamState != null)
    {
      localStreamState.closeLocalSide();
      if (localStreamState.isRemoteSideClosed()) {
        removeActiveStream(paramInt, paramBoolean);
      }
    }
  }
  
  void closeRemoteSide(int paramInt, boolean paramBoolean)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    if (localStreamState != null)
    {
      localStreamState.closeRemoteSide();
      if (localStreamState.isLocalSideClosed()) {
        removeActiveStream(paramInt, paramBoolean);
      }
    }
  }
  
  PendingWrite getPendingWrite(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0)
    {
      localObject1 = activeStreams().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StreamState)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (((StreamState)localObject2).getSendWindowSize() > 0)
        {
          localObject2 = ((StreamState)localObject2).getPendingWrite();
          if (localObject2 != null) {
            return (PendingWrite)localObject2;
          }
        }
      }
      return null;
    }
    Object localObject2 = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    if (localObject2 != null) {
      localObject1 = ((StreamState)localObject2).getPendingWrite();
    }
    return (PendingWrite)localObject1;
  }
  
  int getReceiveWindowSizeLowerBound(int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      return 0;
    }
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    paramInt = i;
    if (localStreamState != null) {
      paramInt = localStreamState.getReceiveWindowSizeLowerBound();
    }
    return paramInt;
  }
  
  int getSendWindowSize(int paramInt)
  {
    if (paramInt == 0) {
      return this.sendWindowSize.get();
    }
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    if (localStreamState != null) {
      paramInt = localStreamState.getSendWindowSize();
    } else {
      paramInt = -1;
    }
    return paramInt;
  }
  
  boolean hasReceivedReply(int paramInt)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    boolean bool;
    if ((localStreamState != null) && (localStreamState.hasReceivedReply())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isActiveStream(int paramInt)
  {
    return this.activeStreams.containsKey(Integer.valueOf(paramInt));
  }
  
  boolean isLocalSideClosed(int paramInt)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    boolean bool;
    if ((localStreamState != null) && (!localStreamState.isLocalSideClosed())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  boolean isRemoteSideClosed(int paramInt)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    boolean bool;
    if ((localStreamState != null) && (!localStreamState.isRemoteSideClosed())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  boolean noActiveStreams()
  {
    return this.activeStreams.isEmpty();
  }
  
  int numActiveStreams(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.activeRemoteStreams.get();
    }
    return this.activeLocalStreams.get();
  }
  
  boolean putPendingWrite(int paramInt, PendingWrite paramPendingWrite)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    boolean bool;
    if ((localStreamState != null) && (localStreamState.putPendingWrite(paramPendingWrite))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void receivedReply(int paramInt)
  {
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    if (localStreamState != null) {
      localStreamState.receivedReply();
    }
  }
  
  PendingWrite removePendingWrite(int paramInt)
  {
    Object localObject = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      localObject = ((StreamState)localObject).removePendingWrite();
    } else {
      localObject = null;
    }
    return (PendingWrite)localObject;
  }
  
  void removeStream(int paramInt, Throwable paramThrowable, boolean paramBoolean)
  {
    StreamState localStreamState = removeActiveStream(paramInt, paramBoolean);
    if (localStreamState != null) {
      localStreamState.clearPendingWrites(paramThrowable);
    }
  }
  
  void updateAllReceiveWindowSizes(int paramInt)
  {
    Iterator localIterator = this.activeStreams.values().iterator();
    while (localIterator.hasNext())
    {
      StreamState localStreamState = (StreamState)localIterator.next();
      localStreamState.updateReceiveWindowSize(paramInt);
      if (paramInt < 0) {
        localStreamState.setReceiveWindowSizeLowerBound(paramInt);
      }
    }
  }
  
  void updateAllSendWindowSizes(int paramInt)
  {
    Iterator localIterator = this.activeStreams.values().iterator();
    while (localIterator.hasNext()) {
      ((StreamState)localIterator.next()).updateSendWindowSize(paramInt);
    }
  }
  
  int updateReceiveWindowSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return this.receiveWindowSize.addAndGet(paramInt2);
    }
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt1));
    if (localStreamState == null) {
      return -1;
    }
    if (paramInt2 > 0) {
      localStreamState.setReceiveWindowSizeLowerBound(0);
    }
    return localStreamState.updateReceiveWindowSize(paramInt2);
  }
  
  int updateSendWindowSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return this.sendWindowSize.addAndGet(paramInt2);
    }
    StreamState localStreamState = (StreamState)this.activeStreams.get(Integer.valueOf(paramInt1));
    if (localStreamState != null) {
      paramInt1 = localStreamState.updateSendWindowSize(paramInt2);
    } else {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public static final class PendingWrite
  {
    final ChannelPromise promise;
    final SpdyDataFrame spdyDataFrame;
    
    PendingWrite(SpdyDataFrame paramSpdyDataFrame, ChannelPromise paramChannelPromise)
    {
      this.spdyDataFrame = paramSpdyDataFrame;
      this.promise = paramChannelPromise;
    }
    
    void fail(Throwable paramThrowable)
    {
      this.spdyDataFrame.release();
      this.promise.setFailure(paramThrowable);
    }
  }
  
  private final class StreamComparator
    implements Comparator<Integer>
  {
    StreamComparator() {}
    
    public int compare(Integer paramInteger1, Integer paramInteger2)
    {
      SpdySession.StreamState localStreamState1 = (SpdySession.StreamState)SpdySession.this.activeStreams.get(paramInteger1);
      SpdySession.StreamState localStreamState2 = (SpdySession.StreamState)SpdySession.this.activeStreams.get(paramInteger2);
      int i = localStreamState1.getPriority() - localStreamState2.getPriority();
      if (i != 0) {
        return i;
      }
      return paramInteger1.intValue() - paramInteger2.intValue();
    }
  }
  
  private static final class StreamState
  {
    private boolean localSideClosed;
    private final Queue<SpdySession.PendingWrite> pendingWriteQueue = new ConcurrentLinkedQueue();
    private final byte priority;
    private final AtomicInteger receiveWindowSize;
    private int receiveWindowSizeLowerBound;
    private boolean receivedReply;
    private boolean remoteSideClosed;
    private final AtomicInteger sendWindowSize;
    
    StreamState(byte paramByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
    {
      this.priority = ((byte)paramByte);
      this.remoteSideClosed = paramBoolean1;
      this.localSideClosed = paramBoolean2;
      this.sendWindowSize = new AtomicInteger(paramInt1);
      this.receiveWindowSize = new AtomicInteger(paramInt2);
    }
    
    void clearPendingWrites(Throwable paramThrowable)
    {
      for (;;)
      {
        SpdySession.PendingWrite localPendingWrite = (SpdySession.PendingWrite)this.pendingWriteQueue.poll();
        if (localPendingWrite == null) {
          return;
        }
        localPendingWrite.fail(paramThrowable);
      }
    }
    
    void closeLocalSide()
    {
      this.localSideClosed = true;
    }
    
    void closeRemoteSide()
    {
      this.remoteSideClosed = true;
    }
    
    SpdySession.PendingWrite getPendingWrite()
    {
      return (SpdySession.PendingWrite)this.pendingWriteQueue.peek();
    }
    
    byte getPriority()
    {
      return this.priority;
    }
    
    int getReceiveWindowSizeLowerBound()
    {
      return this.receiveWindowSizeLowerBound;
    }
    
    int getSendWindowSize()
    {
      return this.sendWindowSize.get();
    }
    
    boolean hasReceivedReply()
    {
      return this.receivedReply;
    }
    
    boolean isLocalSideClosed()
    {
      return this.localSideClosed;
    }
    
    boolean isRemoteSideClosed()
    {
      return this.remoteSideClosed;
    }
    
    boolean putPendingWrite(SpdySession.PendingWrite paramPendingWrite)
    {
      return this.pendingWriteQueue.offer(paramPendingWrite);
    }
    
    void receivedReply()
    {
      this.receivedReply = true;
    }
    
    SpdySession.PendingWrite removePendingWrite()
    {
      return (SpdySession.PendingWrite)this.pendingWriteQueue.poll();
    }
    
    void setReceiveWindowSizeLowerBound(int paramInt)
    {
      this.receiveWindowSizeLowerBound = paramInt;
    }
    
    int updateReceiveWindowSize(int paramInt)
    {
      return this.receiveWindowSize.addAndGet(paramInt);
    }
    
    int updateSendWindowSize(int paramInt)
    {
      return this.sendWindowSize.addAndGet(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */