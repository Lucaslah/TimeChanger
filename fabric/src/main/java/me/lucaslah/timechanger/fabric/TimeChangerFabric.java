package me.lucaslah.timechanger.fabric;

import me.lucaslah.timechanger.api.TimeChangerApi;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;

@Environment(EnvType.CLIENT)
public class TimeChangerFabric implements ClientModInitializer {
    public TimeChangerApi api;
    @Override
    public void onInitializeClient() {
        api = new FabricTimeChangerApi();

        // create the config file if it does not exist
        File configFile = new File(FabricLoader.getInstance().getConfigDir().resolve("time-changer.json").toUri());
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
