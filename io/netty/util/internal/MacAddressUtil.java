package io.netty.util.internal;

import io.netty.util.NetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class MacAddressUtil
{
  private static final int EUI48_MAC_ADDRESS_LENGTH = 6;
  private static final int EUI64_MAC_ADDRESS_LENGTH = 8;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(MacAddressUtil.class);
  
  public static byte[] bestAvailableMac()
  {
    localObject1 = EmptyArrays.EMPTY_BYTES;
    Object localObject2 = NetUtil.LOCALHOST4;
    Object localObject3 = new LinkedHashMap();
    try
    {
      Object localObject4 = NetworkInterface.getNetworkInterfaces();
      Object localObject5;
      if (localObject4 != null) {
        while (((Enumeration)localObject4).hasMoreElements())
        {
          NetworkInterface localNetworkInterface = (NetworkInterface)((Enumeration)localObject4).nextElement();
          localObject5 = SocketUtils.addressesFromNetworkInterface(localNetworkInterface);
          if (((Enumeration)localObject5).hasMoreElements())
          {
            localObject5 = (InetAddress)((Enumeration)localObject5).nextElement();
            if (!((InetAddress)localObject5).isLoopbackAddress()) {
              ((Map)localObject3).put(localNetworkInterface, localObject5);
            }
          }
        }
      }
      boolean bool;
      int i;
      InetAddress localInetAddress;
      int j;
      int k;
      return (byte[])localObject1;
    }
    catch (SocketException localSocketException2)
    {
      logger.warn("Failed to retrieve the list of available network interfaces", localSocketException2);
      localObject4 = ((Map)localObject3).entrySet().iterator();
      for (;;)
      {
        bool = ((Iterator)localObject4).hasNext();
        i = 0;
        if (!bool) {
          break;
        }
        localObject3 = (Map.Entry)((Iterator)localObject4).next();
        localObject5 = (NetworkInterface)((Map.Entry)localObject3).getKey();
        localInetAddress = (InetAddress)((Map.Entry)localObject3).getValue();
        if (!((NetworkInterface)localObject5).isVirtual()) {
          try
          {
            localObject3 = SocketUtils.hardwareAddressFromNetworkInterface((NetworkInterface)localObject5);
            j = compareAddresses((byte[])localObject1, (byte[])localObject3);
            if (j < 0) {}
            do
            {
              do
              {
                k = 1;
                break;
                k = i;
                if (j != 0) {
                  break;
                }
                j = compareAddresses((InetAddress)localObject2, localInetAddress);
              } while (j < 0);
              k = i;
              if (j != 0) {
                break;
              }
              k = i;
            } while (localObject1.length < localObject3.length);
            if (k != 0)
            {
              localObject2 = localInetAddress;
              localObject1 = localObject3;
            }
          }
          catch (SocketException localSocketException1)
          {
            logger.debug("Failed to get the hardware address of a network interface: {}", localObject5, localSocketException1);
          }
        }
      }
      if (localObject1 == EmptyArrays.EMPTY_BYTES) {
        return null;
      }
      if (localObject1.length != 6)
      {
        localObject1 = Arrays.copyOf((byte[])localObject1, 8);
      }
      else
      {
        localObject2 = new byte[8];
        System.arraycopy(localObject1, 0, localObject2, 0, 3);
        localObject2[3] = ((byte)-1);
        localObject2[4] = ((byte)-2);
        System.arraycopy(localObject1, 3, localObject2, 5, 3);
        localObject1 = localObject2;
      }
    }
  }
  
  private static int compareAddresses(InetAddress paramInetAddress1, InetAddress paramInetAddress2)
  {
    return scoreAddress(paramInetAddress1) - scoreAddress(paramInetAddress2);
  }
  
  static int compareAddresses(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 6))
    {
      int i = paramArrayOfByte2.length;
      for (int j = 0; j < i; j++)
      {
        int k = paramArrayOfByte2[j];
        if ((k != 0) && (k != 1))
        {
          j = 0;
          break label53;
        }
      }
      j = 1;
      label53:
      if (j != 0) {
        return 1;
      }
      if ((paramArrayOfByte2[0] & 0x1) != 0) {
        return 1;
      }
      if ((paramArrayOfByte2[0] & 0x2) == 0)
      {
        if ((paramArrayOfByte1.length != 0) && ((paramArrayOfByte1[0] & 0x2) == 0)) {
          return 0;
        }
        return -1;
      }
      if ((paramArrayOfByte1.length != 0) && ((paramArrayOfByte1[0] & 0x2) == 0)) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
  
  public static byte[] defaultMachineId()
  {
    byte[] arrayOfByte1 = bestAvailableMac();
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1 == null)
    {
      arrayOfByte2 = new byte[8];
      PlatformDependent.threadLocalRandom().nextBytes(arrayOfByte2);
      logger.warn("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", formatAddress(arrayOfByte2));
    }
    return arrayOfByte2;
  }
  
  public static String formatAddress(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(24);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++) {
      localStringBuilder.append(String.format("%02x:", new Object[] { Integer.valueOf(paramArrayOfByte[j] & 0xFF) }));
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public static byte[] parseMAC(String paramString)
  {
    int i = paramString.length();
    char c;
    Object localObject;
    if (i != 17)
    {
      if (i == 23)
      {
        c = paramString.charAt(2);
        validateMacSeparator(c);
        localObject = new byte[8];
      }
      else
      {
        throw new IllegalArgumentException("value is not supported [MAC-48, EUI-48, EUI-64]");
      }
    }
    else
    {
      c = paramString.charAt(2);
      validateMacSeparator(c);
      localObject = new byte[6];
    }
    int j = localObject.length - 1;
    int k = 0;
    i = 0;
    while (k < j)
    {
      int m = i + 2;
      localObject[k] = StringUtil.decodeHexByte(paramString, i);
      if (paramString.charAt(m) == c)
      {
        k++;
        i += 3;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("expected separator '");
        ((StringBuilder)localObject).append(c);
        ((StringBuilder)localObject).append(" but got '");
        ((StringBuilder)localObject).append(paramString.charAt(m));
        ((StringBuilder)localObject).append("' at index: ");
        ((StringBuilder)localObject).append(m);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    localObject[j] = StringUtil.decodeHexByte(paramString, i);
    return (byte[])localObject;
  }
  
  private static int scoreAddress(InetAddress paramInetAddress)
  {
    if ((!paramInetAddress.isAnyLocalAddress()) && (!paramInetAddress.isLoopbackAddress()))
    {
      if (paramInetAddress.isMulticastAddress()) {
        return 1;
      }
      if (paramInetAddress.isLinkLocalAddress()) {
        return 2;
      }
      if (paramInetAddress.isSiteLocalAddress()) {
        return 3;
      }
      return 4;
    }
    return 0;
  }
  
  private static void validateMacSeparator(char paramChar)
  {
    if ((paramChar != ':') && (paramChar != '-'))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unsupported separator: ");
      localStringBuilder.append(paramChar);
      localStringBuilder.append(" (expected: [:-])");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\MacAddressUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */