package com.tplink.iot.devices.lightstrip.adapter;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.ViewKt;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import com.tplink.iot.g.b.b.d;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class PredefinedEffectsAdapter
  extends LightStripEffectsBaseAdapter<d>
{
  public static final a h = new a(null);
  private boolean i = true;
  
  public PredefinedEffectsAdapter(Context paramContext, List<d> paramList, int paramInt)
  {
    super(paramContext, l.U(paramList), paramInt);
  }
  
  public void U(GeneralAdapter.GeneralVH paramGeneralVH, final d paramd, final int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(paramd, "data");
    CircleEffectImageView localCircleEffectImageView = J(paramGeneralVH);
    if (localCircleEffectImageView != null)
    {
      localCircleEffectImageView.setEnabled(this.i);
      localCircleEffectImageView.setImageResource(paramd.d());
      if (paramd.a() != localCircleEffectImageView.isSelected()) {
        localCircleEffectImageView.j(paramd.a(), O());
      }
      localCircleEffectImageView.setOnClickListener(new b(this, paramd, paramInt));
    }
    paramGeneralVH = N(paramGeneralVH);
    if (paramGeneralVH != null) {
      paramGeneralVH.setText(paramd.h());
    }
  }
  
  protected void V(d paramd, boolean paramBoolean)
  {
    j.e(paramd, "data");
    paramd.b(paramBoolean);
  }
  
  protected String W(d paramd)
  {
    j.e(paramd, "data");
    if (paramd.i()) {
      paramd = "PredefinedEffect_Daylight";
    } else {
      paramd = paramd.f();
    }
    return paramd;
  }
  
  public final void X(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      D();
      this.i = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public GeneralAdapter.GeneralVH w(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = super.w(paramViewGroup, paramInt);
    Object localObject = J(paramViewGroup);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, true);
    }
    localObject = N(paramViewGroup);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, true);
    }
    return paramViewGroup;
  }
  
  public static final class a
  {
    private final String c(@StringRes int paramInt)
    {
      String str = AppContext.c.getString(paramInt);
      j.d(str, "AppContext.instance.getString(resId)");
      return str;
    }
    
    public final d a(int paramInt)
    {
      d locald = new d(c(2131952379), 2131690177, null);
      locald.j(true);
      locald.k(new LightStateBean(0, 0, paramInt, 100));
      return locald;
    }
    
    public final d b(String paramString)
    {
      if (paramString != null) {
        switch (paramString.hashCode())
        {
        default: 
          break;
        case 2138818352: 
          if (paramString.equals("Haunted Mansion")) {
            paramString = new d(c(2131952935), 2131690181, null, 4, null);
          }
          break;
        case 1972453248: 
          if (paramString.equals("Aurora")) {
            paramString = new d(c(2131952928), 2131690173, null, 4, null);
          }
          break;
        case 1557237721: 
          if (paramString.equals("Bubbling Cauldron")) {
            paramString = new d(c(2131952929), 2131690174, null, 4, null);
          }
          break;
        case 1235317602: 
          if (paramString.equals("Christmas")) {
            paramString = new d(c(2131952931), 2131690176, null, 4, null);
          }
          break;
        case 976509360: 
          if (paramString.equals("Candy Cane")) {
            paramString = new d(c(2131952930), 2131690175, null, 4, null);
          }
          break;
        case 892721624: 
          if (paramString.equals("Flicker")) {
            paramString = new d(c(2131952932), 2131690178, null, 4, null);
          }
          break;
        case 180810915: 
          if (paramString.equals("Raindrop")) {
            paramString = new d(c(2131952941), 2131690186, null, 4, null);
          }
          break;
        case 82388519: 
          if (paramString.equals("Hanukkah")) {
            paramString = new d(c(2131952934), 2131690180, null, 4, null);
          }
          break;
        case 76007646: 
          if (paramString.equals("Ocean")) {
            paramString = new d(c(2131952939), 2131690184, null, 4, null);
          }
          break;
        case 52580783: 
          if (paramString.equals("Grandma's Christmas Lights")) {
            paramString = new d(c(2131952933), 2131690179, null, 4, null);
          }
          break;
        case -191907083: 
          if (paramString.equals("Sunrise")) {
            paramString = new d(c(2131954168), 2131690188, null, 4, null);
          }
          break;
        case -1296597539: 
          if (paramString.equals("Valentines")) {
            paramString = new d(c(2131952943), 2131690190, null, 4, null);
          }
          break;
        case -1604554070: 
          if (paramString.equals("Lightning")) {
            paramString = new d(c(2131952937), 2131690183, null, 4, null);
          }
          break;
        case -1656737386: 
          if (paramString.equals("Rainbow")) {
            paramString = new d(c(2131952940), 2131690185, null, 4, null);
          }
          break;
        case -1807305034: 
          if (paramString.equals("Sunset")) {
            paramString = new d(c(2131954171), 2131690189, null, 4, null);
          }
          break;
        case -1811812819: 
          if (paramString.equals("Spring")) {
            paramString = new d(c(2131952942), 2131690187, null, 4, null);
          }
          break;
        case -2110384051: 
          if (paramString.equals("Icicle")) {
            paramString = new d(c(2131952936), 2131690182, null, 4, null);
          }
          break;
        }
      }
      paramString = null;
      return paramString;
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(PredefinedEffectsAdapter paramPredefinedEffectsAdapter, d paramd, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.a(paramd, paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\adapter\PredefinedEffectsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */