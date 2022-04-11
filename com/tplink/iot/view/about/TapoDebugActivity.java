package com.tplink.iot.view.about;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import b.d.w.c.c.e;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.a1.b;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.core.q;
import com.tplink.iot.databinding.ActivityTapoDebugBinding;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Future;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class TapoDebugActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final a y = new a(null);
  private final f p0 = h.b(e.c);
  private final f p1 = h.b(f.c);
  private ActivityTapoDebugBinding p2;
  private final f z = h.b(d.c);
  
  private final void A1()
  {
    q.j(this, 0);
  }
  
  private final void B1()
  {
    q.j(this, 1);
  }
  
  private final void g1(List<String> paramList)
  {
    h1(paramList, "android.permission.READ_EXTERNAL_STORAGE");
    if (b.c()) {
      h1(paramList, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
  }
  
  @TargetApi(23)
  private final boolean h1(List<String> paramList, String paramString)
  {
    if (checkSelfPermission(paramString) != 0)
    {
      paramList.add(paramString);
      if (!shouldShowRequestPermissionRationale(paramString)) {
        return false;
      }
    }
    return true;
  }
  
  private final void i1()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      r1();
    } else {
      o1();
    }
  }
  
  private final File j1(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) && (!paramString1.mkdirs())) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US);
    kotlin.jvm.internal.p localp = kotlin.jvm.internal.p.a;
    paramString2 = String.format("%s_%s.txt", Arrays.copyOf(new Object[] { paramString2, localSimpleDateFormat.format(new Date(System.currentTimeMillis())) }, 2));
    j.d(paramString2, "java.lang.String.format(format, *args)");
    return new File(paramString1, paramString2);
  }
  
  private final String k1(String paramString)
  {
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 93628483: 
        if (paramString.equals("beta3")) {
          paramString = "Beta3云";
        }
        break;
      case 93628482: 
        if (paramString.equals("beta2")) {
          paramString = "Beta2云";
        }
        break;
      case 3083686: 
        if (paramString.equals("dist")) {
          paramString = "正式环境";
        }
        break;
      case 3020272: 
        if (paramString.equals("beta")) {
          paramString = "Beta云";
        }
        break;
      case 99349: 
        if (paramString.equals("dev")) {
          paramString = "Dev云";
        }
        break;
      case -1897523141: 
        if (paramString.equals("staging")) {
          paramString = "Staging云环境";
        }
        break;
      }
    }
    paramString = "--";
    return paramString;
  }
  
  private final b l1()
  {
    return (b)this.z.getValue();
  }
  
  private final b m1()
  {
    return (b)this.p0.getValue();
  }
  
  private final b n1()
  {
    return (b)this.p1.getValue();
  }
  
  private final void o1()
  {
    s0.l(this);
    new Thread(new c(this)).start();
  }
  
  private final void p1()
  {
    ActivityTapoDebugBinding localActivityTapoDebugBinding = this.p2;
    if (localActivityTapoDebugBinding == null) {
      j.t("mBinding");
    }
    localActivityTapoDebugBinding.h(this);
    localActivityTapoDebugBinding = this.p2;
    if (localActivityTapoDebugBinding == null) {
      j.t("mBinding");
    }
    localActivityTapoDebugBinding.i(this);
  }
  
  @SuppressLint({"SetTextI18n"})
  private final void q1()
  {
    Object localObject = this.p2;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ViewDataBinding)localObject).getRoot().findViewById(2131364290);
    j.d(localObject, "mBinding.root.findViewBy…View>(R.id.toolbar_title)");
    ((TextView)localObject).setText("Tapo调试页面");
    y1();
    localObject = this.p2;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ActivityTapoDebugBinding)localObject).c;
    j.d(localObject, "mBinding.btnNavigation1");
    ((Button)localObject).setText(l1().b());
    localObject = this.p2;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ActivityTapoDebugBinding)localObject).d;
    j.d(localObject, "mBinding.btnNavigation2");
    ((Button)localObject).setText(m1().b());
    localObject = this.p2;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ActivityTapoDebugBinding)localObject).f;
    j.d(localObject, "mBinding.btnNavigation3");
    ((Button)localObject).setText(n1().b());
    localObject = this.p2;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ActivityTapoDebugBinding)localObject).z;
    j.d(localObject, "mBinding.groupNavigation");
    int i;
    if (s1()) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
  }
  
  @TargetApi(23)
  private final void r1()
  {
    Object localObject = new ArrayList();
    if (o.h0().c("is_first", true))
    {
      g1((List)localObject);
    }
    else if (t1((List)localObject))
    {
      z1();
      return;
    }
    if (((List)localObject).size() > 0)
    {
      localObject = ((Collection)localObject).toArray(new String[0]);
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.Array<T>");
      requestPermissions((String[])localObject, 125);
    }
    else
    {
      o1();
    }
  }
  
  private final boolean s1()
  {
    return false;
  }
  
  private final boolean t1(List<String> paramList)
  {
    boolean bool1 = b.c();
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (!h1(paramList, "android.permission.READ_EXTERNAL_STORAGE")) {
        return bool1;
      }
      if (!h1(paramList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
        return bool2;
      }
    }
    else if (!h1(paramList, "android.permission.READ_EXTERNAL_STORAGE"))
    {
      return bool2;
    }
    bool1 = false;
    return bool1;
  }
  
  private final void u1()
  {
    l1().a().invoke(this);
  }
  
  private final void v1()
  {
    m1().a().invoke(this);
  }
  
  private final void w1()
  {
    n1().a().invoke(this);
  }
  
  private final String x1(String paramString1, String paramString2, String paramString3)
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
      String str = ((File)localObject).getAbsolutePath();
      j.d(str, "rootFile.absolutePath");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separatorChar);
      Objects.requireNonNull(paramString2, "null cannot be cast to non-null type java.lang.String");
      paramString2 = paramString2.toUpperCase();
      j.d(paramString2, "(this as java.lang.String).toUpperCase()");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separatorChar);
      Objects.requireNonNull(paramString3, "null cannot be cast to non-null type java.lang.String");
      paramString2 = paramString3.toUpperCase();
      j.d(paramString2, "(this as java.lang.String).toUpperCase()");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
      paramString3 = j1(paramString2, paramString3);
      if (paramString3 != null)
      {
        new PrintStream(new FileOutputStream(paramString3)).println(paramString1);
        paramString1 = paramString3.getAbsolutePath();
        j.d(paramString1, "destFile.absolutePath");
        return paramString1;
      }
      paramString1 = new StringBuilder();
      paramString1.append("Folder ");
      paramString1.append(paramString2);
      paramString1.append(" doesn't exit.");
      throw new FileNotFoundException(paramString1.toString());
    }
    throw new FileNotFoundException("dest path doesn't exit.");
  }
  
  @SuppressLint({"SetTextI18n"})
  private final void y1()
  {
    Object localObject1 = a0.e();
    int i = 0;
    int j;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      if (j.a("nbu.iot-app-server.app", "nbu.iot-app-server.app")) {
        localObject1 = "dist";
      } else {
        localObject1 = m.w("nbu.iot-app-server.app", "nbu.iot-app-server.app.", "", false, 4, null);
      }
    }
    Object localObject2 = this.p2;
    if (localObject2 == null) {
      j.t("mBinding");
    }
    localObject2 = ((ActivityTapoDebugBinding)localObject2).K3;
    j.d(localObject2, "mBinding.tvIotCloudEnv");
    ((TextView)localObject2).setText(k1((String)localObject1));
    localObject2 = this.p2;
    if (localObject2 == null) {
      j.t("mBinding");
    }
    TextView localTextView = ((ActivityTapoDebugBinding)localObject2).N3;
    j.d(localTextView, "mBinding.tvTpCloudEnv");
    boolean bool = j.a(localObject1, "dist");
    localObject2 = "beta";
    if (bool) {
      localObject1 = k1((String)localObject1);
    } else {
      localObject1 = k1("beta");
    }
    localTextView.setText((CharSequence)localObject1);
    localObject1 = a0.f();
    if (localObject1 != null)
    {
      j = i;
      if (((CharSequence)localObject1).length() != 0) {}
    }
    else
    {
      j = 1;
    }
    if (j != 0) {
      localObject1 = localObject2;
    }
    localObject2 = this.p2;
    if (localObject2 == null) {
      j.t("mBinding");
    }
    localObject2 = ((ActivityTapoDebugBinding)localObject2).M3;
    j.d(localObject2, "mBinding.tvTapoCareEnv");
    ((TextView)localObject2).setText(k1((String)localObject1));
  }
  
  private final void z1()
  {
    new TPMaterialDialogV2.Builder(this).r(2131953013).h(2131953012).p(2131951765, new g(this)).l(2131952391, 2131099804, null).y();
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362138)) {
      A1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362140)) {
      B1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362078)) {
      u1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362079)) {
      v1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362080)) {
      w1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558688);
    j.d(paramBundle, "DataBindingUtil.setConte…yout.activity_tapo_debug)");
    this.p2 = ((ActivityTapoDebugBinding)paramBundle);
    p1();
    q1();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362103)) {
      i1();
    }
    return true;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    j.e(paramArrayOfString, "permissions");
    j.e(paramArrayOfInt, "grantResults");
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
          break label61;
        }
      }
      paramInt = 1;
      label61:
      if (paramInt != 0) {
        o1();
      } else {
        z1();
      }
      o.h0().h("is_first", false);
    }
  }
  
  public static final class a {}
  
  private static final class b
  {
    public static final a a = new a(null);
    private final String b;
    private final l<Activity, kotlin.p> c;
    
    public b(String paramString, l<? super Activity, kotlin.p> paraml)
    {
      this.b = paramString;
      this.c = paraml;
    }
    
    public final l<Activity, kotlin.p> a()
    {
      return this.c;
    }
    
    public final String b()
    {
      return this.b;
    }
    
    public static final class a
    {
      public final TapoDebugActivity.b a(String paramString, l<? super Activity, kotlin.p> paraml)
      {
        j.e(paramString, "btnName");
        j.e(paraml, "action");
        return new TapoDebugActivity.b(paramString, paraml);
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    c(TapoDebugActivity paramTapoDebugActivity) {}
    
    public final void run()
    {
      try
      {
        Object localObject1 = (String)e.d(this.c).c().get();
        TapoDebugActivity localTapoDebugActivity = this.c;
        j.d(localObject1, "log");
        String str = TapoDebugActivity.f1(localTapoDebugActivity, (String)localObject1, "TPLINK", "Tapo");
        if (!TextUtils.isEmpty(str))
        {
          localTapoDebugActivity = this.c;
          localObject1 = new com/tplink/iot/view/about/TapoDebugActivity$c$a;
          ((a)localObject1).<init>(this, str);
          localTapoDebugActivity.runOnUiThread((Runnable)localObject1);
        }
        else
        {
          localTapoDebugActivity = this.c;
          localObject1 = new com/tplink/iot/view/about/TapoDebugActivity$c$b;
          ((b)localObject1).<init>(this);
          localTapoDebugActivity.runOnUiThread((Runnable)localObject1);
        }
      }
      finally
      {
        this.c.runOnUiThread(new c(this));
      }
    }
    
    static final class a
      implements Runnable
    {
      a(TapoDebugActivity.c paramc, String paramString) {}
      
      public final void run()
      {
        TextView localTextView = TapoDebugActivity.e1(this.c.c).L3;
        j.d(localTextView, "mBinding.tvLogPath");
        localTextView.setText(this.d);
        s0.C(this.c.c, "Save successfully", null);
      }
    }
    
    static final class b
      implements Runnable
    {
      b(TapoDebugActivity.c paramc) {}
      
      public final void run()
      {
        Object localObject = TapoDebugActivity.e1(this.c.c).L3;
        j.d(localObject, "mBinding.tvLogPath");
        ((TextView)localObject).setText("--");
        localObject = this.c.c;
        s0.q((Activity)localObject, ((Activity)localObject).getString(2131952444), null);
      }
    }
    
    static final class c
      implements Runnable
    {
      c(TapoDebugActivity.c paramc) {}
      
      public final void run()
      {
        TapoDebugActivity localTapoDebugActivity = this.c.c;
        s0.q(localTapoDebugActivity, localTapoDebugActivity.getString(2131952444), null);
      }
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<TapoDebugActivity.b>
  {
    public static final d c = new d();
    
    d()
    {
      super();
    }
    
    public final TapoDebugActivity.b a()
    {
      return TapoDebugActivity.b.a.a("跳转页面按钮名称1", a.c);
    }
    
    static final class a
      extends Lambda
      implements l<Activity, kotlin.p>
    {
      public static final a c = new a();
      
      a()
      {
        super();
      }
      
      public final void a(Activity paramActivity)
      {
        j.e(paramActivity, "activity");
      }
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<TapoDebugActivity.b>
  {
    public static final e c = new e();
    
    e()
    {
      super();
    }
    
    public final TapoDebugActivity.b a()
    {
      return TapoDebugActivity.b.a.a("跳转页面按钮名称2", a.c);
    }
    
    static final class a
      extends Lambda
      implements l<Activity, kotlin.p>
    {
      public static final a c = new a();
      
      a()
      {
        super();
      }
      
      public final void a(Activity paramActivity)
      {
        j.e(paramActivity, "activity");
      }
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<TapoDebugActivity.b>
  {
    public static final f c = new f();
    
    f()
    {
      super();
    }
    
    public final TapoDebugActivity.b a()
    {
      return TapoDebugActivity.b.a.a("跳转页面按钮名称3", a.c);
    }
    
    static final class a
      extends Lambda
      implements l<Activity, kotlin.p>
    {
      public static final a c = new a();
      
      a()
      {
        super();
      }
      
      public final void a(Activity paramActivity)
      {
        j.e(paramActivity, "activity");
      }
    }
  }
  
  static final class g
    implements TPMaterialDialogV2.d
  {
    g(TapoDebugActivity paramTapoDebugActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("package:");
      paramView.append(this.a.getPackageName());
      paramView = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(paramView.toString()));
      this.a.startActivityForResult(paramView, 126);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\TapoDebugActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */