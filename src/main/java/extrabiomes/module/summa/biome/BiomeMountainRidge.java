/**
 * This work is licensed under the Creative Commons
 * Attribution-ShareAlike 3.0 Unported License. To view a copy of this
 * license, visit http://creativecommons.org/licenses/by-sa/3.0/.
 */

package extrabiomes.module.summa.biome;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary.Type;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;

public class BiomeMountainRidge extends ExtrabiomeGenBase
{
	@Override
	public DecorationSettings getDecorationSettings() {
		return DecorationSettings.MOUNTAINRIDGE;
	}

    @SuppressWarnings("unchecked")
    public BiomeMountainRidge()
    {
		super(BiomeSettings.MOUNTAINRIDGE, Type.MOUNTAIN, Type.DESERT);
        
        setColor(0xC4722F);
		setBiomeName("Mountain Ridge");
        temperature = BiomeGenBase.desert.temperature;
        rainfall = BiomeGenBase.desert.rainfall;
        minHeight = 1.7F;
        maxHeight = 1.7F;
        setDisableRain();
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 3, 1, 3));
    }
}
