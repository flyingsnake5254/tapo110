package com.tplink.iot.core;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.libtpnetwork.Utils.a0;

public class q
{
  private static void h(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    localObject = PendingIntent.getActivity(paramContext.getApplicationContext(), 0, (Intent)localObject, 1073741824);
    ((AlarmManager)paramContext.getSystemService("alarm")).set(1, System.currentTimeMillis() + 2500L, (PendingIntent)localObject);
    Process.killProcess(Process.myPid());
  }
  
  private static void i(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      a0.l(paramString);
    } else if (1 == paramInt) {
      a0.m(paramString);
    }
  }
  
  public static void j(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    View localView = paramActivity.getLayoutInflater().inflate(2131558799, null);
    TPMaterialDialogV2 localTPMaterialDialogV2 = new TPMaterialDialogV2.Builder(paramActivity).d(2131558799).e(localView).a();
    paramActivity = (TextView)localView.findViewById(2131364452);
    int i = 1;
    if (paramInt == 0) {
      paramActivity.setText("IoT Environment");
    } else if (paramInt == 1) {
      paramActivity.setText("TapoCare Environment");
    }
    localView.findViewById(2131362831).setOnClickListener(new f(localTPMaterialDialogV2));
    localView.findViewById(2131362457).setOnClickListener(new k(paramInt, localTPMaterialDialogV2, localView));
    localView.findViewById(2131364735).setOnClickListener(new h(paramInt, localTPMaterialDialogV2, localView));
    localView.findViewById(2131364736).setOnClickListener(new i(paramInt, localTPMaterialDialogV2, localView));
    localView.findViewById(2131364737).setOnClickListener(new j(paramInt, localTPMaterialDialogV2, localView));
    localView.findViewById(2131362402).setOnClickListener(new g(paramInt, localTPMaterialDialogV2, localView));
    localView.findViewById(2131364098).setOnClickListener(new l(paramInt, localTPMaterialDialogV2, localView));
    if (paramInt == 0) {
      paramActivity = a0.e();
    } else if (paramInt == 1) {
      paramActivity = a0.f();
    } else {
      paramActivity = "beta";
    }
    if (!TextUtils.isEmpty(paramActivity))
    {
      paramActivity.hashCode();
      switch (paramActivity.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                paramInt = -1;
                break;
              } while (!paramActivity.equals("beta3"));
              paramInt = 5;
              break;
            } while (!paramActivity.equals("beta2"));
            paramInt = 4;
            break;
          } while (!paramActivity.equals("dist"));
          paramInt = 3;
          break;
        } while (!paramActivity.equals("beta"));
        paramInt = 2;
        break;
        paramInt = i;
        if (paramActivity.equals("dev")) {
          break;
        }
      } while ((goto 304) || (!paramActivity.equals("staging")));
      paramInt = 0;
      switch (paramInt)
      {
      default: 
        break;
      case 5: 
        localView.findViewById(2131364737).setBackgroundColor(-3355444);
        break;
      case 4: 
        localView.findViewById(2131364736).setBackgroundColor(-3355444);
        break;
      case 3: 
        localView.findViewById(2131362457).setBackgroundColor(-3355444);
        break;
      case 2: 
        localView.findViewById(2131364735).setBackgroundColor(-3355444);
        break;
      case 1: 
        localView.findViewById(2131362402).setBackgroundColor(-3355444);
        break;
      case 0: 
        localView.findViewById(2131364098).setBackgroundColor(-3355444);
      }
    }
    localTPMaterialDialogV2.show();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\core\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */