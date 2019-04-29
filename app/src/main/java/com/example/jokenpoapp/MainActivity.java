package com.example.jokenpoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada(0);
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada(1);
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada(2);
    }

    public void opcaoSelecionada(int escolhaUsuario) {

        ImageView ImagemResultado = findViewById(R.id.ImagemResultado);
        TextView TextoResultado = findViewById(R.id.TextoResposta);

        int numero = new Random().nextInt(3);
        int[] opcoes = {0, 1, 2};
        int escolhaMaquina = opcoes[numero];

        switch (escolhaMaquina) {
            case 0:
                ImagemResultado.setImageResource(R.drawable.pedra);
                break;

            case 1:
                ImagemResultado.setImageResource(R.drawable.papel);
                break;

            case 2:
                ImagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((escolhaMaquina == 0 && escolhaUsuario == 2) ||
            (escolhaMaquina == 1 && escolhaUsuario == 0) ||
            (escolhaMaquina == 2 && escolhaUsuario == 1)
        ) {
            TextoResultado.setText("Você Perdeu :(");
        } else if ((escolhaUsuario == 0 && escolhaMaquina == 2) ||
                  (escolhaUsuario == 1 && escolhaMaquina == 0) ||
                  (escolhaUsuario == 2 && escolhaMaquina == 1)
        ) {
            TextoResultado.setText("Você Ganhou :)");
        } else { TextoResultado.setText("Nós Empatamos :|");
        }
    }
}
