package androidx.databinding;

public class DataBinderMapperImpl
  extends MergedDataBinderMapper
{
  DataBinderMapperImpl()
  {
    addMapper(new com.tplink.iot.DataBinderMapperImpl());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\DataBinderMapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */