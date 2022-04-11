package com.samskivert.mustache;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f
{
  protected static final u a = new a();
  protected static final l b = new b();
  
  protected static g a(Reader paramReader, f paramf)
  {
    paramReader = new r(paramf).b(paramReader);
    e locale = new e();
    return new g(d(paramReader.e(), true), paramf, locale);
  }
  
  public static f b()
  {
    return new f(false, false, null, false, false, false, b, c.a, a, new b(), new h());
  }
  
  protected static void c(StringBuilder paramStringBuilder, h paramh)
  {
    paramStringBuilder.insert(0, paramh.a);
    char c = paramh.c;
    if (c != 0) {
      paramStringBuilder.insert(1, c);
    }
  }
  
  protected static g.f[] d(g.f[] paramArrayOff, boolean paramBoolean)
  {
    int i = paramArrayOff.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOff[j];
      t localt1 = null;
      g.f localf1;
      if (j > 0) {
        localf1 = paramArrayOff[(j - 1)];
      } else {
        localf1 = null;
      }
      g.f localf2;
      if (j < i - 1) {
        localf2 = paramArrayOff[(j + 1)];
      } else {
        localf2 = null;
      }
      t localt2;
      if ((localf1 instanceof t)) {
        localt2 = (t)localf1;
      } else {
        localt2 = null;
      }
      if ((localf2 instanceof t)) {
        localt1 = (t)localf2;
      }
      int k = 1;
      int m;
      if (((localf1 == null) && (paramBoolean)) || ((localt2 != null) && (localt2.e()))) {
        m = 1;
      } else {
        m = 0;
      }
      int n;
      if (localf2 == null)
      {
        n = k;
        if (paramBoolean) {}
      }
      else if ((localt1 != null) && (localt1.d()))
      {
        n = k;
      }
      else
      {
        n = 0;
      }
      if ((localObject instanceof d))
      {
        localObject = (d)localObject;
        if ((m != 0) && (((d)localObject).d()))
        {
          if (localf1 != null) {
            paramArrayOff[(j - 1)] = localt2.g();
          }
          ((d)localObject).f();
        }
        if ((n != 0) && (((d)localObject).e()))
        {
          ((d)localObject).g();
          if (localf2 != null) {
            paramArrayOff[(j + 1)] = localt1.f();
          }
        }
      }
      else if (((localObject instanceof j)) && (m != 0) && (n != 0))
      {
        if (localf1 != null) {
          paramArrayOff[(j - 1)] = localt2.g();
        }
        if (localf2 != null) {
          paramArrayOff[(j + 1)] = localt1.f();
        }
      }
    }
    return paramArrayOff;
  }
  
  static final class a
    implements f.u
  {
    public Reader a(String paramString)
    {
      throw new UnsupportedOperationException("Template loading not configured");
    }
  }
  
  static final class b
    implements f.l
  {
    public String a(Object paramObject)
    {
      return String.valueOf(paramObject);
    }
  }
  
  protected static class c
  {
    protected final f.f a;
    protected final boolean b;
    protected final List<g.f> c = new ArrayList();
    
    public c(f.f paramf, boolean paramBoolean)
    {
      this.a = paramf;
      this.b = paramBoolean;
    }
    
    protected static void f(String paramString, int paramInt)
    {
      if ((paramString.indexOf('\n') == -1) && (paramString.indexOf('\r') == -1)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid tag name: contains newline '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      throw new MustacheParseException(localStringBuilder.toString(), paramInt);
    }
    
    protected static void g(String paramString1, String paramString2, int paramInt)
    {
      if (paramString1.equals(paramString2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Section close tag with mismatched open tag '");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("' != '");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("'");
      throw new MustacheParseException(localStringBuilder.toString(), paramInt);
    }
    
    protected c a(String paramString, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Section close tag with no open tag '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      throw new MustacheParseException(localStringBuilder.toString(), paramInt);
    }
    
    public void b()
    {
      this.c.add(new f.j());
    }
    
    public c c(StringBuilder paramStringBuilder, final int paramInt)
    {
      String str = paramStringBuilder.toString().trim();
      final Object localObject = str.substring(1).trim();
      paramStringBuilder.setLength(0);
      int i = str.charAt(0);
      if (i != 33)
      {
        if (i != 35)
        {
          if (i != 38)
          {
            if (i != 47)
            {
              if (i != 62)
              {
                if (i != 94)
                {
                  f(str, paramInt);
                  paramStringBuilder = this.c;
                  localObject = this.a;
                  paramStringBuilder.add(new f.w(str, paramInt, ((f.f)localObject).g, ((f.f)localObject).h));
                  return this;
                }
                f(str, paramInt);
                return new b(this.a, false, (String)localObject, paramInt, this);
              }
              this.c.add(new f.m(this.a, (String)localObject));
              return this;
            }
            f(str, paramInt);
            return a((String)localObject, paramInt);
          }
          f(str, paramInt);
          this.c.add(new f.w((String)localObject, paramInt, this.a.g, c.b));
          return this;
        }
        f(str, paramInt);
        return new a(this.a, false, (String)localObject, paramInt, this);
      }
      this.c.add(new f.j());
      return this;
    }
    
    public void d(StringBuilder paramStringBuilder)
    {
      if (paramStringBuilder.length() > 0)
      {
        List localList = this.c;
        String str = paramStringBuilder.toString();
        boolean bool;
        if ((this.c.isEmpty()) && (this.b)) {
          bool = true;
        } else {
          bool = false;
        }
        localList.add(new f.t(str, bool));
        paramStringBuilder.setLength(0);
      }
    }
    
    public g.f[] e()
    {
      List localList = this.c;
      return (g.f[])localList.toArray(new g.f[localList.size()]);
    }
    
    class a
      extends f.c
    {
      a(f.f paramf, boolean paramBoolean, String paramString, int paramInt, f.c paramc)
      {
        super(paramBoolean);
      }
      
      protected f.c a(String paramString, int paramInt)
      {
        f.c.g(localObject, paramString, paramInt);
        jdField_this.c.add(new f.s(this.a, paramString, super.e(), paramInt));
        return jdField_this;
      }
      
      public g.f[] e()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Section missing close tag '");
        localStringBuilder.append(localObject);
        localStringBuilder.append("'");
        throw new MustacheParseException(localStringBuilder.toString(), paramInt);
      }
    }
    
    class b
      extends f.c
    {
      b(f.f paramf, boolean paramBoolean, String paramString, int paramInt, f.c paramc)
      {
        super(paramBoolean);
      }
      
      protected f.c a(String paramString, int paramInt)
      {
        f.c.g(localObject, paramString, paramInt);
        jdField_this.c.add(new f.n(this.a, paramString, super.e(), paramInt));
        return jdField_this;
      }
      
      public g.f[] e()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Inverted section missing close tag '");
        localStringBuilder.append(localObject);
        localStringBuilder.append("'");
        throw new MustacheParseException(localStringBuilder.toString(), paramInt);
      }
    }
  }
  
  protected static abstract class d
    extends f.q
  {
    protected final g.f[] c;
    
    protected d(String paramString, g.f[] paramArrayOff, int paramInt)
    {
      super(paramInt);
      this.c = f.d(paramArrayOff, false);
    }
    
    protected void c(g paramg, g.c paramc, Writer paramWriter)
    {
      g.f[] arrayOff = this.c;
      int i = arrayOff.length;
      for (int j = 0; j < i; j++) {
        arrayOff[j].a(paramg, paramc, paramWriter);
      }
    }
    
    public boolean d()
    {
      g.f[] arrayOff = this.c;
      if ((arrayOff.length != 0) && ((arrayOff[0] instanceof f.t))) {
        return ((f.t)arrayOff[0]).d();
      }
      return false;
    }
    
    public boolean e()
    {
      g.f[] arrayOff = this.c;
      int i = arrayOff.length - 1;
      if ((arrayOff.length != 0) && ((arrayOff[i] instanceof f.t))) {
        return ((f.t)arrayOff[i]).e();
      }
      return false;
    }
    
    public void f()
    {
      g.f[] arrayOff = this.c;
      arrayOff[0] = ((f.t)arrayOff[0]).f();
    }
    
    public void g()
    {
      g.f[] arrayOff = this.c;
      int i = arrayOff.length - 1;
      arrayOff[i] = ((f.t)arrayOff[i]).g();
    }
  }
  
  public static abstract interface e
  {
    public abstract Iterator<?> a(Object paramObject);
    
    public abstract <K, V> Map<K, V> b();
    
    public abstract f.v c(Object paramObject, String paramString);
  }
  
  public static class f
  {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final f.l g;
    public final f.i h;
    public final f.u i;
    public final f.e j;
    public final f.h k;
    
    protected f(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, f.l paraml, f.i parami, f.u paramu, f.e parame, f.h paramh)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramString;
      this.d = paramBoolean3;
      this.e = paramBoolean4;
      this.f = paramBoolean5;
      this.g = paraml;
      this.h = parami;
      this.i = paramu;
      this.j = parame;
      this.k = paramh;
    }
    
    public g a(Reader paramReader)
    {
      return f.a(paramReader, this);
    }
    
    public g b(String paramString)
    {
      return a(new StringReader(paramString));
    }
    
    public String c(String paramString)
    {
      String str = this.c;
      if (str == null) {
        paramString = null;
      } else {
        paramString = str.replace("{{name}}", paramString);
      }
      return paramString;
    }
    
    public boolean d(Object paramObject)
    {
      boolean bool;
      if (((this.e) && ("".equals(this.g.a(paramObject)))) || ((this.f) && ((paramObject instanceof Number)) && (((Number)paramObject).longValue() == 0L))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    /* Error */
    public g e(String paramString)
      throws MustacheException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: aload_0
      //   5: getfield 47	com/samskivert/mustache/f$f:i	Lcom/samskivert/mustache/f$u;
      //   8: aload_1
      //   9: invokeinterface 101 2 0
      //   14: astore 4
      //   16: aload 4
      //   18: astore_3
      //   19: aload 4
      //   21: astore_2
      //   22: aload_0
      //   23: aload 4
      //   25: invokevirtual 64	com/samskivert/mustache/f$f:a	(Ljava/io/Reader;)Lcom/samskivert/mustache/g;
      //   28: astore 5
      //   30: aload 4
      //   32: ifnull +21 -> 53
      //   35: aload 4
      //   37: invokevirtual 106	java/io/Reader:close	()V
      //   40: goto +13 -> 53
      //   43: astore_1
      //   44: new 108	java/lang/RuntimeException
      //   47: dup
      //   48: aload_1
      //   49: invokespecial 111	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   52: athrow
      //   53: aload 5
      //   55: areturn
      //   56: astore_1
      //   57: goto +82 -> 139
      //   60: astore 4
      //   62: aload_2
      //   63: astore_3
      //   64: aload 4
      //   66: instanceof 108
      //   69: ifeq +11 -> 80
      //   72: aload_2
      //   73: astore_3
      //   74: aload 4
      //   76: checkcast 108	java/lang/RuntimeException
      //   79: athrow
      //   80: aload_2
      //   81: astore_3
      //   82: new 92	com/samskivert/mustache/MustacheException
      //   85: astore 6
      //   87: aload_2
      //   88: astore_3
      //   89: new 113	java/lang/StringBuilder
      //   92: astore 5
      //   94: aload_2
      //   95: astore_3
      //   96: aload 5
      //   98: invokespecial 114	java/lang/StringBuilder:<init>	()V
      //   101: aload_2
      //   102: astore_3
      //   103: aload 5
      //   105: ldc 116
      //   107: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   110: pop
      //   111: aload_2
      //   112: astore_3
      //   113: aload 5
      //   115: aload_1
      //   116: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   119: pop
      //   120: aload_2
      //   121: astore_3
      //   122: aload 6
      //   124: aload 5
      //   126: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   129: aload 4
      //   131: invokespecial 127	com/samskivert/mustache/MustacheException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   134: aload_2
      //   135: astore_3
      //   136: aload 6
      //   138: athrow
      //   139: aload_3
      //   140: ifnull +20 -> 160
      //   143: aload_3
      //   144: invokevirtual 106	java/io/Reader:close	()V
      //   147: goto +13 -> 160
      //   150: astore_1
      //   151: new 108	java/lang/RuntimeException
      //   154: dup
      //   155: aload_1
      //   156: invokespecial 111	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   159: athrow
      //   160: aload_1
      //   161: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	162	0	this	f
      //   0	162	1	paramString	String
      //   1	134	2	localObject1	Object
      //   3	141	3	localObject2	Object
      //   14	22	4	localReader	Reader
      //   60	70	4	localException	Exception
      //   28	97	5	localObject3	Object
      //   85	52	6	localMustacheException	MustacheException
      // Exception table:
      //   from	to	target	type
      //   35	40	43	java/io/IOException
      //   4	16	56	finally
      //   22	30	56	finally
      //   64	72	56	finally
      //   74	80	56	finally
      //   82	87	56	finally
      //   89	94	56	finally
      //   96	101	56	finally
      //   103	111	56	finally
      //   113	120	56	finally
      //   122	134	56	finally
      //   136	139	56	finally
      //   4	16	60	java/lang/Exception
      //   22	30	60	java/lang/Exception
      //   143	147	150	java/io/IOException
    }
  }
  
  public static abstract interface g
  {
    public abstract Object get(String paramString)
      throws Exception;
  }
  
  protected static class h
  {
    public char a = (char)123;
    public char b = (char)125;
    public char c = (char)123;
    public char d = (char)125;
    
    private static String b(String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid delimiter configuration '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'. Must be of the form {{=1 2=}} or {{=12 34=}} where 1, 2, 3 and 4 are delimiter chars.");
      return localStringBuilder.toString();
    }
    
    h a()
    {
      h localh = new h();
      localh.a = ((char)this.a);
      localh.c = ((char)this.c);
      localh.b = ((char)this.b);
      localh.d = ((char)this.d);
      return localh;
    }
    
    public boolean c()
    {
      boolean bool;
      if ((this.a == '{') && (this.c == '{') && (this.b == '}') && (this.d == '}')) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public h d(String paramString)
    {
      String[] arrayOfString = paramString.split(" ");
      if (arrayOfString.length == 2)
      {
        int i = arrayOfString[0].length();
        if (i != 1)
        {
          if (i == 2)
          {
            this.a = arrayOfString[0].charAt(0);
            this.c = arrayOfString[0].charAt(1);
          }
          else
          {
            throw new MustacheException(b(paramString));
          }
        }
        else
        {
          this.a = arrayOfString[0].charAt(0);
          this.c = ((char)0);
        }
        i = arrayOfString[1].length();
        if (i != 1)
        {
          if (i == 2)
          {
            this.b = arrayOfString[1].charAt(0);
            this.d = arrayOfString[1].charAt(1);
          }
          else
          {
            throw new MustacheException(b(paramString));
          }
        }
        else
        {
          this.b = arrayOfString[1].charAt(0);
          this.d = ((char)0);
        }
        return this;
      }
      throw new MustacheException(b(paramString));
    }
  }
  
  public static abstract interface i
  {
    public abstract String a(String paramString);
  }
  
  protected static class j
    extends g.f
  {
    public void a(g paramg, g.c paramc, Writer paramWriter) {}
    
    public String toString()
    {
      return "Faux";
    }
  }
  
  public static abstract interface k
  {
    public abstract Object a(Object paramObject, List<Object> paramList)
      throws IOException;
  }
  
  public static abstract interface l
  {
    public abstract String a(Object paramObject);
  }
  
  protected static class m
    extends g.f
  {
    protected final f.f a;
    protected final String b;
    private g c;
    
    public m(f.f paramf, String paramString)
    {
      this.a = paramf;
      this.b = paramString;
    }
    
    public void a(g paramg, g.c paramc, Writer paramWriter)
    {
      c().e(paramc, paramWriter);
    }
    
    protected g c()
    {
      if (this.c == null) {
        this.c = this.a.e(this.b);
      }
      return this.c;
    }
  }
  
  protected static class n
    extends f.d
  {
    protected final f.f d;
    
    public n(f.f paramf, String paramString, g.f[] paramArrayOff, int paramInt)
    {
      super(paramArrayOff, paramInt);
      this.d = paramf;
    }
    
    public void a(g paramg, g.c paramc, Writer paramWriter)
    {
      Object localObject = paramg.h(paramc, this.a, this.b);
      Iterator localIterator = this.d.j.a(localObject);
      if (localIterator != null)
      {
        if (!localIterator.hasNext()) {
          c(paramg, paramc, paramWriter);
        }
      }
      else if ((localObject instanceof Boolean))
      {
        if (!((Boolean)localObject).booleanValue()) {
          c(paramg, paramc, paramWriter);
        }
      }
      else if ((localObject instanceof f.o)) {
        try
        {
          ((f.o)localObject).b(paramg.b(this.c, paramc), paramWriter);
        }
        catch (IOException paramg)
        {
          throw new MustacheException(paramg);
        }
      } else if (this.d.d(localObject)) {
        c(paramg, paramc, paramWriter);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Inverted(");
      localStringBuilder.append(this.a);
      localStringBuilder.append(":");
      localStringBuilder.append(this.b);
      localStringBuilder.append("): ");
      localStringBuilder.append(Arrays.toString(this.c));
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface o
    extends f.p
  {
    public abstract void b(g.d paramd, Writer paramWriter)
      throws IOException;
  }
  
  public static abstract interface p
  {
    public abstract void a(g.d paramd, Writer paramWriter)
      throws IOException;
  }
  
  protected static abstract class q
    extends g.f
  {
    protected final String a;
    protected final int b;
    
    protected q(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
  
  protected static class r
  {
    final f.h a;
    final StringBuilder b = new StringBuilder();
    Reader c;
    f.c d;
    int e = 0;
    int f = 1;
    int g = 0;
    int h = -1;
    
    public r(f.f paramf)
    {
      this.d = new f.c(paramf, true);
      this.a = paramf.k.a();
    }
    
    protected int a()
    {
      try
      {
        int i = this.c.read();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new MustacheException(localIOException);
      }
    }
    
    public f.c b(Reader paramReader)
    {
      this.c = paramReader;
      for (;;)
      {
        i = a();
        if (i == -1) {
          break;
        }
        char c1 = (char)i;
        this.g += 1;
        c(c1);
        if (c1 == '\n')
        {
          this.g = 0;
          this.f += 1;
        }
      }
      int i = this.e;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            f.c(this.b, this.a);
          }
        }
        else
        {
          f.c(this.b, this.a);
          this.b.append(this.a.b);
        }
      }
      else {
        this.b.append(this.a.a);
      }
      this.d.d(this.b);
      return this.d;
    }
    
    protected void c(char paramChar)
    {
      int i = this.e;
      Object localObject1;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              localObject1 = this.a;
              if (paramChar == ((f.h)localObject1).b)
              {
                this.e = 2;
                if (((f.h)localObject1).d == 0) {
                  c('\000');
                }
              }
              else if ((paramChar == ((f.h)localObject1).a) && (this.b.length() > 0) && (this.b.charAt(0) != '!'))
              {
                f.c(this.b, this.a);
                this.d.d(this.b);
                this.h = this.g;
                if (this.a.c == 0)
                {
                  this.d.d(this.b);
                  this.e = 3;
                }
                else
                {
                  this.e = 1;
                }
              }
              else
              {
                this.b.append(paramChar);
              }
            }
          }
          else
          {
            localObject1 = this.a;
            if (paramChar == ((f.h)localObject1).d)
            {
              Object localObject2;
              if (this.b.charAt(0) == '=')
              {
                localObject2 = this.a;
                localObject1 = this.b;
                ((f.h)localObject2).d(((StringBuilder)localObject1).substring(1, ((StringBuilder)localObject1).length() - 1));
                this.b.setLength(0);
                this.d.b();
              }
              else
              {
                if ((this.a.c()) && (this.b.charAt(0) == this.a.a))
                {
                  i = a();
                  if (i != 125)
                  {
                    if (i == -1) {
                      localObject1 = "";
                    } else {
                      localObject1 = String.valueOf((char)i);
                    }
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("Invalid triple-mustache tag: {{");
                    ((StringBuilder)localObject2).append(this.b);
                    ((StringBuilder)localObject2).append("}}");
                    ((StringBuilder)localObject2).append((String)localObject1);
                    throw new MustacheParseException(((StringBuilder)localObject2).toString(), this.f);
                  }
                  this.b.replace(0, 1, "&");
                }
                this.d = this.d.c(this.b, this.f);
              }
              this.e = 0;
            }
            else
            {
              this.b.append(((f.h)localObject1).b);
              this.e = 3;
              c(paramChar);
            }
          }
        }
        else
        {
          localObject1 = this.a;
          if (paramChar == ((f.h)localObject1).c)
          {
            this.d.d(this.b);
            this.e = 3;
          }
          else
          {
            this.b.append(((f.h)localObject1).a);
            this.e = 0;
            c(paramChar);
          }
        }
      }
      else
      {
        localObject1 = this.a;
        if (paramChar == ((f.h)localObject1).a)
        {
          this.e = 1;
          this.h = this.g;
          if (((f.h)localObject1).c == 0) {
            c('\000');
          }
        }
        else
        {
          this.b.append(paramChar);
        }
      }
    }
  }
  
  protected static class s
    extends f.d
  {
    protected final f.f d;
    
    public s(f.f paramf, String paramString, g.f[] paramArrayOff, int paramInt)
    {
      super(paramArrayOff, paramInt);
      this.d = paramf;
    }
    
    public void a(g paramg, g.c paramc, Writer paramWriter)
    {
      Object localObject = paramg.h(paramc, this.a, this.b);
      Iterator localIterator = this.d.j.a(localObject);
      if (localIterator != null) {
        for (int i = 0; localIterator.hasNext(); i++)
        {
          localObject = localIterator.next();
          boolean bool;
          if (i == 0) {
            bool = true;
          } else {
            bool = false;
          }
          c(paramg, paramc.b(localObject, i, bool, true ^ localIterator.hasNext()), paramWriter);
        }
      }
      if ((localObject instanceof Boolean))
      {
        if (((Boolean)localObject).booleanValue()) {
          c(paramg, paramc, paramWriter);
        }
      }
      else if ((localObject instanceof f.p)) {
        try
        {
          ((f.p)localObject).a(paramg.b(this.c, paramc), paramWriter);
        }
        catch (IOException paramg)
        {
          throw new MustacheException(paramg);
        }
      } else if (!this.d.d(localObject)) {
        c(paramg, paramc.a(localObject), paramWriter);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Section(");
      localStringBuilder.append(this.a);
      localStringBuilder.append(":");
      localStringBuilder.append(this.b);
      localStringBuilder.append("): ");
      localStringBuilder.append(Arrays.toString(this.c));
      return localStringBuilder.toString();
    }
  }
  
  protected static class t
    extends g.f
  {
    protected final String a;
    protected final int b;
    protected final int c;
    
    public t(String paramString, int paramInt1, int paramInt2)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public t(String paramString, boolean paramBoolean)
    {
      this(paramString, c(paramString, true, paramBoolean), c(paramString, false, paramBoolean));
    }
    
    private static int c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      int i = paramString.length();
      int j = 0;
      int k;
      if (paramBoolean1) {
        k = 0;
      } else {
        k = i - 1;
      }
      if (!paramBoolean1) {
        i = -1;
      }
      int m;
      if (paramBoolean1) {
        m = 1;
      } else {
        m = -1;
      }
      while (k != i)
      {
        char c1 = paramString.charAt(k);
        if (c1 == '\n')
        {
          if (!paramBoolean1) {
            k++;
          }
          return k;
        }
        if (!Character.isWhitespace(c1)) {
          return -1;
        }
        k += m;
      }
      if (!paramBoolean1)
      {
        k = j;
        if (paramBoolean2) {}
      }
      else
      {
        k = -1;
      }
      return k;
    }
    
    public void a(g paramg, g.c paramc, Writer paramWriter)
    {
      g.f.b(paramWriter, this.a);
    }
    
    public boolean d()
    {
      boolean bool;
      if (this.b != -1) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean e()
    {
      boolean bool;
      if (this.c != -1) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public t f()
    {
      int i = this.b;
      if (i == -1) {
        return this;
      }
      int j = i + 1;
      i = this.c;
      if (i == -1) {
        i = -1;
      } else {
        i -= j;
      }
      return new t(this.a.substring(j), -1, i);
    }
    
    public t g()
    {
      int i = this.c;
      t localt;
      if (i == -1) {
        localt = this;
      } else {
        localt = new t(this.a.substring(0, i), this.b, -1);
      }
      return localt;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Text(");
      localStringBuilder.append(this.a.replace("\r", "\\r").replace("\n", "\\n"));
      localStringBuilder.append(")");
      localStringBuilder.append(this.b);
      localStringBuilder.append("/");
      localStringBuilder.append(this.c);
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface u
  {
    public abstract Reader a(String paramString)
      throws Exception;
  }
  
  public static abstract interface v
  {
    public abstract Object a(Object paramObject, String paramString)
      throws Exception;
  }
  
  protected static class w
    extends f.q
  {
    protected final f.l c;
    protected final f.i d;
    
    public w(String paramString, int paramInt, f.l paraml, f.i parami)
    {
      super(paramInt);
      this.c = paraml;
      this.d = parami;
    }
    
    public void a(g paramg, g.c paramc, Writer paramWriter)
    {
      paramg = paramg.k(paramc, this.a, this.b);
      if (paramg == null)
      {
        if (g.l(this.a))
        {
          paramc = new StringBuilder();
          paramg = "Resolved '.' to null (which is disallowed), on line ";
        }
        else
        {
          paramc = new StringBuilder();
          paramc.append("No key, method or field with name '");
          paramc.append(this.a);
          paramg = "' on line ";
        }
        paramc.append(paramg);
        paramc.append(this.b);
        throw new MustacheException.Context(paramc.toString(), this.a, this.b);
      }
      g.f.b(paramWriter, this.d.a(this.c.a(paramg)));
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Var(");
      localStringBuilder.append(this.a);
      localStringBuilder.append(":");
      localStringBuilder.append(this.b);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */