package androidx.collection;

import kotlin.jvm.b.l;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class LruCacheKt
{
  public static final <K, V> LruCache<K, V> lruCache(final int paramInt, kotlin.jvm.b.p<? super K, ? super V, Integer> paramp, final l<? super K, ? extends V> paraml, final r<? super Boolean, ? super K, ? super V, ? super V, kotlin.p> paramr)
  {
    j.f(paramp, "sizeOf");
    j.f(paraml, "create");
    j.f(paramr, "onEntryRemoved");
    new LruCache(paramp)
    {
      protected V create(K paramAnonymousK)
      {
        j.f(paramAnonymousK, "key");
        return (V)paraml.invoke(paramAnonymousK);
      }
      
      protected void entryRemoved(boolean paramAnonymousBoolean, K paramAnonymousK, V paramAnonymousV1, V paramAnonymousV2)
      {
        j.f(paramAnonymousK, "key");
        j.f(paramAnonymousV1, "oldValue");
        paramr.invoke(Boolean.valueOf(paramAnonymousBoolean), paramAnonymousK, paramAnonymousV1, paramAnonymousV2);
      }
      
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        j.f(paramAnonymousK, "key");
        j.f(paramAnonymousV, "value");
        return ((Number)this.$sizeOf.invoke(paramAnonymousK, paramAnonymousV)).intValue();
      }
    };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\collection\LruCacheKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */