package com.tplink.iot.Utils.extension;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.s0.h;
import kotlin.jvm.b.a;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class e
{
  public static final void a() {}
  
  public static final void b(DialogFragment paramDialogFragment, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    j.e(paramDialogFragment, "$this$makeFullscreen");
    paramDialogFragment = paramDialogFragment.getDialog();
    if (paramDialogFragment != null)
    {
      paramDialogFragment = paramDialogFragment.getWindow();
      if (paramDialogFragment != null)
      {
        paramDialogFragment.setBackgroundDrawable(new ColorDrawable(0));
        Object localObject = paramDialogFragment.getDecorView();
        j.d(localObject, "decorView");
        ((View)localObject).setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams localLayoutParams = paramDialogFragment.getAttributes();
        localLayoutParams.gravity = 80;
        if (paramBoolean3) {
          paramDialogFragment.clearFlags(2);
        }
        if (paramBoolean1) {
          localLayoutParams.width = -1;
        }
        if (paramBoolean2) {
          localLayoutParams.height = -1;
        }
        localObject = p.a;
        paramDialogFragment.setAttributes(localLayoutParams);
      }
    }
  }
  
  public static final void d(Activity paramActivity, a<p> parama)
  {
    j.e(paramActivity, "$this$showCommonFailDialog");
    Object localObject = parama;
    if (parama != null) {
      localObject = new d(parama);
    }
    s0.o(paramActivity, 2131952444, (s0.h)localObject);
  }
  
  public static final void f(Activity paramActivity, a<p> parama)
  {
    j.e(paramActivity, "$this$showCommonSuccessDialog");
    Object localObject = parama;
    if (parama != null) {
      localObject = new d(parama);
    }
    s0.B(paramActivity, (s0.h)localObject);
  }
  
  public static final void h(Activity paramActivity, @StringRes int paramInt, a<p> parama)
  {
    j.e(paramActivity, "$this$showFailDialog");
    Object localObject = parama;
    if (parama != null) {
      localObject = new d(parama);
    }
    s0.o(paramActivity, paramInt, (s0.h)localObject);
  }
  
  public static final void i(Activity paramActivity, String paramString, a<p> parama)
  {
    j.e(paramActivity, "$this$showFailDialog");
    Object localObject = parama;
    if (parama != null) {
      localObject = new d(parama);
    }
    s0.q(paramActivity, paramString, (s0.h)localObject);
  }
  
  public static final void l(Activity paramActivity, String paramString)
  {
    j.e(paramActivity, "$this$showLoadingDialog");
    if (paramString != null) {
      s0.m(paramActivity, paramString);
    } else {
      s0.l(paramActivity);
    }
  }
  
  public static final void n(Activity paramActivity, String paramString, a<p> parama)
  {
    j.e(paramActivity, "$this$showMessageDialog");
    Object localObject = parama;
    if (parama != null) {
      localObject = new d(parama);
    }
    s0.w(paramActivity, paramString, (s0.h)localObject);
  }
  
  public static final void p(Activity paramActivity, a<p> parama)
  {
    j.e(paramActivity, "$this$showOperationFailDialog");
    Object localObject = parama;
    if (parama != null) {
      localObject = new d(parama);
    }
    s0.o(paramActivity, 2131953328, (s0.h)localObject);
  }
  
  public static final void r(Context paramContext, l<? super f, p> paraml)
  {
    j.e(paramContext, "$this$showTPMaterialDialogV3");
    j.e(paraml, "configs");
    paramContext = new f(new TPMaterialDialogV3.Builder(paramContext));
    paraml.invoke(paramContext);
    paramContext.k();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */