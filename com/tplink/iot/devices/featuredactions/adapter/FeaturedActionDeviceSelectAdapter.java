package com.tplink.iot.devices.featuredactions.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.z0.n;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.model.iot.c;
import com.tplink.iot.view.firmware.FirmwareSlideActivity;
import com.tplink.iot.view.wss.WssAmazonInstrWebActivity;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class FeaturedActionDeviceSelectAdapter
  extends GeneralAdapter<c>
{
  private kotlin.jvm.b.l<? super Boolean, p> d;
  private final c e = new c();
  
  public FeaturedActionDeviceSelectAdapter(Context paramContext)
  {
    super(paramContext, null, 2, null);
  }
  
  private final void E(GeneralAdapter.GeneralVH paramGeneralVH, final c paramc, final int paramInt)
  {
    Object localObject1 = paramc.a();
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((com.tplink.iot.g.a.a.b)localObject1).a();
      if (localObject1 != null)
      {
        localObject2 = r();
        localObject3 = G(paramGeneralVH);
        j.c(localObject3);
        com.tplink.iot.Utils.z0.l.p((Context)localObject2, (BaseALIoTDevice)localObject1, (ImageView)localObject3);
        localObject3 = K(paramGeneralVH);
        if (localObject3 != null) {
          ((TextView)localObject3).setText(com.tplink.iot.Utils.z0.l.c(r(), (BaseALIoTDevice)localObject1));
        }
      }
    }
    localObject1 = paramc.a();
    int i;
    if ((localObject1 != null) && (((com.tplink.iot.g.a.a.b)localObject1).c() == true)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = paramc.a();
    int j;
    if ((localObject1 != null) && (((com.tplink.iot.g.a.a.b)localObject1).b() == true)) {
      j = 1;
    } else {
      j = 0;
    }
    localObject1 = null;
    if (i != 0)
    {
      localObject3 = r();
      localObject2 = paramc.a();
      if (localObject2 != null) {
        localObject1 = ((com.tplink.iot.g.a.a.b)localObject2).a();
      }
      localObject3 = com.tplink.iot.Utils.z0.l.b((Context)localObject3, (BaseALIoTDevice)localObject1);
      localObject1 = L(paramGeneralVH);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText((CharSequence)localObject3);
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          i = 8;
        } else {
          i = 0;
        }
        ((View)localObject1).setVisibility(i);
      }
      localObject1 = H(paramGeneralVH);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        if (paramc.f()) {
          i = 2131689721;
        } else {
          i = 2131689722;
        }
        ((ImageView)localObject1).setImageResource(i);
      }
      localObject1 = F(paramGeneralVH);
      if (localObject1 != null) {
        ViewKt.setVisible((View)localObject1, true);
      }
      localObject1 = I(paramGeneralVH);
      if (localObject1 != null) {
        ViewKt.setVisible((View)localObject1, false);
      }
      paramGeneralVH = paramGeneralVH.itemView;
      paramGeneralVH.setEnabled(true);
      paramGeneralVH.setAlpha(1.0F);
      paramGeneralVH.setOnClickListener(new a(this, paramc, paramInt));
    }
    else if ((i == 0) && (j != 0))
    {
      paramc = L(paramGeneralVH);
      if (paramc != null)
      {
        paramc.setVisibility(0);
        paramc.setText(2131953697);
      }
      paramc = F(paramGeneralVH);
      if (paramc != null) {
        ViewKt.setVisible(paramc, true);
      }
      paramc = I(paramGeneralVH);
      if (paramc != null) {
        ViewKt.setVisible(paramc, true);
      }
      paramc = H(paramGeneralVH);
      if (paramc != null) {
        ViewKt.setVisible(paramc, false);
      }
      paramGeneralVH = paramGeneralVH.itemView;
      paramGeneralVH.setEnabled(true);
      paramGeneralVH.setAlpha(1.0F);
      paramGeneralVH.setOnClickListener(new b(this));
    }
    else
    {
      paramc = L(paramGeneralVH);
      if (paramc != null)
      {
        paramc.setVisibility(0);
        paramc.setText(2131953697);
      }
      paramc = F(paramGeneralVH);
      if (paramc != null) {
        ViewKt.setVisible(paramc, false);
      }
      paramGeneralVH = paramGeneralVH.itemView;
      paramGeneralVH.setEnabled(false);
      paramGeneralVH.setAlpha(0.5F);
      paramGeneralVH.setOnClickListener(null);
    }
  }
  
  private final View F(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return paramGeneralVH.c(2131362664);
  }
  
  private final ImageView G(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return (ImageView)paramGeneralVH.c(2131363028);
  }
  
  private final ImageView H(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return (ImageView)paramGeneralVH.c(2131363030);
  }
  
  private final View I(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return paramGeneralVH.c(2131363287);
  }
  
  private final TextView K(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return (TextView)paramGeneralVH.c(2131364409);
  }
  
  private final TextView L(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return (TextView)paramGeneralVH.c(2131364655);
  }
  
  private final void M()
  {
    FirmwareSlideActivity.q1(r(), "FeaturedActionHostActivity");
  }
  
  private final void N()
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      Object localObject2 = s();
      boolean bool = localObject2 instanceof Collection;
      int i = 0;
      int j;
      if ((bool) && (((Collection)localObject2).isEmpty()))
      {
        j = i;
      }
      else
      {
        localObject2 = ((Iterable)localObject2).iterator();
        do
        {
          j = i;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (!((c)((Iterator)localObject2).next()).f());
        j = 1;
      }
      localObject1 = (p)((kotlin.jvm.b.l)localObject1).invoke(Boolean.valueOf(j ^ 0x1));
    }
  }
  
  private final void P(TextView paramTextView, final com.tplink.iot.model.iot.b paramb)
  {
    d0.h(paramTextView, r().getString(2131954500), ContextCompat.getColor(r(), 2131099811), new d(this, paramb));
  }
  
  public void D(GeneralAdapter.GeneralVH paramGeneralVH, c paramc, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(paramc, "data");
    int i = paramc.d();
    if (i != 1)
    {
      if (i != 2)
      {
        paramGeneralVH.d(2131364636, paramc.c());
      }
      else
      {
        paramc = paramc.b();
        if (paramc != null)
        {
          paramGeneralVH.d(2131364409, paramc.c());
          ImageView localImageView = (ImageView)paramGeneralVH.c(2131363028);
          if (localImageView != null) {
            localImageView.setImageResource(paramc.b());
          }
          paramGeneralVH = (TextView)paramGeneralVH.c(2131364456);
          if (paramGeneralVH != null) {
            P(paramGeneralVH, paramc);
          }
        }
      }
    }
    else {
      E(paramGeneralVH, paramc, paramInt);
    }
  }
  
  public final List<BaseALIoTDevice<?>> J()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = s();
    Object localObject2 = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = ((Iterator)localObject1).next();
      c localc = (c)localObject3;
      int i;
      if ((localc.e()) && (localc.f())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        ((Collection)localObject2).add(localObject3);
      }
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((c)((Iterator)localObject2).next()).a();
      if (localObject1 != null)
      {
        localObject1 = ((com.tplink.iot.g.a.a.b)localObject1).a();
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
    }
    return localArrayList;
  }
  
  public final void O(List<com.tplink.iot.g.a.a.b> paramList, List<com.tplink.iot.model.iot.b> paramList1)
  {
    j.e(paramList, "deviceList");
    j.e(paramList1, "devicePlaceholders");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1 = paramList.iterator();
    int i;
    Object localObject2;
    for (;;)
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      i = 0;
      j = 0;
      if (!bool) {
        break;
      }
      localObject2 = (com.tplink.iot.g.a.a.b)((Iterator)localObject1).next();
      String str = ((com.tplink.iot.g.a.a.b)localObject2).a().getCategory();
      if (str != null)
      {
        i = j;
        if (str.length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0)
      {
        localObject3 = localLinkedHashMap.get(str);
        paramList = (List<com.tplink.iot.g.a.a.b>)localObject3;
        if (localObject3 == null)
        {
          paramList = new ArrayList();
          localLinkedHashMap.put(str, paramList);
        }
        ((List)paramList).add(new c((com.tplink.iot.g.a.a.b)localObject2));
      }
    }
    paramList = EnumIoTCategory.values();
    Object localObject3 = new ArrayList(paramList.length);
    int j = paramList.length;
    while (i < j)
    {
      ((Collection)localObject3).add(paramList[i].value());
      i++;
    }
    paramList = new ArrayList();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (String)((Iterator)localObject3).next();
      localObject1 = EnumIoTCategory.fromString((String)localObject2);
      if (localObject1 != null)
      {
        j.d(localObject1, "EnumIoTCategory.fromString(category) ?: continue");
        localObject2 = (List)localLinkedHashMap.get(localObject2);
        if (localObject2 != null)
        {
          paramList.add(new c(n.d((EnumIoTCategory)localObject1)));
          kotlin.collections.l.o((List)localObject2, this.e);
          paramList.addAll((Collection)localObject2);
        }
      }
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      localObject3 = (com.tplink.iot.model.iot.b)paramList1.next();
      paramList.add(new c(n.d(((com.tplink.iot.model.iot.b)localObject3).a())));
      paramList.add(new c((com.tplink.iot.model.iot.b)localObject3));
    }
    y(paramList);
  }
  
  public final void Q(kotlin.jvm.b.l<? super Boolean, p> paraml)
  {
    j.e(paraml, "onChange");
    this.d = paraml;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((c)s().get(paramInt)).d();
  }
  
  public int p(int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 2131559032;
    } else if (paramInt == 2) {
      paramInt = 2131559022;
    } else {
      paramInt = 2131559217;
    }
    return paramInt;
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(FeaturedActionDeviceSelectAdapter paramFeaturedActionDeviceSelectAdapter, c paramc, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = paramc;
      paramView.g(paramView.f() ^ true);
      this.c.z(paramInt, paramc);
      FeaturedActionDeviceSelectAdapter.C(this.c);
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(FeaturedActionDeviceSelectAdapter paramFeaturedActionDeviceSelectAdapter) {}
    
    public final void onClick(View paramView)
    {
      FeaturedActionDeviceSelectAdapter.B(this.c);
    }
  }
  
  public static final class c
    implements Comparator<c>
  {
    public int a(c paramc1, c paramc2)
    {
      int i = 1;
      if (paramc1 != null)
      {
        paramc1 = paramc1.a();
        if (paramc1 != null)
        {
          if (paramc2 != null)
          {
            paramc2 = paramc2.a();
            if (paramc2 != null)
            {
              if (paramc1.c()) {
                if (!paramc2.c()) {}
              }
              do
              {
                for (;;)
                {
                  i = 0;
                  break label96;
                  do
                  {
                    i = -1;
                    break label96;
                    if (!paramc1.b()) {
                      break;
                    }
                    if (paramc2.c()) {
                      break label96;
                    }
                  } while (!paramc2.b());
                }
              } while ((!paramc2.c()) && (!paramc2.b()));
              label96:
              return i;
            }
          }
          return -1;
        }
      }
      return 1;
    }
  }
  
  static final class d
    implements d0.g
  {
    d(FeaturedActionDeviceSelectAdapter paramFeaturedActionDeviceSelectAdapter, com.tplink.iot.model.iot.b paramb) {}
    
    public final void a()
    {
      WssAmazonInstrWebActivity.l1(FeaturedActionDeviceSelectAdapter.A(this.a), paramb.d());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\adapter\FeaturedActionDeviceSelectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */