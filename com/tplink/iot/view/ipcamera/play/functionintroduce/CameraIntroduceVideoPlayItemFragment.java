package com.tplink.iot.view.ipcamera.play.functionintroduce;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.Utils.x0.w;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraIntroduceVideoPlayItemFragment
  extends Fragment
  implements View.OnClickListener
{
  private View c;
  private String d;
  private TextView f;
  private String p0;
  private TextView q;
  private TextView x;
  private ImageView y;
  private CameraIntroduceItemViewModel z;
  
  private void A0()
  {
    this.f = ((TextView)this.c.findViewById(2131364688));
    this.q = ((TextView)this.c.findViewById(2131364684));
    this.x = ((TextView)this.c.findViewById(2131364501));
    this.y = ((ImageView)this.c.findViewById(2131362820));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364501)
    {
      this.z.j(getActivity());
      w.J(this.p0);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558883, paramViewGroup, false);
    this.c = paramLayoutInflater;
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.z = ((CameraIntroduceItemViewModel)new ViewModelProvider(this).get(CameraIntroduceItemViewModel.class));
    if (getArguments() != null)
    {
      paramView = (DeviceModel)getArguments().get("CAMERA_CURRENT_MODEL");
      this.p0 = getArguments().getString("CAMERA_DEVICEIDMD5");
      this.d = ((String)getArguments().get("title"));
      A0();
      this.f.setText(this.z.i(this.d));
      this.q.setText(this.z.h(this.d, paramView));
      if (this.z.k(this.d))
      {
        this.x.setText(this.z.g(this.d));
        this.x.setVisibility(0);
        this.x.getPaint().setFlags(8);
        this.x.setOnClickListener(this);
      }
      this.y.setImageResource(this.z.f(this.d, paramView));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\functionintroduce\CameraIntroduceVideoPlayItemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */