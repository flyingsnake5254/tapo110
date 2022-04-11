package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import org.conscrypt.AllocatedBuffer;
import org.conscrypt.BufferAllocator;
import org.conscrypt.Conscrypt;
import org.conscrypt.HandshakeListener;

abstract class ConscryptAlpnSslEngine
  extends JdkSslEngine
{
  private static final boolean USE_BUFFER_ALLOCATOR = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.conscrypt.useBufferAllocator", true);
  
  private ConscryptAlpnSslEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, List<String> paramList)
  {
    super(paramSSLEngine);
    if (USE_BUFFER_ALLOCATOR) {
      Conscrypt.setBufferAllocator(paramSSLEngine, new BufferAllocatorAdapter(paramByteBufAllocator));
    }
    Conscrypt.setApplicationProtocols(paramSSLEngine, (String[])paramList.toArray(new String[0]));
  }
  
  static ConscryptAlpnSslEngine newClientEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
  {
    return new ClientEngine(paramSSLEngine, paramByteBufAllocator, paramJdkApplicationProtocolNegotiator);
  }
  
  static ConscryptAlpnSslEngine newServerEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
  {
    return new ServerEngine(paramSSLEngine, paramByteBufAllocator, paramJdkApplicationProtocolNegotiator);
  }
  
  final int calculateOutNetBufSize(int paramInt1, int paramInt2)
  {
    long l1 = Conscrypt.maxSealOverhead(getWrappedEngine());
    long l2 = paramInt2;
    return (int)Math.min(2147483647L, paramInt1 + l1 * l2);
  }
  
  final SSLEngineResult unwrap(ByteBuffer[] paramArrayOfByteBuffer1, ByteBuffer[] paramArrayOfByteBuffer2)
    throws SSLException
  {
    return Conscrypt.unwrap(getWrappedEngine(), paramArrayOfByteBuffer1, paramArrayOfByteBuffer2);
  }
  
  private static final class BufferAdapter
    extends AllocatedBuffer
  {
    private final ByteBuffer buffer;
    private final ByteBuf nettyBuffer;
    
    BufferAdapter(ByteBuf paramByteBuf)
    {
      this.nettyBuffer = paramByteBuf;
      this.buffer = paramByteBuf.nioBuffer(0, paramByteBuf.capacity());
    }
    
    public ByteBuffer nioBuffer()
    {
      return this.buffer;
    }
    
    public AllocatedBuffer release()
    {
      this.nettyBuffer.release();
      return this;
    }
    
    public AllocatedBuffer retain()
    {
      this.nettyBuffer.retain();
      return this;
    }
  }
  
  private static final class BufferAllocatorAdapter
    extends BufferAllocator
  {
    private final ByteBufAllocator alloc;
    
    BufferAllocatorAdapter(ByteBufAllocator paramByteBufAllocator)
    {
      this.alloc = paramByteBufAllocator;
    }
    
    public AllocatedBuffer allocateDirectBuffer(int paramInt)
    {
      return new ConscryptAlpnSslEngine.BufferAdapter(this.alloc.directBuffer(paramInt));
    }
  }
  
  private static final class ClientEngine
    extends ConscryptAlpnSslEngine
  {
    private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolListener;
    
    ClientEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
    {
      super(paramByteBufAllocator, paramJdkApplicationProtocolNegotiator.protocols(), null);
      Conscrypt.setHandshakeListener(paramSSLEngine, new HandshakeListener()
      {
        public void onHandshakeFinished()
          throws SSLException
        {
          ConscryptAlpnSslEngine.ClientEngine.this.selectProtocol();
        }
      });
      this.protocolListener = ((JdkApplicationProtocolNegotiator.ProtocolSelectionListener)ObjectUtil.checkNotNull(paramJdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, paramJdkApplicationProtocolNegotiator.protocols()), "protocolListener"));
    }
    
    private void selectProtocol()
      throws SSLException
    {
      String str = Conscrypt.getApplicationProtocol(getWrappedEngine());
      try
      {
        this.protocolListener.selected(str);
        return;
      }
      finally {}
    }
  }
  
  private static final class ServerEngine
    extends ConscryptAlpnSslEngine
  {
    private final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector;
    
    ServerEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
    {
      super(paramByteBufAllocator, paramJdkApplicationProtocolNegotiator.protocols(), null);
      Conscrypt.setHandshakeListener(paramSSLEngine, new HandshakeListener()
      {
        public void onHandshakeFinished()
          throws SSLException
        {
          ConscryptAlpnSslEngine.ServerEngine.this.selectProtocol();
        }
      });
      this.protocolSelector = ((JdkApplicationProtocolNegotiator.ProtocolSelector)ObjectUtil.checkNotNull(paramJdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(paramJdkApplicationProtocolNegotiator.protocols())), "protocolSelector"));
    }
    
    private void selectProtocol()
      throws SSLException
    {
      try
      {
        Object localObject = Conscrypt.getApplicationProtocol(getWrappedEngine());
        JdkApplicationProtocolNegotiator.ProtocolSelector localProtocolSelector = this.protocolSelector;
        if (localObject != null) {
          localObject = Collections.singletonList(localObject);
        } else {
          localObject = Collections.emptyList();
        }
        localProtocolSelector.select((List)localObject);
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ConscryptAlpnSslEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */