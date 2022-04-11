package io.netty.handler.codec.http2;

import io.netty.util.collection.IntCollections;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.collection.IntObjectMap.PrimitiveEntry;
import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.EmptyPriorityQueue;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import io.netty.util.internal.SystemPropertyUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class WeightedFairQueueByteDistributor
  implements StreamByteDistributor
{
  private static final int DEFAULT_MAX_STATE_ONLY_SIZE = 5;
  static final int INITIAL_CHILDREN_MAP_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.http2.childrenMapSize", 2));
  private int allocationQuantum = 1024;
  private final Http2Connection connection;
  private final State connectionState;
  private final int maxStateOnlySize;
  private final Http2Connection.a stateKey;
  private final IntObjectMap<State> stateOnlyMap;
  private final PriorityQueue<State> stateOnlyRemovalQueue;
  
  public WeightedFairQueueByteDistributor(Http2Connection paramHttp2Connection)
  {
    this(paramHttp2Connection, 5);
  }
  
  public WeightedFairQueueByteDistributor(Http2Connection paramHttp2Connection, int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "maxStateOnlySize");
    if (paramInt == 0)
    {
      this.stateOnlyMap = IntCollections.emptyMap();
      this.stateOnlyRemovalQueue = EmptyPriorityQueue.instance();
    }
    else
    {
      this.stateOnlyMap = new IntObjectHashMap(paramInt);
      this.stateOnlyRemovalQueue = new DefaultPriorityQueue(StateOnlyComparator.INSTANCE, paramInt + 2);
    }
    this.maxStateOnlySize = paramInt;
    this.connection = paramHttp2Connection;
    Http2Connection.a locala = paramHttp2Connection.newKey();
    this.stateKey = locala;
    Http2Stream localHttp2Stream = paramHttp2Connection.connectionStream();
    State localState = new State(localHttp2Stream, 16);
    this.connectionState = localState;
    localHttp2Stream.setProperty(locala, localState);
    paramHttp2Connection.addListener(new Http2ConnectionAdapter()
    {
      public void onStreamActive(Http2Stream paramAnonymousHttp2Stream)
      {
        WeightedFairQueueByteDistributor.this.state(paramAnonymousHttp2Stream).setStreamReservedOrActivated();
      }
      
      public void onStreamAdded(Http2Stream paramAnonymousHttp2Stream)
      {
        WeightedFairQueueByteDistributor.State localState = (WeightedFairQueueByteDistributor.State)WeightedFairQueueByteDistributor.this.stateOnlyMap.remove(paramAnonymousHttp2Stream.id());
        if (localState == null)
        {
          localState = new WeightedFairQueueByteDistributor.State(WeightedFairQueueByteDistributor.this, paramAnonymousHttp2Stream);
          ArrayList localArrayList = new ArrayList(1);
          WeightedFairQueueByteDistributor.this.connectionState.takeChild(localState, false, localArrayList);
          WeightedFairQueueByteDistributor.this.notifyParentChanged(localArrayList);
        }
        else
        {
          WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.removeTyped(localState);
          localState.stream = paramAnonymousHttp2Stream;
        }
        int i = WeightedFairQueueByteDistributor.2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[paramAnonymousHttp2Stream.state().ordinal()];
        if ((i == 1) || (i == 2)) {
          localState.setStreamReservedOrActivated();
        }
        paramAnonymousHttp2Stream.setProperty(WeightedFairQueueByteDistributor.this.stateKey, localState);
      }
      
      public void onStreamClosed(Http2Stream paramAnonymousHttp2Stream)
      {
        WeightedFairQueueByteDistributor.this.state(paramAnonymousHttp2Stream).close();
      }
      
      public void onStreamRemoved(Http2Stream paramAnonymousHttp2Stream)
      {
        paramAnonymousHttp2Stream = WeightedFairQueueByteDistributor.this.state(paramAnonymousHttp2Stream);
        paramAnonymousHttp2Stream.stream = null;
        if (WeightedFairQueueByteDistributor.this.maxStateOnlySize == 0)
        {
          paramAnonymousHttp2Stream.parent.removeChild(paramAnonymousHttp2Stream);
          return;
        }
        if (WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.size() == WeightedFairQueueByteDistributor.this.maxStateOnlySize)
        {
          WeightedFairQueueByteDistributor.State localState = (WeightedFairQueueByteDistributor.State)WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.peek();
          if (WeightedFairQueueByteDistributor.StateOnlyComparator.INSTANCE.compare(localState, paramAnonymousHttp2Stream) >= 0)
          {
            paramAnonymousHttp2Stream.parent.removeChild(paramAnonymousHttp2Stream);
            return;
          }
          WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.poll();
          localState.parent.removeChild(localState);
          WeightedFairQueueByteDistributor.this.stateOnlyMap.remove(localState.streamId);
        }
        WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.add(paramAnonymousHttp2Stream);
        WeightedFairQueueByteDistributor.this.stateOnlyMap.put(paramAnonymousHttp2Stream.streamId, paramAnonymousHttp2Stream);
      }
    });
  }
  
  private int distribute(int paramInt, StreamByteDistributor.Writer paramWriter, State paramState)
    throws Http2Exception
  {
    if (paramState.isActive())
    {
      int i = Math.min(paramInt, paramState.streamableBytes);
      paramState.write(i, paramWriter);
      if ((i == 0) && (paramInt != 0)) {
        paramState.updateStreamableBytes(paramState.streamableBytes, false);
      }
      return i;
    }
    return distributeToChildren(paramInt, paramWriter, paramState);
  }
  
  private int distributeToChildren(int paramInt, StreamByteDistributor.Writer paramWriter, State paramState)
    throws Http2Exception
  {
    long l = paramState.totalQueuedWeights;
    State localState1 = paramState.pollPseudoTimeQueue();
    State localState2 = paramState.peekPseudoTimeQueue();
    localState1.setDistributing();
    if (localState2 != null) {}
    try
    {
      paramInt = Math.min(paramInt, (int)Math.min((localState2.pseudoTimeToWrite - localState1.pseudoTimeToWrite) * localState1.weight / l + this.allocationQuantum, 2147483647L));
      paramInt = distribute(paramInt, paramWriter, localState1);
      paramState.pseudoTime += paramInt;
      localState1.updatePseudoTime(paramState, paramInt, l);
      return paramInt;
    }
    finally
    {
      localState1.unsetDistributing();
      if (localState1.activeCountForTree != 0) {
        paramState.offerPseudoTimeQueue(localState1);
      }
    }
  }
  
  private State state(int paramInt)
  {
    Object localObject = this.connection.stream(paramInt);
    if (localObject != null) {
      localObject = state((Http2Stream)localObject);
    } else {
      localObject = (State)this.stateOnlyMap.get(paramInt);
    }
    return (State)localObject;
  }
  
  private State state(Http2Stream paramHttp2Stream)
  {
    return (State)paramHttp2Stream.getProperty(this.stateKey);
  }
  
  public void allocationQuantum(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "allocationQuantum");
    this.allocationQuantum = paramInt;
  }
  
  public boolean distribute(int paramInt, StreamByteDistributor.Writer paramWriter)
    throws Http2Exception
  {
    int i = this.connectionState.activeCountForTree;
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    int j;
    int k;
    do
    {
      do
      {
        State localState = this.connectionState;
        j = localState.activeCountForTree;
        i = paramInt - distributeToChildren(paramInt, paramWriter, localState);
        k = this.connectionState.activeCountForTree;
        if (k == 0) {
          break;
        }
        paramInt = i;
      } while (i > 0);
      paramInt = i;
    } while (j != k);
    if (k != 0) {
      bool = true;
    }
    return bool;
  }
  
  boolean isChild(int paramInt1, int paramInt2, short paramShort)
  {
    State localState1 = state(paramInt2);
    if (localState1.children.containsKey(paramInt1))
    {
      State localState2 = state(paramInt1);
      if ((localState2.parent == localState1) && (localState2.weight == paramShort))
      {
        bool = true;
        break label56;
      }
    }
    boolean bool = false;
    label56:
    return bool;
  }
  
  void notifyParentChanged(List<ParentChangedEvent> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      ParentChangedEvent localParentChangedEvent = (ParentChangedEvent)paramList.get(i);
      this.stateOnlyRemovalQueue.priorityChanged(localParentChangedEvent.state);
      State localState1 = localParentChangedEvent.state;
      State localState2 = localState1.parent;
      if ((localState2 != null) && (localState1.activeCountForTree != 0))
      {
        localState2.offerAndInitializePseudoTime(localState1);
        localState1 = localParentChangedEvent.state;
        localState1.parent.activeCountChangeForTree(localState1.activeCountForTree);
      }
    }
  }
  
  int numChildren(int paramInt)
  {
    State localState = state(paramInt);
    if (localState == null) {
      paramInt = 0;
    } else {
      paramInt = localState.children.size();
    }
    return paramInt;
  }
  
  public void updateDependencyTree(int paramInt1, int paramInt2, short paramShort, boolean paramBoolean)
  {
    Object localObject1 = state(paramInt1);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (this.maxStateOnlySize == 0) {
        return;
      }
      localObject2 = new State(paramInt1);
      this.stateOnlyRemovalQueue.add(localObject2);
      this.stateOnlyMap.put(paramInt1, localObject2);
    }
    Object localObject3 = state(paramInt2);
    paramInt1 = 0;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      if (this.maxStateOnlySize == 0) {
        return;
      }
      localObject1 = new State(paramInt2);
      this.stateOnlyRemovalQueue.add(localObject1);
      this.stateOnlyMap.put(paramInt2, localObject1);
      localObject3 = new ArrayList(1);
      this.connectionState.takeChild((State)localObject1, false, (List)localObject3);
      notifyParentChanged((List)localObject3);
    }
    if (((State)localObject2).activeCountForTree != 0)
    {
      localObject3 = ((State)localObject2).parent;
      if (localObject3 != null) {
        ((State)localObject3).totalQueuedWeights += paramShort - ((State)localObject2).weight;
      }
    }
    ((State)localObject2).weight = ((short)paramShort);
    if ((localObject1 != ((State)localObject2).parent) || ((paramBoolean) && (((State)localObject1).children.size() != 1)))
    {
      if (((State)localObject1).isDescendantOf((State)localObject2))
      {
        if (paramBoolean) {
          paramInt1 = ((State)localObject1).children.size();
        } else {
          paramInt1 = 0;
        }
        localObject3 = new ArrayList(paramInt1 + 2);
        ((State)localObject2).parent.takeChild((State)localObject1, false, (List)localObject3);
      }
      else
      {
        if (paramBoolean) {
          paramInt1 = ((State)localObject1).children.size();
        }
        localObject3 = new ArrayList(paramInt1 + 1);
      }
      ((State)localObject1).takeChild((State)localObject2, paramBoolean, (List)localObject3);
      notifyParentChanged((List)localObject3);
    }
    while (this.stateOnlyRemovalQueue.size() > this.maxStateOnlySize)
    {
      localObject2 = (State)this.stateOnlyRemovalQueue.poll();
      ((State)localObject2).parent.removeChild((State)localObject2);
      this.stateOnlyMap.remove(((State)localObject2).streamId);
    }
  }
  
  public void updateStreamableBytes(StreamByteDistributor.StreamState paramStreamState)
  {
    State localState = state(paramStreamState.stream());
    int i = Http2CodecUtil.streamableBytes(paramStreamState);
    boolean bool;
    if ((paramStreamState.hasFrame()) && (paramStreamState.windowSize() >= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    localState.updateStreamableBytes(i, bool);
  }
  
  private static final class ParentChangedEvent
  {
    final WeightedFairQueueByteDistributor.State oldParent;
    final WeightedFairQueueByteDistributor.State state;
    
    ParentChangedEvent(WeightedFairQueueByteDistributor.State paramState1, WeightedFairQueueByteDistributor.State paramState2)
    {
      this.state = paramState1;
      this.oldParent = paramState2;
    }
  }
  
  private final class State
    implements PriorityQueueNode
  {
    private static final byte STATE_IS_ACTIVE = 1;
    private static final byte STATE_IS_DISTRIBUTING = 2;
    private static final byte STATE_STREAM_ACTIVATED = 4;
    int activeCountForTree;
    IntObjectMap<State> children = IntCollections.emptyMap();
    int dependencyTreeDepth;
    private byte flags;
    State parent;
    long pseudoTime;
    private final PriorityQueue<State> pseudoTimeQueue;
    private int pseudoTimeQueueIndex = -1;
    long pseudoTimeToWrite;
    private int stateOnlyQueueIndex = -1;
    Http2Stream stream;
    final int streamId;
    int streamableBytes;
    long totalQueuedWeights;
    short weight = (short)16;
    
    State(int paramInt)
    {
      this(paramInt, null, 0);
    }
    
    State(int paramInt1, Http2Stream paramHttp2Stream, int paramInt2)
    {
      this.stream = paramHttp2Stream;
      this.streamId = paramInt1;
      this.pseudoTimeQueue = new DefaultPriorityQueue(WeightedFairQueueByteDistributor.StatePseudoTimeComparator.INSTANCE, paramInt2);
    }
    
    State(Http2Stream paramHttp2Stream)
    {
      this(paramHttp2Stream, 0);
    }
    
    State(Http2Stream paramHttp2Stream, int paramInt)
    {
      this(paramHttp2Stream.id(), paramHttp2Stream, paramInt);
    }
    
    private void initChildren()
    {
      this.children = new IntObjectHashMap(WeightedFairQueueByteDistributor.INITIAL_CHILDREN_MAP_SIZE);
    }
    
    private void initChildrenIfEmpty()
    {
      if (this.children == IntCollections.emptyMap()) {
        initChildren();
      }
    }
    
    private IntObjectMap<State> removeAllChildrenExcept(State paramState)
    {
      State localState = (State)this.children.remove(paramState.streamId);
      paramState = this.children;
      initChildren();
      if (localState != null) {
        this.children.put(localState.streamId, localState);
      }
      return paramState;
    }
    
    private void setActive()
    {
      this.flags = ((byte)(byte)(this.flags | 0x1));
    }
    
    private void setParent(State paramState)
    {
      if (this.activeCountForTree != 0)
      {
        State localState = this.parent;
        if (localState != null)
        {
          localState.removePseudoTimeQueue(this);
          this.parent.activeCountChangeForTree(-this.activeCountForTree);
        }
      }
      this.parent = paramState;
      int i;
      if (paramState == null) {
        i = Integer.MAX_VALUE;
      } else {
        i = paramState.dependencyTreeDepth + 1;
      }
      this.dependencyTreeDepth = i;
    }
    
    private void toString(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("{streamId ");
      paramStringBuilder.append(this.streamId);
      paramStringBuilder.append(" streamableBytes ");
      paramStringBuilder.append(this.streamableBytes);
      paramStringBuilder.append(" activeCountForTree ");
      paramStringBuilder.append(this.activeCountForTree);
      paramStringBuilder.append(" pseudoTimeQueueIndex ");
      paramStringBuilder.append(this.pseudoTimeQueueIndex);
      paramStringBuilder.append(" pseudoTimeToWrite ");
      paramStringBuilder.append(this.pseudoTimeToWrite);
      paramStringBuilder.append(" pseudoTime ");
      paramStringBuilder.append(this.pseudoTime);
      paramStringBuilder.append(" flags ");
      paramStringBuilder.append(this.flags);
      paramStringBuilder.append(" pseudoTimeQueue.size() ");
      paramStringBuilder.append(this.pseudoTimeQueue.size());
      paramStringBuilder.append(" stateOnlyQueueIndex ");
      paramStringBuilder.append(this.stateOnlyQueueIndex);
      paramStringBuilder.append(" parent.streamId ");
      Object localObject = this.parent;
      int i;
      if (localObject == null) {
        i = -1;
      } else {
        i = ((State)localObject).streamId;
      }
      paramStringBuilder.append(i);
      paramStringBuilder.append("} [");
      if (!this.pseudoTimeQueue.isEmpty())
      {
        localObject = this.pseudoTimeQueue.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ((State)((Iterator)localObject).next()).toString(paramStringBuilder);
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.setLength(paramStringBuilder.length() - 2);
      }
      paramStringBuilder.append(']');
    }
    
    private void unsetActive()
    {
      this.flags = ((byte)(byte)(this.flags & 0xFFFFFFFE));
    }
    
    void activeCountChangeForTree(int paramInt)
    {
      int i = this.activeCountForTree + paramInt;
      this.activeCountForTree = i;
      State localState = this.parent;
      if (localState != null)
      {
        if (i == 0) {
          localState.removePseudoTimeQueue(this);
        } else if ((i == paramInt) && (!isDistributing())) {
          this.parent.offerAndInitializePseudoTime(this);
        }
        this.parent.activeCountChangeForTree(paramInt);
      }
    }
    
    void close()
    {
      updateStreamableBytes(0, false);
      this.stream = null;
    }
    
    boolean isActive()
    {
      int i = this.flags;
      boolean bool = true;
      if ((i & 0x1) == 0) {
        bool = false;
      }
      return bool;
    }
    
    boolean isDescendantOf(State paramState)
    {
      for (State localState = this.parent; localState != null; localState = localState.parent) {
        if (localState == paramState) {
          return true;
        }
      }
      return false;
    }
    
    boolean isDistributing()
    {
      boolean bool;
      if ((this.flags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void offerAndInitializePseudoTime(State paramState)
    {
      paramState.pseudoTimeToWrite = this.pseudoTime;
      offerPseudoTimeQueue(paramState);
    }
    
    void offerPseudoTimeQueue(State paramState)
    {
      this.pseudoTimeQueue.offer(paramState);
      this.totalQueuedWeights += paramState.weight;
    }
    
    State peekPseudoTimeQueue()
    {
      return (State)this.pseudoTimeQueue.peek();
    }
    
    State pollPseudoTimeQueue()
    {
      State localState = (State)this.pseudoTimeQueue.poll();
      this.totalQueuedWeights -= localState.weight;
      return localState;
    }
    
    public int priorityQueueIndex(DefaultPriorityQueue<?> paramDefaultPriorityQueue)
    {
      int i;
      if (paramDefaultPriorityQueue == WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue) {
        i = this.stateOnlyQueueIndex;
      } else {
        i = this.pseudoTimeQueueIndex;
      }
      return i;
    }
    
    public void priorityQueueIndex(DefaultPriorityQueue<?> paramDefaultPriorityQueue, int paramInt)
    {
      if (paramDefaultPriorityQueue == WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue) {
        this.stateOnlyQueueIndex = paramInt;
      } else {
        this.pseudoTimeQueueIndex = paramInt;
      }
    }
    
    void removeChild(State paramState)
    {
      if (this.children.remove(paramState.streamId) != null)
      {
        ArrayList localArrayList = new ArrayList(paramState.children.size() + 1);
        localArrayList.add(new WeightedFairQueueByteDistributor.ParentChangedEvent(paramState, paramState.parent));
        paramState.setParent(null);
        paramState = paramState.children.entries().iterator();
        while (paramState.hasNext()) {
          takeChild(paramState, (State)((IntObjectMap.PrimitiveEntry)paramState.next()).value(), false, localArrayList);
        }
        WeightedFairQueueByteDistributor.this.notifyParentChanged(localArrayList);
      }
    }
    
    void removePseudoTimeQueue(State paramState)
    {
      if (this.pseudoTimeQueue.removeTyped(paramState)) {
        this.totalQueuedWeights -= paramState.weight;
      }
    }
    
    void setDistributing()
    {
      this.flags = ((byte)(byte)(this.flags | 0x2));
    }
    
    void setStreamReservedOrActivated()
    {
      this.flags = ((byte)(byte)(this.flags | 0x4));
    }
    
    void takeChild(State paramState, boolean paramBoolean, List<WeightedFairQueueByteDistributor.ParentChangedEvent> paramList)
    {
      takeChild(null, paramState, paramBoolean, paramList);
    }
    
    void takeChild(Iterator<IntObjectMap.PrimitiveEntry<State>> paramIterator, State paramState, boolean paramBoolean, List<WeightedFairQueueByteDistributor.ParentChangedEvent> paramList)
    {
      State localState = paramState.parent;
      if (localState != this)
      {
        paramList.add(new WeightedFairQueueByteDistributor.ParentChangedEvent(paramState, localState));
        paramState.setParent(this);
        if (paramIterator != null) {
          paramIterator.remove();
        } else if (localState != null) {
          localState.children.remove(paramState.streamId);
        }
        initChildrenIfEmpty();
        paramIterator = (State)this.children.put(paramState.streamId, paramState);
      }
      if ((paramBoolean) && (!this.children.isEmpty()))
      {
        paramIterator = removeAllChildrenExcept(paramState).entries().iterator();
        while (paramIterator.hasNext()) {
          paramState.takeChild(paramIterator, (State)((IntObjectMap.PrimitiveEntry)paramIterator.next()).value(), false, paramList);
        }
      }
    }
    
    public String toString()
    {
      int i = this.activeCountForTree;
      if (i <= 0) {
        i = 1;
      }
      StringBuilder localStringBuilder = new StringBuilder(i * 256);
      toString(localStringBuilder);
      return localStringBuilder.toString();
    }
    
    void unsetDistributing()
    {
      this.flags = ((byte)(byte)(this.flags & 0xFFFFFFFD));
    }
    
    void updatePseudoTime(State paramState, int paramInt, long paramLong)
    {
      this.pseudoTimeToWrite = (Math.min(this.pseudoTimeToWrite, paramState.pseudoTime) + paramInt * paramLong / this.weight);
    }
    
    void updateStreamableBytes(int paramInt, boolean paramBoolean)
    {
      if (isActive() != paramBoolean) {
        if (paramBoolean)
        {
          activeCountChangeForTree(1);
          setActive();
        }
        else
        {
          activeCountChangeForTree(-1);
          unsetActive();
        }
      }
      this.streamableBytes = paramInt;
    }
    
    boolean wasStreamReservedOrActivated()
    {
      boolean bool;
      if ((this.flags & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void write(int paramInt, StreamByteDistributor.Writer paramWriter)
      throws Http2Exception
    {
      try
      {
        paramWriter.write(this.stream, paramInt);
        return;
      }
      finally {}
    }
  }
  
  private static final class StateOnlyComparator
    implements Comparator<WeightedFairQueueByteDistributor.State>, Serializable
  {
    static final StateOnlyComparator INSTANCE = new StateOnlyComparator();
    private static final long serialVersionUID = -4806936913002105966L;
    
    public int compare(WeightedFairQueueByteDistributor.State paramState1, WeightedFairQueueByteDistributor.State paramState2)
    {
      boolean bool = paramState1.wasStreamReservedOrActivated();
      if (bool != paramState2.wasStreamReservedOrActivated())
      {
        if (bool) {
          i = -1;
        } else {
          i = 1;
        }
        return i;
      }
      int i = paramState2.dependencyTreeDepth - paramState1.dependencyTreeDepth;
      if (i == 0) {
        i = paramState1.streamId - paramState2.streamId;
      }
      return i;
    }
  }
  
  private static final class StatePseudoTimeComparator
    implements Comparator<WeightedFairQueueByteDistributor.State>, Serializable
  {
    static final StatePseudoTimeComparator INSTANCE = new StatePseudoTimeComparator();
    private static final long serialVersionUID = -1437548640227161828L;
    
    public int compare(WeightedFairQueueByteDistributor.State paramState1, WeightedFairQueueByteDistributor.State paramState2)
    {
      return MathUtil.compare(paramState1.pseudoTimeToWrite, paramState2.pseudoTimeToWrite);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\WeightedFairQueueByteDistributor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */