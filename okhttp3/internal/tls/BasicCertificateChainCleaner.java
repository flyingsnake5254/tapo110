package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class BasicCertificateChainCleaner
  extends CertificateChainCleaner
{
  private static final int MAX_SIGNERS = 9;
  private final TrustRootIndex trustRootIndex;
  
  public BasicCertificateChainCleaner(TrustRootIndex paramTrustRootIndex)
  {
    this.trustRootIndex = paramTrustRootIndex;
  }
  
  private boolean verifySignature(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    if (!paramX509Certificate1.getIssuerDN().equals(paramX509Certificate2.getSubjectDN())) {
      return false;
    }
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    }
    catch (GeneralSecurityException paramX509Certificate1) {}
    return false;
  }
  
  public List<Certificate> clean(List<Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException
  {
    ArrayDeque localArrayDeque = new ArrayDeque(paramList);
    paramString = new ArrayList();
    paramString.add(localArrayDeque.removeFirst());
    int i = 0;
    int j = 0;
    while (i < 9)
    {
      paramList = (X509Certificate)paramString.get(paramString.size() - 1);
      Object localObject = this.trustRootIndex.findByIssuerAndSignature(paramList);
      if (localObject != null)
      {
        if ((paramString.size() > 1) || (!paramList.equals(localObject))) {
          paramString.add(localObject);
        }
        if (verifySignature((X509Certificate)localObject, (X509Certificate)localObject)) {
          return paramString;
        }
        j = 1;
      }
      else
      {
        localObject = localArrayDeque.iterator();
        X509Certificate localX509Certificate;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localX509Certificate = (X509Certificate)((Iterator)localObject).next();
        } while (!verifySignature(paramList, localX509Certificate));
        ((Iterator)localObject).remove();
        paramString.add(localX509Certificate);
      }
      i++;
      continue;
      if (j != 0) {
        return paramString;
      }
      paramString = new StringBuilder();
      paramString.append("Failed to find a trusted cert that signed ");
      paramString.append(paramList);
      throw new SSLPeerUnverifiedException(paramString.toString());
    }
    paramList = new StringBuilder();
    paramList.append("Certificate chain too long: ");
    paramList.append(paramString);
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((!(paramObject instanceof BasicCertificateChainCleaner)) || (!((BasicCertificateChainCleaner)paramObject).trustRootIndex.equals(this.trustRootIndex))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.trustRootIndex.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\tls\BasicCertificateChainCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */