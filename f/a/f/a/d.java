package f.a.f.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import f.a.e.a;

public class d
{
  private static volatile d a;
  private Resources b;
  private String c = "";
  private String d = "";
  private e.a e;
  private boolean f = true;
  
  public static int a(Context paramContext, int paramInt)
  {
    return e().f(paramContext, paramInt);
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    return e().g(paramContext, paramInt);
  }
  
  public static Drawable c(Context paramContext, int paramInt)
  {
    return e().h(paramContext, paramInt);
  }
  
  public static Drawable d(Context paramContext, int paramInt)
  {
    return e().i(paramContext, paramInt);
  }
  
  public static d e()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          d locald = new f/a/f/a/d;
          locald.<init>();
          a = locald;
        }
      }
      finally {}
    }
    return a;
  }
  
  private int f(Context paramContext, int paramInt)
  {
    if (!f.d().k())
    {
      localObject = f.d().h(paramInt);
      if (localObject != null) {
        return ((ColorStateList)localObject).getDefaultColor();
      }
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((e.a)localObject).c(paramContext, this.d, paramInt);
      if (localObject != null) {
        return ((ColorStateList)localObject).getDefaultColor();
      }
    }
    if (!this.f)
    {
      int i = l(paramContext, paramInt);
      if (i != 0) {
        return this.b.getColor(i);
      }
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  private ColorStateList g(Context paramContext, int paramInt)
  {
    if (!f.d().k())
    {
      localObject = f.d().h(paramInt);
      if (localObject != null) {
        return (ColorStateList)localObject;
      }
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((e.a)localObject).d(paramContext, this.d, paramInt);
      if (localObject != null) {
        return (ColorStateList)localObject;
      }
    }
    if (!this.f)
    {
      int i = l(paramContext, paramInt);
      if (i != 0) {
        return this.b.getColorStateList(i);
      }
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  private Drawable h(Context paramContext, int paramInt)
  {
    if (!f.d().k())
    {
      localObject = f.d().h(paramInt);
      if (localObject != null) {
        return new ColorDrawable(((ColorStateList)localObject).getDefaultColor());
      }
    }
    if (!f.d().l())
    {
      localObject = f.d().i(paramInt);
      if (localObject != null) {
        return (Drawable)localObject;
      }
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((e.a)localObject).a(paramContext, this.d, paramInt);
      if (localObject != null) {
        return (Drawable)localObject;
      }
    }
    if (!this.f)
    {
      int i = l(paramContext, paramInt);
      if (i != 0) {
        return this.b.getDrawable(i);
      }
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  private Drawable i(Context paramContext, int paramInt)
  {
    if (AppCompatDelegate.isCompatVectorFromResourcesEnabled())
    {
      if (!this.f) {
        try
        {
          Drawable localDrawable = b.m().o(paramContext, paramInt);
          return localDrawable;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (!f.d().k())
      {
        localObject = f.d().h(paramInt);
        if (localObject != null) {
          return new ColorDrawable(((ColorStateList)localObject).getDefaultColor());
        }
      }
      if (!f.d().l())
      {
        localObject = f.d().i(paramInt);
        if (localObject != null) {
          return (Drawable)localObject;
        }
      }
      Object localObject = this.e;
      if (localObject != null)
      {
        localObject = ((e.a)localObject).a(paramContext, this.d, paramInt);
        if (localObject != null) {
          return (Drawable)localObject;
        }
      }
      return AppCompatResources.getDrawable(paramContext, paramInt);
    }
    return h(paramContext, paramInt);
  }
  
  private void j(Context paramContext, @AnyRes int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    if (!this.f)
    {
      int i = l(paramContext, paramInt);
      if (i != 0)
      {
        this.b.getValue(i, paramTypedValue, paramBoolean);
        return;
      }
    }
    paramContext.getResources().getValue(paramInt, paramTypedValue, paramBoolean);
  }
  
  private XmlResourceParser k(Context paramContext, int paramInt)
  {
    if (!this.f)
    {
      int i = l(paramContext, paramInt);
      if (i != 0) {
        return this.b.getXml(i);
      }
    }
    return paramContext.getResources().getXml(paramInt);
  }
  
  private int l(Context paramContext, int paramInt)
  {
    String str = null;
    try
    {
      Object localObject = this.e;
      if (localObject != null) {
        str = ((e.a)localObject).b(paramContext, this.d, paramInt);
      }
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = paramContext.getResources().getResourceEntryName(paramInt);
      }
      paramContext = paramContext.getResources().getResourceTypeName(paramInt);
      paramInt = this.b.getIdentifier((String)localObject, paramContext, this.c);
      return paramInt;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static void m(Context paramContext, @AnyRes int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    e().j(paramContext, paramInt, paramTypedValue, paramBoolean);
  }
  
  public static XmlResourceParser n(Context paramContext, int paramInt)
  {
    return e().k(paramContext, paramInt);
  }
  
  public boolean o()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\f\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */