package com.tplink.iot.view.about;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.d.w.c.c.e;
import com.andexert.library.RippleView;
import com.andexert.library.RippleView.b;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Future;

public class AboutFragment
  extends BaseFragment
  implements RippleView.b
{
  private int p0 = 0;
  private View q = null;
  private ScrollView x = null;
  private TextView y = null;
  private BaseActivity z = null;
  
  private void Q0()
  {
    this.q.startAnimation(R0());
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new d());
    localValueAnimator.setDuration(350L);
    localValueAnimator.start();
  }
  
  private Animation R0()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  @Nullable
  private File S0(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) && (!paramString1.mkdirs())) {
      return null;
    }
    return new File(paramString1, String.format("%s_%s.txt", new Object[] { paramString2, new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US).format(new Date(System.currentTimeMillis())) }));
  }
  
  private void T0()
  {
    s0.l(getActivity());
    new Thread(new e()).start();
  }
  
  private String W0(String paramString1, String paramString2, String paramString3)
    throws FileNotFoundException
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 29) {
      localObject = AppContext.c.getExternalFilesDir("");
    } else {
      localObject = Environment.getExternalStorageDirectory();
    }
    if (localObject != null)
    {
      localObject = ((File)localObject).getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append(paramString2.toUpperCase());
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append(paramString3.toUpperCase());
      paramString2 = localStringBuilder.toString();
      paramString3 = S0(paramString2, paramString3);
      if (paramString3 != null)
      {
        new PrintStream(new FileOutputStream(paramString3)).println(paramString1);
        return paramString2;
      }
      paramString1 = new StringBuilder();
      paramString1.append("Folder ");
      paramString1.append(paramString2);
      paramString1.append(" doesn't exit.");
      throw new FileNotFoundException(paramString1.toString());
    }
    throw new FileNotFoundException("dest path doesn't exit.");
  }
  
  private void X0()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.q, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.start();
  }
  
  private void Y0()
  {
    new TPMaterialDialogV2.Builder(getContext()).r(2131953013).h(2131953012).p(2131951765, new f()).l(2131952391, 2131099804, null).y();
  }
  
  public boolean G0(Intent paramIntent)
  {
    if (paramIntent != null) {
      if (paramIntent.getIntExtra("auto_reconnect_result", 0) != 0) {
        B0();
      } else if (paramIntent.getBooleanExtra("gateway_non_qualified", false)) {
        B0();
      }
    }
    return super.G0(paramIntent);
  }
  
  public void j0(RippleView paramRippleView)
  {
    switch (paramRippleView.getId())
    {
    default: 
      break;
    case 2131364171: 
      paramRippleView = new Intent(getActivity(), AboutWebActivity.class);
      paramRippleView.putExtra("toolbar_title", getString(2131951659));
      paramRippleView.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#terms-of-use");
      startActivity(paramRippleView);
      getActivity().overridePendingTransition(2130772068, 2130772067);
      break;
    case 2131363706: 
      C0(PrivacySettingActivity.class);
      getActivity().overridePendingTransition(2130772068, 2130772067);
      break;
    case 2131363705: 
      paramRippleView = new Intent(getActivity(), AboutWebActivity.class);
      paramRippleView.putExtra("toolbar_title", getString(2131951657));
      paramRippleView.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#privacy-policy");
      startActivity(paramRippleView);
      getActivity().overridePendingTransition(2130772068, 2130772067);
      break;
    case 2131363225: 
      C0(LicensesActivity.class);
      getActivity().overridePendingTransition(2130772068, 2130772067);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.z = ((BaseActivity)getActivity());
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558852, paramViewGroup, false);
    this.q = paramLayoutInflater;
    this.x = ((ScrollView)paramLayoutInflater.findViewById(2131361816));
    this.y = ((TextView)this.q.findViewById(2131361817));
    ((TextView)this.q.findViewById(2131361967)).setText(String.format(getString(2131951653), new Object[] { t0.d(getContext()) }));
    ((RippleView)this.q.findViewById(2131364171)).setOnRippleCompleteListener(this);
    ((RippleView)this.q.findViewById(2131363705)).setOnRippleCompleteListener(this);
    ((RippleView)this.q.findViewById(2131363225)).setOnRippleCompleteListener(this);
    ((RippleView)this.q.findViewById(2131363706)).setOnRippleCompleteListener(this);
    this.q.getViewTreeObserver().addOnPreDrawListener(new a());
    paramLayoutInflater = (Toolbar)this.q.findViewById(2131364275);
    ((BaseActivity)getActivity()).setSupportActionBar(paramLayoutInflater);
    ((TextView)this.q.findViewById(2131364290)).setText(2131952385);
    paramLayoutInflater.setNavigationOnClickListener(new b());
    this.q.findViewById(2131362301).setOnClickListener(new c());
    this.y.setText(getString(2131951655, new Object[] { "2022" }));
    if (a0.j())
    {
      paramLayoutInflater = (TextView)this.q.findViewById(2131364397);
      this.q.findViewById(2131362349).setVisibility(0);
      paramLayoutInflater.setOnClickListener(new d(this));
    }
    return this.q;
  }
  
  public void onDestroyView()
  {
    Q0();
    super.onDestroyView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() != 16908332) {
      return super.onOptionsItemSelected(paramMenuItem);
    }
    B0();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    StatusBarUtils.a(getActivity());
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if (paramInt != 125)
    {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    else
    {
      int i = paramArrayOfInt.length;
      for (paramInt = 0; paramInt < i; paramInt++) {
        if (paramArrayOfInt[paramInt] != 0)
        {
          paramInt = 0;
          break label47;
        }
      }
      paramInt = 1;
      label47:
      if (paramInt != 0) {
        T0();
      } else {
        Y0();
      }
      o.h0().h("is_first", false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    StatusBarUtils.o(getActivity(), this.q, getResources().getColor(2131099771));
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      AboutFragment.H0(AboutFragment.this);
      AboutFragment.I0(AboutFragment.this).getViewTreeObserver().removeOnPreDrawListener(this);
      return true;
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      AboutFragment.this.B0();
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      AboutFragment.K0(AboutFragment.this);
      AboutFragment.J0(AboutFragment.this);
    }
  }
  
  class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      f = b.d.w.f.a.d(AboutFragment.L0(AboutFragment.this)) * f;
      AboutFragment.N0(AboutFragment.this).setTranslationX(f);
      AboutFragment.O0(AboutFragment.this).setTranslationX(f);
    }
  }
  
  class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      try
      {
        Object localObject1 = (String)e.d(AboutFragment.this.getContext()).c().get();
        Object localObject3 = AboutFragment.P0(AboutFragment.this, (String)localObject1, "TPLINK", "Tapo");
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          FragmentActivity localFragmentActivity = AboutFragment.this.getActivity();
          localObject1 = new com/tplink/iot/view/about/a;
          ((a)localObject1).<init>(this, (String)localObject3);
          localFragmentActivity.runOnUiThread((Runnable)localObject1);
        }
        else
        {
          localObject3 = AboutFragment.this.getActivity();
          localObject1 = new com/tplink/iot/view/about/b;
          ((b)localObject1).<init>(this);
          ((Activity)localObject3).runOnUiThread((Runnable)localObject1);
        }
      }
      finally
      {
        AboutFragment.this.getActivity().runOnUiThread(new c(this));
      }
    }
  }
  
  class f
    implements TPMaterialDialogV2.d
  {
    f() {}
    
    public void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("package:");
      paramView.append(AboutFragment.this.getContext().getPackageName());
      paramView = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(paramView.toString()));
      AboutFragment.this.startActivityForResult(paramView, 126);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\AboutFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */