package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.a;
import com.bumptech.glide.load.j.a.b;
import com.bumptech.glide.load.j.a.c;
import com.bumptech.glide.load.j.b.d;
import com.bumptech.glide.load.j.e.c;
import com.bumptech.glide.load.j.f.b;
import com.bumptech.glide.load.j.f.e;
import com.bumptech.glide.load.j.s.a;
import com.bumptech.glide.load.j.s.b;
import com.bumptech.glide.load.j.s.c;
import com.bumptech.glide.load.j.s.d;
import com.bumptech.glide.load.j.u.a;
import com.bumptech.glide.load.j.u.b;
import com.bumptech.glide.load.j.u.c;
import com.bumptech.glide.load.j.v.a;
import com.bumptech.glide.load.j.w.a;
import com.bumptech.glide.load.j.w.b;
import com.bumptech.glide.load.j.w.d;
import com.bumptech.glide.load.j.x.a;
import com.bumptech.glide.load.j.y.e.a;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.a0;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.z;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.manager.p.b;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
  implements ComponentCallbacks2
{
  @GuardedBy("Glide.class")
  private static volatile c c;
  private static volatile boolean d;
  private final a H3;
  private MemoryCategory I3 = MemoryCategory.NORMAL;
  private final com.bumptech.glide.load.engine.k f;
  private final com.bumptech.glide.load.engine.z.b p0;
  private final p p1;
  private final com.bumptech.glide.manager.d p2;
  @GuardedBy("managers")
  private final List<i> p3 = new ArrayList();
  private final com.bumptech.glide.load.engine.z.e q;
  private final com.bumptech.glide.load.engine.a0.h x;
  private final e y;
  private final Registry z;
  
  c(@NonNull Context paramContext, @NonNull com.bumptech.glide.load.engine.k paramk, @NonNull com.bumptech.glide.load.engine.a0.h paramh, @NonNull com.bumptech.glide.load.engine.z.e parame, @NonNull com.bumptech.glide.load.engine.z.b paramb, @NonNull p paramp, @NonNull com.bumptech.glide.manager.d paramd, int paramInt, @NonNull a parama, @NonNull Map<Class<?>, j<?, ?>> paramMap, @NonNull List<com.bumptech.glide.request.f<Object>> paramList, f paramf)
  {
    this.f = paramk;
    this.q = parame;
    this.p0 = paramb;
    this.x = paramh;
    this.p1 = paramp;
    this.p2 = paramd;
    this.H3 = parama;
    Resources localResources = paramContext.getResources();
    paramd = new Registry();
    this.z = paramd;
    paramd.o(new DefaultImageHeaderParser());
    int i = Build.VERSION.SDK_INT;
    if (i >= 27) {
      paramd.o(new n());
    }
    List localList = paramd.g();
    com.bumptech.glide.load.resource.gif.a locala = new com.bumptech.glide.load.resource.gif.a(paramContext, localList, parame, paramb);
    com.bumptech.glide.load.g localg = a0.h(parame);
    com.bumptech.glide.load.resource.bitmap.k localk = new com.bumptech.glide.load.resource.bitmap.k(paramd.g(), localResources.getDisplayMetrics(), parame, paramb);
    if ((paramf.a(d.c.class)) && (i >= 28))
    {
      paramh = new r();
      paramp = new com.bumptech.glide.load.resource.bitmap.h();
    }
    else
    {
      paramp = new com.bumptech.glide.load.resource.bitmap.g(localk);
      paramh = new x(localk, paramb);
    }
    com.bumptech.glide.load.k.e.d locald = new com.bumptech.glide.load.k.e.d(paramContext);
    s.c localc = new s.c(localResources);
    s.d locald1 = new s.d(localResources);
    s.b localb = new s.b(localResources);
    s.a locala1 = new s.a(localResources);
    com.bumptech.glide.load.resource.bitmap.c localc1 = new com.bumptech.glide.load.resource.bitmap.c(paramb);
    com.bumptech.glide.load.k.g.a locala2 = new com.bumptech.glide.load.k.g.a();
    com.bumptech.glide.load.k.g.d locald2 = new com.bumptech.glide.load.k.g.d();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    paramd.a(ByteBuffer.class, new com.bumptech.glide.load.j.c()).a(InputStream.class, new com.bumptech.glide.load.j.t(paramb)).e("Bitmap", ByteBuffer.class, Bitmap.class, paramp).e("Bitmap", InputStream.class, Bitmap.class, paramh);
    if (ParcelFileDescriptorRewinder.c()) {
      paramd.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.t(localk));
    }
    paramd.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, localg).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, a0.c(parame)).d(Bitmap.class, Bitmap.class, v.a.b()).e("Bitmap", Bitmap.class, Bitmap.class, new z()).b(Bitmap.class, localc1).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(localResources, paramp)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(localResources, paramh)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(localResources, localg)).b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(parame, localc1)).e("Gif", InputStream.class, GifDrawable.class, new com.bumptech.glide.load.resource.gif.i(localList, locala, paramb)).e("Gif", ByteBuffer.class, GifDrawable.class, locala).b(GifDrawable.class, new com.bumptech.glide.load.resource.gif.c()).d(com.bumptech.glide.l.a.class, com.bumptech.glide.l.a.class, v.a.b()).e("Bitmap", com.bumptech.glide.l.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.g(parame)).c(Uri.class, Drawable.class, locald).c(Uri.class, Bitmap.class, new v(locald, parame)).p(new com.bumptech.glide.load.k.d.a.a()).d(File.class, ByteBuffer.class, new com.bumptech.glide.load.j.d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new com.bumptech.glide.load.k.f.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.b()).p(new com.bumptech.glide.load.data.k.a(paramb));
    if (ParcelFileDescriptorRewinder.c()) {
      paramd.p(new ParcelFileDescriptorRewinder.a());
    }
    paramh = Integer.TYPE;
    paramd.d(paramh, InputStream.class, localc).d(paramh, ParcelFileDescriptor.class, localb).d(Integer.class, InputStream.class, localc).d(Integer.class, ParcelFileDescriptor.class, localb).d(Integer.class, Uri.class, locald1).d(paramh, AssetFileDescriptor.class, locala1).d(Integer.class, AssetFileDescriptor.class, locala1).d(paramh, Uri.class, locald1).d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new a.c(paramContext.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new a.b(paramContext.getAssets())).d(Uri.class, InputStream.class, new com.bumptech.glide.load.j.y.b.a(paramContext)).d(Uri.class, InputStream.class, new com.bumptech.glide.load.j.y.c.a(paramContext));
    if (i >= 29)
    {
      paramd.d(Uri.class, InputStream.class, new com.bumptech.glide.load.j.y.d.c(paramContext));
      paramd.d(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.j.y.d.b(paramContext));
    }
    paramd.d(Uri.class, InputStream.class, new w.d(localContentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(localContentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(localContentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new e.a()).d(Uri.class, File.class, new com.bumptech.glide.load.j.k.a(paramContext)).d(com.bumptech.glide.load.j.g.class, InputStream.class, new com.bumptech.glide.load.j.y.a.a()).d(byte[].class, ByteBuffer.class, new com.bumptech.glide.load.j.b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.b()).d(Drawable.class, Drawable.class, v.a.b()).c(Drawable.class, Drawable.class, new com.bumptech.glide.load.k.e.e()).q(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.k.g.b(localResources)).q(Bitmap.class, byte[].class, locala2).q(Drawable.class, byte[].class, new com.bumptech.glide.load.k.g.c(parame, locala2, locald2)).q(GifDrawable.class, byte[].class, locald2);
    if (i >= 23)
    {
      paramh = a0.d(parame);
      paramd.c(ByteBuffer.class, Bitmap.class, paramh);
      paramd.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(localResources, paramh));
    }
    this.y = new e(paramContext, paramb, paramd, new com.bumptech.glide.request.k.g(), parama, paramMap, paramList, paramk, paramf, paramInt);
  }
  
  @GuardedBy("Glide.class")
  private static void a(@NonNull Context paramContext, @Nullable GeneratedAppGlideModule paramGeneratedAppGlideModule)
  {
    if (!d)
    {
      d = true;
      m(paramContext, paramGeneratedAppGlideModule);
      d = false;
      return;
    }
    throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
  }
  
  @NonNull
  public static c c(@NonNull Context paramContext)
  {
    if (c == null)
    {
      GeneratedAppGlideModule localGeneratedAppGlideModule = d(paramContext.getApplicationContext());
      try
      {
        if (c == null) {
          a(paramContext, localGeneratedAppGlideModule);
        }
      }
      finally {}
    }
    return c;
  }
  
  @Nullable
  private static GeneratedAppGlideModule d(Context paramContext)
  {
    try
    {
      paramContext = (GeneratedAppGlideModule)Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext.getApplicationContext() });
    }
    catch (InvocationTargetException paramContext)
    {
      q(paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      q(paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      q(paramContext);
    }
    catch (InstantiationException paramContext)
    {
      q(paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      if (Log.isLoggable("Glide", 5)) {
        Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
      }
    }
    paramContext = null;
    return paramContext;
  }
  
  @NonNull
  private static p l(@Nullable Context paramContext)
  {
    com.bumptech.glide.util.i.e(paramContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    return c(paramContext).k();
  }
  
  @GuardedBy("Glide.class")
  private static void m(@NonNull Context paramContext, @Nullable GeneratedAppGlideModule paramGeneratedAppGlideModule)
  {
    n(paramContext, new d(), paramGeneratedAppGlideModule);
  }
  
  @GuardedBy("Glide.class")
  private static void n(@NonNull Context paramContext, @NonNull d paramd, @Nullable GeneratedAppGlideModule paramGeneratedAppGlideModule)
  {
    Context localContext = paramContext.getApplicationContext();
    paramContext = Collections.emptyList();
    if ((paramGeneratedAppGlideModule == null) || (paramGeneratedAppGlideModule.c())) {
      paramContext = new com.bumptech.glide.m.d(localContext).a();
    }
    Iterator localIterator;
    Object localObject2;
    if ((paramGeneratedAppGlideModule != null) && (!paramGeneratedAppGlideModule.d().isEmpty()))
    {
      Set localSet = paramGeneratedAppGlideModule.d();
      localIterator = paramContext.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.bumptech.glide.m.b)localIterator.next();
        if (localSet.contains(localObject1.getClass()))
        {
          if (Log.isLoggable("Glide", 3))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("AppGlideModule excludes manifest GlideModule: ");
            ((StringBuilder)localObject2).append(localObject1);
            Log.d("Glide", ((StringBuilder)localObject2).toString());
          }
          localIterator.remove();
        }
      }
    }
    if (Log.isLoggable("Glide", 3))
    {
      localIterator = paramContext.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (com.bumptech.glide.m.b)localIterator.next();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Discovered GlideModule from manifest: ");
        ((StringBuilder)localObject1).append(localObject2.getClass());
        Log.d("Glide", ((StringBuilder)localObject1).toString());
      }
    }
    if (paramGeneratedAppGlideModule != null) {
      localObject1 = paramGeneratedAppGlideModule.e();
    } else {
      localObject1 = null;
    }
    paramd.d((p.b)localObject1);
    Object localObject1 = paramContext.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.bumptech.glide.m.b)((Iterator)localObject1).next()).a(localContext, paramd);
    }
    if (paramGeneratedAppGlideModule != null) {
      paramGeneratedAppGlideModule.b(localContext, paramd);
    }
    paramd = paramd.a(localContext);
    localObject1 = paramContext.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramContext = (com.bumptech.glide.m.b)((Iterator)localObject1).next();
      try
      {
        paramContext.b(localContext, paramd, paramd.z);
      }
      catch (AbstractMethodError paramd)
      {
        paramGeneratedAppGlideModule = new StringBuilder();
        paramGeneratedAppGlideModule.append("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
        paramGeneratedAppGlideModule.append(paramContext.getClass().getName());
        throw new IllegalStateException(paramGeneratedAppGlideModule.toString(), paramd);
      }
    }
    if (paramGeneratedAppGlideModule != null) {
      paramGeneratedAppGlideModule.a(localContext, paramd, paramd.z);
    }
    localContext.registerComponentCallbacks(paramd);
    c = paramd;
  }
  
  private static void q(Exception paramException)
  {
    throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", paramException);
  }
  
  @NonNull
  public static i t(@NonNull Activity paramActivity)
  {
    return l(paramActivity).j(paramActivity);
  }
  
  @NonNull
  public static i u(@NonNull Context paramContext)
  {
    return l(paramContext).l(paramContext);
  }
  
  @NonNull
  public static i v(@NonNull View paramView)
  {
    return l(paramView.getContext()).m(paramView);
  }
  
  @NonNull
  public static i w(@NonNull Fragment paramFragment)
  {
    return l(paramFragment.getContext()).n(paramFragment);
  }
  
  @NonNull
  public static i x(@NonNull FragmentActivity paramFragmentActivity)
  {
    return l(paramFragmentActivity).o(paramFragmentActivity);
  }
  
  public void b()
  {
    com.bumptech.glide.util.j.b();
    this.x.b();
    this.q.b();
    this.p0.b();
  }
  
  @NonNull
  public com.bumptech.glide.load.engine.z.b e()
  {
    return this.p0;
  }
  
  @NonNull
  public com.bumptech.glide.load.engine.z.e f()
  {
    return this.q;
  }
  
  com.bumptech.glide.manager.d g()
  {
    return this.p2;
  }
  
  @NonNull
  public Context h()
  {
    return this.y.getBaseContext();
  }
  
  @NonNull
  e i()
  {
    return this.y;
  }
  
  @NonNull
  public Registry j()
  {
    return this.z;
  }
  
  @NonNull
  public p k()
  {
    return this.p1;
  }
  
  void o(i parami)
  {
    synchronized (this.p3)
    {
      if (!this.p3.contains(parami))
      {
        this.p3.add(parami);
        return;
      }
      parami = new java/lang/IllegalStateException;
      parami.<init>("Cannot register already registered manager");
      throw parami;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    b();
  }
  
  public void onTrimMemory(int paramInt)
  {
    r(paramInt);
  }
  
  boolean p(@NonNull com.bumptech.glide.request.k.j<?> paramj)
  {
    synchronized (this.p3)
    {
      Iterator localIterator = this.p3.iterator();
      while (localIterator.hasNext()) {
        if (((i)localIterator.next()).z(paramj)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public void r(int paramInt)
  {
    
    synchronized (this.p3)
    {
      Iterator localIterator = this.p3.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onTrimMemory(paramInt);
      }
      this.x.a(paramInt);
      this.q.a(paramInt);
      this.p0.a(paramInt);
      return;
    }
  }
  
  void s(i parami)
  {
    synchronized (this.p3)
    {
      if (this.p3.contains(parami))
      {
        this.p3.remove(parami);
        return;
      }
      parami = new java/lang/IllegalStateException;
      parami.<init>("Cannot unregister not yet registered manager");
      throw parami;
    }
  }
  
  public static abstract interface a
  {
    @NonNull
    public abstract com.bumptech.glide.request.g build();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */