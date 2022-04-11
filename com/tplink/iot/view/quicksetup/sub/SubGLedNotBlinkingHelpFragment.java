package com.tplink.iot.view.quicksetup.sub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.databinding.FragmentSubgLedNotBlinkingHelpBinding;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.f.a.a;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.view.quicksetup.sub.common.g;
import com.tplink.iot.widget.PointTextView;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SubGLedNotBlinkingHelpFragment
  extends BaseBottomSheetDialog<FragmentSubgLedNotBlinkingHelpBinding>
{
  public static final a p1 = new a(null);
  private SubDeviceModel p2 = SubDeviceModel.SENSOR_OTHER;
  private HashMap p3;
  
  private final void U0()
  {
    Object localObject = this.p2;
    int i = r.a[localObject.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i == 3)
      {
        ((FragmentSubgLedNotBlinkingHelpBinding)O0()).y.setContent(getString(2131954174));
        ((FragmentSubgLedNotBlinkingHelpBinding)O0()).z.setContent(getString(2131954173));
        localObject = ((FragmentSubgLedNotBlinkingHelpBinding)O0()).p0;
        ((View)localObject).setVisibility(0);
        ((PointTextView)localObject).setContent(getString(2131954210));
      }
    }
    else
    {
      ((FragmentSubgLedNotBlinkingHelpBinding)O0()).y.setContent(getString(2131954174));
      ((FragmentSubgLedNotBlinkingHelpBinding)O0()).z.setContent(getString(2131954173));
      localObject = ((FragmentSubgLedNotBlinkingHelpBinding)O0()).p0;
      ((View)localObject).setVisibility(0);
      ((PointTextView)localObject).setContent(getString(2131954210));
    }
  }
  
  public static final SubGLedNotBlinkingHelpFragment V0(SubDeviceModel paramSubDeviceModel)
  {
    return p1.a(paramSubDeviceModel);
  }
  
  public void A0()
  {
    HashMap localHashMap = this.p3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int L0()
  {
    return 2131558975;
  }
  
  public BottomSheetOptions P0()
  {
    return new BottomSheetOptions().fullscreen(true).noDim(true).topRoundCorner(false);
  }
  
  public void Q0()
  {
    ((FragmentSubgLedNotBlinkingHelpBinding)O0()).c.setOnClickListener(new b(this));
    e locale = g.a(this.p2);
    TextView localTextView = ((FragmentSubgLedNotBlinkingHelpBinding)O0()).x;
    j.d(localTextView, "mBinding.tvResetHint");
    localTextView.setText(locale.c());
    U0();
    if (this.p2 == SubDeviceModel.BUTTON_S200B) {
      ((FragmentSubgLedNotBlinkingHelpBinding)O0()).d.b(this, new c(this));
    } else {
      ((FragmentSubgLedNotBlinkingHelpBinding)O0()).d.a(this, locale.d());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    Object localObject = null;
    if (paramBundle != null) {
      paramBundle = paramBundle.getSerializable("SubDeviceModel");
    } else {
      paramBundle = null;
    }
    if (!(paramBundle instanceof SubDeviceModel)) {
      paramBundle = (Bundle)localObject;
    }
    paramBundle = (SubDeviceModel)paramBundle;
    if (paramBundle == null) {
      paramBundle = SubDeviceModel.SENSOR_OTHER;
    }
    this.p2 = paramBundle;
  }
  
  public static final class a
  {
    public final SubGLedNotBlinkingHelpFragment a(SubDeviceModel paramSubDeviceModel)
    {
      j.e(paramSubDeviceModel, "deviceModel");
      SubGLedNotBlinkingHelpFragment localSubGLedNotBlinkingHelpFragment = new SubGLedNotBlinkingHelpFragment();
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("SubDeviceModel", paramSubDeviceModel);
      paramSubDeviceModel = p.a;
      localSubGLedNotBlinkingHelpFragment.setArguments(localBundle);
      return localSubGLedNotBlinkingHelpFragment;
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(SubGLedNotBlinkingHelpFragment paramSubGLedNotBlinkingHelpFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismiss();
    }
  }
  
  static final class c
    extends Lambda
    implements l<LottieAnimationView, p>
  {
    c(SubGLedNotBlinkingHelpFragment paramSubGLedNotBlinkingHelpFragment)
    {
      super();
    }
    
    public final void a(LottieAnimationView paramLottieAnimationView)
    {
      j.e(paramLottieAnimationView, "it");
      paramLottieAnimationView.setImageAssetsFolder("images/s200b/");
      paramLottieAnimationView.setAnimation(2131886087);
      Context localContext = this.c.requireContext();
      j.d(localContext, "requireContext()");
      a.c(paramLottieAnimationView, localContext, false, 2, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGLedNotBlinkingHelpFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */