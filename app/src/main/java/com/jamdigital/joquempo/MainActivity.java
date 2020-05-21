package com.jamdigital.joquempo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

import android.graphics.drawable.Drawable;
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

    public void pedraSelecionado(View view){
        this.opcaoSelecionada("pedra");
    }

    public void papelSelecionado(View view){
        this.opcaoSelecionada("papel");
    }

    public void tesouraSelecionado(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        ImageView imagem = findViewById(R.id.imageResultado);
        TextView texto = findViewById(R.id.textResultado);

        switch (opcaoApp){
            case "pedra":
                imagem.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagem.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagem.setImageResource(R.drawable.tesoura);
                break;
        }

        if(opcaoApp == "pedra" && opcaoSelecionada == "tesoura" ||
                opcaoApp == "papel" && opcaoSelecionada == "pedra" ||
                opcaoApp == "tesoura" && opcaoSelecionada == "papel")
        {//App ganhador
            texto.setText("Você perdeu :(");
        }else if(opcaoSelecionada == "pedra" && opcaoApp == "tesoura" ||
                opcaoSelecionada == "papel" && opcaoApp == "pedra" ||
                opcaoSelecionada == "tesoura" && opcaoApp == "papel")
        {//Usuario ganhador
            texto.setText("Você ganhou :)");
        }else{//Empate
            texto.setText("Empate");
        }

    }

}
