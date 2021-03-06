package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class OkHostnameVerifier
  implements HostnameVerifier
{
  private static final int ALT_DNS_NAME = 2;
  private static final int ALT_IPA_NAME = 7;
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
  
  public static List<String> allSubjectAltNames(X509Certificate paramX509Certificate)
  {
    List localList1 = getSubjectAltNames(paramX509Certificate, 7);
    List localList2 = getSubjectAltNames(paramX509Certificate, 2);
    paramX509Certificate = new ArrayList(localList1.size() + localList2.size());
    paramX509Certificate.addAll(localList1);
    paramX509Certificate.addAll(localList2);
    return paramX509Certificate;
  }
  
  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        Object localObject = (List)paramX509Certificate.next();
        if ((localObject != null) && (((List)localObject).size() >= 2))
        {
          Integer localInteger = (Integer)((List)localObject).get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            localObject = (String)((List)localObject).get(1);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      return localArrayList;
    }
    catch (CertificateParsingException paramX509Certificate) {}
    return Collections.emptyList();
  }
  
  private boolean verifyHostname(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2).iterator();
    while (paramX509Certificate.hasNext()) {
      if (verifyHostname(paramString, (String)paramX509Certificate.next())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 7);
    int i = paramX509Certificate.size();
    for (int j = 0; j < i; j++) {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.get(j))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    boolean bool;
    if (Util.verifyAsIpAddress(paramString)) {
      bool = verifyIpAddress(paramString, paramX509Certificate);
    } else {
      bool = verifyHostname(paramString, paramX509Certificate);
    }
    return bool;
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException paramString) {}
    return false;
  }
  
  public boolean verifyHostname(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (!paramString1.startsWith(".")) && (!paramString1.endsWith("..")) && (paramString2 != null) && (paramString2.length() != 0) && (!paramString2.startsWith(".")) && (!paramString2.endsWith("..")))
    {
      Object localObject = paramString1;
      if (!paramString1.endsWith("."))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append('.');
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString1 = paramString2;
      if (!paramString2.endsWith("."))
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append('.');
        paramString1 = paramString1.toString();
      }
      paramString1 = paramString1.toLowerCase(Locale.US);
      if (!paramString1.contains("*")) {
        return ((String)localObject).equals(paramString1);
      }
      if ((paramString1.startsWith("*.")) && (paramString1.indexOf('*', 1) == -1))
      {
        if (((String)localObject).length() < paramString1.length()) {
          return false;
        }
        if ("*.".equals(paramString1)) {
          return false;
        }
        paramString1 = paramString1.substring(1);
        if (!((String)localObject).endsWith(paramString1)) {
          return false;
        }
        int i = ((String)localObject).length() - paramString1.length();
        return (i <= 0) || (((String)localObject).lastIndexOf('.', i - 1) == -1);
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\tls\OkHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */