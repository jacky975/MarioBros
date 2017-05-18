package com.baconcow.mariobros.tools;

import com.baconcow.mariobros.MarioBros;
import com.baconcow.mariobros.screens.PlayScreen;
import com.baconcow.mariobros.sprite.Brick;
import com.baconcow.mariobros.sprite.Coin;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by jacky975 on 5/14/17.
 */

public class B2WorldCreator {
    public B2WorldCreator(PlayScreen screen) {
        World world = screen.getWorld();
        TiledMap map = screen.getMap();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();

        Body body;

        for(MapObject obj : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) obj).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX()+ rect.getWidth()/2)/ MarioBros.PPM, (rect.getY()+rect.getHeight()/2)/ MarioBros.PPM);

            body = world.createBody(bdef);

            shape.setAsBox((rect.getWidth()/2)/ MarioBros.PPM, (rect.getHeight()/2)/ MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //pipes
        for(MapObject obj : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) obj).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX()+ rect.getWidth()/2)/ MarioBros.PPM, (rect.getY()+rect.getHeight()/2)/ MarioBros.PPM);

            body = world.createBody(bdef);

            shape.setAsBox((rect.getWidth()/2)/ MarioBros.PPM, (rect.getHeight()/2)/ MarioBros.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = MarioBros.OBJECT_BIT;
            body.createFixture(fdef);
        }

        for(MapObject obj : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) obj).getRectangle();

            new Brick(screen, rect);
        }
        for(MapObject obj : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) obj).getRectangle();

            new Coin(screen ,rect );
        }
    }
}
