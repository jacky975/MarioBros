package com.baconcow.mariobros.sprite;

import com.baconcow.mariobros.MarioBros;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by jacky975 on 5/14/17.
 */

public class Coin extends InteractiveTileObject{
    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");
    }

    public Coin(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
    }
}
