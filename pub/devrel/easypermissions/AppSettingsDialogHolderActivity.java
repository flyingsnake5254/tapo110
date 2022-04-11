package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AppSettingsDialogHolderActivity
  extends AppCompatActivity
  implements DialogInterface.OnClickListener
{
  public static Intent P0(Context paramContext, AppSettingsDialog paramAppSettingsDialog)
  {
    return new Intent(paramContext, AppSettingsDialogHolderActivity.class).putExtra("extra_app_settings", paramAppSettingsDialog);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    setResult(0);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (AppSettingsDialog)getIntent().getParcelableExtra("extra_app_settings");
    paramBundle.b(this);
    paramBundle.a(this);
    paramBundle.c(this);
    paramBundle.e();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\AppSettingsDialogHolderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */