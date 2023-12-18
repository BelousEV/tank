package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BulletEmitter {

    private Texture bulletTexture;
    private Bullet [] bullets;

    public static final int MAX_BULLETS_COUNT = 500; // 500 пуль

    public BulletEmitter () {
        this.bulletTexture = new Texture("projectile.png");
        this.bullets = new Bullet[MAX_BULLETS_COUNT];
        for (int i = 0; i < MAX_BULLETS_COUNT; i++) {
            this.bullets [i] = new Bullet(); //инициализируем весь массив пуль

        }
    }

    public void render (SpriteBatch batch) {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()){
                batch.draw(bulletTexture,bullets[i].getPosition().x - 8, bullets[i].getPosition().y - 8);
            }

        }

    }

    public void update (float dt){
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) { //если пуля активна апдейтим
                bullets[i].update(dt);
            }
        }

    }
}
