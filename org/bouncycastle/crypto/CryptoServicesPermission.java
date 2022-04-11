package org.bouncycastle.crypto;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

public class CryptoServicesPermission
  extends Permission
{
  public static final String DEFAULT_RANDOM = "defaultRandomConfig";
  public static final String GLOBAL_CONFIG = "globalConfig";
  public static final String THREAD_LOCAL_CONFIG = "threadLocalConfig";
  private final Set<String> actions;
  
  public CryptoServicesPermission(String paramString)
  {
    super(paramString);
    HashSet localHashSet = new HashSet();
    this.actions = localHashSet;
    localHashSet.add(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof CryptoServicesPermission))
    {
      paramObject = (CryptoServicesPermission)paramObject;
      if (this.actions.equals(((CryptoServicesPermission)paramObject).actions)) {
        return true;
      }
    }
    return false;
  }
  
  public String getActions()
  {
    return this.actions.toString();
  }
  
  public int hashCode()
  {
    return this.actions.hashCode();
  }
  
  public boolean implies(Permission paramPermission)
  {
    if ((paramPermission instanceof CryptoServicesPermission))
    {
      paramPermission = (CryptoServicesPermission)paramPermission;
      if (getName().equals(paramPermission.getName())) {
        return true;
      }
      if (this.actions.containsAll(paramPermission.actions)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\CryptoServicesPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */