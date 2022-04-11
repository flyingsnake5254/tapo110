package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;

public class LibraryVersionComponent
{
  public static Component<?> create(String paramString1, String paramString2)
  {
    return Component.intoSet(LibraryVersion.create(paramString1, paramString2), LibraryVersion.class);
  }
  
  public static Component<?> fromContext(String paramString, VersionExtractor<Context> paramVersionExtractor)
  {
    return Component.intoSetBuilder(LibraryVersion.class).add(Dependency.required(Context.class)).factory(new b(paramString, paramVersionExtractor)).build();
  }
  
  public static abstract interface VersionExtractor<T>
  {
    public abstract String extract(T paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\platforminfo\LibraryVersionComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */