package com.tplink.libtpnetwork.cameranetwork.net;

import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackItem;
import io.reactivex.q;
import java.util.Date;
import java.util.List;

public abstract interface a
{
  public abstract q<Response<List<YearlyPlaybackItem>>> a(Date paramDate1, Date paramDate2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\net\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */