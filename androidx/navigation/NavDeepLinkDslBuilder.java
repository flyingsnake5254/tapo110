package androidx.navigation;

import kotlin.jvm.internal.j;

@NavDeepLinkDsl
public final class NavDeepLinkDslBuilder
{
  private String action;
  private final NavDeepLink.Builder builder = new NavDeepLink.Builder();
  private String mimeType;
  private String uriPattern;
  
  public final NavDeepLink build$navigation_common_ktx_release()
  {
    Object localObject = this.builder;
    String str = this.uriPattern;
    int i;
    if ((str == null) && (this.action == null) && (this.mimeType == null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if (str != null) {
        ((NavDeepLink.Builder)localObject).setUriPattern(str);
      }
      str = this.action;
      if (str != null) {
        ((NavDeepLink.Builder)localObject).setAction(str);
      }
      str = this.mimeType;
      if (str != null) {
        ((NavDeepLink.Builder)localObject).setMimeType(str);
      }
      localObject = ((NavDeepLink.Builder)localObject).build();
      j.b(localObject, "builder.apply {\n        …eType(it) }\n    }.build()");
      return (NavDeepLink)localObject;
    }
    throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.".toString());
  }
  
  public final String getAction()
  {
    return this.action;
  }
  
  public final String getMimeType()
  {
    return this.mimeType;
  }
  
  public final String getUriPattern()
  {
    return this.uriPattern;
  }
  
  public final void setAction(String paramString)
  {
    if (paramString != null)
    {
      int i;
      if (paramString.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
      }
    }
    this.action = paramString;
  }
  
  public final void setMimeType(String paramString)
  {
    this.mimeType = paramString;
  }
  
  public final void setUriPattern(String paramString)
  {
    this.uriPattern = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDeepLinkDslBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */