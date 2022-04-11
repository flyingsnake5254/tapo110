package io.netty.util.internal;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class UnpaddedInternalThreadLocalMap
{
  static final AtomicInteger nextIndex = new AtomicInteger();
  static final ThreadLocal<InternalThreadLocalMap> slowThreadLocalMap = new ThreadLocal();
  ArrayList<Object> arrayList;
  Map<Charset, CharsetDecoder> charsetDecoderCache;
  Map<Charset, CharsetEncoder> charsetEncoderCache;
  IntegerHolder counterHashCode;
  int futureListenerStackDepth;
  Map<Class<?>, Boolean> handlerSharableCache;
  Object[] indexedVariables;
  int localChannelReaderStackDepth;
  ThreadLocalRandom random;
  StringBuilder stringBuilder;
  Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache;
  Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache;
  
  UnpaddedInternalThreadLocalMap(Object[] paramArrayOfObject)
  {
    this.indexedVariables = paramArrayOfObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\UnpaddedInternalThreadLocalMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */