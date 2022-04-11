package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.Request;
import okhttp3.Request.Builder;
import retrofit2.x.a;
import retrofit2.x.b;
import retrofit2.x.d;
import retrofit2.x.e;
import retrofit2.x.f;
import retrofit2.x.g;
import retrofit2.x.h;
import retrofit2.x.j;
import retrofit2.x.k;
import retrofit2.x.l;
import retrofit2.x.n;
import retrofit2.x.q;
import retrofit2.x.s;
import retrofit2.x.t;
import retrofit2.x.u;
import retrofit2.x.x;
import retrofit2.x.y;

final class p
{
  private final Method a;
  private final HttpUrl b;
  final String c;
  @Nullable
  private final String d;
  @Nullable
  private final Headers e;
  @Nullable
  private final MediaType f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final m<?>[] j;
  final boolean k;
  
  p(a parama)
  {
    this.a = parama.d;
    this.b = parama.c.c;
    this.c = parama.p;
    this.d = parama.t;
    this.e = parama.u;
    this.f = parama.v;
    this.g = parama.q;
    this.h = parama.r;
    this.i = parama.s;
    this.j = parama.x;
    this.k = parama.y;
  }
  
  static p b(r paramr, Method paramMethod)
  {
    return new a(paramr, paramMethod).b();
  }
  
  Request a(Object[] paramArrayOfObject)
    throws IOException
  {
    m[] arrayOfm = this.j;
    int m = paramArrayOfObject.length;
    if (m == arrayOfm.length)
    {
      o localo = new o(this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i);
      int n = m;
      if (this.k) {
        n = m - 1;
      }
      ArrayList localArrayList = new ArrayList(n);
      for (m = 0; m < n; m++)
      {
        localArrayList.add(paramArrayOfObject[m]);
        arrayOfm[m].a(localo, paramArrayOfObject[m]);
      }
      return localo.k().tag(i.class, new i(this.a, localArrayList)).build();
    }
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("Argument count (");
    paramArrayOfObject.append(m);
    paramArrayOfObject.append(") doesn't match expected count (");
    paramArrayOfObject.append(arrayOfm.length);
    paramArrayOfObject.append(")");
    throw new IllegalArgumentException(paramArrayOfObject.toString());
  }
  
  static final class a
  {
    private static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    private static final Pattern b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    final r c;
    final Method d;
    final Annotation[] e;
    final Annotation[][] f;
    final Type[] g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    @Nullable
    String p;
    boolean q;
    boolean r;
    boolean s;
    @Nullable
    String t;
    @Nullable
    Headers u;
    @Nullable
    MediaType v;
    @Nullable
    Set<String> w;
    @Nullable
    m<?>[] x;
    boolean y;
    
    a(r paramr, Method paramMethod)
    {
      this.c = paramr;
      this.d = paramMethod;
      this.e = paramMethod.getAnnotations();
      this.g = paramMethod.getGenericParameterTypes();
      this.f = paramMethod.getParameterAnnotations();
    }
    
    private static Class<?> a(Class<?> paramClass)
    {
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      Object localObject = paramClass;
      if (Short.TYPE == paramClass) {
        localObject = Short.class;
      }
      return (Class<?>)localObject;
    }
    
    private Headers c(String[] paramArrayOfString)
    {
      Headers.Builder localBuilder = new Headers.Builder();
      int i1 = paramArrayOfString.length;
      int i2 = 0;
      while (i2 < i1)
      {
        String str1 = paramArrayOfString[i2];
        int i3 = str1.indexOf(':');
        if ((i3 != -1) && (i3 != 0) && (i3 != str1.length() - 1))
        {
          String str2 = str1.substring(0, i3);
          str1 = str1.substring(i3 + 1).trim();
          if ("Content-Type".equalsIgnoreCase(str2)) {
            try
            {
              this.v = MediaType.get(str1);
            }
            catch (IllegalArgumentException paramArrayOfString)
            {
              throw v.o(this.d, paramArrayOfString, "Malformed content type: %s", new Object[] { str1 });
            }
          } else {
            localBuilder.add(str2, str1);
          }
          i2++;
        }
        else
        {
          throw v.n(this.d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[] { str1 });
        }
      }
      return localBuilder.build();
    }
    
    private void d(String paramString1, String paramString2, boolean paramBoolean)
    {
      String str = this.p;
      if (str == null)
      {
        this.p = paramString1;
        this.q = paramBoolean;
        if (paramString2.isEmpty()) {
          return;
        }
        int i1 = paramString2.indexOf('?');
        if ((i1 != -1) && (i1 < paramString2.length() - 1))
        {
          paramString1 = paramString2.substring(i1 + 1);
          if (a.matcher(paramString1).find()) {
            throw v.n(this.d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[] { paramString1 });
          }
        }
        this.t = paramString2;
        this.w = h(paramString2);
        return;
      }
      throw v.n(this.d, "Only one HTTP method is allowed. Found: %s and %s.", new Object[] { str, paramString1 });
    }
    
    private void e(Annotation paramAnnotation)
    {
      if ((paramAnnotation instanceof b))
      {
        d("DELETE", ((b)paramAnnotation).value(), false);
      }
      else if ((paramAnnotation instanceof f))
      {
        d("GET", ((f)paramAnnotation).value(), false);
      }
      else if ((paramAnnotation instanceof g))
      {
        d("HEAD", ((g)paramAnnotation).value(), false);
      }
      else if ((paramAnnotation instanceof n))
      {
        d("PATCH", ((n)paramAnnotation).value(), true);
      }
      else if ((paramAnnotation instanceof retrofit2.x.o))
      {
        d("POST", ((retrofit2.x.o)paramAnnotation).value(), true);
      }
      else if ((paramAnnotation instanceof retrofit2.x.p))
      {
        d("PUT", ((retrofit2.x.p)paramAnnotation).value(), true);
      }
      else if ((paramAnnotation instanceof retrofit2.x.m))
      {
        d("OPTIONS", ((retrofit2.x.m)paramAnnotation).value(), false);
      }
      else if ((paramAnnotation instanceof h))
      {
        paramAnnotation = (h)paramAnnotation;
        d(paramAnnotation.method(), paramAnnotation.path(), paramAnnotation.hasBody());
      }
      else if ((paramAnnotation instanceof k))
      {
        paramAnnotation = ((k)paramAnnotation).value();
        if (paramAnnotation.length != 0) {
          this.u = c(paramAnnotation);
        } else {
          throw v.n(this.d, "@Headers annotation is empty.", new Object[0]);
        }
      }
      else if ((paramAnnotation instanceof l))
      {
        if (!this.r) {
          this.s = true;
        } else {
          throw v.n(this.d, "Only one encoding annotation is allowed.", new Object[0]);
        }
      }
      else if ((paramAnnotation instanceof e))
      {
        if (!this.s) {
          this.r = true;
        } else {
          throw v.n(this.d, "Only one encoding annotation is allowed.", new Object[0]);
        }
      }
    }
    
    @Nullable
    private m<?> f(int paramInt, Type paramType, @Nullable Annotation[] paramArrayOfAnnotation, boolean paramBoolean)
    {
      if (paramArrayOfAnnotation != null)
      {
        int i1 = paramArrayOfAnnotation.length;
        Object localObject1 = null;
        for (int i2 = 0;; i2++)
        {
          localObject2 = localObject1;
          if (i2 >= i1) {
            break label80;
          }
          localObject2 = g(paramInt, paramType, paramArrayOfAnnotation, paramArrayOfAnnotation[i2]);
          if (localObject2 != null)
          {
            if (localObject1 != null) {
              break;
            }
            localObject1 = localObject2;
          }
        }
        throw v.p(this.d, paramInt, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
      }
      Object localObject2 = null;
      label80:
      if ((localObject2 != null) || (paramBoolean)) {}
      try
      {
        if (v.i(paramType) == kotlin.coroutines.c.class)
        {
          this.y = true;
          return null;
        }
      }
      catch (NoClassDefFoundError paramType)
      {
        for (;;) {}
      }
      throw v.p(this.d, paramInt, "No Retrofit annotation found.", new Object[0]);
      return (m<?>)localObject2;
    }
    
    @Nullable
    private m<?> g(int paramInt, Type paramType, Annotation[] paramArrayOfAnnotation, Annotation paramAnnotation)
    {
      if ((paramAnnotation instanceof y))
      {
        j(paramInt, paramType);
        if (!this.o)
        {
          if (!this.k)
          {
            if (!this.l)
            {
              if (!this.m)
              {
                if (!this.n)
                {
                  if (this.t == null)
                  {
                    this.o = true;
                    if ((paramType != HttpUrl.class) && (paramType != String.class) && (paramType != URI.class) && ((!(paramType instanceof Class)) || (!"android.net.Uri".equals(((Class)paramType).getName())))) {
                      throw v.p(this.d, paramInt, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                    }
                    return new m.p(this.d, paramInt);
                  }
                  throw v.p(this.d, paramInt, "@Url cannot be used with @%s URL", new Object[] { this.p });
                }
                throw v.p(this.d, paramInt, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
              }
              throw v.p(this.d, paramInt, "A @Url parameter must not come after a @QueryName.", new Object[0]);
            }
            throw v.p(this.d, paramInt, "A @Url parameter must not come after a @Query.", new Object[0]);
          }
          throw v.p(this.d, paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
        }
        throw v.p(this.d, paramInt, "Multiple @Url method annotations found.", new Object[0]);
      }
      Object localObject;
      if ((paramAnnotation instanceof s))
      {
        j(paramInt, paramType);
        if (!this.l)
        {
          if (!this.m)
          {
            if (!this.n)
            {
              if (!this.o)
              {
                if (this.t != null)
                {
                  this.k = true;
                  paramAnnotation = (s)paramAnnotation;
                  localObject = paramAnnotation.value();
                  i(paramInt, (String)localObject);
                  paramType = this.c.j(paramType, paramArrayOfAnnotation);
                  return new m.k(this.d, paramInt, (String)localObject, paramType, paramAnnotation.encoded());
                }
                throw v.p(this.d, paramInt, "@Path can only be used with relative url on @%s", new Object[] { this.p });
              }
              throw v.p(this.d, paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
            }
            throw v.p(this.d, paramInt, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
          }
          throw v.p(this.d, paramInt, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        }
        throw v.p(this.d, paramInt, "A @Path parameter must not come after a @Query.", new Object[0]);
      }
      boolean bool;
      if ((paramAnnotation instanceof t))
      {
        j(paramInt, paramType);
        localObject = (t)paramAnnotation;
        paramAnnotation = ((t)localObject).value();
        bool = ((t)localObject).encoded();
        localObject = v.i(paramType);
        this.l = true;
        if (Iterable.class.isAssignableFrom((Class)localObject))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = v.h(0, (ParameterizedType)paramType);
            return new m.l(paramAnnotation, this.c.j(paramType, paramArrayOfAnnotation), bool).c();
          }
          paramType = this.d;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw v.p(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (((Class)localObject).isArray())
        {
          paramType = a(((Class)localObject).getComponentType());
          return new m.l(paramAnnotation, this.c.j(paramType, paramArrayOfAnnotation), bool).b();
        }
        return new m.l(paramAnnotation, this.c.j(paramType, paramArrayOfAnnotation), bool);
      }
      if ((paramAnnotation instanceof retrofit2.x.v))
      {
        j(paramInt, paramType);
        bool = ((retrofit2.x.v)paramAnnotation).encoded();
        paramAnnotation = v.i(paramType);
        this.m = true;
        if (Iterable.class.isAssignableFrom(paramAnnotation))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = v.h(0, (ParameterizedType)paramType);
            return new m.n(this.c.j(paramType, paramArrayOfAnnotation), bool).c();
          }
          paramArrayOfAnnotation = this.d;
          paramType = new StringBuilder();
          paramType.append(paramAnnotation.getSimpleName());
          paramType.append(" must include generic type (e.g., ");
          paramType.append(paramAnnotation.getSimpleName());
          paramType.append("<String>)");
          throw v.p(paramArrayOfAnnotation, paramInt, paramType.toString(), new Object[0]);
        }
        if (paramAnnotation.isArray())
        {
          paramType = a(paramAnnotation.getComponentType());
          return new m.n(this.c.j(paramType, paramArrayOfAnnotation), bool).b();
        }
        return new m.n(this.c.j(paramType, paramArrayOfAnnotation), bool);
      }
      if ((paramAnnotation instanceof u))
      {
        j(paramInt, paramType);
        localObject = v.i(paramType);
        this.n = true;
        if (Map.class.isAssignableFrom((Class)localObject))
        {
          paramType = v.j(paramType, (Class)localObject, Map.class);
          if ((paramType instanceof ParameterizedType))
          {
            localObject = (ParameterizedType)paramType;
            paramType = v.h(0, (ParameterizedType)localObject);
            if (String.class == paramType)
            {
              paramType = v.h(1, (ParameterizedType)localObject);
              paramType = this.c.j(paramType, paramArrayOfAnnotation);
              return new m.m(this.d, paramInt, paramType, ((u)paramAnnotation).encoded());
            }
            paramAnnotation = this.d;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append("@QueryMap keys must be of type String: ");
            paramArrayOfAnnotation.append(paramType);
            throw v.p(paramAnnotation, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
          throw v.p(this.d, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        }
        throw v.p(this.d, paramInt, "@QueryMap parameter type must be Map.", new Object[0]);
      }
      if ((paramAnnotation instanceof retrofit2.x.i))
      {
        j(paramInt, paramType);
        localObject = ((retrofit2.x.i)paramAnnotation).value();
        paramAnnotation = v.i(paramType);
        if (Iterable.class.isAssignableFrom(paramAnnotation))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = v.h(0, (ParameterizedType)paramType);
            return new m.f((String)localObject, this.c.j(paramType, paramArrayOfAnnotation)).c();
          }
          paramType = this.d;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw v.p(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (paramAnnotation.isArray())
        {
          paramType = a(paramAnnotation.getComponentType());
          return new m.f((String)localObject, this.c.j(paramType, paramArrayOfAnnotation)).b();
        }
        return new m.f((String)localObject, this.c.j(paramType, paramArrayOfAnnotation));
      }
      if ((paramAnnotation instanceof j))
      {
        if (paramType == Headers.class) {
          return new m.h(this.d, paramInt);
        }
        j(paramInt, paramType);
        paramAnnotation = v.i(paramType);
        if (Map.class.isAssignableFrom(paramAnnotation))
        {
          paramType = v.j(paramType, paramAnnotation, Map.class);
          if ((paramType instanceof ParameterizedType))
          {
            paramAnnotation = (ParameterizedType)paramType;
            paramType = v.h(0, paramAnnotation);
            if (String.class == paramType)
            {
              paramType = v.h(1, paramAnnotation);
              paramType = this.c.j(paramType, paramArrayOfAnnotation);
              return new m.g(this.d, paramInt, paramType);
            }
            paramArrayOfAnnotation = this.d;
            paramAnnotation = new StringBuilder();
            paramAnnotation.append("@HeaderMap keys must be of type String: ");
            paramAnnotation.append(paramType);
            throw v.p(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
          }
          throw v.p(this.d, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        }
        throw v.p(this.d, paramInt, "@HeaderMap parameter type must be Map.", new Object[0]);
      }
      if ((paramAnnotation instanceof retrofit2.x.c))
      {
        j(paramInt, paramType);
        if (this.r)
        {
          localObject = (retrofit2.x.c)paramAnnotation;
          paramAnnotation = ((retrofit2.x.c)localObject).value();
          bool = ((retrofit2.x.c)localObject).encoded();
          this.h = true;
          localObject = v.i(paramType);
          if (Iterable.class.isAssignableFrom((Class)localObject))
          {
            if ((paramType instanceof ParameterizedType))
            {
              paramType = v.h(0, (ParameterizedType)paramType);
              return new m.d(paramAnnotation, this.c.j(paramType, paramArrayOfAnnotation), bool).c();
            }
            paramType = this.d;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
            paramArrayOfAnnotation.append(" must include generic type (e.g., ");
            paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
            paramArrayOfAnnotation.append("<String>)");
            throw v.p(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
          if (((Class)localObject).isArray())
          {
            paramType = a(((Class)localObject).getComponentType());
            return new m.d(paramAnnotation, this.c.j(paramType, paramArrayOfAnnotation), bool).b();
          }
          return new m.d(paramAnnotation, this.c.j(paramType, paramArrayOfAnnotation), bool);
        }
        throw v.p(this.d, paramInt, "@Field parameters can only be used with form encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof d))
      {
        j(paramInt, paramType);
        if (this.r)
        {
          localObject = v.i(paramType);
          if (Map.class.isAssignableFrom((Class)localObject))
          {
            paramType = v.j(paramType, (Class)localObject, Map.class);
            if ((paramType instanceof ParameterizedType))
            {
              localObject = (ParameterizedType)paramType;
              paramType = v.h(0, (ParameterizedType)localObject);
              if (String.class == paramType)
              {
                paramType = v.h(1, (ParameterizedType)localObject);
                paramType = this.c.j(paramType, paramArrayOfAnnotation);
                this.h = true;
                return new m.e(this.d, paramInt, paramType, ((d)paramAnnotation).encoded());
              }
              paramArrayOfAnnotation = this.d;
              paramAnnotation = new StringBuilder();
              paramAnnotation.append("@FieldMap keys must be of type String: ");
              paramAnnotation.append(paramType);
              throw v.p(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
            }
            throw v.p(this.d, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
          }
          throw v.p(this.d, paramInt, "@FieldMap parameter type must be Map.", new Object[0]);
        }
        throw v.p(this.d, paramInt, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof q))
      {
        j(paramInt, paramType);
        if (this.s)
        {
          localObject = (q)paramAnnotation;
          this.i = true;
          String str = ((q)localObject).value();
          paramAnnotation = v.i(paramType);
          if (str.isEmpty())
          {
            if (Iterable.class.isAssignableFrom(paramAnnotation))
            {
              if ((paramType instanceof ParameterizedType))
              {
                if (MultipartBody.Part.class.isAssignableFrom(v.i(v.h(0, (ParameterizedType)paramType)))) {
                  return m.o.a.c();
                }
                throw v.p(this.d, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
              }
              paramArrayOfAnnotation = this.d;
              paramType = new StringBuilder();
              paramType.append(paramAnnotation.getSimpleName());
              paramType.append(" must include generic type (e.g., ");
              paramType.append(paramAnnotation.getSimpleName());
              paramType.append("<String>)");
              throw v.p(paramArrayOfAnnotation, paramInt, paramType.toString(), new Object[0]);
            }
            if (paramAnnotation.isArray())
            {
              if (MultipartBody.Part.class.isAssignableFrom(paramAnnotation.getComponentType())) {
                return m.o.a.b();
              }
              throw v.p(this.d, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
            }
            if (MultipartBody.Part.class.isAssignableFrom(paramAnnotation)) {
              return m.o.a;
            }
            throw v.p(this.d, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("form-data; name=\"");
          localStringBuilder.append(str);
          localStringBuilder.append("\"");
          localObject = Headers.of(new String[] { "Content-Disposition", localStringBuilder.toString(), "Content-Transfer-Encoding", ((q)localObject).encoding() });
          if (Iterable.class.isAssignableFrom(paramAnnotation))
          {
            if ((paramType instanceof ParameterizedType))
            {
              paramType = v.h(0, (ParameterizedType)paramType);
              if (!MultipartBody.Part.class.isAssignableFrom(v.i(paramType)))
              {
                paramType = this.c.h(paramType, paramArrayOfAnnotation, this.e);
                return new m.i(this.d, paramInt, (Headers)localObject, paramType).c();
              }
              throw v.p(this.d, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
            }
            paramType = this.d;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
            paramArrayOfAnnotation.append(" must include generic type (e.g., ");
            paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
            paramArrayOfAnnotation.append("<String>)");
            throw v.p(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
          if (paramAnnotation.isArray())
          {
            paramType = a(paramAnnotation.getComponentType());
            if (!MultipartBody.Part.class.isAssignableFrom(paramType))
            {
              paramType = this.c.h(paramType, paramArrayOfAnnotation, this.e);
              return new m.i(this.d, paramInt, (Headers)localObject, paramType).b();
            }
            throw v.p(this.d, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
          }
          if (!MultipartBody.Part.class.isAssignableFrom(paramAnnotation))
          {
            paramType = this.c.h(paramType, paramArrayOfAnnotation, this.e);
            return new m.i(this.d, paramInt, (Headers)localObject, paramType);
          }
          throw v.p(this.d, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        }
        throw v.p(this.d, paramInt, "@Part parameters can only be used with multipart encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof retrofit2.x.r))
      {
        j(paramInt, paramType);
        if (this.s)
        {
          this.i = true;
          localObject = v.i(paramType);
          if (Map.class.isAssignableFrom((Class)localObject))
          {
            paramType = v.j(paramType, (Class)localObject, Map.class);
            if ((paramType instanceof ParameterizedType))
            {
              localObject = (ParameterizedType)paramType;
              paramType = v.h(0, (ParameterizedType)localObject);
              if (String.class == paramType)
              {
                paramType = v.h(1, (ParameterizedType)localObject);
                if (!MultipartBody.Part.class.isAssignableFrom(v.i(paramType)))
                {
                  paramType = this.c.h(paramType, paramArrayOfAnnotation, this.e);
                  paramArrayOfAnnotation = (retrofit2.x.r)paramAnnotation;
                  return new m.j(this.d, paramInt, paramType, paramArrayOfAnnotation.encoding());
                }
                throw v.p(this.d, paramInt, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
              }
              paramAnnotation = this.d;
              paramArrayOfAnnotation = new StringBuilder();
              paramArrayOfAnnotation.append("@PartMap keys must be of type String: ");
              paramArrayOfAnnotation.append(paramType);
              throw v.p(paramAnnotation, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
            }
            throw v.p(this.d, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
          }
          throw v.p(this.d, paramInt, "@PartMap parameter type must be Map.", new Object[0]);
        }
        throw v.p(this.d, paramInt, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof a))
      {
        j(paramInt, paramType);
        if ((!this.r) && (!this.s))
        {
          if (!this.j) {
            try
            {
              paramArrayOfAnnotation = this.c.h(paramType, paramArrayOfAnnotation, this.e);
              this.j = true;
              return new m.c(this.d, paramInt, paramArrayOfAnnotation);
            }
            catch (RuntimeException paramArrayOfAnnotation)
            {
              throw v.q(this.d, paramArrayOfAnnotation, paramInt, "Unable to create @Body converter for %s", new Object[] { paramType });
            }
          }
          throw v.p(this.d, paramInt, "Multiple @Body method annotations found.", new Object[0]);
        }
        throw v.p(this.d, paramInt, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof x))
      {
        j(paramInt, paramType);
        paramType = v.i(paramType);
        for (int i1 = paramInt - 1; i1 >= 0; i1--)
        {
          paramArrayOfAnnotation = this.x[i1];
          if (((paramArrayOfAnnotation instanceof m.q)) && (((m.q)paramArrayOfAnnotation).a.equals(paramType)))
          {
            paramAnnotation = this.d;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append("@Tag type ");
            paramArrayOfAnnotation.append(paramType.getName());
            paramArrayOfAnnotation.append(" is duplicate of parameter #");
            paramArrayOfAnnotation.append(i1 + 1);
            paramArrayOfAnnotation.append(" and would always overwrite its value.");
            throw v.p(paramAnnotation, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
        }
        return new m.q(paramType);
      }
      return null;
    }
    
    static Set<String> h(String paramString)
    {
      Matcher localMatcher = a.matcher(paramString);
      paramString = new LinkedHashSet();
      while (localMatcher.find()) {
        paramString.add(localMatcher.group(1));
      }
      return paramString;
    }
    
    private void i(int paramInt, String paramString)
    {
      if (b.matcher(paramString).matches())
      {
        if (this.w.contains(paramString)) {
          return;
        }
        throw v.p(this.d, paramInt, "URL \"%s\" does not contain \"{%s}\".", new Object[] { this.t, paramString });
      }
      throw v.p(this.d, paramInt, "@Path parameter name must match %s. Found: %s", new Object[] { a.pattern(), paramString });
    }
    
    private void j(int paramInt, Type paramType)
    {
      if (!v.k(paramType)) {
        return;
      }
      throw v.p(this.d, paramInt, "Parameter type must not include a type variable or wildcard: %s", new Object[] { paramType });
    }
    
    p b()
    {
      Object localObject = this.e;
      int i1 = localObject.length;
      for (int i2 = 0; i2 < i1; i2++) {
        e(localObject[i2]);
      }
      if (this.p != null)
      {
        if (!this.q) {
          if (!this.s)
          {
            if (this.r) {
              throw v.n(this.d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
          }
          else {
            throw v.n(this.d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
          }
        }
        i1 = this.f.length;
        this.x = new m[i1];
        for (i2 = 0;; i2++)
        {
          bool = true;
          if (i2 >= i1) {
            break;
          }
          m[] arrayOfm = this.x;
          localObject = this.g[i2];
          Annotation[] arrayOfAnnotation = this.f[i2];
          if (i2 != i1 - 1) {
            bool = false;
          }
          arrayOfm[i2] = f(i2, (Type)localObject, arrayOfAnnotation, bool);
        }
        if ((this.t == null) && (!this.o)) {
          throw v.n(this.d, "Missing either @%s URL or @Url parameter.", new Object[] { this.p });
        }
        boolean bool = this.r;
        if ((!bool) && (!this.s) && (!this.q) && (this.j)) {
          throw v.n(this.d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        }
        if ((bool) && (!this.h)) {
          throw v.n(this.d, "Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if ((this.s) && (!this.i)) {
          throw v.n(this.d, "Multipart method must contain at least one @Part.", new Object[0]);
        }
        return new p(this);
      }
      throw v.n(this.d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */