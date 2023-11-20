package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private Texture texture;

    private Vector2 position;
    private Vector2 velocity; // скорость (без  ускорения)
    private float speed;
    private boolean active; // может быть включена или выключена



    public boolean isActive() {
        return active;
    }

    public Bullet() {
        this.texture = new Texture("projectile.png");
        this.position = new Vector2();
        this.velocity = new Vector2();
        this.active = false;
    }

    public void render (SpriteBatch batch){
        batch.draw (texture, position.x -8, position.y - 8); //вычитаем половину из картинки для централизации
    }


    public void active (float x, float y, float vx, float vy){
        this.active = true;
        this.position.set(x, y);
        this.velocity.set(vx, vy);
    }

    public void deactivate(){
        active = false;
    }

    public void update (float dt){
       position.mulAdd(velocity, dt); //складываем два вектора
        if (position.x < 0.0f || position.x > 1280f || position.y < 0.0f || position.y > 720.f) {
            deactivate();
        }


    }
}
