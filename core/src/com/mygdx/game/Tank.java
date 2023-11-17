package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank {
    private MyGdxGameTank game;
    private Texture texture;
    private float x;
    private float y;
    private float speed;
    private float angle; //есть у танка угол

    public Tank (MyGdxGameTank game){
        this.game = game;
        this.texture = new Texture("tank.png");
        this.x = 100.0f;
        this.y = 100.0f;
        this.speed = 100.0f;


    }
    public void render (SpriteBatch batch){ //рисуем танк
        //ниже описываем повороты танка
        batch.draw(texture,x-16,y-16,16,16,32, 32,1,1,angle,0, 0, 32,32, false,false);
    }

    public void update (float dt){
        checkMoment(dt);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) { //нажатие в данный момент
            fire();
        }
    }

    public void checkMoment(float dt){ //метод отвечает за движения
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= speed * dt;
            angle = 180.f;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += speed * dt;
            angle = 0;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += speed * dt;
            angle = 90.0f;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= speed * dt;
            angle = 270.0f;
            return;
        }
    }

    public void fire () {
        if (!game.getBullet().isActive()) { //проверяем не активна пуля
            float angleRad = (float) Math.toRadians(angle); //приводим к радиану
            game.getBullet().active(x, y, 320.0f * (float) Math.cos(angleRad),320.0f * (float) Math.sin(angleRad)); // хотим активировать и указываем координаты
        }
    }
}
