package com.tplink.iot.view.quicksetup.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.libtpwifi.b;
import java.lang.ref.WeakReference;

public class e
{
  private TPMaterialDialogV2 a;
  private TPMaterialDialogV2 b;
  private WeakReference<Activity> c;
  
  public e(Activity paramActivity)
  {
    this.c = new WeakReference(paramActivity);
  }
  
  private Activity c()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  public void b()
  {
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.a;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.a = null;
    }
    localTPMaterialDialogV2 = this.b;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.b = null;
    }
  }
  
  public void d(String paramString)
  {
    final Activity localActivity = c();
    if (localActivity == null) {
      return;
    }
    View localView = LayoutInflater.from(localActivity).inflate(2131559247, null, false);
    ((TextView)localView.findViewById(2131364644)).setText(localActivity.getString(2131953600, new Object[] { paramString }));
    paramString = new TPMaterialDialogV2.Builder(localActivity);
    paramString.w(localView);
    paramString.c(false);
    paramString.b(false);
    paramString.o(2131951765, 2131099808, new a(localActivity));
    paramString.l(2131952391, 2131099804, null);
    paramString.g(8, 8);
    paramString = paramString.a();
    this.b = paramString;
    paramString.show();
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a(Activity paramActivity) {}
    
    public void onClick(View paramView)
    {
      b.k().n(localActivity);
      if (e.a(e.this) != null) {
        e.a(e.this).dismiss();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */