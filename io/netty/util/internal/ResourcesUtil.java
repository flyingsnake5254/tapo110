package io.netty.util.internal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public final class ResourcesUtil
{
  public static File getFile(Class paramClass, String paramString)
  {
    try
    {
      File localFile = new File(URLDecoder.decode(paramClass.getResource(paramString).getFile(), "UTF-8"));
      return localFile;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new File(paramClass.getResource(paramString).getFile());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ResourcesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */