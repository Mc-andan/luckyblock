package mod.lucky.drop.func;

import mod.lucky.drop.DropProperties;
import mod.lucky.drop.value.ValueParser;
import net.minecraft.world.WorldServer;

public class DropFuncTime extends DropFunction {
  @Override
  public void process(DropProcessData processData) {
    DropProperties drop = processData.getDropProperties();
    String id = drop.getPropertyString("ID");
    long time = id.equals("day") ? 1000 : (id.equals("night") ? 13000 : ValueParser.getInteger(id));
    for (WorldServer worldServer : processData.getWorld().getMinecraftServer().worlds) {
      worldServer.setWorldTime(time);
    }
  }

  @Override
  public String getType() {
    return "time";
  }
}