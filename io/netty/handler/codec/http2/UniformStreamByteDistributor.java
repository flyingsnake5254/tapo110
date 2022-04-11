package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Deque;

public final class UniformStreamByteDistributor
  implements StreamByteDistributor
{
  private int minAllocationChunk = 1024;
  private final Deque<State> queue = new ArrayDeque(4);
  private final Http2Connection.a stateKey;
  private long totalStreamableBytes;
  
  public UniformStreamByteDistributor(Http2Connection paramHttp2Connection)
  {
    Http2Connection.a locala = paramHttp2Connection.newKey();
    this.stateKey = locala;
    Http2Stream localHttp2Stream = paramHttp2Connection.connectionStream();
    localHttp2Stream.setProperty(locala, new State(localHttp2Stream));
    paramHttp2Connection.addListener(new Http2ConnectionAdapter()
    {
      public void onStreamAdded(Http2Stream paramAnonymousHttp2Stream)
      {
        paramAnonymousHttp2Stream.setProperty(UniformStreamByteDistributor.this.stateKey, new UniformStreamByteDistributor.State(UniformStreamByteDistributor.this, paramAnonymousHttp2Stream));
      }
      
      public void onStreamClosed(Http2Stream paramAnonymousHttp2Stream)
      {
        UniformStreamByteDistributor.this.state(paramAnonymousHttp2Stream).close();
      }
    });
  }
  
  private State state(Http2Stream paramHttp2Stream)
  {
    return (State)((Http2Stream)ObjectUtil.checkNotNull(paramHttp2Stream, "stream")).getProperty(this.stateKey);
  }
  
  public boolean distribute(int paramInt, StreamByteDistributor.Writer paramWriter)
    throws Http2Exception
  {
    int i = this.queue.size();
    boolean bool1 = true;
    boolean bool2 = true;
    if (i == 0)
    {
      if (this.totalStreamableBytes <= 0L) {
        bool2 = false;
      }
      return bool2;
    }
    i = Math.max(this.minAllocationChunk, paramInt / i);
    Object localObject = (State)this.queue.pollFirst();
    State localState;
    do
    {
      ((State)localObject).enqueued = false;
      if (!((State)localObject).windowNegative)
      {
        if ((paramInt == 0) && (((State)localObject).streamableBytes > 0))
        {
          this.queue.addFirst(localObject);
          ((State)localObject).enqueued = true;
          break;
        }
        int j = Math.min(i, Math.min(paramInt, ((State)localObject).streamableBytes));
        paramInt -= j;
        ((State)localObject).write(j, paramWriter);
      }
      localState = (State)this.queue.pollFirst();
      localObject = localState;
    } while (localState != null);
    if (this.totalStreamableBytes > 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  public void minAllocationChunk(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "minAllocationChunk");
    this.minAllocationChunk = paramInt;
  }
  
  public void updateDependencyTree(int paramInt1, int paramInt2, short paramShort, boolean paramBoolean) {}
  
  public void updateStreamableBytes(StreamByteDistributor.StreamState paramStreamState)
  {
    state(paramStreamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(paramStreamState), paramStreamState.hasFrame(), paramStreamState.windowSize());
  }
  
  private final class State
  {
    boolean enqueued;
    final Http2Stream stream;
    int streamableBytes;
    boolean windowNegative;
    boolean writing;
    
    State(Http2Stream paramHttp2Stream)
    {
      this.stream = paramHttp2Stream;
    }
    
    void addToQueue()
    {
      if (!this.enqueued)
      {
        this.enqueued = true;
        UniformStreamByteDistributor.this.queue.addLast(this);
      }
    }
    
    void close()
    {
      removeFromQueue();
      updateStreamableBytes(0, false, 0);
    }
    
    void removeFromQueue()
    {
      if (this.enqueued)
      {
        this.enqueued = false;
        UniformStreamByteDistributor.this.queue.remove(this);
      }
    }
    
    void updateStreamableBytes(int paramInt1, boolean paramBoolean, int paramInt2)
    {
      int i = paramInt1 - this.streamableBytes;
      if (i != 0)
      {
        this.streamableBytes = paramInt1;
        UniformStreamByteDistributor localUniformStreamByteDistributor = UniformStreamByteDistributor.this;
        UniformStreamByteDistributor.access$202(localUniformStreamByteDistributor, localUniformStreamByteDistributor.totalStreamableBytes + i);
      }
      boolean bool;
      if (paramInt2 < 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.windowNegative = bool;
      if ((paramBoolean) && ((paramInt2 > 0) || ((paramInt2 == 0) && (!this.writing)))) {
        addToQueue();
      }
    }
    
    void write(int paramInt, StreamByteDistributor.Writer paramWriter)
      throws Http2Exception
    {
      this.writing = true;
      try
      {
        paramWriter.write(this.stream, paramInt);
        this.writing = false;
        return;
      }
      finally
      {
        try
        {
          throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, paramWriter, "byte distribution write error", new Object[0]);
        }
        finally
        {
          this.writing = false;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\UniformStreamByteDistributor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */