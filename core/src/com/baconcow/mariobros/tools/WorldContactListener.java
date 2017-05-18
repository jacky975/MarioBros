package com.baconcow.mariobros.tools;

import com.baconcow.mariobros.MarioBros;
import com.baconcow.mariobros.sprite.Enemy;
import com.baconcow.mariobros.sprite.InteractiveTileObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Created by jacky975 on 5/16/17.
 */

public class WorldContactListener implements ContactListener{
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;
        if(fixA.getUserData() == "head" || fixB.getUserData() == "head"){
            Fixture head = fixA.getUserData() == "head" ? fixA : fixB;
            Fixture obj = head == fixA ? fixB:fixA;

            if(obj.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(obj.getUserData().getClass())){
                ((InteractiveTileObject) obj.getUserData()).onHeadHit();
            }
        }
        switch(cDef){
            case MarioBros.ENEMY_HEAD_BIT | MarioBros.MARIO_BIT:
                    if (fixA.getFilterData().categoryBits == MarioBros.ENEMY_HEAD_BIT)
                        ((Enemy) fixA.getUserData()).hitOnHead();
                    else if (fixB.getFilterData().categoryBits == MarioBros.ENEMY_HEAD_BIT)
                        ((Enemy) fixB.getUserData()).hitOnHead();
        }
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
