package xyz.aksp.np.bottomshow;

import Rs.Plugin.Auto.RsAutoMainClass;
import Rs.Plugin.Function.RsFunction;
import Rs.Plugin.Money.MoneyClass;
import Rs.Plugin.Money.MoneyConfig;
import cn.nukkit.Player;
import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.utils.TextFormat;

import java.security.PublicKey;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/17 0017.
 */
public class BottomShowTask extends PluginTask<BottomShow> {
    private String p = "管理员";
    public BottomShowTask(BottomShow owner) {
        super(owner);
    }

    @Override
    public void onRun(int time) {
        //this.getOwner().getLogger().info("233333333");
        Map<String, Player> onlinePlayers = this.getOwner().getServer().getOnlinePlayers();
        if (onlinePlayers.size()!=0) {
            for (Map.Entry<String, Player> online : onlinePlayers.entrySet()) {
                Player player = this.getOwner().getServer().getPlayer(online.getValue().getName());
                try {
                    if (new RsAutoMainClass().getPlayerState(player.getName()) == 1) {
                        if (player.isOp() == false) {
                            p = "玩家";
                        }
                        int x = (int) player.getX();
                        int y = (int) player.getY();
                        int z = (int) player.getZ();
                        String pos = TextFormat.BLUE + " X：" + TextFormat.GREEN + x + TextFormat.BLUE + "Y：" + TextFormat.GREEN + y + TextFormat.BLUE + "Y：" + TextFormat.GREEN + z;
                        player.sendPopup(TextFormat.BLUE+"权限"+TextFormat.RED+p + pos + TextFormat.BLUE+" 所在地图: " +TextFormat.YELLOW+player.getLevel().getName()+" 当前语言: "+onLang(new RsFunction().getPlayerLang(player)), TextFormat.RED+"money: "+TextFormat.YELLOW+new MoneyConfig(player).getMoney()+" "+onCurrentTime()+ TextFormat.YELLOW+"  点劵:" + TextFormat.RED+new MoneyConfig(player).getPoint());
                    }
                }catch (Exception e){

                }
            }
        }
    }

    //得到时间
    public String onCurrentTime() {
        Date time = new Date();
        int hours = time.getHours();
        int minutes = time.getMinutes();

        return TextFormat.GREEN+"时间:" +TextFormat.RED+ hours + TextFormat.GREEN+"点" + TextFormat.RED+minutes + TextFormat.GREEN+"分";
    }

    public String onLang(String lang){
        switch (lang){
            case "ch":
                return "中文";
            case "en":
                return "English";
            case "ru":
                return "русский";
            case "ko":
                return "한국어";
            case "jp":
                return "日本語";
        }
        return "其他";
    }


}
