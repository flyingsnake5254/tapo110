package f.a.f.a;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import f.a.e;
import f.a.h.b;
import f.a.h.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.json.JSONException;

public class f
{
  private static f a = new f();
  private final HashMap<String, a> b = new HashMap();
  private final Object c = new Object();
  private final WeakHashMap<Integer, WeakReference<ColorStateList>> d = new WeakHashMap();
  private boolean e;
  private final HashMap<String, String> f = new HashMap();
  private final Object g = new Object();
  private final WeakHashMap<Integer, WeakReference<Drawable>> h = new WeakHashMap();
  private boolean i;
  
  private f()
  {
    try
    {
      n();
    }
    catch (JSONException localJSONException)
    {
      this.b.clear();
      this.f.clear();
      if (c.a)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLoadFromSharedPreferences error: ");
        localStringBuilder.append(localJSONException);
        c.a("SkinCompatUserThemeManager", localStringBuilder.toString());
      }
    }
  }
  
  private void a(@ColorRes int paramInt, ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      synchronized (this.c)
      {
        WeakHashMap localWeakHashMap = this.d;
        WeakReference localWeakReference = new java/lang/ref/WeakReference;
        localWeakReference.<init>(paramColorStateList);
        localWeakHashMap.put(Integer.valueOf(paramInt), localWeakReference);
      }
    }
  }
  
  private void b(@DrawableRes int paramInt, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      synchronized (this.g)
      {
        WeakHashMap localWeakHashMap = this.h;
        WeakReference localWeakReference = new java/lang/ref/WeakReference;
        localWeakReference.<init>(paramDrawable);
        localWeakHashMap.put(Integer.valueOf(paramInt), localWeakReference);
      }
    }
  }
  
  private static boolean c(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists())) {
      bool = true;
    } else {
      bool = false;
    }
    if ((c.a) && (!bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid drawable path : ");
      localStringBuilder.append(paramString);
      c.a("SkinCompatUserThemeManager", localStringBuilder.toString());
    }
    return bool;
  }
  
  public static f d()
  {
    return a;
  }
  
  private ColorStateList e(@ColorRes int paramInt)
  {
    synchronized (this.c)
    {
      Object localObject2 = (WeakReference)this.d.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject2 = (ColorStateList)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          return (ColorStateList)localObject2;
        }
        this.d.remove(Integer.valueOf(paramInt));
      }
      return null;
    }
  }
  
  private Drawable f(@DrawableRes int paramInt)
  {
    synchronized (this.g)
    {
      Object localObject2 = (WeakReference)this.h.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject2 = (Drawable)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          return (Drawable)localObject2;
        }
        this.h.remove(Integer.valueOf(paramInt));
      }
      return null;
    }
  }
  
  private String j(int paramInt, String paramString)
  {
    e.a();
    throw null;
  }
  
  private void n()
    throws JSONException
  {
    b.a();
    throw null;
  }
  
  public a g(String paramString)
  {
    return (a)this.b.get(paramString);
  }
  
  public ColorStateList h(@ColorRes int paramInt)
  {
    ColorStateList localColorStateList1 = e(paramInt);
    ColorStateList localColorStateList2 = localColorStateList1;
    if (localColorStateList1 == null)
    {
      Object localObject = j(paramInt, "color");
      localColorStateList2 = localColorStateList1;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = (a)this.b.get(localObject);
        localColorStateList2 = localColorStateList1;
        if (localObject != null)
        {
          localColorStateList1 = ((a)localObject).c();
          localColorStateList2 = localColorStateList1;
          if (localColorStateList1 != null)
          {
            a(paramInt, localColorStateList1);
            localColorStateList2 = localColorStateList1;
          }
        }
      }
    }
    return localColorStateList2;
  }
  
  public Drawable i(@DrawableRes int paramInt)
  {
    Object localObject1 = f(paramInt);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      String str = j(paramInt, "drawable");
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        str = (String)this.f.get(str);
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = str.split(":");
          int j = 0;
          str = localObject2[0];
          if (localObject2.length == 2) {
            j = Integer.valueOf(localObject2[1]).intValue();
          }
          localObject2 = localObject1;
          if (c(str))
          {
            if (j == 0)
            {
              localObject1 = Drawable.createFromPath(str);
            }
            else
            {
              localObject1 = new Matrix();
              ((Matrix)localObject1).postRotate(j);
              localObject2 = BitmapFactory.decodeFile(str);
              localObject1 = new BitmapDrawable(null, Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, true));
            }
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              b(paramInt, (Drawable)localObject1);
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    return (Drawable)localObject2;
  }
  
  boolean k()
  {
    return this.e;
  }
  
  boolean l()
  {
    return this.i;
  }
  
  void m(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.remove(paramString);
      this.e = this.b.isEmpty();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\f\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */