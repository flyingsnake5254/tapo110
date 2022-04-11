package io.netty.util.internal;

final class NativeLibraryUtil
{
  public static void loadLibrary(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      System.load(paramString);
    } else {
      System.loadLibrary(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\NativeLibraryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */