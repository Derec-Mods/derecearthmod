
package net.minecraftearthmod.fluid.types;

public class MudFluidType extends FluidType {
public MudFluidType() {
super(FluidType.Properties.create()
.fallDistanceModifier(0F)
.canExtinguish(true)
.supportsBoating(true)
.canHydrate(true)
.viscosity(2005)
.canConvertToSource(true)
.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
.sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
}
@Override public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
consumer.accept(new IClientFluidTypeExtensions() {
private static final ResourceLocation STILL_TEXTURE = new ResourceLocation("minecraft_earth_mod:blocks/mud"),
FLOWING_TEXTURE = new ResourceLocation("minecraft_earth_mod:blocks/mud");
@Override public ResourceLocation getStillTexture() {
return STILL_TEXTURE;
}
@Override public ResourceLocation getFlowingTexture() {
return FLOWING_TEXTURE;
}
}
);
}
}