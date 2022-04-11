package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;

class d
{
  int a;
  int b;
  int c;
  String d;
  String[] e;
  
  d(@StringRes int paramInt1, @StringRes int paramInt2, @NonNull String paramString, int paramInt3, @NonNull String[] paramArrayOfString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString;
    this.c = paramInt3;
    this.e = paramArrayOfString;
  }
  
  d(Bundle paramBundle)
  {
    this.a = paramBundle.getInt("positiveButton");
    this.b = paramBundle.getInt("negativeButton");
    this.d = paramBundle.getString("rationaleMsg");
    this.c = paramBundle.getInt("requestCode");
    this.e = paramBundle.getStringArray("permissions");
  }
  
  AlertDialog a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    return new AlertDialog.Builder(paramContext).setCancelable(false).setPositiveButton(this.a, paramOnClickListener).setNegativeButton(this.b, paramOnClickListener).setMessage(this.d).create();
  }
  
  Bundle b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("positiveButton", this.a);
    localBundle.putInt("negativeButton", this.b);
    localBundle.putString("rationaleMsg", this.d);
    localBundle.putInt("requestCode", this.c);
    localBundle.putStringArray("permissions", this.e);
    return localBundle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */