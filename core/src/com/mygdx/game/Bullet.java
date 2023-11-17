package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
    private Texture texture;

    private float x;
    private float y;
    private float vx; //скорость по х
    private float vy; // скорость по у
    private float speed;
    private boolean active; // может быть включена или выключена

    public Bullet() {
        this.texture = new Texture("projectile.png");
    }

    public boolean isActive() {
        return active;
    }

    public Bullet(float x, float y, float speed, boolean active) {
        this.texture = new Texture("projectile.png");
        this.x = 0.0f;
        this.y = 0.0f;
        this.vx = 0.0f;
        this.vy = 0.0f;
        this.active = false;
    }

    public void render (SpriteBatch batch){
        batch.draw (texture, x -8, y - 8); //вычитаем половину из картинки для централизации
    }


    public void active (float x, float y, float vx, float vy){
        this.active = true;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void deactivate(){
        active = false;
    }

    public void update (float dt){
        x += vx * dt;
        y += vy * dt;

        if (x < 0.0f || x > 1280f || y < 0.0f || y > 720.f) {
            deactivate();
        }


    }
}
