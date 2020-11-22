package waylanderou.almostalltheores.block;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class CustomOre extends OreBlock {

	public CustomOre(Properties properties) {
		super(properties);		
	}

	private int getXP(Random random) {
		if(this == Ores.PEAT) {
			return MathHelper.nextInt(random, 0, 2);			
		} else if(this == Ores.LIGNITE_ORE) {
			return MathHelper.nextInt(random, 0, 2);						
		} else if(this == Ores.BITUMINOUS_COAL_ORE) {
			return MathHelper.nextInt(random, 0, 2);
		} else if(this == Ores.ANTHRACITE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.PYRITE) {
			return MathHelper.nextInt(random, 0, 2);
		} else if(this == Ores.SULPHUR) {
			return MathHelper.nextInt(random, 1, 2);
		} else if(this == Ores.PHOSPHORITE) {
			return MathHelper.nextInt(random, 0, 1);
		} else if(this == Ores.NITRATINE) {
			return MathHelper.nextInt(random, 1, 3);
		} else if(this == Ores.HALITE) {
			return MathHelper.nextInt(random, 0, 1);
		} else if(this == Ores.SAPPHIRE_ORE) {
			return MathHelper.nextInt(random, 3, 7);
		} else if(this == Ores.RUBY_ORE) {
			return MathHelper.nextInt(random, 3, 7);
		} else if(this == Ores.SPINEL_ORE) {
			return MathHelper.nextInt(random, 2, 5);
		} else if(this == Ores.AMETHYST_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.JADE_ORE) {
			return MathHelper.nextInt(random, 2, 4);
		} else if(this == Ores.TOURMALINE_ORE) {
			return MathHelper.nextInt(random, 2, 4);
		} else if(this == Ores.SUGILITE_ORE) {
			return MathHelper.nextInt(random, 1, 3);
		} else if(this == Ores.PERIDOT_ORE) {
			return MathHelper.nextInt(random, 1, 4);
		} else if(this == Ores.AGATE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.CARNELIAN_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.CHRYSOPRASE_ORE) {
			return MathHelper.nextInt(random, 2, 5);
		} else if(this == Ores.HELIOTROPE_ORE) {
			return MathHelper.nextInt(random, 2, 4);
		} else if(this == Ores.TOPAZ_ORE) {
			return MathHelper.nextInt(random, 2, 5);
		} else if(this == Ores.UNAKITE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.TANZANITE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.HAUYNE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.ONYX_ORE) {
			return MathHelper.nextInt(random, 2, 4);
		} else if(this == Ores.OPAL_ORE) {
			return MathHelper.nextInt(random, 2, 4);
		} else if(this == Ores.MOONSTONE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.TURQUOISE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.AMAZONITE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.CHRYSOCOLLA_ORE) {
			return MathHelper.nextInt(random, 0, 3);
		} else if(this == Ores.ALMANDINE_ORE) {
			return MathHelper.nextInt(random, 1, 3);
		} else if(this == Ores.SPESSARTINE_ORE) {
			return MathHelper.nextInt(random, 1, 3);
		} else if(this == Ores.PYROPE_ORE) {
			return MathHelper.nextInt(random, 1, 3);
		} else if(this == Ores.TSAVORITE_ORE) {
			return MathHelper.nextInt(random, 1, 3);
		} else if(this == Ores.ANDRADITE_ORE) {
			return MathHelper.nextInt(random, 2, 3);
		} else if(this == Ores.NETHER_COAL_ORE) {
			return MathHelper.nextInt(random, 0, 2);
		} else if(this == Ores.KIMBERLITE) {
			return MathHelper.nextInt(random, 3, 7);
		} else if(this == Ores.LAMPROITE) {
			return MathHelper.nextInt(random, 3, 7);
		} else {		
			return 0;			
		}		
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? this.getXP(RANDOM) : 0;
	}

}