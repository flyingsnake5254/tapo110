package okio;

import java.io.IOException;

final class PeekSource
  implements Source
{
  private final Buffer buffer;
  private boolean closed;
  private int expectedPos;
  private Segment expectedSegment;
  private long pos;
  private final BufferedSource upstream;
  
  PeekSource(BufferedSource paramBufferedSource)
  {
    this.upstream = paramBufferedSource;
    paramBufferedSource = paramBufferedSource.buffer();
    this.buffer = paramBufferedSource;
    paramBufferedSource = paramBufferedSource.head;
    this.expectedSegment = paramBufferedSource;
    int i;
    if (paramBufferedSource != null) {
      i = paramBufferedSource.pos;
    } else {
      i = -1;
    }
    this.expectedPos = i;
  }
  
  public void close()
    throws IOException
  {
    this.closed = true;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    boolean bool = paramLong < 0L;
    if (!bool)
    {
      if (!this.closed)
      {
        Segment localSegment1 = this.expectedSegment;
        if (localSegment1 != null)
        {
          Segment localSegment2 = this.buffer.head;
          if ((localSegment1 != localSegment2) || (this.expectedPos != localSegment2.pos)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
          }
        }
        if (!bool) {
          return 0L;
        }
        if (!this.upstream.request(this.pos + 1L)) {
          return -1L;
        }
        if (this.expectedSegment == null)
        {
          localSegment1 = this.buffer.head;
          if (localSegment1 != null)
          {
            this.expectedSegment = localSegment1;
            this.expectedPos = localSegment1.pos;
          }
        }
        paramLong = Math.min(paramLong, this.buffer.size - this.pos);
        this.buffer.copyTo(paramBuffer, this.pos, paramLong);
        this.pos += paramLong;
        return paramLong;
      }
      throw new IllegalStateException("closed");
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw new IllegalArgumentException(paramBuffer.toString());
  }
  
  public Timeout timeout()
  {
    return this.upstream.timeout();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\PeekSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */