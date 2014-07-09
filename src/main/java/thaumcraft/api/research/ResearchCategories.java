package thaumcraft.api.research;

import java.util.Collection;
import java.util.LinkedHashMap;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ResearchCategories {
	
	//Research
	public static LinkedHashMap <String, ResearchCategoryList> researchCategories = new LinkedHashMap <String,ResearchCategoryList>();
	
	/**
	 * @param key
	 * @return the research item linked to this key
	 */
	public static ResearchCategoryList getResearchList(String key) {
		return researchCategories.get(key);
	}
	
	/**
	 * @param key
	 * @return the name of the research category linked to this key. 
	 * Must be stored as localization information in the LanguageRegistry.
	 */
	public static String getCategoryName(String key) {
		return StatCollector.translateToLocal("tc.research_category."+key);
	}
	
	/**
	 * @param key the research key
	 * @return the ResearchItem object. 
	 */
	public static ResearchItem getResearch(String key) {
		Collection rc = researchCategories.values();
		for (Object cat:rc) {
			Collection rl = ((ResearchCategoryList)cat).research.values();
			for (Object ri:rl) {
				if ((((ResearchItem)ri).key).equals(key)) return (ResearchItem)ri;
			}
		}
		return null;
	}
	
	/**
	 * @param key the key used for this category
	 * @param IIcon the IIcon to be used for the research category tab
	 * @param background the resource location of the background image to use for this category
	 * @return the name of the research linked to this key
	 */
	public static void registerCategory(String key, ResourceLocation IIcon, ResourceLocation background) {
		if (getResearchList(key)==null) {
			ResearchCategoryList rl = new ResearchCategoryList(IIcon, background);
			researchCategories.put(key, rl);
		}
	}
	
	public static void addResearch(ResearchItem ri) {
		ResearchCategoryList rl = getResearchList(ri.category);
		if (rl!=null && !rl.research.containsKey(ri.key)) {
			rl.research.put(ri.key, ri);
			
			if (ri.displayColumn < rl.minDisplayColumn) 
	        {
	            rl.minDisplayColumn = ri.displayColumn;
	        }

	        if (ri.displayRow < rl.minDisplayRow)
	        {
	            rl.minDisplayRow = ri.displayRow;
	        }

	        if (ri.displayColumn > rl.maxDisplayColumn)
	        {
	            rl.maxDisplayColumn = ri.displayColumn;
	        }

	        if (ri.displayRow > rl.maxDisplayRow)
	        {
	            rl.maxDisplayRow = ri.displayRow;
	        }
	        		}
	}
}
