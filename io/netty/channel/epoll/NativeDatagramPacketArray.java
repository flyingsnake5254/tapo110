package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelOutboundBuffer.MessageProcessor;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Limits;
import io.netty.channel.unix.NativeInetAddress;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

final class NativeDatagramPacketArray
{
  private int count;
  private final IovArray iovArray = new IovArray();
  private final byte[] ipv4Bytes = new byte[4];
  private final NativeDatagramPacket[] packets = new NativeDatagramPacket[Limits.UIO_MAX_IOV];
  private final MyMessageProcessor processor = new MyMessageProcessor(null);
  
  NativeDatagramPacketArray()
  {
    for (int i = 0;; i++)
    {
      NativeDatagramPacket[] arrayOfNativeDatagramPacket = this.packets;
      if (i >= arrayOfNativeDatagramPacket.length) {
        break;
      }
      arrayOfNativeDatagramPacket[i] = new NativeDatagramPacket();
    }
  }
  
  private boolean add0(ByteBuf paramByteBuf, int paramInt1, int paramInt2, InetSocketAddress paramInetSocketAddress)
  {
    if (this.count == this.packets.length) {
      return false;
    }
    if (paramInt2 == 0) {
      return true;
    }
    int i = this.iovArray.count();
    if ((i != Limits.IOV_MAX) && (this.iovArray.add(paramByteBuf, paramInt1, paramInt2)))
    {
      this.packets[this.count].init(this.iovArray.memoryAddress(i), this.iovArray.count() - i, paramInetSocketAddress);
      this.count += 1;
      return true;
    }
    return false;
  }
  
  void add(ChannelOutboundBuffer paramChannelOutboundBuffer, boolean paramBoolean)
    throws Exception
  {
    MyMessageProcessor.access$202(this.processor, paramBoolean);
    paramChannelOutboundBuffer.forEachFlushedMessage(this.processor);
  }
  
  boolean addWritable(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return add0(paramByteBuf, paramInt1, paramInt2, null);
  }
  
  void clear()
  {
    this.count = 0;
    this.iovArray.clear();
  }
  
  int count()
  {
    return this.count;
  }
  
  NativeDatagramPacket[] packets()
  {
    return this.packets;
  }
  
  void release()
  {
    this.iovArray.release();
  }
  
  private final class MyMessageProcessor
    implements ChannelOutboundBuffer.MessageProcessor
  {
    private boolean connected;
    
    private MyMessageProcessor() {}
    
    public boolean processMessage(Object paramObject)
    {
      if ((paramObject instanceof DatagramPacket))
      {
        DatagramPacket localDatagramPacket = (DatagramPacket)paramObject;
        paramObject = (ByteBuf)localDatagramPacket.content();
        return NativeDatagramPacketArray.this.add0((ByteBuf)paramObject, ((ByteBuf)paramObject).readerIndex(), ((ByteBuf)paramObject).readableBytes(), (InetSocketAddress)localDatagramPacket.recipient());
      }
      if (((paramObject instanceof ByteBuf)) && (this.connected))
      {
        paramObject = (ByteBuf)paramObject;
        return NativeDatagramPacketArray.this.add0((ByteBuf)paramObject, ((ByteBuf)paramObject).readerIndex(), ((ByteBuf)paramObject).readableBytes(), null);
      }
      return false;
    }
  }
  
  final class NativeDatagramPacket
  {
    private final byte[] addr = new byte[16];
    private int addrLen;
    private int count;
    private long memoryAddress;
    private int port;
    private int scopeId;
    
    NativeDatagramPacket() {}
    
    private void init(long paramLong, int paramInt, InetSocketAddress paramInetSocketAddress)
    {
      this.memoryAddress = paramLong;
      this.count = paramInt;
      if (paramInetSocketAddress == null)
      {
        this.scopeId = 0;
        this.port = 0;
        this.addrLen = 0;
      }
      else
      {
        InetAddress localInetAddress = paramInetSocketAddress.getAddress();
        if ((localInetAddress instanceof Inet6Address))
        {
          byte[] arrayOfByte1 = localInetAddress.getAddress();
          byte[] arrayOfByte2 = this.addr;
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
          this.scopeId = ((Inet6Address)localInetAddress).getScopeId();
        }
        else
        {
          NativeInetAddress.copyIpv4MappedIpv6Address(localInetAddress.getAddress(), this.addr);
          this.scopeId = 0;
        }
        this.addrLen = this.addr.length;
        this.port = paramInetSocketAddress.getPort();
      }
    }
    
    DatagramPacket newDatagramPacket(ByteBuf paramByteBuf, InetSocketAddress paramInetSocketAddress)
      throws UnknownHostException
    {
      Object localObject;
      if (this.addrLen == NativeDatagramPacketArray.this.ipv4Bytes.length)
      {
        System.arraycopy(this.addr, 0, NativeDatagramPacketArray.this.ipv4Bytes, 0, this.addrLen);
        localObject = InetAddress.getByAddress(NativeDatagramPacketArray.this.ipv4Bytes);
      }
      else
      {
        localObject = Inet6Address.getByAddress(null, this.addr, this.scopeId);
      }
      return new DatagramPacket(paramByteBuf.writerIndex(this.count), paramInetSocketAddress, new InetSocketAddress((InetAddress)localObject, this.port));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\NativeDatagramPacketArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */