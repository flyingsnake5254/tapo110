package com.tplink.iot.view.about;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.adapter.about.LicenseListAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

public class LicensesActivity
  extends BaseActivity
{
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558557);
    b1(2131951656);
    paramBundle = (RecyclerView)findViewById(2131363226);
    paramBundle.setLayoutManager(new LinearLayoutManager(this));
    paramBundle.setAdapter(new LicenseListAdapter(this));
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\LicensesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */