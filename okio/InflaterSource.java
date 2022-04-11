package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource
  implements Source
{
  private int bufferBytesHeldByInflater;
  private boolean closed;
  private final Inflater inflater;
  private final BufferedSource source;
  
  InflaterSource(BufferedSource paramBufferedSource, Inflater paramInflater)
  {
    if (paramBufferedSource != null)
    {
      if (paramInflater != null)
      {
        this.source = paramBufferedSource;
        this.inflater = paramInflater;
        return;
      }
      throw new IllegalArgumentException("inflater == null");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public InflaterSource(Source paramSource, Inflater paramInflater)
  {
    this(Okio.buffer(paramSource), paramInflater);
  }
  
  private void releaseInflatedBytes()
    throws IOException
  {
    int i = this.bufferBytesHeldByInflater;
    if (i == 0) {
      return;
    }
    i -= this.inflater.getRemaining();
    this.bufferBytesHeldByInflater -= i;
    this.source.skip(i);
  }
  
  public void close()
    throws IOException
  {
    if (this.closed) {
      return;
    }
    this.inflater.end();
    this.closed = true;
    this.source.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    boolean bool1 = paramLong < 0L;
    if (!bool1)
    {
      if (!this.closed)
      {
        if (!bool1) {
          return 0L;
        }
        for (;;)
        {
          boolean bool2 = refill();
          try
          {
            Segment localSegment = paramBuffer.writableSegment(1);
            int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
            i = this.inflater.inflate(localSegment.data, localSegment.limit, i);
            if (i > 0)
            {
              localSegment.limit += i;
              long l = paramBuffer.size;
              paramLong = i;
              paramBuffer.size = (l + paramLong);
              return paramLong;
            }
            if ((!this.inflater.finished()) && (!this.inflater.needsDictionary()))
            {
              if (bool2)
              {
                paramBuffer = new java/io/EOFException;
                paramBuffer.<init>("source exhausted prematurely");
                throw paramBuffer;
              }
            }
            else
            {
              releaseInflatedBytes();
              if (localSegment.pos == localSegment.limit)
              {
                paramBuffer.head = localSegment.pop();
                SegmentPool.recycle(localSegment);
              }
              return -1L;
            }
          }
          catch (DataFormatException paramBuffer)
          {
            throw new IOException(paramBuffer);
          }
        }
      }
      throw new IllegalStateException("closed");
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw new IllegalArgumentException(paramBuffer.toString());
  }
  
  public final boolean refill()
    throws IOException
  {
    if (!this.inflater.needsInput()) {
      return false;
    }
    releaseInflatedBytes();
    if (this.inflater.getRemaining() == 0)
    {
      if (this.source.exhausted()) {
        return true;
      }
      Segment localSegment = this.source.buffer().head;
      int i = localSegment.limit;
      int j = localSegment.pos;
      i -= j;
      this.bufferBytesHeldByInflater = i;
      this.inflater.setInput(localSegment.data, j, i);
      return false;
    }
    throw new IllegalStateException("?");
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\InflaterSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */