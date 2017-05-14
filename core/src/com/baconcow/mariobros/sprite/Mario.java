package com.baconcow.mariobros.sprite;

import com.baconcow.mariobros.MarioBros;
import com.baconcow.mariobros.screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by jacky975 on 5/14/17.
 */

public class Mario extends Sprite {
    public World world;
    public Body b2body;
    private TextureRegion marioStand;

    public Mario(World world, PlayScreen screen){
        this.world = world;
        defineMario();
        marioStand = new TextureRegion(screen.getAtlas().findRegion("little_mario"), 0,0,16,16);
        setBounds(0, 0, 16/MarioBros.PPM, 16/MarioBros.PPM);
        setRegion(marioStand);
    }



    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32/ MarioBros.PPM,32/MarioBros.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;

        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/MarioBros.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
