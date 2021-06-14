
package net.minecraftearthmod.world.dimension;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.procedures.CheckEarthDimensionGameruleProcedure;
import net.minecraftearthmod.item.MinecraftEarthDimensionItem;
import net.minecraftearthmod.block.ChestTappableBlock;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.world.server.TicketType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DimensionType;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.village.PointOfInterest;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Entity;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.PortalInfo;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;

import javax.annotation.Nullable;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Set;
import java.util.Random;
import java.util.Optional;
import java.util.Comparator;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

import com.google.common.collect.Sets;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableMap;

@MinecraftEarthModModElements.ModElement.Tag
public class MinecraftEarthDimensionDimension extends MinecraftEarthModModElements.ModElement {
	@ObjectHolder("minecraft_earth_mod:minecraft_earth_dimension_portal")
	public static final CustomPortalBlock portal = null;
	public MinecraftEarthDimensionDimension(MinecraftEarthModModElements instance) {
		super(instance, 133);
		FMLJavaModLoadingContext.get().getModEventBus().register(new POIRegisterHandler());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			try {
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "field_222718_j"))
						.add(Blocks.STONE.getDefaultState().getBlock()).build(), "field_222718_j");
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "field_222718_j"))
						.add(Blocks.STONE.getDefaultState().getBlock()).build(), "field_222718_j");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		DimensionRenderInfo customEffect = new DimensionRenderInfo(128, true, DimensionRenderInfo.FogType.NORMAL, false, false) {
			@Override
			public Vector3d func_230494_a_(Vector3d color, float sunHeight) {
				return new Vector3d(0.752941176471, 0.847058823529, 1);
			}

			@Override
			public boolean func_230493_a_(int x, int y) {
				return false;
			}
		};
		DeferredWorkQueue.runLater(() -> {
			try {
				Object2ObjectMap<ResourceLocation, DimensionRenderInfo> effectsRegistry = (Object2ObjectMap<ResourceLocation, DimensionRenderInfo>) ObfuscationReflectionHelper
						.getPrivateValue(DimensionRenderInfo.class, null, "field_239208_a_");
				effectsRegistry.put(new ResourceLocation("minecraft_earth_mod:minecraft_earth_dimension"), customEffect);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		RenderTypeLookup.setRenderLayer(portal, RenderType.getTranslucent());
	}
	private static PointOfInterestType poi = null;
	public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.create("minecraft_earth_dimension_portal", Vector3i::compareTo, 300);
	public static class POIRegisterHandler {
		@SubscribeEvent
		public void registerPointOfInterest(RegistryEvent.Register<PointOfInterestType> event) {
			poi = new PointOfInterestType("minecraft_earth_dimension_portal",
					Sets.newHashSet(ImmutableSet.copyOf(portal.getStateContainer().getValidStates())), 0, 1)
							.setRegistryName("minecraft_earth_dimension_portal");
			ForgeRegistries.POI_TYPES.register(poi);
		}
	}
	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomPortalBlock());
		elements.items.add(() -> new MinecraftEarthDimensionItem().setRegistryName("minecraft_earth_dimension"));
	}
	public static class CustomPortalBlock extends NetherPortalBlock {
		public CustomPortalBlock() {
			super(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS)
					.setLightLevel(s -> 15).noDrops());
			setRegistryName("minecraft_earth_dimension_portal");
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		}

		@Override
		public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		}

		public void portalSpawn(World world, BlockPos pos) {
			Optional<CustomPortalSize> optional = CustomPortalSize.func_242964_a(world, pos, Direction.Axis.X);
			if (optional.isPresent()) {
				optional.get().placePortalBlocks();
			}
		}

		@Override /**
					 * Update the provided state given the provided neighbor facing and neighbor
					 * state, returning a new state. For example, fences make their connections to
					 * the passed in state if possible, and wet concrete powder immediately returns
					 * its solidified counterpart. Note that this method should ideally consider
					 * only the specific face passed in.
					 */
		public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos,
				BlockPos facingPos) {
			Direction.Axis direction$axis = facing.getAxis();
			Direction.Axis direction$axis1 = stateIn.get(AXIS);
			boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
			return !flag && !facingState.isIn(this) && !(new CustomPortalSize(worldIn, currentPos, direction$axis1)).validatePortal()
					? Blocks.AIR.getDefaultState()
					: super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			for (int i = 0; i < 4; i++) {
				double px = pos.getX() + random.nextFloat();
				double py = pos.getY() + random.nextFloat();
				double pz = pos.getZ() + random.nextFloat();
				double vx = (random.nextFloat() - 0.5) / 2.;
				double vy = (random.nextFloat() - 0.5) / 2.;
				double vz = (random.nextFloat() - 0.5) / 2.;
				int j = random.nextInt(4) - 1;
				if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
					px = pos.getX() + 0.5 + 0.25 * j;
					vx = random.nextFloat() * 2 * j;
				} else {
					pz = pos.getZ() + 0.5 + 0.25 * j;
					vz = random.nextFloat() * 2 * j;
				}
				world.addParticle(ParticleTypes.HAPPY_VILLAGER, px, py, pz, vx, vy, vz);
			}
			if (random.nextInt(110) == 0)
				world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(("block.wet_grass.step"))),
						SoundCategory.BLOCKS, 0.5f, random.nextFloat() * 0.4F + 0.8F, false);
		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			if (!entity.isPassenger() && !entity.isBeingRidden() && entity.isNonBoss() && !entity.world.isRemote
					&& CheckEarthDimensionGameruleProcedure.executeProcedure(ImmutableMap.of("world", world))) {
				if (entity.func_242280_ah()) {
					entity.func_242279_ag();
				} else if (entity.world.getDimensionKey() != RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("minecraft_earth_mod:minecraft_earth_dimension"))) {
					entity.func_242279_ag();
					teleportToDimension(entity, pos,
							RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("minecraft_earth_mod:minecraft_earth_dimension")));
				} else {
					entity.func_242279_ag();
					teleportToDimension(entity, pos, World.OVERWORLD);
				}
			}
		}

		private void teleportToDimension(Entity entity, BlockPos pos, RegistryKey<World> destinationType) {
			entity.changeDimension(entity.getServer().getWorld(destinationType),
					new TeleporterDimensionMod(entity.getServer().getWorld(destinationType), pos));
		}
	}

	public static class CustomPortalSize {
		private static final AbstractBlock.IPositionPredicate POSITION_PREDICATE = (state, blockReader, pos) -> {
			return state.getBlock() == ChestTappableBlock.block.getDefaultState().getBlock();
		};
		private final IWorld world;
		private final Direction.Axis axis;
		private final Direction rightDir;
		private int portalBlockCount;
		@Nullable
		private BlockPos bottomLeft;
		private int height;
		private int width;
		public static Optional<CustomPortalSize> func_242964_a(IWorld world, BlockPos pos, Direction.Axis axis) {
			return func_242965_a(world, pos, (size) -> {
				return size.isValid() && size.portalBlockCount == 0;
			}, axis);
		}

		public static Optional<CustomPortalSize> func_242965_a(IWorld world, BlockPos pos, Predicate<CustomPortalSize> sizePredicate,
				Direction.Axis axis) {
			Optional<CustomPortalSize> optional = Optional.of(new CustomPortalSize(world, pos, axis)).filter(sizePredicate);
			if (optional.isPresent()) {
				return optional;
			} else {
				Direction.Axis direction$axis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
				return Optional.of(new CustomPortalSize(world, pos, direction$axis)).filter(sizePredicate);
			}
		}

		public CustomPortalSize(IWorld worldIn, BlockPos pos, Direction.Axis axisIn) {
			this.world = worldIn;
			this.axis = axisIn;
			this.rightDir = axisIn == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
			this.bottomLeft = this.func_242971_a(pos);
			if (this.bottomLeft == null) {
				this.bottomLeft = pos;
				this.width = 1;
				this.height = 1;
			} else {
				this.width = this.func_242974_d();
				if (this.width > 0) {
					this.height = this.func_242975_e();
				}
			}
		}

		@Nullable
		private BlockPos func_242971_a(BlockPos pos) {
			for (int i = Math.max(0, pos.getY() - 21); pos.getY() > i && canConnect(this.world.getBlockState(pos.down())); pos = pos.down()) {
			}
			Direction direction = this.rightDir.getOpposite();
			int j = this.func_242972_a(pos, direction) - 1;
			return j < 0 ? null : pos.offset(direction, j);
		}

		private int func_242974_d() {
			int i = this.func_242972_a(this.bottomLeft, this.rightDir);
			return i >= 2 && i <= 21 ? i : 0;
		}

		private int func_242972_a(BlockPos pos, Direction direction) {
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
			for (int i = 0; i <= 21; ++i) {
				blockpos$mutable.setPos(pos).move(direction, i);
				BlockState blockstate = this.world.getBlockState(blockpos$mutable);
				if (!canConnect(blockstate)) {
					if (POSITION_PREDICATE.test(blockstate, this.world, blockpos$mutable)) {
						return i;
					}
					break;
				}
				BlockState blockstate1 = this.world.getBlockState(blockpos$mutable.move(Direction.DOWN));
				if (!POSITION_PREDICATE.test(blockstate1, this.world, blockpos$mutable)) {
					break;
				}
			}
			return 0;
		}

		private int func_242975_e() {
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
			int i = this.func_242969_a(blockpos$mutable);
			return i >= 3 && i <= 21 && this.func_242970_a(blockpos$mutable, i) ? i : 0;
		}

		private boolean func_242970_a(BlockPos.Mutable mutablePos, int upDisplacement) {
			for (int i = 0; i < this.width; ++i) {
				BlockPos.Mutable blockpos$mutable = mutablePos.setPos(this.bottomLeft).move(Direction.UP, upDisplacement).move(this.rightDir, i);
				if (!POSITION_PREDICATE.test(this.world.getBlockState(blockpos$mutable), this.world, blockpos$mutable)) {
					return false;
				}
			}
			return true;
		}

		private int func_242969_a(BlockPos.Mutable mutablePos) {
			for (int i = 0; i < 21; ++i) {
				mutablePos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
				if (!POSITION_PREDICATE.test(this.world.getBlockState(mutablePos), this.world, mutablePos)) {
					return i;
				}
				mutablePos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
				if (!POSITION_PREDICATE.test(this.world.getBlockState(mutablePos), this.world, mutablePos)) {
					return i;
				}
				for (int j = 0; j < this.width; ++j) {
					mutablePos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
					BlockState blockstate = this.world.getBlockState(mutablePos);
					if (!canConnect(blockstate)) {
						return i;
					}
					if (blockstate.getBlock() == portal) {
						++this.portalBlockCount;
					}
				}
			}
			return 21;
		}

		private static boolean canConnect(BlockState state) {
			return state.isAir() || state.getBlock() == portal;
		}

		public boolean isValid() {
			return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
		}

		public void placePortalBlocks() {
			BlockState blockstate = portal.getDefaultState().with(NetherPortalBlock.AXIS, this.axis);
			BlockPos.getAllInBoxMutable(this.bottomLeft, this.bottomLeft.offset(Direction.UP, this.height - 1).offset(this.rightDir, this.width - 1))
					.forEach((pos) -> {
						this.world.setBlockState(pos, blockstate, 18);
						if (this.world instanceof ServerWorld)
							((ServerWorld) this.world).getPointOfInterestManager().add(pos, poi);
					});
		}

		public boolean validatePortal() {
			return this.isValid() && this.portalBlockCount == this.width * this.height;
		}

		public static Vector3d func_242973_a(TeleportationRepositioner.Result result, Direction.Axis axis, Vector3d positionVector, EntitySize size) {
			double d0 = (double) result.width - (double) size.width;
			double d1 = (double) result.height - (double) size.height;
			BlockPos blockpos = result.startPos;
			double d2;
			if (d0 > 0.0D) {
				float f = (float) blockpos.func_243648_a(axis) + size.width / 2.0F;
				d2 = MathHelper.clamp(MathHelper.func_233020_c_(positionVector.getCoordinate(axis) - (double) f, 0.0D, d0), 0.0D, 1.0D);
			} else {
				d2 = 0.5D;
			}
			double d4;
			if (d1 > 0.0D) {
				Direction.Axis direction$axis = Direction.Axis.Y;
				d4 = MathHelper.clamp(MathHelper.func_233020_c_(
						positionVector.getCoordinate(direction$axis) - (double) blockpos.func_243648_a(direction$axis), 0.0D, d1), 0.0D, 1.0D);
			} else {
				d4 = 0.0D;
			}
			Direction.Axis direction$axis1 = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
			double d3 = positionVector.getCoordinate(direction$axis1) - ((double) blockpos.func_243648_a(direction$axis1) + 0.5D);
			return new Vector3d(d2, d4, d3);
		}

		public static PortalInfo func_242963_a(ServerWorld world, TeleportationRepositioner.Result result, Direction.Axis axis, Vector3d offsetVector,
				EntitySize size, Vector3d motion, float rotationYaw, float rotationPitch) {
			BlockPos blockpos = result.startPos;
			BlockState blockstate = world.getBlockState(blockpos);
			Direction.Axis direction$axis = blockstate.get(BlockStateProperties.HORIZONTAL_AXIS);
			double d0 = (double) result.width;
			double d1 = (double) result.height;
			int i = axis == direction$axis ? 0 : 90;
			Vector3d vector3d = axis == direction$axis ? motion : new Vector3d(motion.z, motion.y, -motion.x);
			double d2 = (double) size.width / 2.0D + (d0 - (double) size.width) * offsetVector.getX();
			double d3 = (d1 - (double) size.height) * offsetVector.getY();
			double d4 = 0.5D + offsetVector.getZ();
			boolean flag = direction$axis == Direction.Axis.X;
			Vector3d vector3d1 = new Vector3d((double) blockpos.getX() + (flag ? d2 : d4), (double) blockpos.getY() + d3,
					(double) blockpos.getZ() + (flag ? d4 : d2));
			return new PortalInfo(vector3d1, vector3d, rotationYaw + (float) i, rotationPitch);
		}
	}

	public static class TeleporterDimensionMod implements ITeleporter {
		private final ServerWorld world;
		private final BlockPos entityEnterPos;
		public TeleporterDimensionMod(ServerWorld worldServer, BlockPos entityEnterPos) {
			this.world = worldServer;
			this.entityEnterPos = entityEnterPos;
		}

		public Optional<TeleportationRepositioner.Result> getExistingPortal(BlockPos pos, boolean isNether) {
			PointOfInterestManager pointofinterestmanager = this.world.getPointOfInterestManager();
			int i = isNether ? 16 : 128;
			pointofinterestmanager.ensureLoadedAndValid(this.world, pos, i);
			Optional<PointOfInterest> optional = pointofinterestmanager.getInSquare((poiType) -> {
				return poiType == poi;
			}, pos, i, PointOfInterestManager.Status.ANY).sorted(Comparator.<PointOfInterest>comparingDouble((poi) -> {
				return poi.getPos().distanceSq(pos);
			}).thenComparingInt((poi) -> {
				return poi.getPos().getY();
			})).filter((poi) -> {
				return this.world.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS);
			}).findFirst();
			return optional.map((poi) -> {
				BlockPos blockpos = poi.getPos();
				this.world.getChunkProvider().registerTicket(CUSTOM_PORTAL, new ChunkPos(blockpos), 3, blockpos);
				BlockState blockstate = this.world.getBlockState(blockpos);
				return TeleportationRepositioner.findLargestRectangle(blockpos, blockstate.get(BlockStateProperties.HORIZONTAL_AXIS), 21,
						Direction.Axis.Y, 21, (posIn) -> {
							return this.world.getBlockState(posIn) == blockstate;
						});
			});
		}

		public Optional<TeleportationRepositioner.Result> makePortal(BlockPos pos, Direction.Axis axis) {
			Direction direction = Direction.getFacingFromAxis(Direction.AxisDirection.POSITIVE, axis);
			double d0 = -1.0D;
			BlockPos blockpos = null;
			double d1 = -1.0D;
			BlockPos blockpos1 = null;
			WorldBorder worldborder = this.world.getWorldBorder();
			int i = this.world.func_234938_ad_() - 1;
			BlockPos.Mutable blockpos$mutable = pos.toMutable();
			for (BlockPos.Mutable blockpos$mutable1 : BlockPos.func_243514_a(pos, 16, Direction.EAST, Direction.SOUTH)) {
				int j = Math.min(i, this.world.getHeight(Heightmap.Type.MOTION_BLOCKING, blockpos$mutable1.getX(), blockpos$mutable1.getZ()));
				int k = 1;
				if (worldborder.contains(blockpos$mutable1) && worldborder.contains(blockpos$mutable1.move(direction, 1))) {
					blockpos$mutable1.move(direction.getOpposite(), 1);
					for (int l = j; l >= 0; --l) {
						blockpos$mutable1.setY(l);
						if (this.world.isAirBlock(blockpos$mutable1)) {
							int i1;
							for (i1 = l; l > 0 && this.world.isAirBlock(blockpos$mutable1.move(Direction.DOWN)); --l) {
							}
							if (l + 4 <= i) {
								int j1 = i1 - l;
								if (j1 <= 0 || j1 >= 3) {
									blockpos$mutable1.setY(l);
									if (this.checkRegionForPlacement(blockpos$mutable1, blockpos$mutable, direction, 0)) {
										double d2 = pos.distanceSq(blockpos$mutable1);
										if (this.checkRegionForPlacement(blockpos$mutable1, blockpos$mutable, direction, -1)
												&& this.checkRegionForPlacement(blockpos$mutable1, blockpos$mutable, direction, 1)
												&& (d0 == -1.0D || d0 > d2)) {
											d0 = d2;
											blockpos = blockpos$mutable1.toImmutable();
										}
										if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
											d1 = d2;
											blockpos1 = blockpos$mutable1.toImmutable();
										}
									}
								}
							}
						}
					}
				}
			}
			if (d0 == -1.0D && d1 != -1.0D) {
				blockpos = blockpos1;
				d0 = d1;
			}
			if (d0 == -1.0D) {
				blockpos = (new BlockPos(pos.getX(), MathHelper.clamp(pos.getY(), 70, this.world.func_234938_ad_() - 10), pos.getZ())).toImmutable();
				Direction direction1 = direction.rotateY();
				if (!worldborder.contains(blockpos)) {
					return Optional.empty();
				}
				for (int l1 = -1; l1 < 2; ++l1) {
					for (int k2 = 0; k2 < 2; ++k2) {
						for (int i3 = -1; i3 < 3; ++i3) {
							BlockState blockstate1 = i3 < 0
									? ChestTappableBlock.block.getDefaultState().getBlock().getDefaultState()
									: Blocks.AIR.getDefaultState();
							blockpos$mutable.setAndOffset(blockpos, k2 * direction.getXOffset() + l1 * direction1.getXOffset(), i3,
									k2 * direction.getZOffset() + l1 * direction1.getZOffset());
							this.world.setBlockState(blockpos$mutable, blockstate1);
						}
					}
				}
			}
			for (int k1 = -1; k1 < 3; ++k1) {
				for (int i2 = -1; i2 < 4; ++i2) {
					if (k1 == -1 || k1 == 2 || i2 == -1 || i2 == 3) {
						blockpos$mutable.setAndOffset(blockpos, k1 * direction.getXOffset(), i2, k1 * direction.getZOffset());
						this.world.setBlockState(blockpos$mutable, ChestTappableBlock.block.getDefaultState().getBlock().getDefaultState(), 3);
					}
				}
			}
			BlockState blockstate = portal.getDefaultState().with(NetherPortalBlock.AXIS, axis);
			for (int j2 = 0; j2 < 2; ++j2) {
				for (int l2 = 0; l2 < 3; ++l2) {
					blockpos$mutable.setAndOffset(blockpos, j2 * direction.getXOffset(), l2, j2 * direction.getZOffset());
					this.world.setBlockState(blockpos$mutable, blockstate, 18);
					this.world.getPointOfInterestManager().add(blockpos$mutable, poi);
				}
			}
			return Optional.of(new TeleportationRepositioner.Result(blockpos.toImmutable(), 2, 3));
		}

		private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.Mutable offsetPos, Direction directionIn, int offsetScale) {
			Direction direction = directionIn.rotateY();
			for (int i = -1; i < 3; ++i) {
				for (int j = -1; j < 4; ++j) {
					offsetPos.setAndOffset(originalPos, directionIn.getXOffset() * i + direction.getXOffset() * offsetScale, j,
							directionIn.getZOffset() * i + direction.getZOffset() * offsetScale);
					if (j < 0 && !this.world.getBlockState(offsetPos).getMaterial().isSolid()) {
						return false;
					}
					if (j >= 0 && !this.world.isAirBlock(offsetPos)) {
						return false;
					}
				}
			}
			return true;
		}

		@Override
		public Entity placeEntity(Entity entity, ServerWorld serverworld, ServerWorld server, float yaw, Function<Boolean, Entity> repositionEntity) {
			PortalInfo portalinfo = getPortalInfo(entity, server);
			if (entity instanceof ServerPlayerEntity) {
				entity.setWorld(server);
				server.addDuringPortalTeleport((ServerPlayerEntity) entity);
				entity.rotationYaw = portalinfo.rotationYaw % 360.0F;
				entity.rotationPitch = portalinfo.rotationPitch % 360.0F;
				entity.moveForced(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z);
				return entity;
			} else {
				Entity entityNew = entity.getType().create(server);
				if (entityNew != null) {
					entityNew.copyDataFromOld(entity);
					entityNew.setLocationAndAngles(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.rotationYaw,
							entityNew.rotationPitch);
					entityNew.setMotion(portalinfo.motion);
					server.addFromAnotherDimension(entityNew);
				}
				return entityNew;
			}
		}

		private PortalInfo getPortalInfo(Entity entity, ServerWorld server) {
			WorldBorder worldborder = server.getWorldBorder();
			double d0 = Math.max(-2.9999872E7D, worldborder.minX() + 16.);
			double d1 = Math.max(-2.9999872E7D, worldborder.minZ() + 16.);
			double d2 = Math.min(2.9999872E7D, worldborder.maxX() - 16.);
			double d3 = Math.min(2.9999872E7D, worldborder.maxZ() - 16.);
			double d4 = DimensionType.getCoordinateDifference(entity.world.getDimensionType(), server.getDimensionType());
			BlockPos blockpos1 = new BlockPos(MathHelper.clamp(entity.getPosX() * d4, d0, d2), entity.getPosY(),
					MathHelper.clamp(entity.getPosZ() * d4, d1, d3));
			return this.getPortalRepositioner(entity, blockpos1).map(repositioner -> {
				BlockState blockstate = entity.world.getBlockState(this.entityEnterPos);
				Direction.Axis direction$axis;
				Vector3d vector3d;
				if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
					direction$axis = blockstate.get(BlockStateProperties.HORIZONTAL_AXIS);
					TeleportationRepositioner.Result teleportationrepositioner$result = TeleportationRepositioner.findLargestRectangle(
							this.entityEnterPos, direction$axis, 21, Direction.Axis.Y, 21, pos -> entity.world.getBlockState(pos) == blockstate);
					vector3d = CustomPortalSize.func_242973_a(teleportationrepositioner$result, direction$axis, entity.getPositionVec(),
							entity.getSize(entity.getPose()));
				} else {
					direction$axis = Direction.Axis.X;
					vector3d = new Vector3d(0.5, 0, 0);
				}
				return CustomPortalSize.func_242963_a(server, repositioner, direction$axis, vector3d, entity.getSize(entity.getPose()),
						entity.getMotion(), entity.rotationYaw, entity.rotationPitch);
			}).orElse(new PortalInfo(entity.getPositionVec(), Vector3d.ZERO, entity.rotationYaw, entity.rotationPitch));
		}

		protected Optional<TeleportationRepositioner.Result> getPortalRepositioner(Entity entity, BlockPos pos) {
			Optional<TeleportationRepositioner.Result> optional = this.getExistingPortal(pos, false);
			if (entity instanceof ServerPlayerEntity) {
				if (optional.isPresent()) {
					return optional;
				} else {
					Direction.Axis direction$axis = entity.world.getBlockState(this.entityEnterPos).func_235903_d_(NetherPortalBlock.AXIS)
							.orElse(Direction.Axis.X);
					return this.makePortal(pos, direction$axis);
				}
			} else {
				return optional;
			}
		}
	}
}
