package com.tplink.iot.view.ipcamera.play;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;

public class CloudTerraceControlFragment_ViewBinding
  implements Unbinder
{
  private CloudTerraceControlFragment b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  @UiThread
  public CloudTerraceControlFragment_ViewBinding(final CloudTerraceControlFragment paramCloudTerraceControlFragment, View paramView)
  {
    this.b = paramCloudTerraceControlFragment;
    View localView = c.c(paramView, 2131363614, "field 'controlPanel' and method 'move'");
    paramCloudTerraceControlFragment.controlPanel = ((CloudTerraceControlPanel)c.b(localView, 2131363614, "field 'controlPanel'", CloudTerraceControlPanel.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramCloudTerraceControlFragment));
    localView = c.c(paramView, 2131363403, "method 'markPosition'");
    this.d = localView;
    localView.setOnClickListener(new b(paramCloudTerraceControlFragment));
    localView = c.c(paramView, 2131364023, "method 'openSensitivityPanel'");
    this.e = localView;
    localView.setOnClickListener(new c(paramCloudTerraceControlFragment));
    localView = c.c(paramView, 2131362267, "method 'cruiseVertical'");
    this.f = localView;
    localView.setOnClickListener(new d(paramCloudTerraceControlFragment));
    paramView = c.c(paramView, 2131362266, "method 'cruiseHorizontal'");
    this.g = paramView;
    paramView.setOnClickListener(new e(paramCloudTerraceControlFragment));
  }
  
  @CallSuper
  public void a()
  {
    CloudTerraceControlFragment localCloudTerraceControlFragment = this.b;
    if (localCloudTerraceControlFragment != null)
    {
      this.b = null;
      localCloudTerraceControlFragment.controlPanel = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      this.g.setOnClickListener(null);
      this.g = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(CloudTerraceControlFragment paramCloudTerraceControlFragment) {}
    
    public void a(View paramView)
    {
      paramCloudTerraceControlFragment.move((CloudTerraceControlPanel)c.a(paramView, "doClick", 0, "move", 0, CloudTerraceControlPanel.class));
    }
  }
  
  class b
    extends b
  {
    b(CloudTerraceControlFragment paramCloudTerraceControlFragment) {}
    
    public void a(View paramView)
    {
      paramCloudTerraceControlFragment.markPosition();
    }
  }
  
  class c
    extends b
  {
    c(CloudTerraceControlFragment paramCloudTerraceControlFragment) {}
    
    public void a(View paramView)
    {
      paramCloudTerraceControlFragment.openSensitivityPanel();
    }
  }
  
  class d
    extends b
  {
    d(CloudTerraceControlFragment paramCloudTerraceControlFragment) {}
    
    public void a(View paramView)
    {
      paramCloudTerraceControlFragment.cruiseVertical();
    }
  }
  
  class e
    extends b
  {
    e(CloudTerraceControlFragment paramCloudTerraceControlFragment) {}
    
    public void a(View paramView)
    {
      paramCloudTerraceControlFragment.cruiseHorizontal();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\CloudTerraceControlFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */