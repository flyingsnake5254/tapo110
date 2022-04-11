package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest
{
  private final List<List<byte[]>> mCertificates;
  private final int mCertificatesArray;
  private final String mIdentifier;
  private final String mProviderAuthority;
  private final String mProviderPackage;
  private final String mQuery;
  
  public FontRequest(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @ArrayRes int paramInt)
  {
    paramString1 = (String)Preconditions.checkNotNull(paramString1);
    this.mProviderAuthority = paramString1;
    paramString2 = (String)Preconditions.checkNotNull(paramString2);
    this.mProviderPackage = paramString2;
    paramString3 = (String)Preconditions.checkNotNull(paramString3);
    this.mQuery = paramString3;
    this.mCertificates = null;
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    this.mCertificatesArray = paramInt;
    paramString1 = new StringBuilder(paramString1);
    paramString1.append("-");
    paramString1.append(paramString2);
    paramString1.append("-");
    paramString1.append(paramString3);
    this.mIdentifier = paramString1.toString();
  }
  
  public FontRequest(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull List<List<byte[]>> paramList)
  {
    paramString1 = (String)Preconditions.checkNotNull(paramString1);
    this.mProviderAuthority = paramString1;
    paramString2 = (String)Preconditions.checkNotNull(paramString2);
    this.mProviderPackage = paramString2;
    paramString3 = (String)Preconditions.checkNotNull(paramString3);
    this.mQuery = paramString3;
    this.mCertificates = ((List)Preconditions.checkNotNull(paramList));
    this.mCertificatesArray = 0;
    paramString1 = new StringBuilder(paramString1);
    paramString1.append("-");
    paramString1.append(paramString2);
    paramString1.append("-");
    paramString1.append(paramString3);
    this.mIdentifier = paramString1.toString();
  }
  
  @Nullable
  public List<List<byte[]>> getCertificates()
  {
    return this.mCertificates;
  }
  
  @ArrayRes
  public int getCertificatesArrayResId()
  {
    return this.mCertificatesArray;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public String getIdentifier()
  {
    return this.mIdentifier;
  }
  
  @NonNull
  public String getProviderAuthority()
  {
    return this.mProviderAuthority;
  }
  
  @NonNull
  public String getProviderPackage()
  {
    return this.mProviderPackage;
  }
  
  @NonNull
  public String getQuery()
  {
    return this.mQuery;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FontRequest {mProviderAuthority: ");
    ((StringBuilder)localObject).append(this.mProviderAuthority);
    ((StringBuilder)localObject).append(", mProviderPackage: ");
    ((StringBuilder)localObject).append(this.mProviderPackage);
    ((StringBuilder)localObject).append(", mQuery: ");
    ((StringBuilder)localObject).append(this.mQuery);
    ((StringBuilder)localObject).append(", mCertificates:");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    for (int i = 0; i < this.mCertificates.size(); i++)
    {
      localStringBuilder.append(" [");
      localObject = (List)this.mCertificates.get(i);
      for (int j = 0; j < ((List)localObject).size(); j++)
      {
        localStringBuilder.append(" \"");
        localStringBuilder.append(Base64.encodeToString((byte[])((List)localObject).get(j), 0));
        localStringBuilder.append("\"");
      }
      localStringBuilder.append(" ]");
    }
    localStringBuilder.append("}");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mCertificatesArray: ");
    ((StringBuilder)localObject).append(this.mCertificatesArray);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\provider\FontRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */