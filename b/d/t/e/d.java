package b.d.t.e;

public class d
{
  public static String a(String paramString)
  {
    if ((paramString != null) && (paramString.contains("aps"))) {
      return "13.250.156.167";
    }
    if ((paramString != null) && (paramString.contains("euw"))) {
      return "52.48.246.100";
    }
    return "54.85.98.44";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.contains("aps")))
    {
      if ((paramString1 != null) && (paramString1.contains("beta"))) {
        return "http://aps1-relay-dcipc-beta.i.tplinknbu.com";
      }
      return "http://aps1-relay-dcipc.i.tplinknbu.com";
    }
    if ((paramString2 != null) && (paramString2.contains("euw")))
    {
      if ((paramString1 != null) && (paramString1.contains("beta"))) {
        return "http://aps1-relay-dcipc-beta.i.tplinknbu.com";
      }
      return "http://euw1-relay-dcipc.i.tplinknbu.com";
    }
    if ((paramString1 != null) && (paramString1.contains("beta"))) {
      return "http://aps1-relay-dcipc-beta.i.tplinknbu.com";
    }
    return "http://use1-relay-dcipc.i.tplinknbu.com";
  }
  
  public static String c(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.contains("aps")))
    {
      if ((paramString1 != null) && (paramString1.contains("beta"))) {
        return "sg-stun-beta.tplinkcloud.com";
      }
      return "sg-stun.tplinkcloud.com";
    }
    if ((paramString2 != null) && (paramString2.contains("euw")))
    {
      if ((paramString1 != null) && (paramString1.contains("beta"))) {
        return "us-stun-beta.tplinkcloud.com";
      }
      return "ie-stun.tplinkcloud.com";
    }
    if ((paramString1 != null) && (paramString1.contains("beta"))) {
      return "us-stun-beta.tplinkcloud.com";
    }
    return "us-stun.tplinkcloud.com";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */