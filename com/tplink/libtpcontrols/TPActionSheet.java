package com.tplink.libtpcontrols;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.commit451.nativestackblur.NativeStackBlur;
import com.tplink.libtpcontrols.model.ActionSheetParams;
import java.util.ArrayList;

public class TPActionSheet
  extends Fragment
  implements View.OnClickListener
{
  private com.tplink.libtpcontrols.z0.a c = null;
  private FragmentManager d = null;
  private View f = null;
  private boolean p0 = true;
  private int p1;
  private View p2 = null;
  private LinearLayout q = null;
  private LayoutInflater x = null;
  private boolean y = true;
  private Activity z = null;
  
  private void G0()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.f, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    Object localObject = this.q;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { ((LinearLayout)localObject).getHeight(), 0.0F });
    localObjectAnimator2.setDuration(300L);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2);
    ((AnimatorSet)localObject).start();
  }
  
  private void H0(TextView paramTextView, ActionSheetParams paramActionSheetParams)
  {
    if (!TextUtils.isEmpty(paramActionSheetParams.b())) {
      paramTextView.setText(paramActionSheetParams.b());
    } else if (paramActionSheetParams.d() != -1) {
      paramTextView.setText(paramActionSheetParams.d());
    }
    if (paramActionSheetParams.c() != -1) {
      paramTextView.setTextColor(ContextCompat.getColorStateList(this.z, paramActionSheetParams.c()));
    }
    if (paramActionSheetParams.a() > 0) {
      paramTextView.setBackgroundResource(P0());
    }
    if ((P0() > 0) && (paramActionSheetParams.a() <= 0)) {
      paramTextView.setBackgroundResource(P0());
    }
  }
  
  private void I0()
  {
    View localView = this.p2;
    if (localView == null) {
      localView = this.z.getWindow().getDecorView();
    }
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    Bitmap localBitmap = localView.getDrawingCache();
    for (int i = 0; i < this.p1; i++) {
      J0(this.q.getChildAt(i), localBitmap);
    }
    localView.setDrawingCacheEnabled(false);
  }
  
  private void J0(View paramView, Bitmap paramBitmap)
  {
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i;
    if (localObject[0] + paramView.getWidth() > paramBitmap.getWidth()) {
      i = paramBitmap.getWidth() - localObject[0];
    } else {
      i = paramView.getWidth();
    }
    int j;
    if (localObject[1] + paramView.getHeight() > paramBitmap.getHeight()) {
      j = paramBitmap.getHeight() - localObject[1];
    } else {
      j = paramView.getHeight();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, localObject[0], localObject[1], i, j);
    localObject = new Canvas(localBitmap);
    paramBitmap = new Paint();
    paramBitmap.setFlags(2);
    ((Canvas)localObject).drawBitmap(localBitmap, 0.0F, 0.0F, paramBitmap);
    paramBitmap = NativeStackBlur.process(localBitmap, 150);
    ((ImageView)paramView.findViewById(s0.action_sheet_bg)).setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }
  
  private int K0()
  {
    return Math.abs(b.d.w.f.a.c(this.z) - this.z.getWindow().getDecorView().getHeight());
  }
  
  private Animation L0()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(400L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  private void N0()
  {
    ArrayList localArrayList1 = (ArrayList)getArguments().get("ARG_ACTION_SHEET_ITEM_PARAMS_LIST");
    if (localArrayList1 != null)
    {
      this.p1 = localArrayList1.size();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject1 = null;
      Object localObject2 = null;
      int i = 0;
      while (i < localArrayList1.size())
      {
        localObject3 = (ActionSheetParams)localArrayList1.get(i);
        if (!((ActionSheetParams)localObject3).e()) {
          if (((ActionSheetParams)localObject3).f())
          {
            localObject1 = localObject3;
            localObject3 = localObject2;
          }
          else
          {
            localArrayList2.add(localObject3);
            localObject3 = localObject2;
          }
        }
        i++;
        localObject2 = localObject3;
      }
      if (localObject1 != null)
      {
        localObject3 = (TextView)((ViewGroup)this.x.inflate(t0.tpaction_sheet_title, this.q)).getChildAt(0).findViewById(s0.action_sheet_item);
        ((TextView)localObject3).setTag(Integer.valueOf(0));
        H0((TextView)localObject3, (ActionSheetParams)localObject1);
      }
      for (i = 0; i < localArrayList2.size(); i++)
      {
        ActionSheetParams localActionSheetParams = (ActionSheetParams)localArrayList2.get(i);
        int j;
        if (localObject1 == null) {
          j = i;
        } else {
          j = i + 1;
        }
        if ((localArrayList2.size() == 1) && (localObject2 != null) && (localObject1 == null))
        {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_single, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
          ((Button)localObject3).setTag(Integer.valueOf(0));
          H0((TextView)localObject3, localActionSheetParams);
          ((Button)localObject3).setOnClickListener(this);
          break;
        }
        if ((localArrayList2.size() == 1) && (localObject2 == null) && (localObject1 == null))
        {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_single_without_cancel_action, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
          ((Button)localObject3).setTag(Integer.valueOf(0));
          H0((TextView)localObject3, localActionSheetParams);
          ((Button)localObject3).setOnClickListener(this);
          break;
        }
        if ((localArrayList2.size() == 1) && (localObject2 != null))
        {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_bottom, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
          ((Button)localObject3).setTag(Integer.valueOf(0));
          H0((TextView)localObject3, localActionSheetParams);
          ((Button)localObject3).setOnClickListener(this);
          break;
        }
        if (localArrayList2.size() == 1)
        {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_bottom_without_cancel_action, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
          ((Button)localObject3).setTag(Integer.valueOf(0));
          H0((TextView)localObject3, localActionSheetParams);
          ((Button)localObject3).setOnClickListener(this);
          break;
        }
        if ((i == 0) && (localObject1 == null)) {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_top, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
        } else if ((i == localArrayList2.size() - 1) && (localObject2 != null)) {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_bottom, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
        } else if ((i == localArrayList2.size() - 1) && (localObject2 == null)) {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_bottom_without_cancel_action, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
        } else {
          localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_middle, this.q)).getChildAt(j).findViewById(s0.action_sheet_item);
        }
        ((Button)localObject3).setTag(Integer.valueOf(i));
        H0((TextView)localObject3, localActionSheetParams);
        ((Button)localObject3).setOnClickListener(this);
      }
      if (localObject2 != null)
      {
        localObject3 = (Button)((ViewGroup)this.x.inflate(t0.tpaction_sheet_cancel, this.q)).getChildAt(localArrayList1.size() - 1).findViewById(s0.action_sheet_item);
        ((Button)localObject3).setTag(Integer.valueOf(-1));
        H0((TextView)localObject3, (ActionSheetParams)localObject2);
        ((Button)localObject3).setOnClickListener(this);
      }
      Object localObject3 = (FrameLayout.LayoutParams)this.q.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject3).setMargins(0, 0, 0, K0());
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    }
  }
  
  private Animation O0()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    return localTranslateAnimation;
  }
  
  private int P0()
  {
    return getArguments().getInt("ARG_ACTION_SHEET_ITEM_BG_COLOR");
  }
  
  private boolean Q0()
  {
    return getArguments().getBoolean("ARG_CANCELABLE_ONTOUCHOUTSIDE");
  }
  
  public void dismiss()
  {
    if (this.p0) {
      return;
    }
    this.p0 = true;
    new Handler().post(new c(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = s0.action_sheet_root_view;
    if ((i == j) && (!Q0())) {
      return;
    }
    dismiss();
    if (paramView.getId() == j)
    {
      this.y = false;
      return;
    }
    i = ((Integer)paramView.getTag()).intValue();
    if (-1 != i)
    {
      paramView = this.c;
      if (paramView != null)
      {
        paramView.a(this, i);
        this.y = false;
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.z = getActivity();
    if (paramBundle != null) {
      this.p0 = paramBundle.getBoolean("EXTRA_DISMISSED");
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = (InputMethodManager)getActivity().getSystemService("input_method");
    if (paramBundle.isActive())
    {
      View localView = getActivity().getCurrentFocus();
      if (localView != null) {
        paramBundle.hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    this.x = paramLayoutInflater;
    paramLayoutInflater = paramLayoutInflater.inflate(t0.tpaction_sheet_main, paramViewGroup, true);
    this.f = paramLayoutInflater;
    paramLayoutInflater.setOnClickListener(this);
    this.q = ((LinearLayout)this.f.findViewById(s0.action_sheet_container));
    N0();
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(this.f);
    this.f.getViewTreeObserver().addOnPreDrawListener(new a());
    return this.f;
  }
  
  public void onDestroyView()
  {
    this.f.postDelayed(new b(this), 200L);
    this.p0 = true;
    super.onDestroyView();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("EXTRA_DISMISSED", this.p0);
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      TPActionSheet.A0(TPActionSheet.this);
      TPActionSheet.B0(TPActionSheet.this);
      TPActionSheet.C0(TPActionSheet.this).getViewTreeObserver().removeOnPreDrawListener(this);
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */