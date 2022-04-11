package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil
{
  @KeepForSdk
  public static Set<Scope> fromScopeString(Collection<String> paramCollection)
  {
    Preconditions.checkNotNull(paramCollection, "scopeStrings can't be null.");
    return fromScopeString((String[])paramCollection.toArray(new String[paramCollection.size()]));
  }
  
  @KeepForSdk
  public static Set<Scope> fromScopeString(String... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs, "scopeStrings can't be null.");
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramVarArgs[j];
      if (!TextUtils.isEmpty(str)) {
        localHashSet.add(new Scope(str));
      }
    }
    return localHashSet;
  }
  
  @KeepForSdk
  public static String[] toScopeString(Set<Scope> paramSet)
  {
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    return toScopeString((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
  }
  
  @KeepForSdk
  public static String[] toScopeString(Scope[] paramArrayOfScope)
  {
    Preconditions.checkNotNull(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    for (int i = 0; i < paramArrayOfScope.length; i++) {
      arrayOfString[i] = paramArrayOfScope[i].getScopeUri();
    }
    return arrayOfString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\ScopeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */