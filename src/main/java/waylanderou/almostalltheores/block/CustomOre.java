package waylanderou.almostalltheores.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;

public class CustomOre extends OreBlock {
	private int harvestLevel = 0;

	public CustomOre(Properties properties) {
		super(properties);		
	}

	public CustomOre( int harvestLevel, Properties properties, UniformInt xp) {
		super(properties, xp);
		this.harvestLevel = harvestLevel;
	}

	public CustomOre(int harvestLevel, Properties properties) {
		super(properties);
		this.harvestLevel = harvestLevel;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player)
	{
		if(player.getItemInHand(player.getUsedItemHand()).canPerformAction(ToolActions.PICKAXE_DIG))
		{
			Item itemUsed = player.getItemInHand(player.getUsedItemHand()).getItem();
			if(itemUsed instanceof TieredItem) {
				if(((TieredItem) itemUsed).getTier().getLevel() >= this.harvestLevel) {
					//Of course this only works with Vanilla tools...
					return true;
				}
			}
		}
		return false;
	}

}