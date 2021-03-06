package br.com.pedro.apostando;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class Principal extends AppCompatActivity {

    private FloatingActionMenu menu;
    private FloatingActionButton apostar;
    private FloatingActionButton consultar;
    private FloatingActionButton realizarSorteios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (FloatingActionMenu) findViewById(R.id.menu_opcao);
        apostar = (FloatingActionButton) findViewById(R.id.fazer_aposta);
        consultar = (FloatingActionButton) findViewById(R.id.consultar_aposta);
        realizarSorteios = (FloatingActionButton) findViewById(R.id.realizar_sorteio);

        apostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroAposta.class);
                startActivity(intent);
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaAposta.class);
                intent.putExtra("tela", "1");
                startActivity(intent);
            }
        });

        realizarSorteios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = sortear();
                Intent intent = new Intent(getApplicationContext(), ListaAposta.class);
                intent.putExtra("tela", "2");
                intent.putExtra("numeroSorteado", numero);
                startActivity(intent);
            }
        });
    }

    public int sortear() {
        Random random = new Random();
        int numeroSorteado = random.nextInt(99);
        return numeroSorteado;
}
