package kotlinx.android.extensions;

import kotlin.jvm.internal.j;

public enum CacheImplementation
{
  public static final a Companion;
  private static final CacheImplementation DEFAULT;
  
  static
  {
    CacheImplementation localCacheImplementation1 = new CacheImplementation("SPARSE_ARRAY", 0);
    SPARSE_ARRAY = localCacheImplementation1;
    CacheImplementation localCacheImplementation2 = new CacheImplementation("HASH_MAP", 1);
    HASH_MAP = localCacheImplementation2;
    CacheImplementation localCacheImplementation3 = new CacheImplementation("NO_CACHE", 2);
    NO_CACHE = localCacheImplementation3;
    $VALUES = new CacheImplementation[] { localCacheImplementation1, localCacheImplementation2, localCacheImplementation3 };
    Companion = new a(null);
    DEFAULT = localCacheImplementation2;
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\android\extensions\CacheImplementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */