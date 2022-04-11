package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.q.b.p.b.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.request.g;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocationSettingAdapter
  extends RecyclerView.Adapter<a>
{
  private int[] a;
  private int[] b;
  private boolean[] c;
  private List<b.c> d;
  private b e;
  private Activity f;
  private boolean g;
  private int h;
  private boolean i;
  
  public LocationSettingAdapter(Activity paramActivity, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[23];
    int[] tmp10_9 = arrayOfInt;
    tmp10_9[0] = 2131953273;
    int[] tmp15_10 = tmp10_9;
    tmp15_10[1] = 2131953274;
    int[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 2131953275;
    int[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 2131953276;
    int[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 2131953277;
    int[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 2131953278;
    int[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 2131953279;
    int[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 2131953280;
    int[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 2131953281;
    int[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 2131953282;
    int[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 2131953283;
    int[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 2131953284;
    int[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 2131953286;
    int[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 2131953287;
    int[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 2131953288;
    int[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 2131953289;
    int[] tmp100_94 = tmp94_88;
    tmp100_94[16] = 2131953290;
    int[] tmp106_100 = tmp100_94;
    tmp106_100[17] = 2131953291;
    int[] tmp112_106 = tmp106_100;
    tmp112_106[18] = 2131953292;
    int[] tmp118_112 = tmp112_106;
    tmp118_112[19] = 2131953293;
    int[] tmp124_118 = tmp118_112;
    tmp124_118[20] = 2131953294;
    int[] tmp130_124 = tmp124_118;
    tmp130_124[21] = 2131953296;
    int[] tmp136_130 = tmp130_124;
    tmp136_130[22] = 2131953297;
    tmp136_130;
    this.a = arrayOfInt;
    this.b = new int[] { 2131689498, 2131690437, 2131689502, 2131689505, 2131689564, 2131689582, 2131689638, 2131689641, 2131689662, 2131689671, 2131689678, 2131689687, 2131690018, 2131690113, 2131690165, 2131690232, 2131690238, 2131690348, 2131690369, 2131690404, 2131690415, 2131690447, 2131690460 };
    this.c = new boolean[arrayOfInt.length];
    this.d = new ArrayList();
    this.h = -1;
    this.i = false;
    this.f = paramActivity;
    this.i = paramBoolean;
    q();
  }
  
  private void q()
  {
    for (int j = 0;; j++)
    {
      boolean[] arrayOfBoolean = this.c;
      if (j >= arrayOfBoolean.length) {
        break;
      }
      arrayOfBoolean[j] = false;
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.a.length + this.d.size();
  }
  
  public String n(int paramInt)
  {
    if (s(paramInt)) {
      return ((b.c)this.d.get(paramInt)).b().replace(".png", "");
    }
    return z4.b(this.f, paramInt - this.d.size());
  }
  
  String o(int paramInt)
  {
    if (s(paramInt)) {
      return ((b.c)this.d.get(paramInt)).c();
    }
    return "";
  }
  
  public int p()
  {
    for (int j = 0;; j++)
    {
      boolean[] arrayOfBoolean = this.c;
      if (j >= arrayOfBoolean.length) {
        break;
      }
      if (arrayOfBoolean[j] != 0) {
        return j;
      }
    }
    return -1;
  }
  
  public boolean r(int paramInt)
  {
    int j = getItemCount();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramInt < j)
    {
      bool2 = bool1;
      if (paramInt >= 0) {
        if (s(paramInt))
        {
          bool2 = bool1;
        }
        else
        {
          j = this.d.size();
          bool2 = bool1;
          if (this.b[(paramInt - j)] == 2131689498) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean s(int paramInt)
  {
    boolean bool;
    if (paramInt < this.d.size()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void t(a parama, int paramInt)
  {
    int j = this.d.size();
    int k = 0;
    if (paramInt < j)
    {
      b.c localc = (b.c)this.d.get(paramInt);
      Object localObject = new g();
      ((g)((com.bumptech.glide.request.a)localObject).f0(new com.tplink.iot.Utils.y0.c())).c0(new c(String.valueOf(localc.d())));
      com.bumptech.glide.c.t(this.f).s(localc.c()).m0((com.bumptech.glide.request.a)localObject).x0(a.c(parama));
      a.c(parama).setSelected(this.c[paramInt]);
      a.d(parama).setText(localc.b().replace(".png", ""));
      localObject = a.e(parama);
      if (this.g) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      ((ImageView)localObject).setVisibility(paramInt);
    }
    else
    {
      j = paramInt - this.d.size();
      a.c(parama).setImageResource(this.b[j]);
      a.c(parama).setSelected(this.c[paramInt]);
      a.d(parama).setText(this.a[j]);
      a.e(parama).setVisibility(8);
      if (this.h == paramInt) {
        a.c(parama).setBackground(this.f.getResources().getDrawable(2131231313));
      } else {
        a.c(parama).setBackgroundColor(this.f.getResources().getColor(2131100206));
      }
    }
    parama = a.d(parama);
    paramInt = k;
    if (this.i) {
      paramInt = 8;
    }
    parama.setVisibility(paramInt);
  }
  
  public a u(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559079, paramViewGroup, false));
  }
  
  public void v(b paramb)
  {
    this.e = paramb;
  }
  
  public void w(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      z4.e(this.f);
      for (int j = 0;; j++)
      {
        Object localObject = this.a;
        if (j >= localObject.length) {
          break;
        }
        if (paramString.equals(this.f.getString(localObject[j])))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("selected location index is: ");
          ((StringBuilder)localObject).append(j);
          b.d.w.c.a.e("LocationSettingAdapter", ((StringBuilder)localObject).toString());
          x(j);
        }
      }
      z4.d(this.f);
    }
  }
  
  public void x(int paramInt)
  {
    boolean[] arrayOfBoolean;
    for (int j = 0;; j++)
    {
      arrayOfBoolean = this.c;
      if (j >= arrayOfBoolean.length) {
        break;
      }
      if (arrayOfBoolean[j] != 0) {
        break label30;
      }
    }
    j = 0;
    label30:
    arrayOfBoolean[j] = false;
    arrayOfBoolean[paramInt] = true;
    this.h = paramInt;
    notifyItemChanged(j);
    notifyItemChanged(paramInt);
  }
  
  class a
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private View c;
    private TextView d;
    private ImageView f;
    private ImageView q;
    
    a(View paramView)
    {
      super();
      this.c = paramView.findViewById(2131362958);
      this.d = ((TextView)paramView.findViewById(2131362959));
      this.f = ((ImageView)paramView.findViewById(2131362957));
      this$1 = (ImageView)paramView.findViewById(2131362903);
      this.q = LocationSettingAdapter.this;
      LocationSettingAdapter.this.setOnClickListener(this);
      this.c.setOnClickListener(this);
    }
    
    public void onClick(View paramView)
    {
      int i = paramView.getId();
      int j = getAdapterPosition();
      if (i == 2131362958) {
        LocationSettingAdapter.this.x(j);
      }
      if (LocationSettingAdapter.m(LocationSettingAdapter.this) != null) {
        LocationSettingAdapter.m(LocationSettingAdapter.this).a(paramView, j);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt);
  }
  
  public class c
    implements com.bumptech.glide.load.c
  {
    private final String b;
    
    public c(String paramString)
    {
      Objects.requireNonNull(paramString, "Signature cannot be null!");
      this.b = paramString;
    }
    
    public void b(MessageDigest paramMessageDigest)
    {
      try
      {
        paramMessageDigest.update(this.b.getBytes("UTF-8"));
      }
      catch (UnsupportedEncodingException paramMessageDigest)
      {
        paramMessageDigest.printStackTrace();
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (c.class == paramObject.getClass()))
      {
        paramObject = (c)paramObject;
        return this.b.equals(((c)paramObject).b);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.b.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StringSignature{signature='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LocationSettingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */