package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class HAProxyMessage
  extends AbstractReferenceCounted
{
  private static final ResourceLeakDetector<HAProxyMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HAProxyMessage.class);
  private final HAProxyCommand command;
  private final String destinationAddress;
  private final int destinationPort;
  private final ResourceLeakTracker<HAProxyMessage> leak;
  private final HAProxyProtocolVersion protocolVersion;
  private final HAProxyProxiedProtocol proxiedProtocol;
  private final String sourceAddress;
  private final int sourcePort;
  private final List<HAProxyTLV> tlvs;
  
  public HAProxyMessage(HAProxyProtocolVersion paramHAProxyProtocolVersion, HAProxyCommand paramHAProxyCommand, HAProxyProxiedProtocol paramHAProxyProxiedProtocol, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this(paramHAProxyProtocolVersion, paramHAProxyCommand, paramHAProxyProxiedProtocol, paramString1, paramString2, paramInt1, paramInt2, Collections.emptyList());
  }
  
  public HAProxyMessage(HAProxyProtocolVersion paramHAProxyProtocolVersion, HAProxyCommand paramHAProxyCommand, HAProxyProxiedProtocol paramHAProxyProxiedProtocol, String paramString1, String paramString2, int paramInt1, int paramInt2, List<? extends HAProxyTLV> paramList)
  {
    ObjectUtil.checkNotNull(paramHAProxyProtocolVersion, "protocolVersion");
    ObjectUtil.checkNotNull(paramHAProxyProxiedProtocol, "proxiedProtocol");
    ObjectUtil.checkNotNull(paramList, "tlvs");
    HAProxyProxiedProtocol.AddressFamily localAddressFamily = paramHAProxyProxiedProtocol.addressFamily();
    checkAddress(paramString1, localAddressFamily);
    checkAddress(paramString2, localAddressFamily);
    checkPort(paramInt1, localAddressFamily);
    checkPort(paramInt2, localAddressFamily);
    this.protocolVersion = paramHAProxyProtocolVersion;
    this.command = paramHAProxyCommand;
    this.proxiedProtocol = paramHAProxyProxiedProtocol;
    this.sourceAddress = paramString1;
    this.destinationAddress = paramString2;
    this.sourcePort = paramInt1;
    this.destinationPort = paramInt2;
    this.tlvs = Collections.unmodifiableList(paramList);
    this.leak = leakDetector.track(this);
  }
  
  private HAProxyMessage(HAProxyProtocolVersion paramHAProxyProtocolVersion, HAProxyCommand paramHAProxyCommand, HAProxyProxiedProtocol paramHAProxyProxiedProtocol, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramHAProxyProtocolVersion, paramHAProxyCommand, paramHAProxyProxiedProtocol, paramString1, paramString2, portStringToInt(paramString3), portStringToInt(paramString4));
  }
  
  private static void checkAddress(String paramString, HAProxyProxiedProtocol.AddressFamily paramAddressFamily)
  {
    ObjectUtil.checkNotNull(paramAddressFamily, "addrFamily");
    int[] arrayOfInt = 1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;
    int i = arrayOfInt[paramAddressFamily.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        ObjectUtil.checkNotNull(paramString, "address");
        i = arrayOfInt[paramAddressFamily.ordinal()];
        if (i != 3)
        {
          if (i == 4)
          {
            if (!NetUtil.isValidIpV6Address(paramString))
            {
              paramAddressFamily = new StringBuilder();
              paramAddressFamily.append("invalid IPv6 address: ");
              paramAddressFamily.append(paramString);
              throw new IllegalArgumentException(paramAddressFamily.toString());
            }
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append("unexpected addrFamily: ");
            paramString.append(paramAddressFamily);
            throw new IllegalArgumentException(paramString.toString());
          }
        }
        else {
          if (!NetUtil.isValidIpV4Address(paramString)) {
            break label136;
          }
        }
        return;
        label136:
        paramAddressFamily = new StringBuilder();
        paramAddressFamily.append("invalid IPv4 address: ");
        paramAddressFamily.append(paramString);
        throw new IllegalArgumentException(paramAddressFamily.toString());
      }
      ObjectUtil.checkNotNull(paramString, "address");
      if (paramString.getBytes(CharsetUtil.US_ASCII).length <= 108) {
        return;
      }
      paramAddressFamily = new StringBuilder();
      paramAddressFamily.append("invalid AF_UNIX address: ");
      paramAddressFamily.append(paramString);
      throw new IllegalArgumentException(paramAddressFamily.toString());
    }
    if (paramString == null) {
      return;
    }
    paramAddressFamily = new StringBuilder();
    paramAddressFamily.append("unable to validate an AF_UNSPEC address: ");
    paramAddressFamily.append(paramString);
    throw new IllegalArgumentException(paramAddressFamily.toString());
  }
  
  private static void checkPort(int paramInt, HAProxyProxiedProtocol.AddressFamily paramAddressFamily)
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[paramAddressFamily.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("unexpected addrFamily: ");
        localStringBuilder.append(paramAddressFamily);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      if ((paramInt < 0) || (paramInt > 65535))
      {
        paramAddressFamily = new StringBuilder();
        paramAddressFamily.append("invalid port: ");
        paramAddressFamily.append(paramInt);
        paramAddressFamily.append(" (expected: 0 ~ 65535)");
        throw new IllegalArgumentException(paramAddressFamily.toString());
      }
    }
    else
    {
      if (paramInt != 0) {
        break label123;
      }
    }
    return;
    label123:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("port cannot be specified with addrFamily: ");
    localStringBuilder.append(paramAddressFamily);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static HAProxyMessage decodeHeader(ByteBuf paramByteBuf)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "header");
    int i = paramByteBuf.readableBytes();
    int j = 16;
    if (i >= 16)
    {
      paramByteBuf.skipBytes(12);
      byte b = paramByteBuf.readByte();
      try
      {
        HAProxyProtocolVersion localHAProxyProtocolVersion = HAProxyProtocolVersion.valueOf(b);
        localObject1 = HAProxyProtocolVersion.V2;
        if (localHAProxyProtocolVersion == localObject1) {
          try
          {
            HAProxyCommand localHAProxyCommand = HAProxyCommand.valueOf(b);
            Object localObject2 = HAProxyCommand.LOCAL;
            if (localHAProxyCommand == localObject2) {
              return unknownMsg((HAProxyProtocolVersion)localObject1, (HAProxyCommand)localObject2);
            }
            try
            {
              HAProxyProxiedProtocol localHAProxyProxiedProtocol = HAProxyProxiedProtocol.valueOf(paramByteBuf.readByte());
              if (localHAProxyProxiedProtocol == HAProxyProxiedProtocol.UNKNOWN) {
                return unknownMsg((HAProxyProtocolVersion)localObject1, HAProxyCommand.PROXY);
              }
              i = paramByteBuf.readUnsignedShort();
              localObject1 = localHAProxyProxiedProtocol.addressFamily();
              Object localObject3;
              if (localObject1 == HAProxyProxiedProtocol.AddressFamily.AF_UNIX)
              {
                if ((i >= 216) && (paramByteBuf.readableBytes() >= 216))
                {
                  i = paramByteBuf.readerIndex();
                  localObject1 = ByteProcessor.FIND_NUL;
                  j = paramByteBuf.forEachByte(i, 108, (ByteProcessor)localObject1);
                  if (j == -1) {
                    j = 108;
                  } else {
                    j -= i;
                  }
                  localObject2 = CharsetUtil.US_ASCII;
                  localObject3 = paramByteBuf.toString(i, j, (Charset)localObject2);
                  i += 108;
                  j = paramByteBuf.forEachByte(i, 108, (ByteProcessor)localObject1);
                  if (j == -1) {
                    j = 108;
                  } else {
                    j -= i;
                  }
                  localObject1 = paramByteBuf.toString(i, j, (Charset)localObject2);
                  paramByteBuf.readerIndex(i + 108);
                  j = 0;
                  i = 0;
                  localObject2 = localObject1;
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("incomplete UNIX socket address information: ");
                  ((StringBuilder)localObject1).append(Math.min(i, paramByteBuf.readableBytes()));
                  ((StringBuilder)localObject1).append(" bytes (expected: 216+ bytes)");
                  throw new HAProxyProtocolException(((StringBuilder)localObject1).toString());
                }
              }
              else
              {
                if (localObject1 == HAProxyProxiedProtocol.AddressFamily.AF_IPv4)
                {
                  if ((i >= 12) && (paramByteBuf.readableBytes() >= 12))
                  {
                    j = 4;
                  }
                  else
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("incomplete IPv4 address information: ");
                    ((StringBuilder)localObject1).append(Math.min(i, paramByteBuf.readableBytes()));
                    ((StringBuilder)localObject1).append(" bytes (expected: 12+ bytes)");
                    throw new HAProxyProtocolException(((StringBuilder)localObject1).toString());
                  }
                }
                else
                {
                  if (localObject1 != HAProxyProxiedProtocol.AddressFamily.AF_IPv6) {
                    break label513;
                  }
                  if ((i < 36) || (paramByteBuf.readableBytes() < 36)) {
                    break label459;
                  }
                }
                localObject1 = ipBytesToString(paramByteBuf, j);
                localObject2 = ipBytesToString(paramByteBuf, j);
                j = paramByteBuf.readUnsignedShort();
                i = paramByteBuf.readUnsignedShort();
                localObject3 = localObject1;
              }
              return new HAProxyMessage(localHAProxyProtocolVersion, localHAProxyCommand, localHAProxyProxiedProtocol, (String)localObject3, (String)localObject2, j, i, readTlvs(paramByteBuf));
              label459:
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("incomplete IPv6 address information: ");
              ((StringBuilder)localObject1).append(Math.min(i, paramByteBuf.readableBytes()));
              ((StringBuilder)localObject1).append(" bytes (expected: 36+ bytes)");
              throw new HAProxyProtocolException(((StringBuilder)localObject1).toString());
              label513:
              paramByteBuf = new StringBuilder();
              paramByteBuf.append("unable to parse address information (unknown address family: ");
              paramByteBuf.append(localObject1);
              paramByteBuf.append(')');
              throw new HAProxyProtocolException(paramByteBuf.toString());
            }
            catch (IllegalArgumentException paramByteBuf)
            {
              throw new HAProxyProtocolException(paramByteBuf);
            }
            paramByteBuf = new StringBuilder();
          }
          catch (IllegalArgumentException paramByteBuf)
          {
            throw new HAProxyProtocolException(paramByteBuf);
          }
        }
        paramByteBuf.append("version 1 unsupported: 0x");
        paramByteBuf.append(Integer.toHexString(b));
        throw new HAProxyProtocolException(paramByteBuf.toString());
      }
      catch (IllegalArgumentException paramByteBuf)
      {
        throw new HAProxyProtocolException(paramByteBuf);
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("incomplete header: ");
    ((StringBuilder)localObject1).append(paramByteBuf.readableBytes());
    ((StringBuilder)localObject1).append(" bytes (expected: 16+ bytes)");
    throw new HAProxyProtocolException(((StringBuilder)localObject1).toString());
  }
  
  static HAProxyMessage decodeHeader(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = paramString.split(" ");
      int i = localObject.length;
      if (i >= 2)
      {
        if ("PROXY".equals(localObject[0])) {
          try
          {
            HAProxyProxiedProtocol localHAProxyProxiedProtocol = HAProxyProxiedProtocol.valueOf(localObject[1]);
            if ((localHAProxyProxiedProtocol != HAProxyProxiedProtocol.TCP4) && (localHAProxyProxiedProtocol != HAProxyProxiedProtocol.TCP6) && (localHAProxyProxiedProtocol != HAProxyProxiedProtocol.UNKNOWN))
            {
              paramString = new StringBuilder();
              paramString.append("unsupported v1 proxied protocol: ");
              paramString.append(localObject[1]);
              throw new HAProxyProtocolException(paramString.toString());
            }
            if (localHAProxyProxiedProtocol == HAProxyProxiedProtocol.UNKNOWN) {
              return unknownMsg(HAProxyProtocolVersion.V1, HAProxyCommand.PROXY);
            }
            if (i == 6) {
              try
              {
                paramString = new HAProxyMessage(HAProxyProtocolVersion.V1, HAProxyCommand.PROXY, localHAProxyProxiedProtocol, localObject[2], localObject[3], localObject[4], localObject[5]);
                return paramString;
              }
              catch (RuntimeException paramString)
              {
                throw new HAProxyProtocolException("invalid HAProxy message", paramString);
              }
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("invalid TCP4/6 header: ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" (expected: 6 parts)");
            throw new HAProxyProtocolException(((StringBuilder)localObject).toString());
          }
          catch (IllegalArgumentException paramString)
          {
            throw new HAProxyProtocolException(paramString);
          }
        }
        paramString = new StringBuilder();
        paramString.append("unknown identifier: ");
        paramString.append(localObject[0]);
        throw new HAProxyProtocolException(paramString.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid header: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" (expected: 'PROXY' and proxied protocol values)");
      throw new HAProxyProtocolException(((StringBuilder)localObject).toString());
    }
    throw new HAProxyProtocolException("header");
  }
  
  private static String ipBytesToString(ByteBuf paramByteBuf, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    if (paramInt == 4) {
      for (paramInt = j; paramInt < 4; paramInt++)
      {
        localStringBuilder.append(paramByteBuf.readByte() & 0xFF);
        localStringBuilder.append('.');
      }
    }
    while (i < 8)
    {
      localStringBuilder.append(Integer.toHexString(paramByteBuf.readUnsignedShort()));
      localStringBuilder.append(':');
      i++;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  private static int portStringToInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if ((i > 0) && (i <= 65535)) {
        return i;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid port: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" (expected: 1 ~ 65535)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid port: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString(), localNumberFormatException);
    }
  }
  
  private static HAProxyTLV readNextTLV(ByteBuf paramByteBuf)
  {
    if (paramByteBuf.readableBytes() < 4) {
      return null;
    }
    byte b = paramByteBuf.readByte();
    Object localObject = HAProxyTLV.Type.typeForByteValue(b);
    int i = paramByteBuf.readUnsignedShort();
    switch (1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[localObject.ordinal()])
    {
    default: 
      return null;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      return new HAProxyTLV((HAProxyTLV.Type)localObject, b, paramByteBuf.readRetainedSlice(i));
    }
    localObject = paramByteBuf.retainedSlice(paramByteBuf.readerIndex(), i);
    paramByteBuf = paramByteBuf.readSlice(i);
    b = paramByteBuf.readByte();
    i = paramByteBuf.readInt();
    if (paramByteBuf.readableBytes() >= 4)
    {
      ArrayList localArrayList = new ArrayList(4);
      do
      {
        HAProxyTLV localHAProxyTLV = readNextTLV(paramByteBuf);
        if (localHAProxyTLV == null) {
          break;
        }
        localArrayList.add(localHAProxyTLV);
      } while (paramByteBuf.readableBytes() >= 4);
      return new HAProxySSLTLV(i, b, localArrayList, (ByteBuf)localObject);
    }
    return new HAProxySSLTLV(i, b, Collections.emptyList(), (ByteBuf)localObject);
  }
  
  private static List<HAProxyTLV> readTlvs(ByteBuf paramByteBuf)
  {
    Object localObject = readNextTLV(paramByteBuf);
    if (localObject == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(4);
    HAProxyTLV localHAProxyTLV;
    do
    {
      localArrayList.add(localObject);
      if ((localObject instanceof HAProxySSLTLV)) {
        localArrayList.addAll(((HAProxySSLTLV)localObject).encapsulatedTLVs());
      }
      localHAProxyTLV = readNextTLV(paramByteBuf);
      localObject = localHAProxyTLV;
    } while (localHAProxyTLV != null);
    return localArrayList;
  }
  
  private void tryRecord()
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record();
    }
  }
  
  private static HAProxyMessage unknownMsg(HAProxyProtocolVersion paramHAProxyProtocolVersion, HAProxyCommand paramHAProxyCommand)
  {
    return new HAProxyMessage(paramHAProxyProtocolVersion, paramHAProxyCommand, HAProxyProxiedProtocol.UNKNOWN, null, null, 0, 0);
  }
  
  public HAProxyCommand command()
  {
    return this.command;
  }
  
  protected void deallocate()
  {
    try
    {
      Object localObject1 = this.tlvs.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((HAProxyTLV)((Iterator)localObject1).next()).release();
      }
      return;
    }
    finally
    {
      ResourceLeakTracker localResourceLeakTracker = this.leak;
      if (localResourceLeakTracker != null) {
        localResourceLeakTracker.close(this);
      }
    }
  }
  
  public String destinationAddress()
  {
    return this.destinationAddress;
  }
  
  public int destinationPort()
  {
    return this.destinationPort;
  }
  
  public HAProxyProtocolVersion protocolVersion()
  {
    return this.protocolVersion;
  }
  
  public HAProxyProxiedProtocol proxiedProtocol()
  {
    return this.proxiedProtocol;
  }
  
  public boolean release()
  {
    tryRecord();
    return super.release();
  }
  
  public boolean release(int paramInt)
  {
    tryRecord();
    return super.release(paramInt);
  }
  
  public HAProxyMessage retain()
  {
    tryRecord();
    return (HAProxyMessage)super.retain();
  }
  
  public HAProxyMessage retain(int paramInt)
  {
    tryRecord();
    return (HAProxyMessage)super.retain(paramInt);
  }
  
  public String sourceAddress()
  {
    return this.sourceAddress;
  }
  
  public int sourcePort()
  {
    return this.sourcePort;
  }
  
  int tlvNumBytes()
  {
    int i = 0;
    int j = 0;
    while (i < this.tlvs.size())
    {
      j += ((HAProxyTLV)this.tlvs.get(i)).totalNumBytes();
      i++;
    }
    return j;
  }
  
  public List<HAProxyTLV> tlvs()
  {
    return this.tlvs;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(protocolVersion: ");
    localStringBuilder.append(this.protocolVersion);
    localStringBuilder.append(", command: ");
    localStringBuilder.append(this.command);
    localStringBuilder.append(", proxiedProtocol: ");
    localStringBuilder.append(this.proxiedProtocol);
    localStringBuilder.append(", sourceAddress: ");
    localStringBuilder.append(this.sourceAddress);
    localStringBuilder.append(", destinationAddress: ");
    localStringBuilder.append(this.destinationAddress);
    localStringBuilder.append(", sourcePort: ");
    localStringBuilder.append(this.sourcePort);
    localStringBuilder.append(", destinationPort: ");
    localStringBuilder.append(this.destinationPort);
    localStringBuilder.append(", tlvs: [");
    if (!this.tlvs.isEmpty())
    {
      Iterator localIterator = this.tlvs.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((HAProxyTLV)localIterator.next());
        localStringBuilder.append(", ");
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
    }
    localStringBuilder.append("])");
    return localStringBuilder.toString();
  }
  
  public HAProxyMessage touch()
  {
    tryRecord();
    return (HAProxyMessage)super.touch();
  }
  
  public HAProxyMessage touch(Object paramObject)
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record(paramObject);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */