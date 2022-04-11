package com.tplink.iot.view.ipcamera.play;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import kotlin.p;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.e;

public final class OperationShellFragment
  extends BaseFragment
{
  private final ArrayList<String> p0 = new ArrayList();
  private VideoPlayViewModel p1;
  private HashMap p2;
  private MagicIndicator q;
  private ViewPager x;
  private final ArrayList<Fragment> y = new ArrayList();
  private FragmentPagerAdapter z;
  
  private final void N0(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getString("first_operation_fragment_tag");
      int i;
      if (localObject != null)
      {
        i = ((String)localObject).hashCode();
        if (i != -989769983)
        {
          if (i != -662580069)
          {
            if ((i == 723559217) && (((String)localObject).equals("VideoPlay.CloudTerraceControlFragment")))
            {
              this.p0.add(getString(2131952349));
              localObject = this.y;
              CloudTerraceControlFragment localCloudTerraceControlFragment = new CloudTerraceControlFragment();
              Bundle localBundle = new Bundle();
              localBundle.putBoolean("cloud_terrace_feature_visible", true);
              p localp = p.a;
              localCloudTerraceControlFragment.setArguments(localBundle);
              ((ArrayList)localObject).add(localCloudTerraceControlFragment);
            }
          }
          else if (((String)localObject).equals("VideoPlay.TalkFragment"))
          {
            this.p0.add(getString(2131954400));
            this.y.add(new TalkFragment());
          }
        }
        else if (((String)localObject).equals("VideoPlay.VoiceCallFragment"))
        {
          this.p0.add(getString(2131954402));
          this.y.add(new VoiceCallFragment());
        }
      }
      paramBundle = paramBundle.getString("second_operation_fragment_tag");
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (i != 723559217)
        {
          if ((i == 768612715) && (paramBundle.equals("VideoPlay.CloudTerracePresetFragment")))
          {
            this.p0.add(getString(2131952347));
            this.y.add(new CloudTerracePresetFragment());
          }
        }
        else if (paramBundle.equals("VideoPlay.CloudTerraceControlFragment"))
        {
          this.p0.add(getString(2131952349));
          this.y.add(new CloudTerraceControlFragment());
        }
      }
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.p2;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    N0(getArguments());
    boolean bool = false;
    paramLayoutInflater = paramLayoutInflater.inflate(2131558940, paramViewGroup, false);
    ArrayList localArrayList = this.y;
    paramViewGroup = this.p0;
    paramBundle = getChildFragmentManager();
    j.d(paramBundle, "childFragmentManager");
    this.z = new g4(localArrayList, paramViewGroup, paramBundle);
    j.d(paramLayoutInflater, "rootView");
    paramBundle = (ViewPager)paramLayoutInflater.findViewById(com.tplink.iot.a.view_pager);
    j.d(paramBundle, "rootView.view_pager");
    this.x = paramBundle;
    if (paramBundle == null) {
      j.t("viewPager");
    }
    paramViewGroup = this.z;
    if (paramViewGroup == null) {
      j.t("adapter");
    }
    paramBundle.setAdapter(paramViewGroup);
    paramViewGroup = (MagicIndicator)paramLayoutInflater.findViewById(com.tplink.iot.a.magic_indicator);
    j.d(paramViewGroup, "rootView.magic_indicator");
    this.q = paramViewGroup;
    paramBundle = new CommonNavigator(getContext());
    paramBundle.setAdapter(new a(this));
    paramViewGroup = this.q;
    if (paramViewGroup == null) {
      j.t("magicIndicator");
    }
    paramViewGroup.setNavigator(paramBundle);
    if (this.p0.size() > 1) {
      bool = true;
    }
    paramBundle.setAdjustMode(bool);
    paramViewGroup = this.q;
    if (paramViewGroup == null) {
      j.t("magicIndicator");
    }
    paramBundle = this.x;
    if (paramBundle == null) {
      j.t("viewPager");
    }
    e.a(paramViewGroup, paramBundle);
    paramViewGroup = getActivity();
    j.c(paramViewGroup);
    paramViewGroup = ViewModelProviders.of(paramViewGroup).get(VideoPlayViewModel.class);
    j.d(paramViewGroup, "ViewModelProviders.of(ac…layViewModel::class.java)");
    this.p1 = ((VideoPlayViewModel)paramViewGroup);
    ((ImageView)paramLayoutInflater.findViewById(com.tplink.iot.a.back_tv)).setOnClickListener(new b(this));
    return paramLayoutInflater;
  }
  
  public static final class a
    extends net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a
  {
    a(OperationShellFragment paramOperationShellFragment) {}
    
    public int a()
    {
      return OperationShellFragment.I0(this.b).size();
    }
    
    public c b(Context paramContext)
    {
      paramContext = new LinePagerIndicator(this.b.getContext());
      paramContext.setMode(2);
      paramContext.setColors(new Integer[] { Integer.valueOf(Color.parseColor("#FF66B3FF")) });
      paramContext.setLineWidth(b.d.w.f.a.a(paramContext.getContext(), 20.0F));
      paramContext.setRoundRadius(b.d.w.f.a.a(paramContext.getContext(), 0.5F));
      return paramContext;
    }
    
    public d c(Context paramContext, final int paramInt)
    {
      paramContext = new ColorTransitionPagerTitleView(paramContext);
      paramContext.setNormalColor(Color.parseColor("#66666666"));
      paramContext.setSelectedColor(Color.parseColor("#FF66B3FF"));
      paramContext.setText((CharSequence)OperationShellFragment.J0(this.b).get(paramInt));
      paramContext.setTextSize(15.0F);
      paramContext.setOnClickListener(new a(this, paramInt));
      return paramContext;
    }
    
    static final class a
      implements View.OnClickListener
    {
      a(OperationShellFragment.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        OperationShellFragment.L0(this.c.b).setCurrentItem(paramInt);
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(OperationShellFragment paramOperationShellFragment) {}
    
    public final void onClick(View paramView)
    {
      OperationShellFragment.K0(this.c).y("VideoPlay.VideoControlPanelFragment");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\OperationShellFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */