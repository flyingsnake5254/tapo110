package com.tplink.iot.devices.lightstrip.view.effects;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.Utils.i;
import java.util.List;
import kotlin.collections.l;

public final class b
{
  public static final List<String> a = l.g(new String[] { "sequence", "random", "static", "music" });
  public static final List<String> b = l.g(new String[] { "Forward", "Backward", "PingPong", "Random", "Blossom" });
  public static final List<String> c = l.g(new String[] { "None", "Repeat", "Expansion" });
  public static final LightingEffectData d = (LightingEffectData)i.d("\n        {\n            \"id\":\"01234567890123456789012345678901\",\n            \"custom\":1,\n            \"repeat_times\":1,\n            \"type\":\"pulse\",\n            \"enable\":1,\n            \"direction\":1,\n            \"segments\":[0],\n            \"expansion_strategy\":2,\n            \"name\":\"sunrise\",\n            \"transition\":60000,\n            \"duration\":600,\n            \"spread\":1,\n            \"sequence\":[\n                [0, 100, 5],[0, 100, 5],[10, 100, 6],[15, 100, 7],[20, 100, 8],[20, 100, 10],[30, 100, 12],[30, 95, 15],[30, 90, 20],[30, 80, 25],[30, 75, 30],\n                [30, 70, 40],[30, 60, 50],[30, 50, 60],[30, 20, 70],[30, 0, 100]\n            ],\n            \"display_colors\":[[30,0,100],[30,95,100],[0,100,100]]\n\t    }\n    ", LightingEffectData.class);
  public static final LightingEffectData e = (LightingEffectData)i.d("\n        {\n            \"id\":\"01234567890123456789012345678901\",\n            \"custom\":1,\n            \"repeat_times\":1,\n            \"type\":\"pulse\",\n            \"enable\":1,\n            \"direction\":1,\n            \"segments\":[0],\n            \"expansion_strategy\":2,\n            \"name\":\"sunset\",\n            \"transition\":60000,\n            \"duration\":600,\n            \"spread\":1,\n            \"sequence\":[\n            \t[30, 0, 100],[30, 20, 100],[30, 50, 99],[30, 60, 98],[30, 70, 97],[30, 75, 95],[30, 80, 93],[30, 90, 90],[30, 95, 85],[30, 100, 80],[20, 100, 70],\n\t\t\t    [20, 100, 60],[15, 100, 50],[10, 100, 40],[0, 100, 30],[0, 100, 0]\n            ],\n            \"display_colors\":[[0,100,100],[30,95,100],[30,0,100]]\n\t    }\n    ", LightingEffectData.class);
  public static final b f = new b();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */