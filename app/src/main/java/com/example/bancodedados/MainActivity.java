package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //Criando banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS  pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR , idade INT(3))");
            //bancoDados.execSQL("DROP TABLE pessoas");

            //Inserir dados
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Silvio', 60)");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Amanda', 42)");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Ana', 21)");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Lair', 22)");

            //Update
                //Atualizar informações
            //bancoDados.execSQL("UPDATE pessoas SET idade = 43 WHERE nome = 'Amanda'");
            //bancoDados.execSQL("UPDATE pessoas SET idade = 45 WHERE id = 2");

                //Deletar uma linha completa
            bancoDados.execSQL("DELETE FROM pessoas WHERE id = 3");
                //Deletar toda a tabela
            bancoDados.execSQL("DELETE FROM pessoas");

            //Recuperar pessoas
            //String consulta = "SELECT nome, idade FROM pessoas";

            /*String consulta =
                    "SELECT nome, idade FROM pessoas WHERE nome = 'Lair'";
             */

            /*String consulta = "SELECT nome, idade FROM pessoas " +
                    "WHERE nome = 'Lair' AND idade = 22";
            */

            /*String consulta = "SELECT nome, idade FROM pessoas " +
                    "WHERE idade >= 40 OR idade = 23";
            */

            //Não funcionou
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade IN(18,43)";

            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 18 AND 43";

            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE 'Ana' ";

            /*String filtro = "an";
            String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%"+ filtro +"%' ";
            */


            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade ASC";

            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade DESC LIMIT 4";

            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Amanda' ";

            //String consulta = "SELECT id, nome, idade FROM pessoas WHERE 1=1";

            //Traz todosos campos:
            String consulta = "SELECT * FROM pessoas WHERE 1=1";


            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade =  cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while(cursor != null){
                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("Resultado - id", id + "/ nome: " + nome + " / idade: " + idade);


                cursor.moveToNext();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
