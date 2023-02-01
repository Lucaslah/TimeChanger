package me.lucaslah.timechanger.fabric.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(ClientWorld.class)
public class ClientWorldMixin extends ClientWorld {
    public ClientWorldMixin(ClientPlayNetworkHandler networkHandler, Properties properties, RegistryKey<World> registryRef, RegistryEntry<DimensionType> dimensionTypeEntry, int loadDistance, int simulationDistance, Supplier<Profiler> profiler, WorldRenderer worldRenderer, boolean debugWorld, long seed) {
        super(networkHandler, properties, registryRef, dimensionTypeEntry, loadDistance, simulationDistance, profiler, worldRenderer, debugWorld, seed);
    }

    @Shadow
    @Final
    private ClientWorld.Properties clientWorldProperties;
    @Shadow
    @Final
    private MinecraftClient minecraftClient;

    @Inject(at = @At("TAIL"), method = "setTimeOfDay", cancellable = true)
    @Environment(EnvType.CLIENT)
    public void setTimeOfDay(long time, CallbackInfo ci) {
        // TODO: Logic handler for this
    }
}
