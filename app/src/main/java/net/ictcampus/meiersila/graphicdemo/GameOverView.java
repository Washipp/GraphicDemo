package net.ictcampus.meiersila.graphicdemo;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by meiersila on 09.06.2017.
 */

public class GameOverView extends View {

    private Button restartGameButton, leaderBoardButton;

    public GameOverView(final Context context){
        super(context);

        restartGameButton = new Button(context);
        restartGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });
        leaderBoardButton = new Button(context);
        leaderBoardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


    }


}