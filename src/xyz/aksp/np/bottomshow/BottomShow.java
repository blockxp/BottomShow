package xyz.aksp.np.bottomshow;

import Rs.Plugin.Auto.RsAutoMainClass;
import Rs.Plugin.Money.MoneyClass;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.Library;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

import java.util.Date;

public class BottomShow extends PluginBase implements Listener{
    @Override
    public void onLoad(){
        this.getLogger().info(TextFormat.BLUE+"插件开启中...");
    }

    @Override
    public void onEnable(){
        this.getLogger().info(TextFormat.BLUE+"插件开启成功");
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getScheduler().scheduleRepeatingTask(new BottomShowTask(this), 10);
    }

    @Override
    public void onDisable(){
        this.getLogger().info(TextFormat.BLUE+"插件关闭");
    }

}





