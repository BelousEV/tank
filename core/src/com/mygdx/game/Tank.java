package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tank {
    private MyGdxGameTank game;
    private Texture texture;
    private Vector2 position;
    private float speed;
    private float angle; //есть у танка угол

    public Tank (MyGdxGameTank game){
        this.game = game;
        this.texture = new Texture("player_tank_base.png");
        this.position = new Vector2(100.f, 100.0f);
        this.speed = 100.0f;


    }
    public void render (SpriteBatch batch){ //рисуем танк
        //ниже описываем повороты танка
        batch.draw(texture,position.x-20,position.y-20,20,20,40, 40,1,1,angle,0, 0, 40,40, false,false);
    }

    public void update (float dt){
        checkMoment(dt);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) { //нажатие в данный момент
            fire();
        }
    }

    public void checkMoment(float dt){ //метод отвечает за движения
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            position.x -= speed * dt;
            angle = 180.f;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            position.x += speed * dt;
            angle = 0;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            position.y += speed * dt;
            angle = 90.0f;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            position.y -= speed * dt;
            angle = 270.0f;
            return;
        }
    }

    public void fire () {
        if (!game.getBullet().isActive()) { //проверяем не активна пуля
            float angleRad = (float) Math.toRadians(angle); //приводим к радиану
            game.getBullet().active(position.x, position.y, 320.0f * (float) Math.cos(angleRad),320.0f * (float) Math.sin(angleRad)); // хотим активировать и указываем координаты
        }
    }
}
