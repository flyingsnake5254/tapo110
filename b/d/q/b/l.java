package b.d.q.b;

import java.io.File;
import org.greenrobot.greendao.AbstractDao;

public class l
{
  private static final String a = "l";
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static void b(long paramLong, com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.d> paramb)
  {
    q(new b(paramLong, k.a().b(), paramb));
  }
  
  public static void c(String paramString, com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.d> paramb)
  {
    q(new e(k.a().b(), paramString, paramb));
  }
  
  public static void d(String paramString)
  {
    c(paramString, null);
  }
  
  public static void e(String paramString, com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c> paramb)
  {
    q(new f(k.a().a(), paramString, paramb));
  }
  
  public static com.tplink.libtpmediaother.database.model.c f(String paramString)
  {
    com.tplink.libtpmediaother.database.model.c localc1 = (com.tplink.libtpmediaother.database.model.c)k.a().a().load(paramString);
    com.tplink.libtpmediaother.database.model.c localc2 = localc1;
    if (localc1 == null)
    {
      localc2 = new com.tplink.libtpmediaother.database.model.c();
      localc2.m(paramString);
    }
    return localc2;
  }
  
  public static void g(String paramString, boolean paramBoolean, com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e> paramb)
  {
    q(new d(k.a().c(), paramString, paramBoolean, paramb));
  }
  
  public static void h(com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.d> paramb)
  {
    q(new a(paramb, k.a().b()));
  }
  
  /* Error */
  private static void q(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 194 1 0
    //   6: goto +14 -> 20
    //   9: astore_0
    //   10: getstatic 196	b/d/q/b/l:a	Ljava/lang/String;
    //   13: aload_0
    //   14: invokestatic 202	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   17: invokestatic 207	b/d/w/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	21	0	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   0	6	9	finally
  }
  
  public static void r(String paramString, com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c> paramb)
  {
    q(new g(k.a().a(), paramString, paramb));
  }
  
  public static void s(String paramString, boolean paramBoolean, com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e> paramb)
  {
    q(new c(k.a().c(), paramString, paramBoolean, paramb));
  }
  
  public static void t(long paramLong, com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.d> paramb)
  {
    q(new h(paramLong, k.a().b(), paramb));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */