package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.h;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson
{
  private static final com.google.gson.r.a<?> a = com.google.gson.r.a.get(Object.class);
  private final ThreadLocal<Map<com.google.gson.r.a<?>, FutureTypeAdapter<?>>> b = new ThreadLocal();
  private final Map<com.google.gson.r.a<?>, TypeAdapter<?>> c = new ConcurrentHashMap();
  private final com.google.gson.internal.c d;
  private final JsonAdapterAnnotationTypeAdapterFactory e;
  final List<p> f;
  final Excluder g;
  final c h;
  final Map<Type, e<?>> i;
  final boolean j;
  final boolean k;
  final boolean l;
  final boolean m;
  final boolean n;
  final boolean o;
  final boolean p;
  final String q;
  final int r;
  final int s;
  final LongSerializationPolicy t;
  final List<p> u;
  final List<p> v;
  
  public Gson()
  {
    this(Excluder.c, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
  }
  
  Gson(Excluder paramExcluder, c paramc, Map<Type, e<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, LongSerializationPolicy paramLongSerializationPolicy, String paramString, int paramInt1, int paramInt2, List<p> paramList1, List<p> paramList2, List<p> paramList3)
  {
    this.g = paramExcluder;
    this.h = paramc;
    this.i = paramMap;
    paramMap = new com.google.gson.internal.c(paramMap);
    this.d = paramMap;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.l = paramBoolean3;
    this.m = paramBoolean4;
    this.n = paramBoolean5;
    this.o = paramBoolean6;
    this.p = paramBoolean7;
    this.t = paramLongSerializationPolicy;
    this.q = paramString;
    this.r = paramInt1;
    this.s = paramInt2;
    this.u = paramList1;
    this.v = paramList2;
    paramString = new ArrayList();
    paramString.add(TypeAdapters.Y);
    paramString.add(ObjectTypeAdapter.a);
    paramString.add(paramExcluder);
    paramString.addAll(paramList3);
    paramString.add(TypeAdapters.D);
    paramString.add(TypeAdapters.m);
    paramString.add(TypeAdapters.g);
    paramString.add(TypeAdapters.i);
    paramString.add(TypeAdapters.k);
    paramLongSerializationPolicy = q(paramLongSerializationPolicy);
    paramString.add(TypeAdapters.c(Long.TYPE, Long.class, paramLongSerializationPolicy));
    paramString.add(TypeAdapters.c(Double.TYPE, Double.class, e(paramBoolean7)));
    paramString.add(TypeAdapters.c(Float.TYPE, Float.class, f(paramBoolean7)));
    paramString.add(TypeAdapters.x);
    paramString.add(TypeAdapters.o);
    paramString.add(TypeAdapters.q);
    paramString.add(TypeAdapters.b(AtomicLong.class, b(paramLongSerializationPolicy)));
    paramString.add(TypeAdapters.b(AtomicLongArray.class, c(paramLongSerializationPolicy)));
    paramString.add(TypeAdapters.s);
    paramString.add(TypeAdapters.z);
    paramString.add(TypeAdapters.F);
    paramString.add(TypeAdapters.H);
    paramString.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.B));
    paramString.add(TypeAdapters.b(BigInteger.class, TypeAdapters.C));
    paramString.add(TypeAdapters.J);
    paramString.add(TypeAdapters.L);
    paramString.add(TypeAdapters.P);
    paramString.add(TypeAdapters.R);
    paramString.add(TypeAdapters.W);
    paramString.add(TypeAdapters.N);
    paramString.add(TypeAdapters.d);
    paramString.add(DateTypeAdapter.a);
    paramString.add(TypeAdapters.U);
    paramString.add(TimeTypeAdapter.a);
    paramString.add(SqlDateTypeAdapter.a);
    paramString.add(TypeAdapters.S);
    paramString.add(ArrayTypeAdapter.a);
    paramString.add(TypeAdapters.b);
    paramString.add(new CollectionTypeAdapterFactory(paramMap));
    paramString.add(new MapTypeAdapterFactory(paramMap, paramBoolean2));
    paramLongSerializationPolicy = new JsonAdapterAnnotationTypeAdapterFactory(paramMap);
    this.e = paramLongSerializationPolicy;
    paramString.add(paramLongSerializationPolicy);
    paramString.add(TypeAdapters.Z);
    paramString.add(new ReflectiveTypeAdapterFactory(paramMap, paramc, paramExcluder, paramLongSerializationPolicy));
    this.f = Collections.unmodifiableList(paramString);
  }
  
  private static void a(Object paramObject, com.google.gson.stream.a parama)
  {
    if (paramObject != null) {
      try
      {
        if (parama.G() != JsonToken.END_DOCUMENT)
        {
          paramObject = new com/google/gson/JsonIOException;
          ((JsonIOException)paramObject).<init>("JSON document was not fully consumed.");
          throw ((Throwable)paramObject);
        }
      }
      catch (IOException paramObject)
      {
        throw new JsonIOException((Throwable)paramObject);
      }
      catch (MalformedJsonException paramObject)
      {
        throw new JsonSyntaxException((Throwable)paramObject);
      }
    }
  }
  
  private static TypeAdapter<AtomicLong> b(TypeAdapter<Number> paramTypeAdapter)
  {
    new TypeAdapter()
    {
      public AtomicLong a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        return new AtomicLong(((Number)Gson.this.read(paramAnonymousa)).longValue());
      }
      
      public void b(com.google.gson.stream.b paramAnonymousb, AtomicLong paramAnonymousAtomicLong)
        throws IOException
      {
        Gson.this.write(paramAnonymousb, Long.valueOf(paramAnonymousAtomicLong.get()));
      }
    }.nullSafe();
  }
  
  private static TypeAdapter<AtomicLongArray> c(TypeAdapter<Number> paramTypeAdapter)
  {
    new TypeAdapter()
    {
      public AtomicLongArray a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        ArrayList localArrayList = new ArrayList();
        paramAnonymousa.a();
        while (paramAnonymousa.s()) {
          localArrayList.add(Long.valueOf(((Number)Gson.this.read(paramAnonymousa)).longValue()));
        }
        paramAnonymousa.j();
        int i = localArrayList.size();
        paramAnonymousa = new AtomicLongArray(i);
        for (int j = 0; j < i; j++) {
          paramAnonymousa.set(j, ((Long)localArrayList.get(j)).longValue());
        }
        return paramAnonymousa;
      }
      
      public void b(com.google.gson.stream.b paramAnonymousb, AtomicLongArray paramAnonymousAtomicLongArray)
        throws IOException
      {
        paramAnonymousb.e();
        int i = paramAnonymousAtomicLongArray.length();
        for (int j = 0; j < i; j++) {
          Gson.this.write(paramAnonymousb, Long.valueOf(paramAnonymousAtomicLongArray.get(j)));
        }
        paramAnonymousb.j();
      }
    }.nullSafe();
  }
  
  static void d(double paramDouble)
  {
    if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private TypeAdapter<Number> e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TypeAdapters.v;
    }
    new TypeAdapter()
    {
      public Double a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return Double.valueOf(paramAnonymousa.x());
      }
      
      public void b(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousb.w();
          return;
        }
        Gson.d(paramAnonymousNumber.doubleValue());
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
  }
  
  private TypeAdapter<Number> f(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TypeAdapters.u;
    }
    new TypeAdapter()
    {
      public Float a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return Float.valueOf((float)paramAnonymousa.x());
      }
      
      public void b(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousb.w();
          return;
        }
        Gson.d(paramAnonymousNumber.floatValue());
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
  }
  
  private static TypeAdapter<Number> q(LongSerializationPolicy paramLongSerializationPolicy)
  {
    if (paramLongSerializationPolicy == LongSerializationPolicy.DEFAULT) {
      return TypeAdapters.t;
    }
    new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return Long.valueOf(paramAnonymousa.z());
      }
      
      public void b(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousb.w();
          return;
        }
        paramAnonymousb.J(paramAnonymousNumber.toString());
      }
    };
  }
  
  public i A(Object paramObject)
  {
    if (paramObject == null) {
      return j.a;
    }
    return B(paramObject, paramObject.getClass());
  }
  
  public i B(Object paramObject, Type paramType)
  {
    com.google.gson.internal.bind.b localb = new com.google.gson.internal.bind.b();
    y(paramObject, paramType, localb);
    return localb.M();
  }
  
  public <T> T g(i parami, Class<T> paramClass)
    throws JsonSyntaxException
  {
    parami = h(parami, paramClass);
    return (T)h.b(paramClass).cast(parami);
  }
  
  public <T> T h(i parami, Type paramType)
    throws JsonSyntaxException
  {
    if (parami == null) {
      return null;
    }
    return (T)i(new com.google.gson.internal.bind.a(parami), paramType);
  }
  
  /* Error */
  public <T> T i(com.google.gson.stream.a parama, Type paramType)
    throws JsonIOException, JsonSyntaxException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 457	com/google/gson/stream/a:t	()Z
    //   4: istore_3
    //   5: iconst_1
    //   6: istore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 460	com/google/gson/stream/a:L	(Z)V
    //   13: aload_1
    //   14: invokevirtual 326	com/google/gson/stream/a:G	()Lcom/google/gson/stream/JsonToken;
    //   17: pop
    //   18: iconst_0
    //   19: istore 4
    //   21: aload_0
    //   22: aload_2
    //   23: invokestatic 463	com/google/gson/r/a:get	(Ljava/lang/reflect/Type;)Lcom/google/gson/r/a;
    //   26: invokevirtual 466	com/google/gson/Gson:n	(Lcom/google/gson/r/a;)Lcom/google/gson/TypeAdapter;
    //   29: aload_1
    //   30: invokevirtual 470	com/google/gson/TypeAdapter:read	(Lcom/google/gson/stream/a;)Ljava/lang/Object;
    //   33: astore_2
    //   34: aload_1
    //   35: iload_3
    //   36: invokevirtual 460	com/google/gson/stream/a:L	(Z)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: goto +112 -> 154
    //   45: astore 5
    //   47: new 454	java/lang/AssertionError
    //   50: astore_2
    //   51: new 367	java/lang/StringBuilder
    //   54: astore 6
    //   56: aload 6
    //   58: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   61: aload 6
    //   63: ldc_w 472
    //   66: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 6
    //   72: aload 5
    //   74: invokevirtual 475	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_2
    //   82: aload 6
    //   84: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 478	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   90: aload_2
    //   91: aload 5
    //   93: invokevirtual 482	java/lang/AssertionError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   96: pop
    //   97: aload_2
    //   98: athrow
    //   99: astore 6
    //   101: new 344	com/google/gson/JsonSyntaxException
    //   104: astore_2
    //   105: aload_2
    //   106: aload 6
    //   108: invokespecial 345	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   111: aload_2
    //   112: athrow
    //   113: astore_2
    //   114: new 344	com/google/gson/JsonSyntaxException
    //   117: astore 6
    //   119: aload 6
    //   121: aload_2
    //   122: invokespecial 345	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   125: aload 6
    //   127: athrow
    //   128: astore 6
    //   130: iload 4
    //   132: ifeq +10 -> 142
    //   135: aload_1
    //   136: iload_3
    //   137: invokevirtual 460	com/google/gson/stream/a:L	(Z)V
    //   140: aconst_null
    //   141: areturn
    //   142: new 344	com/google/gson/JsonSyntaxException
    //   145: astore_2
    //   146: aload_2
    //   147: aload 6
    //   149: invokespecial 345	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   152: aload_2
    //   153: athrow
    //   154: aload_1
    //   155: iload_3
    //   156: invokevirtual 460	com/google/gson/stream/a:L	(Z)V
    //   159: aload_2
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	Gson
    //   0	161	1	parama	com.google.gson.stream.a
    //   0	161	2	paramType	Type
    //   4	152	3	bool	boolean
    //   6	125	4	i1	int
    //   45	47	5	localAssertionError	AssertionError
    //   54	29	6	localStringBuilder	StringBuilder
    //   99	8	6	localIOException	IOException
    //   117	9	6	localJsonSyntaxException	JsonSyntaxException
    //   128	20	6	localEOFException	java.io.EOFException
    // Exception table:
    //   from	to	target	type
    //   13	18	41	finally
    //   21	34	41	finally
    //   47	99	41	finally
    //   101	113	41	finally
    //   114	128	41	finally
    //   142	154	41	finally
    //   13	18	45	java/lang/AssertionError
    //   21	34	45	java/lang/AssertionError
    //   13	18	99	java/io/IOException
    //   21	34	99	java/io/IOException
    //   13	18	113	java/lang/IllegalStateException
    //   21	34	113	java/lang/IllegalStateException
    //   13	18	128	java/io/EOFException
    //   21	34	128	java/io/EOFException
  }
  
  public <T> T j(Reader paramReader, Class<T> paramClass)
    throws JsonSyntaxException, JsonIOException
  {
    com.google.gson.stream.a locala = r(paramReader);
    paramReader = i(locala, paramClass);
    a(paramReader, locala);
    return (T)h.b(paramClass).cast(paramReader);
  }
  
  public <T> T k(Reader paramReader, Type paramType)
    throws JsonIOException, JsonSyntaxException
  {
    paramReader = r(paramReader);
    paramType = i(paramReader, paramType);
    a(paramType, paramReader);
    return paramType;
  }
  
  public <T> T l(String paramString, Class<T> paramClass)
    throws JsonSyntaxException
  {
    paramString = m(paramString, paramClass);
    return (T)h.b(paramClass).cast(paramString);
  }
  
  public <T> T m(String paramString, Type paramType)
    throws JsonSyntaxException
  {
    if (paramString == null) {
      return null;
    }
    return (T)k(new StringReader(paramString), paramType);
  }
  
  public <T> TypeAdapter<T> n(com.google.gson.r.a<T> parama)
  {
    Object localObject1 = this.c;
    if (parama == null) {
      localObject3 = a;
    } else {
      localObject3 = parama;
    }
    Object localObject3 = (TypeAdapter)((Map)localObject1).get(localObject3);
    if (localObject3 != null) {
      return (TypeAdapter<T>)localObject3;
    }
    localObject1 = (Map)this.b.get();
    int i1 = 0;
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = new HashMap();
      this.b.set(localObject3);
      i1 = 1;
    }
    localObject1 = (FutureTypeAdapter)((Map)localObject3).get(parama);
    if (localObject1 != null) {
      return (TypeAdapter<T>)localObject1;
    }
    try
    {
      FutureTypeAdapter localFutureTypeAdapter = new com/google/gson/Gson$FutureTypeAdapter;
      localFutureTypeAdapter.<init>();
      ((Map)localObject3).put(parama, localFutureTypeAdapter);
      localObject1 = this.f.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((p)((Iterator)localObject1).next()).a(this, parama);
        if (localObject4 != null)
        {
          localFutureTypeAdapter.a((TypeAdapter)localObject4);
          this.c.put(parama, localObject4);
          return (TypeAdapter<T>)localObject4;
        }
      }
      Object localObject4 = new java/lang/IllegalArgumentException;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("GSON (2.8.6) cannot handle ");
      ((StringBuilder)localObject1).append(parama);
      ((IllegalArgumentException)localObject4).<init>(((StringBuilder)localObject1).toString());
      throw ((Throwable)localObject4);
    }
    finally
    {
      ((Map)localObject3).remove(parama);
      if (i1 != 0) {
        this.b.remove();
      }
    }
  }
  
  public <T> TypeAdapter<T> o(Class<T> paramClass)
  {
    return n(com.google.gson.r.a.get(paramClass));
  }
  
  public <T> TypeAdapter<T> p(p paramp, com.google.gson.r.a<T> parama)
  {
    Object localObject1 = paramp;
    if (!this.f.contains(paramp)) {
      localObject1 = this.e;
    }
    int i1 = 0;
    paramp = this.f.iterator();
    while (paramp.hasNext())
    {
      Object localObject2 = (p)paramp.next();
      if (i1 == 0)
      {
        if (localObject2 == localObject1) {
          i1 = 1;
        }
      }
      else
      {
        localObject2 = ((p)localObject2).a(this, parama);
        if (localObject2 != null) {
          return (TypeAdapter<T>)localObject2;
        }
      }
    }
    paramp = new StringBuilder();
    paramp.append("GSON cannot serialize ");
    paramp.append(parama);
    throw new IllegalArgumentException(paramp.toString());
  }
  
  public com.google.gson.stream.a r(Reader paramReader)
  {
    paramReader = new com.google.gson.stream.a(paramReader);
    paramReader.L(this.o);
    return paramReader;
  }
  
  public com.google.gson.stream.b s(Writer paramWriter)
    throws IOException
  {
    if (this.l) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new com.google.gson.stream.b(paramWriter);
    if (this.n) {
      paramWriter.C("  ");
    }
    paramWriter.E(this.j);
    return paramWriter;
  }
  
  public String t(i parami)
  {
    StringWriter localStringWriter = new StringWriter();
    x(parami, localStringWriter);
    return localStringWriter.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{serializeNulls:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",factories:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",instanceCreators:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public String u(Object paramObject)
  {
    if (paramObject == null) {
      return t(j.a);
    }
    return v(paramObject, paramObject.getClass());
  }
  
  public String v(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    z(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  /* Error */
  public void w(i parami, com.google.gson.stream.b paramb)
    throws JsonIOException
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 615	com/google/gson/stream/b:t	()Z
    //   4: istore_3
    //   5: aload_2
    //   6: iconst_1
    //   7: invokevirtual 617	com/google/gson/stream/b:D	(Z)V
    //   10: aload_2
    //   11: invokevirtual 619	com/google/gson/stream/b:s	()Z
    //   14: istore 4
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 129	com/google/gson/Gson:m	Z
    //   21: invokevirtual 621	com/google/gson/stream/b:B	(Z)V
    //   24: aload_2
    //   25: invokevirtual 623	com/google/gson/stream/b:l	()Z
    //   28: istore 5
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 123	com/google/gson/Gson:j	Z
    //   35: invokevirtual 583	com/google/gson/stream/b:E	(Z)V
    //   38: aload_1
    //   39: aload_2
    //   40: invokestatic 627	com/google/gson/internal/i:b	(Lcom/google/gson/i;Lcom/google/gson/stream/b;)V
    //   43: aload_2
    //   44: iload_3
    //   45: invokevirtual 617	com/google/gson/stream/b:D	(Z)V
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 621	com/google/gson/stream/b:B	(Z)V
    //   54: aload_2
    //   55: iload 5
    //   57: invokevirtual 583	com/google/gson/stream/b:E	(Z)V
    //   60: return
    //   61: astore_1
    //   62: goto +71 -> 133
    //   65: astore 6
    //   67: new 454	java/lang/AssertionError
    //   70: astore 7
    //   72: new 367	java/lang/StringBuilder
    //   75: astore_1
    //   76: aload_1
    //   77: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   80: aload_1
    //   81: ldc_w 472
    //   84: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: aload 6
    //   91: invokevirtual 475	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   94: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 7
    //   100: aload_1
    //   101: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 478	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   107: aload 7
    //   109: aload 6
    //   111: invokevirtual 482	java/lang/AssertionError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   114: pop
    //   115: aload 7
    //   117: athrow
    //   118: astore_1
    //   119: new 334	com/google/gson/JsonIOException
    //   122: astore 7
    //   124: aload 7
    //   126: aload_1
    //   127: invokespecial 342	com/google/gson/JsonIOException:<init>	(Ljava/lang/Throwable;)V
    //   130: aload 7
    //   132: athrow
    //   133: aload_2
    //   134: iload_3
    //   135: invokevirtual 617	com/google/gson/stream/b:D	(Z)V
    //   138: aload_2
    //   139: iload 4
    //   141: invokevirtual 621	com/google/gson/stream/b:B	(Z)V
    //   144: aload_2
    //   145: iload 5
    //   147: invokevirtual 583	com/google/gson/stream/b:E	(Z)V
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	Gson
    //   0	152	1	parami	i
    //   0	152	2	paramb	com.google.gson.stream.b
    //   4	131	3	bool1	boolean
    //   14	126	4	bool2	boolean
    //   28	118	5	bool3	boolean
    //   65	45	6	localAssertionError	AssertionError
    //   70	61	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	43	61	finally
    //   67	118	61	finally
    //   119	133	61	finally
    //   38	43	65	java/lang/AssertionError
    //   38	43	118	java/io/IOException
  }
  
  public void x(i parami, Appendable paramAppendable)
    throws JsonIOException
  {
    try
    {
      w(parami, s(com.google.gson.internal.i.c(paramAppendable)));
      return;
    }
    catch (IOException parami)
    {
      throw new JsonIOException(parami);
    }
  }
  
  /* Error */
  public void y(Object paramObject, Type paramType, com.google.gson.stream.b paramb)
    throws JsonIOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokestatic 463	com/google/gson/r/a:get	(Ljava/lang/reflect/Type;)Lcom/google/gson/r/a;
    //   5: invokevirtual 466	com/google/gson/Gson:n	(Lcom/google/gson/r/a;)Lcom/google/gson/TypeAdapter;
    //   8: astore_2
    //   9: aload_3
    //   10: invokevirtual 615	com/google/gson/stream/b:t	()Z
    //   13: istore 4
    //   15: aload_3
    //   16: iconst_1
    //   17: invokevirtual 617	com/google/gson/stream/b:D	(Z)V
    //   20: aload_3
    //   21: invokevirtual 619	com/google/gson/stream/b:s	()Z
    //   24: istore 5
    //   26: aload_3
    //   27: aload_0
    //   28: getfield 129	com/google/gson/Gson:m	Z
    //   31: invokevirtual 621	com/google/gson/stream/b:B	(Z)V
    //   34: aload_3
    //   35: invokevirtual 623	com/google/gson/stream/b:l	()Z
    //   38: istore 6
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 123	com/google/gson/Gson:j	Z
    //   45: invokevirtual 583	com/google/gson/stream/b:E	(Z)V
    //   48: aload_2
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 637	com/google/gson/TypeAdapter:write	(Lcom/google/gson/stream/b;Ljava/lang/Object;)V
    //   54: aload_3
    //   55: iload 4
    //   57: invokevirtual 617	com/google/gson/stream/b:D	(Z)V
    //   60: aload_3
    //   61: iload 5
    //   63: invokevirtual 621	com/google/gson/stream/b:B	(Z)V
    //   66: aload_3
    //   67: iload 6
    //   69: invokevirtual 583	com/google/gson/stream/b:E	(Z)V
    //   72: return
    //   73: astore_1
    //   74: goto +66 -> 140
    //   77: astore_2
    //   78: new 454	java/lang/AssertionError
    //   81: astore_1
    //   82: new 367	java/lang/StringBuilder
    //   85: astore 7
    //   87: aload 7
    //   89: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   92: aload 7
    //   94: ldc_w 472
    //   97: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 7
    //   103: aload_2
    //   104: invokevirtual 475	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: aload 7
    //   114: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 478	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   120: aload_1
    //   121: aload_2
    //   122: invokevirtual 482	java/lang/AssertionError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   125: pop
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: new 334	com/google/gson/JsonIOException
    //   132: astore_2
    //   133: aload_2
    //   134: aload_1
    //   135: invokespecial 342	com/google/gson/JsonIOException:<init>	(Ljava/lang/Throwable;)V
    //   138: aload_2
    //   139: athrow
    //   140: aload_3
    //   141: iload 4
    //   143: invokevirtual 617	com/google/gson/stream/b:D	(Z)V
    //   146: aload_3
    //   147: iload 5
    //   149: invokevirtual 621	com/google/gson/stream/b:B	(Z)V
    //   152: aload_3
    //   153: iload 6
    //   155: invokevirtual 583	com/google/gson/stream/b:E	(Z)V
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	Gson
    //   0	160	1	paramObject	Object
    //   0	160	2	paramType	Type
    //   0	160	3	paramb	com.google.gson.stream.b
    //   13	129	4	bool1	boolean
    //   24	124	5	bool2	boolean
    //   38	116	6	bool3	boolean
    //   85	28	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	54	73	finally
    //   78	128	73	finally
    //   129	140	73	finally
    //   48	54	77	java/lang/AssertionError
    //   48	54	128	java/io/IOException
  }
  
  public void z(Object paramObject, Type paramType, Appendable paramAppendable)
    throws JsonIOException
  {
    try
    {
      y(paramObject, paramType, s(com.google.gson.internal.i.c(paramAppendable)));
      return;
    }
    catch (IOException paramObject)
    {
      throw new JsonIOException((Throwable)paramObject);
    }
  }
  
  static class FutureTypeAdapter<T>
    extends TypeAdapter<T>
  {
    private TypeAdapter<T> a;
    
    public void a(TypeAdapter<T> paramTypeAdapter)
    {
      if (this.a == null)
      {
        this.a = paramTypeAdapter;
        return;
      }
      throw new AssertionError();
    }
    
    public T read(com.google.gson.stream.a parama)
      throws IOException
    {
      TypeAdapter localTypeAdapter = this.a;
      if (localTypeAdapter != null) {
        return (T)localTypeAdapter.read(parama);
      }
      throw new IllegalStateException();
    }
    
    public void write(com.google.gson.stream.b paramb, T paramT)
      throws IOException
    {
      TypeAdapter localTypeAdapter = this.a;
      if (localTypeAdapter != null)
      {
        localTypeAdapter.write(paramb, paramT);
        return;
      }
      throw new IllegalStateException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\Gson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */