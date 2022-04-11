package com.tplink.iot.view.ipcamera.memories;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.c1;
import com.google.android.exoplayer2.e1;
import com.google.android.exoplayer2.f2;
import com.google.android.exoplayer2.h2.b;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.u1.e;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.DialogMemoryBottomOperationBinding;
import com.tplink.iot.databinding.ExoPlaybackControlViewBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.r;
import io.reactivex.q;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.AppSettingsDialog.b;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

public class MemoriesVideoPlayActivity
  extends BaseActivity
  implements com.tplink.iot.view.ipcamera.base.g, EasyPermissions.PermissionCallbacks
{
  private TextView H3;
  private PlayerView I3;
  private ViewGroup J3;
  private View K3;
  private TextView L3;
  private View M3;
  private View N3;
  private Animation O3;
  private Animation P3;
  private Animation Q3;
  private Animation R3;
  private e1 S3;
  private int T3 = 0;
  private boolean U3;
  private int V3;
  private long W3;
  private boolean X3 = false;
  private int p0;
  private int p1;
  private View p2;
  private View p3;
  private MemoriesViewModel y;
  private MemoryBean z;
  
  private void A1(int paramInt, String paramString)
  {
    EasyPermissions.f(this, paramString, paramInt, com.tplink.iot.Utils.a1.b.a());
  }
  
  private void B1()
  {
    int i = this.T3 + 1;
    this.T3 = i;
    if (i >= 3)
    {
      this.T3 = 3;
      return;
    }
    e1 locale1 = this.S3;
    if (locale1 != null)
    {
      locale1.prepare();
      this.S3.play();
    }
  }
  
  private void C1()
  {
    Toolbar localToolbar = (Toolbar)findViewById(2131364275);
    setSupportActionBar(localToolbar);
    localToolbar.setNavigationOnClickListener(new i(this));
  }
  
  private void D1()
  {
    Object localObject1 = new File(this.z.getVideoPath());
    if (!((File)localObject1).exists()) {
      return;
    }
    Object localObject2 = Uri.fromFile((File)localObject1);
    Uri localUri;
    if ((Build.VERSION.SDK_INT >= 20) && ("file".equals(((Uri)localObject2).getScheme())))
    {
      localObject2 = b.d.q.b.p.b.n().concat(".provider");
      try
      {
        localObject1 = FileProvider.getUriForFile(this, (String)localObject2, (File)localObject1);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return;
      }
    }
    else
    {
      localUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
    }
    localObject2 = new Intent();
    ((Intent)localObject2).setAction("android.intent.action.SEND");
    ((Intent)localObject2).putExtra("android.intent.extra.STREAM", localUri);
    ((Intent)localObject2).setType("video/*");
    startActivity(Intent.createChooser((Intent)localObject2, getString(2131953082)));
  }
  
  private void G1()
  {
    if (this.y.l.get())
    {
      this.M3.setVisibility(0);
      this.X3 = false;
    }
    else if ((this.y.l.get()) && (!this.X3))
    {
      this.M3.setVisibility(8);
      this.X3 = true;
    }
    else
    {
      this.M3.setVisibility(8);
      this.X3 = true;
    }
  }
  
  private boolean g1()
  {
    return EasyPermissions.a(this, com.tplink.iot.Utils.a1.b.a());
  }
  
  private void h1()
  {
    final MemoryDeleteDialogFragment localMemoryDeleteDialogFragment = MemoryDeleteDialogFragment.A0();
    localMemoryDeleteDialogFragment.B0(new b(localMemoryDeleteDialogFragment));
    localMemoryDeleteDialogFragment.show(getSupportFragmentManager(), "MemoryDeleteDialogFragment");
  }
  
  private void i1()
  {
    this.y.o.set(true);
    r.f().e(this.z).y(new k(this)).H0(new h(this), t.c);
  }
  
  private void j1()
  {
    if (this.y.h.get())
    {
      this.z.setMark(true);
      r.f().G(this.z);
    }
    else
    {
      this.z.setMark(false);
      r.f().G(this.z);
    }
  }
  
  private void l1()
  {
    this.p2 = findViewById(2131363919);
    this.p3 = findViewById(2131364284);
    this.H3 = ((TextView)findViewById(2131364290));
    this.I3 = ((PlayerView)findViewById(2131364781));
    Object localObject = (ViewGroup)findViewById(2131364771);
    this.J3 = ((ViewGroup)localObject);
    View.inflate(this, 2131559334, (ViewGroup)localObject);
    this.I3 = ((PlayerView)findViewById(2131364781));
    this.K3 = findViewById(2131364786);
    this.L3 = ((TextView)findViewById(2131364772));
    localObject = (DialogMemoryBottomOperationBinding)DataBindingUtil.bind(this.K3);
    ((DialogMemoryBottomOperationBinding)localObject).i(this);
    ((DialogMemoryBottomOperationBinding)localObject).h(this.y);
  }
  
  private void m1()
  {
    if (getIntent() != null)
    {
      Bundle localBundle = getIntent().getExtras();
      Objects.requireNonNull(localBundle);
      this.z = ((MemoryBean)((Bundle)localBundle).getSerializable("MemoryBean"));
    }
    else
    {
      this.z = new MemoryBean();
    }
    n1(this.z);
    this.O3 = AnimationUtils.loadAnimation(this, 2130772048);
    this.P3 = AnimationUtils.loadAnimation(this, 2130772049);
    this.Q3 = AnimationUtils.loadAnimation(this, 2130772046);
    this.R3 = AnimationUtils.loadAnimation(this, 2130772047);
  }
  
  private void n1(MemoryBean paramMemoryBean)
  {
    this.p1 = 640;
    this.p0 = 360;
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    Object localObject = null;
    String str;
    try
    {
      localMediaMetadataRetriever.setDataSource(paramMemoryBean.getVideoPath());
      str = localMediaMetadataRetriever.extractMetadata(18);
      try
      {
        paramMemoryBean = localMediaMetadataRetriever.extractMetadata(19);
      }
      catch (Exception paramMemoryBean)
      {
        paramMemoryBean = (MemoryBean)localObject;
      }
      if (org.apache.commons.lang.e.a(str)) {
        break label79;
      }
    }
    catch (Exception paramMemoryBean)
    {
      str = null;
      paramMemoryBean = (MemoryBean)localObject;
    }
    localObject = paramMemoryBean;
    if (org.apache.commons.lang.e.a(paramMemoryBean))
    {
      label79:
      str = "640";
      localObject = "360";
    }
    this.p1 = Integer.parseInt(str);
    this.p0 = Integer.parseInt((String)localObject);
  }
  
  private void o1()
  {
    this.y.g.set(true);
    this.y.f.set(true);
    this.y.d.set(true);
    this.y.e.set(true);
    this.y.m.set(false);
    this.y.j.set(this.z.getDeviceAlias());
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Long.valueOf(this.z.getTimestamp()));
    this.y.k.set(localObject);
    this.y.h.set(this.z.isMark());
    this.H3.setText(this.z.getDeviceAlias());
    this.L3.setText((CharSequence)localObject);
    localObject = (ExoPlaybackControlViewBinding)DataBindingUtil.bind(this.I3.findViewById(2131362573));
    ((ExoPlaybackControlViewBinding)localObject).h(this.y);
    ((ExoPlaybackControlViewBinding)localObject).i(this);
    this.M3 = ((ExoPlaybackControlViewBinding)localObject).p2;
    this.N3 = ((ExoPlaybackControlViewBinding)localObject).p3;
    this.I3.setControllerVisibilityListener(new j(this));
    this.I3.setControllerShowTimeoutMs(-1);
    p1(this.z.getVideoPath());
  }
  
  private void p1(String paramString)
  {
    z1();
    if (paramString.contains("summary"))
    {
      this.S3 = new h2.b(this, new c1(this)).z();
    }
    else
    {
      localObject = new com.tplink.iot.Utils.hls.d(this);
      ((c1)localObject).i(2);
      this.S3 = new h2.b(this, (f2)localObject).z();
    }
    this.S3.N(new a());
    this.I3.setPlayer(this.S3);
    this.S3.p(this.U3);
    this.S3.B(this.V3, this.W3);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file://");
    ((StringBuilder)localObject).append(paramString);
    paramString = Uri.parse(((StringBuilder)localObject).toString());
    paramString = new l1.c().u(paramString).q("video/mp4").a();
    this.S3.D(paramString);
    this.S3.prepare();
  }
  
  private void y1()
  {
    e1 locale1 = this.S3;
    if (locale1 != null) {
      locale1.p(false);
    }
  }
  
  private void z1()
  {
    e1 locale1 = this.S3;
    if (locale1 != null)
    {
      this.W3 = locale1.V();
      this.V3 = this.S3.m();
      this.U3 = this.S3.E();
      this.S3.release();
      this.S3 = null;
    }
  }
  
  public void E0(int paramInt, List<String> paramList)
  {
    if (2 == paramInt) {
      i1();
    }
  }
  
  public void E1()
  {
    F1();
    G1();
  }
  
  public void F1()
  {
    boolean bool = this.y.l.get();
    int i = 0;
    int j;
    if ((!bool) && (!this.y.m.get())) {
      j = 0;
    } else {
      j = 1;
    }
    if (this.y.l.get()) {
      this.p2.setBackgroundColor(ContextCompat.getColor(this, 2131100139));
    } else if (this.y.m.get()) {
      this.p2.setBackgroundColor(ContextCompat.getColor(this, 2131099799));
    } else {
      this.p2.setBackgroundColor(ContextCompat.getColor(this, 2131100140));
    }
    int k = 1792;
    int m = Build.VERSION.SDK_INT;
    if (m >= 23) {
      k = 9984;
    }
    int n = k;
    if (m >= 19) {
      n = k | 0x1000;
    }
    k = n;
    if (j != 0) {
      k = n | 0x6;
    }
    getWindow().getDecorView().setSystemUiVisibility(k);
    ActionBar localActionBar = getSupportActionBar();
    Object localObject = (ViewGroup.MarginLayoutParams)this.J3.getLayoutParams();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    WindowManager.LayoutParams localLayoutParams;
    if (this.y.l.get())
    {
      localLayoutParams = getWindow().getAttributes();
      localLayoutParams.flags |= 0x400;
      getWindow().setAttributes(localLayoutParams);
      getWindow().addFlags(512);
      ((ViewGroup.MarginLayoutParams)localObject).width = localDisplayMetrics.widthPixels;
      ((ViewGroup.MarginLayoutParams)localObject).height = localDisplayMetrics.heightPixels;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
      if (localActionBar != null) {
        localActionBar.hide();
      }
    }
    else
    {
      localLayoutParams = getWindow().getAttributes();
      localLayoutParams.flags &= 0xFBFF;
      getWindow().setAttributes(localLayoutParams);
      getWindow().clearFlags(512);
      n = localDisplayMetrics.widthPixels;
      ((ViewGroup.MarginLayoutParams)localObject).width = n;
      ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(n / (this.p1 / this.p0)));
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tplink.libtpnetwork.cameranetwork.util.e.a(80, this);
      if (localActionBar != null) {
        localActionBar.show();
      }
    }
    this.J3.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.y.l.get()) {
      this.p3.setVisibility(8);
    } else if (this.y.m.get()) {
      this.p3.setVisibility(4);
    } else {
      this.p3.setVisibility(0);
    }
    localObject = this.K3;
    if (j != 0) {
      n = 8;
    } else {
      n = 0;
    }
    ((View)localObject).setVisibility(n);
    localObject = this.L3;
    n = i;
    if (j != 0) {
      n = 8;
    }
    ((TextView)localObject).setVisibility(n);
    if (j == 0)
    {
      localObject = (ViewGroup.MarginLayoutParams)this.K3.getLayoutParams();
      k = com.tplink.iot.view.quicksetup.base.d.j(this);
      n = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      if (n < k) {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (n + k);
      }
      this.K3.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void k1()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MemoryDelete", false);
    localIntent.putExtra("MemoryBean", this.z);
    setResult(1012, localIntent);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((3 == paramInt1) && (g1())) {
      i1();
    }
  }
  
  public void onBackPressed()
  {
    k1();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363124: 
    case 2131364626: 
      D1();
      com.tplink.iot.Utils.x0.e.x();
      break;
    case 2131363047: 
    case 2131364458: 
      paramView = this.y.h;
      paramView.set(paramView.get() ^ true);
      j1();
      break;
    case 2131363038: 
    case 2131364424: 
      if (g1()) {
        i1();
      } else {
        A1(2, getString(2131953355));
      }
      break;
    case 2131363025: 
    case 2131364400: 
      h1();
      break;
    case 2131361999: 
      onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    ObservableBoolean localObservableBoolean = this.y.l;
    boolean bool;
    if (paramConfiguration.orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localObservableBoolean.set(bool);
    E1();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(128, 128);
    setContentView(2131558581);
    ((ViewGroup.MarginLayoutParams)findViewById(2131364275).getLayoutParams()).topMargin = com.tplink.iot.view.quicksetup.base.d.A(this);
    com.tplink.iot.view.quicksetup.base.d.d(this);
    com.tplink.iot.view.quicksetup.base.d.K(this);
    this.y = ((MemoriesViewModel)ViewModelProviders.of(this).get(MemoriesViewModel.class));
    l1();
    C1();
    m1();
    o1();
    E1();
    setRequestedOrientation(2);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    z1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (16908332 == paramMenuItem.getItemId())
    {
      onBackPressed();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    y1();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    EasyPermissions.d(paramInt, paramArrayOfString, paramArrayOfInt, new Object[] { this });
  }
  
  public void t(int paramInt, List<String> paramList)
  {
    if (2 == paramInt) {
      paramInt = 3;
    } else {
      paramInt = -1;
    }
    new AppSettingsDialog.b(this).d(2131953354).c(2131952441).b(2131952391).e(paramInt).a().d();
  }
  
  class a
    implements u1.e
  {
    a() {}
    
    public void P(@NonNull PlaybackException paramPlaybackException)
    {
      int i = paramPlaybackException.errorCode;
      if (i == 4003)
      {
        MemoriesVideoPlayActivity.e1(MemoriesVideoPlayActivity.this);
      }
      else if (i == 2005)
      {
        TSnackbar.z(TSnackbar.r(MemoriesVideoPlayActivity.this), 2131953647, -1).N();
        new Handler().postDelayed(new g(this), 2000L);
      }
    }
  }
  
  class b
    implements MemoryDeleteDialogFragment.a
  {
    b(MemoryDeleteDialogFragment paramMemoryDeleteDialogFragment) {}
    
    public void a()
    {
      localMemoryDeleteDialogFragment.dismiss();
    }
    
    public void b()
    {
      localMemoryDeleteDialogFragment.dismiss();
      Intent localIntent = new Intent();
      localIntent.putExtra("MemoryDelete", true);
      r.f().E(MemoriesVideoPlayActivity.f1(MemoriesVideoPlayActivity.this));
      MemoriesVideoPlayActivity.this.setResult(1012, localIntent);
      MemoriesVideoPlayActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\MemoriesVideoPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */