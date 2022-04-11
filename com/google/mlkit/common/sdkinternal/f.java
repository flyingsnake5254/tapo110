package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
public class f
{
  private static final GmsLogger a = new GmsLogger("LibraryVersion", "");
  private static f b = new f();
  private final ConcurrentHashMap<String, String> c = new ConcurrentHashMap();
  
  @KeepForSdk
  public static f a()
  {
    return b;
  }
  
  @KeepForSdk
  public String b(@NonNull String paramString)
  {
    Preconditions.checkNotEmpty(paramString, "Please provide a valid libraryName");
    if (this.c.containsKey(paramString)) {
      return (String)this.c.get(paramString);
    }
    Object localObject1 = new Properties();
    GmsLogger localGmsLogger = null;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    try
    {
      Object localObject4 = f.class.getResourceAsStream(String.format("/%s.properties", new Object[] { paramString }));
      if (localObject4 != null)
      {
        localObject3 = localObject2;
        ((Properties)localObject1).load((InputStream)localObject4);
        localObject3 = localObject2;
        localObject1 = ((Properties)localObject1).getProperty("version", null);
        localObject3 = localObject1;
        localGmsLogger = a;
        localObject3 = localObject1;
        int i = String.valueOf(paramString).length();
        localObject3 = localObject1;
        int j = String.valueOf(localObject1).length();
        localObject3 = localObject1;
        localObject2 = new java/lang/StringBuilder;
        localObject3 = localObject1;
        ((StringBuilder)localObject2).<init>(i + 12 + j);
        localObject3 = localObject1;
        ((StringBuilder)localObject2).append(paramString);
        localObject3 = localObject1;
        ((StringBuilder)localObject2).append(" version is ");
        localObject3 = localObject1;
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject3 = localObject1;
        localGmsLogger.v("LibraryVersion", ((StringBuilder)localObject2).toString());
        localObject3 = localObject1;
      }
      else
      {
        localObject3 = localObject2;
        localObject4 = a;
        localObject3 = localObject2;
        localObject1 = String.valueOf(paramString);
        localObject3 = localObject2;
        if (((String)localObject1).length() != 0)
        {
          localObject3 = localObject2;
          localObject1 = "Failed to get app version for libraryName: ".concat((String)localObject1);
        }
        else
        {
          localObject3 = localObject2;
          localObject1 = new String("Failed to get app version for libraryName: ");
        }
        localObject3 = localObject2;
        ((GmsLogger)localObject4).e("LibraryVersion", (String)localObject1);
        localObject3 = localGmsLogger;
      }
    }
    catch (IOException localIOException)
    {
      localObject2 = a;
      localObject1 = String.valueOf(paramString);
      if (((String)localObject1).length() != 0) {
        localObject1 = "Failed to get app version for libraryName: ".concat((String)localObject1);
      } else {
        localObject1 = new String("Failed to get app version for libraryName: ");
      }
      ((GmsLogger)localObject2).e("LibraryVersion", (String)localObject1, localIOException);
    }
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      a.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
      localObject1 = "UNKNOWN";
    }
    this.c.put(paramString, localObject1);
    return (String)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */