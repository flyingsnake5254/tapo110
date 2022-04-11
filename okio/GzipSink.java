package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink
  implements Sink
{
  private boolean closed;
  private final CRC32 crc = new CRC32();
  private final Deflater deflater;
  private final DeflaterSink deflaterSink;
  private final BufferedSink sink;
  
  public GzipSink(Sink paramSink)
  {
    if (paramSink != null)
    {
      Deflater localDeflater = new Deflater(-1, true);
      this.deflater = localDeflater;
      paramSink = Okio.buffer(paramSink);
      this.sink = paramSink;
      this.deflaterSink = new DeflaterSink(paramSink, localDeflater);
      writeHeader();
      return;
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  private void updateCrc(Buffer paramBuffer, long paramLong)
  {
    for (paramBuffer = paramBuffer.head; paramLong > 0L; paramBuffer = paramBuffer.next)
    {
      int i = (int)Math.min(paramLong, paramBuffer.limit - paramBuffer.pos);
      this.crc.update(paramBuffer.data, paramBuffer.pos, i);
      paramLong -= i;
    }
  }
  
  private void writeFooter()
    throws IOException
  {
    this.sink.writeIntLe((int)this.crc.getValue());
    this.sink.writeIntLe((int)this.deflater.getBytesRead());
  }
  
  private void writeHeader()
  {
    Buffer localBuffer = this.sink.buffer();
    localBuffer.writeShort(8075);
    localBuffer.writeByte(8);
    localBuffer.writeByte(0);
    localBuffer.writeInt(0);
    localBuffer.writeByte(0);
    localBuffer.writeByte(0);
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 126	okio/GzipSink:closed	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 48	okio/GzipSink:deflaterSink	Lokio/DeflaterSink;
    //   14: invokevirtual 129	okio/DeflaterSink:finishDeflate	()V
    //   17: aload_0
    //   18: invokespecial 131	okio/GzipSink:writeFooter	()V
    //   21: goto +4 -> 25
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 33	okio/GzipSink:deflater	Ljava/util/zip/Deflater;
    //   29: invokevirtual 134	java/util/zip/Deflater:end	()V
    //   32: aload_1
    //   33: astore_2
    //   34: goto +12 -> 46
    //   37: astore_3
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: ifnonnull +5 -> 46
    //   44: aload_3
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 41	okio/GzipSink:sink	Lokio/BufferedSink;
    //   50: invokeinterface 136 1 0
    //   55: aload_2
    //   56: astore_1
    //   57: goto +12 -> 69
    //   60: astore_3
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: ifnonnull +5 -> 69
    //   67: aload_3
    //   68: astore_1
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield 126	okio/GzipSink:closed	Z
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokestatic 142	okio/Util:sneakyRethrow	(Ljava/lang/Throwable;)V
    //   82: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	GzipSink
    //   9	1	1	localObject1	Object
    //   24	17	1	localObject2	Object
    //   56	23	1	localObject3	Object
    //   33	31	2	localObject4	Object
    //   37	8	3	localObject5	Object
    //   60	8	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   10	21	24	finally
    //   25	32	37	finally
    //   46	55	60	finally
  }
  
  public final Deflater deflater()
  {
    return this.deflater;
  }
  
  public void flush()
    throws IOException
  {
    this.deflaterSink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    boolean bool = paramLong < 0L;
    if (!bool)
    {
      if (!bool) {
        return;
      }
      updateCrc(paramBuffer, paramLong);
      this.deflaterSink.write(paramBuffer, paramLong);
      return;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw new IllegalArgumentException(paramBuffer.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\GzipSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */