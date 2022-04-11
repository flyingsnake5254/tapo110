package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.adapter.widget.ColorLightEffectAdapter;
import com.tplink.iot.adapter.widget.ColorLightEffectAdapter.c;
import com.tplink.iot.widget.dialog.LightEffectColorEditDialog;
import com.tplink.iot.widget.dialog.LightEffectColorEditDialog.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.ArrayList;
import java.util.List;

public class ColorLightEffectView
  extends LinearLayout
  implements ColorLightEffectAdapter.c, LightEffectColorEditDialog.a
{
  private RecyclerView c;
  private List<LightStateBean> d = new ArrayList();
  private ColorLightEffectAdapter f;
  private FragmentManager q;
  private LightEffectColorEditDialog x;
  
  public ColorLightEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorLightEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorLightEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559410, this, true);
    paramAttributeSet = (RecyclerView)findViewById(2131363820);
    this.c = paramAttributeSet;
    paramAttributeSet.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    paramContext = new ColorLightEffectAdapter(paramContext, this.d);
    this.f = paramContext;
    paramContext.p(this);
    this.c.setAdapter(this.f);
  }
  
  private void c(boolean paramBoolean, int paramInt, LightStateBean paramLightStateBean)
  {
    if (this.q != null)
    {
      LightEffectColorEditDialog localLightEffectColorEditDialog = this.x;
      if ((localLightEffectColorEditDialog == null) || (!localLightEffectColorEditDialog.isVisible()))
      {
        paramLightStateBean = LightEffectColorEditDialog.G0(paramBoolean ^ true, paramInt, paramLightStateBean);
        this.x = paramLightStateBean;
        paramLightStateBean.H0(this);
        this.x.show(this.q, null);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      c(true, 0, null);
    } else {
      c(false, paramInt, (LightStateBean)this.d.get(paramInt));
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt < this.d.size())
    {
      this.d.remove(paramInt);
      this.f.notifyDataSetChanged();
    }
  }
  
  public void g(int paramInt, LightStateBean paramLightStateBean)
  {
    if (paramInt < this.d.size())
    {
      LightStateBean localLightStateBean = (LightStateBean)this.d.get(paramInt);
      localLightStateBean.setColorTemp(paramLightStateBean.getColorTemp());
      localLightStateBean.setHue(paramLightStateBean.getHue());
      localLightStateBean.setSaturation(paramLightStateBean.getSaturation());
      this.f.notifyDataSetChanged();
    }
  }
  
  public List<LightStateBean> getColorStatusList()
  {
    return this.d;
  }
  
  public void h(LightStateBean paramLightStateBean)
  {
    this.d.add(paramLightStateBean);
    this.f.notifyDataSetChanged();
  }
  
  public void setFragmentManager(FragmentManager paramFragmentManager)
  {
    this.q = paramFragmentManager;
  }
  
  public void setLightEffectList(List<LightStateBean> paramList)
  {
    if (paramList != null)
    {
      this.d.clear();
      this.d.addAll(paramList);
      this.f.notifyDataSetChanged();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorLightEffectView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */