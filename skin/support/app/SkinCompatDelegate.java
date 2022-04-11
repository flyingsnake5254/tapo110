package skin.support.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.view.LayoutInflaterFactory;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import skin.support.widget.g;

public class SkinCompatDelegate
  implements LayoutInflaterFactory
{
  private final Context a;
  private a b;
  private List<WeakReference<g>> c = new ArrayList();
  
  private SkinCompatDelegate(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static SkinCompatDelegate a(Context paramContext)
  {
    return new SkinCompatDelegate(paramContext);
  }
  
  private boolean c(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    Object localObject = this.a;
    if ((localObject instanceof Activity))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      for (;;)
      {
        if (paramViewParent == null) {
          return true;
        }
        if ((paramViewParent == localObject) || (!(paramViewParent instanceof View)) || (ViewCompat.isAttachedToWindow((View)paramViewParent))) {
          break;
        }
        paramViewParent = paramViewParent.getParent();
      }
    }
    return false;
  }
  
  public View b(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT < 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.b == null) {
      this.b = new a();
    }
    boolean bool2;
    if ((bool1) && (c((ViewParent)paramView))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    return this.b.c(paramView, paramString, paramContext, paramAttributeSet, bool2, bool1, true, VectorEnabledTintResources.shouldBeUsed());
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      paramView = b(paramView, paramString, paramContext, paramAttributeSet);
    }
    catch (Exception paramView)
    {
      paramView = null;
    }
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof g)) {
      this.c.add(new WeakReference((g)paramView));
    }
    return paramView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\app\SkinCompatDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */