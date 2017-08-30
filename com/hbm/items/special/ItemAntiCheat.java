package com.hbm.items.special;

import com.hbm.items.ModItems;
import com.hbm.lib.ModDamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAntiCheat extends ItemCustomLore {
	
    @Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b) {

    	if(stack.getItemDamage() != 34) {
        	
        	if(entity instanceof EntityPlayer) {
        		EntityPlayer player = (EntityPlayer)entity;
        		for(ItemStack s : player.inventory.mainInventory) {
        			player.inventory.consumeInventoryItem(ModItems.ingot_euphemium);
        			player.inventory.consumeInventoryItem(ModItems.nugget_euphemium);
        		}
        	}

        	//entity.attackEntityFrom(ModDamageSource.cheater, Float.POSITIVE_INFINITY);
        	entity.attackEntityFrom(ModDamageSource.cheater, 10000);
        	
        	//if(!world.isRemote)
        	//	ExplosionChaos.antiCheat(world, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 20);
    	}
    }

}