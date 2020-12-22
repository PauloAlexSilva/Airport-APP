package pt.ubi.di.pmd.aeroporto;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    ImageView imagem;
    TextView texto;

    Animation aparece;
    Animation desaparece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagem = findViewById(R.id.minhaImagem);
        texto = findViewById(R.id.meuTexto);

        texto.setText("CLICK TO CONTINUE");
        imagem.setVisibility(View.INVISIBLE);

        //Classe animação para imagem
        aparece = new AlphaAnimation(0, 1);
        desaparece = new AlphaAnimation(1, 0);

        //duração da animação
        desaparece.setDuration(500);
        aparece.setDuration(500);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        desaparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void cliqueImagem(View v) {
        /*Troca a imagem. Exemplo uma seta inicialmente que está a apontar para a esquerda fica
        a apontar para a direita setScaleX(-1f);*/

        if (Math.random() < 0.5) {
            texto.setText("GO LEFT");
            imagem.setScaleX(1f);
        } else {
            texto.setText("GO RIGHT");
            imagem.setScaleX(-1f);
        }
        imagem.startAnimation(aparece);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                imagem.startAnimation(desaparece);
                texto.setText("CLICK TO CONTINUE");
            }
        }, 2000);
    }
}
