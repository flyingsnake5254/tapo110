package com.tplink.iot.view.quicksetup.bulb;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.extension.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.devicecommon.feature.AnimationDrawableImageViewFeature;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import com.tplink.iot.widget.OrderTextView;
import com.tplink.iot.widget.PointTextView;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

public class BulbNoFindActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String p0;
  private View p1;
  private ValueAnimator y;
  private AnimationDrawable z;
  
  private void e1()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.y.removeAllListeners();
      this.y = null;
    }
    localObject = this.z;
    if (localObject != null) {
      ((AnimationDrawable)localObject).stop();
    }
  }
  
  private String f1(String paramString)
  {
    if ("L530".equals(paramString)) {
      return getResources().getString(2131953107);
    }
    if ("L520".equals(paramString)) {
      return getResources().getString(2131953106);
    }
    if ("L510".equals(paramString)) {
      return getResources().getString(2131953105);
    }
    if ("P110".equals(paramString)) {
      return getResources().getString(2131953121);
    }
    if ("H100".equals(paramString)) {
      return getResources().getString(2131953115);
    }
    if ("L900".equals(paramString)) {
      return getResources().getString(2131953116);
    }
    if ("L920".equals(paramString)) {
      return getResources().getString(2131953117);
    }
    String str = paramString;
    if ("L930".equals(paramString)) {
      str = getResources().getString(2131953118);
    }
    return str;
  }
  
  private void g1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.p0 = ((Bundle)localObject).getString("device_model");
      }
    }
  }
  
  private void h1()
  {
    final ImageView localImageView = (ImageView)this.p1.findViewById(2131363007);
    if (localImageView != null)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
      this.y = localValueAnimator;
      localValueAnimator.addListener(new a(localImageView));
      this.y.setRepeatCount(-1);
      this.y.setRepeatMode(1);
      this.y.start();
    }
  }
  
  private void i1()
  {
    h.a(this.p1.findViewById(2131364606), getString(2131953319, new Object[] { Integer.valueOf(5) }));
    ImageView localImageView = (ImageView)this.p1.findViewById(2131363108);
    if (localImageView != null) {
      AnimationDrawableImageViewFeature.a(this, localImageView);
    }
  }
  
  private void j1()
  {
    Object localObject = (OrderTextView)this.p1.findViewById(2131364606);
    if (localObject != null)
    {
      int i = 2131952959;
      if (c.j(this.p0)) {
        i = 2131952960;
      }
      ((OrderTextView)localObject).setContent(getString(i));
    }
    ImageView localImageView = (ImageView)this.p1.findViewById(2131363007);
    localObject = (LottieAnimationView)this.p1.findViewById(2131363390);
    if (c.g(this.p0))
    {
      if ((localImageView != null) && ((localImageView.getDrawable() instanceof AnimationDrawable)))
      {
        localObject = (AnimationDrawable)localImageView.getDrawable();
        this.z = ((AnimationDrawable)localObject);
        ((AnimationDrawable)localObject).start();
      }
    }
    else if ((c.j(this.p0)) && (localImageView != null) && (localObject != null))
    {
      localImageView.setVisibility(8);
      LottieAnimationViewFeature.b(this, (LottieAnimationView)localObject, 2131886084);
    }
  }
  
  private void k1()
  {
    if (TextUtils.isEmpty(this.p0)) {
      return;
    }
    View localView = this.p1.findViewById(2131364606);
    if (this.p0.startsWith("P115")) {
      h.a(localView, getString(2131953546));
    }
  }
  
  private void l1()
  {
    EnumDeviceType localEnumDeviceType = b.l(this.p0);
    int i = b.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          i1();
        }
      }
      else {
        k1();
      }
    }
    else if (c.i(this.p0)) {
      j1();
    } else {
      h1();
    }
  }
  
  private void m1()
  {
    d.c0(this, (TextView)findViewById(2131364385), f1(this.p0));
    Object localObject = (Button)findViewById(2131362037);
    ((Button)localObject).setText(getString(2131954363));
    ((Button)localObject).setOnClickListener(this);
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    localObject = (ViewStub)findViewById(2131364069);
    ((ViewStub)localObject).setLayoutResource(b.r(this.p0));
    localObject = ((ViewStub)localObject).inflate();
    this.p1 = ((View)localObject);
    localObject = ((View)localObject).findViewById(2131364410);
    if (localObject != null)
    {
      String str1 = b.v(this.p0);
      String str2 = getString(2131953477, new Object[] { str1 });
      if ((localObject instanceof TextView)) {
        d0.a((TextView)localObject, str2, str1, ContextCompat.getColor(this, 2131099811));
      } else if ((localObject instanceof PointTextView)) {
        d0.b((PointTextView)localObject, str2, str1, ContextCompat.getColor(this, 2131099811));
      }
    }
    l1();
  }
  
  public static void n1(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, BulbNoFindActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_model", paramString);
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void o1()
  {
    e1();
    a.h(this, b.l(this.p0).getDeviceType(), this.p0, "NotFindDevicePage");
  }
  
  public void onBackPressed()
  {
    o1();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362831) {
        o1();
      }
    }
    else
    {
      setResult(-1);
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558674);
    g1();
    m1();
  }
  
  class a
    implements Animator.AnimatorListener
  {
    private boolean c = false;
    
    a(ImageView paramImageView) {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      boolean bool = this.c ^ true;
      this.c = bool;
      paramAnimator = localImageView;
      int i;
      if (bool) {
        i = 2131689525;
      } else {
        i = 2131689524;
      }
      paramAnimator.setImageResource(i);
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\BulbNoFindActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */