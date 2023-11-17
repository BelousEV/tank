package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGameTank extends ApplicationAdapter {
	private SpriteBatch batch; //вся игровая область (хотим что то нарисовать, обращаемся к batch)
	private Tank tank;
	private Bullet bullet;

	public Bullet getBullet() {
		return bullet;
	}

	@Override
	public void create () { //метод отвечает за запуск приложения с начальной подготовкой
		batch = new SpriteBatch();
		tank = new Tank(this);
		bullet = new Bullet ();

	}

	@Override
	public void render () { //метод отвечает за всю отрисовку
		float dt = Gdx.graphics.getDeltaTime();//дельтатайм// спрашиваем у видеокарты сколько времени прошло от предыдущей отрисовки
		update(dt);
		ScreenUtils.clear(0, 0.6f, 0, 1);
		batch.begin();
		tank.render(batch);
		if (bullet.isActive()) {
			bullet.render(batch);
		}
		batch.end();
	}

	public void update(float dt){
		tank.update(dt);
		if (bullet.isActive()) {
			bullet.update(dt);
		}

	}
	@Override
	public void dispose () { //метод освобождения ресурсов
		batch.dispose();

	}
}
