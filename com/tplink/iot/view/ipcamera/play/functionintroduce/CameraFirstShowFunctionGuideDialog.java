package com.tplink.iot.view.ipcamera.play.functionintroduce;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

public class CameraFirstShowFunctionGuideDialog
  extends BaseBottomSheetDialogFragment
  implements View.OnClickListener
{
  public static final String c = CameraFirstShowFunctionGuideDialog.class.getName();
  private d H3;
  private DeviceCloudProduct I3;
  private boolean J3 = true;
  private boolean K3 = false;
  private ImageView d;
  private TextView f;
  private LinearLayout p0;
  private LinearLayout p1;
  private Button p2;
  private String p3;
  private TextView q;
  private TextView x;
  private ViewPager2 y;
  private LinearLayout z;
  
  private String Q0(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "";
          }
          return "Tapo Care";
        }
        return "Event Alerts";
      }
      return "Activity Zones";
    }
    return "Realtime Call";
  }
  
  private String R0(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "";
            }
            return "Tapo Care";
          }
          return "Event Alerts";
        }
        return "Activity Zones";
      }
      return "Look Around";
    }
    return "Realtime Call";
  }
  
  private String S0(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "";
            }
            return "Tapo Care";
          }
          return "Intruders Beware";
        }
        return "Activity Zones";
      }
      return "Person Detection";
    }
    return "Event Alerts";
  }
  
  private String T0(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "";
              }
              return "Tapo Care";
            }
            return "Activity Zones";
          }
          return "Person Detection";
        }
        return "Smart Night Vision Mode";
      }
      return "Full Color Sight At Night";
    }
    return "Event Alerts";
  }
  
  private int U0(DeviceModel paramDeviceModel)
  {
    if (c.t(paramDeviceModel)) {
      return 2131690382;
    }
    if (c.u(paramDeviceModel)) {
      return 2131690383;
    }
    if (c.v(paramDeviceModel)) {
      return 2131690384;
    }
    return 2131690383;
  }
  
  private List<CameraIntroduceVideoPlayItemFragment> V0(DeviceModel paramDeviceModel)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = c.t(paramDeviceModel);
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject1;
    Object localObject2;
    if (bool) {
      while (n < 4)
      {
        localObject1 = new CameraIntroduceVideoPlayItemFragment();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putSerializable("CAMERA_CURRENT_MODEL", paramDeviceModel);
        ((Bundle)localObject2).putString("CAMERA_DEVICEIDMD5", this.p3);
        ((Bundle)localObject2).putString("title", Q0(n));
        ((Fragment)localObject1).setArguments((Bundle)localObject2);
        localArrayList.add(localObject1);
        n++;
      }
    }
    if (c.u(paramDeviceModel)) {
      for (n = i; n < 5; n++)
      {
        localObject1 = new CameraIntroduceVideoPlayItemFragment();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putSerializable("CAMERA_CURRENT_MODEL", paramDeviceModel);
        ((Bundle)localObject2).putString("CAMERA_DEVICEIDMD5", this.p3);
        ((Bundle)localObject2).putString("title", R0(n));
        ((Fragment)localObject1).setArguments((Bundle)localObject2);
        localArrayList.add(localObject1);
      }
    }
    n = m;
    if (DeviceModel.CAMERA_C310 != paramDeviceModel) {
      if (DeviceModel.CAMERA_TC65 == paramDeviceModel)
      {
        n = m;
      }
      else
      {
        n = k;
        if (paramDeviceModel == DeviceModel.CAMERA_C320WS) {
          for (n = j; n < 6; n++)
          {
            localObject1 = new CameraIntroduceVideoPlayItemFragment();
            localObject2 = new Bundle();
            ((Bundle)localObject2).putSerializable("CAMERA_CURRENT_MODEL", paramDeviceModel);
            ((Bundle)localObject2).putString("CAMERA_DEVICEIDMD5", this.p3);
            ((Bundle)localObject2).putString("title", T0(n));
            ((Fragment)localObject1).setArguments((Bundle)localObject2);
            localArrayList.add(localObject1);
          }
        }
        while (n < 5)
        {
          localObject2 = new CameraIntroduceVideoPlayItemFragment();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putSerializable("CAMERA_CURRENT_MODEL", paramDeviceModel);
          ((Bundle)localObject1).putString("CAMERA_DEVICEIDMD5", this.p3);
          ((Bundle)localObject1).putString("title", R0(n));
          ((Fragment)localObject2).setArguments((Bundle)localObject1);
          localArrayList.add(localObject2);
          n++;
        }
      }
    }
    while (n < 5)
    {
      localObject2 = new CameraIntroduceVideoPlayItemFragment();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putSerializable("CAMERA_CURRENT_MODEL", paramDeviceModel);
      ((Bundle)localObject1).putString("CAMERA_DEVICEIDMD5", this.p3);
      ((Bundle)localObject1).putString("title", S0(n));
      ((Fragment)localObject2).setArguments((Bundle)localObject1);
      localArrayList.add(localObject2);
      n++;
    }
    return localArrayList;
  }
  
  public static CameraFirstShowFunctionGuideDialog X0(DeviceModel paramDeviceModel, String paramString, d paramd)
  {
    CameraFirstShowFunctionGuideDialog localCameraFirstShowFunctionGuideDialog = new CameraFirstShowFunctionGuideDialog();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("CAMERA_CURRENT_MODEL", paramDeviceModel);
    localBundle.putString("CAMERA_DEVICEIDMD5", paramString);
    localCameraFirstShowFunctionGuideDialog.setArguments(localBundle);
    localCameraFirstShowFunctionGuideDialog.a1(paramd);
    return localCameraFirstShowFunctionGuideDialog;
  }
  
  private void Y0(int paramInt)
  {
    for (int i = 0; i < this.z.getChildCount(); i++) {
      this.z.getChildAt(i).setBackground(getContext().getDrawable(2131231071));
    }
    this.z.getChildAt(paramInt).setBackground(getContext().getDrawable(2131231096));
  }
  
  private void Z0(List<CameraIntroduceVideoPlayItemFragment> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (i == 0) {
        localLayoutParams.setMargins(0, 0, 8, 0);
      } else {
        localLayoutParams.setMargins(8, 0, 8, 0);
      }
      localImageView.setBackground(getContext().getDrawable(2131231071));
      this.z.addView(localImageView, localLayoutParams);
    }
  }
  
  protected int A0()
  {
    return 2131558775;
  }
  
  protected void B0(View paramView)
  {
    setCancelable(false);
    final Object localObject = (TextView)paramView.findViewById(2131362562);
    this.f = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    localObject = (TextView)paramView.findViewById(2131364646);
    this.q = ((TextView)localObject);
    ((TextView)localObject).setText(String.format(getActivity().getString(2131954233), new Object[] { "30" }));
    this.q.setOnClickListener(this);
    localObject = (TextView)paramView.findViewById(2131362058);
    this.x = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    this.x.getPaint().setFlags(8);
    this.y = ((ViewPager2)paramView.findViewById(2131362713));
    this.z = ((LinearLayout)paramView.findViewById(2131363683));
    this.p1 = ((LinearLayout)paramView.findViewById(2131362712));
    this.p0 = ((LinearLayout)paramView.findViewById(2131362714));
    localObject = (Button)paramView.findViewById(2131362065);
    this.p2 = ((Button)localObject);
    ((Button)localObject).setOnClickListener(this);
    this.d = ((ImageView)paramView.findViewById(2131364838));
    localObject = getArguments();
    if (localObject != null)
    {
      paramView = (DeviceModel)((Bundle)localObject).getSerializable("CAMERA_CURRENT_MODEL");
      this.p3 = ((Bundle)localObject).getString("CAMERA_DEVICEIDMD5");
    }
    else
    {
      paramView = null;
    }
    localObject = V0(paramView);
    if (!h.D(this.p3))
    {
      ((List)localObject).remove(((List)localObject).size() - 1);
      this.J3 = false;
    }
    this.d.setImageResource(U0(paramView));
    Z0((List)localObject);
    paramView = new CameraIntroduceVideoPlayPager2Adapter(getChildFragmentManager(), getLifecycle(), (List)localObject);
    this.y.setAdapter(paramView);
    paramView = this.y.getChildAt(0);
    if ((paramView != null) && ((paramView instanceof RecyclerView))) {
      paramView.setOverScrollMode(2);
    }
    this.y.registerOnPageChangeCallback(new a((List)localObject));
  }
  
  @SuppressLint({"CheckResult"})
  public q<DeviceCloudProduct> P0(String paramString)
  {
    return h.i(paramString, false).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new c());
  }
  
  public int W0()
  {
    DeviceCloudProduct localDeviceCloudProduct = this.I3;
    if (localDeviceCloudProduct == null) {
      return 8;
    }
    if (localDeviceCloudProduct.getTrialQualified()) {
      return 0;
    }
    return 8;
  }
  
  public void a1(d paramd)
  {
    this.H3 = paramd;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364646: 
      TrialDialogActivity.f1(getActivity(), e.k(h.j(this.p3)));
      break;
    case 2131362065: 
      this.p0.setVisibility(8);
      this.p1.setVisibility(0);
      break;
    case 2131362058: 
    case 2131362562: 
      C0();
      paramView = this.H3;
      if (paramView != null) {
        paramView.onFinish();
      }
      break;
    }
  }
  
  @SuppressLint({"CheckResult"})
  public void onResume()
  {
    super.onResume();
    P0(this.p3).G0(new b());
  }
  
  class a
    extends ViewPager2.OnPageChangeCallback
  {
    a(List paramList) {}
    
    public void onPageSelected(int paramInt)
    {
      super.onPageSelected(paramInt);
      CameraFirstShowFunctionGuideDialog.G0(CameraFirstShowFunctionGuideDialog.this, paramInt + 1);
      int i = localObject.size();
      int j = 4;
      int k = 0;
      if (paramInt == i - 1)
      {
        CameraFirstShowFunctionGuideDialog.H0(CameraFirstShowFunctionGuideDialog.this).setVisibility(0);
        if (CameraFirstShowFunctionGuideDialog.I0(CameraFirstShowFunctionGuideDialog.this))
        {
          CameraFirstShowFunctionGuideDialog.J0(CameraFirstShowFunctionGuideDialog.this).setVisibility(CameraFirstShowFunctionGuideDialog.this.W0());
          TextView localTextView = CameraFirstShowFunctionGuideDialog.K0(CameraFirstShowFunctionGuideDialog.this);
          if (CameraFirstShowFunctionGuideDialog.this.W0() == 8) {
            paramInt = j;
          } else {
            paramInt = 0;
          }
          localTextView.setVisibility(paramInt);
          localTextView = CameraFirstShowFunctionGuideDialog.H0(CameraFirstShowFunctionGuideDialog.this);
          if (CameraFirstShowFunctionGuideDialog.this.W0() == 8) {
            paramInt = k;
          } else {
            paramInt = 8;
          }
          localTextView.setVisibility(paramInt);
          CameraFirstShowFunctionGuideDialog.N0(CameraFirstShowFunctionGuideDialog.this, true);
        }
      }
      else
      {
        CameraFirstShowFunctionGuideDialog.H0(CameraFirstShowFunctionGuideDialog.this).setVisibility(8);
        CameraFirstShowFunctionGuideDialog.J0(CameraFirstShowFunctionGuideDialog.this).setVisibility(4);
        CameraFirstShowFunctionGuideDialog.K0(CameraFirstShowFunctionGuideDialog.this).setVisibility(4);
        CameraFirstShowFunctionGuideDialog.N0(CameraFirstShowFunctionGuideDialog.this, false);
      }
    }
  }
  
  class b
    implements g<DeviceCloudProduct>
  {
    b() {}
    
    public void a(DeviceCloudProduct paramDeviceCloudProduct)
      throws Exception
    {
      boolean bool = CameraFirstShowFunctionGuideDialog.I0(CameraFirstShowFunctionGuideDialog.this);
      int i = 4;
      if ((bool) && (CameraFirstShowFunctionGuideDialog.L0(CameraFirstShowFunctionGuideDialog.this)))
      {
        CameraFirstShowFunctionGuideDialog.J0(CameraFirstShowFunctionGuideDialog.this).setVisibility(CameraFirstShowFunctionGuideDialog.this.W0());
        paramDeviceCloudProduct = CameraFirstShowFunctionGuideDialog.K0(CameraFirstShowFunctionGuideDialog.this);
        int j = CameraFirstShowFunctionGuideDialog.this.W0();
        int k = 0;
        if (j != 8) {
          i = 0;
        }
        paramDeviceCloudProduct.setVisibility(i);
        paramDeviceCloudProduct = CameraFirstShowFunctionGuideDialog.H0(CameraFirstShowFunctionGuideDialog.this);
        if (CameraFirstShowFunctionGuideDialog.this.W0() == 8) {
          i = k;
        } else {
          i = 8;
        }
        paramDeviceCloudProduct.setVisibility(i);
      }
      else
      {
        CameraFirstShowFunctionGuideDialog.J0(CameraFirstShowFunctionGuideDialog.this).setVisibility(4);
        CameraFirstShowFunctionGuideDialog.K0(CameraFirstShowFunctionGuideDialog.this).setVisibility(4);
      }
    }
  }
  
  class c
    implements g<DeviceCloudProduct>
  {
    c() {}
    
    public void a(DeviceCloudProduct paramDeviceCloudProduct)
      throws Exception
    {
      CameraFirstShowFunctionGuideDialog.O0(CameraFirstShowFunctionGuideDialog.this, paramDeviceCloudProduct);
    }
  }
  
  public static abstract interface d
  {
    public abstract void onFinish();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\functionintroduce\CameraFirstShowFunctionGuideDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */