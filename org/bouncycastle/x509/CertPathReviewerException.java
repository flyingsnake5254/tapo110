package org.bouncycastle.x509;

import java.security.cert.CertPath;
import java.util.List;
import org.bouncycastle.i18n.LocalizedException;
import org.bouncycastle.i18n.a;

public class CertPathReviewerException
  extends LocalizedException
{
  private CertPath certPath = null;
  private int index = -1;
  
  public CertPathReviewerException(a parama)
  {
    super(parama);
  }
  
  public CertPathReviewerException(a parama, Throwable paramThrowable)
  {
    super(parama, paramThrowable);
  }
  
  public CertPathReviewerException(a parama, Throwable paramThrowable, CertPath paramCertPath, int paramInt)
  {
    super(parama, paramThrowable);
    if ((paramCertPath != null) && (paramInt != -1))
    {
      if ((paramInt >= -1) && (paramInt < paramCertPath.getCertificates().size()))
      {
        this.certPath = paramCertPath;
        this.index = paramInt;
        return;
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public CertPathReviewerException(a parama, CertPath paramCertPath, int paramInt)
  {
    super(parama);
    if ((paramCertPath != null) && (paramInt != -1))
    {
      if ((paramInt >= -1) && (paramInt < paramCertPath.getCertificates().size()))
      {
        this.certPath = paramCertPath;
        this.index = paramInt;
        return;
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public CertPath getCertPath()
  {
    return this.certPath;
  }
  
  public int getIndex()
  {
    return this.index;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\x509\CertPathReviewerException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */