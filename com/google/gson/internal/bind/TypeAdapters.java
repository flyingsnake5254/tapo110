package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.p;
import com.google.gson.q.c;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters
{
  public static final TypeAdapter<String> A;
  public static final TypeAdapter<BigDecimal> B;
  public static final TypeAdapter<BigInteger> C;
  public static final p D;
  public static final TypeAdapter<StringBuilder> E;
  public static final p F;
  public static final TypeAdapter<StringBuffer> G;
  public static final p H;
  public static final TypeAdapter<URL> I;
  public static final p J;
  public static final TypeAdapter<URI> K;
  public static final p L;
  public static final TypeAdapter<InetAddress> M;
  public static final p N;
  public static final TypeAdapter<UUID> O;
  public static final p P;
  public static final TypeAdapter<Currency> Q;
  public static final p R;
  public static final p S;
  public static final TypeAdapter<Calendar> T;
  public static final p U;
  public static final TypeAdapter<Locale> V;
  public static final p W;
  public static final TypeAdapter<i> X;
  public static final p Y;
  public static final p Z = new p()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
    {
      paramAnonymousa = paramAnonymousa.getRawType();
      if ((Enum.class.isAssignableFrom(paramAnonymousa)) && (paramAnonymousa != Enum.class))
      {
        paramAnonymousGson = paramAnonymousa;
        if (!paramAnonymousa.isEnum()) {
          paramAnonymousGson = paramAnonymousa.getSuperclass();
        }
        return new TypeAdapters.EnumTypeAdapter(paramAnonymousGson);
      }
      return null;
    }
  };
  public static final TypeAdapter<Class> a;
  public static final p b;
  public static final TypeAdapter<BitSet> c;
  public static final p d;
  public static final TypeAdapter<Boolean> e;
  public static final TypeAdapter<Boolean> f;
  public static final p g;
  public static final TypeAdapter<Number> h;
  public static final p i;
  public static final TypeAdapter<Number> j;
  public static final p k;
  public static final TypeAdapter<Number> l;
  public static final p m;
  public static final TypeAdapter<AtomicInteger> n;
  public static final p o;
  public static final TypeAdapter<AtomicBoolean> p;
  public static final p q;
  public static final TypeAdapter<AtomicIntegerArray> r;
  public static final p s;
  public static final TypeAdapter<Number> t;
  public static final TypeAdapter<Number> u;
  public static final TypeAdapter<Number> v;
  public static final TypeAdapter<Number> w;
  public static final p x;
  public static final TypeAdapter<Character> y;
  public static final p z;
  
  static
  {
    Object localObject = new TypeAdapter()
    {
      public Class a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
      }
      
      public void b(b paramAnonymousb, Class paramAnonymousClass)
        throws IOException
      {
        paramAnonymousb = new StringBuilder();
        paramAnonymousb.append("Attempted to serialize java.lang.Class: ");
        paramAnonymousb.append(paramAnonymousClass.getName());
        paramAnonymousb.append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(paramAnonymousb.toString());
      }
    }.nullSafe();
    a = (TypeAdapter)localObject;
    b = b(Class.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public BitSet a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        BitSet localBitSet = new BitSet();
        paramAnonymousa.a();
        Object localObject = paramAnonymousa.G();
        int i = 0;
        while (localObject != JsonToken.END_ARRAY)
        {
          int j = TypeAdapters.a.a[localObject.ordinal()];
          boolean bool = true;
          if (j != 1) {
            if (j != 2) {
              if (j == 3) {
                localObject = paramAnonymousa.E();
              }
            }
          }
          while (paramAnonymousa.y() == 0)
          {
            try
            {
              j = Integer.parseInt((String)localObject);
              if (j != 0) {
                break;
              }
              bool = false;
            }
            catch (NumberFormatException paramAnonymousa)
            {
              paramAnonymousa = new StringBuilder();
              paramAnonymousa.append("Error: Expecting: bitset number value (1, 0), Found: ");
              paramAnonymousa.append((String)localObject);
              throw new JsonSyntaxException(paramAnonymousa.toString());
            }
            paramAnonymousa = new StringBuilder();
            paramAnonymousa.append("Invalid bitset value type: ");
            paramAnonymousa.append(localObject);
            throw new JsonSyntaxException(paramAnonymousa.toString());
            bool = paramAnonymousa.w();
            break;
          }
          if (bool) {
            localBitSet.set(i);
          }
          i++;
          localObject = paramAnonymousa.G();
        }
        paramAnonymousa.j();
        return localBitSet;
      }
      
      public void b(b paramAnonymousb, BitSet paramAnonymousBitSet)
        throws IOException
      {
        paramAnonymousb.e();
        int i = paramAnonymousBitSet.length();
        for (int j = 0; j < i; j++) {
          paramAnonymousb.G(paramAnonymousBitSet.get(j));
        }
        paramAnonymousb.j();
      }
    }.nullSafe();
    c = (TypeAdapter)localObject;
    d = b(BitSet.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Boolean a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        JsonToken localJsonToken = paramAnonymousa.G();
        if (localJsonToken == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        if (localJsonToken == JsonToken.STRING) {
          return Boolean.valueOf(Boolean.parseBoolean(paramAnonymousa.E()));
        }
        return Boolean.valueOf(paramAnonymousa.w());
      }
      
      public void b(b paramAnonymousb, Boolean paramAnonymousBoolean)
        throws IOException
      {
        paramAnonymousb.H(paramAnonymousBoolean);
      }
    };
    e = (TypeAdapter)localObject;
    f = new TypeAdapter()
    {
      public Boolean a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return Boolean.valueOf(paramAnonymousa.E());
      }
      
      public void b(b paramAnonymousb, Boolean paramAnonymousBoolean)
        throws IOException
      {
        if (paramAnonymousBoolean == null) {
          paramAnonymousBoolean = "null";
        } else {
          paramAnonymousBoolean = paramAnonymousBoolean.toString();
        }
        paramAnonymousb.J(paramAnonymousBoolean);
      }
    };
    g = c(Boolean.TYPE, Boolean.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        try
        {
          byte b = (byte)paramAnonymousa.y();
          return Byte.valueOf(b);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new JsonSyntaxException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
    h = (TypeAdapter)localObject;
    i = c(Byte.TYPE, Byte.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        try
        {
          short s = (short)paramAnonymousa.y();
          return Short.valueOf(s);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new JsonSyntaxException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
    j = (TypeAdapter)localObject;
    k = c(Short.TYPE, Short.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        try
        {
          int i = paramAnonymousa.y();
          return Integer.valueOf(i);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new JsonSyntaxException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
    l = (TypeAdapter)localObject;
    m = c(Integer.TYPE, Integer.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public AtomicInteger a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        try
        {
          paramAnonymousa = new AtomicInteger(paramAnonymousa.y());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new JsonSyntaxException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, AtomicInteger paramAnonymousAtomicInteger)
        throws IOException
      {
        paramAnonymousb.G(paramAnonymousAtomicInteger.get());
      }
    }.nullSafe();
    n = (TypeAdapter)localObject;
    o = b(AtomicInteger.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public AtomicBoolean a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        return new AtomicBoolean(paramAnonymousa.w());
      }
      
      public void b(b paramAnonymousb, AtomicBoolean paramAnonymousAtomicBoolean)
        throws IOException
      {
        paramAnonymousb.K(paramAnonymousAtomicBoolean.get());
      }
    }.nullSafe();
    p = (TypeAdapter)localObject;
    q = b(AtomicBoolean.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public AtomicIntegerArray a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        ArrayList localArrayList = new ArrayList();
        paramAnonymousa.a();
        while (paramAnonymousa.s()) {
          try
          {
            localArrayList.add(Integer.valueOf(paramAnonymousa.y()));
          }
          catch (NumberFormatException paramAnonymousa)
          {
            throw new JsonSyntaxException(paramAnonymousa);
          }
        }
        paramAnonymousa.j();
        int i = localArrayList.size();
        paramAnonymousa = new AtomicIntegerArray(i);
        for (int j = 0; j < i; j++) {
          paramAnonymousa.set(j, ((Integer)localArrayList.get(j)).intValue());
        }
        return paramAnonymousa;
      }
      
      public void b(b paramAnonymousb, AtomicIntegerArray paramAnonymousAtomicIntegerArray)
        throws IOException
      {
        paramAnonymousb.e();
        int i = paramAnonymousAtomicIntegerArray.length();
        for (int j = 0; j < i; j++) {
          paramAnonymousb.G(paramAnonymousAtomicIntegerArray.get(j));
        }
        paramAnonymousb.j();
      }
    }.nullSafe();
    r = (TypeAdapter)localObject;
    s = b(AtomicIntegerArray.class, (TypeAdapter)localObject);
    t = new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        try
        {
          long l = paramAnonymousa.z();
          return Long.valueOf(l);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new JsonSyntaxException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
    u = new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return Float.valueOf((float)paramAnonymousa.x());
      }
      
      public void b(b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
    v = new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return Double.valueOf(paramAnonymousa.x());
      }
      
      public void b(b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
    localObject = new TypeAdapter()
    {
      public Number a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        JsonToken localJsonToken = paramAnonymousa.G();
        int i = TypeAdapters.a.a[localJsonToken.ordinal()];
        if ((i != 1) && (i != 3))
        {
          if (i == 4)
          {
            paramAnonymousa.C();
            return null;
          }
          paramAnonymousa = new StringBuilder();
          paramAnonymousa.append("Expecting number, got: ");
          paramAnonymousa.append(localJsonToken);
          throw new JsonSyntaxException(paramAnonymousa.toString());
        }
        return new LazilyParsedNumber(paramAnonymousa.E());
      }
      
      public void b(b paramAnonymousb, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousNumber);
      }
    };
    w = (TypeAdapter)localObject;
    x = b(Number.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Character a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        paramAnonymousa = paramAnonymousa.E();
        if (paramAnonymousa.length() == 1) {
          return Character.valueOf(paramAnonymousa.charAt(0));
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Expecting character, got: ");
        localStringBuilder.append(paramAnonymousa);
        throw new JsonSyntaxException(localStringBuilder.toString());
      }
      
      public void b(b paramAnonymousb, Character paramAnonymousCharacter)
        throws IOException
      {
        if (paramAnonymousCharacter == null) {
          paramAnonymousCharacter = null;
        } else {
          paramAnonymousCharacter = String.valueOf(paramAnonymousCharacter);
        }
        paramAnonymousb.J(paramAnonymousCharacter);
      }
    };
    y = (TypeAdapter)localObject;
    z = c(Character.TYPE, Character.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public String read(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        JsonToken localJsonToken = paramAnonymousa.G();
        if (localJsonToken == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        if (localJsonToken == JsonToken.BOOLEAN) {
          return Boolean.toString(paramAnonymousa.w());
        }
        return paramAnonymousa.E();
      }
      
      public void write(b paramAnonymousb, String paramAnonymousString)
        throws IOException
      {
        paramAnonymousb.J(paramAnonymousString);
      }
    };
    A = (TypeAdapter)localObject;
    B = new TypeAdapter()
    {
      public BigDecimal a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        try
        {
          paramAnonymousa = new BigDecimal(paramAnonymousa.E());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new JsonSyntaxException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, BigDecimal paramAnonymousBigDecimal)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousBigDecimal);
      }
    };
    C = new TypeAdapter()
    {
      public BigInteger a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        try
        {
          paramAnonymousa = new BigInteger(paramAnonymousa.E());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new JsonSyntaxException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, BigInteger paramAnonymousBigInteger)
        throws IOException
      {
        paramAnonymousb.I(paramAnonymousBigInteger);
      }
    };
    D = b(String.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public StringBuilder a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return new StringBuilder(paramAnonymousa.E());
      }
      
      public void b(b paramAnonymousb, StringBuilder paramAnonymousStringBuilder)
        throws IOException
      {
        if (paramAnonymousStringBuilder == null) {
          paramAnonymousStringBuilder = null;
        } else {
          paramAnonymousStringBuilder = paramAnonymousStringBuilder.toString();
        }
        paramAnonymousb.J(paramAnonymousStringBuilder);
      }
    };
    E = (TypeAdapter)localObject;
    F = b(StringBuilder.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public StringBuffer a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return new StringBuffer(paramAnonymousa.E());
      }
      
      public void b(b paramAnonymousb, StringBuffer paramAnonymousStringBuffer)
        throws IOException
      {
        if (paramAnonymousStringBuffer == null) {
          paramAnonymousStringBuffer = null;
        } else {
          paramAnonymousStringBuffer = paramAnonymousStringBuffer.toString();
        }
        paramAnonymousb.J(paramAnonymousStringBuffer);
      }
    };
    G = (TypeAdapter)localObject;
    H = b(StringBuffer.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public URL a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        JsonToken localJsonToken1 = paramAnonymousa.G();
        JsonToken localJsonToken2 = JsonToken.NULL;
        Object localObject = null;
        if (localJsonToken1 == localJsonToken2)
        {
          paramAnonymousa.C();
          return null;
        }
        paramAnonymousa = paramAnonymousa.E();
        if ("null".equals(paramAnonymousa)) {
          paramAnonymousa = (com.google.gson.stream.a)localObject;
        } else {
          paramAnonymousa = new URL(paramAnonymousa);
        }
        return paramAnonymousa;
      }
      
      public void b(b paramAnonymousb, URL paramAnonymousURL)
        throws IOException
      {
        if (paramAnonymousURL == null) {
          paramAnonymousURL = null;
        } else {
          paramAnonymousURL = paramAnonymousURL.toExternalForm();
        }
        paramAnonymousb.J(paramAnonymousURL);
      }
    };
    I = (TypeAdapter)localObject;
    J = b(URL.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public URI a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        JsonToken localJsonToken1 = paramAnonymousa.G();
        JsonToken localJsonToken2 = JsonToken.NULL;
        Object localObject = null;
        if (localJsonToken1 == localJsonToken2)
        {
          paramAnonymousa.C();
          return null;
        }
        try
        {
          paramAnonymousa = paramAnonymousa.E();
          if ("null".equals(paramAnonymousa)) {
            paramAnonymousa = (com.google.gson.stream.a)localObject;
          } else {
            paramAnonymousa = new URI(paramAnonymousa);
          }
          return paramAnonymousa;
        }
        catch (URISyntaxException paramAnonymousa)
        {
          throw new JsonIOException(paramAnonymousa);
        }
      }
      
      public void b(b paramAnonymousb, URI paramAnonymousURI)
        throws IOException
      {
        if (paramAnonymousURI == null) {
          paramAnonymousURI = null;
        } else {
          paramAnonymousURI = paramAnonymousURI.toASCIIString();
        }
        paramAnonymousb.J(paramAnonymousURI);
      }
    };
    K = (TypeAdapter)localObject;
    L = b(URI.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public InetAddress a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return InetAddress.getByName(paramAnonymousa.E());
      }
      
      public void b(b paramAnonymousb, InetAddress paramAnonymousInetAddress)
        throws IOException
      {
        if (paramAnonymousInetAddress == null) {
          paramAnonymousInetAddress = null;
        } else {
          paramAnonymousInetAddress = paramAnonymousInetAddress.getHostAddress();
        }
        paramAnonymousb.J(paramAnonymousInetAddress);
      }
    };
    M = (TypeAdapter)localObject;
    N = e(InetAddress.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public UUID a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return UUID.fromString(paramAnonymousa.E());
      }
      
      public void b(b paramAnonymousb, UUID paramAnonymousUUID)
        throws IOException
      {
        if (paramAnonymousUUID == null) {
          paramAnonymousUUID = null;
        } else {
          paramAnonymousUUID = paramAnonymousUUID.toString();
        }
        paramAnonymousb.J(paramAnonymousUUID);
      }
    };
    O = (TypeAdapter)localObject;
    P = b(UUID.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Currency a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        return Currency.getInstance(paramAnonymousa.E());
      }
      
      public void b(b paramAnonymousb, Currency paramAnonymousCurrency)
        throws IOException
      {
        paramAnonymousb.J(paramAnonymousCurrency.getCurrencyCode());
      }
    }.nullSafe();
    Q = (TypeAdapter)localObject;
    R = b(Currency.class, (TypeAdapter)localObject);
    S = new p()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() != Timestamp.class) {
          return null;
        }
        new TypeAdapter()
        {
          public Timestamp a(com.google.gson.stream.a paramAnonymous2a)
            throws IOException
          {
            paramAnonymous2a = (Date)this.a.read(paramAnonymous2a);
            if (paramAnonymous2a != null) {
              paramAnonymous2a = new Timestamp(paramAnonymous2a.getTime());
            } else {
              paramAnonymous2a = null;
            }
            return paramAnonymous2a;
          }
          
          public void b(b paramAnonymous2b, Timestamp paramAnonymous2Timestamp)
            throws IOException
          {
            this.a.write(paramAnonymous2b, paramAnonymous2Timestamp);
          }
        };
      }
    };
    localObject = new TypeAdapter()
    {
      public Calendar a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        paramAnonymousa.c();
        int i = 0;
        int j = 0;
        int k = 0;
        int m = 0;
        int n = 0;
        int i1 = 0;
        while (paramAnonymousa.G() != JsonToken.END_OBJECT)
        {
          String str = paramAnonymousa.A();
          int i2 = paramAnonymousa.y();
          if ("year".equals(str)) {
            i = i2;
          } else if ("month".equals(str)) {
            j = i2;
          } else if ("dayOfMonth".equals(str)) {
            k = i2;
          } else if ("hourOfDay".equals(str)) {
            m = i2;
          } else if ("minute".equals(str)) {
            n = i2;
          } else if ("second".equals(str)) {
            i1 = i2;
          }
        }
        paramAnonymousa.k();
        return new GregorianCalendar(i, j, k, m, n, i1);
      }
      
      public void b(b paramAnonymousb, Calendar paramAnonymousCalendar)
        throws IOException
      {
        if (paramAnonymousCalendar == null)
        {
          paramAnonymousb.w();
          return;
        }
        paramAnonymousb.g();
        paramAnonymousb.u("year");
        paramAnonymousb.G(paramAnonymousCalendar.get(1));
        paramAnonymousb.u("month");
        paramAnonymousb.G(paramAnonymousCalendar.get(2));
        paramAnonymousb.u("dayOfMonth");
        paramAnonymousb.G(paramAnonymousCalendar.get(5));
        paramAnonymousb.u("hourOfDay");
        paramAnonymousb.G(paramAnonymousCalendar.get(11));
        paramAnonymousb.u("minute");
        paramAnonymousb.G(paramAnonymousCalendar.get(12));
        paramAnonymousb.u("second");
        paramAnonymousb.G(paramAnonymousCalendar.get(13));
        paramAnonymousb.k();
      }
    };
    T = (TypeAdapter)localObject;
    U = d(Calendar.class, GregorianCalendar.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Locale a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        Object localObject1 = paramAnonymousa.G();
        Object localObject2 = JsonToken.NULL;
        String str = null;
        if (localObject1 == localObject2)
        {
          paramAnonymousa.C();
          return null;
        }
        localObject2 = new StringTokenizer(paramAnonymousa.E(), "_");
        if (((StringTokenizer)localObject2).hasMoreElements()) {
          paramAnonymousa = ((StringTokenizer)localObject2).nextToken();
        } else {
          paramAnonymousa = null;
        }
        if (((StringTokenizer)localObject2).hasMoreElements()) {
          localObject1 = ((StringTokenizer)localObject2).nextToken();
        } else {
          localObject1 = null;
        }
        if (((StringTokenizer)localObject2).hasMoreElements()) {
          str = ((StringTokenizer)localObject2).nextToken();
        }
        if ((localObject1 == null) && (str == null)) {
          return new Locale(paramAnonymousa);
        }
        if (str == null) {
          return new Locale(paramAnonymousa, (String)localObject1);
        }
        return new Locale(paramAnonymousa, (String)localObject1, str);
      }
      
      public void b(b paramAnonymousb, Locale paramAnonymousLocale)
        throws IOException
      {
        if (paramAnonymousLocale == null) {
          paramAnonymousLocale = null;
        } else {
          paramAnonymousLocale = paramAnonymousLocale.toString();
        }
        paramAnonymousb.J(paramAnonymousLocale);
      }
    };
    V = (TypeAdapter)localObject;
    W = b(Locale.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public i a(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        Object localObject;
        switch (TypeAdapters.a.a[paramAnonymousa.G().ordinal()])
        {
        default: 
          throw new IllegalArgumentException();
        case 6: 
          localObject = new k();
          paramAnonymousa.c();
          while (paramAnonymousa.s()) {
            ((k)localObject).j(paramAnonymousa.A(), a(paramAnonymousa));
          }
          paramAnonymousa.k();
          return (i)localObject;
        case 5: 
          localObject = new f();
          paramAnonymousa.a();
          while (paramAnonymousa.s()) {
            ((f)localObject).j(a(paramAnonymousa));
          }
          paramAnonymousa.j();
          return (i)localObject;
        case 4: 
          paramAnonymousa.C();
          return j.a;
        case 3: 
          return new m(paramAnonymousa.E());
        case 2: 
          return new m(Boolean.valueOf(paramAnonymousa.w()));
        }
        return new m(new LazilyParsedNumber(paramAnonymousa.E()));
      }
      
      public void b(b paramAnonymousb, i paramAnonymousi)
        throws IOException
      {
        if ((paramAnonymousi != null) && (!paramAnonymousi.g()))
        {
          if (paramAnonymousi.i())
          {
            paramAnonymousi = paramAnonymousi.d();
            if (paramAnonymousi.p()) {
              paramAnonymousb.I(paramAnonymousi.m());
            } else if (paramAnonymousi.n()) {
              paramAnonymousb.K(paramAnonymousi.j());
            } else {
              paramAnonymousb.J(paramAnonymousi.e());
            }
          }
          else if (paramAnonymousi.f())
          {
            paramAnonymousb.e();
            paramAnonymousi = paramAnonymousi.b().iterator();
            while (paramAnonymousi.hasNext()) {
              b(paramAnonymousb, (i)paramAnonymousi.next());
            }
            paramAnonymousb.j();
          }
          else if (paramAnonymousi.h())
          {
            paramAnonymousb.g();
            Iterator localIterator = paramAnonymousi.c().entrySet().iterator();
            while (localIterator.hasNext())
            {
              paramAnonymousi = (Map.Entry)localIterator.next();
              paramAnonymousb.u((String)paramAnonymousi.getKey());
              b(paramAnonymousb, (i)paramAnonymousi.getValue());
            }
            paramAnonymousb.k();
          }
          else
          {
            paramAnonymousb = new StringBuilder();
            paramAnonymousb.append("Couldn't write ");
            paramAnonymousb.append(paramAnonymousi.getClass());
            throw new IllegalArgumentException(paramAnonymousb.toString());
          }
        }
        else {
          paramAnonymousb.w();
        }
      }
    };
    X = (TypeAdapter)localObject;
    Y = e(i.class, (TypeAdapter)localObject);
  }
  
  public static <TT> p a(com.google.gson.r.a<TT> parama, final TypeAdapter<TT> paramTypeAdapter)
  {
    new p()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.equals(TypeAdapters.this)) {
          paramAnonymousGson = paramTypeAdapter;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
    };
  }
  
  public static <TT> p b(Class<TT> paramClass, final TypeAdapter<TT> paramTypeAdapter)
  {
    new p()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == TypeAdapters.this) {
          paramAnonymousGson = paramTypeAdapter;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <TT> p c(Class<TT> paramClass1, final Class<TT> paramClass2, final TypeAdapter<? super TT> paramTypeAdapter)
  {
    new p()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
      {
        paramAnonymousGson = paramAnonymousa.getRawType();
        if ((paramAnonymousGson != TypeAdapters.this) && (paramAnonymousGson != paramClass2)) {
          paramAnonymousGson = null;
        } else {
          paramAnonymousGson = paramTypeAdapter;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(paramClass2.getName());
        localStringBuilder.append("+");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <TT> p d(Class<TT> paramClass, final Class<? extends TT> paramClass1, final TypeAdapter<? super TT> paramTypeAdapter)
  {
    new p()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
      {
        paramAnonymousGson = paramAnonymousa.getRawType();
        if ((paramAnonymousGson != TypeAdapters.this) && (paramAnonymousGson != paramClass1)) {
          paramAnonymousGson = null;
        } else {
          paramAnonymousGson = paramTypeAdapter;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append("+");
        localStringBuilder.append(paramClass1.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <T1> p e(Class<T1> paramClass, final TypeAdapter<T1> paramTypeAdapter)
  {
    new p()
    {
      public <T2> TypeAdapter<T2> a(final Gson paramAnonymousGson, com.google.gson.r.a<T2> paramAnonymousa)
      {
        paramAnonymousGson = paramAnonymousa.getRawType();
        if (!TypeAdapters.this.isAssignableFrom(paramAnonymousGson)) {
          return null;
        }
        new TypeAdapter()
        {
          public T1 read(com.google.gson.stream.a paramAnonymous2a)
            throws IOException
          {
            Object localObject = TypeAdapters.35.this.d.read(paramAnonymous2a);
            if ((localObject != null) && (!paramAnonymousGson.isInstance(localObject)))
            {
              paramAnonymous2a = new StringBuilder();
              paramAnonymous2a.append("Expected a ");
              paramAnonymous2a.append(paramAnonymousGson.getName());
              paramAnonymous2a.append(" but was ");
              paramAnonymous2a.append(localObject.getClass().getName());
              throw new JsonSyntaxException(paramAnonymous2a.toString());
            }
            return (T1)localObject;
          }
          
          public void write(b paramAnonymous2b, T1 paramAnonymous2T1)
            throws IOException
          {
            TypeAdapters.35.this.d.write(paramAnonymous2b, paramAnonymous2T1);
          }
        };
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[typeHierarchy=");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  private static final class EnumTypeAdapter<T extends Enum<T>>
    extends TypeAdapter<T>
  {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();
    
    public EnumTypeAdapter(Class<T> paramClass)
    {
      try
      {
        for (Enum localEnum : (Enum[])paramClass.getEnumConstants())
        {
          Object localObject1 = localEnum.name();
          Object localObject2 = (c)paramClass.getField((String)localObject1).getAnnotation(c.class);
          if (localObject2 != null)
          {
            String str = ((c)localObject2).value();
            localObject2 = ((c)localObject2).alternate();
            int k = localObject2.length;
            for (int m = 0;; m++)
            {
              localObject1 = str;
              if (m >= k) {
                break;
              }
              localObject1 = localObject2[m];
              this.a.put(localObject1, localEnum);
            }
          }
          this.a.put(localObject1, localEnum);
          this.b.put(localEnum, localObject1);
        }
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        throw new AssertionError(paramClass);
      }
    }
    
    public T a(com.google.gson.stream.a parama)
      throws IOException
    {
      if (parama.G() == JsonToken.NULL)
      {
        parama.C();
        return null;
      }
      return (Enum)this.a.get(parama.E());
    }
    
    public void b(b paramb, T paramT)
      throws IOException
    {
      if (paramT == null) {
        paramT = null;
      } else {
        paramT = (String)this.b.get(paramT);
      }
      paramb.J(paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\TypeAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */