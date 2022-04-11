package com.tplink.iot.dailysummary.view.adapter;

import android.content.Context;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class b
{
  public static final b a = new b();
  
  @BindingAdapter({"summary_select_num_string"})
  public static final void a(TextView paramTextView, int paramInt)
  {
    j.e(paramTextView, "view");
    if (paramInt > 1) {}
    try
    {
      str = paramTextView.getContext().getString(2131953077);
      j.d(str, "view.context.getString(R…ng.memory_filter_selects)");
      paramTextView.setText(m.w(str, "%s", String.valueOf(paramInt), false, 4, null));
    }
    catch (Exception paramTextView)
    {
      String str;
      for (;;) {}
    }
    if (paramInt == 1)
    {
      str = paramTextView.getContext().getString(2131953076);
      j.d(str, "view.context.getString(R…ing.memory_filter_select)");
      paramTextView.setText(m.w(str, "%s", String.valueOf(paramInt), false, 4, null));
    }
    else
    {
      paramTextView.setText(2131952497);
    }
  }
  
  @BindingAdapter({"summary_moments_num_string"})
  public static final void b(TextView paramTextView, int paramInt)
  {
    j.e(paramTextView, "view");
    if (paramInt > 1) {}
    try
    {
      str = paramTextView.getContext().getString(2131952488);
      j.d(str, "view.context.getString(R…ng.daily_summary_moments)");
      paramTextView.setText(m.w(str, "%s", String.valueOf(paramInt), false, 4, null));
    }
    catch (Exception paramTextView)
    {
      String str;
      for (;;) {}
    }
    if (paramInt == 1)
    {
      str = paramTextView.getContext().getString(2131952487);
      j.d(str, "view.context.getString(R…ing.daily_summary_moment)");
      paramTextView.setText(m.w(str, "%s", String.valueOf(paramInt), false, 4, null));
    }
    else
    {
      paramTextView.setText(2131952503);
    }
  }
  
  @BindingAdapter({"text_string_id"})
  public static final void c(TextView paramTextView, int paramInt)
  {
    j.e(paramTextView, "view");
    try
    {
      paramTextView.setText(paramInt);
      return;
    }
    catch (Exception paramTextView)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\adapter\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */