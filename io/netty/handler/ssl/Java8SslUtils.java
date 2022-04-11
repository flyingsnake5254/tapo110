package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class Java8SslUtils
{
  static boolean checkSniHostnameMatch(Collection<?> paramCollection, byte[] paramArrayOfByte)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      paramArrayOfByte = new SNIHostName(paramArrayOfByte);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        SNIMatcher localSNIMatcher = (SNIMatcher)paramCollection.next();
        if ((localSNIMatcher.getType() == 0) && (localSNIMatcher.matches(paramArrayOfByte))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  static List getSniHostName(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return Collections.singletonList(new SNIHostName(paramArrayOfByte));
    }
    return Collections.emptyList();
  }
  
  static List getSniHostNames(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new SNIHostName((String)paramList.next()));
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  static List<String> getSniHostNames(SSLParameters paramSSLParameters)
  {
    Object localObject = paramSSLParameters.getServerNames();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramSSLParameters = new ArrayList(((List)localObject).size());
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (SNIServerName)localIterator.next();
        if ((localObject instanceof SNIHostName))
        {
          paramSSLParameters.add(((SNIHostName)localObject).getAsciiName());
        }
        else
        {
          paramSSLParameters = new StringBuilder();
          paramSSLParameters.append("Only ");
          paramSSLParameters.append(SNIHostName.class.getName());
          paramSSLParameters.append(" instances are supported, but found: ");
          paramSSLParameters.append(localObject);
          throw new IllegalArgumentException(paramSSLParameters.toString());
        }
      }
      return paramSSLParameters;
    }
    return Collections.emptyList();
  }
  
  static boolean getUseCipherSuitesOrder(SSLParameters paramSSLParameters)
  {
    return paramSSLParameters.getUseCipherSuitesOrder();
  }
  
  static void setSNIMatchers(SSLParameters paramSSLParameters, Collection<?> paramCollection)
  {
    paramSSLParameters.setSNIMatchers(paramCollection);
  }
  
  static void setSniHostNames(SSLParameters paramSSLParameters, List<String> paramList)
  {
    paramSSLParameters.setServerNames(getSniHostNames(paramList));
  }
  
  static void setUseCipherSuitesOrder(SSLParameters paramSSLParameters, boolean paramBoolean)
  {
    paramSSLParameters.setUseCipherSuitesOrder(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\Java8SslUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */