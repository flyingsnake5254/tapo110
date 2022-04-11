package com.tplink.iot.dailysummary.view.adapter;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.tplink.iot.dailysummary.model.SummaryClipItem;
import com.tplink.iot.dailysummary.network.bean.common.SummaryImage;
import com.tplink.iot.e.a.d;

public final class a
{
  public static final a a = new a();
  
  @BindingAdapter({"summary_clip"})
  public static final void a(ImageView paramImageView, SummaryClipItem paramSummaryClipItem)
  {
    kotlin.jvm.internal.j.e(paramImageView, "view");
    if (paramSummaryClipItem != null) {
      ((h)((h)c.u(paramImageView.getContext()).r(new com.tplink.iot.e.a.b(paramSummaryClipItem)).f(com.bumptech.glide.load.engine.j.a)).c()).x0(paramImageView);
    }
  }
  
  @BindingAdapter({"summary"})
  public static final void b(ImageView paramImageView, com.tplink.iot.dailysummary.model.b paramb)
  {
    kotlin.jvm.internal.j.e(paramImageView, "view");
    if (paramb != null)
    {
      SummaryImage localSummaryImage = paramb.k();
      String str = paramb.l();
      if ((str != null) && (localSummaryImage != null) && (str.length() != 0)) {
        ((h)((h)c.u(paramImageView.getContext()).r(new d(paramb)).f(com.bumptech.glide.load.engine.j.a)).c()).x0(paramImageView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\adapter\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */