package com.droidrank.tictactoe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;
    String player = "O";
    Boolean gameFinished = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        block1 = (Button) findViewById(R.id.bt_block1);
        block2 = (Button) findViewById(R.id.bt_block2);
        block3 = (Button) findViewById(R.id.bt_block3);
        block4 = (Button) findViewById(R.id.bt_block4);
        block5 = (Button) findViewById(R.id.bt_block5);
        block6 = (Button) findViewById(R.id.bt_block6);
        block7 = (Button) findViewById(R.id.bt_block7);
        block8 = (Button) findViewById(R.id.bt_block8);
        block9 = (Button) findViewById(R.id.bt_block9);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);

        result.setText("Player 1 = O and Player 2 = X");

        block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block1);
            }
        });
        block2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block2);
            }
        });
        block3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block3);
            }
        });
        block4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block4);
            }
        });
        block5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block5);
            }
        });
        block6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block6);
            }
        });
        block7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block7);
            }
        });
        block8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block8);
            }
        });
        block9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBox(block9);
            }
        });

        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (restart.getText().toString().equals("Restart Game")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Restart Game");
                    builder.setMessage("Do you want to restart the game?")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    newGame();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (gameFinished) {
                    newGame();
                }

            }
        });
    }

    void setBox(Button btn) {
        if (btn.getText().equals("") && !gameFinished) {
            restart.setText("Restart Game");
            btn.setText(player);
            nextPlayer();
            checkWin();
        }
    }

    void newGame() {
        gameFinished = false;
        restart.setText("Start New Game");
        result.setText("Player 1 = O and Player 2 = X");
        player = "O";
        block1.setText("");
        block2.setText("");
        block3.setText("");
        block4.setText("");
        block5.setText("");
        block6.setText("");
        block7.setText("");
        block8.setText("");
        block9.setText("");
    }

    void nextPlayer() {
        if (player.equals("O")) {
            player = "X";
            result.setText("Player 2 turn (X)");
        } else {
            player = "O";
            result.setText("Player 1 turn (0)");
        }
    }

    void checkWin() {
        if ((block1.getText().equals(block2.getText()) && block2.getText().equals(block3.getText()) && !block1.getText().equals("")) ||
                (block4.getText().equals(block5.getText()) && block5.getText().equals(block6.getText()) && !block4.getText().equals("")) ||
                (block7.getText().equals(block8.getText()) && block8.getText().equals(block9.getText()) && !block7.getText().equals("")) ||
                (block1.getText().equals(block4.getText()) && block4.getText().equals(block7.getText()) && !block1.getText().equals("")) ||
                (block2.getText().equals(block5.getText()) && block5.getText().equals(block8.getText()) && !block2.getText().equals("")) ||
                (block3.getText().equals(block6.getText()) && block6.getText().equals(block9.getText()) && !block3.getText().equals("")) ||
                (block1.getText().equals(block5.getText()) && block5.getText().equals(block9.getText()) && !block1.getText().equals("")) ||
                (block3.getText().equals(block5.getText()) && block5.getText().equals(block7.getText()) && !block3.getText().equals(""))) {
            if (player.equals("O")) {
                result.setText("Player 2 Wins");
                gameFinished = true;
            } else {
                result.setText("Player 1 Wins");
                gameFinished = true;
            }
        } else if (!block1.getText().equals("") &&
                !block2.getText().equals("") &&
                !block3.getText().equals("") &&
                !block4.getText().equals("") &&
                !block5.getText().equals("") &&
                !block6.getText().equals("") &&
                !block7.getText().equals("") &&
                !block8.getText().equals("") &&
                !block9.getText().equals("")) {
            result.setText("It's a Tie");
            gameFinished = true;
        }
        if (gameFinished) {
            restart.setText("Start New Game");
        }
    }

}
