package com.adriano.listadapterfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import android.content.*;
import android.support.v7.widget.*;

//import com.adriano.listadapterfragment.R;

public class MainActivity extends AppCompatActivity {

    Button btn_adicionar, btn_fragment;
    EditText et_nome;
    ListView lv_nomes;

    List<String> personagens = new ArrayList<String>();
    String[] list_nomes = {"Gandalf - O Cinzento","Bilbo Bolseiro", 
		"Thorin - Escudo de Carvalho","Galadriel - Lady de Lórien","Sauron",};

    ArrayAdapter arrayAdapter;
	private MenuItem item;
	public String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

        btn_adicionar = (Button)findViewById(R.id.botao_add);
        et_nome = (EditText)findViewById(R.id.nome_et);
        lv_nomes = (ListView)findViewById(R.id.nomes_lv);

        personagens = new ArrayList<String>(Arrays.asList(list_nomes));

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,personagens);
        lv_nomes.setAdapter(arrayAdapter);
		
		lv_nomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					
					Intent intent = new Intent(MainActivity.this, MainActivity2.class); 
				 		intent.putExtra("Personagem", personagens.get(position)); 
						startActivity(intent); 
					
					s = (String)parent.getItemAtPosition(position);
					Toast.makeText(MainActivity.this, s,Toast.LENGTH_SHORT).show();
					//Toast.makeText(MainActivity.this,"Posicao= " 
								   //+ position + " Nome= " 
								   //+ personagens.get(position), Toast.LENGTH_SHORT).show();
				}
			});
			
		lv_nomes.setOnLongClickListener(new AdapterView.OnLongClickListener() {

				@Override
				public boolean onLongClick(View view) {

					Toast.makeText(MainActivity.this, "Removendo " +s ,Toast.LENGTH_SHORT).show();
					return true;
				}


				
			});
					
		btn_adicionar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//if(et_nome.getText().toString().isEmpty()){
						//Toast.makeText(MainActivity.this, "O campo está vazio", Toast.LENGTH_SHORT).show();
					if(et_nome.getText().toString().equals("")){
						Toast.makeText(MainActivity.this, "Opss, Digite algo!", Toast.LENGTH_SHORT).show();
					}else{
						String novo_nome = et_nome.getText().toString();
						personagens.add(novo_nome);
						Collections.sort(personagens);

						arrayAdapter.notifyDataSetChanged();
						et_nome.setText("");
					}
				}
			});
			
		/*btn_fragment.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
					startActivity(intent);
				}
			});*/
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main:
                startActivity(new Intent(MainActivity.this, FragmentActivity.class));
				//Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
				//startActivity(intent);
                return true;
			case R.id.menu_main1:
                startActivity(new Intent(MainActivity.this, AdapterViewActivity.class));
                return true;
			case R.id.menu_main2:
                Toast.makeText(MainActivity.this, "Clicou no menu 3", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
