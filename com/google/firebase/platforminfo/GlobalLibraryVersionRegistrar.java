package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GlobalLibraryVersionRegistrar
{
  private static volatile GlobalLibraryVersionRegistrar INSTANCE;
  private final Set<LibraryVersion> infos = new HashSet();
  
  public static GlobalLibraryVersionRegistrar getInstance()
  {
    GlobalLibraryVersionRegistrar localGlobalLibraryVersionRegistrar1 = INSTANCE;
    GlobalLibraryVersionRegistrar localGlobalLibraryVersionRegistrar2 = localGlobalLibraryVersionRegistrar1;
    if (localGlobalLibraryVersionRegistrar1 == null) {
      try
      {
        localGlobalLibraryVersionRegistrar1 = INSTANCE;
        localGlobalLibraryVersionRegistrar2 = localGlobalLibraryVersionRegistrar1;
        if (localGlobalLibraryVersionRegistrar1 == null)
        {
          localGlobalLibraryVersionRegistrar2 = new com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar;
          localGlobalLibraryVersionRegistrar2.<init>();
          INSTANCE = localGlobalLibraryVersionRegistrar2;
        }
      }
      finally {}
    }
    return localGlobalLibraryVersionRegistrar3;
  }
  
  Set<LibraryVersion> getRegisteredVersions()
  {
    synchronized (this.infos)
    {
      Set localSet2 = Collections.unmodifiableSet(this.infos);
      return localSet2;
    }
  }
  
  public void registerVersion(String paramString1, String paramString2)
  {
    synchronized (this.infos)
    {
      this.infos.add(LibraryVersion.create(paramString1, paramString2));
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\platforminfo\GlobalLibraryVersionRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */