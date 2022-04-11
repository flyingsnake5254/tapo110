package skin.support.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.FragmentActivity;
import f.a.f.a.d;
import skin.support.widget.c;

@Deprecated
public class SkinCompatActivity
  extends AppCompatActivity
{
  private SkinCompatDelegate c;
  
  @NonNull
  public SkinCompatDelegate P0()
  {
    if (this.c == null) {
      this.c = SkinCompatDelegate.a(this);
    }
    return this.c;
  }
  
  protected boolean Q0()
  {
    return true;
  }
  
  protected void R0()
  {
    if ((Q0()) && (Build.VERSION.SDK_INT >= 21))
    {
      int i = f.a.f.a.e.d(this);
      int j = f.a.f.a.e.a(this);
      if (c.a(i) != 0) {
        getWindow().setStatusBarColor(d.a(this, i));
      } else if (c.a(j) != 0) {
        getWindow().setStatusBarColor(d.a(this, j));
      }
    }
  }
  
  protected void S0()
  {
    int i = f.a.f.a.e.i(this);
    if (c.a(i) != 0)
    {
      Drawable localDrawable = d.d(this, i);
      if (localDrawable != null) {
        getWindow().setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    LayoutInflaterCompat.setFactory(getLayoutInflater(), P0());
    super.onCreate(paramBundle);
    R0();
    S0();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    f.a.e.a();
    throw null;
  }
  
  protected void onResume()
  {
    super.onResume();
    f.a.e.a();
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\app\SkinCompatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */