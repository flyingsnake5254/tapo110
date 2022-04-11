package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay
{
  private static final long FILE_HEADER_SIZE = 32L;
  static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
  static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
  private static final int SOURCE_FILE = 2;
  private static final int SOURCE_UPSTREAM = 1;
  final Buffer buffer = new Buffer();
  final long bufferMaxSize;
  boolean complete;
  RandomAccessFile file;
  private final ByteString metadata;
  int sourceCount;
  Source upstream;
  final Buffer upstreamBuffer = new Buffer();
  long upstreamPos;
  Thread upstreamReader;
  
  private Relay(RandomAccessFile paramRandomAccessFile, Source paramSource, long paramLong1, ByteString paramByteString, long paramLong2)
  {
    this.file = paramRandomAccessFile;
    this.upstream = paramSource;
    boolean bool;
    if (paramSource == null) {
      bool = true;
    } else {
      bool = false;
    }
    this.complete = bool;
    this.upstreamPos = paramLong1;
    this.metadata = paramByteString;
    this.bufferMaxSize = paramLong2;
  }
  
  public static Relay edit(File paramFile, Source paramSource, ByteString paramByteString, long paramLong)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    paramSource = new Relay(paramFile, paramSource, 0L, paramByteString, paramLong);
    paramFile.setLength(0L);
    paramSource.writeHeader(PREFIX_DIRTY, -1L, -1L);
    return paramSource;
  }
  
  public static Relay read(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    FileOperator localFileOperator = new FileOperator(paramFile.getChannel());
    Buffer localBuffer = new Buffer();
    localFileOperator.read(0L, localBuffer, 32L);
    ByteString localByteString = PREFIX_CLEAN;
    if (localBuffer.readByteString(localByteString.size()).equals(localByteString))
    {
      long l1 = localBuffer.readLong();
      long l2 = localBuffer.readLong();
      localBuffer = new Buffer();
      localFileOperator.read(l1 + 32L, localBuffer, l2);
      return new Relay(paramFile, null, l1, localBuffer.readByteString(), 0L);
    }
    throw new IOException("unreadable cache file");
  }
  
  private void writeHeader(ByteString paramByteString, long paramLong1, long paramLong2)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(paramByteString);
    localBuffer.writeLong(paramLong1);
    localBuffer.writeLong(paramLong2);
    if (localBuffer.size() == 32L)
    {
      new FileOperator(this.file.getChannel()).write(0L, localBuffer, 32L);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  private void writeMetadata(long paramLong)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(this.metadata);
    new FileOperator(this.file.getChannel()).write(32L + paramLong, localBuffer, this.metadata.size());
  }
  
  void commit(long paramLong)
    throws IOException
  {
    writeMetadata(paramLong);
    this.file.getChannel().force(false);
    writeHeader(PREFIX_CLEAN, paramLong, this.metadata.size());
    this.file.getChannel().force(false);
    try
    {
      this.complete = true;
      Util.closeQuietly(this.upstream);
      this.upstream = null;
      return;
    }
    finally {}
  }
  
  boolean isClosed()
  {
    boolean bool;
    if (this.file == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ByteString metadata()
  {
    return this.metadata;
  }
  
  public Source newSource()
  {
    try
    {
      if (this.file == null) {
        return null;
      }
      this.sourceCount += 1;
      return new RelaySource();
    }
    finally {}
  }
  
  class RelaySource
    implements Source
  {
    private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
    private long sourcePos;
    private final Timeout timeout = new Timeout();
    
    RelaySource() {}
    
    public void close()
      throws IOException
    {
      if (this.fileOperator == null) {
        return;
      }
      RandomAccessFile localRandomAccessFile = null;
      this.fileOperator = null;
      synchronized (Relay.this)
      {
        Relay localRelay2 = Relay.this;
        int i = localRelay2.sourceCount - 1;
        localRelay2.sourceCount = i;
        if (i == 0)
        {
          localRandomAccessFile = localRelay2.file;
          localRelay2.file = null;
        }
        if (localRandomAccessFile != null) {
          Util.closeQuietly(localRandomAccessFile);
        }
        return;
      }
    }
    
    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      if (this.fileOperator != null) {
        synchronized (Relay.this)
        {
          for (;;)
          {
            l1 = this.sourcePos;
            localRelay2 = Relay.this;
            l2 = localRelay2.upstreamPos;
            if (l1 != l2) {
              break label95;
            }
            if (localRelay2.complete) {
              return -1L;
            }
            if (localRelay2.upstreamReader == null) {
              break;
            }
            this.timeout.waitUntilNotified(localRelay2);
          }
          localRelay2.upstreamReader = Thread.currentThread();
          int i = 1;
          break label128;
          label95:
          l1 = l2 - localRelay2.buffer.size();
          l3 = this.sourcePos;
          if (l3 < l1)
          {
            i = 2;
            label128:
            if (i == 2)
            {
              paramLong = Math.min(paramLong, l2 - this.sourcePos);
              this.fileOperator.read(this.sourcePos + 32L, ???, paramLong);
              this.sourcePos += paramLong;
              return paramLong;
            }
            try
            {
              ??? = Relay.this;
              l1 = ???.upstream.read(???.upstreamBuffer, ???.bufferMaxSize);
              if (l1 == -1L)
              {
                Relay.this.commit(l2);
                synchronized (Relay.this)
                {
                  ??? = Relay.this;
                  ???.upstreamReader = null;
                  ???.notifyAll();
                  return -1L;
                }
              }
              paramLong = Math.min(l1, paramLong);
              Relay.this.upstreamBuffer.copyTo(???, 0L, paramLong);
              this.sourcePos += paramLong;
              this.fileOperator.write(l2 + 32L, Relay.this.upstreamBuffer.clone(), l1);
              synchronized (Relay.this)
              {
                Object localObject2 = Relay.this;
                ((Relay)localObject2).buffer.write(((Relay)localObject2).upstreamBuffer, l1);
                l2 = Relay.this.buffer.size();
                localObject2 = Relay.this;
                if (l2 > ((Relay)localObject2).bufferMaxSize)
                {
                  localObject2 = ((Relay)localObject2).buffer;
                  ((Buffer)localObject2).skip(((Buffer)localObject2).size() - Relay.this.bufferMaxSize);
                }
                localObject2 = Relay.this;
                ((Relay)localObject2).upstreamPos += l1;
                try
                {
                  ??? = Relay.this;
                  ???.upstreamReader = null;
                  ???.notifyAll();
                  return paramLong;
                }
                finally {}
              }
              synchronized (Relay.this)
              {
                localRelay2 = Relay.this;
                localRelay2.upstreamReader = null;
                localRelay2.notifyAll();
                throw ((Throwable)localObject4);
              }
            }
            finally {}
          }
        }
      }
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\cache2\Relay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */