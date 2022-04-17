package waylanderou.almostalltheores.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import waylanderou.almostalltheores.RefinerTile;

public class Refiner extends Block implements EntityBlock {

	public static final BooleanProperty REFINING = BooleanProperty.create("refining");		
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public Refiner() {
		super(BlockBehaviour.Properties.of(Material.METAL)		
				.sound(SoundType.METAL)
				.strength(2.0F).lightLevel((x) -> {
					return 10;
				}));
		setRegistryName("refiner");
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(Refiner.REFINING, Boolean.valueOf(false)));
	}	

	@Override
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof RefinerTile) {
				dropResources(state, worldIn, pos, tileentity);
				worldIn.updateNeighbourForOutputSignal(pos, newState.getBlock());
			}
			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	public BlockState getStateForPlacement(UseOnContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
		return Direction.getNearest((float) (entity.xOld - clickedBlock.getX()), (float) (entity.yOld - clickedBlock.getY()), (float) (entity.zOld - clickedBlock.getZ()));
	}//getFacingFromVector ?

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, Refiner.REFINING);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		if(level.isClientSide())
			return null;
		return (lvl, pos, blockState, t) -> {
			if (t instanceof RefinerTile tile) {
				tile.tickServer();
			}
		};
	}

	@Override
	public InteractionResult use(BlockState p_225533_1_, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult p_225533_6_) {
		if (!world.isClientSide) {
			BlockEntity tileEntity = world.getBlockEntity(pos);
			if (tileEntity instanceof RefinerTile) {
				NetworkHooks.openGui((ServerPlayer) player, (RefinerTile) tileEntity, tileEntity.getBlockPos());
			} else {
				throw new IllegalStateException("Named container provider missing");
			}
			return InteractionResult.SUCCESS;
		}
		return super.use(p_225533_1_, world, pos, player, hand, p_225533_6_);
	}

	public int getLightValue(BlockState state) {
		return state.getValue(Refiner.REFINING) ? state.getLightEmission() : 0;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new RefinerTile(pos, state);
	}

}
