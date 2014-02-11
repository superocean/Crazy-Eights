package nghia.crazyeights;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class TitleView extends View {

    private Bitmap titleGraphic;
    private Bitmap playButton;
    private Bitmap playButtonHover;
    private boolean playButtonPressed;
    private int screenW;
    private int screenH;
    private Context gameContext;

	public TitleView(Context context)
	{
		super(context);
        gameContext=context;
        titleGraphic = BitmapFactory.decodeResource(getResources(),R.drawable.title);
        playButton = BitmapFactory.decodeResource(getResources(),R.drawable.play);
        playButtonHover=BitmapFactory.decodeResource(getResources(),R.drawable.play_press);

	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawBitmap(titleGraphic,(screenW-titleGraphic.getWidth())/2,0,null);
        if (playButtonPressed)
        {
            canvas.drawBitmap(playButtonHover,(screenW-playButton.getWidth())/2,(int)(screenH*0.7),null);
        }
        else
        {
            canvas.drawBitmap(playButton,(screenW-playButton.getWidth())/2,(int)(screenH*0.7),null);
        }
	}
	@Override
    public void onSizeChanged (int w, int h, int oldw,int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }
	public boolean onTouchEvent(MotionEvent event)
	{
		int eventAction = event.getAction();
		int X = (int)event.getX();
		int Y=(int)event.getY();
		
		switch(eventAction)
		{
			case MotionEvent.ACTION_DOWN:
                if (X > (screenW-playButton.getWidth())/2 &&
                        X < ((screenW-playButton.getWidth())/2) +
                                playButton.getWidth() &&
                Y > (int)(screenH*0.7) &&
                        Y < (int)(screenH*0.7) +
                                playButton.getHeight()) {
                playButtonPressed = true;
            }
				break;
			case MotionEvent.ACTION_MOVE:
				break;
            case MotionEvent.ACTION_UP:
                if(playButtonPressed)
                {
                    Intent gameIntent = new Intent(gameContext,GameActivity.class);
                    gameContext.startActivity(gameIntent);
                }
                playButtonPressed = false;
				break;
			
		}
		invalidate();
		return true;
	}
}
