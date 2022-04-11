package com.tplink.iot.view.ipcamera.play;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.d.m.f;
import com.tplink.iot.Utils.y0.e;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter.ViewHolder;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.DialogMarkPositionConfirmBinding;
import com.tplink.iot.databinding.FragmentCloudTerracePresetBinding;
import com.tplink.iot.databinding.FragmentOperationShellBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerracePresetViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.e3;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.d;
import kotlin.text.m;

public final class CloudTerracePresetFragment
  extends BaseFragment
{
  public static final a q = new a(null);
  private FragmentCloudTerracePresetBinding H3;
  private VideoPlayViewModel I3;
  private int J3;
  private final e3 K3 = new b(this);
  private final e3 L3 = new h(this);
  private final View.OnLongClickListener M3 = new g(this);
  private HashMap N3;
  private Dialog p0;
  private LayoutInflater p1;
  private ViewGroup p2;
  private CloudTerracePresetViewModel p3;
  private Dialog x;
  private EditText y;
  private ImageView z;
  
  private final void X0()
  {
    Object localObject = getParentFragment();
    j.c(localObject);
    localObject = ViewModelProviders.of((Fragment)localObject).get(CloudTerracePresetViewModel.class);
    j.d(localObject, "ViewModelProviders.of(pa…setViewModel::class.java)");
    localObject = (CloudTerracePresetViewModel)localObject;
    this.p3 = ((CloudTerracePresetViewModel)localObject);
    if (localObject == null) {
      j.t("presetVM");
    }
    ((CloudTerracePresetViewModel)localObject).e0(this);
    localObject = getActivity();
    j.c(localObject);
    localObject = ViewModelProviders.of((FragmentActivity)localObject).get(CloudTerraceControlViewModel.class);
    j.d(localObject, "ViewModelProviders.of(ac…rolViewModel::class.java)");
    localObject = (CloudTerraceControlViewModel)localObject;
    CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.p3;
    if (localCloudTerracePresetViewModel == null) {
      j.t("presetVM");
    }
    localCloudTerracePresetViewModel.v((CloudTerraceControlViewModel)localObject);
    localObject = getActivity();
    j.c(localObject);
    localObject = ViewModelProviders.of((FragmentActivity)localObject).get(VideoPlayViewModel.class);
    j.d(localObject, "ViewModelProviders.of(ac…layViewModel::class.java)");
    this.I3 = ((VideoPlayViewModel)localObject);
  }
  
  private final void Y0()
  {
    CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.p3;
    if (localCloudTerracePresetViewModel == null) {
      j.t("presetVM");
    }
    int i = com.tplink.iot.adapter.databinding.a.h;
    int j = com.tplink.iot.adapter.databinding.a.i;
    int k = com.tplink.iot.adapter.databinding.a.j;
    int m = com.tplink.iot.adapter.databinding.a.k;
    int n = com.tplink.iot.adapter.databinding.a.l;
    int i1 = com.tplink.iot.adapter.databinding.a.m;
    int i2 = com.tplink.iot.adapter.databinding.a.n;
    int i3 = com.tplink.iot.adapter.databinding.a.h;
    int i4 = com.tplink.iot.adapter.databinding.a.i;
    int i5 = com.tplink.iot.adapter.databinding.a.j;
    Object localObject1 = this.p3;
    if (localObject1 == null) {
      j.t("presetVM");
    }
    localObject1 = ((CloudTerracePresetViewModel)localObject1).E();
    Object localObject2 = this.p3;
    if (localObject2 == null) {
      j.t("presetVM");
    }
    localObject2 = ((CloudTerracePresetViewModel)localObject2).D();
    Object localObject3 = this.p3;
    if (localObject3 == null) {
      j.t("presetVM");
    }
    localObject3 = ((CloudTerracePresetViewModel)localObject3).F();
    Object localObject4 = this.p3;
    if (localObject4 == null) {
      j.t("presetVM");
    }
    MutableLiveData localMutableLiveData = ((CloudTerracePresetViewModel)localObject4).X();
    localObject4 = this.K3;
    e3 locale3 = this.L3;
    View.OnLongClickListener localOnLongClickListener = this.M3;
    localObject1 = new DataBindingListAdapter(2131559001, new int[] { i, j, k, m, n, i1, i2 }, new int[] { i3, i4, i5 }, new Object[] { localObject1, localObject2, localObject3, localMutableLiveData, localObject4, locale3, localOnLongClickListener })
    {
      public DataBindingListAdapter.ViewHolder w(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        j.e(paramAnonymousViewGroup, "parent");
        paramAnonymousViewGroup = super.w(paramAnonymousViewGroup, paramAnonymousInt);
        if (this.r.W0() == 0)
        {
          localObject = CloudTerracePresetFragment.O0(this.r).c;
          j.d(localObject, "presetBinding.cloudTerraceMarkedPositionList");
          paramAnonymousInt = ((ViewGroup)localObject).getHeight();
          this.r.a1((int)(paramAnonymousInt / 3.0F));
        }
        Object localObject = paramAnonymousViewGroup.itemView;
        j.d(localObject, "viewHolder.itemView");
        ((View)localObject).getLayoutParams().height = this.r.W0();
        return paramAnonymousViewGroup;
      }
    };
    localObject3 = this.p1;
    if (localObject3 == null) {
      j.t("inflater");
    }
    localObject2 = this.p2;
    if (localObject2 == null) {
      j.t("container");
    }
    localObject2 = ((LayoutInflater)localObject3).inflate(2131559009, (ViewGroup)localObject2, false);
    j.d(localObject2, "inflater.inflate(R.layou…sition, container, false)");
    ((View)localObject2).setOnClickListener(new c(this));
    ((DataBindingListAdapter)localObject1).A((View)localObject2);
    ((DataBindingListAdapter)localObject1).B(this);
    localObject2 = this.H3;
    if (localObject2 == null) {
      j.t("presetBinding");
    }
    localObject2 = ((FragmentCloudTerracePresetBinding)localObject2).c;
    j.d(localObject2, "presetBinding.cloudTerraceMarkedPositionList");
    ((RecyclerView)localObject2).setAdapter((RecyclerView.Adapter)localObject1);
    localObject2 = p.a;
    localCloudTerracePresetViewModel.f0((DataBindingListAdapter)localObject1);
  }
  
  private final void Z0()
  {
    Object localObject1 = this.H3;
    if (localObject1 == null) {
      j.t("presetBinding");
    }
    Object localObject2 = this.p3;
    if (localObject2 == null) {
      j.t("presetVM");
    }
    ((FragmentCloudTerracePresetBinding)localObject1).h((CloudTerracePresetViewModel)localObject2);
    ((ViewDataBinding)localObject1).setLifecycleOwner(this);
    localObject2 = ((FragmentCloudTerracePresetBinding)localObject1).c;
    ((RecyclerView)localObject2).setLayoutManager(new GridLayoutManager(((ViewGroup)localObject2).getContext(), 3, 1, false));
    ((ViewGroup)localObject2).post(new d(this));
    ((FragmentCloudTerracePresetBinding)localObject1).f.setOnClickListener(new e(this));
    localObject1 = getParentFragment();
    if (localObject1 != null)
    {
      localObject1 = ((Fragment)localObject1).getView();
      if (localObject1 != null)
      {
        localObject2 = (FragmentOperationShellBinding)DataBindingUtil.bind((View)localObject1);
        if (localObject2 != null)
        {
          localObject1 = this.p3;
          if (localObject1 == null) {
            j.t("presetVM");
          }
          ((FragmentOperationShellBinding)localObject2).h(((CloudTerracePresetViewModel)localObject1).X());
          ((ViewDataBinding)localObject2).setLifecycleOwner(this);
          ((FragmentOperationShellBinding)localObject2).x.setOnClickListener(new f(this));
        }
      }
    }
  }
  
  private final void b1()
  {
    if (this.p0 == null)
    {
      localObject1 = getContext();
      j.c(localObject1);
      localObject1 = new Dialog((Context)localObject1);
      Object localObject2 = this.p1;
      if (localObject2 == null) {
        j.t("inflater");
      }
      ViewGroup localViewGroup = this.p2;
      if (localViewGroup == null) {
        j.t("container");
      }
      ((Dialog)localObject1).setContentView(((LayoutInflater)localObject2).inflate(2131558805, localViewGroup, false));
      ((Dialog)localObject1).findViewById(2131362312).setOnClickListener(new i((Dialog)localObject1));
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      localObject2 = p.a;
      this.p0 = ((Dialog)localObject1);
    }
    Object localObject1 = this.p0;
    if (localObject1 != null) {
      ((Dialog)localObject1).show();
    }
  }
  
  private final void c1()
  {
    Object localObject = this.I3;
    if (localObject == null) {
      j.t("playVM");
    }
    ((VideoPlayViewModel)localObject).k.observe(this, new n(this));
    localObject = this.p3;
    if (localObject == null) {
      j.t("presetVM");
    }
    ((CloudTerracePresetViewModel)localObject).L().observe(this, new j(this));
    ((CloudTerracePresetViewModel)localObject).O().observe(this, new k(this));
    ((CloudTerracePresetViewModel)localObject).C().observe(this, new l(this));
    localObject = this.p3;
    if (localObject == null) {
      j.t("presetVM");
    }
    ((CloudTerracePresetViewModel)localObject).A().observe(this, new m(this));
  }
  
  private final void markPosition()
  {
    CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.p3;
    if (localCloudTerracePresetViewModel == null) {
      j.t("presetVM");
    }
    if (localCloudTerracePresetViewModel.Y())
    {
      b1();
    }
    else
    {
      localCloudTerracePresetViewModel = this.p3;
      if (localCloudTerracePresetViewModel == null) {
        j.t("presetVM");
      }
      localCloudTerracePresetViewModel.Z();
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.N3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final int W0()
  {
    return this.J3;
  }
  
  public final void a1(int paramInt)
  {
    this.J3 = paramInt;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    this.p1 = paramLayoutInflater;
    X0();
    paramLayoutInflater = DataBindingUtil.inflate(paramLayoutInflater, 2131558911, paramViewGroup, false);
    j.d(paramLayoutInflater, "DataBindingUtil.inflate(…preset, container, false)");
    this.H3 = ((FragmentCloudTerracePresetBinding)paramLayoutInflater);
    j.c(paramViewGroup);
    this.p2 = paramViewGroup;
    Z0();
    c1();
    paramLayoutInflater = this.H3;
    if (paramLayoutInflater == null) {
      j.t("presetBinding");
    }
    return paramLayoutInflater.getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Dialog localDialog = this.x;
    if (localDialog != null) {
      localDialog.dismiss();
    }
    this.x = null;
    localDialog = this.p0;
    if (localDialog != null) {
      localDialog.dismiss();
    }
    this.p0 = null;
    H0();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    CloudTerracePresetViewModel localCloudTerracePresetViewModel1 = this.p3;
    if (localCloudTerracePresetViewModel1 != null)
    {
      if (localCloudTerracePresetViewModel1 == null) {
        j.t("presetVM");
      }
      localCloudTerracePresetViewModel1.h0(paramBoolean);
      if (paramBoolean)
      {
        localCloudTerracePresetViewModel1 = this.p3;
        if (localCloudTerracePresetViewModel1 == null) {
          j.t("presetVM");
        }
        CloudTerracePresetViewModel localCloudTerracePresetViewModel2 = this.p3;
        if (localCloudTerracePresetViewModel2 == null) {
          j.t("presetVM");
        }
        if (localCloudTerracePresetViewModel2.D().size() == 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localCloudTerracePresetViewModel1.G(paramBoolean);
      }
      else
      {
        localCloudTerracePresetViewModel1 = this.p3;
        if (localCloudTerracePresetViewModel1 == null) {
          j.t("presetVM");
        }
        localCloudTerracePresetViewModel1.X().setValue(Boolean.FALSE);
      }
    }
  }
  
  public static final class a {}
  
  public static final class b
    implements e3
  {
    b(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public void a(String paramString, Integer paramInteger)
    {
      paramString = CloudTerracePresetFragment.P0(this.a);
      j.c(paramInteger);
      paramString.P(paramInteger.intValue());
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void onClick(View paramView)
    {
      CloudTerracePresetFragment.R0(this.c);
    }
  }
  
  static final class d
    implements Runnable
  {
    d(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void run()
    {
      CloudTerracePresetFragment.Q0(this.c);
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void onClick(View paramView)
    {
      CloudTerracePresetFragment.R0(this.c);
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void onClick(View paramView)
    {
      CloudTerracePresetFragment.P0(this.c).X().setValue(Boolean.FALSE);
    }
  }
  
  static final class g
    implements View.OnLongClickListener
  {
    g(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final boolean onLongClick(View paramView)
    {
      CloudTerracePresetFragment.P0(this.c).X().setValue(Boolean.TRUE);
      return true;
    }
  }
  
  public static final class h
    implements e3
  {
    h(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public void a(String paramString, Integer paramInteger)
    {
      CloudTerracePresetViewModel localCloudTerracePresetViewModel = CloudTerracePresetFragment.P0(this.a);
      j.c(paramString);
      j.c(paramInteger);
      localCloudTerracePresetViewModel.b0(paramString, paramInteger.intValue());
    }
  }
  
  static final class i
    implements View.OnClickListener
  {
    i(Dialog paramDialog) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismiss();
    }
  }
  
  static final class j<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    j(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      if ((parama != null) && (parama.a() != null)) {
        CloudTerracePresetFragment.V0(this.a);
      }
    }
  }
  
  static final class k<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>>
  {
    k(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String> parama)
    {
      if (parama != null) {
        parama = (String)parama.a();
      } else {
        parama = null;
      }
      if (parama != null) {
        TSnackbar.C(this.a, parama, -1).N();
      }
    }
  }
  
  static final class l<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    l(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      if (parama != null) {
        parama = (Boolean)parama.a();
      } else {
        parama = null;
      }
      if (j.a(parama, Boolean.TRUE)) {
        CloudTerracePresetFragment.R0(this.a);
      }
    }
  }
  
  static final class m<T>
    implements Observer<f<Pair<Bitmap, String>>>
  {
    m(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void a(f<Pair<Bitmap, String>> paramf)
    {
      if (paramf != null)
      {
        paramf = (Pair)paramf.a();
        if (paramf != null)
        {
          j.d(paramf, "it.contentIfNotHandled ?: return@Observer");
          CloudTerracePresetFragment.P0(this.a).x();
          paramf = (String)paramf.second;
          e.a(this.a.getContext(), paramf).l0(io.reactivex.d0.b.a.a()).G0(new a(this));
        }
      }
    }
    
    static final class a<T>
      implements g<Bitmap>
    {
      a(CloudTerracePresetFragment.m paramm) {}
      
      public final void a(Bitmap paramBitmap)
      {
        CloudTerracePresetFragment.P0(this.c.a).g0(paramBitmap);
        if (CloudTerracePresetFragment.K0(this.c.a) == null)
        {
          localObject1 = CloudTerracePresetFragment.J0(this.c.a).inflate(2131558804, CloudTerracePresetFragment.I0(this.c.a), false);
          final Object localObject2 = this.c.a;
          final Object localObject3 = this.c.a.getContext();
          j.c(localObject3);
          Dialog localDialog = new Dialog((Context)localObject3);
          localDialog.setCanceledOnTouchOutside(false);
          localDialog.setContentView((View)localObject1);
          localObject3 = p.a;
          CloudTerracePresetFragment.S0((CloudTerracePresetFragment)localObject2, localDialog);
          localObject2 = this.c.a.getContext();
          j.c(localObject2);
          localObject2 = ((Context)localObject2).getSystemService("input_method");
          Objects.requireNonNull(localObject2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          localObject2 = (InputMethodManager)localObject2;
          localObject3 = new a(this, (InputMethodManager)localObject2);
          localObject1 = (DialogMarkPositionConfirmBinding)DataBindingUtil.bind((View)localObject1);
          if (localObject1 != null)
          {
            ((ViewDataBinding)localObject1).setLifecycleOwner(this.c.a);
            CloudTerracePresetFragment.T0(this.c.a, ((DialogMarkPositionConfirmBinding)localObject1).d);
            CloudTerracePresetFragment.U0(this.c.a, ((DialogMarkPositionConfirmBinding)localObject1).x);
            ((DialogMarkPositionConfirmBinding)localObject1).h(CloudTerracePresetFragment.P0(this.c.a).z());
            ((DialogMarkPositionConfirmBinding)localObject1).f.setOnClickListener(new b(this, (View.OnClickListener)localObject3, (InputMethodManager)localObject2));
            ((DialogMarkPositionConfirmBinding)localObject1).y.setOnClickListener((View.OnClickListener)localObject3);
            ((DialogMarkPositionConfirmBinding)localObject1).c.setOnClickListener((View.OnClickListener)localObject3);
            ((DialogMarkPositionConfirmBinding)localObject1).d.addTextChangedListener(new c());
            ((DialogMarkPositionConfirmBinding)localObject1).d.setOnEditorActionListener(new d((DialogMarkPositionConfirmBinding)localObject1, this, (View.OnClickListener)localObject3, (InputMethodManager)localObject2));
          }
          localObject1 = CloudTerracePresetFragment.K0(this.c.a);
          if (localObject1 != null) {
            ((Dialog)localObject1).setOnShowListener(new e(this, (InputMethodManager)localObject2));
          }
        }
        Object localObject1 = CloudTerracePresetFragment.N0(this.c.a);
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageBitmap(paramBitmap);
        }
        paramBitmap = CloudTerracePresetFragment.K0(this.c.a);
        if (paramBitmap != null) {
          paramBitmap.show();
        }
      }
      
      static final class a
        implements View.OnClickListener
      {
        a(CloudTerracePresetFragment.m.a parama, InputMethodManager paramInputMethodManager) {}
        
        public final void onClick(View paramView)
        {
          j.d(paramView, "view");
          if (paramView.getId() == 2131363955) {
            CloudTerracePresetFragment.P0(this.c.c.a).c0();
          }
          localObject2.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
          paramView = CloudTerracePresetFragment.K0(this.c.c.a);
          if (paramView != null) {
            paramView.dismiss();
          }
        }
      }
      
      static final class b
        implements View.OnClickListener
      {
        b(CloudTerracePresetFragment.m.a parama, View.OnClickListener paramOnClickListener, InputMethodManager paramInputMethodManager) {}
        
        public final void onClick(View paramView)
        {
          CloudTerracePresetFragment.P0(this.c.c.a).z().setValue("");
        }
      }
      
      public static final class c
        implements TextWatcher
      {
        public void afterTextChanged(Editable paramEditable) {}
        
        public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
        
        public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
        {
          if (paramCharSequence != null)
          {
            Object localObject = paramCharSequence.toString();
            if (localObject != null)
            {
              localObject = ((String)localObject).getBytes(d.a);
              j.d(localObject, "(this as java.lang.String).getBytes(charset)");
              if (localObject != null)
              {
                paramInt1 = localObject.length;
                break label46;
              }
            }
          }
          paramInt1 = 0;
          label46:
          if ((paramInt1 > 32) && (paramCharSequence != null)) {
            m.a0(paramCharSequence, paramCharSequence.length() - 1, paramCharSequence.length());
          }
        }
      }
      
      static final class d
        implements TextView.OnEditorActionListener
      {
        d(DialogMarkPositionConfirmBinding paramDialogMarkPositionConfirmBinding, CloudTerracePresetFragment.m.a parama, View.OnClickListener paramOnClickListener, InputMethodManager paramInputMethodManager) {}
        
        public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
        {
          boolean bool = false;
          if (paramInt == 6)
          {
            CloudTerracePresetFragment.P0(jdField_this.c.a).c0();
            paramTextView = localObject2;
            paramKeyEvent = this.a.p0;
            j.d(paramKeyEvent, "view");
            paramTextView.hideSoftInputFromWindow(paramKeyEvent.getWindowToken(), 0);
            paramTextView = CloudTerracePresetFragment.K0(jdField_this.c.a);
            if (paramTextView != null) {
              paramTextView.dismiss();
            }
            bool = true;
          }
          return bool;
        }
      }
      
      static final class e
        implements DialogInterface.OnShowListener
      {
        e(CloudTerracePresetFragment.m.a parama, InputMethodManager paramInputMethodManager) {}
        
        public final void onShow(DialogInterface paramDialogInterface)
        {
          paramDialogInterface = CloudTerracePresetFragment.L0(this.a.c.a);
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getText();
            if (paramDialogInterface != null)
            {
              int i = paramDialogInterface.length();
              paramDialogInterface = CloudTerracePresetFragment.L0(this.a.c.a);
              if (paramDialogInterface != null) {
                paramDialogInterface.setSelection(i);
              }
            }
          }
          localObject2.showSoftInput(CloudTerracePresetFragment.L0(this.a.c.a), 1);
        }
      }
    }
  }
  
  static final class n<T>
    implements Observer<String>
  {
    n(CloudTerracePresetFragment paramCloudTerracePresetFragment) {}
    
    public final void a(String paramString)
    {
      CloudTerracePresetFragment.P0(this.a).d0(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\CloudTerracePresetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */