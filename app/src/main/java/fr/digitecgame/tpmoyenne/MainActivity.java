package fr.digitecgame.tpmoyenne;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText number_td;
        final EditText number_tp;
        final EditText number_exam;
        final TextView Resultat;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //*******************Le Spinner************//

        Spinner spin=(Spinner)findViewById(R.id.spin_module);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.modules));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(myAdapter);

        //**************************Declaration des Composants ***********//


        number_td=(EditText)findViewById(R.id.number_TD);
        number_tp=(EditText)findViewById(R.id.number_TP);
        number_exam=(EditText)findViewById(R.id.number_exam);
        Resultat=findViewById(R.id.txt_result);



        Button btn_calculer=(Button)findViewById(R.id.btn_calcul);

        btn_calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1=number_td.getText().toString();
                String num2=number_tp.getText().toString();
                String num3=number_exam.getText().toString();


                float td=Float.parseFloat(num1);
                float tp=Float.parseFloat(num2);
                float exam=Float.parseFloat(num3);

                final double Moyenne= (double) (((tp+td)/2)+exam)/2;
                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("TPMoyenne");
                builder.setMessage("Voulez Voir Votre Moyenne");
                builder.setIcon(R.drawable.ic_star);
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    if(Moyenne>=10){
                        AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
                        build.setTitle("Congratulation");
                        build.setIcon(R.drawable.ic_congrat);
                        build.setMessage("Accepte avec Une Moyenne de : "+Moyenne);

                        AlertDialog alert=build.create();
                        alert.show();
                    }else{
                        AlertDialog.Builder buildi=new AlertDialog.Builder(MainActivity.this);
                        buildi.setTitle("Requiem");
                        buildi.setIcon(R.drawable.ic_fail);
                        buildi.setMessage("Ajourne avec une moyenne de : "+Moyenne);

                        AlertDialog alerti=buildi.create();
                        alerti.show();
                    }

                    }
                });

                builder.setNegativeButton("Non",null);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();



            }




        });


    }




}

