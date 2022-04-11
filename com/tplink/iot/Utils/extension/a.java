package com.tplink.iot.Utils.extension;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class a
{
  @InverseBindingAdapter(attribute="isChecked", event="isCheckedAttrChanged")
  public static final boolean a(TPSwitchCompat paramTPSwitchCompat)
  {
    j.e(paramTPSwitchCompat, "switch");
    return paramTPSwitchCompat.isChecked();
  }
  
  @BindingAdapter({"isCheckedAttrChanged"})
  public static final void b(TPSwitchCompat paramTPSwitchCompat, InverseBindingListener paramInverseBindingListener)
  {
    j.e(paramTPSwitchCompat, "switch");
    if (paramInverseBindingListener != null) {
      paramTPSwitchCompat.setOnSwitchCheckedChangeListener(new a(paramInverseBindingListener));
    }
  }
  
  @BindingAdapter({"bind_text_end"})
  public static final void c(DrawableEditText paramDrawableEditText, String paramString)
  {
    j.e(paramDrawableEditText, "et");
    Object localObject = paramDrawableEditText.getText();
    if (localObject != null)
    {
      localObject = localObject.toString();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    if (paramString == null) {
      paramString = "";
    }
    int i = 1;
    if (!m.q((String)localObject, paramString, true))
    {
      paramDrawableEditText.setText(paramString);
      if (paramString.length() <= 0) {
        i = 0;
      }
      if (i != 0) {
        paramDrawableEditText.setSelection(paramString.length());
      }
    }
  }
  
  @BindingAdapter({"drawableStartCompat"})
  public static final void d(TextView paramTextView, @DrawableRes int paramInt)
  {
    j.e(paramTextView, "textView");
    if (paramInt == -1) {
      paramTextView.setCompoundDrawables(null, null, null, null);
    } else {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(paramTextView.getContext(), paramInt), null, null, null);
    }
  }
  
  @BindingAdapter({"tint"})
  public static final void e(ImageView paramImageView, int paramInt)
  {
    j.e(paramImageView, "iv");
    ImageViewCompat.setImageTintList(paramImageView, ColorStateList.valueOf(paramInt));
  }
  
  @BindingAdapter({"item_set_info"})
  public static final void f(ItemSettingLayout paramItemSettingLayout, String paramString)
  {
    j.e(paramItemSettingLayout, "view");
    paramItemSettingLayout.setItemInfo(paramString);
  }
  
  @BindingAdapter({"isChecked"})
  public static final void g(TPSwitchCompat paramTPSwitchCompat, boolean paramBoolean)
  {
    j.e(paramTPSwitchCompat, "switch");
    if (paramTPSwitchCompat.isChecked() != paramBoolean) {
      paramTPSwitchCompat.setChecked(paramBoolean);
    }
  }
  
  @BindingAdapter({"android:visibility"})
  public static final void h(View paramView, boolean paramBoolean)
  {
    j.e(paramView, "view");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    paramView.setVisibility(i);
  }
  
  static final class a
    implements TPSwitchCompat.a
  {
    a(InverseBindingListener paramInverseBindingListener) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2) {
        this.a.onChange();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */