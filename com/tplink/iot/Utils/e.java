package com.tplink.iot.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.core.content.ContextCompat;

public class e
{
  public static void d(Activity paramActivity, int paramInt, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    String str = paramActivity.getString(2131951724, new Object[] { Integer.valueOf(paramInt) });
    new TPLongMaterialDialogV2.Builder(paramActivity).g(str).l(2131952722, 2131099808, new d(paramActivity, paramString)).i(2131952441, 2131099808, null).d(0, 8).b(false).c(false).a().show();
  }
  
  public static void e(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramActivity == null) {
      return;
    }
    String str1 = paramActivity.getString(2131951725, new Object[] { Integer.valueOf(paramInt1) });
    String str2 = paramActivity.getString(2131951726, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    new TPMaterialDialogV3.Builder(paramActivity).p(str1).f(str2).c(false).b(false).j(2131952441, 2131099808, null).a().show();
  }
  
  public static void f(final Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    final String str1 = paramActivity.getString(2131951747);
    String str2 = paramActivity.getString(2131951746, new Object[] { str1 });
    new TPMaterialDialogV2.Builder(paramActivity).v(2131559148).x(new a(str2, str1, paramActivity)).g(8, 8).c(false).b(false).o(2131952441, 2131099808, null).a().show();
  }
  
  public static void g(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject1 = new AlertDialog.Builder(paramActivity, 2132017570);
    Object localObject2 = paramActivity.getLayoutInflater().inflate(2131558828, null);
    localObject1 = ((AlertDialog.Builder)localObject1).setView((View)localObject2).setCancelable(false).create();
    ((View)localObject2).findViewById(2131362826).setOnClickListener(new c((AlertDialog)localObject1));
    ((View)localObject2).findViewById(2131362068).setOnClickListener(new b((AlertDialog)localObject1));
    localObject2 = ((Dialog)localObject1).getWindow();
    if (localObject2 != null)
    {
      ((Window)localObject2).setGravity(80);
      ((Window)localObject2).getDecorView().setPadding(0, net.lucode.hackware.magicindicator.g.b.a(paramActivity, 50.0D), 0, 0);
      paramActivity = ((Window)localObject2).getAttributes();
      paramActivity.width = -1;
      paramActivity.horizontalMargin = 0.0F;
      ((Window)localObject2).setAttributes(paramActivity);
      ((Window)localObject2).setWindowAnimations(2132017164);
    }
    ((Dialog)localObject1).show();
  }
  
  static final class a
    implements TPMaterialDialogV2.c
  {
    a(String paramString1, String paramString2, Activity paramActivity) {}
    
    public void a(TPMaterialDialogV2 paramTPMaterialDialogV2, View paramView)
    {
      d0.c((TextView)paramView.findViewById(2131362440), this.a, str1, ContextCompat.getColor(paramActivity, 2131099811), new a(paramActivity, paramTPMaterialDialogV2));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */