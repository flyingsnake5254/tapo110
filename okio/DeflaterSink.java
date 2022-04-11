package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink
  implements Sink
{
  private boolean closed;
  private final Deflater deflater;
  private final BufferedSink sink;
  
  DeflaterSink(BufferedSink paramBufferedSink, Deflater paramDeflater)
  {
    if (paramBufferedSink != null)
    {
      if (paramDeflater != null)
      {
        this.sink = paramBufferedSink;
        this.deflater = paramDeflater;
        return;
      }
      throw new IllegalArgumentException("inflater == null");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public DeflaterSink(Sink paramSink, Deflater paramDeflater)
  {
    this(Okio.buffer(paramSink), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private void deflate(boolean paramBoolean)
    throws IOException
  {
    Buffer localBuffer = this.sink.buffer();
    Segment localSegment;
    do
    {
      for (;;)
      {
        localSegment = localBuffer.writableSegment(1);
        Object localObject1;
        Object localObject2;
        int i;
        if (paramBoolean)
        {
          localObject1 = this.deflater;
          localObject2 = localSegment.data;
          i = localSegment.limit;
          i = ((Deflater)localObject1).deflate((byte[])localObject2, i, 8192 - i, 2);
        }
        else
        {
          localObject2 = this.deflater;
          localObject1 = localSegment.data;
          i = localSegment.limit;
          i = ((Deflater)localObject2).deflate((byte[])localObject1, i, 8192 - i);
        }
        if (i <= 0) {
          break;
        }
        localSegment.limit += i;
        localBuffer.size += i;
        this.sink.emitCompleteSegments();
      }
    } while (!this.deflater.needsInput());
    if (localSegment.pos == localSegment.limit)
    {
      localBuffer.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 108	okio/DeflaterSink:closed	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore_1
    //   10: aload_0
    //   11: invokevirtual 111	okio/DeflaterSink:finishDeflate	()V
    //   14: goto +4 -> 18
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 21	okio/DeflaterSink:deflater	Ljava/util/zip/Deflater;
    //   22: invokevirtual 114	java/util/zip/Deflater:end	()V
    //   25: aload_1
    //   26: astore_2
    //   27: goto +12 -> 39
    //   30: astore_3
    //   31: aload_1
    //   32: astore_2
    //   33: aload_1
    //   34: ifnonnull +5 -> 39
    //   37: aload_3
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 19	okio/DeflaterSink:sink	Lokio/BufferedSink;
    //   43: invokeinterface 116 1 0
    //   48: aload_2
    //   49: astore_1
    //   50: goto +12 -> 62
    //   53: astore_3
    //   54: aload_2
    //   55: astore_1
    //   56: aload_2
    //   57: ifnonnull +5 -> 62
    //   60: aload_3
    //   61: astore_1
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 108	okio/DeflaterSink:closed	Z
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokestatic 122	okio/Util:sneakyRethrow	(Ljava/lang/Throwable;)V
    //   75: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	DeflaterSink
    //   9	1	1	localObject1	Object
    //   17	17	1	localObject2	Object
    //   49	23	1	localObject3	Object
    //   26	31	2	localObject4	Object
    //   30	8	3	localObject5	Object
    //   53	8	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   10	14	17	finally
    //   18	25	30	finally
    //   39	48	53	finally
  }
  
  void finishDeflate()
    throws IOException
  {
    this.deflater.finish();
    deflate(false);
  }
  
  public void flush()
    throws IOException
  {
    deflate(true);
    this.sink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeflaterSink(");
    localStringBuilder.append(this.sink);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    while (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.head;
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.deflater.setInput(localSegment.data, localSegment.pos, i);
      deflate(false);
      long l1 = paramBuffer.size;
      long l2 = i;
      paramBuffer.size = (l1 - l2);
      i = localSegment.pos + i;
      localSegment.pos = i;
      if (i == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
      }
      paramLong -= l2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\DeflaterSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */