package wehavecookies56.kk.entities;

import wehavecookies56.kk.client.particles.SharpshooterBullet;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySharpshooterBullet extends EntityThrowable{
	public EntitySharpshooterBullet(World world) {
		super(world);
	}

	public EntitySharpshooterBullet(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	public EntitySharpshooterBullet(World world, double x, double y, double z) {
		super(world, x, y, z);
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}
		
	@Override
	public void onUpdate() {
		int rotation = 0;
		Minecraft.getMinecraft().effectRenderer.addEffect(new SharpshooterBullet(worldObj, this.posX, this.posY, this.posZ));
		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 60){
			setDead();
		}
		super.onUpdate();
	}
	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (mop.entityHit != null) {
			
			float shotDamage = 10;
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), shotDamage);
		}

		this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

		if (!worldObj.isRemote) {
			setDead();
		}
		
	}
}
