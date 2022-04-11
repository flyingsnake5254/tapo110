package b.d.o.a;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

public class d
  extends BaseConnection
{
  public d(String paramString, int paramInt1, int paramInt2, DeviceModel paramDeviceModel)
  {
    super(paramString, paramDeviceModel);
    this.mediaType = 0;
    this.connectionType = paramInt1;
    this.streamType = paramInt2;
  }
  
  public d a()
  {
    d locald = new d(this.deviceIdMD5, this.connectionType, this.streamType, this.deviceModel);
    locald.isLocal = this.isLocal;
    locald.portId = this.portId;
    locald.statistics = this.statistics;
    locald.url = this.url;
    locald.streamType = this.streamType;
    locald.audioType = this.audioType;
    locald.connectionType = this.connectionType;
    locald.createTime = this.createTime;
    locald.encryptType = this.encryptType;
    locald.relayTime = this.relayTime;
    locald.bitStreamType = this.bitStreamType;
    return locald;
  }
  
  public boolean b()
  {
    boolean bool;
    if (System.currentTimeMillis() - this.createTime < 300000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    int i = this.streamType;
    if (1 == i) {
      localObject = "MIXED";
    } else if (3 == i) {
      localObject = "DUAL VIDEO";
    } else {
      localObject = "DUAL AUDIO";
    }
    i = this.connectionType;
    if (256 == i) {
      str1 = "Local";
    } else if (16 == i) {
      str1 = "P2P";
    } else {
      str1 = "Relay";
    }
    String str2 = str1;
    if (this.statistics != null) {
      str2 = str1.concat("\nstatistics : ").concat(this.statistics.toString());
    }
    String str1 = "\n".concat(String.valueOf(this.deviceIdMD5)).concat("\nisLocal : ").concat(String.valueOf(this.isLocal)).concat("\nurl : ").concat(String.valueOf(this.url)).concat("\nstreamType : ").concat((String)localObject).concat("\nconnectionType : ").concat(str2).concat("\ncreateTime : ");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.createTime);
    return str1.concat(((StringBuilder)localObject).toString()).concat("\nencryptType : ").concat(String.valueOf(this.encryptType)).concat("\nrelayTime : ").concat(String.valueOf(this.relayTime)).concat("\nresolution : ").concat("\nport : ").concat(String.valueOf(this.port)).concat("\nportId : ").concat(String.valueOf(this.portId)).concat("\nmodel : ").concat(this.deviceModel.value());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\o\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */