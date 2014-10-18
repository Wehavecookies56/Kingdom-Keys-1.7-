package wehavecookies56.kk.item;

import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemFinalFormOrb extends Item {

	public ItemFinalFormOrb() {
		super();
		this.setUnlocalizedName(Strings.FinalFormOrb);
		this.setCreativeTab(KingdomKeys.KKTAB);
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	}
}
