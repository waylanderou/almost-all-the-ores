package waylanderou.almostalltheores.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import waylanderou.almostalltheores.RefinerTile;

public class Refiner extends Block {
	public static final BooleanProperty REFINING = BooleanProperty.create("refining");		
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public Refiner() {
		super(Properties.create(Material.IRON)				
				.sound(SoundType.METAL)
				.hardnessAndResistance(2.0F)
				.lightValue(10));
		setRegistryName("refiner");
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(Refiner.REFINING, Boolean.valueOf(false)));
	}	

	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof RefinerTile) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (RefinerTile)tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
			super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
		return Direction.getFacingFromVector((float) (entity.posX - clickedBlock.getX()), (float) (entity.posY - clickedBlock.getY()), (float) (entity.posZ - clickedBlock.getZ()));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, Refiner.REFINING);
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new RefinerTile();
	}

	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
		if (!world.isRemote) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof INamedContainerProvider) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
			} else {
				throw new IllegalStateException("Named container provider missing");
			}
			return true;
		}
		return super.onBlockActivated(state, world, pos, player, hand, result);
	}

	public int getLightValue(BlockState state) {
		return state.get(Refiner.REFINING) ? super.getLightValue(state) : 0;
	}

}
