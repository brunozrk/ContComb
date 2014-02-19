package com.br.econocomb;

import com.br.uteis.BancoDeDados;
import com.br.uteis.Uteis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	BancoDeDados banco_de_dados;
	Button btnCarros, btnAbastecimentos;

	Uteis util = new Uteis();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		banco_de_dados = new BancoDeDados(MainActivity.this);
		chamaTelaInicial();
	}
	
	/**
	 * Carrega tela inicial
	 */
	public void chamaTelaInicial() {
		setContentView(R.layout.activity_main);
		inicializaDados();
		criaBotaoCarros();
		criaBotaoAbastecimentos();
	}
	
	/**
	 * Cria bot�o que carrega CarroActivity
	 */
	public void criaBotaoCarros(){
		btnCarros.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	            Intent i = new Intent(getBaseContext(), CarroActivity.class);
                startActivity(i);
                finish();
			}
		});
	}
	
	/**
	 * Cria bot�o que carrega AbastecimentoActivity
	 */
	public void criaBotaoAbastecimentos(){
		btnAbastecimentos.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	            Intent i = new Intent(getBaseContext(), AbastecimentoActivity.class);
                startActivity(i);
                finish();
			}
		});
	}
	
	/**
	 * Inicializar dados
	 */
	public void inicializaDados() {
		btnAbastecimentos = (Button) findViewById(R.id.btnAbastecimetos);
		btnCarros = (Button) findViewById(R.id.btnCarros);
	}
	
	/**
	 * Bot�o voltar do android finaliza o app
	 */
	@Override
    public void onBackPressed() {
		banco_de_dados.fechaBancoDeDados(MainActivity.this);
		this.finish();
	}

}
