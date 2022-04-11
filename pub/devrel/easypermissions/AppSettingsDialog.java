package pub.devrel.easypermissions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog.Builder;

public class AppSettingsDialog
  implements Parcelable, DialogInterface.OnClickListener
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final Parcelable.Creator<AppSettingsDialog> CREATOR = new a();
  private final String c;
  private final String d;
  private final String f;
  private DialogInterface.OnClickListener p0;
  private final String q;
  private final int x;
  private Context y;
  private Object z;
  
  private AppSettingsDialog(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.f = paramParcel.readString();
    this.q = paramParcel.readString();
    this.x = paramParcel.readInt();
  }
  
  private AppSettingsDialog(@NonNull Object paramObject, @NonNull Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable DialogInterface.OnClickListener paramOnClickListener, int paramInt)
  {
    this.z = paramObject;
    this.y = paramContext;
    this.c = paramString1;
    this.d = paramString2;
    this.f = paramString3;
    this.q = paramString4;
    this.p0 = paramOnClickListener;
    this.x = paramInt;
  }
  
  @RequiresApi(api=11)
  private void f(Intent paramIntent)
  {
    Object localObject = this.z;
    if ((localObject instanceof Activity)) {
      ((Activity)localObject).startActivityForResult(paramIntent, this.x);
    } else if ((localObject instanceof androidx.fragment.app.Fragment)) {
      ((androidx.fragment.app.Fragment)localObject).startActivityForResult(paramIntent, this.x);
    } else if ((localObject instanceof android.app.Fragment)) {
      ((android.app.Fragment)localObject).startActivityForResult(paramIntent, this.x);
    }
  }
  
  void a(Object paramObject)
  {
    this.z = paramObject;
  }
  
  void b(Context paramContext)
  {
    this.y = paramContext;
  }
  
  void c(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
  }
  
  public void d()
  {
    if (this.p0 == null) {
      f(AppSettingsDialogHolderActivity.P0(this.y, this));
    } else {
      e();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  void e()
  {
    new AlertDialog.Builder(this.y).setCancelable(false).setTitle(this.d).setMessage(this.c).setPositiveButton(this.f, this).setNegativeButton(this.q, this.p0).create().show();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    paramDialogInterface.setData(Uri.fromParts("package", this.y.getPackageName(), null));
    f(paramDialogInterface);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.q);
    paramParcel.writeInt(this.x);
  }
  
  static final class a
    implements Parcelable.Creator<AppSettingsDialog>
  {
    public AppSettingsDialog a(Parcel paramParcel)
    {
      return new AppSettingsDialog(paramParcel, null);
    }
    
    public AppSettingsDialog[] b(int paramInt)
    {
      return new AppSettingsDialog[paramInt];
    }
  }
  
  public static class b
  {
    private Object a;
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private DialogInterface.OnClickListener g;
    private int h = -1;
    
    public b(@NonNull Activity paramActivity)
    {
      this.a = paramActivity;
      this.b = paramActivity;
    }
    
    public b(@NonNull androidx.fragment.app.Fragment paramFragment)
    {
      this.a = paramFragment;
      this.b = paramFragment.getContext();
    }
    
    public AppSettingsDialog a()
    {
      String str;
      if (TextUtils.isEmpty(this.c)) {
        str = this.b.getString(b.rationale_ask_again);
      } else {
        str = this.c;
      }
      this.c = str;
      if (TextUtils.isEmpty(this.d)) {
        str = this.b.getString(b.title_settings_dialog);
      } else {
        str = this.d;
      }
      this.d = str;
      if (TextUtils.isEmpty(this.e)) {
        str = this.b.getString(17039370);
      } else {
        str = this.e;
      }
      this.e = str;
      if (TextUtils.isEmpty(this.f)) {
        str = this.b.getString(17039360);
      } else {
        str = this.f;
      }
      this.f = str;
      int i = this.h;
      if (i <= 0) {
        i = 16061;
      }
      this.h = i;
      return new AppSettingsDialog(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
    }
    
    public b b(@StringRes int paramInt)
    {
      this.f = this.b.getString(paramInt);
      return this;
    }
    
    public b c(@StringRes int paramInt)
    {
      this.e = this.b.getString(paramInt);
      return this;
    }
    
    public b d(@StringRes int paramInt)
    {
      this.c = this.b.getString(paramInt);
      return this;
    }
    
    public b e(int paramInt)
    {
      this.h = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\AppSettingsDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */