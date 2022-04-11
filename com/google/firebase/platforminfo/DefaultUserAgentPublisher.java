package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

public class DefaultUserAgentPublisher
  implements UserAgentPublisher
{
  private final GlobalLibraryVersionRegistrar gamesSDKRegistrar;
  private final String javaSDKVersionUserAgent;
  
  DefaultUserAgentPublisher(Set<LibraryVersion> paramSet, GlobalLibraryVersionRegistrar paramGlobalLibraryVersionRegistrar)
  {
    this.javaSDKVersionUserAgent = toUserAgent(paramSet);
    this.gamesSDKRegistrar = paramGlobalLibraryVersionRegistrar;
  }
  
  public static Component<UserAgentPublisher> component()
  {
    return Component.builder(UserAgentPublisher.class).add(Dependency.setOf(LibraryVersion.class)).factory(a.a).build();
  }
  
  private static String toUserAgent(Set<LibraryVersion> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      paramSet = (LibraryVersion)localIterator.next();
      localStringBuilder.append(paramSet.getLibraryName());
      localStringBuilder.append('/');
      localStringBuilder.append(paramSet.getVersion());
      if (localIterator.hasNext()) {
        localStringBuilder.append(' ');
      }
    }
    return localStringBuilder.toString();
  }
  
  public String getUserAgent()
  {
    if (this.gamesSDKRegistrar.getRegisteredVersions().isEmpty()) {
      return this.javaSDKVersionUserAgent;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.javaSDKVersionUserAgent);
    localStringBuilder.append(' ');
    localStringBuilder.append(toUserAgent(this.gamesSDKRegistrar.getRegisteredVersions()));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\platforminfo\DefaultUserAgentPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */